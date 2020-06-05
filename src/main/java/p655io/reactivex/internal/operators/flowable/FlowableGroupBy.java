package p655io.reactivex.internal.operators.flowable;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.p705b.Publisher;
import org.p705b.Subscriber;
import org.p705b.Subscription;
import p655io.reactivex.C8085e;
import p655io.reactivex.exceptions.Exceptions;
import p655io.reactivex.internal.p669a.ObjectHelper;
import p655io.reactivex.internal.queue.SpscLinkedArrayQueue;
import p655io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import p655io.reactivex.internal.subscriptions.EmptySubscription;
import p655io.reactivex.internal.subscriptions.SubscriptionHelper;
import p655io.reactivex.internal.util.BackpressureHelper;
import p655io.reactivex.p663c.GroupedFlowable;
import p655io.reactivex.p664d.Function;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableGroupBy */
public final class FlowableGroupBy<T, K, V> extends AbstractFlowableWithUpstream<T, GroupedFlowable<K, V>> {

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableGroupBy$GroupBySubscriber */
    public static final class GroupBySubscriber<T, K, V> extends BasicIntQueueSubscription<GroupedFlowable<K, V>> implements C8085e<T> {
        static final Object NULL_KEY = new Object();
        private static final long serialVersionUID = -3688291656102519502L;
        final int bufferSize;
        final AtomicBoolean cancelled = new AtomicBoolean();
        final boolean delayError;
        boolean done;
        final Subscriber<? super GroupedFlowable<K, V>> downstream;
        Throwable error;
        final Queue<C8117a<K, V>> evictedGroups;
        volatile boolean finished;
        final AtomicInteger groupCount = new AtomicInteger(1);
        final Map<Object, C8117a<K, V>> groups;
        final Function<? super T, ? extends K> keySelector;
        boolean outputFused;
        final SpscLinkedArrayQueue<GroupedFlowable<K, V>> queue;
        final AtomicLong requested = new AtomicLong();
        Subscription upstream;
        final Function<? super T, ? extends V> valueSelector;

        public GroupBySubscriber(Subscriber<? super GroupedFlowable<K, V>> bVar, Function<? super T, ? extends K> hVar, Function<? super T, ? extends V> hVar2, int i, boolean z, Map<Object, C8117a<K, V>> map, Queue<C8117a<K, V>> queue2) {
            this.downstream = bVar;
            this.keySelector = hVar;
            this.valueSelector = hVar2;
            this.bufferSize = i;
            this.delayError = z;
            this.groups = map;
            this.evictedGroups = queue2;
            this.queue = new SpscLinkedArrayQueue<>(i);
        }

        public void onSubscribe(Subscription cVar) {
            if (SubscriptionHelper.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
                cVar.request((long) this.bufferSize);
            }
        }

        public void onNext(T t) {
            Object obj;
            if (!this.done) {
                SpscLinkedArrayQueue<GroupedFlowable<K, V>> aVar = this.queue;
                try {
                    Object apply = this.keySelector.apply(t);
                    boolean z = false;
                    if (apply != null) {
                        obj = apply;
                    } else {
                        obj = NULL_KEY;
                    }
                    C8117a aVar2 = (C8117a) this.groups.get(obj);
                    if (aVar2 == null) {
                        if (!this.cancelled.get()) {
                            aVar2 = C8117a.m35069a(apply, this.bufferSize, this, this.delayError);
                            this.groups.put(obj, aVar2);
                            this.groupCount.getAndIncrement();
                            z = true;
                        } else {
                            return;
                        }
                    }
                    try {
                        aVar2.mo38972a(ObjectHelper.m35048a(this.valueSelector.apply(t), "The valueSelector returned null"));
                        completeEvictions();
                        if (z) {
                            aVar.offer(aVar2);
                            drain();
                        }
                    } catch (Throwable th) {
                        Exceptions.m34944b(th);
                        this.upstream.cancel();
                        onError(th);
                    }
                } catch (Throwable th2) {
                    Exceptions.m34944b(th2);
                    this.upstream.cancel();
                    onError(th2);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.m34959a(th);
                return;
            }
            this.done = true;
            for (C8117a a : this.groups.values()) {
                a.mo38973a(th);
            }
            this.groups.clear();
            Queue<C8117a<K, V>> queue2 = this.evictedGroups;
            if (queue2 != null) {
                queue2.clear();
            }
            this.error = th;
            this.finished = true;
            drain();
        }

        public void onComplete() {
            if (!this.done) {
                for (C8117a e : this.groups.values()) {
                    e.mo38974e();
                }
                this.groups.clear();
                Queue<C8117a<K, V>> queue2 = this.evictedGroups;
                if (queue2 != null) {
                    queue2.clear();
                }
                this.done = true;
                this.finished = true;
                drain();
            }
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.m35177a(this.requested, j);
                drain();
            }
        }

        public void cancel() {
            if (this.cancelled.compareAndSet(false, true)) {
                completeEvictions();
                if (this.groupCount.decrementAndGet() == 0) {
                    this.upstream.cancel();
                }
            }
        }

        private void completeEvictions() {
            if (this.evictedGroups != null) {
                int i = 0;
                while (true) {
                    C8117a aVar = (C8117a) this.evictedGroups.poll();
                    if (aVar == null) {
                        break;
                    }
                    aVar.mo38974e();
                    i++;
                }
                if (i != 0) {
                    this.groupCount.addAndGet(-i);
                }
            }
        }

        public void cancel(K k) {
            if (k == null) {
                k = NULL_KEY;
            }
            this.groups.remove(k);
            if (this.groupCount.decrementAndGet() == 0) {
                this.upstream.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void drain() {
            if (getAndIncrement() == 0) {
                if (this.outputFused) {
                    drainFused();
                } else {
                    drainNormal();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void drainFused() {
            SpscLinkedArrayQueue<GroupedFlowable<K, V>> aVar = this.queue;
            Subscriber<? super GroupedFlowable<K, V>> bVar = this.downstream;
            int i = 1;
            while (!this.cancelled.get()) {
                boolean z = this.finished;
                if (z && !this.delayError) {
                    Throwable th = this.error;
                    if (th != null) {
                        aVar.clear();
                        bVar.onError(th);
                        return;
                    }
                }
                bVar.onNext(null);
                if (z) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        bVar.onError(th2);
                    } else {
                        bVar.onComplete();
                    }
                    return;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
            aVar.clear();
        }

        /* access modifiers changed from: 0000 */
        public void drainNormal() {
            int i;
            SpscLinkedArrayQueue<GroupedFlowable<K, V>> aVar = this.queue;
            Subscriber<? super GroupedFlowable<K, V>> bVar = this.downstream;
            int i2 = 1;
            do {
                long j = this.requested.get();
                long j2 = 0;
                while (true) {
                    i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                    if (i == 0) {
                        break;
                    }
                    boolean z = this.finished;
                    GroupedFlowable aVar2 = (GroupedFlowable) aVar.poll();
                    boolean z2 = aVar2 == null;
                    if (!checkTerminated(z, z2, bVar, aVar)) {
                        if (z2) {
                            break;
                        }
                        bVar.onNext(aVar2);
                        j2++;
                    } else {
                        return;
                    }
                }
                if (i != 0 || !checkTerminated(this.finished, aVar.isEmpty(), bVar, aVar)) {
                    if (j2 != 0) {
                        if (j != Long.MAX_VALUE) {
                            this.requested.addAndGet(-j2);
                        }
                        this.upstream.request(j2);
                    }
                    i2 = addAndGet(-i2);
                } else {
                    return;
                }
            } while (i2 != 0);
        }

        /* access modifiers changed from: 0000 */
        public boolean checkTerminated(boolean z, boolean z2, Subscriber<?> bVar, SpscLinkedArrayQueue<?> aVar) {
            if (this.cancelled.get()) {
                aVar.clear();
                return true;
            }
            if (this.delayError) {
                if (z && z2) {
                    Throwable th = this.error;
                    if (th != null) {
                        bVar.onError(th);
                    } else {
                        bVar.onComplete();
                    }
                    return true;
                }
            } else if (z) {
                Throwable th2 = this.error;
                if (th2 != null) {
                    aVar.clear();
                    bVar.onError(th2);
                    return true;
                } else if (z2) {
                    bVar.onComplete();
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

        public GroupedFlowable<K, V> poll() {
            return (GroupedFlowable) this.queue.poll();
        }

        public void clear() {
            this.queue.clear();
        }

        public boolean isEmpty() {
            return this.queue.isEmpty();
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableGroupBy$a */
    static final class C8117a<K, T> extends GroupedFlowable<K, T> {
        /* renamed from: c */
        final C8118b<T, K> f27499c;

        /* renamed from: a */
        public static <T, K> C8117a<K, T> m35069a(K k, int i, GroupBySubscriber<?, K, T> groupBySubscriber, boolean z) {
            return new C8117a<>(k, new C8118b(i, groupBySubscriber, k, z));
        }

        protected C8117a(K k, C8118b<T, K> bVar) {
            super(k);
            this.f27499c = bVar;
        }

        /* renamed from: a */
        public void mo38972a(T t) {
            this.f27499c.onNext(t);
        }

        /* renamed from: a */
        public void mo38973a(Throwable th) {
            this.f27499c.onError(th);
        }

        /* renamed from: e */
        public void mo38974e() {
            this.f27499c.onComplete();
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableGroupBy$b */
    static final class C8118b<T, K> extends BasicIntQueueSubscription<T> implements Publisher<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        final AtomicReference<Subscriber<? super T>> actual = new AtomicReference<>();
        final AtomicBoolean cancelled = new AtomicBoolean();
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final K key;
        final AtomicBoolean once = new AtomicBoolean();
        boolean outputFused;
        final GroupBySubscriber<?, K, T> parent;
        int produced;
        final SpscLinkedArrayQueue<T> queue;
        final AtomicLong requested = new AtomicLong();

        C8118b(int i, GroupBySubscriber<?, K, T> groupBySubscriber, K k, boolean z) {
            this.queue = new SpscLinkedArrayQueue<>(i);
            this.parent = groupBySubscriber;
            this.key = k;
            this.delayError = z;
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.m35177a(this.requested, j);
                drain();
            }
        }

        public void cancel() {
            if (this.cancelled.compareAndSet(false, true)) {
                this.parent.cancel(this.key);
            }
        }

        public void subscribe(Subscriber<? super T> bVar) {
            if (this.once.compareAndSet(false, true)) {
                bVar.onSubscribe(this);
                this.actual.lazySet(bVar);
                drain();
                return;
            }
            EmptySubscription.error(new IllegalStateException("Only one Subscriber allowed!"), bVar);
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
                if (this.outputFused) {
                    drainFused();
                } else {
                    drainNormal();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void drainFused() {
            SpscLinkedArrayQueue<T> aVar = this.queue;
            Subscriber bVar = (Subscriber) this.actual.get();
            int i = 1;
            while (true) {
                if (bVar != null) {
                    if (this.cancelled.get()) {
                        aVar.clear();
                        return;
                    }
                    boolean z = this.done;
                    if (z && !this.delayError) {
                        Throwable th = this.error;
                        if (th != null) {
                            aVar.clear();
                            bVar.onError(th);
                            return;
                        }
                    }
                    bVar.onNext(null);
                    if (z) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            bVar.onError(th2);
                        } else {
                            bVar.onComplete();
                        }
                        return;
                    }
                }
                i = addAndGet(-i);
                if (i != 0) {
                    if (bVar == null) {
                        bVar = (Subscriber) this.actual.get();
                    }
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void drainNormal() {
            int i;
            SpscLinkedArrayQueue<T> aVar = this.queue;
            boolean z = this.delayError;
            Subscriber bVar = (Subscriber) this.actual.get();
            int i2 = 1;
            while (true) {
                if (bVar != null) {
                    long j = this.requested.get();
                    long j2 = 0;
                    while (true) {
                        i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i == 0) {
                            break;
                        }
                        boolean z2 = this.done;
                        Object poll = aVar.poll();
                        boolean z3 = poll == null;
                        if (!checkTerminated(z2, z3, bVar, z)) {
                            if (z3) {
                                break;
                            }
                            bVar.onNext(poll);
                            j2++;
                        } else {
                            return;
                        }
                    }
                    if (i == 0 && checkTerminated(this.done, aVar.isEmpty(), bVar, z)) {
                        return;
                    }
                    if (j2 != 0) {
                        if (j != Long.MAX_VALUE) {
                            this.requested.addAndGet(-j2);
                        }
                        this.parent.upstream.request(j2);
                    }
                }
                i2 = addAndGet(-i2);
                if (i2 != 0) {
                    if (bVar == null) {
                        bVar = (Subscriber) this.actual.get();
                    }
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean checkTerminated(boolean z, boolean z2, Subscriber<? super T> bVar, boolean z3) {
            if (this.cancelled.get()) {
                this.queue.clear();
                return true;
            }
            if (z) {
                if (!z3) {
                    Throwable th = this.error;
                    if (th != null) {
                        this.queue.clear();
                        bVar.onError(th);
                        return true;
                    } else if (z2) {
                        bVar.onComplete();
                        return true;
                    }
                } else if (z2) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        bVar.onError(th2);
                    } else {
                        bVar.onComplete();
                    }
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

        public T poll() {
            T poll = this.queue.poll();
            if (poll != null) {
                this.produced++;
                return poll;
            }
            int i = this.produced;
            if (i != 0) {
                this.produced = 0;
                this.parent.upstream.request((long) i);
            }
            return null;
        }

        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        public void clear() {
            this.queue.clear();
        }
    }
}
