package discoveryAD;

import java.util.List;

/* renamed from: discoveryAD.k */
class C7910k implements Runnable {
    /* renamed from: Fc */
    final /* synthetic */ C7858c f26908Fc;
    /* renamed from: Hc */
    final /* synthetic */ List f26909Hc;
    final /* synthetic */ C7855C this$0;

    C7910k(C7855C c, List list, C7858c cVar) {
        this.this$0 = c;
        this.f26909Hc = list;
        this.f26908Fc = cVar;
    }

    public void run() {
        this.this$0.m34172a(this.f26909Hc, this.f26908Fc, true);
    }
}
