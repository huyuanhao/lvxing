package com.ali.auth.third.p021b;

import com.ali.auth.third.core.config.C0990a;
import com.ali.auth.third.core.exception.SecRuntimeException;
import com.ali.auth.third.core.p024c.C0989a;
import com.ali.auth.third.core.p030h.C1014d;
import com.alibaba.wireless.security.open.C1355b;
import com.alibaba.wireless.security.open.SecException;

/* renamed from: com.ali.auth.third.b.a */
public class C0979a implements C1014d {
    /* renamed from: c */
    private C1355b m1857c() {
        try {
            return C1355b.m3996a(C0989a.f1891f);
        } catch (SecException e) {
            throw new SecRuntimeException(e.getErrorCode(), e);
        }
    }

    /* renamed from: a */
    public String mo10292a() {
        try {
            return m1857c().mo11877d().mo11906a();
        } catch (SecException e) {
            throw new SecRuntimeException(e.getErrorCode(), e);
        }
    }

    /* renamed from: a */
    public String mo10293a(String str) {
        try {
            return m1857c().mo11873a().mo11883a(str, 0);
        } catch (SecException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public String mo10294a(String str, boolean z) {
        if (!z) {
            return m1857c().mo11875b().mo11905a(str, C0990a.f1910i);
        }
        try {
            return m1857c().mo11873a().mo11882a(str);
        } catch (SecException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public void mo10295a(String str, String str2) {
        try {
            m1857c().mo11873a().mo11884a(str, str2, 0);
        } catch (SecException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo10296a(String str, String str2, boolean z) {
        try {
            m1857c().mo11873a().mo11881a(str, str2);
        } catch (SecException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public String mo10297b() {
        try {
            return m1857c().mo11875b().mo11904a(C0990a.m1890d(), C0990a.f1910i);
        } catch (SecException e) {
            throw new SecRuntimeException(e.getErrorCode(), e);
        }
    }

    /* renamed from: b */
    public void mo10298b(String str) {
        try {
            m1857c().mo11873a().mo11886b(str, 0);
        } catch (SecException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void mo10299b(String str, boolean z) {
        if (z) {
            try {
                m1857c().mo11873a().mo11885b(str);
            } catch (SecException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003c, code lost:
            return false;
     */
    /* renamed from: b */
    public synchronized boolean mo10300b(java.lang.String r7, java.lang.String r8) {
        /*
        r6 = this;
        monitor-enter(r6)
        boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x003d }
        r1 = 0
        if (r0 != 0) goto L_0x003b
        com.alibaba.wireless.security.open.b r0 = r6.m1857c()     // Catch:{ all -> 0x003d }
        if (r0 != 0) goto L_0x000f
        goto L_0x003b
    L_0x000f:
        com.alibaba.wireless.security.open.b r0 = r6.m1857c()     // Catch:{ SecException -> 0x0035, all -> 0x0030 }
        com.alibaba.wireless.security.open.j.a r0 = r0.mo11878e()     // Catch:{ SecException -> 0x0035, all -> 0x0030 }
        if (r0 == 0) goto L_0x002e
        java.lang.String r2 = ""
        java.lang.String r3 = ""
        java.lang.String r4 = ""
        java.lang.String r5 = ""
        java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4, r5}     // Catch:{ SecException -> 0x0035, all -> 0x0030 }
        int r3 = r2.length     // Catch:{ SecException -> 0x0035, all -> 0x0030 }
        r2 = r2[r1]     // Catch:{ SecException -> 0x0035, all -> 0x0030 }
        boolean r7 = r0.mo11894a(r7, r8, r2, r1)     // Catch:{ SecException -> 0x0035, all -> 0x0030 }
        monitor-exit(r6)
        return r7
    L_0x002e:
        monitor-exit(r6)
        return r1
    L_0x0030:
        r7 = move-exception
        r7.printStackTrace()     // Catch:{ all -> 0x003d }
        goto L_0x0039
    L_0x0035:
        r7 = move-exception
        r7.printStackTrace()     // Catch:{ all -> 0x003d }
    L_0x0039:
        monitor-exit(r6)
        return r1
    L_0x003b:
        monitor-exit(r6)
        return r1
    L_0x003d:
        r7 = move-exception
        monitor-exit(r6)
        throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.auth.third.p021b.C0979a.mo10300b(java.lang.String, java.lang.String):boolean");
    }
}
