package com.p530ss.android.p531a.p532a.p536c;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;

/* renamed from: com.ss.android.a.a.c.c */
public class DownloadAlertDialogInfo {
    /* renamed from: a */
    public Context f21054a;
    /* renamed from: b */
    public String f21055b;
    /* renamed from: c */
    public String f21056c;
    /* renamed from: d */
    public String f21057d;
    /* renamed from: e */
    public String f21058e;
    /* renamed from: f */
    public boolean f21059f;
    /* renamed from: g */
    public Drawable f21060g;
    /* renamed from: h */
    public C6517b f21061h;
    /* renamed from: i */
    public View f21062i;
    /* renamed from: j */
    public int f21063j;

    /* compiled from: DownloadAlertDialogInfo */
    /* renamed from: com.ss.android.a.a.c.c$a */
    public static final class C6516a {
        /* renamed from: a */
        public View f21064a;
        /* renamed from: b */
        public int f21065b;
        /* access modifiers changed from: private */
        /* renamed from: c */
        public Context f21066c;
        /* access modifiers changed from: private */
        /* renamed from: d */
        public String f21067d;
        /* access modifiers changed from: private */
        /* renamed from: e */
        public String f21068e;
        /* access modifiers changed from: private */
        /* renamed from: f */
        public String f21069f;
        /* access modifiers changed from: private */
        /* renamed from: g */
        public String f21070g;
        /* access modifiers changed from: private */
        /* renamed from: h */
        public boolean f21071h;
        /* access modifiers changed from: private */
        /* renamed from: i */
        public Drawable f21072i;
        /* access modifiers changed from: private */
        /* renamed from: j */
        public C6517b f21073j;

        public C6516a(Context context) {
            this.f21066c = context;
        }

        /* renamed from: a */
        public C6516a mo31110a(String str) {
            this.f21067d = str;
            return this;
        }

        /* renamed from: b */
        public C6516a mo31113b(String str) {
            this.f21068e = str;
            return this;
        }

        /* renamed from: c */
        public C6516a mo31114c(String str) {
            this.f21069f = str;
            return this;
        }

        /* renamed from: d */
        public C6516a mo31115d(String str) {
            this.f21070g = str;
            return this;
        }

        /* renamed from: a */
        public C6516a mo31111a(boolean z) {
            this.f21071h = z;
            return this;
        }

        /* renamed from: a */
        public C6516a mo31108a(Drawable drawable) {
            this.f21072i = drawable;
            return this;
        }

        /* renamed from: a */
        public C6516a mo31109a(C6517b bVar) {
            this.f21073j = bVar;
            return this;
        }

        /* renamed from: a */
        public C6516a mo31107a(int i) {
            this.f21065b = i;
            return this;
        }

        /* renamed from: a */
        public DownloadAlertDialogInfo mo31112a() {
            return new DownloadAlertDialogInfo(this);
        }
    }

    /* compiled from: DownloadAlertDialogInfo */
    /* renamed from: com.ss.android.a.a.c.c$b */
    public interface C6517b {
        /* renamed from: a */
        void mo31116a(DialogInterface dialogInterface);

        /* renamed from: b */
        void mo31117b(DialogInterface dialogInterface);

        /* renamed from: c */
        void mo31118c(DialogInterface dialogInterface);
    }

    private DownloadAlertDialogInfo(C6516a aVar) {
        this.f21059f = true;
        this.f21054a = aVar.f21066c;
        this.f21055b = aVar.f21067d;
        this.f21056c = aVar.f21068e;
        this.f21057d = aVar.f21069f;
        this.f21058e = aVar.f21070g;
        this.f21059f = aVar.f21071h;
        this.f21060g = aVar.f21072i;
        this.f21061h = aVar.f21073j;
        this.f21062i = aVar.f21064a;
        this.f21063j = aVar.f21065b;
    }
}
