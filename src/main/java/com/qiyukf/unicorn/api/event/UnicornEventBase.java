package com.qiyukf.unicorn.api.event;

import android.content.Context;

public interface UnicornEventBase<T> {
    void onEvent(T t, Context context, EventCallback<T> eventCallback);
}
