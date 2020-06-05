package com.yanzhenjie.permission.bridge;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.bridge.IBridge.C7829a;
import com.yanzhenjie.permission.bridge.Messenger.C7831a;

/* renamed from: com.yanzhenjie.permission.bridge.d */
final class RequestExecutor extends Thread implements C7831a {
    /* renamed from: a */
    private BridgeRequest f26650a;
    /* renamed from: b */
    private Messenger f26651b;
    /* renamed from: c */
    private ServiceConnection f26652c = new ServiceConnection() {
        public void onServiceDisconnected(ComponentName componentName) {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                RequestExecutor.this.m34045a(C7829a.m34032a(iBinder));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    };

    public RequestExecutor(BridgeRequest aVar) {
        this.f26650a = aVar;
    }

    public void run() {
        Context a = this.f26650a.mo38029a().mo38075a();
        this.f26651b = new Messenger(a, this);
        this.f26651b.mo38041a(getName());
        Intent intent = new Intent();
        intent.setAction(AndPermission.m33994a(a, (String) null));
        intent.setPackage(a.getPackageName());
        a.bindService(intent, this.f26652c, 1);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34045a(IBridge bVar) throws RemoteException {
        switch (this.f26650a.mo38033b()) {
            case 1:
                bVar.mo38021a(getName());
                return;
            case 2:
                bVar.mo38022a(getName(), (String[]) this.f26650a.mo38035d().toArray(new String[0]));
                return;
            case 3:
                bVar.mo38023b(getName());
                return;
            case 4:
                bVar.mo38024c(getName());
                return;
            case 5:
                bVar.mo38025d(getName());
                return;
            case 6:
                bVar.mo38026e(getName());
                return;
            case 7:
                bVar.mo38027f(getName());
                return;
            case 8:
                bVar.mo38028g(getName());
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public void mo38043a() {
        synchronized (this) {
            this.f26651b.mo38040a();
            this.f26650a.mo38034c().mo38036c();
            this.f26650a.mo38029a().mo38075a().unbindService(this.f26652c);
            this.f26651b = null;
            this.f26650a = null;
        }
    }
}
