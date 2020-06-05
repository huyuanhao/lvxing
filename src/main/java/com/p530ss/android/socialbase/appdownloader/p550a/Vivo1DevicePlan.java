package com.p530ss.android.socialbase.appdownloader.p550a;

import android.content.Context;
import android.content.Intent;

/* renamed from: com.ss.android.socialbase.appdownloader.a.h */
public class Vivo1DevicePlan extends AbsDevicePlan {
    public Vivo1DevicePlan(Context context, String str) {
        super(context, str);
    }

    /* renamed from: b */
    public Intent mo31456b() {
        Intent intent = new Intent("com.android.filemanager.FILE_OPEN");
        intent.putExtra("FilePathToBeOpenAfterScan", this.f21483b);
        intent.putExtra("com.iqoo.secure", true);
        intent.putExtra("OpenParentAndLocationDestFile", true);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
