package retrofit2.adapter.rxjava2;

import javax.annotation.Nullable;
import retrofit2.C8658l;

/* compiled from: Result */
/* renamed from: retrofit2.adapter.rxjava2.d */
public final class C8621d<T> {
    @Nullable
    /* renamed from: a */
    private final C8658l<T> f29323a;
    @Nullable
    /* renamed from: b */
    private final Throwable f29324b;

    /* renamed from: a */
    public static <T> C8621d<T> m37485a(Throwable th) {
        if (th != null) {
            return new C8621d<>(null, th);
        }
        throw new NullPointerException("error == null");
    }

    /* renamed from: a */
    public static <T> C8621d<T> m37486a(C8658l<T> lVar) {
        if (lVar != null) {
            return new C8621d<>(lVar, null);
        }
        throw new NullPointerException("response == null");
    }

    private C8621d(@Nullable C8658l<T> lVar, @Nullable Throwable th) {
        this.f29323a = lVar;
        this.f29324b = th;
    }
}
