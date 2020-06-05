package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import retrofit2.CallAdapter.C8624a;

/* renamed from: retrofit2.f */
final class DefaultCallAdapterFactory extends C8624a {
    /* renamed from: a */
    static final C8624a f29338a = new DefaultCallAdapterFactory();

    DefaultCallAdapterFactory() {
    }

    /* renamed from: a */
    public CallAdapter<?, ?> mo41288a(Type type, Annotation[] annotationArr, Retrofit mVar) {
        if (m37500a(type) != C8623b.class) {
            return null;
        }
        final Type e = C8662o.m37651e(type);
        return new CallAdapter<Object, C8623b<?>>() {
            /* renamed from: b */
            public C8623b<Object> mo41286a(C8623b<Object> bVar) {
                return bVar;
            }

            /* renamed from: a */
            public Type mo41287a() {
                return e;
            }
        };
    }
}
