package com.example.anh.deton.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Anh on 9/27/2016.
 */
public class ChapterModel extends RealmObject {
    @PrimaryKey
    private String id;
    private int storyId;
    private String chapterNumber;
    private int pageNumber;
    private String chapterName;
    private String showName;
    private String content;

    public  ChapterModel() {
        this.id = "";
        this.storyId = -1;
        this.chapterNumber = "";
        this.pageNumber = -1;
        this.chapterName = "";
        this.showName = "";
        this.content = "";
    }

    public ChapterModel(String id, int storyId, String chapterNumber, int pageNumber, String chapterName, String showName, String content) {
        this.id = id;
        this.storyId = storyId;
        this.chapterNumber = chapterNumber;
        this.pageNumber = pageNumber;
        this.chapterName = chapterName;
        this.showName = showName;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChapterName() {
        return chapterName;
    }

    public String getChapterNumber() {
        return chapterNumber;
    }

    public String getShowName() {
        return showName;
    }

    public int getStoryId() {
        return storyId;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public void setChapterNumber(String chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }
}
