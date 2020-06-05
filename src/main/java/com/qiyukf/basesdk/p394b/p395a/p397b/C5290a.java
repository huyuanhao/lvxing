package com.qiyukf.basesdk.p394b.p395a.p397b;

import android.text.TextUtils;
import com.qiyukf.basesdk.C5263a;
import com.qiyukf.basesdk.p394b.p395a.p397b.p400c.C5299a;
import com.qiyukf.basesdk.p394b.p395a.p397b.p400c.C5300b;
import com.qiyukf.basesdk.p394b.p395a.p397b.p400c.C5302d;
import com.qiyukf.basesdk.p394b.p395a.p397b.p400c.C5304f;
import com.qiyukf.basesdk.p394b.p395a.p397b.p401d.C5305a;
import com.qiyukf.basesdk.p394b.p395a.p397b.p402e.C5308b;
import com.qiyukf.basesdk.p394b.p395a.p397b.p403f.C5310a;
import com.qiyukf.basesdk.p394b.p395a.p397b.p403f.C5311b;
import com.qiyukf.basesdk.p412c.p416c.C5406d;
import com.tencent.p605ep.commonbase.network.HttpStatus;
import java.io.File;
import java.net.URLDecoder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.qiyukf.basesdk.b.a.b.a */
public final class C5290a {
    /* renamed from: e */
    private static C5305a f17129e;
    /* renamed from: a */
    private C5295b f17130a;
    /* renamed from: b */
    private List<C5302d> f17131b;
    /* renamed from: c */
    private AtomicBoolean f17132c;
    /* renamed from: d */
    private Set<C5293c> f17133d;

    /* renamed from: com.qiyukf.basesdk.b.a.b.a$a */
    private class C5291a implements C5300b {
        /* renamed from: b */
        private String f17135b;
        /* renamed from: c */
        private C5298c f17136c;
        /* renamed from: d */
        private C5302d f17137d;

        C5291a(String str, C5302d dVar, C5298c cVar) {
            this.f17135b = str;
            this.f17137d = dVar;
            this.f17136c = cVar;
        }

        /* renamed from: a */
        public final void mo27159a() {
            C5295b.m21757c(this.f17135b);
            C5295b.m21759e(this.f17135b);
            C5298c cVar = this.f17136c;
            if (cVar != null) {
                C5302d dVar = this.f17137d;
                String decode = URLDecoder.decode(dVar.mo27182c());
                String decode2 = URLDecoder.decode(dVar.mo27180b());
                StringBuilder sb = new StringBuilder("https://");
                sb.append(decode2);
                sb.append(".nosdn.127.net/");
                sb.append(decode);
                cVar.mo27172a(sb.toString());
            }
        }

        /* renamed from: a */
        public final void mo27160a(long j, long j2) {
            C5298c cVar = this.f17136c;
            if (cVar != null) {
                cVar.mo27171a(j, j2);
            }
        }

        /* renamed from: a */
        public final void mo27161a(C5299a aVar) {
            C5298c cVar = this.f17136c;
            if (cVar != null) {
                cVar.mo27170a(aVar.mo27173a());
            }
            if (aVar.mo27173a() == 403) {
                C5292b.f17138a.mo27158d();
                C5295b.m21757c(this.f17135b);
                C5295b.m21759e(this.f17135b);
                return;
            }
            C5308b.m21826c(C5263a.m21607a());
        }

        /* renamed from: a */
        public final void mo27162a(String str) {
            C5295b.m21754a(this.f17135b, str);
            C5295b.m21753a(this.f17135b, this.f17137d);
        }

        /* renamed from: b */
        public final void mo27163b() {
            C5298c cVar = this.f17136c;
            if (cVar != null) {
                cVar.mo27169a();
            }
        }
    }

    /* renamed from: com.qiyukf.basesdk.b.a.b.a$b */
    private static class C5292b {
        /* access modifiers changed from: private|static */
        /* renamed from: a */
        public static C5290a f17138a = new C5290a(0);
    }

    /* renamed from: com.qiyukf.basesdk.b.a.b.a$c */
    public class C5293c implements Runnable {
        /* renamed from: b */
        private String f17140b;
        /* renamed from: c */
        private String f17141c;
        /* renamed from: d */
        private Object f17142d;
        /* access modifiers changed from: private */
        /* renamed from: e */
        public C5298c f17143e;
        /* renamed from: f */
        private C5311b f17144f;
        /* access modifiers changed from: private */
        /* renamed from: g */
        public C5302d f17145g;

        C5293c(String str, String str2, Object obj, C5298c cVar) {
            this.f17140b = str;
            this.f17141c = str2;
            this.f17142d = obj;
            this.f17143e = cVar;
        }

        /* renamed from: a */
        public final void mo27164a() {
            C5311b bVar = this.f17144f;
            if (bVar != null) {
                bVar.mo27213a();
            }
        }

        public final void run() {
            String b = C5295b.m21756b(this.f17140b);
            if (!TextUtils.isEmpty(b)) {
                C5302d d = C5295b.m21758d(this.f17140b);
                if (d != null) {
                    this.f17145g = d;
                }
            }
            C5304f fVar = new C5304f(this.f17145g.mo27177a(), this.f17145g.mo27180b(), this.f17145g.mo27182c(), this.f17141c);
            fVar.mo27203b(C5406d.m22122c(this.f17140b));
            try {
                this.f17144f = C5310a.m21833a(C5263a.m21607a(), new File(this.f17140b), this.f17142d, b, fVar, new C5291a(this.f17140b, this.f17145g, this.f17143e));
            } catch (Exception e) {
                C5298c cVar = this.f17143e;
                if (cVar != null) {
                    new StringBuilder("exception: ").append(e.getMessage());
                    cVar.mo27170a(1000);
                }
            }
        }
    }

    private C5290a() {
        this.f17132c = new AtomicBoolean(false);
        this.f17130a = new C5295b();
        this.f17131b = C5302d.m21777d(C5295b.m21751a());
        m21722f();
        this.f17133d = new HashSet();
    }

    /* synthetic */ C5290a(byte b) {
        this();
    }

    /* renamed from: a */
    public static final C5290a m21719a() {
        return C5292b.f17138a;
    }

    /* renamed from: c */
    public static C5305a m21720c() {
        if (f17129e == null) {
            f17129e = new C5305a();
        }
        return f17129e;
    }

    /* renamed from: e */
    private void m21721e() {
        C5295b.m21752a(C5302d.m21775a(this.f17131b));
    }

    /* renamed from: f */
    private void m21722f() {
        if (this.f17131b.size() <= 10) {
            m21724h();
        }
    }

    /* renamed from: g */
    private C5302d m21723g() {
        m21722f();
        synchronized (this.f17131b) {
            if (this.f17131b.size() <= 0) {
                return null;
            }
            C5302d dVar = (C5302d) this.f17131b.remove(this.f17131b.size() - 1);
            m21721e();
            return dVar;
        }
    }

    /* renamed from: h */
    private void m21724h() {
        if (this.f17132c.compareAndSet(false, true)) {
            C5263a.m21614g();
        }
    }

    /* renamed from: a */
    public final C5293c mo27154a(String str, String str2, Object obj, C5298c cVar) {
        C5293c cVar2 = new C5293c(str, str2, obj, cVar);
        C5302d g = m21723g();
        if (g == null) {
            synchronized (this.f17133d) {
                this.f17133d.add(cVar2);
            }
        } else {
            cVar2.f17145g = g;
            cVar2.run();
        }
        return cVar2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
            if ((r3 instanceof com.qiyukf.basesdk.p394b.p395a.p397b.C5290a.C5293c) == false) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
            ((com.qiyukf.basesdk.p394b.p395a.p397b.C5290a.C5293c) r3).mo27164a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
            return;
     */
    /* renamed from: a */
    public final void mo27155a(java.lang.Runnable r3) {
        /*
        r2 = this;
        java.util.Set<com.qiyukf.basesdk.b.a.b.a$c> r0 = r2.f17133d
        monitor-enter(r0)
        java.util.Set<com.qiyukf.basesdk.b.a.b.a$c> r1 = r2.f17133d     // Catch:{ all -> 0x001d }
        boolean r1 = r1.contains(r3)     // Catch:{ all -> 0x001d }
        if (r1 == 0) goto L_0x0012
        java.util.Set<com.qiyukf.basesdk.b.a.b.a$c> r1 = r2.f17133d     // Catch:{ all -> 0x001d }
        r1.remove(r3)     // Catch:{ all -> 0x001d }
        monitor-exit(r0)     // Catch:{ all -> 0x001d }
        return
    L_0x0012:
        monitor-exit(r0)     // Catch:{ all -> 0x001d }
        boolean r0 = r3 instanceof com.qiyukf.basesdk.p394b.p395a.p397b.C5290a.C5293c
        if (r0 == 0) goto L_0x001c
        com.qiyukf.basesdk.b.a.b.a$c r3 = (com.qiyukf.basesdk.p394b.p395a.p397b.C5290a.C5293c) r3
        r3.mo27164a()
    L_0x001c:
        return
    L_0x001d:
        r3 = move-exception
        monitor-exit(r0)     // Catch:{ all -> 0x001d }
        throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.p394b.p395a.p397b.C5290a.mo27155a(java.lang.Runnable):void");
    }

    /* renamed from: a */
    public final void mo27156a(List<C5302d> list) {
        this.f17132c.set(false);
        if (list.size() != 0) {
            synchronized (this.f17131b) {
                this.f17131b.addAll(list);
                m21721e();
            }
            synchronized (this.f17133d) {
                while (true) {
                    if (this.f17133d.size() <= 0) {
                        break;
                    }
                    Iterator it = this.f17133d.iterator();
                    C5293c cVar = (C5293c) it.next();
                    cVar.f17145g = m21723g();
                    if (cVar.f17145g == null) {
                        m21724h();
                        break;
                    } else {
                        cVar.run();
                        it.remove();
                    }
                }
            }
        } else if (this.f17131b.size() == 0 && this.f17133d.size() > 0) {
            synchronized (this.f17133d) {
                for (C5293c cVar2 : this.f17133d) {
                    if (cVar2.f17143e != null) {
                        cVar2.f17143e.mo27170a((int) HttpStatus.SC_REQUEST_TIMEOUT);
                    }
                }
                this.f17133d.clear();
            }
        }
    }

    /* renamed from: b */
    public final void mo27157b() {
        synchronized (this.f17133d) {
            this.f17133d.clear();
        }
        this.f17132c.set(false);
        C5310a.m21834a();
    }

    /* renamed from: d */
    public final void mo27158d() {
        synchronized (this.f17131b) {
            this.f17131b.clear();
        }
        m21724h();
    }
}
