package com.yanzhenjie.album.widget.photoview.scrollerproxy;

import android.content.Context;
import android.widget.Scroller;

public class PreGingerScroller extends ScrollerProxy {
    /* renamed from: a */
    private final Scroller f26414a;

    public PreGingerScroller(Context context) {
        this.f26414a = new Scroller(context);
    }

    /* renamed from: a */
    public boolean mo37773a() {
        return this.f26414a.computeScrollOffset();
    }

    /* renamed from: a */
    public void mo37771a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f26414a.fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    /* renamed from: a */
    public void mo37772a(boolean z) {
        this.f26414a.forceFinished(z);
    }

    /* renamed from: b */
    public boolean mo37774b() {
        return this.f26414a.isFinished();
    }

    /* renamed from: c */
    public int mo37775c() {
        return this.f26414a.getCurrX();
    }

    /* renamed from: d */
    public int mo37776d() {
        return this.f26414a.getCurrY();
    }
}
