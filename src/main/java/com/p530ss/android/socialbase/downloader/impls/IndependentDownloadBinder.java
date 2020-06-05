package com.p530ss.android.socialbase.downloader.impls;

import android.app.Notification;
import android.os.RemoteException;
import com.p530ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.p530ss.android.socialbase.downloader.downloader.IDownloadAidlService.C6701a;
import com.p530ss.android.socialbase.downloader.downloader.IDownloadProxy;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadAidlFileProvider;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadAidlListener;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadNotificationEventAidlListener;
import com.p530ss.android.socialbase.downloader.p559d.INotificationClickAidlCallback;
import com.p530ss.android.socialbase.downloader.p559d.ProcessAidlCallback;
import com.p530ss.android.socialbase.downloader.p562g.DownloadAidlTask;
import com.p530ss.android.socialbase.downloader.p562g.DownloadChunk;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p569m.DownloadUtils;
import com.p530ss.android.socialbase.downloader.p569m.IPCUtils;
import java.util.List;

/* renamed from: com.ss.android.socialbase.downloader.impls.m */
public class IndependentDownloadBinder extends C6701a {
    /* renamed from: a */
    private static final String f22216a = IndependentDownloadBinder.class.getSimpleName();
    /* renamed from: b */
    private final IDownloadProxy f22217b = new ProcessDownloadHandler(true);

    /* renamed from: a */
    public void mo31971a(DownloadAidlTask aVar) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar != null) {
            nVar.mo32037b(IPCUtils.m28851a(aVar));
        }
    }

    /* renamed from: a */
    public void mo31960a(int i) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar != null) {
            nVar.mo32015a(i);
        }
    }

    /* renamed from: a */
    public void mo31969a(int i, boolean z) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar != null) {
            nVar.mo32024a(i, z);
        }
    }

    /* renamed from: b */
    public boolean mo31982b(int i) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar == null) {
            return false;
        }
        return nVar.mo32039b(i);
    }

    /* renamed from: c */
    public void mo31985c(int i) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar != null) {
            nVar.mo32041c(i);
        }
    }

    /* renamed from: d */
    public void mo31990d(int i) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar != null) {
            nVar.mo32047d(i);
        }
    }

    /* renamed from: a */
    public void mo31959a() throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar != null) {
            nVar.mo32014a();
        }
    }

    /* renamed from: e */
    public long mo31991e(int i) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar == null) {
            return 0;
        }
        return nVar.mo32048e(i);
    }

    /* renamed from: f */
    public int mo31994f(int i) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar == null) {
            return 0;
        }
        return nVar.mo32051f(i);
    }

    /* renamed from: g */
    public boolean mo31995g(int i) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar == null) {
            return false;
        }
        return nVar.mo32054g(i);
    }

    /* renamed from: h */
    public DownloadInfo mo31996h(int i) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar == null) {
            return null;
        }
        return nVar.mo32055h(i);
    }

    /* renamed from: a */
    public List<DownloadInfo> mo31958a(String str) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar == null) {
            return null;
        }
        return nVar.mo32013a(str);
    }

    /* renamed from: i */
    public List<DownloadChunk> mo31997i(int i) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar == null) {
            return null;
        }
        return nVar.mo32056i(i);
    }

    /* renamed from: a */
    public int mo31957a(String str, String str2) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar == null) {
            return 0;
        }
        return nVar.mo32012a(str, str2);
    }

    /* renamed from: b */
    public DownloadInfo mo31976b(String str, String str2) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar == null) {
            return null;
        }
        return nVar.mo32031b(str, str2);
    }

    /* renamed from: b */
    public List<DownloadInfo> mo31977b(String str) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar == null) {
            return null;
        }
        return nVar.mo32032b(str);
    }

    /* renamed from: c */
    public List<DownloadInfo> mo31984c(String str) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar == null) {
            return null;
        }
        return nVar.mo32040c(str);
    }

    /* renamed from: d */
    public List<DownloadInfo> mo31988d(String str) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar == null) {
            return null;
        }
        return nVar.mo32049e(str);
    }

    /* renamed from: a */
    public void mo31973a(List<String> list) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar != null) {
            nVar.mo32028a(list);
        }
    }

    /* renamed from: b */
    public void mo31980b(int i, boolean z) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar != null) {
            nVar.mo32035b(i, z);
        }
    }

    /* renamed from: j */
    public void mo31998j(int i) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar != null) {
            nVar.mo32057j(i);
        }
    }

    /* renamed from: a */
    public void mo31965a(int i, int i2, IDownloadAidlListener pVar, int i3, boolean z) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar != null) {
            nVar.mo32033b(i, i2, IPCUtils.m28825a(pVar), DownloadUtils.m28798c(i3), z);
        }
    }

    /* renamed from: b */
    public void mo31978b(int i, int i2, IDownloadAidlListener pVar, int i3, boolean z) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar != null) {
            nVar.mo32020a(i, i2, IPCUtils.m28825a(pVar), DownloadUtils.m28798c(i3), z);
        }
    }

    /* renamed from: a */
    public boolean mo31975a(DownloadInfo cVar) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar == null) {
            return false;
        }
        return nVar.mo32030a(cVar);
    }

    /* renamed from: a */
    public void mo31966a(int i, Notification notification) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar != null) {
            nVar.mo32021a(i, notification);
        }
    }

    /* renamed from: a */
    public void mo31974a(boolean z) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar != null) {
            nVar.mo32029a(true, z);
        }
    }

    /* renamed from: e */
    public boolean mo31993e() throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar == null) {
            return false;
        }
        return nVar.mo32038b();
    }

    /* renamed from: b */
    public boolean mo31981b() throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar == null) {
            return false;
        }
        return nVar.mo32043c();
    }

    /* renamed from: e */
    public List<DownloadInfo> mo31992e(String str) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar == null) {
            return null;
        }
        return nVar.mo32045d(str);
    }

    /* renamed from: k */
    public boolean mo31999k(int i) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar == null) {
            return false;
        }
        return nVar.mo32059l(i);
    }

    /* renamed from: l */
    public void mo32000l(int i) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar != null) {
            nVar.mo32058k(i);
        }
    }

    /* renamed from: c */
    public boolean mo31987c() throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar == null) {
            return false;
        }
        return nVar.mo32050e();
    }

    /* renamed from: c */
    public void mo31986c(int i, boolean z) throws RemoteException {
        DownloadProcessDispatcher.m27395a().mo31868b(i, z);
    }

    /* renamed from: m */
    public int mo32001m(int i) throws RemoteException {
        return DownloadProcessDispatcher.m27395a().mo31863b(i);
    }

    /* renamed from: a */
    public void mo31972a(DownloadChunk bVar) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar != null) {
            nVar.mo32026a(bVar);
        }
    }

    /* renamed from: b */
    public boolean mo31983b(DownloadInfo cVar) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar == null) {
            return false;
        }
        return nVar.mo32044c(cVar);
    }

    /* renamed from: n */
    public boolean mo32002n(int i) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar == null) {
            return false;
        }
        return nVar.mo32061n(i);
    }

    /* renamed from: o */
    public void mo32003o(int i) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar != null) {
            nVar.mo32062o(i);
        }
    }

    /* renamed from: a */
    public void mo31964a(int i, int i2, long j) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar != null) {
            nVar.mo32019a(i, i2, j);
        }
    }

    /* renamed from: a */
    public void mo31963a(int i, int i2, int i3, long j) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar != null) {
            nVar.mo32018a(i, i2, i3, j);
        }
    }

    /* renamed from: a */
    public void mo31962a(int i, int i2, int i3, int i4) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar != null) {
            nVar.mo32017a(i, i2, i3, i4);
        }
    }

    /* renamed from: p */
    public boolean mo32004p(int i) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar == null) {
            return false;
        }
        return nVar.mo32063p(i);
    }

    /* renamed from: d */
    public void mo31989d() throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar != null) {
            nVar.mo32052f();
        }
    }

    /* renamed from: a */
    public void mo31968a(int i, List<DownloadChunk> list) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar != null) {
            nVar.mo32034b(i, list);
        }
    }

    /* renamed from: b */
    public void mo31979b(int i, List<DownloadChunk> list) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar != null) {
            nVar.mo32023a(i, list);
        }
    }

    /* renamed from: a */
    public void mo31970a(ProcessAidlCallback gVar) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar != null) {
            nVar.mo32025a(IPCUtils.m28833a(gVar));
        }
    }

    /* renamed from: a */
    public void mo31961a(int i, int i2) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar != null) {
            nVar.mo32016a(i, i2);
        }
    }

    /* renamed from: q */
    public IDownloadNotificationEventAidlListener mo32005q(int i) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar == null) {
            return null;
        }
        return IPCUtils.m28827a(nVar.mo32064q(i));
    }

    /* renamed from: r */
    public INotificationClickAidlCallback mo32006r(int i) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar == null) {
            return null;
        }
        return IPCUtils.m28829a(nVar.mo32065r(i));
    }

    /* renamed from: a */
    public void mo31967a(int i, IDownloadNotificationEventAidlListener afVar) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar != null) {
            nVar.mo32022a(i, IPCUtils.m28828a(afVar));
        }
    }

    /* renamed from: s */
    public IDownloadAidlFileProvider mo32007s(int i) throws RemoteException {
        IDownloadProxy nVar = this.f22217b;
        if (nVar == null) {
            return null;
        }
        return IPCUtils.m28836a(nVar.mo32066s(i));
    }
}
