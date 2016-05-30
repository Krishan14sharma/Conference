package y29.schedule.common.core;

/**
 * Created by Krishan on 31-01-2016.
 * This is the screen which have content error progress related methods. Screen interfaces should extend this
 * This should not be directly used in the activity instead extended by an Screen interface.
 */
public interface ErrorProgressScreen extends Screen {

    /**
     * this is use to show progress to the user
     */
    void onShowProgress();

    /**
     * this is used to hide progress to the user
     */
    void onHideProgress();

    void showRetryView();

    void hideRetryView();

    void disableRetry();

    void enableRetry();

}