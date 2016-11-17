package com.example.anh.deton.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Anh on 9/29/2016.
 */
public class PageNumberModel extends RealmObject {
    @PrimaryKey
    private int pageNumber;
    private String link;
    private boolean isloaded;

    public boolean isloaded() {
        return isloaded;
    }

    public void setIsloaded(boolean isloaded) {
        this.isloaded = isloaded;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public PageNumberModel(boolean isloaded, int pageNumber, String link) {
        this.isloaded = isloaded;
        this.pageNumber = pageNumber;
        this.link = link;
    }

    public PageNumberModel() {
        this.pageNumber = -1;
        this.isloaded = false;
        this.link = "";
    }
}
