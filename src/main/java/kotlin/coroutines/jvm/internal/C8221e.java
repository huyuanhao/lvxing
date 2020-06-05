package kotlin.coroutines.jvm.internal;

import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo39189d2 = {"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever;", "", "()V", "cache", "Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "notOnJava9", "buildCache", "continuation", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getModuleName", "", "Cache", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: DebugMetadata.kt */
/* renamed from: kotlin.coroutines.jvm.internal.e */
final class C8221e {
    /* renamed from: a */
    public static C8222a f27737a;
    /* renamed from: b */
    public static final C8221e f27738b = new C8221e();
    /* renamed from: c */
    private static final C8222a f27739c = new C8222a(null, null, null);

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo39189d2 = {"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "", "getModuleMethod", "Ljava/lang/reflect/Method;", "getDescriptorMethod", "nameMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: DebugMetadata.kt */
    /* renamed from: kotlin.coroutines.jvm.internal.e$a */
    private static final class C8222a {
        /* renamed from: a */
        public final Method f27740a;
        /* renamed from: b */
        public final Method f27741b;
        /* renamed from: c */
        public final Method f27742c;

        public C8222a(Method method, Method method2, Method method3) {
            this.f27740a = method;
            this.f27741b = method2;
            this.f27742c = method3;
        }
    }

    private C8221e() {
    }

    /* renamed from: a */
    public final String mo39379a(BaseContinuationImpl baseContinuationImpl) {
        C8271i.m35386b(baseContinuationImpl, "continuation");
        C8222a aVar = f27737a;
        if (aVar == null) {
            aVar = m35315b(baseContinuationImpl);
        }
        if (aVar == f27739c) {
            return null;
        }
        Method method = aVar.f27740a;
        if (method != null) {
            Object invoke = method.invoke(baseContinuationImpl.getClass(), new Object[0]);
            if (invoke != null) {
                Method method2 = aVar.f27741b;
                if (method2 != null) {
                    Object invoke2 = method2.invoke(invoke, new Object[0]);
                    if (invoke2 != null) {
                        Method method3 = aVar.f27742c;
                        Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
                        if (!(invoke3 instanceof String)) {
                            invoke3 = null;
                        }
                        return (String) invoke3;
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    private final C8222a m35315b(BaseContinuationImpl baseContinuationImpl) {
        try {
            C8222a aVar = new C8222a(Class.class.getDeclaredMethod("getModule", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod(ArgKey.KEY_NAME, new Class[0]));
            f27737a = aVar;
            return aVar;
        } catch (Exception unused) {
            C8222a aVar2 = f27739c;
            f27737a = aVar2;
            return aVar2;
        }
    }
}
