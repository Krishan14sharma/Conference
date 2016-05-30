package y29.schedule.common.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
import y29.schedule.common.core.ErrorProgressScreen;

/**
 * Created by krishan on 16/12/15.
 * This is the base activity to handle all common operations and features.
 */
public abstract class BaseActivity extends AppCompatActivity implements
        ErrorProgressScreen, ScreenContainer.RetryClickListner {

    private ScreenContainer screenContainer;
    private ViewGroup mainFrame;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        screenContainer = createScreenContainer();
        mainFrame = screenContainer.bind(this);
        getLayoutInflater().inflate(getLayout(), mainFrame);
        ButterKnife.bind(this);
    }

    /**
     * @return instance of ScreenContainer
     */
    private static ScreenContainer createScreenContainer() {
        return new BaseScreenContainerImpl();
    }

    /**
     * @return id of the layout to be used
     */
    public abstract
    @LayoutRes
    int getLayout();


    /**
     * Calligraphy lib is using it to set our fonts
     *
     * @param newBase
     */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    //---------------------Common functions provided to all activities---------------------

    @Override
    public void onShowProgress() {
        screenContainer.onShowProgress();
    }

    @Override
    public void onHideProgress() {
        screenContainer.onHideProgress();
    }

    @Override
    public void showRetryView() {
        screenContainer.showRetryView();
    }

    @Override
    public void hideRetryView() {
        screenContainer.hideRetryView();
    }

    @Override
    public void disableRetry() {
        screenContainer.disableRetry();
    }

    @Override
    public void enableRetry() {
        screenContainer.enableRetry();
    }

    @Override
    public void onRetryClicked(View view) {
// do something cool in child activities
    }

    //---------------------------------------fin-------------------------------------------------
}
