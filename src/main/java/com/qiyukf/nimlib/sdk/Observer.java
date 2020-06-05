package com.qiyukf.nimlib.sdk;

import java.io.Serializable;

public interface Observer<T> extends Serializable {
    void onEvent(T t);
}
