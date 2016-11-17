package com.example.anh.deton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.anh.deton.Activity.LoadInitData;
import com.example.anh.deton.Activity.LoadPageData;
import com.example.anh.deton.Model.ConfigModel;
import com.example.anh.deton.Utils.RealmUtils;

import io.realm.Realm;


public class MainActivity extends AppCompatActivity {

    public LoadInitData loaddata;
    public LoadPageData loadpageData;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize

        // setup realm and config
        this.realm = RealmUtils.with(this).getRealm();
        RealmUtils.with(this).refresh();
        if (RealmUtils.with(this).hasConfigs() == false ) {
            setInitConfig();
        }

//        ChapterModel chap = new ChapterModel();
//        chap.setId(1);
//        chap.setShowName(getResources().getString(R.string.story_content));
//
//        realm.beginTransaction();
//        realm.copyToRealmOrUpdate(chap);
//        realm.commitTransaction();

        // custom
        init();
    }

    void init() {

        LoadPageData a = new LoadPageData();
        a.loadData(1,"");
    }

    private void setInitConfig() {

        ConfigModel config = new ConfigModel();
        config.setId(1);
        config.setFontSize(20);
        config.setCurrentChap(0);
        config.setLastPage(0);
        config.setLastChap(0);

        realm.beginTransaction();
        realm.copyToRealmOrUpdate(config);
        realm.commitTransaction();
    }
}
