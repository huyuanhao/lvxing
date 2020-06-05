package com.jiayouya.travel.module.travel.data;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/CoinRankListItem;", "", "position", "", "level", "", "coin", "", "avatar", "nickname", "dogName", "(ILjava/lang/String;DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "getCoin", "()D", "getDogName", "getLevel", "getNickname", "getPosition", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: CoinRankListItem.kt */
public final class CoinRankListItem {
    private final String avatar;
    private final double coin;
    private final String dogName;
    private final String level;
    private final String nickname;
    private final int position;

    public static /* synthetic */ CoinRankListItem copy$default(CoinRankListItem coinRankListItem, int i, String str, double d, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = coinRankListItem.position;
        }
        if ((i2 & 2) != 0) {
            str = coinRankListItem.level;
        }
        String str5 = str;
        if ((i2 & 4) != 0) {
            d = coinRankListItem.coin;
        }
        double d2 = d;
        if ((i2 & 8) != 0) {
            str2 = coinRankListItem.avatar;
        }
        String str6 = str2;
        if ((i2 & 16) != 0) {
            str3 = coinRankListItem.nickname;
        }
        String str7 = str3;
        if ((i2 & 32) != 0) {
            str4 = coinRankListItem.dogName;
        }
        return coinRankListItem.copy(i, str5, d2, str6, str7, str4);
    }

    public final int component1() {
        return this.position;
    }

    public final String component2() {
        return this.level;
    }

    public final double component3() {
        return this.coin;
    }

    public final String component4() {
        return this.avatar;
    }

    public final String component5() {
        return this.nickname;
    }

    public final String component6() {
        return this.dogName;
    }

    public final CoinRankListItem copy(int i, String str, double d, String str2, String str3, String str4) {
        String str5 = str;
        C8271i.m35386b(str, "level");
        String str6 = str2;
        C8271i.m35386b(str2, "avatar");
        String str7 = str3;
        C8271i.m35386b(str3, "nickname");
        String str8 = str4;
        C8271i.m35386b(str8, "dogName");
        CoinRankListItem coinRankListItem = new CoinRankListItem(i, str5, d, str6, str7, str8);
        return coinRankListItem;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CoinRankListItem) {
                CoinRankListItem coinRankListItem = (CoinRankListItem) obj;
                if (!(this.position == coinRankListItem.position) || !C8271i.m35384a((Object) this.level, (Object) coinRankListItem.level) || Double.compare(this.coin, coinRankListItem.coin) != 0 || !C8271i.m35384a((Object) this.avatar, (Object) coinRankListItem.avatar) || !C8271i.m35384a((Object) this.nickname, (Object) coinRankListItem.nickname) || !C8271i.m35384a((Object) this.dogName, (Object) coinRankListItem.dogName)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.position * 31;
        String str = this.level;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        long doubleToLongBits = Double.doubleToLongBits(this.coin);
        int i3 = (hashCode + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        String str2 = this.avatar;
        int hashCode2 = (i3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.nickname;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.dogName;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CoinRankListItem(position=");
        sb.append(this.position);
        sb.append(", level=");
        sb.append(this.level);
        sb.append(", coin=");
        sb.append(this.coin);
        sb.append(", avatar=");
        sb.append(this.avatar);
        sb.append(", nickname=");
        sb.append(this.nickname);
        sb.append(", dogName=");
        sb.append(this.dogName);
        sb.append(")");
        return sb.toString();
    }

    public CoinRankListItem(int i, String str, double d, String str2, String str3, String str4) {
        C8271i.m35386b(str, "level");
        C8271i.m35386b(str2, "avatar");
        C8271i.m35386b(str3, "nickname");
        C8271i.m35386b(str4, "dogName");
        this.position = i;
        this.level = str;
        this.coin = d;
        this.avatar = str2;
        this.nickname = str3;
        this.dogName = str4;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final double getCoin() {
        return this.coin;
    }

    public final String getLevel() {
        return this.level;
    }

    public final int getPosition() {
        return this.position;
    }

    public final String getDogName() {
        return this.dogName;
    }

    public final String getNickname() {
        return this.nickname;
    }
}
