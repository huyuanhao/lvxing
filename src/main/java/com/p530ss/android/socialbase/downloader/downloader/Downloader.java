package com.p530ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.p530ss.android.socialbase.downloader.p557b.ListenerType;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadFileUriProvider;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadListener;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadNotificationEventListener;
import com.p530ss.android.socialbase.downloader.p562g.C6712d;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p569m.DownloadExpSwitchCode;
import java.util.List;

/* renamed from: com.ss.android.socialbase.downloader.downloader.f */
public class Downloader {
    /* renamed from: a */
    private static volatile Downloader f21919a;

    private Downloader() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0016, code lost:
            return;
     */
    /* renamed from: a */
    public static synchronized void m27479a(com.p530ss.android.socialbase.downloader.downloader.DownloaderBuilder r2) {
        /*
        java.lang.Class<com.ss.android.socialbase.downloader.downloader.f> r0 = com.p530ss.android.socialbase.downloader.downloader.Downloader.class
        monitor-enter(r0)
        if (r2 != 0) goto L_0x0007
        monitor-exit(r0)
        return
    L_0x0007:
        com.ss.android.socialbase.downloader.downloader.f r1 = f21919a     // Catch:{ all -> 0x0017 }
        if (r1 != 0) goto L_0x0012
        com.ss.android.socialbase.downloader.downloader.f r2 = r2.mo31956t()     // Catch:{ all -> 0x0017 }
        f21919a = r2     // Catch:{ all -> 0x0017 }
        goto L_0x0015
    L_0x0012:
        com.p530ss.android.socialbase.downloader.downloader.C6694b.m27357a(r2)     // Catch:{ all -> 0x0017 }
    L_0x0015:
        monitor-exit(r0)
        return
    L_0x0017:
        r2 = move-exception
        monitor-exit(r0)
        throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.downloader.downloader.Downloader.m27479a(com.ss.android.socialbase.downloader.downloader.g):void");
    }

    Downloader(DownloaderBuilder gVar) {
        C6694b.m27357a(gVar);
    }

    /* renamed from: a */
    public static Downloader m27478a(Context context) {
        if (f21919a == null) {
            synchronized (Downloader.class) {
                if (f21919a == null) {
                    C6694b.m27353a(context);
                    f21919a = new Downloader();
                }
            }
        }
        return f21919a;
    }

    /* renamed from: b */
    public static C6712d m27480b(Context context) {
        m27478a(context);
        return new C6712d();
    }

    /* renamed from: a */
    public void mo31914a(int i) {
        DownloadProcessDispatcher.m27395a().mo31874d(i);
    }

    /* renamed from: a */
    public List<DownloadInfo> mo31912a(String str) {
        return DownloadProcessDispatcher.m27395a().mo31857a(str);
    }

    /* renamed from: b */
    public void mo31920b(int i) {
        mo31916a(i, true);
    }

    /* renamed from: a */
    public void mo31916a(int i, boolean z) {
        DownloadProcessDispatcher.m27395a().mo31872c(i, z);
    }

    /* renamed from: c */
    public void mo31922c(int i) {
        DownloadProcessDispatcher.m27395a().mo31877f(i);
    }

    /* renamed from: d */
    public boolean mo31924d(int i) {
        return DownloadProcessDispatcher.m27395a().mo31876e(i);
    }

    /* renamed from: e */
    public void mo31925e(int i) {
        DownloadProcessDispatcher.m27395a().mo31878g(i);
    }

    /* renamed from: a */
    public void mo31913a() {
        DownloadProcessDispatcher.m27395a().mo31871c();
    }

    /* renamed from: a */
    public void mo31917a(List<String> list) {
        DownloadProcessDispatcher.m27395a().mo31861a(list);
    }

    /* renamed from: f */
    public int mo31926f(int i) {
        return DownloadProcessDispatcher.m27395a().mo31879h(i);
    }

    /* renamed from: g */
    public boolean mo31927g(int i) {
        boolean i2;
        if (!DownloadExpSwitchCode.m28744a(4194304)) {
            return DownloadProcessDispatcher.m27395a().mo31880i(i);
        }
        synchronized (this) {
            i2 = DownloadProcessDispatcher.m27395a().mo31880i(i);
        }
        return i2;
    }

    /* renamed from: h */
    public DownloadInfo mo31928h(int i) {
        return DownloadProcessDispatcher.m27395a().mo31881j(i);
    }

    /* renamed from: a */
    public DownloadInfo mo31911a(String str, String str2) {
        return DownloadProcessDispatcher.m27395a().mo31864b(str, str2);
    }

    /* renamed from: i */
    public IDownloadNotificationEventListener mo31929i(int i) {
        return DownloadProcessDispatcher.m27395a().mo31882k(i);
    }

    /* renamed from: b */
    public List<DownloadInfo> mo31919b(String str) {
        return DownloadProcessDispatcher.m27395a().mo31865b(str);
    }

    /* renamed from: j */
    public void mo31930j(int i) {
        DownloadProcessDispatcher.m27395a().mo31875d(i, true);
    }

    @Deprecated
    /* renamed from: k */
    public void mo31931k(int i) {
        DownloadProcessDispatcher.m27395a().mo31858a(i, null, ListenerType.MAIN, true);
    }

    @Deprecated
    /* renamed from: a */
    public void mo31915a(int i, IDownloadListener adVar) {
        if (adVar != null) {
            DownloadProcessDispatcher.m27395a().mo31867b(i, adVar, ListenerType.MAIN, true);
        }
    }

    /* renamed from: a */
    public boolean mo31918a(DownloadInfo cVar) {
        return DownloadProcessDispatcher.m27395a().mo31862a(cVar);
    }

    /* renamed from: c */
    public List<DownloadInfo> mo31921c(String str) {
        return DownloadProcessDispatcher.m27395a().mo31870c(str);
    }

    /* renamed from: d */
    public List<DownloadInfo> mo31923d(String str) {
        return DownloadProcessDispatcher.m27395a().mo31873d(str);
    }

    /* renamed from: l */
    public IDownloadFileUriProvider mo31932l(int i) {
        return DownloadProcessDispatcher.m27395a().mo31886o(i);
    }

    /* renamed from: m */
    public boolean mo31933m(int i) {
        return DownloadProcessDispatcher.m27395a().mo31869c(i).mo32038b();
    }
}
