package discoveryAD;

import com.tencent.qqpim.discovery.AdDisplayModel;
import com.tencent.qqpim.discovery.AdRequestData;
import com.tencent.qqpim.discovery.internal.model.C7491f;

/* renamed from: discoveryAD.v */
class C7934v implements Runnable {
    /* renamed from: Oc */
    final /* synthetic */ AdDisplayModel f26964Oc;
    /* renamed from: Uc */
    final /* synthetic */ boolean f26965Uc;
    final /* synthetic */ C7855C this$0;

    C7934v(C7855C c, AdDisplayModel adDisplayModel, boolean z) {
        this.this$0 = c;
        this.f26964Oc = adDisplayModel;
        this.f26965Uc = z;
    }

    public void run() {
        AdRequestData adRequestData = new AdRequestData();
        adRequestData.positionId = this.f26964Oc.positionId;
        this.this$0.m34162a(adRequestData);
        C7491f a = this.this$0.mo38109a(this.f26964Oc);
        if (a != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("onNagetiveFeedbackAd() UnifiedAdData:");
            sb.append(a);
            C7852Aa.m34153d(sb.toString());
            if (this.f26965Uc) {
                this.this$0.f26731ed.mo38193e(a);
                C7862G.getInstance().mo38132eb().delete(a.uniqueKey);
            }
            this.this$0.f26733hd.mo38153a(a, 9, 0, 0);
        }
    }
}
