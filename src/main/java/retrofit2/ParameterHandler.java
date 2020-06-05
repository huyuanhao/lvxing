package retrofit2;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import okhttp3.C8358aa;
import okhttp3.C8504s;
import okhttp3.MultipartBody.C8512b;

/* renamed from: retrofit2.i */
abstract class ParameterHandler<T> {

    /* compiled from: ParameterHandler */
    /* renamed from: retrofit2.i$a */
    static final class C8639a<T> extends ParameterHandler<T> {
        /* renamed from: a */
        private final Converter<T, C8358aa> f29367a;

        C8639a(Converter<T, C8358aa> eVar) {
            this.f29367a = eVar;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo41329a(C8656k kVar, @Nullable T t) {
            if (t != null) {
                try {
                    kVar.mo41346a((C8358aa) this.f29367a.mo41274a(t));
                } catch (IOException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unable to convert ");
                    sb.append(t);
                    sb.append(" to RequestBody");
                    throw new RuntimeException(sb.toString(), e);
                }
            } else {
                throw new IllegalArgumentException("Body parameter value must not be null.");
            }
        }
    }

    /* compiled from: ParameterHandler */
    /* renamed from: retrofit2.i$b */
    static final class C8640b<T> extends ParameterHandler<T> {
        /* renamed from: a */
        private final String f29368a;
        /* renamed from: b */
        private final Converter<T, String> f29369b;
        /* renamed from: c */
        private final boolean f29370c;

        C8640b(String str, Converter<T, String> eVar, boolean z) {
            this.f29368a = (String) C8662o.m37637a(str, "name == null");
            this.f29369b = eVar;
            this.f29370c = z;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo41329a(C8656k kVar, @Nullable T t) throws IOException {
            if (t != null) {
                String str = (String) this.f29369b.mo41274a(t);
                if (str != null) {
                    kVar.mo41350c(this.f29368a, str, this.f29370c);
                }
            }
        }
    }

    /* compiled from: ParameterHandler */
    /* renamed from: retrofit2.i$c */
    static final class C8641c<T> extends ParameterHandler<Map<String, T>> {
        /* renamed from: a */
        private final Converter<T, String> f29371a;
        /* renamed from: b */
        private final boolean f29372b;

        C8641c(Converter<T, String> eVar, boolean z) {
            this.f29371a = eVar;
            this.f29372b = z;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo41329a(C8656k kVar, @Nullable Map<String, T> map) throws IOException {
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str != null) {
                        Object value = entry.getValue();
                        String str2 = "'.";
                        if (value != null) {
                            String str3 = (String) this.f29371a.mo41274a(value);
                            if (str3 != null) {
                                kVar.mo41350c(str, str3, this.f29372b);
                            } else {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Field map value '");
                                sb.append(value);
                                sb.append("' converted to null by ");
                                sb.append(this.f29371a.getClass().getName());
                                sb.append(" for key '");
                                sb.append(str);
                                sb.append(str2);
                                throw new IllegalArgumentException(sb.toString());
                            }
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Field map contained null value for key '");
                            sb2.append(str);
                            sb2.append(str2);
                            throw new IllegalArgumentException(sb2.toString());
                        }
                    } else {
                        throw new IllegalArgumentException("Field map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Field map was null.");
        }
    }

    /* compiled from: ParameterHandler */
    /* renamed from: retrofit2.i$d */
    static final class C8642d<T> extends ParameterHandler<T> {
        /* renamed from: a */
        private final String f29373a;
        /* renamed from: b */
        private final Converter<T, String> f29374b;

        C8642d(String str, Converter<T, String> eVar) {
            this.f29373a = (String) C8662o.m37637a(str, "name == null");
            this.f29374b = eVar;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo41329a(C8656k kVar, @Nullable T t) throws IOException {
            if (t != null) {
                String str = (String) this.f29374b.mo41274a(t);
                if (str != null) {
                    kVar.mo41344a(this.f29373a, str);
                }
            }
        }
    }

    /* compiled from: ParameterHandler */
    /* renamed from: retrofit2.i$e */
    static final class C8643e<T> extends ParameterHandler<Map<String, T>> {
        /* renamed from: a */
        private final Converter<T, String> f29375a;

        C8643e(Converter<T, String> eVar) {
            this.f29375a = eVar;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo41329a(C8656k kVar, @Nullable Map<String, T> map) throws IOException {
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str != null) {
                        Object value = entry.getValue();
                        if (value != null) {
                            kVar.mo41344a(str, (String) this.f29375a.mo41274a(value));
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Header map contained null value for key '");
                            sb.append(str);
                            sb.append("'.");
                            throw new IllegalArgumentException(sb.toString());
                        }
                    } else {
                        throw new IllegalArgumentException("Header map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Header map was null.");
        }
    }

    /* compiled from: ParameterHandler */
    /* renamed from: retrofit2.i$f */
    static final class C8644f<T> extends ParameterHandler<T> {
        /* renamed from: a */
        private final C8504s f29376a;
        /* renamed from: b */
        private final Converter<T, C8358aa> f29377b;

        C8644f(C8504s sVar, Converter<T, C8358aa> eVar) {
            this.f29376a = sVar;
            this.f29377b = eVar;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo41329a(C8656k kVar, @Nullable T t) {
            if (t != null) {
                try {
                    kVar.mo41347a(this.f29376a, (C8358aa) this.f29377b.mo41274a(t));
                } catch (IOException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unable to convert ");
                    sb.append(t);
                    sb.append(" to RequestBody");
                    throw new RuntimeException(sb.toString(), e);
                }
            }
        }
    }

    /* compiled from: ParameterHandler */
    /* renamed from: retrofit2.i$g */
    static final class C8645g<T> extends ParameterHandler<Map<String, T>> {
        /* renamed from: a */
        private final Converter<T, C8358aa> f29378a;
        /* renamed from: b */
        private final String f29379b;

        C8645g(Converter<T, C8358aa> eVar, String str) {
            this.f29378a = eVar;
            this.f29379b = str;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo41329a(C8656k kVar, @Nullable Map<String, T> map) throws IOException {
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str != null) {
                        Object value = entry.getValue();
                        if (value != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("form-data; name=\"");
                            sb.append(str);
                            sb.append("\"");
                            kVar.mo41347a(C8504s.m36516a("Content-Disposition", sb.toString(), "Content-Transfer-Encoding", this.f29379b), (C8358aa) this.f29378a.mo41274a(value));
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Part map contained null value for key '");
                            sb2.append(str);
                            sb2.append("'.");
                            throw new IllegalArgumentException(sb2.toString());
                        }
                    } else {
                        throw new IllegalArgumentException("Part map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Part map was null.");
        }
    }

    /* compiled from: ParameterHandler */
    /* renamed from: retrofit2.i$h */
    static final class C8646h<T> extends ParameterHandler<T> {
        /* renamed from: a */
        private final String f29380a;
        /* renamed from: b */
        private final Converter<T, String> f29381b;
        /* renamed from: c */
        private final boolean f29382c;

        C8646h(String str, Converter<T, String> eVar, boolean z) {
            this.f29380a = (String) C8662o.m37637a(str, "name == null");
            this.f29381b = eVar;
            this.f29382c = z;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo41329a(C8656k kVar, @Nullable T t) throws IOException {
            if (t != null) {
                kVar.mo41345a(this.f29380a, (String) this.f29381b.mo41274a(t), this.f29382c);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Path parameter \"");
            sb.append(this.f29380a);
            sb.append("\" value must not be null.");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* compiled from: ParameterHandler */
    /* renamed from: retrofit2.i$i */
    static final class C8647i<T> extends ParameterHandler<T> {
        /* renamed from: a */
        private final String f29383a;
        /* renamed from: b */
        private final Converter<T, String> f29384b;
        /* renamed from: c */
        private final boolean f29385c;

        C8647i(String str, Converter<T, String> eVar, boolean z) {
            this.f29383a = (String) C8662o.m37637a(str, "name == null");
            this.f29384b = eVar;
            this.f29385c = z;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo41329a(C8656k kVar, @Nullable T t) throws IOException {
            if (t != null) {
                String str = (String) this.f29384b.mo41274a(t);
                if (str != null) {
                    kVar.mo41349b(this.f29383a, str, this.f29385c);
                }
            }
        }
    }

    /* compiled from: ParameterHandler */
    /* renamed from: retrofit2.i$j */
    static final class C8648j<T> extends ParameterHandler<Map<String, T>> {
        /* renamed from: a */
        private final Converter<T, String> f29386a;
        /* renamed from: b */
        private final boolean f29387b;

        C8648j(Converter<T, String> eVar, boolean z) {
            this.f29386a = eVar;
            this.f29387b = z;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo41329a(C8656k kVar, @Nullable Map<String, T> map) throws IOException {
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str != null) {
                        Object value = entry.getValue();
                        String str2 = "'.";
                        if (value != null) {
                            String str3 = (String) this.f29386a.mo41274a(value);
                            if (str3 != null) {
                                kVar.mo41349b(str, str3, this.f29387b);
                            } else {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Query map value '");
                                sb.append(value);
                                sb.append("' converted to null by ");
                                sb.append(this.f29386a.getClass().getName());
                                sb.append(" for key '");
                                sb.append(str);
                                sb.append(str2);
                                throw new IllegalArgumentException(sb.toString());
                            }
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Query map contained null value for key '");
                            sb2.append(str);
                            sb2.append(str2);
                            throw new IllegalArgumentException(sb2.toString());
                        }
                    } else {
                        throw new IllegalArgumentException("Query map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Query map was null.");
        }
    }

    /* compiled from: ParameterHandler */
    /* renamed from: retrofit2.i$k */
    static final class C8649k<T> extends ParameterHandler<T> {
        /* renamed from: a */
        private final Converter<T, String> f29388a;
        /* renamed from: b */
        private final boolean f29389b;

        C8649k(Converter<T, String> eVar, boolean z) {
            this.f29388a = eVar;
            this.f29389b = z;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo41329a(C8656k kVar, @Nullable T t) throws IOException {
            if (t != null) {
                kVar.mo41349b((String) this.f29388a.mo41274a(t), null, this.f29389b);
            }
        }
    }

    /* compiled from: ParameterHandler */
    /* renamed from: retrofit2.i$l */
    static final class C8650l extends ParameterHandler<C8512b> {
        /* renamed from: a */
        static final C8650l f29390a = new C8650l();

        private C8650l() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo41329a(C8656k kVar, @Nullable C8512b bVar) {
            if (bVar != null) {
                kVar.mo41348a(bVar);
            }
        }
    }

    /* compiled from: ParameterHandler */
    /* renamed from: retrofit2.i$m */
    static final class C8651m extends ParameterHandler<Object> {
        C8651m() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo41329a(C8656k kVar, @Nullable Object obj) {
            C8662o.m37637a(obj, "@Url parameter is null.");
            kVar.mo41343a(obj);
        }
    }

    /* renamed from: a */
    public abstract void mo41329a(C8656k kVar, @Nullable T t) throws IOException;

    ParameterHandler() {
    }

    /* access modifiers changed from: final */
    /* renamed from: a */
    public final ParameterHandler<Iterable<T>> mo41328a() {
        return new ParameterHandler<Iterable<T>>() {
            /* access modifiers changed from: 0000 */
            /* renamed from: a */
            public void mo41329a(C8656k kVar, @Nullable Iterable<T> iterable) throws IOException {
                if (iterable != null) {
                    for (T a : iterable) {
                        ParameterHandler.this.mo41329a(kVar, a);
                    }
                }
            }
        };
    }

    /* access modifiers changed from: final */
    /* renamed from: b */
    public final ParameterHandler<Object> mo41330b() {
        return new ParameterHandler<Object>() {
            /* access modifiers changed from: 0000 */
            /* renamed from: a */
            public void mo41329a(C8656k kVar, @Nullable Object obj) throws IOException {
                if (obj != null) {
                    int length = Array.getLength(obj);
                    for (int i = 0; i < length; i++) {
                        ParameterHandler.this.mo41329a(kVar, Array.get(obj, i));
                    }
                }
            }
        };
    }
}
