package com.yanzhenjie.permission.bridge;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: RequestManager */
/* renamed from: com.yanzhenjie.permission.bridge.e */
public class C7833e {
    /* renamed from: a */
    private static C7833e f26654a;
    /* renamed from: b */
    private final Executor f26655b = Executors.newCachedThreadPool();

    /* renamed from: a */
    public static C7833e m34048a() {
        if (f26654a == null) {
            synchronized (C7833e.class) {
                if (f26654a == null) {
                    f26654a = new C7833e();
                }
            }
        }
        return f26654a;
    }

    private C7833e() {
    }

    /* renamed from: a */
    public void mo38047a(BridgeRequest aVar) {
        this.f26655b.execute(new RequestExecutor(aVar));
    }
}
