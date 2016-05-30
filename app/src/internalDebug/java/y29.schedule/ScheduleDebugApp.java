package y29.schedule;


import com.squareup.leakcanary.LeakCanary;

import timber.log.Timber;
import y29.schedule.common.base.BaseApp;

/**
 * Created by krishan on 14/12/15.
 * This class will be used for Debug builds only. No code written here will go into production build.
 */
public class ScheduleDebugApp extends BaseApp {

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
        LeakCanary.install(this); // Detects possible memory leaks in your application.

    }


}