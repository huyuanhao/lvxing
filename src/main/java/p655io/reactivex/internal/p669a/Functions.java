package p655io.reactivex.internal.p669a;

import java.util.Comparator;
import java.util.concurrent.Callable;
import org.p705b.Subscription;
import p655io.reactivex.exceptions.OnErrorNotImplementedException;
import p655io.reactivex.p664d.C8083a;
import p655io.reactivex.p664d.C8084j;
import p655io.reactivex.p664d.Consumer;
import p655io.reactivex.p664d.Function;
import p655io.reactivex.p664d.LongConsumer;
import p655io.reactivex.p666f.RxJavaPlugins;

/* renamed from: io.reactivex.internal.a.a */
public final class Functions {
    /* renamed from: a */
    static final Function<Object, Object> f27468a = new C8109i();
    /* renamed from: b */
    public static final Runnable f27469b = new C8106f();
    /* renamed from: c */
    public static final C8083a f27470c = new C8103c();
    /* renamed from: d */
    static final Consumer<Object> f27471d = new C8104d();
    /* renamed from: e */
    public static final Consumer<Throwable> f27472e = new C8107g();
    /* renamed from: f */
    public static final Consumer<Throwable> f27473f = new C8114n();
    /* renamed from: g */
    public static final LongConsumer f27474g = new C8105e();
    /* renamed from: h */
    static final C8084j<Object> f27475h = new C8115o();
    /* renamed from: i */
    static final C8084j<Object> f27476i = new C8108h();
    /* renamed from: j */
    static final Callable<Object> f27477j = new C8113m();
    /* renamed from: k */
    static final Comparator<Object> f27478k = new C8112l();
    /* renamed from: l */
    public static final Consumer<Subscription> f27479l = new C8111k();

    /* compiled from: Functions */
    /* renamed from: io.reactivex.internal.a.a$a */
    static final class C8101a<T, U> implements Function<T, U> {
        /* renamed from: a */
        final Class<U> f27480a;

        C8101a(Class<U> cls) {
            this.f27480a = cls;
        }

        public U apply(T t) throws Exception {
            return this.f27480a.cast(t);
        }
    }

    /* compiled from: Functions */
    /* renamed from: io.reactivex.internal.a.a$b */
    static final class C8102b<T, U> implements C8084j<T> {
        /* renamed from: a */
        final Class<U> f27481a;

        C8102b(Class<U> cls) {
            this.f27481a = cls;
        }

        public boolean test(T t) throws Exception {
            return this.f27481a.isInstance(t);
        }
    }

    /* compiled from: Functions */
    /* renamed from: io.reactivex.internal.a.a$c */
    static final class C8103c implements C8083a {
        /* renamed from: a */
        public void mo19849a() {
        }

        public String toString() {
            return "EmptyAction";
        }

        C8103c() {
        }
    }

    /* compiled from: Functions */
    /* renamed from: io.reactivex.internal.a.a$d */
    static final class C8104d implements Consumer<Object> {
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }

        C8104d() {
        }
    }

    /* compiled from: Functions */
    /* renamed from: io.reactivex.internal.a.a$e */
    static final class C8105e implements LongConsumer {
        C8105e() {
        }
    }

    /* compiled from: Functions */
    /* renamed from: io.reactivex.internal.a.a$f */
    static final class C8106f implements Runnable {
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }

        C8106f() {
        }
    }

    /* compiled from: Functions */
    /* renamed from: io.reactivex.internal.a.a$g */
    static final class C8107g implements Consumer<Throwable> {
        C8107g() {
        }

        /* renamed from: a */
        public void accept(Throwable th) {
            RxJavaPlugins.m34959a(th);
        }
    }

    /* compiled from: Functions */
    /* renamed from: io.reactivex.internal.a.a$h */
    static final class C8108h implements C8084j<Object> {
        public boolean test(Object obj) {
            return false;
        }

        C8108h() {
        }
    }

    /* compiled from: Functions */
    /* renamed from: io.reactivex.internal.a.a$i */
    static final class C8109i implements Function<Object, Object> {
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }

        C8109i() {
        }
    }

    /* compiled from: Functions */
    /* renamed from: io.reactivex.internal.a.a$j */
    static final class C8110j<T, U> implements Function<T, U>, Callable<U> {
        /* renamed from: a */
        final U f27482a;

        C8110j(U u) {
            this.f27482a = u;
        }

        public U call() throws Exception {
            return this.f27482a;
        }

        public U apply(T t) throws Exception {
            return this.f27482a;
        }
    }

    /* compiled from: Functions */
    /* renamed from: io.reactivex.internal.a.a$k */
    static final class C8111k implements Consumer<Subscription> {
        C8111k() {
        }

        /* renamed from: a */
        public void accept(Subscription cVar) throws Exception {
            cVar.request(Long.MAX_VALUE);
        }
    }

    /* compiled from: Functions */
    /* renamed from: io.reactivex.internal.a.a$l */
    static final class C8112l implements Comparator<Object> {
        C8112l() {
        }

        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* compiled from: Functions */
    /* renamed from: io.reactivex.internal.a.a$m */
    static final class C8113m implements Callable<Object> {
        public Object call() {
            return null;
        }

        C8113m() {
        }
    }

    /* compiled from: Functions */
    /* renamed from: io.reactivex.internal.a.a$n */
    static final class C8114n implements Consumer<Throwable> {
        C8114n() {
        }

        /* renamed from: a */
        public void accept(Throwable th) {
            RxJavaPlugins.m34959a((Throwable) new OnErrorNotImplementedException(th));
        }
    }

    /* compiled from: Functions */
    /* renamed from: io.reactivex.internal.a.a$o */
    static final class C8115o implements C8084j<Object> {
        public boolean test(Object obj) {
            return true;
        }

        C8115o() {
        }
    }

    /* renamed from: a */
    public static <T> Function<T, T> m35035a() {
        return f27468a;
    }

    /* renamed from: b */
    public static <T> Consumer<T> m35038b() {
        return f27471d;
    }

    /* renamed from: a */
    public static <T> Callable<T> m35037a(T t) {
        return new C8110j(t);
    }

    /* renamed from: b */
    public static <T, U> Function<T, U> m35039b(U u) {
        return new C8110j(u);
    }

    /* renamed from: a */
    public static <T, U> Function<T, U> m35036a(Class<U> cls) {
        return new C8101a(cls);
    }

    /* renamed from: b */
    public static <T, U> C8084j<T> m35040b(Class<U> cls) {
        return new C8102b(cls);
    }
}
