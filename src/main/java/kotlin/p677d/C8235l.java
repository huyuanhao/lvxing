package kotlin.p677d;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.C8193x;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\b\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, mo39189d2 = {"Lkotlin/ranges/LongProgressionIterator;", "Lkotlin/collections/LongIterator;", "first", "", "last", "step", "(JJJ)V", "finalElement", "hasNext", "", "next", "getStep", "()J", "nextLong", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: ProgressionIterators.kt */
/* renamed from: kotlin.d.l */
public final class C8235l extends C8193x {
    /* renamed from: a */
    private final long f27771a;
    /* renamed from: b */
    private boolean f27772b;
    /* renamed from: c */
    private long f27773c;
    /* renamed from: d */
    private final long f27774d;

    public C8235l(long j, long j2, long j3) {
        this.f27774d = j3;
        this.f27771a = j2;
        boolean z = true;
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (this.f27774d <= 0 ? i < 0 : i > 0) {
            z = false;
        }
        this.f27772b = z;
        if (!this.f27772b) {
            j = this.f27771a;
        }
        this.f27773c = j;
    }

    public boolean hasNext() {
        return this.f27772b;
    }

    public long nextLong() {
        long j = this.f27773c;
        if (j != this.f27771a) {
            this.f27773c = this.f27774d + j;
        } else if (this.f27772b) {
            this.f27772b = false;
        } else {
            throw new NoSuchElementException();
        }
        return j;
    }
}
