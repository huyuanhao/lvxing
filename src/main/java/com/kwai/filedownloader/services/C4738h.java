package com.kwai.filedownloader.services;

import android.util.SparseArray;
import com.kwai.filedownloader.download.DownloadLaunchRunnable;
import com.kwai.filedownloader.p358f.C4652b;
import com.kwai.filedownloader.p358f.C4660d;
import com.kwai.filedownloader.p358f.C4661e;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: com.kwai.filedownloader.services.h */
class C4738h {
    /* renamed from: a */
    private SparseArray<DownloadLaunchRunnable> f15285a = new SparseArray<>();
    /* renamed from: b */
    private ThreadPoolExecutor f15286b;
    /* renamed from: c */
    private final String f15287c;
    /* renamed from: d */
    private int f15288d;
    /* renamed from: e */
    private int f15289e;

    C4738h(int i) {
        String str = "Network";
        this.f15287c = str;
        this.f15289e = 0;
        this.f15286b = C4652b.m19102a(i, str);
        this.f15288d = i;
    }

    /* renamed from: c */
    private synchronized void m19460c() {
        SparseArray<DownloadLaunchRunnable> sparseArray = new SparseArray<>();
        int size = this.f15285a.size();
        for (int i = 0; i < size; i++) {
            int keyAt = this.f15285a.keyAt(i);
            DownloadLaunchRunnable downloadLaunchRunnable = (DownloadLaunchRunnable) this.f15285a.get(keyAt);
            if (downloadLaunchRunnable.mo25126e()) {
                sparseArray.put(keyAt, downloadLaunchRunnable);
            }
        }
        this.f15285a = sparseArray;
    }

    /* renamed from: a */
    public synchronized int mo25354a() {
        m19460c();
        return this.f15285a.size();
    }

    /* renamed from: a */
    public int mo25355a(String str, int i) {
        if (str == null) {
            return 0;
        }
        int size = this.f15285a.size();
        for (int i2 = 0; i2 < size; i2++) {
            DownloadLaunchRunnable downloadLaunchRunnable = (DownloadLaunchRunnable) this.f15285a.valueAt(i2);
            if (downloadLaunchRunnable != null && downloadLaunchRunnable.mo25126e() && downloadLaunchRunnable.mo25125d() != i && str.equals(downloadLaunchRunnable.mo25127f())) {
                return downloadLaunchRunnable.mo25125d();
            }
        }
        return 0;
    }

    /* renamed from: a */
    public void mo25356a(DownloadLaunchRunnable downloadLaunchRunnable) {
        int i;
        downloadLaunchRunnable.mo25122b();
        synchronized (this) {
            this.f15285a.put(downloadLaunchRunnable.mo25125d(), downloadLaunchRunnable);
        }
        this.f15286b.execute(downloadLaunchRunnable);
        int i2 = this.f15289e;
        if (i2 >= 600) {
            m19460c();
            i = 0;
        } else {
            i = i2 + 1;
        }
        this.f15289e = i;
    }

    /* renamed from: a */
    public synchronized boolean mo25357a(int i) {
        if (mo25354a() > 0) {
            C4660d.m19124d(this, "Can't change the max network thread count, because the  network thread pool isn't in IDLE, please try again after all running tasks are completed or invoking FileDownloader#pauseAll directly.", new Object[0]);
            return false;
        }
        int a = C4661e.m19126a(i);
        if (C4660d.f15179a) {
            C4660d.m19123c(this, "change the max network thread count, from %d to %d", Integer.valueOf(this.f15288d), Integer.valueOf(a));
        }
        List shutdownNow = this.f15286b.shutdownNow();
        this.f15286b = C4652b.m19102a(a, "Network");
        if (shutdownNow.size() > 0) {
            C4660d.m19124d(this, "recreate the network thread pool and discard %d tasks", Integer.valueOf(shutdownNow.size()));
        }
        this.f15288d = a;
        return true;
    }

    /* renamed from: b */
    public synchronized List<Integer> mo25358b() {
        ArrayList arrayList;
        m19460c();
        arrayList = new ArrayList();
        for (int i = 0; i < this.f15285a.size(); i++) {
            arrayList.add(Integer.valueOf(((DownloadLaunchRunnable) this.f15285a.get(this.f15285a.keyAt(i))).mo25125d()));
        }
        return arrayList;
    }

    /* renamed from: b */
    public void mo25359b(int i) {
        m19460c();
        synchronized (this) {
            DownloadLaunchRunnable downloadLaunchRunnable = (DownloadLaunchRunnable) this.f15285a.get(i);
            if (downloadLaunchRunnable != null) {
                downloadLaunchRunnable.mo25117a();
                boolean remove = this.f15286b.remove(downloadLaunchRunnable);
                if (C4660d.f15179a) {
                    C4660d.m19123c(this, "successful cancel %d %B", Integer.valueOf(i), Boolean.valueOf(remove));
                }
            }
            this.f15285a.remove(i);
        }
    }

    /* renamed from: c */
    public boolean mo25360c(int i) {
        DownloadLaunchRunnable downloadLaunchRunnable = (DownloadLaunchRunnable) this.f15285a.get(i);
        return downloadLaunchRunnable != null && downloadLaunchRunnable.mo25126e();
    }
}
