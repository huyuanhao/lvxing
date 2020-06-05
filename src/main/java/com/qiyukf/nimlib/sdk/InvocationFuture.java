package com.qiyukf.nimlib.sdk;

import com.qiyukf.unicorn.api.RequestCallback;

public interface InvocationFuture<T> {
    void setCallback(RequestCallback<T> requestCallback);
}
