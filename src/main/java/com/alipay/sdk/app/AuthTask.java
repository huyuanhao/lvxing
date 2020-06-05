package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.app.statistic.C1505a;
import com.alipay.sdk.p121b.C1508a;
import com.alipay.sdk.p121b.C1508a.C1509a;
import com.alipay.sdk.p121b.C1511c;
import com.alipay.sdk.p124e.p125a.C1522a;
import com.alipay.sdk.protocol.C1533a;
import com.alipay.sdk.protocol.C1534b;
import com.alipay.sdk.sys.C1535a;
import com.alipay.sdk.sys.C1536b;
import com.alipay.sdk.util.C1542e;
import com.alipay.sdk.util.C1543f;
import com.alipay.sdk.util.C1543f.C1544a;
import com.alipay.sdk.util.C1551m;
import com.alipay.sdk.util.C1553o;
import com.alipay.sdk.widget.C1559a;
import com.p522qq.p523e.comm.constants.Constants.KEYS;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AuthTask {
    /* renamed from: a */
    static final Object f3790a = C1543f.class;
    /* renamed from: b */
    private Activity f3791b;
    /* renamed from: c */
    private C1559a f3792c;

    public AuthTask(Activity activity) {
        this.f3791b = activity;
        C1536b.m4608a().mo12201a(this.f3791b, C1511c.m4489a());
        C1505a.m4450a(activity);
        this.f3792c = new C1559a(activity, "去支付宝授权");
    }

    /* renamed from: a */
    private C1544a m4388a() {
        return new C1493a(this);
    }

    /* renamed from: b */
    private void m4393b() {
        C1559a aVar = this.f3792c;
        if (aVar != null) {
            aVar.mo12244a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m4394c() {
        C1559a aVar = this.f3792c;
        if (aVar != null) {
            aVar.mo12246b();
        }
    }

    public synchronized Map<String, String> authV2(String str, boolean z) {
        return C1551m.m4662a(auth(str, z));
    }

    public synchronized String auth(String str, boolean z) {
        String c;
        Activity activity;
        if (z) {
            m4393b();
        }
        C1536b.m4608a().mo12201a(this.f3791b, C1511c.m4489a());
        c = C1503j.m4442c();
        C1502i.m4435a("");
        try {
            c = m4389a(this.f3791b, str);
            C1508a.m4475g().mo12154a((Context) this.f3791b);
            m4394c();
            activity = this.f3791b;
        } catch (Exception e) {
            try {
                C1542e.m4633a(e);
                C1508a.m4475g().mo12154a((Context) this.f3791b);
                m4394c();
                activity = this.f3791b;
            } catch (Throwable th) {
                C1508a.m4475g().mo12154a((Context) this.f3791b);
                m4394c();
                C1505a.m4456b(this.f3791b, str);
                throw th;
            }
        }
        C1505a.m4456b(activity, str);
        return c;
    }

    /* renamed from: a */
    private String m4389a(Activity activity, String str) {
        String a = new C1535a(this.f3791b).mo12199a(str);
        List<C1509a> f = C1508a.m4475g().mo12159f();
        if (!C1508a.m4475g().f3866a || f == null) {
            f = C1502i.f3836a;
        }
        boolean b = C1553o.m4682b((Context) this.f3791b, f);
        String str2 = "";
        String str3 = KEYS.BIZ;
        if (b) {
            String a2 = new C1543f(activity, m4388a()).mo12216a(a);
            if (!TextUtils.equals(a2, "failed") && !TextUtils.equals(a2, "scheme_failed")) {
                return TextUtils.isEmpty(a2) ? C1503j.m4442c() : a2;
            }
            C1505a.m4452a(str3, "LogBindCalledH5", str2);
            return m4392b(activity, a);
        }
        C1505a.m4452a(str3, "LogCalledH5", str2);
        return m4392b(activity, a);
    }

    /* renamed from: b */
    private String m4392b(Activity activity, String str) {
        C1504k kVar;
        m4393b();
        try {
            List a = C1534b.m4594a(new C1522a().mo12172a((Context) activity, str).mo12178c().optJSONObject("form").optJSONObject("onload"));
            m4394c();
            for (int i = 0; i < a.size(); i++) {
                if (((C1534b) a.get(i)).mo12197a() == C1533a.WapPay) {
                    String a2 = m4390a((C1534b) a.get(i));
                    m4394c();
                    return a2;
                }
            }
        } catch (IOException e) {
            C1504k b = C1504k.m4445b(C1504k.NETWORK_ERROR.mo12142a());
            C1505a.m4455a("net", (Throwable) e);
            m4394c();
            kVar = b;
        } catch (Throwable th) {
            m4394c();
            throw th;
        }
        m4394c();
        kVar = null;
        if (kVar == null) {
            kVar = C1504k.m4445b(C1504k.FAILED.mo12142a());
        }
        return C1503j.m4438a(kVar.mo12142a(), kVar.mo12145b(), "");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:11|12|13|14) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            r0 = com.alipay.sdk.app.C1503j.m4442c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0041, code lost:
            return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002b, code lost:
            r4 = com.alipay.sdk.app.C1503j.m4437a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0033, code lost:
            if (android.text.TextUtils.isEmpty(r4) == false) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0035, code lost:
            r4 = com.alipay.sdk.app.C1503j.m4442c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0039, code lost:
            return r4;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003c */
    /* renamed from: a */
    private java.lang.String m4390a(com.alipay.sdk.protocol.C1534b r4) {
        /*
        r3 = this;
        java.lang.String[] r4 = r4.mo12198b()
        android.os.Bundle r0 = new android.os.Bundle
        r0.<init>()
        r1 = 0
        r4 = r4[r1]
        java.lang.String r1 = "url"
        r0.putString(r1, r4)
        android.content.Intent r4 = new android.content.Intent
        android.app.Activity r1 = r3.f3791b
        java.lang.Class<com.alipay.sdk.app.H5AuthActivity> r2 = com.alipay.sdk.app.H5AuthActivity.class
        r4.<init>(r1, r2)
        r4.putExtras(r0)
        android.app.Activity r0 = r3.f3791b
        r0.startActivity(r4)
        java.lang.Object r4 = f3790a
        monitor-enter(r4)
        java.lang.Object r0 = f3790a     // Catch:{ InterruptedException -> 0x003c }
        r0.wait()     // Catch:{ InterruptedException -> 0x003c }
        monitor-exit(r4)     // Catch:{ all -> 0x003a }
        java.lang.String r4 = com.alipay.sdk.app.C1503j.m4437a()
        boolean r0 = android.text.TextUtils.isEmpty(r4)
        if (r0 == 0) goto L_0x0039
        java.lang.String r4 = com.alipay.sdk.app.C1503j.m4442c()
    L_0x0039:
        return r4
    L_0x003a:
        r0 = move-exception
        goto L_0x0042
    L_0x003c:
        java.lang.String r0 = com.alipay.sdk.app.C1503j.m4442c()     // Catch:{ all -> 0x003a }
        monitor-exit(r4)     // Catch:{ all -> 0x003a }
        return r0
    L_0x0042:
        monitor-exit(r4)     // Catch:{ all -> 0x003a }
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.AuthTask.m4390a(com.alipay.sdk.protocol.b):java.lang.String");
    }
}
