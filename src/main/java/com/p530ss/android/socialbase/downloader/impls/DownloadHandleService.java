package com.p530ss.android.socialbase.downloader.impls;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;

/* renamed from: com.ss.android.socialbase.downloader.impls.DownloadHandleService */
public class DownloadHandleService extends Service {
    /* renamed from: a */
    private static final String f22166a = DownloadHandleService.class.getSimpleName();

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        C6694b.m27353a((Context) this);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        m28226a(intent);
        return 2;
    }

    /* renamed from: a */
    private void m28226a(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                final int intExtra = intent.getIntExtra("extra_download_id", 0);
                if (intExtra != 0) {
                    if (action.equals("com.ss.android.downloader.action.DOWNLOAD_WAKEUP")) {
                        C6694b.m27379k().execute(new Runnable() {
                            public void run() {
                                try {
                                    DownloadProcessDispatcher.m27395a().mo31884m(intExtra);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    } else if (action.equals("com.ss.android.downloader.action.PROCESS_NOTIFY")) {
                        DownloadProcessDispatcher.m27395a().mo31885n(intExtra);
                    } else if (action.equals("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY")) {
                        C6694b.m27351a();
                    }
                }
            }
        }
    }
}
