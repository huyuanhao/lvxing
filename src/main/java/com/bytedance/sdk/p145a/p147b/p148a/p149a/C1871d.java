package com.bytedance.sdk.p145a.p147b.p148a.p149a;

import com.bytedance.sdk.p145a.p146a.BufferedSink;
import com.bytedance.sdk.p145a.p147b.p148a.p154f.FileSystem;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

/* compiled from: DiskLruCache */
/* renamed from: com.bytedance.sdk.a.b.a.a.d */
public final class C1871d implements Closeable, Flushable {
    /* renamed from: a */
    static final Pattern f5323a = Pattern.compile("[a-z0-9_-]{1,120}");
    /* renamed from: j */
    static final /* synthetic */ boolean f5324j = (!C1871d.class.desiredAssertionStatus());
    /* renamed from: b */
    final FileSystem f5325b;
    /* renamed from: c */
    final int f5326c;
    /* renamed from: d */
    BufferedSink f5327d;
    /* renamed from: e */
    final LinkedHashMap<String, C1873b> f5328e;
    /* renamed from: f */
    int f5329f;
    /* renamed from: g */
    boolean f5330g;
    /* renamed from: h */
    boolean f5331h;
    /* renamed from: i */
    boolean f5332i;
    /* renamed from: k */
    private long f5333k;
    /* renamed from: l */
    private long f5334l;
    /* renamed from: m */
    private long f5335m;
    /* renamed from: n */
    private final Executor f5336n;
    /* renamed from: o */
    private final Runnable f5337o;

    /* compiled from: DiskLruCache */
    /* renamed from: com.bytedance.sdk.a.b.a.a.d$a */
    public final class C1872a {
        /* renamed from: a */
        final C1873b f5338a;
        /* renamed from: b */
        final boolean[] f5339b;
        /* renamed from: c */
        final /* synthetic */ C1871d f5340c;
        /* renamed from: d */
        private boolean f5341d;

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo13675a() {
            if (this.f5338a.f5347f == this) {
                for (int i = 0; i < this.f5340c.f5326c; i++) {
                    try {
                        this.f5340c.f5325b.mo13865a(this.f5338a.f5345d[i]);
                    } catch (IOException unused) {
                    }
                }
                this.f5338a.f5347f = null;
            }
        }

        /* renamed from: b */
        public void mo13676b() throws IOException {
            synchronized (this.f5340c) {
                if (!this.f5341d) {
                    if (this.f5338a.f5347f == this) {
                        this.f5340c.mo13668a(this, false);
                    }
                    this.f5341d = true;
                } else {
                    throw new IllegalStateException();
                }
            }
        }
    }

    /* compiled from: DiskLruCache */
    /* renamed from: com.bytedance.sdk.a.b.a.a.d$b */
    private final class C1873b {
        /* renamed from: a */
        final String f5342a;
        /* renamed from: b */
        final long[] f5343b;
        /* renamed from: c */
        final File[] f5344c;
        /* renamed from: d */
        final File[] f5345d;
        /* renamed from: e */
        boolean f5346e;
        /* renamed from: f */
        C1872a f5347f;
        /* renamed from: g */
        long f5348g;

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo13677a(BufferedSink dVar) throws IOException {
            for (long l : this.f5343b) {
                dVar.mo13559i(32).mo13567l(l);
            }
        }
    }

    /* access modifiers changed from: declared_synchronized */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f4, code lost:
            return;
     */
    /* renamed from: a */
    public synchronized void mo13668a(com.bytedance.sdk.p145a.p147b.p148a.p149a.C1871d.C1872a r10, boolean r11) throws java.io.IOException {
        /*
        r9 = this;
        monitor-enter(r9)
        com.bytedance.sdk.a.b.a.a.d$b r0 = r10.f5338a     // Catch:{ all -> 0x00fb }
        com.bytedance.sdk.a.b.a.a.d$a r1 = r0.f5347f     // Catch:{ all -> 0x00fb }
        if (r1 != r10) goto L_0x00f5
        r1 = 0
        if (r11 == 0) goto L_0x0047
        boolean r2 = r0.f5346e     // Catch:{ all -> 0x00fb }
        if (r2 != 0) goto L_0x0047
        r2 = 0
    L_0x000f:
        int r3 = r9.f5326c     // Catch:{ all -> 0x00fb }
        if (r2 >= r3) goto L_0x0047
        boolean[] r3 = r10.f5339b     // Catch:{ all -> 0x00fb }
        boolean r3 = r3[r2]     // Catch:{ all -> 0x00fb }
        if (r3 == 0) goto L_0x002d
        com.bytedance.sdk.a.b.a.f.a r3 = r9.f5325b     // Catch:{ all -> 0x00fb }
        java.io.File[] r4 = r0.f5345d     // Catch:{ all -> 0x00fb }
        r4 = r4[r2]     // Catch:{ all -> 0x00fb }
        boolean r3 = r3.mo13867b(r4)     // Catch:{ all -> 0x00fb }
        if (r3 != 0) goto L_0x002a
        r10.mo13676b()     // Catch:{ all -> 0x00fb }
        monitor-exit(r9)
        return
    L_0x002a:
        int r2 = r2 + 1
        goto L_0x000f
    L_0x002d:
        r10.mo13676b()     // Catch:{ all -> 0x00fb }
        java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00fb }
        java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fb }
        r11.<init>()     // Catch:{ all -> 0x00fb }
        java.lang.String r0 = "Newly created entry didn't create value for index "
        r11.append(r0)     // Catch:{ all -> 0x00fb }
        r11.append(r2)     // Catch:{ all -> 0x00fb }
        java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00fb }
        r10.<init>(r11)     // Catch:{ all -> 0x00fb }
        throw r10     // Catch:{ all -> 0x00fb }
    L_0x0047:
        int r10 = r9.f5326c     // Catch:{ all -> 0x00fb }
        if (r1 >= r10) goto L_0x007f
        java.io.File[] r10 = r0.f5345d     // Catch:{ all -> 0x00fb }
        r10 = r10[r1]     // Catch:{ all -> 0x00fb }
        if (r11 == 0) goto L_0x0077
        com.bytedance.sdk.a.b.a.f.a r2 = r9.f5325b     // Catch:{ all -> 0x00fb }
        boolean r2 = r2.mo13867b(r10)     // Catch:{ all -> 0x00fb }
        if (r2 == 0) goto L_0x007c
        java.io.File[] r2 = r0.f5344c     // Catch:{ all -> 0x00fb }
        r2 = r2[r1]     // Catch:{ all -> 0x00fb }
        com.bytedance.sdk.a.b.a.f.a r3 = r9.f5325b     // Catch:{ all -> 0x00fb }
        r3.mo13866a(r10, r2)     // Catch:{ all -> 0x00fb }
        long[] r10 = r0.f5343b     // Catch:{ all -> 0x00fb }
        r3 = r10[r1]     // Catch:{ all -> 0x00fb }
        com.bytedance.sdk.a.b.a.f.a r10 = r9.f5325b     // Catch:{ all -> 0x00fb }
        long r5 = r10.mo13868c(r2)     // Catch:{ all -> 0x00fb }
        long[] r10 = r0.f5343b     // Catch:{ all -> 0x00fb }
        r10[r1] = r5     // Catch:{ all -> 0x00fb }
        long r7 = r9.f5334l     // Catch:{ all -> 0x00fb }
        long r7 = r7 - r3
        long r7 = r7 + r5
        r9.f5334l = r7     // Catch:{ all -> 0x00fb }
        goto L_0x007c
    L_0x0077:
        com.bytedance.sdk.a.b.a.f.a r2 = r9.f5325b     // Catch:{ all -> 0x00fb }
        r2.mo13865a(r10)     // Catch:{ all -> 0x00fb }
    L_0x007c:
        int r1 = r1 + 1
        goto L_0x0047
    L_0x007f:
        int r10 = r9.f5329f     // Catch:{ all -> 0x00fb }
        r1 = 1
        int r10 = r10 + r1
        r9.f5329f = r10     // Catch:{ all -> 0x00fb }
        r10 = 0
        r0.f5347f = r10     // Catch:{ all -> 0x00fb }
        boolean r10 = r0.f5346e     // Catch:{ all -> 0x00fb }
        r10 = r10 | r11
        r2 = 10
        r3 = 32
        if (r10 == 0) goto L_0x00bb
        r0.f5346e = r1     // Catch:{ all -> 0x00fb }
        com.bytedance.sdk.a.a.d r10 = r9.f5327d     // Catch:{ all -> 0x00fb }
        java.lang.String r1 = "CLEAN"
        com.bytedance.sdk.a.a.d r10 = r10.mo13534b(r1)     // Catch:{ all -> 0x00fb }
        r10.mo13559i(r3)     // Catch:{ all -> 0x00fb }
        com.bytedance.sdk.a.a.d r10 = r9.f5327d     // Catch:{ all -> 0x00fb }
        java.lang.String r1 = r0.f5342a     // Catch:{ all -> 0x00fb }
        r10.mo13534b(r1)     // Catch:{ all -> 0x00fb }
        com.bytedance.sdk.a.a.d r10 = r9.f5327d     // Catch:{ all -> 0x00fb }
        r0.mo13677a(r10)     // Catch:{ all -> 0x00fb }
        com.bytedance.sdk.a.a.d r10 = r9.f5327d     // Catch:{ all -> 0x00fb }
        r10.mo13559i(r2)     // Catch:{ all -> 0x00fb }
        if (r11 == 0) goto L_0x00d9
        long r10 = r9.f5335m     // Catch:{ all -> 0x00fb }
        r1 = 1
        long r1 = r1 + r10
        r9.f5335m = r1     // Catch:{ all -> 0x00fb }
        r0.f5348g = r10     // Catch:{ all -> 0x00fb }
        goto L_0x00d9
    L_0x00bb:
        java.util.LinkedHashMap<java.lang.String, com.bytedance.sdk.a.b.a.a.d$b> r10 = r9.f5328e     // Catch:{ all -> 0x00fb }
        java.lang.String r11 = r0.f5342a     // Catch:{ all -> 0x00fb }
        r10.remove(r11)     // Catch:{ all -> 0x00fb }
        com.bytedance.sdk.a.a.d r10 = r9.f5327d     // Catch:{ all -> 0x00fb }
        java.lang.String r11 = "REMOVE"
        com.bytedance.sdk.a.a.d r10 = r10.mo13534b(r11)     // Catch:{ all -> 0x00fb }
        r10.mo13559i(r3)     // Catch:{ all -> 0x00fb }
        com.bytedance.sdk.a.a.d r10 = r9.f5327d     // Catch:{ all -> 0x00fb }
        java.lang.String r11 = r0.f5342a     // Catch:{ all -> 0x00fb }
        r10.mo13534b(r11)     // Catch:{ all -> 0x00fb }
        com.bytedance.sdk.a.a.d r10 = r9.f5327d     // Catch:{ all -> 0x00fb }
        r10.mo13559i(r2)     // Catch:{ all -> 0x00fb }
    L_0x00d9:
        com.bytedance.sdk.a.a.d r10 = r9.f5327d     // Catch:{ all -> 0x00fb }
        r10.flush()     // Catch:{ all -> 0x00fb }
        long r10 = r9.f5334l     // Catch:{ all -> 0x00fb }
        long r0 = r9.f5333k     // Catch:{ all -> 0x00fb }
        int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
        if (r2 > 0) goto L_0x00ec
        boolean r10 = r9.mo13669a()     // Catch:{ all -> 0x00fb }
        if (r10 == 0) goto L_0x00f3
    L_0x00ec:
        java.util.concurrent.Executor r10 = r9.f5336n     // Catch:{ all -> 0x00fb }
        java.lang.Runnable r11 = r9.f5337o     // Catch:{ all -> 0x00fb }
        r10.execute(r11)     // Catch:{ all -> 0x00fb }
    L_0x00f3:
        monitor-exit(r9)
        return
    L_0x00f5:
        java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00fb }
        r10.<init>()     // Catch:{ all -> 0x00fb }
        throw r10     // Catch:{ all -> 0x00fb }
    L_0x00fb:
        r10 = move-exception
        monitor-exit(r9)
        throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.p145a.p147b.p148a.p149a.C1871d.mo13668a(com.bytedance.sdk.a.b.a.a.d$a, boolean):void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo13669a() {
        int i = this.f5329f;
        return i >= 2000 && i >= this.f5328e.size();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo13670a(C1873b bVar) throws IOException {
        if (bVar.f5347f != null) {
            bVar.f5347f.mo13675a();
        }
        for (int i = 0; i < this.f5326c; i++) {
            this.f5325b.mo13865a(bVar.f5344c[i]);
            this.f5334l -= bVar.f5343b[i];
            bVar.f5343b[i] = 0;
        }
        this.f5329f++;
        this.f5327d.mo13534b("REMOVE").mo13559i(32).mo13534b(bVar.f5342a).mo13559i(10);
        this.f5328e.remove(bVar.f5342a);
        if (mo13669a()) {
            this.f5336n.execute(this.f5337o);
        }
        return true;
    }

    /* renamed from: b */
    public synchronized boolean mo13671b() {
        return this.f5331h;
    }

    /* renamed from: d */
    private synchronized void m6876d() {
        if (mo13671b()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void flush() throws IOException {
        if (this.f5330g) {
            m6876d();
            mo13672c();
            this.f5327d.flush();
        }
    }

    public synchronized void close() throws IOException {
        C1873b[] bVarArr;
        if (this.f5330g) {
            if (!this.f5331h) {
                for (C1873b bVar : (C1873b[]) this.f5328e.values().toArray(new C1873b[this.f5328e.size()])) {
                    if (bVar.f5347f != null) {
                        bVar.f5347f.mo13676b();
                    }
                }
                mo13672c();
                this.f5327d.close();
                this.f5327d = null;
                this.f5331h = true;
                return;
            }
        }
        this.f5331h = true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo13672c() throws IOException {
        while (this.f5334l > this.f5333k) {
            mo13670a((C1873b) this.f5328e.values().iterator().next());
        }
        this.f5332i = false;
    }
}
