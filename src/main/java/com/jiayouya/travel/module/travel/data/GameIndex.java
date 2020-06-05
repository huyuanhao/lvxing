package com.jiayouya.travel.module.travel.data;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/GameIndex;", "", "coin", "", "city", "Lcom/jiayouya/travel/module/travel/data/CityInfo;", "seconds", "", "offline", "Lcom/jiayouya/travel/module/travel/data/OfflineProfit;", "(DLcom/jiayouya/travel/module/travel/data/CityInfo;JLcom/jiayouya/travel/module/travel/data/OfflineProfit;)V", "getCity", "()Lcom/jiayouya/travel/module/travel/data/CityInfo;", "getCoin", "()D", "getOffline", "()Lcom/jiayouya/travel/module/travel/data/OfflineProfit;", "getSeconds", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: GameIndex.kt */
public final class GameIndex {
    private final CityInfo city;
    private final double coin;
    private final OfflineProfit offline;
    private final long seconds;

    public static /* synthetic */ GameIndex copy$default(GameIndex gameIndex, double d, CityInfo cityInfo, long j, OfflineProfit offlineProfit, int i, Object obj) {
        if ((i & 1) != 0) {
            d = gameIndex.coin;
        }
        double d2 = d;
        if ((i & 2) != 0) {
            cityInfo = gameIndex.city;
        }
        CityInfo cityInfo2 = cityInfo;
        if ((i & 4) != 0) {
            j = gameIndex.seconds;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            offlineProfit = gameIndex.offline;
        }
        return gameIndex.copy(d2, cityInfo2, j2, offlineProfit);
    }

    public final double component1() {
        return this.coin;
    }

    public final CityInfo component2() {
        return this.city;
    }

    public final long component3() {
        return this.seconds;
    }

    public final OfflineProfit component4() {
        return this.offline;
    }

    public final GameIndex copy(double d, CityInfo cityInfo, long j, OfflineProfit offlineProfit) {
        C8271i.m35386b(cityInfo, "city");
        GameIndex gameIndex = new GameIndex(d, cityInfo, j, offlineProfit);
        return gameIndex;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof GameIndex) {
                GameIndex gameIndex = (GameIndex) obj;
                if (Double.compare(this.coin, gameIndex.coin) == 0 && C8271i.m35384a((Object) this.city, (Object) gameIndex.city)) {
                    if (!(this.seconds == gameIndex.seconds) || !C8271i.m35384a((Object) this.offline, (Object) gameIndex.offline)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.coin);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31;
        CityInfo cityInfo = this.city;
        int i2 = 0;
        int hashCode = (i + (cityInfo != null ? cityInfo.hashCode() : 0)) * 31;
        long j = this.seconds;
        int i3 = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        OfflineProfit offlineProfit = this.offline;
        if (offlineProfit != null) {
            i2 = offlineProfit.hashCode();
        }
        return i3 + i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GameIndex(coin=");
        sb.append(this.coin);
        sb.append(", city=");
        sb.append(this.city);
        sb.append(", seconds=");
        sb.append(this.seconds);
        sb.append(", offline=");
        sb.append(this.offline);
        sb.append(")");
        return sb.toString();
    }

    public GameIndex(double d, CityInfo cityInfo, long j, OfflineProfit offlineProfit) {
        C8271i.m35386b(cityInfo, "city");
        this.coin = d;
        this.city = cityInfo;
        this.seconds = j;
        this.offline = offlineProfit;
    }

    public final CityInfo getCity() {
        return this.city;
    }

    public final double getCoin() {
        return this.coin;
    }

    public final OfflineProfit getOffline() {
        return this.offline;
    }

    public final long getSeconds() {
        return this.seconds;
    }
}
