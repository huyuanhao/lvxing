package com.qiyukf.nimlib.p453d.p465e;

import android.content.Context;
import android.text.TextUtils;
import com.qiyukf.nimlib.p453d.p454a.p456b.C5753a;
import com.qiyukf.nimlib.p453d.p459b.C5762a;
import com.qiyukf.nimlib.p453d.p459b.p460a.C5763a;
import com.qiyukf.nimlib.p453d.p459b.p460a.C5765c;
import com.qiyukf.nimlib.p453d.p459b.p460a.C5766d;
import com.qiyukf.nimlib.p453d.p459b.p460a.C5767e;
import com.qiyukf.nimlib.p453d.p459b.p460a.C5768f;
import com.qiyukf.nimlib.p453d.p459b.p461b.C5770a;
import com.qiyukf.nimlib.p453d.p459b.p461b.C5771b;
import com.qiyukf.nimlib.p453d.p462c.C5773a;
import com.qiyukf.nimlib.p453d.p462c.C5773a.C5776a;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.qiyukf.nimlib.d.e.a */
public final class C5781a extends C5788b {
    /* access modifiers changed from: private */
    /* renamed from: d */
    public Set<String> f18413d = new HashSet(10);

    /* renamed from: com.qiyukf.nimlib.d.e.a$a */
    private static class C5783a {
        /* access modifiers changed from: private|static|final */
        /* renamed from: a */
        public static final C5781a f18415a = new C5781a();
    }

    /* renamed from: a */
    public static C5781a m23217a() {
        return C5783a.f18415a;
    }

    /* renamed from: a */
    private String m23218a(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject b = m23222b(z);
            if (b != null) {
                jSONObject.put("wifi", b);
            }
            JSONArray c = m23223c(z);
            if (c != null) {
                jSONObject.put("wifi_list", c);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            StringBuilder sb = new StringBuilder("tryCollectWifi error=");
            sb.append(e.getMessage());
            C5753a.m23149f(sb.toString());
        }
        if (jSONObject.length() == 0) {
            return null;
        }
        return jSONObject.toString();
    }

    /* renamed from: a */
    private static JSONObject m23220a(C5762a aVar) {
        if (aVar != null) {
            return aVar.mo28034a();
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m23221a(long j, long j2) {
        return System.currentTimeMillis() >= j + (j2 * 1000);
    }

    /* renamed from: b */
    private JSONObject m23222b(boolean z) {
        if (z || m23221a(C5801a.f18456a.mo28089f(), this.f18425b.mo28049e().longValue())) {
            C5770a a = C5771b.m23192a(this.f18424a);
            this.f18413d.add("wifi");
            StringBuilder sb = new StringBuilder("* getConnectedWifiInfo=");
            sb.append(a);
            C5753a.m23145b(sb.toString());
            return m23220a((C5762a) a);
        }
        C5753a.m23145b("- getConnectedWifiInfo period control!");
        return null;
    }

    /* renamed from: c */
    private JSONArray m23223c(boolean z) {
        String str;
        if (z || m23221a(C5801a.f18456a.mo28091g(), this.f18425b.mo28050f().longValue())) {
            List b = C5771b.m23193b(this.f18424a);
            if (b == null) {
                str = "* getWifiList=null";
            } else {
                this.f18413d.add("wifi_list");
                StringBuilder sb = new StringBuilder("* getWifiList size=");
                sb.append(b.size());
                sb.append(", ex=");
                sb.append(b.get(b.size() / 2));
                str = sb.toString();
            }
            C5753a.m23145b(str);
            return C5770a.m23189a(b);
        }
        C5753a.m23145b("- getWifiList period control!");
        return null;
    }

    /* renamed from: d */
    private String m23224d() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        String sb;
        if (!m23221a(C5801a.f18456a.mo28097j(), 5)) {
            C5753a.m23149f("collect all frequency control !!!");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            String str = "device";
            if (m23221a(C5801a.f18456a.mo28081b(), this.f18425b.mo28045a().longValue())) {
                C5766d a = C5767e.m23179a(this.f18424a);
                this.f18413d.add(str);
                StringBuilder sb2 = new StringBuilder("* getDeviceInfo=");
                sb2.append(a);
                C5753a.m23145b(sb2.toString());
                obj = m23220a((C5762a) a);
            } else {
                C5753a.m23145b("- getDeviceInfo period control!");
                obj = null;
            }
            if (obj != null) {
                jSONObject.put(str, obj);
            }
            String str2 = "app";
            if (m23221a(C5801a.f18456a.mo28087e(), this.f18425b.mo28048d().longValue())) {
                C5763a b = C5767e.m23180b(this.f18424a);
                this.f18413d.add(str2);
                StringBuilder sb3 = new StringBuilder("* getAppInfo=");
                sb3.append(b);
                C5753a.m23145b(sb3.toString());
                obj2 = m23220a((C5762a) b);
            } else {
                C5753a.m23145b("- getAppInfo period control!");
                obj2 = null;
            }
            if (obj2 != null) {
                jSONObject.put(str2, obj2);
            }
            String str3 = "carrier";
            if (m23221a(C5801a.f18456a.mo28083c(), this.f18425b.mo28046b().longValue())) {
                C5768f d = C5767e.m23182d(this.f18424a);
                this.f18413d.add(str3);
                StringBuilder sb4 = new StringBuilder("* getOperatorInfo=");
                sb4.append(d);
                C5753a.m23145b(sb4.toString());
                obj3 = m23220a((C5762a) d);
            } else {
                C5753a.m23145b("- getOperatorInfo period control!");
                obj3 = null;
            }
            if (obj3 != null) {
                jSONObject.put(str3, obj3);
            }
            String str4 = "cell";
            if (m23221a(C5801a.f18456a.mo28095i(), this.f18425b.mo28052h().longValue())) {
                C5765c e = C5767e.m23183e(this.f18424a);
                this.f18413d.add(str4);
                StringBuilder sb5 = new StringBuilder("* getCellInfo=");
                sb5.append(e);
                C5753a.m23145b(sb5.toString());
                obj4 = m23220a((C5762a) e);
            } else {
                C5753a.m23145b("- getCellInfo period control!");
                obj4 = null;
            }
            if (obj4 != null) {
                jSONObject.put(str4, obj4);
            }
            JSONObject d2 = m23225d(false);
            if (d2 != null) {
                jSONObject.put("gps", d2);
            }
            JSONObject b2 = m23222b(false);
            if (b2 != null) {
                jSONObject.put("wifi", b2);
            }
            JSONArray c = m23223c(false);
            if (c != null) {
                jSONObject.put("wifi_list", c);
            }
            String str5 = "app_list";
            if (m23221a(C5801a.f18456a.mo28085d(), this.f18425b.mo28047c().longValue())) {
                List c2 = C5767e.m23181c(this.f18424a);
                this.f18413d.add(str5);
                if (c2 == null) {
                    sb = "* getInstalledAppInfoList=null";
                } else {
                    StringBuilder sb6 = new StringBuilder("* getInstalledAppInfoList size=");
                    sb6.append(c2.size());
                    sb6.append(", ex=");
                    sb6.append(c2.get(c2.size() / 2));
                    sb = sb6.toString();
                }
                C5753a.m23145b(sb);
                obj5 = C5763a.m23162a(c2);
            } else {
                C5753a.m23145b("- getInstalledAppInfoList period control!");
                obj5 = null;
            }
            if (obj5 != null) {
                jSONObject.put(str5, obj5);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            StringBuilder sb7 = new StringBuilder("tryCollectAll error=");
            sb7.append(e2.getMessage());
            C5753a.m23149f(sb7.toString());
        }
        C5801a.f18456a.mo28098j(System.currentTimeMillis());
        if (jSONObject.length() == 0) {
            return null;
        }
        return jSONObject.toString();
    }

    /* renamed from: d */
    private JSONObject m23225d(boolean z) {
        String str;
        if (this.f18426c == null) {
            str = "- getGPS null, as app has not commit";
        } else if (z || m23221a(C5801a.f18456a.mo28093h(), this.f18425b.mo28051g().longValue())) {
            this.f18413d.add("gps");
            StringBuilder sb = new StringBuilder("* getGPS=");
            sb.append(this.f18426c);
            C5753a.m23145b(sb.toString());
            JSONObject a = m23220a((C5762a) this.f18426c);
            this.f18426c = null;
            return a;
        } else {
            str = "- getGPS period control!";
        }
        C5753a.m23145b(str);
        return null;
    }

    /* renamed from: e */
    private String m23226e() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject d = m23225d(true);
            if (d != null) {
                jSONObject.put("gps", d);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            StringBuilder sb = new StringBuilder("tryCollectGPS error=");
            sb.append(e.getMessage());
            C5753a.m23149f(sb.toString());
        }
        if (jSONObject.length() == 0) {
            return null;
        }
        return jSONObject.toString();
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo28060a(int i) {
        this.f18413d.clear();
        String str = (i == 0 || i == 1 || i == 2) ? m23224d() : i != 3 ? i != 4 ? i != 5 ? null : m23226e() : m23218a(false) : m23218a(true);
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder("posting data to DCServer, data=");
            sb.append(str);
            C5753a.m23148e(sb.toString());
            C5773a.m23195a().mo28042a(str, new C5776a<Void>() {
                /* renamed from: a */
                public final void mo28043a(int i, String str) {
                    StringBuilder sb = new StringBuilder("on post data failed, code=");
                    sb.append(i);
                    sb.append(", error=");
                    sb.append(str);
                    C5753a.m23148e(sb.toString());
                    C5781a.this.f18413d.clear();
                }

                /* renamed from: a */
                public final /* synthetic */ void mo28044a(Object obj) {
                    C5753a.m23148e("on post data success!");
                    long currentTimeMillis = System.currentTimeMillis();
                    if (C5781a.this.f18413d.contains("device")) {
                        C5801a.f18456a.mo28082b(currentTimeMillis);
                    }
                    if (C5781a.this.f18413d.contains("app")) {
                        C5801a.f18456a.mo28088e(System.currentTimeMillis());
                    }
                    if (C5781a.this.f18413d.contains("carrier")) {
                        C5801a.f18456a.mo28084c(System.currentTimeMillis());
                    }
                    if (C5781a.this.f18413d.contains("cell")) {
                        C5801a.f18456a.mo28096i(System.currentTimeMillis());
                    }
                    if (C5781a.this.f18413d.contains("wifi")) {
                        C5801a.f18456a.mo28090f(System.currentTimeMillis());
                    }
                    if (C5781a.this.f18413d.contains("wifi_list")) {
                        C5801a.f18456a.mo28092g(System.currentTimeMillis());
                    }
                    if (C5781a.this.f18413d.contains("gps")) {
                        C5801a.f18456a.mo28094h(System.currentTimeMillis());
                    }
                    if (C5781a.this.f18413d.contains("app_list")) {
                        C5801a.f18456a.mo28086d(System.currentTimeMillis());
                    }
                    StringBuilder sb = new StringBuilder("save post time, key size=");
                    sb.append(C5781a.this.f18413d.size());
                    C5753a.m23148e(sb.toString());
                    C5781a.this.f18413d.clear();
                }
            });
        }
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo28061a(Context context) {
        super.mo28061a(context);
    }

    /* renamed from: b */
    public final /* bridge */ /* synthetic */ void mo28062b() {
        super.mo28062b();
    }
}
