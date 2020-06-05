package discoveryAD;

import com.tencent.qqpim.discovery.AdDisplayModel;
import com.tencent.qqpim.discovery.AdRequestData;
import com.tencent.qqpim.discovery.internal.model.C7491f;

/* renamed from: discoveryAD.q */
class C7924q implements Runnable {
    /* renamed from: Oc */
    final /* synthetic */ AdDisplayModel f26946Oc;
    /* renamed from: Pc */
    final /* synthetic */ int f26947Pc;
    /* renamed from: Qc */
    final /* synthetic */ int f26948Qc;
    final /* synthetic */ C7855C this$0;

    C7924q(C7855C c, AdDisplayModel adDisplayModel, int i, int i2) {
        this.this$0 = c;
        this.f26946Oc = adDisplayModel;
        this.f26947Pc = i;
        this.f26948Qc = i2;
    }

    public void run() {
        AdRequestData adRequestData = new AdRequestData();
        adRequestData.positionId = this.f26946Oc.positionId;
        this.this$0.m34162a(adRequestData);
        C7491f a = this.this$0.mo38109a(this.f26946Oc);
        if (a != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("reportAppPhase() UnifiedAdData:");
            sb.append(a);
            sb.append(" phase=");
            sb.append(this.f26947Pc);
            C7852Aa.m34153d(sb.toString());
            C7885a aVar = null;
            int i = this.f26947Pc;
            if (i == 5) {
                aVar = this.this$0.f26731ed.mo38194f(a);
            } else if (i == 6) {
                aVar = this.this$0.f26731ed.mo38192d(a);
            } else if (i == 10) {
                aVar = this.this$0.f26731ed.mo38186a(a);
            }
            if (aVar != null) {
                C7862G.getInstance().mo38132eb().mo38171a(a.uniqueKey, aVar);
            }
            this.this$0.f26733hd.mo38153a(a, this.f26947Pc, 0, this.f26948Qc);
        }
    }
}
