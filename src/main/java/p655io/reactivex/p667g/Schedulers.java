package p655io.reactivex.p667g;

import java.util.concurrent.Callable;
import p655io.reactivex.Scheduler;
import p655io.reactivex.internal.schedulers.ComputationScheduler;
import p655io.reactivex.internal.schedulers.IoScheduler;
import p655io.reactivex.internal.schedulers.NewThreadScheduler;
import p655io.reactivex.internal.schedulers.SingleScheduler;
import p655io.reactivex.internal.schedulers.TrampolineScheduler;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: io.reactivex.g.a */
public final class Schedulers {
    /* renamed from: a */
    static final Scheduler f27432a = RxJavaPlugins.m34965d(new C8097h());
    /* renamed from: b */
    static final Scheduler f27433b = RxJavaPlugins.m34953a((Callable<Scheduler>) new C8091b<Scheduler>());
    /* renamed from: c */
    static final Scheduler f27434c = RxJavaPlugins.m34961b((Callable<Scheduler>) new C8092c<Scheduler>());
    /* renamed from: d */
    static final Scheduler f27435d = TrampolineScheduler.m35160c();
    /* renamed from: e */
    static final Scheduler f27436e = RxJavaPlugins.m34963c((Callable<Scheduler>) new C8095f<Scheduler>());

    /* compiled from: Schedulers */
    /* renamed from: io.reactivex.g.a$a */
    static final class C8090a {
        /* renamed from: a */
        static final Scheduler f27437a = new ComputationScheduler();
    }

    /* compiled from: Schedulers */
    /* renamed from: io.reactivex.g.a$b */
    static final class C8091b implements Callable<Scheduler> {
        C8091b() {
        }

        /* renamed from: a */
        public Scheduler call() throws Exception {
            return C8090a.f27437a;
        }
    }

    /* compiled from: Schedulers */
    /* renamed from: io.reactivex.g.a$c */
    static final class C8092c implements Callable<Scheduler> {
        C8092c() {
        }

        /* renamed from: a */
        public Scheduler call() throws Exception {
            return C8093d.f27438a;
        }
    }

    /* compiled from: Schedulers */
    /* renamed from: io.reactivex.g.a$d */
    static final class C8093d {
        /* renamed from: a */
        static final Scheduler f27438a = new IoScheduler();
    }

    /* compiled from: Schedulers */
    /* renamed from: io.reactivex.g.a$e */
    static final class C8094e {
        /* renamed from: a */
        static final Scheduler f27439a = new NewThreadScheduler();
    }

    /* compiled from: Schedulers */
    /* renamed from: io.reactivex.g.a$f */
    static final class C8095f implements Callable<Scheduler> {
        C8095f() {
        }

        /* renamed from: a */
        public Scheduler call() throws Exception {
            return C8094e.f27439a;
        }
    }

    /* compiled from: Schedulers */
    /* renamed from: io.reactivex.g.a$g */
    static final class C8096g {
        /* renamed from: a */
        static final Scheduler f27440a = new SingleScheduler();
    }

    /* compiled from: Schedulers */
    /* renamed from: io.reactivex.g.a$h */
    static final class C8097h implements Callable<Scheduler> {
        C8097h() {
        }

        /* renamed from: a */
        public Scheduler call() throws Exception {
            return C8096g.f27440a;
        }
    }

    /* renamed from: a */
    public static Scheduler m34967a() {
        return RxJavaPlugins.m34952a(f27433b);
    }

    /* renamed from: b */
    public static Scheduler m34968b() {
        return RxJavaPlugins.m34960b(f27434c);
    }
}
