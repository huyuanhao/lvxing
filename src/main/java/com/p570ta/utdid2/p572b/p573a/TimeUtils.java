package com.p570ta.utdid2.p572b.p573a;

import android.util.Log;

/* renamed from: com.ta.utdid2.b.a.j */
public class TimeUtils {
    public static final String TAG = TimeUtils.class.getName();

    /* renamed from: a */
    public static boolean m29035a(long j, int i) {
        boolean z = (System.currentTimeMillis() - j) / 86400000 < ((long) i);
        if (DebugUtils.f22504e) {
            String str = TAG;
            StringBuilder sb = new StringBuilder("isUpToDate: ");
            sb.append(z);
            sb.append("; oldTimestamp: ");
            sb.append(j);
            sb.append("; currentTimestamp");
            sb.append(System.currentTimeMillis());
            Log.d(str, sb.toString());
        }
        return z;
    }
}
