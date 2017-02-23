package net.oschina.app.base;

import android.app.ActionBar;
import android.widget.Toolbar;

import net.oschina.app.R;

/**
 * Created by Jerry on 2017/2/23.
 */

public class BackActivity extends BaseActivity {


    protected Toolbar mToolbar;

    @Override
    protected void initWindow() {
        super.initWindow();
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setHomeButtonEnabled(false);
            }


        }
    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}
