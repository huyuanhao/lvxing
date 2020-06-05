package com.tmsdk.module.coin;

import android.os.Bundle;

public class AdConfig implements Cloneable {
    private int mTaskType;
    private String sceneId;
    /* renamed from: t */
    private BUSINESS f25862t;
    /* renamed from: u */
    private Bundle f25863u;

    /* renamed from: com.tmsdk.module.coin.AdConfig$AD_KEY */
    public enum AD_KEY {
        AD_NUM,
        AD_CHANNEL_NO
    }

    /* renamed from: com.tmsdk.module.coin.AdConfig$BUSINESS */
    public enum BUSINESS {
        COIN_DOWNLOAD_APP_AD,
        COIN_DOWNLOAD_GAME_AD,
        COIN_CARD_GIVE,
        COIN_VIDEO_EXIT,
        COIN_FEED_EXIT,
        COIN_SCROLL_EXIT,
        COIN_BANNER_EXIT,
        COIN_TIPS_EXIT,
        COIN_SPLASH_EXIT,
        COIN_PUBLIC_EXIT,
        COIN_SLASH_VIDEO
    }

    public AdConfig(int i, Bundle bundle) {
        this.mTaskType = i;
        this.f25863u = bundle;
    }

    public AdConfig(BUSINESS business, Bundle bundle) {
        this(business, "0000", bundle);
    }

    public AdConfig(BUSINESS business, String str, Bundle bundle) {
        this.f25862t = business;
        this.sceneId = str;
        this.f25863u = bundle;
    }

    public BUSINESS getBusiness() {
        return this.f25862t;
    }

    public Bundle getOtherInput() {
        return this.f25863u;
    }

    public String getSceneId() {
        return this.sceneId;
    }

    public int getTaskType() {
        return this.mTaskType;
    }

    public void setSceneId(String str) {
        this.sceneId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Business:[");
        sb2.append(this.f25862t);
        String str = "]";
        sb2.append(str);
        sb.append(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("OtherInput:[");
        sb3.append(this.f25863u);
        sb3.append(str);
        sb.append(sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("mTaskType:[");
        sb4.append(this.mTaskType);
        sb4.append(str);
        sb.append(sb4.toString());
        return sb.toString();
    }
}
