package com.tencent.bugly.beta.utils;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.utils.d */
public class C7158d {
    /* renamed from: a */
    C7153a f23900a = null;
    /* renamed from: b */
    private String f23901b = null;
    /* renamed from: c */
    private long f23902c = 0;
    /* renamed from: d */
    private long f23903d = 0;

    public C7158d(String str, long j, long j2) {
        this.f23901b = str;
        this.f23902c = j;
        this.f23903d = j2;
    }

    /* renamed from: b */
    private boolean m30676b() {
        return (this.f23902c == 0 || this.f23903d == 0) ? false : true;
    }

    /* renamed from: a */
    public synchronized void mo34511a() {
        if (this.f23900a != null) {
            this.f23900a.mo34477a();
            this.f23900a = null;
        }
    }

    /* renamed from: c */
    private synchronized boolean m30677c() {
        if (!m30676b()) {
            return false;
        }
        if (this.f23900a == null) {
            try {
                this.f23900a = new C7153a(this.f23901b);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private synchronized String m30675b(long j) {
        if (this.f23900a == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            this.f23900a.mo34480b(this.f23902c);
            this.f23900a.mo34480b(j);
            while (true) {
                byte b = this.f23900a.mo34479b();
                if (b == 0) {
                    break;
                }
                stringBuffer.append((char) b);
            }
            this.f23900a.mo34477a();
            this.f23900a = new C7153a(this.f23901b);
        } catch (Exception e) {
            this.f23900a = null;
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0025, code lost:
            return null;
     */
    /* renamed from: a */
    public synchronized java.lang.String mo34510a(long r5) {
        /*
        r4 = this;
        monitor-enter(r4)
        r0 = 0
        r2 = 0
        int r3 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
        if (r3 < 0) goto L_0x0024
        long r0 = r4.f23903d     // Catch:{ all -> 0x0021 }
        int r3 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
        if (r3 < 0) goto L_0x000f
        goto L_0x0024
    L_0x000f:
        com.tencent.bugly.beta.utils.a r0 = r4.f23900a     // Catch:{ all -> 0x0021 }
        if (r0 != 0) goto L_0x001b
        boolean r0 = r4.m30677c()     // Catch:{ all -> 0x0021 }
        if (r0 != 0) goto L_0x001b
        monitor-exit(r4)
        return r2
    L_0x001b:
        java.lang.String r5 = r4.m30675b(r5)     // Catch:{ all -> 0x0021 }
        monitor-exit(r4)
        return r5
    L_0x0021:
        r5 = move-exception
        monitor-exit(r4)
        throw r5
    L_0x0024:
        monitor-exit(r4)
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.utils.C7158d.mo34510a(long):java.lang.String");
    }
}
