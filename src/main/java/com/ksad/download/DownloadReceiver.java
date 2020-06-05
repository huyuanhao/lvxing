package com.ksad.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class DownloadReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String str = "download.intent.action.EXTRA_TASK_ID";
        if ("download.intent.action.DOWNLOAD_PAUSE".equals(intent.getAction())) {
            C3608d.m15048a().mo22724d(intent.getIntExtra(str, 0));
            return;
        }
        if ("download.intent.action.DOWNLOAD_RESUME".equals(intent.getAction())) {
            C3608d.m15048a().mo22727e(intent.getIntExtra(str, 0));
            return;
        }
        if ("download.intent.action.DOWNLOAD_CANCEL".equals(intent.getAction())) {
            C3608d.m15048a().mo22723c(intent.getIntExtra(str, 0));
            C3611e.m15066a().mo22730a(intent.getIntExtra(str, 0));
        }
    }
}
