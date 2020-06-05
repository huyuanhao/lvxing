package com.bumptech.glide.p131c.p132a;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.p131c.Request;

@Deprecated
/* renamed from: com.bumptech.glide.c.a.a */
public abstract class BaseTarget<Z> implements Target<Z> {
    private Request request;

    public void onDestroy() {
    }

    public void onLoadCleared(Drawable drawable) {
    }

    public void onLoadFailed(Drawable drawable) {
    }

    public void onLoadStarted(Drawable drawable) {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void setRequest(Request cVar) {
        this.request = cVar;
    }

    public Request getRequest() {
        return this.request;
    }
}
