package y29.schedule.common.base;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import butterknife.Bind;
import butterknife.ButterKnife;
import y29.schedule.R;

/**
 * Created by krishan on 29-05-2016. This is the base Screen Container implementation used in all activities.
 */
public class BaseScreenContainerImpl implements ScreenContainer {

    @Bind(R.id.retry_view)
    View retryView;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.container)
    FrameLayout container;
    private View btn_Retry;
    private ScreenContainer.RetryClickListner listner;

    @Override
    public ViewGroup bind(AppCompatActivity activity) {
        listner = (RetryClickListner) activity;
        activity.setContentView(R.layout.core_layout);
        ButterKnife.bind(this, activity);
        return null;
    }

    @Override
    public void onShowProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onHideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showRetryView() {
        lazilyLoadRetryView();
        retryView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRetryView() {
        if (retryView != null)
            retryView.setVisibility(View.GONE);
    }

    @Override
    public void disableRetry() {
        if (btn_Retry != null)
            btn_Retry.setEnabled(false);
    }

    @Override
    public void enableRetry() {
        if (btn_Retry != null)
            btn_Retry.setEnabled(true);
    }

    /**
     * This lazily loads the retry view. You can use the view after loading it.
     */
    protected void lazilyLoadRetryView() {
        if (retryView == null) {
            ViewStub viewStub = (ViewStub) container.findViewById(R.id.retry_view);
            retryView = viewStub.inflate();
            btn_Retry = retryView.findViewById(R.id.btn_retry);
            btn_Retry.setOnClickListener(view -> onRetryClicked(view));
        }

    }

    private void onRetryClicked(View view) {
        if (listner != null) listner.onRetryClicked(view);
    }

}
