package com.jiayouya.travel.module.travel.data;

import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/BagItem;", "", "num", "", "name", "", "level", "dogId", "(ILjava/lang/String;II)V", "getDogId", "()I", "isSelected", "", "()Z", "setSelected", "(Z)V", "getLevel", "getName", "()Ljava/lang/String;", "getNum", "setNum", "(I)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: BagInfo.kt */
public final class BagItem {
    private final int dogId;
    private boolean isSelected;
    private final int level;
    private final String name;
    private int num;

    public static /* synthetic */ BagItem copy$default(BagItem bagItem, int i, String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = bagItem.num;
        }
        if ((i4 & 2) != 0) {
            str = bagItem.name;
        }
        if ((i4 & 4) != 0) {
            i2 = bagItem.level;
        }
        if ((i4 & 8) != 0) {
            i3 = bagItem.dogId;
        }
        return bagItem.copy(i, str, i2, i3);
    }

    public final int component1() {
        return this.num;
    }

    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.level;
    }

    public final int component4() {
        return this.dogId;
    }

    public final BagItem copy(int i, String str, int i2, int i3) {
        C8271i.m35386b(str, ArgKey.KEY_NAME);
        return new BagItem(i, str, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof BagItem) {
                BagItem bagItem = (BagItem) obj;
                if ((this.num == bagItem.num) && C8271i.m35384a((Object) this.name, (Object) bagItem.name)) {
                    if (this.level == bagItem.level) {
                        if (this.dogId == bagItem.dogId) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.num * 31;
        String str = this.name;
        return ((((i + (str != null ? str.hashCode() : 0)) * 31) + this.level) * 31) + this.dogId;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BagItem(num=");
        sb.append(this.num);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", level=");
        sb.append(this.level);
        sb.append(", dogId=");
        sb.append(this.dogId);
        sb.append(")");
        return sb.toString();
    }

    public BagItem(int i, String str, int i2, int i3) {
        C8271i.m35386b(str, ArgKey.KEY_NAME);
        this.num = i;
        this.name = str;
        this.level = i2;
        this.dogId = i3;
    }

    public final int getNum() {
        return this.num;
    }

    public final void setNum(int i) {
        this.num = i;
    }

    public final String getName() {
        return this.name;
    }

    public final int getLevel() {
        return this.level;
    }

    public final int getDogId() {
        return this.dogId;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }
}
