package com.test3.hotkang.test3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PreviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        Intent intent = getIntent();
        TextView Email = findViewById(R.id.textView6);
        TextView Sex = findViewById(R.id.textView9);
        TextView Hobby = findViewById(R.id.textView11);
        String hobbyList = "";

        Email.setText(intent.getExtras().getString("Email"));
        Sex.setText(intent.getExtras().getString("Sex"));
        for(int i = 0; i < intent.getExtras().getStringArrayList("Hobby").size(); i++)
        {
            hobbyList = hobbyList + intent.getExtras().getStringArrayList("Hobby").get(i) + " ";
        }
        Hobby.setText(hobbyList);
    }

    public void Confirm(View view)
    {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void Cancel(View view)
    {
        finish();
    }
}
