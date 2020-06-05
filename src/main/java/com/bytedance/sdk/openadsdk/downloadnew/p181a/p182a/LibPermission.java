package com.bytedance.sdk.openadsdk.downloadnew.p181a.p182a;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.core.GlobalInfo;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p172f.PermissionsManager;
import com.bytedance.sdk.openadsdk.p185f.StatsLogManager;
import com.bytedance.sdk.openadsdk.utils.CommonPermissionUtils;
import com.bytedance.sdk.openadsdk.utils.CommonPermissionUtils.C2554a;
import com.p530ss.android.downloadlib.p549e.C6587g;
import com.p530ss.android.p531a.p532a.p533a.DownloadPermissionChecker;
import com.p530ss.android.p531a.p532a.p533a.IPermissionCallback;
import com.tencent.mid.core.Constants;
import java.lang.ref.WeakReference;

/* renamed from: com.bytedance.sdk.openadsdk.downloadnew.a.a.d */
public class LibPermission implements DownloadPermissionChecker {
    /* renamed from: a */
    private final WeakReference<Context> f8532a;

    /* renamed from: a */
    public void mo16480a(Activity activity, int i, String[] strArr, int[] iArr) {
    }

    public LibPermission(Context context) {
        this.f8532a = new WeakReference<>(context);
    }

    /* renamed from: a */
    public void mo16481a(Activity activity, final String[] strArr, final IPermissionCallback nVar) {
        String str;
        boolean z;
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                str = Constants.PERMISSION_WRITE_EXTERNAL_STORAGE;
                if (i >= length) {
                    z = false;
                    break;
                } else if (str.equalsIgnoreCase(strArr[i])) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                TTCustomController d = GlobalInfo.m9616c().mo15672d();
                if (!(d == null || nVar == null || d.isCanUseWriteExternal())) {
                    nVar.mo31042a(str);
                    return;
                }
            }
        }
        if (VERSION.SDK_INT >= 23 && C6587g.m26506a((Context) activity) < 23) {
            if (nVar != null) {
                nVar.mo31041a();
            }
        } else if (strArr == null || strArr.length <= 0) {
            if (nVar != null) {
                nVar.mo31041a();
            }
        } else {
            long hashCode = (long) hashCode();
            for (String hashCode2 : strArr) {
                hashCode += (long) hashCode2.hashCode();
            }
            CommonPermissionUtils.m12156a(String.valueOf(hashCode), strArr, new C2554a() {
                /* renamed from: a */
                public void mo16483a() {
                    IPermissionCallback nVar = nVar;
                    if (nVar != null) {
                        nVar.mo31041a();
                    }
                    StatsLogManager.m11278a().mo16568a(true, strArr);
                }

                /* renamed from: a */
                public void mo16484a(String str) {
                    IPermissionCallback nVar = nVar;
                    if (nVar != null) {
                        nVar.mo31042a(str);
                    }
                    StatsLogManager.m11278a().mo16568a(false, new String[]{str});
                }
            });
        }
    }

    /* renamed from: a */
    public boolean mo16482a(Context context, String str) {
        if (Constants.PERMISSION_WRITE_EXTERNAL_STORAGE.equalsIgnoreCase(str)) {
            TTCustomController d = GlobalInfo.m9616c().mo15672d();
            if (d != null && !d.isCanUseWriteExternal()) {
                return false;
            }
        }
        if (context == null) {
            context = InternalContainer.m10059a();
        }
        return PermissionsManager.m9560a().mo15632a(context, str);
    }
}
