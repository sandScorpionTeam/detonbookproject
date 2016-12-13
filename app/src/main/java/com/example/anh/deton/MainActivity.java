package com.example.anh.deton;

import android.app.FragmentManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.widget.ListView;

import com.example.anh.deton.Activity.LoadInitData;
import com.example.anh.deton.Activity.LoadPageData;
import com.example.anh.deton.Fragment_Navigation.Fragment_1;
import com.example.anh.deton.Fragment_Navigation.Fragment_2;
import com.example.anh.deton.Fragment_Navigation.Fragment_3;
import com.example.anh.deton.Fragment_Navigation.Fragment_4;
import com.example.anh.deton.Model.ConfigModel;
import com.example.anh.deton.Navigation.NavigationDrawerFragment;
import com.example.anh.deton.Utils.RealmUtils;

import io.realm.Realm;


public class MainActivity extends ActionBarActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    public LoadInitData loaddata;
    public LoadPageData loadpageData;
    private Realm realm;
    // Navigation
    private NavigationDrawerFragment mNavigationDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        setUpNavigation();
        init();

    }

    private void setUpNavigation() {
        try {
            //
            mNavigationDrawerFragment = (NavigationDrawerFragment)
                    getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);

            setTitleColor(Color.WHITE);
            // Set up the drawer.
            mNavigationDrawerFragment.setUp(
                    R.id.navigation_drawer,
                    (DrawerLayout) findViewById(R.id.drawer_layout));

        } catch (Exception ex) {
            ex.toString();
        }
    }

    private void init() {
        // initialize
        // setup realm and config
        this.realm = RealmUtils.with(this).getRealm();
        RealmUtils.with(this).refresh();
        if (RealmUtils.with(this).hasConfigs() == false) {
            setInitConfig();
        }

//        ChapterModel chap = new ChapterModel();
//        chap.setId(1);
//        chap.setShowName(getResources().getString(R.string.story_content));
//
//        realm.beginTransaction();
//        realm.copyToRealmOrUpdate(chap);
//        realm.commitTransaction();

        loaddata = new LoadInitData();
        loaddata.loadData();

//        LoadPageData a = new LoadPageData();
//        a.loadData(1,"");
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

    @Override
    public void setTitleColor(int textColor) {
        super.setTitleColor(textColor);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        Fragment_1 fragment_1 = null;
        Fragment_2 fragment_2 = null;
        Fragment_3 fragment_3 = null;
        Fragment_4 fragment_4 = null;
        switch (position) {
            case 0:
                fragment_1 = new Fragment_1();
                break;
            case 1:
                fragment_2 = new Fragment_2();
                break;
            case 2:
                fragment_3 = new Fragment_3();
                break;
            case 3:
                fragment_4 = new Fragment_4();
                break;
            default:
                break;

        }
        FragmentManager fm = getFragmentManager();
        if (fragment_1 != null) {
            fm.beginTransaction().replace(R.id.container, fragment_1).commit();
            getSupportActionBar().setTitle(Html.fromHtml("<font color = \"#FFFFFF\"> Fragment 1 </font>"));
        } else {
            //TODO nothing
        }
        if (fragment_2 != null) {
            fm.beginTransaction().replace(R.id.container, fragment_2).commit();
            getSupportActionBar().setTitle(Html.fromHtml("<font color = \"#FFFFFF\"> Fragment 2 </font>"));
        } else {
            //TODO nothing
        }
        if (fragment_3 != null) {
            fm.beginTransaction().replace(R.id.container, fragment_3).commit();
            getSupportActionBar().setTitle(Html.fromHtml("<font color = \"#FFFFFF\"> Fragment 3 </font>"));
        } else {
            //TODO nothing
        }
        if (fragment_4 != null) {
            fm.beginTransaction().replace(R.id.container, fragment_4).commit();
            getSupportActionBar().setTitle(Html.fromHtml("<font color = \"#FFFFFF\"> Fragment 4 </font>"));
        } else {
            //TODO nothing
        }

    }
}
