package com.alipay.sdk.p121b;

import android.content.Context;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* renamed from: com.alipay.sdk.b.d */
class C1512d implements Callable<String> {
    /* renamed from: a */
    final /* synthetic */ Context f3882a;
    /* renamed from: b */
    final /* synthetic */ HashMap f3883b;
    /* renamed from: c */
    final /* synthetic */ C1511c f3884c;

    C1512d(C1511c cVar, Context context, HashMap hashMap) {
        this.f3884c = cVar;
        this.f3882a = context;
        this.f3883b = hashMap;
    }

    /* renamed from: a */
    public String call() throws Exception {
        return this.f3884c.m4490a(this.f3882a, this.f3883b);
    }
}
