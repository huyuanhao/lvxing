package com.qiyukf.basesdk.p394b.p406b.p409c;

import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p394b.p406b.p407a.C5322b;
import com.qiyukf.basesdk.p394b.p406b.p407a.C5339k;
import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.qiyukf.basesdk.b.b.c.f */
public final class C5352f extends C5355h {
    /* renamed from: a */
    private static final String f17278a = C5352f.class.getSimpleName();
    /* renamed from: b */
    private Selector f17279b = m21968m();
    /* renamed from: c */
    private final SelectorProvider f17280c = SelectorProvider.provider();
    /* renamed from: d */
    private final AtomicBoolean f17281d = new AtomicBoolean();
    /* renamed from: e */
    private boolean f17282e;
    /* renamed from: f */
    private boolean f17283f;

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0065, code lost:
            r5 = r4.f17279b.selectedKeys();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006f, code lost:
            if (r5.isEmpty() != false) goto L_0x0072;
     */
    /* renamed from: a */
    private void m21967a(java.util.Set<java.nio.channels.SelectionKey> r5) {
        /*
        r4 = this;
        boolean r0 = r5.isEmpty()
        if (r0 == 0) goto L_0x0007
        return
    L_0x0007:
        java.util.Iterator r5 = r5.iterator()
    L_0x000b:
        java.lang.Object r0 = r5.next()
        java.nio.channels.SelectionKey r0 = (java.nio.channels.SelectionKey) r0
        java.lang.Object r1 = r0.attachment()
        r5.remove()
        boolean r2 = r1 instanceof com.qiyukf.basesdk.p394b.p406b.p407a.C5339k
        if (r2 == 0) goto L_0x005b
        com.qiyukf.basesdk.b.b.a.k r1 = (com.qiyukf.basesdk.p394b.p406b.p407a.C5339k) r1
        boolean r2 = r0.isValid()
        if (r2 != 0) goto L_0x0028
    L_0x0024:
        r1.mo27231e()
        goto L_0x005b
    L_0x0028:
        int r2 = r0.readyOps()     // Catch:{ CancelledKeyException -> 0x0024 }
        r3 = r2 & 1
        if (r3 != 0) goto L_0x0032
        if (r2 != 0) goto L_0x003c
    L_0x0032:
        r1.mo27280h()     // Catch:{ CancelledKeyException -> 0x0024 }
        boolean r3 = r1.mo27230d()     // Catch:{ CancelledKeyException -> 0x0024 }
        if (r3 != 0) goto L_0x003c
        goto L_0x005b
    L_0x003c:
        r3 = r2 & 4
        if (r3 == 0) goto L_0x0047
        com.qiyukf.basesdk.b.b.d.a r3 = r1.mo27228b()     // Catch:{ CancelledKeyException -> 0x0024 }
        r3.mo27312d()     // Catch:{ CancelledKeyException -> 0x0024 }
    L_0x0047:
        r2 = r2 & 8
        if (r2 == 0) goto L_0x005b
        int r2 = r0.interestOps()     // Catch:{ CancelledKeyException -> 0x0024 }
        r2 = r2 & -9
        r0.interestOps(r2)     // Catch:{ CancelledKeyException -> 0x0024 }
        com.qiyukf.basesdk.b.b.a.g r0 = r1.mo27226a()     // Catch:{ CancelledKeyException -> 0x0024 }
        r0.mo27260b()     // Catch:{ CancelledKeyException -> 0x0024 }
    L_0x005b:
        boolean r0 = r5.hasNext()
        if (r0 == 0) goto L_0x0072
        boolean r0 = r4.f17283f
        if (r0 == 0) goto L_0x000b
        java.nio.channels.Selector r5 = r4.f17279b
        java.util.Set r5 = r5.selectedKeys()
        boolean r0 = r5.isEmpty()
        if (r0 != 0) goto L_0x0072
        goto L_0x0007
    L_0x0072:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.p394b.p406b.p409c.C5352f.m21967a(java.util.Set):void");
    }

    /* renamed from: m */
    private Selector m21968m() {
        try {
            return this.f17280c.openSelector();
        } catch (IOException e) {
            throw new C5322b("failed to open a new selector", e);
        }
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Regions count limit reached
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:694)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:694)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:30)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
        	at jadx.core.ProcessClass.process(ProcessClass.java:35)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0026 A[Catch:{ ConcurrentModificationException -> 0x0018 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x006d A[SYNTHETIC] */
    /* renamed from: n */
    public void m21969n() {
        /*
        r7 = this;
        boolean r0 = r7.mo27299h()
        if (r0 != 0) goto L_0x000f
        com.qiyukf.basesdk.b.b.c.f$1 r0 = new com.qiyukf.basesdk.b.b.c.f$1
        r0.m49479init()
        r7.execute(r0)
        return
    L_0x000f:
        java.nio.channels.Selector r0 = r7.f17279b
        if (r0 != 0) goto L_0x0014
        return
    L_0x0014:
        java.nio.channels.Selector r1 = r7.m21968m()     // Catch:{ Exception -> 0x007c }
    L_0x0018:
        java.util.Set r2 = r0.keys()     // Catch:{ ConcurrentModificationException -> 0x0018 }
        java.util.Iterator r2 = r2.iterator()     // Catch:{ ConcurrentModificationException -> 0x0018 }
    L_0x0020:
        boolean r3 = r2.hasNext()     // Catch:{ ConcurrentModificationException -> 0x0018 }
        if (r3 == 0) goto L_0x006d     // Catch:{ ConcurrentModificationException -> 0x0018 }
        java.lang.Object r3 = r2.next()     // Catch:{ ConcurrentModificationException -> 0x0018 }
        java.nio.channels.SelectionKey r3 = (java.nio.channels.SelectionKey) r3     // Catch:{ ConcurrentModificationException -> 0x0018 }
        java.lang.Object r4 = r3.attachment()     // Catch:{ ConcurrentModificationException -> 0x0018 }
        boolean r5 = r3.isValid()     // Catch:{ Exception -> 0x005b }
        if (r5 == 0) goto L_0x0020     // Catch:{ Exception -> 0x005b }
        java.nio.channels.SelectableChannel r5 = r3.channel()     // Catch:{ Exception -> 0x005b }
        java.nio.channels.SelectionKey r5 = r5.keyFor(r1)     // Catch:{ Exception -> 0x005b }
        if (r5 == 0) goto L_0x0041     // Catch:{ Exception -> 0x005b }
        goto L_0x0020     // Catch:{ Exception -> 0x005b }
    L_0x0041:
        int r5 = r3.interestOps()     // Catch:{ Exception -> 0x005b }
        r3.cancel()     // Catch:{ Exception -> 0x005b }
        java.nio.channels.SelectableChannel r3 = r3.channel()     // Catch:{ Exception -> 0x005b }
        java.nio.channels.SelectionKey r3 = r3.register(r1, r5, r4)     // Catch:{ Exception -> 0x005b }
        boolean r5 = r4 instanceof com.qiyukf.basesdk.p394b.p406b.p407a.C5339k     // Catch:{ Exception -> 0x005b }
        if (r5 == 0) goto L_0x0020     // Catch:{ Exception -> 0x005b }
        r5 = r4     // Catch:{ Exception -> 0x005b }
        com.qiyukf.basesdk.b.b.a.k r5 = (com.qiyukf.basesdk.p394b.p406b.p407a.C5339k) r5     // Catch:{ Exception -> 0x005b }
        r5.mo27279a(r3)     // Catch:{ Exception -> 0x005b }
        goto L_0x0020
    L_0x005b:
        r3 = move-exception
        java.lang.String r5 = f17278a     // Catch:{ ConcurrentModificationException -> 0x0018 }
        java.lang.String r6 = "Failed to re-register a Channel to the new Selector."     // Catch:{ ConcurrentModificationException -> 0x0018 }
        com.qiyukf.basesdk.p393a.C5264a.m21625d(r5, r6, r3)     // Catch:{ ConcurrentModificationException -> 0x0018 }
        boolean r3 = r4 instanceof com.qiyukf.basesdk.p394b.p406b.p407a.C5339k     // Catch:{ ConcurrentModificationException -> 0x0018 }
        if (r3 == 0) goto L_0x0020     // Catch:{ ConcurrentModificationException -> 0x0018 }
        com.qiyukf.basesdk.b.b.a.k r4 = (com.qiyukf.basesdk.p394b.p406b.p407a.C5339k) r4     // Catch:{ ConcurrentModificationException -> 0x0018 }
        r4.mo27231e()     // Catch:{ ConcurrentModificationException -> 0x0018 }
        goto L_0x0020
    L_0x006d:
        r7.f17279b = r1
        r0.close()     // Catch:{ all -> 0x0073 }
        return
    L_0x0073:
        r0 = move-exception
        java.lang.String r1 = f17278a
        java.lang.String r2 = "Failed to close the old Selector."
        com.qiyukf.basesdk.p393a.C5264a.m21625d(r1, r2, r0)
        return
    L_0x007c:
        r0 = move-exception
        java.lang.String r1 = f17278a
        java.lang.String r2 = "Failed to create a new Selector."
        com.qiyukf.basesdk.p393a.C5264a.m21625d(r1, r2, r0)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.p394b.p406b.p409c.C5352f.m21969n():void");
    }

    /* renamed from: o */
    private void m21970o() {
        Set<SelectionKey> keys = this.f17279b.keys();
        ArrayList<C5339k> arrayList = new ArrayList<>(keys.size());
        for (SelectionKey attachment : keys) {
            Object attachment2 = attachment.attachment();
            if (attachment2 instanceof C5339k) {
                arrayList.add((C5339k) attachment2);
            }
        }
        for (C5339k e : arrayList) {
            e.mo27231e();
        }
    }

    /* renamed from: a */
    public final Selector mo27288a() {
        return this.f17279b;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo27289a(boolean z) {
        if (!z && this.f17281d.compareAndSet(false, true)) {
            this.f17279b.wakeup();
        }
    }

    /* access modifiers changed from: protected|final */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
            if (r6 == 0) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
            r0.selectNow();
     */
    /* renamed from: b */
    public final void mo27290b() {
        /*
        r12 = this;
    L_0x0000:
        java.util.concurrent.atomic.AtomicBoolean r0 = r12.f17281d
        r1 = 0
        boolean r0 = r0.getAndSet(r1)
        r12.f17282e = r0
        boolean r0 = r12.mo27295e()     // Catch:{ all -> 0x00e4 }
        if (r0 == 0) goto L_0x0014
        r12.mo27292d()     // Catch:{ all -> 0x00e4 }
        goto L_0x00c6
    L_0x0014:
        java.nio.channels.Selector r0 = r12.f17279b     // Catch:{ all -> 0x00e4 }
        long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ CancelledKeyException -> 0x009c }
        long r4 = r12.mo27298g()     // Catch:{ CancelledKeyException -> 0x009c }
        long r4 = r4 + r2
        r6 = 0
    L_0x0020:
        long r2 = r4 - r2
        r7 = 0
        java.lang.String r9 = "Selector.select() returned prematurely "
        r10 = 1
        int r11 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
        if (r11 > 0) goto L_0x0033
        if (r6 != 0) goto L_0x0031
    L_0x002d:
        r0.selectNow()     // Catch:{ CancelledKeyException -> 0x009c }
        goto L_0x0080
    L_0x0031:
        r10 = r6
        goto L_0x0080
    L_0x0033:
        int r2 = r0.select(r2)     // Catch:{ CancelledKeyException -> 0x009c }
        int r6 = r6 + 1
        if (r2 != 0) goto L_0x0031
        boolean r2 = r12.f17282e     // Catch:{ CancelledKeyException -> 0x009c }
        if (r2 != 0) goto L_0x0031
        java.util.concurrent.atomic.AtomicBoolean r2 = r12.f17281d     // Catch:{ CancelledKeyException -> 0x009c }
        boolean r2 = r2.get()     // Catch:{ CancelledKeyException -> 0x009c }
        if (r2 != 0) goto L_0x0031
        boolean r2 = r12.mo27295e()     // Catch:{ CancelledKeyException -> 0x009c }
        if (r2 != 0) goto L_0x0031
        boolean r2 = java.lang.Thread.interrupted()     // Catch:{ CancelledKeyException -> 0x009c }
        if (r2 == 0) goto L_0x005b
        java.lang.String r0 = f17278a     // Catch:{ CancelledKeyException -> 0x009c }
        java.lang.String r2 = "Selector.select() returned prematurely because Thread.currentThread().interrupt() was called. Use NioEventLoop.shutdownGracefully() to shutdown the NioEventLoop."
        com.qiyukf.basesdk.p393a.C5264a.m21624d(r0, r2)     // Catch:{ CancelledKeyException -> 0x009c }
        goto L_0x0080
    L_0x005b:
        r2 = 512(0x200, float:7.175E-43)
        if (r6 < r2) goto L_0x007b
        java.lang.String r0 = f17278a     // Catch:{ CancelledKeyException -> 0x009c }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ CancelledKeyException -> 0x009c }
        r2.<init>(r9)     // Catch:{ CancelledKeyException -> 0x009c }
        r2.append(r6)     // Catch:{ CancelledKeyException -> 0x009c }
        java.lang.String r3 = " times in a row; rebuilding selector."
        r2.append(r3)     // Catch:{ CancelledKeyException -> 0x009c }
        java.lang.String r2 = r2.toString()     // Catch:{ CancelledKeyException -> 0x009c }
        com.qiyukf.basesdk.p393a.C5264a.m21624d(r0, r2)     // Catch:{ CancelledKeyException -> 0x009c }
        r12.m21969n()     // Catch:{ CancelledKeyException -> 0x009c }
        java.nio.channels.Selector r0 = r12.f17279b     // Catch:{ CancelledKeyException -> 0x009c }
        goto L_0x002d
    L_0x007b:
        long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ CancelledKeyException -> 0x009c }
        goto L_0x0020
    L_0x0080:
        r0 = 3
        if (r10 <= r0) goto L_0x00b9
        java.lang.String r0 = f17278a     // Catch:{ CancelledKeyException -> 0x009c }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ CancelledKeyException -> 0x009c }
        r2.<init>(r9)     // Catch:{ CancelledKeyException -> 0x009c }
        int r10 = r10 + -1
        r2.append(r10)     // Catch:{ CancelledKeyException -> 0x009c }
        java.lang.String r3 = " times in a row."
        r2.append(r3)     // Catch:{ CancelledKeyException -> 0x009c }
        java.lang.String r2 = r2.toString()     // Catch:{ CancelledKeyException -> 0x009c }
        com.qiyukf.basesdk.p393a.C5264a.m21624d(r0, r2)     // Catch:{ CancelledKeyException -> 0x009c }
        goto L_0x00b9
    L_0x009c:
        r0 = move-exception
        java.lang.String r2 = f17278a     // Catch:{ all -> 0x00e4 }
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e4 }
        r3.<init>()     // Catch:{ all -> 0x00e4 }
        java.lang.Class<java.nio.channels.CancelledKeyException> r4 = java.nio.channels.CancelledKeyException.class
        java.lang.String r4 = r4.getSimpleName()     // Catch:{ all -> 0x00e4 }
        r3.append(r4)     // Catch:{ all -> 0x00e4 }
        java.lang.String r4 = " raised by a Selector - JDK bug?"
        r3.append(r4)     // Catch:{ all -> 0x00e4 }
        java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00e4 }
        com.qiyukf.basesdk.p393a.C5264a.m21623c(r2, r3, r0)     // Catch:{ all -> 0x00e4 }
    L_0x00b9:
        java.util.concurrent.atomic.AtomicBoolean r0 = r12.f17281d     // Catch:{ all -> 0x00e4 }
        boolean r0 = r0.get()     // Catch:{ all -> 0x00e4 }
        if (r0 == 0) goto L_0x00c6
        java.nio.channels.Selector r0 = r12.f17279b     // Catch:{ all -> 0x00e4 }
        r0.wakeup()     // Catch:{ all -> 0x00e4 }
    L_0x00c6:
        r12.f17283f = r1     // Catch:{ all -> 0x00e4 }
        java.nio.channels.Selector r0 = r12.f17279b     // Catch:{ all -> 0x00e4 }
        java.util.Set r0 = r0.selectedKeys()     // Catch:{ all -> 0x00e4 }
        r12.m21967a(r0)     // Catch:{ all -> 0x00e4 }
        r12.mo27297f()     // Catch:{ all -> 0x00e4 }
        boolean r0 = r12.mo27301j()     // Catch:{ all -> 0x00e4 }
        if (r0 == 0) goto L_0x0000
        r12.m21970o()     // Catch:{ all -> 0x00e4 }
        boolean r0 = r12.mo27302k()     // Catch:{ all -> 0x00e4 }
        if (r0 == 0) goto L_0x0000
        return
    L_0x00e4:
        r0 = move-exception
        java.lang.String r1 = f17278a
        java.lang.String r2 = "Unexpected exception in the selector loop."
        com.qiyukf.basesdk.p393a.C5264a.m21625d(r1, r2, r0)
        r0 = 1000(0x3e8, double:4.94E-321)
        java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0000 }
        goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.p394b.p406b.p409c.C5352f.mo27290b():void");
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: c */
    public final void mo27291c() {
        try {
            this.f17279b.close();
        } catch (IOException e) {
            C5264a.m21625d(f17278a, "Failed to close a selector.", e);
        }
    }

    /* renamed from: d */
    public final void mo27292d() {
        try {
            this.f17279b.selectNow();
        } finally {
            if (this.f17281d.get()) {
                this.f17279b.wakeup();
            }
        }
    }
}
