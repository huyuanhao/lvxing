package com.kwad.sdk.core.p330f.p331a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.Signature;
import android.os.IBinder;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p330f.p332b.C4136d.C4137a;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.security.MessageDigest;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.kwad.sdk.core.f.a.f */
public class C4122f {
    /* renamed from: a */
    private Context f13788a;
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final LinkedBlockingQueue<IBinder> f13789b = new LinkedBlockingQueue<>(1);
    /* renamed from: c */
    private ServiceConnection f13790c = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C4065b.m16867b("OppoDeviceIDHelper", "onServiceConnected");
            try {
                C4122f.this.f13789b.put(iBinder);
            } catch (InterruptedException e) {
                C4065b.m16865a(e);
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public C4122f(Context context) {
        this.f13788a = context;
    }

    /* renamed from: b */
    private String m17095b() {
        try {
            Signature[] signatureArr = this.f13788a.getPackageManager().getPackageInfo(this.f13788a.getPackageName(), 64).signatures;
            if (signatureArr == null || signatureArr.length <= 0) {
                return null;
            }
            byte[] digest = MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(Integer.toHexString((b & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | 0).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception e) {
            C4065b.m16865a(e);
            return null;
        }
    }

    /* renamed from: a */
    public String mo23819a() {
        Context context;
        ServiceConnection serviceConnection;
        String str = "OppoDeviceIDHelper";
        String str2 = "";
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            boolean bindService = this.f13788a.bindService(intent, this.f13790c, 1);
            StringBuilder sb = new StringBuilder();
            sb.append("getOAID isBin=");
            sb.append(bindService);
            C4065b.m16867b(str, sb.toString());
            if (bindService) {
                try {
                    str2 = new C4137a((IBinder) this.f13789b.take()).mo23837a(this.f13788a.getPackageName(), m17095b(), "OUID");
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("getOAID oaid");
                    sb2.append(str2);
                    C4065b.m16867b(str, sb2.toString());
                    context = this.f13788a;
                    serviceConnection = this.f13790c;
                } catch (Exception e) {
                    C4065b.m16865a(e);
                    context = this.f13788a;
                    serviceConnection = this.f13790c;
                }
                context.unbindService(serviceConnection);
            }
        } catch (Exception e2) {
            C4065b.m16867b(str, "getOAID service not found");
            C4065b.m16865a(e2);
        } catch (Throwable th) {
            this.f13788a.unbindService(this.f13790c);
            throw th;
        }
        return str2;
    }
}
