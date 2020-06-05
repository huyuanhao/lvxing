package retrofit2;

import javax.annotation.Nullable;
import okhttp3.C8362ab;
import okhttp3.C8364ac;

/* compiled from: Response */
/* renamed from: retrofit2.l */
public final class C8658l<T> {
    /* renamed from: a */
    private final C8362ab f29406a;
    @Nullable
    /* renamed from: b */
    private final T f29407b;
    @Nullable
    /* renamed from: c */
    private final C8364ac f29408c;

    /* renamed from: a */
    public static <T> C8658l<T> m37591a(@Nullable T t, C8362ab abVar) {
        C8662o.m37637a(abVar, "rawResponse == null");
        if (abVar.mo40093d()) {
            return new C8658l<>(abVar, t, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    /* renamed from: a */
    public static <T> C8658l<T> m37592a(C8364ac acVar, C8362ab abVar) {
        C8662o.m37637a(acVar, "body == null");
        C8662o.m37637a(abVar, "rawResponse == null");
        if (!abVar.mo40093d()) {
            return new C8658l<>(abVar, null, acVar);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    private C8658l(C8362ab abVar, @Nullable T t, @Nullable C8364ac acVar) {
        this.f29406a = abVar;
        this.f29407b = t;
        this.f29408c = acVar;
    }

    /* renamed from: a */
    public int mo41351a() {
        return this.f29406a.mo40091c();
    }

    /* renamed from: b */
    public String mo41352b() {
        return this.f29406a.mo40094e();
    }

    /* renamed from: c */
    public boolean mo41353c() {
        return this.f29406a.mo40093d();
    }

    @Nullable
    /* renamed from: d */
    public T mo41354d() {
        return this.f29407b;
    }

    public String toString() {
        return this.f29406a.toString();
    }
}
