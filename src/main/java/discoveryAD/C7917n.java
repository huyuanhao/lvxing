package discoveryAD;

import com.tencent.qqpim.discovery.AdRequestData;
import java.util.List;

/* renamed from: discoveryAD.n */
class C7917n implements Runnable {
    /* renamed from: Fc */
    final /* synthetic */ C7858c f26921Fc;
    /* renamed from: Gc */
    final /* synthetic */ List f26922Gc;
    final /* synthetic */ C7855C this$0;

    C7917n(C7855C c, List list, C7858c cVar) {
        this.this$0 = c;
        this.f26922Gc = list;
        this.f26921Fc = cVar;
    }

    public void run() {
        if (C7931ta.isNetworkConnected(this.this$0.mContext)) {
            this.this$0.m34170a(this.f26922Gc, this.f26921Fc);
            return;
        }
        for (AdRequestData adRequestData : this.f26922Gc) {
            StringBuilder sb = new StringBuilder();
            sb.append("ReportError.NONETWORK AdRequestData:");
            sb.append(adRequestData.positionId);
            C7852Aa.m34153d(sb.toString());
            this.f26921Fc.f26743ad.put(adRequestData.positionId, 3);
        }
        this.f26921Fc.f26745cd.mo38122a(this.f26922Gc);
    }
}
