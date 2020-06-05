package com.p530ss.android.socialbase.downloader.p559d;

import com.p530ss.android.socialbase.downloader.notification.AbsNotificationItem;
import com.p530ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;

/* renamed from: com.ss.android.socialbase.downloader.d.k */
public abstract class AbsNotificationListener extends AbsDownloadListener {
    /* renamed from: a */
    public abstract AbsNotificationItem mo31619a();

    /* renamed from: a */
    public void mo31350a(DownloadInfo cVar) {
        super.mo31350a(cVar);
        m27241j(cVar);
        m27240a(1, cVar, null, true);
    }

    /* renamed from: b */
    public void mo31352b(DownloadInfo cVar) {
        super.mo31352b(cVar);
        m27240a(2, cVar, null, false);
    }

    /* renamed from: c */
    public void mo31353c(DownloadInfo cVar) {
        super.mo31353c(cVar);
        m27242k(cVar);
    }

    /* renamed from: d */
    public void mo31354d(DownloadInfo cVar) {
        super.mo31354d(cVar);
        m27240a(-2, cVar, null, false);
    }

    /* renamed from: e */
    public void mo31355e(DownloadInfo cVar) {
        super.mo31355e(cVar);
        m27240a(-3, cVar, null, false);
    }

    /* renamed from: a */
    public void mo31351a(DownloadInfo cVar, BaseException aVar) {
        super.mo31351a(cVar, aVar);
        m27240a(-1, cVar, aVar, false);
    }

    /* renamed from: j */
    private void m27241j(DownloadInfo cVar) {
        if (cVar != null && cVar.mo32229af()) {
            AbsNotificationItem e = DownloadNotificationManager.m28984a().mo32647e(cVar.mo32283g());
            if (e == null) {
                DownloadNotificationManager.m28984a().mo32642a(mo31619a());
                return;
            }
            e.mo31508a(cVar);
        }
    }

    /* renamed from: a */
    private void m27240a(int i, DownloadInfo cVar, BaseException aVar, boolean z) {
        if (!(cVar == null || !cVar.mo32229af() || i == 4)) {
            AbsNotificationItem e = DownloadNotificationManager.m28984a().mo32647e(cVar.mo32283g());
            if (e == null) {
                e = mo31619a();
            }
            e.mo32631b(cVar.mo32225ab());
            if (i == -3) {
                e.mo32626a(cVar.mo32225ab());
            } else {
                e.mo32626a(cVar.mo32180Z());
            }
            e.mo32625a(i, aVar, z, false);
        }
    }

    /* renamed from: k */
    private void m27242k(DownloadInfo cVar) {
        if (cVar != null && cVar.mo32229af() && cVar.mo32308q() == 4) {
            AbsNotificationItem e = DownloadNotificationManager.m28984a().mo32647e(cVar.mo32283g());
            if (e == null) {
                e = mo31619a();
            }
            e.mo32627a(cVar.mo32180Z(), cVar.mo32225ab());
        }
    }
}
