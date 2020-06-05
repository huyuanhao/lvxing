package com.p530ss.android.socialbase.downloader.downloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.p530ss.android.socialbase.downloader.notification.DownloadNotificationService;
import com.p530ss.android.socialbase.downloader.p561f.C6704a;

/* renamed from: com.ss.android.socialbase.downloader.downloader.DownloadReceiver */
public class DownloadReceiver extends BroadcastReceiver {
    /* renamed from: a */
    private static final String f21805a = DownloadReceiver.class.getSimpleName();

    public void onReceive(Context context, Intent intent) {
        if (!(context == null || intent == null)) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    if (C6704a.m27756a()) {
                        C6704a.m27754a(f21805a, "Received broadcast intent for android.net.conn.CONNECTIVITY_CHANGE");
                    }
                    m27314a(context, action);
                } else if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
                    m27315b(context, action);
                }
            }
        }
    }

    /* renamed from: a */
    private void m27314a(Context context, String str) {
        try {
            Intent intent = new Intent(context, DownloadNotificationService.class);
            intent.setAction(str);
            context.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m27315b(Context context, String str) {
        try {
            Intent intent = new Intent(context, DownloadNotificationService.class);
            intent.setAction(str);
            context.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
