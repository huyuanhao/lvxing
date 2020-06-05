package com.tencent.android.tpush.stat.p597b;

import android.content.Context;
import com.tencent.android.tpush.stat.p596a.C7066c;
import com.tencent.android.tpush.stat.p596a.C7067d;
import com.tencent.android.tpush.stat.p596a.C7069f;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.stat.b.h */
public abstract class C7079h {
    /* renamed from: a */
    protected C7067d f23534a = C7066c.m30259b();
    /* renamed from: b */
    protected Context f23535b = null;
    /* renamed from: c */
    protected int f23536c = 0;

    /* renamed from: a */
    public abstract int mo34177a();

    /* renamed from: a */
    public abstract void mo34178a(String str);

    /* renamed from: b */
    public abstract boolean mo34179b();

    /* renamed from: c */
    public abstract String mo34180c();

    /* renamed from: d */
    public String mo34199d() {
        String str = "6X8Y4XdM2Vhvn0I=";
        if (this.f23536c == 0) {
            return C7069f.m30290a(str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(C7069f.m30290a(str));
        sb.append(this.f23536c);
        return sb.toString();
    }

    /* renamed from: e */
    public String mo34201e() {
        String str = "6X8Y4XdM2Vhvn0KfzcEatGnWaNU=";
        if (this.f23536c == 0) {
            return C7069f.m30290a(str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(C7069f.m30290a(str));
        sb.append(this.f23536c);
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public String mo34202f() {
        String str = "4kU71lN96TJUomD1vOU9lgj9Tw==";
        if (this.f23536c == 0) {
            return C7069f.m30290a(str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(C7069f.m30290a(str));
        sb.append(this.f23536c);
        return sb.toString();
    }

    protected C7079h(Context context, int i) {
        this.f23535b = context;
        this.f23536c = i;
    }

    /* renamed from: h */
    private String m30349h() {
        if (mo34179b()) {
            return mo34200d(mo34180c());
        }
        return null;
    }

    /* renamed from: g */
    public C7075d mo34203g() {
        String h = m30349h();
        if (h != null) {
            return C7075d.m30322a(h);
        }
        return null;
    }

    /* renamed from: b */
    private void mo34196b(String str) {
        if (mo34179b()) {
            mo34178a(mo34198c(str));
        }
    }

    /* renamed from: a */
    public void mo34197a(C7075d dVar) {
        if (dVar != null) {
            if (mo34177a() == 4) {
                C7076e.m30335a(this.f23535b).mo34194a(dVar.mo34190e());
            }
            mo34196b(dVar.toString());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo34198c(String str) {
        return C7069f.m30293b(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String mo34200d(String str) {
        return C7069f.m30290a(str);
    }
}
