package discoveryAD;

import java.util.List;

/* renamed from: discoveryAD.A */
class C7851A implements Runnable {
    /* renamed from: Ac */
    final /* synthetic */ List f26723Ac;
    /* renamed from: Fc */
    final /* synthetic */ C7858c f26724Fc;
    final /* synthetic */ C7855C this$0;

    C7851A(C7855C c, List list, C7858c cVar) {
        this.this$0 = c;
        this.f26723Ac = list;
        this.f26724Fc = cVar;
    }

    public void run() {
        this.this$0.m34172a(this.f26723Ac, this.f26724Fc, false);
    }
}
