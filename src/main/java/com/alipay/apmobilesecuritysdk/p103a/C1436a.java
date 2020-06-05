package com.alipay.apmobilesecuritysdk.p103a;

import android.content.Context;
import android.os.Environment;
import com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper;
import com.alipay.apmobilesecuritysdk.p104b.C1437a;
import com.alipay.apmobilesecuritysdk.p105c.C1438a;
import com.alipay.apmobilesecuritysdk.p106d.C1445e;
import com.alipay.apmobilesecuritysdk.p107e.C1446a;
import com.alipay.apmobilesecuritysdk.p107e.C1447b;
import com.alipay.apmobilesecuritysdk.p107e.C1448c;
import com.alipay.apmobilesecuritysdk.p107e.C1449d;
import com.alipay.apmobilesecuritysdk.p107e.C1452g;
import com.alipay.apmobilesecuritysdk.p107e.C1453h;
import com.alipay.apmobilesecuritysdk.p107e.C1454i;
import com.alipay.p109b.p110a.p111a.p112a.C1460a;
import com.alipay.p109b.p110a.p111a.p117e.C1488d;
import com.alipay.p109b.p110a.p111a.p117e.p118a.C1482c;
import com.alipay.p109b.p110a.p111a.p117e.p118a.C1483d;
import com.tencent.p605ep.commonbase.software.AppEntity;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/* renamed from: com.alipay.apmobilesecuritysdk.a.a */
public final class C1436a {
    /* renamed from: a */
    private Context f3692a;
    /* renamed from: b */
    private C1437a f3693b = C1437a.m4163a();
    /* renamed from: c */
    private int f3694c = 4;

    public C1436a(Context context) {
        this.f3692a = context;
    }

    /* renamed from: a */
    public static String m4156a(Context context) {
        String b = m4160b(context);
        return C1460a.m4260a(b) ? C1453h.m4225f(context) : b;
    }

    /* renamed from: a */
    public static String m4157a(Context context, String str) {
        try {
            m4161b();
            String a = C1454i.m4229a(str);
            if (!C1460a.m4260a(a)) {
                return a;
            }
            String a2 = C1452g.m4208a(context, str);
            C1454i.m4233a(str, a2);
            if (!C1460a.m4260a(a2)) {
                return a2;
            }
            return "";
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    private static boolean m4158a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String[] strArr = {"2017-01-27 2017-01-28", "2017-11-10 2017-11-11", "2017-12-11 2017-12-12"};
        int random = ((int) (Math.random() * 24.0d * 60.0d * 60.0d)) * 1;
        int i = 0;
        while (i < 3) {
            try {
                String[] split = strArr[i].split(" ");
                if (split != null && split.length == 2) {
                    Date date = new Date();
                    StringBuilder sb = new StringBuilder();
                    sb.append(split[0]);
                    sb.append(" 00:00:00");
                    Date parse = simpleDateFormat.parse(sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(split[1]);
                    sb2.append(" 23:59:59");
                    Date parse2 = simpleDateFormat.parse(sb2.toString());
                    Calendar instance = Calendar.getInstance();
                    instance.setTime(parse2);
                    instance.add(13, random);
                    Date time = instance.getTime();
                    if (date.after(parse) && date.before(time)) {
                        return true;
                    }
                }
                i++;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* renamed from: b */
    private C1482c m4159b(Map<String, String> map) {
        String str;
        String str2;
        String str3;
        String str4 = "";
        try {
            Context context = this.f3692a;
            C1483d dVar = new C1483d();
            String a = C1460a.m4259a(map, AppEntity.KEY_APP_NAME_STR, str4);
            String a2 = C1460a.m4259a(map, "sessionId", str4);
            String a3 = C1460a.m4259a(map, "rpcVersion", str4);
            String a4 = m4157a(context, a);
            String securityToken = UmidSdkWrapper.getSecurityToken(context);
            String d = C1453h.m4221d(context);
            if (C1460a.m4263b(a2)) {
                dVar.f3769c = a2;
            } else {
                dVar.f3769c = a4;
            }
            dVar.f3770d = securityToken;
            dVar.f3771e = d;
            dVar.f3767a = "android";
            C1448c c = C1449d.m4196c(context);
            if (c != null) {
                str = c.f3702a;
                str2 = c.f3704c;
            } else {
                str2 = str4;
                str = str2;
            }
            if (C1460a.m4260a(str)) {
                C1447b c2 = C1446a.m4189c(context);
                if (c2 != null) {
                    str = c2.f3699a;
                    str2 = c2.f3701c;
                }
            }
            C1448c b = C1449d.m4194b();
            if (b != null) {
                str4 = b.f3702a;
                str3 = b.f3704c;
            } else {
                str3 = str4;
            }
            if (C1460a.m4260a(str4)) {
                C1447b b2 = C1446a.m4187b();
                if (b2 != null) {
                    str4 = b2.f3699a;
                    str3 = b2.f3701c;
                }
            }
            dVar.f3774h = str;
            dVar.f3773g = str4;
            dVar.f3776j = a3;
            if (C1460a.m4260a(str)) {
                dVar.f3768b = str4;
                dVar.f3775i = str3;
            } else {
                dVar.f3768b = str;
                dVar.f3775i = str2;
            }
            dVar.f3772f = C1445e.m4179a(context, map);
            return C1488d.m4385b(this.f3692a, this.f3693b.mo12006c()).mo12094a(dVar);
        } catch (Throwable th) {
            th.printStackTrace();
            C1438a.m4169a(th);
            return null;
        }
    }

    /* renamed from: b */
    private static String m4160b(Context context) {
        try {
            String b = C1454i.m4235b();
            if (!C1460a.m4260a(b)) {
                return b;
            }
            C1448c b2 = C1449d.m4195b(context);
            if (b2 != null) {
                C1454i.m4232a(b2);
                String str = b2.f3702a;
                if (C1460a.m4263b(str)) {
                    return str;
                }
            }
            C1447b b3 = C1446a.m4188b(context);
            if (b3 != null) {
                C1454i.m4231a(b3);
                String str2 = b3.f3699a;
                if (C1460a.m4263b(str2)) {
                    return str2;
                }
            }
            return "";
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    private static void m4161b() {
        try {
            String[] strArr = {"device_feature_file_name", "wallet_times", "wxcasxx_v3", "wxcasxx_v4", "wxxzyy_v1"};
            for (int i = 0; i < 5; i++) {
                String str = strArr[i];
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                StringBuilder sb = new StringBuilder(".SystemConfig/");
                sb.append(str);
                File file = new File(externalStorageDirectory, sb.toString());
                if (file.exists() && file.canWrite()) {
                    file.delete();
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d4 A[Catch:{ Exception -> 0x023d }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0200 A[Catch:{ Exception -> 0x023d }] */
    /* renamed from: a */
    public final int mo12003a(java.util.Map<java.lang.String, java.lang.String> r10) {
        /*
        r9 = this;
        java.lang.String r0 = "utdid"
        java.lang.String r1 = "tid"
        java.lang.String r2 = ""
        android.content.Context r3 = r9.f3692a     // Catch:{ Exception -> 0x023d }
        java.lang.String r4 = com.alipay.p109b.p110a.p111a.p112a.C1460a.m4259a(r10, r1, r2)     // Catch:{ Exception -> 0x023d }
        java.lang.String r5 = com.alipay.p109b.p110a.p111a.p112a.C1460a.m4259a(r10, r0, r2)     // Catch:{ Exception -> 0x023d }
        android.content.Context r6 = r9.f3692a     // Catch:{ Exception -> 0x023d }
        java.lang.String r6 = m4156a(r6)     // Catch:{ Exception -> 0x023d }
        com.alipay.apmobilesecuritysdk.p105c.C1438a.m4167a(r3, r4, r5, r6)     // Catch:{ Exception -> 0x023d }
        java.lang.String r3 = "appName"
        java.lang.String r3 = com.alipay.p109b.p110a.p111a.p112a.C1460a.m4259a(r10, r3, r2)     // Catch:{ Exception -> 0x023d }
        m4161b()     // Catch:{ Exception -> 0x023d }
        android.content.Context r4 = r9.f3692a     // Catch:{ Exception -> 0x023d }
        m4160b(r4)     // Catch:{ Exception -> 0x023d }
        android.content.Context r4 = r9.f3692a     // Catch:{ Exception -> 0x023d }
        m4157a(r4, r3)     // Catch:{ Exception -> 0x023d }
        com.alipay.apmobilesecuritysdk.p107e.C1454i.m4230a()     // Catch:{ Exception -> 0x023d }
        boolean r4 = m4158a()     // Catch:{ Exception -> 0x023d }
        r5 = 0
        r6 = 1
        if (r4 != 0) goto L_0x00a2
        android.content.Context r4 = r9.f3692a     // Catch:{ Exception -> 0x023d }
        boolean r4 = com.alipay.apmobilesecuritysdk.common.C1440a.m4171a(r4)     // Catch:{ Exception -> 0x023d }
        if (r4 == 0) goto L_0x0040
        goto L_0x00a2
    L_0x0040:
        com.alipay.apmobilesecuritysdk.p106d.C1445e.m4180a()     // Catch:{ Exception -> 0x023d }
        android.content.Context r4 = r9.f3692a     // Catch:{ Exception -> 0x023d }
        java.lang.String r4 = com.alipay.apmobilesecuritysdk.p106d.C1445e.m4181b(r4, r10)     // Catch:{ Exception -> 0x023d }
        java.lang.String r7 = com.alipay.apmobilesecuritysdk.p107e.C1454i.m4237c()     // Catch:{ Exception -> 0x023d }
        boolean r4 = com.alipay.p109b.p110a.p111a.p112a.C1460a.m4261a(r4, r7)     // Catch:{ Exception -> 0x023d }
        r4 = r4 ^ r6
        if (r4 == 0) goto L_0x0055
        goto L_0x00ae
    L_0x0055:
        java.lang.String r4 = com.alipay.p109b.p110a.p111a.p112a.C1460a.m4259a(r10, r1, r2)     // Catch:{ Exception -> 0x023d }
        java.lang.String r7 = com.alipay.p109b.p110a.p111a.p112a.C1460a.m4259a(r10, r0, r2)     // Catch:{ Exception -> 0x023d }
        boolean r8 = com.alipay.p109b.p110a.p111a.p112a.C1460a.m4263b(r4)     // Catch:{ Exception -> 0x023d }
        if (r8 == 0) goto L_0x006e
        java.lang.String r8 = com.alipay.apmobilesecuritysdk.p107e.C1454i.m4239d()     // Catch:{ Exception -> 0x023d }
        boolean r4 = com.alipay.p109b.p110a.p111a.p112a.C1460a.m4261a(r4, r8)     // Catch:{ Exception -> 0x023d }
        if (r4 != 0) goto L_0x006e
        goto L_0x00ae
    L_0x006e:
        boolean r4 = com.alipay.p109b.p110a.p111a.p112a.C1460a.m4263b(r7)     // Catch:{ Exception -> 0x023d }
        if (r4 == 0) goto L_0x007f
        java.lang.String r4 = com.alipay.apmobilesecuritysdk.p107e.C1454i.m4241e()     // Catch:{ Exception -> 0x023d }
        boolean r4 = com.alipay.p109b.p110a.p111a.p112a.C1460a.m4261a(r7, r4)     // Catch:{ Exception -> 0x023d }
        if (r4 != 0) goto L_0x007f
        goto L_0x00ae
    L_0x007f:
        android.content.Context r4 = r9.f3692a     // Catch:{ Exception -> 0x023d }
        boolean r4 = com.alipay.apmobilesecuritysdk.p107e.C1454i.m4234a(r4, r3)     // Catch:{ Exception -> 0x023d }
        if (r4 != 0) goto L_0x0088
        goto L_0x00ae
    L_0x0088:
        android.content.Context r4 = r9.f3692a     // Catch:{ Exception -> 0x023d }
        java.lang.String r4 = m4157a(r4, r3)     // Catch:{ Exception -> 0x023d }
        boolean r4 = com.alipay.p109b.p110a.p111a.p112a.C1460a.m4260a(r4)     // Catch:{ Exception -> 0x023d }
        if (r4 == 0) goto L_0x0095
        goto L_0x00ae
    L_0x0095:
        android.content.Context r4 = r9.f3692a     // Catch:{ Exception -> 0x023d }
        java.lang.String r4 = m4160b(r4)     // Catch:{ Exception -> 0x023d }
        boolean r4 = com.alipay.p109b.p110a.p111a.p112a.C1460a.m4260a(r4)     // Catch:{ Exception -> 0x023d }
        if (r4 == 0) goto L_0x00bd
        goto L_0x00ae
    L_0x00a2:
        android.content.Context r4 = r9.f3692a     // Catch:{ Exception -> 0x023d }
        java.lang.String r4 = m4157a(r4, r3)     // Catch:{ Exception -> 0x023d }
        boolean r4 = com.alipay.p109b.p110a.p111a.p112a.C1460a.m4260a(r4)     // Catch:{ Exception -> 0x023d }
        if (r4 == 0) goto L_0x00b0
    L_0x00ae:
        r4 = 1
        goto L_0x00be
    L_0x00b0:
        android.content.Context r4 = r9.f3692a     // Catch:{ Exception -> 0x023d }
        java.lang.String r4 = m4160b(r4)     // Catch:{ Exception -> 0x023d }
        boolean r4 = com.alipay.p109b.p110a.p111a.p112a.C1460a.m4260a(r4)     // Catch:{ Exception -> 0x023d }
        if (r4 == 0) goto L_0x00bd
        goto L_0x00ae
    L_0x00bd:
        r4 = 0
    L_0x00be:
        android.content.Context r7 = r9.f3692a     // Catch:{ Exception -> 0x023d }
        com.alipay.b.a.a.d.b r8 = com.alipay.p109b.p110a.p111a.p116d.C1476b.m4299a()     // Catch:{ Exception -> 0x023d }
        java.lang.String r8 = r8.mo12063q()     // Catch:{ Exception -> 0x023d }
        java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x023d }
        com.alipay.apmobilesecuritysdk.p107e.C1453h.m4218b(r7, r8)     // Catch:{ Exception -> 0x023d }
        if (r4 != 0) goto L_0x00d4
    L_0x00d1:
        r10 = 0
        goto L_0x01e5
    L_0x00d4:
        com.alipay.apmobilesecuritysdk.c.b r4 = new com.alipay.apmobilesecuritysdk.c.b     // Catch:{ Exception -> 0x023d }
        r4.m42061init()     // Catch:{ Exception -> 0x023d }
        android.content.Context r4 = r9.f3692a     // Catch:{ Exception -> 0x023d }
        com.alipay.apmobilesecuritysdk.b.a r7 = com.alipay.apmobilesecuritysdk.p104b.C1437a.m4163a()     // Catch:{ Exception -> 0x023d }
        int r7 = r7.mo12005b()     // Catch:{ Exception -> 0x023d }
        com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper.startUmidTaskSync(r4, r7)     // Catch:{ Exception -> 0x023d }
        com.alipay.b.a.a.e.a.c r4 = r9.m4159b(r10)     // Catch:{ Exception -> 0x023d }
        if (r4 == 0) goto L_0x00f1
        int r7 = r4.mo12091a()     // Catch:{ Exception -> 0x023d }
        goto L_0x00f2
    L_0x00f1:
        r7 = 2
    L_0x00f2:
        if (r7 == r6) goto L_0x0122
        r10 = 3
        if (r7 == r10) goto L_0x011f
        if (r4 == 0) goto L_0x010d
        java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x023d }
        java.lang.String r0 = "Server error, result:"
        r10.<init>(r0)     // Catch:{ Exception -> 0x023d }
        java.lang.String r0 = r4.f3757b     // Catch:{ Exception -> 0x023d }
        r10.append(r0)     // Catch:{ Exception -> 0x023d }
        java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x023d }
    L_0x0109:
        com.alipay.apmobilesecuritysdk.p105c.C1438a.m4168a(r10)     // Catch:{ Exception -> 0x023d }
        goto L_0x0110
    L_0x010d:
        java.lang.String r10 = "Server error, returned null"
        goto L_0x0109
    L_0x0110:
        android.content.Context r10 = r9.f3692a     // Catch:{ Exception -> 0x023d }
        java.lang.String r10 = m4157a(r10, r3)     // Catch:{ Exception -> 0x023d }
        boolean r10 = com.alipay.p109b.p110a.p111a.p112a.C1460a.m4260a(r10)     // Catch:{ Exception -> 0x023d }
        if (r10 == 0) goto L_0x00d1
        r10 = 4
        goto L_0x01e5
    L_0x011f:
        r10 = 1
        goto L_0x01e5
    L_0x0122:
        android.content.Context r7 = r9.f3692a     // Catch:{ Exception -> 0x023d }
        boolean r8 = r4.mo12092b()     // Catch:{ Exception -> 0x023d }
        com.alipay.apmobilesecuritysdk.p107e.C1453h.m4216a(r7, r8)     // Catch:{ Exception -> 0x023d }
        android.content.Context r7 = r9.f3692a     // Catch:{ Exception -> 0x023d }
        java.lang.String r8 = r4.mo12093c()     // Catch:{ Exception -> 0x023d }
        com.alipay.apmobilesecuritysdk.p107e.C1453h.m4222d(r7, r8)     // Catch:{ Exception -> 0x023d }
        android.content.Context r7 = r9.f3692a     // Catch:{ Exception -> 0x023d }
        java.lang.String r8 = r4.f3762g     // Catch:{ Exception -> 0x023d }
        com.alipay.apmobilesecuritysdk.p107e.C1453h.m4224e(r7, r8)     // Catch:{ Exception -> 0x023d }
        android.content.Context r7 = r9.f3692a     // Catch:{ Exception -> 0x023d }
        java.lang.String r8 = r4.f3763h     // Catch:{ Exception -> 0x023d }
        com.alipay.apmobilesecuritysdk.p107e.C1453h.m4213a(r7, r8)     // Catch:{ Exception -> 0x023d }
        android.content.Context r7 = r9.f3692a     // Catch:{ Exception -> 0x023d }
        java.lang.String r8 = r4.f3764i     // Catch:{ Exception -> 0x023d }
        com.alipay.apmobilesecuritysdk.p107e.C1453h.m4226f(r7, r8)     // Catch:{ Exception -> 0x023d }
        android.content.Context r7 = r9.f3692a     // Catch:{ Exception -> 0x023d }
        java.lang.String r8 = r4.f3766k     // Catch:{ Exception -> 0x023d }
        com.alipay.apmobilesecuritysdk.p107e.C1453h.m4227g(r7, r8)     // Catch:{ Exception -> 0x023d }
        android.content.Context r7 = r9.f3692a     // Catch:{ Exception -> 0x023d }
        java.lang.String r7 = com.alipay.apmobilesecuritysdk.p106d.C1445e.m4181b(r7, r10)     // Catch:{ Exception -> 0x023d }
        com.alipay.apmobilesecuritysdk.p107e.C1454i.m4238c(r7)     // Catch:{ Exception -> 0x023d }
        java.lang.String r7 = r4.f3759d     // Catch:{ Exception -> 0x023d }
        com.alipay.apmobilesecuritysdk.p107e.C1454i.m4233a(r3, r7)     // Catch:{ Exception -> 0x023d }
        java.lang.String r7 = r4.f3758c     // Catch:{ Exception -> 0x023d }
        com.alipay.apmobilesecuritysdk.p107e.C1454i.m4236b(r7)     // Catch:{ Exception -> 0x023d }
        java.lang.String r4 = r4.f3765j     // Catch:{ Exception -> 0x023d }
        com.alipay.apmobilesecuritysdk.p107e.C1454i.m4240d(r4)     // Catch:{ Exception -> 0x023d }
        java.lang.String r1 = com.alipay.p109b.p110a.p111a.p112a.C1460a.m4259a(r10, r1, r2)     // Catch:{ Exception -> 0x023d }
        boolean r4 = com.alipay.p109b.p110a.p111a.p112a.C1460a.m4263b(r1)     // Catch:{ Exception -> 0x023d }
        if (r4 == 0) goto L_0x0180
        java.lang.String r4 = com.alipay.apmobilesecuritysdk.p107e.C1454i.m4239d()     // Catch:{ Exception -> 0x023d }
        boolean r4 = com.alipay.p109b.p110a.p111a.p112a.C1460a.m4261a(r1, r4)     // Catch:{ Exception -> 0x023d }
        if (r4 != 0) goto L_0x0180
        com.alipay.apmobilesecuritysdk.p107e.C1454i.m4242e(r1)     // Catch:{ Exception -> 0x023d }
        goto L_0x0184
    L_0x0180:
        java.lang.String r1 = com.alipay.apmobilesecuritysdk.p107e.C1454i.m4239d()     // Catch:{ Exception -> 0x023d }
    L_0x0184:
        com.alipay.apmobilesecuritysdk.p107e.C1454i.m4242e(r1)     // Catch:{ Exception -> 0x023d }
        java.lang.String r10 = com.alipay.p109b.p110a.p111a.p112a.C1460a.m4259a(r10, r0, r2)     // Catch:{ Exception -> 0x023d }
        boolean r0 = com.alipay.p109b.p110a.p111a.p112a.C1460a.m4263b(r10)     // Catch:{ Exception -> 0x023d }
        if (r0 == 0) goto L_0x019f
        java.lang.String r0 = com.alipay.apmobilesecuritysdk.p107e.C1454i.m4241e()     // Catch:{ Exception -> 0x023d }
        boolean r0 = com.alipay.p109b.p110a.p111a.p112a.C1460a.m4261a(r10, r0)     // Catch:{ Exception -> 0x023d }
        if (r0 != 0) goto L_0x019f
        com.alipay.apmobilesecuritysdk.p107e.C1454i.m4244f(r10)     // Catch:{ Exception -> 0x023d }
        goto L_0x01a3
    L_0x019f:
        java.lang.String r10 = com.alipay.apmobilesecuritysdk.p107e.C1454i.m4241e()     // Catch:{ Exception -> 0x023d }
    L_0x01a3:
        com.alipay.apmobilesecuritysdk.p107e.C1454i.m4244f(r10)     // Catch:{ Exception -> 0x023d }
        com.alipay.apmobilesecuritysdk.p107e.C1454i.m4230a()     // Catch:{ Exception -> 0x023d }
        com.alipay.apmobilesecuritysdk.e.c r10 = com.alipay.apmobilesecuritysdk.p107e.C1454i.m4245g()     // Catch:{ Exception -> 0x023d }
        android.content.Context r0 = r9.f3692a     // Catch:{ Exception -> 0x023d }
        com.alipay.apmobilesecuritysdk.p107e.C1449d.m4193a(r0, r10)     // Catch:{ Exception -> 0x023d }
        com.alipay.apmobilesecuritysdk.p107e.C1449d.m4191a()     // Catch:{ Exception -> 0x023d }
        android.content.Context r10 = r9.f3692a     // Catch:{ Exception -> 0x023d }
        com.alipay.apmobilesecuritysdk.e.b r0 = new com.alipay.apmobilesecuritysdk.e.b     // Catch:{ Exception -> 0x023d }
        java.lang.String r1 = com.alipay.apmobilesecuritysdk.p107e.C1454i.m4235b()     // Catch:{ Exception -> 0x023d }
        java.lang.String r2 = com.alipay.apmobilesecuritysdk.p107e.C1454i.m4237c()     // Catch:{ Exception -> 0x023d }
        java.lang.String r4 = com.alipay.apmobilesecuritysdk.p107e.C1454i.m4243f()     // Catch:{ Exception -> 0x023d }
        r0.m42064init(r1, r2, r4)     // Catch:{ Exception -> 0x023d }
        com.alipay.apmobilesecuritysdk.p107e.C1446a.m4186a(r10, r0)     // Catch:{ Exception -> 0x023d }
        com.alipay.apmobilesecuritysdk.p107e.C1446a.m4184a()     // Catch:{ Exception -> 0x023d }
        java.lang.String r10 = com.alipay.apmobilesecuritysdk.p107e.C1454i.m4229a(r3)     // Catch:{ Exception -> 0x023d }
        android.content.Context r0 = r9.f3692a     // Catch:{ Exception -> 0x023d }
        com.alipay.apmobilesecuritysdk.p107e.C1452g.m4211a(r0, r3, r10)     // Catch:{ Exception -> 0x023d }
        com.alipay.apmobilesecuritysdk.p107e.C1452g.m4209a()     // Catch:{ Exception -> 0x023d }
        android.content.Context r10 = r9.f3692a     // Catch:{ Exception -> 0x023d }
        long r0 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x023d }
        com.alipay.apmobilesecuritysdk.p107e.C1453h.m4214a(r10, r3, r0)     // Catch:{ Exception -> 0x023d }
        goto L_0x00d1
    L_0x01e5:
        r9.f3694c = r10     // Catch:{ Exception -> 0x023d }
        android.content.Context r10 = r9.f3692a     // Catch:{ Exception -> 0x023d }
        com.alipay.apmobilesecuritysdk.b.a r0 = r9.f3693b     // Catch:{ Exception -> 0x023d }
        java.lang.String r0 = r0.mo12006c()     // Catch:{ Exception -> 0x023d }
        com.alipay.b.a.a.e.b.a r10 = com.alipay.p109b.p110a.p111a.p117e.C1488d.m4385b(r10, r0)     // Catch:{ Exception -> 0x023d }
        android.content.Context r0 = r9.f3692a     // Catch:{ Exception -> 0x023d }
        r1 = 0
        java.lang.String r2 = "connectivity"
        java.lang.Object r2 = r0.getSystemService(r2)     // Catch:{ Exception -> 0x023d }
        android.net.ConnectivityManager r2 = (android.net.ConnectivityManager) r2     // Catch:{ Exception -> 0x023d }
        if (r2 == 0) goto L_0x0204
        android.net.NetworkInfo r1 = r2.getActiveNetworkInfo()     // Catch:{ Exception -> 0x023d }
    L_0x0204:
        if (r1 == 0) goto L_0x0213
        boolean r2 = r1.isConnected()     // Catch:{ Exception -> 0x023d }
        if (r2 == 0) goto L_0x0213
        int r1 = r1.getType()     // Catch:{ Exception -> 0x023d }
        if (r1 != r6) goto L_0x0213
        r5 = 1
    L_0x0213:
        if (r5 == 0) goto L_0x0241
        boolean r1 = com.alipay.apmobilesecuritysdk.p107e.C1453h.m4220c(r0)     // Catch:{ Exception -> 0x023d }
        if (r1 == 0) goto L_0x0241
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x023d }
        r1.<init>()     // Catch:{ Exception -> 0x023d }
        java.io.File r0 = r0.getFilesDir()     // Catch:{ Exception -> 0x023d }
        java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ Exception -> 0x023d }
        r1.append(r0)     // Catch:{ Exception -> 0x023d }
        java.lang.String r0 = "/log/ap"
        r1.append(r0)     // Catch:{ Exception -> 0x023d }
        java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x023d }
        com.alipay.b.a.a.c.b r1 = new com.alipay.b.a.a.c.b     // Catch:{ Exception -> 0x023d }
        r1.m42090init(r0, r10)     // Catch:{ Exception -> 0x023d }
        r1.mo12030a()     // Catch:{ Exception -> 0x023d }
        goto L_0x0241
    L_0x023d:
        r10 = move-exception
        com.alipay.apmobilesecuritysdk.p105c.C1438a.m4169a(r10)
    L_0x0241:
        int r10 = r9.f3694c
        return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.p103a.C1436a.mo12003a(java.util.Map):int");
    }
}
