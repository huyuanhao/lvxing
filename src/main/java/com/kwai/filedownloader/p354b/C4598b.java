package com.kwai.filedownloader.p354b;

import android.util.SparseArray;
import com.kwai.filedownloader.p354b.C4596a.C4597a;
import com.kwai.filedownloader.p356d.C4618a;
import com.kwai.filedownloader.p356d.C4621c;
import com.kwai.filedownloader.p358f.C4660d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.kwai.filedownloader.b.b */
public class C4598b implements C4596a {
    /* renamed from: a */
    final SparseArray<C4621c> f14968a = new SparseArray<>();
    /* renamed from: b */
    final SparseArray<List<C4618a>> f14969b = new SparseArray<>();

    /* renamed from: com.kwai.filedownloader.b.b$a */
    class C4599a implements C4597a {
        C4599a() {
        }

        /* renamed from: a */
        public void mo24979a() {
        }

        /* renamed from: a */
        public void mo24980a(int i, C4621c cVar) {
        }

        /* renamed from: a */
        public void mo24981a(C4621c cVar) {
        }

        /* renamed from: b */
        public void mo24982b(C4621c cVar) {
        }

        public Iterator<C4621c> iterator() {
            return new C4600b();
        }
    }

    /* renamed from: com.kwai.filedownloader.b.b$b */
    class C4600b implements Iterator<C4621c> {
        C4600b() {
        }

        /* renamed from: a */
        public C4621c next() {
            return null;
        }

        public boolean hasNext() {
            return false;
        }

        public void remove() {
        }
    }

    /* renamed from: a */
    public void mo24960a() {
        synchronized (this.f14968a) {
            this.f14968a.clear();
        }
    }

    /* renamed from: a */
    public void mo24961a(int i) {
    }

    /* renamed from: a */
    public void mo24962a(int i, int i2) {
    }

    /* renamed from: a */
    public void mo24963a(int i, int i2, long j) {
        List list;
        synchronized (this.f14969b) {
            list = (List) this.f14969b.get(i);
        }
        if (list != null) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C4618a aVar = (C4618a) it.next();
                if (aVar.mo25052b() == i2) {
                    aVar.mo25054b(j);
                    break;
                }
            }
        }
    }

    /* renamed from: a */
    public void mo24964a(int i, long j) {
    }

    /* renamed from: a */
    public void mo24965a(int i, long j, String str, String str2) {
    }

    /* renamed from: a */
    public void mo24966a(int i, String str, long j, long j2, int i2) {
    }

    /* renamed from: a */
    public void mo24967a(int i, Throwable th) {
    }

    /* renamed from: a */
    public void mo24968a(int i, Throwable th, long j) {
    }

    /* renamed from: a */
    public void mo24969a(C4618a aVar) {
        List list;
        try {
            int a = aVar.mo25049a();
            synchronized (this.f14969b) {
                list = (List) this.f14969b.get(a);
                if (list == null) {
                    list = new ArrayList();
                    this.f14969b.put(a, list);
                }
            }
            list.add(aVar);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public void mo24970a(C4621c cVar) {
        if (cVar == null) {
            C4660d.m19124d(this, "update but model == null!", new Object[0]);
            return;
        }
        if (mo24972b(cVar.mo25071a()) != null) {
            synchronized (this.f14968a) {
                this.f14968a.remove(cVar.mo25071a());
                this.f14968a.put(cVar.mo25071a(), cVar);
            }
        } else {
            mo24983b(cVar);
        }
    }

    /* renamed from: b */
    public C4597a mo24971b() {
        return new C4599a();
    }

    /* renamed from: b */
    public C4621c mo24972b(int i) {
        C4621c cVar;
        synchronized (this.f14968a) {
            cVar = (C4621c) this.f14968a.get(i);
        }
        return cVar;
    }

    /* renamed from: b */
    public void mo24973b(int i, long j) {
        mo24977e(i);
    }

    /* renamed from: b */
    public void mo24983b(C4621c cVar) {
        synchronized (this.f14968a) {
            this.f14968a.put(cVar.mo25071a(), cVar);
        }
    }

    /* renamed from: c */
    public List<C4618a> mo24974c(int i) {
        List list;
        try {
            ArrayList arrayList = new ArrayList();
            synchronized (this.f14969b) {
                list = (List) this.f14969b.get(i);
            }
            if (list != null) {
                arrayList.addAll(list);
            }
            return arrayList;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    /* renamed from: c */
    public void mo24975c(int i, long j) {
    }

    /* renamed from: d */
    public void mo24976d(int i) {
        try {
            synchronized (this.f14969b) {
                this.f14969b.remove(i);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: e */
    public boolean mo24977e(int i) {
        synchronized (this.f14968a) {
            this.f14968a.remove(i);
        }
        return true;
    }

    /* renamed from: f */
    public void mo24978f(int i) {
    }
}
