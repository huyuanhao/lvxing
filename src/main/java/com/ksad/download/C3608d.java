package com.ksad.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import com.ksad.download.C3615h.C3617a;
import com.ksad.download.DownloadTask.DownloadRequest;
import com.ksad.download.p297c.C3607b;
import com.kwai.filedownloader.C4723q;
import com.kwai.filedownloader.download.C4629b;
import com.kwai.filedownloader.p358f.C4654c.C4656b;
import com.kwai.filedownloader.services.C4731c.C4732a;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.ksad.download.d */
public class C3608d {
    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final Map<Integer, DownloadTask> f12366a = new ConcurrentHashMap();
    /* renamed from: b */
    private final Map<String, Integer> f12367b = new ConcurrentHashMap();
    /* renamed from: c */
    private C3605c f12368c;
    /* renamed from: d */
    private Context f12369d;
    /* renamed from: e */
    private C3610b f12370e;
    /* renamed from: f */
    private boolean f12371f = false;

    /* renamed from: com.ksad.download.d$a */
    private static final class C3609a {
        /* access modifiers changed from: private|static|final */
        /* renamed from: a */
        public static final C3608d f12372a = new C3608d();
    }

    /* renamed from: com.ksad.download.d$b */
    public class C3610b extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ C3608d f12373a;

        public void onReceive(Context context, Intent intent) {
            NetworkInfo c = C3607b.m15047c(context);
            if (c != null && 1 == c.getType()) {
                for (Integer intValue : this.f12373a.f12366a.keySet()) {
                    DownloadTask downloadTask = (DownloadTask) this.f12373a.f12366a.get(Integer.valueOf(intValue.intValue()));
                    if (downloadTask.isErrorBecauseWifiRequired()) {
                        downloadTask.resume(null);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static C3608d m15048a() {
        return C3609a.f12372a;
    }

    /* renamed from: a */
    private void m15050a(int i, DownloadRequest downloadRequest) {
        DownloadTask downloadTask = (DownloadTask) this.f12366a.get(Integer.valueOf(i));
        if (downloadTask != null) {
            downloadTask.resume(downloadRequest);
        }
    }

    /* renamed from: a */
    public static void m15051a(Context context, File file, C3613f fVar) {
        C3617a aVar;
        C3603b.m15024a(context);
        C3603b.m15026a(file);
        C3611e.m15066a().mo22733a(fVar);
        C4732a a = new C4732a().mo25334a((int) ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        try {
            aVar = new C3617a(false);
        } catch (Throwable th) {
            th.printStackTrace();
            aVar = null;
        }
        if (aVar != null) {
            a.mo25335a((C4656b) aVar);
        }
        C4723q.m19349a(context, a);
    }

    /* renamed from: a */
    public int mo22715a(DownloadRequest downloadRequest, C3605c cVar) {
        DownloadTask downloadTask = new DownloadTask(downloadRequest);
        if (downloadRequest.getDownloadUrl().contains("downali.game.uc.cn")) {
            mo22720b();
        } else if (this.f12371f) {
            mo22722c();
        }
        if (this.f12366a.get(Integer.valueOf(downloadTask.getId())) != null) {
            m15050a(downloadTask.getId(), downloadRequest);
            mo22721b(downloadTask.getId());
            mo22717a(downloadTask.getId(), cVar, this.f12368c);
        } else {
            this.f12366a.put(Integer.valueOf(downloadTask.getId()), downloadTask);
            this.f12367b.put(downloadTask.getUrl(), Integer.valueOf(downloadTask.getId()));
            downloadTask.submit();
            mo22717a(downloadTask.getId(), cVar, this.f12368c);
        }
        return downloadTask.getId();
    }

    /* renamed from: a */
    public DownloadTask mo22716a(int i) {
        return (DownloadTask) this.f12366a.get(Integer.valueOf(i));
    }

    /* renamed from: a */
    public void mo22717a(int i, C3605c... cVarArr) {
        DownloadTask downloadTask = (DownloadTask) this.f12366a.get(Integer.valueOf(i));
        if (downloadTask != null && cVarArr != null) {
            for (C3605c cVar : cVarArr) {
                if (cVar != null) {
                    cVar.mo22702a(i);
                    downloadTask.addListener(cVar);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22718a(DownloadTask downloadTask) {
        this.f12366a.remove(Integer.valueOf(downloadTask.getId()));
        this.f12367b.remove(downloadTask.getUrl());
    }

    /* renamed from: a */
    public void mo22719a(C3605c cVar) {
        this.f12368c = cVar;
    }

    /* renamed from: b */
    public void mo22720b() {
        C3617a aVar;
        try {
            aVar = new C3617a(true);
        } catch (Throwable th) {
            th.printStackTrace();
            aVar = null;
        }
        if (aVar != null) {
            C4629b.m18995a().mo25144b(new C4732a().mo25334a((int) ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED).mo25335a((C4656b) aVar));
            this.f12371f = true;
        }
    }

    /* renamed from: b */
    public void mo22721b(int i) {
        DownloadTask downloadTask = (DownloadTask) this.f12366a.get(Integer.valueOf(i));
        if (downloadTask != null) {
            downloadTask.clearListener();
        }
    }

    /* renamed from: c */
    public void mo22722c() {
        C3617a aVar;
        try {
            aVar = new C3617a(false);
        } catch (Throwable th) {
            th.printStackTrace();
            aVar = null;
        }
        if (aVar != null) {
            C4629b.m18995a().mo25144b(new C4732a().mo25334a((int) ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED).mo25335a((C4656b) aVar));
        }
    }

    /* renamed from: c */
    public void mo22723c(int i) {
        DownloadTask downloadTask = (DownloadTask) this.f12366a.get(Integer.valueOf(i));
        if (downloadTask != null) {
            downloadTask.cancel();
            mo22718a(downloadTask);
        }
    }

    /* renamed from: d */
    public void mo22724d(int i) {
        DownloadTask downloadTask = (DownloadTask) this.f12366a.get(Integer.valueOf(i));
        if (downloadTask != null) {
            downloadTask.userPause();
        }
    }

    /* renamed from: d */
    public boolean mo22725d() {
        while (true) {
            boolean z = false;
            for (Entry value : this.f12366a.entrySet()) {
                DownloadTask downloadTask = (DownloadTask) value.getValue();
                if (downloadTask != null) {
                    int status = downloadTask.getStatus();
                    if (!(status == -2 || status == 1 || status == 2 || status == 3 || status == 5 || status == 6 || status == 10 || status == 11)) {
                        if (Math.abs(downloadTask.getStatusUpdateTime() - System.currentTimeMillis()) > 120000) {
                            z = true;
                        }
                    }
                }
            }
            return z;
        }
    }

    /* renamed from: e */
    public void mo22726e() {
        C3610b bVar = this.f12370e;
        if (bVar != null) {
            try {
                this.f12369d.unregisterReceiver(bVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: e */
    public void mo22727e(int i) {
        m15050a(i, (DownloadRequest) null);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        try {
            Iterator it = this.f12366a.entrySet().iterator();
            while (it.hasNext()) {
                ((DownloadTask) ((Entry) it.next()).getValue()).cancel();
                it.remove();
            }
            this.f12367b.clear();
            mo22726e();
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.finalize();
    }
}
