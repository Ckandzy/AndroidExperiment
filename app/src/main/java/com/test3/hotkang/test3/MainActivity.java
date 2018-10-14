package com.test3.hotkang.test3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void Login(View view)
    {
        Intent intent = new Intent(this, SignUp.class);
        EditText Login_Email = findViewById(R.id.Login_Email);
        EditText Login_PWD = findViewById(R.id.Login_PWD);
        String email = Login_Email.getText().toString();
        String password = Login_PWD.getText().toString();
        if(email.contentEquals("353223003@qq.com")&&password.contentEquals("123456"))
        {
            startActivity(intent);
        }
        else {
            Toast toast = Toast.makeText(this, "Email or password error", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void SignUp(View view)
    {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }

    public void Forget(View view)
    {
        Intent intent = new Intent(this, Reset.class);
        startActivityForResult(intent,2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==2 && resultCode==1)
        {
            EditText Login_Email = findViewById(R.id.Login_Email);
            EditText Login_PWD = findViewById(R.id.Login_PWD);
            Login_Email.setText(data.getStringExtra("Email"));
            Login_PWD.setText(data.getStringExtra("Password"));
        }
    }
}
