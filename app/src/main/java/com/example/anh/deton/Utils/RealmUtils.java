package com.example.anh.deton.Utils;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;

import com.example.anh.deton.Model.ChapterModel;
import com.example.anh.deton.Model.ConfigModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Anh on 9/27/2016.
 */
public class RealmUtils {
    private static RealmUtils instance;
    private final Realm realm;

    public RealmUtils(Application application) {
        realm = Realm.getDefaultInstance();
    }

    public static RealmUtils with(Fragment fragment) {

        if (instance == null) {
            instance = new RealmUtils(fragment.getActivity().getApplication());
        }
        return instance;
    }

    public static RealmUtils with(Activity activity) {

        if (instance == null) {
            instance = new RealmUtils(activity.getApplication());
        }
        return instance;
    }

    public static RealmUtils with(Application application) {

        if (instance == null) {
            instance = new RealmUtils(application);
        }
        return instance;
    }

    public static RealmUtils getInstance() {

        return instance;
    }

    public Realm getRealm() {

        return realm;
    }

    //Refresh the realm instance
    public void refresh() {
        realm.refresh();
    }

    // CONFIG CLASS

    public void clearConfig() {
        realm.beginTransaction();
        realm.clear(ConfigModel.class);
        realm.commitTransaction();
    }
    public boolean hasConfigs() {

        return !realm.allObjects(ConfigModel.class).isEmpty();
    }

    public RealmResults<ConfigModel> getall() {
        return realm.where(ConfigModel.class).findAll();
    }

    public ConfigModel getConfigItem() {
        if (this.hasConfigs()) {
            ConfigModel tmp = realm.where(ConfigModel.class).findFirst();
            if (tmp != null) {
                return tmp;
            } else {
                return null;
            }
        }
        return null;
    }

    public void saveConfigClass(ConfigModel item) {
        ConfigModel tmp = realm.where(ConfigModel.class).findFirst();
        if (tmp != null) {
            realm.beginTransaction();

            tmp.setFontSize(item.getFontSize());
            tmp.setCurrentChap(item.getCurrentChap());
            tmp.setLastPage(item.getLastPage());
            tmp.setLastChap(item.getLastChap());
            tmp.setArrPageLoaded(item.getArrPageLoaded());

            realm.commitTransaction();
        } else {
            realm.beginTransaction();
            realm.copyToRealm(item);
            realm.commitTransaction();
        }
    }


    // CHAPTER CLASS
    public List<ChapterModel> getAllChapter() {
        RealmResults<ChapterModel> listItem = realm.where(ChapterModel.class).findAll();
        List<ChapterModel> ret = new ArrayList<>();
        if (listItem.size() > 0) {
            ret.addAll(listItem.subList(0, listItem.size()));
        }
        return ret;
    }

    public void saveChapter(ChapterModel item){
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(item);
        realm.commitTransaction();
    }

    public ChapterModel getChapterById(String id) {
        ChapterModel item = realm.where(ChapterModel.class).equalTo("id", id).findFirst();
        if (item != null) {
            return item;
        }
        return null;
    }

    public ChapterModel getChapterByChapterNumber(String chapterNumber) {
        ChapterModel item = realm.where(ChapterModel.class).equalTo("chapterNumber", chapterNumber).findFirst();
        if (item != null) {
            return item;
        }
        return null;
    }

    public List<ChapterModel> getChapterByPageNumber(int pageNumber) {
        RealmResults<ChapterModel> listItem = realm.where(ChapterModel.class).contains("pageNumber", ""+pageNumber).findAll();
        List<ChapterModel> ret = new ArrayList<>();
        if (listItem.size() > 0) {
            ret.addAll(listItem.subList(0, listItem.size()));
        }
        return ret;
    }

    public void clearAllChapter() {
        realm.beginTransaction();
        realm.clear(ChapterModel.class);
        realm.commitTransaction();
    }

    public void deleteChapterById(String id) {
        ChapterModel item = realm.where(ChapterModel.class).equalTo("id", id).findFirst();
        if (item != null) {
            item.removeFromRealm();
        }
    }

    public void deleteChapterByPageNumber(int pageNumber) {
        RealmResults<ChapterModel> listItem = realm.where(ChapterModel.class).contains("pageNumber", ""+pageNumber).findAll();
        if (listItem.size() > 0) {
            listItem.removeAll(listItem);
        }
    }
}
