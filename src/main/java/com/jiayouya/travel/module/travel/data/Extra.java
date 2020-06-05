package com.jiayouya.travel.module.travel.data;

import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\fHÆ\u0003JQ\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015¨\u0006("}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/Extra;", "", "dogId", "", "level", "name", "", "desc", "position", "birthTime", "", "extra", "Lcom/jiayouya/travel/module/travel/data/PositionExtra;", "(IILjava/lang/String;Ljava/lang/String;IJLcom/jiayouya/travel/module/travel/data/PositionExtra;)V", "getBirthTime", "()J", "setBirthTime", "(J)V", "getDesc", "()Ljava/lang/String;", "getDogId", "()I", "getExtra", "()Lcom/jiayouya/travel/module/travel/data/PositionExtra;", "getLevel", "getName", "getPosition", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: MergeDogRsp.kt */
public final class Extra {
    private long birthTime;
    private final String desc;
    private final int dogId;
    private final PositionExtra extra;
    private final int level;
    private final String name;
    private final int position;

    public static /* synthetic */ Extra copy$default(Extra extra2, int i, int i2, String str, String str2, int i3, long j, PositionExtra positionExtra, int i4, Object obj) {
        Extra extra3 = extra2;
        return extra2.copy((i4 & 1) != 0 ? extra3.dogId : i, (i4 & 2) != 0 ? extra3.level : i2, (i4 & 4) != 0 ? extra3.name : str, (i4 & 8) != 0 ? extra3.desc : str2, (i4 & 16) != 0 ? extra3.position : i3, (i4 & 32) != 0 ? extra3.birthTime : j, (i4 & 64) != 0 ? extra3.extra : positionExtra);
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

    public final int component5() {
        return this.position;
    }

    public final long component6() {
        return this.birthTime;
    }

    public final PositionExtra component7() {
        return this.extra;
    }

    public final Extra copy(int i, int i2, String str, String str2, int i3, long j, PositionExtra positionExtra) {
        String str3 = str;
        C8271i.m35386b(str, ArgKey.KEY_NAME);
        String str4 = str2;
        C8271i.m35386b(str2, ArgKey.KEY_DESC);
        Extra extra2 = new Extra(i, i2, str3, str4, i3, j, positionExtra);
        return extra2;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Extra) {
                Extra extra2 = (Extra) obj;
                if (this.dogId == extra2.dogId) {
                    if ((this.level == extra2.level) && C8271i.m35384a((Object) this.name, (Object) extra2.name) && C8271i.m35384a((Object) this.desc, (Object) extra2.desc)) {
                        if (this.position == extra2.position) {
                            if (!(this.birthTime == extra2.birthTime) || !C8271i.m35384a((Object) this.extra, (Object) extra2.extra)) {
                                return false;
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
        int i = ((this.dogId * 31) + this.level) * 31;
        String str = this.name;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.desc;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.position) * 31;
        long j = this.birthTime;
        int i3 = (hashCode2 + ((int) (j ^ (j >>> 32)))) * 31;
        PositionExtra positionExtra = this.extra;
        if (positionExtra != null) {
            i2 = positionExtra.hashCode();
        }
        return i3 + i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Extra(dogId=");
        sb.append(this.dogId);
        sb.append(", level=");
        sb.append(this.level);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", desc=");
        sb.append(this.desc);
        sb.append(", position=");
        sb.append(this.position);
        sb.append(", birthTime=");
        sb.append(this.birthTime);
        sb.append(", extra=");
        sb.append(this.extra);
        sb.append(")");
        return sb.toString();
    }

    public Extra(int i, int i2, String str, String str2, int i3, long j, PositionExtra positionExtra) {
        C8271i.m35386b(str, ArgKey.KEY_NAME);
        C8271i.m35386b(str2, ArgKey.KEY_DESC);
        this.dogId = i;
        this.level = i2;
        this.name = str;
        this.desc = str2;
        this.position = i3;
        this.birthTime = j;
        this.extra = positionExtra;
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

    public final String getDesc() {
        return this.desc;
    }

    public final int getPosition() {
        return this.position;
    }

    public final long getBirthTime() {
        return this.birthTime;
    }

    public final void setBirthTime(long j) {
        this.birthTime = j;
    }

    public final PositionExtra getExtra() {
        return this.extra;
    }
}
