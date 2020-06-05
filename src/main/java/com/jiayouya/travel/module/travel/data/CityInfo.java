package com.jiayouya.travel.module.travel.data;

import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/CityInfo;", "", "id", "", "name", "", "percent", "", "(ILjava/lang/String;F)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getPercent", "()F", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: GameIndex.kt */
public final class CityInfo {
    /* renamed from: id */
    private final int f11904id;
    private final String name;
    private final float percent;

    public static /* synthetic */ CityInfo copy$default(CityInfo cityInfo, int i, String str, float f, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = cityInfo.f11904id;
        }
        if ((i2 & 2) != 0) {
            str = cityInfo.name;
        }
        if ((i2 & 4) != 0) {
            f = cityInfo.percent;
        }
        return cityInfo.copy(i, str, f);
    }

    public final int component1() {
        return this.f11904id;
    }

    public final String component2() {
        return this.name;
    }

    public final float component3() {
        return this.percent;
    }

    public final CityInfo copy(int i, String str, float f) {
        C8271i.m35386b(str, ArgKey.KEY_NAME);
        return new CityInfo(i, str, f);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CityInfo) {
                CityInfo cityInfo = (CityInfo) obj;
                if (!(this.f11904id == cityInfo.f11904id) || !C8271i.m35384a((Object) this.name, (Object) cityInfo.name) || Float.compare(this.percent, cityInfo.percent) != 0) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.f11904id * 31;
        String str = this.name;
        return ((i + (str != null ? str.hashCode() : 0)) * 31) + Float.floatToIntBits(this.percent);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CityInfo(id=");
        sb.append(this.f11904id);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", percent=");
        sb.append(this.percent);
        sb.append(")");
        return sb.toString();
    }

    public CityInfo(int i, String str, float f) {
        C8271i.m35386b(str, ArgKey.KEY_NAME);
        this.f11904id = i;
        this.name = str;
        this.percent = f;
    }

    public final int getId() {
        return this.f11904id;
    }

    public final String getName() {
        return this.name;
    }

    public final float getPercent() {
        return this.percent;
    }
}
