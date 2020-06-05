package kotlin.jvm.internal;

import java.util.Iterator;
import kotlin.Metadata;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, mo39189d2 = {"iterator", "", "T", "array", "", "([Ljava/lang/Object;)Ljava/util/Iterator;", "kotlin-stdlib"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: ArrayIterator.kt */
/* renamed from: kotlin.jvm.internal.b */
public final class C8270b {
    /* renamed from: a */
    public static final <T> Iterator<T> m35369a(T[] tArr) {
        C8271i.m35386b(tArr, "array");
        return new ArrayIterator<>(tArr);
    }
}
