package com.p530ss.android.socialbase.downloader.impls;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteException;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.p530ss.android.socialbase.downloader.downloader.Downloader;
import com.p530ss.android.socialbase.downloader.downloader.IDownloadAidlService;
import com.p530ss.android.socialbase.downloader.downloader.IDownloadAidlService.C6701a;
import com.p530ss.android.socialbase.downloader.downloader.IDownloadProxy;
import com.p530ss.android.socialbase.downloader.downloader.IDownloadServiceConnectionListener;
import com.p530ss.android.socialbase.downloader.downloader.IDownloadServiceHandler;
import com.p530ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.p530ss.android.socialbase.downloader.p557b.ListenerType;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadFileUriProvider;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadListener;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadNotificationEventListener;
import com.p530ss.android.socialbase.downloader.p559d.INotificationClickCallback;
import com.p530ss.android.socialbase.downloader.p559d.ProcessCallback;
import com.p530ss.android.socialbase.downloader.p561f.C6704a;
import com.p530ss.android.socialbase.downloader.p562g.C6712d;
import com.p530ss.android.socialbase.downloader.p562g.DownloadChunk;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p569m.DownloadUtils;
import com.p530ss.android.socialbase.downloader.p569m.IPCUtils;
import java.util.List;

/* renamed from: com.ss.android.socialbase.downloader.impls.o */
public class IndependentProcessDownloadHandler implements IDownloadProxy, IDownloadServiceConnectionListener {
    /* renamed from: a */
    private static final String f22231a = IndependentProcessDownloadHandler.class.getSimpleName();
    /* renamed from: b */
    private volatile IDownloadAidlService f22232b;
    /* renamed from: c */
    private IDownloadServiceHandler<IndependentProcessDownloadService> f22233c = C6694b.m27386r();
    /* renamed from: d */
    private IDownloadProxy f22234d = new ProcessDownloadHandler();

    /* renamed from: b */
    public void mo32036b(DownloadInfo cVar) {
    }

    public IndependentProcessDownloadHandler() {
        this.f22233c.mo31841a((IDownloadServiceConnectionListener) this);
    }

    /* renamed from: a */
    public void mo32015a(int i) {
        if (this.f22232b != null) {
            try {
                this.f22232b.mo31960a(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void mo32024a(int i, boolean z) {
        if (this.f22232b == null) {
            this.f22234d.mo32024a(i, z);
            return;
        }
        try {
            this.f22232b.mo31969a(i, z);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public boolean mo32039b(int i) {
        if (this.f22232b == null) {
            return false;
        }
        try {
            return this.f22232b.mo31982b(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: c */
    public void mo32041c(int i) {
        if (this.f22232b != null) {
            try {
                this.f22232b.mo31985c(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: d */
    public void mo32047d(int i) {
        if (this.f22232b != null) {
            try {
                this.f22232b.mo31990d(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void mo32014a() {
        if (this.f22232b != null) {
            try {
                this.f22232b.mo31959a();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: e */
    public long mo32048e(int i) {
        if (this.f22232b == null) {
            return 0;
        }
        try {
            return this.f22232b.mo31991e(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: f */
    public int mo32051f(int i) {
        if (this.f22232b == null) {
            return 0;
        }
        try {
            return this.f22232b.mo31994f(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: g */
    public boolean mo32054g(int i) {
        if (this.f22232b == null) {
            return false;
        }
        try {
            return this.f22232b.mo31995g(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: h */
    public DownloadInfo mo32055h(int i) {
        if (this.f22232b == null) {
            return this.f22234d.mo32055h(i);
        }
        try {
            return this.f22232b.mo31996h(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public List<DownloadInfo> mo32013a(String str) {
        if (this.f22232b == null) {
            return this.f22234d.mo32013a(str);
        }
        try {
            return this.f22232b.mo31958a(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: i */
    public List<DownloadChunk> mo32056i(int i) {
        if (this.f22232b == null) {
            return this.f22234d.mo32056i(i);
        }
        try {
            return this.f22232b.mo31997i(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public int mo32012a(String str, String str2) {
        return C6694b.m27348a(str, str2);
    }

    /* renamed from: b */
    public DownloadInfo mo32031b(String str, String str2) {
        return mo32055h(mo32012a(str, str2));
    }

    /* renamed from: b */
    public List<DownloadInfo> mo32032b(String str) {
        if (this.f22232b == null) {
            return this.f22234d.mo32032b(str);
        }
        try {
            return this.f22232b.mo31977b(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    public List<DownloadInfo> mo32040c(String str) {
        if (this.f22232b == null) {
            return this.f22234d.mo32040c(str);
        }
        try {
            return this.f22232b.mo31984c(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public void mo32028a(List<String> list) {
        if (this.f22232b == null) {
            this.f22234d.mo32028a(list);
            return;
        }
        try {
            this.f22232b.mo31973a(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void mo32035b(int i, boolean z) {
        if (this.f22232b == null) {
            this.f22234d.mo32035b(i, z);
            return;
        }
        try {
            this.f22232b.mo31980b(i, z);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: j */
    public void mo32057j(int i) {
        if (this.f22232b == null) {
            this.f22234d.mo32057j(i);
            return;
        }
        try {
            this.f22232b.mo31998j(i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo32020a(int i, int i2, IDownloadListener adVar, ListenerType hVar, boolean z) {
        if (this.f22232b != null) {
            try {
                this.f22232b.mo31978b(i, i2, IPCUtils.m28838a(adVar, hVar != ListenerType.SUB), hVar.ordinal(), z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public void mo32033b(int i, int i2, IDownloadListener adVar, ListenerType hVar, boolean z) {
        if (this.f22232b != null) {
            try {
                this.f22232b.mo31965a(i, i2, IPCUtils.m28838a(adVar, hVar != ListenerType.SUB), hVar.ordinal(), z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public boolean mo32030a(DownloadInfo cVar) {
        if (this.f22232b == null) {
            return this.f22234d.mo32030a(cVar);
        }
        try {
            this.f22232b.mo31975a(cVar);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    /* renamed from: a */
    public void mo32021a(int i, Notification notification) {
        if (this.f22232b == null) {
            C6704a.m27761d(f22231a, "startForeground, aidlService is null");
            return;
        }
        String str = f22231a;
        StringBuilder sb = new StringBuilder();
        sb.append("aidlService.startForeground, id = ");
        sb.append(i);
        C6704a.m27760c(str, sb.toString());
        try {
            this.f22232b.mo31966a(i, notification);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo32029a(boolean z, boolean z2) {
        if (this.f22232b == null) {
            C6704a.m27761d(f22231a, "stopForeground, aidlService is null");
            return;
        }
        C6704a.m27760c(f22231a, "aidlService.stopForeground");
        try {
            this.f22232b.mo31974a(z2);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public boolean mo32038b() {
        if (this.f22232b == null) {
            C6704a.m27761d(f22231a, "isServiceForeground, aidlService is null");
            return false;
        }
        C6704a.m27760c(f22231a, "aidlService.isServiceForeground");
        try {
            return this.f22232b.mo31993e();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: c */
    public boolean mo32043c() {
        return C6694b.m27343C();
    }

    /* renamed from: d */
    public List<DownloadInfo> mo32045d(String str) {
        if (this.f22232b == null) {
            return this.f22234d.mo32045d(str);
        }
        try {
            return this.f22232b.mo31992e(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: e */
    public List<DownloadInfo> mo32049e(String str) {
        if (this.f22232b != null) {
            try {
                return this.f22232b.mo31988d(str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: a */
    public void mo32027a(C6712d dVar) {
        if (dVar != null) {
            IDownloadServiceHandler<IndependentProcessDownloadService> pVar = this.f22233c;
            if (pVar != null) {
                pVar.mo31846b(dVar);
            }
        }
    }

    /* renamed from: b */
    public void mo32037b(C6712d dVar) {
        if (dVar != null) {
            IDownloadServiceHandler<IndependentProcessDownloadService> pVar = this.f22233c;
            if (pVar != null) {
                pVar.mo31849c(dVar);
            }
        }
    }

    /* renamed from: l */
    public boolean mo32059l(int i) {
        if (this.f22232b == null) {
            return false;
        }
        try {
            return this.f22232b.mo31999k(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: k */
    public void mo32058k(int i) {
        IDownloadServiceHandler<IndependentProcessDownloadService> pVar = this.f22233c;
        if (pVar != null) {
            pVar.mo31837a(i);
        }
    }

    /* renamed from: d */
    public void mo32046d() {
        IDownloadServiceHandler<IndependentProcessDownloadService> pVar = this.f22233c;
        if (pVar != null) {
            pVar.mo31852f();
        }
    }

    /* renamed from: e */
    public boolean mo32050e() {
        if (this.f22232b == null) {
            return this.f22234d.mo32050e();
        }
        try {
            return this.f22232b.mo31987c();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public void mo32023a(int i, List<DownloadChunk> list) {
        if (this.f22232b != null) {
            try {
                this.f22232b.mo31979b(i, list);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    public void mo32042c(int i, boolean z) {
        if (this.f22232b != null) {
            try {
                this.f22232b.mo31986c(i, z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: m */
    public int mo32060m(int i) {
        if (this.f22232b == null) {
            return DownloadProcessDispatcher.m27395a().mo31863b(i);
        }
        try {
            return this.f22232b.mo32001m(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* renamed from: a */
    public void mo32026a(DownloadChunk bVar) {
        if (this.f22232b == null) {
            this.f22234d.mo32026a(bVar);
            return;
        }
        try {
            this.f22232b.mo31972a(bVar);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public boolean mo32044c(DownloadInfo cVar) {
        if (this.f22232b == null) {
            return this.f22234d.mo32044c(cVar);
        }
        try {
            return this.f22232b.mo31983b(cVar);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: n */
    public boolean mo32061n(int i) {
        if (this.f22232b == null) {
            return this.f22234d.mo32061n(i);
        }
        try {
            return this.f22232b.mo32002n(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: o */
    public void mo32062o(int i) {
        if (this.f22232b == null) {
            this.f22234d.mo32062o(i);
            return;
        }
        try {
            this.f22232b.mo32003o(i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo32019a(int i, int i2, long j) {
        if (this.f22232b == null) {
            this.f22234d.mo32019a(i, i2, j);
            return;
        }
        try {
            this.f22232b.mo31964a(i, i2, j);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo32018a(int i, int i2, int i3, long j) {
        if (this.f22232b == null) {
            this.f22234d.mo32018a(i, i2, i3, j);
            return;
        }
        try {
            this.f22232b.mo31963a(i, i2, i3, j);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo32017a(int i, int i2, int i3, int i4) {
        if (this.f22232b == null) {
            this.f22234d.mo32017a(i, i2, i3, i4);
            return;
        }
        try {
            this.f22232b.mo31962a(i, i2, i3, i4);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: p */
    public boolean mo32063p(int i) {
        if (this.f22232b == null) {
            return this.f22234d.mo32063p(i);
        }
        try {
            return this.f22232b.mo32004p(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: f */
    public void mo32052f() {
        if (this.f22232b == null) {
            this.f22234d.mo32052f();
            return;
        }
        try {
            this.f22232b.mo31989d();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void mo32034b(int i, List<DownloadChunk> list) {
        if (this.f22232b == null) {
            this.f22234d.mo32034b(i, list);
            return;
        }
        try {
            this.f22232b.mo31968a(i, list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: g */
    public boolean mo32053g() {
        return this.f22232b != null;
    }

    /* renamed from: a */
    public void mo32025a(ProcessCallback hVar) {
        if (this.f22232b != null) {
            try {
                this.f22232b.mo31970a(IPCUtils.m28832a(hVar));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void mo32016a(int i, int i2) {
        if (this.f22232b != null) {
            try {
                this.f22232b.mo31961a(i, i2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: q */
    public IDownloadNotificationEventListener mo32064q(int i) {
        if (this.f22232b != null) {
            try {
                return IPCUtils.m28828a(this.f22232b.mo32005q(i));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: r */
    public INotificationClickCallback mo32065r(int i) {
        if (this.f22232b != null) {
            try {
                return IPCUtils.m28830a(this.f22232b.mo32006r(i));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: a */
    public void mo32022a(int i, IDownloadNotificationEventListener agVar) {
        if (this.f22232b != null) {
            try {
                this.f22232b.mo31967a(i, IPCUtils.m28827a(agVar));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: s */
    public IDownloadFileUriProvider mo32066s(int i) {
        if (this.f22232b != null) {
            try {
                return IPCUtils.m28845a(this.f22232b.mo32007s(i));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: a */
    public void mo32067a(IBinder iBinder) {
        this.f22232b = C6701a.m27580a(iBinder);
        if (DownloadUtils.m28769a()) {
            mo32025a((ProcessCallback) new ProcessCallback() {
                /* renamed from: a */
                public void mo31763a(int i, int i2) {
                    if (i2 == 1) {
                        Downloader.m27478a(C6694b.m27342B()).mo31914a(i);
                        List i3 = DownloadProxy.m28368a(false).mo32056i(i);
                        if (i3 != null) {
                            DownloadProxy.m28368a(true).mo32023a(i, DownloadUtils.m28758a(i3));
                        }
                    } else if (i2 == 2) {
                        Downloader.m27478a(C6694b.m27342B()).mo31920b(i);
                    }
                }
            });
        }
    }

    /* renamed from: h */
    public void mo32068h() {
        this.f22232b = null;
    }
}
