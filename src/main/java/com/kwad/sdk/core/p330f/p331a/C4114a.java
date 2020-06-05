package com.kwad.sdk.core.p330f.p331a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p330f.p332b.C4130a.C4131a;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.kwad.sdk.core.f.a.a */
public class C4114a {
    /* renamed from: a */
    private Context f13774a;
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final LinkedBlockingQueue<IBinder> f13775b = new LinkedBlockingQueue<>(1);
    /* renamed from: c */
    private ServiceConnection f13776c = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                C4114a.this.f13775b.put(iBinder);
            } catch (Exception e) {
                C4065b.m16865a(e);
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public C4114a(Context context) {
        this.f13774a = context;
    }

    /* renamed from: a */
    public String mo23808a() {
        Context context;
        ServiceConnection serviceConnection;
        String str = "ASUSDeviceIDHelper";
        String str2 = "";
        try {
            Intent intent = new Intent();
            intent.setAction("com.asus.msa.action.ACCESS_DID");
            intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
            if (this.f13774a.bindService(intent, this.f13776c, 1)) {
                try {
                    str2 = new C4131a((IBinder) this.f13775b.take()).mo23830a();
                    StringBuilder sb = new StringBuilder();
                    sb.append("getOAID oaid:");
                    sb.append(str2);
                    C4065b.m16867b(str, sb.toString());
                    context = this.f13774a;
                    serviceConnection = this.f13776c;
                } catch (Exception e) {
                    C4065b.m16865a(e);
                    context = this.f13774a;
                    serviceConnection = this.f13776c;
                }
                context.unbindService(serviceConnection);
            }
        } catch (Exception e2) {
            C4065b.m16867b(str, "getOAID asus service not found;");
            C4065b.m16865a(e2);
        } catch (Throwable th) {
            this.f13774a.unbindService(this.f13776c);
            throw th;
        }
        return str2;
    }
}
