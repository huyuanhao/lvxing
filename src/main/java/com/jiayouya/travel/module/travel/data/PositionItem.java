package com.jiayouya.travel.module.travel.data;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001&B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J=\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006'"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/PositionItem;", "Ljava/io/Serializable;", "dogId", "", "level", "position", "birthTime", "", "extra", "Lcom/jiayouya/travel/module/travel/data/PositionExtra;", "(IIIJLcom/jiayouya/travel/module/travel/data/PositionExtra;)V", "getBirthTime", "()J", "setBirthTime", "(J)V", "getDogId", "()I", "setDogId", "(I)V", "getExtra", "()Lcom/jiayouya/travel/module/travel/data/PositionExtra;", "getLevel", "setLevel", "getPosition", "setPosition", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: PositionItem.kt */
public final class PositionItem implements Serializable {
    public static final Companion Companion = new Companion(null);
    public static final long serialVersionUID = 1;
    private long birthTime;
    private int dogId;
    private final PositionExtra extra;
    private int level;
    private int position;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/PositionItem$Companion;", "", "()V", "serialVersionUID", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: PositionItem.kt */
    /* renamed from: com.jiayouya.travel.module.travel.data.PositionItem$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker fVar) {
            this();
        }
    }

    public static /* synthetic */ PositionItem copy$default(PositionItem positionItem, int i, int i2, int i3, long j, PositionExtra positionExtra, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = positionItem.dogId;
        }
        if ((i4 & 2) != 0) {
            i2 = positionItem.level;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            i3 = positionItem.position;
        }
        int i6 = i3;
        if ((i4 & 8) != 0) {
            j = positionItem.birthTime;
        }
        long j2 = j;
        if ((i4 & 16) != 0) {
            positionExtra = positionItem.extra;
        }
        return positionItem.copy(i, i5, i6, j2, positionExtra);
    }

    public final int component1() {
        return this.dogId;
    }

    public final int component2() {
        return this.level;
    }

    public final int component3() {
        return this.position;
    }

    public final long component4() {
        return this.birthTime;
    }

    public final PositionExtra component5() {
        return this.extra;
    }

    public final PositionItem copy(int i, int i2, int i3, long j, PositionExtra positionExtra) {
        PositionItem positionItem = new PositionItem(i, i2, i3, j, positionExtra);
        return positionItem;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof PositionItem) {
                PositionItem positionItem = (PositionItem) obj;
                if (this.dogId == positionItem.dogId) {
                    if (this.level == positionItem.level) {
                        if (this.position == positionItem.position) {
                            if (!(this.birthTime == positionItem.birthTime) || !C8271i.m35384a((Object) this.extra, (Object) positionItem.extra)) {
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
        int i = ((((this.dogId * 31) + this.level) * 31) + this.position) * 31;
        long j = this.birthTime;
        int i2 = (i + ((int) (j ^ (j >>> 32)))) * 31;
        PositionExtra positionExtra = this.extra;
        return i2 + (positionExtra != null ? positionExtra.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PositionItem(dogId=");
        sb.append(this.dogId);
        sb.append(", level=");
        sb.append(this.level);
        sb.append(", position=");
        sb.append(this.position);
        sb.append(", birthTime=");
        sb.append(this.birthTime);
        sb.append(", extra=");
        sb.append(this.extra);
        sb.append(")");
        return sb.toString();
    }

    public PositionItem(int i, int i2, int i3, long j, PositionExtra positionExtra) {
        this.dogId = i;
        this.level = i2;
        this.position = i3;
        this.birthTime = j;
        this.extra = positionExtra;
    }

    public final long getBirthTime() {
        return this.birthTime;
    }

    public final int getDogId() {
        return this.dogId;
    }

    public final int getLevel() {
        return this.level;
    }

    public final int getPosition() {
        return this.position;
    }

    public final void setBirthTime(long j) {
        this.birthTime = j;
    }

    public final void setDogId(int i) {
        this.dogId = i;
    }

    public final void setLevel(int i) {
        this.level = i;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    public final PositionExtra getExtra() {
        return this.extra;
    }
}
