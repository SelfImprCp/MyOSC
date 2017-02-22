package net.oschina.app.dialog;

import android.app.ProgressDialog;

/**
 * Created by Jerry on 2017/2/22.
 */

public interface DialogControl {


    public abstract void hideWaitDialog();

    public abstract ProgressDialog showWaitDialog();

    public abstract ProgressDialog showWaitDialog(int resid);

    public abstract ProgressDialog showWaitDialog(String text);




}
