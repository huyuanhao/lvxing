package com.kwad.sdk.core.p330f.p331a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p330f.p332b.C4140f.C4141a;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.kwad.sdk.core.f.a.j */
public class C4128j {
    /* renamed from: a */
    public Context f13798a;
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final LinkedBlockingQueue<IBinder> f13799b = new LinkedBlockingQueue<>(1);
    /* renamed from: c */
    private ServiceConnection f13800c = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                C4065b.m16867b("ZTEDeviceIDHelper", "onServiceConnected");
                C4128j.this.f13799b.put(iBinder);
            } catch (Exception e) {
                C4065b.m16865a(e);
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public C4128j(Context context) {
        this.f13798a = context;
    }

    /* renamed from: a */
    public String mo23827a() {
        Context context;
        ServiceConnection serviceConnection;
        String str = "ZTEDeviceIDHelper";
        String str2 = "";
        try {
            Intent intent = new Intent();
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
            intent.setAction("com.bun.msa.action.bindto.service");
            intent.putExtra("com.bun.msa.param.pkgname", this.f13798a.getPackageName());
            boolean bindService = this.f13798a.bindService(intent, this.f13800c, 1);
            StringBuilder sb = new StringBuilder();
            sb.append("getOAID isBind=");
            sb.append(bindService);
            C4065b.m16867b(str, sb.toString());
            if (bindService) {
                try {
                    str2 = new C4141a((IBinder) this.f13799b.take()).mo23841a();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("getOAID oaid:");
                    sb2.append(str2);
                    C4065b.m16867b(str, sb2.toString());
                    context = this.f13798a;
                    serviceConnection = this.f13800c;
                } catch (Exception e) {
                    C4065b.m16865a(e);
                    context = this.f13798a;
                    serviceConnection = this.f13800c;
                }
                context.unbindService(serviceConnection);
            }
        } catch (Exception e2) {
            C4065b.m16867b(str, "getOAID hw service not found");
            C4065b.m16865a(e2);
        } catch (Throwable th) {
            this.f13798a.unbindService(this.f13800c);
            throw th;
        }
        return str2;
    }
}
