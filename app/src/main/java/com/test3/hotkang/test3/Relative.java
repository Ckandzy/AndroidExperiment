package com.test3.hotkang.test3;

import android.content.Context;
import android.content.Intent;
import android.opengl.Visibility;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Relative extends AppCompatActivity {

    public Context context = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);
        Button btn = findViewById(R.id.button8);
        ImageButton btnStart = findViewById(R.id.imageButton1);

        context = this;
        btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Button btnOK = findViewById(R.id.button9);
                btnOK.setVisibility(View.VISIBLE);
                return false;
            }
        });
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Frame.class);
                startActivity(intent);
            }
        });
    }
}
