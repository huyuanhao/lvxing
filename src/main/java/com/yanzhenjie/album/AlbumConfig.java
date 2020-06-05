package com.yanzhenjie.album;

import android.content.Context;
import java.util.Locale;

/* renamed from: com.yanzhenjie.album.b */
public class AlbumConfig {
    /* renamed from: a */
    private AlbumLoader f26323a;
    /* renamed from: b */
    private Locale f26324b;

    /* compiled from: AlbumConfig */
    /* renamed from: com.yanzhenjie.album.b$a */
    public static final class C7761a {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public AlbumLoader f26325a;
        /* access modifiers changed from: private */
        /* renamed from: b */
        public Locale f26326b;

        private C7761a(Context context) {
        }

        /* renamed from: a */
        public C7761a mo37675a(AlbumLoader cVar) {
            this.f26325a = cVar;
            return this;
        }

        /* renamed from: a */
        public AlbumConfig mo37676a() {
            return new AlbumConfig(this);
        }
    }

    /* renamed from: a */
    public static C7761a m33528a(Context context) {
        return new C7761a(context);
    }

    private AlbumConfig(C7761a aVar) {
        this.f26323a = aVar.f26325a == null ? AlbumLoader.f26327a : aVar.f26325a;
        this.f26324b = aVar.f26326b == null ? Locale.getDefault() : aVar.f26326b;
    }

    /* renamed from: a */
    public AlbumLoader mo37673a() {
        return this.f26323a;
    }

    /* renamed from: b */
    public Locale mo37674b() {
        return this.f26324b;
    }
}
