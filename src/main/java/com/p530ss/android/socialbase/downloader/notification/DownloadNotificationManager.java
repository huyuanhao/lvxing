package com.p530ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.downloader.Downloader;
import com.p530ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.p530ss.android.socialbase.downloader.p561f.C6704a;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.ss.android.socialbase.downloader.notification.b */
public class DownloadNotificationManager {
    /* renamed from: a */
    private static volatile DownloadNotificationManager f22469a;
    /* renamed from: c */
    private static final Object f22470c = new Object();
    /* renamed from: b */
    private final Set<String> f22471b = new HashSet();
    /* renamed from: d */
    private final SparseArray<AbsNotificationItem> f22472d = new SparseArray<>();

    /* renamed from: b */
    static boolean m28985b(int i) {
        return i == 1 || i == 3;
    }

    private DownloadNotificationManager() {
    }

    /* renamed from: a */
    public static DownloadNotificationManager m28984a() {
        if (f22469a == null) {
            synchronized (DownloadNotificationManager.class) {
                if (f22469a == null) {
                    f22469a = new DownloadNotificationManager();
                }
            }
        }
        return f22469a;
    }

    /* renamed from: a */
    public void mo32639a(int i) {
        DownloadInfo h = Downloader.m27478a(C6694b.m27342B()).mo31928h(i);
        if (h != null) {
            mo32641a(h);
            mo32644b(h);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo32641a(DownloadInfo cVar) {
        IDownloadCache p = C6694b.m27384p();
        if (p != null && cVar.mo32199aB()) {
            cVar.mo32269d(3);
            try {
                p.mo31676a(cVar);
            } catch (SQLiteException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo32644b(DownloadInfo cVar) {
        if (m28986c(cVar)) {
            mo32648f(cVar.mo32283g());
        }
    }

    /* renamed from: c */
    static boolean m28986c(DownloadInfo cVar) {
        return cVar.mo32199aB() && m28985b(cVar.mo32228ae());
    }

    /* renamed from: a */
    public void mo32640a(int i, int i2, Notification notification) {
        Context B = C6694b.m27342B();
        if (B != null && i != 0 && notification != null) {
            try {
                Intent intent = new Intent(B, DownloadNotificationService.class);
                intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY");
                intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA", notification);
                intent.putExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", i2);
                intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i);
                B.startService(intent);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    public void mo32645c(int i) {
        Context B = C6694b.m27342B();
        if (B != null && i != 0) {
            try {
                Intent intent = new Intent(B, DownloadNotificationService.class);
                intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL");
                intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i);
                B.startService(intent);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void mo32642a(AbsNotificationItem aVar) {
        if (aVar != null) {
            synchronized (this.f22472d) {
                this.f22472d.put(aVar.mo32624a(), aVar);
            }
        }
    }

    /* renamed from: d */
    public AbsNotificationItem mo32646d(int i) {
        AbsNotificationItem aVar;
        if (i == 0) {
            return null;
        }
        synchronized (this.f22472d) {
            aVar = (AbsNotificationItem) this.f22472d.get(i);
            if (aVar != null) {
                this.f22472d.remove(i);
                StringBuilder sb = new StringBuilder();
                sb.append("removeNotificationId ");
                sb.append(i);
                C6704a.m27753a(sb.toString());
            }
        }
        return aVar;
    }

    /* renamed from: e */
    public AbsNotificationItem mo32647e(int i) {
        AbsNotificationItem aVar;
        if (i == 0) {
            return null;
        }
        synchronized (this.f22472d) {
            aVar = (AbsNotificationItem) this.f22472d.get(i);
        }
        return aVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public SparseArray<AbsNotificationItem> mo32643b() {
        SparseArray<AbsNotificationItem> sparseArray;
        synchronized (this.f22472d) {
            sparseArray = this.f22472d;
        }
        return sparseArray;
    }

    /* renamed from: f */
    public void mo32648f(int i) {
        mo32646d(i);
        if (i != 0) {
            m28984a().mo32645c(i);
        }
    }
}
