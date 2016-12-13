package com.example.anh.deton.Activity;

import android.app.Activity;

import com.example.anh.deton.Adapter.NetworkAdapter;
import com.example.anh.deton.Global.Constant;
import com.example.anh.deton.Interface.NetworkListenInterface;
import com.example.anh.deton.Model.ChapterModel;
import com.example.anh.deton.Utils.RealmUtils;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.Objects;

/**
 * Created by Anh on 9/27/2016.
 */
public class LoadPageData extends Activity implements NetworkListenInterface {
    private NetworkAdapter network;
    private Elements listChap = null;
    private int count = 0;
    private String link = "";
    private int pageNum = -1;
    private String mChapter = "";

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Elements getListChap() {
        return listChap;
    }

    public void setListChap(Elements listChap) {
        this.listChap = listChap;
    }

    public LoadPageData() {
        this.network = new NetworkAdapter();
    }

    public String getChapter(){
        return mChapter;
    }

    public void loadData(int pageNum,String url) {
        network = NetworkAdapter.getInstance();
        network.setNetworkListener(this);

        this.setPageNum(pageNum);
        this.setLink(url);

        network.RequestData(Constant.URL_WEBTRUYEN + url);
    }

    public void handleData(Document doc) {
        // get element contain list chap
        Element classChapter = doc.getElementsByAttributeValue("class", "list-chapter").last();
        setListChap(classChapter.getElementsByTag("ul").first().getElementsByAttribute("href"));

        if (getListChap().size() > 0) {
            setCount(getCount() + 1);
            network.RequestDataWithCallBack(getListChap().get(0).attr("href"),"receiveChapter");
        }

    }
    public void requestData(){
        if (getCount() <= getListChap().size()) {

            // call next link chapter
            network.RequestDataWithCallBack(getListChap().get(getCount()-1).attr("href"),"receiveChapter");
        }
        else {
            List<ChapterModel> abcd =  RealmUtils.with(this).getAllChapter();
            for(ChapterModel i: abcd) {
                mChapter = i.getShowName();
                System.out.println("---------->" + mChapter);
            }
        }
    }
    public void receiveChapter(Document doc) {
        // to do save chapter item
        saveEachChapter(doc);

        // inc current item that will load.
        setCount(getCount() + 1);

        requestData();
    }

    public void saveEachChapter(Document doc) {
        // find class title
        Element classElement = doc.getElementsByAttributeValue("class", "w3-ul").first();
        // find tag title
        classElement = classElement.getElementsByTag("h3").first();
        // find chapterNumber
        Element eleTag1 = classElement.getElementsByTag("b").first();
        // find content
        Element content = doc.getElementById("content");

        ChapterModel chapItem = new ChapterModel();
        chapItem.setId(this.getPageNum() + "P" + getCount());
        chapItem.setStoryId(Constant.STORYID);
//        chapItem.setChapterNumber(eleTag1.text());
        chapItem.setPageNumber(this.getPageNum());
        chapItem.setChapterName(classElement.text());
        chapItem.setShowName(classElement.text());
        chapItem.setContent(content.text());

        RealmUtils.with(this).saveChapter(chapItem);
    }

    @Override
    public void onSuccess(Document doc) {
        handleData(doc);
    }

    @Override
    public void onError(String errorMessage) {

    }
}
