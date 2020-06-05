package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\f\n\u0002\b\u0005\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0002H&¨\u0006\u0007"}, mo39189d2 = {"Lkotlin/collections/CharIterator;", "", "", "()V", "next", "()Ljava/lang/Character;", "nextChar", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: Iterators.kt */
/* renamed from: kotlin.collections.j */
public abstract class C8186j implements Iterator<Character> {
    /* renamed from: b */
    public abstract char mo39315b();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: a */
    public final Character next() {
        return Character.valueOf(mo39315b());
    }
}
