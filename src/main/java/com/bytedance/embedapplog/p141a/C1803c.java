package com.bytedance.embedapplog.p141a;

import android.content.Context;
import com.bytedance.embedapplog.util.C1852d;
import com.bytedance.embedapplog.util.C1856h;

/* renamed from: com.bytedance.embedapplog.a.c */
abstract class C1803c {
    /* renamed from: a */
    final Context f5041a;
    /* renamed from: b */
    private int f5042b = 0;
    /* renamed from: c */
    private boolean f5043c;

    /* renamed from: a */
    public abstract boolean mo13345a();

    /* renamed from: b */
    public abstract long mo13346b();

    /* renamed from: c */
    public abstract long[] mo13347c();

    /* renamed from: d */
    public abstract boolean mo13348d();

    /* renamed from: e */
    public abstract String mo13349e();

    C1803c(Context context) {
        this.f5041a = context;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo13350f() {
        this.f5043c = true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public boolean mo13351g() {
        return this.f5043c;
    }

    /* access modifiers changed from: final */
    /* renamed from: h */
    public final long mo13352h() {
        boolean z;
        long j;
        boolean z2 = !mo13345a() || C1852d.m6564a(this.f5041a);
        if (!z2) {
            return 60000;
        }
        long b = mo13346b();
        long currentTimeMillis = System.currentTimeMillis();
        if (b > 1000 + currentTimeMillis) {
            return b - currentTimeMillis;
        }
        try {
            z = mo13348d();
        } catch (Exception e) {
            C1856h.m6582a(e);
            z = false;
        }
        if (z) {
            this.f5042b = 0;
            j = mo13346b() - System.currentTimeMillis();
        } else {
            long[] c = mo13347c();
            int i = this.f5042b;
            this.f5042b = i + 1;
            j = c[i % c.length];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(mo13349e());
        sb.append(" worked:");
        sb.append(z);
        sb.append(" ");
        sb.append(j);
        C1856h.m6585d(sb.toString(), null);
        return j;
    }
}
