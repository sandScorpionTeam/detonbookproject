package com.example.anh.deton.Fragment_Navigation;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.anh.deton.R;

/**
 * Created by Admin on 30/11/2016.
 */

public class Fragment_2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.fragment_2, container, false);

        GridView gridView = (GridView)v.findViewById(R.id.gv_test);
        RelativeLayout relativeLayout = (RelativeLayout)v.findViewById(R.id.rl_test);

        String [] a = new String [20];
        for (int i = 0; i < 20; i++){
            a[i] = "" + i;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,
                a);

        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("AAAA", "" + position);
            }
        });
        relativeLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.d("AAAA", "long" );
                return true;
            }
        });
//        gridView.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                Log.d("AAAA", "long" );
//                return true;
//            }
//        });

        return v;
    }

}
