package com.test3.hotkang.test3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Agreement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreement);
    }

    public void HasRead(View view)
    {
        setResult(1);
        finish();
    }
}
