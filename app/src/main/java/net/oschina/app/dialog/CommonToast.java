//package net.oschina.app.dialog;
//
//import android.app.Activity;
//import android.content.Context;
//import android.util.AttributeSet;
//import android.view.LayoutInflater;
//import android.widget.FrameLayout;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import net.oschina.app.R;
//import net.oschina.app.util.TDevice;
//
///**
// * Created by Jerry on 2017/2/22.
// */
//
//public class CommonToast {
//
//
//
//
//    public static final long DURATION_LONG = 5000L;
//    public static final long DURATION_MEDIUM = 3500L;
//    public static final long DURATION_SHORT = 2500L;
//    private long _duration = 3500l;
//    private ToastView _toastVw;
//
//     public  CommonToast(Activity activity)
//    {
//         init(activity);
//    }
//
//
//    private  void init(Activity activity)
//    {
//         _toastVw = new ToastView(activity);
//
//
//    }
//
//
//    public void setLayoutGravity(int i) {
//        if (i != 0) {
//            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-2,
//                    -2);
//            params.gravity = i;
//            int j = (int) TDevice.dp2px(16F);
//            params.setMargins(j, j, j, j);
//            _toastVw.setLayoutParams(params);
//        }
//    }
//
//
//
//    private class ToastView extends FrameLayout{
//        public ImageView actionIv;
//        public TextView actionTv;
//        public ImageView messageIc;
//        public TextView messageTv;
//
//        public ToastView(Context context) {
//          this(context,null);
//        }
//
//        public ToastView(Context context, AttributeSet attrs) {
//            this(context, attrs,0);
//        }
//
//        public ToastView(Context context, AttributeSet attrs, int defStyleAttr) {
//            super(context, attrs, defStyleAttr);
//            init();
//        }
//
//
//         private  void init()
//         {
//
//             LayoutInflater.from(getContext()).inflate(R.layout.view_base_toast,this,true);
//
//             messageTv = (TextView) findViewById(R.id.title_tv);
//             messageIc = (ImageView) findViewById(R.id.icon_iv);
//             actionTv = (TextView) findViewById(R.id.title_tv);
//             actionIv = (ImageView) findViewById(R.id.icon_iv);
//
//
//         }
//
//
//
//    }
//
//
//
//
//
//
//}
