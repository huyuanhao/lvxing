package p655io.reactivex.internal.operators.observable;

import p655io.reactivex.ObservableSource;
import p655io.reactivex.Observer;
import p655io.reactivex.Scheduler;
import p655io.reactivex.Scheduler.C8167c;
import p655io.reactivex.exceptions.Exceptions;
import p655io.reactivex.internal.disposables.DisposableHelper;
import p655io.reactivex.internal.observers.BasicIntQueueDisposable;
import p655io.reactivex.internal.p670b.QueueDisposable;
import p655io.reactivex.internal.p670b.SimpleQueue;
import p655io.reactivex.internal.queue.SpscLinkedArrayQueue;
import p655io.reactivex.internal.schedulers.TrampolineScheduler;
import p655io.reactivex.p662b.Disposable;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.observable.p */
public final class ObservableObserveOn<T> extends AbstractObservableWithUpstream<T, T> {
    /* renamed from: b */
    final Scheduler f27573b;
    /* renamed from: c */
    final boolean f27574c;
    /* renamed from: d */
    final int f27575d;

    /* compiled from: ObservableObserveOn */
    /* renamed from: io.reactivex.internal.operators.observable.p$a */
    static final class C8136a<T> extends BasicIntQueueDisposable<T> implements Observer<T>, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;
        final int bufferSize;
        final boolean delayError;
        volatile boolean disposed;
        volatile boolean done;
        final Observer<? super T> downstream;
        Throwable error;
        boolean outputFused;
        SimpleQueue<T> queue;
        int sourceMode;
        Disposable upstream;
        final C8167c worker;

        C8136a(Observer<? super T> lVar, C8167c cVar, boolean z, int i) {
            this.downstream = lVar;
            this.worker = cVar;
            this.delayError = z;
            this.bufferSize = i;
        }

        public void onSubscribe(Disposable bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                if (bVar instanceof QueueDisposable) {
                    QueueDisposable aVar = (QueueDisposable) bVar;
                    int requestFusion = aVar.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = aVar;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        schedule();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = aVar;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new SpscLinkedArrayQueue(this.bufferSize);
                this.downstream.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (!this.done) {
                if (this.sourceMode != 2) {
                    this.queue.offer(t);
                }
                schedule();
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.m34959a(th);
                return;
            }
            this.error = th;
            this.done = true;
            schedule();
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                schedule();
            }
        }

        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.upstream.dispose();
                this.worker.dispose();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        public boolean isDisposed() {
            return this.disposed;
        }

        /* access modifiers changed from: 0000 */
        public void schedule() {
            if (getAndIncrement() == 0) {
                this.worker.mo39043a((Runnable) this);
            }
        }

        /* access modifiers changed from: 0000 */
        public void drainNormal() {
            SimpleQueue<T> fVar = this.queue;
            Observer<? super T> lVar = this.downstream;
            int i = 1;
            while (!checkTerminated(this.done, fVar.isEmpty(), lVar)) {
                while (true) {
                    boolean z = this.done;
                    try {
                        Object poll = fVar.poll();
                        boolean z2 = poll == null;
                        if (!checkTerminated(z, z2, lVar)) {
                            if (z2) {
                                i = addAndGet(-i);
                                if (i == 0) {
                                    return;
                                }
                            } else {
                                lVar.onNext(poll);
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.m34944b(th);
                        this.disposed = true;
                        this.upstream.dispose();
                        fVar.clear();
                        lVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void drainFused() {
            int i = 1;
            while (!this.disposed) {
                boolean z = this.done;
                Throwable th = this.error;
                if (this.delayError || !z || th == null) {
                    this.downstream.onNext(null);
                    if (z) {
                        this.disposed = true;
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            this.downstream.onError(th2);
                        } else {
                            this.downstream.onComplete();
                        }
                        this.worker.dispose();
                        return;
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    this.disposed = true;
                    this.downstream.onError(th);
                    this.worker.dispose();
                    return;
                }
            }
        }

        public void run() {
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean checkTerminated(boolean z, boolean z2, Observer<? super T> lVar) {
            if (this.disposed) {
                this.queue.clear();
                return true;
            }
            if (z) {
                Throwable th = this.error;
                if (this.delayError) {
                    if (z2) {
                        this.disposed = true;
                        if (th != null) {
                            lVar.onError(th);
                        } else {
                            lVar.onComplete();
                        }
                        this.worker.dispose();
                        return true;
                    }
                } else if (th != null) {
                    this.disposed = true;
                    this.queue.clear();
                    lVar.onError(th);
                    this.worker.dispose();
                    return true;
                } else if (z2) {
                    this.disposed = true;
                    lVar.onComplete();
                    this.worker.dispose();
                    return true;
                }
            }
            return false;
        }

        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        public T poll() throws Exception {
            return this.queue.poll();
        }

        public void clear() {
            this.queue.clear();
        }

        public boolean isEmpty() {
            return this.queue.isEmpty();
        }
    }

    public ObservableObserveOn(ObservableSource<T> kVar, Scheduler mVar, boolean z, int i) {
        super(kVar);
        this.f27573b = mVar;
        this.f27574c = z;
        this.f27575d = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo19781a(Observer<? super T> lVar) {
        Scheduler mVar = this.f27573b;
        if (mVar instanceof TrampolineScheduler) {
            this.f27515a.subscribe(lVar);
            return;
        }
        this.f27515a.subscribe(new C8136a(lVar, mVar.mo38822a(), this.f27574c, this.f27575d));
    }
}
