package com.test3.hotkang.test3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void Read(View view)
    {
        Intent intent = new Intent(this, Agreement.class);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == 1)
        {
            CheckBox Read = findViewById(R.id.SignUp_Read);

            Read.setClickable(true);
        }
    }

    public void Confirm(View view)
    {
        Intent intent = new Intent(this, Preview.class);
        Bundle data = new Bundle();
        EditText Email = findViewById(R.id.editText3);
        RadioGroup Sex = findViewById(R.id.radioGroup);
        CheckBox[] box = new CheckBox[9];
        box[0] = findViewById(R.id.checkBox);
        box[1] = findViewById(R.id.checkBox2);
        box[2] = findViewById(R.id.checkBox3);
        box[3] = findViewById(R.id.checkBox4);
        box[4] = findViewById(R.id.checkBox5);
        box[5] = findViewById(R.id.checkBox6);
        box[6] = findViewById(R.id.checkBox7);
        box[7] = findViewById(R.id.checkBox8);
        box[8] = findViewById(R.id.checkBox9);
        data.putString("Email",Email.getText().toString());
        if(Sex.getCheckedRadioButtonId()==R.id.radioButton)
        {
            data.putString("Sex","Male");
        }
        else
        {
            data.putString("Sex","Female");
        }
        ArrayList<String> strList = new ArrayList<String>();
        for(int i = 0; i < 9; i++)
        {
            if(box[i].isChecked())
            {
                strList.add(box[i].getText().toString());
            }

        }
        data.putStringArrayList("Hobby",strList);
        intent.putExtras(data);
        startActivityForResult(intent,1);
    }

    public void Cancel(View view)
    {
        finish();
    }

    public void Clean(View view)
    {
        EditText Email = findViewById(R.id.editText3);
        EditText Password = findViewById(R.id.editText4);
        EditText PWDRepeat = findViewById(R.id.editText5);

        CheckBox box1 = findViewById(R.id.checkBox);
        CheckBox box2 = findViewById(R.id.checkBox2);
        CheckBox box3 = findViewById(R.id.checkBox3);
        CheckBox box4 = findViewById(R.id.checkBox4);
        CheckBox box5 = findViewById(R.id.checkBox5);
        CheckBox box6 = findViewById(R.id.checkBox6);
        CheckBox box7 = findViewById(R.id.checkBox7);
        CheckBox box8 = findViewById(R.id.checkBox8);
        CheckBox box9 = findViewById(R.id.checkBox9);

        RadioGroup Sex = findViewById(R.id.radioGroup);

        Email.setText("");
        Password.setText("");
        PWDRepeat.setText("");

        box1.setClickable(false);
        box2.setClickable(false);
        box3.setClickable(false);
        box4.setClickable(false);
        box5.setClickable(false);
        box6.setClickable(false);
        box7.setClickable(false);
        box8.setClickable(false);
        box9.setClickable(false);

        Sex.clearCheck();

    }
}
