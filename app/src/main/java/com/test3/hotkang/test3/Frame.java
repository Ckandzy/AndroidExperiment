package com.test3.hotkang.test3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ActionMenuView;
import android.widget.FrameLayout;

public class Frame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        FrameLayout frameLayout = findViewById(R.id.activity_frame);
        AnimationView animationView = new AnimationView(Frame.this);
    }
}
