package com.bumptech.glide.load.engine;

/* renamed from: com.bumptech.glide.load.engine.u */
public interface Resource<Z> {
    Z get();

    Class<Z> getResourceClass();

    int getSize();

    void recycle();
}
