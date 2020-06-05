package com.jiayouya.travel.module.travel.data;

import kotlin.Metadata;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/MergeDialExtra;", "", "p1", "", "p2", "(II)V", "getP1", "()I", "getP2", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: MergeDialExtra.kt */
public final class MergeDialExtra {
    /* renamed from: p1 */
    private final int f11908p1;
    /* renamed from: p2 */
    private final int f11909p2;

    public static /* synthetic */ MergeDialExtra copy$default(MergeDialExtra mergeDialExtra, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = mergeDialExtra.f11908p1;
        }
        if ((i3 & 2) != 0) {
            i2 = mergeDialExtra.f11909p2;
        }
        return mergeDialExtra.copy(i, i2);
    }

    public final int component1() {
        return this.f11908p1;
    }

    public final int component2() {
        return this.f11909p2;
    }

    public final MergeDialExtra copy(int i, int i2) {
        return new MergeDialExtra(i, i2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof MergeDialExtra) {
                MergeDialExtra mergeDialExtra = (MergeDialExtra) obj;
                if (this.f11908p1 == mergeDialExtra.f11908p1) {
                    if (this.f11909p2 == mergeDialExtra.f11909p2) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f11908p1 * 31) + this.f11909p2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MergeDialExtra(p1=");
        sb.append(this.f11908p1);
        sb.append(", p2=");
        sb.append(this.f11909p2);
        sb.append(")");
        return sb.toString();
    }

    public MergeDialExtra(int i, int i2) {
        this.f11908p1 = i;
        this.f11909p2 = i2;
    }

    public final int getP1() {
        return this.f11908p1;
    }

    public final int getP2() {
        return this.f11909p2;
    }
}
