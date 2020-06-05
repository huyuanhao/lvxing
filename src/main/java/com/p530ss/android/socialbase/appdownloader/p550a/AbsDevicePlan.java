package com.p530ss.android.socialbase.appdownloader.p550a;

import android.content.Context;
import android.util.Log;
import com.p530ss.android.socialbase.downloader.p561f.C6704a;

/* renamed from: com.ss.android.socialbase.appdownloader.a.a */
public abstract class AbsDevicePlan implements IAntiHijackDevicePlan {
    /* renamed from: a */
    protected final Context f21482a;
    /* renamed from: b */
    protected final String f21483b;

    public AbsDevicePlan(Context context, String str) {
        this.f21482a = context;
        this.f21483b = str;
    }

    /* renamed from: a */
    public boolean mo31455a() {
        if (this.f21482a == null) {
            return false;
        }
        try {
            if (mo31456b().resolveActivity(this.f21482a.getPackageManager()) != null) {
                return true;
            }
        } catch (Throwable th) {
            if (C6704a.m27756a()) {
                Log.e("AbsDevicePlan", "check is valid failed!", th);
            }
        }
        return false;
    }
}
