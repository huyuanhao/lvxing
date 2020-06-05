package com.jiayouya.travel.module.p276me.data;

import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/data/ClaimSuperDog;", "", "dogId", "", "level", "name", "", "desc", "(IILjava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getDogId", "()I", "getLevel", "getName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: ClaimSuperDog.kt */
/* renamed from: com.jiayouya.travel.module.me.data.ClaimSuperDog */
public final class ClaimSuperDog {
    private final String desc;
    private final int dogId;
    private final int level;
    private final String name;

    public static /* synthetic */ ClaimSuperDog copy$default(ClaimSuperDog claimSuperDog, int i, int i2, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = claimSuperDog.dogId;
        }
        if ((i3 & 2) != 0) {
            i2 = claimSuperDog.level;
        }
        if ((i3 & 4) != 0) {
            str = claimSuperDog.name;
        }
        if ((i3 & 8) != 0) {
            str2 = claimSuperDog.desc;
        }
        return claimSuperDog.copy(i, i2, str, str2);
    }

    public final int component1() {
        return this.dogId;
    }

    public final int component2() {
        return this.level;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.desc;
    }

    public final ClaimSuperDog copy(int i, int i2, String str, String str2) {
        C8271i.m35386b(str, ArgKey.KEY_NAME);
        C8271i.m35386b(str2, ArgKey.KEY_DESC);
        return new ClaimSuperDog(i, i2, str, str2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ClaimSuperDog) {
                ClaimSuperDog claimSuperDog = (ClaimSuperDog) obj;
                if (this.dogId == claimSuperDog.dogId) {
                    if (!(this.level == claimSuperDog.level) || !C8271i.m35384a((Object) this.name, (Object) claimSuperDog.name) || !C8271i.m35384a((Object) this.desc, (Object) claimSuperDog.desc)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = ((this.dogId * 31) + this.level) * 31;
        String str = this.name;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.desc;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ClaimSuperDog(dogId=");
        sb.append(this.dogId);
        sb.append(", level=");
        sb.append(this.level);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", desc=");
        sb.append(this.desc);
        sb.append(")");
        return sb.toString();
    }

    public ClaimSuperDog(int i, int i2, String str, String str2) {
        C8271i.m35386b(str, ArgKey.KEY_NAME);
        C8271i.m35386b(str2, ArgKey.KEY_DESC);
        this.dogId = i;
        this.level = i2;
        this.name = str;
        this.desc = str2;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getDogId() {
        return this.dogId;
    }

    public final int getLevel() {
        return this.level;
    }

    public final String getName() {
        return this.name;
    }
}
