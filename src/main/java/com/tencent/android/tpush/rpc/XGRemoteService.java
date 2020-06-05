package com.tencent.android.tpush.rpc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.android.tpush.rpc.C6949a.C6950a;
import com.tencent.android.tpush.service.C6973b;

/* compiled from: ProGuard */
public class XGRemoteService extends Service {
    /* renamed from: a */
    private C6950a f23074a = new C6956d();

    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        C6973b.m29767a(getApplication(), "pullup", 1000);
        return super.onStartCommand(intent, i, i2);
    }

    public IBinder onBind(Intent intent) {
        C6973b.m29774d(getApplicationContext());
        return this.f23074a;
    }
}
