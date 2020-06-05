package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* renamed from: retrofit2.c */
public interface CallAdapter<R, T> {

    /* compiled from: CallAdapter */
    /* renamed from: retrofit2.c$a */
    public static abstract class C8624a {
        @Nullable
        /* renamed from: a */
        public abstract CallAdapter<?, ?> mo41288a(Type type, Annotation[] annotationArr, Retrofit mVar);

        /* renamed from: a */
        protected static Type m37501a(int i, ParameterizedType parameterizedType) {
            return C8662o.m37638a(i, parameterizedType);
        }

        /* renamed from: a */
        protected static Class<?> m37500a(Type type) {
            return C8662o.m37635a(type);
        }
    }

    /* renamed from: a */
    T mo41286a(C8623b<R> bVar);

    /* renamed from: a */
    Type mo41287a();
}
