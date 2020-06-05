package p655io.reactivex.internal.util;

import p655io.reactivex.Observer;
import p655io.reactivex.p664d.C8084j;

/* renamed from: io.reactivex.internal.util.a */
public class AppendOnlyLinkedArrayList<T> {
    /* renamed from: a */
    final int f27687a;
    /* renamed from: b */
    final Object[] f27688b;
    /* renamed from: c */
    Object[] f27689c = this.f27688b;
    /* renamed from: d */
    int f27690d;

    /* compiled from: AppendOnlyLinkedArrayList */
    /* renamed from: io.reactivex.internal.util.a$a */
    public interface C8161a<T> extends C8084j<T> {
        boolean test(T t);
    }

    public AppendOnlyLinkedArrayList(int i) {
        this.f27687a = i;
        this.f27688b = new Object[(i + 1)];
    }

    /* renamed from: a */
    public void mo39146a(T t) {
        int i = this.f27687a;
        int i2 = this.f27690d;
        if (i2 == i) {
            Object[] objArr = new Object[(i + 1)];
            this.f27689c[i] = objArr;
            this.f27689c = objArr;
            i2 = 0;
        }
        this.f27689c[i2] = t;
        this.f27690d = i2 + 1;
    }

    /* renamed from: b */
    public void mo39148b(T t) {
        this.f27688b[0] = t;
    }

    /* renamed from: a */
    public void mo39145a(C8161a<? super T> aVar) {
        int i = this.f27687a;
        for (Object[] objArr = this.f27688b; objArr != null; objArr = objArr[i]) {
            int i2 = 0;
            while (i2 < i) {
                Object[] objArr2 = objArr[i2];
                if (objArr2 == null) {
                    continue;
                    break;
                } else if (!aVar.test(objArr2)) {
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public <U> boolean mo39147a(Observer<? super U> lVar) {
        Object[] objArr = this.f27688b;
        int i = this.f27687a;
        while (true) {
            int i2 = 0;
            if (objArr == null) {
                return false;
            }
            while (i2 < i) {
                Object[] objArr2 = objArr[i2];
                if (objArr2 == null) {
                    continue;
                    break;
                } else if (NotificationLite.acceptFull((Object) objArr2, lVar)) {
                    return true;
                } else {
                    i2++;
                }
            }
            objArr = objArr[i];
        }
    }
}
