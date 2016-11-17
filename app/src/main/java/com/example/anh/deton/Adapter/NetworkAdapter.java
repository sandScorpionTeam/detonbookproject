package com.example.anh.deton.Adapter;

import android.os.AsyncTask;
import android.util.Log;

import com.example.anh.deton.Interface.NetworkListenInterface;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.lang.reflect.Method;

/**
 * Created by Anh on 9/19/2016.
 */
public class NetworkAdapter {

    private static NetworkListenInterface interfaceNetwork = null; // current activity
    private static NetworkAdapter instance = null;
    private static String callbackFunction = null;

    public String getCallbackFunction() {
        return this.callbackFunction;
    }

    public void setCallbackFunction(String callbackFunction) {
        if (this.callbackFunction == null) {
            this.callbackFunction = new String(callbackFunction);
        }
        else {
            this.callbackFunction = callbackFunction;
        }
    }

    public NetworkAdapter() {

    }

    public static NetworkAdapter getInstance() {
        if (instance == null) {
            instance = new NetworkAdapter();
        }
        return instance;
    }

    public void setNetworkListener(NetworkListenInterface interfaceNetwork) {
        this.interfaceNetwork = interfaceNetwork;
    }

    public NetworkListenInterface getNetworkListener() {
        return this.interfaceNetwork;
    }

    public void RequestData(String url) {
        setCallbackFunction("");
        DownloadTask download = new DownloadTask();
        download.execute(url);
    }

    public void RequestDataWithCallBack(String url, String callbackfunction) {
        setCallbackFunction(callbackfunction);
        DownloadTask download = new DownloadTask();
        download.execute(url);
    }

    public void ResponseData(Document doc, boolean isSuccess) {
        if ((getCallbackFunction() != null) && (!getCallbackFunction().equalsIgnoreCase(""))) {
            try {
                Method m = this.getNetworkListener().getClass().getDeclaredMethod(this.getCallbackFunction(), doc.getClass());
                m.setAccessible(true);
                m.invoke(this.getNetworkListener(), doc);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else {
            if (isSuccess) {
                this.getNetworkListener().onSuccess(doc);
            } else {
                this.getNetworkListener().onError("Cannot Connect To Server");
            }
        }
    }

    static class DownloadTask extends AsyncTask<String, Void, Document> {

        @Override
        protected Document doInBackground(String... params) {

            Document doc = null;
            try {

                Connection conn = Jsoup.connect(params[0]);
                doc = conn.get();

            } catch (Exception a) {
                return null;
            }
            return doc;
        }

        @Override
        protected void onPostExecute(Document document) {
            NetworkAdapter network = NetworkAdapter.getInstance();
            if (document == null) {
                network.ResponseData(document, false);
            } else {
                network.ResponseData(document, true);
            }
        }
    }
}
