package com.ali.auth.third.p016a.p019c;

import android.app.Activity;
import android.text.TextUtils;
import com.ali.auth.third.core.broadcast.LoginAction;
import com.ali.auth.third.core.model.C1025f;
import com.ali.auth.third.core.model.C1026g;
import com.ali.auth.third.core.model.C1029j;
import com.ali.auth.third.core.p023b.C0985c;
import com.ali.auth.third.core.p024c.C0989a;
import com.ali.auth.third.core.p027f.C0999a;
import com.ali.auth.third.core.p027f.C1000b;
import com.ali.auth.third.core.p030h.C1015e;
import com.ali.auth.third.core.p032i.C1016a;
import com.ali.auth.third.core.p033j.C1018a;
import com.ali.auth.third.core.util.C1034a;
import com.ali.auth.third.core.util.C1041f;
import com.ali.auth.third.p016a.C0955a;
import com.ali.auth.third.p016a.C0976d;
import java.util.HashMap;

/* renamed from: com.ali.auth.third.a.c.c */
public class C0968c extends C1016a<String, Void, Void> {
    /* renamed from: a */
    protected boolean f1851a = false;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public C0985c f1852b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public Activity f1853c;

    public C0968c(Activity activity, C0985c cVar, boolean z) {
        this.f1853c = activity;
        this.f1852b = cVar;
        this.f1851a = true;
    }

    /* renamed from: a */
    private void m1832a(final int i, final String str) {
        C0989a.f1901p.mo10335a(new Runnable() {
            public void run() {
                HashMap hashMap = new HashMap();
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                sb.append("");
                hashMap.put("code", sb.toString());
                if (!TextUtils.isEmpty(str)) {
                    hashMap.put("message", str);
                }
                ((C1015e) C0989a.m1882a(C1015e.class)).mo10356a(C0976d.f1868c, hashMap);
                if (C0968c.this.f1852b != null) {
                    C0968c.this.f1852b.mo10305a(i, str);
                }
            }
        });
    }

    /* renamed from: b */
    private void m1834b() {
        C0989a.f1901p.mo10335a(new Runnable() {
            public void run() {
                if (C0968c.this.f1852b != null) {
                    C0968c.this.f1852b.mo10306a(C0989a.f1893h.mo10329a());
                }
                C1034a.m1979a(LoginAction.NOTIFY_LOGIN_SUCCESS);
                if (C0968c.this.f1851a) {
                    C0968c.this.f1853c.finish();
                }
            }
        });
    }

    /* access modifiers changed from: protected|varargs */
    /* renamed from: a */
    public Void mo10274a(String... strArr) {
        if (!C1034a.m1982b()) {
            C1029j jVar = new C1029j();
            jVar.f2054a = -1;
            jVar.f2055b = C1041f.m2005a("com_taobao_tae_sdk_network_not_available_message");
            m1832a(jVar.f2054a, jVar.f2055b);
            return null;
        }
        C1029j a = C0955a.f1830a.mo10260a(strArr[0], strArr[1], strArr[2]);
        if (a == null || a.f2056c == null) {
            m1832a(C1026g.f2045i.f2046j, C1026g.f2045i.f2047k);
            return null;
        }
        if (a.f2054a == 3000) {
            C0989a.f1893h.mo10330a((C1025f) a.f2056c);
            m1834b();
        } else {
            m1832a(a.f2054a, a.f2055b);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10281a() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10282a(Throwable th) {
        C0999a a = C1000b.m1914a(10010, th.getMessage());
        C1018a.m1958a("login", a, th);
        HashMap hashMap = new HashMap();
        hashMap.put("code", "10010");
        hashMap.put("message", "exception");
        ((C1015e) C0989a.m1882a(C1015e.class)).mo10356a(C0976d.f1868c, hashMap);
        m1832a(a.f1942a, a.f1944c);
    }
}
