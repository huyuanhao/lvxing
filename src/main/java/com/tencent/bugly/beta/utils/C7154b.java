package com.tencent.bugly.beta.utils;

import android.util.Log;
import java.io.IOException;
import java.util.HashMap;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.utils.b */
public class C7154b {
    /* renamed from: a */
    private String f23858a = null;
    /* renamed from: b */
    private C7153a f23859b = null;
    /* renamed from: c */
    private long f23860c = 0;
    /* renamed from: d */
    private long f23861d = 0;
    /* renamed from: e */
    private String f23862e = null;
    /* renamed from: f */
    private final HashMap<Long, String> f23863f = new HashMap<>();

    public C7154b(String str, long j, long j2) {
        this.f23863f.put(Long.valueOf(1), "armeabi-v4");
        this.f23863f.put(Long.valueOf(2), "armeabi-v4t");
        this.f23863f.put(Long.valueOf(3), "armeabi-v5t");
        this.f23863f.put(Long.valueOf(4), "armeabi-v5te");
        this.f23863f.put(Long.valueOf(5), "armeabi-v5tej");
        this.f23863f.put(Long.valueOf(6), "armeabi-v6");
        this.f23863f.put(Long.valueOf(7), "armeabi-v6kz");
        this.f23863f.put(Long.valueOf(8), "armeabi-v6t2");
        this.f23863f.put(Long.valueOf(9), "armeabi-v6k");
        this.f23863f.put(Long.valueOf(10), "armeabi-v7a");
        this.f23863f.put(Long.valueOf(11), "armeabi-v6-m");
        this.f23863f.put(Long.valueOf(12), "armeabi-v6s-m");
        this.f23863f.put(Long.valueOf(13), "armeabi-v7e-m");
        this.f23863f.put(Long.valueOf(14), "armeabi-v8a");
        this.f23858a = str;
        this.f23860c = j;
        this.f23861d = j2;
    }

    /* renamed from: a */
    private boolean m30627a() {
        return 0 != this.f23861d;
    }

    /* renamed from: b */
    private synchronized void m30629b() {
        if (this.f23859b != null) {
            if (this.f23859b.mo34477a()) {
                this.f23859b = null;
            }
        }
    }

    /* renamed from: c */
    private synchronized boolean m30630c() {
        if (!m30627a()) {
            return false;
        }
        if (this.f23859b != null) {
            m30629b();
        }
        try {
            this.f23859b = new C7153a(this.f23858a, this.f23860c);
            if (!this.f23859b.mo34480b(this.f23861d)) {
                return false;
            }
            return true;
        } catch (Exception e) {
            Log.e("ElfArmAttrParser", e.getMessage());
            return false;
        }
    }

    /* renamed from: d */
    private synchronized String m30631d() {
        StringBuilder sb;
        sb = new StringBuilder();
        while (true) {
            try {
                char b = (char) this.f23859b.mo34479b();
                if (b != 0) {
                    sb.append(b);
                }
            } catch (IOException e) {
                Log.e("ElfArmAttrParser", e.getMessage());
                return null;
            }
        }
        return sb.toString();
    }

    /* renamed from: e */
    private String m30632e() {
        return m30631d();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            r0 = m30631d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0051, code lost:
            if (r0 == null) goto L_0x0001;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0053, code lost:
            r5 = r5 - ((long) r0.length());
     */
    /* renamed from: a */
    private synchronized boolean m30628a(long r5) {
        /*
        r4 = this;
        monitor-enter(r4)
    L_0x0001:
        r0 = 0
        r2 = 0
        int r3 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
        if (r3 <= 0) goto L_0x0070
        com.tencent.bugly.beta.utils.a r0 = r4.f23859b     // Catch:{ IOException -> 0x0062 }
        long r0 = m30625a(r0)     // Catch:{ IOException -> 0x0062 }
        int r1 = (int) r0     // Catch:{ IOException -> 0x0062 }
        r0 = 34
        if (r1 == r0) goto L_0x005a
        r0 = 36
        if (r1 == r0) goto L_0x005a
        r0 = 38
        if (r1 == r0) goto L_0x005a
        r0 = 42
        if (r1 == r0) goto L_0x005a
        r0 = 44
        if (r1 == r0) goto L_0x005a
        r0 = 70
        if (r1 == r0) goto L_0x005a
        switch(r1) {
            case 4: goto L_0x004d;
            case 5: goto L_0x004d;
            case 6: goto L_0x0036;
            case 7: goto L_0x005a;
            case 8: goto L_0x005a;
            case 9: goto L_0x005a;
            case 10: goto L_0x005a;
            case 11: goto L_0x005a;
            case 12: goto L_0x005a;
            case 13: goto L_0x005a;
            case 14: goto L_0x005a;
            case 15: goto L_0x005a;
            case 16: goto L_0x005a;
            case 17: goto L_0x005a;
            case 18: goto L_0x005a;
            case 19: goto L_0x005a;
            case 20: goto L_0x005a;
            case 21: goto L_0x005a;
            case 22: goto L_0x005a;
            case 23: goto L_0x005a;
            case 24: goto L_0x005a;
            case 25: goto L_0x005a;
            case 26: goto L_0x005a;
            case 27: goto L_0x005a;
            case 28: goto L_0x005a;
            case 29: goto L_0x005a;
            case 30: goto L_0x005a;
            case 31: goto L_0x005a;
            case 32: goto L_0x004d;
            default: goto L_0x002a;
        }     // Catch:{ IOException -> 0x0062 }
    L_0x002a:
        switch(r1) {
            case 64: goto L_0x005a;
            case 65: goto L_0x004d;
            case 66: goto L_0x005a;
            case 67: goto L_0x004d;
            case 68: goto L_0x005a;
            default: goto L_0x002d;
        }     // Catch:{ IOException -> 0x0062 }
    L_0x002d:
        java.lang.String r5 = "ElfArmAttrParser"
        java.lang.String r6 = "Unimplemented tag."
        android.util.Log.e(r5, r6)     // Catch:{ IOException -> 0x0062 }
        monitor-exit(r4)
        return r2
    L_0x0036:
        com.tencent.bugly.beta.utils.a r5 = r4.f23859b     // Catch:{ IOException -> 0x0062 }
        long r5 = m30625a(r5)     // Catch:{ IOException -> 0x0062 }
        java.util.HashMap<java.lang.Long, java.lang.String> r0 = r4.f23863f     // Catch:{ IOException -> 0x0062 }
        java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ IOException -> 0x0062 }
        java.lang.Object r5 = r0.get(r5)     // Catch:{ IOException -> 0x0062 }
        java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x0062 }
        r4.f23862e = r5     // Catch:{ IOException -> 0x0062 }
        r5 = 1
        monitor-exit(r4)
        return r5
    L_0x004d:
        java.lang.String r0 = r4.m30631d()     // Catch:{ IOException -> 0x0062 }
        if (r0 == 0) goto L_0x0001
        int r0 = r0.length()     // Catch:{ IOException -> 0x0062 }
        long r0 = (long) r0     // Catch:{ IOException -> 0x0062 }
        long r5 = r5 - r0
        goto L_0x0001
    L_0x005a:
        com.tencent.bugly.beta.utils.a r0 = r4.f23859b     // Catch:{ IOException -> 0x0062 }
        m30625a(r0)     // Catch:{ IOException -> 0x0062 }
        goto L_0x0001
    L_0x0060:
        r5 = move-exception
        goto L_0x006e
    L_0x0062:
        r5 = move-exception
        java.lang.String r6 = "ElfArmAttrParser"
        java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x0060 }
        android.util.Log.e(r6, r5)     // Catch:{ all -> 0x0060 }
        monitor-exit(r4)
        return r2
    L_0x006e:
        monitor-exit(r4)
        throw r5
    L_0x0070:
        monitor-exit(r4)
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.utils.C7154b.m30628a(long):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0056, code lost:
            return false;
     */
    /* renamed from: f */
    private synchronized boolean m30633f() {
        /*
        r10 = this;
        monitor-enter(r10)
        r0 = 0
        com.tencent.bugly.beta.utils.a r1 = r10.f23859b     // Catch:{ IOException -> 0x0059 }
        long r1 = r1.mo34484f()     // Catch:{ IOException -> 0x0059 }
        r3 = 65
        int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
        if (r5 == 0) goto L_0x0010
        monitor-exit(r10)
        return r0
    L_0x0010:
        com.tencent.bugly.beta.utils.a r1 = r10.f23859b     // Catch:{ IOException -> 0x0059 }
        long r1 = r1.mo34486h()     // Catch:{ IOException -> 0x0059 }
        java.lang.String r3 = r10.m30632e()     // Catch:{ IOException -> 0x0059 }
        if (r3 == 0) goto L_0x0055
        java.lang.String r4 = "aeabi"
        boolean r4 = r3.equals(r4)     // Catch:{ IOException -> 0x0059 }
        if (r4 != 0) goto L_0x0025
        goto L_0x0055
    L_0x0025:
        int r3 = r3.length()     // Catch:{ IOException -> 0x0059 }
        long r3 = (long) r3     // Catch:{ IOException -> 0x0059 }
        long r1 = r1 - r3
    L_0x002b:
        r3 = 0
        int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
        if (r5 <= 0) goto L_0x0052
        com.tencent.bugly.beta.utils.a r3 = r10.f23859b     // Catch:{ IOException -> 0x0059 }
        long r3 = r3.mo34484f()     // Catch:{ IOException -> 0x0059 }
        com.tencent.bugly.beta.utils.a r5 = r10.f23859b     // Catch:{ IOException -> 0x0059 }
        long r5 = r5.mo34486h()     // Catch:{ IOException -> 0x0059 }
        r7 = 5
        long r5 = r5 - r7
        r7 = 1
        int r9 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
        if (r9 != 0) goto L_0x004c
        boolean r0 = r10.m30628a(r5)     // Catch:{ IOException -> 0x0059 }
        monitor-exit(r10)
        return r0
    L_0x004c:
        com.tencent.bugly.beta.utils.a r3 = r10.f23859b     // Catch:{ IOException -> 0x0059 }
        r3.mo34480b(r5)     // Catch:{ IOException -> 0x0059 }
        goto L_0x002b
    L_0x0052:
        r0 = 1
        monitor-exit(r10)
        return r0
    L_0x0055:
        monitor-exit(r10)
        return r0
    L_0x0057:
        r0 = move-exception
        goto L_0x0065
    L_0x0059:
        r1 = move-exception
        java.lang.String r2 = "ElfArmAttrParser"
        java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0057 }
        android.util.Log.e(r2, r1)     // Catch:{ all -> 0x0057 }
        monitor-exit(r10)
        return r0
    L_0x0065:
        monitor-exit(r10)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.utils.C7154b.m30633f():boolean");
    }

    /* renamed from: g */
    private boolean m30634g() {
        if (!m30630c()) {
            m30629b();
            return false;
        }
        if (!m30633f()) {
            Log.e("ElfArmAttrParser", "Failed to parse elf header");
        }
        m30629b();
        return true;
    }

    /* renamed from: a */
    public static String m30626a(String str, long j, long j2) {
        C7154b bVar = new C7154b(str, j, j2);
        if (bVar.m30634g()) {
            return bVar.f23862e;
        }
        Log.e("ElfArmAttrParser", "Failed to parse the arch.");
        return null;
    }

    /* renamed from: a */
    public static synchronized long m30625a(C7153a aVar) throws IOException {
        long j;
        byte b;
        synchronized (C7154b.class) {
            j = 0;
            long j2 = 0;
            do {
                b = aVar.mo34479b();
                j |= (((long) b) & 127) << ((int) j2);
                j2 += 7;
            } while ((b & Byte.MIN_VALUE) != 0);
        }
        return j;
    }
}
