package com.oasisfeng.condom.util;

public abstract class Lazy<T> {
    private T mInstance;

    public abstract T create();

    public final T get() {
        T t;
        synchronized (this) {
            if (this.mInstance != null) {
                t = this.mInstance;
            } else {
                t = create();
                this.mInstance = t;
            }
        }
        return t;
    }
}
