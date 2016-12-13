package com.example.anh.deton.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.anh.deton.R;

/**
 * Created by Admin on 10/12/2016.
 */

public class Fragment_1_OnDiaLogLoadChapter_Adapter extends BaseAdapter {

    private String[] mChapter;

    private Context mContext;

    public Fragment_1_OnDiaLogLoadChapter_Adapter(Context context, String[] mContent) {
        this.mChapter = mContent;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mChapter.length;
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
        if (view == null) {
            viewHolder = new ViewHolder();
            view = View.inflate(mContext, R.layout.layout_list_item_on_dialog_loadchapter, null);
            viewHolder.textContent = (TextView) view.findViewById(R.id.tv_chapter);
            view.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) view.getTag();
        viewHolder.textContent.setText(mChapter[position]);

        return view;
    }

    private class ViewHolder {

        TextView textContent;

    }
}
