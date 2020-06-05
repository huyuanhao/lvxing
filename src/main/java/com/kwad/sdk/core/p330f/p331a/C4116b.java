package com.kwad.sdk.core.p330f.p331a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p330f.p332b.C4132b.C4133a;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.kwad.sdk.core.f.a.b */
public class C4116b {
    /* renamed from: a */
    private Context f13778a;
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final LinkedBlockingQueue<IBinder> f13779b = new LinkedBlockingQueue<>(1);
    /* renamed from: c */
    private ServiceConnection f13780c = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                C4065b.m16867b("HWDeviceIDHelper", "onServiceConnected");
                C4116b.this.f13779b.put(iBinder);
            } catch (Exception e) {
                C4065b.m16865a(e);
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public C4116b(Context context) {
        this.f13778a = context;
    }

    /* renamed from: a */
    public String mo23811a() {
        Context context;
        ServiceConnection serviceConnection;
        String str = "HWDeviceIDHelper";
        String str2 = "";
        try {
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            if (this.f13778a.bindService(intent, this.f13780c, 1)) {
                try {
                    C4133a aVar = new C4133a((IBinder) this.f13779b.take());
                    str2 = aVar.mo23832a();
                    boolean b = aVar.mo23834b();
                    StringBuilder sb = new StringBuilder();
                    sb.append("getOAID oaid:");
                    sb.append(str2);
                    sb.append("--boos:");
                    sb.append(b);
                    C4065b.m16867b(str, sb.toString());
                    context = this.f13778a;
                    serviceConnection = this.f13780c;
                } catch (Exception e) {
                    C4065b.m16865a(e);
                    context = this.f13778a;
                    serviceConnection = this.f13780c;
                }
                context.unbindService(serviceConnection);
            }
        } catch (Exception e2) {
            C4065b.m16867b(str, "getOAID hw service not found");
            C4065b.m16865a(e2);
        } catch (Throwable th) {
            this.f13778a.unbindService(this.f13780c);
            throw th;
        }
        return str2;
    }
}
