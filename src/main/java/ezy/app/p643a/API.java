package ezy.app.p643a;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.C8271i;
import retrofit2.Retrofit;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005¢\u0006\u0002\u0010\u000bR\u001e\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo39189d2 = {"Lezy/app/net/API;", "", "()V", "apis", "", "Ljava/lang/Class;", "get", "T", "retrofit", "Lretrofit2/Retrofit;", "apiClass", "(Lretrofit2/Retrofit;Ljava/lang/Class;)Ljava/lang/Object;", "lib.framework_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: ezy.app.a.a */
public final class API {
    /* renamed from: a */
    public static final API f27251a = new API();
    /* renamed from: b */
    private static final Map<Class<?>, Object> f27252b = new HashMap();

    private API() {
    }

    /* renamed from: a */
    public final <T> T mo38533a(Retrofit mVar, Class<T> cls) {
        C8271i.m35386b(cls, "apiClass");
        if (f27252b.containsKey(cls)) {
            return f27252b.get(cls);
        }
        T a = mVar != null ? mVar.mo41356a(cls) : null;
        Map<Class<?>, Object> map = f27252b;
        if (a != null) {
            map.put(cls, a);
            return a;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Any");
    }
}
