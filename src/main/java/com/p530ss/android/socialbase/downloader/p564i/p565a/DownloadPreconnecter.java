package com.p530ss.android.socialbase.downloader.p564i.p565a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import com.p530ss.android.socialbase.downloader.p567k.DownloadSetting;

/* renamed from: com.ss.android.socialbase.downloader.i.a.b */
public class DownloadPreconnecter {
    /* renamed from: a */
    static long f22128a;
    /* renamed from: b */
    static long f22129b;
    /* renamed from: c */
    private static final HandlerThread f22130c = new HandlerThread("Downloader-preconnecter");
    /* renamed from: d */
    private static final Handler f22131d = new Handler(f22130c.getLooper());

    static {
        f22130c.start();
        f22131d.post(new Runnable() {
            public void run() {
                Process.setThreadPriority(10);
            }
        });
    }

    /* renamed from: a */
    public static void m28192a() {
        f22128a = DownloadSetting.m28617b().mo32548a("preconnect_connection_outdate_time", 300000);
        f22129b = DownloadSetting.m28617b().mo32548a("preconnect_head_info_outdate_time", 300000);
        DownloadConnectionPool.m28187a().mo32454a(DownloadSetting.m28617b().mo32547a("preconnect_max_cache_size", 3));
    }
}
