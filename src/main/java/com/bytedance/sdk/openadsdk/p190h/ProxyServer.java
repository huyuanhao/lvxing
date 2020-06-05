package com.bytedance.sdk.openadsdk.p190h;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.p190h.ProxyTask.C2478c;
import com.bytedance.sdk.openadsdk.p190h.p191a.C2441b;
import com.bytedance.sdk.openadsdk.p190h.p191a.C2443c;
import com.bytedance.sdk.openadsdk.p190h.p192b.VideoProxyDB;
import com.bytedance.sdk.openadsdk.p190h.p197g.C2479d;
import com.bytedance.sdk.openadsdk.p190h.p197g.MD5;
import com.bytedance.sdk.openadsdk.p198i.TTExecutor;
import com.bytedance.sdk.openadsdk.p198i.TTFutureTask;
import com.bytedance.sdk.openadsdk.p198i.TTRunnable;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.tencent.android.tpush.SettingsContentProvider;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.bytedance.sdk.openadsdk.h.f */
public class ProxyServer {
    /* renamed from: d */
    private static volatile ProxyServer f8855d;
    /* access modifiers changed from: private|volatile */
    /* renamed from: a */
    public volatile ServerSocket f8856a;
    /* access modifiers changed from: private|volatile */
    /* renamed from: b */
    public volatile int f8857b;
    /* access modifiers changed from: private|final */
    /* renamed from: c */
    public final AtomicInteger f8858c = new AtomicInteger(0);
    /* access modifiers changed from: private|volatile */
    /* renamed from: e */
    public volatile VideoProxyDB f8859e;
    /* renamed from: f */
    private volatile C2443c f8860f;
    /* renamed from: g */
    private volatile C2441b f8861g;
    /* access modifiers changed from: private|final */
    /* renamed from: h */
    public final SparseArray<Set<ProxyTask>> f8862h = new SparseArray<>(2);
    /* access modifiers changed from: private|final */
    /* renamed from: i */
    public final C2478c f8863i = new C2478c() {
        /* renamed from: a */
        public void mo16760a(ProxyTask gVar) {
            synchronized (ProxyServer.this.f8862h) {
                Set set = (Set) ProxyServer.this.f8862h.get(gVar.mo16669f());
                if (set != null) {
                    set.add(gVar);
                }
            }
        }

        /* renamed from: b */
        public void mo16761b(ProxyTask gVar) {
            if (Proxy.f8836c) {
                StringBuilder sb = new StringBuilder();
                sb.append("afterExecute, ProxyTask: ");
                sb.append(gVar);
                Log.d("TAG_PROXY_ProxyServer", sb.toString());
            }
            int f = gVar.mo16669f();
            synchronized (ProxyServer.this.f8862h) {
                Set set = (Set) ProxyServer.this.f8862h.get(f);
                if (set != null) {
                    set.remove(gVar);
                }
            }
        }
    };
    /* renamed from: j */
    private volatile IncrementalTimeout f8864j;
    /* renamed from: k */
    private volatile IncrementalTimeout f8865k;
    /* renamed from: l */
    private final Runnable f8866l = new Runnable() {
        public void run() {
            String str = "127.0.0.1";
            String str2 = "TAG_PROXY_ProxyServer";
            try {
                int i = 0;
                ProxyServer.this.f8856a = new ServerSocket(0, 50, InetAddress.getByName(str));
                ProxyServer fVar = ProxyServer.this;
                fVar.f8857b = fVar.f8856a.getLocalPort();
                if (ProxyServer.this.f8857b == -1) {
                    ProxyServer.m11577b("socket not bound", "");
                    ProxyServer.this.m11580e();
                    return;
                }
                SkipProxySelector.m11685a(str, ProxyServer.this.f8857b);
                if (ProxyServer.this.m11585g() && ProxyServer.this.f8858c.compareAndSet(0, 1)) {
                    if (Proxy.f8836c) {
                        Log.i(str2, "proxy server start!");
                    }
                    while (ProxyServer.this.f8858c.get() == 1) {
                        try {
                            Socket accept = ProxyServer.this.f8856a.accept();
                            VideoProxyDB g = ProxyServer.this.f8859e;
                            if (g != null) {
                                TTExecutor.m11692a().mo16807b(new C2476a().mo16777a(g).mo16779a(accept).mo16778a(ProxyServer.this.f8863i).mo16780a(), 10);
                            } else {
                                C2479d.m11666a(accept);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                            ProxyServer.m11577b("accept error", Log.getStackTraceString(e));
                            i++;
                            if (i > 3) {
                                break;
                            }
                        } catch (Throwable th) {
                            String stackTraceString = Log.getStackTraceString(th);
                            StringBuilder sb = new StringBuilder();
                            sb.append("proxy server crashed!  ");
                            sb.append(stackTraceString);
                            Log.e(str2, sb.toString());
                            ProxyServer.m11577b("error", stackTraceString);
                        }
                    }
                    if (Proxy.f8836c) {
                        Log.i(str2, "proxy server closed!");
                    }
                    ProxyServer.this.m11580e();
                }
            } catch (IOException e2) {
                if (Proxy.f8836c) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("create ServerSocket error!  ");
                    sb2.append(Log.getStackTraceString(e2));
                    Log.e(str2, sb2.toString());
                }
                ProxyServer.m11577b("create ServerSocket error", Log.getStackTraceString(e2));
                ProxyServer.this.m11580e();
            }
        }
    };
    /* renamed from: m */
    private final AtomicBoolean f8867m = new AtomicBoolean();

    /* compiled from: ProxyServer */
    /* renamed from: com.bytedance.sdk.openadsdk.h.f$a */
    private static final class C2469a implements Callable<Boolean> {
        /* renamed from: a */
        private final String f8872a;
        /* renamed from: b */
        private final int f8873b;

        C2469a(String str, int i) {
            this.f8872a = str;
            this.f8873b = i;
        }

        /* renamed from: a */
        public Boolean call() {
            Socket socket;
            Throwable th;
            try {
                socket = new Socket(this.f8872a, this.f8873b);
                try {
                    socket.setSoTimeout(2000);
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write("Ping\n".getBytes(C2479d.f8916a));
                    outputStream.flush();
                    if ("OK".equals(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine())) {
                        Boolean valueOf = Boolean.valueOf(true);
                        C2479d.m11666a(socket);
                        return valueOf;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        th.printStackTrace();
                        ProxyServer.m11577b("ping error", Log.getStackTraceString(th));
                        C2479d.m11666a(socket);
                        return Boolean.valueOf(false);
                    } catch (Throwable th3) {
                        C2479d.m11666a(socket);
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                Throwable th5 = th4;
                socket = null;
                th = th5;
                th.printStackTrace();
                ProxyServer.m11577b("ping error", Log.getStackTraceString(th));
                C2479d.m11666a(socket);
                return Boolean.valueOf(false);
            }
            C2479d.m11666a(socket);
            return Boolean.valueOf(false);
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static void m11577b(String str, String str2) {
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002f, code lost:
            return false;
     */
    /* renamed from: a */
    public boolean mo16756a(int r4, java.lang.String r5) {
        /*
        r3 = this;
        r0 = 0
        if (r5 != 0) goto L_0x0004
        return r0
    L_0x0004:
        android.util.SparseArray<java.util.Set<com.bytedance.sdk.openadsdk.h.g>> r1 = r3.f8862h
        monitor-enter(r1)
        android.util.SparseArray<java.util.Set<com.bytedance.sdk.openadsdk.h.g>> r2 = r3.f8862h     // Catch:{ all -> 0x0030 }
        java.lang.Object r4 = r2.get(r4)     // Catch:{ all -> 0x0030 }
        java.util.Set r4 = (java.util.Set) r4     // Catch:{ all -> 0x0030 }
        if (r4 == 0) goto L_0x002e
        java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0030 }
    L_0x0015:
        boolean r2 = r4.hasNext()     // Catch:{ all -> 0x0030 }
        if (r2 == 0) goto L_0x002e
        java.lang.Object r2 = r4.next()     // Catch:{ all -> 0x0030 }
        com.bytedance.sdk.openadsdk.h.g r2 = (com.bytedance.sdk.openadsdk.p190h.ProxyTask) r2     // Catch:{ all -> 0x0030 }
        if (r2 == 0) goto L_0x0015
        java.lang.String r2 = r2.f8742h     // Catch:{ all -> 0x0030 }
        boolean r2 = r5.equals(r2)     // Catch:{ all -> 0x0030 }
        if (r2 == 0) goto L_0x0015
        r4 = 1
        monitor-exit(r1)     // Catch:{ all -> 0x0030 }
        return r4
    L_0x002e:
        monitor-exit(r1)     // Catch:{ all -> 0x0030 }
        return r0
    L_0x0030:
        r4 = move-exception
        monitor-exit(r1)     // Catch:{ all -> 0x0030 }
        throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.p190h.ProxyServer.mo16756a(int, java.lang.String):boolean");
    }

    /* renamed from: a */
    public static ProxyServer m11573a() {
        if (f8855d == null) {
            synchronized (ProxyServer.class) {
                if (f8855d == null) {
                    f8855d = new ProxyServer();
                }
            }
        }
        return f8855d;
    }

    private ProxyServer() {
        this.f8862h.put(0, new HashSet());
        this.f8862h.put(1, new HashSet());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public IncrementalTimeout mo16757b() {
        return this.f8864j;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public IncrementalTimeout mo16758c() {
        return this.f8865k;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo16755a(VideoProxyDB cVar) {
        this.f8859e = cVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo16754a(C2443c cVar) {
        this.f8860f = cVar;
    }

    /* renamed from: a */
    public String mo16753a(boolean z, boolean z2, String str, String... strArr) {
        String str2;
        String str3 = "url";
        if (strArr == null || strArr.length == 0) {
            m11577b(str3, "url is empty");
            return null;
        } else if (TextUtils.isEmpty(str)) {
            m11577b(SettingsContentProvider.KEY, "key is empty");
            return strArr[0];
        } else if (this.f8859e == null) {
            m11577b("db", "VideoProxyDB is null");
            return strArr[0];
        } else {
            if ((z ? this.f8861g : this.f8860f) == null) {
                m11577b("cache", "Cache is null");
                return strArr[0];
            }
            int i = this.f8858c.get();
            if (i != 1) {
                StringBuilder sb = new StringBuilder();
                sb.append("ProxyServer is not running, ");
                sb.append(i);
                m11577b(ArgKey.KEY_STATE, sb.toString());
                return strArr[0];
            }
            List a = C2479d.m11661a(strArr);
            if (a == null) {
                m11577b(str3, "url not start with http/https");
                return strArr[0];
            }
            if (z2) {
                str2 = str;
            } else {
                str2 = MD5.m11646a(str);
            }
            String a2 = C2482i.m11680a(str, str2, a);
            if (a2 == null) {
                m11577b(str3, "combine proxy url error");
                return strArr[0];
            }
            String str4 = "http://127.0.0.1:";
            if (z) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str4);
                sb2.append(this.f8857b);
                sb2.append("?f=");
                sb2.append(1);
                sb2.append("&");
                sb2.append(a2);
                return sb2.toString();
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str4);
            sb3.append(this.f8857b);
            sb3.append("?");
            sb3.append(a2);
            return sb3.toString();
        }
    }

    /* renamed from: d */
    public void mo16759d() {
        if (this.f8867m.compareAndSet(false, true)) {
            new Thread(this.f8866l).start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m11580e() {
        if (this.f8858c.compareAndSet(1, 2) || this.f8858c.compareAndSet(0, 2)) {
            C2479d.m11665a(this.f8856a);
            m11583f();
        }
    }

    /* renamed from: f */
    private void m11583f() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f8862h) {
            int size = this.f8862h.size();
            for (int i = 0; i < size; i++) {
                Set set = (Set) this.f8862h.get(this.f8862h.keyAt(i));
                if (set != null) {
                    arrayList.addAll(set);
                    set.clear();
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ProxyTask) it.next()).mo16662a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public boolean m11585g() {
        String str = "ping error";
        final TTFutureTask bVar = new TTFutureTask(new C2469a("127.0.0.1", this.f8857b), 5, 1);
        TTExecutor.m11692a().mo16803a((TTRunnable) new TTRunnable() {
            public void run() {
                C2564t.m12220b("TTExecutor", "pingTest.....run");
                bVar.run();
            }
        });
        m11587h();
        try {
            String str2 = "TAG_PROXY_ProxyServer";
            if (!((Boolean) bVar.get()).booleanValue()) {
                Log.e(str2, "Ping error");
                m11577b(str, "");
                m11580e();
                return false;
            }
            if (Proxy.f8836c) {
                Log.i(str2, "Ping OK!");
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            m11577b(str, Log.getStackTraceString(th));
            m11580e();
            return false;
        }
    }

    /* renamed from: h */
    private void m11587h() {
        Socket socket = null;
        try {
            socket = this.f8856a.accept();
            socket.setSoTimeout(2000);
            if ("Ping".equals(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine())) {
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write("OK\n".getBytes(C2479d.f8916a));
                outputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
            m11577b("ping error", Log.getStackTraceString(e));
        } catch (Throwable th) {
            C2479d.m11666a((Socket) null);
            throw th;
        }
        C2479d.m11666a(socket);
    }
}
