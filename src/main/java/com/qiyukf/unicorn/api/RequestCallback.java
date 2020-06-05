package com.qiyukf.unicorn.api;

public interface RequestCallback<T> {
    void onException(Throwable th);

    void onFailed(int i);

    void onSuccess(T t);
}
