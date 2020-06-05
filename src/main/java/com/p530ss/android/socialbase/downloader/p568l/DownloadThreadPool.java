package com.p530ss.android.socialbase.downloader.p568l;

import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadMonitorDepend;
import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.p530ss.android.socialbase.downloader.p562g.C6712d;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p563h.DownloadMonitorHelper;
import com.p530ss.android.socialbase.downloader.p567k.DownloadSetting;
import com.p530ss.android.socialbase.downloader.p569m.DownloadExpSwitchCode;
import com.p530ss.android.socialbase.downloader.p569m.DownloadUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: com.ss.android.socialbase.downloader.l.d */
public class DownloadThreadPool {
    /* renamed from: a */
    private volatile SparseArray<DownloadRunnable> f22356a = new SparseArray<>();
    /* renamed from: b */
    private int f22357b = 0;

    /* renamed from: a */
    public void mo32583a(DownloadRunnable cVar) {
        int i;
        cVar.mo32578f();
        synchronized (DownloadThreadPool.class) {
            i = 0;
            if (this.f22357b >= 500) {
                m28706b();
                this.f22357b = 0;
            } else {
                this.f22357b++;
            }
            this.f22356a.put(cVar.mo32577e(), cVar);
        }
        C6712d c = cVar.mo32574c();
        try {
            ExecutorService j = C6694b.m27378j();
            if (j == null) {
                DownloadMonitorHelper.m28177a(c.mo32401e(), c.mo32357a(), new BaseException((int) PointerIconCompat.TYPE_HELP, "execute failed cpu thread executor service is null"), c.mo32357a() != null ? c.mo32357a().mo32308q() : 0);
            } else if (DownloadSetting.m28610a(cVar.mo32577e()).mo32552b("pause_with_interrupt", false)) {
                cVar.mo32569a(j.submit(cVar));
            } else {
                j.execute(cVar);
            }
        } catch (Exception e) {
            if (c != null) {
                IDownloadMonitorDepend e2 = c.mo32401e();
                DownloadInfo a = c.mo32357a();
                BaseException aVar = new BaseException((int) PointerIconCompat.TYPE_HELP, DownloadUtils.m28786b((Throwable) e, "DownloadThreadPoolExecute"));
                if (c.mo32357a() != null) {
                    i = c.mo32357a().mo32308q();
                }
                DownloadMonitorHelper.m28177a(e2, a, aVar, i);
            }
            e.printStackTrace();
        } catch (OutOfMemoryError e3) {
            if (c != null) {
                IDownloadMonitorDepend e4 = c.mo32401e();
                DownloadInfo a2 = c.mo32357a();
                BaseException aVar2 = new BaseException((int) PointerIconCompat.TYPE_HELP, "execute OOM");
                if (c.mo32357a() != null) {
                    i = c.mo32357a().mo32308q();
                }
                DownloadMonitorHelper.m28177a(e4, a2, aVar2, i);
            }
            e3.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m28706b() {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f22356a.size(); i++) {
                int keyAt = this.f22356a.keyAt(i);
                if (!((DownloadRunnable) this.f22356a.get(keyAt)).mo32576d()) {
                    arrayList.add(Integer.valueOf(keyAt));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                Integer num = (Integer) arrayList.get(i2);
                if (num != null) {
                    this.f22356a.remove(num.intValue());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    public void mo32586b(DownloadRunnable cVar) {
        if (cVar != null) {
            synchronized (DownloadThreadPool.class) {
                try {
                    if (DownloadExpSwitchCode.m28744a(524288)) {
                        int indexOfValue = this.f22356a.indexOfValue(cVar);
                        if (indexOfValue >= 0) {
                            this.f22356a.removeAt(indexOfValue);
                        }
                    } else {
                        this.f22356a.remove(cVar.mo32577e());
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
            return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
            return false;
     */
    /* renamed from: a */
    public boolean mo32584a(int r4) {
        /*
        r3 = this;
        java.lang.Class<com.ss.android.socialbase.downloader.l.d> r0 = com.p530ss.android.socialbase.downloader.p568l.DownloadThreadPool.class
        monitor-enter(r0)
        android.util.SparseArray<com.ss.android.socialbase.downloader.l.c> r1 = r3.f22356a     // Catch:{ all -> 0x0026 }
        r2 = 0
        if (r1 == 0) goto L_0x0024
        android.util.SparseArray<com.ss.android.socialbase.downloader.l.c> r1 = r3.f22356a     // Catch:{ all -> 0x0026 }
        int r1 = r1.size()     // Catch:{ all -> 0x0026 }
        if (r1 > 0) goto L_0x0011
        goto L_0x0024
    L_0x0011:
        android.util.SparseArray<com.ss.android.socialbase.downloader.l.c> r1 = r3.f22356a     // Catch:{ all -> 0x0026 }
        java.lang.Object r4 = r1.get(r4)     // Catch:{ all -> 0x0026 }
        com.ss.android.socialbase.downloader.l.c r4 = (com.p530ss.android.socialbase.downloader.p568l.DownloadRunnable) r4     // Catch:{ all -> 0x0026 }
        if (r4 == 0) goto L_0x0022
        boolean r4 = r4.mo32576d()     // Catch:{ all -> 0x0026 }
        if (r4 == 0) goto L_0x0022
        r2 = 1
    L_0x0022:
        monitor-exit(r0)     // Catch:{ all -> 0x0026 }
        return r2
    L_0x0024:
        monitor-exit(r0)     // Catch:{ all -> 0x0026 }
        return r2
    L_0x0026:
        r4 = move-exception
        monitor-exit(r0)     // Catch:{ all -> 0x0026 }
        throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.downloader.p568l.DownloadThreadPool.mo32584a(int):boolean");
    }

    /* renamed from: b */
    public DownloadRunnable mo32585b(int i) {
        synchronized (DownloadThreadPool.class) {
            m28706b();
            DownloadRunnable cVar = (DownloadRunnable) this.f22356a.get(i);
            if (cVar == null) {
                return null;
            }
            cVar.mo32572b();
            m28707c(cVar);
            this.f22356a.remove(i);
            return cVar;
        }
    }

    /* renamed from: c */
    public void mo32587c(int i) {
        synchronized (DownloadThreadPool.class) {
            m28706b();
            DownloadRunnable cVar = (DownloadRunnable) this.f22356a.get(i);
            if (cVar != null) {
                cVar.mo32565a();
                m28707c(cVar);
                this.f22356a.remove(i);
            }
        }
    }

    /* renamed from: c */
    private void m28707c(DownloadRunnable cVar) {
        try {
            ExecutorService j = C6694b.m27378j();
            if (j != null && (j instanceof ThreadPoolExecutor)) {
                ((ThreadPoolExecutor) j).remove(cVar);
                if (cVar != null && DownloadSetting.m28610a(cVar.mo32577e()).mo32552b("pause_with_interrupt", false)) {
                    Future g = cVar.mo32579g();
                    if (g != null) {
                        g.cancel(true);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public List<Integer> mo32582a() {
        ArrayList arrayList;
        synchronized (DownloadThreadPool.class) {
            m28706b();
            arrayList = new ArrayList();
            for (int i = 0; i < this.f22356a.size(); i++) {
                DownloadRunnable cVar = (DownloadRunnable) this.f22356a.get(this.f22356a.keyAt(i));
                if (cVar != null) {
                    arrayList.add(Integer.valueOf(cVar.mo32577e()));
                }
            }
        }
        return arrayList;
    }
}
