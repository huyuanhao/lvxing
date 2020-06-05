package btmsdkobf;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeMap;

/* renamed from: btmsdkobf.er */
public class C0818er<T> {
    /* renamed from: nf */
    private TreeMap<T, LinkedList<T>> f914nf = null;

    public C0818er(Comparator<T> comparator) {
        this.f914nf = new TreeMap<>(comparator);
    }

    /* renamed from: cv */
    private LinkedList<T> m824cv() {
        return new LinkedList<>();
    }

    public synchronized void add(T t) {
        LinkedList linkedList = (LinkedList) this.f914nf.get(t);
        if (linkedList == null) {
            linkedList = m824cv();
            this.f914nf.put(t, linkedList);
        }
        linkedList.addLast(t);
    }

    public synchronized void clear() {
        this.f914nf.clear();
    }

    public synchronized boolean isEmpty() {
        return this.f914nf.isEmpty();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
            return r2;
     */
    public synchronized T poll() {
        /*
        r3 = this;
        monitor-enter(r3)
        boolean r0 = r3.isEmpty()     // Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x000a
        r0 = 0
        monitor-exit(r3)
        return r0
    L_0x000a:
        java.util.TreeMap<T, java.util.LinkedList<T>> r0 = r3.f914nf     // Catch:{ all -> 0x0029 }
        java.lang.Object r0 = r0.firstKey()     // Catch:{ all -> 0x0029 }
        java.util.TreeMap<T, java.util.LinkedList<T>> r1 = r3.f914nf     // Catch:{ all -> 0x0029 }
        java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x0029 }
        java.util.LinkedList r1 = (java.util.LinkedList) r1     // Catch:{ all -> 0x0029 }
        java.lang.Object r2 = r1.poll()     // Catch:{ all -> 0x0029 }
        int r1 = r1.size()     // Catch:{ all -> 0x0029 }
        if (r1 > 0) goto L_0x0027
        java.util.TreeMap<T, java.util.LinkedList<T>> r1 = r3.f914nf     // Catch:{ all -> 0x0029 }
        r1.remove(r0)     // Catch:{ all -> 0x0029 }
    L_0x0027:
        monitor-exit(r3)
        return r2
    L_0x0029:
        r0 = move-exception
        monitor-exit(r3)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0818er.poll():java.lang.Object");
    }
}
