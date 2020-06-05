package com.bytedance.sdk.openadsdk.multipro.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IBinderPool;
import com.bytedance.sdk.openadsdk.IBinderPool.Stub;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.bytedance.sdk.openadsdk.multipro.aidl.a */
public class BinderPool {
    /* renamed from: c */
    private static volatile BinderPool f9004c;
    /* renamed from: a */
    private Context f9005a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public IBinderPool f9006b;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public CountDownLatch f9007d;
    /* renamed from: e */
    private final Object f9008e = new Object();
    /* access modifiers changed from: private */
    /* renamed from: f */
    public long f9009f = 0;
    /* renamed from: g */
    private ServiceConnection f9010g = new ServiceConnection() {
        public void onServiceDisconnected(ComponentName componentName) {
            C2564t.m12222c("MultiProcess", "BinderPool......onServiceDisconnected");
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            String str = "MultiProcess";
            BinderPool.this.f9006b = Stub.asInterface(iBinder);
            try {
                BinderPool.this.f9006b.asBinder().linkToDeath(BinderPool.this.f9011h, 0);
            } catch (RemoteException e) {
                C2564t.m12223c(str, "onServiceConnected throws :", e);
            }
            BinderPool.this.f9007d.countDown();
            StringBuilder sb = new StringBuilder();
            sb.append("onServiceConnected - binderService consume time ：");
            sb.append(System.currentTimeMillis() - BinderPool.this.f9009f);
            C2564t.m12220b(str, sb.toString());
        }
    };
    /* access modifiers changed from: private */
    /* renamed from: h */
    public DeathRecipient f9011h = new DeathRecipient() {
        public void binderDied() {
            C2564t.m12225d("MultiProcess", "binder died.");
            BinderPool.this.f9006b.asBinder().unlinkToDeath(BinderPool.this.f9011h, 0);
            BinderPool.this.f9006b = null;
            BinderPool.this.m11777a();
        }
    };

    private BinderPool(Context context) {
        this.f9005a = context.getApplicationContext();
        m11777a();
    }

    /* renamed from: a */
    public static BinderPool m11776a(Context context) {
        if (f9004c == null) {
            synchronized (BinderPool.class) {
                if (f9004c == null) {
                    f9004c = new BinderPool(context);
                }
            }
        }
        return f9004c;
    }

    /* renamed from: a */
    public IBinder mo16858a(int i) {
        try {
            if (this.f9006b != null) {
                return this.f9006b.queryBinder(i);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* renamed from: a */
    public synchronized void m11777a() {
        C2564t.m12222c("MultiProcess", "BinderPool......connectBinderPoolService");
        this.f9007d = new CountDownLatch(1);
        this.f9005a.bindService(new Intent(this.f9005a, BinderPoolService.class), this.f9010g, 1);
        this.f9009f = System.currentTimeMillis();
        try {
            this.f9007d.await();
        } catch (InterruptedException e) {
            C2564t.m12223c("MultiProcess", "connectBinderPoolService throws: ", e);
        }
        return;
    }
}
