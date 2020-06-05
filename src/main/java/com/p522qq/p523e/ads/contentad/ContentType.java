package com.p522qq.p523e.ads.contentad;

/* renamed from: com.qq.e.ads.contentad.ContentType */
public enum ContentType {
    ARTICLE,
    VIDEO;

    public static ContentType fromString(String str) {
        if ("article".equals(str)) {
            return ARTICLE;
        }
        if ("video".equals(str)) {
            return VIDEO;
        }
        return null;
    }
}
