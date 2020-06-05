package kotlin.p677d;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.C8192w;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\b\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, mo39189d2 = {"Lkotlin/ranges/IntProgressionIterator;", "Lkotlin/collections/IntIterator;", "first", "", "last", "step", "(III)V", "finalElement", "hasNext", "", "next", "getStep", "()I", "nextInt", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: ProgressionIterators.kt */
/* renamed from: kotlin.d.i */
public final class C8230i extends C8192w {
    /* renamed from: a */
    private final int f27761a;
    /* renamed from: b */
    private boolean f27762b;
    /* renamed from: c */
    private int f27763c;
    /* renamed from: d */
    private final int f27764d;

    public C8230i(int i, int i2, int i3) {
        this.f27764d = i3;
        this.f27761a = i2;
        boolean z = true;
        if (this.f27764d <= 0 ? i < i2 : i > i2) {
            z = false;
        }
        this.f27762b = z;
        if (!this.f27762b) {
            i = this.f27761a;
        }
        this.f27763c = i;
    }

    public boolean hasNext() {
        return this.f27762b;
    }

    public int nextInt() {
        int i = this.f27763c;
        if (i != this.f27761a) {
            this.f27763c = this.f27764d + i;
        } else if (this.f27762b) {
            this.f27762b = false;
        } else {
            throw new NoSuchElementException();
        }
        return i;
    }
}
