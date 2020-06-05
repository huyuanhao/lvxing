package com.p530ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.SparseArray;
import com.p530ss.android.socialbase.downloader.impls.AbsDownloadEngine;
import com.p530ss.android.socialbase.downloader.p561f.C6704a;
import com.p530ss.android.socialbase.downloader.p562g.C6712d;
import com.p530ss.android.socialbase.downloader.p569m.DownloadExpSwitchCode;
import java.lang.ref.WeakReference;

/* renamed from: com.ss.android.socialbase.downloader.downloader.a */
public abstract class AbsDownloadServiceHandler implements IDownloadServiceHandler {
    /* access modifiers changed from: private|static|final */
    /* renamed from: e */
    public static final String f21822e = AbsDownloadServiceHandler.class.getSimpleName();
    /* renamed from: a */
    protected final SparseArray<C6712d> f21823a = new SparseArray<>();
    /* renamed from: b */
    protected volatile boolean f21824b = false;
    /* renamed from: c */
    protected volatile boolean f21825c;
    /* renamed from: d */
    protected volatile boolean f21826d = false;
    /* renamed from: f */
    private WeakReference<Service> f21827f;
    /* renamed from: g */
    private Handler f21828g = new Handler(Looper.getMainLooper());
    /* renamed from: h */
    private Runnable f21829h = new Runnable() {
        public void run() {
            if (C6704a.m27756a()) {
                C6704a.m27758b(AbsDownloadServiceHandler.f21822e, "tryDownload: 2 try");
            }
            if (!AbsDownloadServiceHandler.this.f21824b) {
                if (C6704a.m27756a()) {
                    C6704a.m27758b(AbsDownloadServiceHandler.f21822e, "tryDownload: 2 error");
                }
                AbsDownloadServiceHandler.this.mo31839a(C6694b.m27342B(), (ServiceConnection) null);
            }
        }
    };

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo31839a(Context context, ServiceConnection serviceConnection) {
    }

    /* renamed from: a */
    public void mo31840a(Intent intent, int i, int i2) {
    }

    /* renamed from: a */
    public void mo31841a(IDownloadServiceConnectionListener oVar) {
    }

    /* renamed from: c */
    public void mo31848c() {
    }

    /* renamed from: c */
    public void mo31849c(C6712d dVar) {
    }

    /* renamed from: a */
    public void mo31843a(WeakReference weakReference) {
        this.f21827f = weakReference;
    }

    /* renamed from: a */
    public boolean mo31845a() {
        return this.f21824b;
    }

    /* renamed from: b */
    public boolean mo31847b() {
        String str = f21822e;
        StringBuilder sb = new StringBuilder();
        sb.append("isServiceForeground = ");
        sb.append(this.f21825c);
        C6704a.m27760c(str, sb.toString());
        return this.f21825c;
    }

    /* renamed from: a */
    public IBinder mo31836a(Intent intent) {
        C6704a.m27758b(f21822e, "onBind Abs");
        return new Binder();
    }

    /* renamed from: a */
    public void mo31838a(int i, Notification notification) {
        WeakReference<Service> weakReference = this.f21827f;
        if (weakReference == null || weakReference.get() == null) {
            C6704a.m27761d(f21822e, "startForeground: downloadService is null, do nothing!");
            return;
        }
        String str = f21822e;
        StringBuilder sb = new StringBuilder();
        sb.append("startForeground  id = ");
        sb.append(i);
        sb.append(", service = ");
        sb.append(this.f21827f.get());
        sb.append(",  isServiceAlive = ");
        sb.append(this.f21824b);
        C6704a.m27760c(str, sb.toString());
        try {
            ((Service) this.f21827f.get()).startForeground(i, notification);
            this.f21825c = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo31844a(boolean z) {
        WeakReference<Service> weakReference = this.f21827f;
        if (weakReference != null && weakReference.get() != null) {
            String str = f21822e;
            StringBuilder sb = new StringBuilder();
            sb.append("stopForeground  service = ");
            sb.append(this.f21827f.get());
            sb.append(",  isServiceAlive = ");
            sb.append(this.f21824b);
            C6704a.m27760c(str, sb.toString());
            try {
                this.f21825c = false;
                ((Service) this.f21827f.get()).stopForeground(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: d */
    public void mo31850d() {
        this.f21824b = false;
    }

    /* renamed from: a */
    public void mo31842a(C6712d dVar) {
        if (dVar != null) {
            String str = f21822e;
            StringBuilder sb = new StringBuilder();
            sb.append("pendDownloadTask pendingTasks.size:");
            sb.append(this.f21823a.size());
            sb.append(" downloadTask.getDownloadId():");
            sb.append(dVar.mo32426o());
            C6704a.m27758b(str, sb.toString());
            if (this.f21823a.get(dVar.mo32426o()) == null) {
                synchronized (this.f21823a) {
                    if (this.f21823a.get(dVar.mo32426o()) == null) {
                        this.f21823a.put(dVar.mo32426o(), dVar);
                    }
                }
            }
            String str2 = f21822e;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("after pendDownloadTask pendingTasks.size:");
            sb2.append(this.f21823a.size());
            C6704a.m27758b(str2, sb2.toString());
        }
    }

    /* renamed from: b */
    public void mo31846b(C6712d dVar) {
        if (dVar != null) {
            if (!this.f21824b) {
                if (C6704a.m27756a()) {
                    C6704a.m27758b(f21822e, "tryDownload but service is not alive");
                }
                if (DownloadExpSwitchCode.m28744a(262144)) {
                    synchronized (this.f21823a) {
                        mo31842a(dVar);
                        if (!this.f21826d) {
                            if (C6704a.m27756a()) {
                                C6704a.m27758b(f21822e, "tryDownload: 1");
                            }
                            mo31839a(C6694b.m27342B(), (ServiceConnection) null);
                            this.f21826d = true;
                        } else {
                            this.f21828g.removeCallbacks(this.f21829h);
                            this.f21828g.postDelayed(this.f21829h, 10);
                        }
                    }
                } else {
                    mo31842a(dVar);
                    mo31839a(C6694b.m27342B(), (ServiceConnection) null);
                }
            } else {
                if (this.f21823a.get(dVar.mo32426o()) != null) {
                    synchronized (this.f21823a) {
                        if (this.f21823a.get(dVar.mo32426o()) != null) {
                            this.f21823a.remove(dVar.mo32426o());
                        }
                    }
                }
                AbsDownloadEngine t = C6694b.m27388t();
                if (t != null) {
                    t.mo32485a(dVar);
                }
                mo31851e();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo31851e() {
        SparseArray clone;
        String str = f21822e;
        StringBuilder sb = new StringBuilder();
        sb.append("resumePendingTask pendingTasks.size:");
        sb.append(this.f21823a.size());
        C6704a.m27758b(str, sb.toString());
        synchronized (this.f21823a) {
            clone = this.f21823a.clone();
            this.f21823a.clear();
        }
        AbsDownloadEngine t = C6694b.m27388t();
        if (t != null) {
            for (int i = 0; i < clone.size(); i++) {
                C6712d dVar = (C6712d) clone.get(clone.keyAt(i));
                if (dVar != null) {
                    t.mo32485a(dVar);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo31837a(int i) {
        C6704a.m27752a(i);
    }

    /* renamed from: f */
    public void mo31852f() {
        if (!this.f21824b) {
            if (C6704a.m27756a()) {
                C6704a.m27758b(f21822e, "startService");
            }
            mo31839a(C6694b.m27342B(), (ServiceConnection) null);
        }
    }
}
