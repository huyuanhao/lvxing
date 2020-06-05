package com.alipay.sdk.util;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.alipay.android.app.IAlixPay.Stub;

/* renamed from: com.alipay.sdk.util.g */
class C1545g implements ServiceConnection {
    /* renamed from: a */
    final /* synthetic */ C1543f f3960a;

    C1545g(C1543f fVar) {
        this.f3960a = fVar;
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.f3960a.f3953b = null;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f3960a.f3954c) {
            this.f3960a.f3953b = Stub.asInterface(iBinder);
            this.f3960a.f3954c.notify();
        }
    }
}
