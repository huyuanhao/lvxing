package com.kwad.sdk.core.p330f.p331a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p330f.p332b.C4134c.C4135a;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.kwad.sdk.core.f.a.c */
public class C4118c {
    /* renamed from: a */
    private Context f13782a;
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final LinkedBlockingQueue<IBinder> f13783b = new LinkedBlockingQueue<>(1);
    /* renamed from: c */
    private ServiceConnection f13784c = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                C4065b.m16867b("LenovoDeviceIDHelper", "onServiceConnected");
                C4118c.this.f13783b.put(iBinder);
            } catch (Exception e) {
                C4065b.m16865a(e);
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public C4118c(Context context) {
        this.f13782a = context;
    }

    /* renamed from: a */
    public String mo23814a() {
        Context context;
        ServiceConnection serviceConnection;
        String str = "LenovoDeviceIDHelper";
        String str2 = "";
        try {
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (this.f13782a.bindService(intent, this.f13784c, 1)) {
                try {
                    str2 = new C4135a((IBinder) this.f13783b.take()).mo23835a();
                    StringBuilder sb = new StringBuilder();
                    sb.append("getOAID oaid:");
                    sb.append(str2);
                    C4065b.m16867b(str, sb.toString());
                    context = this.f13782a;
                    serviceConnection = this.f13784c;
                } catch (Exception e) {
                    C4065b.m16865a(e);
                    context = this.f13782a;
                    serviceConnection = this.f13784c;
                }
                context.unbindService(serviceConnection);
            }
        } catch (Exception e2) {
            C4065b.m16867b(str, "getOAID Lenovo service not found");
            C4065b.m16865a(e2);
        } catch (Throwable th) {
            this.f13782a.unbindService(this.f13784c);
            throw th;
        }
        return str2;
    }
}
