package com.tencent.android.tpush.rpc;

import android.content.ServiceConnection;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.rpc.C6952b.C6953a;
import com.tencent.android.tpush.service.C6973b;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.rpc.c */
public class C6955c extends C6953a {
    /* renamed from: a */
    private ServiceConnection f23077a;

    /* renamed from: a */
    public void mo33251a(ServiceConnection serviceConnection) {
        this.f23077a = serviceConnection;
    }

    /* renamed from: a */
    public void mo33247a() {
        try {
            if (C6973b.m29776f() != null) {
                C6973b.m29776f().unbindService(this.f23077a);
                this.f23077a = null;
            }
        } catch (Throwable th) {
            C6864a.m29302d(Constants.ServiceLogTag, "unBind", th);
        }
    }
}
