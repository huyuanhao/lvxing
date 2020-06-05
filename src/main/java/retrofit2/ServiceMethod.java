package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.C8362ab;
import okhttp3.C8364ac;
import okhttp3.C8379e;
import okhttp3.C8379e.C8380a;
import okhttp3.C8504s;
import okhttp3.C8504s.C8505a;
import okhttp3.C8506t;
import okhttp3.C8510v;
import retrofit2.http.DELETE;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.OPTIONS;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/* renamed from: retrofit2.n */
final class ServiceMethod<R, T> {
    /* renamed from: a */
    static final Pattern f29426a = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
    /* renamed from: b */
    static final Pattern f29427b = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");
    /* renamed from: c */
    private final C8380a f29428c;
    /* renamed from: d */
    private final CallAdapter<R, T> f29429d;
    /* renamed from: e */
    private final C8506t f29430e;
    /* renamed from: f */
    private final Converter<C8364ac, R> f29431f;
    /* renamed from: g */
    private final String f29432g;
    /* renamed from: h */
    private final String f29433h;
    /* renamed from: i */
    private final C8504s f29434i;
    /* renamed from: j */
    private final C8510v f29435j;
    /* renamed from: k */
    private final boolean f29436k;
    /* renamed from: l */
    private final boolean f29437l;
    /* renamed from: m */
    private final boolean f29438m;
    /* renamed from: n */
    private final ParameterHandler<?>[] f29439n;

    /* compiled from: ServiceMethod */
    /* renamed from: retrofit2.n$a */
    static final class C8661a<T, R> {
        /* renamed from: a */
        final Retrofit f29440a;
        /* renamed from: b */
        final Method f29441b;
        /* renamed from: c */
        final Annotation[] f29442c;
        /* renamed from: d */
        final Annotation[][] f29443d;
        /* renamed from: e */
        final Type[] f29444e;
        /* renamed from: f */
        Type f29445f;
        /* renamed from: g */
        boolean f29446g;
        /* renamed from: h */
        boolean f29447h;
        /* renamed from: i */
        boolean f29448i;
        /* renamed from: j */
        boolean f29449j;
        /* renamed from: k */
        boolean f29450k;
        /* renamed from: l */
        boolean f29451l;
        /* renamed from: m */
        String f29452m;
        /* renamed from: n */
        boolean f29453n;
        /* renamed from: o */
        boolean f29454o;
        /* renamed from: p */
        boolean f29455p;
        /* renamed from: q */
        String f29456q;
        /* renamed from: r */
        C8504s f29457r;
        /* renamed from: s */
        C8510v f29458s;
        /* renamed from: t */
        Set<String> f29459t;
        /* renamed from: u */
        ParameterHandler<?>[] f29460u;
        /* renamed from: v */
        Converter<C8364ac, T> f29461v;
        /* renamed from: w */
        CallAdapter<T, R> f29462w;

        C8661a(Retrofit mVar, Method method) {
            this.f29440a = mVar;
            this.f29441b = method;
            this.f29442c = method.getAnnotations();
            this.f29444e = method.getGenericParameterTypes();
            this.f29443d = method.getParameterAnnotations();
        }

        /* renamed from: a */
        public ServiceMethod mo41378a() {
            this.f29462w = m37631b();
            this.f29445f = this.f29462w.mo41287a();
            Type type = this.f29445f;
            if (type == C8658l.class || type == C8362ab.class) {
                StringBuilder sb = new StringBuilder();
                sb.append("'");
                sb.append(C8662o.m37635a(this.f29445f).getName());
                sb.append("' is not a valid response body type. Did you mean ResponseBody?");
                throw m37622a(sb.toString(), new Object[0]);
            }
            this.f29461v = m37632c();
            for (Annotation a : this.f29442c) {
                m37630a(a);
            }
            if (this.f29452m != null) {
                if (!this.f29453n) {
                    if (this.f29455p) {
                        throw m37622a("Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    } else if (this.f29454o) {
                        throw m37622a("FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    }
                }
                int length = this.f29443d.length;
                this.f29460u = new ParameterHandler[length];
                int i = 0;
                while (i < length) {
                    Type type2 = this.f29444e[i];
                    if (!C8662o.m37650d(type2)) {
                        Annotation[] annotationArr = this.f29443d[i];
                        if (annotationArr != null) {
                            this.f29460u[i] = m37626a(i, type2, annotationArr);
                            i++;
                        } else {
                            throw m37621a(i, "No Retrofit annotation found.", new Object[0]);
                        }
                    } else {
                        throw m37621a(i, "Parameter type must not include a type variable or wildcard: %s", type2);
                    }
                }
                if (this.f29456q == null && !this.f29451l) {
                    throw m37622a("Missing either @%s URL or @Url parameter.", this.f29452m);
                } else if (!this.f29454o && !this.f29455p && !this.f29453n && this.f29448i) {
                    throw m37622a("Non-body HTTP method cannot contain @Body.", new Object[0]);
                } else if (this.f29454o && !this.f29446g) {
                    throw m37622a("Form-encoded method must contain at least one @Field.", new Object[0]);
                } else if (!this.f29455p || this.f29447h) {
                    return new ServiceMethod(this);
                } else {
                    throw m37622a("Multipart method must contain at least one @Part.", new Object[0]);
                }
            } else {
                throw m37622a("HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
        }

        /* renamed from: b */
        private CallAdapter<T, R> m37631b() {
            Object obj;
            Type genericReturnType = this.f29441b.getGenericReturnType();
            if (C8662o.m37650d(genericReturnType)) {
                throw m37622a("Method return type must not include a type variable or wildcard: %s", genericReturnType);
            } else if (genericReturnType != Void.TYPE) {
                try {
                    obj = genericReturnType;
                    CallAdapter a = this.f29440a.mo41358a(genericReturnType, this.f29441b.getAnnotations());
                    obj = a;
                    return a;
                } catch (RuntimeException e) {
                    throw m37624a((Throwable) e, "Unable to create call adapter for %s", obj);
                }
            } else {
                throw m37622a("Service methods cannot return void.", new Object[0]);
            }
        }

        /* renamed from: a */
        private void m37630a(Annotation annotation) {
            if (annotation instanceof DELETE) {
                m37629a("DELETE", ((DELETE) annotation).value(), false);
            } else if (annotation instanceof GET) {
                m37629a("GET", ((GET) annotation).value(), false);
            } else if (annotation instanceof HEAD) {
                m37629a("HEAD", ((HEAD) annotation).value(), false);
                if (!Void.class.equals(this.f29445f)) {
                    throw m37622a("HEAD method must use Void as response type.", new Object[0]);
                }
            } else if (annotation instanceof PATCH) {
                m37629a("PATCH", ((PATCH) annotation).value(), true);
            } else if (annotation instanceof POST) {
                m37629a("POST", ((POST) annotation).value(), true);
            } else if (annotation instanceof PUT) {
                m37629a("PUT", ((PUT) annotation).value(), true);
            } else if (annotation instanceof OPTIONS) {
                m37629a("OPTIONS", ((OPTIONS) annotation).value(), false);
            } else if (annotation instanceof HTTP) {
                HTTP http = (HTTP) annotation;
                m37629a(http.method(), http.path(), http.hasBody());
            } else if (annotation instanceof Headers) {
                String[] value = ((Headers) annotation).value();
                if (value.length != 0) {
                    this.f29457r = m37625a(value);
                } else {
                    throw m37622a("@Headers annotation is empty.", new Object[0]);
                }
            } else {
                String str = "Only one encoding annotation is allowed.";
                if (annotation instanceof Multipart) {
                    if (!this.f29454o) {
                        this.f29455p = true;
                        return;
                    }
                    throw m37622a(str, new Object[0]);
                } else if (!(annotation instanceof FormUrlEncoded)) {
                } else {
                    if (!this.f29455p) {
                        this.f29454o = true;
                        return;
                    }
                    throw m37622a(str, new Object[0]);
                }
            }
        }

        /* renamed from: a */
        private void m37629a(String str, String str2, boolean z) {
            String str3 = this.f29452m;
            if (str3 == null) {
                this.f29452m = str;
                this.f29453n = z;
                if (!str2.isEmpty()) {
                    int indexOf = str2.indexOf(63);
                    if (indexOf != -1 && indexOf < str2.length() - 1) {
                        String substring = str2.substring(indexOf + 1);
                        if (ServiceMethod.f29426a.matcher(substring).find()) {
                            throw m37622a("URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", substring);
                        }
                    }
                    this.f29456q = str2;
                    this.f29459t = ServiceMethod.m37617a(str2);
                    return;
                }
                return;
            }
            throw m37622a("Only one HTTP method is allowed. Found: %s and %s.", str3, str);
        }

        /* renamed from: a */
        private C8504s m37625a(String[] strArr) {
            C8505a aVar = new C8505a();
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                String str = strArr[i];
                int indexOf = str.indexOf(58);
                if (indexOf == -1 || indexOf == 0 || indexOf == str.length() - 1) {
                    throw m37622a("@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String substring = str.substring(0, indexOf);
                String trim = str.substring(indexOf + 1).trim();
                if ("Content-Type".equalsIgnoreCase(substring)) {
                    C8510v b = C8510v.m36598b(trim);
                    if (b != null) {
                        this.f29458s = b;
                    } else {
                        throw m37622a("Malformed content type: %s", trim);
                    }
                } else {
                    aVar.mo40542a(substring, trim);
                }
            }
            return aVar.mo40543a();
        }

        /* renamed from: a */
        private ParameterHandler<?> m37626a(int i, Type type, Annotation[] annotationArr) {
            ParameterHandler<?> iVar = null;
            for (Annotation a : annotationArr) {
                ParameterHandler<?> a2 = m37627a(i, type, annotationArr, a);
                if (a2 != null) {
                    if (iVar == null) {
                        iVar = a2;
                    } else {
                        throw m37621a(i, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                    }
                }
            }
            if (iVar != null) {
                return iVar;
            }
            throw m37621a(i, "No Retrofit annotation found.", new Object[0]);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
            if ("android.net.Uri".equals(((java.lang.Class) r11).getName()) != false) goto L_0x0042;
     */
        /* renamed from: a */
        private retrofit2.ParameterHandler<?> m37627a(int r10, java.lang.reflect.Type r11, java.lang.annotation.Annotation[] r12, java.lang.annotation.Annotation r13) {
            /*
            r9 = this;
            boolean r0 = r13 instanceof retrofit2.http.Url
            java.lang.String r1 = "@Path parameters may not be used with @Url."
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x006e
            boolean r12 = r9.f29451l
            if (r12 != 0) goto L_0x0065
            boolean r12 = r9.f29449j
            if (r12 != 0) goto L_0x005e
            boolean r12 = r9.f29450k
            if (r12 != 0) goto L_0x0055
            java.lang.String r12 = r9.f29456q
            if (r12 != 0) goto L_0x0048
            r9.f29451l = r2
            java.lang.Class<okhttp3.t> r12 = okhttp3.C8506t.class
            if (r11 == r12) goto L_0x0042
            java.lang.Class<java.lang.String> r12 = java.lang.String.class
            if (r11 == r12) goto L_0x0042
            java.lang.Class<java.net.URI> r12 = java.net.URI.class
            if (r11 == r12) goto L_0x0042
            boolean r12 = r11 instanceof java.lang.Class
            if (r12 == 0) goto L_0x0039
            java.lang.Class r11 = (java.lang.Class) r11
            java.lang.String r11 = r11.getName()
            java.lang.String r12 = "android.net.Uri"
            boolean r11 = r12.equals(r11)
            if (r11 == 0) goto L_0x0039
            goto L_0x0042
        L_0x0039:
            java.lang.Object[] r11 = new java.lang.Object[r3]
            java.lang.String r12 = "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type."
            java.lang.RuntimeException r10 = r9.m37621a(r10, r12, r11)
            throw r10
        L_0x0042:
            retrofit2.i$m r10 = new retrofit2.i$m
            r10.m55930init()
            return r10
        L_0x0048:
            java.lang.Object[] r11 = new java.lang.Object[r2]
            java.lang.String r12 = r9.f29452m
            r11[r3] = r12
            java.lang.String r12 = "@Url cannot be used with @%s URL"
            java.lang.RuntimeException r10 = r9.m37621a(r10, r12, r11)
            throw r10
        L_0x0055:
            java.lang.Object[] r11 = new java.lang.Object[r3]
            java.lang.String r12 = "A @Url parameter must not come after a @Query"
            java.lang.RuntimeException r10 = r9.m37621a(r10, r12, r11)
            throw r10
        L_0x005e:
            java.lang.Object[] r11 = new java.lang.Object[r3]
            java.lang.RuntimeException r10 = r9.m37621a(r10, r1, r11)
            throw r10
        L_0x0065:
            java.lang.Object[] r11 = new java.lang.Object[r3]
            java.lang.String r12 = "Multiple @Url method annotations found."
            java.lang.RuntimeException r10 = r9.m37621a(r10, r12, r11)
            throw r10
        L_0x006e:
            boolean r0 = r13 instanceof retrofit2.http.Path
            if (r0 == 0) goto L_0x00b6
            boolean r0 = r9.f29450k
            if (r0 != 0) goto L_0x00ad
            boolean r0 = r9.f29451l
            if (r0 != 0) goto L_0x00a6
            java.lang.String r0 = r9.f29456q
            if (r0 == 0) goto L_0x0099
            r9.f29449j = r2
            retrofit2.http.Path r13 = (retrofit2.http.Path) r13
            java.lang.String r0 = r13.value()
            r9.m37628a(r10, r0)
            retrofit2.m r10 = r9.f29440a
            retrofit2.e r10 = r10.mo41366c(r11, r12)
            retrofit2.i$h r11 = new retrofit2.i$h
            boolean r12 = r13.encoded()
            r11.m55924init(r0, r10, r12)
            return r11
        L_0x0099:
            java.lang.Object[] r11 = new java.lang.Object[r2]
            java.lang.String r12 = r9.f29452m
            r11[r3] = r12
            java.lang.String r12 = "@Path can only be used with relative url on @%s"
            java.lang.RuntimeException r10 = r9.m37621a(r10, r12, r11)
            throw r10
        L_0x00a6:
            java.lang.Object[] r11 = new java.lang.Object[r3]
            java.lang.RuntimeException r10 = r9.m37621a(r10, r1, r11)
            throw r10
        L_0x00ad:
            java.lang.Object[] r11 = new java.lang.Object[r3]
            java.lang.String r12 = "A @Path parameter must not come after a @Query."
            java.lang.RuntimeException r10 = r9.m37621a(r10, r12, r11)
            throw r10
        L_0x00b6:
            boolean r0 = r13 instanceof retrofit2.http.Query
            java.lang.String r1 = "<String>)"
            java.lang.String r4 = " must include generic type (e.g., "
            if (r0 == 0) goto L_0x013e
            retrofit2.http.Query r13 = (retrofit2.http.Query) r13
            java.lang.String r0 = r13.value()
            boolean r13 = r13.encoded()
            java.lang.Class r5 = retrofit2.C8662o.m37635a(r11)
            r9.f29450k = r2
            java.lang.Class<java.lang.Iterable> r2 = java.lang.Iterable.class
            boolean r2 = r2.isAssignableFrom(r5)
            if (r2 == 0) goto L_0x0114
            boolean r2 = r11 instanceof java.lang.reflect.ParameterizedType
            if (r2 == 0) goto L_0x00f0
            java.lang.reflect.ParameterizedType r11 = (java.lang.reflect.ParameterizedType) r11
            java.lang.reflect.Type r10 = retrofit2.C8662o.m37638a(r3, r11)
            retrofit2.m r11 = r9.f29440a
            retrofit2.e r10 = r11.mo41366c(r10, r12)
            retrofit2.i$i r11 = new retrofit2.i$i
            r11.m55925init(r0, r10, r13)
            retrofit2.i r10 = r11.mo41328a()
            return r10
        L_0x00f0:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = r5.getSimpleName()
            r11.append(r12)
            r11.append(r4)
            java.lang.String r12 = r5.getSimpleName()
            r11.append(r12)
            r11.append(r1)
            java.lang.String r11 = r11.toString()
            java.lang.Object[] r12 = new java.lang.Object[r3]
            java.lang.RuntimeException r10 = r9.m37621a(r10, r11, r12)
            throw r10
        L_0x0114:
            boolean r10 = r5.isArray()
            if (r10 == 0) goto L_0x0132
            java.lang.Class r10 = r5.getComponentType()
            java.lang.Class r10 = retrofit2.ServiceMethod.m37616a(r10)
            retrofit2.m r11 = r9.f29440a
            retrofit2.e r10 = r11.mo41366c(r10, r12)
            retrofit2.i$i r11 = new retrofit2.i$i
            r11.m55925init(r0, r10, r13)
            retrofit2.i r10 = r11.mo41330b()
            return r10
        L_0x0132:
            retrofit2.m r10 = r9.f29440a
            retrofit2.e r10 = r10.mo41366c(r11, r12)
            retrofit2.i$i r11 = new retrofit2.i$i
            r11.m55925init(r0, r10, r13)
            return r11
        L_0x013e:
            boolean r0 = r13 instanceof retrofit2.http.QueryName
            if (r0 == 0) goto L_0x01be
            retrofit2.http.QueryName r13 = (retrofit2.http.QueryName) r13
            boolean r13 = r13.encoded()
            java.lang.Class r0 = retrofit2.C8662o.m37635a(r11)
            r9.f29450k = r2
            java.lang.Class<java.lang.Iterable> r2 = java.lang.Iterable.class
            boolean r2 = r2.isAssignableFrom(r0)
            if (r2 == 0) goto L_0x0194
            boolean r2 = r11 instanceof java.lang.reflect.ParameterizedType
            if (r2 == 0) goto L_0x0170
            java.lang.reflect.ParameterizedType r11 = (java.lang.reflect.ParameterizedType) r11
            java.lang.reflect.Type r10 = retrofit2.C8662o.m37638a(r3, r11)
            retrofit2.m r11 = r9.f29440a
            retrofit2.e r10 = r11.mo41366c(r10, r12)
            retrofit2.i$k r11 = new retrofit2.i$k
            r11.m55927init(r10, r13)
            retrofit2.i r10 = r11.mo41328a()
            return r10
        L_0x0170:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = r0.getSimpleName()
            r11.append(r12)
            r11.append(r4)
            java.lang.String r12 = r0.getSimpleName()
            r11.append(r12)
            r11.append(r1)
            java.lang.String r11 = r11.toString()
            java.lang.Object[] r12 = new java.lang.Object[r3]
            java.lang.RuntimeException r10 = r9.m37621a(r10, r11, r12)
            throw r10
        L_0x0194:
            boolean r10 = r0.isArray()
            if (r10 == 0) goto L_0x01b2
            java.lang.Class r10 = r0.getComponentType()
            java.lang.Class r10 = retrofit2.ServiceMethod.m37616a(r10)
            retrofit2.m r11 = r9.f29440a
            retrofit2.e r10 = r11.mo41366c(r10, r12)
            retrofit2.i$k r11 = new retrofit2.i$k
            r11.m55927init(r10, r13)
            retrofit2.i r10 = r11.mo41330b()
            return r10
        L_0x01b2:
            retrofit2.m r10 = r9.f29440a
            retrofit2.e r10 = r10.mo41366c(r11, r12)
            retrofit2.i$k r11 = new retrofit2.i$k
            r11.m55927init(r10, r13)
            return r11
        L_0x01be:
            boolean r0 = r13 instanceof retrofit2.http.QueryMap
            java.lang.String r5 = "Map must include generic types (e.g., Map<String, String>)"
            if (r0 == 0) goto L_0x0222
            java.lang.Class r0 = retrofit2.C8662o.m37635a(r11)
            java.lang.Class<java.util.Map> r1 = java.util.Map.class
            boolean r1 = r1.isAssignableFrom(r0)
            if (r1 == 0) goto L_0x0219
            java.lang.Class<java.util.Map> r1 = java.util.Map.class
            java.lang.reflect.Type r11 = retrofit2.C8662o.m37648b(r11, r0, r1)
            boolean r0 = r11 instanceof java.lang.reflect.ParameterizedType
            if (r0 == 0) goto L_0x0212
            java.lang.reflect.ParameterizedType r11 = (java.lang.reflect.ParameterizedType) r11
            java.lang.reflect.Type r0 = retrofit2.C8662o.m37638a(r3, r11)
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            if (r1 != r0) goto L_0x01fa
            java.lang.reflect.Type r10 = retrofit2.C8662o.m37638a(r2, r11)
            retrofit2.m r11 = r9.f29440a
            retrofit2.e r10 = r11.mo41366c(r10, r12)
            retrofit2.i$j r11 = new retrofit2.i$j
            retrofit2.http.QueryMap r13 = (retrofit2.http.QueryMap) r13
            boolean r12 = r13.encoded()
            r11.m55926init(r10, r12)
            return r11
        L_0x01fa:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "@QueryMap keys must be of type String: "
            r11.append(r12)
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            java.lang.Object[] r12 = new java.lang.Object[r3]
            java.lang.RuntimeException r10 = r9.m37621a(r10, r11, r12)
            throw r10
        L_0x0212:
            java.lang.Object[] r11 = new java.lang.Object[r3]
            java.lang.RuntimeException r10 = r9.m37621a(r10, r5, r11)
            throw r10
        L_0x0219:
            java.lang.Object[] r11 = new java.lang.Object[r3]
            java.lang.String r12 = "@QueryMap parameter type must be Map."
            java.lang.RuntimeException r10 = r9.m37621a(r10, r12, r11)
            throw r10
        L_0x0222:
            boolean r0 = r13 instanceof retrofit2.http.Header
            if (r0 == 0) goto L_0x02a0
            retrofit2.http.Header r13 = (retrofit2.http.Header) r13
            java.lang.String r13 = r13.value()
            java.lang.Class r0 = retrofit2.C8662o.m37635a(r11)
            java.lang.Class<java.lang.Iterable> r2 = java.lang.Iterable.class
            boolean r2 = r2.isAssignableFrom(r0)
            if (r2 == 0) goto L_0x0276
            boolean r2 = r11 instanceof java.lang.reflect.ParameterizedType
            if (r2 == 0) goto L_0x0252
            java.lang.reflect.ParameterizedType r11 = (java.lang.reflect.ParameterizedType) r11
            java.lang.reflect.Type r10 = retrofit2.C8662o.m37638a(r3, r11)
            retrofit2.m r11 = r9.f29440a
            retrofit2.e r10 = r11.mo41366c(r10, r12)
            retrofit2.i$d r11 = new retrofit2.i$d
            r11.m55920init(r13, r10)
            retrofit2.i r10 = r11.mo41328a()
            return r10
        L_0x0252:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = r0.getSimpleName()
            r11.append(r12)
            r11.append(r4)
            java.lang.String r12 = r0.getSimpleName()
            r11.append(r12)
            r11.append(r1)
            java.lang.String r11 = r11.toString()
            java.lang.Object[] r12 = new java.lang.Object[r3]
            java.lang.RuntimeException r10 = r9.m37621a(r10, r11, r12)
            throw r10
        L_0x0276:
            boolean r10 = r0.isArray()
            if (r10 == 0) goto L_0x0294
            java.lang.Class r10 = r0.getComponentType()
            java.lang.Class r10 = retrofit2.ServiceMethod.m37616a(r10)
            retrofit2.m r11 = r9.f29440a
            retrofit2.e r10 = r11.mo41366c(r10, r12)
            retrofit2.i$d r11 = new retrofit2.i$d
            r11.m55920init(r13, r10)
            retrofit2.i r10 = r11.mo41330b()
            return r10
        L_0x0294:
            retrofit2.m r10 = r9.f29440a
            retrofit2.e r10 = r10.mo41366c(r11, r12)
            retrofit2.i$d r11 = new retrofit2.i$d
            r11.m55920init(r13, r10)
            return r11
        L_0x02a0:
            boolean r0 = r13 instanceof retrofit2.http.HeaderMap
            if (r0 == 0) goto L_0x02fc
            java.lang.Class r13 = retrofit2.C8662o.m37635a(r11)
            java.lang.Class<java.util.Map> r0 = java.util.Map.class
            boolean r0 = r0.isAssignableFrom(r13)
            if (r0 == 0) goto L_0x02f3
            java.lang.Class<java.util.Map> r0 = java.util.Map.class
            java.lang.reflect.Type r11 = retrofit2.C8662o.m37648b(r11, r13, r0)
            boolean r13 = r11 instanceof java.lang.reflect.ParameterizedType
            if (r13 == 0) goto L_0x02ec
            java.lang.reflect.ParameterizedType r11 = (java.lang.reflect.ParameterizedType) r11
            java.lang.reflect.Type r13 = retrofit2.C8662o.m37638a(r3, r11)
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            if (r0 != r13) goto L_0x02d4
            java.lang.reflect.Type r10 = retrofit2.C8662o.m37638a(r2, r11)
            retrofit2.m r11 = r9.f29440a
            retrofit2.e r10 = r11.mo41366c(r10, r12)
            retrofit2.i$e r11 = new retrofit2.i$e
            r11.m55921init(r10)
            return r11
        L_0x02d4:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "@HeaderMap keys must be of type String: "
            r11.append(r12)
            r11.append(r13)
            java.lang.String r11 = r11.toString()
            java.lang.Object[] r12 = new java.lang.Object[r3]
            java.lang.RuntimeException r10 = r9.m37621a(r10, r11, r12)
            throw r10
        L_0x02ec:
            java.lang.Object[] r11 = new java.lang.Object[r3]
            java.lang.RuntimeException r10 = r9.m37621a(r10, r5, r11)
            throw r10
        L_0x02f3:
            java.lang.Object[] r11 = new java.lang.Object[r3]
            java.lang.String r12 = "@HeaderMap parameter type must be Map."
            java.lang.RuntimeException r10 = r9.m37621a(r10, r12, r11)
            throw r10
        L_0x02fc:
            boolean r0 = r13 instanceof retrofit2.http.Field
            if (r0 == 0) goto L_0x038d
            boolean r0 = r9.f29454o
            if (r0 == 0) goto L_0x0384
            retrofit2.http.Field r13 = (retrofit2.http.Field) r13
            java.lang.String r0 = r13.value()
            boolean r13 = r13.encoded()
            r9.f29446g = r2
            java.lang.Class r2 = retrofit2.C8662o.m37635a(r11)
            java.lang.Class<java.lang.Iterable> r5 = java.lang.Iterable.class
            boolean r5 = r5.isAssignableFrom(r2)
            if (r5 == 0) goto L_0x035a
            boolean r5 = r11 instanceof java.lang.reflect.ParameterizedType
            if (r5 == 0) goto L_0x0336
            java.lang.reflect.ParameterizedType r11 = (java.lang.reflect.ParameterizedType) r11
            java.lang.reflect.Type r10 = retrofit2.C8662o.m37638a(r3, r11)
            retrofit2.m r11 = r9.f29440a
            retrofit2.e r10 = r11.mo41366c(r10, r12)
            retrofit2.i$b r11 = new retrofit2.i$b
            r11.m55918init(r0, r10, r13)
            retrofit2.i r10 = r11.mo41328a()
            return r10
        L_0x0336:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = r2.getSimpleName()
            r11.append(r12)
            r11.append(r4)
            java.lang.String r12 = r2.getSimpleName()
            r11.append(r12)
            r11.append(r1)
            java.lang.String r11 = r11.toString()
            java.lang.Object[] r12 = new java.lang.Object[r3]
            java.lang.RuntimeException r10 = r9.m37621a(r10, r11, r12)
            throw r10
        L_0x035a:
            boolean r10 = r2.isArray()
            if (r10 == 0) goto L_0x0378
            java.lang.Class r10 = r2.getComponentType()
            java.lang.Class r10 = retrofit2.ServiceMethod.m37616a(r10)
            retrofit2.m r11 = r9.f29440a
            retrofit2.e r10 = r11.mo41366c(r10, r12)
            retrofit2.i$b r11 = new retrofit2.i$b
            r11.m55918init(r0, r10, r13)
            retrofit2.i r10 = r11.mo41330b()
            return r10
        L_0x0378:
            retrofit2.m r10 = r9.f29440a
            retrofit2.e r10 = r10.mo41366c(r11, r12)
            retrofit2.i$b r11 = new retrofit2.i$b
            r11.m55918init(r0, r10, r13)
            return r11
        L_0x0384:
            java.lang.Object[] r11 = new java.lang.Object[r3]
            java.lang.String r12 = "@Field parameters can only be used with form encoding."
            java.lang.RuntimeException r10 = r9.m37621a(r10, r12, r11)
            throw r10
        L_0x038d:
            boolean r0 = r13 instanceof retrofit2.http.FieldMap
            if (r0 == 0) goto L_0x03fe
            boolean r0 = r9.f29454o
            if (r0 == 0) goto L_0x03f5
            java.lang.Class r0 = retrofit2.C8662o.m37635a(r11)
            java.lang.Class<java.util.Map> r1 = java.util.Map.class
            boolean r1 = r1.isAssignableFrom(r0)
            if (r1 == 0) goto L_0x03ec
            java.lang.Class<java.util.Map> r1 = java.util.Map.class
            java.lang.reflect.Type r11 = retrofit2.C8662o.m37648b(r11, r0, r1)
            boolean r0 = r11 instanceof java.lang.reflect.ParameterizedType
            if (r0 == 0) goto L_0x03e5
            java.lang.reflect.ParameterizedType r11 = (java.lang.reflect.ParameterizedType) r11
            java.lang.reflect.Type r0 = retrofit2.C8662o.m37638a(r3, r11)
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            if (r1 != r0) goto L_0x03cd
            java.lang.reflect.Type r10 = retrofit2.C8662o.m37638a(r2, r11)
            retrofit2.m r11 = r9.f29440a
            retrofit2.e r10 = r11.mo41366c(r10, r12)
            r9.f29446g = r2
            retrofit2.i$c r11 = new retrofit2.i$c
            retrofit2.http.FieldMap r13 = (retrofit2.http.FieldMap) r13
            boolean r12 = r13.encoded()
            r11.m55919init(r10, r12)
            return r11
        L_0x03cd:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "@FieldMap keys must be of type String: "
            r11.append(r12)
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            java.lang.Object[] r12 = new java.lang.Object[r3]
            java.lang.RuntimeException r10 = r9.m37621a(r10, r11, r12)
            throw r10
        L_0x03e5:
            java.lang.Object[] r11 = new java.lang.Object[r3]
            java.lang.RuntimeException r10 = r9.m37621a(r10, r5, r11)
            throw r10
        L_0x03ec:
            java.lang.Object[] r11 = new java.lang.Object[r3]
            java.lang.String r12 = "@FieldMap parameter type must be Map."
            java.lang.RuntimeException r10 = r9.m37621a(r10, r12, r11)
            throw r10
        L_0x03f5:
            java.lang.Object[] r11 = new java.lang.Object[r3]
            java.lang.String r12 = "@FieldMap parameters can only be used with form encoding."
            java.lang.RuntimeException r10 = r9.m37621a(r10, r12, r11)
            throw r10
        L_0x03fe:
            boolean r0 = r13 instanceof retrofit2.http.Part
            if (r0 == 0) goto L_0x057d
            boolean r0 = r9.f29455p
            if (r0 == 0) goto L_0x0574
            retrofit2.http.Part r13 = (retrofit2.http.Part) r13
            r9.f29447h = r2
            java.lang.String r0 = r13.value()
            java.lang.Class r5 = retrofit2.C8662o.m37635a(r11)
            boolean r6 = r0.isEmpty()
            if (r6 == 0) goto L_0x049c
            java.lang.Class<java.lang.Iterable> r12 = java.lang.Iterable.class
            boolean r12 = r12.isAssignableFrom(r5)
            java.lang.String r13 = "@Part annotation must supply a name or use MultipartBody.Part parameter type."
            if (r12 == 0) goto L_0x046a
            boolean r12 = r11 instanceof java.lang.reflect.ParameterizedType
            if (r12 == 0) goto L_0x0446
            java.lang.reflect.ParameterizedType r11 = (java.lang.reflect.ParameterizedType) r11
            java.lang.reflect.Type r11 = retrofit2.C8662o.m37638a(r3, r11)
            java.lang.Class<okhttp3.w$b> r12 = okhttp3.MultipartBody.C8512b.class
            java.lang.Class r11 = retrofit2.C8662o.m37635a(r11)
            boolean r11 = r12.isAssignableFrom(r11)
            if (r11 == 0) goto L_0x043f
            retrofit2.i$l r10 = retrofit2.ParameterHandler.C8650l.f29390a
            retrofit2.i r10 = r10.mo41328a()
            return r10
        L_0x043f:
            java.lang.Object[] r11 = new java.lang.Object[r3]
            java.lang.RuntimeException r10 = r9.m37621a(r10, r13, r11)
            throw r10
        L_0x0446:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = r5.getSimpleName()
            r11.append(r12)
            r11.append(r4)
            java.lang.String r12 = r5.getSimpleName()
            r11.append(r12)
            r11.append(r1)
            java.lang.String r11 = r11.toString()
            java.lang.Object[] r12 = new java.lang.Object[r3]
            java.lang.RuntimeException r10 = r9.m37621a(r10, r11, r12)
            throw r10
        L_0x046a:
            boolean r11 = r5.isArray()
            if (r11 == 0) goto L_0x048a
            java.lang.Class r11 = r5.getComponentType()
            java.lang.Class<okhttp3.w$b> r12 = okhttp3.MultipartBody.C8512b.class
            boolean r11 = r12.isAssignableFrom(r11)
            if (r11 == 0) goto L_0x0483
            retrofit2.i$l r10 = retrofit2.ParameterHandler.C8650l.f29390a
            retrofit2.i r10 = r10.mo41330b()
            return r10
        L_0x0483:
            java.lang.Object[] r11 = new java.lang.Object[r3]
            java.lang.RuntimeException r10 = r9.m37621a(r10, r13, r11)
            throw r10
        L_0x048a:
            java.lang.Class<okhttp3.w$b> r11 = okhttp3.MultipartBody.C8512b.class
            boolean r11 = r11.isAssignableFrom(r5)
            if (r11 == 0) goto L_0x0495
            retrofit2.i$l r10 = retrofit2.ParameterHandler.C8650l.f29390a
            return r10
        L_0x0495:
            java.lang.Object[] r11 = new java.lang.Object[r3]
            java.lang.RuntimeException r10 = r9.m37621a(r10, r13, r11)
            throw r10
        L_0x049c:
            r6 = 4
            java.lang.String[] r6 = new java.lang.String[r6]
            java.lang.String r7 = "Content-Disposition"
            r6[r3] = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "form-data; name=\""
            r7.append(r8)
            r7.append(r0)
            java.lang.String r0 = "\""
            r7.append(r0)
            java.lang.String r0 = r7.toString()
            r6[r2] = r0
            r0 = 2
            java.lang.String r2 = "Content-Transfer-Encoding"
            r6[r0] = r2
            r0 = 3
            java.lang.String r13 = r13.encoding()
            r6[r0] = r13
            okhttp3.s r13 = okhttp3.C8504s.m36516a(r6)
            java.lang.Class<java.lang.Iterable> r0 = java.lang.Iterable.class
            boolean r0 = r0.isAssignableFrom(r5)
            java.lang.String r2 = "@Part parameters using the MultipartBody.Part must not include a part name in the annotation."
            if (r0 == 0) goto L_0x0528
            boolean r0 = r11 instanceof java.lang.reflect.ParameterizedType
            if (r0 == 0) goto L_0x0504
            java.lang.reflect.ParameterizedType r11 = (java.lang.reflect.ParameterizedType) r11
            java.lang.reflect.Type r11 = retrofit2.C8662o.m37638a(r3, r11)
            java.lang.Class<okhttp3.w$b> r0 = okhttp3.MultipartBody.C8512b.class
            java.lang.Class r1 = retrofit2.C8662o.m37635a(r11)
            boolean r0 = r0.isAssignableFrom(r1)
            if (r0 != 0) goto L_0x04fd
            retrofit2.m r10 = r9.f29440a
            java.lang.annotation.Annotation[] r0 = r9.f29442c
            retrofit2.e r10 = r10.mo41360a(r11, r12, r0)
            retrofit2.i$f r11 = new retrofit2.i$f
            r11.m55922init(r13, r10)
            retrofit2.i r10 = r11.mo41328a()
            return r10
        L_0x04fd:
            java.lang.Object[] r11 = new java.lang.Object[r3]
            java.lang.RuntimeException r10 = r9.m37621a(r10, r2, r11)
            throw r10
        L_0x0504:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = r5.getSimpleName()
            r11.append(r12)
            r11.append(r4)
            java.lang.String r12 = r5.getSimpleName()
            r11.append(r12)
            r11.append(r1)
            java.lang.String r11 = r11.toString()
            java.lang.Object[] r12 = new java.lang.Object[r3]
            java.lang.RuntimeException r10 = r9.m37621a(r10, r11, r12)
            throw r10
        L_0x0528:
            boolean r0 = r5.isArray()
            if (r0 == 0) goto L_0x0557
            java.lang.Class r11 = r5.getComponentType()
            java.lang.Class r11 = retrofit2.ServiceMethod.m37616a(r11)
            java.lang.Class<okhttp3.w$b> r0 = okhttp3.MultipartBody.C8512b.class
            boolean r0 = r0.isAssignableFrom(r11)
            if (r0 != 0) goto L_0x0550
            retrofit2.m r10 = r9.f29440a
            java.lang.annotation.Annotation[] r0 = r9.f29442c
            retrofit2.e r10 = r10.mo41360a(r11, r12, r0)
            retrofit2.i$f r11 = new retrofit2.i$f
            r11.m55922init(r13, r10)
            retrofit2.i r10 = r11.mo41330b()
            return r10
        L_0x0550:
            java.lang.Object[] r11 = new java.lang.Object[r3]
            java.lang.RuntimeException r10 = r9.m37621a(r10, r2, r11)
            throw r10
        L_0x0557:
            java.lang.Class<okhttp3.w$b> r0 = okhttp3.MultipartBody.C8512b.class
            boolean r0 = r0.isAssignableFrom(r5)
            if (r0 != 0) goto L_0x056d
            retrofit2.m r10 = r9.f29440a
            java.lang.annotation.Annotation[] r0 = r9.f29442c
            retrofit2.e r10 = r10.mo41360a(r11, r12, r0)
            retrofit2.i$f r11 = new retrofit2.i$f
            r11.m55922init(r13, r10)
            return r11
        L_0x056d:
            java.lang.Object[] r11 = new java.lang.Object[r3]
            java.lang.RuntimeException r10 = r9.m37621a(r10, r2, r11)
            throw r10
        L_0x0574:
            java.lang.Object[] r11 = new java.lang.Object[r3]
            java.lang.String r12 = "@Part parameters can only be used with multipart encoding."
            java.lang.RuntimeException r10 = r9.m37621a(r10, r12, r11)
            throw r10
        L_0x057d:
            boolean r0 = r13 instanceof retrofit2.http.PartMap
            if (r0 == 0) goto L_0x0605
            boolean r0 = r9.f29455p
            if (r0 == 0) goto L_0x05fc
            r9.f29447h = r2
            java.lang.Class r0 = retrofit2.C8662o.m37635a(r11)
            java.lang.Class<java.util.Map> r1 = java.util.Map.class
            boolean r1 = r1.isAssignableFrom(r0)
            if (r1 == 0) goto L_0x05f3
            java.lang.Class<java.util.Map> r1 = java.util.Map.class
            java.lang.reflect.Type r11 = retrofit2.C8662o.m37648b(r11, r0, r1)
            boolean r0 = r11 instanceof java.lang.reflect.ParameterizedType
            if (r0 == 0) goto L_0x05ec
            java.lang.reflect.ParameterizedType r11 = (java.lang.reflect.ParameterizedType) r11
            java.lang.reflect.Type r0 = retrofit2.C8662o.m37638a(r3, r11)
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            if (r1 != r0) goto L_0x05d4
            java.lang.reflect.Type r11 = retrofit2.C8662o.m37638a(r2, r11)
            java.lang.Class<okhttp3.w$b> r0 = okhttp3.MultipartBody.C8512b.class
            java.lang.Class r1 = retrofit2.C8662o.m37635a(r11)
            boolean r0 = r0.isAssignableFrom(r1)
            if (r0 != 0) goto L_0x05cb
            retrofit2.m r10 = r9.f29440a
            java.lang.annotation.Annotation[] r0 = r9.f29442c
            retrofit2.e r10 = r10.mo41360a(r11, r12, r0)
            retrofit2.http.PartMap r13 = (retrofit2.http.PartMap) r13
            retrofit2.i$g r11 = new retrofit2.i$g
            java.lang.String r12 = r13.encoding()
            r11.m55923init(r10, r12)
            return r11
        L_0x05cb:
            java.lang.Object[] r11 = new java.lang.Object[r3]
            java.lang.String r12 = "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead."
            java.lang.RuntimeException r10 = r9.m37621a(r10, r12, r11)
            throw r10
        L_0x05d4:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "@PartMap keys must be of type String: "
            r11.append(r12)
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            java.lang.Object[] r12 = new java.lang.Object[r3]
            java.lang.RuntimeException r10 = r9.m37621a(r10, r11, r12)
            throw r10
        L_0x05ec:
            java.lang.Object[] r11 = new java.lang.Object[r3]
            java.lang.RuntimeException r10 = r9.m37621a(r10, r5, r11)
            throw r10
        L_0x05f3:
            java.lang.Object[] r11 = new java.lang.Object[r3]
            java.lang.String r12 = "@PartMap parameter type must be Map."
            java.lang.RuntimeException r10 = r9.m37621a(r10, r12, r11)
            throw r10
        L_0x05fc:
            java.lang.Object[] r11 = new java.lang.Object[r3]
            java.lang.String r12 = "@PartMap parameters can only be used with multipart encoding."
            java.lang.RuntimeException r10 = r9.m37621a(r10, r12, r11)
            throw r10
        L_0x0605:
            boolean r13 = r13 instanceof retrofit2.http.Body
            if (r13 == 0) goto L_0x0643
            boolean r13 = r9.f29454o
            if (r13 != 0) goto L_0x063a
            boolean r13 = r9.f29455p
            if (r13 != 0) goto L_0x063a
            boolean r13 = r9.f29448i
            if (r13 != 0) goto L_0x0631
            retrofit2.m r13 = r9.f29440a     // Catch:{ RuntimeException -> 0x0625 }
            java.lang.annotation.Annotation[] r0 = r9.f29442c     // Catch:{ RuntimeException -> 0x0625 }
            retrofit2.e r10 = r13.mo41360a(r11, r12, r0)     // Catch:{ RuntimeException -> 0x0625 }
            r9.f29448i = r2
            retrofit2.i$a r11 = new retrofit2.i$a
            r11.m55917init(r10)
            return r11
        L_0x0625:
            r12 = move-exception
            java.lang.Object[] r13 = new java.lang.Object[r2]
            r13[r3] = r11
            java.lang.String r11 = "Unable to create @Body converter for %s"
            java.lang.RuntimeException r10 = r9.m37623a(r12, r10, r11, r13)
            throw r10
        L_0x0631:
            java.lang.Object[] r11 = new java.lang.Object[r3]
            java.lang.String r12 = "Multiple @Body method annotations found."
            java.lang.RuntimeException r10 = r9.m37621a(r10, r12, r11)
            throw r10
        L_0x063a:
            java.lang.Object[] r11 = new java.lang.Object[r3]
            java.lang.String r12 = "@Body parameters cannot be used with form or multi-part encoding."
            java.lang.RuntimeException r10 = r9.m37621a(r10, r12, r11)
            throw r10
        L_0x0643:
            r10 = 0
            return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: retrofit2.ServiceMethod.C8661a.m37627a(int, java.lang.reflect.Type, java.lang.annotation.Annotation[], java.lang.annotation.Annotation):retrofit2.i");
        }

        /* renamed from: a */
        private void m37628a(int i, String str) {
            if (!ServiceMethod.f29427b.matcher(str).matches()) {
                throw m37621a(i, "@Path parameter name must match %s. Found: %s", ServiceMethod.f29426a.pattern(), str);
            } else if (!this.f29459t.contains(str)) {
                throw m37621a(i, "URL \"%s\" does not contain \"{%s}\".", this.f29456q, str);
            }
        }

        /* renamed from: c */
        private Converter<C8364ac, T> m37632c() {
            try {
                return this.f29440a.mo41365b(this.f29445f, this.f29441b.getAnnotations());
            } catch (RuntimeException e) {
                throw m37624a((Throwable) e, "Unable to create converter for %s", this.f29445f);
            }
        }

        /* renamed from: a */
        private RuntimeException m37622a(String str, Object... objArr) {
            return m37624a((Throwable) null, str, objArr);
        }

        /* renamed from: a */
        private RuntimeException m37624a(Throwable th, String str, Object... objArr) {
            String format = String.format(str, objArr);
            StringBuilder sb = new StringBuilder();
            sb.append(format);
            sb.append("\n    for method ");
            sb.append(this.f29441b.getDeclaringClass().getSimpleName());
            sb.append(".");
            sb.append(this.f29441b.getName());
            return new IllegalArgumentException(sb.toString(), th);
        }

        /* renamed from: a */
        private RuntimeException m37623a(Throwable th, int i, String str, Object... objArr) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" (parameter #");
            sb.append(i + 1);
            sb.append(")");
            return m37624a(th, sb.toString(), objArr);
        }

        /* renamed from: a */
        private RuntimeException m37621a(int i, String str, Object... objArr) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" (parameter #");
            sb.append(i + 1);
            sb.append(")");
            return m37622a(sb.toString(), objArr);
        }
    }

    ServiceMethod(C8661a<R, T> aVar) {
        this.f29428c = aVar.f29440a.mo41357a();
        this.f29429d = aVar.f29462w;
        this.f29430e = aVar.f29440a.mo41364b();
        this.f29431f = aVar.f29461v;
        this.f29432g = aVar.f29452m;
        this.f29433h = aVar.f29456q;
        this.f29434i = aVar.f29457r;
        this.f29435j = aVar.f29458s;
        this.f29436k = aVar.f29453n;
        this.f29437l = aVar.f29454o;
        this.f29438m = aVar.f29455p;
        this.f29439n = aVar.f29460u;
    }

    /* access modifiers changed from: varargs */
    /* renamed from: a */
    public C8379e mo41377a(@Nullable Object... objArr) throws IOException {
        C8656k kVar = new C8656k(this.f29432g, this.f29430e, this.f29433h, this.f29434i, this.f29435j, this.f29436k, this.f29437l, this.f29438m);
        ParameterHandler<?>[] iVarArr = this.f29439n;
        int length = objArr != null ? objArr.length : 0;
        if (length == iVarArr.length) {
            for (int i = 0; i < length; i++) {
                iVarArr[i].mo41329a(kVar, objArr[i]);
            }
            return this.f29428c.mo40177a(kVar.mo41342a());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Argument count (");
        sb.append(length);
        sb.append(") doesn't match expected count (");
        sb.append(iVarArr.length);
        sb.append(")");
        throw new IllegalArgumentException(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public T mo41376a(C8623b<R> bVar) {
        return this.f29429d.mo41286a(bVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public R mo41375a(C8364ac acVar) throws IOException {
        return this.f29431f.mo41274a(acVar);
    }

    /* renamed from: a */
    static Set<String> m37617a(String str) {
        Matcher matcher = f29426a.matcher(str);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (matcher.find()) {
            linkedHashSet.add(matcher.group(1));
        }
        return linkedHashSet;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Class<?>, code=java.lang.Class, for r1v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* renamed from: a */
    static java.lang.Class<?> m37616a(java.lang.Class r1) {
        /*
        java.lang.Class r0 = java.lang.Boolean.TYPE
        if (r0 != r1) goto L_0x0007
        java.lang.Class<java.lang.Boolean> r1 = java.lang.Boolean.class
        return r1
    L_0x0007:
        java.lang.Class r0 = java.lang.Byte.TYPE
        if (r0 != r1) goto L_0x000e
        java.lang.Class<java.lang.Byte> r1 = java.lang.Byte.class
        return r1
    L_0x000e:
        java.lang.Class r0 = java.lang.Character.TYPE
        if (r0 != r1) goto L_0x0015
        java.lang.Class<java.lang.Character> r1 = java.lang.Character.class
        return r1
    L_0x0015:
        java.lang.Class r0 = java.lang.Double.TYPE
        if (r0 != r1) goto L_0x001c
        java.lang.Class<java.lang.Double> r1 = java.lang.Double.class
        return r1
    L_0x001c:
        java.lang.Class r0 = java.lang.Float.TYPE
        if (r0 != r1) goto L_0x0023
        java.lang.Class<java.lang.Float> r1 = java.lang.Float.class
        return r1
    L_0x0023:
        java.lang.Class r0 = java.lang.Integer.TYPE
        if (r0 != r1) goto L_0x002a
        java.lang.Class<java.lang.Integer> r1 = java.lang.Integer.class
        return r1
    L_0x002a:
        java.lang.Class r0 = java.lang.Long.TYPE
        if (r0 != r1) goto L_0x0031
        java.lang.Class<java.lang.Long> r1 = java.lang.Long.class
        return r1
    L_0x0031:
        java.lang.Class r0 = java.lang.Short.TYPE
        if (r0 != r1) goto L_0x0037
        java.lang.Class<java.lang.Short> r1 = java.lang.Short.class
    L_0x0037:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.ServiceMethod.m37616a(java.lang.Class):java.lang.Class");
    }
}
