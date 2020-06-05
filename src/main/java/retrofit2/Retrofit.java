package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.C8358aa;
import okhttp3.C8364ac;
import okhttp3.C8379e.C8380a;
import okhttp3.C8506t;
import okhttp3.C8513x;
import retrofit2.CallAdapter.C8624a;
import retrofit2.Converter.C8626a;

/* renamed from: retrofit2.m */
public final class Retrofit {
    /* renamed from: a */
    final C8380a f29409a;
    /* renamed from: b */
    final C8506t f29410b;
    /* renamed from: c */
    final List<C8626a> f29411c;
    /* renamed from: d */
    final List<C8624a> f29412d;
    @Nullable
    /* renamed from: e */
    final Executor f29413e;
    /* renamed from: f */
    final boolean f29414f;
    /* renamed from: g */
    private final Map<Method, ServiceMethod<?, ?>> f29415g = new ConcurrentHashMap();

    /* compiled from: Retrofit */
    /* renamed from: retrofit2.m$a */
    public static final class C8660a {
        /* renamed from: a */
        private final C8652j f29419a;
        @Nullable
        /* renamed from: b */
        private C8380a f29420b;
        /* renamed from: c */
        private C8506t f29421c;
        /* renamed from: d */
        private final List<C8626a> f29422d;
        /* renamed from: e */
        private final List<C8624a> f29423e;
        @Nullable
        /* renamed from: f */
        private Executor f29424f;
        /* renamed from: g */
        private boolean f29425g;

        C8660a(C8652j jVar) {
            this.f29422d = new ArrayList();
            this.f29423e = new ArrayList();
            this.f29419a = jVar;
        }

        public C8660a() {
            this(C8652j.m37567a());
        }

        /* renamed from: a */
        public C8660a mo41371a(C8513x xVar) {
            return mo41369a((C8380a) C8662o.m37637a(xVar, "client == null"));
        }

        /* renamed from: a */
        public C8660a mo41369a(C8380a aVar) {
            this.f29420b = (C8380a) C8662o.m37637a(aVar, "factory == null");
            return this;
        }

        /* renamed from: a */
        public C8660a mo41368a(String str) {
            C8662o.m37637a(str, "baseUrl == null");
            C8506t e = C8506t.m36545e(str);
            if (e != null) {
                return mo41370a(e);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Illegal URL: ");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }

        /* renamed from: a */
        public C8660a mo41370a(C8506t tVar) {
            C8662o.m37637a(tVar, "baseUrl == null");
            List k = tVar.mo40562k();
            if ("".equals(k.get(k.size() - 1))) {
                this.f29421c = tVar;
                return this;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("baseUrl must end in /: ");
            sb.append(tVar);
            throw new IllegalArgumentException(sb.toString());
        }

        /* renamed from: a */
        public C8660a mo41373a(C8626a aVar) {
            this.f29422d.add(C8662o.m37637a(aVar, "factory == null"));
            return this;
        }

        /* renamed from: a */
        public C8660a mo41372a(C8624a aVar) {
            this.f29423e.add(C8662o.m37637a(aVar, "factory == null"));
            return this;
        }

        /* renamed from: a */
        public Retrofit mo41374a() {
            if (this.f29421c != null) {
                C8380a aVar = this.f29420b;
                if (aVar == null) {
                    aVar = new C8513x();
                }
                C8380a aVar2 = aVar;
                Executor executor = this.f29424f;
                if (executor == null) {
                    executor = this.f29419a.mo41340b();
                }
                Executor executor2 = executor;
                ArrayList arrayList = new ArrayList(this.f29423e);
                arrayList.add(this.f29419a.mo41338a(executor2));
                ArrayList arrayList2 = new ArrayList(this.f29422d.size() + 1);
                arrayList2.add(new BuiltInConverters());
                arrayList2.addAll(this.f29422d);
                Retrofit mVar = new Retrofit(aVar2, this.f29421c, Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList), executor2, this.f29425g);
                return mVar;
            }
            throw new IllegalStateException("Base URL required.");
        }
    }

    Retrofit(C8380a aVar, C8506t tVar, List<C8626a> list, List<C8624a> list2, @Nullable Executor executor, boolean z) {
        this.f29409a = aVar;
        this.f29410b = tVar;
        this.f29411c = list;
        this.f29412d = list2;
        this.f29413e = executor;
        this.f29414f = z;
    }

    /* renamed from: a */
    public <T> T mo41356a(final Class<T> cls) {
        C8662o.m37643a(cls);
        if (this.f29414f) {
            m37597b(cls);
        }
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() {
            /* renamed from: c */
            private final C8652j f29418c = C8652j.m37567a();

            public Object invoke(Object obj, Method method, @Nullable Object[] objArr) throws Throwable {
                if (method.getDeclaringClass() == Object.class) {
                    return method.invoke(this, objArr);
                }
                if (this.f29418c.mo41339a(method)) {
                    return this.f29418c.mo41337a(method, cls, obj, objArr);
                }
                ServiceMethod a = Retrofit.this.mo41363a(method);
                return a.mo41376a((C8623b<R>) new OkHttpCall<R>(a, objArr));
            }
        });
    }

    /* renamed from: b */
    private void m37597b(Class<?> cls) {
        Method[] declaredMethods;
        C8652j a = C8652j.m37567a();
        for (Method method : cls.getDeclaredMethods()) {
            if (!a.mo41339a(method)) {
                mo41363a(method);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public ServiceMethod<?, ?> mo41363a(Method method) {
        ServiceMethod<?, ?> nVar;
        ServiceMethod<?, ?> nVar2 = (ServiceMethod) this.f29415g.get(method);
        if (nVar2 != null) {
            return nVar2;
        }
        synchronized (this.f29415g) {
            nVar = (ServiceMethod) this.f29415g.get(method);
            if (nVar == null) {
                nVar = new C8661a(this, method).mo41378a();
                this.f29415g.put(method, nVar);
            }
        }
        return nVar;
    }

    /* renamed from: a */
    public C8380a mo41357a() {
        return this.f29409a;
    }

    /* renamed from: b */
    public C8506t mo41364b() {
        return this.f29410b;
    }

    /* renamed from: a */
    public CallAdapter<?, ?> mo41358a(Type type, Annotation[] annotationArr) {
        return mo41359a((C8624a) null, type, annotationArr);
    }

    /* renamed from: a */
    public CallAdapter<?, ?> mo41359a(@Nullable C8624a aVar, Type type, Annotation[] annotationArr) {
        C8662o.m37637a(type, "returnType == null");
        C8662o.m37637a(annotationArr, "annotations == null");
        int indexOf = this.f29412d.indexOf(aVar) + 1;
        int size = this.f29412d.size();
        for (int i = indexOf; i < size; i++) {
            CallAdapter<?, ?> a = ((C8624a) this.f29412d.get(i)).mo41288a(type, annotationArr, this);
            if (a != null) {
                return a;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(type);
        sb.append(".\n");
        String str = "\n   * ";
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i2 = 0; i2 < indexOf; i2++) {
                sb.append(str);
                sb.append(((C8624a) this.f29412d.get(i2)).getClass().getName());
            }
            sb.append(10);
        }
        sb.append("  Tried:");
        int size2 = this.f29412d.size();
        while (indexOf < size2) {
            sb.append(str);
            sb.append(((C8624a) this.f29412d.get(indexOf)).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    public <T> Converter<T, C8358aa> mo41360a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return mo41362a(null, type, annotationArr, annotationArr2);
    }

    /* renamed from: a */
    public <T> Converter<T, C8358aa> mo41362a(@Nullable C8626a aVar, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        C8662o.m37637a(type, "type == null");
        C8662o.m37637a(annotationArr, "parameterAnnotations == null");
        C8662o.m37637a(annotationArr2, "methodAnnotations == null");
        int indexOf = this.f29411c.indexOf(aVar) + 1;
        int size = this.f29411c.size();
        for (int i = indexOf; i < size; i++) {
            Converter<T, C8358aa> a = ((C8626a) this.f29411c.get(i)).mo41273a(type, annotationArr, annotationArr2, this);
            if (a != null) {
                return a;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n");
        String str = "\n   * ";
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i2 = 0; i2 < indexOf; i2++) {
                sb.append(str);
                sb.append(((C8626a) this.f29411c.get(i2)).getClass().getName());
            }
            sb.append(10);
        }
        sb.append("  Tried:");
        int size2 = this.f29411c.size();
        while (indexOf < size2) {
            sb.append(str);
            sb.append(((C8626a) this.f29411c.get(indexOf)).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: b */
    public <T> Converter<C8364ac, T> mo41365b(Type type, Annotation[] annotationArr) {
        return mo41361a((C8626a) null, type, annotationArr);
    }

    /* renamed from: a */
    public <T> Converter<C8364ac, T> mo41361a(@Nullable C8626a aVar, Type type, Annotation[] annotationArr) {
        C8662o.m37637a(type, "type == null");
        C8662o.m37637a(annotationArr, "annotations == null");
        int indexOf = this.f29411c.indexOf(aVar) + 1;
        int size = this.f29411c.size();
        for (int i = indexOf; i < size; i++) {
            Converter<C8364ac, T> a = ((C8626a) this.f29411c.get(i)).mo41272a(type, annotationArr, this);
            if (a != null) {
                return a;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n");
        String str = "\n   * ";
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i2 = 0; i2 < indexOf; i2++) {
                sb.append(str);
                sb.append(((C8626a) this.f29411c.get(i2)).getClass().getName());
            }
            sb.append(10);
        }
        sb.append("  Tried:");
        int size2 = this.f29411c.size();
        while (indexOf < size2) {
            sb.append(str);
            sb.append(((C8626a) this.f29411c.get(indexOf)).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: c */
    public <T> Converter<T, String> mo41366c(Type type, Annotation[] annotationArr) {
        C8662o.m37637a(type, "type == null");
        C8662o.m37637a(annotationArr, "annotations == null");
        int size = this.f29411c.size();
        for (int i = 0; i < size; i++) {
            Converter<T, String> b = ((C8626a) this.f29411c.get(i)).mo41294b(type, annotationArr, this);
            if (b != null) {
                return b;
            }
        }
        return C8616d.f29303a;
    }
}
