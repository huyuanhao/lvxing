package com.p530ss.android.socialbase.downloader.downloader;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import com.p530ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.p530ss.android.socialbase.downloader.impls.DownloadProxy;
import com.p530ss.android.socialbase.downloader.p557b.ListenerType;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadFileUriProvider;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadListener;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadNotificationEventListener;
import com.p530ss.android.socialbase.downloader.p559d.IDownloaderProcessConnectedListener;
import com.p530ss.android.socialbase.downloader.p559d.INotificationClickCallback;
import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.p530ss.android.socialbase.downloader.p562g.C6712d;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p563h.DownloadMonitorHelper;
import com.p530ss.android.socialbase.downloader.p569m.DownloadExpSwitchCode;
import com.p530ss.android.socialbase.downloader.p569m.DownloadUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.ss.android.socialbase.downloader.downloader.c */
public class DownloadProcessDispatcher {
    /* renamed from: a */
    private static volatile DownloadProcessDispatcher f21868a;
    /* renamed from: b */
    private volatile SparseArray<Boolean> f21869b = new SparseArray<>();
    /* renamed from: c */
    private Handler f21870c = new Handler(Looper.getMainLooper());
    /* renamed from: d */
    private volatile List<IDownloaderProcessConnectedListener> f21871d = new ArrayList();

    /* renamed from: a */
    public static DownloadProcessDispatcher m27395a() {
        if (f21868a == null) {
            synchronized (DownloadProcessDispatcher.class) {
                f21868a = new DownloadProcessDispatcher();
            }
        }
        return f21868a;
    }

    /* renamed from: b */
    public void mo31866b() {
        synchronized (this.f21871d) {
            for (IDownloaderProcessConnectedListener bVar : this.f21871d) {
                if (bVar != null) {
                    bVar.mo31745a();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo31859a(int i, boolean z) {
        mo31868b(i, z);
        if (!DownloadUtils.m28801c() && DownloadProxy.m28368a(true).mo32053g()) {
            DownloadProxy.m28368a(true).mo32042c(i, z);
        }
        if (!C6694b.m27368b() && !DownloadUtils.m28801c() && !DownloadUtils.m28769a()) {
            try {
                Intent intent = new Intent(C6694b.m27342B(), DownloadHandleService.class);
                intent.setAction("com.ss.android.downloader.action.PROCESS_NOTIFY");
                intent.putExtra("extra_download_id", i);
                C6694b.m27342B().startService(intent);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public synchronized void mo31868b(int i, boolean z) {
        this.f21869b.put(i, z ? Boolean.TRUE : Boolean.FALSE);
    }

    /* renamed from: a */
    public int mo31855a(int i) {
        if (DownloadUtils.m28801c() || !DownloadProxy.m28368a(true).mo32053g()) {
            return mo31863b(i);
        }
        return DownloadProxy.m28368a(true).mo32060m(i);
    }

    /* renamed from: b */
    public synchronized int mo31863b(int i) {
        if (this.f21869b.get(i) == null) {
            return -1;
        }
        return ((Boolean) this.f21869b.get(i)).booleanValue();
    }

    /* renamed from: c */
    public IDownloadProxy mo31869c(int i) {
        boolean z = true;
        if (mo31855a(i) != 1 || DownloadUtils.m28801c()) {
            z = false;
        }
        return DownloadProxy.m28368a(z);
    }

    /* renamed from: b */
    private IDownloadProxy m27397b(C6712d dVar) {
        if (dVar == null) {
            return null;
        }
        DownloadInfo a = dVar.mo32357a();
        if (a == null) {
            return null;
        }
        boolean T = a.mo32174T();
        boolean z = true;
        if (DownloadUtils.m28801c() || !DownloadUtils.m28769a()) {
            T = true;
        }
        int a2 = mo31855a(a.mo32283g());
        if (a2 >= 0 && a2 != T) {
            if (a2 == 1) {
                try {
                    if (DownloadUtils.m28769a()) {
                        DownloadProxy.m28368a(true).mo32015a(a.mo32283g());
                        DownloadInfo h = DownloadProxy.m28368a(true).mo32055h(a.mo32283g());
                        if (h != null) {
                            DownloadProxy.m28368a(false).mo32036b(h);
                        }
                        if (h.mo32219aV() > 1) {
                            List i = DownloadProxy.m28368a(true).mo32056i(a.mo32283g());
                            if (i != null) {
                                DownloadProxy.m28368a(false).mo32023a(a.mo32283g(), DownloadUtils.m28758a(i));
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            } else if (DownloadUtils.m28769a()) {
                DownloadProxy.m28368a(false).mo32015a(a.mo32283g());
                List i2 = DownloadProxy.m28368a(false).mo32056i(a.mo32283g());
                if (i2 != null) {
                    DownloadProxy.m28368a(true).mo32023a(a.mo32283g(), DownloadUtils.m28758a(i2));
                }
            } else {
                dVar.mo32379a(true);
                DownloadProxy.m28368a(true).mo32016a(1, a.mo32283g());
            }
        }
        mo31859a(a.mo32283g(), T);
        if (!T) {
            z = false;
        }
        return DownloadProxy.m28368a(z);
    }

    /* renamed from: d */
    public void mo31874d(int i) {
        IDownloadProxy c = mo31869c(i);
        if (c != null) {
            c.mo32015a(i);
        }
    }

    /* renamed from: c */
    public void mo31872c(int i, boolean z) {
        if (!DownloadUtils.m28769a()) {
            IDownloadProxy c = mo31869c(i);
            if (c != null) {
                c.mo32024a(i, z);
            }
            DownloadProxy.m28368a(true).mo32016a(2, i);
        } else if (DownloadExpSwitchCode.m28744a(8388608)) {
            IDownloadProxy a = DownloadProxy.m28368a(true);
            if (a != null) {
                a.mo32024a(i, z);
            }
            IDownloadProxy a2 = DownloadProxy.m28368a(false);
            if (a2 != null) {
                a2.mo32024a(i, z);
            }
        } else {
            IDownloadProxy a3 = DownloadProxy.m28368a(false);
            if (a3 != null) {
                a3.mo32024a(i, z);
            }
            IDownloadProxy a4 = DownloadProxy.m28368a(true);
            if (a4 != null) {
                a4.mo32024a(i, z);
            }
        }
    }

    /* renamed from: e */
    public boolean mo31876e(int i) {
        IDownloadProxy c = mo31869c(i);
        if (c == null) {
            return false;
        }
        return c.mo32039b(i);
    }

    /* renamed from: f */
    public void mo31877f(int i) {
        IDownloadProxy c = mo31869c(i);
        if (c != null) {
            c.mo32041c(i);
        }
    }

    /* renamed from: g */
    public void mo31878g(int i) {
        IDownloadProxy c = mo31869c(i);
        if (c != null) {
            c.mo32047d(i);
        }
    }

    /* renamed from: c */
    public void mo31871c() {
        IDownloadProxy a = DownloadProxy.m28368a(false);
        if (a != null) {
            a.mo32014a();
        }
        IDownloadProxy a2 = DownloadProxy.m28368a(true);
        if (a2 != null) {
            a2.mo32014a();
        }
    }

    /* renamed from: h */
    public int mo31879h(int i) {
        IDownloadProxy c = mo31869c(i);
        if (c == null) {
            return 0;
        }
        return c.mo32051f(i);
    }

    /* renamed from: i */
    public boolean mo31880i(int i) {
        IDownloadProxy c = mo31869c(i);
        if (c == null) {
            return false;
        }
        return c.mo32054g(i);
    }

    /* renamed from: j */
    public DownloadInfo mo31881j(int i) {
        IDownloadProxy c = mo31869c(i);
        if (c == null) {
            return null;
        }
        return c.mo32055h(i);
    }

    /* renamed from: a */
    public int mo31856a(String str, String str2) {
        return C6694b.m27348a(str, str2);
    }

    /* renamed from: b */
    public DownloadInfo mo31864b(String str, String str2) {
        int a = mo31856a(str, str2);
        IDownloadProxy c = mo31869c(a);
        if (c == null) {
            return null;
        }
        return c.mo32055h(a);
    }

    /* renamed from: a */
    public List<DownloadInfo> mo31857a(String str) {
        List a = DownloadProxy.m28368a(false).mo32013a(str);
        List a2 = DownloadProxy.m28368a(true).mo32013a(str);
        if (a == null && a2 == null) {
            return null;
        }
        if (a == null || a2 == null) {
            if (a != null) {
                a2 = a;
            }
            return a2;
        }
        ArrayList arrayList = new ArrayList(a);
        arrayList.addAll(a2);
        return arrayList;
    }

    /* renamed from: k */
    public IDownloadNotificationEventListener mo31882k(int i) {
        IDownloadProxy c = mo31869c(i);
        if (c == null) {
            return null;
        }
        return c.mo32064q(i);
    }

    /* renamed from: l */
    public INotificationClickCallback mo31883l(int i) {
        IDownloadProxy c = mo31869c(i);
        if (c == null) {
            return null;
        }
        return c.mo32065r(i);
    }

    /* renamed from: a */
    private List<DownloadInfo> m27396a(List<DownloadInfo> list, List<DownloadInfo> list2, SparseArray<DownloadInfo> sparseArray) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (DownloadInfo cVar : list) {
                if (cVar != null && sparseArray.get(cVar.mo32283g()) == null) {
                    sparseArray.put(cVar.mo32283g(), cVar);
                }
            }
        }
        if (list2 != null) {
            for (DownloadInfo cVar2 : list2) {
                if (cVar2 != null && sparseArray.get(cVar2.mo32283g()) == null) {
                    sparseArray.put(cVar2.mo32283g(), cVar2);
                }
            }
        }
        for (int i = 0; i < sparseArray.size(); i++) {
            arrayList.add((DownloadInfo) sparseArray.get(sparseArray.keyAt(i)));
        }
        return arrayList;
    }

    /* renamed from: b */
    public List<DownloadInfo> mo31865b(String str) {
        SparseArray sparseArray = new SparseArray();
        IDownloadProxy a = DownloadProxy.m28368a(false);
        List list = null;
        List c = a != null ? a.mo32040c(str) : null;
        IDownloadProxy a2 = DownloadProxy.m28368a(true);
        if (a2 != null) {
            list = a2.mo32040c(str);
        }
        return m27396a(c, list, sparseArray);
    }

    /* renamed from: a */
    public void mo31861a(List<String> list) {
        IDownloadProxy a = DownloadProxy.m28368a(false);
        if (a != null) {
            a.mo32028a(list);
        }
        IDownloadProxy a2 = DownloadProxy.m28368a(true);
        if (a2 != null) {
            a2.mo32028a(list);
        }
    }

    /* renamed from: d */
    public void mo31875d(int i, boolean z) {
        IDownloadProxy c = mo31869c(i);
        if (c != null) {
            c.mo32035b(i, z);
        }
    }

    /* renamed from: a */
    public void mo31858a(int i, IDownloadListener adVar, ListenerType hVar, boolean z) {
        int i2;
        IDownloadProxy c = mo31869c(i);
        if (c != null) {
            if (adVar == null) {
                i2 = 0;
            } else {
                i2 = adVar.hashCode();
            }
            c.mo32033b(i, i2, adVar, hVar, z);
        }
    }

    /* renamed from: b */
    public void mo31867b(int i, IDownloadListener adVar, ListenerType hVar, boolean z) {
        IDownloadProxy c = mo31869c(i);
        if (c != null) {
            c.mo32020a(i, adVar.hashCode(), adVar, hVar, z);
        }
    }

    /* renamed from: a */
    public boolean mo31862a(DownloadInfo cVar) {
        if (cVar == null) {
            return false;
        }
        IDownloadProxy c = mo31869c(cVar.mo32283g());
        if (c == null) {
            return false;
        }
        return c.mo32030a(cVar);
    }

    /* renamed from: c */
    public List<DownloadInfo> mo31870c(String str) {
        SparseArray sparseArray = new SparseArray();
        IDownloadProxy a = DownloadProxy.m28368a(false);
        List list = null;
        List d = a != null ? a.mo32045d(str) : null;
        IDownloadProxy a2 = DownloadProxy.m28368a(true);
        if (a2 != null) {
            list = a2.mo32045d(str);
        }
        return m27396a(d, list, sparseArray);
    }

    /* renamed from: d */
    public List<DownloadInfo> mo31873d(String str) {
        SparseArray sparseArray = new SparseArray();
        IDownloadProxy a = DownloadProxy.m28368a(false);
        List list = null;
        List e = a != null ? a.mo32049e(str) : null;
        IDownloadProxy a2 = DownloadProxy.m28368a(true);
        if (a2 != null) {
            list = a2.mo32049e(str);
        }
        return m27396a(e, list, sparseArray);
    }

    /* renamed from: a */
    public void mo31860a(final C6712d dVar) {
        final IDownloadProxy b = m27397b(dVar);
        if (b == null) {
            if (dVar != null) {
                DownloadMonitorHelper.m28177a(dVar.mo32401e(), dVar.mo32357a(), new BaseException((int) PointerIconCompat.TYPE_HELP, "tryDownload but getDownloadHandler failed"), dVar.mo32357a() != null ? dVar.mo32357a().mo32308q() : 0);
            }
            return;
        }
        if (dVar.mo32390b()) {
            this.f21870c.postDelayed(new Runnable() {
                public void run() {
                    b.mo32027a(dVar);
                }
            }, 500);
        } else {
            b.mo32027a(dVar);
        }
    }

    /* renamed from: m */
    public boolean mo31884m(int i) {
        IDownloadProxy c = mo31869c(i);
        if (c == null) {
            return false;
        }
        return c.mo32059l(i);
    }

    /* renamed from: n */
    public void mo31885n(int i) {
        if (i != 0) {
            mo31868b(i, Boolean.TRUE.booleanValue());
            IDownloadProxy a = DownloadProxy.m28368a(true);
            if (a != null) {
                a.mo32046d();
            }
        }
    }

    /* renamed from: o */
    public IDownloadFileUriProvider mo31886o(int i) {
        IDownloadProxy c = mo31869c(i);
        if (c == null) {
            return null;
        }
        return c.mo32066s(i);
    }
}
