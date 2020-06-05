package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.adnet.core.C1982p;
import com.bytedance.sdk.adnet.core.C1982p.C1983a;
import com.bytedance.sdk.adnet.err.AuthFailureError;
import com.bytedance.sdk.adnet.err.ParseError;
import com.bytedance.sdk.adnet.err.TimeoutError;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.p159b.JsonObjectRequest;
import com.bytedance.sdk.adnet.p159b.JsonStringRequest;
import com.bytedance.sdk.adnet.p159b.RequestFuture;
import com.bytedance.sdk.adnet.p159b.StringRequest;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.NetApi.C2286a;
import com.bytedance.sdk.openadsdk.core.NetApi.C2287b;
import com.bytedance.sdk.openadsdk.core.NetApi.C2288c;
import com.bytedance.sdk.openadsdk.core.p168b.FrequentCallControllerAdapter;
import com.bytedance.sdk.openadsdk.core.p170d.AdInfo;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.p170d.NetExtParams;
import com.bytedance.sdk.openadsdk.core.p170d.TempPkgModel;
import com.bytedance.sdk.openadsdk.core.p170d.VerifyData;
import com.bytedance.sdk.openadsdk.core.p174h.ApplistHelper;
import com.bytedance.sdk.openadsdk.core.p174h.ISettings;
import com.bytedance.sdk.openadsdk.core.p174h.ProcessPushHelper;
import com.bytedance.sdk.openadsdk.core.p174h.SdkSettingsHelper;
import com.bytedance.sdk.openadsdk.core.p174h.SdkSwitch;
import com.bytedance.sdk.openadsdk.p165c.AdEvent;
import com.bytedance.sdk.openadsdk.p165c.AdEventManager;
import com.bytedance.sdk.openadsdk.p165c.AdEventUploadResult;
import com.bytedance.sdk.openadsdk.p188g.TTNetClient;
import com.bytedance.sdk.openadsdk.utils.AdLocation;
import com.bytedance.sdk.openadsdk.utils.AdLocationUtils;
import com.bytedance.sdk.openadsdk.utils.BitmapUtils;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.C2566w;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.DigestUtils;
import com.bytedance.sdk.openadsdk.utils.InstallAppUtils;
import com.bytedance.sdk.openadsdk.utils.OAIDHelper;
import com.bytedance.sdk.openadsdk.utils.RomUtils;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.bytedance.sdk.openadsdk.utils.UIUtils;
import com.p522qq.p523e.comm.p525pi.ACTD;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import com.tencent.p605ep.commonbase.software.AppEntity;
import com.tencent.qqpim.discovery.internal.protocol.C7516p;
import com.tencent.stat.common.DeviceInfo;
import discoveryAD.C7880W.C7881a;
import discoveryAD.C7895e;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.core.q */
public class NetApiImpl implements NetApi<AdEvent> {
    /* renamed from: f */
    private static boolean f7875f = true;
    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final Context f7876a;
    /* renamed from: b */
    private final boolean f7877b = m10123g();
    /* renamed from: c */
    private final String f7878c = m10126j();
    /* renamed from: d */
    private long f7879d;
    /* renamed from: e */
    private int f7880e;

    /* compiled from: NetApiImpl */
    /* renamed from: com.bytedance.sdk.openadsdk.core.q$a */
    public static class C2294a {
        /* renamed from: a */
        final int f7894a;
        /* renamed from: b */
        final long f7895b;
        /* renamed from: c */
        final long f7896c;
        /* renamed from: d */
        final int f7897d;
        /* renamed from: e */
        final String f7898e;
        /* renamed from: f */
        final int f7899f;
        /* renamed from: g */
        final String f7900g;
        /* renamed from: h */
        public final AdInfo f7901h;
        /* renamed from: i */
        final String f7902i;

        private C2294a(String str, int i, int i2, String str2, int i3, String str3, AdInfo aVar, long j, long j2) {
            this.f7894a = i;
            this.f7897d = i2;
            this.f7898e = str2;
            this.f7900g = str3;
            this.f7901h = aVar;
            this.f7902i = str;
            this.f7899f = i3;
            this.f7895b = j;
            this.f7896c = j2;
        }

        /* renamed from: a */
        public static C2294a m10143a(JSONObject jSONObject) {
            return m10144a(jSONObject, null);
        }

        /* renamed from: a */
        public static C2294a m10144a(JSONObject jSONObject, AdSlot adSlot) {
            String optString = jSONObject.optString("did");
            int optInt = jSONObject.optInt("processing_time_ms");
            long optLong = jSONObject.optLong("s_receive_ts");
            long optLong2 = jSONObject.optLong("s_send_ts");
            int optInt2 = jSONObject.optInt("status_code");
            String optString2 = jSONObject.optString(ArgKey.KEY_DESC);
            String optString3 = jSONObject.optString("request_id");
            int optInt3 = jSONObject.optInt("reason");
            AdInfo a = AdInfoFactory.m9162a(jSONObject, adSlot);
            if (a != null) {
                a.mo15331a(jSONObject.optLong("request_after"));
            }
            C2294a aVar = new C2294a(optString, optInt, optInt2, optString2, optInt3, optString3, a, optLong, optLong2);
            return aVar;
        }
    }

    /* compiled from: NetApiImpl */
    /* renamed from: com.bytedance.sdk.openadsdk.core.q$b */
    public static class C2295b {
        /* renamed from: a */
        public final int f7903a;
        /* renamed from: b */
        public final boolean f7904b;

        private C2295b(int i, boolean z) {
            this.f7903a = i;
            this.f7904b = z;
        }

        /* renamed from: a */
        public static C2295b m10145a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new C2295b(jSONObject.optInt("error_code"), jSONObject.optBoolean(ArgKey.KEY_RESULT));
        }
    }

    /* compiled from: NetApiImpl */
    /* renamed from: com.bytedance.sdk.openadsdk.core.q$c */
    public static class C2296c {
        /* renamed from: a */
        public final int f7905a;
        /* renamed from: b */
        public final boolean f7906b;
        /* renamed from: c */
        public final VerifyData f7907c;

        private C2296c(int i, boolean z, VerifyData qVar) {
            this.f7905a = i;
            this.f7906b = z;
            this.f7907c = qVar;
        }

        /* renamed from: a */
        public static C2296c m10146a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int optInt = jSONObject.optInt("code");
            boolean optBoolean = jSONObject.optBoolean("verify");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            VerifyData qVar = new VerifyData();
            if (optJSONObject != null) {
                try {
                    qVar.mo15580a(optJSONObject.optInt("reason"));
                    qVar.mo15583b(optJSONObject.optInt("corp_type"));
                    qVar.mo15584c(optJSONObject.optInt("reward_amount"));
                    qVar.mo15581a(optJSONObject.optString("reward_name"));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return new C2296c(optInt, optBoolean, qVar);
        }
    }

    /* renamed from: a */
    private int m10090a(int i) {
        return C7516p.f25219Cf;
    }

    /* renamed from: b */
    private static String m10108b(int i) {
        String str = "mdpi";
        return i != 120 ? i != 160 ? i != 240 ? i != 320 ? i != 480 ? i != 640 ? str : "xxxhdpi" : "xxhdpi" : "xhdpi" : "hdpi" : str : "ldpi";
    }

    NetApiImpl(Context context) {
        this.f7876a = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0033 A[Catch:{ Exception -> 0x0155 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008e A[Catch:{ Exception -> 0x0155 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0140 A[SYNTHETIC, Splitter:B:48:0x0140] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0147 A[Catch:{ Exception -> 0x0155 }] */
    /* renamed from: a */
    private org.json.JSONObject m10094a(com.bytedance.sdk.openadsdk.AdSlot r11, com.bytedance.sdk.openadsdk.core.p170d.NetExtParams r12, int r13) {
        /*
        r10 = this;
        java.lang.String r0 = "app"
        java.lang.String r1 = "2.9.5.5"
        java.lang.String r2 = "ad_sdk_version"
        org.json.JSONObject r3 = new org.json.JSONObject
        r3.<init>()
        org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0155 }
        r4.<init>()     // Catch:{ Exception -> 0x0155 }
        if (r12 == 0) goto L_0x001e
        java.lang.String r5 = r12.f7450a     // Catch:{ Exception -> 0x0155 }
        boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0155 }
        if (r5 == 0) goto L_0x001b
        goto L_0x001e
    L_0x001b:
        java.lang.String r5 = r12.f7450a     // Catch:{ Exception -> 0x0155 }
        goto L_0x0022
    L_0x001e:
        java.lang.String r5 = com.bytedance.sdk.openadsdk.utils.ToolUtils.m12008b()     // Catch:{ Exception -> 0x0155 }
    L_0x0022:
        r6 = 7
        java.lang.String r7 = "req_type"
        if (r13 != r6) goto L_0x0033
        if (r12 == 0) goto L_0x0042
        int r6 = r12.f7451b     // Catch:{ Exception -> 0x0155 }
        if (r6 <= 0) goto L_0x0042
        int r6 = r12.f7451b     // Catch:{ Exception -> 0x0155 }
        r4.put(r7, r6)     // Catch:{ Exception -> 0x0155 }
        goto L_0x0042
    L_0x0033:
        r6 = 8
        if (r13 != r6) goto L_0x0042
        if (r12 == 0) goto L_0x0042
        int r6 = r12.f7452c     // Catch:{ Exception -> 0x0155 }
        if (r6 <= 0) goto L_0x0042
        int r6 = r12.f7452c     // Catch:{ Exception -> 0x0155 }
        r4.put(r7, r6)     // Catch:{ Exception -> 0x0155 }
    L_0x0042:
        com.bytedance.sdk.openadsdk.core.h.l r6 = com.bytedance.sdk.openadsdk.core.InternalContainer.m10069h()     // Catch:{ all -> 0x0072 }
        java.lang.String r6 = r6.mo15791h()     // Catch:{ all -> 0x0072 }
        com.bytedance.sdk.openadsdk.core.h.l r7 = com.bytedance.sdk.openadsdk.core.InternalContainer.m10069h()     // Catch:{ all -> 0x0072 }
        java.lang.String r7 = r7.mo15793i()     // Catch:{ all -> 0x0072 }
        boolean r8 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0072 }
        if (r8 != 0) goto L_0x0072
        boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0072 }
        if (r8 != 0) goto L_0x0072
        org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ all -> 0x0072 }
        r8.<init>()     // Catch:{ all -> 0x0072 }
        java.lang.String r9 = "version"
        r8.put(r9, r6)     // Catch:{ all -> 0x0072 }
        java.lang.String r6 = "param"
        r8.put(r6, r7)     // Catch:{ all -> 0x0072 }
        java.lang.String r6 = "abtest"
        r4.put(r6, r8)     // Catch:{ all -> 0x0072 }
    L_0x0072:
        java.lang.String r6 = "request_id"
        r4.put(r6, r5)     // Catch:{ Exception -> 0x0155 }
        r4.put(r2, r1)     // Catch:{ Exception -> 0x0155 }
        java.lang.String r6 = "source_type"
        r4.put(r6, r0)     // Catch:{ Exception -> 0x0155 }
        org.json.JSONObject r6 = r10.m10110b()     // Catch:{ Exception -> 0x0155 }
        r4.put(r0, r6)     // Catch:{ Exception -> 0x0155 }
        android.content.Context r0 = r10.f7876a     // Catch:{ Exception -> 0x0155 }
        org.json.JSONObject r0 = com.bytedance.sdk.openadsdk.utils.DeviceUtils.m12167d(r0)     // Catch:{ Exception -> 0x0155 }
        if (r0 == 0) goto L_0x00b2
        com.bytedance.sdk.openadsdk.core.h.l r6 = com.bytedance.sdk.openadsdk.core.InternalContainer.m10069h()     // Catch:{ Exception -> 0x0155 }
        boolean r6 = r6.mo15758F()     // Catch:{ Exception -> 0x0155 }
        if (r6 != 0) goto L_0x00a3
        boolean r6 = com.bytedance.sdk.openadsdk.downloadnew.p181a.LibHolder.m11230b()     // Catch:{ Exception -> 0x0155 }
        if (r6 != 0) goto L_0x00a3
        java.lang.String r6 = "free_space"
        r0.remove(r6)     // Catch:{ Exception -> 0x0155 }
    L_0x00a3:
        int r6 = r11.getOrientation()     // Catch:{ Exception -> 0x0155 }
        if (r6 <= 0) goto L_0x00b2
        java.lang.String r6 = "orientation"
        int r7 = r11.getOrientation()     // Catch:{ Exception -> 0x0155 }
        r0.put(r6, r7)     // Catch:{ Exception -> 0x0155 }
    L_0x00b2:
        java.lang.String r6 = "device"
        r4.put(r6, r0)     // Catch:{ Exception -> 0x0155 }
        java.lang.String r0 = "user"
        org.json.JSONObject r6 = r10.m10118d()     // Catch:{ Exception -> 0x0155 }
        r4.put(r0, r6)     // Catch:{ Exception -> 0x0155 }
        java.lang.String r0 = "ua"
        java.lang.String r6 = com.bytedance.sdk.openadsdk.core.Sdk.f7908a     // Catch:{ Exception -> 0x0155 }
        r4.put(r0, r6)     // Catch:{ Exception -> 0x0155 }
        java.lang.String r0 = "ip"
        java.lang.String r6 = r10.m10120e()     // Catch:{ Exception -> 0x0155 }
        r4.put(r0, r6)     // Catch:{ Exception -> 0x0155 }
        org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ Exception -> 0x0155 }
        r0.<init>()     // Catch:{ Exception -> 0x0155 }
        org.json.JSONObject r13 = r10.m10093a(r11, r13, r12)     // Catch:{ Exception -> 0x0155 }
        r0.put(r13)     // Catch:{ Exception -> 0x0155 }
        java.lang.String r13 = "adslots"
        r4.put(r13, r0)     // Catch:{ Exception -> 0x0155 }
        r10.m10104a(r4, r12)     // Catch:{ Exception -> 0x0155 }
        long r12 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0155 }
        r6 = 1000(0x3e8, double:4.94E-321)
        long r12 = r12 / r6
        java.lang.String r0 = "ts"
        r4.put(r0, r12)     // Catch:{ Exception -> 0x0155 }
        java.lang.String r0 = ""
        java.lang.String r6 = r11.getCodeId()     // Catch:{ Exception -> 0x0155 }
        if (r6 == 0) goto L_0x010a
        if (r5 == 0) goto L_0x010a
        java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ Exception -> 0x0155 }
        java.lang.String r11 = r11.getCodeId()     // Catch:{ Exception -> 0x0155 }
        java.lang.String r11 = r12.concat(r11)     // Catch:{ Exception -> 0x0155 }
        java.lang.String r0 = r11.concat(r5)     // Catch:{ Exception -> 0x0155 }
    L_0x010a:
        java.lang.String r11 = "req_sign"
        java.lang.String r12 = com.bytedance.sdk.openadsdk.utils.DigestUtils.m12169a(r0)     // Catch:{ Exception -> 0x0155 }
        r4.put(r11, r12)     // Catch:{ Exception -> 0x0155 }
        java.lang.String r11 = r10.m10127k()     // Catch:{ Exception -> 0x0155 }
        java.lang.String r12 = r10.m10117d(r11)     // Catch:{ Exception -> 0x0155 }
        java.lang.String r13 = r4.toString()     // Catch:{ Exception -> 0x0155 }
        java.lang.String r12 = com.bytedance.sdk.openadsdk.core.AES.m9050a(r13, r12)     // Catch:{ Exception -> 0x0155 }
        r13 = 2
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0155 }
        r0.<init>()     // Catch:{ Exception -> 0x0155 }
        r0.append(r13)     // Catch:{ Exception -> 0x0155 }
        r0.append(r11)     // Catch:{ Exception -> 0x0155 }
        r0.append(r12)     // Catch:{ Exception -> 0x0155 }
        java.lang.String r11 = r0.toString()     // Catch:{ Exception -> 0x0155 }
        boolean r12 = r10.m10112b(r12)     // Catch:{ Exception -> 0x0155 }
        java.lang.String r0 = "cypher"
        java.lang.String r5 = "message"
        if (r12 == 0) goto L_0x0147
        r3.put(r5, r11)     // Catch:{ Exception -> 0x0155 }
        r3.put(r0, r13)     // Catch:{ Exception -> 0x0155 }
        goto L_0x0152
    L_0x0147:
        java.lang.String r11 = r4.toString()     // Catch:{ Exception -> 0x0155 }
        r3.put(r5, r11)     // Catch:{ Exception -> 0x0155 }
        r11 = 0
        r3.put(r0, r11)     // Catch:{ Exception -> 0x0155 }
    L_0x0152:
        r3.put(r2, r1)     // Catch:{ Exception -> 0x0155 }
    L_0x0155:
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.NetApiImpl.m10094a(com.bytedance.sdk.openadsdk.AdSlot, com.bytedance.sdk.openadsdk.core.d.l, int):org.json.JSONObject");
    }

    /* renamed from: a */
    private void m10104a(JSONObject jSONObject, NetExtParams lVar) {
        if (lVar != null && lVar.f7453d != null) {
            try {
                jSONObject.put("source_temai_product_ids", lVar.f7453d);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    private boolean m10107a(String str) {
        if (FrequentCallControllerAdapter.m9101a()) {
            return true;
        }
        if (!FrequentCallControllerAdapter.m9102a(str)) {
            return false;
        }
        String b = FrequentCallControllerAdapter.m9103b();
        if (!TextUtils.isEmpty(b)) {
            AdEventManager.m8390a(this.f7876a, b, System.currentTimeMillis());
        }
        return true;
    }

    /* renamed from: a */
    public void mo15917a(AdSlot adSlot, NetExtParams lVar, int i, C2287b bVar) {
        C2287b bVar2 = bVar;
        if (!SdkSwitch.m9757a()) {
            if (bVar2 != null) {
                bVar2.mo14946a(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            }
            return;
        }
        SdkSettingsHelper.m9740a((ISettings) null).mo15749c();
        ProcessPushHelper.m9725a().mo15744b();
        ApplistHelper.m9686a().mo15716b();
        if (bVar2 != null) {
            if (m10107a(adSlot.getCodeId())) {
                bVar2.mo14946a(-8, C2240g.m9576a(-8));
                return;
            }
            final JSONObject a = m10094a(adSlot, lVar, i);
            if (a == null) {
                bVar2.mo14946a(-9, C2240g.m9576a(-9));
                return;
            }
            String q = ToolUtils.m12046q("/api/ad/union/sdk/get_ads/");
            final C2287b bVar3 = bVar;
            final AdSlot adSlot2 = adSlot;
            final int i2 = i;
            final NetExtParams lVar2 = lVar;
            C22891 r0 = new C1983a<JSONObject>() {
                /* renamed from: a */
                public void mo14171a(C1982p<JSONObject> pVar) {
                    boolean z;
                    long j;
                    C1982p<JSONObject> pVar2 = pVar;
                    try {
                        j = ((Long) pVar2.mo14371a("extra_time_start")).longValue();
                        z = true;
                    } catch (Throwable unused) {
                        j = 0;
                        z = false;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject a = NetApiImpl.this.m10121e((JSONObject) pVar2.f6293a);
                    if (a == null) {
                        NetApiImpl.this.m10099a(bVar3);
                        NetApiImpl.this.m10097a(pVar2.f6297e, adSlot2.getCodeId(), i2, null, -1, "mate parse_fail");
                        return;
                    }
                    try {
                        C2294a a2 = C2294a.m10144a(a, adSlot2);
                        IdUtils.m9862a(NetApiImpl.this.f7876a, a2.f7902i);
                        if (a2.f7897d != 20000) {
                            bVar3.mo14946a(a2.f7897d, a2.f7898e);
                            NetApiImpl qVar = NetApiImpl.this;
                            long j2 = pVar2.f6297e;
                            String codeId = adSlot2.getCodeId();
                            int i = i2;
                            qVar.m10097a(j2, codeId, i, a2, a2.f7897d, String.valueOf(a2.f7899f));
                        } else if (a2.f7901h == null) {
                            NetApiImpl.this.m10099a(bVar3);
                            NetApiImpl.this.m10097a(pVar2.f6297e, adSlot2.getCodeId(), i2, a2, -1, "parse_fail");
                        } else {
                            a2.f7901h.mo15337c(a.toString());
                            long currentTimeMillis2 = System.currentTimeMillis();
                            bVar3.mo14947a(a2.f7901h);
                            if (z && a2.f7901h.mo15336c() != null && !a2.f7901h.mo15336c().isEmpty()) {
                                MaterialMeta kVar = (MaterialMeta) a2.f7901h.mo15336c().get(0);
                                String b = ToolUtils.m12009b(i2);
                                HashMap hashMap = new HashMap();
                                if (lVar2 != null && lVar2.f7455f > 0) {
                                    hashMap.put("client_start_time", Long.valueOf(j - lVar2.f7455f));
                                    hashMap.put("load_ts", Long.valueOf(lVar2.f7455f));
                                    hashMap.put("total_time", Long.valueOf(currentTimeMillis2 - lVar2.f7455f));
                                }
                                hashMap.put("request_ts", Long.valueOf(j));
                                hashMap.put("s_revice_ts", Long.valueOf(a2.f7895b));
                                hashMap.put("s_send_ts", Long.valueOf(a2.f7896c));
                                hashMap.put("c_revice_ts", Long.valueOf(currentTimeMillis));
                                hashMap.put("c_end_ts", Long.valueOf(currentTimeMillis2));
                                hashMap.put("network_time", Long.valueOf(pVar2.f6298f));
                                hashMap.put("go_time", Long.valueOf(a2.f7895b - j));
                                hashMap.put("sever_time", Integer.valueOf(a2.f7894a));
                                hashMap.put("back_time", Long.valueOf(currentTimeMillis - a2.f7896c));
                                hashMap.put("client_end_time", Long.valueOf(currentTimeMillis2 - currentTimeMillis));
                                AdEventManager.m8394a(kVar, b, (Map<String, Object>) hashMap);
                            }
                        }
                    } catch (Throwable th) {
                        C2564t.m12223c("NetApiImpl", "get ad error: ", th);
                        NetApiImpl.this.m10099a(bVar3);
                        NetApiImpl.this.m10097a(pVar2.f6297e, adSlot2.getCodeId(), i2, null, -1, "parse_fail");
                    }
                }

                /* renamed from: b */
                public void mo14172b(C1982p<JSONObject> pVar) {
                    int i;
                    VAdError vAdError = pVar.f6295c;
                    if (vAdError instanceof ParseError) {
                        NetApiImpl.this.m10099a(bVar3);
                        NetApiImpl.this.m10097a(pVar.f6297e, adSlot2.getCodeId(), i2, null, -1, C2240g.m9576a(-1));
                        return;
                    }
                    String a = C2240g.m9576a(-2);
                    if (vAdError == null || pVar == null) {
                        i = -2;
                    } else {
                        int i2 = (int) pVar.f6300h;
                        a = vAdError.getMessage();
                        i = i2;
                    }
                    bVar3.mo14946a(i, a);
                    NetApiImpl.this.m10097a(pVar.f6297e, adSlot2.getCodeId(), i2, null, i, vAdError instanceof TimeoutError ? "SocketTimeout" : a);
                }
            };
            C22902 r02 = new JsonObjectRequest(1, q, a, r0) {
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap hashMap = new HashMap();
                    hashMap.put("ss-sign", SecSdkHelper.m10148b(IdUtils.m9858a(NetApiImpl.this.f7876a)).mo15925d(a.toString()));
                    return hashMap;
                }
            };
            int i3 = i;
            r02.setRetryPolicy(TTNetClient.m11430b().mo14330a(m10090a(i)).mo14333b(0)).setUserAgent(Sdk.f7908a).setShouldCache(false).addExtra("extra_time_start", Long.valueOf(System.currentTimeMillis())).build(TTNetClient.m11428a(this.f7876a).mo16658e());
        }
    }

    /* renamed from: b */
    private boolean m10112b(String str) {
        return !TextUtils.isEmpty(str);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008d A[Catch:{ all -> 0x00b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a9 A[Catch:{ all -> 0x00b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ad A[Catch:{ all -> 0x00b3 }] */
    /* renamed from: a */
    public void m10097a(long r4, java.lang.String r6, int r7, com.bytedance.sdk.openadsdk.core.NetApiImpl.C2294a r8, int r9, java.lang.String r10) {
        /*
        r3 = this;
        boolean r0 = com.bytedance.sdk.openadsdk.core.p174h.SdkSwitch.m9757a()
        if (r0 != 0) goto L_0x0007
        return
    L_0x0007:
        r0 = 4
        if (r7 == r0) goto L_0x000e
        r0 = 3
        if (r7 == r0) goto L_0x000e
        return
    L_0x000e:
        boolean r0 = android.text.TextUtils.isEmpty(r10)
        if (r0 == 0) goto L_0x0018
        java.lang.String r10 = com.bytedance.sdk.openadsdk.core.C2240g.m9576a(r9)
    L_0x0018:
        com.bytedance.sdk.openadsdk.f.a.c r0 = new com.bytedance.sdk.openadsdk.f.a.c
        r0.m44011init()
        com.bytedance.sdk.openadsdk.f.a.d r7 = r0.mo16590a(r7)
        com.bytedance.sdk.openadsdk.f.a.c r7 = (com.bytedance.sdk.openadsdk.p185f.p186a.LoadAdNoRspLog) r7
        com.bytedance.sdk.openadsdk.f.a.d r7 = r7.mo16592b(r9)
        com.bytedance.sdk.openadsdk.f.a.c r7 = (com.bytedance.sdk.openadsdk.p185f.p186a.LoadAdNoRspLog) r7
        com.bytedance.sdk.openadsdk.f.a.d r7 = r7.mo16603g(r10)
        com.bytedance.sdk.openadsdk.f.a.c r7 = (com.bytedance.sdk.openadsdk.p185f.p186a.LoadAdNoRspLog) r7
        r9 = 0
        java.lang.String r10 = ""
        if (r8 == 0) goto L_0x0071
        com.bytedance.sdk.openadsdk.core.d.a r0 = r8.f7901h     // Catch:{ all -> 0x00b3 }
        if (r0 == 0) goto L_0x0071
        com.bytedance.sdk.openadsdk.core.d.a r0 = r8.f7901h     // Catch:{ all -> 0x00b3 }
        java.util.List r0 = r0.mo15336c()     // Catch:{ all -> 0x00b3 }
        if (r0 == 0) goto L_0x0071
        com.bytedance.sdk.openadsdk.core.d.a r0 = r8.f7901h     // Catch:{ all -> 0x00b3 }
        java.util.List r0 = r0.mo15336c()     // Catch:{ all -> 0x00b3 }
        int r0 = r0.size()     // Catch:{ all -> 0x00b3 }
        if (r0 <= 0) goto L_0x0071
        com.bytedance.sdk.openadsdk.core.d.a r9 = r8.f7901h     // Catch:{ all -> 0x00b3 }
        java.util.List r9 = r9.mo15336c()     // Catch:{ all -> 0x00b3 }
        r0 = 0
        java.lang.Object r9 = r9.get(r0)     // Catch:{ all -> 0x00b3 }
        com.bytedance.sdk.openadsdk.core.d.k r9 = (com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta) r9     // Catch:{ all -> 0x00b3 }
        java.lang.String r0 = r9.mo15428P()     // Catch:{ all -> 0x00b3 }
        boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00b3 }
        if (r1 != 0) goto L_0x006f
        org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x006f }
        r1.<init>(r0)     // Catch:{ all -> 0x006f }
        java.lang.String r2 = "req_id"
        java.lang.String r1 = r1.getString(r2)     // Catch:{ all -> 0x006f }
        goto L_0x0073
    L_0x006f:
        r1 = r10
        goto L_0x0073
    L_0x0071:
        r0 = r10
        r1 = r0
    L_0x0073:
        boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00b3 }
        if (r2 == 0) goto L_0x0085
        if (r8 == 0) goto L_0x0085
        com.bytedance.sdk.openadsdk.core.d.a r2 = r8.f7901h     // Catch:{ all -> 0x00b3 }
        if (r2 == 0) goto L_0x0085
        com.bytedance.sdk.openadsdk.core.d.a r1 = r8.f7901h     // Catch:{ all -> 0x00b3 }
        java.lang.String r1 = r1.mo15329a()     // Catch:{ all -> 0x00b3 }
    L_0x0085:
        com.bytedance.sdk.openadsdk.f.a.d r1 = r7.mo16601f(r1)     // Catch:{ all -> 0x00b3 }
        com.bytedance.sdk.openadsdk.f.a.c r1 = (com.bytedance.sdk.openadsdk.p185f.p186a.LoadAdNoRspLog) r1     // Catch:{ all -> 0x00b3 }
        if (r9 == 0) goto L_0x0091
        java.lang.String r10 = r9.mo15425M()     // Catch:{ all -> 0x00b3 }
    L_0x0091:
        com.bytedance.sdk.openadsdk.f.a.d r9 = r1.mo16597d(r10)     // Catch:{ all -> 0x00b3 }
        com.bytedance.sdk.openadsdk.f.a.c r9 = (com.bytedance.sdk.openadsdk.p185f.p186a.LoadAdNoRspLog) r9     // Catch:{ all -> 0x00b3 }
        com.bytedance.sdk.openadsdk.f.a.d r9 = r9.mo16605h(r0)     // Catch:{ all -> 0x00b3 }
        com.bytedance.sdk.openadsdk.f.a.c r9 = (com.bytedance.sdk.openadsdk.p185f.p186a.LoadAdNoRspLog) r9     // Catch:{ all -> 0x00b3 }
        com.bytedance.sdk.openadsdk.f.a.d r6 = r9.mo16595c(r6)     // Catch:{ all -> 0x00b3 }
        com.bytedance.sdk.openadsdk.f.a.c r6 = (com.bytedance.sdk.openadsdk.p185f.p186a.LoadAdNoRspLog) r6     // Catch:{ all -> 0x00b3 }
        com.bytedance.sdk.openadsdk.f.a.c r4 = r6.mo16588a(r4)     // Catch:{ all -> 0x00b3 }
        if (r8 == 0) goto L_0x00ad
        int r5 = r8.f7894a     // Catch:{ all -> 0x00b3 }
        long r5 = (long) r5     // Catch:{ all -> 0x00b3 }
        goto L_0x00af
    L_0x00ad:
        r5 = 0
    L_0x00af:
        r4.mo16589b(r5)     // Catch:{ all -> 0x00b3 }
        goto L_0x00bb
    L_0x00b3:
        r4 = move-exception
        java.lang.String r5 = "NetApiImpl"
        java.lang.String r6 = "uploadAdTypeTimeOutEvent throws exception "
        com.bytedance.sdk.openadsdk.utils.C2564t.m12223c(r5, r6, r4)
    L_0x00bb:
        com.bytedance.sdk.openadsdk.f.a r4 = com.bytedance.sdk.openadsdk.p185f.StatsLogManager.m11278a()
        r4.mo16573e(r7)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.NetApiImpl.m10097a(long, java.lang.String, int, com.bytedance.sdk.openadsdk.core.q$a, int, java.lang.String):void");
    }

    /* renamed from: a */
    public AdEventUploadResult mo15913a(List<AdEvent> list) {
        String str;
        C1982p pVar = null;
        if (!SdkSwitch.m9757a()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        boolean z = false;
        try {
            m10098a((AdEvent) list.get(0));
            jSONObject.put("header", m10122f());
            JSONArray jSONArray = new JSONArray();
            for (AdEvent aVar : list) {
                jSONArray.put(aVar.f6744b);
            }
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, jSONArray);
            jSONObject.put("_gen_time", System.currentTimeMillis());
        } catch (JSONException unused) {
        }
        String a = AES.m9050a(jSONObject.toString(), AESKey.m9087b());
        if (!m10112b(a)) {
            a = jSONObject.toString();
        }
        String str2 = a;
        StringBuilder sb = new StringBuilder();
        sb.append("adevent is :");
        sb.append(jSONObject.toString());
        C2564t.m12220b("adevent", sb.toString());
        final Map c = m10115c(str2);
        RequestFuture a2 = RequestFuture.m7746a();
        C22913 r3 = new JsonObjectRequest(1, ToolUtils.m12031g(), str2, a2) {
            public Map<String, String> getHeaders() throws AuthFailureError {
                return c;
            }
        };
        r3.setRetryPolicy(TTNetClient.m11430b().mo14330a((int) C7516p.f25219Cf)).setUserAgent(Sdk.f7908a).build(TTNetClient.m11428a(this.f7876a).mo16657d());
        try {
            pVar = a2.get();
        } catch (Throwable unused2) {
        }
        boolean z2 = pVar != null && m10113b((JSONObject) pVar.f6293a);
        int i = pVar != null ? (int) pVar.f6300h : 0;
        if (z2 || i != 200) {
            str = (pVar == null || pVar.f6295c == null) ? "error unknown" : pVar.f6295c.getMessage();
        } else {
            str = "server say not success";
            z = true;
        }
        return new AdEventUploadResult(z2, i, str, z);
    }

    /* renamed from: a */
    public void mo15918a(MaterialMeta kVar, List<FilterWord> list) {
        if (SdkSwitch.m9757a()) {
            JSONObject b = m10111b(kVar, list);
            if (b != null) {
                new JsonStringRequest(1, ToolUtils.m12046q("/api/ad/union/dislike_event/"), ToolUtils.m12000a(b), null).setRetryPolicy(TTNetClient.m11430b().mo14330a((int) C7516p.f25219Cf)).build(TTNetClient.m11428a(this.f7876a).mo16657d());
            }
        }
    }

    /* renamed from: b */
    private JSONObject m10111b(MaterialMeta kVar, List<FilterWord> list) {
        JSONObject jSONObject = new JSONObject();
        AdLocation a = AdLocationUtils.m12114a(this.f7876a);
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("action", "dislike");
            jSONObject2.put(C7881a.TIMESTAMP, System.currentTimeMillis());
            jSONObject2.put("ad_sdk_version", "2.9.5.5");
            if (a != null) {
                jSONObject2.put("latitude", (double) a.f9146a);
                jSONObject2.put("longitude", (double) a.f9147b);
            }
            jSONObject2.put("extra", kVar.mo15428P());
            jSONObject2.put("filter_words", m10109b(list));
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put("actions", jSONArray);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* renamed from: b */
    private JSONArray m10109b(List<FilterWord> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (FilterWord id : list) {
            jSONArray.put(id.getId());
        }
        return jSONArray;
    }

    /* renamed from: c */
    private Map<String, String> m10115c(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json; charset=utf-8");
        if (m10112b(str)) {
            hashMap.put("Content-Encoding", "union_sdk_encode");
        }
        return hashMap;
    }

    /* renamed from: b */
    private boolean m10113b(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                return jSONObject.optString("message").equalsIgnoreCase("success");
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10099a(C2287b bVar) {
        bVar.mo14946a(-1, C2240g.m9576a(-1));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10100a(C2288c cVar) {
        cVar.mo14968a(-1, C2240g.m9576a(-1));
    }

    /* renamed from: b */
    private JSONObject m10110b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ACTD.APPID_KEY, GlobalInfo.m9616c().mo15675e());
            jSONObject.put(ArgKey.KEY_NAME, GlobalInfo.m9616c().mo15676f());
            m10116c(jSONObject);
            m10119d(jSONObject);
            jSONObject.put("is_paid_app", GlobalInfo.m9616c().mo15677g());
            jSONObject.put("apk_sign", SecSdkHelper.m10148b(IdUtils.m9858a(this.f7876a)).mo15922a());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* renamed from: c */
    private String m10114c() {
        return DeviceUtils.m12161a();
    }

    /* renamed from: d */
    private JSONObject m10118d() {
        JSONObject jSONObject = new JSONObject();
        try {
            m10106a(jSONObject, "keywords", GlobalInfo.m9616c().mo15678h());
            JSONArray a = InstallAppUtils.m12199a(this.f7876a);
            if (a != null) {
                jSONObject.put("app_list", a);
            }
            m10106a(jSONObject, "data", GlobalInfo.m9616c().mo15679i());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* renamed from: a */
    private void m10106a(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put(str, str2);
        }
    }

    /* renamed from: c */
    private void m10116c(JSONObject jSONObject) {
        try {
            jSONObject.put("package_name", ToolUtils.m12019d());
            jSONObject.put("version_code", ToolUtils.m12023e());
            jSONObject.put(AppEntity.KEY_VERSION_STR, ToolUtils.m12027f());
        } catch (Exception unused) {
        }
    }

    /* renamed from: d */
    private void m10119d(JSONObject jSONObject) {
        AdLocation a = AdLocationUtils.m12114a(this.f7876a);
        if (a != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("latitude", (double) a.f9146a);
                jSONObject2.put("longitude", (double) a.f9147b);
                jSONObject.put("geo", jSONObject2);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: e */
    private String m10120e() {
        return DeviceUtils.m12163a(true);
    }

    /* renamed from: a */
    private JSONObject m10093a(AdSlot adSlot, int i, NetExtParams lVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", adSlot.getCodeId());
            jSONObject.put("adtype", i);
            String str = "render_method";
            if (lVar != null) {
                jSONObject.put(str, lVar.f7454e);
            } else {
                jSONObject.put(str, 1);
            }
            jSONObject.put("ptpl_ids", InternalContainer.m10069h().mo15792h(adSlot.getCodeId()));
            jSONObject.put("pos", AdSlot.getPosition(i));
            m10105a(jSONObject, "accepted_size", adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight());
            jSONObject.put("is_support_dpl", adSlot.isSupportDeepLink());
            if (adSlot.getNativeAdType() > 0 || i == 9 || i == 5) {
                jSONObject.put("is_origin_ad", true);
            }
            if (!(lVar == null || lVar.f7456g == null)) {
                jSONObject.put("session_params", lVar.f7456g);
            }
            int adCount = adSlot.getAdCount();
            if (adCount < 1) {
                adCount = 1;
            }
            if (adCount > 3) {
                adCount = 3;
            }
            if (i == 7 || i == 8) {
                adCount = 1;
            }
            if (!(lVar == null || lVar.f7453d == null)) {
                adCount = adSlot.getAdCount();
            }
            jSONObject.put("ad_count", adCount);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* renamed from: a */
    private void m10105a(JSONObject jSONObject, String str, int i, int i2) {
        if (i > 0 && i2 > 0) {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            try {
                jSONObject2.put("width", i);
                jSONObject2.put("height", i2);
                jSONArray.put(jSONObject2);
                jSONObject.put(str, jSONArray);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    private void m10098a(AdEvent aVar) {
        if (aVar != null && aVar.f6744b != null) {
            String optString = aVar.f6744b.optString("log_extra", "");
            long e = ToolUtils.m12022e(optString);
            int f = ToolUtils.m12026f(optString);
            if (e == 0) {
                e = this.f7879d;
            }
            this.f7879d = e;
            if (f == 0) {
                f = this.f7880e;
            }
            this.f7880e = f;
        }
    }

    /* renamed from: f */
    private JSONObject m10122f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ua", Sdk.f7908a);
            jSONObject.put("udid", IdUtils.m9866d(this.f7876a));
            jSONObject.put("openudid", IdUtils.m9865c(this.f7876a));
            jSONObject.put("oaid", OAIDHelper.m12248a());
            jSONObject.put("ad_sdk_version", "2.9.5.5");
            jSONObject.put("sim_op", m10092a(this.f7876a));
            jSONObject.put("root", this.f7877b ? 1 : 0);
            jSONObject.put("timezone", m10125i());
            jSONObject.put("access", C2566w.m12247f(this.f7876a));
            jSONObject.put("os", "Android");
            jSONObject.put("os_version", VERSION.RELEASE);
            jSONObject.put("os_api", VERSION.SDK_INT);
            jSONObject.put("device_type", this.f7878c);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
            jSONObject.put("language", Locale.getDefault().getLanguage());
            StringBuilder sb = new StringBuilder();
            sb.append(UIUtils.m12084d(this.f7876a));
            sb.append("x");
            sb.append(UIUtils.m12078c(this.f7876a));
            jSONObject.put("resolution", sb.toString());
            jSONObject.put("display_density", m10108b(UIUtils.m12089f(this.f7876a)));
            jSONObject.put("density_dpi", UIUtils.m12089f(this.f7876a));
            jSONObject.put(DeviceInfo.TAG_MAC, m10114c());
            jSONObject.put("device_id", IdUtils.m9858a(this.f7876a));
            jSONObject.put(DeviceInfo.TAG_ANDROID_ID, "1371");
            jSONObject.put("rom", m10124h());
            jSONObject.put("cpu_abi", Build.CPU_ABI);
            jSONObject.put("build_serial", IdUtils.m9871i(this.f7876a));
            jSONObject.put("ut", this.f7880e);
            jSONObject.put(AppEntity.KEY_UID, this.f7879d);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* renamed from: g */
    private static boolean m10123g() {
        try {
            return new File("/system/bin/su").exists() || new File("/system/xbin/su").exists();
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    private static String m10092a(Context context) {
        String str = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager == null ? str : telephonyManager.getSimOperator();
        } catch (Throwable unused) {
            return str;
        }
    }

    /* renamed from: h */
    private static String m10124h() {
        StringBuilder sb = new StringBuilder();
        try {
            if (RomUtils.m11951e()) {
                sb.append("MIUI-");
            } else if (RomUtils.m11946b()) {
                sb.append("FLYME-");
            } else {
                String n = RomUtils.m11960n();
                if (RomUtils.m11944a(n)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(n)) {
                    sb.append(n);
                    sb.append("-");
                }
            }
            sb.append(VERSION.INCREMENTAL);
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    /* renamed from: i */
    private static int m10125i() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / C7895e.f26887Bc;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    /* renamed from: j */
    private String m10126j() {
        if (DeviceUtils.m12165b(this.f7876a)) {
            return "tv";
        }
        return DeviceUtils.m12164a(this.f7876a) ? "android_pad" : "android";
    }

    /* renamed from: k */
    private String m10127k() {
        String a = AES.m9048a();
        return a == null ? AESKey.m9086a() : a;
    }

    /* renamed from: d */
    private String m10117d(String str) {
        String a = AES.m9049a(str);
        if (str != null) {
            return a;
        }
        String a2 = AESKey.m9086a();
        return a2.concat(a2).substring(8, 24);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0053  */
    /* renamed from: e */
    public org.json.JSONObject m10121e(org.json.JSONObject r6) {
        /*
        r5 = this;
        if (r6 != 0) goto L_0x0003
        return r6
    L_0x0003:
        boolean r0 = f7875f     // Catch:{ Exception -> 0x004e }
        if (r0 == 0) goto L_0x004e
        java.lang.String r0 = "cypher"
        r1 = -1
        int r0 = r6.optInt(r0, r1)     // Catch:{ Exception -> 0x004e }
        java.lang.String r1 = "message"
        java.lang.String r1 = r6.optString(r1)     // Catch:{ Exception -> 0x004e }
        r2 = 1
        if (r0 != r2) goto L_0x0020
        java.lang.String r3 = com.bytedance.sdk.openadsdk.core.AESKey.m9086a()     // Catch:{ Exception -> 0x004e }
        java.lang.String r3 = com.bytedance.sdk.openadsdk.core.AES.m9052b(r1, r3)     // Catch:{ Exception -> 0x004e }
        goto L_0x0021
    L_0x0020:
        r3 = r1
    L_0x0021:
        r4 = 2
        if (r0 != r4) goto L_0x0042
        boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x004e }
        if (r0 != 0) goto L_0x0042
        int r0 = r1.length()     // Catch:{ Exception -> 0x004e }
        r4 = 17
        if (r0 < r4) goto L_0x0042
        java.lang.String r0 = r1.substring(r2, r4)     // Catch:{ Exception -> 0x004e }
        java.lang.String r0 = r5.m10117d(r0)     // Catch:{ Exception -> 0x004e }
        java.lang.String r1 = r1.substring(r4)     // Catch:{ Exception -> 0x004e }
        java.lang.String r3 = com.bytedance.sdk.openadsdk.core.AES.m9052b(r1, r0)     // Catch:{ Exception -> 0x004e }
    L_0x0042:
        boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x004e }
        if (r0 != 0) goto L_0x004e
        org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{  }
        r0.<init>(r3)     // Catch:{  }
        goto L_0x004f
    L_0x004e:
        r0 = r6
    L_0x004f:
        boolean r1 = f7875f
        if (r1 == 0) goto L_0x0054
        r6 = r0
    L_0x0054:
        return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.NetApiImpl.m10121e(org.json.JSONObject):org.json.JSONObject");
    }

    /* renamed from: a */
    public void mo15920a(JSONObject jSONObject, final C2288c cVar) {
        if (!SdkSwitch.m9757a()) {
            if (cVar != null) {
                cVar.mo14968a(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            }
            return;
        }
        if (!(jSONObject == null || cVar == null)) {
            new JsonObjectRequest(1, ToolUtils.m12046q("/api/ad/union/sdk/reward_video/reward/"), ToolUtils.m12000a(jSONObject), (C1983a<JSONObject>) new C1983a<JSONObject>() {
                /* renamed from: a */
                public void mo14171a(C1982p<JSONObject> pVar) {
                    if (pVar == null || pVar.f6293a == null) {
                        NetApiImpl.this.m10100a(cVar);
                    } else {
                        int optInt = ((JSONObject) pVar.f6293a).optInt("cypher", -1);
                        String optString = ((JSONObject) pVar.f6293a).optString("message");
                        JSONObject jSONObject = (JSONObject) pVar.f6293a;
                        String str = null;
                        if (optInt == 1) {
                            str = AES.m9052b(optString, AESKey.m9086a());
                        } else if (optInt == 2) {
                            str = ToolUtils.m12040k(optString);
                        }
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                jSONObject = new JSONObject(str);
                            } catch (Throwable unused) {
                            }
                        }
                        C2296c a = C2296c.m10146a(jSONObject);
                        if (a.f7905a != 20000) {
                            cVar.mo14968a(a.f7905a, C2240g.m9576a(a.f7905a));
                        } else if (a.f7907c == null) {
                            NetApiImpl.this.m10100a(cVar);
                        } else {
                            cVar.mo14969a(a);
                        }
                    }
                }

                /* renamed from: b */
                public void mo14172b(C1982p<JSONObject> pVar) {
                    int i = -2;
                    String a = C2240g.m9576a(-2);
                    if (pVar != null) {
                        i = (int) pVar.f6300h;
                    }
                    if (!(pVar == null || pVar.f6295c == null)) {
                        a = pVar.f6295c.getMessage();
                    }
                    cVar.mo14968a(i, a);
                }
            }).setRetryPolicy(TTNetClient.m11430b().mo14330a((int) C7516p.f25219Cf)).build(TTNetClient.m11428a(this.f7876a).mo16657d());
        }
    }

    /* renamed from: a */
    public void mo15916a(int i, String str, String str2, Bitmap bitmap) {
        String str3 = ":";
        if (SdkSwitch.m9757a() && bitmap != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(str3);
                sb.append(i);
                sb.append(str3);
                sb.append(str2);
                String a = DigestUtils.m12169a(sb.toString());
                jSONObject.put("rit", i);
                jSONObject.put("req_id", str);
                jSONObject.put("ad_id", str2);
                jSONObject.put("sign", a);
                jSONObject.put("image", BitmapUtils.m12137a(bitmap));
            } catch (Throwable unused) {
            }
            new JsonObjectRequest(1, ToolUtils.m12046q("/union/service/sdk/upload/v2/"), ToolUtils.m12000a(jSONObject), null).setRetryPolicy(TTNetClient.m11430b().mo14330a((int) C7516p.f25219Cf)).setShouldCache(false).build(TTNetClient.m11428a(this.f7876a).mo16657d());
            try {
                if (!bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            } catch (Throwable unused2) {
            }
        }
    }

    /* renamed from: a */
    private JSONObject m10096a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            String a = AES.m9050a(str, AESKey.m9086a());
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            StringBuilder sb = new StringBuilder("id=");
            sb.append(a);
            sb.append("&timestamp=");
            sb.append(currentTimeMillis);
            sb.append("&ext=");
            sb.append(str2);
            String upperCase = DigestUtils.m12169a(sb.toString()).toUpperCase();
            jSONObject.put("id", a);
            jSONObject.put(C7881a.TIMESTAMP, currentTimeMillis);
            jSONObject.put("sign", upperCase);
            jSONObject.put("ext", str2);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* renamed from: a */
    public void mo15919a(String str, String str2, final C2286a aVar) {
        if (!SdkSwitch.m9757a()) {
            if (aVar != null) {
                aVar.mo15248a(false, -1, 0);
            }
            return;
        }
        if (!(str == null || str2 == null || aVar == null)) {
            new JsonObjectRequest(1, ToolUtils.m12046q("/api/ad/union/sdk/material/check/"), ToolUtils.m12000a(m10096a(str, str2)), (C1983a<JSONObject>) new C1983a<JSONObject>() {
                /* renamed from: a */
                public void mo14171a(C1982p<JSONObject> pVar) {
                    long j;
                    long j2;
                    boolean z;
                    if (pVar.f6293a != null) {
                        C2295b a = C2295b.m10145a((JSONObject) pVar.f6293a);
                        long j3 = (long) a.f7903a;
                        long j4 = pVar.f6298f;
                        z = a.f7904b;
                        j2 = j3;
                        j = j4;
                    } else {
                        j2 = -1;
                        j = 0;
                        z = false;
                    }
                    aVar.mo15248a(z, j2, j);
                }

                /* renamed from: b */
                public void mo14172b(C1982p<JSONObject> pVar) {
                    aVar.mo15248a(false, pVar.f6300h != 0 ? pVar.f6300h : -1, pVar.f6298f);
                }
            }).setRetryPolicy(TTNetClient.m11430b().mo14330a(800)).build(TTNetClient.m11428a(this.f7876a).mo16657d());
        }
    }

    /* renamed from: a */
    public AdEventUploadResult mo15914a(JSONObject jSONObject) {
        boolean z;
        if (!SdkSwitch.m9757a() || jSONObject == null || jSONObject.length() <= 0) {
            return null;
        }
        RequestFuture a = RequestFuture.m7746a();
        boolean z2 = true;
        new JsonObjectRequest(1, ToolUtils.m12046q("/api/ad/union/sdk/stats/batch/"), ToolUtils.m12000a(jSONObject), (C1983a<JSONObject>) a).setRetryPolicy(TTNetClient.m11430b().mo14330a((int) C7516p.f25219Cf)).setUserAgent(Sdk.f7908a).build(TTNetClient.m11428a(this.f7876a).mo16657d());
        String str = "error unknown";
        int i = 0;
        try {
            C1982p b = a.get();
            if (b == null) {
                return new AdEventUploadResult(false, 0, str, false);
            }
            if (b.f6293a != null) {
                int optInt = ((JSONObject) b.f6293a).optInt("code", -1);
                str = ((JSONObject) b.f6293a).optString("data", "");
                z = optInt == 20000;
                if (optInt != 60005) {
                    z2 = false;
                }
            } else {
                z2 = false;
                z = false;
            }
            try {
                i = (int) b.f6300h;
                if (b.f6295c != null) {
                    str = b.f6295c.getMessage();
                }
            } catch (Throwable unused) {
            }
            return new AdEventUploadResult(z, i, str, z2);
        } catch (Throwable unused2) {
            z2 = false;
            z = false;
        }
    }

    /* renamed from: a */
    public boolean mo15921a(JSONObject jSONObject, int i) {
        String str = "success";
        boolean z = false;
        if (!SdkSwitch.m9757a()) {
            return false;
        }
        if (jSONObject == null || jSONObject.length() <= 0) {
            return true;
        }
        RequestFuture a = RequestFuture.m7746a();
        new JsonObjectRequest(1, "https://i.snssdk.com/inspect/aegis/client/page/", jSONObject, (C1983a<JSONObject>) a).setRetryPolicy(TTNetClient.m11430b().mo14330a((int) C7516p.f25219Cf).mo14333b(i)).build(TTNetClient.m11428a(this.f7876a).mo16657d());
        try {
            C1982p b = a.get();
            if (!(b == null || b.f6293a == null)) {
                z = str.equals(((JSONObject) b.f6293a).optString(NotificationCompat.CATEGORY_STATUS, str));
            }
        } catch (Throwable unused) {
        }
        return z;
    }

    /* renamed from: a */
    public TempPkgModel mo15915a() {
        C1982p pVar;
        TempPkgModel oVar = null;
        if (!SdkSwitch.m9757a()) {
            return null;
        }
        RequestFuture a = RequestFuture.m7746a();
        new StringRequest(0, "https://sf3-ttcdn-tos.pstatp.com/obj/ad-pattern/renderer/package.json", a).setRetryPolicy(TTNetClient.m11430b().mo14330a((int) C7516p.f25219Cf)).setShouldCache(false).build(TTNetClient.m11428a(this.f7876a).mo16657d());
        try {
            pVar = a.get();
        } catch (Exception unused) {
            pVar = null;
        }
        if (pVar != null && pVar.mo14373a()) {
            oVar = TempPkgModel.m9470d((String) pVar.f6293a);
        }
        return oVar;
    }
}
