package com.example.anh.deton.Fragment_Navigation;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anh.deton.R;

/**
 * Created by Admin on 30/11/2016.
 */

public class Fragment_Chapter extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_chapter, container, false);
        return v;
    }
}
