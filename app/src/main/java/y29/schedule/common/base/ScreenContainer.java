package y29.schedule.common.base;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import y29.schedule.common.core.ErrorProgressScreen;

/**
 * An indirection which allows controlling the root container used for each activity.
 */
public interface ScreenContainer extends ErrorProgressScreen {
    /**
     * The root {@link android.view.ViewGroup} into which the activity should place its contents.
     */
    ViewGroup bind(AppCompatActivity activity);

    interface RetryClickListner {
        void onRetryClicked(View view);
    }
}