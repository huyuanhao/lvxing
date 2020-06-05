package com.jiayouya.travel.module.travel.data;

import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/DogInfo;", "", "name", "", "level", "", "dogId", "online", "", "offline", "superDog", "Lcom/jiayouya/travel/module/travel/data/SuperDog;", "(Ljava/lang/String;IIDDLcom/jiayouya/travel/module/travel/data/SuperDog;)V", "getDogId", "()I", "getLevel", "getName", "()Ljava/lang/String;", "getOffline", "()D", "getOnline", "getSuperDog", "()Lcom/jiayouya/travel/module/travel/data/SuperDog;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: DogInfo.kt */
public final class DogInfo {
    private final int dogId;
    private final int level;
    private final String name;
    private final double offline;
    private final double online;
    private final SuperDog superDog;

    public static /* synthetic */ DogInfo copy$default(DogInfo dogInfo, String str, int i, int i2, double d, double d2, SuperDog superDog2, int i3, Object obj) {
        DogInfo dogInfo2 = dogInfo;
        return dogInfo.copy((i3 & 1) != 0 ? dogInfo2.name : str, (i3 & 2) != 0 ? dogInfo2.level : i, (i3 & 4) != 0 ? dogInfo2.dogId : i2, (i3 & 8) != 0 ? dogInfo2.online : d, (i3 & 16) != 0 ? dogInfo2.offline : d2, (i3 & 32) != 0 ? dogInfo2.superDog : superDog2);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.level;
    }

    public final int component3() {
        return this.dogId;
    }

    public final double component4() {
        return this.online;
    }

    public final double component5() {
        return this.offline;
    }

    public final SuperDog component6() {
        return this.superDog;
    }

    public final DogInfo copy(String str, int i, int i2, double d, double d2, SuperDog superDog2) {
        String str2 = str;
        C8271i.m35386b(str, ArgKey.KEY_NAME);
        SuperDog superDog3 = superDog2;
        C8271i.m35386b(superDog3, "superDog");
        DogInfo dogInfo = new DogInfo(str2, i, i2, d, d2, superDog3);
        return dogInfo;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof DogInfo) {
                DogInfo dogInfo = (DogInfo) obj;
                if (C8271i.m35384a((Object) this.name, (Object) dogInfo.name)) {
                    if (this.level == dogInfo.level) {
                        if (!(this.dogId == dogInfo.dogId) || Double.compare(this.online, dogInfo.online) != 0 || Double.compare(this.offline, dogInfo.offline) != 0 || !C8271i.m35384a((Object) this.superDog, (Object) dogInfo.superDog)) {
                            return false;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (((((str != null ? str.hashCode() : 0) * 31) + this.level) * 31) + this.dogId) * 31;
        long doubleToLongBits = Double.doubleToLongBits(this.online);
        int i2 = (hashCode + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.offline);
        int i3 = (i2 + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31;
        SuperDog superDog2 = this.superDog;
        if (superDog2 != null) {
            i = superDog2.hashCode();
        }
        return i3 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DogInfo(name=");
        sb.append(this.name);
        sb.append(", level=");
        sb.append(this.level);
        sb.append(", dogId=");
        sb.append(this.dogId);
        sb.append(", online=");
        sb.append(this.online);
        sb.append(", offline=");
        sb.append(this.offline);
        sb.append(", superDog=");
        sb.append(this.superDog);
        sb.append(")");
        return sb.toString();
    }

    public DogInfo(String str, int i, int i2, double d, double d2, SuperDog superDog2) {
        C8271i.m35386b(str, ArgKey.KEY_NAME);
        C8271i.m35386b(superDog2, "superDog");
        this.name = str;
        this.level = i;
        this.dogId = i2;
        this.online = d;
        this.offline = d2;
        this.superDog = superDog2;
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

    public final double getOnline() {
        return this.online;
    }

    public final double getOffline() {
        return this.offline;
    }

    public final SuperDog getSuperDog() {
        return this.superDog;
    }
}
