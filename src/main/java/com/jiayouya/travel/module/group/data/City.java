package com.jiayouya.travel.module.group.data;

import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016"}, mo39189d2 = {"Lcom/jiayouya/travel/module/group/data/City;", "", "id", "", "status", "name", "", "(IILjava/lang/String;)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getStatus", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: TravelCity.kt */
public final class City {
    /* renamed from: id */
    private final int f11480id;
    private final String name;
    private final int status;

    public static /* synthetic */ City copy$default(City city, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = city.f11480id;
        }
        if ((i3 & 2) != 0) {
            i2 = city.status;
        }
        if ((i3 & 4) != 0) {
            str = city.name;
        }
        return city.copy(i, i2, str);
    }

    public final int component1() {
        return this.f11480id;
    }

    public final int component2() {
        return this.status;
    }

    public final String component3() {
        return this.name;
    }

    public final City copy(int i, int i2, String str) {
        C8271i.m35386b(str, ArgKey.KEY_NAME);
        return new City(i, i2, str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof City) {
                City city = (City) obj;
                if (this.f11480id == city.f11480id) {
                    if (!(this.status == city.status) || !C8271i.m35384a((Object) this.name, (Object) city.name)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = ((this.f11480id * 31) + this.status) * 31;
        String str = this.name;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("City(id=");
        sb.append(this.f11480id);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(")");
        return sb.toString();
    }

    public City(int i, int i2, String str) {
        C8271i.m35386b(str, ArgKey.KEY_NAME);
        this.f11480id = i;
        this.status = i2;
        this.name = str;
    }

    public final int getId() {
        return this.f11480id;
    }

    public final String getName() {
        return this.name;
    }

    public final int getStatus() {
        return this.status;
    }
}
