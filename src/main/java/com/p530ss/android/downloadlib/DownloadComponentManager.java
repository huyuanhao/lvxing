package com.p530ss.android.downloadlib;

import com.p530ss.android.downloadlib.p549e.C6587g;
import com.p530ss.android.socialbase.downloader.p568l.C6745a;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.ss.android.downloadlib.d */
public class DownloadComponentManager {
    /* renamed from: a */
    private final ThreadPoolExecutor f21421a;

    /* compiled from: DownloadComponentManager */
    /* renamed from: com.ss.android.downloadlib.d$a */
    private static class C6577a {
        /* access modifiers changed from: private|static */
        /* renamed from: a */
        public static DownloadComponentManager f21423a = new DownloadComponentManager();
    }

    /* renamed from: a */
    public static DownloadComponentManager m26440a() {
        return C6577a.f21423a;
    }

    private DownloadComponentManager() {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        StringBuilder sb = new StringBuilder();
        sb.append(TTDownloader.class.getName());
        sb.append("-ThreadPool");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 30, timeUnit, synchronousQueue, new C6745a(sb.toString()));
        this.f21421a = threadPoolExecutor;
    }

    /* renamed from: a */
    public void mo31386a(Runnable runnable) {
        try {
            this.f21421a.submit(runnable);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    public void mo31388b(Runnable runnable) {
        if (C6587g.m26521a()) {
            mo31386a(runnable);
        } else {
            runnable.run();
        }
    }

    /* renamed from: b */
    public ThreadPoolExecutor mo31387b() {
        return this.f21421a;
    }

    /* renamed from: c */
    public void mo31389c() {
        mo31386a(new Runnable() {
            /* JADX WARNING: Can't wrap try/catch for region: R(6:15|16|(3:18|(2:20|31)(1:32)|21)|22|23|24) */
            /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0070 */
            public void run() {
                /*
                r9 = this;
                java.lang.Class<com.ss.android.downloadlib.d> r0 = com.p530ss.android.downloadlib.DownloadComponentManager.class
                monitor-enter(r0)
                java.lang.String r1 = "sp_ad_download_event"
                java.lang.String r2 = "sp_download_finish_cache"
                java.lang.String r3 = "sp_delay_operation_info"
                java.lang.String r4 = "sp_ttdownloader_md5"
                java.lang.String r5 = "sp_name_installed_app"
                java.lang.String r6 = "misc_config"
                java.lang.String r7 = "sp_ad_install_back_dialog"
                java.lang.String r8 = "sp_appdownloader"
                java.lang.String[] r1 = new java.lang.String[]{r1, r2, r3, r4, r5, r6, r7, r8}     // Catch:{ all -> 0x0070 }
                int r2 = r1.length     // Catch:{ all -> 0x0070 }
                r3 = 0
                r4 = 0
            L_0x001a:
                if (r4 >= r2) goto L_0x0036
                r5 = r1[r4]     // Catch:{ all -> 0x0070 }
                android.content.Context r6 = com.p530ss.android.downloadlib.p541a.C6565j.m26357a()     // Catch:{ all -> 0x0070 }
                android.content.SharedPreferences r5 = r6.getSharedPreferences(r5, r3)     // Catch:{ all -> 0x0070 }
                if (r5 == 0) goto L_0x0033
                android.content.SharedPreferences$Editor r5 = r5.edit()     // Catch:{ all -> 0x0070 }
                android.content.SharedPreferences$Editor r5 = r5.clear()     // Catch:{ all -> 0x0070 }
                r5.apply()     // Catch:{ all -> 0x0070 }
            L_0x0033:
                int r4 = r4 + 1
                goto L_0x001a
            L_0x0036:
                com.ss.android.socialbase.downloader.downloader.k r1 = com.p530ss.android.socialbase.downloader.downloader.C6694b.m27384p()     // Catch:{ all -> 0x0070 }
                boolean r2 = r1 instanceof com.p530ss.android.socialbase.downloader.impls.DefaultDownloadCache     // Catch:{ all -> 0x0070 }
                if (r2 != 0) goto L_0x0040
                monitor-exit(r0)     // Catch:{ all -> 0x0072 }
                return
            L_0x0040:
                com.ss.android.socialbase.downloader.impls.d r1 = (com.p530ss.android.socialbase.downloader.impls.DefaultDownloadCache) r1     // Catch:{ all -> 0x0070 }
                com.ss.android.socialbase.downloader.impls.k r1 = r1.mo32511a()     // Catch:{ all -> 0x0070 }
                android.util.SparseArray r1 = r1.mo32517a()     // Catch:{ all -> 0x0070 }
                int r2 = r1.size()     // Catch:{ all -> 0x0070 }
                int r2 = r2 + -1
            L_0x0050:
                if (r2 < 0) goto L_0x0070
                int r3 = r1.keyAt(r2)     // Catch:{ all -> 0x0070 }
                java.lang.Object r3 = r1.get(r3)     // Catch:{ all -> 0x0070 }
                com.ss.android.socialbase.downloader.g.c r3 = (com.p530ss.android.socialbase.downloader.p562g.DownloadInfo) r3     // Catch:{ all -> 0x0070 }
                if (r3 == 0) goto L_0x006d
                android.content.Context r4 = com.p530ss.android.downloadlib.p541a.C6565j.m26357a()     // Catch:{ all -> 0x0070 }
                com.ss.android.socialbase.downloader.downloader.f r4 = com.p530ss.android.socialbase.downloader.downloader.Downloader.m27478a(r4)     // Catch:{ all -> 0x0070 }
                int r3 = r3.mo32283g()     // Catch:{ all -> 0x0070 }
                r4.mo31930j(r3)     // Catch:{ all -> 0x0070 }
            L_0x006d:
                int r2 = r2 + -1
                goto L_0x0050
            L_0x0070:
                monitor-exit(r0)     // Catch:{ all -> 0x0072 }
                return
            L_0x0072:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0072 }
                throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.downloadlib.DownloadComponentManager.C65761.run():void");
            }
        });
    }
}
