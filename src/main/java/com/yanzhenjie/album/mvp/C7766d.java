package com.yanzhenjie.album.mvp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;

/* compiled from: Source */
/* renamed from: com.yanzhenjie.album.mvp.d */
abstract class C7766d<Host> {
    /* renamed from: a */
    private Host f26341a;

    /* compiled from: Source */
    /* renamed from: com.yanzhenjie.album.mvp.d$a */
    interface C7767a {
        /* renamed from: a */
        void mo37712a();

        /* renamed from: a */
        void mo37713a(MenuItem menuItem);
    }

    /* renamed from: a */
    public abstract void mo37681a();

    /* renamed from: a */
    public abstract void mo37682a(int i);

    /* renamed from: a */
    public abstract void mo37683a(Drawable drawable);

    /* renamed from: a */
    public abstract void mo37684a(Toolbar toolbar);

    /* renamed from: a */
    public abstract void mo37685a(C7767a aVar);

    /* renamed from: a */
    public abstract void mo37686a(CharSequence charSequence);

    /* renamed from: b */
    public abstract MenuInflater mo37687b();

    /* renamed from: b */
    public abstract void mo37688b(CharSequence charSequence);

    /* renamed from: c */
    public abstract Menu mo37689c();

    /* renamed from: d */
    public abstract Context mo37690d();

    /* renamed from: e */
    public abstract void mo37691e();

    public C7766d(Host host) {
        this.f26341a = host;
    }

    /* renamed from: f */
    public Host mo37714f() {
        return this.f26341a;
    }
}
