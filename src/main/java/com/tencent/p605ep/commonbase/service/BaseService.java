package com.tencent.p605ep.commonbase.service;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/* renamed from: com.tencent.ep.commonbase.service.BaseService */
public abstract class BaseService {
    private IBinder mBinder;

    public final boolean equals(Object obj) {
        return obj != null && BaseService.class == obj.getClass();
    }

    /* access modifiers changed from: protected|declared_synchronized */
    public synchronized IBinder getBinder() {
        if (this.mBinder == null) {
            this.mBinder = onBind();
        }
        return this.mBinder;
    }

    public abstract IBinder onBind();

    public void onCreate(Context context) {
    }

    public void onDestory() {
    }

    public void onStart(Intent intent) {
    }

    /* access modifiers changed from: protected|final */
    public final void stopSelf() {
        TMSService.stopService(this);
    }
}
