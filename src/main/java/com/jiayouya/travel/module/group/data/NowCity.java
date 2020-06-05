package com.jiayouya.travel.module.group.data;

import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, mo39189d2 = {"Lcom/jiayouya/travel/module/group/data/NowCity;", "", "id", "", "name", "", "(ILjava/lang/String;)V", "getId", "()I", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: TravelCity.kt */
public final class NowCity {
    /* renamed from: id */
    private final int f11484id;
    private final String name;

    public static /* synthetic */ NowCity copy$default(NowCity nowCity, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = nowCity.f11484id;
        }
        if ((i2 & 2) != 0) {
            str = nowCity.name;
        }
        return nowCity.copy(i, str);
    }

    public final int component1() {
        return this.f11484id;
    }

    public final String component2() {
        return this.name;
    }

    public final NowCity copy(int i, String str) {
        C8271i.m35386b(str, ArgKey.KEY_NAME);
        return new NowCity(i, str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof NowCity) {
                NowCity nowCity = (NowCity) obj;
                if (!(this.f11484id == nowCity.f11484id) || !C8271i.m35384a((Object) this.name, (Object) nowCity.name)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.f11484id * 31;
        String str = this.name;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NowCity(id=");
        sb.append(this.f11484id);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(")");
        return sb.toString();
    }

    public NowCity(int i, String str) {
        C8271i.m35386b(str, ArgKey.KEY_NAME);
        this.f11484id = i;
        this.name = str;
    }

    public final int getId() {
        return this.f11484id;
    }

    public final String getName() {
        return this.name;
    }
}
