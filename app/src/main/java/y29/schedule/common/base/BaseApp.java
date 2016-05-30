package y29.schedule.common.base;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import y29.schedule.AppComponent;
import y29.schedule.AppModule;
import y29.schedule.DaggerAppComponent;
import y29.schedule.R;
import y29.schedule.data.DataModule;

/**
 * Created by krishan on 10/12/14.
 * This is the Base application class that provides global application instance.
 */
public abstract class BaseApp extends Application {
    private static BaseApp instance;
    private AppComponent appComponent;

    public static BaseApp getContext() {
        return instance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        appComponent = initInjector();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath(getString(R.string.default_font_path))
                .setFontAttrId(R.attr.fontPath)
                .build());
    }

    /**
     * This is used to inject the AppComponent in the application
     *
     * @return
     */
    protected AppComponent initInjector() {
        return DaggerAppComponent.builder()
                .dataModule(new DataModule())
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}