package com.p530ss.android.socialbase.appdownloader.p550a;

import android.content.Context;
import android.content.Intent;

/* renamed from: com.ss.android.socialbase.appdownloader.a.j */
public class XiaoMiUnknownSourcePlan extends AbsDevicePlan {
    public XiaoMiUnknownSourcePlan(Context context) {
        super(context, null);
    }

    /* renamed from: b */
    public Intent mo31456b() {
        Intent intent = new Intent("android.settings.SECURITY_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        return intent;
    }
}
