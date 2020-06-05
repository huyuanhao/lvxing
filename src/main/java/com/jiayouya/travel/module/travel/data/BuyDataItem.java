package com.jiayouya.travel.module.travel.data;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\t¨\u0006\u001c"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/BuyDataItem;", "Ljava/io/Serializable;", "coin", "", "dogId", "", "buyNum", "(Ljava/lang/String;II)V", "getBuyNum", "()I", "setBuyNum", "(I)V", "getCoin", "()Ljava/lang/String;", "setCoin", "(Ljava/lang/String;)V", "getDogId", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: BuyDataItem.kt */
public final class BuyDataItem implements Serializable {
    public static final Companion Companion = new Companion(null);
    public static final long serialVersionUID = 1;
    private int buyNum;
    private String coin;
    private final int dogId;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/BuyDataItem$Companion;", "", "()V", "serialVersionUID", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: BuyDataItem.kt */
    /* renamed from: com.jiayouya.travel.module.travel.data.BuyDataItem$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker fVar) {
            this();
        }
    }

    public static /* synthetic */ BuyDataItem copy$default(BuyDataItem buyDataItem, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = buyDataItem.coin;
        }
        if ((i3 & 2) != 0) {
            i = buyDataItem.dogId;
        }
        if ((i3 & 4) != 0) {
            i2 = buyDataItem.buyNum;
        }
        return buyDataItem.copy(str, i, i2);
    }

    public final String component1() {
        return this.coin;
    }

    public final int component2() {
        return this.dogId;
    }

    public final int component3() {
        return this.buyNum;
    }

    public final BuyDataItem copy(String str, int i, int i2) {
        C8271i.m35386b(str, "coin");
        return new BuyDataItem(str, i, i2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof BuyDataItem) {
                BuyDataItem buyDataItem = (BuyDataItem) obj;
                if (C8271i.m35384a((Object) this.coin, (Object) buyDataItem.coin)) {
                    if (this.dogId == buyDataItem.dogId) {
                        if (this.buyNum == buyDataItem.buyNum) {
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
        String str = this.coin;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.dogId) * 31) + this.buyNum;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BuyDataItem(coin=");
        sb.append(this.coin);
        sb.append(", dogId=");
        sb.append(this.dogId);
        sb.append(", buyNum=");
        sb.append(this.buyNum);
        sb.append(")");
        return sb.toString();
    }

    public BuyDataItem(String str, int i, int i2) {
        C8271i.m35386b(str, "coin");
        this.coin = str;
        this.dogId = i;
        this.buyNum = i2;
    }

    public final int getBuyNum() {
        return this.buyNum;
    }

    public final String getCoin() {
        return this.coin;
    }

    public final int getDogId() {
        return this.dogId;
    }

    public final void setBuyNum(int i) {
        this.buyNum = i;
    }

    public final void setCoin(String str) {
        C8271i.m35386b(str, "<set-?>");
        this.coin = str;
    }
}
