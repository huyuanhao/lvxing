package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import okhttp3.C8358aa;
import okhttp3.C8364ac;

/* renamed from: retrofit2.e */
public interface Converter<F, T> {

    /* compiled from: Converter */
    /* renamed from: retrofit2.e$a */
    public static abstract class C8626a {
        @Nullable
        /* renamed from: a */
        public Converter<C8364ac, ?> mo41272a(Type type, Annotation[] annotationArr, Retrofit mVar) {
            return null;
        }

        @Nullable
        /* renamed from: a */
        public Converter<?, C8358aa> mo41273a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit mVar) {
            return null;
        }

        @Nullable
        /* renamed from: b */
        public Converter<?, String> mo41294b(Type type, Annotation[] annotationArr, Retrofit mVar) {
            return null;
        }
    }

    /* renamed from: a */
    T mo41274a(F f) throws IOException;
}
