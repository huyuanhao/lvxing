package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\bH\u0002\u001a\f\u0010\t\u001a\u00020\u0001*\u00020\bH\u0002\u001a\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b*\u00020\bH\u0001¢\u0006\u0002\u0010\r\u001a\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\bH\u0001¢\u0006\u0002\b\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo39189d2 = {"COROUTINES_DEBUG_METADATA_VERSION", "", "checkDebugMetadataVersion", "", "expected", "actual", "getDebugMetadataAnnotation", "Lkotlin/coroutines/jvm/internal/DebugMetadata;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getLabel", "getSpilledVariableFieldMapping", "", "", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)[Ljava/lang/String;", "getStackTraceElementImpl", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "kotlin-stdlib"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: DebugMetadata.kt */
/* renamed from: kotlin.coroutines.jvm.internal.c */
public final class C8220c {
    /* renamed from: a */
    public static final StackTraceElement m35310a(BaseContinuationImpl baseContinuationImpl) {
        int i;
        String str;
        C8271i.m35386b(baseContinuationImpl, "$this$getStackTraceElementImpl");
        DebugMetadata b = m35312b(baseContinuationImpl);
        if (b == null) {
            return null;
        }
        m35311a(1, b.mo39376v());
        int c = m35313c(baseContinuationImpl);
        if (c < 0) {
            i = -1;
        } else {
            i = b.mo39372l()[c];
        }
        String a = C8221e.f27738b.mo39379a(baseContinuationImpl);
        if (a == null) {
            str = b.mo39369c();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(a);
            sb.append('/');
            sb.append(b.mo39369c());
            str = sb.toString();
        }
        return new StackTraceElement(str, b.mo39373m(), b.mo39370f(), i);
    }

    /* renamed from: b */
    private static final DebugMetadata m35312b(BaseContinuationImpl baseContinuationImpl) {
        return (DebugMetadata) baseContinuationImpl.getClass().getAnnotation(DebugMetadata.class);
    }

    /* renamed from: c */
    private static final int m35313c(BaseContinuationImpl baseContinuationImpl) {
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField("label");
            C8271i.m35382a((Object) declaredField, "field");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    /* renamed from: a */
    private static final void m35311a(int i, int i2) {
        if (i2 > i) {
            StringBuilder sb = new StringBuilder();
            sb.append("Debug metadata version mismatch. Expected: ");
            sb.append(i);
            sb.append(", got ");
            sb.append(i2);
            sb.append(". Please update the Kotlin standard library.");
            throw new IllegalStateException(sb.toString().toString());
        }
    }
}
