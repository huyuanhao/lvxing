package com.tencent.stat.common;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.stat.C7614e;
import com.tencent.stat.NetworkManager;
import com.tencent.stat.StatConfig;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Marker;

/* renamed from: com.tencent.stat.common.a */
public class C7592a {
    /* renamed from: a */
    static C7594a f25653a;
    /* renamed from: d */
    private static StatLogger f25654d = StatCommonHelper.getLogger();
    /* renamed from: e */
    private static JSONObject f25655e = new JSONObject();
    /* renamed from: b */
    Integer f25656b = null;
    /* renamed from: c */
    String f25657c = null;

    /* renamed from: com.tencent.stat.common.a$a */
    static class C7594a {
        /* renamed from: a */
        String f25658a;
        /* renamed from: b */
        String f25659b;
        /* renamed from: c */
        DisplayMetrics f25660c;
        /* renamed from: d */
        int f25661d;
        /* renamed from: e */
        String f25662e;
        /* renamed from: f */
        String f25663f;
        /* renamed from: g */
        String f25664g;
        /* renamed from: h */
        String f25665h;
        /* renamed from: i */
        String f25666i;
        /* renamed from: j */
        String f25667j;
        /* renamed from: k */
        String f25668k;
        /* renamed from: l */
        int f25669l;
        /* renamed from: m */
        String f25670m;
        /* renamed from: n */
        String f25671n;
        /* renamed from: o */
        String f25672o;
        /* renamed from: p */
        Context f25673p;
        /* renamed from: q */
        private String f25674q;
        /* renamed from: r */
        private String f25675r;
        /* renamed from: s */
        private String f25676s;
        /* renamed from: t */
        private String f25677t;
        /* renamed from: u */
        private String f25678u;

        private C7594a(Context context) {
            this.f25659b = StatConstants.VERSION;
            this.f25661d = VERSION.SDK_INT;
            this.f25662e = Build.MODEL;
            this.f25663f = Build.MANUFACTURER;
            this.f25664g = Locale.getDefault().getLanguage();
            this.f25669l = 0;
            this.f25671n = null;
            this.f25672o = null;
            this.f25673p = null;
            this.f25674q = null;
            this.f25675r = null;
            this.f25676s = null;
            this.f25677t = null;
            this.f25678u = null;
            this.f25673p = Util.getContextSelf(context);
            this.f25660c = StatCommonHelper.getDisplayMetrics(this.f25673p);
            this.f25658a = StatCommonHelper.getCurAppVersion(this.f25673p);
            this.f25665h = StatConfig.getInstallChannel(this.f25673p);
            this.f25666i = StatCommonHelper.getSimOperator(this.f25673p);
            this.f25667j = TimeZone.getDefault().getID();
            this.f25669l = StatCommonHelper.hasRootAccess(this.f25673p);
            this.f25668k = StatCommonHelper.getExternalStorageInfo(this.f25673p);
            this.f25671n = this.f25673p.getPackageName();
            int i = this.f25661d;
            this.f25675r = StatCommonHelper.getCpuInfo(this.f25673p).toString();
            this.f25676s = StatCommonHelper.getSystemMemory(this.f25673p);
            this.f25677t = StatCommonHelper.getRomMemory();
            this.f25672o = StatCommonHelper.getLauncherPackageName(this.f25673p);
            this.f25678u = StatCommonHelper.getCurAppSHA1Signature(this.f25673p);
            this.f25670m = StatCommonHelper.getDeviceIMSI(this.f25673p);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo37121a(JSONObject jSONObject, Thread thread) throws JSONException {
            if (thread == null) {
                if (this.f25660c != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.f25660c.widthPixels);
                    String str = Marker.ANY_MARKER;
                    sb.append(str);
                    sb.append(this.f25660c.heightPixels);
                    jSONObject.put("sr", sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.f25660c.xdpi);
                    sb2.append(str);
                    sb2.append(this.f25660c.ydpi);
                    jSONObject.put("dpi", sb2.toString());
                }
                if (NetworkManager.getInstance(this.f25673p).isWifi()) {
                    JSONObject jSONObject2 = new JSONObject();
                    Util.jsonPut(jSONObject2, "bs", Util.getWiFiBBSID(this.f25673p));
                    Util.jsonPut(jSONObject2, "ss", Util.getWiFiSSID(this.f25673p));
                    if (jSONObject2.length() > 0) {
                        Util.jsonPut(jSONObject, "wf", jSONObject2.toString());
                    }
                }
                JSONArray wifiTopN = Util.getWifiTopN(this.f25673p, 10);
                if (wifiTopN != null && wifiTopN.length() > 0) {
                    Util.jsonPut(jSONObject, "wflist", wifiTopN.toString());
                }
                Util.jsonPut(jSONObject, "sen", this.f25674q);
            } else {
                Util.jsonPut(jSONObject, "thn", thread.getName());
                Util.jsonPut(jSONObject, "qq", StatConfig.getQQ(this.f25673p));
                Util.jsonPut(jSONObject, "cui", StatConfig.getCustomUserId(this.f25673p));
                String str2 = "/";
                if (StatCommonHelper.isStringValid(this.f25676s) && this.f25676s.split(str2).length == 2) {
                    Util.jsonPut(jSONObject, "fram", this.f25676s.split(str2)[0]);
                }
                if (StatCommonHelper.isStringValid(this.f25677t) && this.f25677t.split(str2).length == 2) {
                    Util.jsonPut(jSONObject, "from", this.f25677t.split(str2)[0]);
                }
                if (C7614e.m32812a(this.f25673p).mo37149b(this.f25673p) != null) {
                    jSONObject.put(DeviceInfo.TAG_IMEI, C7614e.m32812a(this.f25673p).mo37149b(this.f25673p).getImei());
                }
                Util.jsonPut(jSONObject, "mid", StatConfig.getLocalMidOnly(this.f25673p));
            }
            Util.jsonPut(jSONObject, "pcn", StatCommonHelper.getCurProcessName(this.f25673p));
            Util.jsonPut(jSONObject, "osn", VERSION.RELEASE);
            String appVersion = StatConfig.getAppVersion();
            String str3 = "av";
            if (!StatCommonHelper.isStringValid(appVersion)) {
                Util.jsonPut(jSONObject, str3, this.f25658a);
            } else {
                Util.jsonPut(jSONObject, str3, appVersion);
                Util.jsonPut(jSONObject, "appv", this.f25658a);
            }
            Util.jsonPut(jSONObject, "ch", this.f25665h);
            Util.jsonPut(jSONObject, "mf", this.f25663f);
            Util.jsonPut(jSONObject, "sv", this.f25659b);
            Util.jsonPut(jSONObject, "osd", Build.DISPLAY);
            Util.jsonPut(jSONObject, "prod", Build.PRODUCT);
            Util.jsonPut(jSONObject, "tags", Build.TAGS);
            Util.jsonPut(jSONObject, "id", Build.ID);
            Util.jsonPut(jSONObject, "fng", Build.FINGERPRINT);
            Util.jsonPut(jSONObject, "lch", this.f25672o);
            Util.jsonPut(jSONObject, "ov", Integer.toString(this.f25661d));
            jSONObject.put("os", 1);
            Util.jsonPut(jSONObject, "op", this.f25666i);
            Util.jsonPut(jSONObject, "lg", this.f25664g);
            Util.jsonPut(jSONObject, "md", this.f25662e);
            Util.jsonPut(jSONObject, "tz", this.f25667j);
            int i = this.f25669l;
            if (i != 0) {
                jSONObject.put("jb", i);
            }
            Util.jsonPut(jSONObject, "sd", this.f25668k);
            Util.jsonPut(jSONObject, "apn", this.f25671n);
            Util.jsonPut(jSONObject, "cpu", this.f25675r);
            Util.jsonPut(jSONObject, "abi", Build.CPU_ABI);
            Util.jsonPut(jSONObject, "abi2", Build.CPU_ABI2);
            Util.jsonPut(jSONObject, "ram", this.f25676s);
            Util.jsonPut(jSONObject, "rom", this.f25677t);
            Util.jsonPut(jSONObject, "im", this.f25670m);
            Util.jsonPut(jSONObject, "asg", this.f25678u);
        }
    }

    /* renamed from: a */
    public static void m32749a(Context context, Map<String, String> map) throws JSONException {
        if (map != null) {
            for (Entry entry : new HashMap(map).entrySet()) {
                f25655e.put((String) entry.getKey(), entry.getValue());
            }
        }
    }

    /* renamed from: a */
    static synchronized C7594a m32748a(Context context) {
        C7594a aVar;
        synchronized (C7592a.class) {
            if (f25653a == null) {
                f25653a = new C7594a(Util.getContextSelf(context));
            }
            aVar = f25653a;
        }
        return aVar;
    }

    public C7592a(Context context) {
        try {
            m32748a(context);
            this.f25656b = StatCommonHelper.getTelephonyNetworkType(context);
            this.f25657c = NetworkManager.getInstance(context).getCurNetwrokName();
        } catch (Throwable th) {
            f25654d.mo37104e(th);
        }
    }

    /* renamed from: a */
    public void mo37120a(JSONObject jSONObject, Thread thread) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (f25653a != null) {
                f25653a.mo37121a(jSONObject2, thread);
            }
            Util.jsonPut(jSONObject2, "cn", this.f25657c);
            if (this.f25656b != null) {
                jSONObject2.put("tn", this.f25656b);
            }
            if (thread == null) {
                jSONObject.put("ev", jSONObject2);
            } else {
                jSONObject.put("errkv", jSONObject2.toString());
            }
            if (f25655e != null && f25655e.length() > 0) {
                jSONObject.put("eva", f25655e);
            }
        } catch (Throwable th) {
            f25654d.mo37104e(th);
        }
    }
}
