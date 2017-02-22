package net.oschina.app;

import net.oschina.app.base.BaseApplication;

/**
 * Created by Jerry on 2017/2/22.
 */

public class AppContext extends BaseApplication {

public static  AppContext instance;

    @Override
    public void onCreate() {
        super.onCreate();

     instance = this;
    }

    public static AppContext getInstance()
    {
        return instance;
    }




}
