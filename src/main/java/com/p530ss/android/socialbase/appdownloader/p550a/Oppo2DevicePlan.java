package com.p530ss.android.socialbase.appdownloader.p550a;

import android.content.Context;
import android.content.Intent;

/* renamed from: com.ss.android.socialbase.appdownloader.a.g */
public class Oppo2DevicePlan extends AbsDevicePlan {
    public Oppo2DevicePlan(Context context, String str) {
        super(context, str);
    }

    /* renamed from: b */
    public Intent mo31456b() {
        Intent intent = new Intent("oppo.intent.action.OPEN_FILEMANAGER");
        intent.putExtra("CurrentDir", this.f21483b);
        intent.putExtra("first_position", 1);
        intent.putExtra("CurrentMode", 1);
        intent.putExtra("com.iqoo.secure", true);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
