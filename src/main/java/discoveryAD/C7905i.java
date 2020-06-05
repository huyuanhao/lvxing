package discoveryAD;

import com.tencent.qqpim.discovery.AdRequestData;
import java.util.List;

/* renamed from: discoveryAD.i */
class C7905i implements Runnable {
    /* renamed from: Fc */
    final /* synthetic */ C7858c f26903Fc;
    /* renamed from: Gc */
    final /* synthetic */ List f26904Gc;
    final /* synthetic */ C7855C this$0;

    C7905i(C7855C c, List list, C7858c cVar) {
        this.this$0 = c;
        this.f26904Gc = list;
        this.f26903Fc = cVar;
    }

    public void run() {
        if (C7931ta.isNetworkConnected(this.this$0.mContext)) {
            this.this$0.m34170a(this.f26904Gc, this.f26903Fc);
            return;
        }
        for (AdRequestData adRequestData : this.f26904Gc) {
            StringBuilder sb = new StringBuilder();
            sb.append("ReportError.NONETWORK AdRequestData:");
            sb.append(adRequestData.positionId);
            C7852Aa.m34153d(sb.toString());
            this.f26903Fc.f26743ad.put(adRequestData.positionId, 3);
        }
        this.this$0.m34172a(this.f26904Gc, this.f26903Fc, false);
    }
}
