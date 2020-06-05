package com.bytedance.embedapplog.p142b;

import com.bytedance.embedapplog.p141a.C1805e;
import com.bytedance.embedapplog.p144d.C1838a;
import com.bytedance.embedapplog.p144d.C1841c;
import com.bytedance.embedapplog.p144d.C1843e;
import com.bytedance.embedapplog.p144d.C1847i;
import com.bytedance.embedapplog.util.C1856h;
import java.util.LinkedList;

/* renamed from: com.bytedance.embedapplog.b.b */
public class C1815b {
    /* renamed from: a */
    private static final LinkedList<C1838a> f5093a = new LinkedList<>();
    /* renamed from: b */
    private static final LinkedList<C1838a> f5094b = new LinkedList<>();

    /* renamed from: a */
    public static void m6315a(C1838a aVar) {
        synchronized (f5093a) {
            if (f5093a.size() > 200) {
                C1838a aVar2 = (C1838a) f5093a.poll();
                C1856h.m6583b("drop event in cache", null);
                f5094b.add(aVar2);
            }
            f5093a.add(aVar);
        }
    }

    /* renamed from: a */
    public static void m6314a() {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        synchronized (f5093a) {
            linkedList.addAll(f5093a);
            linkedList2.addAll(f5094b);
            f5093a.clear();
            f5094b.clear();
        }
        while (!linkedList.isEmpty()) {
            C1805e.m6273a((C1838a) linkedList.poll());
        }
        while (!linkedList2.isEmpty()) {
            C1838a aVar = (C1838a) linkedList2.poll();
            C1847i iVar = null;
            if (aVar instanceof C1847i) {
                iVar = (C1847i) aVar;
            } else if (aVar instanceof C1841c) {
                C1841c cVar = (C1841c) aVar;
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(cVar.mo13482i());
                sb.append(cVar.mo13483j());
                iVar = new C1847i(sb.toString(), "16", 1);
            } else if (aVar instanceof C1843e) {
                iVar = new C1847i(((C1843e) aVar).mo13485j(), "16", 1);
            }
            C1805e.m6273a((C1838a) iVar);
        }
    }
}
