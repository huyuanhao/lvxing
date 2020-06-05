package p655io.reactivex.internal.operators.observable;

import p655io.reactivex.Observable;
import p655io.reactivex.Observer;
import p655io.reactivex.internal.disposables.EmptyDisposable;
import p655io.reactivex.internal.p670b.ScalarCallable;

/* renamed from: io.reactivex.internal.operators.observable.f */
public final class ObservableEmpty extends Observable<Object> implements ScalarCallable<Object> {
    /* renamed from: a */
    public static final Observable<Object> f27546a = new ObservableEmpty();

    public Object call() {
        return null;
    }

    private ObservableEmpty() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo19781a(Observer<? super Object> lVar) {
        EmptyDisposable.complete(lVar);
    }
}
