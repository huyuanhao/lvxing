package com.kwad.sdk.core.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.kwad.sdk.core.videocache.p343a.C4334b;
import java.io.File;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.kwad.sdk.core.videocache.g */
final class C4358g {
    /* renamed from: a */
    private final AtomicInteger f14282a = new AtomicInteger(0);
    /* renamed from: b */
    private final String f14283b;
    /* renamed from: c */
    private volatile C4352e f14284c;
    /* renamed from: d */
    private final List<C4343b> f14285d = new CopyOnWriteArrayList();
    /* renamed from: e */
    private final C4343b f14286e;
    /* renamed from: f */
    private final C4346c f14287f;

    /* renamed from: com.kwad.sdk.core.videocache.g$a */
    private static final class C4359a extends Handler implements C4343b {
        /* renamed from: a */
        private final String f14288a;
        /* renamed from: b */
        private final List<C4343b> f14289b;

        public C4359a(String str, List<C4343b> list) {
            super(Looper.getMainLooper());
            this.f14288a = str;
            this.f14289b = list;
        }

        /* renamed from: a */
        public void mo24495a(File file, String str, int i) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }

        public void handleMessage(Message message) {
            for (C4343b a : this.f14289b) {
                a.mo24495a((File) message.obj, this.f14288a, message.arg1);
            }
        }
    }

    public C4358g(String str, C4346c cVar) {
        this.f14283b = (String) C4362j.m17805a(str);
        this.f14287f = (C4346c) C4362j.m17805a(cVar);
        this.f14286e = new C4359a(str, this.f14285d);
    }

    /* renamed from: b */
    private synchronized void m17787b() {
        this.f14284c = this.f14284c == null ? m17789d() : this.f14284c;
    }

    /* renamed from: c */
    private synchronized void m17788c() {
        if (this.f14282a.decrementAndGet() <= 0) {
            this.f14284c.mo24526a();
            this.f14284c = null;
        }
    }

    /* renamed from: d */
    private C4352e m17789d() {
        C4352e eVar = new C4352e(new C4360h(this.f14283b, this.f14287f.f14254d, this.f14287f.f14255e), new C4334b(this.f14287f.mo24497a(this.f14283b), this.f14287f.f14253c));
        eVar.mo24504a(this.f14286e);
        return eVar;
    }

    /* renamed from: a */
    public int mo24513a() {
        return this.f14282a.get();
    }

    /* renamed from: a */
    public void mo24514a(C4348d dVar, Socket socket) {
        m17787b();
        try {
            this.f14282a.incrementAndGet();
            this.f14284c.mo24505a(dVar, socket);
        } finally {
            m17788c();
        }
    }
}
