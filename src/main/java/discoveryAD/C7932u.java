package discoveryAD;

import com.tencent.qqpim.discovery.internal.model.C7491f;

/* renamed from: discoveryAD.u */
class C7932u implements Runnable {
    /* renamed from: Rc */
    final /* synthetic */ long f26961Rc;
    /* renamed from: Sc */
    final /* synthetic */ C7885a f26962Sc;
    /* renamed from: Tc */
    final /* synthetic */ C7491f f26963Tc;
    final /* synthetic */ C7855C this$0;

    C7932u(C7855C c, C7885a aVar, C7491f fVar, long j) {
        this.this$0 = c;
        this.f26962Sc = aVar;
        this.f26963Tc = fVar;
        this.f26961Rc = j;
    }

    public void run() {
        if (this.f26962Sc != null) {
            C7862G.getInstance().mo38132eb().mo38171a(this.f26963Tc.uniqueKey, this.f26962Sc);
        }
        this.this$0.f26733hd.mo38153a(this.f26963Tc, 3, this.f26961Rc, 0);
    }
}
