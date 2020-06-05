package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.C8358aa;
import okhttp3.C8364ac;
import retrofit2.Converter.C8626a;
import retrofit2.http.Streaming;

/* renamed from: retrofit2.a */
final class BuiltInConverters extends C8626a {

    /* compiled from: BuiltInConverters */
    /* renamed from: retrofit2.a$a */
    static final class C8613a implements Converter<C8364ac, C8364ac> {
        /* renamed from: a */
        static final C8613a f29300a = new C8613a();

        C8613a() {
        }

        /* renamed from: a */
        public C8364ac mo41274a(C8364ac acVar) throws IOException {
            try {
                return C8662o.m37642a(acVar);
            } finally {
                acVar.close();
            }
        }
    }

    /* compiled from: BuiltInConverters */
    /* renamed from: retrofit2.a$b */
    static final class C8614b implements Converter<C8358aa, C8358aa> {
        /* renamed from: a */
        static final C8614b f29301a = new C8614b();

        /* renamed from: a */
        public C8358aa mo41274a(C8358aa aaVar) {
            return aaVar;
        }

        C8614b() {
        }
    }

    /* compiled from: BuiltInConverters */
    /* renamed from: retrofit2.a$c */
    static final class C8615c implements Converter<C8364ac, C8364ac> {
        /* renamed from: a */
        static final C8615c f29302a = new C8615c();

        /* renamed from: a */
        public C8364ac mo41274a(C8364ac acVar) {
            return acVar;
        }

        C8615c() {
        }
    }

    /* compiled from: BuiltInConverters */
    /* renamed from: retrofit2.a$d */
    static final class C8616d implements Converter<Object, String> {
        /* renamed from: a */
        static final C8616d f29303a = new C8616d();

        C8616d() {
        }

        /* renamed from: b */
        public String mo41274a(Object obj) {
            return obj.toString();
        }
    }

    /* compiled from: BuiltInConverters */
    /* renamed from: retrofit2.a$e */
    static final class C8617e implements Converter<C8364ac, Void> {
        /* renamed from: a */
        static final C8617e f29304a = new C8617e();

        C8617e() {
        }

        /* renamed from: a */
        public Void mo41274a(C8364ac acVar) {
            acVar.close();
            return null;
        }
    }

    BuiltInConverters() {
    }

    /* renamed from: a */
    public Converter<C8364ac, ?> mo41272a(Type type, Annotation[] annotationArr, Retrofit mVar) {
        Converter<C8364ac, ?> eVar;
        if (type == C8364ac.class) {
            if (C8662o.m37646a(annotationArr, Streaming.class)) {
                eVar = C8615c.f29302a;
            } else {
                eVar = C8613a.f29300a;
            }
            return eVar;
        } else if (type == Void.class) {
            return C8617e.f29304a;
        } else {
            return null;
        }
    }

    /* renamed from: a */
    public Converter<?, C8358aa> mo41273a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit mVar) {
        if (C8358aa.class.isAssignableFrom(C8662o.m37635a(type))) {
            return C8614b.f29301a;
        }
        return null;
    }
}
