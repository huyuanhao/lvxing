package btmsdkobf;

import java.util.Iterator;
import java.util.LinkedHashSet;

/* renamed from: btmsdkobf.en */
public class C0808en<T> {
    /* renamed from: hp */
    private int f903hp = -1;
    /* renamed from: mV */
    private LinkedHashSet<T> f904mV = new LinkedHashSet<>();

    public C0808en(int i) {
        this.f903hp = i;
    }

    /* renamed from: b */
    public synchronized boolean mo9490b(T t) {
        return this.f904mV.contains(t);
    }

    public synchronized T poll() {
        if (this.f904mV != null) {
            Iterator it = this.f904mV.iterator();
            if (it != null && it.hasNext()) {
                T next = it.next();
                this.f904mV.remove(next);
                return next;
            }
        }
        return null;
    }

    public synchronized void push(T t) {
        if (this.f904mV.size() >= this.f903hp) {
            poll();
        }
        this.f904mV.add(t);
    }
}
