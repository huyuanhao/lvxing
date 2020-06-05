package com.p530ss.android.socialbase.appdownloader.p550a;

import android.content.Context;
import android.content.Intent;

/* renamed from: com.ss.android.socialbase.appdownloader.a.f */
public class Oppo1DevicePlan extends AbsDevicePlan {
    public Oppo1DevicePlan(Context context, String str) {
        super(context, str);
    }

    /* renamed from: b */
    public Intent mo31456b() {
        Intent intent = new Intent("oppo.filemanager.intent.action.BROWSER_FILE");
        intent.putExtra("CurrentDir", this.f21483b);
        intent.putExtra("CurrentMode", 1);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
