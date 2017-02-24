package net.oschina.app.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by Jerry on 2017/2/24.
 */

public class BaseApplication extends Application {
    private static final String PREF_NAME = "creativelocker.pref";
    static Context _context;

    @Override
    public void onCreate() {
        super.onCreate();
        _context = getApplicationContext();
        //LeakCanary.install(this);
    }

    public static synchronized BaseApplication context() {
        return (BaseApplication) _context;
    }

}
