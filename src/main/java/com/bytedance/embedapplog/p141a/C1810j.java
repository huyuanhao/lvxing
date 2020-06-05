package com.bytedance.embedapplog.p141a;

import android.content.Context;
import com.bytedance.embedapplog.p142b.C1821h;
import com.bytedance.embedapplog.p142b.C1822i;
import com.bytedance.embedapplog.p143c.C1835a;
import com.bytedance.embedapplog.p143c.C1836b;
import com.bytedance.embedapplog.p144d.C1839b;
import com.bytedance.embedapplog.p144d.C1844f;
import com.bytedance.embedapplog.p144d.C1845g;
import com.bytedance.embedapplog.util.C1856h;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.a.j */
class C1810j extends C1803c {
    /* renamed from: b */
    private static final long[] f5070b = {60000};
    /* renamed from: c */
    private final C1821h f5071c;
    /* renamed from: d */
    private final C1839b f5072d;
    /* renamed from: e */
    private final C1822i f5073e;
    /* renamed from: f */
    private long f5074f;
    /* renamed from: g */
    private long f5075g;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo13345a() {
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public String mo13349e() {
        return "s";
    }

    C1810j(Context context, C1839b bVar, C1821h hVar, C1822i iVar) {
        super(context);
        this.f5072d = bVar;
        this.f5071c = hVar;
        this.f5073e = iVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public long mo13346b() {
        long B = this.f5071c.mo13367B();
        long j = 60000;
        if (B <= 60000 && B > 0) {
            j = B;
        }
        f5070b[0] = j;
        return this.f5074f + j;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public long[] mo13347c() {
        return f5070b;
    }

    /* renamed from: d */
    public boolean mo13348d() {
        if (System.currentTimeMillis() > this.f5075g + this.f5071c.mo13367B()) {
            JSONObject b = this.f5073e.mo13430b();
            C1811k d = C1805e.m6278d();
            if (!(d == null || b == null)) {
                C1844f a = d.mo13359a();
                if (a != null) {
                    this.f5072d.mo13478a(b, a, d.mo13362b());
                    this.f5075g = System.currentTimeMillis();
                }
            }
        }
        ArrayList a2 = this.f5072d.mo13472a();
        ArrayList arrayList = new ArrayList(a2.size());
        ArrayList arrayList2 = new ArrayList(a2.size());
        this.f5072d.mo13474a(this.f5041a, this.f5073e.mo13425a());
        this.f5072d.mo13473a(this.f5041a);
        String[] a3 = C1836b.m6442a(this.f5041a, this.f5073e.mo13425a());
        Iterator it = a2.iterator();
        while (it.hasNext()) {
            C1845g gVar = (C1845g) it.next();
            int a4 = C1835a.m6430a(a3, gVar.f5186h, this.f5071c);
            if (a4 == 200) {
                arrayList.add(gVar);
            } else {
                gVar.f5188j = a4;
                arrayList2.add(gVar);
            }
        }
        if (arrayList.size() > 0 || arrayList2.size() > 0) {
            this.f5072d.mo13476a(arrayList, arrayList2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(mo13349e());
        sb.append(arrayList.size());
        sb.append(" ");
        sb.append(a2.size());
        C1856h.m6585d(sb.toString(), null);
        if (arrayList.size() != a2.size()) {
            return false;
        }
        this.f5074f = System.currentTimeMillis();
        return true;
    }
}
