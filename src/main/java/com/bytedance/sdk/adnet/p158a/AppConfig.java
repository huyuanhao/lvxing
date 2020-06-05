package com.bytedance.sdk.adnet.p158a;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.location.Address;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.AdNetSdk;
import com.bytedance.sdk.adnet.core.C1982p;
import com.bytedance.sdk.adnet.core.C1982p.C1983a;
import com.bytedance.sdk.adnet.core.DefaultRetryPolicy;
import com.bytedance.sdk.adnet.p159b.JsonObjectRequest;
import com.bytedance.sdk.adnet.p160c.ApiRequestInterceptor;
import com.bytedance.sdk.adnet.p160c.TNCManager;
import com.bytedance.sdk.adnet.p161d.C1987d;
import com.bytedance.sdk.adnet.p161d.NetworkUtils;
import com.bytedance.sdk.adnet.p161d.ProcessUtils;
import com.bytedance.sdk.adnet.p161d.UrlBuilder;
import com.bytedance.sdk.adnet.p161d.WeakHandler;
import com.bytedance.sdk.adnet.p161d.WeakHandler.C1993a;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import com.tencent.qqpim.discovery.internal.protocol.C7516p;
import com.tencent.stat.apkreader.ChannelReader;
import com.tencent.stat.common.DeviceInfo;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.adnet.a.a */
public class AppConfig implements ApiRequestInterceptor, C1993a {
    /* renamed from: b */
    private static AppConfig f6059b;
    /* renamed from: a */
    final WeakHandler f6060a = new WeakHandler(Looper.getMainLooper(), this);
    /* renamed from: c */
    private final boolean f6061c;
    /* renamed from: d */
    private volatile boolean f6062d = false;
    /* renamed from: e */
    private boolean f6063e = true;
    /* renamed from: f */
    private boolean f6064f = false;
    /* renamed from: g */
    private long f6065g = 0;
    /* renamed from: h */
    private long f6066h = 0;
    /* renamed from: i */
    private AtomicBoolean f6067i = new AtomicBoolean(false);
    /* renamed from: j */
    private final Context f6068j;
    /* renamed from: k */
    private volatile boolean f6069k = false;

    /* renamed from: a */
    public static AppConfig m7653a(Context context) {
        AppConfig aVar;
        synchronized (AppConfig.class) {
            if (f6059b == null) {
                f6059b = new AppConfig(context.getApplicationContext(), ProcessUtils.m7957b(context));
                AdNetSdk.m7645a((ApiRequestInterceptor) f6059b);
            }
            aVar = f6059b;
        }
        return aVar;
    }

    private AppConfig(Context context, boolean z) {
        this.f6068j = context;
        this.f6061c = z;
    }

    /* renamed from: a */
    public void mo14161a() {
        mo14163a(false);
    }

    /* renamed from: a */
    public synchronized void mo14163a(boolean z) {
        if (this.f6061c) {
            m7662d(z);
        } else if (this.f6065g <= 0) {
            try {
                new Thread("LoadDomainConfig4Other-Thread") {
                    public void run() {
                        AppConfig.this.mo14164b();
                    }
                }.start();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: b */
    public static void m7660b(Context context) {
        AppConfig aVar = f6059b;
        if (aVar == null) {
            return;
        }
        if (ProcessUtils.m7957b(context)) {
            aVar.mo14163a(true);
        } else {
            aVar.mo14161a();
        }
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: b */
    public synchronized void mo14164b() {
        if (System.currentTimeMillis() - this.f6065g > 3600000) {
            this.f6065g = System.currentTimeMillis();
            try {
                if (TNCManager.m7771a().mo14249e() != null) {
                    TNCManager.m7771a().mo14249e().mo14242b();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: d */
    private void m7662d(boolean z) {
        if (!this.f6064f) {
            if (this.f6063e) {
                this.f6063e = false;
                this.f6065g = 0;
                this.f6066h = 0;
            }
            long j = z ? 10800000 : 43200000;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f6065g > j && currentTimeMillis - this.f6066h > 120000) {
                boolean a = NetworkUtils.m7954a(this.f6068j);
                if (!this.f6069k || a) {
                    mo14165b(a);
                }
            }
        }
    }

    /* renamed from: b */
    public boolean mo14165b(final boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("doRefresh: updating state");
        sb.append(this.f6067i.get());
        String str = "TNCManager";
        C1987d.m7948b(str, sb.toString());
        if (!this.f6067i.compareAndSet(false, true)) {
            C1987d.m7948b(str, "doRefresh, already running");
            return false;
        }
        if (z) {
            this.f6066h = System.currentTimeMillis();
        }
        new Thread("AppConfigThread") {
            public void run() {
                AppConfig.this.mo14167c(z);
            }
        }.start();
        return true;
    }

    /* renamed from: a */
    public void mo14162a(Message message) {
        int i = message.what;
        String str = "TNCManager";
        if (i == 101) {
            this.f6064f = false;
            this.f6065g = System.currentTimeMillis();
            C1987d.m7948b(str, "doRefresh, succ");
            if (this.f6063e) {
                mo14161a();
            }
            this.f6067i.set(false);
        } else if (i == 102) {
            this.f6064f = false;
            if (this.f6063e) {
                mo14161a();
            }
            C1987d.m7948b(str, "doRefresh, error");
            this.f6067i.set(false);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003c, code lost:
            return;
     */
    /* renamed from: c */
    public synchronized void mo14166c() {
        /*
        r5 = this;
        monitor-enter(r5)
        boolean r0 = r5.f6069k     // Catch:{ all -> 0x003d }
        if (r0 == 0) goto L_0x0007
        monitor-exit(r5)
        return
    L_0x0007:
        r0 = 1
        r5.f6069k = r0     // Catch:{ all -> 0x003d }
        android.content.Context r0 = r5.f6068j     // Catch:{ all -> 0x003d }
        java.lang.String r1 = "ss_app_config"
        r2 = 0
        android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)     // Catch:{ all -> 0x003d }
        java.lang.String r1 = "last_refresh_time"
        r2 = 0
        long r0 = r0.getLong(r1, r2)     // Catch:{ all -> 0x003d }
        long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x003d }
        int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
        if (r4 <= 0) goto L_0x0024
        r0 = r2
    L_0x0024:
        r5.f6065g = r0     // Catch:{ all -> 0x003d }
        com.bytedance.sdk.adnet.c.f r0 = com.bytedance.sdk.adnet.p160c.TNCManager.m7771a()     // Catch:{ all -> 0x003d }
        com.bytedance.sdk.adnet.c.e r0 = r0.mo14249e()     // Catch:{ all -> 0x003d }
        if (r0 == 0) goto L_0x003b
        com.bytedance.sdk.adnet.c.f r0 = com.bytedance.sdk.adnet.p160c.TNCManager.m7771a()     // Catch:{ all -> 0x003d }
        com.bytedance.sdk.adnet.c.e r0 = r0.mo14249e()     // Catch:{ all -> 0x003d }
        r0.mo14240a()     // Catch:{ all -> 0x003d }
    L_0x003b:
        monitor-exit(r5)
        return
    L_0x003d:
        r0 = move-exception
        monitor-exit(r5)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.adnet.p158a.AppConfig.mo14166c():void");
    }

    /* renamed from: a */
    public String mo14160a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            try {
                str = TNCManager.m7771a().mo14244a(str);
            } catch (Throwable unused) {
            }
            return str;
        }
        try {
            if (this.f6061c) {
                mo14166c();
            } else {
                mo14164b();
            }
            str = TNCManager.m7771a().mo14244a(str);
        } catch (Throwable unused2) {
        }
        return str;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo14167c(boolean z) {
        C1987d.m7948b("TNCManager", "doRefresh, actual request");
        mo14166c();
        this.f6064f = true;
        if (!z) {
            this.f6060a.sendEmptyMessage(102);
            return;
        }
        try {
            m7663e();
        } catch (Exception unused) {
            this.f6067i.set(false);
        }
    }

    /* renamed from: d */
    public String[] mo14168d() {
        String[] f = AdNetSdk.m7640a().mo14236f();
        return (f == null || f.length <= 0) ? new String[0] : f;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m7657a(Object obj) throws Exception {
        JSONObject jSONObject;
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            jSONObject = new JSONObject(str);
            if (!"success".equals(jSONObject.getString("message"))) {
                return false;
            }
        } else {
            jSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
        }
        if (jSONObject == null) {
            return false;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        synchronized (this) {
            Editor edit = this.f6068j.getSharedPreferences("ss_app_config", 0).edit();
            edit.putLong("last_refresh_time", System.currentTimeMillis());
            edit.apply();
        }
        if (TNCManager.m7771a().mo14249e() != null) {
            TNCManager.m7771a().mo14249e().mo14241a(jSONObject2);
        }
        return true;
    }

    /* renamed from: e */
    private boolean m7663e() {
        String[] d = mo14168d();
        if (!(d == null || d.length == 0)) {
            m7654a(0);
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7654a(final int i) {
        String[] d = mo14168d();
        if (d == null || d.length <= i) {
            m7659b(102);
            return;
        }
        String str = d[i];
        if (TextUtils.isEmpty(str)) {
            m7659b(102);
            return;
        }
        try {
            String b = m7658b(str);
            if (TextUtils.isEmpty(b)) {
                m7659b(102);
            } else {
                new JsonObjectRequest(0, b, new JSONObject(), (C1983a<JSONObject>) new C1983a<JSONObject>() {
                    /* renamed from: a */
                    public void mo14171a(C1982p<JSONObject> pVar) {
                        JSONObject jSONObject = (JSONObject) pVar.f6293a;
                        if (jSONObject == null) {
                            AppConfig.this.m7654a(i + 1);
                            return;
                        }
                        String str = null;
                        try {
                            str = jSONObject.getString("message");
                        } catch (Exception unused) {
                        }
                        if (!"success".equals(str)) {
                            AppConfig.this.m7654a(i + 1);
                            return;
                        }
                        try {
                            if (AppConfig.this.m7657a((Object) jSONObject)) {
                                AppConfig.this.m7659b(101);
                            } else {
                                AppConfig.this.m7654a(i + 1);
                            }
                        } catch (Exception unused2) {
                        }
                    }

                    /* renamed from: b */
                    public void mo14172b(C1982p<JSONObject> pVar) {
                        AppConfig.this.m7654a(i + 1);
                    }
                }).setRetryPolicy(new DefaultRetryPolicy().mo14330a((int) C7516p.f25219Cf).mo14333b(0)).build(AdNetSdk.m7641a(this.f6068j));
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("try app config exception: ");
            sb.append(th);
            C1987d.m7948b("AppConfig", sb.toString());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m7659b(int i) {
        WeakHandler jVar = this.f6060a;
        if (jVar != null) {
            jVar.sendEmptyMessage(i);
        }
    }

    /* renamed from: b */
    private String m7658b(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("https://");
        sb.append(str);
        sb.append("/get_domains/v4/");
        Address a = AdNetSdk.m7640a().mo14229a(this.f6068j);
        UrlBuilder iVar = new UrlBuilder(sb.toString());
        if (a != null && a.hasLatitude() && a.hasLongitude()) {
            iVar.mo14395a("latitude", a.getLatitude());
            iVar.mo14395a("longitude", a.getLongitude());
            String locality = a.getLocality();
            if (!TextUtils.isEmpty(locality)) {
                iVar.mo14397a("city", Uri.encode(locality));
            }
        }
        if (this.f6062d) {
            iVar.mo14396a(ArgKey.KEY_FORCE, 1);
        }
        try {
            if (VERSION.SDK_INT < 21) {
                str2 = Build.CPU_ABI;
            } else {
                str2 = Build.SUPPORTED_ABIS[0];
            }
            iVar.mo14397a("abi", str2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        iVar.mo14396a(DeviceInfo.TAG_ANDROID_ID, AdNetSdk.m7640a().mo14228a());
        iVar.mo14397a("device_platform", AdNetSdk.m7640a().mo14233c());
        iVar.mo14397a(ChannelReader.CHANNEL_KEY, AdNetSdk.m7640a().mo14232b());
        iVar.mo14396a("version_code", AdNetSdk.m7640a().mo14234d());
        iVar.mo14397a("device_id", AdNetSdk.m7640a().mo14235e());
        return iVar.toString();
    }
}
