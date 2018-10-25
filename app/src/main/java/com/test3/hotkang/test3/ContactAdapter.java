package com.test3.hotkang.test3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

public class ContactAdapter extends BaseAdapter
{
    private LinkedList<ItemContact> mData;
    private Context mContext;

    public ContactAdapter(LinkedList<ItemContact> mData, Context mContext)
    {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public int getCount()
    {
        return mData.size();
    }

    @Override
    public Object getItem(int position)
    {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder = null;
        if(convertView == null)
        {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list_contact,parent,false);
            holder = new ViewHolder();
            holder.contactPhoto = (ImageView) convertView.findViewById(R.id.contactPhoto);
            holder.contactName = (TextView) convertView.findViewById(R.id.contactName);
            holder.phoneNumber = (TextView) convertView.findViewById(R.id.phoneNumber);
            convertView.setTag(holder);   //将Holder存储到convertView中
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.contactPhoto.setBackgroundResource(mData.get(position).getcPhoto());
        holder.contactName.setText(mData.get(position).getcName());
        holder.phoneNumber.setText(mData.get(position).getcPhoneNumber());
        return convertView;
    }

    static class ViewHolder
    {
        ImageView contactPhoto;
        TextView contactName;
        TextView phoneNumber;
    }

    public void add(ItemContact data) {
        if (mData == null) {
            mData = new LinkedList<>();
        }
        mData.add(data);
        notifyDataSetChanged();
    }

    public void Remove(int position)
    {
        if(getItem(position) != null)
        {
            mData.remove(position);
            notifyDataSetChanged();
        }
    }
}
