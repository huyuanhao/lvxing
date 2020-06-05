package com.p530ss.android.socialbase.downloader.p567k;

import android.content.Context;
import android.text.TextUtils;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.downloader.Downloader;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p569m.C6791h;
import com.tencent.p605ep.commonbase.api.ConfigManager.OEM;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ss.android.socialbase.downloader.k.a */
public class DownloadSetting {
    /* renamed from: a */
    private static final C6791h<Integer, DownloadSetting> f22291a = new C6791h<>(8, 8);
    /* renamed from: b */
    private static final DownloadSetting f22292b = new DownloadSetting(null);
    /* renamed from: c */
    private static JSONObject f22293c;
    /* renamed from: d */
    private static JSONObject f22294d;
    /* renamed from: e */
    private static JSONObject f22295e;
    /* renamed from: f */
    private static Boolean f22296f;
    /* renamed from: g */
    private static boolean f22297g;
    /* renamed from: h */
    private static DownloadSetting f22298h;
    /* renamed from: i */
    private final JSONObject f22299i;
    /* renamed from: j */
    private final JSONObject f22300j;
    /* renamed from: k */
    private final Boolean f22301k;
    /* renamed from: l */
    private int f22302l;

    static {
        m28614a();
    }

    /* renamed from: a */
    public static void m28614a() {
        JSONObject v = C6694b.m27390v();
        if (f22293c != v) {
            f22293c = v;
            boolean z = false;
            f22297g = v.optInt("disable_task_setting", 0) == 1;
            f22294d = v.optJSONObject("disabled_task_keys");
            JSONObject optJSONObject = v.optJSONObject("bugfix");
            Boolean bool = null;
            if (optJSONObject != null) {
                String str = OEM.DEFAULT;
                if (optJSONObject.has(str)) {
                    if (optJSONObject.optInt(str, 0) == 1) {
                        z = true;
                    }
                    bool = Boolean.valueOf(z);
                }
            }
            f22295e = optJSONObject;
            f22296f = bool;
        }
    }

    private DownloadSetting(JSONObject jSONObject) {
        JSONObject jSONObject2;
        this.f22299i = jSONObject;
        Boolean bool = null;
        if (jSONObject != null) {
            String str = "bugfix";
            if (!m28621f(str)) {
                jSONObject2 = jSONObject.optJSONObject(str);
                if (jSONObject2 != null) {
                    String str2 = OEM.DEFAULT;
                    if (jSONObject2.has(str2) && !m28621f(str2)) {
                        boolean z = false;
                        if (jSONObject2.optInt(str2, 0) == 1) {
                            z = true;
                        }
                        bool = Boolean.valueOf(z);
                    }
                }
                this.f22300j = jSONObject2;
                this.f22301k = bool;
            }
        }
        jSONObject2 = null;
        this.f22300j = jSONObject2;
        this.f22301k = bool;
    }

    /* renamed from: a */
    public static void m28616a(String str, boolean z) {
        try {
            if (f22295e == null) {
                f22295e = new JSONObject();
            }
            f22295e.put(str, z ? 1 : 0);
        } catch (JSONException unused) {
        }
    }

    /* renamed from: b */
    public static DownloadSetting m28617b() {
        return f22292b;
    }

    /* renamed from: a */
    public static DownloadSetting m28610a(int i) {
        return m28611a(i, (DownloadInfo) null);
    }

    @Deprecated
    /* renamed from: a */
    public static DownloadSetting m28612a(DownloadInfo cVar) {
        if (cVar == null) {
            return f22292b;
        }
        return m28611a(cVar.mo32283g(), cVar);
    }

    /* renamed from: a */
    private static DownloadSetting m28611a(int i, DownloadInfo cVar) {
        DownloadSetting aVar;
        DownloadSetting aVar2 = f22298h;
        if (aVar2 != null && aVar2.f22302l == i) {
            return aVar2;
        }
        synchronized (f22291a) {
            aVar = (DownloadSetting) f22291a.get(Integer.valueOf(i));
        }
        if (aVar == null) {
            aVar = cVar == null ? m28620c(i) : m28618b(cVar);
            synchronized (f22291a) {
                f22291a.put(Integer.valueOf(i), aVar);
            }
        }
        aVar.f22302l = i;
        f22298h = aVar;
        return aVar;
    }

    /* renamed from: a */
    public boolean mo32550a(String str) {
        return mo32552b(str, false);
    }

    /* renamed from: b */
    public boolean mo32552b(String str, boolean z) {
        boolean z2 = false;
        if (this.f22300j != null && !m28621f(str)) {
            if (this.f22300j.has(str)) {
                if (this.f22300j.optInt(str, z) == 1) {
                    z2 = true;
                }
                return z2;
            }
            Boolean bool = this.f22301k;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        JSONObject jSONObject = f22295e;
        if (jSONObject != null) {
            if (jSONObject.has(str)) {
                if (f22295e.optInt(str, z) == 1) {
                    z2 = true;
                }
                return z2;
            }
            Boolean bool2 = f22296f;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
        }
        return z;
    }

    /* renamed from: a */
    public int mo32547a(String str, int i) {
        JSONObject jSONObject = this.f22299i;
        if (jSONObject == null || !jSONObject.has(str) || m28621f(str)) {
            return f22293c.optInt(str, i);
        }
        return this.f22299i.optInt(str, i);
    }

    /* renamed from: a */
    public long mo32548a(String str, long j) {
        JSONObject jSONObject = this.f22299i;
        if (jSONObject == null || !jSONObject.has(str) || m28621f(str)) {
            return f22293c.optLong(str, j);
        }
        return this.f22299i.optLong(str, j);
    }

    /* renamed from: a */
    public double mo32546a(String str, double d) {
        JSONObject jSONObject = this.f22299i;
        if (jSONObject == null || !jSONObject.has(str) || m28621f(str)) {
            return f22293c.optDouble(str, d);
        }
        return this.f22299i.optDouble(str, d);
    }

    /* renamed from: b */
    public boolean mo32551b(String str) {
        return mo32554c(str, false);
    }

    /* renamed from: c */
    public boolean mo32554c(String str, boolean z) {
        JSONObject jSONObject = this.f22299i;
        if (jSONObject == null || !jSONObject.has(str) || m28621f(str)) {
            return f22293c.optBoolean(str, z);
        }
        return this.f22299i.optBoolean(str, z);
    }

    /* renamed from: c */
    public String mo32553c(String str) {
        return mo32549a(str, "");
    }

    /* renamed from: a */
    public String mo32549a(String str, String str2) {
        JSONObject jSONObject = this.f22299i;
        if (jSONObject == null || !jSONObject.has(str) || m28621f(str)) {
            return f22293c.optString(str, str2);
        }
        return this.f22299i.optString(str, str2);
    }

    /* renamed from: d */
    public JSONObject mo32555d(String str) {
        JSONObject jSONObject = this.f22299i;
        if (jSONObject == null || !jSONObject.has(str) || m28621f(str)) {
            return f22293c.optJSONObject(str);
        }
        return this.f22299i.optJSONObject(str);
    }

    /* renamed from: e */
    public JSONArray mo32556e(String str) {
        JSONObject jSONObject = this.f22299i;
        if (jSONObject == null || !jSONObject.has(str) || m28621f(str)) {
            return f22293c.optJSONArray(str);
        }
        return this.f22299i.optJSONArray(str);
    }

    /* renamed from: f */
    public static boolean m28621f(String str) {
        JSONObject jSONObject = f22294d;
        if (jSONObject == null || jSONObject.optInt(str, 0) != 1) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static DownloadSetting m28613a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == f22293c || f22297g) {
            return f22292b;
        }
        DownloadSetting aVar = f22298h;
        if (aVar != null && aVar.f22299i == jSONObject) {
            return aVar;
        }
        synchronized (f22291a) {
            for (DownloadSetting aVar2 : f22291a.values()) {
                if (aVar2.f22299i == jSONObject) {
                    f22298h = aVar2;
                    return aVar2;
                }
            }
            DownloadSetting aVar3 = new DownloadSetting(jSONObject);
            f22298h = aVar3;
            return aVar3;
        }
    }

    /* renamed from: a */
    public static void m28615a(int i, JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != f22293c && !f22297g) {
            synchronized (f22291a) {
                DownloadSetting aVar = f22298h;
                if (aVar == null || aVar.f22299i != jSONObject) {
                    aVar = null;
                    Iterator it = f22291a.values().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        DownloadSetting aVar2 = (DownloadSetting) it.next();
                        if (aVar2.f22299i == jSONObject) {
                            aVar2.f22302l = i;
                            aVar = aVar2;
                            break;
                        }
                    }
                    if (aVar == null) {
                        aVar = new DownloadSetting(jSONObject);
                        aVar.f22302l = i;
                    }
                    f22298h = aVar;
                } else {
                    aVar.f22302l = i;
                }
                f22291a.put(Integer.valueOf(i), aVar);
            }
        }
    }

    /* renamed from: b */
    public static void m28619b(int i) {
        DownloadSetting aVar = f22298h;
        if (aVar != null && aVar.f22302l == i) {
            f22298h = null;
        }
        synchronized (f22291a) {
            f22291a.remove(Integer.valueOf(i));
        }
    }

    /* renamed from: c */
    private static DownloadSetting m28620c(int i) {
        if (f22297g) {
            return f22292b;
        }
        Context B = C6694b.m27342B();
        if (B != null) {
            DownloadInfo h = Downloader.m27478a(B).mo31928h(i);
            if (h != null) {
                return m28618b(h);
            }
        }
        return f22292b;
    }

    /* renamed from: b */
    private static DownloadSetting m28618b(DownloadInfo cVar) {
        if (f22297g) {
            return f22292b;
        }
        try {
            String M = cVar.mo32167M();
            if (!TextUtils.isEmpty(M)) {
                return new DownloadSetting(new JSONObject(M));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return f22292b;
    }
}
