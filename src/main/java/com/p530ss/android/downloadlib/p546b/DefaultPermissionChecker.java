package com.p530ss.android.downloadlib.p546b;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import androidx.core.content.ContextCompat;
import com.p530ss.android.p531a.p532a.p533a.DownloadPermissionChecker;
import com.p530ss.android.p531a.p532a.p533a.IPermissionCallback;

/* renamed from: com.ss.android.downloadlib.b.b */
public class DefaultPermissionChecker implements DownloadPermissionChecker {
    /* renamed from: a */
    private IPermissionCallback f21409a;

    /* renamed from: a */
    public void mo16481a(Activity activity, String[] strArr, IPermissionCallback nVar) {
        if (VERSION.SDK_INT >= 23) {
            this.f21409a = nVar;
            activity.requestPermissions(strArr, 1);
        } else if (nVar != null) {
            nVar.mo31041a();
        }
    }

    /* renamed from: a */
    public boolean mo16482a(Context context, String str) {
        return context != null && ContextCompat.checkSelfPermission(context, str) == 0;
    }

    /* renamed from: a */
    public void mo16480a(Activity activity, int i, String[] strArr, int[] iArr) {
        if (iArr.length > 0) {
            IPermissionCallback nVar = this.f21409a;
            if (nVar == null) {
                return;
            }
            if (iArr[0] == -1) {
                nVar.mo31042a(strArr[0]);
            } else if (iArr[0] == 0) {
                nVar.mo31041a();
            }
        }
    }
}
