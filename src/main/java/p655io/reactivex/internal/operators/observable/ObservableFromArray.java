package p655io.reactivex.internal.operators.observable;

import p655io.reactivex.Observable;
import p655io.reactivex.Observer;
import p655io.reactivex.internal.observers.BasicQueueDisposable;
import p655io.reactivex.internal.p669a.ObjectHelper;

/* renamed from: io.reactivex.internal.operators.observable.j */
public final class ObservableFromArray<T> extends Observable<T> {
    /* renamed from: a */
    final T[] f27555a;

    /* compiled from: ObservableFromArray */
    /* renamed from: io.reactivex.internal.operators.observable.j$a */
    static final class C8131a<T> extends BasicQueueDisposable<T> {
        /* renamed from: a */
        final Observer<? super T> f27556a;
        /* renamed from: b */
        final T[] f27557b;
        /* renamed from: c */
        int f27558c;
        /* renamed from: d */
        boolean f27559d;
        /* renamed from: e */
        volatile boolean f27560e;

        C8131a(Observer<? super T> lVar, T[] tArr) {
            this.f27556a = lVar;
            this.f27557b = tArr;
        }

        public int requestFusion(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            this.f27559d = true;
            return 1;
        }

        public T poll() {
            int i = this.f27558c;
            T[] tArr = this.f27557b;
            if (i == tArr.length) {
                return null;
            }
            this.f27558c = i + 1;
            return ObjectHelper.m35048a(tArr[i], "The array element is null");
        }

        public boolean isEmpty() {
            return this.f27558c == this.f27557b.length;
        }

        public void clear() {
            this.f27558c = this.f27557b.length;
        }

        public void dispose() {
            this.f27560e = true;
        }

        public boolean isDisposed() {
            return this.f27560e;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo39013a() {
            T[] tArr = this.f27557b;
            int length = tArr.length;
            for (int i = 0; i < length && !isDisposed(); i++) {
                T t = tArr[i];
                if (t == null) {
                    Observer<? super T> lVar = this.f27556a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("The ");
                    sb.append(i);
                    sb.append("th element is null");
                    lVar.onError(new NullPointerException(sb.toString()));
                    return;
                }
                this.f27556a.onNext(t);
            }
            if (!isDisposed()) {
                this.f27556a.onComplete();
            }
        }
    }

    public ObservableFromArray(T[] tArr) {
        this.f27555a = tArr;
    }

    /* renamed from: a */
    public void mo19781a(Observer<? super T> lVar) {
        C8131a aVar = new C8131a(lVar, this.f27555a);
        lVar.onSubscribe(aVar);
        if (!aVar.f27559d) {
            aVar.mo39013a();
        }
    }
}
