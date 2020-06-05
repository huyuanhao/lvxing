package com.kwai.filedownloader;

import com.kwai.filedownloader.C4583a.C4585b;
import com.kwai.filedownloader.message.C4701f;
import com.kwai.filedownloader.message.MessageSnapshot;
import com.kwai.filedownloader.p358f.C4660d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.kwai.filedownloader.h */
public class C4666h {
    /* renamed from: a */
    private final ArrayList<C4585b> f15194a;

    /* renamed from: com.kwai.filedownloader.h$a */
    private static final class C4668a {
        /* access modifiers changed from: private|static|final */
        /* renamed from: a */
        public static final C4666h f15195a = new C4666h();
    }

    private C4666h() {
        this.f15194a = new ArrayList<>();
    }

    /* renamed from: a */
    public static C4666h m19171a() {
        return C4668a.f15195a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo25225a(int i) {
        int i2;
        synchronized (this.f15194a) {
            Iterator it = this.f15194a.iterator();
            i2 = 0;
            while (it.hasNext()) {
                if (((C4585b) it.next()).mo24945b(i)) {
                    i2++;
                }
            }
        }
        return i2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo25226a(List<C4585b> list) {
        synchronized (this.f15194a) {
            Iterator it = this.f15194a.iterator();
            while (it.hasNext()) {
                C4585b bVar = (C4585b) it.next();
                if (!list.contains(bVar)) {
                    list.add(bVar);
                }
            }
            this.f15194a.clear();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo25227a(C4585b bVar) {
        return this.f15194a.isEmpty() || !this.f15194a.contains(bVar);
    }

    /* renamed from: a */
    public boolean mo25228a(C4585b bVar, MessageSnapshot messageSnapshot) {
        boolean remove;
        byte b = messageSnapshot.mo25286b();
        synchronized (this.f15194a) {
            remove = this.f15194a.remove(bVar);
        }
        if (C4660d.f15179a && this.f15194a.size() == 0) {
            C4660d.m19125e(this, "remove %s left %d %d", bVar, Byte.valueOf(b), Integer.valueOf(this.f15194a.size()));
        }
        if (remove) {
            C4728s d = bVar.mo24936G().mo25035d();
            if (b == -4) {
                d.mo25252g(messageSnapshot);
            } else if (b == -3) {
                d.mo25250e(C4701f.m19290a(messageSnapshot));
            } else if (b == -2) {
                d.mo25254i(messageSnapshot);
            } else if (b == -1) {
                d.mo25253h(messageSnapshot);
            }
        } else {
            C4660d.m19120a(this, "remove error, not exist: %s %d", bVar, Byte.valueOf(b));
        }
        return remove;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo25229b() {
        return this.f15194a.size();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public List<C4585b> mo25230b(int i) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f15194a) {
            Iterator it = this.f15194a.iterator();
            while (it.hasNext()) {
                C4585b bVar = (C4585b) it.next();
                if (bVar.mo24945b(i) && !bVar.mo24937H()) {
                    byte v = bVar.mo24935F().mo24929v();
                    if (!(v == 0 || v == 10)) {
                        arrayList.add(bVar);
                    }
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo25231b(C4585b bVar) {
        if (!bVar.mo24935F().mo24911d()) {
            bVar.mo24939J();
        }
        if (bVar.mo24936G().mo25035d().mo25242a()) {
            mo25233c(bVar);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public List<C4585b> mo25232c(int i) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f15194a) {
            Iterator it = this.f15194a.iterator();
            while (it.hasNext()) {
                C4585b bVar = (C4585b) it.next();
                if (bVar.mo24945b(i) && !bVar.mo24937H()) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo25233c(C4585b bVar) {
        if (!bVar.mo24940K()) {
            synchronized (this.f15194a) {
                if (this.f15194a.contains(bVar)) {
                    C4660d.m19124d(this, "already has %s", bVar);
                } else {
                    bVar.mo24941L();
                    this.f15194a.add(bVar);
                    if (C4660d.f15179a) {
                        C4660d.m19125e(this, "add list in all %s %d %d", bVar, Byte.valueOf(bVar.mo24935F().mo24929v()), Integer.valueOf(this.f15194a.size()));
                    }
                }
            }
        }
    }
}
