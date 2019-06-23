package com.example.huhu.helloword;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mBtn;
    private float mLastX;
    private float mLastY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn = findViewById(R.id.btn);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "text", Toast.LENGTH_SHORT).show();
                XToast.makeText(MainActivity.this, "hahaha", 5000).show();
            }
        });

        final Button mBtn2 = findViewById(R.id.btn2);
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) mBtn2.getLayoutParams();
                params.leftMargin += 100;
                mBtn2.requestLayout();

                //mBtn2.scrollBy(10,10);
            }
        });
        mLastX = mBtn2.getX();
        mLastY = mBtn2.getY();

        mBtn2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float x = event.getRawX();
                float y = event.getRawY();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        return false;
                    }
                    case MotionEvent.ACTION_MOVE: {
                        float deltaX = x - mLastX;
                        float deltaY = y - mLastY;
                        float translationX = mBtn2.getTranslationX() + deltaX;
                        float translationY = mBtn2.getTranslationY() + deltaY;
                        mBtn2.setTranslationX(translationX);
                        mBtn2.setTranslationY(translationY);
                        break;
                    }
                }
                mLastX = x;
                mLastY = y;
                return true;
            }

        });


        Handler handler = new Handler() {

        };
    }
}
