package kotlin.p677d;

import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.lang.Comparable;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\nH\u0016R\u0012\u0010\u0004\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\u000e"}, mo39189d2 = {"Lkotlin/ranges/ClosedRange;", "T", "", "", "endInclusive", "getEndInclusive", "()Ljava/lang/Comparable;", "start", "getStart", "contains", "", "value", "(Ljava/lang/Comparable;)Z", "isEmpty", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: kotlin.d.g */
public interface Range<T extends Comparable<? super T>> {

    @Metadata(mo39187bv = {1, 0, 3}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: Range.kt */
    /* renamed from: kotlin.d.g$a */
    public static final class C8227a {
        /* renamed from: a */
        public static <T extends Comparable<? super T>> boolean m35333a(Range<T> gVar, T t) {
            C8271i.m35386b(t, ArgKey.KEY_VALUE);
            return t.compareTo(gVar.getStart()) >= 0 && t.compareTo(gVar.getEndInclusive()) <= 0;
        }

        /* renamed from: a */
        public static <T extends Comparable<? super T>> boolean m35332a(Range<T> gVar) {
            return gVar.getStart().compareTo(gVar.getEndInclusive()) > 0;
        }
    }

    T getEndInclusive();

    T getStart();
}
