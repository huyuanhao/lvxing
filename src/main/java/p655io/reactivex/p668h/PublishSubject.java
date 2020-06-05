package p655io.reactivex.p668h;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p655io.reactivex.Observer;
import p655io.reactivex.annotations.CheckReturnValue;
import p655io.reactivex.internal.p669a.ObjectHelper;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: io.reactivex.h.b */
public final class PublishSubject<T> extends Subject<T> {
    /* renamed from: a */
    static final C8099a[] f27459a = new C8099a[0];
    /* renamed from: b */
    static final C8099a[] f27460b = new C8099a[0];
    /* renamed from: c */
    final AtomicReference<C8099a<T>[]> f27461c = new AtomicReference<>(f27460b);
    /* renamed from: d */
    Throwable f27462d;

    /* compiled from: PublishSubject */
    /* renamed from: io.reactivex.h.b$a */
    static final class C8099a<T> extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 3562861878281475070L;
        final Observer<? super T> downstream;
        final PublishSubject<T> parent;

        C8099a(Observer<? super T> lVar, PublishSubject<T> bVar) {
            this.downstream = lVar;
            this.parent = bVar;
        }

        public void onNext(T t) {
            if (!get()) {
                this.downstream.onNext(t);
            }
        }

        public void onError(Throwable th) {
            if (get()) {
                RxJavaPlugins.m34959a(th);
            } else {
                this.downstream.onError(th);
            }
        }

        public void onComplete() {
            if (!get()) {
                this.downstream.onComplete();
            }
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.mo38873b(this);
            }
        }

        public boolean isDisposed() {
            return get();
        }
    }

    @CheckReturnValue
    /* renamed from: a */
    public static <T> PublishSubject<T> m34983a() {
        return new PublishSubject<>();
    }

    PublishSubject() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo19781a(Observer<? super T> lVar) {
        C8099a aVar = new C8099a(lVar, this);
        lVar.onSubscribe(aVar);
        if (!mo38872a(aVar)) {
            Throwable th = this.f27462d;
            if (th != null) {
                lVar.onError(th);
            } else {
                lVar.onComplete();
            }
        } else if (aVar.isDisposed()) {
            mo38873b(aVar);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo38872a(C8099a<T> aVar) {
        C8099a[] aVarArr;
        C8099a[] aVarArr2;
        do {
            aVarArr = (C8099a[]) this.f27461c.get();
            if (aVarArr == f27459a) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new C8099a[(length + 1)];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f27461c.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo38873b(C8099a<T> aVar) {
        C8099a<T>[] aVarArr;
        Object obj;
        do {
            aVarArr = (C8099a[]) this.f27461c.get();
            if (aVarArr != f27459a && aVarArr != f27460b) {
                int length = aVarArr.length;
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (aVarArr[i2] == aVar) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        obj = f27460b;
                    } else {
                        C8099a[] aVarArr2 = new C8099a[(length - 1)];
                        System.arraycopy(aVarArr, 0, aVarArr2, 0, i);
                        System.arraycopy(aVarArr, i + 1, aVarArr2, i, (length - i) - 1);
                        obj = aVarArr2;
                    }
                } else {
                    return;
                }
            }
        } while (!this.f27461c.compareAndSet(aVarArr, obj));
    }

    public void onSubscribe(Disposable bVar) {
        if (this.f27461c.get() == f27459a) {
            bVar.dispose();
        }
    }

    public void onNext(T t) {
        ObjectHelper.m35048a(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (C8099a onNext : (C8099a[]) this.f27461c.get()) {
            onNext.onNext(t);
        }
    }

    public void onError(Throwable th) {
        ObjectHelper.m35048a(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        Object obj = this.f27461c.get();
        Object obj2 = f27459a;
        if (obj == obj2) {
            RxJavaPlugins.m34959a(th);
            return;
        }
        this.f27462d = th;
        for (C8099a onError : (C8099a[]) this.f27461c.getAndSet(obj2)) {
            onError.onError(th);
        }
    }

    public void onComplete() {
        Object obj = this.f27461c.get();
        Object obj2 = f27459a;
        if (obj != obj2) {
            for (C8099a onComplete : (C8099a[]) this.f27461c.getAndSet(obj2)) {
                onComplete.onComplete();
            }
        }
    }
}
