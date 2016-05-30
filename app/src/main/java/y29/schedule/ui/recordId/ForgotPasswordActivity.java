package y29.schedule.ui.recordId;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatAutoCompleteTextView;

import com.jiocartseller.R;
import com.jiocartseller.jio.base.BaseActivity;
import com.jiocartseller.jio.base.BaseApp;
import com.jiocartseller.jio.ui.forgotPassword.ForgotPasswordContract.ForgotPasswordPresenter;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

import static com.jiocartseller.jio.util.CommonUtil.hideKeyboard;
import static com.jiocartseller.jio.util.CommonUtil.showErrorSnackBar;

public class ForgotPasswordActivity extends BaseActivity implements ForgotPasswordContract.ForgotPasswordScreen {

    private static final String EXTRA_EMAIL = "email";
    @Bind(R.id.edt_email)
    AppCompatAutoCompleteTextView mEdtEmail;
    @Bind(R.id.input_layout_email)
    TextInputLayout mInputLayoutEmail;

    @Inject
    ForgotPasswordPresenter mPresenter;

    @Nullable
    private AlertDialog mDialog1;
    @Nullable
    private ProgressDialog mDialog;


    public static Intent createIntent(Context context, @NonNull String email) {
        Intent intent = new Intent(context, ForgotPasswordActivity.class);
        intent.putExtra(EXTRA_EMAIL, email);
        return intent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set the email from the intent
        if (getIntent() != null) {
            String email = getIntent().getStringExtra(EXTRA_EMAIL);
            mEdtEmail.setText(email);
        }

        DaggerForgotPasswordComponent.builder().appComponent(BaseApp.getContext().getAppComponent())
                .forgotPasswordModule(new ForgotPasswordModule()).build().inject(this);
        mPresenter.attachView(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_forgot_password;
    }

    @Override
    public boolean hasNavDrawer() {
        return false;
    }

    @Override
    public void showResetPasswordSuccessMsg() {
        final String email = mEdtEmail.getText().toString().trim();
        String msg = getString(R.string.check_u_email) + " " + email
                + getString(R.string.forgot_password_check_your_email);
        mDialog1 = new AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle(getString(R.string.reset_password_check_your_email1))
                .setMessage(msg)
                .setPositiveButton(getString(R.string.ok),
                        (dialog, which) -> moveToLogin())
                .show();
    }

    @Override
    public void moveToLogin() {
        if (mDialog1 != null)
            mDialog1.dismiss();
        finish();
    }

    @Override
    public void hideKeyBoard() {
        hideKeyboard(this);
    }

    @Override
    public void showEmailError(@StringRes int msg) {
        mInputLayoutEmail.setErrorEnabled(true);
        mInputLayoutEmail.setError(getString(msg));
    }

    @Override
    public void hideEmailError() {
        mInputLayoutEmail.setError(null);
        mInputLayoutEmail.setErrorEnabled(false);
    }

    @Override
    public void showResetPasswordFailureMsg(@StringRes int msg) {
        showErrorSnackBar(mInputLayoutEmail, msg);
    }

    @Override
    public void showLoading(@StringRes int message) {
        mDialog = new ProgressDialog(this);
        mDialog.setMessage(getString(message));
        mDialog.setIndeterminate(false);
        mDialog.setCancelable(false);
        mDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mDialog != null)
            mDialog.hide();
    }

    @OnClick(R.id.btn_forgot_password)
    public void forgotPassword() {
        final String email = mEdtEmail.getText().toString().trim();
        mPresenter.resetPassword(email);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
        if (mDialog1 != null) mDialog1.dismiss();
        if (mDialog != null) mDialog.dismiss();
    }
}
