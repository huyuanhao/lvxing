package com.p530ss.android.socialbase.downloader.p562g;

import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import com.p530ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.p530ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator;
import com.p530ss.android.socialbase.downloader.downloader.IChunkCntCalculator;
import com.p530ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator;
import com.p530ss.android.socialbase.downloader.p557b.EnqueueType;
import com.p530ss.android.socialbase.downloader.p557b.ListenerType;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadDepend;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadDiskSpaceHandler;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadFileUriProvider;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadForbiddenHandler;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadInterceptor;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadListener;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadMonitorDepend;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadNotificationEventListener;
import com.p530ss.android.socialbase.downloader.p559d.INotificationClickCallback;
import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.p530ss.android.socialbase.downloader.p561f.C6704a;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo.C6711a;
import com.p530ss.android.socialbase.downloader.p563h.DownloadMonitorHelper;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: DownloadTask */
/* renamed from: com.ss.android.socialbase.downloader.g.d */
public class C6712d {
    /* renamed from: a */
    private DownloadInfo f22092a;
    /* renamed from: b */
    private IChunkAdjustCalculator f22093b;
    /* renamed from: c */
    private IChunkCntCalculator f22094c;
    /* renamed from: d */
    private final Map<ListenerType, IDownloadListener> f22095d;
    /* renamed from: e */
    private final SparseArray<ListenerType> f22096e;
    /* renamed from: f */
    private final SparseArray<IDownloadListener> f22097f;
    /* renamed from: g */
    private final SparseArray<IDownloadListener> f22098g;
    /* renamed from: h */
    private final SparseArray<IDownloadListener> f22099h;
    /* renamed from: i */
    private IDownloadNotificationEventListener f22100i;
    /* renamed from: j */
    private IDownloadInterceptor f22101j;
    /* renamed from: k */
    private IDownloadDepend f22102k;
    /* renamed from: l */
    private IDownloadMonitorDepend f22103l;
    /* renamed from: m */
    private C6711a f22104m;
    /* renamed from: n */
    private IDownloadForbiddenHandler f22105n;
    /* renamed from: o */
    private IDownloadDiskSpaceHandler f22106o;
    /* renamed from: p */
    private IRetryDelayTimeCalculator f22107p;
    /* renamed from: q */
    private INotificationClickCallback f22108q;
    /* renamed from: r */
    private boolean f22109r;
    /* renamed from: s */
    private IDownloadFileUriProvider f22110s;

    /* renamed from: a */
    public DownloadInfo mo32357a() {
        return this.f22092a;
    }

    public C6712d() {
        this.f22095d = new ConcurrentHashMap();
        this.f22096e = new SparseArray<>();
        this.f22109r = false;
        this.f22104m = new C6711a();
        this.f22097f = new SparseArray<>();
        this.f22098g = new SparseArray<>();
        this.f22099h = new SparseArray<>();
    }

    public C6712d(DownloadInfo cVar) {
        this();
        this.f22092a = cVar;
    }

    /* renamed from: b */
    public boolean mo32390b() {
        return this.f22109r;
    }

    /* renamed from: a */
    public void mo32379a(boolean z) {
        this.f22109r = z;
    }

    /* renamed from: c */
    public IDownloadInterceptor mo32391c() {
        return this.f22101j;
    }

    /* renamed from: d */
    public IDownloadDepend mo32397d() {
        return this.f22102k;
    }

    /* renamed from: e */
    public IDownloadMonitorDepend mo32401e() {
        return this.f22103l;
    }

    /* renamed from: f */
    public IChunkCntCalculator mo32404f() {
        return this.f22094c;
    }

    /* renamed from: g */
    public IRetryDelayTimeCalculator mo32407g() {
        return this.f22107p;
    }

    /* renamed from: h */
    public IDownloadForbiddenHandler mo32410h() {
        return this.f22105n;
    }

    /* renamed from: i */
    public IDownloadDiskSpaceHandler mo32413i() {
        return this.f22106o;
    }

    /* renamed from: j */
    public IDownloadNotificationEventListener mo32416j() {
        return this.f22100i;
    }

    /* renamed from: k */
    public INotificationClickCallback mo32418k() {
        return this.f22108q;
    }

    /* renamed from: l */
    public IDownloadFileUriProvider mo32420l() {
        return this.f22110s;
    }

    /* renamed from: m */
    public boolean mo32423m() {
        DownloadInfo cVar = this.f22092a;
        if (cVar != null) {
            return cVar.mo32229af();
        }
        return false;
    }

    /* renamed from: a */
    public C6712d mo32371a(IChunkCntCalculator iVar) {
        this.f22094c = iVar;
        return this;
    }

    /* renamed from: a */
    public C6712d mo32370a(IChunkAdjustCalculator hVar) {
        this.f22093b = hVar;
        return this;
    }

    /* renamed from: a */
    public C6712d mo32372a(IRetryDelayTimeCalculator rVar) {
        this.f22107p = rVar;
        return this;
    }

    /* renamed from: a */
    public C6712d mo32363a(IDownloadListener adVar) {
        return adVar == null ? this : mo32359a(adVar.hashCode(), adVar);
    }

    /* renamed from: a */
    public C6712d mo32359a(int i, IDownloadListener adVar) {
        if (adVar != null) {
            synchronized (this.f22097f) {
                this.f22097f.put(i, adVar);
            }
            this.f22095d.put(ListenerType.MAIN, adVar);
            synchronized (this.f22096e) {
                this.f22096e.put(i, ListenerType.MAIN);
            }
        }
        return this;
    }

    /* renamed from: b */
    public C6712d mo32382b(int i, IDownloadListener adVar) {
        if (adVar != null) {
            synchronized (this.f22098g) {
                this.f22098g.put(i, adVar);
            }
            this.f22095d.put(ListenerType.SUB, adVar);
            synchronized (this.f22096e) {
                this.f22096e.put(i, ListenerType.SUB);
            }
        }
        return this;
    }

    /* renamed from: b */
    public C6712d mo32383b(IDownloadListener adVar) {
        return adVar == null ? this : mo32394c(adVar.hashCode(), adVar);
    }

    /* renamed from: c */
    public C6712d mo32394c(int i, IDownloadListener adVar) {
        if (adVar != null) {
            synchronized (this.f22099h) {
                this.f22099h.put(i, adVar);
            }
            this.f22095d.put(ListenerType.NOTIFICATION, adVar);
            synchronized (this.f22096e) {
                this.f22096e.put(i, ListenerType.NOTIFICATION);
            }
        }
        return this;
    }

    /* renamed from: a */
    public C6712d mo32365a(IDownloadNotificationEventListener agVar) {
        this.f22100i = agVar;
        return this;
    }

    /* renamed from: a */
    public C6712d mo32362a(IDownloadInterceptor acVar) {
        this.f22101j = acVar;
        return this;
    }

    /* renamed from: a */
    public C6712d mo32367a(IDownloadDepend sVar) {
        this.f22102k = sVar;
        return this;
    }

    /* renamed from: a */
    public C6712d mo32364a(IDownloadMonitorDepend aeVar) {
        this.f22103l = aeVar;
        return this;
    }

    /* renamed from: a */
    public C6712d mo32366a(INotificationClickCallback dVar) {
        this.f22108q = dVar;
        return this;
    }

    /* renamed from: a */
    public C6712d mo32361a(IDownloadForbiddenHandler abVar) {
        this.f22105n = abVar;
        return this;
    }

    /* renamed from: a */
    public C6712d mo32368a(IDownloadDiskSpaceHandler wVar) {
        this.f22106o = wVar;
        return this;
    }

    /* renamed from: a */
    public C6712d mo32373a(String str) {
        this.f22104m.mo32326a(str);
        return this;
    }

    /* renamed from: b */
    public C6712d mo32384b(String str) {
        this.f22104m.mo32332b(str);
        return this;
    }

    /* renamed from: c */
    public C6712d mo32395c(String str) {
        this.f22104m.mo32336c(str);
        return this;
    }

    /* renamed from: d */
    public C6712d mo32399d(String str) {
        this.f22104m.mo32339d(str);
        return this;
    }

    /* renamed from: e */
    public C6712d mo32402e(String str) {
        this.f22104m.mo32341e(str);
        return this;
    }

    /* renamed from: b */
    public C6712d mo32386b(boolean z) {
        this.f22104m.mo32329a(z);
        return this;
    }

    /* renamed from: a */
    public C6712d mo32374a(List<HttpHeader> list) {
        this.f22104m.mo32327a(list);
        return this;
    }

    /* renamed from: a */
    public C6712d mo32358a(int i) {
        this.f22104m.mo32324a(i);
        return this;
    }

    /* renamed from: b */
    public C6712d mo32381b(int i) {
        this.f22104m.mo32331b(i);
        return this;
    }

    /* renamed from: c */
    public C6712d mo32396c(boolean z) {
        this.f22104m.mo32334b(z);
        return this;
    }

    /* renamed from: c */
    public C6712d mo32393c(int i) {
        this.f22104m.mo32335c(i);
        return this;
    }

    /* renamed from: d */
    public C6712d mo32398d(int i) {
        this.f22104m.mo32338d(i);
        return this;
    }

    /* renamed from: b */
    public C6712d mo32385b(List<String> list) {
        this.f22104m.mo32333b(list);
        return this;
    }

    /* renamed from: f */
    public C6712d mo32405f(String str) {
        this.f22104m.mo32343f(str);
        return this;
    }

    /* renamed from: d */
    public C6712d mo32400d(boolean z) {
        this.f22104m.mo32340d(z);
        return this;
    }

    /* renamed from: e */
    public C6712d mo32403e(boolean z) {
        this.f22104m.mo32337c(z);
        return this;
    }

    /* renamed from: f */
    public C6712d mo32406f(boolean z) {
        this.f22104m.mo32342e(z);
        return this;
    }

    /* renamed from: g */
    public C6712d mo32409g(boolean z) {
        this.f22104m.mo32344f(z);
        return this;
    }

    /* renamed from: g */
    public C6712d mo32408g(String str) {
        this.f22104m.mo32345g(str);
        return this;
    }

    /* renamed from: h */
    public C6712d mo32411h(String str) {
        this.f22104m.mo32347h(str);
        return this;
    }

    /* renamed from: h */
    public C6712d mo32412h(boolean z) {
        this.f22104m.mo32350i(z);
        return this;
    }

    /* renamed from: i */
    public C6712d mo32414i(String str) {
        this.f22104m.mo32349i(str);
        return this;
    }

    /* renamed from: i */
    public C6712d mo32415i(boolean z) {
        this.f22104m.mo32346g(z);
        return this;
    }

    /* renamed from: j */
    public C6712d mo32417j(boolean z) {
        this.f22104m.mo32351j(z);
        return this;
    }

    /* renamed from: k */
    public C6712d mo32419k(boolean z) {
        this.f22104m.mo32354m(z);
        return this;
    }

    /* renamed from: l */
    public C6712d mo32421l(boolean z) {
        this.f22104m.mo32348h(z);
        return this;
    }

    /* renamed from: m */
    public C6712d mo32422m(boolean z) {
        this.f22104m.mo32352k(z);
        return this;
    }

    /* renamed from: a */
    public C6712d mo32360a(EnqueueType gVar) {
        this.f22104m.mo32325a(gVar);
        return this;
    }

    /* renamed from: n */
    public C6712d mo32425n(boolean z) {
        this.f22104m.mo32353l(z);
        return this;
    }

    /* renamed from: a */
    public C6712d mo32369a(IDownloadFileUriProvider xVar) {
        this.f22110s = xVar;
        return this;
    }

    /* renamed from: a */
    public C6712d mo32375a(JSONObject jSONObject) {
        this.f22104m.mo32328a(jSONObject);
        return this;
    }

    /* renamed from: n */
    public int mo32424n() {
        this.f22092a = this.f22104m.mo32330a();
        DownloadProcessDispatcher.m27395a().mo31860a(this);
        DownloadInfo cVar = this.f22092a;
        if (cVar == null) {
            return 0;
        }
        return cVar.mo32283g();
    }

    /* renamed from: o */
    public int mo32426o() {
        DownloadInfo cVar = this.f22092a;
        if (cVar == null) {
            return 0;
        }
        return cVar.mo32283g();
    }

    /* renamed from: p */
    public void mo32427p() {
        C6704a.m27758b("DownloadTask", "same task just tryDownloading, so add listener in last task instead of tryDownload");
        m28092d(ListenerType.MAIN);
        m28092d(ListenerType.SUB);
        DownloadMonitorHelper.m28177a(this.f22103l, this.f22092a, new BaseException((int) PointerIconCompat.TYPE_HELP, "has another same task, add Listener to old task"), 0);
    }

    /* renamed from: d */
    private void m28092d(ListenerType hVar) {
        SparseArray a = mo32355a(hVar);
        synchronized (a) {
            for (int i = 0; i < a.size(); i++) {
                IDownloadListener adVar = (IDownloadListener) a.get(a.keyAt(i));
                if (adVar != null) {
                    DownloadProcessDispatcher.m27395a().mo31867b(mo32426o(), adVar, hVar, false);
                }
            }
        }
    }

    /* renamed from: a */
    public SparseArray<IDownloadListener> mo32355a(ListenerType hVar) {
        if (hVar == ListenerType.MAIN) {
            return this.f22097f;
        }
        if (hVar == ListenerType.SUB) {
            return this.f22098g;
        }
        if (hVar == ListenerType.NOTIFICATION) {
            return this.f22099h;
        }
        return null;
    }

    /* renamed from: b */
    public int mo32380b(ListenerType hVar) {
        int size;
        SparseArray a = mo32355a(hVar);
        if (a == null) {
            return 0;
        }
        synchronized (a) {
            size = a.size();
        }
        return size;
    }

    /* renamed from: a */
    public IDownloadListener mo32356a(ListenerType hVar, int i) {
        SparseArray a = mo32355a(hVar);
        if (a == null || i < 0) {
            return null;
        }
        synchronized (a) {
            if (i >= a.size()) {
                return null;
            }
            IDownloadListener adVar = (IDownloadListener) a.get(a.keyAt(i));
            return adVar;
        }
    }

    /* renamed from: c */
    public IDownloadListener mo32392c(ListenerType hVar) {
        return (IDownloadListener) this.f22095d.get(hVar);
    }

    /* renamed from: a */
    public void mo32376a(int i, IDownloadListener adVar, ListenerType hVar, boolean z) {
        SparseArray a = mo32355a(hVar);
        if (a == null) {
            if (z && this.f22095d.containsKey(hVar)) {
                this.f22095d.remove(hVar);
            }
            return;
        }
        synchronized (a) {
            if (z) {
                if (this.f22095d.containsKey(hVar)) {
                    adVar = (IDownloadListener) this.f22095d.get(hVar);
                    this.f22095d.remove(hVar);
                }
                if (adVar != null) {
                    int indexOfValue = a.indexOfValue(adVar);
                    if (indexOfValue >= 0 && indexOfValue < a.size()) {
                        a.removeAt(indexOfValue);
                    }
                }
            } else {
                a.remove(i);
                synchronized (this.f22096e) {
                    ListenerType hVar2 = (ListenerType) this.f22096e.get(i);
                    if (hVar2 != null && this.f22095d.containsKey(hVar2)) {
                        this.f22095d.remove(hVar2);
                        this.f22096e.remove(i);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public void mo32387b(int i, IDownloadListener adVar, ListenerType hVar, boolean z) {
        if (adVar != null) {
            if (z) {
                Map<ListenerType, IDownloadListener> map = this.f22095d;
                if (map != null) {
                    map.put(hVar, adVar);
                    synchronized (this.f22096e) {
                        this.f22096e.put(i, hVar);
                    }
                }
            }
            SparseArray a = mo32355a(hVar);
            if (a != null) {
                synchronized (a) {
                    a.put(i, adVar);
                }
            }
        }
    }

    /* renamed from: a */
    private void m28089a(SparseArray<IDownloadListener> sparseArray, SparseArray<IDownloadListener> sparseArray2) {
        sparseArray.clear();
        for (int i = 0; i < sparseArray2.size(); i++) {
            int keyAt = sparseArray2.keyAt(i);
            IDownloadListener adVar = (IDownloadListener) sparseArray2.get(keyAt);
            if (adVar != null) {
                sparseArray.put(keyAt, adVar);
            }
        }
    }

    /* renamed from: a */
    public void mo32377a(SparseArray<IDownloadListener> sparseArray, ListenerType hVar) {
        if (sparseArray != null) {
            try {
                if (hVar == ListenerType.MAIN) {
                    synchronized (this.f22097f) {
                        m28089a(this.f22097f, sparseArray);
                    }
                } else if (hVar == ListenerType.SUB) {
                    synchronized (this.f22098g) {
                        m28089a(this.f22098g, sparseArray);
                    }
                } else {
                    if (hVar == ListenerType.NOTIFICATION) {
                        synchronized (this.f22099h) {
                            m28089a(this.f22099h, sparseArray);
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public void mo32388b(IDownloadNotificationEventListener agVar) {
        this.f22100i = agVar;
    }

    /* renamed from: q */
    public IChunkAdjustCalculator mo32428q() {
        return this.f22093b;
    }

    /* renamed from: a */
    public void mo32378a(C6712d dVar) {
        this.f22093b = dVar.f22093b;
        this.f22094c = dVar.f22094c;
        this.f22095d.clear();
        this.f22095d.putAll(dVar.f22095d);
        this.f22097f.clear();
        m28090b((SparseArray) dVar.f22097f, (SparseArray) this.f22097f);
        this.f22098g.clear();
        m28090b((SparseArray) dVar.f22098g, (SparseArray) this.f22098g);
        this.f22099h.clear();
        m28090b((SparseArray) dVar.f22099h, (SparseArray) this.f22099h);
        this.f22100i = dVar.f22100i;
        this.f22101j = dVar.f22101j;
        this.f22102k = dVar.f22102k;
        this.f22103l = dVar.f22103l;
        this.f22105n = dVar.f22105n;
        this.f22106o = dVar.f22106o;
        this.f22107p = dVar.f22107p;
        this.f22108q = dVar.f22108q;
        this.f22110s = dVar.f22110s;
    }

    /* renamed from: b */
    public void mo32389b(C6712d dVar) {
        for (Entry entry : dVar.f22095d.entrySet()) {
            if (entry != null) {
                if (!this.f22095d.containsKey(entry.getKey())) {
                    this.f22095d.put(entry.getKey(), entry.getValue());
                }
            }
        }
        try {
            if (dVar.f22097f.size() != 0) {
                synchronized (this.f22097f) {
                    m28091c((SparseArray) this.f22097f, (SparseArray) dVar.f22097f);
                    m28090b((SparseArray) dVar.f22097f, (SparseArray) this.f22097f);
                }
            }
            if (dVar.f22098g.size() != 0) {
                synchronized (this.f22098g) {
                    m28091c((SparseArray) this.f22098g, (SparseArray) dVar.f22098g);
                    m28090b((SparseArray) dVar.f22098g, (SparseArray) this.f22098g);
                }
            }
            if (dVar.f22099h.size() != 0) {
                synchronized (this.f22099h) {
                    m28091c((SparseArray) this.f22099h, (SparseArray) dVar.f22099h);
                    m28090b((SparseArray) dVar.f22099h, (SparseArray) this.f22099h);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m28090b(SparseArray sparseArray, SparseArray sparseArray2) {
        if (sparseArray != null && sparseArray2 != null) {
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                int keyAt = sparseArray.keyAt(i);
                sparseArray2.put(keyAt, sparseArray.get(keyAt));
            }
        }
    }

    /* renamed from: c */
    private void m28091c(SparseArray sparseArray, SparseArray sparseArray2) {
        if (sparseArray != null && sparseArray2 != null) {
            int size = sparseArray2.size();
            for (int i = 0; i < size; i++) {
                sparseArray.remove(sparseArray2.keyAt(i));
            }
        }
    }
}
