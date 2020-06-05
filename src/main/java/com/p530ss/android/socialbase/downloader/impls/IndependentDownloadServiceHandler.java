package com.p530ss.android.socialbase.downloader.impls;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.p530ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.p530ss.android.socialbase.downloader.downloader.IDownloadAidlService;
import com.p530ss.android.socialbase.downloader.downloader.IDownloadAidlService.C6701a;
import com.p530ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler;
import com.p530ss.android.socialbase.downloader.downloader.IDownloadProxy;
import com.p530ss.android.socialbase.downloader.downloader.IDownloadServiceConnectionListener;
import com.p530ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.p530ss.android.socialbase.downloader.p561f.C6704a;
import com.p530ss.android.socialbase.downloader.p562g.C6712d;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p567k.DownloadSetting;
import com.p530ss.android.socialbase.downloader.p569m.DownloadExpSwitchCode;
import com.p530ss.android.socialbase.downloader.p569m.DownloadUtils;
import com.p530ss.android.socialbase.downloader.p569m.IPCUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.ss.android.socialbase.downloader.impls.n */
public class IndependentDownloadServiceHandler extends AbsDownloadServiceHandler implements ServiceConnection {
    /* access modifiers changed from: private|static|final */
    /* renamed from: e */
    public static final String f22218e = IndependentDownloadServiceHandler.class.getSimpleName();
    /* access modifiers changed from: private|static */
    /* renamed from: i */
    public static int f22219i = 0;
    /* access modifiers changed from: private|static */
    /* renamed from: j */
    public static long f22220j = 0;
    /* renamed from: f */
    private IDownloadAidlService f22221f;
    /* renamed from: g */
    private IDownloadServiceConnectionListener f22222g;
    /* renamed from: h */
    private int f22223h = -1;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public Handler f22224k = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    /* renamed from: l */
    public boolean f22225l;
    /* access modifiers changed from: private */
    /* renamed from: m */
    public ServiceConnection f22226m;

    /* renamed from: k */
    static /* synthetic */ int m28428k() {
        int i = f22219i;
        f22219i = i + 1;
        return i;
    }

    /* renamed from: a */
    public void mo31839a(Context context, ServiceConnection serviceConnection) {
        try {
            C6704a.m27758b(f22218e, "bindService");
            Intent intent = new Intent(context, IndependentProcessDownloadService.class);
            if (DownloadUtils.m28769a()) {
                intent.putExtra("fix_downloader_db_sigbus", DownloadSetting.m28617b().mo32550a("fix_sigbus_downloader_db"));
            }
            if (serviceConnection != null) {
                context.bindService(intent, serviceConnection, 1);
            }
            this.f22226m = serviceConnection;
            context.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public IBinder mo31836a(Intent intent) {
        if (intent != null && intent.getBooleanExtra("fix_downloader_db_sigbus", false)) {
            Log.w(f22218e, "downloader process sync database on main process!");
            DownloadSetting.m28616a("fix_sigbus_downloader_db", true);
        }
        C6704a.m27758b(f22218e, "onBind IndependentDownloadBinder");
        return new IndependentDownloadBinder();
    }

    /* renamed from: b */
    public void mo31846b(C6712d dVar) {
        if (dVar != null) {
            String str = f22218e;
            StringBuilder sb = new StringBuilder();
            sb.append("tryDownload aidlService == null:");
            sb.append(this.f22221f == null);
            C6704a.m27758b(str, sb.toString());
            if (this.f22221f == null) {
                mo31842a(dVar);
                mo31839a(C6694b.m27342B(), (ServiceConnection) this);
            } else {
                if (this.f21823a.get(dVar.mo32426o()) != null) {
                    synchronized (this.f21823a) {
                        if (this.f21823a.get(dVar.mo32426o()) != null) {
                            this.f21823a.remove(dVar.mo32426o());
                        }
                    }
                }
                try {
                    this.f22221f.mo31971a(IPCUtils.m28850a(dVar));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                synchronized (this.f21823a) {
                    SparseArray clone = this.f21823a.clone();
                    this.f21823a.clear();
                    if (C6694b.m27388t() != null) {
                        for (int i = 0; i < clone.size(); i++) {
                            if (((C6712d) clone.get(clone.keyAt(i))) != null) {
                                try {
                                    this.f22221f.mo31971a(IPCUtils.m28850a(dVar));
                                } catch (RemoteException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public void mo31849c(C6712d dVar) {
        if (dVar != null) {
            DownloadProcessDispatcher.m27395a().mo31859a(dVar.mo32426o(), true);
            AbsDownloadEngine t = C6694b.m27388t();
            if (t != null) {
                t.mo32485a(dVar);
            }
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C6704a.m27758b(f22218e, "onServiceConnected ");
        this.f22221f = C6701a.m27580a(iBinder);
        C6694b.m27342B();
        if (VERSION.SDK_INT < 26 && DownloadExpSwitchCode.m28744a(512) && DownloadUtils.m28769a()) {
            try {
                iBinder.linkToDeath(new DeathRecipient() {
                    public void binderDied() {
                        String h = IndependentDownloadServiceHandler.f22218e;
                        StringBuilder sb = new StringBuilder();
                        sb.append("binderDied: mServiceConnection = ");
                        sb.append(IndependentDownloadServiceHandler.this.f22226m);
                        C6704a.m27761d(h, sb.toString());
                        if (IndependentDownloadServiceHandler.f22219i < 5 && System.currentTimeMillis() - IndependentDownloadServiceHandler.f22220j > 15000) {
                            IndependentDownloadServiceHandler.this.f22224k.postDelayed(new Runnable() {
                                public void run() {
                                    C6704a.m27758b(IndependentDownloadServiceHandler.f22218e, "run: restart downloader process !!");
                                    IndependentDownloadServiceHandler.this.f22225l = true;
                                    try {
                                        IndependentDownloadServiceHandler.this.mo31839a(C6694b.m27342B(), (ServiceConnection) IndependentDownloadServiceHandler.this);
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                }
                            }, 1000);
                            IndependentDownloadServiceHandler.m28428k();
                            IndependentDownloadServiceHandler.f22220j = System.currentTimeMillis();
                        }
                    }
                }, 0);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            if (this.f22225l) {
                this.f22224k.postDelayed(new Runnable() {
                    public void run() {
                        C6694b.m27379k().execute(new Runnable() {
                            public void run() {
                                try {
                                    IndependentDownloadServiceHandler.this.m28429l();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                }, 1000);
                this.f22225l = false;
            }
        }
        IDownloadServiceConnectionListener oVar = this.f22222g;
        if (oVar != null) {
            oVar.mo32067a(iBinder);
        }
        String str = f22218e;
        StringBuilder sb = new StringBuilder();
        sb.append("onServiceConnected aidlService!=null");
        sb.append(this.f22221f != null);
        sb.append(" pendingTasks.size:");
        sb.append(this.f21823a.size());
        C6704a.m27758b(str, sb.toString());
        if (this.f22221f != null) {
            DownloadProcessDispatcher.m27395a().mo31866b();
            this.f21824b = true;
            this.f21826d = false;
            int i = this.f22223h;
            if (i != -1) {
                try {
                    this.f22221f.mo32000l(i);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
            synchronized (this.f21823a) {
                if (this.f22221f != null) {
                    SparseArray clone = this.f21823a.clone();
                    this.f21823a.clear();
                    for (int i2 = 0; i2 < clone.size(); i2++) {
                        C6712d dVar = (C6712d) clone.get(clone.keyAt(i2));
                        if (dVar != null) {
                            try {
                                this.f22221f.mo31971a(IPCUtils.m28850a(dVar));
                            } catch (RemoteException e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        C6704a.m27758b(f22218e, "onServiceDisconnected ");
        this.f22221f = null;
        this.f21824b = false;
        IDownloadServiceConnectionListener oVar = this.f22222g;
        if (oVar != null) {
            oVar.mo32068h();
        }
    }

    public void onBindingDied(ComponentName componentName) {
        this.f22221f = null;
        IDownloadServiceConnectionListener oVar = this.f22222g;
        if (oVar != null) {
            oVar.mo32068h();
        }
    }

    /* renamed from: a */
    public void mo31841a(IDownloadServiceConnectionListener oVar) {
        this.f22222g = oVar;
    }

    /* renamed from: a */
    public void mo31837a(int i) {
        IDownloadAidlService jVar = this.f22221f;
        if (jVar == null) {
            this.f22223h = i;
            mo31839a(C6694b.m27342B(), (ServiceConnection) this);
            return;
        }
        try {
            jVar.mo32000l(i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: f */
    public void mo31852f() {
        if (this.f22221f == null) {
            mo31839a(C6694b.m27342B(), (ServiceConnection) this);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m28429l() {
        C6704a.m27758b(f22218e, "resumeDownloaderProcessTaskForDied: ");
        if (C6694b.m27342B() != null) {
            IDownloadLaunchHandler o = C6694b.m27383o();
            if (o != null) {
                IDownloadProxy a = DownloadProxy.m28368a(true);
                if (a != null) {
                    List<DownloadInfo> d = a.mo32045d("application/vnd.android.package-archive");
                    if (d != null && !d.isEmpty()) {
                        ArrayList arrayList = new ArrayList();
                        for (DownloadInfo cVar : d) {
                            if (cVar != null && cVar.mo32174T() && cVar.mo32315w() == -5) {
                                arrayList.add(cVar);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            String str = f22218e;
                            StringBuilder sb = new StringBuilder();
                            sb.append("resumeDownloaderProcessTaskForDied: resume size =");
                            sb.append(arrayList.size());
                            C6704a.m27758b(str, sb.toString());
                            o.mo31503a(arrayList);
                        }
                    }
                }
            }
        }
    }
}
