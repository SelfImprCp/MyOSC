package net.oschina.app.dialog;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.view.View;

import net.oschina.app.R;

/**
 * Created by Jerry on 2017/2/22.
 */

public final class DialogHelper {


    public static AlertDialog.Builder getDialog(Context context) {

        return new AlertDialog.Builder(context, R.style.AppTheme);
    }


    /**
     * 获取一个普通消息对话框，
     *
     * @param context
     * @param title
     * @param message
     * @param cancelable
     * @return
     */

    public static AlertDialog.Builder getMessageDialog(Context context, String title, String message, boolean cancelable) {

        return getDialog(context).setCancelable(cancelable).setTitle(title).setMessage(message).setPositiveButton("确定", null);

    }

    /**
     * 获取一个普通消息对话框 ，没有取消按钮
     *
     * @param context
     * @param title
     * @param message
     * @return
     */
    public static AlertDialog.Builder getMessageDialog(Context context, String title, String message) {
        return getMessageDialog(context, title, message, false);
    }


    /**
     * @param context
     * @param message
     * @return
     */
    public static AlertDialog.Builder getMessageDialog(Context context, String message) {
        return getMessageDialog(context, "", message);

    }

    /**
     * @param context
     * @param title
     * @param message
     * @param positiveText
     * @return
     */
    public static AlertDialog.Builder getMessageDialog(Context context, String title, String message, String positiveText) {
        return getDialog(context).setTitle(title).setMessage(message).setPositiveButton(positiveText, null);

    }

    /**
     * 确认对话框
     *
     * @param context
     * @param title
     * @param view
     * @param positiveListener
     * @return
     */
    public static AlertDialog.Builder getConfirmDialog(Context context, String title, View view, DialogInterface.OnClickListener positiveListener) {
        return getDialog(context).setTitle(title).setView(view).setPositiveButton("确定", positiveListener).setNegativeButton("取消", null);

    }

    /**
     * 确认对话框
     *
     * @param context
     * @param title
     * @param message
     * @param positiveText
     * @param negativeText
     * @param cancelable
     * @param pisitiveListener
     * @param negativeListener
     * @return
     */

    public static AlertDialog.Builder getConfirmDialog(Context context, String title, String message, String positiveText, String negativeText, boolean cancelable, DialogInterface.OnClickListener pisitiveListener,
                                                       DialogInterface.OnClickListener negativeListener) {

        return getDialog(context).setTitle(title).setCancelable(cancelable)
                .setMessage(message).setPositiveButton(positiveText, pisitiveListener).setNegativeButton(negativeText, negativeListener);

    }

    /**
     * @param context
     * @param message
     * @param positiveListener
     * @param negativeListener
     * @return
     */

    public static AlertDialog.Builder getConfirmDialog(Context context, String message,
                                                       DialogInterface.OnClickListener positiveListener,
                                                       DialogInterface.OnClickListener negativeListener) {
        return getDialog(context)
                .setMessage(message)
                .setPositiveButton("确定", positiveListener)
                .setNegativeButton("取消", negativeListener);


    }


//    public static AlertDialog.Builder getConfirmDialog(Context context,String title,String message,String positiveText,String negativeText,boolean cancelable,
//                                                       DialogInterface.OnClickListener onClickListener)
//    {
//
//
//
//
//
//
//    }


    /**
     * @param context
     * @param title
     * @param array
     * @param selectIndex
     * @param onClickListener
     * @return
     */
    public static AlertDialog.Builder getSingleChoiceDialog(Context context, String title, String[] array, int selectIndex, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = getDialog(context);
        builder.setSingleChoiceItems(array, selectIndex, onClickListener);
        if (!TextUtils.isEmpty(title)) {
            builder.setTitle(title);
        }
        builder.setNegativeButton("取消", null);
        return builder;

    }


    /**
     * @param context
     * @param title
     * @param editText
     * @param positiveText
     * @param negativeText
     * @param cancelable
     * @param positiveListener
     * @param negativeListener
     * @return
     */
    public static AlertDialog.Builder getInputDialog(Context context, String title, AppCompatEditText editText, String positiveText, String negativeText, boolean cancelable, DialogInterface.OnClickListener
            positiveListener, DialogInterface.OnClickListener negativeListener) {
        return getDialog(context)
                .setCancelable(cancelable)
                .setTitle(title)
                .setView(editText)
                .setPositiveButton(positiveText, positiveListener)
                .setNegativeButton(negativeText, negativeListener);


    }


    /**
     * @param context
     * @return
     */
    public static ProgressDialog getProgressDialog(Context context) {
        return new ProgressDialog(context);


    }

    /**
     * @param context
     * @param message
     * @return
     */
    public static ProgressDialog getProgressDialog(Context context, String message) {

        ProgressDialog progressDialog = getProgressDialog(context);
        progressDialog.setMessage(message)
        ;
        return progressDialog;
    }


    /**
     * 获取一个等待对话框
     */
    public static ProgressDialog getProgressDialog(
            Context context, String title, String message, boolean cancelable) {
        ProgressDialog dialog = getProgressDialog(context);
        dialog.setCancelable(cancelable);
        dialog.setTitle(title);
        dialog.setMessage(message);
        return dialog;
    }

    /**
     * 获取一个等待对话框
     */
    public static ProgressDialog getProgressDialog(
            Context context, String message, boolean cancelable) {
        ProgressDialog dialog = getProgressDialog(context);
        dialog.setCancelable(cancelable);
        dialog.setMessage(message);
        return dialog;
    }

    public static AlertDialog.Builder getSelectDialog(
            Context context, String title, String[] items,
            String positiveText,
            DialogInterface.OnClickListener itemListener) {
        return getDialog(context)
                .setTitle(title)
                .setItems(items, itemListener)
                .setPositiveButton(positiveText, null);

    }

    public static AlertDialog.Builder getSelectDialog(
            Context context, String[] items,
            String positiveText,
            DialogInterface.OnClickListener itemListener) {
        return getDialog(context)
                .setItems(items, itemListener)
                .setPositiveButton(positiveText, null);

    }

    public static AlertDialog.Builder getSelectDialog(Context context, View view, String positiveText,
                                                      DialogInterface.OnClickListener itemListener) {
        return getDialog(context)
                .setView(view)
                .setPositiveButton(positiveText, null);
    }

}



