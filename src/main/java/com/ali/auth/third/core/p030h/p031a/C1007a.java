package com.ali.auth.third.core.p030h.p031a;

import android.text.TextUtils;
import com.ali.auth.third.core.model.C1023d;
import com.ali.auth.third.core.model.C1030k;
import com.ali.auth.third.core.model.C1031l;
import com.ali.auth.third.core.p024c.C0989a;
import com.ali.auth.third.core.p028g.C1005b;
import com.ali.auth.third.core.p030h.C1006a;
import com.ali.auth.third.core.p030h.C1013c;
import com.ali.auth.third.core.p030h.C1014d;
import com.ali.auth.third.core.p033j.C1018a;
import com.ali.auth.third.core.util.C1039d;
import com.ali.auth.third.core.util.C1040e;
import com.ali.auth.third.core.util.C1042g;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import org.json.JSONObject;

/* renamed from: com.ali.auth.third.core.h.a.a */
public class C1007a implements C1006a {
    /* renamed from: b */
    public static final C1007a f1962b = new C1007a();
    /* renamed from: c */
    private static final String f1963c = C1007a.class.getSimpleName();
    /* renamed from: a */
    public String f1964a = "internal_session";
    /* renamed from: d */
    private volatile C1023d f1965d;

    public C1007a() {
        try {
            m1930d();
        } catch (Throwable unused) {
            this.f1965d = new C1023d();
            this.f1965d.f2001g = new C1031l();
        }
    }

    /* renamed from: a */
    private Object m1927a(String str, String[] strArr, Object[] objArr) {
        try {
            return C1040e.m2001a(str, strArr, objArr);
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private void m1928a(C1005b bVar) {
        boolean z;
        String str = "com.ali.auth.third.b.a";
        try {
            Class.forName(str);
            try {
                C0989a.f1886a = false;
                C0989a.f1890e = C0989a.f1889d;
            } catch (Throwable unused) {
            }
            z = true;
        } catch (Throwable unused2) {
            z = false;
        }
        if (!z) {
            str = "com.ali.auth.third.core.storage.CommonStorageServiceImpl";
        }
        try {
            bVar.mo10324a(new Class[]{C1014d.class}, m1927a(str, null, null), null);
            C0989a.f1892g = (C1014d) bVar.mo10325a(C1014d.class, null);
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m1929a(C1023d dVar) {
        this.f1965d = dVar;
        C0989a.f1892g.mo10296a(this.f1964a, C1042g.m2008a(dVar), true);
    }

    /* renamed from: d */
    private void m1930d() {
        if (C0989a.f1892g == null) {
            m1928a(C0989a.f1900o);
        }
        C1018a.m1964b(f1963c, "CredentialManager init step 1");
        String str = "loginEnvironmentIndex";
        String a = C0989a.f1892g.mo10294a(str, true);
        C1018a.m1964b(f1963c, "CredentialManager init step 2");
        String valueOf = String.valueOf(C0989a.m1885b().ordinal());
        if (a == null || a.equals(valueOf)) {
            C1018a.m1964b(f1963c, "CredentialManager init step 3");
            String a2 = C0989a.f1892g.mo10294a(this.f1964a, true);
            C1018a.m1964b(f1963c, "CredentialManager init step 4");
            if (TextUtils.isEmpty(a2)) {
                a2 = C0989a.f1892g.mo10294a(this.f1964a, true);
            }
            if (!TextUtils.isEmpty(a2)) {
                this.f1965d = mo10333a(a2);
            } else {
                this.f1965d = new C1023d();
                this.f1965d.f2001g = new C1031l();
            }
            C1018a.m1964b(f1963c, "CredentialManager init step 5");
            return;
        }
        C0989a.f1892g.mo10296a(str, valueOf, true);
        C0989a.f1892g.mo10299b(this.f1964a, true);
        this.f1965d = new C1023d();
        this.f1965d.f2001g = new C1031l();
    }

    /* renamed from: a */
    public long mo10332a(long j, long j2) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        return currentTimeMillis > j2 ? j > 0 ? j + (currentTimeMillis - j2) : 86400 + currentTimeMillis : j;
    }

    /* renamed from: a */
    public C1023d mo10333a(String str) {
        C1023d dVar = new C1023d();
        try {
            JSONObject jSONObject = new JSONObject(str);
            dVar.f1995a = C1039d.m1998b(jSONObject, "sid");
            dVar.f1996b = (long) C1039d.m1989a(jSONObject, "expireIn").intValue();
            C1031l lVar = new C1031l();
            JSONObject optJSONObject = jSONObject.optJSONObject("user");
            if (optJSONObject != null) {
                lVar.f2072f = optJSONObject.optString("avatarUrl");
                lVar.f2067a = optJSONObject.optString("userId");
                lVar.f2068b = optJSONObject.optString("nick");
                lVar.f2075i = optJSONObject.optString("openId");
                lVar.f2076j = optJSONObject.optString("openSid");
                lVar.f2073g = optJSONObject.optString("deviceTokenKey");
                lVar.f2074h = optJSONObject.optString("deviceTokenSalt");
                if (!TextUtils.isEmpty(dVar.f1995a) && !TextUtils.isEmpty(lVar.f2067a)) {
                    ((C1013c) C0989a.m1882a(C1013c.class)).mo10355a(dVar.f1995a, lVar.f2067a);
                }
            }
            dVar.f2001g = lVar;
            dVar.f1997c = C1039d.m1999c(jSONObject, "loginTime").longValue();
            dVar.f1998d = C1039d.m1998b(jSONObject, ArgKey.KEY_MOBILE);
            dVar.f1999e = C1039d.m1998b(jSONObject, "loginId");
            dVar.f2000f = C1039d.m1998b(jSONObject, "autoLoginToken");
            dVar.f2002h = C1039d.m1998b(jSONObject, "topAccessToken");
            dVar.f2004j = C1039d.m1998b(jSONObject, "topExpireTime");
            dVar.f2003i = C1039d.m1998b(jSONObject, "topAuthCode");
            dVar.f2007m = C1039d.m1993a(jSONObject.optJSONObject("otherInfo"));
            dVar.f2005k = C1039d.m1998b(jSONObject, "ssoToken");
            dVar.f2006l = C1039d.m1998b(jSONObject, "havanaSsoToken");
        } catch (Exception e) {
            C1018a.m1960a(f1963c, e.getMessage(), (Throwable) e);
        }
        return dVar;
    }

    /* renamed from: a */
    public C1030k mo10329a() {
        C1030k kVar = new C1030k();
        String str = "";
        String str2 = (this.f1965d == null || this.f1965d.f2001g == null) ? str : this.f1965d.f2001g.f2067a;
        kVar.f2057a = str2;
        String str3 = (this.f1965d == null || this.f1965d.f2001g == null) ? str : this.f1965d.f2001g.f2068b;
        kVar.f2058b = str3;
        String str4 = (this.f1965d == null || this.f1965d.f2001g == null) ? str : this.f1965d.f2001g.f2072f;
        kVar.f2059c = str4;
        String str5 = (this.f1965d == null || this.f1965d.f2001g == null) ? str : this.f1965d.f2001g.f2075i;
        kVar.f2060d = str5;
        String str6 = (this.f1965d == null || this.f1965d.f2001g == null) ? str : this.f1965d.f2001g.f2076j;
        kVar.f2061e = str6;
        kVar.f2062f = this.f1965d == null ? str : this.f1965d.f2002h;
        kVar.f2063g = this.f1965d == null ? str : this.f1965d.f2003i;
        kVar.f2064h = this.f1965d == null ? str : this.f1965d.f2004j;
        kVar.f2065i = this.f1965d == null ? str : this.f1965d.f2005k;
        if (this.f1965d != null) {
            str = this.f1965d.f2006l;
        }
        kVar.f2066j = str;
        return kVar;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:5|6|(2:8|9)|13|(2:17|18)|19|20|(1:22)|23|24|25|26|(2:30|31)|35) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x008d */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0091 A[Catch:{ Exception -> 0x0124 }] */
    /* renamed from: a */
    public void mo10330a(com.ali.auth.third.core.model.C1025f r11) {
        /*
        r10 = this;
        java.lang.String r0 = "1688ext"
        if (r11 == 0) goto L_0x0141
        java.lang.String r1 = r11.f2031c
        boolean r1 = android.text.TextUtils.isEmpty(r1)
        if (r1 == 0) goto L_0x000e
        goto L_0x0141
    L_0x000e:
        long r1 = java.lang.System.currentTimeMillis()
        com.ali.auth.third.core.model.C1020a.f1987b = r1
        com.ali.auth.third.core.model.d r1 = new com.ali.auth.third.core.model.d
        r1.m41173init()
        org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0124 }
        java.lang.String r3 = r11.f2031c     // Catch:{ Exception -> 0x0124 }
        r2.<init>(r3)     // Catch:{ Exception -> 0x0124 }
        java.lang.Class<com.ali.auth.third.core.model.e> r3 = com.ali.auth.third.core.model.C1024e.class
        java.lang.Object r2 = com.ali.auth.third.core.util.C1039d.m1990a(r2, r3)     // Catch:{ Exception -> 0x0124 }
        com.ali.auth.third.core.model.e r2 = (com.ali.auth.third.core.model.C1024e) r2     // Catch:{ Exception -> 0x0124 }
        java.lang.String[] r3 = r2.f2027s     // Catch:{ Exception -> 0x0124 }
        r1.f2008n = r3     // Catch:{ Exception -> 0x0124 }
        com.ali.auth.third.core.model.l r3 = new com.ali.auth.third.core.model.l     // Catch:{ Exception -> 0x0124 }
        r3.m41181init()     // Catch:{ Exception -> 0x0124 }
        java.lang.String r4 = r2.f2023o     // Catch:{ Exception -> 0x0124 }
        r3.f2067a = r4     // Catch:{ Exception -> 0x0124 }
        java.lang.String r4 = r2.f2018j     // Catch:{ Exception -> 0x0124 }
        if (r4 == 0) goto L_0x004e
        java.lang.String r4 = r2.f2018j     // Catch:{ Exception -> 0x0044 }
        java.lang.String r5 = "UTF-8"
        java.lang.String r4 = java.net.URLDecoder.decode(r4, r5)     // Catch:{ Exception -> 0x0044 }
        r3.f2068b = r4     // Catch:{ Exception -> 0x0044 }
        goto L_0x004e
    L_0x0044:
        r4 = move-exception
        java.lang.String r5 = f1963c     // Catch:{ Exception -> 0x0124 }
        java.lang.String r6 = r4.getMessage()     // Catch:{ Exception -> 0x0124 }
        com.ali.auth.third.core.p033j.C1018a.m1960a(r5, r6, r4)     // Catch:{ Exception -> 0x0124 }
    L_0x004e:
        java.lang.String r4 = r2.f2024p     // Catch:{ Exception -> 0x0124 }
        r3.f2075i = r4     // Catch:{ Exception -> 0x0124 }
        java.lang.String r4 = r2.f2025q     // Catch:{ Exception -> 0x0124 }
        r3.f2076j = r4     // Catch:{ Exception -> 0x0124 }
        java.lang.String r4 = r2.f2021m     // Catch:{ Exception -> 0x0124 }
        r3.f2072f = r4     // Catch:{ Exception -> 0x0124 }
        java.lang.String r4 = r2.f2022n     // Catch:{ Exception -> 0x0124 }
        r3.f2069c = r4     // Catch:{ Exception -> 0x0124 }
        java.util.Map<java.lang.String, java.lang.String> r4 = r2.f2020l     // Catch:{ Exception -> 0x0124 }
        if (r4 == 0) goto L_0x008d
        java.util.Map<java.lang.String, java.lang.String> r4 = r2.f2020l     // Catch:{ Exception -> 0x0124 }
        java.lang.Object r4 = r4.get(r0)     // Catch:{ Exception -> 0x0124 }
        java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x0124 }
        boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0124 }
        if (r4 != 0) goto L_0x008d
        org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x008d }
        java.util.Map<java.lang.String, java.lang.String> r5 = r2.f2020l     // Catch:{ Exception -> 0x008d }
        java.lang.Object r0 = r5.get(r0)     // Catch:{ Exception -> 0x008d }
        java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x008d }
        r4.<init>(r0)     // Catch:{ Exception -> 0x008d }
        java.lang.String r0 = "loginId"
        java.lang.String r0 = r4.optString(r0)     // Catch:{ Exception -> 0x008d }
        r3.f2070d = r0     // Catch:{ Exception -> 0x008d }
        java.lang.String r0 = "memberId"
        java.lang.String r0 = r4.optString(r0)     // Catch:{ Exception -> 0x008d }
        r3.f2071e = r0     // Catch:{ Exception -> 0x008d }
    L_0x008d:
        com.ali.auth.third.core.model.b r0 = r11.f2035g     // Catch:{ Exception -> 0x0124 }
        if (r0 == 0) goto L_0x009d
        com.ali.auth.third.core.model.b r0 = r11.f2035g     // Catch:{ Exception -> 0x0124 }
        java.lang.String r0 = r0.f1989b     // Catch:{ Exception -> 0x0124 }
        r3.f2074h = r0     // Catch:{ Exception -> 0x0124 }
        com.ali.auth.third.core.model.b r0 = r11.f2035g     // Catch:{ Exception -> 0x0124 }
        java.lang.String r0 = r0.f1988a     // Catch:{ Exception -> 0x0124 }
        r3.f2073g = r0     // Catch:{ Exception -> 0x0124 }
    L_0x009d:
        com.ali.auth.third.core.model.c r0 = new com.ali.auth.third.core.model.c     // Catch:{ Exception -> 0x0124 }
        java.lang.String r5 = r2.f2023o     // Catch:{ Exception -> 0x0124 }
        java.lang.String r6 = r3.f2073g     // Catch:{ Exception -> 0x0124 }
        java.lang.String r7 = r2.f2018j     // Catch:{ Exception -> 0x0124 }
        java.lang.String r8 = r2.f2010b     // Catch:{ Exception -> 0x0124 }
        java.lang.String r9 = r2.f2022n     // Catch:{ Exception -> 0x0124 }
        r4 = r0
        r4.m41172init(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0124 }
        com.ali.auth.third.core.e.a r4 = com.ali.auth.third.core.p026e.C0998a.m1908a()     // Catch:{ Exception -> 0x0124 }
        java.lang.String r5 = r3.f2074h     // Catch:{ Exception -> 0x0124 }
        r4.mo10318a(r0, r5)     // Catch:{ Exception -> 0x0124 }
        r1.f2001g = r3     // Catch:{ Exception -> 0x0124 }
        long r3 = r2.f2012d     // Catch:{ Exception -> 0x0124 }
        r1.f1997c = r3     // Catch:{ Exception -> 0x0124 }
        java.lang.String r0 = r2.f2009a     // Catch:{ Exception -> 0x0124 }
        r1.f1995a = r0     // Catch:{ Exception -> 0x0124 }
        long r3 = r2.f2017i     // Catch:{ Exception -> 0x0124 }
        long r5 = r2.f2012d     // Catch:{ Exception -> 0x0124 }
        long r3 = r10.mo10332a(r3, r5)     // Catch:{ Exception -> 0x0124 }
        r1.f1996b = r3     // Catch:{ Exception -> 0x0124 }
        java.lang.String r0 = r2.f2011c     // Catch:{ Exception -> 0x0124 }
        r1.f1998d = r0     // Catch:{ Exception -> 0x0124 }
        java.lang.String r0 = r11.f2034f     // Catch:{ Exception -> 0x0124 }
        r1.f1999e = r0     // Catch:{ Exception -> 0x0124 }
        java.lang.String r0 = r2.f2013e     // Catch:{ Exception -> 0x0124 }
        r1.f2000f = r0     // Catch:{ Exception -> 0x0124 }
        java.lang.String r0 = r2.f2014f     // Catch:{ Exception -> 0x0124 }
        r1.f2002h = r0     // Catch:{ Exception -> 0x0124 }
        java.lang.String r0 = r2.f2016h     // Catch:{ Exception -> 0x0124 }
        r1.f2003i = r0     // Catch:{ Exception -> 0x0124 }
        java.lang.String r0 = r2.f2015g     // Catch:{ Exception -> 0x0124 }
        r1.f2004j = r0     // Catch:{ Exception -> 0x0124 }
        java.util.Map<java.lang.String, java.lang.Object> r0 = r2.f2019k     // Catch:{ Exception -> 0x0124 }
        r1.f2007m = r0     // Catch:{ Exception -> 0x0124 }
        java.lang.String r11 = r11.f2036h     // Catch:{ Exception -> 0x0124 }
        r1.f2005k = r11     // Catch:{ Exception -> 0x0124 }
        java.lang.String r11 = r2.f2028t     // Catch:{ Exception -> 0x0124 }
        r1.f2006l = r11     // Catch:{ Exception -> 0x0124 }
        java.lang.Class<com.ali.auth.third.core.h.c> r11 = com.ali.auth.third.core.p030h.C1013c.class
        java.lang.Object r11 = com.ali.auth.third.core.p024c.C0989a.m1882a(r11)     // Catch:{ Exception -> 0x0124 }
        com.ali.auth.third.core.h.c r11 = (com.ali.auth.third.core.p030h.C1013c) r11     // Catch:{ Exception -> 0x0124 }
        java.lang.String r0 = r2.f2009a     // Catch:{ Exception -> 0x0124 }
        java.lang.String r3 = r2.f2023o     // Catch:{ Exception -> 0x0124 }
        r11.mo10355a(r0, r3)     // Catch:{ Exception -> 0x0124 }
        r11 = 0
        java.util.Map<java.lang.String, java.lang.Object> r0 = r2.f2019k     // Catch:{ Exception -> 0x0119 }
        java.lang.String r3 = "ssoDomainList"
        java.lang.Object r0 = r0.get(r3)     // Catch:{ Exception -> 0x0119 }
        if (r0 == 0) goto L_0x011d
        boolean r3 = r0 instanceof java.util.ArrayList     // Catch:{ Exception -> 0x0119 }
        if (r3 == 0) goto L_0x011d
        java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch:{ Exception -> 0x0119 }
        r3 = 0
        java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ Exception -> 0x0119 }
        java.lang.Object[] r0 = r0.toArray(r3)     // Catch:{ Exception -> 0x0119 }
        java.lang.String[] r0 = (java.lang.String[]) r0     // Catch:{ Exception -> 0x0119 }
        r11 = r0
        goto L_0x011d
    L_0x0119:
        r0 = move-exception
        r0.printStackTrace()     // Catch:{ Exception -> 0x0124 }
    L_0x011d:
        com.ali.auth.third.core.d.a r0 = com.ali.auth.third.core.p025d.C0992a.f1924a     // Catch:{ Exception -> 0x0124 }
        java.lang.String[] r2 = r2.f2026r     // Catch:{ Exception -> 0x0124 }
        r0.mo10315a(r2, r11)     // Catch:{ Exception -> 0x0124 }
    L_0x0124:
        java.lang.StringBuilder r11 = new java.lang.StringBuilder
        r11.<init>()
        java.lang.String r0 = "session = "
        r11.append(r0)
        java.lang.String r0 = r1.toString()
        r11.append(r0)
        java.lang.String r11 = r11.toString()
        java.lang.String r0 = "session"
        com.ali.auth.third.core.p033j.C1018a.m1967d(r0, r11)
        r10.m1929a(r1)
    L_0x0141:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.auth.third.core.p030h.p031a.C1007a.mo10330a(com.ali.auth.third.core.model.f):void");
    }

    /* renamed from: b */
    public boolean mo10331b() {
        String str;
        String str2;
        C1018a.m1964b(f1963c, "func isSessionValid");
        boolean z = false;
        if (this.f1965d == null) {
            str = f1963c;
            str2 = "isSessionValid()  internalSession is null";
        } else if (this.f1965d.f1997c == 0 || this.f1965d.f1996b == 0) {
            str = f1963c;
            str2 = "isSessionValid()  loginTime is 0 or expireIn is 0";
        } else {
            String str3 = f1963c;
            StringBuilder sb = new StringBuilder();
            sb.append("isSessionValid()  ");
            sb.append(System.currentTimeMillis() / 1000 < this.f1965d.f1996b);
            C1018a.m1964b(str3, sb.toString());
            if (System.currentTimeMillis() / 1000 < this.f1965d.f1996b) {
                z = true;
            }
            return z;
        }
        C1018a.m1964b(str, str2);
        return false;
    }

    /* renamed from: c */
    public C1023d mo10334c() {
        return this.f1965d;
    }
}
