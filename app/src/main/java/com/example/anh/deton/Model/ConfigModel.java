package com.example.anh.deton.Model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Anh on 9/28/2016.
 */
public class ConfigModel extends RealmObject {

    @PrimaryKey
    private int id;
    private int lastPage;
    private int lastChap;
    private int currentChap;
    private int fontSize;
    private RealmList<PageNumberModel> arrPageLoaded;

    public ConfigModel() {
        this.id = -1;
        this.lastPage = -1;
        this.arrPageLoaded = null;
        this.lastChap = -1;
        this.currentChap = -1;
        this.fontSize = -1;
    }

    public ConfigModel(int id, int lastPage, RealmList<PageNumberModel> arrPageLoaded, int lastChap, int currentChap, int fontSize) {
        this.id = id;
        this.lastPage = lastPage;
        this.arrPageLoaded = arrPageLoaded;
        this.lastChap = lastChap;
        this.currentChap = currentChap;
        this.fontSize = fontSize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RealmList<PageNumberModel> getArrPageLoaded() {
        return arrPageLoaded;
    }

    public void setArrPageLoaded(RealmList<PageNumberModel> arrPageLoaded) {
        this.arrPageLoaded = arrPageLoaded;
    }

    public int getLastPage() {
        return lastPage;
    }

    public int getLastChap() {
        return lastChap;
    }

    public int getFontSize() {
        return fontSize;
    }

    public int getCurrentChap() {
        return currentChap;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public void setLastChap(int lastChap) {
        this.lastChap = lastChap;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public void setCurrentChap(int currentChap) {
        this.currentChap = currentChap;
    }

}
