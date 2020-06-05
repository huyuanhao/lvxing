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
import com.ali.auth.third.core.p033j.C1018a;
import com.ali.auth.third.core.util.C1034a;
import com.ali.auth.third.p016a.C0955a;
import com.ali.auth.third.p016a.C0976d;
import com.ali.auth.third.p016a.p017a.C0957a;
import com.ali.auth.third.p034ui.LoginActivity;
import com.ali.auth.third.p034ui.p035a.C1067a;
import java.util.HashMap;

/* renamed from: com.ali.auth.third.a.c.e */
public class C0972e extends C0962a {
    /* renamed from: b */
    private C0985c f1860b;

    public C0972e(Activity activity, C0985c cVar) {
        super(activity);
        this.f1860b = cVar;
    }

    /* access modifiers changed from: protected|varargs */
    /* renamed from: a */
    public Void mo10274a(String... strArr) {
        final C1029j b = mo10277b(strArr);
        if (b == null) {
            return null;
        }
        final int i = b.f2054a;
        StringBuilder sb = new StringBuilder();
        sb.append("asyncExecute code = ");
        sb.append(i);
        C1018a.m1964b("login", sb.toString());
        if (i == 3000) {
            try {
                if (b.f2056c != null) {
                    C0957a.f1835b.mo10330a((C1025f) b.f2056c);
                }
                C0989a.f1901p.mo10335a(new Runnable() {
                    public void run() {
                        C0972e.this.mo10278b();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            C0989a.f1901p.mo10335a(new Runnable() {
                public void run() {
                    String str = "login";
                    StringBuilder sb = new StringBuilder();
                    sb.append("code ");
                    sb.append(i);
                    sb.append(" ");
                    sb.append(b.f2055b);
                    C0999a a = C1000b.m1914a(15, str, sb.toString());
                    C1018a.m1964b(str, a.toString());
                    C0972e.this.mo10276a(a.f1942a, a.f1944c);
                }
            });
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10276a(int i, String str) {
        C0985c cVar = this.f1860b;
        if (cVar != null) {
            cVar.mo10305a(i, str);
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append("");
            hashMap.put("code", sb.toString());
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("message", str);
            }
            ((C1015e) C0989a.m1882a(C1015e.class)).mo10356a(C0976d.f1871f, hashMap);
        }
        if (C1067a.f2148b != null) {
            C1067a.f2148b.mo10305a(i, str);
        }
        C1034a.m1979a(LoginAction.NOTIFY_LOGIN_FAILED);
        if (this.f1976a != null && (this.f1976a instanceof LoginActivity)) {
            C1067a.f2149c = null;
            this.f1976a.finish();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10282a(Throwable th) {
        C1034a.m1979a(LoginAction.NOTIFY_LOGIN_FAILED);
        HashMap hashMap = new HashMap();
        hashMap.put("code", "10010");
        hashMap.put("message", "exception");
        ((C1015e) C0989a.m1882a(C1015e.class)).mo10356a(C0976d.f1871f, hashMap);
        C1034a.m1978a(this.f1860b, C1026g.m1970a(10010, th.getMessage()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C1029j<C1025f> mo10277b(String[] strArr) {
        return C0955a.f1830a.mo10264b(strArr[0]);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo10278b() {
        C0985c cVar = this.f1860b;
        if (cVar != null) {
            cVar.mo10306a(C0957a.f1835b.mo10329a());
            ((C1015e) C0989a.m1882a(C1015e.class)).mo10356a(C0976d.f1870e, null);
        }
        if (C1067a.f2148b != null) {
            C1067a.f2148b.mo10306a(C0957a.f1835b.mo10329a());
        }
        C1034a.m1979a(LoginAction.NOTIFY_LOGIN_SUCCESS);
        if (this.f1976a != null && (this.f1976a instanceof LoginActivity)) {
            C1067a.f2149c = null;
            this.f1976a.finish();
        }
    }
}
