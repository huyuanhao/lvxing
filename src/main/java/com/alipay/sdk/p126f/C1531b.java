package com.alipay.sdk.p126f;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alipay.sdk.p122c.C1514b;
import com.alipay.sdk.util.C1542e;
import discoveryAD.C7880W.C7881a;
import java.util.Random;
import org.json.JSONObject;

/* renamed from: com.alipay.sdk.f.b */
public class C1531b {
    /* access modifiers changed from: private|static */
    /* renamed from: a */
    public static Context f3904a;
    /* renamed from: g */
    private static C1531b f3905g;
    /* renamed from: b */
    private String f3906b;
    /* renamed from: c */
    private String f3907c;
    /* renamed from: d */
    private long f3908d;
    /* renamed from: e */
    private String f3909e;
    /* renamed from: f */
    private String f3910f;
    /* renamed from: h */
    private boolean f3911h = false;

    /* renamed from: com.alipay.sdk.f.b$a */
    public static class C1532a {
        /* renamed from: a */
        private static String m4587a() {
            return "!@#23457";
        }

        /* renamed from: a */
        public static void m4589a(String str, String str2) {
            if (C1531b.f3904a != null) {
                C1531b.f3904a.getSharedPreferences(str, 0).edit().remove(str2).apply();
            }
        }

        /* renamed from: b */
        public static boolean m4592b(String str, String str2) {
            if (C1531b.f3904a == null) {
                return false;
            }
            return C1531b.f3904a.getSharedPreferences(str, 0).contains(str2);
        }

        /* renamed from: a */
        public static String m4588a(String str, String str2, boolean z) {
            String str3;
            if (C1531b.f3904a == null) {
                return null;
            }
            String string = C1531b.f3904a.getSharedPreferences(str, 0).getString(str2, null);
            String str4 = "TidStorage";
            if (TextUtils.isEmpty(string) || !z) {
                str3 = string;
            } else {
                String b = m4591b();
                str3 = C1514b.m4513b(string, b);
                if (TextUtils.isEmpty(str3)) {
                    str3 = C1514b.m4513b(string, m4587a());
                    if (!TextUtils.isEmpty(str3)) {
                        m4590a(str, str2, str3, true);
                    }
                }
                if (TextUtils.isEmpty(str3)) {
                    String.format("LocalPreference::getLocalPreferences failed %s，%s", new Object[]{string, b});
                    C1542e.m4631a(str4, "TidStorage.save LocalPreference::getLocalPreferences failed");
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("TidStorage.save LocalPreference::getLocalPreferences value ");
            sb.append(string);
            C1542e.m4631a(str4, sb.toString());
            return str3;
        }

        /* renamed from: a */
        public static void m4590a(String str, String str2, String str3, boolean z) {
            if (C1531b.f3904a != null) {
                SharedPreferences sharedPreferences = C1531b.f3904a.getSharedPreferences(str, 0);
                if (z) {
                    String b = m4591b();
                    String a = C1514b.m4512a(str3, b);
                    if (TextUtils.isEmpty(a)) {
                        String.format("LocalPreference::putLocalPreferences failed %s，%s", new Object[]{str3, b});
                    }
                    str3 = a;
                }
                sharedPreferences.edit().putString(str2, str3).apply();
            }
        }

        /* renamed from: b */
        private static String m4591b() {
            String str;
            try {
                str = C1531b.f3904a.getApplicationContext().getPackageName();
            } catch (Throwable th) {
                C1542e.m4633a(th);
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                str = "unknow";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("00000000");
            return sb.toString().substring(0, 8);
        }
    }

    /* renamed from: i */
    private void m4581i() {
    }

    /* renamed from: a */
    public static synchronized C1531b m4573a(Context context) {
        C1531b bVar;
        synchronized (C1531b.class) {
            if (f3905g == null) {
                C1542e.m4631a("TidStorage", "getInstance");
                f3905g = new C1531b();
            }
            if (f3904a == null) {
                f3905g.m4575b(context);
            }
            bVar = f3905g;
        }
        return bVar;
    }

    /* renamed from: b */
    private void m4575b(Context context) {
        if (context != null) {
            C1542e.m4631a("TidStorage", "TidStorage.initialize context != null");
            f3904a = context.getApplicationContext();
        }
        if (!this.f3911h) {
            this.f3911h = true;
            m4577e();
            m4578f();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0072, code lost:
            if (r5 != null) goto L_0x0065;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008f A[DONT_GENERATE] */
    /* renamed from: e */
    private void m4577e() {
        /*
        r10 = this;
        android.content.Context r0 = f3904a
        if (r0 != 0) goto L_0x0005
        return
    L_0x0005:
        java.lang.String r1 = "upgraded_from_db"
        java.lang.String r2 = "alipay_tid_storage"
        boolean r3 = com.alipay.sdk.p126f.C1531b.C1532a.m4592b(r2, r1)
        java.lang.String r4 = "TidStorage"
        if (r3 == 0) goto L_0x0017
        java.lang.String r0 = "transferTidFromOldDb: already migrated. returning"
        com.alipay.sdk.util.C1542e.m4631a(r4, r0)
        return
    L_0x0017:
        r3 = 0
        java.lang.String r5 = "transferTidFromOldDb: tid from db: "
        com.alipay.sdk.util.C1542e.m4631a(r4, r5)     // Catch:{ all -> 0x006b }
        com.alipay.sdk.f.a r5 = new com.alipay.sdk.f.a     // Catch:{ all -> 0x006b }
        r5.m42158init(r0)     // Catch:{ all -> 0x006b }
        com.alipay.sdk.util.b r3 = com.alipay.sdk.util.C1539b.m4617a(r0)     // Catch:{ all -> 0x0069 }
        java.lang.String r3 = r3.mo12210b()     // Catch:{ all -> 0x0069 }
        com.alipay.sdk.util.b r6 = com.alipay.sdk.util.C1539b.m4617a(r0)     // Catch:{ all -> 0x0069 }
        java.lang.String r6 = r6.mo12208a()     // Catch:{ all -> 0x0069 }
        java.lang.String r7 = r5.mo12188a(r3, r6)     // Catch:{ all -> 0x0069 }
        java.lang.String r3 = r5.mo12190b(r3, r6)     // Catch:{ all -> 0x0069 }
        boolean r6 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0069 }
        if (r6 != 0) goto L_0x0065
        boolean r6 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0069 }
        if (r6 != 0) goto L_0x0065
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0069 }
        r6.<init>()     // Catch:{ all -> 0x0069 }
        java.lang.String r8 = "transferTidFromOldDb: tid from db is "
        r6.append(r8)     // Catch:{ all -> 0x0069 }
        r6.append(r7)     // Catch:{ all -> 0x0069 }
        java.lang.String r8 = ", "
        r6.append(r8)     // Catch:{ all -> 0x0069 }
        r6.append(r3)     // Catch:{ all -> 0x0069 }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0069 }
        com.alipay.sdk.util.C1542e.m4631a(r4, r6)     // Catch:{ all -> 0x0069 }
        r10.mo12194a(r7, r3)     // Catch:{ all -> 0x0069 }
    L_0x0065:
        r5.close()
        goto L_0x0075
    L_0x0069:
        r3 = move-exception
        goto L_0x006f
    L_0x006b:
        r5 = move-exception
        r9 = r5
        r5 = r3
        r3 = r9
    L_0x006f:
        com.alipay.sdk.util.C1542e.m4633a(r3)     // Catch:{ all -> 0x00a0 }
        if (r5 == 0) goto L_0x0075
        goto L_0x0065
    L_0x0075:
        java.lang.String r3 = "transferTidFromOldDb: removing database table"
        com.alipay.sdk.util.C1542e.m4631a(r4, r3)     // Catch:{ all -> 0x0089 }
        com.alipay.sdk.f.a r3 = new com.alipay.sdk.f.a     // Catch:{ all -> 0x0089 }
        r3.m42158init(r0)     // Catch:{ all -> 0x0089 }
        r3.mo12189a()     // Catch:{ all -> 0x0086 }
        r3.close()
        goto L_0x0092
    L_0x0086:
        r0 = move-exception
        r5 = r3
        goto L_0x008a
    L_0x0089:
        r0 = move-exception
    L_0x008a:
        com.alipay.sdk.util.C1542e.m4633a(r0)     // Catch:{ all -> 0x0099 }
        if (r5 == 0) goto L_0x0092
        r5.close()
    L_0x0092:
        r0 = 0
        java.lang.String r3 = "updated"
        com.alipay.sdk.p126f.C1531b.C1532a.m4590a(r2, r1, r3, r0)
        return
    L_0x0099:
        r0 = move-exception
        if (r5 == 0) goto L_0x009f
        r5.close()
    L_0x009f:
        throw r0
    L_0x00a0:
        r0 = move-exception
        if (r5 == 0) goto L_0x00a6
        r5.close()
    L_0x00a6:
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.p126f.C1531b.m4577e():void");
    }

    /* renamed from: a */
    public String mo12193a() {
        StringBuilder sb = new StringBuilder();
        sb.append("TidStorage.getTid ");
        sb.append(this.f3906b);
        C1542e.m4631a("TidStorage", sb.toString());
        return this.f3906b;
    }

    /* renamed from: b */
    public String mo12195b() {
        StringBuilder sb = new StringBuilder();
        sb.append("TidStorage.getClientKey ");
        sb.append(this.f3907c);
        C1542e.m4631a("TidStorage", sb.toString());
        return this.f3907c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0095  */
    /* renamed from: f */
    private void m4578f() {
        /*
        r9 = this;
        java.lang.String r0 = ""
        long r1 = java.lang.System.currentTimeMillis()
        java.lang.Long r1 = java.lang.Long.valueOf(r1)
        r2 = 0
        java.lang.String r3 = "alipay_tid_storage"
        java.lang.String r4 = "tidinfo"
        r5 = 1
        java.lang.String r3 = com.alipay.sdk.p126f.C1531b.C1532a.m4588a(r3, r4, r5)     // Catch:{ Exception -> 0x0052 }
        boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0052 }
        if (r4 != 0) goto L_0x004e
        org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0052 }
        r4.<init>(r3)     // Catch:{ Exception -> 0x0052 }
        java.lang.String r3 = "tid"
        java.lang.String r3 = r4.optString(r3, r0)     // Catch:{ Exception -> 0x0052 }
        java.lang.String r5 = "client_key"
        java.lang.String r5 = r4.optString(r5, r0)     // Catch:{ Exception -> 0x004b }
        java.lang.String r6 = "timestamp"
        long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0048 }
        long r6 = r4.optLong(r6, r7)     // Catch:{ Exception -> 0x0048 }
        java.lang.Long r1 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x0048 }
        java.lang.String r6 = "vimei"
        java.lang.String r6 = r4.optString(r6, r0)     // Catch:{ Exception -> 0x0048 }
        java.lang.String r7 = "vimsi"
        java.lang.String r0 = r4.optString(r7, r0)     // Catch:{ Exception -> 0x0046 }
        goto L_0x005a
    L_0x0046:
        r0 = move-exception
        goto L_0x0056
    L_0x0048:
        r0 = move-exception
        r6 = r2
        goto L_0x0056
    L_0x004b:
        r0 = move-exception
        r5 = r2
        goto L_0x0055
    L_0x004e:
        r0 = r2
        r5 = r0
        r6 = r5
        goto L_0x005b
    L_0x0052:
        r0 = move-exception
        r3 = r2
        r5 = r3
    L_0x0055:
        r6 = r5
    L_0x0056:
        com.alipay.sdk.util.C1542e.m4633a(r0)
        r0 = r2
    L_0x005a:
        r2 = r3
    L_0x005b:
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        java.lang.String r4 = "TidStorage.load "
        r3.append(r4)
        r3.append(r2)
        java.lang.String r4 = " "
        r3.append(r4)
        r3.append(r5)
        r3.append(r4)
        r3.append(r1)
        r3.append(r4)
        r3.append(r6)
        r3.append(r4)
        r3.append(r0)
        java.lang.String r3 = r3.toString()
        java.lang.String r4 = "TidStorage"
        com.alipay.sdk.util.C1542e.m4631a(r4, r3)
        boolean r3 = r9.m4574a(r2, r5, r6, r0)
        if (r3 == 0) goto L_0x0095
        r9.m4579g()
        goto L_0x00a3
    L_0x0095:
        r9.f3906b = r2
        r9.f3907c = r5
        long r1 = r1.longValue()
        r9.f3908d = r1
        r9.f3909e = r6
        r9.f3910f = r0
    L_0x00a3:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.p126f.C1531b.m4578f():void");
    }

    /* renamed from: a */
    private boolean m4574a(String str, String str2, String str3, String str4) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4);
    }

    /* renamed from: g */
    private void m4579g() {
        this.f3906b = "";
        this.f3907c = mo12196c();
        this.f3908d = System.currentTimeMillis();
        this.f3909e = m4580h();
        this.f3910f = m4580h();
        C1532a.m4589a("alipay_tid_storage", "tidinfo");
    }

    /* renamed from: h */
    private String m4580h() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append(hexString);
        sb.append(random.nextInt(9000) + 1000);
        return sb.toString();
    }

    /* renamed from: c */
    public String mo12196c() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        return hexString.length() > 10 ? hexString.substring(hexString.length() - 10) : hexString;
    }

    /* renamed from: a */
    public void mo12194a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("tid=");
        sb.append(str);
        sb.append(",clientKey=");
        sb.append(str2);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("TidStorage.save ");
        sb3.append(sb2);
        C1542e.m4631a("TidStorage", sb3.toString());
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.f3906b = str;
            this.f3907c = str2;
            this.f3908d = System.currentTimeMillis();
            m4582j();
            m4581i();
        }
    }

    /* renamed from: j */
    private void m4582j() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tid", this.f3906b);
            jSONObject.put("client_key", this.f3907c);
            jSONObject.put(C7881a.TIMESTAMP, this.f3908d);
            jSONObject.put("vimei", this.f3909e);
            jSONObject.put("vimsi", this.f3910f);
            C1532a.m4590a("alipay_tid_storage", "tidinfo", jSONObject.toString(), true);
        } catch (Exception e) {
            C1542e.m4633a(e);
        }
    }
}
