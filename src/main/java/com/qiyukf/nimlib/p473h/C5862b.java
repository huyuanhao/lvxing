package com.qiyukf.nimlib.p473h;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.p417d.C5411c;
import com.qiyukf.basesdk.sdk.ResponseCode;
import com.qiyukf.nimlib.C5718b;
import com.qiyukf.nimlib.C5743d;
import com.qiyukf.nimlib.p429a.p436c.C5669a;
import com.qiyukf.nimlib.p429a.p442d.C5686a.C5687a;
import com.qiyukf.nimlib.p470f.C5837d;
import com.qiyukf.nimlib.p473h.C5900d.C5904a;
import com.qiyukf.nimlib.p473h.p474a.p476b.C5854c;
import com.qiyukf.nimlib.p473h.p474a.p476b.C5855d;
import com.qiyukf.nimlib.p473h.p478b.C5867b;
import com.qiyukf.nimlib.p473h.p478b.p480b.C5874a;
import com.qiyukf.nimlib.p473h.p481c.p483b.C5892b;
import com.qiyukf.nimlib.p488k.p492d.C5948b;
import com.qiyukf.nimlib.sdk.StatusCode;
import com.qiyukf.nimlib.sdk.auth.LoginInfo;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.qiyukf.nimlib.h.b */
public final class C5862b implements C5904a {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public AtomicReference<StatusCode> f18567a = new AtomicReference<>(StatusCode.UNLOGIN);
    /* renamed from: b */
    private Context f18568b;
    /* renamed from: c */
    private C5867b f18569c;
    /* renamed from: d */
    private C5900d f18570d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public C5854c f18571e;
    /* renamed from: f */
    private Handler f18572f;
    /* renamed from: g */
    private Runnable f18573g = new Runnable() {
        public final void run() {
            if (C5862b.this.f18567a.get() == StatusCode.LOGINING && C5862b.this.f18571e != null) {
                C5687a a = C5687a.m22947a(C5862b.this.f18571e.mo27870a(), ResponseCode.RES_ETIMEOUT);
                if (a != null) {
                    C5906f.m23656a().mo28280a(a);
                }
            }
        }
    };

    C5862b() {
    }

    /* renamed from: a */
    private void m23469a(StatusCode statusCode) {
        if (this.f18567a.get() != statusCode && !((StatusCode) this.f18567a.get()).wontAutoLogin()) {
            if (statusCode.wontAutoLogin()) {
                this.f18570d.mo28271a();
            }
            this.f18567a.set(statusCode);
            this.f18570d.mo28273a(statusCode);
            C5743d.m23108a(statusCode);
            C5837d.m23405a(statusCode);
            StringBuilder sb = new StringBuilder("status change to: ");
            sb.append(statusCode);
            C5264a.m21624d("AuthManager", sb.toString());
        }
    }

    /* renamed from: e */
    private boolean m23471e() {
        if (!m23472f()) {
            return false;
        }
        this.f18569c.mo28189a();
        m23469a(StatusCode.CONNECTING);
        this.f18570d.mo28272a(this.f18568b);
        this.f18569c.mo28192a(C5874a.m23528a().mo28198b());
        return true;
    }

    /* renamed from: f */
    private static boolean m23472f() {
        LoginInfo e = C5718b.m23018e();
        return e != null && e.valid();
    }

    /* renamed from: g */
    private Handler m23473g() {
        if (this.f18572f == null) {
            this.f18572f = new Handler(this.f18568b.getMainLooper());
        }
        return this.f18572f;
    }

    /* renamed from: h */
    private static final String m23474h() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("PRODUCT", Build.PRODUCT);
            jSONObject.put("DEVICE", Build.DEVICE);
            jSONObject.put("MANUFACTURER", Build.MANUFACTURER);
            jSONObject.put("BRAND", Build.BRAND);
            jSONObject.put("MODEL", Build.MODEL);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* renamed from: a */
    public final void mo28178a() {
        m23469a(StatusCode.UNLOGIN);
        C5900d dVar = this.f18570d;
        if (dVar != null) {
            dVar.mo28271a();
            this.f18570d = null;
        }
        this.f18568b = null;
        this.f18569c = null;
    }

    /* renamed from: a */
    public final void mo28179a(int i) {
        StringBuilder sb = new StringBuilder("on connect change ");
        sb.append(i);
        String str = "core";
        C5264a.m21624d(str, sb.toString());
        if (i != 0) {
            if (i == 2 && m23472f()) {
                m23469a(StatusCode.LOGINING);
                this.f18571e = new C5854c();
                C5854c cVar = this.f18571e;
                C5892b bVar = new C5892b();
                if (C5718b.m23016c() != null) {
                    bVar.mo28240a(1, C5718b.m23016c().intValue());
                }
                bVar.mo28240a(3, 1);
                bVar.mo28241a(19, C5718b.m23018e().getAccount());
                bVar.mo28241a(18, C5718b.m23020g());
                bVar.mo28241a(1000, C5718b.m23018e().getToken());
                bVar.mo28240a(6, 16);
                bVar.mo28241a(25, C5718b.m23019f());
                bVar.mo28240a(9, 1);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Build.PRODUCT);
                String str2 = "$$";
                sb2.append(str2);
                sb2.append(Build.MODEL);
                sb2.append(str2);
                sb2.append(VERSION.SDK_INT);
                bVar.mo28241a(4, sb2.toString());
                bVar.mo28241a(13, C5905e.m23645a());
                String g = C5411c.m22140g(this.f18568b);
                if (!TextUtils.isEmpty(g)) {
                    bVar.mo28241a(5, g);
                }
                bVar.mo28241a(14, C5411c.m22143j(this.f18568b));
                String a = C5948b.m23845a();
                if (!TextUtils.isEmpty(a)) {
                    bVar.mo28241a(28, a);
                }
                String b = C5948b.m23846b();
                if (!TextUtils.isEmpty(b)) {
                    bVar.mo28241a(29, b);
                }
                bVar.mo28241a(31, C5948b.m23847c());
                bVar.mo28241a(32, m23474h());
                bVar.mo28240a(8, 1);
                cVar.mo28166a(bVar);
                C5906f.m23656a().mo28279a((C5669a) this.f18571e);
                m23473g().removeCallbacks(this.f18573g);
                m23473g().postDelayed(this.f18573g, 30000);
            }
            return;
        }
        boolean c = C5411c.m22136c(this.f18568b);
        StringBuilder sb3 = new StringBuilder("on connection broken, network connected=");
        sb3.append(c);
        C5264a.m21617a(str, sb3.toString());
        m23469a(c ? StatusCode.UNLOGIN : StatusCode.NET_BROKEN);
        if (!m23472f()) {
            this.f18570d.mo28271a();
        }
    }

    /* renamed from: a */
    public final void mo28180a(int i, int i2) {
        StatusCode statusCode = StatusCode.KICKOUT;
        if (i == 2) {
            statusCode = StatusCode.FORBIDDEN;
        } else if (i == 3) {
            statusCode = StatusCode.KICK_BY_OTHER_CLIENT;
        }
        C5743d.m23106a(i2);
        C5718b.m23013a((LoginInfo) null);
        m23469a(statusCode);
    }

    /* renamed from: a */
    public final void mo28181a(Context context, C5867b bVar) {
        this.f18568b = context;
        this.f18569c = bVar;
        this.f18570d = new C5900d(this);
        if (m23472f()) {
            mo28182a(C5718b.m23018e());
        }
    }

    /* renamed from: a */
    public final void mo28182a(LoginInfo loginInfo) {
        if (!((StatusCode) this.f18567a.get()).logined()) {
            if (loginInfo == null || !loginInfo.valid()) {
                throw new IllegalArgumentException("LoginInfo is invalid!");
            }
            this.f18567a.set(StatusCode.UNLOGIN);
            C5718b.m23013a(loginInfo);
            m23471e();
        }
    }

    /* renamed from: a */
    public final void mo28183a(boolean z) {
        if (z) {
            C5718b.m23013a((LoginInfo) null);
        }
        C5906f.m23656a().mo28279a((C5669a) new C5855d());
        m23469a(StatusCode.UNLOGIN);
    }

    /* renamed from: b */
    public final void mo28184b() {
        if (this.f18567a.get() != StatusCode.LOGINING && this.f18567a.get() != StatusCode.LOGINED) {
            m23471e();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
            if (r3 != 404) goto L_0x0030;
     */
    /* renamed from: b */
    public final void mo28185b(int r3) {
        /*
        r2 = this;
        android.os.Handler r0 = r2.m23473g()
        java.lang.Runnable r1 = r2.f18573g
        r0.removeCallbacks(r1)
        r0 = 0
        r2.f18571e = r0
        r1 = 200(0xc8, float:2.8E-43)
        if (r3 == r1) goto L_0x003f
        r1 = 302(0x12e, float:4.23E-43)
        if (r3 == r1) goto L_0x003c
        r1 = 317(0x13d, float:4.44E-43)
        if (r3 == r1) goto L_0x0039
        r1 = 414(0x19e, float:5.8E-43)
        if (r3 == r1) goto L_0x003c
        r1 = 417(0x1a1, float:5.84E-43)
        if (r3 == r1) goto L_0x0036
        r1 = 422(0x1a6, float:5.91E-43)
        if (r3 == r1) goto L_0x0033
        r1 = 431(0x1af, float:6.04E-43)
        if (r3 == r1) goto L_0x0030
        r1 = 403(0x193, float:5.65E-43)
        if (r3 == r1) goto L_0x0033
        r1 = 404(0x194, float:5.66E-43)
        if (r3 == r1) goto L_0x003c
    L_0x0030:
        com.qiyukf.nimlib.sdk.StatusCode r3 = com.qiyukf.nimlib.sdk.StatusCode.UNLOGIN
        goto L_0x0041
    L_0x0033:
        com.qiyukf.nimlib.sdk.StatusCode r3 = com.qiyukf.nimlib.sdk.StatusCode.FORBIDDEN
        goto L_0x0041
    L_0x0036:
        com.qiyukf.nimlib.sdk.StatusCode r3 = com.qiyukf.nimlib.sdk.StatusCode.KICKOUT
        goto L_0x0041
    L_0x0039:
        com.qiyukf.nimlib.sdk.StatusCode r3 = com.qiyukf.nimlib.sdk.StatusCode.VER_ERROR
        goto L_0x0041
    L_0x003c:
        com.qiyukf.nimlib.sdk.StatusCode r3 = com.qiyukf.nimlib.sdk.StatusCode.PWD_ERROR
        goto L_0x0041
    L_0x003f:
        com.qiyukf.nimlib.sdk.StatusCode r3 = com.qiyukf.nimlib.sdk.StatusCode.LOGINED
    L_0x0041:
        boolean r1 = r3.wontAutoLogin()
        if (r1 == 0) goto L_0x004f
        com.qiyukf.nimlib.h.b.b r1 = r2.f18569c
        r1.mo28189a()
        com.qiyukf.nimlib.C5718b.m23013a(r0)
    L_0x004f:
        r2.m23469a(r3)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p473h.C5862b.mo28185b(int):void");
    }

    /* renamed from: c */
    public final void mo28186c() {
        C5264a.m21617a("core", "on network unavailable");
        this.f18569c.mo28189a();
        m23469a(StatusCode.NET_BROKEN);
    }

    /* renamed from: d */
    public final void mo28187d() {
        if (C5743d.m23120e().shouldReLogin()) {
            this.f18570d.mo28274b();
        }
    }
}
