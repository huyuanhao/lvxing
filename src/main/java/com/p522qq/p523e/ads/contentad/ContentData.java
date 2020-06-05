package com.p522qq.p523e.ads.contentad;

import android.view.View;
import java.util.List;

/* renamed from: com.qq.e.ads.contentad.ContentData */
public interface ContentData extends ContentAdData {
    ContentType getContentType();

    String getElapseTime();

    String getFrom();

    List<String> getImages();

    String getLabel();

    int getPlayCount();

    long getPostTime();

    long getPv();

    int getRuntime();

    String getTitle();

    int getcommentNum();

    boolean isBigPic();

    void onClick(View view);

    void onExpouse(View view);
}
