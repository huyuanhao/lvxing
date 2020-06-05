package discoveryAD;

import com.tencent.qqpim.discovery.AdRequestData;
import discoveryAD.C7855C.C7857b;
import java.util.List;

/* renamed from: discoveryAD.l */
class C7913l implements C7857b {
    /* renamed from: Ac */
    final /* synthetic */ List f26912Ac;
    /* renamed from: Fc */
    final /* synthetic */ C7858c f26913Fc;
    final /* synthetic */ C7855C this$0;

    C7913l(C7855C c, C7858c cVar, List list) {
        this.this$0 = c;
        this.f26913Fc = cVar;
        this.f26912Ac = list;
    }

    /* renamed from: a */
    public void mo38122a(List<AdRequestData> list) {
        synchronized (this) {
            for (AdRequestData adRequestData : list) {
                this.f26913Fc.f26741Zc.remove(Integer.valueOf(adRequestData.positionId));
            }
            if (this.f26913Fc.f26741Zc.isEmpty()) {
                this.this$0.m34180c(this.f26912Ac, this.f26913Fc);
            }
        }
    }
}
