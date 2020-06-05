package p655io.reactivex.internal.operators.observable;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p655io.reactivex.ObservableSource;
import p655io.reactivex.Observer;
import p655io.reactivex.exceptions.Exceptions;
import p655io.reactivex.internal.disposables.DisposableHelper;
import p655io.reactivex.internal.p669a.ObjectHelper;
import p655io.reactivex.internal.p670b.QueueDisposable;
import p655io.reactivex.internal.p670b.SimplePlainQueue;
import p655io.reactivex.internal.p670b.SimpleQueue;
import p655io.reactivex.internal.queue.SpscArrayQueue;
import p655io.reactivex.internal.queue.SpscLinkedArrayQueue;
import p655io.reactivex.internal.util.AtomicThrowable;
import p655io.reactivex.internal.util.C8162d;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p664d.Function;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.observable.i */
public final class ObservableFlatMap<T, U> extends AbstractObservableWithUpstream<T, U> {
    /* renamed from: b */
    final Function<? super T, ? extends ObservableSource<? extends U>> f27550b;
    /* renamed from: c */
    final boolean f27551c;
    /* renamed from: d */
    final int f27552d;
    /* renamed from: e */
    final int f27553e;

    /* compiled from: ObservableFlatMap */
    /* renamed from: io.reactivex.internal.operators.observable.i$a */
    static final class C8129a<T, U> extends AtomicReference<Disposable> implements Observer<U> {
        private static final long serialVersionUID = -4606175640614850599L;
        volatile boolean done;
        int fusionMode;
        /* renamed from: id */
        final long f27554id;
        final C8130b<T, U> parent;
        volatile SimpleQueue<U> queue;

        C8129a(C8130b<T, U> bVar, long j) {
            this.f27554id = j;
            this.parent = bVar;
        }

        public void onSubscribe(Disposable bVar) {
            if (DisposableHelper.setOnce(this, bVar) && (bVar instanceof QueueDisposable)) {
                QueueDisposable aVar = (QueueDisposable) bVar;
                int requestFusion = aVar.requestFusion(7);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = aVar;
                    this.done = true;
                    this.parent.drain();
                } else if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = aVar;
                }
            }
        }

        public void onNext(U u) {
            if (this.fusionMode == 0) {
                this.parent.tryEmit(u, this);
            } else {
                this.parent.drain();
            }
        }

        public void onError(Throwable th) {
            if (this.parent.errors.addThrowable(th)) {
                if (!this.parent.delayErrors) {
                    this.parent.disposeAll();
                }
                this.done = true;
                this.parent.drain();
                return;
            }
            RxJavaPlugins.m34959a(th);
        }

        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }
    }

    /* compiled from: ObservableFlatMap */
    /* renamed from: io.reactivex.internal.operators.observable.i$b */
    static final class C8130b<T, U> extends AtomicInteger implements Disposable, Observer<T> {
        static final C8129a<?, ?>[] CANCELLED = new C8129a[0];
        static final C8129a<?, ?>[] EMPTY = new C8129a[0];
        private static final long serialVersionUID = -2117620485640801370L;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final Observer<? super U> downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        long lastId;
        int lastIndex;
        final Function<? super T, ? extends ObservableSource<? extends U>> mapper;
        final int maxConcurrency;
        final AtomicReference<C8129a<?, ?>[]> observers;
        volatile SimplePlainQueue<U> queue;
        Queue<ObservableSource<? extends U>> sources;
        long uniqueId;
        Disposable upstream;
        int wip;

        C8130b(Observer<? super U> lVar, Function<? super T, ? extends ObservableSource<? extends U>> hVar, boolean z, int i, int i2) {
            this.downstream = lVar;
            this.mapper = hVar;
            this.delayErrors = z;
            this.maxConcurrency = i;
            this.bufferSize = i2;
            if (i != Integer.MAX_VALUE) {
                this.sources = new ArrayDeque(i);
            }
            this.observers = new AtomicReference<>(EMPTY);
        }

        public void onSubscribe(Disposable bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (!this.done) {
                try {
                    ObservableSource kVar = (ObservableSource) ObjectHelper.m35048a(this.mapper.apply(t), "The mapper returned a null ObservableSource");
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        synchronized (this) {
                            if (this.wip == this.maxConcurrency) {
                                this.sources.offer(kVar);
                                return;
                            }
                            this.wip++;
                        }
                    }
                    subscribeInner(kVar);
                } catch (Throwable th) {
                    Exceptions.m34944b(th);
                    this.upstream.dispose();
                    onError(th);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void subscribeInner(ObservableSource<? extends U> kVar) {
            ObservableSource<? extends U> kVar2;
            while (kVar instanceof Callable) {
                if (tryEmitScalar((Callable) kVar) && this.maxConcurrency != Integer.MAX_VALUE) {
                    boolean z = false;
                    synchronized (this) {
                        kVar2 = (ObservableSource) this.sources.poll();
                        if (kVar2 == null) {
                            this.wip--;
                            z = true;
                        }
                    }
                    if (z) {
                        drain();
                        return;
                    }
                    kVar = kVar2;
                } else {
                    return;
                }
            }
            long j = this.uniqueId;
            this.uniqueId = 1 + j;
            C8129a aVar = new C8129a(this, j);
            if (addInner(aVar)) {
                kVar.subscribe(aVar);
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean addInner(C8129a<T, U> aVar) {
            C8129a<?, ?>[] aVarArr;
            C8129a[] aVarArr2;
            do {
                aVarArr = (C8129a[]) this.observers.get();
                if (aVarArr == CANCELLED) {
                    aVar.dispose();
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new C8129a[(length + 1)];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!this.observers.compareAndSet(aVarArr, aVarArr2));
            return true;
        }

        /* access modifiers changed from: 0000 */
        public void removeInner(C8129a<T, U> aVar) {
            C8129a<T, U>[] aVarArr;
            Object obj;
            do {
                aVarArr = (C8129a[]) this.observers.get();
                int length = aVarArr.length;
                if (length != 0) {
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
                            obj = EMPTY;
                        } else {
                            C8129a[] aVarArr2 = new C8129a[(length - 1)];
                            System.arraycopy(aVarArr, 0, aVarArr2, 0, i);
                            System.arraycopy(aVarArr, i + 1, aVarArr2, i, (length - i) - 1);
                            obj = aVarArr2;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.observers.compareAndSet(aVarArr, obj));
        }

        /* access modifiers changed from: 0000 */
        public boolean tryEmitScalar(Callable<? extends U> callable) {
            try {
                Object call = callable.call();
                if (call == null) {
                    return true;
                }
                if (get() != 0 || !compareAndSet(0, 1)) {
                    SimplePlainQueue<U> eVar = this.queue;
                    if (eVar == null) {
                        int i = this.maxConcurrency;
                        if (i == Integer.MAX_VALUE) {
                            eVar = new SpscLinkedArrayQueue<>(this.bufferSize);
                        } else {
                            eVar = new SpscArrayQueue<>(i);
                        }
                        this.queue = eVar;
                    }
                    if (!eVar.offer(call)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return true;
                    } else if (getAndIncrement() != 0) {
                        return false;
                    }
                } else {
                    this.downstream.onNext(call);
                    if (decrementAndGet() == 0) {
                        return true;
                    }
                }
                drainLoop();
                return true;
            } catch (Throwable th) {
                Exceptions.m34944b(th);
                this.errors.addThrowable(th);
                drain();
                return true;
            }
        }

        /* access modifiers changed from: 0000 */
        public void tryEmit(U u, C8129a<T, U> aVar) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                SimpleQueue fVar = aVar.queue;
                if (fVar == null) {
                    fVar = new SpscLinkedArrayQueue(this.bufferSize);
                    aVar.queue = fVar;
                }
                fVar.offer(u);
                if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                this.downstream.onNext(u);
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            drainLoop();
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.m34959a(th);
                return;
            }
            if (this.errors.addThrowable(th)) {
                this.done = true;
                drain();
            } else {
                RxJavaPlugins.m34959a(th);
            }
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                drain();
            }
        }

        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                if (disposeAll()) {
                    Throwable terminate = this.errors.terminate();
                    if (terminate != null && terminate != C8162d.f27691a) {
                        RxJavaPlugins.m34959a(terminate);
                    }
                }
            }
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        /* access modifiers changed from: 0000 */
        public void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x00b7, code lost:
            if (r12 != null) goto L_0x00a5;
     */
        public void drainLoop() {
            /*
            r14 = this;
            io.reactivex.l<? super U> r0 = r14.downstream
            r1 = 1
            r2 = 1
        L_0x0004:
            boolean r3 = r14.checkTerminate()
            if (r3 == 0) goto L_0x000b
            return
        L_0x000b:
            io.reactivex.internal.b.e<U> r3 = r14.queue
            if (r3 == 0) goto L_0x0023
        L_0x000f:
            boolean r4 = r14.checkTerminate()
            if (r4 == 0) goto L_0x0016
            return
        L_0x0016:
            java.lang.Object r4 = r3.poll()
            if (r4 != 0) goto L_0x001f
            if (r4 != 0) goto L_0x000f
            goto L_0x0023
        L_0x001f:
            r0.onNext(r4)
            goto L_0x000f
        L_0x0023:
            boolean r3 = r14.done
            io.reactivex.internal.b.e<U> r4 = r14.queue
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.i$a<?, ?>[]> r5 = r14.observers
            java.lang.Object r5 = r5.get()
            io.reactivex.internal.operators.observable.i$a[] r5 = (p655io.reactivex.internal.operators.observable.ObservableFlatMap.C8129a[]) r5
            int r6 = r5.length
            int r7 = r14.maxConcurrency
            r8 = 2147483647(0x7fffffff, float:NaN)
            r9 = 0
            if (r7 == r8) goto L_0x0044
            monitor-enter(r14)
            java.util.Queue<io.reactivex.k<? extends U>> r7 = r14.sources     // Catch:{ all -> 0x0041 }
            int r7 = r7.size()     // Catch:{ all -> 0x0041 }
            monitor-exit(r14)     // Catch:{ all -> 0x0041 }
            goto L_0x0045
        L_0x0041:
            r0 = move-exception
            monitor-exit(r14)     // Catch:{ all -> 0x0041 }
            throw r0
        L_0x0044:
            r7 = 0
        L_0x0045:
            if (r3 == 0) goto L_0x0067
            if (r4 == 0) goto L_0x004f
            boolean r3 = r4.isEmpty()
            if (r3 == 0) goto L_0x0067
        L_0x004f:
            if (r6 != 0) goto L_0x0067
            if (r7 != 0) goto L_0x0067
            io.reactivex.internal.util.AtomicThrowable r1 = r14.errors
            java.lang.Throwable r1 = r1.terminate()
            java.lang.Throwable r2 = p655io.reactivex.internal.util.C8162d.f27691a
            if (r1 == r2) goto L_0x0066
            if (r1 != 0) goto L_0x0063
            r0.onComplete()
            goto L_0x0066
        L_0x0063:
            r0.onError(r1)
        L_0x0066:
            return
        L_0x0067:
            if (r6 == 0) goto L_0x0106
            long r3 = r14.lastId
            int r7 = r14.lastIndex
            if (r6 <= r7) goto L_0x0077
            r10 = r5[r7]
            long r10 = r10.f27554id
            int r12 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r12 == 0) goto L_0x0098
        L_0x0077:
            if (r6 > r7) goto L_0x007a
            r7 = 0
        L_0x007a:
            r10 = r7
            r7 = 0
        L_0x007c:
            if (r7 >= r6) goto L_0x008f
            r11 = r5[r10]
            long r11 = r11.f27554id
            int r13 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r13 != 0) goto L_0x0087
            goto L_0x008f
        L_0x0087:
            int r10 = r10 + 1
            if (r10 != r6) goto L_0x008c
            r10 = 0
        L_0x008c:
            int r7 = r7 + 1
            goto L_0x007c
        L_0x008f:
            r14.lastIndex = r10
            r3 = r5[r10]
            long r3 = r3.f27554id
            r14.lastId = r3
            r7 = r10
        L_0x0098:
            r3 = 0
            r4 = 0
        L_0x009a:
            if (r3 >= r6) goto L_0x00fd
            boolean r10 = r14.checkTerminate()
            if (r10 == 0) goto L_0x00a3
            return
        L_0x00a3:
            r10 = r5[r7]
        L_0x00a5:
            boolean r11 = r14.checkTerminate()
            if (r11 == 0) goto L_0x00ac
            return
        L_0x00ac:
            io.reactivex.internal.b.f<U> r11 = r10.queue
            if (r11 != 0) goto L_0x00b1
            goto L_0x00b9
        L_0x00b1:
            java.lang.Object r12 = r11.poll()     // Catch:{ all -> 0x00e2 }
            if (r12 != 0) goto L_0x00d8
            if (r12 != 0) goto L_0x00a5
        L_0x00b9:
            boolean r11 = r10.done
            io.reactivex.internal.b.f<U> r12 = r10.queue
            if (r11 == 0) goto L_0x00d2
            if (r12 == 0) goto L_0x00c7
            boolean r11 = r12.isEmpty()
            if (r11 == 0) goto L_0x00d2
        L_0x00c7:
            r14.removeInner(r10)
            boolean r4 = r14.checkTerminate()
            if (r4 == 0) goto L_0x00d1
            return
        L_0x00d1:
            r4 = 1
        L_0x00d2:
            int r7 = r7 + 1
            if (r7 != r6) goto L_0x00fb
            r7 = 0
            goto L_0x00fb
        L_0x00d8:
            r0.onNext(r12)
            boolean r12 = r14.checkTerminate()
            if (r12 == 0) goto L_0x00b1
            return
        L_0x00e2:
            r4 = move-exception
            p655io.reactivex.exceptions.Exceptions.m34944b(r4)
            r10.dispose()
            io.reactivex.internal.util.AtomicThrowable r11 = r14.errors
            r11.addThrowable(r4)
            boolean r4 = r14.checkTerminate()
            if (r4 == 0) goto L_0x00f5
            return
        L_0x00f5:
            r14.removeInner(r10)
            int r3 = r3 + 1
            r4 = 1
        L_0x00fb:
            int r3 = r3 + r1
            goto L_0x009a
        L_0x00fd:
            r14.lastIndex = r7
            r3 = r5[r7]
            long r5 = r3.f27554id
            r14.lastId = r5
            goto L_0x0107
        L_0x0106:
            r4 = 0
        L_0x0107:
            if (r4 == 0) goto L_0x0129
            int r3 = r14.maxConcurrency
            if (r3 == r8) goto L_0x0004
            monitor-enter(r14)
            java.util.Queue<io.reactivex.k<? extends U>> r3 = r14.sources     // Catch:{ all -> 0x0126 }
            java.lang.Object r3 = r3.poll()     // Catch:{ all -> 0x0126 }
            io.reactivex.k r3 = (p655io.reactivex.ObservableSource) r3     // Catch:{ all -> 0x0126 }
            if (r3 != 0) goto L_0x0120
            int r3 = r14.wip     // Catch:{ all -> 0x0126 }
            int r3 = r3 - r1
            r14.wip = r3     // Catch:{ all -> 0x0126 }
            monitor-exit(r14)     // Catch:{ all -> 0x0126 }
            goto L_0x0004
        L_0x0120:
            monitor-exit(r14)     // Catch:{ all -> 0x0126 }
            r14.subscribeInner(r3)
            goto L_0x0004
        L_0x0126:
            r0 = move-exception
            monitor-exit(r14)     // Catch:{ all -> 0x0126 }
            throw r0
        L_0x0129:
            int r2 = -r2
            int r2 = r14.addAndGet(r2)
            if (r2 != 0) goto L_0x0004
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: p655io.reactivex.internal.operators.observable.ObservableFlatMap.C8130b.drainLoop():void");
        }

        /* access modifiers changed from: 0000 */
        public boolean checkTerminate() {
            if (this.cancelled) {
                return true;
            }
            Throwable th = (Throwable) this.errors.get();
            if (this.delayErrors || th == null) {
                return false;
            }
            disposeAll();
            Throwable terminate = this.errors.terminate();
            if (terminate != C8162d.f27691a) {
                this.downstream.onError(terminate);
            }
            return true;
        }

        /* access modifiers changed from: 0000 */
        public boolean disposeAll() {
            this.upstream.dispose();
            C8129a<?, ?>[] aVarArr = (C8129a[]) this.observers.get();
            C8129a<?, ?>[] aVarArr2 = CANCELLED;
            if (aVarArr != aVarArr2) {
                C8129a<?, ?>[] aVarArr3 = (C8129a[]) this.observers.getAndSet(aVarArr2);
                if (aVarArr3 != CANCELLED) {
                    for (C8129a<?, ?> dispose : aVarArr3) {
                        dispose.dispose();
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public ObservableFlatMap(ObservableSource<T> kVar, Function<? super T, ? extends ObservableSource<? extends U>> hVar, boolean z, int i, int i2) {
        super(kVar);
        this.f27550b = hVar;
        this.f27551c = z;
        this.f27552d = i;
        this.f27553e = i2;
    }

    /* renamed from: a */
    public void mo19781a(Observer<? super U> lVar) {
        if (!ObservableScalarXMap.m35080a(this.f27515a, lVar, this.f27550b)) {
            ObservableSource kVar = this.f27515a;
            C8130b bVar = new C8130b(lVar, this.f27550b, this.f27551c, this.f27552d, this.f27553e);
            kVar.subscribe(bVar);
        }
    }
}
