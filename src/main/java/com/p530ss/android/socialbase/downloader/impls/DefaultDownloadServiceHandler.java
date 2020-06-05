package com.p530ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.p530ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler;
import com.p530ss.android.socialbase.downloader.downloader.DownloadService;
import com.p530ss.android.socialbase.downloader.p561f.C6704a;
import com.p530ss.android.socialbase.downloader.p569m.DownloadExpSwitchCode;

/* renamed from: com.ss.android.socialbase.downloader.impls.h */
public class DefaultDownloadServiceHandler extends AbsDownloadServiceHandler {
    /* renamed from: e */
    private static final String f22210e = DefaultDownloadServiceHandler.class.getSimpleName();

    /* renamed from: a */
    public void mo31839a(Context context, ServiceConnection serviceConnection) {
        try {
            context.startService(new Intent(context, DownloadService.class));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: c */
    public void mo31848c() {
        if (DownloadExpSwitchCode.m28744a(262144)) {
            this.f21824b = true;
            this.f21826d = false;
            if (C6704a.m27756a()) {
                C6704a.m27758b(f22210e, "onStartCommandOnMainThread");
            }
        }
    }

    /* renamed from: a */
    public void mo31840a(Intent intent, int i, int i2) {
        if (C6704a.m27756a()) {
            C6704a.m27758b(f22210e, "onStartCommand");
        }
        if (!DownloadExpSwitchCode.m28744a(262144)) {
            this.f21824b = true;
        }
        mo31851e();
    }
}
