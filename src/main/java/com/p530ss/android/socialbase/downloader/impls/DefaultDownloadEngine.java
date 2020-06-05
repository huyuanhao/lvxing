package com.p530ss.android.socialbase.downloader.impls;

import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.p557b.DownloadStatus;
import com.p530ss.android.socialbase.downloader.p561f.C6704a;
import com.p530ss.android.socialbase.downloader.p562g.C6712d;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p568l.DownloadRunnable;
import com.p530ss.android.socialbase.downloader.p568l.DownloadThreadPool;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: com.ss.android.socialbase.downloader.impls.e */
public class DefaultDownloadEngine extends AbsDownloadEngine {
    /* renamed from: b */
    private static DownloadThreadPool f22201b;

    /* renamed from: b */
    public static void m28311b(List<Callable<Object>> list) throws InterruptedException {
        ExecutorService l = C6694b.m27380l();
        if (l != null) {
            l.invokeAll(list);
        }
    }

    /* renamed from: c */
    public static List<Future> m28312c(List<Runnable> list) {
        ExecutorService l = C6694b.m27380l();
        ArrayList arrayList = new ArrayList(list.size());
        for (Runnable submit : list) {
            arrayList.add(l.submit(submit));
        }
        return arrayList;
    }

    public DefaultDownloadEngine() {
        f22201b = new DownloadThreadPool();
    }

    /* renamed from: d */
    public static Runnable m28313d(List<Future> list) {
        Runnable runnable;
        if (list != null && !list.isEmpty()) {
            try {
                ExecutorService l = C6694b.m27380l();
                if (l instanceof ThreadPoolExecutor) {
                    BlockingQueue queue = ((ThreadPoolExecutor) l).getQueue();
                    if (queue != null && !queue.isEmpty()) {
                        Iterator it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                runnable = null;
                                break;
                            }
                            Future future = (Future) it.next();
                            if ((future instanceof Runnable) && queue.remove(future)) {
                                runnable = (Runnable) future;
                                break;
                            }
                        }
                        if (runnable != null) {
                            list.remove(runnable);
                            return runnable;
                        }
                    }
                }
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("getUnstartedTask() error: ");
                sb.append(th.toString());
                C6704a.m27761d("DefaultDownloadEngine", sb.toString());
            }
        }
        return null;
    }

    /* renamed from: a */
    public boolean mo32488a(int i) {
        DownloadThreadPool dVar = f22201b;
        if (dVar == null || !dVar.mo32584a(i)) {
            return false;
        }
        DownloadInfo d = mo32496d(i);
        if (d == null) {
            return false;
        }
        if (DownloadStatus.m26982b(d.mo32308q())) {
            return true;
        }
        mo32492b(i);
        return false;
    }

    /* renamed from: a */
    public void mo32486a(DownloadRunnable cVar) {
        DownloadThreadPool dVar = f22201b;
        if (dVar != null) {
            dVar.mo32586b(cVar);
        }
    }

    /* renamed from: a */
    public void mo32484a(int i, C6712d dVar) {
        if (dVar != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("start doDownload for task : ");
            sb.append(i);
            C6704a.m27758b("DownloadTask", sb.toString());
            f22201b.mo32583a(new DownloadRunnable(dVar, this.f22169a));
        }
    }

    /* renamed from: b */
    public void mo32492b(int i) {
        DownloadThreadPool dVar = f22201b;
        if (dVar != null) {
            dVar.mo32587c(i);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public DownloadRunnable mo32495c(int i) {
        DownloadThreadPool dVar = f22201b;
        if (dVar == null) {
            return null;
        }
        return dVar.mo32585b(i);
    }

    /* renamed from: a */
    public List<Integer> mo32479a() {
        return f22201b.mo32582a();
    }
}
