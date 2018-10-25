package com.test3.hotkang.test3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ContactEditActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    //判断是否为刚进去时触发onItemSelected的标志
    private boolean one_selected = false;
    private int contactPhoto;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_edit);

        TextView cName = (TextView)findViewById(R.id.editText10);
        TextView cPhoneNumber = (TextView)findViewById(R.id.editText11);
        Button apply = (Button)findViewById(R.id.button14);
        Button delete = (Button)findViewById(R.id.button15);

        cName.setText(getIntent().getStringExtra("cName"));
        cPhoneNumber.setText(getIntent().getStringExtra("cPhoneNumber"));
        contactPhoto = getIntent().getIntExtra("cPhoto", R.drawable.duck);

        //此处代码冗余，需要改进
        spinner = (Spinner)findViewById(R.id.spinner2);
        int position = 0;
        switch (contactPhoto)
        {
            case R.drawable.dog: position = 1; break;
            case R.drawable.duck: position = 4; break;
            case R.drawable.cattle: position = 0; break;
            case R.drawable.fish: position = 3; break;
            case R.drawable.horse: position = 2; break;
        }
        spinner.setSelection(position);

        apply.setOnClickListener(v->{
            if(cName.getText().toString().isEmpty() || cPhoneNumber.getText().toString().isEmpty())
            {
                Toast.makeText(this,"Name or phone nubmer can not be empty", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Intent intent = new Intent(this,ContactsActivity.class);
                intent.putExtra("cPosition", getIntent().getIntExtra("cPosition", 0));
                intent.putExtra("cName", cName.getText().toString());
                intent.putExtra("cPhoneNumber", cPhoneNumber.getText().toString());
                intent.putExtra("cPhoto", contactPhoto);
                setResult(1, intent);
                finish();
            }
        });
        delete.setOnClickListener(v->{
            Intent intent = getIntent();
            if(intent.getIntExtra("cPosition",-1) != -1)
            {
                intent = new Intent(this,ContactsActivity.class);
                intent.putExtra("cPosition",getIntent().getIntExtra("cPosition", 0));
                setResult(0, intent);
            }
            else
            {
                setResult(1);
            }
            finish();
        });
        ((Spinner)findViewById(R.id.spinner2)).setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        switch (parent.getId())
        {
            case R.id.spinner2:
                switch (position)
                {
                    case 0: contactPhoto = R.drawable.cattle; break;
                    case 1: contactPhoto = R.drawable.dog; break;
                    case 2: contactPhoto = R.drawable.horse; break;
                    case 3: contactPhoto = R.drawable.fish; break;
                    case 4: contactPhoto = R.drawable.duck; break;
                }
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }
}
