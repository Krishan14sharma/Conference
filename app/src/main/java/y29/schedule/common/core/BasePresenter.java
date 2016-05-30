package y29.schedule.common.core;

import java.lang.ref.WeakReference;

import static com.fernandocejas.arrow.checks.Preconditions.checkNotNull;


/**
 * Created by Krishan on 31-01-2016.
 */
public abstract class BasePresenter<V extends Screen> implements Presenter<V> {

    private WeakReference<V> viewRef;

    @Override
    public void attachView(V view) {
        viewRef = new WeakReference<>(checkNotNull(view, "view passed must not be null"));
    }

    /**
     * Get the attached view. You should always call {@link #isViewAttached()} to check if the view
     * is
     * attached to avoid NullPointerExceptions.
     *
     * @return <code>null</code>, if view is not attached, otherwise the concrete view instance
     */
    public V getView() {
        checkNotNull(viewRef, "Must call attachView first!");
        V view = viewRef.get();
        checkNotNull(view, "View is null. Check isViewAttached() first then use getView()");
        return view;
    }

    /**
     * Checks if a view is attached to this presenter. You should always call this method before
     * calling {@link #getView()} to get the view instance.
     */
    public boolean isViewAttached() {
        return (viewRef != null && viewRef.get() != null);
    }

    @Override
    public void detachView() {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }
}