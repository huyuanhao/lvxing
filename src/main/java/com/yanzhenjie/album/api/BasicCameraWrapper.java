package com.yanzhenjie.album.api;

import android.content.Context;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.api.BasicCameraWrapper;

public abstract class BasicCameraWrapper<Returner extends BasicCameraWrapper> {
    /* renamed from: a */
    Context f26099a;
    /* renamed from: b */
    Action<String> f26100b;
    /* renamed from: c */
    Action<String> f26101c;
    /* renamed from: d */
    String f26102d;

    public BasicCameraWrapper(Context context) {
        this.f26099a = context;
    }

    /* renamed from: a */
    public final Returner mo37527a(Action<String> aVar) {
        this.f26100b = aVar;
        return this;
    }

    /* renamed from: a */
    public Returner mo37528a(String str) {
        this.f26102d = str;
        return this;
    }
}
