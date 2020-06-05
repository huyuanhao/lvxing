package kotlin.p677d;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.C8186j;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0016R\u000e\u0010\b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, mo39189d2 = {"Lkotlin/ranges/CharProgressionIterator;", "Lkotlin/collections/CharIterator;", "first", "", "last", "step", "", "(CCI)V", "finalElement", "hasNext", "", "next", "getStep", "()I", "nextChar", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: kotlin.d.b */
public final class ProgressionIterators extends C8186j {
    /* renamed from: a */
    private final int f27747a;
    /* renamed from: b */
    private boolean f27748b;
    /* renamed from: c */
    private int f27749c;
    /* renamed from: d */
    private final int f27750d;

    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=int, for r3v0, types: [int, char] */
    public ProgressionIterators(int r3, char r4, int r5) {
        /*
        r2 = this;
        r2.m54977init()
        r2.f27750d = r5
        r2.f27747a = r4
        int r5 = r2.f27750d
        r0 = 1
        r1 = 0
        if (r5 <= 0) goto L_0x0010
        if (r3 > r4) goto L_0x0013
        goto L_0x0014
    L_0x0010:
        if (r3 < r4) goto L_0x0013
        goto L_0x0014
    L_0x0013:
        r0 = 0
    L_0x0014:
        r2.f27748b = r0
        boolean r4 = r2.f27748b
        if (r4 == 0) goto L_0x001b
        goto L_0x001d
    L_0x001b:
        int r3 = r2.f27747a
    L_0x001d:
        r2.f27749c = r3
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.p677d.ProgressionIterators.m55029init(char, char, int):void");
    }

    public boolean hasNext() {
        return this.f27748b;
    }

    /* renamed from: b */
    public char mo39315b() {
        int i = this.f27749c;
        if (i != this.f27747a) {
            this.f27749c = this.f27750d + i;
        } else if (this.f27748b) {
            this.f27748b = false;
        } else {
            throw new NoSuchElementException();
        }
        return (char) i;
    }
}
