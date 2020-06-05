package com.bytedance.embedapplog.p141a;

import android.content.Context;
import com.bytedance.embedapplog.p142b.C1822i;
import com.bytedance.embedapplog.p144d.C1839b;

/* renamed from: com.bytedance.embedapplog.a.f */
class C1806f extends C1808h {
    /* renamed from: b */
    private boolean f5059b;

    C1806f(Context context, C1822i iVar, C1839b bVar) {
        super(context, iVar, bVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public long mo13346b() {
        return this.f5059b ? Long.MAX_VALUE : 0;
    }

    /* renamed from: d */
    public boolean mo13348d() {
        boolean d = super.mo13348d();
        this.f5059b = d;
        return d;
    }
}
