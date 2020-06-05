package com.bytedance.embedapplog.p142b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.p003os.EnvironmentCompat;
import com.bytedance.embed_device_register.C1779b;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.util.C1856h;
import com.bytedance.embedapplog.util.C1857i;
import com.tencent.mid.sotrage.StorageInterface;
import com.tencent.stat.apkreader.ChannelReader;
import com.tencent.stat.common.DeviceInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.b.i */
public class C1822i {
    /* renamed from: f */
    private static final String[] f5111f = {ChannelReader.CHANNEL_KEY, "package", "app_version"};
    /* renamed from: a */
    private boolean f5112a;
    /* renamed from: b */
    private final Context f5113b;
    /* renamed from: c */
    private final C1821h f5114c;
    /* renamed from: d */
    private JSONObject f5115d;
    /* renamed from: e */
    private final ArrayList<C1816c> f5116e = new ArrayList<>(32);
    /* renamed from: g */
    private final SharedPreferences f5117g;
    /* renamed from: h */
    private int f5118h = 0;

    public C1822i(Context context, C1821h hVar) {
        this.f5113b = context;
        this.f5114c = hVar;
        this.f5117g = hVar.mo13399d();
        this.f5115d = new JSONObject();
        C1779b.m6171a(this.f5113b, this.f5117g);
    }

    /* renamed from: a */
    public JSONObject mo13425a() {
        if (this.f5112a) {
            return m6387r();
        }
        return null;
    }

    /* renamed from: b */
    public JSONObject mo13430b() {
        String str = "oaid";
        JSONObject a = mo13425a();
        if (a != null) {
            try {
                String a2 = C1779b.m6170a(a.optJSONObject(str));
                if (!TextUtils.isEmpty(a2)) {
                    JSONObject jSONObject = new JSONObject();
                    C1857i.m6593b(jSONObject, a);
                    jSONObject.put(str, a2);
                    return jSONObject;
                }
            } catch (Exception e) {
                C1856h.m6582a(e);
            }
        }
        return a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000a, code lost:
            if (r2 != null) goto L_0x000e;
     */
    /* renamed from: a */
    public <T> T mo13424a(java.lang.String r2, T r3) {
        /*
        r1 = this;
        org.json.JSONObject r0 = r1.m6387r()
        if (r0 == 0) goto L_0x000d
        java.lang.Object r2 = r0.opt(r2)
        if (r2 == 0) goto L_0x000d
        goto L_0x000e
    L_0x000d:
        r2 = 0
    L_0x000e:
        if (r2 != 0) goto L_0x0011
        r2 = r3
    L_0x0011:
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.p142b.C1822i.mo13424a(java.lang.String, java.lang.Object):java.lang.Object");
    }

    /* renamed from: r */
    private JSONObject m6387r() {
        return this.f5115d;
    }

    /* renamed from: c */
    public int mo13432c() {
        String str = "version_code";
        int optInt = this.f5112a ? m6387r().optInt(str, -1) : -1;
        for (int i = 0; i < 3 && optInt == -1; i++) {
            mo13435e();
            optInt = this.f5112a ? m6387r().optInt(str, -1) : -1;
        }
        return optInt;
    }

    /* renamed from: d */
    public String mo13434d() {
        String str = "app_version";
        String optString = this.f5112a ? m6387r().optString(str, null) : null;
        for (int i = 0; i < 3 && optString == null; i++) {
            mo13435e();
            optString = this.f5112a ? m6387r().optString(str, null) : null;
        }
        return optString;
    }

    /* renamed from: e */
    public boolean mo13435e() {
        synchronized (this.f5116e) {
            if (this.f5116e.size() == 0) {
                this.f5116e.add(new C1817d());
                this.f5116e.add(new C1819f(this.f5113b));
                this.f5116e.add(new C1820g(this.f5113b, this.f5114c));
                this.f5116e.add(new C1823j(this.f5113b));
                this.f5116e.add(new C1824k(this.f5113b));
                this.f5116e.add(new C1825l(this.f5113b, this.f5114c));
                this.f5116e.add(new C1826m(this.f5113b));
                this.f5116e.add(new C1828o(this.f5113b));
                this.f5116e.add(new C1829p(this.f5113b, this.f5114c));
                this.f5116e.add(new C1830q());
                this.f5116e.add(new C1831r(this.f5114c));
                this.f5116e.add(new C1832s(this.f5113b));
                this.f5116e.add(new C1833t(this.f5113b));
                this.f5116e.add(new C1834u(this.f5113b, this.f5114c));
                this.f5116e.add(new C1814a(this.f5113b, this.f5114c));
                this.f5116e.add(new C1827n(this.f5113b, this.f5114c));
                this.f5116e.add(new C1818e(this.f5113b, this.f5114c));
            }
        }
        JSONObject r = m6387r();
        JSONObject jSONObject = new JSONObject();
        C1857i.m6593b(jSONObject, r);
        Iterator it = this.f5116e.iterator();
        boolean z = true;
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            C1816c cVar = (C1816c) it.next();
            if (!cVar.f5095a || cVar.f5097c || m6382a(cVar)) {
                try {
                    cVar.f5095a = cVar.mo13364a(jSONObject);
                } catch (JSONException e) {
                    C1856h.m6582a(e);
                } catch (SecurityException e2) {
                    if (!cVar.f5096b) {
                        i++;
                        StringBuilder sb = new StringBuilder();
                        sb.append("loadHeader, ");
                        sb.append(this.f5118h);
                        C1856h.m6583b(sb.toString(), e2);
                        if (!cVar.f5095a && this.f5118h > 10) {
                            cVar.f5095a = true;
                        }
                    }
                }
                if (!cVar.f5095a && !cVar.f5096b) {
                    i2++;
                }
            }
            boolean z2 = cVar.f5095a || cVar.f5096b;
            z &= z2;
        }
        if (z) {
            for (String optString : f5111f) {
                z &= !TextUtils.isEmpty(jSONObject.optString(optString));
            }
            String optString2 = jSONObject.optString("user_unique_id", null);
            if (!TextUtils.isEmpty(optString2)) {
                try {
                    jSONObject.put("user_unique_id", optString2);
                } catch (JSONException unused) {
                }
            }
        }
        this.f5115d = jSONObject;
        this.f5112a = z;
        if (C1856h.f5226b) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("loadHeader, ");
            sb2.append(this.f5112a);
            sb2.append(", ");
            sb2.append(this.f5118h);
            sb2.append(", ");
            sb2.append(this.f5115d.toString());
            C1856h.m6581a(sb2.toString(), null);
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("loadHeader, ");
            sb3.append(this.f5112a);
            sb3.append(", ");
            sb3.append(this.f5118h);
            C1856h.m6585d(sb3.toString(), null);
        }
        if (i > 0 && i == i2) {
            this.f5118h++;
            if (mo13446o() != 0) {
                this.f5118h += 10;
            }
        }
        if (this.f5112a) {
            AppLog.getDataObserver().onIdLoaded(mo13438g(), mo13441j(), mo13442k());
        }
        return this.f5112a;
    }

    /* renamed from: a */
    private boolean m6382a(C1816c cVar) {
        boolean z = !this.f5114c.mo13418u() && cVar.f5098d;
        if (C1856h.f5226b) {
            StringBuilder sb = new StringBuilder();
            sb.append("needSyncFromSub ");
            sb.append(cVar);
            sb.append(" ");
            sb.append(z);
            C1856h.m6581a(sb.toString(), null);
        }
        return z;
    }

    /* renamed from: a */
    public void mo13428a(JSONObject jSONObject) {
        this.f5114c.mo13396b(jSONObject);
        m6383b(jSONObject);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0077, code lost:
            return;
     */
    /* renamed from: b */
    private synchronized void m6383b(org.json.JSONObject r7) {
        /*
        r6 = this;
        monitor-enter(r6)
        if (r7 != 0) goto L_0x000b
        java.lang.String r7 = "null abconfig"
        r0 = 0
        com.bytedance.embedapplog.util.C1856h.m6583b(r7, r0)     // Catch:{ all -> 0x0078 }
        monitor-exit(r6)
        return
    L_0x000b:
        org.json.JSONObject r0 = r6.m6387r()     // Catch:{ all -> 0x0078 }
        java.lang.String r1 = "ab_version"
        java.lang.String r0 = r0.optString(r1)     // Catch:{ all -> 0x0078 }
        boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0078 }
        if (r1 != 0) goto L_0x0076
        java.lang.String r1 = ","
        java.lang.String[] r0 = r0.split(r1)     // Catch:{ all -> 0x0078 }
        java.util.HashSet r1 = new java.util.HashSet     // Catch:{ all -> 0x0078 }
        r1.<init>()     // Catch:{ all -> 0x0078 }
        int r2 = r0.length     // Catch:{ all -> 0x0078 }
        r3 = 0
    L_0x0028:
        if (r3 >= r2) goto L_0x0038
        r4 = r0[r3]     // Catch:{ all -> 0x0078 }
        boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0078 }
        if (r5 != 0) goto L_0x0035
        r1.add(r4)     // Catch:{ all -> 0x0078 }
    L_0x0035:
        int r3 = r3 + 1
        goto L_0x0028
    L_0x0038:
        java.util.Iterator r0 = r7.keys()     // Catch:{ all -> 0x0078 }
        java.util.HashSet r2 = new java.util.HashSet     // Catch:{ all -> 0x0078 }
        r2.<init>()     // Catch:{ all -> 0x0078 }
    L_0x0041:
        boolean r3 = r0.hasNext()     // Catch:{ all -> 0x0078 }
        if (r3 == 0) goto L_0x006a
        java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x0078 }
        boolean r4 = r3 instanceof java.lang.String     // Catch:{ all -> 0x0078 }
        if (r4 == 0) goto L_0x0041
        java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0078 }
        boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0078 }
        if (r4 != 0) goto L_0x0041
        org.json.JSONObject r3 = r7.getJSONObject(r3)     // Catch:{ JSONException -> 0x0065 }
        java.lang.String r4 = "vid"
        java.lang.String r3 = r3.optString(r4)     // Catch:{ JSONException -> 0x0065 }
        r2.add(r3)     // Catch:{ JSONException -> 0x0065 }
        goto L_0x0041
    L_0x0065:
        r3 = move-exception
        com.bytedance.embedapplog.util.C1856h.m6582a(r3)     // Catch:{ all -> 0x0078 }
        goto L_0x0041
    L_0x006a:
        r1.retainAll(r2)     // Catch:{ all -> 0x0078 }
        java.lang.String r7 = "ab_version"
        java.lang.String r0 = r6.m6380a(r1)     // Catch:{ all -> 0x0078 }
        r6.m6384b(r7, r0)     // Catch:{ all -> 0x0078 }
    L_0x0076:
        monitor-exit(r6)
        return
    L_0x0078:
        r7 = move-exception
        monitor-exit(r6)
        throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.p142b.C1822i.m6383b(org.json.JSONObject):void");
    }

    /* renamed from: a */
    private String m6380a(Set<String> set) {
        StringBuilder sb = new StringBuilder();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            if (it.hasNext()) {
                sb.append(StorageInterface.KEY_SPLITER);
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public void mo13427a(HashMap<String, Object> hashMap) {
        String str = "custom";
        JSONObject jSONObject = null;
        if (hashMap != null && !hashMap.isEmpty()) {
            try {
                jSONObject = m6387r().optJSONObject(str);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                for (Entry entry : hashMap.entrySet()) {
                    if (!TextUtils.isEmpty((CharSequence) entry.getKey())) {
                        jSONObject.put((String) entry.getKey(), entry.getValue());
                    }
                }
            } catch (JSONException e) {
                C1856h.m6582a(e);
            }
        }
        if (m6384b(str, jSONObject)) {
            this.f5114c.mo13391a(jSONObject);
        }
    }

    /* renamed from: f */
    public String mo13436f() {
        return m6387r().optString("user_unique_id", "");
    }

    /* renamed from: g */
    public String mo13438g() {
        return m6387r().optString("device_id", "");
    }

    /* renamed from: h */
    public String mo13439h() {
        return m6387r().optString(DeviceInfo.TAG_ANDROID_ID, "");
    }

    /* renamed from: i */
    public String mo13440i() {
        return m6387r().optString("udid", "");
    }

    /* renamed from: j */
    public String mo13441j() {
        return m6387r().optString("install_id", "");
    }

    /* renamed from: k */
    public String mo13442k() {
        return m6387r().optString("ssid", "");
    }

    /* renamed from: l */
    public String mo13443l() {
        return m6387r().optString("user_unique_id", "");
    }

    /* renamed from: m */
    public String mo13444m() {
        return m6387r().optString("clientudid", "");
    }

    /* renamed from: n */
    public String mo13445n() {
        return m6387r().optString("openudid", "");
    }

    /* renamed from: a */
    public void mo13426a(String str) {
        if (m6384b("ab_sdk_version", str)) {
            this.f5114c.mo13388a(str);
        }
    }

    /* renamed from: b */
    public void mo13431b(String str) {
        if (m6384b("user_agent", str)) {
            this.f5114c.mo13400d(str);
        }
    }

    /* renamed from: c */
    public void mo13433c(String str) {
        if (m6384b("user_unique_id", str)) {
            this.f5114c.mo13395b(str);
        }
    }

    /* renamed from: b */
    private boolean m6384b(String str, Object obj) {
        boolean z;
        Object opt = m6387r().opt(str);
        if ((obj == null || obj.equals(opt)) && (obj != null || opt == null)) {
            z = false;
        } else {
            synchronized (this) {
                try {
                    JSONObject jSONObject = this.f5115d;
                    JSONObject jSONObject2 = new JSONObject();
                    C1857i.m6593b(jSONObject2, jSONObject);
                    jSONObject2.put(str, obj);
                    this.f5115d = jSONObject2;
                } catch (JSONException e) {
                    C1856h.m6582a(e);
                }
            }
            z = true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("updateHeader, ");
        sb.append(str);
        sb.append(", ");
        sb.append(opt);
        sb.append(", ");
        sb.append(obj);
        C1856h.m6581a(sb.toString(), null);
        return z;
    }

    /* renamed from: a */
    static void m6381a(JSONObject jSONObject, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put(str, str2);
        }
    }

    /* renamed from: d */
    static boolean m6385d(String str) {
        int length = str != null ? str.length() : 0;
        if (length < 13 || length > 128) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'f') && ((charAt < 'A' || charAt > 'F') && charAt != '-'))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: e */
    public static boolean m6386e(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str) || EnvironmentCompat.MEDIA_UNKNOWN.equalsIgnoreCase(str) || "Null".equalsIgnoreCase(str)) {
            return false;
        }
        int i = 0;
        while (true) {
            if (i >= str.length()) {
                z = true;
                break;
            } else if (str.charAt(i) != '0') {
                break;
            } else {
                i++;
            }
        }
        return !z;
    }

    /* renamed from: o */
    public int mo13446o() {
        String str = "";
        String optString = m6387r().optString("device_id", str);
        m6387r().optString("install_id", str);
        if (!m6386e(optString)) {
            return 0;
        }
        String str2 = "version_code";
        return this.f5117g.getInt(str2, 0) == m6387r().optInt(str2, -1) ? 1 : 2;
    }

    /* renamed from: p */
    public long mo13447p() {
        return m6387r().optLong("register_time", 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ee A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* renamed from: a */
    public boolean mo13429a(org.json.JSONObject r17, java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
        r16 = this;
        r1 = r16
        r0 = r17
        r5 = r18
        r7 = r19
        r9 = r20
        java.lang.String r2 = "register_time"
        java.lang.String r3 = "ssid"
        java.lang.String r4 = "install_id"
        java.lang.String r6 = ""
        java.lang.String r8 = "device_id"
        java.lang.String r10 = "version_code"
        boolean r11 = com.bytedance.embedapplog.util.C1856h.f5226b
        if (r11 == 0) goto L_0x0043
        java.lang.StringBuilder r11 = new java.lang.StringBuilder
        r11.<init>()
        java.lang.String r12 = "saveRegisterInfo, "
        r11.append(r12)
        r11.append(r5)
        java.lang.String r12 = ", "
        r11.append(r12)
        r11.append(r7)
        r11.append(r12)
        r11.append(r9)
        r11.append(r12)
        r11.append(r0)
        java.lang.String r11 = r11.toString()
        r12 = 0
        com.bytedance.embedapplog.util.C1856h.m6581a(r11, r12)
    L_0x0043:
        boolean r11 = m6386e(r18)
        boolean r12 = m6386e(r19)
        r14 = 0
        boolean r15 = m6386e(r20)     // Catch:{ JSONException -> 0x00e7 }
        android.content.SharedPreferences r13 = r1.f5117g     // Catch:{ JSONException -> 0x00e7 }
        int r13 = r13.getInt(r10, r14)     // Catch:{ JSONException -> 0x00e7 }
        org.json.JSONObject r14 = r16.m6387r()     // Catch:{ JSONException -> 0x00e7 }
        r9 = 0
        int r14 = r14.optInt(r10, r9)     // Catch:{ JSONException -> 0x00e7 }
        android.content.SharedPreferences r9 = r1.f5117g     // Catch:{ JSONException -> 0x00e7 }
        android.content.SharedPreferences$Editor r9 = r9.edit()     // Catch:{ JSONException -> 0x00e7 }
        if (r13 == r14) goto L_0x006a
        r9.putInt(r10, r14)     // Catch:{ JSONException -> 0x00e7 }
    L_0x006a:
        if (r11 == 0) goto L_0x007b
        long r13 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x00e7 }
        r9.putLong(r2, r13)     // Catch:{ JSONException -> 0x00e7 }
        java.lang.Long r0 = java.lang.Long.valueOf(r13)     // Catch:{ JSONException -> 0x00e7 }
        r1.m6384b(r2, r0)     // Catch:{ JSONException -> 0x00e7 }
        goto L_0x008c
    L_0x007b:
        if (r11 != 0) goto L_0x008c
        org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00e7 }
        r2.<init>()     // Catch:{ JSONException -> 0x00e7 }
        java.lang.String r10 = "response"
        r2.put(r10, r0)     // Catch:{ JSONException -> 0x00e7 }
        java.lang.String r0 = "tt_fetch_did_error"
        com.bytedance.embedapplog.AppLog.onEventV3(r0, r2)     // Catch:{ JSONException -> 0x00e7 }
    L_0x008c:
        org.json.JSONObject r0 = r16.m6387r()     // Catch:{ JSONException -> 0x00e7 }
        java.lang.String r0 = r0.optString(r8, r6)     // Catch:{ JSONException -> 0x00e7 }
        if (r11 == 0) goto L_0x00a1
        boolean r2 = r1.m6384b(r8, r5)     // Catch:{ JSONException -> 0x00e7 }
        if (r2 == 0) goto L_0x00a1
        r9.putString(r8, r5)     // Catch:{ JSONException -> 0x00e7 }
        r13 = 1
        goto L_0x00a2
    L_0x00a1:
        r13 = 0
    L_0x00a2:
        org.json.JSONObject r2 = r16.m6387r()     // Catch:{ JSONException -> 0x00e7 }
        java.lang.String r8 = r2.optString(r4, r6)     // Catch:{ JSONException -> 0x00e7 }
        if (r12 == 0) goto L_0x00b6
        boolean r2 = r1.m6384b(r4, r7)     // Catch:{ JSONException -> 0x00e7 }
        if (r2 == 0) goto L_0x00b6
        r9.putString(r4, r7)     // Catch:{ JSONException -> 0x00e7 }
        r13 = 1
    L_0x00b6:
        org.json.JSONObject r2 = r16.m6387r()     // Catch:{ JSONException -> 0x00e7 }
        java.lang.String r10 = r2.optString(r3, r6)     // Catch:{ JSONException -> 0x00e7 }
        r14 = r20
        if (r15 == 0) goto L_0x00ce
        r15 = 0
        boolean r2 = r1.m6384b(r3, r14)     // Catch:{ JSONException -> 0x00e5 }
        if (r2 == 0) goto L_0x00cf
        r9.putString(r3, r14)     // Catch:{ JSONException -> 0x00e5 }
        r3 = 1
        goto L_0x00d0
    L_0x00ce:
        r15 = 0
    L_0x00cf:
        r3 = r13
    L_0x00d0:
        com.bytedance.embedapplog.IDataObserver r2 = com.bytedance.embedapplog.AppLog.getDataObserver()     // Catch:{ JSONException -> 0x00e5 }
        r4 = r0
        r5 = r18
        r6 = r8
        r7 = r19
        r8 = r10
        r0 = r9
        r9 = r20
        r2.onRemoteIdGet(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ JSONException -> 0x00e5 }
        r0.apply()     // Catch:{ JSONException -> 0x00e5 }
        goto L_0x00ec
    L_0x00e5:
        r0 = move-exception
        goto L_0x00e9
    L_0x00e7:
        r0 = move-exception
        r15 = 0
    L_0x00e9:
        com.bytedance.embedapplog.util.C1856h.m6582a(r0)
    L_0x00ec:
        if (r11 == 0) goto L_0x00f1
        if (r12 == 0) goto L_0x00f1
        r15 = 1
    L_0x00f1:
        return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.p142b.C1822i.mo13429a(org.json.JSONObject, java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007f, code lost:
            return;
     */
    /* renamed from: f */
    public synchronized void mo13437f(java.lang.String r8) {
        /*
        r7 = this;
        monitor-enter(r7)
        org.json.JSONObject r0 = r7.m6387r()     // Catch:{ all -> 0x0080 }
        java.lang.String r1 = "ab_version"
        java.lang.String r0 = r0.optString(r1)     // Catch:{ all -> 0x0080 }
        boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0080 }
        r2 = 0
        if (r1 == 0) goto L_0x0013
        goto L_0x005c
    L_0x0013:
        java.lang.String r1 = ","
        java.lang.String[] r1 = r0.split(r1)     // Catch:{ all -> 0x0080 }
        int r3 = r1.length     // Catch:{ all -> 0x0080 }
        r4 = 0
    L_0x001b:
        if (r4 >= r3) goto L_0x0048
        r5 = r1[r4]     // Catch:{ all -> 0x0080 }
        boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0080 }
        if (r6 != 0) goto L_0x0045
        boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x0080 }
        if (r5 == 0) goto L_0x0045
        boolean r8 = com.bytedance.embedapplog.util.C1856h.f5226b     // Catch:{ all -> 0x0080 }
        if (r8 == 0) goto L_0x0043
        java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0080 }
        r8.<init>()     // Catch:{ all -> 0x0080 }
        java.lang.String r1 = "addExposedVid ready added "
        r8.append(r1)     // Catch:{ all -> 0x0080 }
        r8.append(r0)     // Catch:{ all -> 0x0080 }
        java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0080 }
        com.bytedance.embedapplog.util.C1856h.m6581a(r8, r2)     // Catch:{ all -> 0x0080 }
    L_0x0043:
        monitor-exit(r7)
        return
    L_0x0045:
        int r4 = r4 + 1
        goto L_0x001b
    L_0x0048:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0080 }
        r1.<init>()     // Catch:{ all -> 0x0080 }
        r1.append(r0)     // Catch:{ all -> 0x0080 }
        java.lang.String r0 = ","
        r1.append(r0)     // Catch:{ all -> 0x0080 }
        r1.append(r8)     // Catch:{ all -> 0x0080 }
        java.lang.String r8 = r1.toString()     // Catch:{ all -> 0x0080 }
    L_0x005c:
        java.lang.String r0 = "ab_version"
        r7.m6384b(r0, r8)     // Catch:{ all -> 0x0080 }
        com.bytedance.embedapplog.b.h r0 = r7.f5114c     // Catch:{ all -> 0x0080 }
        r0.mo13401e(r8)     // Catch:{ all -> 0x0080 }
        boolean r0 = com.bytedance.embedapplog.util.C1856h.f5226b     // Catch:{ all -> 0x0080 }
        if (r0 == 0) goto L_0x007e
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0080 }
        r0.<init>()     // Catch:{ all -> 0x0080 }
        java.lang.String r1 = "addExposedVid "
        r0.append(r1)     // Catch:{ all -> 0x0080 }
        r0.append(r8)     // Catch:{ all -> 0x0080 }
        java.lang.String r8 = r0.toString()     // Catch:{ all -> 0x0080 }
        com.bytedance.embedapplog.util.C1856h.m6581a(r8, r2)     // Catch:{ all -> 0x0080 }
    L_0x007e:
        monitor-exit(r7)
        return
    L_0x0080:
        r8 = move-exception
        monitor-exit(r7)
        throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.p142b.C1822i.mo13437f(java.lang.String):void");
    }

    /* renamed from: q */
    public String mo13448q() {
        return m6387r().optString("ab_sdk_version", "");
    }
}
