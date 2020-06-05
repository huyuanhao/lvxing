package com.tencent.android.tpush.cloudctr.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.cloudctr.CloudControlManager;
import com.tencent.android.tpush.p580b.C6864a;

/* compiled from: ProGuard */
public class CloudControlDownloadReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        C6864a.m29298c("CloudControlDownloadReceiver", "onReceive");
        DownloadItem a = CloudControlDownloadService.m29445a(intent);
        if (a != null) {
            CloudControlManager.m29396a().mo33060a(context.getApplicationContext(), a, false);
        }
    }
}
