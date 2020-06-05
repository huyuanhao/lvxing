package com.bytedance.sdk.openadsdk.p190h;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.adnet.err.AuthFailureError;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.p190h.C2482i.C2484b;
import com.bytedance.sdk.openadsdk.p190h.Urls.C2488a;
import com.bytedance.sdk.openadsdk.p190h.p191a.C2440a;
import com.bytedance.sdk.openadsdk.p190h.p192b.VideoProxyDB;
import com.bytedance.sdk.openadsdk.p190h.p193c.CancelException;
import com.bytedance.sdk.openadsdk.p190h.p193c.ContentLengthNotMatchException;
import com.bytedance.sdk.openadsdk.p190h.p193c.RequestException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;

/* renamed from: com.bytedance.sdk.openadsdk.h.b */
class DownloadTask extends AbsTask {
    /* renamed from: m */
    final Object f8772m = this;
    /* renamed from: n */
    final Object f8773n;
    /* renamed from: o */
    private final int f8774o;
    /* renamed from: p */
    private final C2453b f8775p;
    /* renamed from: q */
    private volatile C2481a f8776q;
    /* renamed from: r */
    private volatile ContentLengthNotMatchException f8777r;

    /* compiled from: DownloadTask */
    /* renamed from: com.bytedance.sdk.openadsdk.h.b$a */
    static final class C2452a {
        /* renamed from: a */
        String f8778a;
        /* renamed from: b */
        String f8779b;
        /* renamed from: c */
        Urls f8780c;
        /* renamed from: d */
        C2440a f8781d;
        /* renamed from: e */
        VideoProxyDB f8782e;
        /* renamed from: f */
        List<C2484b> f8783f;
        /* renamed from: g */
        int f8784g;
        /* renamed from: h */
        C2482i f8785h;
        /* renamed from: i */
        C2453b f8786i;
        /* renamed from: j */
        Object f8787j;

        C2452a() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C2452a mo16705a(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f8778a = str;
                return this;
            }
            throw new IllegalArgumentException("rawKey == null");
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public C2452a mo16708b(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f8779b = str;
                return this;
            }
            throw new IllegalArgumentException("key == null");
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C2452a mo16703a(Urls lVar) {
            if (lVar != null) {
                this.f8780c = lVar;
                return this;
            }
            throw new IllegalArgumentException("urls is empty");
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C2452a mo16699a(C2440a aVar) {
            if (aVar != null) {
                this.f8781d = aVar;
                return this;
            }
            throw new IllegalArgumentException("cache == null");
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C2452a mo16701a(VideoProxyDB cVar) {
            if (cVar != null) {
                this.f8782e = cVar;
                return this;
            }
            throw new IllegalArgumentException("db == null");
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C2452a mo16706a(List<C2484b> list) {
            this.f8783f = list;
            return this;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C2452a mo16698a(int i) {
            this.f8784g = i;
            return this;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C2452a mo16700a(C2453b bVar) {
            this.f8786i = bVar;
            return this;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C2452a mo16702a(C2482i iVar) {
            this.f8785h = iVar;
            return this;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C2452a mo16704a(Object obj) {
            this.f8787j = obj;
            return this;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public DownloadTask mo16707a() {
            if (this.f8781d != null && this.f8782e != null && !TextUtils.isEmpty(this.f8778a) && !TextUtils.isEmpty(this.f8779b) && this.f8780c != null) {
                return new DownloadTask(this);
            }
            throw new IllegalArgumentException();
        }
    }

    /* compiled from: DownloadTask */
    /* renamed from: com.bytedance.sdk.openadsdk.h.b$b */
    public interface C2453b {
        /* renamed from: a */
        void mo16709a(DownloadTask bVar);
    }

    DownloadTask(C2452a aVar) {
        super(aVar.f8781d, aVar.f8782e);
        this.f8774o = aVar.f8784g;
        this.f8775p = aVar.f8786i;
        this.f8741g = aVar.f8778a;
        this.f8742h = aVar.f8779b;
        this.f8740f = aVar.f8783f;
        this.f8744j = aVar.f8780c;
        this.f8743i = aVar.f8785h;
        this.f8773n = aVar.f8787j;
    }

    public void run() {
        String str = "TAG_PROXY_DownloadTask";
        this.f8735a.mo16672a(this.f8742h);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            m11492j();
        } catch (CancelException e) {
            if (Proxy.f8836c) {
                Log.w(str, Log.getStackTraceString(e));
            }
        } catch (AuthFailureError e2) {
            e2.printStackTrace();
        } catch (VAdError e3) {
            e3.printStackTrace();
        } catch (Throwable th) {
            if (Proxy.f8836c) {
                Log.e(str, Log.getStackTraceString(th));
            }
        }
        this.f8738d.set(SystemClock.elapsedRealtime() - elapsedRealtime);
        this.f8735a.mo16673b(this.f8742h);
        C2453b bVar = this.f8775p;
        if (bVar != null) {
            bVar.mo16709a(this);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public C2481a mo16695h() {
        return this.f8776q;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public ContentLengthNotMatchException mo16696i() {
        return this.f8777r;
    }

    /* renamed from: j */
    private boolean m11492j() throws CancelException, VAdError {
        String str = "TAG_PROXY_DownloadTask";
        while (this.f8744j.mo16797a()) {
            mo16668e();
            C2488a b = this.f8744j.mo16798b();
            try {
                m11491a(b);
                return true;
            } catch (RequestException e) {
                b.mo16799a();
                mo16664a(Boolean.valueOf(mo16670g()), this.f8741g, e);
            } catch (IOException e2) {
                if (e2 instanceof SocketTimeoutException) {
                    b.mo16800b();
                }
                if (!mo16665b()) {
                    mo16664a(Boolean.valueOf(mo16670g()), this.f8741g, e2);
                } else if (Proxy.f8836c) {
                    if ("Canceled".equalsIgnoreCase(e2.getMessage())) {
                        Log.w(str, "okhttp call canceled");
                    } else {
                        Log.e(str, Log.getStackTraceString(e2));
                    }
                }
            } catch (C2481a e3) {
                this.f8776q = e3;
                mo16664a(Boolean.valueOf(mo16670g()), this.f8741g, e3);
                return false;
            } catch (ContentLengthNotMatchException e4) {
                this.f8777r = e4;
                if (Proxy.f8836c) {
                    Log.e(str, Log.getStackTraceString(e4));
                }
                return false;
            } catch (Throwable th) {
                if (Proxy.f8836c) {
                    Log.e(str, Log.getStackTraceString(th));
                }
                return false;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
            mo16666c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01cf, code lost:
            if (com.bytedance.sdk.openadsdk.p190h.Proxy.f8836c == false) goto L_0x01d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01d1, code lost:
            android.util.Log.i("TAG_PROXY_DownloadTask", "download succeed, no need to cancel call");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01d8, code lost:
            com.bytedance.sdk.openadsdk.p190h.p197g.C2479d.m11662a((java.io.Closeable) r6.mo16747d());
            r4.mo16788a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01e2, code lost:
            return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x021d  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0218  */
    /* renamed from: a */
    private void m11491a(com.bytedance.sdk.openadsdk.p190h.Urls.C2488a r13) throws java.io.IOException, com.bytedance.sdk.openadsdk.p190h.RandomAccessFileWrapper.C2481a, com.bytedance.sdk.openadsdk.p190h.p193c.CancelException, com.bytedance.sdk.openadsdk.p190h.p193c.ContentLengthNotMatchException, com.bytedance.sdk.adnet.err.VAdError {
        /*
        r12 = this;
        com.bytedance.sdk.openadsdk.h.a.a r0 = r12.f8735a
        java.lang.String r1 = r12.f8742h
        java.io.File r0 = r0.mo16674c(r1)
        long r1 = r0.length()
        int r3 = r12.f8774o
        if (r3 <= 0) goto L_0x0044
        long r3 = (long) r3
        int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
        if (r5 < 0) goto L_0x0044
        boolean r13 = com.bytedance.sdk.openadsdk.p190h.Proxy.f8836c
        if (r13 == 0) goto L_0x0043
        java.lang.StringBuilder r13 = new java.lang.StringBuilder
        r13.<init>()
        java.lang.String r0 = "no necessary to download for "
        r13.append(r0)
        java.lang.String r0 = r12.f8742h
        r13.append(r0)
        java.lang.String r0 = ", cache file size: "
        r13.append(r0)
        r13.append(r1)
        java.lang.String r0 = ", max: "
        r13.append(r0)
        int r0 = r12.f8774o
        r13.append(r0)
        java.lang.String r13 = r13.toString()
        java.lang.String r0 = "TAG_PROXY_DownloadTask"
        android.util.Log.i(r0, r13)
    L_0x0043:
        return
    L_0x0044:
        int r3 = r12.mo16669f()
        com.bytedance.sdk.openadsdk.h.b.c r4 = r12.f8736b
        java.lang.String r5 = r12.f8742h
        com.bytedance.sdk.openadsdk.h.b.a r4 = r4.mo16710a(r5, r3)
        if (r4 == 0) goto L_0x0076
        int r5 = r4.f8790c
        long r5 = (long) r5
        int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
        if (r7 < 0) goto L_0x0076
        boolean r13 = com.bytedance.sdk.openadsdk.p190h.Proxy.f8836c
        if (r13 == 0) goto L_0x0075
        java.lang.StringBuilder r13 = new java.lang.StringBuilder
        r13.<init>()
        java.lang.String r0 = "file download complete, key: "
        r13.append(r0)
        java.lang.String r0 = r12.f8742h
        r13.append(r0)
        java.lang.String r13 = r13.toString()
        java.lang.String r0 = "TAG_PROXY_DownloadTask"
        android.util.Log.i(r0, r13)
    L_0x0075:
        return
    L_0x0076:
        r12.mo16668e()
        int r5 = (int) r1
        int r6 = r12.f8774o
        java.lang.String r7 = "GET"
        com.bytedance.sdk.openadsdk.h.e.a r6 = r12.mo16661a(r13, r5, r6, r7)
        if (r6 != 0) goto L_0x0085
        return
    L_0x0085:
        r7 = 0
        r8 = 1
        r9 = 0
        r12.mo16668e()     // Catch:{ all -> 0x020e }
        com.bytedance.sdk.openadsdk.h.i r10 = r12.f8743i     // Catch:{ all -> 0x020e }
        if (r10 != 0) goto L_0x0095
        boolean r10 = com.bytedance.sdk.openadsdk.p190h.Proxy.f8838e     // Catch:{ all -> 0x020e }
        if (r10 == 0) goto L_0x0095
        r10 = 1
        goto L_0x0096
    L_0x0095:
        r10 = 0
    L_0x0096:
        java.lang.String r10 = com.bytedance.sdk.openadsdk.p190h.p197g.C2479d.m11658a(r6, r10, r8)     // Catch:{ all -> 0x020e }
        if (r10 != 0) goto L_0x01ea
        int r10 = com.bytedance.sdk.openadsdk.p190h.p197g.C2479d.m11652a(r6)     // Catch:{ all -> 0x020e }
        if (r4 == 0) goto L_0x0111
        int r11 = r4.f8790c     // Catch:{ all -> 0x020e }
        if (r11 == r10) goto L_0x0111
        boolean r0 = com.bytedance.sdk.openadsdk.p190h.Proxy.f8836c     // Catch:{ all -> 0x020e }
        if (r0 == 0) goto L_0x00d4
        java.lang.String r0 = "TAG_PROXY_DownloadTask"
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x020e }
        r1.<init>()     // Catch:{ all -> 0x020e }
        java.lang.String r2 = "Content-Length not match, old: "
        r1.append(r2)     // Catch:{ all -> 0x020e }
        int r2 = r4.f8790c     // Catch:{ all -> 0x020e }
        r1.append(r2)     // Catch:{ all -> 0x020e }
        java.lang.String r2 = ", "
        r1.append(r2)     // Catch:{ all -> 0x020e }
        r1.append(r10)     // Catch:{ all -> 0x020e }
        java.lang.String r2 = ", key: "
        r1.append(r2)     // Catch:{ all -> 0x020e }
        java.lang.String r2 = r12.f8742h     // Catch:{ all -> 0x020e }
        r1.append(r2)     // Catch:{ all -> 0x020e }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x020e }
        android.util.Log.e(r0, r1)     // Catch:{ all -> 0x020e }
    L_0x00d4:
        com.bytedance.sdk.openadsdk.h.c.b r0 = new com.bytedance.sdk.openadsdk.h.c.b     // Catch:{ all -> 0x020e }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x020e }
        r1.<init>()     // Catch:{ all -> 0x020e }
        java.lang.String r2 = "Content-Length not match, old length: "
        r1.append(r2)     // Catch:{ all -> 0x020e }
        int r2 = r4.f8790c     // Catch:{ all -> 0x020e }
        r1.append(r2)     // Catch:{ all -> 0x020e }
        java.lang.String r2 = ", new length: "
        r1.append(r2)     // Catch:{ all -> 0x020e }
        r1.append(r10)     // Catch:{ all -> 0x020e }
        java.lang.String r2 = ", rawKey: "
        r1.append(r2)     // Catch:{ all -> 0x020e }
        java.lang.String r2 = r12.f8741g     // Catch:{ all -> 0x020e }
        r1.append(r2)     // Catch:{ all -> 0x020e }
        java.lang.String r2 = ", currentUrl: "
        r1.append(r2)     // Catch:{ all -> 0x020e }
        r1.append(r13)     // Catch:{ all -> 0x020e }
        java.lang.String r13 = ", previousInfo: "
        r1.append(r13)     // Catch:{ all -> 0x020e }
        java.lang.String r13 = r4.f8792e     // Catch:{ all -> 0x020e }
        r1.append(r13)     // Catch:{ all -> 0x020e }
        java.lang.String r13 = r1.toString()     // Catch:{ all -> 0x020e }
        r0.m44064init(r13)     // Catch:{ all -> 0x020e }
        throw r0     // Catch:{ all -> 0x020e }
    L_0x0111:
        com.bytedance.sdk.openadsdk.h.b.c r13 = r12.f8736b     // Catch:{ all -> 0x020e }
        java.lang.String r4 = r12.f8742h     // Catch:{ all -> 0x020e }
        com.bytedance.sdk.openadsdk.p190h.p197g.C2479d.m11654a(r6, r13, r4, r3)     // Catch:{ all -> 0x020e }
        com.bytedance.sdk.openadsdk.h.b.c r13 = r12.f8736b     // Catch:{ all -> 0x020e }
        java.lang.String r4 = r12.f8742h     // Catch:{ all -> 0x020e }
        com.bytedance.sdk.openadsdk.h.b.a r13 = r13.mo16710a(r4, r3)     // Catch:{ all -> 0x020e }
        if (r13 != 0) goto L_0x0124
        r13 = 0
        goto L_0x0126
    L_0x0124:
        int r13 = r13.f8790c     // Catch:{ all -> 0x020e }
    L_0x0126:
        java.io.InputStream r3 = r6.mo16747d()     // Catch:{ all -> 0x020e }
        com.bytedance.sdk.openadsdk.h.h r4 = new com.bytedance.sdk.openadsdk.h.h     // Catch:{ all -> 0x020e }
        boolean r10 = com.bytedance.sdk.openadsdk.p190h.Proxy.f8837d     // Catch:{ all -> 0x020e }
        if (r10 == 0) goto L_0x0133
        java.lang.String r10 = "rwd"
        goto L_0x0135
    L_0x0133:
        java.lang.String r10 = "rw"
    L_0x0135:
        r4.m44109init(r0, r10)     // Catch:{ all -> 0x020e }
        r4.mo16789a(r1)     // Catch:{ all -> 0x01e7 }
        boolean r0 = com.bytedance.sdk.openadsdk.p190h.Proxy.f8836c     // Catch:{ all -> 0x01e7 }
        if (r0 == 0) goto L_0x0155
        java.lang.String r0 = "TAG_PROXY_DownloadTask"
        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e7 }
        r7.<init>()     // Catch:{ all -> 0x01e7 }
        java.lang.String r10 = "preload start from: "
        r7.append(r10)     // Catch:{ all -> 0x01e7 }
        r7.append(r1)     // Catch:{ all -> 0x01e7 }
        java.lang.String r1 = r7.toString()     // Catch:{ all -> 0x01e7 }
        android.util.Log.i(r0, r1)     // Catch:{ all -> 0x01e7 }
    L_0x0155:
        r0 = 8192(0x2000, float:1.14794E-41)
        byte[] r0 = new byte[r0]     // Catch:{ all -> 0x01e7 }
    L_0x0159:
        int r1 = r3.read(r0)     // Catch:{ all -> 0x01e7 }
        if (r1 < 0) goto L_0x01ca
        r12.mo16668e()     // Catch:{ all -> 0x01e7 }
        if (r1 <= 0) goto L_0x0181
        r4.mo16790a(r0, r9, r1)     // Catch:{ all -> 0x01e7 }
        int r5 = r5 + r1
        com.bytedance.sdk.openadsdk.h.i r2 = r12.f8743i     // Catch:{ all -> 0x01e7 }
        if (r2 == 0) goto L_0x0179
        java.lang.Object r2 = r12.f8772m     // Catch:{ all -> 0x01e7 }
        monitor-enter(r2)     // Catch:{ all -> 0x01e7 }
        java.lang.Object r7 = r12.f8772m     // Catch:{ all -> 0x0176 }
        r7.notifyAll()     // Catch:{ all -> 0x0176 }
        monitor-exit(r2)     // Catch:{ all -> 0x0176 }
        goto L_0x0179
    L_0x0176:
        r13 = move-exception
        monitor-exit(r2)     // Catch:{ all -> 0x0176 }
        throw r13     // Catch:{ all -> 0x01e7 }
    L_0x0179:
        java.util.concurrent.atomic.AtomicInteger r2 = r12.f8737c     // Catch:{ all -> 0x01e7 }
        r2.addAndGet(r1)     // Catch:{ all -> 0x01e7 }
        r12.mo16663a(r13, r5)     // Catch:{ all -> 0x01e7 }
    L_0x0181:
        int r1 = r12.f8774o     // Catch:{ all -> 0x01e7 }
        if (r1 <= 0) goto L_0x01c6
        int r1 = r12.f8774o     // Catch:{ all -> 0x01e7 }
        if (r5 < r1) goto L_0x01c6
        boolean r13 = com.bytedance.sdk.openadsdk.p190h.Proxy.f8836c     // Catch:{ all -> 0x01e7 }
        if (r13 == 0) goto L_0x01ad
        java.lang.String r13 = "TAG_PROXY_DownloadTask"
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e7 }
        r0.<init>()     // Catch:{ all -> 0x01e7 }
        java.lang.String r1 = "download, more data received, currentCacheFileSize: "
        r0.append(r1)     // Catch:{ all -> 0x01e7 }
        r0.append(r5)     // Catch:{ all -> 0x01e7 }
        java.lang.String r1 = ", max: "
        r0.append(r1)     // Catch:{ all -> 0x01e7 }
        int r1 = r12.f8774o     // Catch:{ all -> 0x01e7 }
        r0.append(r1)     // Catch:{ all -> 0x01e7 }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01e7 }
        android.util.Log.w(r13, r0)     // Catch:{ all -> 0x01e7 }
    L_0x01ad:
        java.io.InputStream r13 = r6.mo16747d()
        com.bytedance.sdk.openadsdk.p190h.p197g.C2479d.m11662a(r13)
        r4.mo16788a()
        r12.mo16662a()
        boolean r13 = com.bytedance.sdk.openadsdk.p190h.Proxy.f8836c
        if (r13 == 0) goto L_0x01c5
        java.lang.String r13 = "TAG_PROXY_DownloadTask"
        java.lang.String r0 = "cancel call"
        android.util.Log.w(r13, r0)
    L_0x01c5:
        return
    L_0x01c6:
        r12.mo16668e()     // Catch:{ all -> 0x01e7 }
        goto L_0x0159
    L_0x01ca:
        r12.mo16666c()     // Catch:{ all -> 0x01e3 }
        boolean r13 = com.bytedance.sdk.openadsdk.p190h.Proxy.f8836c     // Catch:{ all -> 0x01e3 }
        if (r13 == 0) goto L_0x01d8
        java.lang.String r13 = "TAG_PROXY_DownloadTask"
        java.lang.String r0 = "download succeed, no need to cancel call"
        android.util.Log.i(r13, r0)     // Catch:{ all -> 0x01e3 }
    L_0x01d8:
        java.io.InputStream r13 = r6.mo16747d()
        com.bytedance.sdk.openadsdk.p190h.p197g.C2479d.m11662a(r13)
        r4.mo16788a()
        return
    L_0x01e3:
        r13 = move-exception
        r7 = r4
        r8 = 0
        goto L_0x020f
    L_0x01e7:
        r13 = move-exception
        r7 = r4
        goto L_0x020f
    L_0x01ea:
        com.bytedance.sdk.openadsdk.h.c.c r0 = new com.bytedance.sdk.openadsdk.h.c.c     // Catch:{ all -> 0x020e }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x020e }
        r1.<init>()     // Catch:{ all -> 0x020e }
        r1.append(r10)     // Catch:{ all -> 0x020e }
        java.lang.String r2 = ", rawKey: "
        r1.append(r2)     // Catch:{ all -> 0x020e }
        java.lang.String r2 = r12.f8741g     // Catch:{ all -> 0x020e }
        r1.append(r2)     // Catch:{ all -> 0x020e }
        java.lang.String r2 = ", url: "
        r1.append(r2)     // Catch:{ all -> 0x020e }
        r1.append(r13)     // Catch:{ all -> 0x020e }
        java.lang.String r13 = r1.toString()     // Catch:{ all -> 0x020e }
        r0.m44065init(r13)     // Catch:{ all -> 0x020e }
        throw r0     // Catch:{ all -> 0x020e }
    L_0x020e:
        r13 = move-exception
    L_0x020f:
        java.io.InputStream r0 = r6.mo16747d()
        com.bytedance.sdk.openadsdk.p190h.p197g.C2479d.m11662a(r0)
        if (r7 == 0) goto L_0x021b
        r7.mo16788a()
    L_0x021b:
        if (r8 == 0) goto L_0x022b
        r12.mo16662a()
        boolean r0 = com.bytedance.sdk.openadsdk.p190h.Proxy.f8836c
        if (r0 == 0) goto L_0x022b
        java.lang.String r0 = "TAG_PROXY_DownloadTask"
        java.lang.String r1 = "cancel call"
        android.util.Log.w(r0, r1)
    L_0x022b:
        throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.p190h.DownloadTask.m11491a(com.bytedance.sdk.openadsdk.h.l$a):void");
    }
}
