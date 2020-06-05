package discoveryAD;

import android.os.Bundle;
import com.tencent.qqpim.discovery.AdDisplayModel;
import com.tencent.qqpim.discovery.AdRequestData;
import com.tencent.qqpim.discovery.internal.model.C7491f;

/* renamed from: discoveryAD.x */
class C7938x implements Runnable {
    /* renamed from: Oc */
    final /* synthetic */ AdDisplayModel f26971Oc;
    /* renamed from: Vc */
    final /* synthetic */ Bundle f26972Vc;
    final /* synthetic */ C7855C this$0;

    C7938x(C7855C c, AdDisplayModel adDisplayModel, Bundle bundle) {
        this.this$0 = c;
        this.f26971Oc = adDisplayModel;
        this.f26972Vc = bundle;
    }

    public void run() {
        AdRequestData adRequestData = new AdRequestData();
        adRequestData.positionId = this.f26971Oc.positionId;
        this.this$0.m34162a(adRequestData);
        C7491f a = this.this$0.mo38109a(this.f26971Oc);
        if (a != null) {
            this.this$0.m34176b(a, this.f26971Oc, this.f26972Vc);
            StringBuilder sb = new StringBuilder();
            sb.append("onClickAd() UnifiedAdData:");
            sb.append(a);
            C7852Aa.m34153d(sb.toString());
            C7885a b = this.this$0.f26731ed.mo38188b(a);
            if (b != null) {
                C7862G.getInstance().mo38132eb().mo38171a(a.uniqueKey, b);
            }
            this.this$0.f26733hd.mo38153a(a, 4, 0, 0);
        }
    }
}
