package com.example.anh.deton.Fragment_Navigation;

import android.app.Dialog;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.example.anh.deton.Activity.LoadInitData;
import com.example.anh.deton.Activity.LoadPageData;
import com.example.anh.deton.Adapter.Fragment_1_Chapter_Adapter;
import com.example.anh.deton.Adapter.Fragment_1_Content_Adapter;
import com.example.anh.deton.Adapter.Fragment_1_OnDiaLogLoadChapter_Adapter;
import com.example.anh.deton.Adapter.Fragment_1_OnDialogLoadPage_Adapter;
import com.example.anh.deton.Model.ChapterModel;
import com.example.anh.deton.R;
import com.example.anh.deton.Utils.RealmUtils;

import java.util.List;

/**
 * Created by Admin on 30/11/2016.
 */

public class Fragment_1 extends Fragment implements View.OnClickListener {

    private ListView mListContent, mListChapter;

    private TextView mTextLoadChap, mTextLoadPage;

    private LoadPageData mLoadPageData;

    private int mStoryId = -1;
    private String mChapterNumber = "";
    private int mPageNumber = -1;
    private String mChapterName = "";
    private String mShowName = "";
    private String mContent = "";
    private String[] chapter = new String[10000];


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_1, container, false);

        initView(v);
        loadChapterModel();

        setDataListView();
        String a  = LoadInitData.strtmp;
        System.out.println("VVVV " + a);
        return v;
    }

    private void initView(View v) {

        mListContent = (ListView) v.findViewById(R.id.lv_content);
        mListChapter = (ListView) v.findViewById(R.id.lv_chapter);

        mTextLoadChap = (TextView) v.findViewById(R.id.tv_loadChap);
        mTextLoadPage = (TextView) v.findViewById(R.id.tv_loadPage);

        mTextLoadChap.setOnClickListener(this);
        mTextLoadPage.setOnClickListener(this);

        mLoadPageData = new LoadPageData();

    }

    private void loadChapterModel() {
        List<ChapterModel> ret = RealmUtils.with(getActivity()).getAllChapter();
        int i = -1;

        for (ChapterModel a : ret) {
            i++;
            chapter[i] = a.getShowName();
            mStoryId = a.getStoryId();
            mChapterNumber = a.getChapterNumber();
            mPageNumber = a.getPageNumber();
            mChapterName = a.getChapterName();
            mShowName = a.getShowName();
            mContent = a.getContent();
        }
        Log.d("III", "" + i);
    }

    private void setDataListView() {
//        mLoadPageData.requestData();

        StringBuilder stringBuilder = new StringBuilder("- ");
        stringBuilder.append(mContent);

        Fragment_1_Chapter_Adapter chapter_adapter =
                new Fragment_1_Chapter_Adapter(getActivity(), chapter);
        mListChapter.setAdapter(chapter_adapter);

        Fragment_1_Content_Adapter content_adapter =
                new Fragment_1_Content_Adapter(getActivity(), stringBuilder);
        mListContent.setAdapter(content_adapter);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id != 0) {
            switch (id) {
                case R.id.tv_loadChap:
                    loadChap();
                    break;
                case R.id.tv_loadPage:
                    loadPage();
                    break;
                default:
                    break;
            }

        }
    }

    private void loadPage() {

        final Dialog dialogLoadPage = new Dialog(getActivity());
        dialogLoadPage.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogLoadPage.setContentView(R.layout.dialog_loadpage);
        CheckBox checkBoxAll = (CheckBox) dialogLoadPage.findViewById(R.id.cb_all);
        final ListView listChap = (ListView) dialogLoadPage.findViewById(R.id.lv_listPage);
        Fragment_1_OnDialogLoadPage_Adapter adapter = new Fragment_1_OnDialogLoadPage_Adapter(
                getActivity(), mPageNumber);
        listChap.setAdapter(adapter);

        checkBoxAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox checkBoxItem = (CheckBox) listChap.findViewById(R.id.cb_checkChap);
                if (!checkBoxItem.isChecked()) {
                    checkBoxItem.setChecked(true);
                } else {
                    checkBoxItem.setChecked(false);
                }
            }
        });

        dialogLoadPage.show();
    }

    private void loadChap() {

        Dialog dialogLoadChap = new Dialog(getActivity());
        dialogLoadChap.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogLoadChap.setContentView(R.layout.dialog_loadchapter);

        ListView listChap = (ListView) dialogLoadChap.findViewById(R.id.lv_chapter);

        Fragment_1_OnDiaLogLoadChapter_Adapter adapter = new Fragment_1_OnDiaLogLoadChapter_Adapter(
                getActivity(), chapter);
        listChap.setAdapter(adapter);
        listChap.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        dialogLoadChap.show();

    }

}
