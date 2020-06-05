package com.bytedance.sdk.openadsdk.core.widget.webview.p179a;

import android.os.Environment;
import com.bytedance.sdk.openadsdk.core.C2240g;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p170d.TempPkgModel;
import com.bytedance.sdk.openadsdk.core.p170d.TempPkgModel.C2228a;
import com.bytedance.sdk.openadsdk.p185f.StatsLogManager;
import com.bytedance.sdk.openadsdk.p185f.p186a.LogStatsBase;
import com.bytedance.sdk.openadsdk.p198i.TTExecutor;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.DigestUtils;
import com.tencent.mid.sotrage.StorageInterface;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.bytedance.sdk.openadsdk.core.widget.webview.a.b */
class TemplateManager {
    /* renamed from: a */
    private static File f8383a;
    /* renamed from: b */
    private static volatile TemplateManager f8384b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public AtomicBoolean f8385c = new AtomicBoolean(true);
    /* renamed from: d */
    private AtomicBoolean f8386d = new AtomicBoolean(false);
    /* renamed from: e */
    private boolean f8387e = false;
    /* renamed from: f */
    private AtomicInteger f8388f = new AtomicInteger(0);
    /* renamed from: g */
    private AtomicLong f8389g = new AtomicLong();

    /* renamed from: a */
    public static TemplateManager m10874a() {
        if (f8384b == null) {
            synchronized (TemplateManager.class) {
                if (f8384b == null) {
                    f8384b = new TemplateManager();
                }
            }
        }
        return f8384b;
    }

    private TemplateManager() {
        m10880f();
    }

    /* renamed from: f */
    private void m10880f() {
        TTExecutor.m11692a().mo16808c(new Runnable() {
            public void run() {
                C2373f.m10913a();
                TemplateManager.this.f8385c.set(false);
                TemplateManager.this.m10881g();
                TemplateManager.this.mo16368d();
            }
        }, 10);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m10881g() {
        String a;
        File file;
        String str = "TemplateManager";
        C2564t.m12220b(str, "check template usable1");
        TempPkgModel b = C2373f.m10915b();
        if (b == null || !b.mo15558e()) {
            C2564t.m12220b(str, "check template usable2");
            return;
        }
        boolean z = true;
        Iterator it = b.mo15557d().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C2228a aVar = (C2228a) it.next();
            a = aVar.mo15560a();
            file = new File(m10879e(), DigestUtils.m12169a(a));
            String a2 = DigestUtils.m12168a(file);
            if (file.exists() && file.isFile() && aVar.mo15563b() != null) {
                if (!aVar.mo15563b().equals(a2)) {
                    break;
                }
            } else {
                z = false;
                StringBuilder sb = new StringBuilder();
                sb.append("check template usable3: ");
                sb.append(a);
                sb.append(StorageInterface.KEY_SPLITER);
                sb.append(file.getAbsolutePath());
                C2564t.m12220b(str, sb.toString());
            }
        }
        z = false;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("check template usable3: ");
        sb2.append(a);
        sb2.append(StorageInterface.KEY_SPLITER);
        sb2.append(file.getAbsolutePath());
        C2564t.m12220b(str, sb2.toString());
        if (!z) {
            C2373f.m10918d();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("check template usable4: ");
        sb3.append(z);
        C2564t.m12220b(str, sb3.toString());
        this.f8387e = z;
    }

    /* renamed from: b */
    public boolean mo16366b() {
        return this.f8387e;
    }

    /* renamed from: c */
    public TempPkgModel mo16367c() {
        return C2373f.m10915b();
    }

    /* renamed from: d */
    public void mo16368d() {
        mo16365a(false);
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:58:0x0157 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0160 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:83:0x01d6 */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x018a A[EDGE_INSN: B:107:0x018a->B:73:0x018a ?: BREAK  
EDGE_INSN: B:107:0x018a->B:73:0x018a ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0198 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x019c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0123 A[SYNTHETIC, Splitter:B:53:0x0123] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x015d A[SYNTHETIC, Splitter:B:61:0x015d] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0184 A[SYNTHETIC, Splitter:B:70:0x0184] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01dc A[SYNTHETIC, Splitter:B:86:0x01dc] */
    /* renamed from: a */
    public void mo16365a(boolean r11) {
        /*
        r10 = this;
        java.util.concurrent.atomic.AtomicBoolean r0 = r10.f8385c
        boolean r0 = r0.get()
        java.lang.String r1 = "TemplateManager"
        if (r0 == 0) goto L_0x0010
        java.lang.String r11 = "loadTemplate error1"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r1, r11)
        return
    L_0x0010:
        java.util.concurrent.atomic.AtomicBoolean r0 = r10.f8386d     // Catch:{ all -> 0x0223 }
        boolean r0 = r0.get()     // Catch:{ all -> 0x0223 }
        if (r0 == 0) goto L_0x0034
        if (r11 == 0) goto L_0x001f
        java.util.concurrent.atomic.AtomicInteger r0 = r10.f8388f     // Catch:{ all -> 0x0223 }
        r0.getAndIncrement()     // Catch:{ all -> 0x0223 }
    L_0x001f:
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0223 }
        r0.<init>()     // Catch:{ all -> 0x0223 }
        java.lang.String r2 = "loadTemplate error2: "
        r0.append(r2)     // Catch:{ all -> 0x0223 }
        r0.append(r11)     // Catch:{ all -> 0x0223 }
        java.lang.String r11 = r0.toString()     // Catch:{ all -> 0x0223 }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r1, r11)     // Catch:{ all -> 0x0223 }
        return
    L_0x0034:
        java.util.concurrent.atomic.AtomicBoolean r11 = r10.f8386d     // Catch:{ all -> 0x0223 }
        r0 = 1
        r11.set(r0)     // Catch:{ all -> 0x0223 }
        com.bytedance.sdk.openadsdk.core.p r11 = com.bytedance.sdk.openadsdk.core.InternalContainer.m10067f()     // Catch:{ all -> 0x0223 }
        com.bytedance.sdk.openadsdk.core.d.o r11 = r11.mo15915a()     // Catch:{ all -> 0x0223 }
        com.bytedance.sdk.openadsdk.core.d.o r0 = com.bytedance.sdk.openadsdk.core.widget.webview.p179a.C2373f.m10915b()     // Catch:{ all -> 0x0223 }
        r2 = 0
        if (r11 == 0) goto L_0x0213
        boolean r3 = r11.mo15558e()     // Catch:{ all -> 0x0223 }
        if (r3 != 0) goto L_0x0051
        goto L_0x0213
    L_0x0051:
        java.lang.String r3 = r11.mo15553b()     // Catch:{ all -> 0x0223 }
        boolean r3 = com.bytedance.sdk.openadsdk.core.widget.webview.p179a.C2373f.m10916b(r3)     // Catch:{ all -> 0x0223 }
        if (r3 != 0) goto L_0x006f
        java.util.concurrent.atomic.AtomicBoolean r11 = r10.f8386d     // Catch:{ all -> 0x0223 }
        r11.set(r2)     // Catch:{ all -> 0x0223 }
        java.util.concurrent.atomic.AtomicLong r11 = r10.f8389g     // Catch:{ all -> 0x0223 }
        long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0223 }
        r11.set(r2)     // Catch:{ all -> 0x0223 }
        java.lang.String r11 = "loadTemplate error4"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r1, r11)     // Catch:{ all -> 0x0223 }
        return
    L_0x006f:
        java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0223 }
        r3.<init>()     // Catch:{ all -> 0x0223 }
        java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0223 }
        r4.<init>()     // Catch:{ all -> 0x0223 }
        if (r0 == 0) goto L_0x010b
        java.util.List r5 = r0.mo15557d()     // Catch:{ all -> 0x0223 }
        boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0223 }
        if (r5 == 0) goto L_0x0087
        goto L_0x010b
    L_0x0087:
        java.util.List r5 = r11.mo15557d()     // Catch:{ all -> 0x0223 }
        boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0223 }
        if (r5 == 0) goto L_0x009f
        java.util.List r0 = r0.mo15557d()     // Catch:{ all -> 0x0223 }
        r3.addAll(r0)     // Catch:{ all -> 0x0223 }
        java.lang.String r0 = "loadTemplate update2"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r1, r0)     // Catch:{ all -> 0x0223 }
        goto L_0x0117
    L_0x009f:
        java.util.List r5 = r11.mo15557d()     // Catch:{ all -> 0x0223 }
        java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0223 }
    L_0x00a7:
        boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0223 }
        if (r6 == 0) goto L_0x00e3
        java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x0223 }
        com.bytedance.sdk.openadsdk.core.d.o$a r6 = (com.bytedance.sdk.openadsdk.core.p170d.TempPkgModel.C2228a) r6     // Catch:{ all -> 0x0223 }
        java.util.List r7 = r0.mo15557d()     // Catch:{ all -> 0x0223 }
        boolean r7 = r7.contains(r6)     // Catch:{ all -> 0x0223 }
        if (r7 != 0) goto L_0x00c1
        r4.add(r6)     // Catch:{ all -> 0x0223 }
        goto L_0x00a7
    L_0x00c1:
        java.lang.String r7 = r6.mo15560a()     // Catch:{ all -> 0x0223 }
        com.bytedance.sdk.openadsdk.core.d.o$a r7 = com.bytedance.sdk.openadsdk.core.widget.webview.p179a.C2373f.m10912a(r7)     // Catch:{ all -> 0x0223 }
        if (r7 == 0) goto L_0x00a7
        java.lang.String r8 = r6.mo15563b()     // Catch:{ all -> 0x0223 }
        if (r8 == 0) goto L_0x00a7
        java.lang.String r8 = r6.mo15563b()     // Catch:{ all -> 0x0223 }
        java.lang.String r7 = r7.mo15563b()     // Catch:{ all -> 0x0223 }
        boolean r7 = r8.equals(r7)     // Catch:{ all -> 0x0223 }
        if (r7 != 0) goto L_0x00a7
        r4.add(r6)     // Catch:{ all -> 0x0223 }
        goto L_0x00a7
    L_0x00e3:
        java.util.List r0 = r0.mo15557d()     // Catch:{ all -> 0x0223 }
        java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0223 }
    L_0x00eb:
        boolean r5 = r0.hasNext()     // Catch:{ all -> 0x0223 }
        if (r5 == 0) goto L_0x0105
        java.lang.Object r5 = r0.next()     // Catch:{ all -> 0x0223 }
        com.bytedance.sdk.openadsdk.core.d.o$a r5 = (com.bytedance.sdk.openadsdk.core.p170d.TempPkgModel.C2228a) r5     // Catch:{ all -> 0x0223 }
        java.util.List r6 = r11.mo15557d()     // Catch:{ all -> 0x0223 }
        boolean r6 = r6.contains(r5)     // Catch:{ all -> 0x0223 }
        if (r6 != 0) goto L_0x00eb
        r3.add(r5)     // Catch:{ all -> 0x0223 }
        goto L_0x00eb
    L_0x0105:
        java.lang.String r0 = "loadTemplate update3"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r1, r0)     // Catch:{ all -> 0x0223 }
        goto L_0x0117
    L_0x010b:
        java.util.List r0 = r11.mo15557d()     // Catch:{ all -> 0x0223 }
        r4.addAll(r0)     // Catch:{ all -> 0x0223 }
        java.lang.String r0 = "loadTemplate update1"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r1, r0)     // Catch:{ all -> 0x0223 }
    L_0x0117:
        java.util.Iterator r0 = r4.iterator()     // Catch:{ all -> 0x0223 }
    L_0x011b:
        boolean r5 = r0.hasNext()     // Catch:{ all -> 0x0223 }
        java.lang.String r6 = ".tmp"
        if (r5 == 0) goto L_0x0198
        java.lang.Object r5 = r0.next()     // Catch:{ all -> 0x0223 }
        com.bytedance.sdk.openadsdk.core.d.o$a r5 = (com.bytedance.sdk.openadsdk.core.p170d.TempPkgModel.C2228a) r5     // Catch:{ all -> 0x0223 }
        java.lang.String r5 = r5.mo15560a()     // Catch:{ all -> 0x0223 }
        java.lang.String r7 = com.bytedance.sdk.openadsdk.utils.DigestUtils.m12169a(r5)     // Catch:{ all -> 0x0223 }
        java.io.File r8 = new java.io.File     // Catch:{ all -> 0x0223 }
        java.io.File r9 = m10879e()     // Catch:{ all -> 0x0223 }
        r8.<init>(r9, r7)     // Catch:{ all -> 0x0223 }
        java.io.File r7 = new java.io.File     // Catch:{ all -> 0x0223 }
        java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0223 }
        r9.<init>()     // Catch:{ all -> 0x0223 }
        r9.append(r8)     // Catch:{ all -> 0x0223 }
        r9.append(r6)     // Catch:{ all -> 0x0223 }
        java.lang.String r6 = r9.toString()     // Catch:{ all -> 0x0223 }
        r7.<init>(r6)     // Catch:{ all -> 0x0223 }
        boolean r6 = r8.exists()     // Catch:{ all -> 0x0223 }
        if (r6 == 0) goto L_0x0157
        r8.delete()     // Catch:{ all -> 0x0157 }
    L_0x0157:
        boolean r6 = r7.exists()     // Catch:{ all -> 0x0223 }
        if (r6 == 0) goto L_0x0160
        r7.delete()     // Catch:{ all -> 0x0160 }
    L_0x0160:
        com.bytedance.sdk.adnet.b.i r6 = com.bytedance.sdk.adnet.p159b.RequestFuture.m7746a()     // Catch:{ all -> 0x0223 }
        com.bytedance.sdk.adnet.b.c r7 = new com.bytedance.sdk.adnet.b.c     // Catch:{ all -> 0x0223 }
        java.lang.String r8 = r8.getAbsolutePath()     // Catch:{ all -> 0x0223 }
        r7.m43110init(r8, r5, r6)     // Catch:{ all -> 0x0223 }
        android.content.Context r5 = com.bytedance.sdk.openadsdk.core.InternalContainer.m10059a()     // Catch:{ all -> 0x0223 }
        com.bytedance.sdk.openadsdk.g.e r5 = com.bytedance.sdk.openadsdk.p188g.TTNetClient.m11428a(r5)     // Catch:{ all -> 0x0223 }
        com.bytedance.sdk.adnet.core.o r5 = r5.mo16656c()     // Catch:{ all -> 0x0223 }
        r7.build(r5)     // Catch:{ all -> 0x0223 }
        com.bytedance.sdk.adnet.core.p r5 = r6.get()     // Catch:{ all -> 0x0181 }
        goto L_0x0182
    L_0x0181:
        r5 = 0
    L_0x0182:
        if (r5 == 0) goto L_0x018a
        boolean r5 = r5.mo14373a()     // Catch:{ all -> 0x0223 }
        if (r5 != 0) goto L_0x011b
    L_0x018a:
        java.util.concurrent.atomic.AtomicBoolean r11 = r10.f8386d     // Catch:{ all -> 0x0223 }
        r11.set(r2)     // Catch:{ all -> 0x0223 }
        r10.m10877a(r4)     // Catch:{ all -> 0x0223 }
        java.lang.String r11 = "loadTemplate error5"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r1, r11)     // Catch:{ all -> 0x0223 }
        return
    L_0x0198:
        java.util.Iterator r0 = r3.iterator()     // Catch:{ all -> 0x0223 }
    L_0x019c:
        boolean r3 = r0.hasNext()     // Catch:{ all -> 0x0223 }
        if (r3 == 0) goto L_0x01e0
        java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x0223 }
        com.bytedance.sdk.openadsdk.core.d.o$a r3 = (com.bytedance.sdk.openadsdk.core.p170d.TempPkgModel.C2228a) r3     // Catch:{ all -> 0x0223 }
        java.lang.String r3 = r3.mo15560a()     // Catch:{ all -> 0x0223 }
        java.lang.String r3 = com.bytedance.sdk.openadsdk.utils.DigestUtils.m12169a(r3)     // Catch:{ all -> 0x0223 }
        java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0223 }
        java.io.File r5 = m10879e()     // Catch:{ all -> 0x0223 }
        r4.<init>(r5, r3)     // Catch:{ all -> 0x0223 }
        java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0223 }
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0223 }
        r5.<init>()     // Catch:{ all -> 0x0223 }
        r5.append(r4)     // Catch:{ all -> 0x0223 }
        r5.append(r6)     // Catch:{ all -> 0x0223 }
        java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0223 }
        r3.<init>(r5)     // Catch:{ all -> 0x0223 }
        boolean r5 = r4.exists()     // Catch:{ all -> 0x0223 }
        if (r5 == 0) goto L_0x01d6
        r4.delete()     // Catch:{ all -> 0x01d6 }
    L_0x01d6:
        boolean r4 = r3.exists()     // Catch:{ all -> 0x0223 }
        if (r4 == 0) goto L_0x019c
        r3.delete()     // Catch:{ all -> 0x019c }
        goto L_0x019c
    L_0x01e0:
        com.bytedance.sdk.openadsdk.core.widget.webview.p179a.C2373f.m10914a(r11)     // Catch:{ all -> 0x0223 }
        com.bytedance.sdk.openadsdk.core.widget.webview.p179a.C2373f.m10917c()     // Catch:{ all -> 0x0223 }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0223 }
        r0.<init>()     // Catch:{ all -> 0x0223 }
        java.lang.String r3 = "loadTemplate update success: "
        r0.append(r3)     // Catch:{ all -> 0x0223 }
        java.lang.String r11 = r11.mo15553b()     // Catch:{ all -> 0x0223 }
        r0.append(r11)     // Catch:{ all -> 0x0223 }
        java.lang.String r11 = r0.toString()     // Catch:{ all -> 0x0223 }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r1, r11)     // Catch:{ all -> 0x0223 }
        r10.m10881g()     // Catch:{ all -> 0x0223 }
        java.util.concurrent.atomic.AtomicBoolean r11 = r10.f8386d     // Catch:{ all -> 0x0223 }
        r11.set(r2)     // Catch:{ all -> 0x0223 }
        java.util.concurrent.atomic.AtomicLong r11 = r10.f8389g     // Catch:{ all -> 0x0223 }
        long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0223 }
        r11.set(r2)     // Catch:{ all -> 0x0223 }
        r10.m10882h()     // Catch:{ all -> 0x0223 }
        goto L_0x0229
    L_0x0213:
        java.util.concurrent.atomic.AtomicBoolean r11 = r10.f8386d     // Catch:{ all -> 0x0223 }
        r11.set(r2)     // Catch:{ all -> 0x0223 }
        r11 = 109(0x6d, float:1.53E-43)
        r10.m10876a(r11)     // Catch:{ all -> 0x0223 }
        java.lang.String r11 = "loadTemplate error3"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r1, r11)     // Catch:{ all -> 0x0223 }
        return
    L_0x0223:
        r11 = move-exception
        java.lang.String r0 = "loadTemplate error: "
        com.bytedance.sdk.openadsdk.utils.C2564t.m12216a(r1, r0, r11)
    L_0x0229:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.widget.webview.p179a.TemplateManager.mo16365a(boolean):void");
    }

    /* renamed from: a */
    private void m10876a(int i) {
        StatsLogManager.m11278a().mo16576h(LogStatsBase.m11308b().mo16592b(i).mo16603g(C2240g.m9576a(i)));
    }

    /* renamed from: h */
    private void m10882h() {
        if (this.f8388f.getAndSet(0) > 0 && System.currentTimeMillis() - this.f8389g.get() > 600000) {
            mo16368d();
        }
    }

    /* renamed from: a */
    private void m10877a(List<C2228a> list) {
        if (list != null && !list.isEmpty()) {
            for (C2228a a : list) {
                File file = new File(m10879e(), DigestUtils.m12169a(a.mo15560a()));
                StringBuilder sb = new StringBuilder();
                sb.append(file);
                sb.append(".tmp");
                File file2 = new File(sb.toString());
                if (file.exists()) {
                    try {
                        file.delete();
                    } catch (Throwable unused) {
                    }
                }
                if (file2.exists()) {
                    try {
                        file2.delete();
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
    }

    /* renamed from: e */
    public static File m10879e() {
        File file;
        if (f8383a == null) {
            try {
                if (("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) && InternalContainer.m10059a().getExternalCacheDir() != null) {
                    file = InternalContainer.m10059a().getExternalCacheDir();
                } else {
                    file = InternalContainer.m10059a().getCacheDir();
                }
                File file2 = new File(new File(file, "tt_tmpl_pkg"), "template");
                file2.mkdirs();
                f8383a = file2;
            } catch (Throwable th) {
                C2564t.m12223c("TemplateManager", "getTemplateDir error", th);
            }
        }
        return f8383a;
    }
}
