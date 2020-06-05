package com.jiayouya.travel.module.group.data;

import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, mo39189d2 = {"Lcom/jiayouya/travel/module/group/data/NextCity;", "", "id", "", "name", "", "percent", "", "distance", "(ILjava/lang/String;FLjava/lang/String;)V", "getDistance", "()Ljava/lang/String;", "getId", "()I", "getName", "getPercent", "()F", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: TravelCity.kt */
public final class NextCity {
    private final String distance;
    /* renamed from: id */
    private final int f11483id;
    private final String name;
    private final float percent;

    public static /* synthetic */ NextCity copy$default(NextCity nextCity, int i, String str, float f, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = nextCity.f11483id;
        }
        if ((i2 & 2) != 0) {
            str = nextCity.name;
        }
        if ((i2 & 4) != 0) {
            f = nextCity.percent;
        }
        if ((i2 & 8) != 0) {
            str2 = nextCity.distance;
        }
        return nextCity.copy(i, str, f, str2);
    }

    public final int component1() {
        return this.f11483id;
    }

    public final String component2() {
        return this.name;
    }

    public final float component3() {
        return this.percent;
    }

    public final String component4() {
        return this.distance;
    }

    public final NextCity copy(int i, String str, float f, String str2) {
        C8271i.m35386b(str, ArgKey.KEY_NAME);
        C8271i.m35386b(str2, "distance");
        return new NextCity(i, str, f, str2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof NextCity) {
                NextCity nextCity = (NextCity) obj;
                if (!(this.f11483id == nextCity.f11483id) || !C8271i.m35384a((Object) this.name, (Object) nextCity.name) || Float.compare(this.percent, nextCity.percent) != 0 || !C8271i.m35384a((Object) this.distance, (Object) nextCity.distance)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.f11483id * 31;
        String str = this.name;
        int i2 = 0;
        int hashCode = (((i + (str != null ? str.hashCode() : 0)) * 31) + Float.floatToIntBits(this.percent)) * 31;
        String str2 = this.distance;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NextCity(id=");
        sb.append(this.f11483id);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", percent=");
        sb.append(this.percent);
        sb.append(", distance=");
        sb.append(this.distance);
        sb.append(")");
        return sb.toString();
    }

    public NextCity(int i, String str, float f, String str2) {
        C8271i.m35386b(str, ArgKey.KEY_NAME);
        C8271i.m35386b(str2, "distance");
        this.f11483id = i;
        this.name = str;
        this.percent = f;
        this.distance = str2;
    }

    public final String getDistance() {
        return this.distance;
    }

    public final int getId() {
        return this.f11483id;
    }

    public final String getName() {
        return this.name;
    }

    public final float getPercent() {
        return this.percent;
    }
}
