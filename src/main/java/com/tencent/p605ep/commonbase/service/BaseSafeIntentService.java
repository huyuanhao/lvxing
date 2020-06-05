package com.tencent.p605ep.commonbase.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* renamed from: com.tencent.ep.commonbase.service.BaseSafeIntentService */
class BaseSafeIntentService extends Service {
    BaseSafeIntentService() {
    }

    public IBinder doOnBind(Intent intent) {
        return null;
    }

    public void doOnRebind(Intent intent) {
        super.onRebind(intent);
    }

    public void doOnStart(Intent intent, int i) {
        super.onStart(intent, i);
    }

    public int doOnStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    public boolean doOnUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    public final IBinder onBind(Intent intent) {
        if (intent != null) {
            try {
                intent = new SafeIntent(intent);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return doOnBind(intent);
    }

    public final void onRebind(Intent intent) {
        if (intent != null) {
            try {
                intent = new SafeIntent(intent);
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        doOnRebind(intent);
    }

    public final void onStart(Intent intent, int i) {
        if (intent != null) {
            try {
                intent = new SafeIntent(intent);
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        doOnStart(intent, i);
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            try {
                intent = new SafeIntent(intent);
            } catch (Throwable th) {
                th.printStackTrace();
                return 1;
            }
        }
        return doOnStartCommand(intent, i, i2);
    }

    public final boolean onUnbind(Intent intent) {
        if (intent != null) {
            try {
                intent = new SafeIntent(intent);
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return doOnUnbind(intent);
    }
}
