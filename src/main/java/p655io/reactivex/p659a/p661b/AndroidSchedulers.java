package p655io.reactivex.p659a.p661b;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import p655io.reactivex.Scheduler;
import p655io.reactivex.p659a.p660a.RxAndroidPlugins;

/* renamed from: io.reactivex.a.b.a */
public final class AndroidSchedulers {
    /* renamed from: a */
    private static final Scheduler f27398a = RxAndroidPlugins.m34916a((Callable<Scheduler>) new Callable<Scheduler>() {
        /* renamed from: a */
        public Scheduler call() throws Exception {
            return C8080a.f27399a;
        }
    });

    /* compiled from: AndroidSchedulers */
    /* renamed from: io.reactivex.a.b.a$a */
    private static final class C8080a {
        /* renamed from: a */
        static final Scheduler f27399a = new HandlerScheduler(new Handler(Looper.getMainLooper()), false);
    }

    /* renamed from: a */
    public static Scheduler m34919a() {
        return RxAndroidPlugins.m34915a(f27398a);
    }
}
