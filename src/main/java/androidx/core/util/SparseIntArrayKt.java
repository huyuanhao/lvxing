package androidx.core.util;

import android.util.SparseIntArray;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.C8192w;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8258m;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\n\u001a\u0015\u0010\b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\b\u001a\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0001H\b\u001aE\u0010\u000b\u001a\u00020\f*\u00020\u000226\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\f0\u000eH\b\u001a\u001d\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\b\u001a#\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014H\b\u001a\r\u0010\u0015\u001a\u00020\u0006*\u00020\u0002H\b\u001a\r\u0010\u0016\u001a\u00020\u0006*\u00020\u0002H\b\u001a\n\u0010\u0017\u001a\u00020\u0018*\u00020\u0002\u001a\u0015\u0010\u0019\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0002\u001a\u0012\u0010\u001b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u001a\u0010\u001c\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001\u001a\u001d\u0010\u001d\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001H\n\u001a\n\u0010\u001e\u001a\u00020\u0018*\u00020\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u001f"}, mo39189d2 = {"size", "", "Landroid/util/SparseIntArray;", "getSize", "(Landroid/util/SparseIntArray;)I", "contains", "", "key", "containsKey", "containsValue", "value", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getOrDefault", "defaultValue", "getOrElse", "Lkotlin/Function0;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", "plus", "other", "putAll", "remove", "set", "valueIterator", "core-ktx_release"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: SparseIntArray.kt */
public final class SparseIntArrayKt {
    public static final int getSize(SparseIntArray sparseIntArray) {
        C8271i.m35386b(sparseIntArray, "$this$size");
        return sparseIntArray.size();
    }

    public static final boolean contains(SparseIntArray sparseIntArray, int i) {
        C8271i.m35386b(sparseIntArray, "$this$contains");
        return sparseIntArray.indexOfKey(i) >= 0;
    }

    public static final void set(SparseIntArray sparseIntArray, int i, int i2) {
        C8271i.m35386b(sparseIntArray, "$this$set");
        sparseIntArray.put(i, i2);
    }

    public static final SparseIntArray plus(SparseIntArray sparseIntArray, SparseIntArray sparseIntArray2) {
        C8271i.m35386b(sparseIntArray, "$this$plus");
        C8271i.m35386b(sparseIntArray2, "other");
        SparseIntArray sparseIntArray3 = new SparseIntArray(sparseIntArray.size() + sparseIntArray2.size());
        putAll(sparseIntArray3, sparseIntArray);
        putAll(sparseIntArray3, sparseIntArray2);
        return sparseIntArray3;
    }

    public static final boolean containsKey(SparseIntArray sparseIntArray, int i) {
        C8271i.m35386b(sparseIntArray, "$this$containsKey");
        return sparseIntArray.indexOfKey(i) >= 0;
    }

    public static final boolean containsValue(SparseIntArray sparseIntArray, int i) {
        C8271i.m35386b(sparseIntArray, "$this$containsValue");
        return sparseIntArray.indexOfValue(i) != -1;
    }

    public static final int getOrDefault(SparseIntArray sparseIntArray, int i, int i2) {
        C8271i.m35386b(sparseIntArray, "$this$getOrDefault");
        return sparseIntArray.get(i, i2);
    }

    public static final int getOrElse(SparseIntArray sparseIntArray, int i, C8246a<Integer> aVar) {
        C8271i.m35386b(sparseIntArray, "$this$getOrElse");
        C8271i.m35386b(aVar, "defaultValue");
        int indexOfKey = sparseIntArray.indexOfKey(i);
        return indexOfKey != -1 ? sparseIntArray.valueAt(indexOfKey) : ((Number) aVar.invoke()).intValue();
    }

    public static final boolean isEmpty(SparseIntArray sparseIntArray) {
        C8271i.m35386b(sparseIntArray, "$this$isEmpty");
        return sparseIntArray.size() == 0;
    }

    public static final boolean isNotEmpty(SparseIntArray sparseIntArray) {
        C8271i.m35386b(sparseIntArray, "$this$isNotEmpty");
        return sparseIntArray.size() != 0;
    }

    public static final boolean remove(SparseIntArray sparseIntArray, int i, int i2) {
        C8271i.m35386b(sparseIntArray, "$this$remove");
        int indexOfKey = sparseIntArray.indexOfKey(i);
        if (indexOfKey == -1 || i2 != sparseIntArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseIntArray.removeAt(indexOfKey);
        return true;
    }

    public static final void forEach(SparseIntArray sparseIntArray, C8258m<? super Integer, ? super Integer, Unit> mVar) {
        C8271i.m35386b(sparseIntArray, "$this$forEach");
        C8271i.m35386b(mVar, "action");
        int size = sparseIntArray.size();
        for (int i = 0; i < size; i++) {
            mVar.invoke(Integer.valueOf(sparseIntArray.keyAt(i)), Integer.valueOf(sparseIntArray.valueAt(i)));
        }
    }

    public static final C8192w keyIterator(SparseIntArray sparseIntArray) {
        C8271i.m35386b(sparseIntArray, "$this$keyIterator");
        return new SparseIntArrayKt$keyIterator$1(sparseIntArray);
    }

    public static final C8192w valueIterator(SparseIntArray sparseIntArray) {
        C8271i.m35386b(sparseIntArray, "$this$valueIterator");
        return new SparseIntArrayKt$valueIterator$1(sparseIntArray);
    }

    public static final void putAll(SparseIntArray sparseIntArray, SparseIntArray sparseIntArray2) {
        C8271i.m35386b(sparseIntArray, "$this$putAll");
        C8271i.m35386b(sparseIntArray2, "other");
        int size = sparseIntArray2.size();
        for (int i = 0; i < size; i++) {
            sparseIntArray.put(sparseIntArray2.keyAt(i), sparseIntArray2.valueAt(i));
        }
    }
}
