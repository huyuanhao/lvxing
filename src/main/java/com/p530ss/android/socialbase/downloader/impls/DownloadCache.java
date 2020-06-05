package com.p530ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import android.util.SparseArray;
import com.p530ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.p530ss.android.socialbase.downloader.p557b.DownloadStatus;
import com.p530ss.android.socialbase.downloader.p562g.DownloadChunk;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.ss.android.socialbase.downloader.impls.k */
public class DownloadCache implements IDownloadCache {
    /* renamed from: a */
    private final SparseArray<DownloadInfo> f22211a = new SparseArray<>();
    /* renamed from: b */
    private final SparseArray<List<DownloadChunk>> f22212b = new SparseArray<>();

    /* renamed from: a */
    public void mo31669a(int i, int i2, int i3, int i4) {
    }

    /* renamed from: b */
    public void mo31681b(int i, List<DownloadChunk> list) {
    }

    /* renamed from: b */
    public void mo31682b(DownloadChunk bVar) {
    }

    /* renamed from: c */
    public boolean mo31687c() {
        return false;
    }

    /* renamed from: d */
    public boolean mo31691d() {
        return false;
    }

    /* renamed from: a */
    public SparseArray<DownloadInfo> mo32517a() {
        return this.f22211a;
    }

    /* renamed from: e */
    public SparseArray<List<DownloadChunk>> mo32518e() {
        return this.f22212b;
    }

    /* renamed from: g */
    public DownloadInfo mo31695g(int i) {
        DownloadInfo b = mo31677b(i);
        if (b != null) {
            b.mo32251b(2);
        }
        return b;
    }

    /* renamed from: b */
    public DownloadInfo mo31677b(int i) {
        DownloadInfo cVar;
        synchronized (this.f22211a) {
            try {
                cVar = (DownloadInfo) this.f22211a.get(i);
            } catch (Exception e) {
                e.printStackTrace();
                cVar = null;
            }
        }
        return cVar;
    }

    /* renamed from: a */
    public List<DownloadInfo> mo31667a(String str) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f22211a) {
            try {
                int size = this.f22211a.size();
                for (int i = 0; i < size; i++) {
                    DownloadInfo cVar = (DownloadInfo) this.f22211a.valueAt(i);
                    if (str != null && str.equals(cVar.mo32295j())) {
                        arrayList.add(cVar);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public List<DownloadInfo> mo31679b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f22211a) {
            if (this.f22211a.size() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f22211a.size(); i++) {
                DownloadInfo cVar = (DownloadInfo) this.f22211a.get(this.f22211a.keyAt(i));
                if (cVar != null && !TextUtils.isEmpty(cVar.mo32231ah()) && cVar.mo32231ah().equals(str) && DownloadStatus.m26987g(cVar.mo32308q())) {
                    arrayList.add(cVar);
                }
            }
            return arrayList;
        }
    }

    /* renamed from: c */
    public List<DownloadInfo> mo31686c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f22211a) {
            if (this.f22211a.size() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f22211a.size(); i++) {
                DownloadInfo cVar = (DownloadInfo) this.f22211a.get(this.f22211a.keyAt(i));
                if (cVar != null && !TextUtils.isEmpty(cVar.mo32231ah()) && cVar.mo32231ah().equals(str) && cVar.mo32308q() == -3) {
                    arrayList.add(cVar);
                }
            }
            return arrayList;
        }
    }

    /* renamed from: d */
    public List<DownloadInfo> mo31689d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f22211a) {
            if (this.f22211a.size() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f22211a.size(); i++) {
                DownloadInfo cVar = (DownloadInfo) this.f22211a.get(this.f22211a.keyAt(i));
                if (cVar != null && !TextUtils.isEmpty(cVar.mo32231ah()) && cVar.mo32231ah().equals(str) && DownloadStatus.m26986f(cVar.mo32308q())) {
                    arrayList.add(cVar);
                }
            }
            return arrayList;
        }
    }

    /* renamed from: c */
    public List<DownloadChunk> mo31685c(int i) {
        return (List) this.f22212b.get(i);
    }

    /* renamed from: d */
    public synchronized void mo31690d(int i) {
        this.f22212b.remove(i);
    }

    /* renamed from: a */
    public synchronized void mo31674a(DownloadChunk bVar) {
        int k = bVar.mo32133k();
        List list = (List) this.f22212b.get(k);
        if (list == null) {
            list = new ArrayList();
            this.f22212b.put(k, list);
        }
        list.add(bVar);
    }

    /* renamed from: a */
    public void mo31671a(int i, int i2, long j) {
        List c = mo31685c(i);
        if (c != null) {
            Iterator it = c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DownloadChunk bVar = (DownloadChunk) it.next();
                if (bVar != null && bVar.mo32141s() == i2) {
                    bVar.mo32120b(j);
                    break;
                }
            }
        }
    }

    /* renamed from: a */
    public void mo31670a(int i, int i2, int i3, long j) {
        List c = mo31685c(i);
        if (c != null) {
            Iterator it = c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DownloadChunk bVar = (DownloadChunk) it.next();
                if (bVar != null && bVar.mo32141s() == i3 && !bVar.mo32128f()) {
                    if (bVar.mo32129g() != null) {
                        Iterator it2 = bVar.mo32129g().iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            DownloadChunk bVar2 = (DownloadChunk) it2.next();
                            if (bVar2 != null && bVar2.mo32141s() == i2) {
                                bVar2.mo32120b(j);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public DownloadInfo mo31664a(int i, int i2) {
        DownloadInfo b = mo31677b(i);
        if (b != null) {
            b.mo32263c(i2);
        }
        return b;
    }

    /* renamed from: a */
    public boolean mo31676a(DownloadInfo cVar) {
        boolean z = true;
        if (cVar == null) {
            return true;
        }
        synchronized (this.f22211a) {
            if (this.f22211a.get(cVar.mo32283g()) == null) {
                z = false;
            }
            this.f22211a.put(cVar.mo32283g(), cVar);
        }
        return z;
    }

    /* renamed from: e */
    public boolean mo31693e(int i) {
        synchronized (this.f22211a) {
            this.f22211a.remove(i);
        }
        return true;
    }

    /* renamed from: f */
    public boolean mo31694f(int i) {
        mo31693e(i);
        mo31690d(i);
        return true;
    }

    /* renamed from: b */
    public void mo31680b() {
        synchronized (this.f22211a) {
            this.f22211a.clear();
            this.f22212b.clear();
        }
    }

    /* renamed from: a */
    public DownloadInfo mo31666a(int i, long j, String str, String str2) {
        DownloadInfo b = mo31677b(i);
        if (b != null) {
            b.mo32264c(j);
            b.mo32253b(str);
            if (TextUtils.isEmpty(b.mo32287h()) && !TextUtils.isEmpty(str2)) {
                b.mo32265c(str2);
            }
            b.mo32251b(3);
        }
        return b;
    }

    /* renamed from: a */
    public DownloadInfo mo31665a(int i, long j) {
        DownloadInfo b = mo31677b(i);
        if (b != null) {
            b.mo32183a(j, false);
            if (!(b.mo32308q() == -3 || b.mo32308q() == -2 || DownloadStatus.m26987g(b.mo32308q()) || b.mo32308q() == -4)) {
                b.mo32251b(4);
            }
        }
        return b;
    }

    /* renamed from: b */
    public DownloadInfo mo31678b(int i, long j) {
        DownloadInfo b = mo31677b(i);
        if (b != null) {
            b.mo32183a(j, false);
            b.mo32251b(-1);
            b.mo32282f(false);
        }
        return b;
    }

    /* renamed from: h */
    public DownloadInfo mo31696h(int i) {
        DownloadInfo b = mo31677b(i);
        if (b != null) {
            b.mo32251b(5);
            b.mo32282f(false);
        }
        return b;
    }

    /* renamed from: c */
    public DownloadInfo mo31684c(int i, long j) {
        DownloadInfo b = mo31677b(i);
        if (b != null) {
            b.mo32183a(j, false);
            b.mo32251b(-3);
            b.mo32282f(false);
            b.mo32286g(false);
        }
        return b;
    }

    /* renamed from: d */
    public DownloadInfo mo31688d(int i, long j) {
        DownloadInfo b = mo31677b(i);
        if (b != null) {
            b.mo32183a(j, false);
            b.mo32251b(-2);
        }
        return b;
    }

    /* renamed from: i */
    public DownloadInfo mo31697i(int i) {
        DownloadInfo b = mo31677b(i);
        if (b != null) {
            b.mo32251b(1);
        }
        return b;
    }

    /* renamed from: j */
    public DownloadInfo mo31698j(int i) {
        DownloadInfo b = mo31677b(i);
        if (b != null) {
            b.mo32251b(-7);
        }
        return b;
    }

    /* renamed from: b */
    public void mo31683b(DownloadInfo cVar) {
        mo31676a(cVar);
    }

    /* renamed from: a */
    public void mo31672a(int i, List<DownloadChunk> list) {
        if (list != null) {
            mo31690d(i);
            for (DownloadChunk bVar : list) {
                if (bVar != null) {
                    mo31674a(bVar);
                    if (bVar.mo32128f()) {
                        for (DownloadChunk a : bVar.mo32129g()) {
                            mo31674a(a);
                        }
                    }
                }
            }
        }
    }
}
