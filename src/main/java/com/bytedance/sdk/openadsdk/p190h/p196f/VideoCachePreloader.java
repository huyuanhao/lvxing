package com.bytedance.sdk.openadsdk.p190h.p196f;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.p190h.Preloader;
import com.bytedance.sdk.openadsdk.p190h.Proxy;
import com.bytedance.sdk.openadsdk.p190h.ProxyServer;
import com.bytedance.sdk.openadsdk.p190h.p191a.C2443c;
import com.bytedance.sdk.openadsdk.p190h.p197g.C2479d;
import com.bytedance.sdk.openadsdk.p190h.p197g.FileHelper;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.bytedance.sdk.openadsdk.h.f.a */
public class VideoCachePreloader {
    /* renamed from: a */
    public static final boolean f8874a = C2564t.m12224c();
    /* renamed from: b */
    private HashMap<String, Boolean> f8875b;
    /* renamed from: c */
    private C2471a f8876c;

    /* compiled from: VideoCachePreloader */
    /* renamed from: com.bytedance.sdk.openadsdk.h.f.a$a */
    class C2471a extends Thread {
        /* renamed from: b */
        private Queue<C2472a> f8878b = new LinkedBlockingQueue();
        /* renamed from: c */
        private boolean f8879c = true;
        /* renamed from: d */
        private final Queue<C2472a> f8880d = new ArrayBlockingQueue(10);
        /* renamed from: e */
        private Queue<C2472a> f8881e = new LinkedBlockingQueue();

        /* compiled from: VideoCachePreloader */
        /* renamed from: com.bytedance.sdk.openadsdk.h.f.a$a$a */
        private class C2472a {
            /* renamed from: a */
            public int f8882a;
            /* renamed from: b */
            public String f8883b;
            /* renamed from: c */
            public String[] f8884c;
            /* renamed from: d */
            public int f8885d;
            /* renamed from: e */
            public String f8886e;
            /* renamed from: f */
            public VideoUrlModel f8887f;

            public C2472a() {
            }
        }

        /* renamed from: a */
        private void m11604a() {
        }

        /* renamed from: b */
        private void m11606b() {
        }

        public C2471a() {
        }

        /* renamed from: a */
        private C2472a m11603a(int i, VideoUrlModel bVar) {
            m11606b();
            StringBuilder sb = new StringBuilder();
            sb.append("pool: ");
            sb.append(this.f8880d.size());
            C2564t.m12220b("VideoCachePreloader", sb.toString());
            C2472a aVar = (C2472a) this.f8880d.poll();
            if (aVar == null) {
                aVar = new C2472a();
            }
            aVar.f8882a = i;
            aVar.f8887f = bVar;
            return aVar;
        }

        /* renamed from: a */
        private void m11605a(C2472a aVar) {
            m11604a();
            aVar.f8884c = null;
            aVar.f8883b = null;
            aVar.f8882a = -1;
            aVar.f8887f = null;
            this.f8880d.offer(aVar);
        }

        /* renamed from: b */
        private synchronized void m11607b(C2472a aVar) {
            m11606b();
            this.f8881e.add(aVar);
            notify();
        }

        /* renamed from: c */
        private void m11609c(C2472a aVar) {
            m11604a();
            if (aVar != null) {
                this.f8878b.offer(aVar);
                notify();
            }
        }

        public void run() {
            String[] strArr;
            while (this.f8879c) {
                synchronized (this) {
                    if (!this.f8881e.isEmpty()) {
                        m11608c();
                    }
                    while (!this.f8878b.isEmpty()) {
                        C2472a aVar = (C2472a) this.f8878b.poll();
                        if (aVar != null) {
                            int i = aVar.f8882a;
                            if (i != 0) {
                                if (i == 1) {
                                    Preloader.m11521c().mo16724a(aVar.f8883b);
                                } else if (i == 2) {
                                    Preloader.m11521c().mo16730d();
                                } else if (i == 3) {
                                    Preloader.m11521c().mo16730d();
                                    if (Proxy.m11543c() != null) {
                                        Proxy.m11543c().mo16676a();
                                    }
                                    if (Proxy.m11541b() != null) {
                                        Proxy.m11541b().mo16680a();
                                    }
                                } else if (i == 4) {
                                    Preloader.m11521c().mo16730d();
                                    this.f8879c = false;
                                }
                            } else if (aVar.f8884c != null && aVar.f8884c.length > 0) {
                                ArrayList arrayList = new ArrayList();
                                for (String str : aVar.f8884c) {
                                    if (C2479d.m11667a(str)) {
                                        arrayList.add(str);
                                    }
                                }
                                Preloader.m11521c().mo16727a(false, !TextUtils.isEmpty(aVar.f8886e), aVar.f8885d, aVar.f8883b, (String[]) arrayList.toArray(new String[arrayList.size()]));
                            }
                            m11605a(aVar);
                        }
                    }
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        /* renamed from: c */
        private void m11608c() {
            m11604a();
            while (true) {
                C2472a aVar = (C2472a) this.f8881e.poll();
                if (aVar != null) {
                    aVar.f8883b = aVar.f8887f.f8890a;
                    aVar.f8884c = new String[]{aVar.f8887f.f8890a};
                    aVar.f8885d = aVar.f8887f.f8891b;
                    aVar.f8886e = aVar.f8887f.f8892c;
                    if (!TextUtils.isEmpty(aVar.f8887f.f8892c)) {
                        aVar.f8883b = aVar.f8887f.f8892c;
                    }
                    aVar.f8887f = null;
                    m11609c(aVar);
                } else {
                    return;
                }
            }
        }

        /* renamed from: a */
        public void mo16769a(VideoUrlModel bVar) {
            m11607b(m11603a(0, bVar));
        }
    }

    /* compiled from: VideoCachePreloader */
    /* renamed from: com.bytedance.sdk.openadsdk.h.f.a$b */
    private static class C2473b {
        /* access modifiers changed from: private|static|final */
        /* renamed from: a */
        public static final VideoCachePreloader f8889a = new VideoCachePreloader();
    }

    private VideoCachePreloader() {
        this.f8875b = new HashMap<>();
        mo16768b();
    }

    /* renamed from: a */
    public static VideoCachePreloader m11598a() {
        return C2473b.f8889a;
    }

    /* renamed from: b */
    public boolean mo16768b() {
        if (this.f8876c != null) {
            return true;
        }
        C2443c c = m11599c();
        if (c == null) {
            return false;
        }
        Proxy.m11540a(true);
        Proxy.m11542b(true);
        Proxy.m11538a(1);
        ProxyServer.m11573a().mo16759d();
        try {
            this.f8876c = new C2471a();
            this.f8876c.start();
            Proxy.m11539a(c, InternalContainer.m10059a());
            Preloader.m11521c().mo16721a(30000, 30000, 30000);
            Preloader.m11521c().mo16720a(10485759);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    public boolean mo16766a(VideoUrlModel bVar) {
        if (!mo16768b()) {
            return false;
        }
        this.f8876c.mo16769a(bVar);
        return true;
    }

    /* renamed from: b */
    public String mo16767b(VideoUrlModel bVar) {
        if (bVar == null) {
            return null;
        }
        boolean z = !TextUtils.isEmpty(bVar.f8892c);
        return ProxyServer.m11573a().mo16753a(false, z, z ? bVar.f8892c : bVar.f8890a, bVar.f8890a);
    }

    /* renamed from: c */
    private static C2443c m11599c() {
        C2443c cVar = null;
        if (!FileHelper.m11645d()) {
            return null;
        }
        File file = new File(FileHelper.m11639a(FileHelper.m11642b(), "cache").getPath());
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            C2443c cVar2 = new C2443c(file);
            try {
                cVar2.mo16681a(104857600);
                return cVar2;
            } catch (IOException e) {
                e = e;
                cVar = cVar2;
                e.printStackTrace();
                return cVar;
            }
        } catch (IOException e2) {
            e = e2;
            e.printStackTrace();
            return cVar;
        }
    }
}
