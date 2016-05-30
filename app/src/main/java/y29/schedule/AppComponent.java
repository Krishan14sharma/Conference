package y29.schedule;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import y29.schedule.common.util.ImageLoader;
import y29.schedule.data.DataModule;
import y29.schedule.data.remote.Repository;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton
@Component(modules = {AppModule.class, DataModule.class})
public interface AppComponent {
    //Exposed to sub-graphs.
    Application context();

    Repository restRepository();

    ImageLoader imageLoader();
}
