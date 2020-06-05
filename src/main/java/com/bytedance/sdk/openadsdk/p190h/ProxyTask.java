package com.bytedance.sdk.openadsdk.p190h;

import android.util.Log;
import com.bytedance.sdk.adnet.err.AuthFailureError;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.p190h.Urls.C2488a;
import com.bytedance.sdk.openadsdk.p190h.p191a.C2440a;
import com.bytedance.sdk.openadsdk.p190h.p192b.VideoHttpHeaderInfo;
import com.bytedance.sdk.openadsdk.p190h.p192b.VideoProxyDB;
import com.bytedance.sdk.openadsdk.p190h.p193c.CancelException;
import com.bytedance.sdk.openadsdk.p190h.p193c.ContentLengthNotMatchException;
import com.bytedance.sdk.openadsdk.p190h.p193c.RequestException;
import com.bytedance.sdk.openadsdk.p190h.p193c.SocketWriteException;
import com.bytedance.sdk.openadsdk.p190h.p195e.AbsResponseWrapper;
import com.bytedance.sdk.openadsdk.p190h.p197g.C2479d;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

/* renamed from: com.bytedance.sdk.openadsdk.h.g */
class ProxyTask extends AbsTask {
    /* renamed from: m */
    private final Socket f8893m;
    /* renamed from: n */
    private final C2478c f8894n;
    /* access modifiers changed from: private|final */
    /* renamed from: o */
    public final Preloader f8895o;
    /* renamed from: p */
    private volatile DownloadTask f8896p;
    /* renamed from: q */
    private volatile boolean f8897q = true;

    /* compiled from: ProxyTask */
    /* renamed from: com.bytedance.sdk.openadsdk.h.g$a */
    static final class C2476a {
        /* renamed from: a */
        C2440a f8901a;
        /* renamed from: b */
        VideoProxyDB f8902b;
        /* renamed from: c */
        Socket f8903c;
        /* renamed from: d */
        C2478c f8904d;

        C2476a() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C2476a mo16777a(VideoProxyDB cVar) {
            if (cVar != null) {
                this.f8902b = cVar;
                return this;
            }
            throw new IllegalArgumentException("db == null");
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C2476a mo16779a(Socket socket) {
            if (socket != null) {
                this.f8903c = socket;
                return this;
            }
            throw new IllegalArgumentException("socket == null");
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C2476a mo16778a(C2478c cVar) {
            this.f8904d = cVar;
            return this;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public ProxyTask mo16780a() {
            if (this.f8902b != null && this.f8903c != null) {
                return new ProxyTask(this);
            }
            throw new IllegalArgumentException();
        }
    }

    /* compiled from: ProxyTask */
    /* renamed from: com.bytedance.sdk.openadsdk.h.g$b */
    private static class C2477b {
        /* renamed from: a */
        private final OutputStream f8905a;
        /* renamed from: b */
        private int f8906b;
        /* renamed from: c */
        private boolean f8907c;

        C2477b(OutputStream outputStream, int i) {
            this.f8905a = outputStream;
            this.f8906b = i;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo16782a() {
            return this.f8907c;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo16781a(byte[] bArr, int i, int i2) throws SocketWriteException {
            if (!this.f8907c) {
                try {
                    this.f8905a.write(bArr, i, i2);
                    this.f8907c = true;
                } catch (IOException e) {
                    throw new SocketWriteException(e);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo16784b(byte[] bArr, int i, int i2) throws SocketWriteException {
            try {
                this.f8905a.write(bArr, i, i2);
                this.f8906b += i2;
            } catch (IOException e) {
                throw new SocketWriteException(e);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public int mo16783b() {
            return this.f8906b;
        }
    }

    /* compiled from: ProxyTask */
    /* renamed from: com.bytedance.sdk.openadsdk.h.g$c */
    public interface C2478c {
        /* renamed from: a */
        void mo16760a(ProxyTask gVar);

        /* renamed from: b */
        void mo16761b(ProxyTask gVar);
    }

    /* renamed from: a */
    private void m11618a(boolean z, int i, int i2, int i3, int i4) {
    }

    ProxyTask(C2476a aVar) {
        super(aVar.f8901a, aVar.f8902b);
        this.f8893m = aVar.f8903c;
        this.f8894n = aVar.f8904d;
        this.f8895o = Preloader.m11521c();
    }

    /* renamed from: h */
    private C2477b m11624h() {
        String str = "TAG_PROXY_ProxyTask";
        try {
            this.f8743i = C2482i.m11679a(this.f8893m.getInputStream());
            OutputStream outputStream = this.f8893m.getOutputStream();
            C2440a aVar = this.f8743i.f8923c.f8924a == 1 ? Proxy.f8834a : Proxy.f8835b;
            if (aVar == null) {
                if (Proxy.f8836c) {
                    Log.e(str, "cache is null");
                }
                return null;
            }
            this.f8735a = aVar;
            this.f8741g = this.f8743i.f8923c.f8925b;
            this.f8742h = this.f8743i.f8923c.f8926c;
            this.f8744j = new Urls(this.f8743i.f8923c.f8930g);
            this.f8740f = this.f8743i.f8922b;
            if (Proxy.f8836c) {
                StringBuilder sb = new StringBuilder();
                sb.append("request from MediaPlayer:    ");
                sb.append(this.f8743i.toString());
                Log.i(str, sb.toString());
            }
            return new C2477b(outputStream, this.f8743i.f8923c.f8927d);
        } catch (IOException e) {
            C2479d.m11666a(this.f8893m);
            if (Proxy.f8836c) {
                Log.e(str, Log.getStackTraceString(e));
            }
            mo16664a(this.f8735a == null ? null : Boolean.valueOf(mo16670g()), this.f8741g, e);
            return null;
        } catch (C2486d e2) {
            C2479d.m11666a(this.f8893m);
            if (Proxy.f8836c) {
                Log.e(str, Log.getStackTraceString(e2));
            }
            mo16664a(this.f8735a == null ? null : Boolean.valueOf(mo16670g()), this.f8741g, e2);
            return null;
        }
    }

    public void run() {
        String str = "TAG_PROXY_ProxyTask";
        C2477b h = m11624h();
        if (h != null) {
            C2478c cVar = this.f8894n;
            if (cVar != null) {
                cVar.mo16760a(this);
            }
            this.f8735a.mo16672a(this.f8742h);
            if (Proxy.f8841h != 0) {
                VideoHttpHeaderInfo a = this.f8736b.mo16710a(this.f8742h, this.f8743i.f8923c.f8924a);
                if (a == null || this.f8735a.mo16674c(this.f8742h).length() < ((long) a.f8790c)) {
                    this.f8895o.mo16725a(mo16670g(), this.f8742h);
                }
            }
            try {
                m11619a(h);
            } catch (CancelException e) {
                if (Proxy.f8836c) {
                    Log.e(str, Log.getStackTraceString(e));
                }
            } catch (VAdError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                if (Proxy.f8836c) {
                    Log.e(str, Log.getStackTraceString(th));
                }
            }
            this.f8735a.mo16673b(this.f8742h);
            this.f8895o.mo16725a(mo16670g(), null);
            mo16662a();
            C2479d.m11666a(this.f8893m);
            C2478c cVar2 = this.f8894n;
            if (cVar2 != null) {
                cVar2.mo16761b(this);
            }
        }
    }

    /* renamed from: a */
    private boolean m11619a(C2477b bVar) throws CancelException, VAdError {
        String str = "TAG_PROXY_ProxyTask";
        while (this.f8744j.mo16797a()) {
            mo16668e();
            C2488a b = this.f8744j.mo16798b();
            try {
                m11617a(bVar, b);
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
            } catch (SocketWriteException e3) {
                if (Proxy.f8836c) {
                    Log.e(str, Log.getStackTraceString(e3));
                }
                return true;
            } catch (C2481a e4) {
                if (Proxy.f8836c) {
                    Log.e(str, Log.getStackTraceString(e4));
                }
                this.f8897q = false;
                mo16664a(Boolean.valueOf(mo16670g()), this.f8741g, e4);
            } catch (ContentLengthNotMatchException e5) {
                if (Proxy.f8836c) {
                    Log.e(str, Log.getStackTraceString(e5));
                }
                return false;
            } catch (AuthFailureError e6) {
                if (Proxy.f8836c) {
                    Log.e(str, Log.getStackTraceString(e6));
                }
            } catch (Exception e7) {
                if (Proxy.f8836c) {
                    Log.e(str, Log.getStackTraceString(e7));
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m11617a(C2477b bVar, C2488a aVar) throws SocketWriteException, IOException, C2481a, CancelException, ContentLengthNotMatchException, VAdError {
        if ("HEAD".equalsIgnoreCase(this.f8743i.f8921a.f8933a)) {
            m11621b(bVar, aVar);
        } else {
            m11622c(bVar, aVar);
        }
    }

    /* renamed from: b */
    private void m11621b(C2477b bVar, C2488a aVar) throws IOException, SocketWriteException, VAdError {
        byte[] a = m11620a(this.f8736b.mo16710a(this.f8742h, this.f8743i.f8923c.f8924a), bVar, aVar);
        if (a != null) {
            bVar.mo16781a(a, 0, a.length);
        }
    }

    /* renamed from: c */
    private void m11622c(C2477b bVar, C2488a aVar) throws C2481a, SocketWriteException, IOException, CancelException, ContentLengthNotMatchException, VAdError {
        int i;
        if (this.f8897q) {
            File c = this.f8735a.mo16674c(this.f8742h);
            long length = c.length();
            VideoHttpHeaderInfo a = this.f8736b.mo16710a(this.f8742h, this.f8743i.f8923c.f8924a);
            int b = bVar.mo16783b();
            long j = length - ((long) b);
            int i2 = (int) j;
            if (a == null) {
                i = -1;
            } else {
                i = a.f8790c;
            }
            if (length > ((long) bVar.mo16783b())) {
                if (Proxy.f8836c) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("cache hit, remainSize: ");
                    sb.append(j);
                    Log.i("TAG_PROXY_ProxyTask", sb.toString());
                }
                m11618a(true, i2, i, (int) length, b);
                m11616a(a, c, bVar, aVar);
                return;
            }
            m11618a(false, i2, i, (int) length, b);
        } else {
            m11618a(false, 0, 0, 0, bVar.mo16783b());
        }
        m11623d(bVar, aVar);
    }

    /* renamed from: a */
    private byte[] m11620a(VideoHttpHeaderInfo aVar, C2477b bVar, C2488a aVar2) throws IOException, VAdError {
        String str = "TAG_PROXY_ProxyTask";
        if (aVar != null) {
            if (Proxy.f8836c) {
                Log.i(str, "get header from db");
            }
            return C2479d.m11656a(aVar, bVar.mo16783b()).getBytes(C2479d.f8916a);
        }
        AbsResponseWrapper a = mo16661a(aVar2, 0, -1, "HEAD");
        if (a == null) {
            return null;
        }
        try {
            String a2 = C2479d.m11658a(a, false, false);
            if (a2 == null) {
                VideoHttpHeaderInfo a3 = C2479d.m11654a(a, this.f8736b, this.f8742h, this.f8743i.f8923c.f8924a);
                if (Proxy.f8836c) {
                    Log.w(str, "get header from network");
                }
                return C2479d.m11656a(a3, bVar.mo16783b()).getBytes(C2479d.f8916a);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(a2);
            sb.append(", rawKey: ");
            sb.append(this.f8741g);
            sb.append(", url: ");
            sb.append(aVar2);
            throw new RequestException(sb.toString());
        } finally {
            C2479d.m11662a((Closeable) a.mo16747d());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0102 A[Catch:{ all -> 0x01c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x010f A[Catch:{ all -> 0x01c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0117 A[Catch:{ all -> 0x01c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0191 A[Catch:{ all -> 0x01c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01bb A[SYNTHETIC, Splitter:B:82:0x01bb] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01cf A[SYNTHETIC, Splitter:B:93:0x01cf] */
    /* renamed from: a */
    private void m11616a(com.bytedance.sdk.openadsdk.p190h.p192b.VideoHttpHeaderInfo r8, java.io.File r9, com.bytedance.sdk.openadsdk.p190h.ProxyTask.C2477b r10, com.bytedance.sdk.openadsdk.p190h.Urls.C2488a r11) throws java.io.IOException, com.bytedance.sdk.openadsdk.p190h.p193c.SocketWriteException, com.bytedance.sdk.openadsdk.p190h.RandomAccessFileWrapper.C2481a, com.bytedance.sdk.openadsdk.p190h.p193c.CancelException, com.bytedance.sdk.openadsdk.p190h.p193c.ContentLengthNotMatchException, com.bytedance.sdk.adnet.err.VAdError {
        /*
        r7 = this;
        boolean r0 = r10.mo16782a()
        r1 = 0
        if (r0 != 0) goto L_0x0015
        byte[] r0 = r7.m11620a(r8, r10, r11)
        r7.mo16668e()
        if (r0 != 0) goto L_0x0011
        return
    L_0x0011:
        int r2 = r0.length
        r10.mo16781a(r0, r1, r2)
    L_0x0015:
        r0 = 0
        if (r8 != 0) goto L_0x0068
        com.bytedance.sdk.openadsdk.h.b.c r8 = r7.f8736b
        java.lang.String r2 = r7.f8742h
        com.bytedance.sdk.openadsdk.h.i r3 = r7.f8743i
        com.bytedance.sdk.openadsdk.h.i$a r3 = r3.f8923c
        int r3 = r3.f8924a
        com.bytedance.sdk.openadsdk.h.b.a r8 = r8.mo16710a(r2, r3)
        if (r8 != 0) goto L_0x0068
        boolean r8 = com.bytedance.sdk.openadsdk.p190h.Proxy.f8836c
        if (r8 == 0) goto L_0x0033
        java.lang.String r8 = "TAG_PROXY_ProxyTask"
        java.lang.String r2 = "failed to get video header info from db"
        android.util.Log.e(r8, r2)
    L_0x0033:
        r7.m11620a(r0, r10, r11)
        com.bytedance.sdk.openadsdk.h.b.c r8 = r7.f8736b
        java.lang.String r2 = r7.f8742h
        com.bytedance.sdk.openadsdk.h.i r3 = r7.f8743i
        com.bytedance.sdk.openadsdk.h.i$a r3 = r3.f8923c
        int r3 = r3.f8924a
        com.bytedance.sdk.openadsdk.h.b.a r8 = r8.mo16710a(r2, r3)
        if (r8 == 0) goto L_0x0047
        goto L_0x0068
    L_0x0047:
        com.bytedance.sdk.openadsdk.h.c.c r8 = new com.bytedance.sdk.openadsdk.h.c.c
        java.lang.StringBuilder r9 = new java.lang.StringBuilder
        r9.<init>()
        java.lang.String r10 = "failed to get header, rawKey: "
        r9.append(r10)
        java.lang.String r10 = r7.f8741g
        r9.append(r10)
        java.lang.String r10 = ", url: "
        r9.append(r10)
        r9.append(r11)
        java.lang.String r9 = r9.toString()
        r8.m44065init(r9)
        throw r8
    L_0x0068:
        long r2 = r9.length()
        int r4 = r8.f8790c
        long r4 = (long) r4
        int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
        if (r6 >= 0) goto L_0x00e6
        com.bytedance.sdk.openadsdk.h.b r2 = r7.f8896p
        if (r2 == 0) goto L_0x0083
        boolean r3 = r2.mo16665b()
        if (r3 != 0) goto L_0x0083
        boolean r2 = r2.mo16667d()
        if (r2 == 0) goto L_0x00e6
    L_0x0083:
        com.bytedance.sdk.openadsdk.h.b$a r2 = new com.bytedance.sdk.openadsdk.h.b$a
        r2.m44057init()
        com.bytedance.sdk.openadsdk.h.a.a r3 = r7.f8735a
        com.bytedance.sdk.openadsdk.h.b$a r2 = r2.mo16699a(r3)
        com.bytedance.sdk.openadsdk.h.b.c r3 = r7.f8736b
        com.bytedance.sdk.openadsdk.h.b$a r2 = r2.mo16701a(r3)
        java.lang.String r3 = r7.f8741g
        com.bytedance.sdk.openadsdk.h.b$a r2 = r2.mo16705a(r3)
        java.lang.String r3 = r7.f8742h
        com.bytedance.sdk.openadsdk.h.b$a r2 = r2.mo16708b(r3)
        com.bytedance.sdk.openadsdk.h.l r3 = new com.bytedance.sdk.openadsdk.h.l
        java.lang.String r4 = r11.f8947a
        r3.m44119init(r4)
        com.bytedance.sdk.openadsdk.h.b$a r2 = r2.mo16703a(r3)
        java.util.List r3 = r7.f8740f
        com.bytedance.sdk.openadsdk.h.b$a r2 = r2.mo16706a(r3)
        com.bytedance.sdk.openadsdk.h.i r3 = r7.f8743i
        com.bytedance.sdk.openadsdk.h.b$a r2 = r2.mo16702a(r3)
        com.bytedance.sdk.openadsdk.h.g$1 r3 = new com.bytedance.sdk.openadsdk.h.g$1
        r3.m44100init()
        com.bytedance.sdk.openadsdk.h.b$a r2 = r2.mo16700a(r3)
        com.bytedance.sdk.openadsdk.h.b r2 = r2.mo16707a()
        r7.f8896p = r2
        com.bytedance.sdk.openadsdk.i.b r3 = new com.bytedance.sdk.openadsdk.i.b
        r4 = 10
        r5 = 1
        r3.m44128init(r2, r0, r4, r5)
        com.bytedance.sdk.openadsdk.i.a r2 = com.bytedance.sdk.openadsdk.p198i.TTExecutor.m11692a()
        com.bytedance.sdk.openadsdk.h.g$2 r4 = new com.bytedance.sdk.openadsdk.h.g$2
        r4.m44101init(r3)
        r2.mo16803a(r4)
        boolean r2 = com.bytedance.sdk.openadsdk.p190h.Proxy.f8836c
        if (r2 == 0) goto L_0x00e7
        java.lang.String r2 = "TAG_PROXY_ProxyTask"
        java.lang.String r4 = "fire download in process cache task"
        android.util.Log.e(r2, r4)
        goto L_0x00e7
    L_0x00e6:
        r3 = r0
    L_0x00e7:
        r2 = 8192(0x2000, float:1.14794E-41)
        byte[] r2 = new byte[r2]
        com.bytedance.sdk.openadsdk.h.h r4 = new com.bytedance.sdk.openadsdk.h.h     // Catch:{ all -> 0x01c6 }
        java.lang.String r5 = "r"
        r4.m44109init(r9, r5)     // Catch:{ all -> 0x01c6 }
        int r9 = r10.mo16783b()     // Catch:{ all -> 0x01c4 }
        long r5 = (long) r9     // Catch:{ all -> 0x01c4 }
        r4.mo16789a(r5)     // Catch:{ all -> 0x01c4 }
        com.bytedance.sdk.openadsdk.h.i r9 = r7.f8743i     // Catch:{ all -> 0x01c4 }
        com.bytedance.sdk.openadsdk.h.i$a r9 = r9.f8923c     // Catch:{ all -> 0x01c4 }
        int r9 = r9.f8928e     // Catch:{ all -> 0x01c4 }
        if (r9 <= 0) goto L_0x010f
        int r8 = r8.f8790c     // Catch:{ all -> 0x01c4 }
        com.bytedance.sdk.openadsdk.h.i r9 = r7.f8743i     // Catch:{ all -> 0x01c4 }
        com.bytedance.sdk.openadsdk.h.i$a r9 = r9.f8923c     // Catch:{ all -> 0x01c4 }
        int r9 = r9.f8928e     // Catch:{ all -> 0x01c4 }
        int r8 = java.lang.Math.min(r8, r9)     // Catch:{ all -> 0x01c4 }
        goto L_0x0111
    L_0x010f:
        int r8 = r8.f8790c     // Catch:{ all -> 0x01c4 }
    L_0x0111:
        int r9 = r10.mo16783b()     // Catch:{ all -> 0x01c4 }
        if (r9 >= r8) goto L_0x018d
        r7.mo16668e()     // Catch:{ all -> 0x01c4 }
        int r9 = r4.mo16787a(r2)     // Catch:{ all -> 0x01c4 }
        if (r9 > 0) goto L_0x0186
        com.bytedance.sdk.openadsdk.h.b r9 = r7.f8896p     // Catch:{ all -> 0x01c4 }
        if (r9 == 0) goto L_0x0133
        com.bytedance.sdk.openadsdk.h.c.b r0 = r9.mo16696i()     // Catch:{ all -> 0x01c4 }
        if (r0 != 0) goto L_0x0132
        com.bytedance.sdk.openadsdk.h.h$a r0 = r9.mo16695h()     // Catch:{ all -> 0x01c4 }
        if (r0 != 0) goto L_0x0131
        goto L_0x0133
    L_0x0131:
        throw r0     // Catch:{ all -> 0x01c4 }
    L_0x0132:
        throw r0     // Catch:{ all -> 0x01c4 }
    L_0x0133:
        if (r9 == 0) goto L_0x015a
        boolean r0 = r9.mo16665b()     // Catch:{ all -> 0x01c4 }
        if (r0 != 0) goto L_0x015a
        boolean r0 = r9.mo16667d()     // Catch:{ all -> 0x01c4 }
        if (r0 == 0) goto L_0x0142
        goto L_0x015a
    L_0x0142:
        r7.mo16668e()     // Catch:{ all -> 0x01c4 }
        java.lang.Object r0 = r9.f8772m     // Catch:{ all -> 0x01c4 }
        monitor-enter(r0)     // Catch:{ all -> 0x01c4 }
        java.lang.Object r9 = r9.f8772m     // Catch:{ InterruptedException -> 0x0152 }
        r5 = 1000(0x3e8, double:4.94E-321)
        r9.wait(r5)     // Catch:{ InterruptedException -> 0x0152 }
        goto L_0x0156
    L_0x0150:
        r8 = move-exception
        goto L_0x0158
    L_0x0152:
        r9 = move-exception
        r9.printStackTrace()     // Catch:{ all -> 0x0150 }
    L_0x0156:
        monitor-exit(r0)     // Catch:{ all -> 0x0150 }
        goto L_0x0189
    L_0x0158:
        monitor-exit(r0)     // Catch:{ all -> 0x0150 }
        throw r8     // Catch:{ all -> 0x01c4 }
    L_0x015a:
        boolean r8 = com.bytedance.sdk.openadsdk.p190h.Proxy.f8836c     // Catch:{ all -> 0x01c4 }
        if (r8 == 0) goto L_0x0165
        java.lang.String r8 = "TAG_PROXY_ProxyTask"
        java.lang.String r9 = "download task has finished!!!"
        android.util.Log.e(r8, r9)     // Catch:{ all -> 0x01c4 }
    L_0x0165:
        com.bytedance.sdk.openadsdk.h.c.c r8 = new com.bytedance.sdk.openadsdk.h.c.c     // Catch:{ all -> 0x01c4 }
        java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c4 }
        r9.<init>()     // Catch:{ all -> 0x01c4 }
        java.lang.String r10 = "illegal state download task has finished, rawKey: "
        r9.append(r10)     // Catch:{ all -> 0x01c4 }
        java.lang.String r10 = r7.f8741g     // Catch:{ all -> 0x01c4 }
        r9.append(r10)     // Catch:{ all -> 0x01c4 }
        java.lang.String r10 = ", url: "
        r9.append(r10)     // Catch:{ all -> 0x01c4 }
        r9.append(r11)     // Catch:{ all -> 0x01c4 }
        java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x01c4 }
        r8.m44065init(r9)     // Catch:{ all -> 0x01c4 }
        throw r8     // Catch:{ all -> 0x01c4 }
    L_0x0186:
        r10.mo16784b(r2, r1, r9)     // Catch:{ all -> 0x01c4 }
    L_0x0189:
        r7.mo16668e()     // Catch:{ all -> 0x01c4 }
        goto L_0x0111
    L_0x018d:
        boolean r9 = com.bytedance.sdk.openadsdk.p190h.Proxy.f8836c     // Catch:{ all -> 0x01c4 }
        if (r9 == 0) goto L_0x01b3
        java.lang.String r9 = "TAG_PROXY_ProxyTask"
        java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c4 }
        r11.<init>()     // Catch:{ all -> 0x01c4 }
        java.lang.String r0 = "read cache file complete: "
        r11.append(r0)     // Catch:{ all -> 0x01c4 }
        int r10 = r10.mo16783b()     // Catch:{ all -> 0x01c4 }
        r11.append(r10)     // Catch:{ all -> 0x01c4 }
        java.lang.String r10 = ", "
        r11.append(r10)     // Catch:{ all -> 0x01c4 }
        r11.append(r8)     // Catch:{ all -> 0x01c4 }
        java.lang.String r8 = r11.toString()     // Catch:{ all -> 0x01c4 }
        android.util.Log.i(r9, r8)     // Catch:{ all -> 0x01c4 }
    L_0x01b3:
        r7.mo16666c()     // Catch:{ all -> 0x01c4 }
        r4.mo16788a()
        if (r3 == 0) goto L_0x01c3
        r3.get()     // Catch:{ all -> 0x01bf }
        goto L_0x01c3
    L_0x01bf:
        r8 = move-exception
        r8.printStackTrace()
    L_0x01c3:
        return
    L_0x01c4:
        r8 = move-exception
        goto L_0x01c8
    L_0x01c6:
        r8 = move-exception
        r4 = r0
    L_0x01c8:
        if (r4 == 0) goto L_0x01cd
        r4.mo16788a()
    L_0x01cd:
        if (r3 == 0) goto L_0x01d7
        r3.get()     // Catch:{ all -> 0x01d3 }
        goto L_0x01d7
    L_0x01d3:
        r9 = move-exception
        r9.printStackTrace()
    L_0x01d7:
        throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.p190h.ProxyTask.m11616a(com.bytedance.sdk.openadsdk.h.b.a, java.io.File, com.bytedance.sdk.openadsdk.h.g$b, com.bytedance.sdk.openadsdk.h.l$a):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x01af A[EDGE_INSN: B:100:0x01af->B:78:0x01af ?: BREAK  
EDGE_INSN: B:100:0x01af->B:78:0x01af ?: BREAK  
EDGE_INSN: B:100:0x01af->B:78:0x01af ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x01af A[EDGE_INSN: B:100:0x01af->B:78:0x01af ?: BREAK  
EDGE_INSN: B:100:0x01af->B:78:0x01af ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0104 A[Catch:{ all -> 0x01db }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x015c A[Catch:{ all -> 0x01db }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x015e A[Catch:{ all -> 0x01db }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0170 A[Catch:{ all -> 0x017f, all -> 0x01d7, all -> 0x01a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01b3 A[Catch:{ all -> 0x017f, all -> 0x01d7, all -> 0x01a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x020a  */
    /* renamed from: d */
    private void m11623d(com.bytedance.sdk.openadsdk.p190h.ProxyTask.C2477b r13, com.bytedance.sdk.openadsdk.p190h.Urls.C2488a r14) throws com.bytedance.sdk.openadsdk.p190h.p193c.SocketWriteException, java.io.IOException, com.bytedance.sdk.openadsdk.p190h.p193c.CancelException, com.bytedance.sdk.openadsdk.p190h.p193c.ContentLengthNotMatchException, com.bytedance.sdk.adnet.err.VAdError {
        /*
        r12 = this;
        r12.m11625i()
        long r0 = android.os.SystemClock.elapsedRealtime()
        int r2 = r13.mo16783b()
        com.bytedance.sdk.openadsdk.h.i r3 = r12.f8743i
        com.bytedance.sdk.openadsdk.h.i$a r3 = r3.f8923c
        int r3 = r3.f8928e
        java.lang.String r4 = "GET"
        com.bytedance.sdk.openadsdk.h.e.a r3 = r12.mo16661a(r14, r2, r3, r4)
        if (r3 != 0) goto L_0x001a
        return
    L_0x001a:
        r4 = 1
        r5 = 0
        r6 = 0
        java.lang.String r4 = com.bytedance.sdk.openadsdk.p190h.p197g.C2479d.m11658a(r3, r6, r4)     // Catch:{ all -> 0x0200 }
        java.lang.String r7 = ", rawKey: "
        if (r4 != 0) goto L_0x01de
        com.bytedance.sdk.openadsdk.h.b.c r4 = r12.f8736b     // Catch:{ all -> 0x0200 }
        java.lang.String r8 = r12.f8742h     // Catch:{ all -> 0x0200 }
        int r9 = r12.mo16669f()     // Catch:{ all -> 0x0200 }
        com.bytedance.sdk.openadsdk.h.b.a r4 = r4.mo16710a(r8, r9)     // Catch:{ all -> 0x0200 }
        int r8 = com.bytedance.sdk.openadsdk.p190h.p197g.C2479d.m11652a(r3)     // Catch:{ all -> 0x0200 }
        java.lang.String r9 = "TAG_PROXY_ProxyTask"
        if (r4 == 0) goto L_0x00a4
        int r10 = r4.f8790c     // Catch:{ all -> 0x0200 }
        if (r10 == r8) goto L_0x00a4
        boolean r13 = com.bytedance.sdk.openadsdk.p190h.Proxy.f8836c     // Catch:{ all -> 0x0200 }
        if (r13 == 0) goto L_0x0069
        java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0200 }
        r13.<init>()     // Catch:{ all -> 0x0200 }
        java.lang.String r2 = "Content-Length not match, old: "
        r13.append(r2)     // Catch:{ all -> 0x0200 }
        int r2 = r4.f8790c     // Catch:{ all -> 0x0200 }
        r13.append(r2)     // Catch:{ all -> 0x0200 }
        java.lang.String r2 = ", "
        r13.append(r2)     // Catch:{ all -> 0x0200 }
        r13.append(r8)     // Catch:{ all -> 0x0200 }
        java.lang.String r2 = ", key: "
        r13.append(r2)     // Catch:{ all -> 0x0200 }
        java.lang.String r2 = r12.f8742h     // Catch:{ all -> 0x0200 }
        r13.append(r2)     // Catch:{ all -> 0x0200 }
        java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x0200 }
        android.util.Log.e(r9, r13)     // Catch:{ all -> 0x0200 }
    L_0x0069:
        com.bytedance.sdk.openadsdk.h.c.b r13 = new com.bytedance.sdk.openadsdk.h.c.b     // Catch:{ all -> 0x0200 }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0200 }
        r2.<init>()     // Catch:{ all -> 0x0200 }
        java.lang.String r9 = "Content-Length not match, old length: "
        r2.append(r9)     // Catch:{ all -> 0x0200 }
        int r9 = r4.f8790c     // Catch:{ all -> 0x0200 }
        r2.append(r9)     // Catch:{ all -> 0x0200 }
        java.lang.String r9 = ", new length: "
        r2.append(r9)     // Catch:{ all -> 0x0200 }
        r2.append(r8)     // Catch:{ all -> 0x0200 }
        r2.append(r7)     // Catch:{ all -> 0x0200 }
        java.lang.String r7 = r12.f8741g     // Catch:{ all -> 0x0200 }
        r2.append(r7)     // Catch:{ all -> 0x0200 }
        java.lang.String r7 = ", currentUrl: "
        r2.append(r7)     // Catch:{ all -> 0x0200 }
        r2.append(r14)     // Catch:{ all -> 0x0200 }
        java.lang.String r14 = ", previousInfo: "
        r2.append(r14)     // Catch:{ all -> 0x0200 }
        java.lang.String r14 = r4.f8792e     // Catch:{ all -> 0x0200 }
        r2.append(r14)     // Catch:{ all -> 0x0200 }
        java.lang.String r14 = r2.toString()     // Catch:{ all -> 0x0200 }
        r13.m44064init(r14)     // Catch:{ all -> 0x0200 }
        throw r13     // Catch:{ all -> 0x0200 }
    L_0x00a4:
        boolean r14 = r13.mo16782a()     // Catch:{ all -> 0x0200 }
        if (r14 != 0) goto L_0x00bb
        java.lang.String r14 = com.bytedance.sdk.openadsdk.p190h.p197g.C2479d.m11657a(r3, r2)     // Catch:{ all -> 0x0200 }
        r12.mo16668e()     // Catch:{ all -> 0x0200 }
        java.nio.charset.Charset r2 = com.bytedance.sdk.openadsdk.p190h.p197g.C2479d.f8916a     // Catch:{ all -> 0x0200 }
        byte[] r14 = r14.getBytes(r2)     // Catch:{ all -> 0x0200 }
        int r2 = r14.length     // Catch:{ all -> 0x0200 }
        r13.mo16781a(r14, r6, r2)     // Catch:{ all -> 0x0200 }
    L_0x00bb:
        r12.mo16668e()     // Catch:{ all -> 0x0200 }
        com.bytedance.sdk.openadsdk.h.a.a r14 = r12.f8735a     // Catch:{ all -> 0x0200 }
        java.lang.String r2 = r12.f8742h     // Catch:{ all -> 0x0200 }
        java.io.File r14 = r14.mo16675d(r2)     // Catch:{ all -> 0x0200 }
        boolean r2 = r12.f8897q     // Catch:{ all -> 0x0200 }
        java.lang.String r4 = ", from: "
        if (r2 == 0) goto L_0x0127
        if (r14 == 0) goto L_0x0127
        long r7 = r14.length()     // Catch:{ all -> 0x0200 }
        int r2 = r13.mo16783b()     // Catch:{ all -> 0x0200 }
        long r10 = (long) r2     // Catch:{ all -> 0x0200 }
        int r2 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
        if (r2 < 0) goto L_0x0127
        com.bytedance.sdk.openadsdk.h.b.c r2 = r12.f8736b     // Catch:{ all -> 0x0200 }
        java.lang.String r7 = r12.f8742h     // Catch:{ all -> 0x0200 }
        com.bytedance.sdk.openadsdk.h.i r8 = r12.f8743i     // Catch:{ all -> 0x0200 }
        com.bytedance.sdk.openadsdk.h.i$a r8 = r8.f8923c     // Catch:{ all -> 0x0200 }
        int r8 = r8.f8924a     // Catch:{ all -> 0x0200 }
        com.bytedance.sdk.openadsdk.p190h.p197g.C2479d.m11654a(r3, r2, r7, r8)     // Catch:{ all -> 0x0200 }
        com.bytedance.sdk.openadsdk.h.h r2 = new com.bytedance.sdk.openadsdk.h.h     // Catch:{ a -> 0x00fa }
        java.lang.String r7 = "rwd"
        r2.m44109init(r14, r7)     // Catch:{ a -> 0x00fa }
        int r7 = r13.mo16783b()     // Catch:{ a -> 0x00f8 }
        long r7 = (long) r7     // Catch:{ a -> 0x00f8 }
        r2.mo16789a(r7)     // Catch:{ a -> 0x00f8 }
        goto L_0x0100
    L_0x00f8:
        r7 = move-exception
        goto L_0x00fc
    L_0x00fa:
        r7 = move-exception
        r2 = r5
    L_0x00fc:
        r7.printStackTrace()     // Catch:{ all -> 0x01db }
        r2 = r5
    L_0x0100:
        boolean r7 = com.bytedance.sdk.openadsdk.p190h.Proxy.f8836c     // Catch:{ all -> 0x01db }
        if (r7 == 0) goto L_0x014e
        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x01db }
        r7.<init>()     // Catch:{ all -> 0x01db }
        java.lang.String r8 = "can write to cache file in network task, cache file size: "
        r7.append(r8)     // Catch:{ all -> 0x01db }
        long r10 = r14.length()     // Catch:{ all -> 0x01db }
        r7.append(r10)     // Catch:{ all -> 0x01db }
        r7.append(r4)     // Catch:{ all -> 0x01db }
        int r14 = r13.mo16783b()     // Catch:{ all -> 0x01db }
        r7.append(r14)     // Catch:{ all -> 0x01db }
        java.lang.String r14 = r7.toString()     // Catch:{ all -> 0x01db }
        android.util.Log.i(r9, r14)     // Catch:{ all -> 0x01db }
        goto L_0x014e
    L_0x0127:
        boolean r2 = com.bytedance.sdk.openadsdk.p190h.Proxy.f8836c     // Catch:{ all -> 0x0200 }
        if (r2 == 0) goto L_0x014d
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0200 }
        r2.<init>()     // Catch:{ all -> 0x0200 }
        java.lang.String r7 = "can't write to cache file in network task, cache file size: "
        r2.append(r7)     // Catch:{ all -> 0x0200 }
        long r7 = r14.length()     // Catch:{ all -> 0x0200 }
        r2.append(r7)     // Catch:{ all -> 0x0200 }
        r2.append(r4)     // Catch:{ all -> 0x0200 }
        int r14 = r13.mo16783b()     // Catch:{ all -> 0x0200 }
        r2.append(r14)     // Catch:{ all -> 0x0200 }
        java.lang.String r14 = r2.toString()     // Catch:{ all -> 0x0200 }
        android.util.Log.w(r9, r14)     // Catch:{ all -> 0x0200 }
    L_0x014d:
        r2 = r5
    L_0x014e:
        com.bytedance.sdk.openadsdk.h.b.c r14 = r12.f8736b     // Catch:{ all -> 0x01db }
        java.lang.String r4 = r12.f8742h     // Catch:{ all -> 0x01db }
        int r7 = r12.mo16669f()     // Catch:{ all -> 0x01db }
        com.bytedance.sdk.openadsdk.h.b.a r14 = r14.mo16710a(r4, r7)     // Catch:{ all -> 0x01db }
        if (r14 != 0) goto L_0x015e
        r14 = 0
        goto L_0x0160
    L_0x015e:
        int r14 = r14.f8790c     // Catch:{ all -> 0x01db }
    L_0x0160:
        r4 = 8192(0x2000, float:1.14794E-41)
        byte[] r4 = new byte[r4]     // Catch:{ all -> 0x01db }
        java.io.InputStream r7 = r3.mo16747d()     // Catch:{ all -> 0x01db }
        r8 = r2
        r2 = 0
    L_0x016a:
        int r10 = r7.read(r4)     // Catch:{ all -> 0x01d7 }
        if (r10 < 0) goto L_0x01af
        r12.mo16668e()     // Catch:{ all -> 0x01d7 }
        if (r10 <= 0) goto L_0x01ab
        r13.mo16784b(r4, r6, r10)     // Catch:{ all -> 0x01d7 }
        int r2 = r2 + r10
        if (r8 == 0) goto L_0x01a4
        r8.mo16790a(r4, r6, r10)     // Catch:{ all -> 0x017f }
        goto L_0x01a4
    L_0x017f:
        r10 = move-exception
        r8.mo16788a()     // Catch:{ all -> 0x01d7 }
        boolean r8 = com.bytedance.sdk.openadsdk.p190h.Proxy.f8836c     // Catch:{ all -> 0x01a1 }
        if (r8 == 0) goto L_0x019f
        java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a1 }
        r8.<init>()     // Catch:{ all -> 0x01a1 }
        java.lang.String r11 = "append to cache file error in network task!!! "
        r8.append(r11)     // Catch:{ all -> 0x01a1 }
        java.lang.String r10 = android.util.Log.getStackTraceString(r10)     // Catch:{ all -> 0x01a1 }
        r8.append(r10)     // Catch:{ all -> 0x01a1 }
        java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x01a1 }
        android.util.Log.e(r9, r8)     // Catch:{ all -> 0x01a1 }
    L_0x019f:
        r8 = r5
        goto L_0x01a4
    L_0x01a1:
        r13 = move-exception
        r6 = r2
        goto L_0x0201
    L_0x01a4:
        int r10 = r13.mo16783b()     // Catch:{ all -> 0x01d7 }
        r12.mo16663a(r14, r10)     // Catch:{ all -> 0x01d7 }
    L_0x01ab:
        r12.mo16668e()     // Catch:{ all -> 0x01d7 }
        goto L_0x016a
    L_0x01af:
        boolean r13 = com.bytedance.sdk.openadsdk.p190h.Proxy.f8836c     // Catch:{ all -> 0x01d7 }
        if (r13 == 0) goto L_0x01b8
        java.lang.String r13 = "read from net complete!"
        android.util.Log.i(r9, r13)     // Catch:{ all -> 0x01d7 }
    L_0x01b8:
        r12.mo16666c()     // Catch:{ all -> 0x01d7 }
        java.io.InputStream r13 = r3.mo16747d()
        com.bytedance.sdk.openadsdk.p190h.p197g.C2479d.m11662a(r13)
        if (r8 == 0) goto L_0x01c7
        r8.mo16788a()
    L_0x01c7:
        java.util.concurrent.atomic.AtomicInteger r13 = r12.f8737c
        r13.addAndGet(r2)
        java.util.concurrent.atomic.AtomicLong r13 = r12.f8738d
        long r2 = android.os.SystemClock.elapsedRealtime()
        long r2 = r2 - r0
        r13.addAndGet(r2)
        return
    L_0x01d7:
        r13 = move-exception
        r6 = r2
        r5 = r8
        goto L_0x0201
    L_0x01db:
        r13 = move-exception
        r5 = r2
        goto L_0x0201
    L_0x01de:
        com.bytedance.sdk.openadsdk.h.c.c r13 = new com.bytedance.sdk.openadsdk.h.c.c     // Catch:{ all -> 0x0200 }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0200 }
        r2.<init>()     // Catch:{ all -> 0x0200 }
        r2.append(r4)     // Catch:{ all -> 0x0200 }
        r2.append(r7)     // Catch:{ all -> 0x0200 }
        java.lang.String r4 = r12.f8741g     // Catch:{ all -> 0x0200 }
        r2.append(r4)     // Catch:{ all -> 0x0200 }
        java.lang.String r4 = ", url: "
        r2.append(r4)     // Catch:{ all -> 0x0200 }
        r2.append(r14)     // Catch:{ all -> 0x0200 }
        java.lang.String r14 = r2.toString()     // Catch:{ all -> 0x0200 }
        r13.m44065init(r14)     // Catch:{ all -> 0x0200 }
        throw r13     // Catch:{ all -> 0x0200 }
    L_0x0200:
        r13 = move-exception
    L_0x0201:
        java.io.InputStream r14 = r3.mo16747d()
        com.bytedance.sdk.openadsdk.p190h.p197g.C2479d.m11662a(r14)
        if (r5 == 0) goto L_0x020d
        r5.mo16788a()
    L_0x020d:
        java.util.concurrent.atomic.AtomicInteger r14 = r12.f8737c
        r14.addAndGet(r6)
        java.util.concurrent.atomic.AtomicLong r14 = r12.f8738d
        long r2 = android.os.SystemClock.elapsedRealtime()
        long r2 = r2 - r0
        r14.addAndGet(r2)
        throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.p190h.ProxyTask.m11623d(com.bytedance.sdk.openadsdk.h.g$b, com.bytedance.sdk.openadsdk.h.l$a):void");
    }

    /* renamed from: a */
    public void mo16662a() {
        super.mo16662a();
        m11625i();
    }

    /* renamed from: i */
    private void m11625i() {
        DownloadTask bVar = this.f8896p;
        this.f8896p = null;
        if (bVar != null) {
            bVar.mo16662a();
        }
    }
}
