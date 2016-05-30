package y29.schedule;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import y29.schedule.common.util.ImageLoader;
import y29.schedule.common.util.PicassoImageLoader;

@Module
public class AppModule {

    private final Application app;

    public AppModule(Application app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Application provideApplicationContext() {
        return app;
    }


    @Provides
    @Singleton
    public ImageLoader provideImageLoader() {
        return new PicassoImageLoader();
    }
}