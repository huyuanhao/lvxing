package com.qiyukf.nimlib.p470f;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.qiyukf.basesdk.p393a.C5264a;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.qiyukf.nimlib.f.c */
public class C5836c extends Handler implements ServiceConnection {
    /* renamed from: a */
    private final Context f18518a;
    /* renamed from: b */
    private final Intent f18519b;
    /* renamed from: c */
    private final AtomicBoolean f18520c = new AtomicBoolean();
    /* renamed from: d */
    private final String f18521d;

    public C5836c(Context context, Intent intent, String str) {
        super(context.getMainLooper());
        this.f18518a = context.getApplicationContext();
        this.f18519b = intent;
        this.f18521d = str;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0040 */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0074 A[Catch:{ all -> 0x0098 }] */
    /* renamed from: a */
    private void m23394a(int r5) {
        /*
        r4 = this;
        java.lang.String r0 = r4.f18521d     // Catch:{ all -> 0x0098 }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0098 }
        java.lang.String r2 = "doConnect: tag#"
        r1.<init>(r2)     // Catch:{ all -> 0x0098 }
        java.lang.String r2 = r4.f18521d     // Catch:{ all -> 0x0098 }
        r1.append(r2)     // Catch:{ all -> 0x0098 }
        java.lang.String r2 = " count#"
        r1.append(r2)     // Catch:{ all -> 0x0098 }
        r1.append(r5)     // Catch:{ all -> 0x0098 }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0098 }
        com.qiyukf.basesdk.p393a.C5264a.m21624d(r0, r1)     // Catch:{ all -> 0x0098 }
        if (r5 <= 0) goto L_0x0040
        java.lang.String r0 = r4.f18521d     // Catch:{ all -> 0x0098 }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0098 }
        java.lang.String r2 = "doConnect: unbind & stop service#"
        r1.<init>(r2)     // Catch:{ all -> 0x0098 }
        android.content.Intent r2 = r4.f18519b     // Catch:{ all -> 0x0098 }
        r1.append(r2)     // Catch:{ all -> 0x0098 }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0098 }
        com.qiyukf.basesdk.p393a.C5264a.m21626e(r0, r1)     // Catch:{ all -> 0x0098 }
        android.content.Context r0 = r4.f18518a     // Catch:{ all -> 0x0040 }
        r0.unbindService(r4)     // Catch:{ all -> 0x0040 }
        android.content.Context r0 = r4.f18518a     // Catch:{ all -> 0x0040 }
        android.content.Intent r1 = r4.f18519b     // Catch:{ all -> 0x0040 }
        r0.stopService(r1)     // Catch:{ all -> 0x0040 }
    L_0x0040:
        android.os.Message r0 = android.os.Message.obtain()     // Catch:{ all -> 0x0098 }
        r1 = 1
        r0.what = r1     // Catch:{ all -> 0x0098 }
        r0.arg1 = r5     // Catch:{ all -> 0x0098 }
        java.lang.String r5 = r4.f18521d     // Catch:{ all -> 0x0098 }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0098 }
        java.lang.String r3 = "doConnect: start & bind service#"
        r2.<init>(r3)     // Catch:{ all -> 0x0098 }
        android.content.Intent r3 = r4.f18519b     // Catch:{ all -> 0x0098 }
        r2.append(r3)     // Catch:{ all -> 0x0098 }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0098 }
        com.qiyukf.basesdk.p393a.C5264a.m21617a(r5, r2)     // Catch:{ all -> 0x0098 }
        r2 = 15000(0x3a98, double:7.411E-320)
        r4.sendMessageDelayed(r0, r2)     // Catch:{ all -> 0x0098 }
        android.content.Context r5 = r4.f18518a     // Catch:{ all -> 0x0098 }
        android.content.Intent r0 = r4.f18519b     // Catch:{ all -> 0x0098 }
        r5.startService(r0)     // Catch:{ all -> 0x0098 }
        android.content.Context r5 = r4.f18518a     // Catch:{ all -> 0x0098 }
        android.content.Intent r0 = r4.f18519b     // Catch:{ all -> 0x0098 }
        boolean r5 = r5.bindService(r0, r4, r1)     // Catch:{ all -> 0x0098 }
        if (r5 != 0) goto L_0x0097
        java.lang.String r5 = r4.f18521d     // Catch:{ all -> 0x0098 }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0098 }
        java.lang.String r2 = "doConnect: stop & bind service#"
        r0.<init>(r2)     // Catch:{ all -> 0x0098 }
        android.content.Intent r2 = r4.f18519b     // Catch:{ all -> 0x0098 }
        r0.append(r2)     // Catch:{ all -> 0x0098 }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0098 }
        com.qiyukf.basesdk.p393a.C5264a.m21626e(r5, r0)     // Catch:{ all -> 0x0098 }
        android.content.Context r5 = r4.f18518a     // Catch:{ all -> 0x0098 }
        android.content.Intent r0 = r4.f18519b     // Catch:{ all -> 0x0098 }
        r5.stopService(r0)     // Catch:{ all -> 0x0098 }
        android.content.Context r5 = r4.f18518a     // Catch:{ all -> 0x0098 }
        android.content.Intent r0 = r4.f18519b     // Catch:{ all -> 0x0098 }
        r5.bindService(r0, r4, r1)     // Catch:{ all -> 0x0098 }
    L_0x0097:
        return
    L_0x0098:
        r5 = move-exception
        r5.printStackTrace()
        java.lang.String r0 = r4.f18521d
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        java.lang.String r2 = "connect core error: "
        r1.<init>(r2)
        r1.append(r5)
        java.lang.String r5 = r1.toString()
        com.qiyukf.basesdk.p393a.C5264a.m21617a(r0, r5)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p470f.C5836c.m23394a(int):void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo28146a() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo28145a(IBinder iBinder) {
    }

    /* renamed from: b */
    public final void mo28149b() {
        if (!this.f18520c.compareAndSet(false, true)) {
            C5264a.m21624d(this.f18521d, "connect: connecting...");
        } else {
            m23394a(0);
        }
    }

    /* renamed from: c */
    public final void mo28150c() {
        try {
            this.f18518a.unbindService(this);
        } catch (Exception e) {
            String str = this.f18521d;
            StringBuilder sb = new StringBuilder("unbind service error: ");
            sb.append(e);
            C5264a.m21622c(str, sb.toString());
        }
    }

    /* renamed from: d */
    public final boolean mo28151d() {
        return this.f18520c.get();
    }

    public void handleMessage(Message message) {
        if (message.what == 1) {
            int i = message.arg1;
            String str = this.f18521d;
            StringBuilder sb = new StringBuilder("doTimeout: count#");
            sb.append(i);
            C5264a.m21624d(str, sb.toString());
            if (i > 0) {
                this.f18520c.set(false);
                return;
            }
            m23394a(i + 1);
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        String str = this.f18521d;
        StringBuilder sb = new StringBuilder("onServiceConnected: binder#");
        sb.append(iBinder);
        C5264a.m21617a(str, sb.toString());
        if (iBinder != null) {
            removeMessages(1);
            this.f18520c.set(false);
            mo28145a(iBinder);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        String str = this.f18521d;
        StringBuilder sb = new StringBuilder("onServiceDisconnected#");
        sb.append(componentName.getClassName());
        C5264a.m21617a(str, sb.toString());
        mo28146a();
    }
}
