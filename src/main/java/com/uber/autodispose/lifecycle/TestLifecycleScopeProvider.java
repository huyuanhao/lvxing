package com.uber.autodispose.lifecycle;

import com.uber.autodispose.OutsideScopeException;
import p655io.reactivex.CompletableSource;
import p655io.reactivex.Observable;
import p655io.reactivex.p668h.BehaviorSubject;

public final class TestLifecycleScopeProvider implements LifecycleScopeProvider<TestLifecycle> {
    /* renamed from: b */
    private final BehaviorSubject<TestLifecycle> f25998b;

    /* renamed from: com.uber.autodispose.lifecycle.TestLifecycleScopeProvider$1 */
    static /* synthetic */ class C77091 {
        /* renamed from: a */
        static final /* synthetic */ int[] f25999a = new int[TestLifecycle.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
            com.uber.autodispose.lifecycle.TestLifecycleScopeProvider$TestLifecycle[] r0 = com.uber.autodispose.lifecycle.TestLifecycleScopeProvider.TestLifecycle.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f25999a = r0
            int[] r0 = f25999a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.uber.autodispose.lifecycle.TestLifecycleScopeProvider$TestLifecycle r1 = com.uber.autodispose.lifecycle.TestLifecycleScopeProvider.TestLifecycle.STARTED     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f25999a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.uber.autodispose.lifecycle.TestLifecycleScopeProvider$TestLifecycle r1 = com.uber.autodispose.lifecycle.TestLifecycleScopeProvider.TestLifecycle.STOPPED     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uber.autodispose.lifecycle.TestLifecycleScopeProvider.C77091.m53874clinit():void");
        }
    }

    /* renamed from: com.uber.autodispose.lifecycle.TestLifecycleScopeProvider$TestLifecycle */
    public enum TestLifecycle {
        STARTED,
        STOPPED
    }

    /* renamed from: a */
    public Observable<TestLifecycle> mo37367a() {
        return this.f25998b.mo38906e();
    }

    /* renamed from: b */
    public CorrespondingEventsFunction<TestLifecycle> mo37368b() {
        return C7705$$Lambda$TestLifecycleScopeProvider$0ZhdS2t4Mgnnc6DPJXBj5Qah_nI.INSTANCE;
    }

    /* access modifiers changed from: private|static|synthetic */
    /* renamed from: a */
    public static /* synthetic */ TestLifecycle m33094a(TestLifecycle testLifecycle) throws OutsideScopeException {
        int i = C77091.f25999a[testLifecycle.ordinal()];
        if (i == 1) {
            return TestLifecycle.STOPPED;
        }
        if (i != 2) {
            throw new IllegalStateException("Unknown lifecycle event.");
        }
        throw new LifecycleEndedException();
    }

    /* renamed from: c */
    public TestLifecycle mo37370d() {
        return (TestLifecycle) this.f25998b.mo38865b();
    }

    public CompletableSource requestScope() {
        return LifecycleScopes.m33102a(this);
    }
}
