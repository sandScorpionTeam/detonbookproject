package com.example.anh.deton.Activity;

import android.app.Activity;

import com.example.anh.deton.Adapter.NetworkAdapter;
import com.example.anh.deton.Global.Constant;
import com.example.anh.deton.Interface.NetworkListenInterface;
import com.example.anh.deton.Model.ConfigModel;
import com.example.anh.deton.Model.PageNumberModel;
import com.example.anh.deton.Utils.RealmUtils;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import io.realm.Realm;

/**
 * Created by Anh on 9/20/2016.
 */
public class LoadInitData extends Activity implements NetworkListenInterface {
    private NetworkAdapter network;

    public LoadInitData() {
        network = new NetworkAdapter();
    }

    public void loadData() {
        network = NetworkAdapter.getInstance();
        network.setNetworkListener(this);
//        network.RequestData(Constant.URL_WEBTRUYEN);
        network.RequestData("http://webtruyen.com/de-ton/hang-phuc-yeu-vuong_324049.html");
    }

    public void updateNewConfig(Document doc) {
        checkAndUpdatePage(doc);
        checkAndUpdateNewChapter(doc);
    }

    public void checkAndUpdatePage(Document doc) {
        // find last page
        int newLastPage = 0;

        Element classElement = doc.getElementsByAttributeValue("class", "w3-pagination paging").first();
        Elements arrLinks = classElement.getElementsByAttribute("href");

        Element lastElement = arrLinks.last();
        String str = lastElement.attr("href");

        if (str.contains(Constant.URL_WEBTRUYEN)) {
            str = str.replace(Constant.URL_WEBTRUYEN, "");
            str = str.replace("/","");
            newLastPage = Integer.parseInt(str);
        }

        if (RealmUtils.with(this).hasConfigs() != false ) {
            ConfigModel config = RealmUtils.with(this).getConfigItem();
            int lastPage = config.getLastPage();
            if (newLastPage > lastPage) {
                Realm realm = RealmUtils.with(this).getRealm();

                // set last page
                realm.beginTransaction();
                config.setLastPage(newLastPage);
                realm.commitTransaction();

                // set all page of story
                realm.beginTransaction();
                for (int i=lastPage; i <= newLastPage; i++) {
                    PageNumberModel tmp;
                    if (i == 0) {
                        tmp = new PageNumberModel(false,i,"");
                    }
                    else {
                        tmp = new PageNumberModel(false, i, "" + i + "/");
                    }
                    config.getArrPageLoaded().add(tmp);
                }
                realm.commitTransaction();
            }
        }
    }

    public void checkAndUpdateNewChapter(Document doc) {
        // find update link
        Element classElement = doc.getElementsByAttributeValue("class", "list-chapter").first();

        Elements linkUpdate = classElement.getElementsByTag("ul");
        linkUpdate = linkUpdate.first().getElementsByAttribute("href");

        for  (Element i : linkUpdate) {
            String strtmp = i.attr("href");
            System.out.println("--------" + strtmp);
        }

        // to do update view of fragment Update
    }

    @Override
    public void onSuccess(Document doc) {
        updateNewConfig(doc);
    }

    @Override
    public void onError(String errorMessage) {

    }
}
