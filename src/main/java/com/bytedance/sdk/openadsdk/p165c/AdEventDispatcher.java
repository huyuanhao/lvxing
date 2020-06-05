package com.bytedance.sdk.openadsdk.p165c;

import android.os.Handler;
import android.os.Message;
import com.bytedance.sdk.openadsdk.core.NetApi;
import com.bytedance.sdk.openadsdk.p165c.AdEventThread.C2086a;
import com.bytedance.sdk.openadsdk.p165c.AdEventThread.C2087b;
import com.bytedance.sdk.openadsdk.p165c.EventFace;
import com.bytedance.sdk.openadsdk.p185f.p187b.LogUploaderImpl.C2424a;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.bytedance.sdk.openadsdk.c.b */
public class AdEventDispatcher<T extends EventFace> {
    /* renamed from: a */
    private AdEventThread<T> f6745a;
    /* renamed from: b */
    private Handler f6746b;
    /* renamed from: c */
    private AtomicBoolean f6747c;

    /* compiled from: AdEventDispatcher */
    /* renamed from: com.bytedance.sdk.openadsdk.c.b$a */
    private static class C2084a extends AdEventDispatcher<AdEvent> {
        /* renamed from: a */
        private static volatile C2084a f6748a;

        /* renamed from: a */
        public void mo14998a(AdEvent aVar) {
        }

        /* renamed from: b */
        public void mo14999b() {
        }

        /* renamed from: e */
        public static C2084a m8365e() {
            if (f6748a == null) {
                synchronized (C2084a.class) {
                    if (f6748a == null) {
                        f6748a = new C2084a();
                    }
                }
            }
            return f6748a;
        }

        C2084a() {
        }

        /* renamed from: a */
        public synchronized void mo14997a() {
        }
    }

    /* compiled from: AdEventDispatcher */
    /* renamed from: com.bytedance.sdk.openadsdk.c.b$b */
    private static class C2085b extends AdEventDispatcher<C2424a> {
        /* renamed from: a */
        private static volatile C2085b f6749a;

        /* renamed from: a */
        public void mo14998a(C2424a aVar) {
        }

        /* renamed from: b */
        public void mo14999b() {
        }

        /* renamed from: e */
        public static C2085b m8370e() {
            if (f6749a == null) {
                synchronized (C2085b.class) {
                    if (f6749a == null) {
                        f6749a = new C2085b();
                    }
                }
            }
            return f6749a;
        }

        C2085b() {
        }

        /* renamed from: a */
        public synchronized void mo14997a() {
        }
    }

    public AdEventDispatcher(AdEventRepertory<T> eVar, NetApi<T> pVar, C2087b bVar, C2086a aVar) {
        this.f6745a = new AdEventThread<>(eVar, pVar, bVar, aVar);
        this.f6747c = new AtomicBoolean(false);
    }

    public AdEventDispatcher(AdEventRepertory<T> eVar, NetApi<T> pVar, C2087b bVar, C2086a aVar, AdEventThread<T> gVar) {
        this.f6745a = gVar;
        this.f6747c = new AtomicBoolean(false);
    }

    AdEventDispatcher() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004c, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
            return;
     */
    /* renamed from: a */
    public synchronized void mo14997a() {
        /*
        r3 = this;
        monitor-enter(r3)
        java.util.concurrent.atomic.AtomicBoolean r0 = r3.f6747c     // Catch:{ all -> 0x004d }
        if (r0 == 0) goto L_0x000d
        java.util.concurrent.atomic.AtomicBoolean r0 = r3.f6747c     // Catch:{ all -> 0x004d }
        boolean r0 = r0.get()     // Catch:{ all -> 0x004d }
        if (r0 != 0) goto L_0x0015
    L_0x000d:
        com.bytedance.sdk.openadsdk.c.g<T> r0 = r3.f6745a     // Catch:{ all -> 0x004d }
        android.os.Looper r0 = r0.getLooper()     // Catch:{ all -> 0x004d }
        if (r0 == 0) goto L_0x0017
    L_0x0015:
        monitor-exit(r3)
        return
    L_0x0017:
        java.util.concurrent.atomic.AtomicBoolean r0 = r3.f6747c     // Catch:{ all -> 0x004d }
        if (r0 == 0) goto L_0x004b
        java.util.concurrent.atomic.AtomicBoolean r0 = r3.f6747c     // Catch:{ all -> 0x004d }
        boolean r0 = r0.get()     // Catch:{ all -> 0x004d }
        if (r0 != 0) goto L_0x004b
        com.bytedance.sdk.openadsdk.c.g<T> r0 = r3.f6745a     // Catch:{ all -> 0x004d }
        r0.start()     // Catch:{ all -> 0x004d }
        android.os.Handler r0 = new android.os.Handler     // Catch:{ all -> 0x004d }
        com.bytedance.sdk.openadsdk.c.g<T> r1 = r3.f6745a     // Catch:{ all -> 0x004d }
        android.os.Looper r1 = r1.getLooper()     // Catch:{ all -> 0x004d }
        com.bytedance.sdk.openadsdk.c.g<T> r2 = r3.f6745a     // Catch:{ all -> 0x004d }
        r0.<init>(r1, r2)     // Catch:{ all -> 0x004d }
        r3.f6746b = r0     // Catch:{ all -> 0x004d }
        android.os.Handler r0 = r3.f6746b     // Catch:{ all -> 0x004d }
        android.os.Message r0 = r0.obtainMessage()     // Catch:{ all -> 0x004d }
        r1 = 5
        r0.what = r1     // Catch:{ all -> 0x004d }
        android.os.Handler r1 = r3.f6746b     // Catch:{ all -> 0x004d }
        r1.sendMessage(r0)     // Catch:{ all -> 0x004d }
        java.util.concurrent.atomic.AtomicBoolean r0 = r3.f6747c     // Catch:{ all -> 0x004d }
        r1 = 1
        r0.set(r1)     // Catch:{ all -> 0x004d }
    L_0x004b:
        monitor-exit(r3)
        return
    L_0x004d:
        r0 = move-exception
        monitor-exit(r3)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.p165c.AdEventDispatcher.mo14997a():void");
    }

    /* renamed from: b */
    public void mo14999b() {
        this.f6747c.set(false);
        this.f6745a.quit();
        this.f6746b.removeCallbacksAndMessages(null);
    }

    /* renamed from: a */
    public void mo14998a(T t) {
        if (this.f6747c.get()) {
            Message obtainMessage = this.f6746b.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = t;
            this.f6746b.sendMessage(obtainMessage);
        }
    }

    /* renamed from: c */
    public static C2084a m8360c() {
        return C2084a.m8365e();
    }

    /* renamed from: d */
    public static C2085b m8361d() {
        return C2085b.m8370e();
    }
}
