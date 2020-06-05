package discoveryAD;

import com.tencent.qqpim.discovery.internal.model.C7491f;

/* renamed from: discoveryAD.t */
class C7930t implements Runnable {
    /* renamed from: Pc */
    final /* synthetic */ int f26958Pc;
    /* renamed from: Sc */
    final /* synthetic */ C7885a f26959Sc;
    /* renamed from: Tc */
    final /* synthetic */ C7491f f26960Tc;
    final /* synthetic */ C7855C this$0;

    C7930t(C7855C c, C7885a aVar, C7491f fVar, int i) {
        this.this$0 = c;
        this.f26959Sc = aVar;
        this.f26960Tc = fVar;
        this.f26958Pc = i;
    }

    public void run() {
        if (this.f26959Sc != null) {
            C7862G.getInstance().mo38132eb().mo38171a(this.f26960Tc.uniqueKey, this.f26959Sc);
        }
        this.this$0.f26733hd.mo38153a(this.f26960Tc, this.f26958Pc, 0, 0);
    }
}
