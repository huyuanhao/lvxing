package com.p530ss.android.socialbase.downloader.impls;

import android.app.Notification;
import androidx.core.view.PointerIconCompat;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.p530ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.p530ss.android.socialbase.downloader.downloader.IDownloadProxy;
import com.p530ss.android.socialbase.downloader.downloader.IDownloadServiceHandler;
import com.p530ss.android.socialbase.downloader.p557b.ListenerType;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadFileUriProvider;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadListener;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadNotificationEventListener;
import com.p530ss.android.socialbase.downloader.p559d.INotificationClickCallback;
import com.p530ss.android.socialbase.downloader.p559d.ProcessCallback;
import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.p530ss.android.socialbase.downloader.p561f.C6704a;
import com.p530ss.android.socialbase.downloader.p562g.C6712d;
import com.p530ss.android.socialbase.downloader.p562g.DownloadChunk;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p563h.DownloadMonitorHelper;
import com.p530ss.android.socialbase.downloader.p567k.DownloadSetting;
import com.p530ss.android.socialbase.downloader.p569m.DownloadExpSwitchCode;
import com.p530ss.android.socialbase.downloader.p569m.DownloadUtils;
import java.util.List;

/* renamed from: com.ss.android.socialbase.downloader.impls.p */
public class ProcessDownloadHandler implements IDownloadProxy {
    /* renamed from: a */
    private final AbsDownloadEngine f22236a;
    /* renamed from: b */
    private final IDownloadCache f22237b;
    /* renamed from: c */
    private final IDownloadServiceHandler f22238c;
    /* renamed from: d */
    private final boolean f22239d;

    /* renamed from: d */
    public void mo32046d() {
    }

    public ProcessDownloadHandler() {
        this(false);
    }

    public ProcessDownloadHandler(boolean z) {
        this.f22236a = C6694b.m27388t();
        this.f22237b = C6694b.m27384p();
        if (!z) {
            this.f22238c = C6694b.m27385q();
        } else {
            this.f22238c = C6694b.m27386r();
        }
        this.f22239d = DownloadSetting.m28617b().mo32552b("judge_service_alive", false);
    }

    /* renamed from: a */
    public void mo32015a(int i) {
        AbsDownloadEngine aVar = this.f22236a;
        if (aVar != null) {
            aVar.mo32497e(i);
        }
    }

    /* renamed from: a */
    public void mo32024a(int i, boolean z) {
        AbsDownloadEngine aVar = this.f22236a;
        if (aVar != null) {
            aVar.mo32489a(i, z);
        }
    }

    /* renamed from: b */
    public boolean mo32039b(int i) {
        AbsDownloadEngine aVar = this.f22236a;
        if (aVar != null) {
            return aVar.mo32506n(i);
        }
        return false;
    }

    /* renamed from: c */
    public void mo32041c(int i) {
        AbsDownloadEngine aVar = this.f22236a;
        if (aVar != null) {
            aVar.mo32498f(i);
        }
    }

    /* renamed from: d */
    public void mo32047d(int i) {
        AbsDownloadEngine aVar = this.f22236a;
        if (aVar != null) {
            aVar.mo32499g(i);
        }
    }

    /* renamed from: a */
    public void mo32014a() {
        AbsDownloadEngine aVar = this.f22236a;
        if (aVar != null) {
            aVar.mo32491b();
        }
    }

    /* renamed from: b */
    public List<DownloadInfo> mo32032b(String str) {
        IDownloadCache kVar = this.f22237b;
        if (kVar != null) {
            return kVar.mo31679b(str);
        }
        return null;
    }

    /* renamed from: a */
    public void mo32028a(List<String> list) {
        AbsDownloadEngine aVar = this.f22236a;
        if (aVar != null) {
            aVar.mo32487a(list);
        }
    }

    /* renamed from: e */
    public long mo32048e(int i) {
        IDownloadCache kVar = this.f22237b;
        if (kVar == null) {
            return 0;
        }
        DownloadInfo b = kVar.mo31677b(i);
        if (b == null) {
            return 0;
        }
        int aV = b.mo32219aV();
        if (aV <= 1) {
            return b.mo32180Z();
        }
        List c = this.f22237b.mo31685c(i);
        if (c == null || c.size() != aV) {
            return 0;
        }
        return DownloadUtils.m28783b(c);
    }

    /* renamed from: f */
    public int mo32051f(int i) {
        AbsDownloadEngine aVar = this.f22236a;
        if (aVar == null) {
            return 0;
        }
        DownloadInfo d = aVar.mo32496d(i);
        if (d == null) {
            return 0;
        }
        return d.mo32308q();
    }

    /* renamed from: g */
    public boolean mo32054g(int i) {
        AbsDownloadEngine aVar = this.f22236a;
        if (aVar != null) {
            return aVar.mo32488a(i);
        }
        return false;
    }

    /* renamed from: h */
    public DownloadInfo mo32055h(int i) {
        AbsDownloadEngine aVar = this.f22236a;
        if (aVar != null) {
            return aVar.mo32496d(i);
        }
        return null;
    }

    /* renamed from: a */
    public List<DownloadInfo> mo32013a(String str) {
        AbsDownloadEngine aVar = this.f22236a;
        if (aVar != null) {
            return aVar.mo32480a(str);
        }
        return null;
    }

    /* renamed from: i */
    public List<DownloadChunk> mo32056i(int i) {
        return this.f22237b.mo31685c(i);
    }

    /* renamed from: b */
    public DownloadInfo mo32031b(String str, String str2) {
        return mo32055h(C6694b.m27348a(str, str2));
    }

    /* renamed from: a */
    public int mo32012a(String str, String str2) {
        return C6694b.m27348a(str, str2);
    }

    /* renamed from: c */
    public List<DownloadInfo> mo32040c(String str) {
        IDownloadCache kVar = this.f22237b;
        if (kVar != null) {
            return kVar.mo31686c(str);
        }
        return null;
    }

    /* renamed from: b */
    public void mo32035b(int i, boolean z) {
        AbsDownloadEngine aVar = this.f22236a;
        if (aVar != null) {
            aVar.mo32494b(i, z);
        }
    }

    /* renamed from: j */
    public void mo32057j(int i) {
        AbsDownloadEngine aVar = this.f22236a;
        if (aVar != null) {
            aVar.mo32505m(i);
        }
    }

    /* renamed from: a */
    public void mo32020a(int i, int i2, IDownloadListener adVar, ListenerType hVar, boolean z) {
        AbsDownloadEngine aVar = this.f22236a;
        if (aVar != null) {
            aVar.mo32493b(i, i2, adVar, hVar, z);
        }
    }

    /* renamed from: b */
    public void mo32033b(int i, int i2, IDownloadListener adVar, ListenerType hVar, boolean z) {
        AbsDownloadEngine aVar = this.f22236a;
        if (aVar != null) {
            aVar.mo32482a(i, i2, adVar, hVar, z);
        }
    }

    /* renamed from: a */
    public boolean mo32030a(DownloadInfo cVar) {
        if (cVar == null) {
            return false;
        }
        boolean a = DownloadUtils.m28772a(cVar.mo32308q(), cVar.mo32297k(), cVar.mo32287h());
        if (a && DownloadExpSwitchCode.m28744a(33554432)) {
            mo32035b(cVar.mo32283g(), true);
        }
        return a;
    }

    /* renamed from: a */
    public void mo32021a(int i, Notification notification) {
        IDownloadServiceHandler pVar = this.f22238c;
        if (pVar != null) {
            pVar.mo31838a(i, notification);
        }
    }

    /* renamed from: a */
    public void mo32029a(boolean z, boolean z2) {
        IDownloadServiceHandler pVar = this.f22238c;
        if (pVar != null) {
            pVar.mo31844a(z2);
        }
    }

    /* renamed from: b */
    public boolean mo32038b() {
        IDownloadServiceHandler pVar = this.f22238c;
        if (pVar != null) {
            return pVar.mo31847b();
        }
        return false;
    }

    /* renamed from: c */
    public boolean mo32043c() {
        return C6694b.m27343C();
    }

    /* renamed from: d */
    public List<DownloadInfo> mo32045d(String str) {
        IDownloadCache kVar = this.f22237b;
        if (kVar != null) {
            return kVar.mo31689d(str);
        }
        return null;
    }

    /* renamed from: e */
    public List<DownloadInfo> mo32049e(String str) {
        AbsDownloadEngine aVar = this.f22236a;
        if (aVar != null) {
            return aVar.mo32490b(str);
        }
        return null;
    }

    /* renamed from: a */
    public void mo32027a(C6712d dVar) {
        IDownloadServiceHandler pVar = this.f22238c;
        if (pVar != null) {
            pVar.mo31846b(dVar);
        } else if (dVar != null) {
            DownloadMonitorHelper.m28177a(dVar.mo32401e(), dVar.mo32357a(), new BaseException((int) PointerIconCompat.TYPE_HELP, "downloadServiceHandler is null"), dVar.mo32357a() != null ? dVar.mo32357a().mo32308q() : 0);
        }
    }

    /* renamed from: b */
    public void mo32037b(C6712d dVar) {
        IDownloadServiceHandler pVar = this.f22238c;
        if (pVar != null) {
            pVar.mo31849c(dVar);
        }
    }

    /* renamed from: l */
    public boolean mo32059l(int i) {
        AbsDownloadEngine aVar = this.f22236a;
        if (aVar != null) {
            return aVar.mo32503k(i);
        }
        return false;
    }

    /* renamed from: k */
    public void mo32058k(int i) {
        C6704a.m27752a(i);
    }

    /* renamed from: e */
    public boolean mo32050e() {
        return this.f22237b.mo31687c();
    }

    /* renamed from: b */
    public void mo32036b(DownloadInfo cVar) {
        this.f22237b.mo31683b(cVar);
    }

    /* renamed from: a */
    public void mo32023a(int i, List<DownloadChunk> list) {
        this.f22237b.mo31672a(i, list);
    }

    /* renamed from: c */
    public void mo32042c(int i, boolean z) {
        DownloadProcessDispatcher.m27395a().mo31859a(i, z);
    }

    /* renamed from: m */
    public int mo32060m(int i) {
        return DownloadProcessDispatcher.m27395a().mo31855a(i);
    }

    /* renamed from: a */
    public void mo32026a(DownloadChunk bVar) {
        this.f22237b.mo31674a(bVar);
    }

    /* renamed from: c */
    public boolean mo32044c(DownloadInfo cVar) {
        return this.f22237b.mo31676a(cVar);
    }

    /* renamed from: n */
    public boolean mo32061n(int i) {
        return this.f22237b.mo31693e(i);
    }

    /* renamed from: o */
    public void mo32062o(int i) {
        this.f22237b.mo31690d(i);
    }

    /* renamed from: a */
    public void mo32019a(int i, int i2, long j) {
        this.f22237b.mo31671a(i, i2, j);
    }

    /* renamed from: a */
    public void mo32018a(int i, int i2, int i3, long j) {
        this.f22237b.mo31670a(i, i2, i3, j);
    }

    /* renamed from: a */
    public void mo32017a(int i, int i2, int i3, int i4) {
        this.f22237b.mo31669a(i, i2, i3, i4);
    }

    /* renamed from: p */
    public boolean mo32063p(int i) {
        return this.f22237b.mo31694f(i);
    }

    /* renamed from: f */
    public void mo32052f() {
        this.f22237b.mo31680b();
    }

    /* renamed from: b */
    public void mo32034b(int i, List<DownloadChunk> list) {
        this.f22237b.mo31681b(i, list);
    }

    /* renamed from: g */
    public boolean mo32053g() {
        if (!this.f22239d) {
            return false;
        }
        IDownloadServiceHandler pVar = this.f22238c;
        if (pVar == null || !pVar.mo31845a()) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public void mo32025a(ProcessCallback hVar) {
        C6694b.m27356a(hVar);
    }

    /* renamed from: a */
    public void mo32016a(int i, int i2) {
        if (C6694b.m27371d() != null) {
            for (ProcessCallback hVar : C6694b.m27371d()) {
                if (hVar != null) {
                    hVar.mo31763a(i2, i);
                }
            }
        }
    }

    /* renamed from: q */
    public IDownloadNotificationEventListener mo32064q(int i) {
        AbsDownloadEngine aVar = this.f22236a;
        if (aVar != null) {
            return aVar.mo32501i(i);
        }
        return null;
    }

    /* renamed from: r */
    public INotificationClickCallback mo32065r(int i) {
        AbsDownloadEngine aVar = this.f22236a;
        INotificationClickCallback h = aVar != null ? aVar.mo32500h(i) : null;
        return h == null ? C6694b.m27393y() : h;
    }

    /* renamed from: a */
    public void mo32022a(int i, IDownloadNotificationEventListener agVar) {
        AbsDownloadEngine aVar = this.f22236a;
        if (aVar != null) {
            aVar.mo32483a(i, agVar);
        }
    }

    /* renamed from: s */
    public IDownloadFileUriProvider mo32066s(int i) {
        AbsDownloadEngine aVar = this.f22236a;
        if (aVar != null) {
            return aVar.mo32502j(i);
        }
        return null;
    }
}
