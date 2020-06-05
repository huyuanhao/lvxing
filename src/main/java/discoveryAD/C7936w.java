package discoveryAD;

import com.tencent.qqpim.discovery.internal.model.C7491f;

/* renamed from: discoveryAD.w */
class C7936w implements Runnable {
    /* renamed from: Tc */
    final /* synthetic */ C7491f f26968Tc;
    /* renamed from: Uc */
    final /* synthetic */ boolean f26969Uc;
    final /* synthetic */ C7855C this$0;

    C7936w(C7855C c, boolean z, C7491f fVar) {
        this.this$0 = c;
        this.f26969Uc = z;
        this.f26968Tc = fVar;
    }

    public void run() {
        if (this.f26969Uc) {
            C7862G.getInstance().mo38132eb().delete(this.f26968Tc.uniqueKey);
        }
        this.this$0.f26733hd.mo38153a(this.f26968Tc, 9, 0, 0);
    }
}
