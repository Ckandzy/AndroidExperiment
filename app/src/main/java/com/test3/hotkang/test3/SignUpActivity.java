package com.test3.hotkang.test3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //判断是否为刚进去时触发onItemSelected的标志
    private boolean one_selected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ((Spinner)findViewById(R.id.spinner)).setOnItemSelectedListener(this);
    }

    public void Read(View view)
    {
        Intent intent = new Intent(this, AgreementActivity.class);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == 1)
        {
            CheckBox read = findViewById(R.id.SignUp_Read);
            Button confirm = findViewById(R.id.SignUp_Confirm);
            confirm.setClickable(true);
            read.setClickable(true);
        }
    }

    public void Confirm(View view)
    {
        Intent intent = new Intent(this, PreviewActivity.class);
        Bundle data = new Bundle();
        EditText Email = findViewById(R.id.editText3);
        EditText Password = findViewById(R.id.editText4);
        EditText Repeat = findViewById(R.id.editText5);
        RadioGroup Sex = findViewById(R.id.radioGroup);
        CheckBox read = findViewById(R.id.SignUp_Read);

        if(!read.isChecked())
        {
            Toast.makeText(this,"Please read the agreement", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!Password.getText().toString().equals(Repeat.getText().toString()))
        {
            Toast.makeText(this,"Invalid password", Toast.LENGTH_SHORT).show();
            return;
        }
        if(Email.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Invalid email ", Toast.LENGTH_SHORT).show();
            return;
        }
        CheckBox[] box = new CheckBox[6];
        box[0] = findViewById(R.id.checkBox);
        box[1] = findViewById(R.id.checkBox2);
        box[2] = findViewById(R.id.checkBox4);
        box[3] = findViewById(R.id.checkBox5);
        box[4] = findViewById(R.id.checkBox7);
        box[5] = findViewById(R.id.checkBox8);
        data.putString("Email", Email.getText().toString());
        if(Sex.getCheckedRadioButtonId() == R.id.radioButton)
        {
            data.putString("Sex", "Male");
        }
        else if(Sex.getCheckedRadioButtonId() == R.id.radioButton2)
        {
            data.putString("Sex", "Female");
        }
        else
        {

        }
        ArrayList<String> strList = new ArrayList<String>();
        for(int i = 0; i < 6; i++)
        {
            if(box[i].isChecked())
            {
                strList.add(box[i].getText().toString());
            }

        }
        SharedHelper sh = new SharedHelper(this);
        sh.save(Email.getText().toString(), Password.getText().toString());

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
        CheckBox box4 = findViewById(R.id.checkBox4);
        CheckBox box5 = findViewById(R.id.checkBox5);
        CheckBox box7 = findViewById(R.id.checkBox7);
        CheckBox box8 = findViewById(R.id.checkBox8);

        RadioGroup Sex = findViewById(R.id.radioGroup);

        Email.setText("");
        Password.setText("");
        PWDRepeat.setText("");

        box1.setChecked(false);
        box2.setChecked(false);
        box4.setChecked(false);
        box5.setChecked(false);
        box7.setChecked(false);
        box8.setChecked(false);

        Sex.clearCheck();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        switch (parent.getId()){
            case R.id.spinner:
                if(one_selected)
                Toast.makeText(SignUpActivity.this,"Your education is：" + parent.getItemAtPosition(position).toString(),
                        Toast.LENGTH_SHORT).show();
                else one_selected = true;
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }
}
