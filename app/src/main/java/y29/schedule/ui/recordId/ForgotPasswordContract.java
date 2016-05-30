package y29.schedule.ui.recordId;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import com.jiocartseller.jio.common.core.Presenter;
import com.jiocartseller.jio.common.core.Screen;

/**
 * Created by krishan on 4/2/16.
 */
public interface ForgotPasswordContract {

    interface ForgotPasswordScreen extends Screen {
        void showResetPasswordSuccessMsg();

        void showEmailError(@StringRes int msg);

        void hideEmailError();

        void showResetPasswordFailureMsg(@StringRes int msg);

        void showLoading(@StringRes int message);

        void hideLoading();

        void hideKeyBoard();

        void moveToLogin();
    }

    interface ForgotPasswordPresenter extends Presenter<ForgotPasswordScreen> {
        void resetPassword(@NonNull final String email);
    }

}


