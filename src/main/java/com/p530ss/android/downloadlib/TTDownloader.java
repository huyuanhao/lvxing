package com.p530ss.android.downloadlib;

import android.content.Context;
import com.p530ss.android.downloadad.p538a.AdDownloadCompletedEventHandler;
import com.p530ss.android.downloadad.p538a.AdWebViewDownloadManager;
import com.p530ss.android.downloadlib.p541a.C6565j;
import com.p530ss.android.downloadlib.p541a.p543b.ModelManager;
import com.p530ss.android.downloadlib.p547c.AppDownloadLaunchResumeListener;
import com.p530ss.android.downloadlib.p547c.NewDownloadCompletedEventDispatcher;
import com.p530ss.android.downloadlib.p547c.NewDownloadDepend;
import com.p530ss.android.p531a.p532a.DownloadConfigure;
import com.p530ss.android.p531a.p532a.p534b.C6507c;
import com.p530ss.android.p531a.p532a.p534b.DownloadController;
import com.p530ss.android.p531a.p532a.p534b.DownloadEventConfig;
import com.p530ss.android.p531a.p532a.p534b.DownloadStatusChangeListener;
import com.p530ss.android.p531a.p532a.p534b.p535a.DownloadCompletedListener;
import com.p530ss.android.socialbase.appdownloader.AppDownloader;
import com.p530ss.android.socialbase.appdownloader.p552c.IAppDownloadLaunchResumeListener;
import com.p530ss.android.socialbase.downloader.downloader.Downloader;

/* renamed from: com.ss.android.downloadlib.h */
public class TTDownloader {
    /* renamed from: a */
    private static volatile TTDownloader f21457a;
    /* renamed from: b */
    private DownloadConfigure f21458b = new DownloadConfigureImpl();
    /* renamed from: c */
    private DownloadDispatcher f21459c = DownloadDispatcherImpl.m26547a();
    /* renamed from: d */
    private AdDownloadCompletedEventHandler f21460d;
    /* renamed from: e */
    private AdWebViewDownloadManager f21461e;
    /* renamed from: f */
    private long f21462f = System.currentTimeMillis();

    /* renamed from: a */
    public static TTDownloader m26565a(Context context) {
        if (f21457a == null) {
            synchronized (TTDownloader.class) {
                if (f21457a == null) {
                    f21457a = new TTDownloader(context);
                }
            }
        }
        return f21457a;
    }

    private TTDownloader(Context context) {
        m26566b(context);
    }

    /* renamed from: b */
    private void m26566b(Context context) {
        C6565j.m26358a(context);
        Downloader.m27478a(C6565j.m26357a());
        ModelManager.m26169a().mo31272b();
        AppDownloader.m26714h().mo31480a(C6565j.m26357a(), "misc_config", new NewDownloadDepend(), new NewDownloadCompletedEventDispatcher(context), new BaseDownloadMonitorListener());
        AppDownloader.m26714h().mo31481a((IAppDownloadLaunchResumeListener) new AppDownloadLaunchResumeListener());
    }

    /* renamed from: a */
    public DownloadConfigure mo31429a() {
        return this.f21458b;
    }

    /* renamed from: b */
    public long mo31436b() {
        return this.f21462f;
    }

    /* renamed from: c */
    public void mo31437c() {
        this.f21462f = System.currentTimeMillis();
    }

    /* renamed from: d */
    public AdDownloadCompletedEventHandler mo31438d() {
        if (this.f21460d == null) {
            this.f21460d = AdDownloadCompletedEventHandlerImpl.m26106a();
        }
        return this.f21460d;
    }

    /* renamed from: e */
    public AdWebViewDownloadManager mo31439e() {
        if (this.f21461e == null) {
            this.f21461e = AdWebViewDownloadManagerImpl.m26401a();
        }
        return this.f21461e;
    }

    /* renamed from: h */
    private DownloadDispatcher m26567h() {
        return this.f21459c;
    }

    /* renamed from: a */
    public void mo31430a(Context context, int i, DownloadStatusChangeListener dVar, C6507c cVar) {
        m26567h().mo31412a(context, i, dVar, cVar);
    }

    /* renamed from: a */
    public void mo31434a(String str, long j, int i, DownloadEventConfig bVar, DownloadController aVar) {
        m26567h().mo31416a(str, j, i, bVar, aVar);
    }

    /* renamed from: a */
    public void mo31433a(String str, long j, int i) {
        m26567h().mo31415a(str, j, i);
    }

    /* renamed from: a */
    public void mo31432a(String str, int i) {
        m26567h().mo31414a(str, i);
    }

    /* renamed from: a */
    public void mo31435a(String str, boolean z) {
        m26567h().mo31417a(str, z);
    }

    /* renamed from: a */
    public void mo31431a(DownloadCompletedListener aVar) {
        m26567h().mo31413a(aVar);
    }

    /* renamed from: f */
    public String mo31440f() {
        return C6565j.m26379m();
    }

    /* renamed from: g */
    public void mo31441g() {
        DownloadComponentManager.m26440a().mo31389c();
    }
}
