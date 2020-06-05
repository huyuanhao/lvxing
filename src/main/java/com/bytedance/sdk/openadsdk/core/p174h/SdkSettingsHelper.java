package com.bytedance.sdk.openadsdk.core.p174h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.core.C1982p;
import com.bytedance.sdk.adnet.core.C1982p.C1983a;
import com.bytedance.sdk.adnet.p159b.JsonObjectRequest;
import com.bytedance.sdk.openadsdk.core.GlobalInfo;
import com.bytedance.sdk.openadsdk.core.IdUtils;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.downloadnew.TTDownloadFactory;
import com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo;
import com.bytedance.sdk.openadsdk.p188g.TTNetClient;
import com.bytedance.sdk.openadsdk.p190h.p197g.MD5;
import com.bytedance.sdk.openadsdk.p198i.TTExecutor;
import com.bytedance.sdk.openadsdk.utils.AdLocation;
import com.bytedance.sdk.openadsdk.utils.AdLocationUtils;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.C2566w;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.DigestUtils;
import com.bytedance.sdk.openadsdk.utils.FileUtils;
import com.bytedance.sdk.openadsdk.utils.OAIDHelper;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.tencent.mid.api.MidEntity;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.io.File;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.core.h.i */
public class SdkSettingsHelper implements Runnable {
    /* access modifiers changed from: private|static|final */
    /* renamed from: c */
    public static final AtomicLong f7641c = new AtomicLong(0);
    /* renamed from: d */
    private static volatile SdkSettingsHelper f7642d;
    /* renamed from: e */
    private static boolean f7643e = true;
    /* access modifiers changed from: private|static|volatile */
    /* renamed from: f */
    public static volatile boolean f7644f = false;
    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final ISettings f7645a;
    /* renamed from: b */
    private final Context f7646b;

    /* compiled from: SdkSettingsHelper */
    /* renamed from: com.bytedance.sdk.openadsdk.core.h.i$a */
    private class C2255a extends BroadcastReceiver {
        private C2255a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                int intExtra = intent.getIntExtra("b_msg_id", -1);
                if (intExtra == 1) {
                    long longExtra = intent.getLongExtra("b_msg_time", -1);
                    if (longExtra > 0) {
                        SdkSettingsHelper.f7641c.set(longExtra);
                    }
                } else if (intExtra == 2) {
                    try {
                        if (SdkSettingsHelper.this.f7645a != null) {
                            SdkSettingsHelper.this.f7645a.mo15741a();
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static SdkSettingsHelper m9740a(ISettings eVar) {
        if (f7642d == null) {
            synchronized (SdkSettingsHelper.class) {
                if (f7642d == null) {
                    f7642d = new SdkSettingsHelper(eVar);
                }
            }
        }
        return f7642d;
    }

    /* renamed from: a */
    public static void m9742a() {
        File file;
        try {
            Context a = InternalContainer.m10059a();
            String str = "shared_prefs";
            if (VERSION.SDK_INT >= 24) {
                file = new File(a.getDataDir(), str);
            } else {
                file = new File(a.getDatabasePath("1").getParentFile().getParentFile(), str);
            }
            File file2 = new File(file, "tt_sdk_settings.xml");
            if (file2.exists() && file2.isFile()) {
                String replace = file2.getName().replace(".xml", "");
                if (VERSION.SDK_INT >= 24) {
                    a.deleteSharedPreferences(replace);
                    return;
                }
                a.getSharedPreferences(replace, 0).edit().clear().apply();
                FileUtils.m12176c(file2);
            }
        } catch (Throwable unused) {
        }
    }

    private SdkSettingsHelper(ISettings eVar) {
        if (eVar == null) {
            eVar = InternalContainer.m10069h();
        }
        this.f7645a = eVar;
        this.f7646b = InternalContainer.m10059a();
        if (MultiGlobalInfo.m11808b()) {
            try {
                this.f7646b.registerReceiver(new C2255a(), new IntentFilter("com.bytedance.openadsdk.settingReceiver"));
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: b */
    public static void m9747b() {
        if (InternalContainer.m10059a() != null) {
            try {
                Intent intent = new Intent();
                intent.setAction("com.bytedance.openadsdk.settingReceiver");
                intent.putExtra("b_msg_id", 2);
                InternalContainer.m10059a().sendBroadcast(intent);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m9743a(long j) {
        if (j > 0 && InternalContainer.m10059a() != null) {
            try {
                Intent intent = new Intent();
                intent.setAction("com.bytedance.openadsdk.settingReceiver");
                intent.putExtra("b_msg_id", 1);
                intent.putExtra("b_msg_time", j);
                InternalContainer.m10059a().sendBroadcast(intent);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: c */
    public void mo15749c() {
        try {
            if (!m9751g()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - f7641c.get() >= 600000) {
                    f7641c.set(currentTimeMillis);
                    if (MultiGlobalInfo.m11808b()) {
                        m9743a(currentTimeMillis);
                    }
                    TTExecutor.m11692a().mo16807b(this, 10);
                }
            }
        } catch (Throwable th) {
            C2564t.m12216a("SdkSettingsHelper", "load sdk settings error: ", th);
        }
    }

    /* renamed from: g */
    private boolean m9751g() {
        return TextUtils.isEmpty(GlobalInfo.m9616c().mo15675e());
    }

    /* renamed from: d */
    public static boolean m9748d() {
        return f7644f;
    }

    public void run() {
        if (!C2566w.m12241a(this.f7646b)) {
            try {
                this.f7645a.mo15741a();
            } catch (Throwable unused) {
            }
        } else if (!m9751g()) {
            new JsonObjectRequest(1, ToolUtils.m12046q("/api/ad/union/sdk/settings/"), m9741a(m9752h()), (C1983a<JSONObject>) new C1983a<JSONObject>() {
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x00a2 */
                /* JADX WARNING: Removed duplicated region for block: B:24:0x0098 A[Catch:{ all -> 0x00a2 }] */
                /* JADX WARNING: Removed duplicated region for block: B:25:0x0099 A[Catch:{ all -> 0x00a2 }] */
                /* JADX WARNING: Removed duplicated region for block: B:30:0x00a8 A[Catch:{ all -> 0x00b5 }] */
                /* JADX WARNING: Removed duplicated region for block: B:35:0x00c3  */
                /* renamed from: a */
                public void mo14171a(com.bytedance.sdk.adnet.core.C1982p<org.json.JSONObject> r8) {
                    /*
                    r7 = this;
                    if (r8 == 0) goto L_0x00c7
                    T r0 = r8.f6293a
                    if (r0 == 0) goto L_0x00c7
                    T r0 = r8.f6293a
                    org.json.JSONObject r0 = (org.json.JSONObject) r0
                    r1 = -1
                    java.lang.String r2 = "cypher"
                    int r0 = r0.optInt(r2, r1)
                    T r1 = r8.f6293a
                    org.json.JSONObject r1 = (org.json.JSONObject) r1
                    java.lang.String r2 = "message"
                    r3 = 1
                    r4 = 0
                    java.lang.String r5 = "SdkSettingsHelper"
                    if (r0 != r3) goto L_0x0058
                    T r0 = r8.f6293a
                    org.json.JSONObject r0 = (org.json.JSONObject) r0
                    java.lang.String r0 = r0.optString(r2)
                    java.lang.String r2 = com.bytedance.sdk.openadsdk.core.AESKey.m9086a()
                    java.lang.String r0 = com.bytedance.sdk.openadsdk.core.AES.m9052b(r0, r2)
                    boolean r2 = android.text.TextUtils.isEmpty(r0)
                    if (r2 != 0) goto L_0x0094
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0051 }
                    r2.<init>()     // Catch:{ all -> 0x0051 }
                    java.lang.String r6 = "setting data : "
                    r2.append(r6)     // Catch:{ all -> 0x0051 }
                    java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x0051 }
                    r2.append(r6)     // Catch:{ all -> 0x0051 }
                    java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0051 }
                    com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r5, r2)     // Catch:{ all -> 0x0051 }
                    org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x0051 }
                    r2.<init>(r0)     // Catch:{ all -> 0x0051 }
                    goto L_0x008a
                L_0x0051:
                    r2 = move-exception
                    java.lang.String r6 = "setting data error: "
                    com.bytedance.sdk.openadsdk.utils.C2564t.m12216a(r5, r6, r2)
                    goto L_0x0094
                L_0x0058:
                    r6 = 2
                    if (r0 != r6) goto L_0x0093
                    T r0 = r8.f6293a
                    org.json.JSONObject r0 = (org.json.JSONObject) r0
                    java.lang.String r0 = r0.optString(r2)
                    java.lang.String r0 = com.bytedance.sdk.openadsdk.utils.ToolUtils.m12040k(r0)
                    boolean r2 = android.text.TextUtils.isEmpty(r0)
                    if (r2 != 0) goto L_0x0094
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x008c }
                    r2.<init>()     // Catch:{ all -> 0x008c }
                    java.lang.String r6 = "setting data1 : "
                    r2.append(r6)     // Catch:{ all -> 0x008c }
                    java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x008c }
                    r2.append(r6)     // Catch:{ all -> 0x008c }
                    java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x008c }
                    com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r5, r2)     // Catch:{ all -> 0x008c }
                    org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x008c }
                    r2.<init>(r0)     // Catch:{ all -> 0x008c }
                L_0x008a:
                    r1 = r2
                    goto L_0x0094
                L_0x008c:
                    r2 = move-exception
                    java.lang.String r6 = "setting data error2: "
                    com.bytedance.sdk.openadsdk.utils.C2564t.m12216a(r5, r6, r2)
                    goto L_0x0094
                L_0x0093:
                    r0 = r4
                L_0x0094:
                    com.bytedance.sdk.adnet.e.b$a r2 = r8.f6294b     // Catch:{ all -> 0x00a2 }
                    if (r2 != 0) goto L_0x0099
                    goto L_0x009d
                L_0x0099:
                    com.bytedance.sdk.adnet.e.b$a r8 = r8.f6294b     // Catch:{ all -> 0x00a2 }
                    java.util.Map<java.lang.String, java.lang.String> r4 = r8.f6331h     // Catch:{ all -> 0x00a2 }
                L_0x009d:
                    com.bytedance.sdk.openadsdk.core.h.i r8 = com.bytedance.sdk.openadsdk.core.p174h.SdkSettingsHelper.this     // Catch:{ all -> 0x00a2 }
                    r8.m9745a(r0, r4)     // Catch:{ all -> 0x00a2 }
                L_0x00a2:
                    boolean r8 = com.bytedance.sdk.openadsdk.core.p174h.SdkSettingsHelper.f7644f     // Catch:{ all -> 0x00b5 }
                    if (r8 != 0) goto L_0x00ab
                    com.bytedance.sdk.openadsdk.core.p174h.SdkSettingsHelper.f7644f = r3     // Catch:{ all -> 0x00b5 }
                L_0x00ab:
                    com.bytedance.sdk.openadsdk.core.h.i r8 = com.bytedance.sdk.openadsdk.core.p174h.SdkSettingsHelper.this     // Catch:{ all -> 0x00b5 }
                    com.bytedance.sdk.openadsdk.core.h.e r8 = r8.f7645a     // Catch:{ all -> 0x00b5 }
                    r8.mo15742a(r1)     // Catch:{ all -> 0x00b5 }
                    goto L_0x00b6
                L_0x00b6:
                    com.bytedance.sdk.openadsdk.f.a r8 = com.bytedance.sdk.openadsdk.p185f.StatsLogManager.m11278a()
                    r8.mo16569b()
                    boolean r8 = com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo.m11808b()
                    if (r8 == 0) goto L_0x00c6
                    com.bytedance.sdk.openadsdk.core.p174h.SdkSettingsHelper.m9747b()
                L_0x00c6:
                    return
                L_0x00c7:
                    com.bytedance.sdk.openadsdk.core.h.i r8 = com.bytedance.sdk.openadsdk.core.p174h.SdkSettingsHelper.this     // Catch:{ all -> 0x00d0 }
                    com.bytedance.sdk.openadsdk.core.h.e r8 = r8.f7645a     // Catch:{ all -> 0x00d0 }
                    r8.mo15741a()     // Catch:{ all -> 0x00d0 }
                L_0x00d0:
                    return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.p174h.SdkSettingsHelper.C22541.mo14171a(com.bytedance.sdk.adnet.core.p):void");
                }

                /* renamed from: b */
                public void mo14172b(C1982p<JSONObject> pVar) {
                    try {
                        SdkSettingsHelper.this.f7645a.mo15741a();
                    } catch (Throwable unused) {
                    }
                }
            }).setResponseOnMain(false).setShouldCache(false).build(TTNetClient.m11428a(this.f7646b).mo16657d());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9745a(String str, Map<String, String> map) {
        int i = 1;
        try {
            if (!TextUtils.isEmpty(str) && map != null) {
                int intValue = Integer.valueOf((String) map.get("active-control")).intValue();
                long longValue = Long.valueOf((String) map.get("ts")).longValue();
                String str2 = (String) map.get("pst");
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(intValue);
                sb.append(longValue);
                String a = MD5.m11646a(sb.toString());
                if (a != null && a.equalsIgnoreCase(str2)) {
                    i = intValue;
                }
            }
        } catch (Throwable unused) {
        }
        SdkSwitch.m9756a(i);
    }

    /* renamed from: h */
    private JSONObject m9752h() {
        String str = "2.9.5.5";
        JSONObject jSONObject = new JSONObject();
        try {
            AdLocation a = AdLocationUtils.m12114a(this.f7646b);
            if (a != null) {
                jSONObject.put("latitude", (double) a.f9146a);
                jSONObject.put("longitude", (double) a.f9147b);
            }
        } catch (Exception unused) {
        }
        int i = 1;
        try {
            jSONObject.put("ip", DeviceUtils.m12163a(true));
            jSONObject.put(MidEntity.TAG_IMEI, IdUtils.m9866d(this.f7646b));
            jSONObject.put("oaid", OAIDHelper.m12248a());
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("conn_type", C2566w.m12243b(this.f7646b));
            jSONObject.put("os", 1);
            jSONObject.put("oversea_version_type", 0);
            jSONObject.put("os_version", String.valueOf(VERSION.RELEASE));
            jSONObject.put("sdk_version", str);
            jSONObject.put("download_sdk_version", TTDownloadFactory.m11073a());
            jSONObject.put("package_name", ToolUtils.m12019d());
            String str2 = "position";
            if (!ToolUtils.m12020d(this.f7646b, ToolUtils.m12019d())) {
                i = 2;
            }
            jSONObject.put(str2, i);
            jSONObject.put("app_version", ToolUtils.m12027f());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put(ArgKey.KEY_APP_ID, GlobalInfo.m9616c().mo15675e());
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put("ts", currentTimeMillis);
            String str3 = "";
            if (GlobalInfo.m9616c().mo15675e() != null) {
                str3 = GlobalInfo.m9616c().mo15675e().concat(String.valueOf(currentTimeMillis)).concat(str);
            }
            jSONObject.put("req_sign", DigestUtils.m12169a(str3));
            StringBuilder sb = new StringBuilder();
            sb.append("app_version:");
            sb.append(ToolUtils.m12027f());
            sb.append("，vendor:");
            sb.append(Build.MANUFACTURER);
            C2564t.m12222c("isApplicationForeground", sb.toString());
        } catch (Exception unused2) {
        }
        return jSONObject;
    }

    /* renamed from: a */
    private JSONObject m9741a(JSONObject jSONObject) {
        return f7643e ? ToolUtils.m12000a(jSONObject) : jSONObject;
    }
}
