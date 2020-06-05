package com.qiyukf.nimlib.p473h.p478b.p480b;

import android.os.Handler;
import android.text.TextUtils;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p394b.p395a.p404c.C5314b;
import com.qiyukf.basesdk.p412c.C5361a;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.nimlib.C5718b;
import com.qiyukf.nimlib.p450b.C5721b;
import com.qiyukf.nimlib.p450b.C5725d;
import com.qiyukf.nimlib.p450b.C5728f;
import com.qiyukf.nimlib.p473h.C5905e;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.qiyukf.nimlib.h.b.b.a */
public final class C5874a {
    /* renamed from: f */
    private static C5874a f18592f = new C5874a();
    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean f18593a = true;
    /* renamed from: b */
    private C5876a[] f18594b = new C5876a[1];
    /* renamed from: c */
    private String f18595c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public long f18596d;
    /* renamed from: e */
    private Handler f18597e = C5361a.m22013a().mo27317c();

    /* renamed from: com.qiyukf.nimlib.h.b.b.a$a */
    private static final class C5876a implements Serializable {
        /* renamed from: a */
        String f18599a;
        /* renamed from: b */
        String[] f18600b;
        /* renamed from: c */
        String[] f18601c;
        /* renamed from: d */
        int f18602d = 1;
        /* renamed from: e */
        int f18603e;
        /* renamed from: f */
        int f18604f;
        /* renamed from: g */
        boolean f18605g;

        C5876a(String str, String[] strArr) {
            this.f18599a = str;
            this.f18600b = strArr;
        }

        /* access modifiers changed from: final|declared_synchronized */
        /* renamed from: a */
        public final synchronized void mo28202a(String[] strArr) {
            this.f18601c = strArr;
            this.f18603e = 0;
            this.f18604f = 0;
        }

        /* access modifiers changed from: final|declared_synchronized */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0039, code lost:
            return true;
     */
        /* renamed from: a */
        public final synchronized boolean mo28203a() {
            /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String[] r0 = r5.f18601c     // Catch:{ all -> 0x003e }
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x000e
            java.lang.String[] r0 = r5.f18601c     // Catch:{ all -> 0x003e }
            int r0 = r0.length     // Catch:{ all -> 0x003e }
            if (r0 <= 0) goto L_0x000e
            r0 = 1
            goto L_0x000f
        L_0x000e:
            r0 = 0
        L_0x000f:
            boolean r3 = r5.f18605g     // Catch:{ all -> 0x003e }
            if (r3 == 0) goto L_0x0015
            monitor-exit(r5)
            return r0
        L_0x0015:
            r3 = 0
            if (r0 == 0) goto L_0x003a
            int r0 = r5.f18603e     // Catch:{ all -> 0x003e }
            int r0 = r0 + r2
            r5.f18603e = r0     // Catch:{ all -> 0x003e }
            int r4 = r5.f18602d     // Catch:{ all -> 0x003e }
            if (r0 < r4) goto L_0x0038
            r5.f18603e = r1     // Catch:{ all -> 0x003e }
            int r0 = r5.f18604f     // Catch:{ all -> 0x003e }
            java.lang.String[] r4 = r5.f18601c     // Catch:{ all -> 0x003e }
            int r4 = r4.length     // Catch:{ all -> 0x003e }
            int r4 = r4 - r2
            if (r0 < r4) goto L_0x002f
            r5.f18601c = r3     // Catch:{ all -> 0x003e }
            monitor-exit(r5)
            return r1
        L_0x002f:
            int r0 = r5.f18604f     // Catch:{ all -> 0x003e }
            int r0 = r0 + r2
            java.lang.String[] r1 = r5.f18601c     // Catch:{ all -> 0x003e }
            int r1 = r1.length     // Catch:{ all -> 0x003e }
            int r0 = r0 % r1
            r5.f18604f = r0     // Catch:{ all -> 0x003e }
        L_0x0038:
            monitor-exit(r5)
            return r2
        L_0x003a:
            r5.f18601c = r3     // Catch:{ all -> 0x003e }
            monitor-exit(r5)
            return r1
        L_0x003e:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p473h.p478b.p480b.C5874a.C5876a.mo28203a():boolean");
        }

        /* access modifiers changed from: final|declared_synchronized */
        /* renamed from: b */
        public final synchronized String mo28204b() {
            if (this.f18601c != null && this.f18601c.length > 0) {
                this.f18605g = false;
                return this.f18601c[this.f18604f];
            } else if (this.f18600b == null || this.f18600b.length <= 0) {
                return null;
            } else {
                this.f18605g = true;
                return this.f18600b[this.f18604f % this.f18600b.length];
            }
        }

        /* access modifiers changed from: final|declared_synchronized */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x000f, code lost:
            return;
     */
        /* renamed from: b */
        public final synchronized void mo28205b(java.lang.String[] r2) {
            /*
            r1 = this;
            monitor-enter(r1)
            if (r2 == 0) goto L_0x000e
            int r0 = r2.length     // Catch:{ all -> 0x000b }
            if (r0 != 0) goto L_0x0007
            goto L_0x000e
        L_0x0007:
            r1.f18600b = r2     // Catch:{ all -> 0x000b }
            monitor-exit(r1)
            return
        L_0x000b:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L_0x000e:
            monitor-exit(r1)
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p473h.p478b.p480b.C5874a.C5876a.mo28205b(java.lang.String[]):void");
        }
    }

    private C5874a() {
        this.f18594b[0] = new C5876a("link", m23534e());
    }

    /* renamed from: a */
    public static C5874a m23528a() {
        return f18592f;
    }

    /* renamed from: a */
    static /* synthetic */ String m23529a(C5874a aVar) {
        String a = TextUtils.isEmpty(aVar.f18595c) ? C5728f.m23060a() : aVar.f18595c;
        C5718b.m23009a();
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append("?tp=1");
        sb.append("&sv=16");
        sb.append("&pv=1");
        String b = C5718b.m23015b();
        if (!TextUtils.isEmpty(b)) {
            sb.append("&id=");
            sb.append(b);
        }
        sb.append("&k=");
        sb.append(C5718b.m23020g());
        sb.append("&devflag=");
        sb.append(C5725d.m23053b() ? "qytest" : "qyonline");
        return sb.toString().trim();
    }

    /* renamed from: a */
    static /* synthetic */ void m23530a(C5874a aVar, String str) {
        String str2 = "core";
        String str3 = null;
        try {
            StringBuilder sb = new StringBuilder("get server addresses from lbs: ");
            sb.append(str);
            C5264a.m21617a(str2, sb.toString());
            str3 = C5314b.m21851b(str, "GET", "LBS");
            StringBuilder sb2 = new StringBuilder("lbs response: ");
            sb2.append(str3);
            C5264a.m21617a(str2, sb2.toString());
        } catch (Exception e) {
            e.printStackTrace();
            C5264a.m21624d("lbs", "LBS Http Error");
        }
        aVar.m23531a(str3);
    }

    /* renamed from: a */
    private final void m23531a(String str) {
        C5876a[] aVarArr;
        String str2 = "lbs";
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str).getJSONObject("common");
                for (C5876a aVar : this.f18594b) {
                    aVar.mo28202a(m23532a(jSONObject, aVar.f18599a));
                }
                this.f18595c = jSONObject.getString(str2);
                String string = jSONObject.getString("link.default");
                if (C5725d.m23053b()) {
                    C5905e.m23649b(string);
                } else if (C5725d.m23055d()) {
                    C5905e.m23651c(string);
                } else {
                    C5905e.m23646a(string);
                }
                this.f18594b[0].mo28205b(m23534e());
                C5721b.m23039e().mo27974a(C5366b.m22040f(jSONObject, "c.aos"));
                this.f18593a = false;
            } catch (Exception e) {
                e.printStackTrace();
                StringBuilder sb = new StringBuilder("LBS Json Error ");
                sb.append(e.getMessage());
                C5264a.m21624d(str2, sb.toString());
            }
        }
    }

    /* renamed from: a */
    private static String[] m23532a(JSONObject jSONObject, String str) {
        JSONArray g = C5366b.m22041g(jSONObject, str);
        if (g == null) {
            return null;
        }
        String[] strArr = new String[g.length()];
        for (int i = 0; i < g.length(); i++) {
            strArr[i] = C5366b.m22026a(g, i);
        }
        return strArr;
    }

    /* renamed from: e */
    private static String[] m23534e() {
        String str = C5725d.m23053b() ? C5905e.m23650c() : C5725d.m23055d() ? C5905e.m23652d() : C5905e.m23648b();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray b = C5366b.m22035b(str);
                String[] strArr = new String[b.length()];
                for (int i = 0; i < b.length(); i++) {
                    strArr[i] = C5366b.m22026a(b, i);
                }
                return strArr;
            } catch (Exception unused) {
            }
        }
        return new String[]{C5728f.m23061b()};
    }

    /* renamed from: f */
    private synchronized String m23535f() {
        boolean isEmpty = TextUtils.isEmpty(this.f18594b[0].mo28204b());
        if (isEmpty || this.f18593a || System.currentTimeMillis() - this.f18596d >= 3600000) {
            C58751 r2 = new Runnable() {
                public final void run() {
                    C5874a aVar = C5874a.this;
                    C5874a.m23530a(aVar, C5874a.m23529a(aVar));
                    if (!C5874a.this.f18593a) {
                        C5874a.this.f18596d = System.currentTimeMillis();
                    }
                }
            };
            if (isEmpty) {
                r2.run();
            } else {
                this.f18597e.post(r2);
            }
        }
        return this.f18594b[0].mo28204b();
    }

    /* renamed from: g */
    private synchronized void m23536g() {
        if (!this.f18594b[0].mo28203a()) {
            mo28200d();
        }
    }

    /* renamed from: b */
    public final C5877b mo28198b() {
        String f = m23535f();
        StringBuilder sb = new StringBuilder("connect link ");
        sb.append(f);
        C5264a.m21617a("core", sb.toString());
        return new C5877b(f);
    }

    /* renamed from: c */
    public final void mo28199c() {
        m23536g();
    }

    /* renamed from: d */
    public final synchronized void mo28200d() {
        this.f18593a = true;
    }
}
