package com.tencent.android.tpush.stat.p596a;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.stat.C7060a;
import com.tencent.android.tpush.stat.event.C7100b;
import com.tencent.bigdata.dataacquisition.CustomDeviceInfos;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.stat.common.DeviceInfo;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Marker;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.stat.a.a */
public class C7062a {
    /* renamed from: a */
    static C7064a f23463a;
    /* renamed from: d */
    private static C7067d f23464d = C7066c.m30259b();
    /* renamed from: e */
    private static JSONObject f23465e = new JSONObject();
    /* renamed from: b */
    Integer f23466b = null;
    /* renamed from: c */
    String f23467c = null;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.stat.a.a$a */
    static class C7064a {
        /* renamed from: a */
        String f23468a;
        /* renamed from: b */
        String f23469b;
        /* renamed from: c */
        DisplayMetrics f23470c;
        /* renamed from: d */
        int f23471d;
        /* renamed from: e */
        String f23472e;
        /* renamed from: f */
        String f23473f;
        /* renamed from: g */
        String f23474g;
        /* renamed from: h */
        String f23475h;
        /* renamed from: i */
        String f23476i;
        /* renamed from: j */
        String f23477j;
        /* renamed from: k */
        int f23478k;
        /* renamed from: l */
        String f23479l;
        /* renamed from: m */
        Context f23480m;
        /* renamed from: n */
        long f23481n;
        /* renamed from: o */
        private String f23482o;
        /* renamed from: p */
        private String f23483p;

        private C7064a(Context context, long j) {
            this.f23469b = "2.0.6";
            this.f23471d = VERSION.SDK_INT;
            this.f23472e = Build.MODEL;
            this.f23473f = Build.MANUFACTURER;
            this.f23474g = Locale.getDefault().getLanguage();
            this.f23478k = 0;
            this.f23479l = null;
            this.f23480m = null;
            this.f23482o = null;
            this.f23483p = null;
            this.f23481n = 0;
            this.f23480m = context.getApplicationContext();
            this.f23470c = DeviceInfos.getDisplayMetrics(this.f23480m);
            this.f23468a = C7066c.m30260b(this.f23480m, j);
            this.f23475h = CustomDeviceInfos.getSimOperator(this.f23480m);
            this.f23476i = TimeZone.getDefault().getID();
            this.f23477j = DeviceInfos.getExternalStorageInfo(this.f23480m);
            this.f23479l = this.f23480m.getPackageName();
            this.f23482o = DeviceInfos.getSystemMemory(this.f23480m);
            this.f23483p = DeviceInfos.getRomMemory();
            this.f23481n = j;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo34164a(JSONObject jSONObject, Thread thread) {
            if (thread == null) {
                if (this.f23470c != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.f23470c.widthPixels);
                    String str = Marker.ANY_MARKER;
                    sb.append(str);
                    sb.append(this.f23470c.heightPixels);
                    jSONObject.put("sr", sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.f23470c.xdpi);
                    sb2.append(str);
                    sb2.append(this.f23470c.ydpi);
                    jSONObject.put("dpi", sb2.toString());
                }
                if (C7060a.m30235a(this.f23480m).mo34158b()) {
                    JSONObject jSONObject2 = new JSONObject();
                    C7069f.m30291a(jSONObject2, "bs", CustomDeviceInfos.getWiFiBBSID(this.f23480m));
                    C7069f.m30291a(jSONObject2, "ss", CustomDeviceInfos.getWiFiSSID(this.f23480m));
                    if (jSONObject2.length() > 0) {
                        C7069f.m30291a(jSONObject, "wf", jSONObject2.toString());
                    }
                }
                JSONArray wifiTopN = CustomDeviceInfos.getWifiTopN(this.f23480m, 10);
                if (wifiTopN != null && wifiTopN.length() > 0) {
                    C7069f.m30291a(jSONObject, "wflist", wifiTopN.toString());
                }
            } else {
                C7069f.m30291a(jSONObject, "thn", thread.getName());
                String str2 = "/";
                if (C7066c.m30262b(this.f23482o) && this.f23482o.split(str2).length == 2) {
                    C7069f.m30291a(jSONObject, "fram", this.f23482o.split(str2)[0]);
                }
                if (C7066c.m30262b(this.f23483p) && this.f23483p.split(str2).length == 2) {
                    C7069f.m30291a(jSONObject, "from", this.f23483p.split(str2)[0]);
                }
                jSONObject.put(DeviceInfo.TAG_IMEI, CustomDeviceInfos.getDeviceId(this.f23480m));
                C7069f.m30291a(jSONObject, "mid", XGPushConfig.getToken(this.f23480m));
            }
            C7069f.m30291a(jSONObject, "pcn", C7066c.m30264c(this.f23480m));
            C7069f.m30291a(jSONObject, "osn", VERSION.RELEASE);
            C7069f.m30291a(jSONObject, "av", this.f23468a);
            C7069f.m30291a(jSONObject, "ch", C7100b.f23598g);
            C7069f.m30291a(jSONObject, "mf", this.f23473f);
            long j = this.f23481n;
            if (j > 0) {
                C7069f.m30291a(jSONObject, "sv", C7066c.m30255a(this.f23480m, j));
            }
            C7069f.m30291a(jSONObject, "osd", Build.DISPLAY);
            C7069f.m30291a(jSONObject, "prod", Build.PRODUCT);
            C7069f.m30291a(jSONObject, "tags", Build.TAGS);
            C7069f.m30291a(jSONObject, "id", Build.ID);
            C7069f.m30291a(jSONObject, "fng", Build.FINGERPRINT);
            C7069f.m30291a(jSONObject, "ov", Integer.toString(this.f23471d));
            jSONObject.put("os", 1);
            C7069f.m30291a(jSONObject, "op", this.f23475h);
            C7069f.m30291a(jSONObject, "lg", this.f23474g);
            C7069f.m30291a(jSONObject, "md", this.f23472e);
            C7069f.m30291a(jSONObject, "tz", this.f23476i);
            int i = this.f23478k;
            if (i != 0) {
                jSONObject.put("jb", i);
            }
            C7069f.m30291a(jSONObject, "sd", this.f23477j);
            C7069f.m30291a(jSONObject, "abi", Build.CPU_ABI);
            C7069f.m30291a(jSONObject, "ram", this.f23482o);
            C7069f.m30291a(jSONObject, "rom", this.f23483p);
        }
    }

    /* renamed from: a */
    static synchronized C7064a m30242a(Context context, long j) {
        C7064a aVar;
        synchronized (C7062a.class) {
            if (f23463a == null) {
                f23463a = new C7064a(context.getApplicationContext(), j);
            }
            aVar = f23463a;
        }
        return aVar;
    }

    public C7062a(Context context, long j) {
        try {
            m30242a(context, j);
            this.f23466b = DeviceInfos.getTelephonyNetworkType(context.getApplicationContext());
            this.f23467c = C7060a.m30235a(context).mo34157a();
        } catch (Throwable th) {
            f23464d.mo34170b(th);
        }
    }

    /* renamed from: a */
    public void mo34163a(JSONObject jSONObject, Thread thread) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (f23463a != null) {
                f23463a.mo34164a(jSONObject2, thread);
            }
            C7069f.m30291a(jSONObject2, "cn", this.f23467c);
            if (this.f23466b != null) {
                jSONObject2.put("tn", this.f23466b);
            }
            if (thread == null) {
                jSONObject.put("ev", jSONObject2);
            } else {
                jSONObject.put("errkv", jSONObject2.toString());
            }
            if (f23465e != null && f23465e.length() > 0) {
                jSONObject.put("eva", f23465e);
            }
        } catch (Throwable th) {
            f23464d.mo34170b(th);
        }
    }
}
