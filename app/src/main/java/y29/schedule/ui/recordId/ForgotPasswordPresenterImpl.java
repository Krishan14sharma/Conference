package y29.schedule.ui.recordId;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.text.TextUtils;

import com.jiocartseller.R;
import com.jiocartseller.jio.common.core.BasePresenter;
import com.jiocartseller.jio.data.repository.rest.model.Status;
import com.jiocartseller.jio.data.repository.rest.restErrors.EmailNotRegistered;
import com.jiocartseller.jio.ui.forgotPassword.ForgotPasswordContract.ForgotPasswordPresenter;
import com.jiocartseller.jio.ui.forgotPassword.ForgotPasswordContract.ForgotPasswordScreen;
import com.jiocartseller.jio.util.Encryptor;
import com.jiocartseller.jio.util.Validator;

import java.io.IOException;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by krishan on 4/2/16.
 */
public class ForgotPasswordPresenterImpl extends BasePresenter<ForgotPasswordScreen> implements ForgotPasswordPresenter {

    private final ForgotPasswordUseCase<Status> mForgotPasswordUseCase;
    private final Encryptor mEncryptor;

    @Inject
    public ForgotPasswordPresenterImpl(ForgotPasswordUseCase<Status> forgotPasswordUseCase, Encryptor encryptor) {
        this.mEncryptor = encryptor;
        this.mForgotPasswordUseCase = forgotPasswordUseCase;
    }

    @Override
    public void resetPassword(@NonNull String email) {
        getView().hideEmailError();
        //check against empty email
        if (TextUtils.isEmpty(email)) {
            getView().showEmailError(R.string.error_msg_email_empty);
            return;
        }

        //check against invalid email
        if (!Validator.isValidEmail(email)) {
            getView().showEmailError(R.string.error_msg_invalid_email);
            return;
        }
        getView().hideKeyBoard();
        getView().showLoading(R.string.loading_msg_generic);
        //encrypt the validated email
        final String enEmail = mEncryptor.encrypt(email);


        //make a call for the reset password
        mForgotPasswordUseCase.execute(enEmail)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(status -> {
                    getView().hideLoading();
                    getView().showResetPasswordSuccessMsg();
                }, throwable -> {
                    getView().hideLoading();
                    getView().showResetPasswordFailureMsg(getErrorMsgFromException(throwable));
                });
    }

    private
    @StringRes
    int getErrorMsgFromException(Throwable throwable) {
        int errorMsg;
        if (throwable instanceof EmailNotRegistered) {
            errorMsg = R.string.error_msg_email_not_registered;
        } else if (throwable instanceof IOException) {
            errorMsg = R.string.error_msg_unable_to_connect;
        } else {
            errorMsg = R.string.error_msg_generic_api_failure;
        }
        return errorMsg;
    }
}
