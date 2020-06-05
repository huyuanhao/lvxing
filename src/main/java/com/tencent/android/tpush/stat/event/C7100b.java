package com.tencent.android.tpush.stat.event;

import android.content.Context;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.common.C6914l;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.stat.p596a.C7066c;
import com.tencent.android.tpush.stat.p596a.C7069f;
import com.tencent.bigdata.dataacquisition.CustomDeviceInfos;
import com.tencent.stat.common.DeviceInfo;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.stat.event.b */
public abstract class C7100b {
    /* renamed from: g */
    public static String f23598g = "xgsdk";
    /* renamed from: i */
    protected static String f23599i;
    /* renamed from: j */
    protected static long f23600j;
    /* renamed from: c */
    protected String f23601c = null;
    /* renamed from: d */
    protected long f23602d = 0;
    /* renamed from: e */
    protected long f23603e;
    /* renamed from: f */
    protected int f23604f;
    /* renamed from: h */
    protected String f23605h = null;
    /* renamed from: k */
    protected long f23606k = 0;
    /* renamed from: l */
    protected Context f23607l;

    /* renamed from: a */
    public abstract boolean mo34232a(JSONObject jSONObject);

    /* renamed from: b */
    public abstract EventType mo34233b();

    public C7100b(Context context, int i, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("Axg");
        sb.append(j);
        this.f23601c = sb.toString();
        m30430a(context, i, j);
    }

    public C7100b(Context context, String str) {
        this.f23601c = str;
        m30430a(context, 0, this.f23602d);
    }

    /* renamed from: a */
    private void m30430a(Context context, int i, long j) {
        this.f23607l = context;
        this.f23602d = j;
        this.f23603e = System.currentTimeMillis() / 1000;
        this.f23604f = i;
        this.f23605h = C6914l.m29525f(context);
        String str = f23599i;
        if (str == null || str.trim().length() < 40) {
            f23599i = XGPushConfig.getToken(context);
            if (!C7066c.m30262b(f23599i)) {
                f23599i = "0";
            }
        }
        if (f23600j == 0) {
            f23600j = CacheManager.getGuid(mo34238c());
        }
    }

    /* renamed from: c */
    public Context mo34238c() {
        return this.f23607l;
    }

    /* renamed from: b */
    public boolean mo34237b(JSONObject jSONObject) {
        try {
            C7069f.m30291a(jSONObject, "ky", this.f23601c);
            jSONObject.put("et", mo34233b().GetIntValue());
            jSONObject.put(DeviceInfo.TAG_IMEI, C7069f.m30289a(this.f23607l));
            C7069f.m30291a(jSONObject, DeviceInfo.TAG_MAC, CustomDeviceInfos.getMacAddress(this.f23607l));
            jSONObject.put("ut", 1);
            if (mo34233b() != EventType.SESSION_ENV) {
                C7069f.m30291a(jSONObject, "av", this.f23605h);
                C7069f.m30291a(jSONObject, "ch", f23598g);
            }
            C7069f.m30291a(jSONObject, "mid", f23599i);
            jSONObject.put("si", this.f23604f);
            String str = "ts";
            if (mo34233b() == EventType.CUSTOM) {
                jSONObject.put("cts", this.f23603e);
                if (this.f23606k != 0 || this.f23603e == 0) {
                    jSONObject.put(str, this.f23606k);
                } else {
                    jSONObject.put(str, this.f23603e);
                }
            } else {
                jSONObject.put(str, this.f23603e);
            }
            String str2 = "sv";
            if ("0".equals(C7066c.m30255a(this.f23607l, this.f23602d))) {
                jSONObject.put(str2, C7066c.m30254a(this.f23607l));
            } else {
                jSONObject.put(str2, C7066c.m30255a(this.f23607l, this.f23602d));
            }
            jSONObject.put("guid", f23600j);
            jSONObject.put("dts", C7066c.m30251a(this.f23607l, false));
            return mo34232a(jSONObject);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: d */
    public String mo34239d() {
        try {
            JSONObject jSONObject = new JSONObject();
            mo34237b(jSONObject);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String toString() {
        return mo34239d();
    }
}
