package com.qiyukf.unicorn.api.event;

public interface EventCallback<T> {
    void onInterceptEvent();

    void onNotPorcessEvent();

    void onPorcessEventError();

    void onProcessEventSuccess(T t);
}
