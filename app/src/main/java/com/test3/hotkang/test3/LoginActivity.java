package com.test3.hotkang.test3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedHelper sh = new SharedHelper(this);
        Map<String, Object> data = sh.read();

        EditText Login_Email = findViewById(R.id.Login_Email);
        EditText Login_PWD = findViewById(R.id.Login_PWD);
        CheckBox checkBox = findViewById(R.id.checkBox3);

        if((boolean)data.get("isRemember"))
        {
            Login_Email.setText((String)data.get("email"));
            Login_PWD.setText((String)data.get("password"));
            checkBox.setChecked(true);
        }
    }

    public void Login(View view)
    {
        Intent intent = new Intent(this, GridActivity.class);
        EditText Login_Email = findViewById(R.id.Login_Email);
        EditText Login_PWD = findViewById(R.id.Login_PWD);
        String email = Login_Email.getText().toString();
        String password = Login_PWD.getText().toString();
        SharedHelper sh = new SharedHelper(this);
        Map<String, Object> data = sh.read();

        if(email.equals(data.get("email")) && password.equals(data.get("password")))
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
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    public void Forget(View view)
    {
        Intent intent = new Intent(this, ResetActivity.class);
        startActivityForResult(intent,2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 2 && resultCode == 1)
        {
            SharedHelper sh = new SharedHelper(this);
            Map<String, Object> dataSH = sh.read();

            EditText Login_Email = findViewById(R.id.Login_Email);
            EditText Login_PWD = findViewById(R.id.Login_PWD);
            CheckBox checkBox = findViewById(R.id.checkBox3);

            Login_Email.setText((String)dataSH.get("email"));
            Login_PWD.setText((String)dataSH.get("password"));

            if((boolean)dataSH.get("isRemember"))
            {
                checkBox.setChecked(true);
            }
        }
    }

    public void Remember(View view)
    {
        SharedHelper sh = new SharedHelper(this);
        sh.save(((CheckBox)view).isChecked());
    }
}
