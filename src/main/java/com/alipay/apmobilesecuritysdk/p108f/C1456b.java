package com.alipay.apmobilesecuritysdk.p108f;

import java.util.LinkedList;

/* renamed from: com.alipay.apmobilesecuritysdk.f.b */
public final class C1456b {
    /* renamed from: a */
    private static C1456b f3719a = new C1456b();
    /* access modifiers changed from: private */
    /* renamed from: b */
    public Thread f3720b = null;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public LinkedList<Runnable> f3721c = new LinkedList<>();

    /* renamed from: a */
    public static C1456b m4251a() {
        return f3719a;
    }

    /* renamed from: a */
    public final synchronized void mo12017a(Runnable runnable) {
        this.f3721c.add(runnable);
        if (this.f3720b == null) {
            this.f3720b = new Thread(new C1457c(this));
            this.f3720b.start();
        }
    }
}
