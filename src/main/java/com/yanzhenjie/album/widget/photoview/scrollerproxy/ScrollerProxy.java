package com.yanzhenjie.album.widget.photoview.scrollerproxy;

import android.content.Context;
import android.os.Build.VERSION;

/* renamed from: com.yanzhenjie.album.widget.photoview.scrollerproxy.a */
public abstract class ScrollerProxy {
    /* renamed from: a */
    public abstract void mo37771a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

    /* renamed from: a */
    public abstract void mo37772a(boolean z);

    /* renamed from: a */
    public abstract boolean mo37773a();

    /* renamed from: b */
    public abstract boolean mo37774b();

    /* renamed from: c */
    public abstract int mo37775c();

    /* renamed from: d */
    public abstract int mo37776d();

    /* renamed from: a */
    public static ScrollerProxy m33740a(Context context) {
        if (VERSION.SDK_INT < 9) {
            return new PreGingerScroller(context);
        }
        if (VERSION.SDK_INT < 14) {
            return new GingerScroller(context);
        }
        return new IcsScroller(context);
    }
}
