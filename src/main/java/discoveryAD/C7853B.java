package discoveryAD;

import com.tencent.qqpim.discovery.AdRequestData;
import java.util.List;

/* renamed from: discoveryAD.B */
class C7853B implements Runnable {
    /* renamed from: Ac */
    final /* synthetic */ List f26725Ac;
    /* renamed from: Fc */
    final /* synthetic */ C7858c f26726Fc;
    final /* synthetic */ C7855C this$0;

    C7853B(C7855C c, List list, C7858c cVar) {
        this.this$0 = c;
        this.f26725Ac = list;
        this.f26726Fc = cVar;
    }

    public void run() {
        if (C7931ta.isNetworkConnected(this.this$0.mContext)) {
            this.this$0.m34170a(this.f26725Ac, this.f26726Fc);
            return;
        }
        for (AdRequestData adRequestData : this.f26725Ac) {
            this.f26726Fc.f26743ad.put(adRequestData.positionId, 3);
        }
        this.this$0.m34171a(this.f26725Ac, this.f26726Fc, null);
    }
}
