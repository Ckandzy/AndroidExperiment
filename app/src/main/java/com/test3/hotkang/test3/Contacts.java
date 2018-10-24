package com.test3.hotkang.test3;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.List;

public class Contacts extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private List<ItemContact> mData = null;
    private Context mContext;
    private ContactAdapter mAdapter = null;
    private ListView list_contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        mContext = Contacts.this;
        list_contact = (ListView) findViewById(R.id.contacts_list);
        mData = new LinkedList<ItemContact>();
        mData.add(new ItemContact("狗", "17347993725", R.drawable.dog));
        mData.add(new ItemContact("牛", "18875199887", R.drawable.cattle));
        mData.add(new ItemContact("鸭", "15823566422", R.drawable.duck));
        mData.add(new ItemContact("鱼", "13028877466", R.drawable.fish));
        mData.add(new ItemContact("马", "13538098161", R.drawable.horse));
        mAdapter = new ContactAdapter((LinkedList<ItemContact>) mData, mContext);
        list_contact.setAdapter(mAdapter);
        list_contact.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        Object contact = parent.getItemAtPosition(position);
        Toast.makeText(mContext, "你点击了第" + position + "项", Toast.LENGTH_SHORT).show();
    }
}
