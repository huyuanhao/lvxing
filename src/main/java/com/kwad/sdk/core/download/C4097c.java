package com.kwad.sdk.core.download;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.kwad.sdk.KsAdSDK;
import com.kwad.sdk.core.p319c.C4065b;

/* renamed from: com.kwad.sdk.core.download.c */
public class C4097c {
    /* renamed from: a */
    private static final boolean f13756a = KsAdSDK.isDebugLogEnable();

    /* renamed from: a */
    public static void m17019a(String str) {
        if (f13756a) {
            StringBuilder sb = new StringBuilder();
            sb.append("onDownloadStart(), id=");
            sb.append(str);
            C4065b.m16863a("DownloadMonitor", sb.toString());
        }
        Intent intent = new Intent(C4086a.f13736b);
        Bundle bundle = new Bundle();
        bundle.putString("RESULT_DOWNLOAD_ID", str);
        intent.putExtras(bundle);
        Context context = KsAdSDK.getContext();
        if (context != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(context.getPackageName());
            sb2.append(".permission.KW_SDK_BROADCAST");
            context.sendBroadcast(intent, sb2.toString());
        }
    }

    /* renamed from: a */
    public static void m17020a(String str, int i) {
        if (f13756a) {
            StringBuilder sb = new StringBuilder();
            sb.append("onProgressUpdate(), id=");
            sb.append(str);
            sb.append(" progress=");
            sb.append(i);
            C4065b.m16863a("DownloadMonitor", sb.toString());
        }
        Intent intent = new Intent(C4086a.f13737c);
        Bundle bundle = new Bundle();
        bundle.putString("RESULT_DOWNLOAD_ID", str);
        bundle.putInt("KEY_RESULT_PROGRESS", i);
        intent.putExtras(bundle);
        Context context = KsAdSDK.getContext();
        if (context != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(context.getPackageName());
            sb2.append(".permission.KW_SDK_BROADCAST");
            context.sendBroadcast(intent, sb2.toString());
        }
    }

    /* renamed from: a */
    public static void m17021a(String str, String str2) {
        if (f13756a) {
            StringBuilder sb = new StringBuilder();
            sb.append("onDownloadFinished(), id=");
            sb.append(str);
            C4065b.m16863a("DownloadMonitor", sb.toString());
        }
        Intent intent = new Intent(C4086a.f13738d);
        Bundle bundle = new Bundle();
        bundle.putString("RESULT_DOWNLOAD_ID", str);
        bundle.putString("KEY_REUSLT_FILEPATH", str2);
        intent.putExtras(bundle);
        Context context = KsAdSDK.getContext();
        if (context != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(context.getPackageName());
            sb2.append(".permission.KW_SDK_BROADCAST");
            context.sendBroadcast(intent, sb2.toString());
        }
    }

    /* renamed from: b */
    public static void m17022b(String str) {
        if (f13756a) {
            StringBuilder sb = new StringBuilder();
            sb.append("onDownloadPaused(), id=");
            sb.append(str);
            C4065b.m16863a("DownloadMonitor", sb.toString());
        }
        Intent intent = new Intent(C4086a.f13740f);
        Bundle bundle = new Bundle();
        bundle.putString("RESULT_DOWNLOAD_ID", str);
        intent.putExtras(bundle);
        Context context = KsAdSDK.getContext();
        if (context != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(context.getPackageName());
            sb2.append(".permission.KW_SDK_BROADCAST");
            context.sendBroadcast(intent, sb2.toString());
        }
    }

    /* renamed from: b */
    public static void m17023b(String str, int i) {
        if (f13756a) {
            StringBuilder sb = new StringBuilder();
            sb.append("onDownloadFail(), id=");
            sb.append(str);
            sb.append(" error=");
            sb.append(i);
            C4065b.m16863a("DownloadMonitor", sb.toString());
        }
        Intent intent = new Intent(C4086a.f13739e);
        Bundle bundle = new Bundle();
        bundle.putString("RESULT_DOWNLOAD_ID", str);
        bundle.putInt("KEY_RESULT_ERROR_CODE", i);
        intent.putExtras(bundle);
        Context context = KsAdSDK.getContext();
        if (context != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(context.getPackageName());
            sb2.append(".permission.KW_SDK_BROADCAST");
            context.sendBroadcast(intent, sb2.toString());
        }
    }

    /* renamed from: c */
    public static void m17024c(String str) {
        if (f13756a) {
            StringBuilder sb = new StringBuilder();
            sb.append("onDownloadResumed(), id=");
            sb.append(str);
            C4065b.m16863a("DownloadMonitor", sb.toString());
        }
        Intent intent = new Intent(C4086a.f13741g);
        Bundle bundle = new Bundle();
        bundle.putString("RESULT_DOWNLOAD_ID", str);
        intent.putExtras(bundle);
        Context context = KsAdSDK.getContext();
        if (context != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(context.getPackageName());
            sb2.append(".permission.KW_SDK_BROADCAST");
            context.sendBroadcast(intent, sb2.toString());
        }
    }

    /* renamed from: d */
    public static void m17025d(String str) {
        if (f13756a) {
            StringBuilder sb = new StringBuilder();
            sb.append("onDownloadCanceled(), id=");
            sb.append(str);
            C4065b.m16863a("DownloadMonitor", sb.toString());
        }
        Intent intent = new Intent(C4086a.f13742h);
        Bundle bundle = new Bundle();
        bundle.putString("RESULT_DOWNLOAD_ID", str);
        intent.putExtras(bundle);
        Context context = KsAdSDK.getContext();
        if (context != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(context.getPackageName());
            sb2.append(".permission.KW_SDK_BROADCAST");
            context.sendBroadcast(intent, sb2.toString());
        }
    }
}
