package com.test3.hotkang.test3;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class FrameActivity extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        FrameLayout frameLayout = findViewById(R.id.activity_frame);
        BubbleDragon bubbleDragon = new BubbleDragon(FrameActivity.this);
        frameLayout.addView(bubbleDragon);
        bubbleDragon.setOnTouchListener((v, event)->{
            BubbleDragon a = (BubbleDragon)v;
            a.bitmapX_1 = event.getX();
            a.bitmapY_1 = event.getY();
            a.invalidate();
            return false;
        });


    }
}
