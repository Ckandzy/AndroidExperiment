package com.test3.hotkang.test3;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class MemoActivity extends AppCompatActivity implements View.OnClickListener
{
    private EditText editFileName;
    private EditText editFileContent;
    private Button btnSave;
    private Button btnLoad;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        mContext = getApplicationContext();
        editFileName = findViewById(R.id.edit_filename);
        editFileContent = findViewById(R.id.edit_filecontent);
        btnLoad = findViewById(R.id.btn_load);
        btnSave = findViewById(R.id.btn_save);

        btnLoad.setOnClickListener(this);
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.btn_save:
            {
                FileHelper fHelper = new FileHelper(mContext);
                String fileName = editFileName.getText().toString();
                String fileContent = editFileContent.getText().toString();
                try
                {
                    fHelper.save(fileName, fileContent);
                    Toast.makeText(getApplicationContext(), "数据写入成功", Toast.LENGTH_SHORT).show();
                } catch (Exception e)
                {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "数据写入失败", Toast.LENGTH_SHORT).show();
                }
            }break;
            case R.id.btn_load:
            {
                String fileContent = "";
                FileHelper fHelper = new FileHelper(getApplicationContext());
                try
                {
                    String fileName = editFileName.getText().toString();
                    fileContent = fHelper.read(fileName);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                editFileContent.setText(fileContent);
                //Toast.makeText(getApplicationContext(), fileContent, Toast.LENGTH_SHORT).show();
            }break;
        }
    }
}
