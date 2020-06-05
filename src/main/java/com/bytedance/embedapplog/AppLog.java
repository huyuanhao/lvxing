package com.bytedance.embedapplog;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.embed_device_register.C1779b;
import com.bytedance.embedapplog.collector.C1837a;
import com.bytedance.embedapplog.p141a.C1805e;
import com.bytedance.embedapplog.p142b.C1821h;
import com.bytedance.embedapplog.p142b.C1822i;
import com.bytedance.embedapplog.p144d.C1838a;
import com.bytedance.embedapplog.p144d.C1841c;
import com.bytedance.embedapplog.p144d.C1842d;
import com.bytedance.embedapplog.p144d.C1843e;
import com.bytedance.embedapplog.p144d.C1847i;
import com.bytedance.embedapplog.util.C1849a;
import com.bytedance.embedapplog.util.C1856h;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class AppLog {
    public static final String UMENG_CATEGORY = "umeng";
    /* renamed from: a */
    private static volatile C1821h f5003a = null;
    /* renamed from: b */
    private static boolean f5004b = true;
    /* renamed from: c */
    private static boolean f5005c = false;
    /* renamed from: d */
    private static C1849a f5006d = new C1849a();
    /* renamed from: e */
    private static volatile IExtraParams f5007e;
    public static ConcurrentHashMap<String, String> sCustomNetParams = new ConcurrentHashMap<>(4);
    public static C1822i sDevice;
    public static IAppParam sIAppParam;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Object, code=T, for r0v0, types: [java.lang.Object] */
    /* renamed from: a */
    private static <T> T m6243a(T r0, T r1) {
        /*
        if (r0 == 0) goto L_0x0003
        goto L_0x0004
    L_0x0003:
        r0 = 0
    L_0x0004:
        if (r0 != 0) goto L_0x0007
        r0 = r1
    L_0x0007:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.AppLog.m6243a(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public static boolean getEncryptAndCompress() {
        return true;
    }

    public static void setEncryptAndCompress(boolean z) {
    }

    private AppLog() {
        C1856h.m6582a(null);
    }

    public static void init(Context context, InitConfig initConfig) {
        if (!C1856h.f5226b && Looper.myLooper() != Looper.getMainLooper()) {
            C1856h.m6582a(new RuntimeException("Wrong thread!"));
        } else if (f5003a != null) {
            C1856h.m6582a(new RuntimeException("Init Twice!"));
            return;
        } else if (initConfig.getSensitiveInfoProvider() == null) {
            C1856h.m6582a(new RuntimeException("need to involve setSensitiveInfoProvider!"));
            return;
        }
        Application application = (Application) context.getApplicationContext();
        C1805e b = C1805e.m6275b();
        C1821h hVar = new C1821h(application, initConfig);
        C1822i iVar = new C1822i(application, hVar);
        b.mo13354a(application, hVar, iVar, new C1837a(initConfig.getPicker()));
        f5003a = hVar;
        sDevice = iVar;
        C1856h.m6585d("Inited", null);
    }

    public static void flush() {
        C1805e.m6272a();
    }

    public static void setUserUniqueID(String str) {
        C1822i iVar = sDevice;
        if (iVar != null) {
            iVar.mo13433c(str);
        }
    }

    public static ConcurrentHashMap<String, String> getCustomNetParams() {
        return sCustomNetParams;
    }

    public static void setCustomNetParams(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            sCustomNetParams.remove(str);
        } else {
            sCustomNetParams.put(str, str2);
        }
    }

    public static IExtraParams getExtraParams() {
        return f5007e;
    }

    public static void setExtraParams(IExtraParams iExtraParams) {
        if (f5007e == null && iExtraParams != null) {
            f5007e = iExtraParams;
        }
    }

    public static IAppParam getIAppParam() {
        return sIAppParam;
    }

    public static void setIAppParam(IAppParam iAppParam) {
        sIAppParam = iAppParam;
    }

    public static void setHeaderInfo(HashMap<String, Object> hashMap) {
        C1822i iVar = sDevice;
        if (iVar != null) {
            iVar.mo13427a(hashMap);
        }
    }

    public static void setAbSDKVersion(String str) {
        C1822i iVar = sDevice;
        if (iVar != null) {
            iVar.mo13426a(str);
        }
    }

    public static String getAbSDKVersion() {
        C1822i iVar = sDevice;
        if (iVar != null) {
            return iVar.mo13448q();
        }
        return null;
    }

    public static <T> T getAbConfig(String str, T t) {
        if (f5003a == null) {
            return null;
        }
        JSONObject c = f5003a.mo13398c(str);
        if (c == null) {
            return t;
        }
        String optString = c.optString("vid");
        Object opt = c.opt("val");
        sDevice.mo13437f(optString);
        return m6243a(opt, t);
    }

    public static JSONObject getAbConfig() {
        if (f5003a != null) {
            return f5003a.mo13421x();
        }
        return null;
    }

    public static String getAbConfigVersion() {
        if (f5003a != null) {
            return f5003a.mo13420w();
        }
        return null;
    }

    public static String getAid() {
        C1822i iVar = sDevice;
        return iVar != null ? iVar.mo13439h() : "";
    }

    public static <T> T getHeaderValue(String str, T t) {
        C1822i iVar = sDevice;
        if (iVar != null) {
            return iVar.mo13424a(str, t);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0034 A[SYNTHETIC, Splitter:B:21:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    public static byte[] toEncryptByte(java.lang.String r4) {
        /*
        java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
        r1 = 8192(0x2000, float:1.14794E-41)
        r0.<init>(r1)
        r1 = 0
        boolean r2 = getEncryptAndCompress()     // Catch:{ all -> 0x002e }
        java.lang.String r3 = "UTF-8"
        if (r2 == 0) goto L_0x0021
        java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x002e }
        r2.<init>(r0)     // Catch:{ all -> 0x002e }
        byte[] r4 = r4.getBytes(r3)     // Catch:{ all -> 0x001e }
        r2.write(r4)     // Catch:{ all -> 0x001e }
        r1 = r2
        goto L_0x0028
    L_0x001e:
        r4 = move-exception
        r1 = r2
        goto L_0x002f
    L_0x0021:
        byte[] r4 = r4.getBytes(r3)     // Catch:{ all -> 0x002e }
        r0.write(r4)     // Catch:{ all -> 0x002e }
    L_0x0028:
        if (r1 == 0) goto L_0x003c
        r1.close()     // Catch:{ IOException -> 0x0038 }
        goto L_0x003c
    L_0x002e:
        r4 = move-exception
    L_0x002f:
        com.bytedance.embedapplog.util.C1856h.m6582a(r4)     // Catch:{ all -> 0x004c }
        if (r1 == 0) goto L_0x003c
        r1.close()     // Catch:{ IOException -> 0x0038 }
        goto L_0x003c
    L_0x0038:
        r4 = move-exception
        com.bytedance.embedapplog.util.C1856h.m6582a(r4)
    L_0x003c:
        byte[] r4 = r0.toByteArray()
        boolean r0 = getEncryptAndCompress()
        if (r0 == 0) goto L_0x004b
        int r0 = r4.length
        byte[] r4 = com.bytedance.embedapplog.util.TTEncryptUtils.m6552a(r4, r0)
    L_0x004b:
        return r4
    L_0x004c:
        r4 = move-exception
        if (r1 == 0) goto L_0x0057
        r1.close()     // Catch:{ IOException -> 0x0053 }
        goto L_0x0057
    L_0x0053:
        r0 = move-exception
        com.bytedance.embedapplog.util.C1856h.m6582a(r0)
    L_0x0057:
        throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.AppLog.toEncryptByte(java.lang.String):byte[]");
    }

    public void setUserAgent(String str) {
        C1822i iVar = sDevice;
        if (iVar != null) {
            iVar.mo13431b(str);
        }
    }

    public static void onEvent(String str, String str2, String str3, long j, long j2, JSONObject jSONObject) {
        String str4 = null;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            if (C1856h.f5226b) {
                C1856h.m6581a("category or label is empty", null);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("");
            String str5 = str2;
            sb.append(str2);
            String str6 = str3;
            sb.append(str3);
            C1805e.m6273a((C1838a) new C1847i(sb.toString(), "2", 1));
            return;
        }
        if (jSONObject != null) {
            str4 = jSONObject.toString();
        }
        C1841c cVar = new C1841c(str, str2, str3, j, j2, str4);
        C1805e.m6273a((C1838a) cVar);
    }

    public static void onEvent(String str, String str2, String str3, long j, long j2) {
        onEvent(str, str2, str3, j, j2, null);
    }

    public static void onEvent(String str, String str2) {
        onEvent(UMENG_CATEGORY, str, str2, 0, 0, null);
    }

    public static void onEvent(String str) {
        onEvent(UMENG_CATEGORY, str, null, 0, 0, null);
    }

    public static void onEventV3(String str, JSONObject jSONObject) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            C1856h.m6581a("eventName is empty", null);
            C1805e.m6273a((C1838a) new C1847i("", "2", 1));
        }
        if (jSONObject != null) {
            str2 = jSONObject.toString();
        }
        C1805e.m6273a((C1838a) new C1843e(str, false, str2));
    }

    public static void onEventV3(String str, Bundle bundle) {
        JSONObject jSONObject;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    jSONObject = new JSONObject();
                    try {
                        for (String str2 : bundle.keySet()) {
                            jSONObject.put(str2, bundle.get(str2));
                        }
                    } catch (Throwable th) {
                        th = th;
                        C1856h.m6582a(th);
                        onEventV3(str, jSONObject);
                    }
                    onEventV3(str, jSONObject);
                }
            } catch (Throwable th2) {
                th = th2;
                jSONObject = null;
                C1856h.m6582a(th);
                onEventV3(str, jSONObject);
            }
        }
        jSONObject = null;
        onEventV3(str, jSONObject);
    }

    public static void onInternalEventV3(String str, JSONObject jSONObject, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("second_app_");
            sb.append(str);
            String sb2 = sb.toString();
            try {
                jSONObject.put("params_for_special", "second_app");
                jSONObject.put("second_appid", str2);
                jSONObject.put("second_appname", str3);
                jSONObject.put("product_type", str4);
            } catch (Throwable th) {
                C1856h.m6582a(th);
            }
            C1805e.m6273a((C1838a) new C1843e(sb2, false, jSONObject.toString()));
            return;
        }
        C1856h.m6583b("both second appid and second app name is empty, return", null);
    }

    public static void onInternalEventV3(String str, Bundle bundle, String str2, String str3, String str4) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("second_app_");
            sb.append(str);
            String sb2 = sb.toString();
            if (bundle != null) {
                try {
                    if (!bundle.isEmpty()) {
                        jSONObject = new JSONObject();
                        try {
                            for (String str5 : bundle.keySet()) {
                                jSONObject.put(str5, bundle.get(str5));
                            }
                            jSONObject.put("params_for_special", "second_app");
                            jSONObject.put("second_appid", str2);
                            jSONObject.put("second_appname", str3);
                            jSONObject.put("product_type", str4);
                        } catch (Throwable th) {
                            th = th;
                            C1856h.m6582a(th);
                            onEventV3(sb2, jSONObject);
                            return;
                        }
                        onEventV3(sb2, jSONObject);
                        return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    jSONObject = null;
                    C1856h.m6582a(th);
                    onEventV3(sb2, jSONObject);
                    return;
                }
            }
            jSONObject = null;
            onEventV3(sb2, jSONObject);
            return;
        }
        C1856h.m6583b("both second appid and second app name is empty, return", null);
    }

    public static void onMiscEvent(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null || jSONObject.length() <= 0) {
            C1856h.m6583b("call onEventData with invalid params, return", null);
            return;
        }
        try {
            C1805e.m6273a((C1838a) new C1842d(str, jSONObject));
        } catch (Exception e) {
            C1856h.m6584c("call onEventData get exception: ", e);
        }
    }

    public static void setEnableLog(boolean z) {
        C1856h.f5226b = z;
    }

    public static void setAutoActiveState(boolean z) {
        f5004b = z;
    }

    public static boolean getAutoActiveState() {
        return f5004b;
    }

    public static boolean manualActivate() {
        if (sDevice != null) {
            return C1805e.m6275b().mo13356e();
        }
        return false;
    }

    public static String getDid() {
        C1822i iVar = sDevice;
        return iVar != null ? iVar.mo13438g() : "";
    }

    public static String getUdid() {
        C1822i iVar = sDevice;
        return iVar != null ? iVar.mo13440i() : "";
    }

    public static String getIid() {
        C1822i iVar = sDevice;
        return iVar != null ? iVar.mo13441j() : "";
    }

    public static String getSsid() {
        C1822i iVar = sDevice;
        return iVar != null ? iVar.mo13442k() : "";
    }

    public static String getUserUniqueID() {
        C1822i iVar = sDevice;
        return iVar != null ? iVar.mo13443l() : "";
    }

    public static String getClientUdid() {
        C1822i iVar = sDevice;
        return iVar != null ? iVar.mo13444m() : "";
    }

    public static String getOpenUdid() {
        C1822i iVar = sDevice;
        return iVar != null ? iVar.mo13445n() : "";
    }

    public static void addDataObserver(IDataObserver iDataObserver) {
        f5006d.mo13496a(iDataObserver);
    }

    public static void removeDataObserver(IDataObserver iDataObserver) {
        f5006d.mo13497b(iDataObserver);
    }

    public static IDataObserver getDataObserver() {
        return f5006d;
    }

    public static int getSuccRate() {
        if (f5003a != null) {
            return f5003a.mo13409l();
        }
        return 0;
    }

    public static void setOaidObserver(IOaidObserver iOaidObserver) {
        C1779b.m6172a(iOaidObserver);
    }

    public static InitConfig getInitConfig() {
        if (f5003a != null) {
            return f5003a.mo13384S();
        }
        return null;
    }
}
