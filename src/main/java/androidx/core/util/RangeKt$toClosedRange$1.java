package androidx.core.util;

import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import kotlin.p677d.Range;
import kotlin.p677d.Range.C8227a;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001R\u001c\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00018\u00008\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00018\u00008\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, mo39189d2 = {"androidx/core/util/RangeKt$toClosedRange$1", "Lkotlin/ranges/ClosedRange;", "endInclusive", "kotlin.jvm.PlatformType", "getEndInclusive", "()Ljava/lang/Comparable;", "start", "getStart", "core-ktx_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: Range.kt */
public final class RangeKt$toClosedRange$1 implements Range<T> {
    final /* synthetic */ android.util.Range $this_toClosedRange;

    RangeKt$toClosedRange$1(android.util.Range<T> range) {
        this.$this_toClosedRange = range;
    }

    public boolean contains(T t) {
        C8271i.m35386b(t, ArgKey.KEY_VALUE);
        return C8227a.m35333a(this, t);
    }

    public boolean isEmpty() {
        return C8227a.m35332a(this);
    }

    public T getEndInclusive() {
        return this.$this_toClosedRange.getUpper();
    }

    public T getStart() {
        return this.$this_toClosedRange.getLower();
    }
}
