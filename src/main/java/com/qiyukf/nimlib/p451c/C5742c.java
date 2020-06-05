package com.qiyukf.nimlib.p451c;

import android.content.Context;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.nimlib.C5718b;
import com.qiyukf.unicorn.api.Unicorn;

/* renamed from: com.qiyukf.nimlib.c.c */
public final class C5742c {
    /* renamed from: b */
    private static C5742c f18306b = new C5742c();
    /* renamed from: a */
    private C5730a f18307a;

    /* renamed from: a */
    public static C5742c m23101a() {
        return f18306b;
    }

    /* renamed from: a */
    public final synchronized boolean mo28015a(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(C5718b.m23020g());
        sb.append("/");
        sb.append(str);
        String sb2 = sb.toString();
        String str2 = C5718b.m23017d().databaseEncryptKey;
        if (this.f18307a == null || !this.f18307a.mo27982b()) {
            this.f18307a = new C5730a(context, sb2);
        }
        return mo28016b();
    }

    /* renamed from: b */
    public final boolean mo28016b() {
        C5730a aVar = this.f18307a;
        return aVar != null && aVar.mo27982b();
    }

    /* renamed from: c */
    public final synchronized void mo28017c() {
        if (this.f18307a != null) {
            this.f18307a.mo27983c();
            this.f18307a = null;
        }
    }

    /* renamed from: d */
    public final C5730a mo28018d() {
        C5730a aVar = this.f18307a;
        if (aVar != null) {
            return aVar;
        }
        String str = "MsgDatabase is not opened. Please login first!";
        C5264a.m21617a(str, String.valueOf(Unicorn.isServiceAvailable()));
        throw new IllegalStateException(str);
    }
}
