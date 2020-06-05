package com.p530ss.android.socialbase.appdownloader.p550a;

import android.content.Context;
import android.content.Intent;

/* renamed from: com.ss.android.socialbase.appdownloader.a.i */
public class Vivo2DevicePlan extends AbsDevicePlan {
    public Vivo2DevicePlan(Context context, String str) {
        super(context, str);
    }

    /* renamed from: b */
    public Intent mo31456b() {
        String str = "com.android.filemanager.OPEN_FOLDER";
        Intent intent = new Intent(str);
        intent.putExtra(str, this.f21483b);
        intent.putExtra("com.iqoo.secure", true);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
