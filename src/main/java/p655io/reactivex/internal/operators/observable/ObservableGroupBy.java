package p655io.reactivex.internal.operators.observable;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p655io.reactivex.ObservableSource;
import p655io.reactivex.Observer;
import p655io.reactivex.exceptions.Exceptions;
import p655io.reactivex.internal.disposables.DisposableHelper;
import p655io.reactivex.internal.disposables.EmptyDisposable;
import p655io.reactivex.internal.p669a.ObjectHelper;
import p655io.reactivex.internal.queue.SpscLinkedArrayQueue;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p664d.Function;
import p655io.reactivex.p665e.GroupedObservable;

/* renamed from: io.reactivex.internal.operators.observable.ObservableGroupBy */
public final class ObservableGroupBy<T, K, V> extends AbstractObservableWithUpstream<T, GroupedObservable<K, V>> {
    /* renamed from: b */
    final Function<? super T, ? extends K> f27508b;
    /* renamed from: c */
    final Function<? super T, ? extends V> f27509c;
    /* renamed from: d */
    final int f27510d;
    /* renamed from: e */
    final boolean f27511e;

    /* renamed from: io.reactivex.internal.operators.observable.ObservableGroupBy$GroupByObserver */
    public static final class GroupByObserver<T, K, V> extends AtomicInteger implements Disposable, Observer<T> {
        static final Object NULL_KEY = new Object();
        private static final long serialVersionUID = -3688291656102519502L;
        final int bufferSize;
        final AtomicBoolean cancelled = new AtomicBoolean();
        final boolean delayError;
        final Observer<? super GroupedObservable<K, V>> downstream;
        final Map<Object, C8119a<K, V>> groups;
        final Function<? super T, ? extends K> keySelector;
        Disposable upstream;
        final Function<? super T, ? extends V> valueSelector;

        public GroupByObserver(Observer<? super GroupedObservable<K, V>> lVar, Function<? super T, ? extends K> hVar, Function<? super T, ? extends V> hVar2, int i, boolean z) {
            this.downstream = lVar;
            this.keySelector = hVar;
            this.valueSelector = hVar2;
            this.bufferSize = i;
            this.delayError = z;
            this.groups = new ConcurrentHashMap();
            lazySet(1);
        }

        public void onSubscribe(Disposable bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            Object obj;
            try {
                Object apply = this.keySelector.apply(t);
                if (apply != null) {
                    obj = apply;
                } else {
                    obj = NULL_KEY;
                }
                C8119a aVar = (C8119a) this.groups.get(obj);
                if (aVar == null) {
                    if (!this.cancelled.get()) {
                        aVar = C8119a.m35074a(apply, this.bufferSize, this, this.delayError);
                        this.groups.put(obj, aVar);
                        getAndIncrement();
                        this.downstream.onNext(aVar);
                    } else {
                        return;
                    }
                }
                try {
                    aVar.mo38989b(ObjectHelper.m35048a(this.valueSelector.apply(t), "The value supplied is null"));
                } catch (Throwable th) {
                    Exceptions.m34944b(th);
                    this.upstream.dispose();
                    onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.m34944b(th2);
                this.upstream.dispose();
                onError(th2);
            }
        }

        public void onError(Throwable th) {
            ArrayList<C8119a> arrayList = new ArrayList<>(this.groups.values());
            this.groups.clear();
            for (C8119a b : arrayList) {
                b.mo38990b(th);
            }
            this.downstream.onError(th);
        }

        public void onComplete() {
            ArrayList<C8119a> arrayList = new ArrayList<>(this.groups.values());
            this.groups.clear();
            for (C8119a a : arrayList) {
                a.mo38988a();
            }
            this.downstream.onComplete();
        }

        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.upstream.dispose();
            }
        }

        public boolean isDisposed() {
            return this.cancelled.get();
        }

        public void cancel(K k) {
            if (k == null) {
                k = NULL_KEY;
            }
            this.groups.remove(k);
            if (decrementAndGet() == 0) {
                this.upstream.dispose();
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableGroupBy$a */
    static final class C8119a<K, T> extends GroupedObservable<K, T> {
        /* renamed from: a */
        final C8120b<T, K> f27512a;

        /* renamed from: a */
        public static <T, K> C8119a<K, T> m35074a(K k, int i, GroupByObserver<?, K, T> groupByObserver, boolean z) {
            return new C8119a<>(k, new C8120b(i, groupByObserver, k, z));
        }

        protected C8119a(K k, C8120b<T, K> bVar) {
            super(k);
            this.f27512a = bVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo19781a(Observer<? super T> lVar) {
            this.f27512a.subscribe(lVar);
        }

        /* renamed from: b */
        public void mo38989b(T t) {
            this.f27512a.onNext(t);
        }

        /* renamed from: b */
        public void mo38990b(Throwable th) {
            this.f27512a.onError(th);
        }

        /* renamed from: a */
        public void mo38988a() {
            this.f27512a.onComplete();
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableGroupBy$b */
    static final class C8120b<T, K> extends AtomicInteger implements Disposable, ObservableSource<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        final AtomicReference<Observer<? super T>> actual = new AtomicReference<>();
        final AtomicBoolean cancelled = new AtomicBoolean();
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final K key;
        final AtomicBoolean once = new AtomicBoolean();
        final GroupByObserver<?, K, T> parent;
        final SpscLinkedArrayQueue<T> queue;

        C8120b(int i, GroupByObserver<?, K, T> groupByObserver, K k, boolean z) {
            this.queue = new SpscLinkedArrayQueue<>(i);
            this.parent = groupByObserver;
            this.key = k;
            this.delayError = z;
        }

        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.actual.lazySet(null);
                this.parent.cancel(this.key);
            }
        }

        public boolean isDisposed() {
            return this.cancelled.get();
        }

        public void subscribe(Observer<? super T> lVar) {
            if (this.once.compareAndSet(false, true)) {
                lVar.onSubscribe(this);
                this.actual.lazySet(lVar);
                if (this.cancelled.get()) {
                    this.actual.lazySet(null);
                } else {
                    drain();
                }
            } else {
                EmptyDisposable.error((Throwable) new IllegalStateException("Only one Observer allowed!"), lVar);
            }
        }

        public void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        /* access modifiers changed from: 0000 */
        public void drain() {
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<T> aVar = this.queue;
                boolean z = this.delayError;
                Observer lVar = (Observer) this.actual.get();
                int i = 1;
                while (true) {
                    if (lVar != null) {
                        while (true) {
                            boolean z2 = this.done;
                            Object poll = aVar.poll();
                            boolean z3 = poll == null;
                            if (!checkTerminated(z2, z3, lVar, z)) {
                                if (z3) {
                                    break;
                                }
                                lVar.onNext(poll);
                            } else {
                                return;
                            }
                        }
                    }
                    i = addAndGet(-i);
                    if (i != 0) {
                        if (lVar == null) {
                            lVar = (Observer) this.actual.get();
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean checkTerminated(boolean z, boolean z2, Observer<? super T> lVar, boolean z3) {
            if (this.cancelled.get()) {
                this.queue.clear();
                this.parent.cancel(this.key);
                this.actual.lazySet(null);
                return true;
            }
            if (z) {
                if (!z3) {
                    Throwable th = this.error;
                    if (th != null) {
                        this.queue.clear();
                        this.actual.lazySet(null);
                        lVar.onError(th);
                        return true;
                    } else if (z2) {
                        this.actual.lazySet(null);
                        lVar.onComplete();
                        return true;
                    }
                } else if (z2) {
                    Throwable th2 = this.error;
                    this.actual.lazySet(null);
                    if (th2 != null) {
                        lVar.onError(th2);
                    } else {
                        lVar.onComplete();
                    }
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: a */
    public void mo19781a(Observer<? super GroupedObservable<K, V>> lVar) {
        ObservableSource kVar = this.f27515a;
        GroupByObserver groupByObserver = new GroupByObserver(lVar, this.f27508b, this.f27509c, this.f27510d, this.f27511e);
        kVar.subscribe(groupByObserver);
    }
}
