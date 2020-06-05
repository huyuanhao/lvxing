package discoveryAD;

import com.tencent.qqpim.discovery.AdDisplayModel;
import com.tencent.qqpim.discovery.AdRequestData;
import com.tencent.qqpim.discovery.internal.model.C7491f;

/* renamed from: discoveryAD.r */
class C7926r implements Runnable {
    /* renamed from: Oc */
    final /* synthetic */ AdDisplayModel f26949Oc;
    /* renamed from: Rc */
    final /* synthetic */ long f26950Rc;
    final /* synthetic */ C7855C this$0;

    C7926r(C7855C c, AdDisplayModel adDisplayModel, long j) {
        this.this$0 = c;
        this.f26949Oc = adDisplayModel;
        this.f26950Rc = j;
    }

    public void run() {
        AdRequestData adRequestData = new AdRequestData();
        adRequestData.positionId = this.f26949Oc.positionId;
        this.this$0.m34162a(adRequestData);
        C7491f a = this.this$0.mo38109a(this.f26949Oc);
        if (a != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("onShowAd() UnifiedAdData:");
            sb.append(a);
            C7852Aa.m34153d(sb.toString());
            C7885a c = this.this$0.f26731ed.mo38190c(a);
            a.predisplaytime = c.f26821xc;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onShowAd() UnifiedAdData PreDisplaytime:");
            sb2.append(a.predisplaytime);
            C7852Aa.m34153d(sb2.toString());
            if (c != null) {
                C7862G.getInstance().mo38132eb().mo38171a(a.uniqueKey, c);
            }
            this.this$0.f26733hd.mo38153a(a, 3, this.f26950Rc, 0);
        }
    }
}
