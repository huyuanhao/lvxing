package com.kwad.sdk.core.p330f.p331a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p330f.p332b.C4138e.C4139a;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.kwad.sdk.core.f.a.g */
public class C4124g {
    /* renamed from: a */
    private Context f13792a;
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final LinkedBlockingQueue<IBinder> f13793b = new LinkedBlockingQueue<>(1);
    /* renamed from: c */
    private ServiceConnection f13794c = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                C4124g.this.f13793b.put(iBinder);
            } catch (Exception e) {
                C4065b.m16865a(e);
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public C4124g(Context context) {
        this.f13792a = context;
    }

    /* renamed from: a */
    public String mo23822a() {
        Context context;
        ServiceConnection serviceConnection;
        String str = "SamsungDeviceIDHelper";
        String str2 = "";
        try {
            Intent intent = new Intent();
            intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
            if (this.f13792a.bindService(intent, this.f13794c, 1)) {
                try {
                    str2 = new C4139a((IBinder) this.f13793b.take()).mo23839a();
                    StringBuilder sb = new StringBuilder();
                    sb.append("getOAID oaid:");
                    sb.append(str2);
                    C4065b.m16867b(str, sb.toString());
                    context = this.f13792a;
                    serviceConnection = this.f13794c;
                } catch (Exception e) {
                    C4065b.m16865a(e);
                    context = this.f13792a;
                    serviceConnection = this.f13794c;
                }
                context.unbindService(serviceConnection);
            }
        } catch (Exception e2) {
            C4065b.m16867b(str, "getOAID service not found");
            C4065b.m16865a(e2);
        } catch (Throwable th) {
            this.f13792a.unbindService(this.f13794c);
            throw th;
        }
        return str2;
    }
}
