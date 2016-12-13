package com.example.anh.deton.Navigation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anh.deton.R;

/**
 * Created by rainb on 10/24/2015.
 */

public class CustomListAdapter_Drawer_Fragment extends ArrayAdapter<String> {
    private final Context context;
    private final String[] itemname;
    private final Integer[] imgid;

    public CustomListAdapter_Drawer_Fragment(Context context, String[] itemname, Integer[] imgid) {
        super(context, R.layout.customlistadapter_drawer_fragment, itemname);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.itemname = itemname;
        this.imgid = imgid;
    }


    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.customlistadapter_drawer_fragment, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.tv_text);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.im_image);


        txtTitle.setText(itemname[position]);
        imageView.setImageResource(imgid[position]);

        return rowView;

    }
}