package com.test3.hotkang.test3;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class SharedHelper
{
    private Context mContext;

    public SharedHelper()
    {
    }

    public SharedHelper(Context mContext)
    {
        this.mContext = mContext;
    }

    public void save(boolean isRemember)
    {
        SharedPreferences sp = mContext.getSharedPreferences("mysp", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("isRemember", isRemember);
        //editor.commit();
        editor.apply();
        Toast.makeText(mContext, "信息已写入SharedPreference中", Toast.LENGTH_SHORT).show();
    }

    public void save(String email, String password)
    {
        SharedPreferences sp = mContext.getSharedPreferences("mysp", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("email", email);
        editor.putString("password", password);
        //editor.commit();
        editor.apply();
        Toast.makeText(mContext, "信息已写入SharedPreference中", Toast.LENGTH_SHORT).show();
    }

    //定义一个保存数据的方法
    public void save(String email, String password, boolean isRemember)
    {
        SharedPreferences sp = mContext.getSharedPreferences("mysp", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("email", email);
        editor.putString("password", password);
        editor.putBoolean("isRemember", isRemember);
        //editor.commit();
        editor.apply();
        Toast.makeText(mContext, "信息已写入SharedPreference中", Toast.LENGTH_SHORT).show();
    }

    //定义一个读取SP文件的方法
    public Map<String, Object> read()
    {
        Map<String, Object> data = new HashMap<String, Object>();
        SharedPreferences sp = mContext.getSharedPreferences("mysp", Context.MODE_PRIVATE);
        data.put("email", sp.getString("email", ""));
        data.put("password", sp.getString("password", ""));
        data.put("isRemember", sp.getBoolean("isRemember",false));
        return data;
    }
}
