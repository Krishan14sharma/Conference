package y29.schedule.ui.recordId;

import rx.Observable;

/**
 * Created by krishan on 4/2/16.
 */
public interface ForgotPasswordUseCase<T> {
    /**
     * @param string could be email,user_name,user_id etc
     * @return Observable with a remote response
     */
    Observable<T> execute(String string);
}
