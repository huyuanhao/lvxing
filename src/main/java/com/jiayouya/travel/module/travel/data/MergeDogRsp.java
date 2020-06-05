package com.jiayouya.travel.module.travel.data;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/MergeDogRsp;", "", "merge", "Lcom/jiayouya/travel/module/travel/data/Extra;", "extra", "hb", "Lcom/jiayouya/travel/module/travel/data/HB;", "isUpgrade", "", "(Lcom/jiayouya/travel/module/travel/data/Extra;Lcom/jiayouya/travel/module/travel/data/Extra;Lcom/jiayouya/travel/module/travel/data/HB;Z)V", "getExtra", "()Lcom/jiayouya/travel/module/travel/data/Extra;", "getHb", "()Lcom/jiayouya/travel/module/travel/data/HB;", "()Z", "getMerge", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: MergeDogRsp.kt */
public final class MergeDogRsp {
    private final Extra extra;
    /* renamed from: hb */
    private final C3325HB f11911hb;
    private final boolean isUpgrade;
    private final Extra merge;

    public static /* synthetic */ MergeDogRsp copy$default(MergeDogRsp mergeDogRsp, Extra extra2, Extra extra3, C3325HB hb, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            extra2 = mergeDogRsp.merge;
        }
        if ((i & 2) != 0) {
            extra3 = mergeDogRsp.extra;
        }
        if ((i & 4) != 0) {
            hb = mergeDogRsp.f11911hb;
        }
        if ((i & 8) != 0) {
            z = mergeDogRsp.isUpgrade;
        }
        return mergeDogRsp.copy(extra2, extra3, hb, z);
    }

    public final Extra component1() {
        return this.merge;
    }

    public final Extra component2() {
        return this.extra;
    }

    public final C3325HB component3() {
        return this.f11911hb;
    }

    public final boolean component4() {
        return this.isUpgrade;
    }

    public final MergeDogRsp copy(Extra extra2, Extra extra3, C3325HB hb, boolean z) {
        C8271i.m35386b(extra2, "merge");
        return new MergeDogRsp(extra2, extra3, hb, z);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof MergeDogRsp) {
                MergeDogRsp mergeDogRsp = (MergeDogRsp) obj;
                if (C8271i.m35384a((Object) this.merge, (Object) mergeDogRsp.merge) && C8271i.m35384a((Object) this.extra, (Object) mergeDogRsp.extra) && C8271i.m35384a((Object) this.f11911hb, (Object) mergeDogRsp.f11911hb)) {
                    if (this.isUpgrade == mergeDogRsp.isUpgrade) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Extra extra2 = this.merge;
        int i = 0;
        int hashCode = (extra2 != null ? extra2.hashCode() : 0) * 31;
        Extra extra3 = this.extra;
        int hashCode2 = (hashCode + (extra3 != null ? extra3.hashCode() : 0)) * 31;
        C3325HB hb = this.f11911hb;
        if (hb != null) {
            i = hb.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z = this.isUpgrade;
        if (z) {
            z = true;
        }
        return i2 + z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MergeDogRsp(merge=");
        sb.append(this.merge);
        sb.append(", extra=");
        sb.append(this.extra);
        sb.append(", hb=");
        sb.append(this.f11911hb);
        sb.append(", isUpgrade=");
        sb.append(this.isUpgrade);
        sb.append(")");
        return sb.toString();
    }

    public MergeDogRsp(Extra extra2, Extra extra3, C3325HB hb, boolean z) {
        C8271i.m35386b(extra2, "merge");
        this.merge = extra2;
        this.extra = extra3;
        this.f11911hb = hb;
        this.isUpgrade = z;
    }

    public final Extra getExtra() {
        return this.extra;
    }

    public final C3325HB getHb() {
        return this.f11911hb;
    }

    public final Extra getMerge() {
        return this.merge;
    }

    public final boolean isUpgrade() {
        return this.isUpgrade;
    }
}
