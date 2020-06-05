package com.alipay.sdk.sys;

import android.content.Context;
import com.alipay.sdk.app.statistic.C1505a;
import com.alipay.sdk.p121b.C1511c;
import com.alipay.sdk.util.C1542e;
import com.p570ta.utdid2.device.UTDevice;
import java.io.File;

/* renamed from: com.alipay.sdk.sys.b */
public class C1536b {
    /* renamed from: a */
    private static C1536b f3926a;
    /* renamed from: b */
    private Context f3927b;

    private C1536b() {
    }

    /* renamed from: a */
    public static C1536b m4608a() {
        if (f3926a == null) {
            f3926a = new C1536b();
        }
        return f3926a;
    }

    /* renamed from: b */
    public Context mo12202b() {
        return this.f3927b;
    }

    /* renamed from: a */
    public void mo12201a(Context context, C1511c cVar) {
        this.f3927b = context.getApplicationContext();
    }

    /* renamed from: c */
    public C1511c mo12203c() {
        return C1511c.m4489a();
    }

    /* renamed from: d */
    public static boolean m4609d() {
        for (String file : new String[]{"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"}) {
            if (new File(file).exists()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    public String mo12204e() {
        try {
            return UTDevice.getUtdid(this.f3927b);
        } catch (Throwable th) {
            C1542e.m4633a(th);
            C1505a.m4453a("third", "GetUtdidEx", th);
            return "";
        }
    }
}
