package y29.schedule.ui.recordId;

import com.jiocartseller.jio.ActivityScope;
import com.jiocartseller.jio.AppComponent;

import dagger.Component;

/**
 * Created by krishan on 4/2/16.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ForgotPasswordModule.class)
public interface ForgotPasswordComponent {
    void inject(ForgotPasswordActivity activity);
}
