package com.example.huhu.helloword;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class XToast {
    private Dialog mDialog;
    private TextView mTextView;
    private int mDuration;
    private Handler mHandler = new Handler();

    XToast(Context context, String text, int duration) {
        mDialog = new Dialog(context);
        mDialog.setContentView(R.layout.activity_xtoast);
        mTextView = mDialog.findViewById(R.id.text);
        mTextView.setText(text);
        mDuration = duration;
        Window window = mDialog.getWindow();
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        //params.format = PixelFormat.TRANSLUCENT;
        //params.windowAnimations = com.android.internal.R.style.Animation_Toast;
        //params.type = WindowManager.LayoutParams.TYPE_TOAST;
        //params.setTitle("Toast");
        params.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        window.setAttributes(params);
        window.setGravity(Gravity.BOTTOM);
    }

    public static XToast makeText(Context context, String text, int duration) {
        return new XToast(context, text, duration);
    }

    public void show() {
        mDialog.show();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mDialog.cancel();
            }
        }, mDuration);
    }
}
