package com.test3.hotkang.test3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class RelativeActivity extends AppCompatActivity {

    public Context context = null;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);
        Button btn = findViewById(R.id.button8);
        ImageButton btnStart = findViewById(R.id.imageButton1);

        context = this;
        btn.setOnLongClickListener(v -> {
            Button btnOK = findViewById(R.id.button9);
            btnOK.setVisibility(View.VISIBLE);
            return false;
        });
        btnStart.setOnClickListener(v -> {
            Intent intent = new Intent(context, FrameActivity.class);
            startActivity(intent);
        });
        btn.setOnTouchListener((v, event)->{
            if(event.getAction() == MotionEvent.ACTION_UP)
            {
                Button btnOK = findViewById(R.id.button9);
                btnOK.setVisibility(View.INVISIBLE);
            }
            return false;
        });

        ImageButton buttonHelp = findViewById(R.id.imageButton2);
        ImageButton buttonSetting = findViewById(R.id.imageButton);
        ImageButton buttonRank = findViewById(R.id.imageButton3);
        ImageButton buttonQuit = findViewById(R.id.imageButton10);

        buttonHelp.setOnClickListener((v -> {
            Toast.makeText(RelativeActivity.this,"帮助",Toast.LENGTH_SHORT).show();
        }));
        buttonSetting.setOnClickListener((v -> {
            Toast.makeText(RelativeActivity.this,"设置",Toast.LENGTH_SHORT).show();
        }));
        buttonRank.setOnClickListener((v -> {
            Toast.makeText(RelativeActivity.this,"风云榜",Toast.LENGTH_SHORT).show();
        }));
        buttonQuit.setOnClickListener((v -> {
            finish();
        }));
    }
}
