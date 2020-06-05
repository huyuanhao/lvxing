package com.travel.adlibrary.p616e;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import com.tencent.android.tpush.common.Constants;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¨\u0006\u0004"}, mo39189d2 = {"getProcessName", "", "context", "Landroid/content/Context;", "lib.ad_release"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: Util.kt */
/* renamed from: com.travel.adlibrary.e.a */
public final class C7690a {
    /* renamed from: a */
    public static final String m33043a(Context context) {
        if (context == null) {
            return null;
        }
        Object systemService = context.getSystemService(Constants.FLAG_ACTIVITY_NAME);
        if (systemService != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) systemService).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == Process.myPid()) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
    }
}
