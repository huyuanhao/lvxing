package com.alibaba.baichuan.trade.common.p058a;

import android.os.Message;
import com.alibaba.baichuan.trade.common.p058a.C1197c.C1198a;
import com.alibaba.baichuan.trade.common.utils.C1227b;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.alibaba.baichuan.trade.common.a.a */
public class C1193a {
    /* renamed from: c */
    private static C1193a f2470c;
    /* access modifiers changed from: private */
    /* renamed from: a */
    public Map<Integer, List<C1196b>> f2471a = new HashMap();
    /* renamed from: b */
    private C1197c f2472b = new C1197c(new C1194a());

    /* renamed from: com.alibaba.baichuan.trade.common.a.a$a */
    class C1194a extends C1198a {
        C1194a() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo10844a(Message message) {
            final int i = message.what;
            final Object obj = message.obj;
            synchronized (C1193a.class) {
                List<C1196b> list = (List) C1193a.this.f2471a.get(Integer.valueOf(i));
                if (list != null && list.size() > 0) {
                    for (final C1196b bVar : list) {
                        if (bVar.f2478b) {
                            C1227b.m2414a().mo10882b(new Runnable() {
                                public void run() {
                                    bVar.onMessageEvent(i, obj);
                                }
                            });
                        } else {
                            bVar.onMessageEvent(i, obj);
                        }
                    }
                }
            }
        }
    }

    private C1193a() {
    }

    /* renamed from: a */
    public static synchronized C1193a m2325a() {
        C1193a aVar;
        synchronized (C1193a.class) {
            if (f2470c == null) {
                f2470c = new C1193a();
            }
            aVar = f2470c;
        }
        return aVar;
    }

    /* renamed from: a */
    public void mo10841a(int i, Object obj) {
        Message message = new Message();
        message.what = i;
        message.obj = obj;
        this.f2472b.mo10846a(message);
    }

    /* renamed from: a */
    public synchronized void mo10842a(C1196b bVar) {
        if (bVar != null) {
            if (this.f2471a.get(Integer.valueOf(bVar.f2479c)) == null) {
                this.f2471a.put(Integer.valueOf(bVar.f2479c), new LinkedList());
            }
            ((List) this.f2471a.get(Integer.valueOf(bVar.f2479c))).add(bVar);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
            return;
     */
    /* renamed from: b */
    public synchronized void mo10843b(com.alibaba.baichuan.trade.common.p058a.C1196b r3) {
        /*
        r2 = this;
        monitor-enter(r2)
        if (r3 != 0) goto L_0x0005
        monitor-exit(r2)
        return
    L_0x0005:
        java.util.Map<java.lang.Integer, java.util.List<com.alibaba.baichuan.trade.common.a.b>> r0 = r2.f2471a     // Catch:{ all -> 0x0023 }
        int r1 = r3.f2479c     // Catch:{ all -> 0x0023 }
        java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0023 }
        java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0023 }
        java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0023 }
        if (r0 == 0) goto L_0x0021
        int r1 = r0.size()     // Catch:{ all -> 0x0023 }
        if (r1 != 0) goto L_0x001c
        goto L_0x0021
    L_0x001c:
        r0.remove(r3)     // Catch:{ all -> 0x0023 }
        monitor-exit(r2)
        return
    L_0x0021:
        monitor-exit(r2)
        return
    L_0x0023:
        r3 = move-exception
        monitor-exit(r2)
        throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.baichuan.trade.common.p058a.C1193a.mo10843b(com.alibaba.baichuan.trade.common.a.b):void");
    }
}
