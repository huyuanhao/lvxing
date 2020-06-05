package discoveryAD;

import com.tencent.qqpim.discovery.AdRequestData;
import java.util.ArrayList;
import java.util.List;

/* renamed from: discoveryAD.m */
class C7915m implements Runnable {
    /* renamed from: Ac */
    final /* synthetic */ List f26914Ac;
    /* renamed from: Fc */
    final /* synthetic */ C7858c f26915Fc;
    /* renamed from: Ic */
    final /* synthetic */ int f26916Ic;
    final /* synthetic */ C7855C this$0;

    C7915m(C7855C c, List list, C7858c cVar, int i) {
        this.this$0 = c;
        this.f26914Ac = list;
        this.f26915Fc = cVar;
        this.f26916Ic = i;
    }

    public void run() {
        List c = this.this$0.m34175b(this.f26914Ac, this.f26915Fc);
        if (c.isEmpty()) {
            if (this.f26916Ic != 4) {
                this.f26915Fc.f26745cd = null;
            } else {
                return;
            }
        }
        ArrayList arrayList = new ArrayList(6);
        for (AdRequestData adRequestData : this.f26914Ac) {
            if (!C7895e.m34311J(adRequestData.positionId)) {
                if (c.contains(adRequestData)) {
                    if (!C7895e.m34312K(adRequestData.positionId)) {
                        this.f26915Fc.f26743ad.put(adRequestData.positionId, 2);
                    }
                }
            }
            arrayList.add(adRequestData);
        }
        if (c.isEmpty() || !arrayList.isEmpty()) {
            this.this$0.m34170a((List<AdRequestData>) arrayList, this.f26915Fc);
        } else {
            this.f26915Fc.f26745cd.mo38122a(c);
        }
    }
}
