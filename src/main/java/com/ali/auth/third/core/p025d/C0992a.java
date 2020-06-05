package com.ali.auth.third.core.p025d;

import android.text.TextUtils;
import com.ali.auth.third.core.p024c.C0989a;
import com.ali.auth.third.core.p033j.C1018a;
import com.ali.auth.third.core.util.C1037b;
import java.util.ArrayList;

/* renamed from: com.ali.auth.third.core.d.a */
public class C0992a {
    /* renamed from: a */
    public static final C0992a f1924a = new C0992a();
    /* renamed from: b */
    private static final String f1925b = C0992a.class.getSimpleName();
    /* renamed from: c */
    private String[] f1926c;

    private C0992a() {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:1|2|(3:4|5|(1:7))|8|9|(1:11)|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0033 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0037  */
    /* renamed from: a */
    public synchronized void mo10314a() {
        /*
        r4 = this;
        monitor-enter(r4)
        java.lang.String[] r0 = r4.f1926c     // Catch:{ all -> 0x003f }
        if (r0 != 0) goto L_0x0033
        android.content.Context r0 = com.ali.auth.third.core.p024c.C0989a.m1887c()     // Catch:{ all -> 0x0033 }
        java.lang.String r1 = "cookies"
        java.lang.String r0 = com.ali.auth.third.core.util.C1037b.m1986a(r0, r1)     // Catch:{ all -> 0x0033 }
        boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0033 }
        if (r1 != 0) goto L_0x0033
        java.lang.String r1 = f1925b     // Catch:{ all -> 0x0033 }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0033 }
        r2.<init>()     // Catch:{ all -> 0x0033 }
        java.lang.String r3 = "get cookie from storage:"
        r2.append(r3)     // Catch:{ all -> 0x0033 }
        r2.append(r0)     // Catch:{ all -> 0x0033 }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0033 }
        com.ali.auth.third.core.p033j.C1018a.m1964b(r1, r2)     // Catch:{ all -> 0x0033 }
        java.lang.String r1 = "\u0005"
        java.lang.String[] r0 = android.text.TextUtils.split(r0, r1)     // Catch:{ all -> 0x0033 }
        r4.f1926c = r0     // Catch:{ all -> 0x0033 }
    L_0x0033:
        java.lang.String[] r0 = r4.f1926c     // Catch:{ all -> 0x003f }
        if (r0 == 0) goto L_0x003d
        java.lang.String[] r0 = r4.f1926c     // Catch:{ all -> 0x003f }
        r1 = 0
        r4.mo10315a(r0, r1)     // Catch:{ all -> 0x003f }
    L_0x003d:
        monitor-exit(r4)
        return
    L_0x003f:
        r0 = move-exception
        monitor-exit(r4)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.auth.third.core.p025d.C0992a.mo10314a():void");
    }

    /* renamed from: a */
    public synchronized void mo10315a(String[] strArr, String[] strArr2) {
        this.f1926c = strArr;
        if (C0989a.f1891f != null) {
            if (strArr != null) {
                C1018a.m1964b(f1925b, "injectCookie cookies != null");
                ArrayList<C0997e> arrayList = new ArrayList<>();
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            C0997e a = C0993b.m1897a(str);
                            String b = C0993b.m1899b(a);
                            String eVar = a.toString();
                            String str2 = f1925b;
                            StringBuilder sb = new StringBuilder();
                            sb.append("add cookie: ");
                            sb.append(eVar);
                            C1018a.m1964b(str2, sb.toString());
                            C0994c.m1902a().mo10303a(b, eVar);
                            if (TextUtils.equals(a.f1934a, ".taobao.com")) {
                                arrayList.add(a);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
                if (strArr2 != null && strArr2.length > 0 && !arrayList.isEmpty()) {
                    for (C0997e eVar2 : arrayList) {
                        String str3 = eVar2.f1934a;
                        for (String str4 : strArr2) {
                            eVar2.f1934a = str4;
                            String b2 = C0993b.m1899b(eVar2);
                            String eVar3 = eVar2.toString();
                            String str5 = f1925b;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("add cookies to domain:");
                            sb2.append(str4);
                            sb2.append(", cookie = ");
                            sb2.append(eVar3);
                            C1018a.m1964b(str5, sb2.toString());
                            C0994c.m1902a().mo10303a(b2, eVar3);
                        }
                        eVar2.f1934a = str3;
                    }
                }
                C0994c.m1902a().mo10302a();
                if (this.f1926c != null) {
                    C1037b.m1987a(C0989a.f1891f, "cookies", TextUtils.join("\u0005", strArr));
                }
            } else {
                mo10316b();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00dc  */
    /* renamed from: b */
    public void mo10316b() {
        /*
        r14 = this;
        java.lang.String r0 = "clearCookies"
        java.lang.String r1 = "into clearCookies "
        com.ali.auth.third.core.p033j.C1018a.m1967d(r0, r1)
        android.content.Context r1 = com.ali.auth.third.core.p024c.C0989a.m1887c()
        android.webkit.CookieSyncManager.createInstance(r1)
        java.lang.String r1 = "into clearCookies removeSessionCookie finish"
        com.ali.auth.third.core.p033j.C1018a.m1967d(r0, r1)
        java.lang.String[] r1 = r14.f1926c
        java.lang.String r2 = "cookies"
        if (r1 != 0) goto L_0x0045
        android.content.Context r1 = com.ali.auth.third.core.p024c.C0989a.m1887c()
        java.lang.String r1 = com.ali.auth.third.core.util.C1037b.m1986a(r1, r2)
        boolean r3 = android.text.TextUtils.isEmpty(r1)
        if (r3 != 0) goto L_0x0045
        java.lang.String r3 = f1925b
        java.lang.StringBuilder r4 = new java.lang.StringBuilder
        r4.<init>()
        java.lang.String r5 = "get cookie from storage:"
        r4.append(r5)
        r4.append(r1)
        java.lang.String r4 = r4.toString()
        com.ali.auth.third.core.p033j.C1018a.m1964b(r3, r4)
        java.lang.String r3 = "\u0005"
        java.lang.String[] r1 = android.text.TextUtils.split(r1, r3)
        r14.f1926c = r1
    L_0x0045:
        java.lang.String r1 = "into clearCookies readFileData finish"
        com.ali.auth.third.core.p033j.C1018a.m1967d(r0, r1)
        java.lang.String[] r1 = r14.f1926c
        if (r1 == 0) goto L_0x011f
        java.util.ArrayList r1 = new java.util.ArrayList
        r1.<init>()
        java.lang.String[] r3 = r14.f1926c
        int r4 = r3.length
        r5 = 0
        r6 = 0
    L_0x0058:
        java.lang.String r7 = "munb"
        if (r6 >= r4) goto L_0x0098
        r8 = r3[r6]
        boolean r9 = android.text.TextUtils.isEmpty(r8)
        if (r9 != 0) goto L_0x0095
        com.ali.auth.third.core.d.e r8 = com.ali.auth.third.core.p025d.C0993b.m1897a(r8)     // Catch:{ all -> 0x0091 }
        java.lang.String r9 = r8.f1936c     // Catch:{ all -> 0x0091 }
        boolean r7 = r7.equals(r9)     // Catch:{ all -> 0x0091 }
        if (r7 == 0) goto L_0x0071
        goto L_0x0095
    L_0x0071:
        java.lang.String r7 = com.ali.auth.third.core.p025d.C0993b.m1899b(r8)     // Catch:{ all -> 0x0091 }
        com.ali.auth.third.core.p025d.C0993b.m1898a(r8)     // Catch:{ all -> 0x0091 }
        com.ali.auth.third.core.b r9 = com.ali.auth.third.core.p025d.C0994c.m1902a()     // Catch:{ all -> 0x0091 }
        java.lang.String r10 = r8.toString()     // Catch:{ all -> 0x0091 }
        r9.mo10303a(r7, r10)     // Catch:{ all -> 0x0091 }
        java.lang.String r7 = r8.f1934a     // Catch:{ all -> 0x0091 }
        java.lang.String r9 = ".taobao.com"
        boolean r7 = android.text.TextUtils.equals(r7, r9)     // Catch:{ all -> 0x0091 }
        if (r7 == 0) goto L_0x0095
        r1.add(r8)     // Catch:{ all -> 0x0091 }
        goto L_0x0095
    L_0x0091:
        r7 = move-exception
        r7.printStackTrace()
    L_0x0095:
        int r6 = r6 + 1
        goto L_0x0058
    L_0x0098:
        r3 = 0
        com.ali.auth.third.core.h.a.a r4 = com.ali.auth.third.core.p030h.p031a.C1007a.f1962b     // Catch:{ Exception -> 0x00c2 }
        com.ali.auth.third.core.model.d r4 = r4.mo10334c()     // Catch:{ Exception -> 0x00c2 }
        java.util.Map<java.lang.String, java.lang.Object> r4 = r4.f2007m     // Catch:{ Exception -> 0x00c2 }
        if (r4 == 0) goto L_0x00c6
        com.ali.auth.third.core.h.a.a r4 = com.ali.auth.third.core.p030h.p031a.C1007a.f1962b     // Catch:{ Exception -> 0x00c2 }
        com.ali.auth.third.core.model.d r4 = r4.mo10334c()     // Catch:{ Exception -> 0x00c2 }
        java.util.Map<java.lang.String, java.lang.Object> r4 = r4.f2007m     // Catch:{ Exception -> 0x00c2 }
        java.lang.String r6 = "ssoDomainList"
        java.lang.Object r4 = r4.get(r6)     // Catch:{ Exception -> 0x00c2 }
        if (r4 == 0) goto L_0x00c6
        boolean r6 = r4 instanceof java.util.ArrayList     // Catch:{ Exception -> 0x00c2 }
        if (r6 == 0) goto L_0x00c6
        java.util.ArrayList r4 = (java.util.ArrayList) r4     // Catch:{ Exception -> 0x00c2 }
        java.lang.String[] r6 = new java.lang.String[r5]     // Catch:{ Exception -> 0x00c2 }
        java.lang.Object[] r4 = r4.toArray(r6)     // Catch:{ Exception -> 0x00c2 }
        java.lang.String[] r4 = (java.lang.String[]) r4     // Catch:{ Exception -> 0x00c2 }
        goto L_0x00c7
    L_0x00c2:
        r4 = move-exception
        r4.printStackTrace()
    L_0x00c6:
        r4 = r3
    L_0x00c7:
        if (r4 == 0) goto L_0x010d
        int r6 = r4.length
        if (r6 <= 0) goto L_0x010d
        boolean r6 = r1.isEmpty()
        if (r6 != 0) goto L_0x010d
        java.util.Iterator r1 = r1.iterator()
    L_0x00d6:
        boolean r6 = r1.hasNext()
        if (r6 == 0) goto L_0x010d
        java.lang.Object r6 = r1.next()
        com.ali.auth.third.core.d.e r6 = (com.ali.auth.third.core.p025d.C0997e) r6
        java.lang.String r8 = r6.f1934a
        int r9 = r4.length
        r10 = 0
    L_0x00e6:
        if (r10 >= r9) goto L_0x010a
        r11 = r4[r10]
        java.lang.String r12 = r6.f1936c
        boolean r12 = r7.equals(r12)
        if (r12 == 0) goto L_0x00f3
        goto L_0x0107
    L_0x00f3:
        r6.f1934a = r11
        java.lang.String r11 = com.ali.auth.third.core.p025d.C0993b.m1899b(r6)
        com.ali.auth.third.core.p025d.C0993b.m1898a(r6)
        com.ali.auth.third.core.b r12 = com.ali.auth.third.core.p025d.C0994c.m1902a()
        java.lang.String r13 = r6.toString()
        r12.mo10303a(r11, r13)
    L_0x0107:
        int r10 = r10 + 1
        goto L_0x00e6
    L_0x010a:
        r6.f1934a = r8
        goto L_0x00d6
    L_0x010d:
        java.lang.String r1 = f1925b
        java.lang.String r4 = "injectCookie cookies is null"
        com.ali.auth.third.core.p033j.C1018a.m1964b(r1, r4)
        r14.f1926c = r3
        android.content.Context r1 = com.ali.auth.third.core.p024c.C0989a.m1887c()
        java.lang.String r3 = ""
        com.ali.auth.third.core.util.C1037b.m1987a(r1, r2, r3)
    L_0x011f:
        java.lang.String r1 = "into clearCookies reset cookie finish"
        com.ali.auth.third.core.p033j.C1018a.m1967d(r0, r1)
        com.ali.auth.third.core.b r1 = com.ali.auth.third.core.p025d.C0994c.m1902a()
        r1.mo10304b()
        java.lang.String r1 = "into clearCookies removeExpiredCookie finish"
        com.ali.auth.third.core.p033j.C1018a.m1967d(r0, r1)
        com.ali.auth.third.core.b r1 = com.ali.auth.third.core.p025d.C0994c.m1902a()
        r1.mo10302a()
        java.lang.String r1 = "into clearCookies  finish"
        com.ali.auth.third.core.p033j.C1018a.m1967d(r0, r1)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.auth.third.core.p025d.C0992a.mo10316b():void");
    }
}
