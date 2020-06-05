package discoveryAD;

import android.os.Bundle;
import com.tencent.qqpim.discovery.AdDisplayModel;
import com.tencent.qqpim.discovery.internal.model.C7491f;

/* renamed from: discoveryAD.y */
class C7940y implements Runnable {
    /* renamed from: Oc */
    final /* synthetic */ AdDisplayModel f26974Oc;
    /* renamed from: Sc */
    final /* synthetic */ C7885a f26975Sc;
    /* renamed from: Tc */
    final /* synthetic */ C7491f f26976Tc;
    /* renamed from: Vc */
    final /* synthetic */ Bundle f26977Vc;
    final /* synthetic */ C7855C this$0;

    C7940y(C7855C c, C7491f fVar, AdDisplayModel adDisplayModel, Bundle bundle, C7885a aVar) {
        this.this$0 = c;
        this.f26976Tc = fVar;
        this.f26974Oc = adDisplayModel;
        this.f26977Vc = bundle;
        this.f26975Sc = aVar;
    }

    public void run() {
        this.this$0.m34176b(this.f26976Tc, this.f26974Oc, this.f26977Vc);
        if (this.f26975Sc != null) {
            C7862G.getInstance().mo38132eb().mo38171a(this.f26976Tc.uniqueKey, this.f26975Sc);
        }
        this.this$0.f26733hd.mo38153a(this.f26976Tc, 4, 0, 0);
    }
}
