package com.qiyukf.nimlib.sdk;

import com.qiyukf.unicorn.api.RequestCallback;

public abstract class RequestCallbackWrapper<T> implements RequestCallback<T> {
    public void onException(Throwable th) {
        onResult(1000, null, th);
    }

    public void onFailed(int i) {
        onResult(i, null, null);
    }

    public abstract void onResult(int i, T t, Throwable th);

    public void onSuccess(T t) {
        onResult(200, t, null);
    }
}
