package kotlin.collections;

import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;
import kotlin.p673a.C8180a;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, mo39189d2 = {"<anonymous>", "", "T", "K", "", "it", "invoke", "(Ljava/lang/Object;)I"}, mo39190k = 3, mo39191mv = {1, 1, 15})
/* compiled from: Collections.kt */
public final class CollectionsKt__CollectionsKt$binarySearchBy$1 extends Lambda implements C8247b<T, Integer> {
    final /* synthetic */ Comparable $key;
    final /* synthetic */ C8247b $selector;

    public CollectionsKt__CollectionsKt$binarySearchBy$1(C8247b bVar, Comparable comparable) {
        this.$selector = bVar;
        this.$key = comparable;
        super(1);
    }

    public final int invoke(T t) {
        return C8180a.m35247a((Comparable) this.$selector.invoke(t), this.$key);
    }
}
