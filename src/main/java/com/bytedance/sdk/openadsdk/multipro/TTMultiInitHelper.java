package com.bytedance.sdk.openadsdk.multipro;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.multipro.p205d.SPMultiHelper;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.tencent.android.tpush.common.Constants;

/* renamed from: com.bytedance.sdk.openadsdk.multipro.d */
public class TTMultiInitHelper {
    /* renamed from: a */
    public static void m11863a(Context context) {
        if (context != null) {
            SPMultiHelper.m11867a(context.getApplicationContext());
            if (VERSION.SDK_INT >= 28) {
                try {
                    int myPid = Process.myPid();
                    StringBuilder sb = new StringBuilder();
                    sb.append(context.getPackageName());
                    sb.append(myPid);
                    String sb2 = sb.toString();
                    for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME)).getRunningAppProcesses()) {
                        if (runningAppProcessInfo.pid == myPid) {
                            sb2 = runningAppProcessInfo.processName;
                        }
                    }
                    SSWebView.setDataDirectorySuffix(sb2);
                } catch (Exception e) {
                    C2564t.m12219b(e.toString());
                }
            }
        }
    }
}
