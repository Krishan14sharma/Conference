package y29.schedule.common.util;

import android.content.Context;

import y29.schedule.common.base.BaseApp;


/**
 * Created by krishan on 14/1/16.
 * This class provides the application context to all the utility classes.
 */
public class AppContextProvider {

    public static Context getContext() {
        if (BaseApp.getContext() == null)
            throw new NullPointerException("Context is null. May be application not defined in Manifest");
        return BaseApp.getContext();
    }
}
