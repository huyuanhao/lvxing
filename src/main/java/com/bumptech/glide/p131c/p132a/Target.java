package com.bumptech.glide.p131c.p132a;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.p131c.Request;
import com.bumptech.glide.p131c.p133b.Transition;

/* renamed from: com.bumptech.glide.c.a.h */
public interface Target<R> extends LifecycleListener {
    Request getRequest();

    void getSize(SizeReadyCallback gVar);

    void onLoadCleared(Drawable drawable);

    void onLoadFailed(Drawable drawable);

    void onLoadStarted(Drawable drawable);

    void onResourceReady(R r, Transition<? super R> fVar);

    void removeCallback(SizeReadyCallback gVar);

    void setRequest(Request cVar);
}
