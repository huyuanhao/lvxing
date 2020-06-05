package com.qiyukf.basesdk.p394b.p406b.p411e;

import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p394b.p406b.p407a.C5321a;
import com.qiyukf.basesdk.p394b.p406b.p409c.C5352f;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NotYetConnectedException;
import java.util.concurrent.RejectedExecutionException;

/* renamed from: com.qiyukf.basesdk.b.b.e.a */
public final class C5360a {
    /* renamed from: a */
    static final ClosedChannelException f17300a = new ClosedChannelException();
    /* renamed from: b */
    static final NotYetConnectedException f17301b = new NotYetConnectedException();

    /* renamed from: a */
    public static Exception m22011a(C5321a aVar) {
        if (!aVar.mo27228b().mo27310b()) {
            return aVar.mo27230d() ? f17301b : f17300a;
        }
        return null;
    }

    /* renamed from: a */
    public static void m22012a(C5352f fVar, Runnable runnable) {
        try {
            fVar.execute(runnable);
        } catch (RejectedExecutionException unused) {
            C5264a.m21622c("socket", "execute task in terminated event loog");
        }
    }
}
