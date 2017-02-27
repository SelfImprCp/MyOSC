package net.oschina.app.ui;

import android.content.Intent;

import net.oschina.app.R;
import net.oschina.app.base.BaseActivity;
import net.oschina.app.main.MainActivity;

/**
 * Created by Jerry on 2017/2/24.
 */

public class LauchActivity
        extends BaseActivity {


    @Override
    protected int getContentView() {
        return R.layout.app_start;
    }


    @Override
    protected void initData() {
        super.initData();
        doMerage();

    }

    private void doMerage()   {

        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        redirectTo();

    }

    private void redirectTo() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}
