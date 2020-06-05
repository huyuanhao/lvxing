package com.tencent.mid.api;

public interface MidCallback {
    void onFail(int i, String str);

    void onSuccess(Object obj);
}
