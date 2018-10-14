package com.test3.hotkang.test3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Reset extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);
    }

    public void Check(View view)
    {
        EditText idNum = findViewById(R.id.editText);
        EditText stuId = findViewById(R.id.editText6);
        if(idNum.getText().toString().equals("500381")&&stuId.getText().toString().equals("11503010227"))
        {
            EditText Email = findViewById(R.id.editText7);
            EditText Password = findViewById(R.id.editText8);
            EditText PWDRepeat = findViewById(R.id.editText9);
            Email.setFocusable(true);
            Email.setFocusableInTouchMode(true);
            Password.setFocusable(true);
            Password.setFocusableInTouchMode(true);
            PWDRepeat.setFocusable(true);
            PWDRepeat.setFocusableInTouchMode(true);
        }
        else
        {
            Toast toast = Toast.makeText(this, "idNum or StuId is not exist", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void Confirm(View view)
    {
        Intent intent = new Intent(this,MainActivity.class);
        EditText Email = findViewById(R.id.editText7);
        EditText Password = findViewById(R.id.editText8);
        EditText PWDRepeat = findViewById(R.id.editText9);
        if(Password.getText().toString().equals(PWDRepeat.getText().toString()))
        {
            intent.putExtra("Email",Email.getText().toString());
            intent.putExtra("Password",Password.getText().toString());
        }
        else
        {
            Toast toast = Toast.makeText(this, "Two passwords are inconsistent", Toast.LENGTH_SHORT);
            toast.show();
        }
        setResult(1, intent);
        finish();
    }

    public void Cancel(View view)
    {
        finish();
    }
}
