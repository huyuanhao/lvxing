package com.tencent.android.tpush.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.android.tpush.p580b.C6864a;

/* compiled from: ProGuard */
public class XGDaemonService extends Service {
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }

    public void onCreate() {
        super.onCreate();
        String str = "XGDaemonService";
        C6864a.m29303e(str, "XGDaemonService onCreate");
        C6973b.m29764a((Service) this);
        C6864a.m29303e(str, "stopSelf");
        stopSelf();
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
