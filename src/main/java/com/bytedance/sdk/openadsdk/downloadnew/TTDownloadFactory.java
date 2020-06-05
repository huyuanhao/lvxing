package com.bytedance.sdk.openadsdk.downloadnew;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.p174h.TTSdkSettings;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTJSDownloadAdapter;
import com.bytedance.sdk.openadsdk.downloadnew.p181a.DMLibJsManager;
import com.bytedance.sdk.openadsdk.downloadnew.p181a.DMLibManager;
import com.bytedance.sdk.openadsdk.downloadnew.p181a.DMLibWebManager;
import com.bytedance.sdk.openadsdk.downloadnew.p181a.LibHolder;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.p530ss.android.downloadlib.p541a.p542a.AdDownloadDialogManager;
import com.p530ss.android.downloadlib.p541a.p542a.AdDownloadDialogManager.C6543a;

/* renamed from: com.bytedance.sdk.openadsdk.downloadnew.a */
public class TTDownloadFactory {
    /* renamed from: a */
    public static ITTDownloadAdapter m11071a(Context context, MaterialMeta kVar, String str) {
        return new DMLibManager(context, kVar, str);
    }

    /* renamed from: b */
    public static ITTJSDownloadAdapter m11075b(Context context, MaterialMeta kVar, String str) {
        return new DMLibJsManager(context, kVar, str);
    }

    /* renamed from: a */
    public static ITTDownloadAdapter m11072a(Context context, String str, String str2) {
        return new DMLibWebManager(context, str, str2);
    }

    /* renamed from: a */
    public static boolean m11074a(Context context, final ExitInstallListener exitInstallListener) {
        TTSdkSettings h = InternalContainer.m10069h();
        if (!(h != null ? h.mo15818w() : true)) {
            return false;
        }
        return AdDownloadDialogManager.m26137a().mo31249a(context, false, (C6543a) new C6543a() {
            /* renamed from: a */
            public void mo16473a() {
                ExitInstallListener exitInstallListener = exitInstallListener;
                if (exitInstallListener != null) {
                    exitInstallListener.onExitInstall();
                }
            }
        });
    }

    /* renamed from: a */
    public static String m11073a() {
        try {
            return LibHolder.m11234d().mo31440f();
        } catch (Exception e) {
            C2564t.m12216a("TTDownloadFactory", "get download sdk version error", e);
            return "0.0.0";
        }
    }
}
