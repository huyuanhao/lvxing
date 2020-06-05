package retrofit2.adapter.rxjava2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import p655io.reactivex.Completable;
import p655io.reactivex.Flowable;
import p655io.reactivex.Maybe;
import p655io.reactivex.Observable;
import p655io.reactivex.Scheduler;
import p655io.reactivex.Single;
import retrofit2.C8658l;
import retrofit2.CallAdapter;
import retrofit2.CallAdapter.C8624a;
import retrofit2.Retrofit;

/* renamed from: retrofit2.adapter.rxjava2.g */
public final class RxJava2CallAdapterFactory extends C8624a {
    @Nullable
    /* renamed from: a */
    private final Scheduler f29336a;
    /* renamed from: b */
    private final boolean f29337b;

    /* renamed from: a */
    public static RxJava2CallAdapterFactory m37491a(Scheduler mVar) {
        if (mVar != null) {
            return new RxJava2CallAdapterFactory(mVar, false);
        }
        throw new NullPointerException("scheduler == null");
    }

    private RxJava2CallAdapterFactory(@Nullable Scheduler mVar, boolean z) {
        this.f29336a = mVar;
        this.f29337b = z;
    }

    /* renamed from: a */
    public CallAdapter<?, ?> mo41288a(Type type, Annotation[] annotationArr, Retrofit mVar) {
        boolean z;
        boolean z2;
        Type type2;
        Class<Observable> a = m37500a(type);
        if (a == Completable.class) {
            RxJava2CallAdapter fVar = new RxJava2CallAdapter(Void.class, this.f29336a, this.f29337b, false, true, false, false, false, true);
            return fVar;
        }
        boolean z3 = a == Flowable.class;
        boolean z4 = a == Single.class;
        boolean z5 = a == Maybe.class;
        if (a != Observable.class && !z3 && !z4 && !z5) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            String str = !z3 ? !z4 ? z5 ? "Maybe" : "Observable" : "Single" : "Flowable";
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" return type must be parameterized as ");
            sb.append(str);
            sb.append("<Foo> or ");
            sb.append(str);
            sb.append("<? extends Foo>");
            throw new IllegalStateException(sb.toString());
        }
        Type a2 = m37501a(0, (ParameterizedType) type);
        Class<C8621d> a3 = m37500a(a2);
        if (a3 == C8658l.class) {
            if (a2 instanceof ParameterizedType) {
                type2 = m37501a(0, (ParameterizedType) a2);
                z2 = false;
            } else {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
        } else if (a3 != C8621d.class) {
            type2 = a2;
            z2 = false;
            z = true;
            RxJava2CallAdapter fVar2 = new RxJava2CallAdapter(type2, this.f29336a, this.f29337b, z2, z, z3, z4, z5, false);
            return fVar2;
        } else if (a2 instanceof ParameterizedType) {
            type2 = m37501a(0, (ParameterizedType) a2);
            z2 = true;
        } else {
            throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
        }
        z = false;
        RxJava2CallAdapter fVar22 = new RxJava2CallAdapter(type2, this.f29336a, this.f29337b, z2, z, z3, z4, z5, false);
        return fVar22;
    }
}
