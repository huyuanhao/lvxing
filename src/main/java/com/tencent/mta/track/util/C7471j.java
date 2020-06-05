package com.tencent.mta.track.util;

import com.tencent.mta.track.thrift.C7446l;
import org.apache.thrift.protocol.TBinaryProtocol;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.util.j */
class C7471j implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ThrifClient f25030a;

    private C7471j(ThrifClient thrifClient) {
        this.f25030a = thrifClient;
    }

    /* synthetic */ C7471j(ThrifClient thrifClient, C7469h hVar) {
        this(thrifClient);
    }

    public void run() {
        try {
            this.f25030a.f25010e = new C7446l(new TBinaryProtocol(this.f25030a.m32316f()));
        } catch (Throwable unused) {
        }
        this.f25030a.f25009d.sendMessage(this.f25030a.f25009d.obtainMessage(0));
    }
}
