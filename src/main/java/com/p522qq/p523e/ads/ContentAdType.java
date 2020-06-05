package com.p522qq.p523e.ads;

/* renamed from: com.qq.e.ads.ContentAdType */
public enum ContentAdType {
    AD,
    INFORMATION;

    public static ContentAdType fromString(String str) {
        if ("ad".equals(str)) {
            return AD;
        }
        if ("information".equals(str)) {
            return INFORMATION;
        }
        return null;
    }
}
