package com.test3.hotkang.test3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

public class ContactAdapter extends BaseAdapter {
    private LinkedList<ItemContact> mData;
    private Context mContext;

    public ContactAdapter(LinkedList<ItemContact> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list_contact, parent,false);
        ImageView contactPhoto = (ImageView) convertView.findViewById(R.id.contactPhoto);
        TextView contactName = (TextView) convertView.findViewById(R.id.contactName);
        TextView phoneNumber = (TextView) convertView.findViewById(R.id.phoneNumber);
        contactPhoto.setBackgroundResource(mData.get(position).getcIcon());
        contactName.setText(mData.get(position).getcName());
        phoneNumber.setText(mData.get(position).getcSpeak());
        return convertView;
    }
}
