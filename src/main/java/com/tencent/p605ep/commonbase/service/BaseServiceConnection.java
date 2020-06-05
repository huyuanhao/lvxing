package com.tencent.p605ep.commonbase.service;

/* renamed from: com.tencent.ep.commonbase.service.BaseServiceConnection */
public class BaseServiceConnection {
    private String key;
    public Class<?> mClass;

    public BaseServiceConnection(Class<?> cls) {
        this.mClass = cls;
    }

    public BaseServiceConnection(String str) {
        this.key = str;
    }

    public String getKey() {
        return this.key;
    }
}
