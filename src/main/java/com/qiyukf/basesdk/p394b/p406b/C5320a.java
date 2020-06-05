package com.qiyukf.basesdk.p394b.p406b;

import android.util.SparseArray;
import com.qiyukf.basesdk.p394b.p406b.p407a.C5323c;
import com.qiyukf.basesdk.p394b.p406b.p407a.C5328e;
import com.qiyukf.basesdk.p394b.p406b.p407a.C5339k;
import com.qiyukf.basesdk.p394b.p406b.p409c.C5352f;

/* renamed from: com.qiyukf.basesdk.b.b.a */
public final class C5320a {
    /* renamed from: a */
    private final SparseArray<Object> f17224a = new SparseArray<>();
    /* renamed from: b */
    private long f17225b;
    /* renamed from: c */
    private C5328e f17226c;
    /* renamed from: d */
    private C5352f f17227d = new C5352f();

    /* renamed from: a */
    public final C5323c mo27220a(String str, int i) {
        return new C5339k(this.f17227d).mo27226a().mo27256a(str, i, this.f17224a, this.f17226c, this.f17225b);
    }

    /* renamed from: a */
    public final C5320a mo27221a() {
        this.f17225b = 30000;
        return this;
    }

    /* renamed from: a */
    public final <T> C5320a mo27222a(int i, T t) {
        synchronized (this.f17224a) {
            if (t == null) {
                this.f17224a.remove(i);
            } else {
                this.f17224a.put(i, t);
            }
        }
        return this;
    }

    /* renamed from: a */
    public final C5320a mo27223a(C5328e eVar) {
        this.f17226c = eVar;
        return this;
    }

    /* renamed from: b */
    public final void mo27224b() {
        C5352f fVar = this.f17227d;
        if (fVar != null) {
            fVar.mo27300i();
        }
    }
}
