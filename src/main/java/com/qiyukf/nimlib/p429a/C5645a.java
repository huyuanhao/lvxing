package com.qiyukf.nimlib.p429a;

import android.text.TextUtils;
import com.qiyukf.nimlib.p473h.p481c.p483b.C5892b;
import com.qiyukf.nimlib.sdk.auth.OnlineClient;

/* renamed from: com.qiyukf.nimlib.a.a */
public final class C5645a implements OnlineClient {
    private static final long serialVersionUID = 1;
    /* renamed from: a */
    private int f18161a;
    /* renamed from: b */
    private String f18162b;
    /* renamed from: c */
    private int f18163c;
    /* renamed from: d */
    private String f18164d;
    /* renamed from: e */
    private String f18165e;
    /* renamed from: f */
    private String f18166f;

    /* renamed from: a */
    public static C5645a m22814a(C5892b bVar) {
        C5645a aVar = new C5645a();
        aVar.f18161a = bVar.mo28242b(3);
        aVar.f18162b = bVar.mo28239a(4);
        aVar.f18163c = bVar.mo28242b(109);
        aVar.f18164d = bVar.mo28239a(103);
        aVar.f18165e = bVar.mo28239a(102);
        aVar.f18166f = bVar.mo28239a(13);
        return aVar;
    }

    /* renamed from: a */
    public final String mo27834a() {
        return this.f18166f;
    }

    /* renamed from: a */
    public final void mo27835a(String str) {
        this.f18166f = str;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C5645a)) {
            return false;
        }
        return TextUtils.equals(this.f18166f, ((C5645a) obj).f18166f);
    }

    public final String getClientIp() {
        return this.f18164d;
    }

    public final int getClientType() {
        return this.f18161a;
    }

    public final int getLoginTime() {
        return this.f18163c;
    }

    public final String getOs() {
        return this.f18162b;
    }
}
