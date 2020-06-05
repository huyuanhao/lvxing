package com.kwai.filedownloader.event;

import com.kwai.filedownloader.p358f.C4652b;
import com.kwai.filedownloader.p358f.C4660d;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Executor;

/* renamed from: com.kwai.filedownloader.event.a */
public class C4644a {
    /* renamed from: a */
    private final Executor f15167a = C4652b.m19102a(10, "EventPool");
    /* renamed from: b */
    private final HashMap<String, LinkedList<C4647c>> f15168b = new HashMap<>();

    /* renamed from: a */
    private void m19089a(LinkedList<C4647c> linkedList, C4646b bVar) {
        Object[] array = linkedList.toArray();
        int length = array.length;
        for (int i = 0; i < length; i++) {
            Object obj = array[i];
            if (obj != null && ((C4647c) obj).mo25191a(bVar)) {
                break;
            }
        }
        if (bVar.f15171a != null) {
            bVar.f15171a.run();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
            return false;
     */
    /* renamed from: a */
    public boolean mo25202a(com.kwai.filedownloader.event.C4646b r6) {
        /*
        r5 = this;
        boolean r0 = com.kwai.filedownloader.p358f.C4660d.f15179a
        r1 = 0
        r2 = 1
        if (r0 == 0) goto L_0x0013
        java.lang.Object[] r0 = new java.lang.Object[r2]
        java.lang.String r3 = r6.mo25206b()
        r0[r1] = r3
        java.lang.String r3 = "publish %s"
        com.kwai.filedownloader.p358f.C4660d.m19125e(r5, r3, r0)
    L_0x0013:
        if (r6 == 0) goto L_0x004a
        java.lang.String r0 = r6.mo25206b()
        java.util.HashMap<java.lang.String, java.util.LinkedList<com.kwai.filedownloader.event.c>> r3 = r5.f15168b
        java.lang.Object r3 = r3.get(r0)
        java.util.LinkedList r3 = (java.util.LinkedList) r3
        if (r3 != 0) goto L_0x0046
        java.lang.String r4 = r0.intern()
        monitor-enter(r4)
        java.util.HashMap<java.lang.String, java.util.LinkedList<com.kwai.filedownloader.event.c>> r3 = r5.f15168b     // Catch:{ all -> 0x0043 }
        java.lang.Object r3 = r3.get(r0)     // Catch:{ all -> 0x0043 }
        java.util.LinkedList r3 = (java.util.LinkedList) r3     // Catch:{ all -> 0x0043 }
        if (r3 != 0) goto L_0x0041
        boolean r6 = com.kwai.filedownloader.p358f.C4660d.f15179a     // Catch:{ all -> 0x0043 }
        if (r6 == 0) goto L_0x003f
        java.lang.String r6 = "No listener for this event %s"
        java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0043 }
        r2[r1] = r0     // Catch:{ all -> 0x0043 }
        com.kwai.filedownloader.p358f.C4660d.m19123c(r5, r6, r2)     // Catch:{ all -> 0x0043 }
    L_0x003f:
        monitor-exit(r4)     // Catch:{ all -> 0x0043 }
        return r1
    L_0x0041:
        monitor-exit(r4)     // Catch:{ all -> 0x0043 }
        goto L_0x0046
    L_0x0043:
        r6 = move-exception
        monitor-exit(r4)     // Catch:{ all -> 0x0043 }
        throw r6
    L_0x0046:
        r5.m19089a(r3, r6)
        return r2
    L_0x004a:
        java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
        java.lang.String r0 = "event must not be null!"
        r6.<init>(r0)
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.event.C4644a.mo25202a(com.kwai.filedownloader.event.b):boolean");
    }

    /* renamed from: a */
    public boolean mo25203a(String str, C4647c cVar) {
        boolean add;
        if (C4660d.f15179a) {
            C4660d.m19125e(this, "setListener %s", str);
        }
        if (cVar != null) {
            LinkedList linkedList = (LinkedList) this.f15168b.get(str);
            if (linkedList == null) {
                synchronized (str.intern()) {
                    linkedList = (LinkedList) this.f15168b.get(str);
                    if (linkedList == null) {
                        HashMap<String, LinkedList<C4647c>> hashMap = this.f15168b;
                        LinkedList linkedList2 = new LinkedList();
                        hashMap.put(str, linkedList2);
                        linkedList = linkedList2;
                    }
                }
            }
            synchronized (str.intern()) {
                add = linkedList.add(cVar);
            }
            return add;
        }
        throw new IllegalArgumentException("listener must not be null!");
    }

    /* renamed from: b */
    public void mo25204b(final C4646b bVar) {
        if (C4660d.f15179a) {
            C4660d.m19125e(this, "asyncPublishInNewThread %s", bVar.mo25206b());
        }
        if (bVar != null) {
            this.f15167a.execute(new Runnable() {
                public void run() {
                    try {
                        C4644a.this.mo25202a(bVar);
                    } catch (Exception unused) {
                    }
                }
            });
            return;
        }
        throw new IllegalArgumentException("event must not be null!");
    }
}
