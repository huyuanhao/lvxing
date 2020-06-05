package com.kwai.filedownloader;

import com.kwai.filedownloader.C4583a.C4585b;
import com.kwai.filedownloader.event.DownloadServiceConnectChangedEvent.ConnectStatus;
import com.kwai.filedownloader.p358f.C4660d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.kwai.filedownloader.y */
public class C4747y extends C4640e implements C4741u {
    /* renamed from: a */
    private final ArrayList<C4585b> f15290a = new ArrayList<>();

    /* renamed from: a */
    public void mo25190a() {
        C4742v d = C4723q.m19348a().mo25318d();
        if (C4660d.f15179a) {
            C4660d.m19123c(this, "The downloader service is connected.", new Object[0]);
        }
        synchronized (this.f15290a) {
            List<C4585b> list = (List) this.f15290a.clone();
            this.f15290a.clear();
            ArrayList arrayList = new ArrayList(d.mo24954b());
            for (C4585b bVar : list) {
                int I = bVar.mo24938I();
                if (d.mo24953a(I)) {
                    bVar.mo24935F().mo24899a().mo24946a();
                    if (!arrayList.contains(Integer.valueOf(I))) {
                        arrayList.add(Integer.valueOf(I));
                    }
                } else {
                    bVar.mo24943N();
                }
            }
            d.mo24952a((List<Integer>) arrayList);
        }
    }

    /* renamed from: a */
    public boolean mo25361a(C4585b bVar) {
        return !this.f15290a.isEmpty() && this.f15290a.contains(bVar);
    }

    /* renamed from: b */
    public void mo25192b() {
        if (mo25193c() == ConnectStatus.lost) {
            C4742v d = C4723q.m19348a().mo25318d();
            if (C4660d.f15179a) {
                C4660d.m19123c(this, "lost the connection to the file download service, and current active task size is %d", Integer.valueOf(C4666h.m19171a().mo25229b()));
            }
            if (C4666h.m19171a().mo25229b() > 0) {
                synchronized (this.f15290a) {
                    C4666h.m19171a().mo25226a((List<C4585b>) this.f15290a);
                    Iterator it = this.f15290a.iterator();
                    while (it.hasNext()) {
                        ((C4585b) it.next()).mo24942M();
                    }
                    d.mo24951a();
                }
                C4723q.m19348a().mo25316b();
            }
        } else if (C4666h.m19171a().mo25229b() > 0) {
            C4660d.m19124d(this, "file download service has be unbound but the size of active tasks are not empty %d ", Integer.valueOf(C4666h.m19171a().mo25229b()));
        }
    }

    /* renamed from: b */
    public void mo25362b(C4585b bVar) {
        if (!this.f15290a.isEmpty()) {
            synchronized (this.f15290a) {
                this.f15290a.remove(bVar);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004e, code lost:
            return true;
     */
    /* renamed from: c */
    public boolean mo25363c(com.kwai.filedownloader.C4583a.C4585b r7) {
        /*
        r6 = this;
        com.kwai.filedownloader.q r0 = com.kwai.filedownloader.C4723q.m19348a()
        boolean r0 = r0.mo25317c()
        r1 = 0
        if (r0 != 0) goto L_0x0054
        java.util.ArrayList<com.kwai.filedownloader.a$b> r0 = r6.f15290a
        monitor-enter(r0)
        com.kwai.filedownloader.q r2 = com.kwai.filedownloader.C4723q.m19348a()     // Catch:{ all -> 0x0051 }
        boolean r2 = r2.mo25317c()     // Catch:{ all -> 0x0051 }
        if (r2 != 0) goto L_0x004f
        boolean r2 = com.kwai.filedownloader.p358f.C4660d.f15179a     // Catch:{ all -> 0x0051 }
        r3 = 1
        if (r2 == 0) goto L_0x0032
        java.lang.String r2 = "Waiting for connecting with the downloader service... %d"
        java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x0051 }
        com.kwai.filedownloader.a r5 = r7.mo24935F()     // Catch:{ all -> 0x0051 }
        int r5 = r5.mo24915h()     // Catch:{ all -> 0x0051 }
        java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0051 }
        r4[r1] = r5     // Catch:{ all -> 0x0051 }
        com.kwai.filedownloader.p358f.C4660d.m19123c(r6, r2, r4)     // Catch:{ all -> 0x0051 }
    L_0x0032:
        com.kwai.filedownloader.m r1 = com.kwai.filedownloader.C4677m.m19228a()     // Catch:{ all -> 0x0051 }
        android.content.Context r2 = com.kwai.filedownloader.p358f.C4654c.m19105a()     // Catch:{ all -> 0x0051 }
        r1.mo25261a(r2)     // Catch:{ all -> 0x0051 }
        java.util.ArrayList<com.kwai.filedownloader.a$b> r1 = r6.f15290a     // Catch:{ all -> 0x0051 }
        boolean r1 = r1.contains(r7)     // Catch:{ all -> 0x0051 }
        if (r1 != 0) goto L_0x004d
        r7.mo24942M()     // Catch:{ all -> 0x0051 }
        java.util.ArrayList<com.kwai.filedownloader.a$b> r1 = r6.f15290a     // Catch:{ all -> 0x0051 }
        r1.add(r7)     // Catch:{ all -> 0x0051 }
    L_0x004d:
        monitor-exit(r0)     // Catch:{ all -> 0x0051 }
        return r3
    L_0x004f:
        monitor-exit(r0)     // Catch:{ all -> 0x0051 }
        goto L_0x0054
    L_0x0051:
        r7 = move-exception
        monitor-exit(r0)     // Catch:{ all -> 0x0051 }
        throw r7
    L_0x0054:
        r6.mo25362b(r7)
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.C4747y.mo25363c(com.kwai.filedownloader.a$b):boolean");
    }
}
