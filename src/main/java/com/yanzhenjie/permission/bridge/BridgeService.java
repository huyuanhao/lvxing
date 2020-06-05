package com.yanzhenjie.permission.bridge;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.yanzhenjie.permission.bridge.IBridge.C7829a;
import com.yanzhenjie.permission.source.C7847b;
import com.yanzhenjie.permission.source.ContextSource;

public class BridgeService extends Service {
    /* renamed from: a */
    private C7829a f26639a = new C7829a() {
        /* renamed from: b */
        private C7847b f26641b = new ContextSource(BridgeService.this);

        /* renamed from: a */
        public void mo38021a(String str) throws RemoteException {
            BridgeActivity.m33999a(this.f26641b, str);
        }

        /* renamed from: a */
        public void mo38022a(String str, String[] strArr) throws RemoteException {
            BridgeActivity.m34000a(this.f26641b, str, strArr);
        }

        /* renamed from: b */
        public void mo38023b(String str) throws RemoteException {
            BridgeActivity.m34001b(this.f26641b, str);
        }

        /* renamed from: c */
        public void mo38024c(String str) throws RemoteException {
            BridgeActivity.m34002c(this.f26641b, str);
        }

        /* renamed from: d */
        public void mo38025d(String str) throws RemoteException {
            BridgeActivity.m34003d(this.f26641b, str);
        }

        /* renamed from: e */
        public void mo38026e(String str) throws RemoteException {
            BridgeActivity.m34004e(this.f26641b, str);
        }

        /* renamed from: f */
        public void mo38027f(String str) throws RemoteException {
            BridgeActivity.m34005f(this.f26641b, str);
        }

        /* renamed from: g */
        public void mo38028g(String str) throws RemoteException {
            BridgeActivity.m34006g(this.f26641b, str);
        }
    };

    public IBinder onBind(Intent intent) {
        return this.f26639a.asBinder();
    }
}
