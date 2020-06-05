package com.tencent.android.tpush.rpc;

import android.content.Intent;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.p581c.C6876f;
import com.tencent.android.tpush.rpc.C6949a.C6950a;
import com.tencent.android.tpush.service.C6973b;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.rpc.d */
public class C6956d extends C6950a {
    /* renamed from: b */
    public void mo33243b() {
    }

    /* renamed from: a */
    public void mo33242a(String str, C6952b bVar) {
        try {
            C6876f.m29376a(C6973b.m29776f()).mo33044a(Intent.parseUri(str, 0));
            bVar.mo33247a();
        } catch (Throwable th) {
            C6864a.m29302d(Constants.ServiceLogTag, "Show", th);
        }
    }

    /* renamed from: a */
    public void mo33241a() {
        try {
            C6973b.m29765a(C6973b.m29776f());
        } catch (Throwable th) {
            C6864a.m29302d(Constants.ServiceLogTag, "startService", th);
        }
    }
}
