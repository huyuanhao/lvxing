package com.p530ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.p530ss.android.socialbase.appdownloader.p552c.IAppDownloadEventHandler;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.downloader.Downloader;
import com.p530ss.android.socialbase.downloader.notification.AbsNotificationItem;
import com.p530ss.android.socialbase.downloader.p559d.AbsNotificationListener;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadNotificationEventListener;
import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p567k.DownloadSetting;
import java.io.File;

/* renamed from: com.ss.android.socialbase.appdownloader.h */
public class DownloadNotificationListener extends AbsNotificationListener {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public Context f21621a;
    /* renamed from: b */
    private int f21622b;
    /* renamed from: c */
    private String f21623c;
    /* renamed from: d */
    private String f21624d;
    /* renamed from: e */
    private String f21625e;
    /* renamed from: f */
    private String f21626f;
    /* renamed from: g */
    private AbsNotificationItem f21627g;

    public DownloadNotificationListener(Context context, int i, String str, String str2, String str3, String str4) {
        if (context != null) {
            this.f21621a = context.getApplicationContext();
        } else {
            this.f21621a = C6694b.m27342B();
        }
        this.f21622b = i;
        this.f21623c = str;
        this.f21624d = str2;
        this.f21625e = str3;
        this.f21626f = str4;
    }

    public DownloadNotificationListener(AbsNotificationItem aVar) {
        this.f21621a = C6694b.m27342B();
        this.f21627g = aVar;
    }

    /* renamed from: a */
    public AbsNotificationItem mo31619a() {
        if (this.f21627g == null) {
            Context context = this.f21621a;
            if (context != null) {
                AppNotificationItem eVar = new AppNotificationItem(context, this.f21622b, this.f21623c, this.f21624d, this.f21625e, this.f21626f);
                return eVar;
            }
        }
        return this.f21627g;
    }

    /* renamed from: a */
    public void mo31350a(DownloadInfo cVar) {
        if (cVar != null && !AppDownloadUtils.m26666c(cVar.mo32318y())) {
            super.mo31350a(cVar);
        }
    }

    /* renamed from: b */
    public void mo31352b(DownloadInfo cVar) {
        if (cVar != null && !AppDownloadUtils.m26666c(cVar.mo32318y())) {
            super.mo31352b(cVar);
        }
    }

    /* renamed from: d */
    public void mo31354d(DownloadInfo cVar) {
        if (cVar != null && !AppDownloadUtils.m26666c(cVar.mo32318y())) {
            super.mo31354d(cVar);
        }
    }

    /* renamed from: c */
    public void mo31353c(DownloadInfo cVar) {
        if (cVar != null && !AppDownloadUtils.m26666c(cVar.mo32318y())) {
            super.mo31353c(cVar);
        }
    }

    /* renamed from: e */
    public void mo31355e(final DownloadInfo cVar) {
        if (cVar != null && this.f21621a != null) {
            if (cVar.mo32229af() && !AppDownloadUtils.m26666c(cVar.mo32318y())) {
                super.mo31355e(cVar);
            }
            boolean z = true;
            if (((cVar.mo32313u() && !cVar.mo32314v()) || AppDownloadUtils.m26664b(cVar.mo32318y()) || TextUtils.isEmpty(cVar.mo32231ah()) || !cVar.mo32231ah().equals("application/vnd.android.package-archive")) && DownloadSetting.m28610a(cVar.mo32283g()).mo32547a("auto_install_when_resume", 0) != 1) {
                z = false;
            }
            final int a = z ? AppDownloadUtils.m26645a(this.f21621a, cVar.mo32283g(), false) : 2;
            C6694b.m27379k().execute(new Runnable() {
                public void run() {
                    IAppDownloadEventHandler b = AppDownloader.m26714h().mo31485b();
                    IDownloadNotificationEventListener i = Downloader.m27478a(DownloadNotificationListener.this.f21621a).mo31929i(cVar.mo32283g());
                    if (b != null || i != null) {
                        File file = new File(cVar.mo32297k(), cVar.mo32287h());
                        if (file.exists()) {
                            try {
                                PackageInfo packageArchiveInfo = DownloadNotificationListener.this.f21621a.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), AppDownloadUtils.m26643a());
                                if (packageArchiveInfo != null) {
                                    String str = packageArchiveInfo.packageName;
                                    if (a != 1 && !TextUtils.isEmpty(cVar.mo32319z())) {
                                        str = cVar.mo32319z();
                                    }
                                    String str2 = str;
                                    if (b != null) {
                                        b.mo31368a(cVar.mo32283g(), 1, str2, -3, cVar.mo32246aw());
                                    }
                                    if (i != null) {
                                        i.mo31500a(1, cVar, str2, "");
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void mo31351a(DownloadInfo cVar, BaseException aVar) {
        if (cVar != null && this.f21621a != null && cVar.mo32229af() && !AppDownloadUtils.m26666c(cVar.mo32318y())) {
            super.mo31351a(cVar, aVar);
        }
    }
}
