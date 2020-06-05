package com.p530ss.android.downloadlib;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.p530ss.android.downloadlib.p541a.CommonDownloadHandler;
import com.p530ss.android.downloadlib.p541a.DownloadHandler;
import com.p530ss.android.p531a.p532a.p534b.C6507c;
import com.p530ss.android.p531a.p532a.p534b.DownloadController;
import com.p530ss.android.p531a.p532a.p534b.DownloadEventConfig;
import com.p530ss.android.p531a.p532a.p534b.DownloadStatusChangeListener;
import com.p530ss.android.p531a.p532a.p534b.p535a.DownloadCompletedListener;
import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.ss.android.downloadlib.g */
public class DownloadDispatcherImpl implements DownloadDispatcher {
    /* renamed from: a */
    private static volatile DownloadDispatcherImpl f21435a;
    /* renamed from: b */
    private final Handler f21436b = new Handler(Looper.getMainLooper());
    /* renamed from: c */
    private final List<DownloadHandler> f21437c = new CopyOnWriteArrayList();
    /* renamed from: d */
    private final Map<String, DownloadHandler> f21438d = new ConcurrentHashMap();
    /* access modifiers changed from: private|final */
    /* renamed from: e */
    public final CopyOnWriteArrayList<DownloadCompletedListener> f21439e = new CopyOnWriteArrayList<>();
    /* renamed from: f */
    private long f21440f;

    private DownloadDispatcherImpl() {
    }

    /* renamed from: a */
    public static DownloadDispatcherImpl m26547a() {
        if (f21435a == null) {
            synchronized (DownloadDispatcherImpl.class) {
                if (f21435a == null) {
                    f21435a = new DownloadDispatcherImpl();
                }
            }
        }
        return f21435a;
    }

    /* renamed from: a */
    public void mo31412a(Context context, int i, DownloadStatusChangeListener dVar, C6507c cVar) {
        if (cVar != null && !TextUtils.isEmpty(cVar.mo31061a())) {
            DownloadHandler gVar = (DownloadHandler) this.f21438d.get(cVar.mo31061a());
            if (gVar != null) {
                gVar.mo31317b(context).mo31316b(i, dVar).mo31320b(cVar).mo31312a();
            } else if (!this.f21437c.isEmpty()) {
                m26550b(context, i, dVar, cVar);
            } else {
                m26552c(context, i, dVar, cVar);
            }
        }
    }

    /* renamed from: a */
    public CommonDownloadHandler mo31418a(String str) {
        Map<String, DownloadHandler> map = this.f21438d;
        if (!(map == null || map.size() == 0 || TextUtils.isEmpty(str))) {
            DownloadHandler gVar = (DownloadHandler) this.f21438d.get(str);
            if (gVar instanceof CommonDownloadHandler) {
                return (CommonDownloadHandler) gVar;
            }
        }
        return null;
    }

    /* renamed from: b */
    private synchronized void m26550b(Context context, int i, DownloadStatusChangeListener dVar, C6507c cVar) {
        if (this.f21437c.size() <= 0) {
            m26552c(context, i, dVar, cVar);
        } else {
            DownloadHandler gVar = (DownloadHandler) this.f21437c.remove(0);
            gVar.mo31317b(context).mo31316b(i, dVar).mo31320b(cVar).mo31312a();
            this.f21438d.put(cVar.mo31061a(), gVar);
        }
    }

    /* renamed from: c */
    private void m26552c(Context context, int i, DownloadStatusChangeListener dVar, C6507c cVar) {
        if (cVar != null) {
            CommonDownloadHandler fVar = new CommonDownloadHandler();
            fVar.mo31317b(context).mo31316b(i, dVar).mo31320b(cVar).mo31312a();
            this.f21438d.put(cVar.mo31061a(), fVar);
        }
    }

    /* renamed from: a */
    public void mo31414a(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            DownloadHandler gVar = (DownloadHandler) this.f21438d.get(str);
            if (gVar != null) {
                if (gVar.mo31315a(i)) {
                    this.f21437c.add(gVar);
                    this.f21438d.remove(str);
                }
                m26549b();
            }
        }
    }

    /* renamed from: a */
    public void mo31417a(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            DownloadHandler gVar = (DownloadHandler) this.f21438d.get(str);
            if (gVar != null) {
                gVar.mo31314a(z);
            }
        }
    }

    /* renamed from: a */
    public void mo31415a(String str, long j, int i) {
        mo31416a(str, j, i, null, null);
    }

    /* renamed from: a */
    public void mo31416a(String str, long j, int i, DownloadEventConfig bVar, DownloadController aVar) {
        if (!TextUtils.isEmpty(str)) {
            DownloadHandler gVar = (DownloadHandler) this.f21438d.get(str);
            if (gVar != null) {
                gVar.mo31319b(bVar).mo31318b(aVar).mo31313a(j, i);
            }
        }
    }

    /* renamed from: a */
    public void mo31413a(DownloadCompletedListener aVar) {
        if (aVar != null) {
            this.f21439e.add(aVar);
        }
    }

    /* renamed from: b */
    private void m26549b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f21440f >= 120000) {
            this.f21440f = currentTimeMillis;
            if (!this.f21437c.isEmpty()) {
                m26551c();
            }
        }
    }

    /* renamed from: c */
    private void m26551c() {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (DownloadHandler gVar : this.f21437c) {
            if (!gVar.mo31321b()) {
                if (currentTimeMillis - gVar.mo31323d() > 120000) {
                    gVar.mo31326g();
                    arrayList.add(gVar);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            this.f21437c.removeAll(arrayList);
        }
    }

    /* renamed from: a */
    public void mo31419a(final C6507c cVar, final DownloadController aVar, final DownloadEventConfig bVar) {
        this.f21436b.post(new Runnable() {
            public void run() {
                Iterator it = DownloadDispatcherImpl.this.f21439e.iterator();
                while (it.hasNext()) {
                    ((DownloadCompletedListener) it.next()).mo16552a(cVar, aVar, bVar);
                }
            }
        });
    }

    /* renamed from: a */
    public void mo31421a(final DownloadInfo cVar, final BaseException aVar, final String str) {
        this.f21436b.post(new Runnable() {
            public void run() {
                Iterator it = DownloadDispatcherImpl.this.f21439e.iterator();
                while (it.hasNext()) {
                    ((DownloadCompletedListener) it.next()).mo16554a(cVar, aVar, str);
                }
            }
        });
    }

    /* renamed from: a */
    public void mo31422a(final DownloadInfo cVar, final String str) {
        this.f21436b.post(new Runnable() {
            public void run() {
                Iterator it = DownloadDispatcherImpl.this.f21439e.iterator();
                while (it.hasNext()) {
                    ((DownloadCompletedListener) it.next()).mo16555a(cVar, str);
                }
            }
        });
    }

    /* renamed from: b */
    public void mo31423b(final DownloadInfo cVar, final String str) {
        this.f21436b.post(new Runnable() {
            public void run() {
                Iterator it = DownloadDispatcherImpl.this.f21439e.iterator();
                while (it.hasNext()) {
                    ((DownloadCompletedListener) it.next()).mo16556b(cVar, str);
                }
            }
        });
    }

    /* renamed from: a */
    public void mo31420a(final DownloadInfo cVar) {
        this.f21436b.post(new Runnable() {
            public void run() {
                Iterator it = DownloadDispatcherImpl.this.f21439e.iterator();
                while (it.hasNext()) {
                    ((DownloadCompletedListener) it.next()).mo16553a(cVar);
                }
            }
        });
    }
}
