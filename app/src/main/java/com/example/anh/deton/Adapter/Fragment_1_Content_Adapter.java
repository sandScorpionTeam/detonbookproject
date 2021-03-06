package com.example.anh.deton.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.anh.deton.R;

import java.util.ArrayList;

/**
 * Created by Admin on 10/12/2016.
 */

public class Fragment_1_Content_Adapter extends BaseAdapter {

    private StringBuilder mContent;

    private Context mContext;

    public Fragment_1_Content_Adapter(Context context, StringBuilder mContent) {
        this.mContent = mContent;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mContent.length();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder;
        if(view == null){
            viewHolder = new ViewHolder();
            view = View.inflate(mContext, R.layout.layout_content_of_fragment_1, null);
            viewHolder.textContent = (TextView)view.findViewById(R.id.tv_content);
            view.setTag(viewHolder);
        }
        viewHolder = (ViewHolder)view.getTag();
        viewHolder.textContent.setText(mContent);

        return view;
    }

    private class ViewHolder{

        TextView textContent;

    }
}
