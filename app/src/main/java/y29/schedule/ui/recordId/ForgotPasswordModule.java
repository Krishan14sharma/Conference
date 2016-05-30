package y29.schedule.ui.recordId;

import com.jiocartseller.jio.ActivityScope;
import com.jiocartseller.jio.data.repository.Repository;
import com.jiocartseller.jio.util.Encryptor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by krishan on 4/2/16.
 */
@Module
public class ForgotPasswordModule {

    @ActivityScope
    @Provides
    public ForgotPasswordContract.ForgotPasswordPresenter providePresenter(ForgotPasswordUseCase forgotPasswordUseCase, Encryptor encryptor) {
        return new ForgotPasswordPresenterImpl(forgotPasswordUseCase, encryptor);
    }

    @ActivityScope
    @Provides
    public ForgotPasswordUseCase provideForgotPassUseCase(Repository repository) {
        return new ForgotPasswordUseCaseImpl(repository);
    }

}
