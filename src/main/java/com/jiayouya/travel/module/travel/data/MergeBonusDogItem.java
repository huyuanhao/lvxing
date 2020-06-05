package com.jiayouya.travel.module.travel.data;

import kotlin.Metadata;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/MergeBonusDogItem;", "", "ozDogIndex", "", "mzDogIndex", "yzDogIndex", "fzDogIndex", "dyzDogIndex", "(IIIII)V", "getDyzDogIndex", "()I", "getFzDogIndex", "getMzDogIndex", "getOzDogIndex", "getYzDogIndex", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: MergeBonusDogItem.kt */
public final class MergeBonusDogItem {
    private final int dyzDogIndex;
    private final int fzDogIndex;
    private final int mzDogIndex;
    private final int ozDogIndex;
    private final int yzDogIndex;

    public static /* synthetic */ MergeBonusDogItem copy$default(MergeBonusDogItem mergeBonusDogItem, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = mergeBonusDogItem.ozDogIndex;
        }
        if ((i6 & 2) != 0) {
            i2 = mergeBonusDogItem.mzDogIndex;
        }
        int i7 = i2;
        if ((i6 & 4) != 0) {
            i3 = mergeBonusDogItem.yzDogIndex;
        }
        int i8 = i3;
        if ((i6 & 8) != 0) {
            i4 = mergeBonusDogItem.fzDogIndex;
        }
        int i9 = i4;
        if ((i6 & 16) != 0) {
            i5 = mergeBonusDogItem.dyzDogIndex;
        }
        return mergeBonusDogItem.copy(i, i7, i8, i9, i5);
    }

    public final int component1() {
        return this.ozDogIndex;
    }

    public final int component2() {
        return this.mzDogIndex;
    }

    public final int component3() {
        return this.yzDogIndex;
    }

    public final int component4() {
        return this.fzDogIndex;
    }

    public final int component5() {
        return this.dyzDogIndex;
    }

    public final MergeBonusDogItem copy(int i, int i2, int i3, int i4, int i5) {
        MergeBonusDogItem mergeBonusDogItem = new MergeBonusDogItem(i, i2, i3, i4, i5);
        return mergeBonusDogItem;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof MergeBonusDogItem) {
                MergeBonusDogItem mergeBonusDogItem = (MergeBonusDogItem) obj;
                if (this.ozDogIndex == mergeBonusDogItem.ozDogIndex) {
                    if (this.mzDogIndex == mergeBonusDogItem.mzDogIndex) {
                        if (this.yzDogIndex == mergeBonusDogItem.yzDogIndex) {
                            if (this.fzDogIndex == mergeBonusDogItem.fzDogIndex) {
                                if (this.dyzDogIndex == mergeBonusDogItem.dyzDogIndex) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((((this.ozDogIndex * 31) + this.mzDogIndex) * 31) + this.yzDogIndex) * 31) + this.fzDogIndex) * 31) + this.dyzDogIndex;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MergeBonusDogItem(ozDogIndex=");
        sb.append(this.ozDogIndex);
        sb.append(", mzDogIndex=");
        sb.append(this.mzDogIndex);
        sb.append(", yzDogIndex=");
        sb.append(this.yzDogIndex);
        sb.append(", fzDogIndex=");
        sb.append(this.fzDogIndex);
        sb.append(", dyzDogIndex=");
        sb.append(this.dyzDogIndex);
        sb.append(")");
        return sb.toString();
    }

    public MergeBonusDogItem(int i, int i2, int i3, int i4, int i5) {
        this.ozDogIndex = i;
        this.mzDogIndex = i2;
        this.yzDogIndex = i3;
        this.fzDogIndex = i4;
        this.dyzDogIndex = i5;
    }

    public final int getMzDogIndex() {
        return this.mzDogIndex;
    }

    public final int getOzDogIndex() {
        return this.ozDogIndex;
    }

    public final int getYzDogIndex() {
        return this.yzDogIndex;
    }

    public final int getDyzDogIndex() {
        return this.dyzDogIndex;
    }

    public final int getFzDogIndex() {
        return this.fzDogIndex;
    }
}
