package com.bytedance.sdk.p145a.p147b;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

/* renamed from: com.bytedance.sdk.a.b.s */
public abstract class EventListener {
    /* renamed from: a */
    public static final EventListener f5953a = new EventListener() {
    };

    /* compiled from: EventListener */
    /* renamed from: com.bytedance.sdk.a.b.s$a */
    public interface C1934a {
        /* renamed from: a */
        EventListener mo14064a(Call hVar);
    }

    /* renamed from: a */
    public void mo14044a(Call hVar) {
    }

    /* renamed from: a */
    public void mo14045a(Call hVar, long j) {
    }

    /* renamed from: a */
    public void mo14046a(Call hVar, C1918ab abVar) {
    }

    /* renamed from: a */
    public void mo14047a(Call hVar, Response bVar) {
    }

    /* renamed from: a */
    public void mo14048a(Call hVar, Connection lVar) {
    }

    /* renamed from: a */
    public void mo14049a(Call hVar, Handshake tVar) {
    }

    /* renamed from: a */
    public void mo14050a(Call hVar, IOException iOException) {
    }

    /* renamed from: a */
    public void mo14051a(Call hVar, String str) {
    }

    /* renamed from: a */
    public void mo14052a(Call hVar, String str, List<InetAddress> list) {
    }

    /* renamed from: a */
    public void mo14053a(Call hVar, InetSocketAddress inetSocketAddress, Proxy proxy) {
    }

    /* renamed from: a */
    public void mo14054a(Call hVar, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol wVar) {
    }

    /* renamed from: a */
    public void mo14055a(Call hVar, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol wVar, IOException iOException) {
    }

    /* renamed from: b */
    public void mo14056b(Call hVar) {
    }

    /* renamed from: b */
    public void mo14057b(Call hVar, long j) {
    }

    /* renamed from: b */
    public void mo14058b(Call hVar, Connection lVar) {
    }

    /* renamed from: c */
    public void mo14059c(Call hVar) {
    }

    /* renamed from: d */
    public void mo14060d(Call hVar) {
    }

    /* renamed from: e */
    public void mo14061e(Call hVar) {
    }

    /* renamed from: f */
    public void mo14062f(Call hVar) {
    }

    /* renamed from: g */
    public void mo14063g(Call hVar) {
    }

    /* renamed from: a */
    static C1934a m7496a(EventListener sVar) {
        return new C1934a(sVar) {
            /* renamed from: a */
            final /* synthetic */ EventListener f5954a;

            {
                this.f5954a = r1;
            }

            /* renamed from: a */
            public EventListener mo14064a(Call hVar) {
                return this.f5954a;
            }
        };
    }
}
