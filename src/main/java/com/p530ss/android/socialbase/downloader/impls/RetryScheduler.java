package com.p530ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest.Builder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.p000v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.SparseArray;
import com.kwad.sdk.core.imageloader.core.download.BaseImageDownloader;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.p556a.AppStatusManager;
import com.p530ss.android.socialbase.downloader.p556a.AppStatusManager.C6638a;
import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.p530ss.android.socialbase.downloader.p560e.DownloadOutOfSpaceException;
import com.p530ss.android.socialbase.downloader.p561f.C6704a;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p567k.DownloadSetting;
import com.p530ss.android.socialbase.downloader.p569m.DownloadUtils;
import com.tencent.mid.sotrage.StorageInterface;
import java.util.ArrayList;
import org.json.JSONObject;

/* renamed from: com.ss.android.socialbase.downloader.impls.r */
public class RetryScheduler implements Callback, C6638a {
    /* renamed from: a */
    private static volatile RetryScheduler f22241a;
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final Context f22242b = C6694b.m27342B();
    /* renamed from: c */
    private final Handler f22243c = new Handler(Looper.getMainLooper(), this);
    /* access modifiers changed from: private|final */
    /* renamed from: d */
    public final SparseArray<C6742a> f22244d = new SparseArray<>();
    /* renamed from: e */
    private final boolean f22245e;
    /* renamed from: f */
    private long f22246f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public int f22247g = 0;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public ConnectivityManager f22248h;

    /* compiled from: RetryScheduler */
    /* renamed from: com.ss.android.socialbase.downloader.impls.r$a */
    private static class C6742a {
        /* renamed from: a */
        final int f22256a;
        /* renamed from: b */
        final int f22257b;
        /* renamed from: c */
        final int f22258c;
        /* renamed from: d */
        final int f22259d;
        /* renamed from: e */
        final int f22260e;
        /* renamed from: f */
        final boolean f22261f;
        /* renamed from: g */
        final int[] f22262g;
        /* renamed from: h */
        private int f22263h;
        /* access modifiers changed from: private */
        /* renamed from: i */
        public int f22264i;
        /* access modifiers changed from: private */
        /* renamed from: j */
        public boolean f22265j;
        /* renamed from: k */
        private long f22266k;
        /* access modifiers changed from: private */
        /* renamed from: l */
        public boolean f22267l;

        C6742a(int i, int i2, int i3, int i4, int i5, boolean z, int[] iArr) {
            if (i4 < 20000) {
                i4 = BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT;
            }
            if (i5 < 20000) {
                i5 = BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT;
            }
            this.f22256a = i;
            this.f22257b = i2;
            this.f22258c = i3;
            this.f22259d = i4;
            this.f22260e = i5;
            this.f22261f = z;
            this.f22262g = iArr;
            this.f22263h = i4;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo32538a(long j, int i, int i2, boolean z) {
            if (!this.f22267l) {
                C6704a.m27760c("RetryScheduler", "canRetry: mIsWaitingRetry is false, return false!!!");
                return false;
            } else if (this.f22257b < i || this.f22264i >= this.f22258c) {
                return false;
            } else {
                if (this.f22265j && i2 != 2) {
                    return false;
                }
                if (z || j - this.f22266k >= ((long) this.f22259d)) {
                    return true;
                }
                return false;
            }
        }

        /* access modifiers changed from: declared_synchronized */
        /* renamed from: a */
        public synchronized void mo32536a() {
            this.f22263h += this.f22260e;
        }

        /* access modifiers changed from: declared_synchronized */
        /* renamed from: a */
        public synchronized void mo32537a(long j) {
            this.f22266k = j;
        }

        /* access modifiers changed from: declared_synchronized */
        /* renamed from: b */
        public synchronized void mo32539b() {
            this.f22264i++;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo32540c() {
            this.f22263h = this.f22259d;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public int mo32541d() {
            return this.f22263h;
        }
    }

    private RetryScheduler() {
        m28571f();
        this.f22245e = DownloadUtils.m28801c();
        AppStatusManager.m26964a().mo31645a((C6638a) this);
    }

    /* renamed from: a */
    public static RetryScheduler m28554a() {
        if (f22241a == null) {
            synchronized (RetryScheduler.class) {
                if (f22241a == null) {
                    f22241a = new RetryScheduler();
                }
            }
        }
        return f22241a;
    }

    /* renamed from: f */
    private void m28571f() {
        if (DownloadSetting.m28617b().mo32547a("use_network_callback", 0) == 1) {
            C6694b.m27379k().execute(new Runnable() {
                public void run() {
                    try {
                        if (RetryScheduler.this.f22242b != null && VERSION.SDK_INT >= 21) {
                            RetryScheduler.this.f22248h = (ConnectivityManager) RetryScheduler.this.f22242b.getApplicationContext().getSystemService("connectivity");
                            RetryScheduler.this.f22248h.registerNetworkCallback(new Builder().build(), new NetworkCallback() {
                                public void onAvailable(Network network) {
                                    C6704a.m27758b("RetryScheduler", "network onAvailable: ");
                                    RetryScheduler.this.m28556a(1, true);
                                }
                            });
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void mo32528a(DownloadInfo cVar) {
        if (cVar != null) {
            if ("application/vnd.android.package-archive".contains(cVar.mo32231ah())) {
                m28557a(cVar, cVar.mo32317x(), m28572g());
            }
        }
    }

    /* renamed from: a */
    private void m28557a(DownloadInfo cVar, boolean z, int i) {
        BaseException aW = cVar.mo32220aW();
        if (aW != null) {
            C6742a b = m28564b(cVar.mo32283g());
            if (b.f22264i > b.f22258c) {
                StringBuilder sb = new StringBuilder();
                sb.append("tryStartScheduleRetry, id = ");
                sb.append(b.f22256a);
                sb.append(", mRetryCount = ");
                sb.append(b.f22264i);
                sb.append(", maxCount = ");
                sb.append(b.f22258c);
                C6704a.m27761d("RetryScheduler", sb.toString());
                return;
            }
            int a = aW.mo32073a();
            if (!DownloadUtils.m28817g((Throwable) aW) && !DownloadUtils.m28819h((Throwable) aW)) {
                if (m28561a(b, a)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("white error code, id = ");
                    sb2.append(b.f22256a);
                    sb2.append(", error code = ");
                    sb2.append(a);
                    C6704a.m27760c("RetryScheduler", sb2.toString());
                } else {
                    return;
                }
            }
            b.f22265j = z;
            synchronized (this.f22244d) {
                if (!b.f22267l) {
                    b.f22267l = true;
                    this.f22247g++;
                }
            }
            int d = b.mo32541d();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("tryStartScheduleRetry: id = ");
            sb3.append(b.f22256a);
            sb3.append(", delayTimeMills = ");
            sb3.append(d);
            sb3.append(", mWaitingRetryTasks = ");
            sb3.append(this.f22247g);
            C6704a.m27760c("RetryScheduler", sb3.toString());
            if (b.f22261f) {
                if (i == 0) {
                    b.mo32540c();
                }
                RetryJobSchedulerService.m28227a(cVar, (long) d, z, i);
                if (this.f22245e) {
                    b.mo32537a(System.currentTimeMillis());
                    b.mo32539b();
                    b.mo32536a();
                }
            } else if (!z) {
                this.f22243c.removeMessages(cVar.mo32283g());
                this.f22243c.sendEmptyMessageDelayed(cVar.mo32283g(), (long) d);
            }
        }
    }

    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            m28565b(message.arg1, message.arg2 == 1);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("handleMessage, doSchedulerRetry, id = ");
            sb.append(message.what);
            C6704a.m27760c("RetryScheduler", sb.toString());
            mo32527a(message.what);
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
            r0 = new java.lang.StringBuilder();
            r0.append("scheduleAllTaskRetry, level = [");
            r0.append(r8);
            r0.append("], force = [");
            r0.append(r9);
            r0.append("]");
            com.p530ss.android.socialbase.downloader.p561f.C6704a.m27760c("RetryScheduler", r0.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003f, code lost:
            if (r9 == false) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0041, code lost:
            r7.f22243c.removeMessages(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
            r1 = android.os.Message.obtain();
            r1.what = 0;
            r1.arg1 = r8;
            r1.arg2 = r9;
            r7.f22243c.sendMessageDelayed(r1, 2000);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0057, code lost:
            return;
     */
    /* renamed from: a */
    public void m28556a(int r8, boolean r9) {
        /*
        r7 = this;
        int r0 = r7.f22247g
        if (r0 > 0) goto L_0x0005
        return
    L_0x0005:
        long r0 = java.lang.System.currentTimeMillis()
        monitor-enter(r7)
        if (r9 != 0) goto L_0x0018
        long r2 = r7.f22246f     // Catch:{ all -> 0x0058 }
        long r2 = r0 - r2
        r4 = 20000(0x4e20, double:9.8813E-320)
        int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
        if (r6 >= 0) goto L_0x0018
        monitor-exit(r7)     // Catch:{ all -> 0x0058 }
        return
    L_0x0018:
        r7.f22246f = r0     // Catch:{ all -> 0x0058 }
        monitor-exit(r7)     // Catch:{ all -> 0x0058 }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = "scheduleAllTaskRetry, level = ["
        r0.append(r1)
        r0.append(r8)
        java.lang.String r1 = "], force = ["
        r0.append(r1)
        r0.append(r9)
        java.lang.String r1 = "]"
        r0.append(r1)
        java.lang.String r0 = r0.toString()
        java.lang.String r1 = "RetryScheduler"
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27760c(r1, r0)
        r0 = 0
        if (r9 == 0) goto L_0x0046
        android.os.Handler r1 = r7.f22243c
        r1.removeMessages(r0)
    L_0x0046:
        android.os.Message r1 = android.os.Message.obtain()
        r1.what = r0
        r1.arg1 = r8
        r1.arg2 = r9
        android.os.Handler r8 = r7.f22243c
        r2 = 2000(0x7d0, double:9.88E-321)
        r8.sendMessageDelayed(r1, r2)
        return
    L_0x0058:
        r8 = move-exception
        monitor-exit(r7)     // Catch:{ all -> 0x0058 }
        throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.downloader.impls.RetryScheduler.m28556a(int, boolean):void");
    }

    /* renamed from: b */
    private void m28565b(final int i, final boolean z) {
        C6694b.m27379k().execute(new Runnable() {
            public void run() {
                try {
                    if (RetryScheduler.this.f22247g > 0) {
                        int d = RetryScheduler.this.m28572g();
                        if (d != 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("doScheduleAllTaskRetry: mWaitingRetryTasksCount = ");
                            sb.append(RetryScheduler.this.f22247g);
                            C6704a.m27760c("RetryScheduler", sb.toString());
                            long currentTimeMillis = System.currentTimeMillis();
                            ArrayList<C6742a> arrayList = new ArrayList<>();
                            synchronized (RetryScheduler.this.f22244d) {
                                for (int i = 0; i < RetryScheduler.this.f22244d.size(); i++) {
                                    C6742a aVar = (C6742a) RetryScheduler.this.f22244d.valueAt(i);
                                    if (aVar != null) {
                                        if (aVar.mo32538a(currentTimeMillis, i, d, z)) {
                                            if (z) {
                                                aVar.mo32540c();
                                            }
                                            arrayList.add(aVar);
                                        }
                                    }
                                }
                            }
                            if (arrayList.size() > 0) {
                                for (C6742a aVar2 : arrayList) {
                                    RetryScheduler.this.m28555a(aVar2.f22256a, d, false);
                                }
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo32527a(final int i) {
        C6694b.m27379k().execute(new Runnable() {
            public void run() {
                try {
                    RetryScheduler.this.m28555a(i, RetryScheduler.this.m28572g(), true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
            r1 = new java.lang.StringBuilder();
            r1.append("doSchedulerRetryInSubThread: downloadId = ");
            r1.append(r8);
            r1.append(", retryCount = ");
            r1.append(com.p530ss.android.socialbase.downloader.impls.RetryScheduler.C6742a.m28579a(r2));
            r1.append(", mWaitingRetryTasksCount = ");
            r1.append(r7.f22247g);
            com.p530ss.android.socialbase.downloader.p561f.C6704a.m27760c("RetryScheduler", r1.toString());
            r1 = com.p530ss.android.socialbase.downloader.downloader.Downloader.m27478a(r0).mo31928h(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005f, code lost:
            if (r1 != null) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0061, code lost:
            m28567c(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0064, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0065, code lost:
            r3 = r1.mo32315w();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006a, code lost:
            if (r3 == -3) goto L_0x00f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006d, code lost:
            if (r3 != -4) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0072, code lost:
            if (r3 != -5) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0074, code lost:
            r9 = com.p530ss.android.socialbase.downloader.downloader.C6694b.m27383o();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0078, code lost:
            if (r9 == null) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007a, code lost:
            r9.mo31503a(java.util.Collections.singletonList(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0081, code lost:
            m28567c(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0084, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0086, code lost:
            if (r3 == -1) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0088, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0089, code lost:
            if (r9 != 0) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008d, code lost:
            if (r2.f22261f == false) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008f, code lost:
            r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0091, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0092, code lost:
            r3 = r1.mo32220aW();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0096, code lost:
            if (r4 == false) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x009c, code lost:
            if (com.p530ss.android.socialbase.downloader.p569m.DownloadUtils.m28817g((java.lang.Throwable) r3) == false) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x009e, code lost:
            r4 = m28560a(r1, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a2, code lost:
            r2.mo32539b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a5, code lost:
            if (r4 == false) goto L_0x00e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a7, code lost:
            r9 = new java.lang.StringBuilder();
            r9.append("doSchedulerRetry: restart task, ****** id = ");
            r9.append(r2.f22256a);
            com.p530ss.android.socialbase.downloader.p561f.C6704a.m27760c("RetryScheduler", r9.toString());
            r2.mo32537a(java.lang.System.currentTimeMillis());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00c6, code lost:
            if (r10 == false) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00c8, code lost:
            r2.mo32536a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00cb, code lost:
            r1.mo32181a(com.p530ss.android.socialbase.downloader.impls.RetryScheduler.C6742a.m28579a(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d6, code lost:
            if (r1.mo32308q() != -1) goto L_0x00f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00d8, code lost:
            com.p530ss.android.socialbase.downloader.downloader.Downloader.m27478a(r0).mo31925e(r1.mo32283g());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e4, code lost:
            if (r10 == false) goto L_0x00e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e6, code lost:
            r2.mo32536a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e9, code lost:
            m28557a(r1, r1.mo32317x(), r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00f0, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00f1, code lost:
            m28567c(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00f4, code lost:
            return;
     */
    /* renamed from: a */
    public void m28555a(int r8, int r9, boolean r10) {
        /*
        r7 = this;
        android.content.Context r0 = r7.f22242b
        if (r0 != 0) goto L_0x0005
        return
    L_0x0005:
        android.util.SparseArray<com.ss.android.socialbase.downloader.impls.r$a> r1 = r7.f22244d
        monitor-enter(r1)
        android.util.SparseArray<com.ss.android.socialbase.downloader.impls.r$a> r2 = r7.f22244d     // Catch:{ all -> 0x00f5 }
        java.lang.Object r2 = r2.get(r8)     // Catch:{ all -> 0x00f5 }
        com.ss.android.socialbase.downloader.impls.r$a r2 = (com.p530ss.android.socialbase.downloader.impls.RetryScheduler.C6742a) r2     // Catch:{ all -> 0x00f5 }
        if (r2 != 0) goto L_0x0014
        monitor-exit(r1)     // Catch:{ all -> 0x00f5 }
        return
    L_0x0014:
        boolean r3 = r2.f22267l     // Catch:{ all -> 0x00f5 }
        r4 = 1
        r5 = 0
        if (r3 == 0) goto L_0x002a
        r2.f22267l = r5     // Catch:{ all -> 0x00f5 }
        int r3 = r7.f22247g     // Catch:{ all -> 0x00f5 }
        int r3 = r3 - r4
        r7.f22247g = r3     // Catch:{ all -> 0x00f5 }
        int r3 = r7.f22247g     // Catch:{ all -> 0x00f5 }
        if (r3 >= 0) goto L_0x002a
        r7.f22247g = r5     // Catch:{ all -> 0x00f5 }
    L_0x002a:
        monitor-exit(r1)     // Catch:{ all -> 0x00f5 }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r3 = "doSchedulerRetryInSubThread: downloadId = "
        r1.append(r3)
        r1.append(r8)
        java.lang.String r3 = ", retryCount = "
        r1.append(r3)
        int r3 = r2.f22264i
        r1.append(r3)
        java.lang.String r3 = ", mWaitingRetryTasksCount = "
        r1.append(r3)
        int r3 = r7.f22247g
        r1.append(r3)
        java.lang.String r1 = r1.toString()
        java.lang.String r3 = "RetryScheduler"
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27760c(r3, r1)
        com.ss.android.socialbase.downloader.downloader.f r1 = com.p530ss.android.socialbase.downloader.downloader.Downloader.m27478a(r0)
        com.ss.android.socialbase.downloader.g.c r1 = r1.mo31928h(r8)
        if (r1 != 0) goto L_0x0065
        r7.m28567c(r8)
        return
    L_0x0065:
        int r3 = r1.mo32315w()
        r6 = -3
        if (r3 == r6) goto L_0x00f1
        r6 = -4
        if (r3 != r6) goto L_0x0071
        goto L_0x00f1
    L_0x0071:
        r6 = -5
        if (r3 != r6) goto L_0x0085
        com.ss.android.socialbase.downloader.downloader.m r9 = com.p530ss.android.socialbase.downloader.downloader.C6694b.m27383o()
        if (r9 == 0) goto L_0x0081
        java.util.List r10 = java.util.Collections.singletonList(r1)
        r9.mo31503a(r10)
    L_0x0081:
        r7.m28567c(r8)
        return
    L_0x0085:
        r8 = -1
        if (r3 == r8) goto L_0x0089
        return
    L_0x0089:
        if (r9 != 0) goto L_0x0092
        boolean r3 = r2.f22261f
        if (r3 == 0) goto L_0x0091
        r4 = 0
        goto L_0x0092
    L_0x0091:
        return
    L_0x0092:
        com.ss.android.socialbase.downloader.e.a r3 = r1.mo32220aW()
        if (r4 == 0) goto L_0x00a2
        boolean r5 = com.p530ss.android.socialbase.downloader.p569m.DownloadUtils.m28817g(r3)
        if (r5 == 0) goto L_0x00a2
        boolean r4 = r7.m28560a(r1, r3)
    L_0x00a2:
        r2.mo32539b()
        if (r4 == 0) goto L_0x00e4
        java.lang.StringBuilder r9 = new java.lang.StringBuilder
        r9.<init>()
        java.lang.String r3 = "doSchedulerRetry: restart task, ****** id = "
        r9.append(r3)
        int r3 = r2.f22256a
        r9.append(r3)
        java.lang.String r9 = r9.toString()
        java.lang.String r3 = "RetryScheduler"
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27760c(r3, r9)
        long r3 = java.lang.System.currentTimeMillis()
        r2.mo32537a(r3)
        if (r10 == 0) goto L_0x00cb
        r2.mo32536a()
    L_0x00cb:
        int r9 = r2.f22264i
        r1.mo32181a(r9)
        int r9 = r1.mo32308q()
        if (r9 != r8) goto L_0x00f0
        com.ss.android.socialbase.downloader.downloader.f r8 = com.p530ss.android.socialbase.downloader.downloader.Downloader.m27478a(r0)
        int r9 = r1.mo32283g()
        r8.mo31925e(r9)
        goto L_0x00f0
    L_0x00e4:
        if (r10 == 0) goto L_0x00e9
        r2.mo32536a()
    L_0x00e9:
        boolean r8 = r1.mo32317x()
        r7.m28557a(r1, r8, r9)
    L_0x00f0:
        return
    L_0x00f1:
        r7.m28567c(r8)
        return
    L_0x00f5:
        r8 = move-exception
        monitor-exit(r1)     // Catch:{ all -> 0x00f5 }
        throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.downloader.impls.RetryScheduler.m28555a(int, int, boolean):void");
    }

    /* renamed from: a */
    private boolean m28561a(C6742a aVar, int i) {
        int[] iArr = aVar.f22262g;
        if (!(iArr == null || iArr.length == 0)) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    private C6742a m28564b(int i) {
        C6742a aVar = (C6742a) this.f22244d.get(i);
        if (aVar == null) {
            synchronized (this.f22244d) {
                aVar = (C6742a) this.f22244d.get(i);
                if (aVar == null) {
                    aVar = m28569d(i);
                }
                this.f22244d.put(i, aVar);
            }
        }
        return aVar;
    }

    /* renamed from: c */
    private void m28567c(int i) {
        synchronized (this.f22244d) {
            this.f22244d.remove(i);
        }
    }

    /* renamed from: d */
    private C6742a m28569d(int i) {
        int[] iArr;
        boolean z;
        int i2;
        int i3;
        DownloadSetting a = DownloadSetting.m28610a(i);
        boolean z2 = false;
        int a2 = a.mo32547a("retry_schedule", 0);
        JSONObject d = a.mo32555d("retry_schedule_config");
        int i4 = 60;
        if (d != null) {
            int optInt = d.optInt("max_count", 60);
            int optInt2 = d.optInt("interval_sec", 60);
            int optInt3 = d.optInt("interval_sec_acceleration", 60);
            if (VERSION.SDK_INT >= 21 && d.optInt("use_job_scheduler", 0) == 1) {
                z2 = true;
            }
            iArr = m28562a(d.optString("white_error_code"));
            z = z2;
            i3 = optInt3;
            i2 = optInt;
            i4 = optInt2;
        } else {
            iArr = null;
            i3 = 60;
            i2 = 60;
            z = false;
        }
        C6742a aVar = new C6742a(i, a2, i2, i4 * 1000, i3 * 1000, z, iArr);
        return aVar;
    }

    /* renamed from: a */
    private int[] m28562a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(StorageInterface.KEY_SPLITER);
            if (split.length <= 0) {
                return null;
            }
            int[] iArr = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                iArr[i] = Integer.parseInt(split[i]);
            }
            return iArr;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: b */
    public void mo31235b() {
        m28556a(4, false);
    }

    /* renamed from: c */
    public void mo31237c() {
        m28556a(3, false);
    }

    /* renamed from: d */
    public void mo32529d() {
        m28556a(2, false);
    }

    /* renamed from: e */
    public void mo32530e() {
        m28556a(5, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public int m28572g() {
        try {
            if (this.f22248h == null) {
                this.f22248h = (ConnectivityManager) this.f22242b.getApplicationContext().getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = this.f22248h.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return activeNetworkInfo.getType() == 1 ? 2 : 1;
                }
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    /* renamed from: a */
    private boolean m28560a(DownloadInfo cVar, BaseException aVar) {
        long j;
        long j2;
        try {
            j = DownloadUtils.m28796c(cVar.mo32300l());
        } catch (BaseException e) {
            e.printStackTrace();
            j = 0;
        }
        if (aVar instanceof DownloadOutOfSpaceException) {
            j2 = ((DownloadOutOfSpaceException) aVar).mo32087d();
        } else {
            j2 = cVar.mo32225ab() - cVar.mo32180Z();
        }
        if (j < j2) {
            DownloadSetting a = DownloadSetting.m28610a(cVar.mo32283g());
            if (a.mo32547a("space_fill_part_download", 0) == 1) {
                if (j > 0) {
                    int a2 = a.mo32547a("space_fill_min_keep_mb", 100);
                    if (a2 > 0) {
                        long j3 = j - (((long) a2) * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
                        StringBuilder sb = new StringBuilder();
                        sb.append("retry schedule: available = ");
                        sb.append(DownloadUtils.m28747a(j));
                        sb.append("MB, minKeep = ");
                        sb.append(a2);
                        sb.append("MB, canDownload = ");
                        sb.append(DownloadUtils.m28747a(j3));
                        sb.append("MB");
                        String str = "RetryScheduler";
                        C6704a.m27760c(str, sb.toString());
                        if (j3 <= 0) {
                            C6704a.m27761d(str, "doSchedulerRetryInSubThread: canDownload <= 0 , canRetry = false !!!!");
                            return false;
                        }
                    }
                } else if (a.mo32547a("download_when_space_negative", 0) != 1) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }
}
