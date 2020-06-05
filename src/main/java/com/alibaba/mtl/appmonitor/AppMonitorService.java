package com.alibaba.mtl.appmonitor;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class AppMonitorService extends Service {
    /* renamed from: a */
    IMonitor f3086a = null;

    public IBinder onBind(Intent intent) {
        if (this.f3086a == null) {
            this.f3086a = new Monitor(getApplication());
        }
        return (IBinder) this.f3086a;
    }

    public void onDestroy() {
        IMonitor cVar = this.f3086a;
        if (cVar != null) {
            try {
                cVar.mo11606b();
            } catch (RemoteException unused) {
            }
        }
        super.onDestroy();
    }

    public void onLowMemory() {
        IMonitor cVar = this.f3086a;
        if (cVar != null) {
            try {
                cVar.mo11606b();
            } catch (RemoteException unused) {
            }
        }
        super.onLowMemory();
    }
}
