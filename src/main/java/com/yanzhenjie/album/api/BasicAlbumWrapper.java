package com.yanzhenjie.album.api;

import android.content.Context;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.api.BasicAlbumWrapper;
import com.yanzhenjie.album.api.widget.Widget;

/* renamed from: com.yanzhenjie.album.api.a */
public abstract class BasicAlbumWrapper<Returner extends BasicAlbumWrapper, Result, Cancel, Checked> {
    /* renamed from: a */
    final Context f26108a;
    /* renamed from: b */
    Action<Result> f26109b;
    /* renamed from: c */
    Action<Cancel> f26110c;
    /* renamed from: d */
    Widget f26111d;

    BasicAlbumWrapper(Context context) {
        this.f26108a = context;
        this.f26111d = Widget.m33305b(context);
    }

    /* renamed from: a */
    public final Returner mo37535a(Action<Result> aVar) {
        this.f26109b = aVar;
        return this;
    }
}
