package com.p530ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.p530ss.android.socialbase.downloader.p561f.C6704a;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

/* renamed from: com.ss.android.socialbase.downloader.downloader.DownloadService */
public class DownloadService extends Service {
    /* renamed from: b */
    private static final String f21806b = DownloadService.class.getSimpleName();
    /* renamed from: a */
    protected IDownloadServiceHandler f21807a;

    public void onCreate() {
        super.onCreate();
        C6694b.m27353a((Context) this);
        this.f21807a = C6694b.m27385q();
        this.f21807a.mo31843a(new WeakReference<>(this));
    }

    public IBinder onBind(Intent intent) {
        String str = f21806b;
        StringBuilder sb = new StringBuilder();
        sb.append("onBind downloadServiceHandler != null:");
        sb.append(this.f21807a != null);
        C6704a.m27758b(str, sb.toString());
        IDownloadServiceHandler pVar = this.f21807a;
        if (pVar != null) {
            return pVar.mo31836a(intent);
        }
        return null;
    }

    public int onStartCommand(final Intent intent, final int i, final int i2) {
        if (C6704a.m27756a()) {
            C6704a.m27758b(f21806b, "DownloadService onStartCommand");
        }
        this.f21807a.mo31848c();
        ExecutorService j = C6694b.m27378j();
        if (j != null) {
            j.execute(new Runnable() {
                public void run() {
                    if (DownloadService.this.f21807a != null) {
                        DownloadService.this.f21807a.mo31840a(intent, i, i2);
                    }
                }
            });
        }
        return 3;
    }

    public void onDestroy() {
        if (C6704a.m27756a()) {
            C6704a.m27758b(f21806b, "Service onDestroy");
        }
        IDownloadServiceHandler pVar = this.f21807a;
        if (pVar != null) {
            pVar.mo31850d();
            this.f21807a = null;
        }
        super.onDestroy();
    }
}
