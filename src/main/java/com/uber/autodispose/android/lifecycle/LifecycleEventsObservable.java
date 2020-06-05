package com.uber.autodispose.android.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.uber.autodispose.android.p619a.AutoDisposeAndroidUtil;
import com.uber.autodispose.android.p619a.MainThreadDisposable;
import p655io.reactivex.Observable;
import p655io.reactivex.Observer;
import p655io.reactivex.p668h.BehaviorSubject;

class LifecycleEventsObservable extends Observable<Event> {
    /* renamed from: a */
    private final Lifecycle f25976a;
    /* renamed from: b */
    private final BehaviorSubject<Event> f25977b = BehaviorSubject.m34973a();

    /* renamed from: com.uber.autodispose.android.lifecycle.LifecycleEventsObservable$1 */
    static /* synthetic */ class C76981 {
        /* renamed from: a */
        static final /* synthetic */ int[] f25978a = new int[State.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
            androidx.lifecycle.Lifecycle$State[] r0 = androidx.lifecycle.Lifecycle.State.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f25978a = r0
            int[] r0 = f25978a     // Catch:{ NoSuchFieldError -> 0x0014 }
            androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f25978a     // Catch:{ NoSuchFieldError -> 0x001f }
            androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.CREATED     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = f25978a     // Catch:{ NoSuchFieldError -> 0x002a }
            androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.STARTED     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            int[] r0 = f25978a     // Catch:{ NoSuchFieldError -> 0x0035 }
            androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.RESUMED     // Catch:{ NoSuchFieldError -> 0x0035 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            int[] r0 = f25978a     // Catch:{ NoSuchFieldError -> 0x0040 }
            androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.DESTROYED     // Catch:{ NoSuchFieldError -> 0x0040 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
            r2 = 5
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uber.autodispose.android.lifecycle.LifecycleEventsObservable.C76981.m53848clinit():void");
        }
    }

    /* renamed from: com.uber.autodispose.android.lifecycle.LifecycleEventsObservable$ArchLifecycleObserver */
    static final class ArchLifecycleObserver extends MainThreadDisposable implements LifecycleObserver {
        /* renamed from: a */
        private final Lifecycle f25979a;
        /* renamed from: b */
        private final Observer<? super Event> f25980b;
        /* renamed from: c */
        private final BehaviorSubject<Event> f25981c;

        ArchLifecycleObserver(Lifecycle lifecycle, Observer<? super Event> lVar, BehaviorSubject<Event> aVar) {
            this.f25979a = lifecycle;
            this.f25980b = lVar;
            this.f25981c = aVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo37361a() {
            this.f25979a.removeObserver(this);
        }

        /* access modifiers changed from: 0000 */
        @OnLifecycleEvent(Event.ON_ANY)
        public void onStateChange(LifecycleOwner lifecycleOwner, Event event) {
            if (!isDisposed()) {
                if (!(event == Event.ON_CREATE && this.f25981c.mo38865b() == event)) {
                    this.f25981c.onNext(event);
                }
                this.f25980b.onNext(event);
            }
        }
    }

    LifecycleEventsObservable(Lifecycle lifecycle) {
        this.f25976a = lifecycle;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Event mo37364a() {
        return (Event) this.f25977b.mo38865b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo37365b() {
        Event event;
        int i = C76981.f25978a[this.f25976a.getCurrentState().ordinal()];
        if (i == 1) {
            event = Event.ON_CREATE;
        } else if (i == 2) {
            event = Event.ON_START;
        } else if (i == 3 || i == 4) {
            event = Event.ON_RESUME;
        } else {
            event = Event.ON_DESTROY;
        }
        this.f25977b.onNext(event);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo19781a(Observer<? super Event> lVar) {
        ArchLifecycleObserver archLifecycleObserver = new ArchLifecycleObserver(this.f25976a, lVar, this.f25977b);
        lVar.onSubscribe(archLifecycleObserver);
        if (!AutoDisposeAndroidUtil.m33058a()) {
            lVar.onError(new IllegalStateException("Lifecycles can only be bound to on the main thread!"));
            return;
        }
        this.f25976a.addObserver(archLifecycleObserver);
        if (archLifecycleObserver.isDisposed()) {
            this.f25976a.removeObserver(archLifecycleObserver);
        }
    }
}
