package y29.schedule.common.core;

import rx.Observable;

public interface Usecase<T> {
    Observable<T> execute();
}