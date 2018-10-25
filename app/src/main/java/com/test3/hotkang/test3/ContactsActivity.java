package com.test3.hotkang.test3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ContactsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private List<ItemContact> mData = null;
    private Context mContext;
    private ContactAdapter mAdapter = null;
    private ListView list_contact;
    //private HashMap<String, Integer> photoMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

//        photoMap = new HashMap<>();
//        photoMap.put("dog", R.drawable.dog);
//        photoMap.put("cattle", R.drawable.cattle);
//        photoMap.put("duck", R.drawable.duck);
//        photoMap.put("fish", R.drawable.fish);
//        photoMap.put("horse", R.drawable.horse);

        mContext = ContactsActivity.this;
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

        Button add = (Button)findViewById(R.id.button17);
        add.setOnClickListener(v->{
            Intent intent = new Intent(this,ContactEditActivity.class);
            startActivityForResult(intent,1);
        });
    }

    //提示: requestCode(1:点击添加按钮调用,2:点击通讯录列表调用)
    //      resultCode(0:删除按钮返回,1:应用按钮返回)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1)
        {
            if(resultCode == 0)
            {

            }
            else if(resultCode == 1)
            {
                mAdapter.add(
                        new ItemContact(
                                data.getStringExtra("cName"),
                                data.getStringExtra("cPhoneNumber"),
                                data.getIntExtra("cPhoto", R.drawable.duck)
                        )
                );
            }
        }
        else if(requestCode == 2)
        {
            if(data == null)
                return;
            if(resultCode == 0)
            {
                mAdapter.Remove(data.getIntExtra("cPosition",0));
            }
            else if(resultCode == 1)
            {
                ItemContact itemContact = (ItemContact)mAdapter.getItem(data.getIntExtra("cPosition",0));
                itemContact.setcName(data.getStringExtra("cName"));
                itemContact.setcPhoneNumber(data.getStringExtra("cPhoneNumber"));
                itemContact.setcPhoto(data.getIntExtra("cPhoto", R.drawable.duck));
                mAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        //ItemContact contact = (ItemContact)parent.getItemAtPosition(position);
        //Toast.makeText(mContext, contact.getcName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,ContactEditActivity.class);
        intent.putExtra("cPosition", position);
        intent.putExtra("cName", ((ItemContact)parent.getItemAtPosition(position)).getcName());
        intent.putExtra("cPhoneNumber", ((ItemContact)parent.getItemAtPosition(position)).getcPhoneNumber());
        intent.putExtra("cPhoto", ((ItemContact)parent.getItemAtPosition(position)).getcPhoto());
        startActivityForResult(intent,2);
    }
}
