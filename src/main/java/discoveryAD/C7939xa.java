package discoveryAD;

import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: discoveryAD.xa */
class C7939xa extends Thread {
    /* renamed from: Kg */
    final /* synthetic */ ArrayList f26973Kg;

    C7939xa(ArrayList arrayList) {
        this.f26973Kg = arrayList;
    }

    public void run() {
        Iterator it = this.f26973Kg.iterator();
        while (it.hasNext()) {
            C7941ya.m34359Q((String) it.next());
        }
    }
}
