package com.p530ss.android.socialbase.appdownloader.p550a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* renamed from: com.ss.android.socialbase.appdownloader.a.b */
public class AndroidUnknownSourcePlan extends AbsDevicePlan {
    public AndroidUnknownSourcePlan(Context context) {
        super(context, null);
    }

    /* renamed from: b */
    public Intent mo31456b() {
        StringBuilder sb = new StringBuilder();
        sb.append("package:");
        sb.append(this.f21482a.getPackageName());
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse(sb.toString()));
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        intent.addFlags(268435456);
        return intent;
    }
}
