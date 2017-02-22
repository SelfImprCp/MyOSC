package net.oschina.app.base;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;

import net.oschina.app.dialog.DialogControl;

/**
 * Created by Jerry on 2017/2/22.
 */

public abstract class BaseActivity extends AppCompatActivity implements DialogControl {


    @Override
    public ProgressDialog showWaitDialog() {
        return null;
    }


    @Override
    public void hideWaitDialog() {

    }
}
