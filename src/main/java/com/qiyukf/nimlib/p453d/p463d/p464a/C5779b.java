package com.qiyukf.nimlib.p453d.p463d.p464a;

import android.text.TextUtils;
import com.qiyukf.nimlib.p453d.p454a.p456b.C5753a;

/* renamed from: com.qiyukf.nimlib.d.d.a.b */
public final class C5779b {
    /* renamed from: a */
    private String f18406a;
    /* renamed from: b */
    private String f18407b;
    /* renamed from: c */
    private String f18408c;

    public C5779b(String str, String str2, String str3) {
        this.f18406a = str;
        this.f18407b = str2;
        this.f18408c = str3;
    }

    /* renamed from: a */
    public final String mo28056a() {
        return this.f18406a;
    }

    /* renamed from: b */
    public final String mo28057b() {
        return this.f18407b;
    }

    /* renamed from: c */
    public final String mo28058c() {
        return this.f18408c;
    }

    /* renamed from: d */
    public final boolean mo28059d() {
        if (!TextUtils.isEmpty(this.f18406a)) {
            return true;
        }
        StringBuilder sb = new StringBuilder("invalid product info, p=");
        sb.append(toString());
        C5753a.m23146c(sb.toString());
        return false;
    }
}
