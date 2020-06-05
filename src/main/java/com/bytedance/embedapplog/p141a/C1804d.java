package com.bytedance.embedapplog.p141a;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.embedapplog.p142b.C1821h;
import com.bytedance.embedapplog.p142b.C1822i;
import com.bytedance.embedapplog.util.C1853e;
import com.bytedance.embedapplog.util.C1854f;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.a.d */
class C1804d extends C1803c {
    /* renamed from: e */
    private static final Pattern f5044e = Pattern.compile("[^+0-9]");
    /* renamed from: b */
    private final C1821h f5045b;
    /* renamed from: c */
    private final C1822i f5046c;
    /* renamed from: d */
    private int f5047d = 1;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo13345a() {
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public String mo13349e() {
        return "c";
    }

    C1804d(Context context, C1822i iVar, C1821h hVar) {
        super(context);
        this.f5046c = iVar;
        this.f5045b = hVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public long mo13346b() {
        long g = this.f5045b.mo13404g() + 21600000;
        Long i = this.f5045b.mo13406i();
        if (i == null) {
            return g;
        }
        if (i.longValue() == 0) {
            return 0;
        }
        Long k = this.f5045b.mo13408k();
        if (k == null) {
            return g;
        }
        long longValue = k.longValue() + 1800000;
        return longValue < g ? longValue : g;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public long[] mo13347c() {
        return C1809i.f5066c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00e1  */
    /* renamed from: d */
    public boolean mo13348d() {
        /*
        r11 = this;
        com.bytedance.embedapplog.b.i r0 = r11.f5046c
        org.json.JSONObject r0 = r0.mo13425a()
        com.bytedance.embedapplog.b.i r1 = r11.f5046c
        int r1 = r1.mo13446o()
        r2 = 0
        if (r1 == 0) goto L_0x010d
        if (r0 == 0) goto L_0x010d
        com.bytedance.embedapplog.b.h r1 = r11.f5045b
        java.lang.Long r1 = r1.mo13406i()
        r3 = 0
        r4 = 1
        if (r1 == 0) goto L_0x0076
        long r5 = r1.longValue()
        r7 = 0
        int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
        if (r1 != 0) goto L_0x0028
        r5 = r3
    L_0x0026:
        r1 = 1
        goto L_0x005a
    L_0x0028:
        com.bytedance.embedapplog.b.h r1 = r11.f5045b
        java.lang.Long r1 = r1.mo13408k()
        if (r1 == 0) goto L_0x0058
        long r5 = java.lang.System.currentTimeMillis()
        long r7 = r1.longValue()
        r9 = 1800000(0x1b7740, double:8.89318E-318)
        long r7 = r7 + r9
        int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
        if (r1 < 0) goto L_0x0058
        android.content.Context r1 = r11.f5041a
        java.lang.String r1 = com.bytedance.embedapplog.util.C1852d.m6565b(r1)
        if (r1 == 0) goto L_0x0056
        com.bytedance.embedapplog.b.h r5 = r11.f5045b
        java.lang.String r5 = r5.mo13407j()
        boolean r5 = r1.equals(r5)
        if (r5 != 0) goto L_0x0056
        r5 = r1
        goto L_0x0026
    L_0x0056:
        r5 = r1
        goto L_0x0059
    L_0x0058:
        r5 = r3
    L_0x0059:
        r1 = 0
    L_0x005a:
        if (r1 == 0) goto L_0x0078
        org.json.JSONObject r5 = r11.m6266b(r5)
        java.lang.String r6 = m6265a(r5)
        boolean r7 = android.text.TextUtils.isEmpty(r6)
        if (r7 != 0) goto L_0x0073
        java.lang.String r7 = "wifi_bssid"
        java.lang.String r3 = r5.optString(r7, r3)
        r5 = r3
        r3 = r6
        goto L_0x0078
    L_0x0073:
        r5 = r3
        r3 = r6
        goto L_0x0077
    L_0x0076:
        r5 = r3
    L_0x0077:
        r1 = 0
    L_0x0078:
        com.bytedance.embedapplog.b.h r6 = r11.f5045b
        long r6 = r6.mo13404g()
        r8 = 21600000(0x1499700, double:1.0671818E-316)
        long r6 = r6 + r8
        if (r1 != 0) goto L_0x008c
        long r8 = java.lang.System.currentTimeMillis()
        int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
        if (r10 > 0) goto L_0x010d
    L_0x008c:
        org.json.JSONObject r6 = new org.json.JSONObject
        r6.<init>()
        java.lang.String r7 = "magic_tag"
        java.lang.String r8 = "ss_app_log"
        r6.put(r7, r8)
        java.lang.String r7 = "header"
        r6.put(r7, r0)
        long r7 = java.lang.System.currentTimeMillis()
        java.lang.String r0 = "_gen_time"
        r6.put(r0, r7)
        java.lang.String r0 = "fingerprint"
        r6.put(r0, r3)
        android.content.Context r0 = r11.f5041a
        com.bytedance.embedapplog.b.i r3 = r11.f5046c
        org.json.JSONObject r3 = r3.mo13425a()
        com.bytedance.embedapplog.util.UriConfig r7 = com.bytedance.embedapplog.p143c.C1835a.m6431a()
        java.lang.String r7 = r7.getSettingUri()
        com.bytedance.embedapplog.IAppParam r8 = com.bytedance.embedapplog.AppLog.getIAppParam()
        java.lang.String r0 = com.bytedance.embedapplog.p143c.C1836b.m6441a(r0, r3, r7, r4, r8)
        java.lang.String[] r3 = com.bytedance.embedapplog.p143c.C1835a.f5136c
        java.lang.String r0 = com.bytedance.embedapplog.p143c.C1835a.m6434a(r0, r3)
        org.json.JSONObject r0 = com.bytedance.embedapplog.p143c.C1835a.m6439c(r0, r6)
        com.bytedance.embedapplog.IDataObserver r3 = com.bytedance.embedapplog.AppLog.getDataObserver()
        com.bytedance.embedapplog.b.h r6 = r11.f5045b
        org.json.JSONObject r6 = r6.mo13403f()
        boolean r6 = com.bytedance.embedapplog.util.C1857i.m6592a(r0, r6)
        r6 = r6 ^ r4
        r3.onRemoteConfigGet(r6, r0)
        if (r0 == 0) goto L_0x010d
        com.bytedance.embedapplog.b.h r2 = r11.f5045b
        java.util.HashSet r2 = r2.mo13405h()
        int r2 = r2.size()
        long r2 = (long) r2
        com.bytedance.embedapplog.b.h r6 = r11.f5045b
        r6.mo13392a(r0, r1, r5)
        com.bytedance.embedapplog.b.h r0 = r11.f5045b
        java.util.HashSet r0 = r0.mo13405h()
        int r0 = r0.size()
        long r0 = (long) r0
        int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
        if (r5 <= 0) goto L_0x010c
        int r0 = r11.f5047d
        if (r0 <= 0) goto L_0x010c
        int r0 = r0 - r4
        r11.f5047d = r0
        boolean r0 = r11.mo13348d()
        return r0
    L_0x010c:
        return r4
    L_0x010d:
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.p141a.C1804d.mo13348d():boolean");
    }

    /* renamed from: a */
    private static String m6265a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return null;
        }
        return m6263a(jSONObject.toString());
    }

    /* renamed from: a */
    private static String m6263a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                byte[] bytes = str.getBytes("UTF-8");
                int length = bytes.length;
                for (int i = 0; i < length; i++) {
                    bytes[i] = (byte) (bytes[i] ^ -99);
                }
                return Base64.encodeToString(bytes, 10);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:15|16|(1:20)|25|26|(1:31)(1:30)) */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0073, code lost:
            r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            r1.put(r0, r4.getClass().getName());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005b */
    /* renamed from: b */
    private org.json.JSONObject m6266b(java.lang.String r9) {
        /*
        r8 = this;
        java.lang.String r0 = "no_raw_phone"
        org.json.JSONObject r1 = new org.json.JSONObject
        r1.<init>()
        com.bytedance.embedapplog.b.h r2 = r8.f5045b
        java.util.HashSet r2 = r2.mo13405h()
        boolean r3 = r2.isEmpty()
        r4 = 0
        if (r3 == 0) goto L_0x0015
        return r4
    L_0x0015:
        android.content.Context r3 = r8.f5041a     // Catch:{ all -> 0x0020 }
        java.lang.String r5 = "phone"
        java.lang.Object r3 = r3.getSystemService(r5)     // Catch:{ all -> 0x0020 }
        android.telephony.TelephonyManager r3 = (android.telephony.TelephonyManager) r3     // Catch:{ all -> 0x0020 }
        goto L_0x0021
    L_0x0020:
        r3 = r4
    L_0x0021:
        if (r3 != 0) goto L_0x0024
        return r4
    L_0x0024:
        java.lang.String r4 = "m_phone_number"
        r5 = 1
        java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
        boolean r5 = r2.contains(r5)
        if (r5 == 0) goto L_0x0081
        boolean r5 = r1.isNull(r4)
        if (r5 == 0) goto L_0x0081
        boolean r5 = com.bytedance.embedapplog.util.C1853e.m6568a(r4)
        if (r5 == 0) goto L_0x0081
        java.lang.String r5 = m6262a(r3)     // Catch:{ all -> 0x004d }
        if (r5 == 0) goto L_0x005b
        int r6 = r5.length()     // Catch:{ all -> 0x004d }
        if (r6 <= 0) goto L_0x005b
        r1.put(r4, r5)     // Catch:{ all -> 0x004d }
        goto L_0x005b
    L_0x004d:
        r4 = move-exception
        java.lang.String r5 = "no_m_phone"
        java.lang.Class r4 = r4.getClass()     // Catch:{ Exception -> 0x005b }
        java.lang.String r4 = r4.getName()     // Catch:{ Exception -> 0x005b }
        r1.put(r5, r4)     // Catch:{ Exception -> 0x005b }
    L_0x005b:
        java.lang.String r4 = com.bytedance.embedapplog.util.C1853e.m6571d(r3)     // Catch:{ all -> 0x0073 }
        if (r4 == 0) goto L_0x006d
        int r5 = r4.length()     // Catch:{ all -> 0x0073 }
        if (r5 <= 0) goto L_0x006d
        java.lang.String r5 = "raw_phone_number"
        r1.put(r5, r4)     // Catch:{ all -> 0x0073 }
        goto L_0x0081
    L_0x006d:
        java.lang.String r4 = "empty"
        r1.put(r0, r4)     // Catch:{ all -> 0x0073 }
        goto L_0x0081
    L_0x0073:
        r4 = move-exception
        java.lang.Class r4 = r4.getClass()     // Catch:{ Exception -> 0x0080 }
        java.lang.String r4 = r4.getName()     // Catch:{ Exception -> 0x0080 }
        r1.put(r0, r4)     // Catch:{ Exception -> 0x0080 }
        goto L_0x0081
    L_0x0081:
        java.lang.String r0 = "sim_serial"
        r4 = 2
        java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        boolean r4 = r2.contains(r4)
        r5 = 30
        if (r4 == 0) goto L_0x00b3
        boolean r4 = r1.isNull(r0)
        if (r4 == 0) goto L_0x00b3
        boolean r4 = com.bytedance.embedapplog.util.C1853e.m6568a(r0)
        if (r4 == 0) goto L_0x00b3
        java.lang.String r4 = com.bytedance.embedapplog.util.C1853e.m6569b(r3)     // Catch:{ all -> 0x00b2 }
        if (r4 == 0) goto L_0x00b3
        int r6 = r4.length()     // Catch:{ all -> 0x00b2 }
        if (r6 <= 0) goto L_0x00b3
        int r6 = r4.length()     // Catch:{ all -> 0x00b2 }
        if (r6 >= r5) goto L_0x00b3
        r1.put(r0, r4)     // Catch:{ all -> 0x00b2 }
        goto L_0x00b3
    L_0x00b3:
        java.lang.String r0 = "subscribe_id"
        r4 = 3
        java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        boolean r4 = r2.contains(r4)
        if (r4 == 0) goto L_0x00e3
        boolean r4 = r1.isNull(r0)
        if (r4 == 0) goto L_0x00e3
        boolean r4 = com.bytedance.embedapplog.util.C1853e.m6568a(r0)
        if (r4 == 0) goto L_0x00e3
        java.lang.String r4 = com.bytedance.embedapplog.util.C1853e.m6570c(r3)     // Catch:{ all -> 0x00e2 }
        if (r4 == 0) goto L_0x00e3
        int r6 = r4.length()     // Catch:{ all -> 0x00e2 }
        if (r6 <= 0) goto L_0x00e3
        int r6 = r4.length()     // Catch:{ all -> 0x00e2 }
        if (r6 >= r5) goto L_0x00e3
        r1.put(r0, r4)     // Catch:{ all -> 0x00e2 }
        goto L_0x00e3
    L_0x00e3:
        java.lang.String r0 = "sim_op"
        r4 = 4
        java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
        boolean r6 = r2.contains(r6)
        if (r6 == 0) goto L_0x0113
        boolean r6 = r1.isNull(r0)
        if (r6 == 0) goto L_0x0113
        boolean r6 = com.bytedance.embedapplog.util.C1853e.m6568a(r0)
        if (r6 == 0) goto L_0x0113
        java.lang.String r6 = r3.getSimOperator()     // Catch:{ all -> 0x0112 }
        if (r6 == 0) goto L_0x0113
        int r7 = r6.length()     // Catch:{ all -> 0x0112 }
        if (r7 <= 0) goto L_0x0113
        int r7 = r6.length()     // Catch:{ all -> 0x0112 }
        if (r7 >= r5) goto L_0x0113
        r1.put(r0, r6)     // Catch:{ all -> 0x0112 }
        goto L_0x0113
    L_0x0113:
        java.lang.String r0 = "net_op"
        java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
        boolean r6 = r2.contains(r6)
        if (r6 == 0) goto L_0x0142
        boolean r6 = r1.isNull(r0)
        if (r6 == 0) goto L_0x0142
        boolean r6 = com.bytedance.embedapplog.util.C1853e.m6568a(r0)
        if (r6 == 0) goto L_0x0142
        java.lang.String r6 = r3.getNetworkOperator()     // Catch:{ all -> 0x0141 }
        if (r6 == 0) goto L_0x0142
        int r7 = r6.length()     // Catch:{ all -> 0x0141 }
        if (r7 <= 0) goto L_0x0142
        int r7 = r6.length()     // Catch:{ all -> 0x0141 }
        if (r7 >= r5) goto L_0x0142
        r1.put(r0, r6)     // Catch:{ all -> 0x0141 }
        goto L_0x0142
    L_0x0142:
        java.lang.String r0 = "phone_type"
        java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
        boolean r5 = r2.contains(r5)
        if (r5 == 0) goto L_0x0163
        boolean r5 = r1.isNull(r0)
        if (r5 == 0) goto L_0x0163
        boolean r5 = com.bytedance.embedapplog.util.C1853e.m6568a(r0)
        if (r5 == 0) goto L_0x0163
        int r5 = r3.getPhoneType()     // Catch:{ Exception -> 0x0162 }
        r1.put(r0, r5)     // Catch:{ Exception -> 0x0162 }
        goto L_0x0163
    L_0x0163:
        java.lang.String r0 = "net_type"
        java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        boolean r4 = r2.contains(r4)
        if (r4 == 0) goto L_0x0184
        boolean r4 = r1.isNull(r0)
        if (r4 == 0) goto L_0x0184
        boolean r4 = com.bytedance.embedapplog.util.C1853e.m6568a(r0)
        if (r4 == 0) goto L_0x0184
        int r3 = r3.getNetworkType()     // Catch:{ Exception -> 0x0183 }
        r1.put(r0, r3)     // Catch:{ Exception -> 0x0183 }
        goto L_0x0184
    L_0x0184:
        java.lang.String r0 = "wifi_bssid"
        r3 = 6
        java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        boolean r2 = r2.contains(r3)
        if (r2 == 0) goto L_0x01ac
        boolean r2 = com.bytedance.embedapplog.util.C1853e.m6568a(r0)
        if (r2 == 0) goto L_0x01ac
        boolean r2 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x01ac }
        if (r2 == 0) goto L_0x01a3
        android.content.Context r9 = r8.f5041a     // Catch:{ Exception -> 0x01ac }
        java.lang.String r9 = com.bytedance.embedapplog.util.C1852d.m6565b(r9)     // Catch:{ Exception -> 0x01ac }
    L_0x01a3:
        boolean r2 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x01ac }
        if (r2 != 0) goto L_0x01ac
        r1.put(r0, r9)     // Catch:{ Exception -> 0x01ac }
    L_0x01ac:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.p141a.C1804d.m6266b(java.lang.String):org.json.JSONObject");
    }

    /* renamed from: a */
    private static String m6262a(TelephonyManager telephonyManager) {
        String d = C1853e.m6571d(telephonyManager);
        String str = "";
        if (TextUtils.isEmpty(d)) {
            return str;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Pair.create(Pattern.compile("^(\\+86)?(1\\d{10})$"), "$2"));
        return !TextUtils.isEmpty(m6264a(d, arrayList)) ? C1854f.m6572a(d) : str;
    }

    /* renamed from: a */
    private static String m6264a(String str, List<Pair<Pattern, String>> list) {
        if (!(list == null || list.size() == 0 || TextUtils.isEmpty(str))) {
            String replaceAll = f5044e.matcher(str).replaceAll("");
            for (Pair pair : list) {
                Matcher matcher = ((Pattern) pair.first).matcher(replaceAll);
                if (matcher.matches()) {
                    return matcher.replaceAll((String) pair.second);
                }
            }
        }
        return null;
    }
}
