package com.tencent.stat;

public interface StatDispatchCallback {
    void onDispatchFailure();

    void onDispatchSuccess();
}
