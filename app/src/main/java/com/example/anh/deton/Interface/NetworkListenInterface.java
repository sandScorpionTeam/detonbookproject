package com.example.anh.deton.Interface;

import org.jsoup.nodes.Document;

/**
 * Created by Anh on 9/20/2016.
 */
public interface NetworkListenInterface {
    public void onSuccess(Document doc);
    public void onError(String errorMessage);
}
