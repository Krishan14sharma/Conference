package y29.schedule;


import timber.log.Timber;
import y29.schedule.common.base.BaseApp;

/**
 * Created by krishan on 14/12/15. This is used for production builds.
 */
public class ScheduleApp extends BaseApp {

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new CrashReportingTree());
    }

    /**
     * This tree will log crash reporting. Use Crashylytics etc.
     */
    private static class CrashReportingTree extends Timber.Tree {
        @Override
        protected void log(int priority, String tag, String message, Throwable t) {
            // // TODO: 29-05-2016 Send to crashylytics etc
        }
    }

}