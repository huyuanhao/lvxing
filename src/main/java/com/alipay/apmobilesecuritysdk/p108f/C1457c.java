package com.alipay.apmobilesecuritysdk.p108f;

import android.os.Process;

/* renamed from: com.alipay.apmobilesecuritysdk.f.c */
final class C1457c implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1456b f3722a;

    C1457c(C1456b bVar) {
        this.f3722a = bVar;
    }

    public final void run() {
        try {
            Process.setThreadPriority(0);
            while (!this.f3722a.f3721c.isEmpty()) {
                Runnable runnable = (Runnable) this.f3722a.f3721c.get(0);
                this.f3722a.f3721c.remove(0);
                if (runnable != null) {
                    runnable.run();
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.f3722a.f3720b = null;
            throw th;
        }
        this.f3722a.f3720b = null;
    }
}
