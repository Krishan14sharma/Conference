package y29.schedule.ui.recordId;

import com.jiocartseller.jio.data.repository.Repository;
import com.jiocartseller.jio.data.repository.rest.model.Status;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by krishan on 4/2/16.
 */
public class ForgotPasswordUseCaseImpl implements ForgotPasswordUseCase<Status> {

    private final Repository repository;

    @Inject
    public ForgotPasswordUseCaseImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<Status> execute(String string) {
        return repository.resetPassword(string);
    }
}
