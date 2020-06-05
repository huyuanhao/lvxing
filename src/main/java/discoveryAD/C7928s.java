package discoveryAD;

import com.tencent.qqpim.discovery.internal.model.C7491f;

/* renamed from: discoveryAD.s */
class C7928s implements Runnable {
    /* renamed from: Pc */
    final /* synthetic */ int f26951Pc;
    /* renamed from: Qc */
    final /* synthetic */ int f26952Qc;
    /* renamed from: Sc */
    final /* synthetic */ C7885a f26953Sc;
    /* renamed from: Tc */
    final /* synthetic */ C7491f f26954Tc;
    final /* synthetic */ C7855C this$0;

    C7928s(C7855C c, C7885a aVar, C7491f fVar, int i, int i2) {
        this.this$0 = c;
        this.f26953Sc = aVar;
        this.f26954Tc = fVar;
        this.f26951Pc = i;
        this.f26952Qc = i2;
    }

    public void run() {
        if (this.f26953Sc != null) {
            C7862G.getInstance().mo38132eb().mo38171a(this.f26954Tc.uniqueKey, this.f26953Sc);
        }
        this.this$0.f26733hd.mo38153a(this.f26954Tc, this.f26951Pc, 0, this.f26952Qc);
    }
}
