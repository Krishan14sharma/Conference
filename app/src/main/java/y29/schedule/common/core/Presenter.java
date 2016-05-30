package y29.schedule.common.core;

/**
 * Created by Krishan on 31-01-2016.
 */
public interface Presenter<V extends Screen> {
    void attachView(V v);

    void detachView();
}