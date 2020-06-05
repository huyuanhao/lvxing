package com.uber.autodispose.android.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleOwner;
import com.uber.autodispose.OutsideScopeException;
import com.uber.autodispose.lifecycle.CorrespondingEventsFunction;
import com.uber.autodispose.lifecycle.LifecycleEndedException;
import com.uber.autodispose.lifecycle.LifecycleScopeProvider;
import com.uber.autodispose.lifecycle.LifecycleScopes;
import p655io.reactivex.CompletableSource;
import p655io.reactivex.Observable;

/* renamed from: com.uber.autodispose.android.lifecycle.a */
public final class AndroidLifecycleScopeProvider implements LifecycleScopeProvider<Event> {
    /* renamed from: b */
    private static final CorrespondingEventsFunction<Event> f25983b = C7697$$Lambda$a$wb3rKFKCdHDkYj7OntrQuNosbwA.INSTANCE;
    /* renamed from: c */
    private final CorrespondingEventsFunction<Event> f25984c;
    /* renamed from: d */
    private final LifecycleEventsObservable f25985d;

    /* compiled from: AndroidLifecycleScopeProvider */
    /* renamed from: com.uber.autodispose.android.lifecycle.a$1 */
    static /* synthetic */ class C76991 {
        /* renamed from: a */
        static final /* synthetic */ int[] f25986a = new int[Event.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|(3:11|12|14)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
            androidx.lifecycle.Lifecycle$Event[] r0 = androidx.lifecycle.Lifecycle.Event.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f25986a = r0
            int[] r0 = f25986a     // Catch:{ NoSuchFieldError -> 0x0014 }
            androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_CREATE     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f25986a     // Catch:{ NoSuchFieldError -> 0x001f }
            androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_START     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = f25986a     // Catch:{ NoSuchFieldError -> 0x002a }
            androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_RESUME     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            int[] r0 = f25986a     // Catch:{ NoSuchFieldError -> 0x0035 }
            androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_PAUSE     // Catch:{ NoSuchFieldError -> 0x0035 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            int[] r0 = f25986a     // Catch:{ NoSuchFieldError -> 0x0040 }
            androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_STOP     // Catch:{ NoSuchFieldError -> 0x0040 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
            r2 = 5
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            int[] r0 = f25986a     // Catch:{ NoSuchFieldError -> 0x004b }
            androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_DESTROY     // Catch:{ NoSuchFieldError -> 0x004b }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
            r2 = 6
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004b }
        L_0x004b:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider.C76991.m53853clinit():void");
        }
    }

    /* compiled from: AndroidLifecycleScopeProvider */
    /* renamed from: com.uber.autodispose.android.lifecycle.a$a */
    private static class C7700a implements CorrespondingEventsFunction<Event> {
        /* renamed from: a */
        private final Event f25987a;

        C7700a(Event event) {
            this.f25987a = event;
        }

        /* renamed from: a */
        public Event apply(Event event) throws OutsideScopeException {
            return this.f25987a;
        }
    }

    /* access modifiers changed from: private|static|synthetic */
    /* renamed from: a */
    public static /* synthetic */ Event m33066a(Event event) throws OutsideScopeException {
        int i = C76991.f25986a[event.ordinal()];
        if (i == 1) {
            return Event.ON_DESTROY;
        }
        if (i == 2) {
            return Event.ON_STOP;
        }
        if (i == 3) {
            return Event.ON_PAUSE;
        }
        if (i == 4) {
            return Event.ON_STOP;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Lifecycle has ended! Last event was ");
        sb.append(event);
        throw new LifecycleEndedException(sb.toString());
    }

    /* renamed from: a */
    public static AndroidLifecycleScopeProvider m33069a(LifecycleOwner lifecycleOwner, Event event) {
        return m33067a(lifecycleOwner.getLifecycle(), event);
    }

    /* renamed from: a */
    public static AndroidLifecycleScopeProvider m33067a(Lifecycle lifecycle, Event event) {
        return m33068a(lifecycle, (CorrespondingEventsFunction<Event>) new C7700a<Event>(event));
    }

    /* renamed from: a */
    public static AndroidLifecycleScopeProvider m33068a(Lifecycle lifecycle, CorrespondingEventsFunction<Event> aVar) {
        return new AndroidLifecycleScopeProvider(lifecycle, aVar);
    }

    private AndroidLifecycleScopeProvider(Lifecycle lifecycle, CorrespondingEventsFunction<Event> aVar) {
        this.f25985d = new LifecycleEventsObservable(lifecycle);
        this.f25984c = aVar;
    }

    /* renamed from: a */
    public Observable<Event> mo37367a() {
        return this.f25985d;
    }

    /* renamed from: b */
    public CorrespondingEventsFunction<Event> mo37368b() {
        return this.f25984c;
    }

    /* renamed from: c */
    public Event mo37370d() {
        this.f25985d.mo37365b();
        return this.f25985d.mo37364a();
    }

    public CompletableSource requestScope() {
        return LifecycleScopes.m33102a(this);
    }
}
