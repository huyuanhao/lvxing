package btmsdkobf;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/* renamed from: btmsdkobf.dc */
public class C0682dc<K, V> {
    /* renamed from: hp */
    private int f493hp = -1;
    /* renamed from: hq */
    private LinkedHashMap<K, V> f494hq = new LinkedHashMap<>();

    public C0682dc(int i) {
        this.f493hp = i;
    }

    /* renamed from: a */
    public void mo9265a(K k) {
        try {
            this.f494hq.remove(k);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: aM */
    public LinkedHashMap<K, V> mo9266aM() {
        return this.f494hq;
    }

    public V get(K k) {
        return this.f494hq.get(k);
    }

    public V put(K k, V v) {
        if (this.f494hq.size() >= this.f493hp) {
            Set keySet = this.f494hq.keySet();
            if (keySet != null) {
                Iterator it = keySet.iterator();
                if (it.hasNext()) {
                    try {
                        this.f494hq.remove(it.next());
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        return this.f494hq.put(k, v);
    }

    public int size() {
        return this.f494hq.size();
    }
}
