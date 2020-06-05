package discoveryAD;

import java.util.List;

/* renamed from: discoveryAD.j */
class C7907j implements Runnable {
    /* renamed from: Fc */
    final /* synthetic */ C7858c f26905Fc;
    /* renamed from: Gc */
    final /* synthetic */ List f26906Gc;
    final /* synthetic */ C7855C this$0;

    C7907j(C7855C c, List list, C7858c cVar) {
        this.this$0 = c;
        this.f26906Gc = list;
        this.f26905Fc = cVar;
    }

    public void run() {
        this.this$0.m34170a(this.f26906Gc, this.f26905Fc);
    }
}
