package com.p530ss.android.downloadlib.p541a.p544c;

import android.os.Environment;
import com.p530ss.android.downloadlib.AdDownloadCompletedEventHandlerImpl;
import com.p530ss.android.downloadlib.p541a.C6565j;
import com.p530ss.android.downloadlib.p549e.TLogger;
import com.p530ss.android.p531a.p532a.p533a.DownloadClearSpaceListener;
import com.p530ss.android.socialbase.downloader.downloader.Downloader;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadDiskSpaceCallback;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadDiskSpaceHandler;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p567k.DownloadSetting;
import com.p530ss.android.socialbase.downloader.p569m.DownloadUtils;
import java.io.File;

/* renamed from: com.ss.android.downloadlib.a.c.a */
public class AppDownloadDiskSpaceHandler implements IDownloadDiskSpaceHandler {
    /* renamed from: a */
    private int f21335a;

    /* renamed from: a */
    public void mo31290a(int i) {
        this.f21335a = i;
    }

    /* renamed from: a */
    public boolean mo31291a(long j, long j2, IDownloadDiskSpaceCallback vVar) {
        long j3;
        long j4 = j2;
        DownloadSetting a = DownloadSetting.m28610a(this.f21335a);
        if (!m26205a(a)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        DownloadOptimizationManager.m26212a().mo31298d();
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        long a2 = m26202a(externalStorageDirectory.toString());
        m26203a();
        long a3 = m26202a(externalStorageDirectory.toString());
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (a3 < j4) {
            j3 = m26206b(a);
            if (j3 > 0) {
                a3 = m26202a(externalStorageDirectory.toString());
            }
        } else {
            j3 = 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("cleanUpDisk, byteRequired = ");
        sb.append(j4);
        sb.append(", byteAvailableAfter = ");
        sb.append(a3);
        sb.append(", cleaned = ");
        sb.append(a3 - a2);
        TLogger.m26505b("AppDownloadDiskSpaceHandler", sb.toString(), null);
        long j5 = a3;
        m26204a(a2, a3, j2, currentTimeMillis2, j3);
        if (j5 < j4) {
            return false;
        }
        if (vVar != null) {
            vVar.mo31813a();
        }
        return true;
    }

    /* renamed from: a */
    private boolean m26205a(DownloadSetting aVar) {
        if (aVar.mo32547a("clear_space_use_disk_handler", 0) != 1) {
            return false;
        }
        return System.currentTimeMillis() - DownloadOptimizationManager.m26212a().mo31296c() >= aVar.mo32548a("clear_space_min_time_interval", 600000);
    }

    /* renamed from: a */
    private void m26203a() {
        DownloadClearSpaceListener o = C6565j.m26381o();
        if (o != null) {
            o.mo31031a();
        }
        ClearSpaceUtil.m26209a();
        ClearSpaceUtil.m26211b();
    }

    /* renamed from: b */
    private long m26206b(DownloadSetting aVar) {
        long a = aVar.mo32548a("clear_space_sleep_time", 0);
        if (a <= 0) {
            return 0;
        }
        long j = 5000;
        if (a <= 5000) {
            j = a;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("waiting for space clear, sleepTime = ");
        sb.append(j);
        String str = "AppDownloadDiskSpaceHandler";
        TLogger.m26505b(str, sb.toString(), null);
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TLogger.m26505b(str, "waiting end!", null);
        return j;
    }

    /* renamed from: a */
    private void m26204a(long j, long j2, long j3, long j4, long j5) {
        DownloadInfo h = Downloader.m27478a(C6565j.m26357a()).mo31928h(this.f21335a);
        if (h != null) {
            try {
                AdDownloadCompletedEventHandlerImpl.m26106a().mo31230a(h, j, j2, j3, j4, j5, j2 > j3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private long m26202a(String str) {
        try {
            return DownloadUtils.m28796c(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
