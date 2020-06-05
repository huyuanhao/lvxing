package com.jiayouya.travel.module.travel.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\fHÆ\u0003J\t\u0010#\u001a\u00020\fHÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003JU\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0003HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020\fHÖ\u0001R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001a¨\u0006+"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/DogHomeRsp;", "", "tickets", "", "freeCoin", "", "positions", "", "Lcom/jiayouya/travel/module/travel/data/PositionItem;", "suggest", "Lcom/jiayouya/travel/module/travel/data/SuggestBuyItem;", "adProfit", "", "howToPlay", "walkDogId", "(IJLjava/util/List;Lcom/jiayouya/travel/module/travel/data/SuggestBuyItem;Ljava/lang/String;Ljava/lang/String;I)V", "getAdProfit", "()Ljava/lang/String;", "getFreeCoin", "()J", "getHowToPlay", "getPositions", "()Ljava/util/List;", "getSuggest", "()Lcom/jiayouya/travel/module/travel/data/SuggestBuyItem;", "getTickets", "()I", "setTickets", "(I)V", "getWalkDogId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: DogHomeRsp.kt */
public final class DogHomeRsp {
    private final String adProfit;
    private final long freeCoin;
    private final String howToPlay;
    private final List<PositionItem> positions;
    private final SuggestBuyItem suggest;
    private int tickets;
    private final int walkDogId;

    public static /* synthetic */ DogHomeRsp copy$default(DogHomeRsp dogHomeRsp, int i, long j, List list, SuggestBuyItem suggestBuyItem, String str, String str2, int i2, int i3, Object obj) {
        DogHomeRsp dogHomeRsp2 = dogHomeRsp;
        return dogHomeRsp.copy((i3 & 1) != 0 ? dogHomeRsp2.tickets : i, (i3 & 2) != 0 ? dogHomeRsp2.freeCoin : j, (i3 & 4) != 0 ? dogHomeRsp2.positions : list, (i3 & 8) != 0 ? dogHomeRsp2.suggest : suggestBuyItem, (i3 & 16) != 0 ? dogHomeRsp2.adProfit : str, (i3 & 32) != 0 ? dogHomeRsp2.howToPlay : str2, (i3 & 64) != 0 ? dogHomeRsp2.walkDogId : i2);
    }

    public final int component1() {
        return this.tickets;
    }

    public final long component2() {
        return this.freeCoin;
    }

    public final List<PositionItem> component3() {
        return this.positions;
    }

    public final SuggestBuyItem component4() {
        return this.suggest;
    }

    public final String component5() {
        return this.adProfit;
    }

    public final String component6() {
        return this.howToPlay;
    }

    public final int component7() {
        return this.walkDogId;
    }

    public final DogHomeRsp copy(int i, long j, List<PositionItem> list, SuggestBuyItem suggestBuyItem, String str, String str2, int i2) {
        List<PositionItem> list2 = list;
        C8271i.m35386b(list, "positions");
        SuggestBuyItem suggestBuyItem2 = suggestBuyItem;
        C8271i.m35386b(suggestBuyItem, "suggest");
        String str3 = str;
        C8271i.m35386b(str3, "adProfit");
        String str4 = str2;
        C8271i.m35386b(str4, "howToPlay");
        DogHomeRsp dogHomeRsp = new DogHomeRsp(i, j, list2, suggestBuyItem2, str3, str4, i2);
        return dogHomeRsp;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof DogHomeRsp) {
                DogHomeRsp dogHomeRsp = (DogHomeRsp) obj;
                if (this.tickets == dogHomeRsp.tickets) {
                    if ((this.freeCoin == dogHomeRsp.freeCoin) && C8271i.m35384a((Object) this.positions, (Object) dogHomeRsp.positions) && C8271i.m35384a((Object) this.suggest, (Object) dogHomeRsp.suggest) && C8271i.m35384a((Object) this.adProfit, (Object) dogHomeRsp.adProfit) && C8271i.m35384a((Object) this.howToPlay, (Object) dogHomeRsp.howToPlay)) {
                        if (this.walkDogId == dogHomeRsp.walkDogId) {
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
        int i = this.tickets * 31;
        long j = this.freeCoin;
        int i2 = (i + ((int) (j ^ (j >>> 32)))) * 31;
        List<PositionItem> list = this.positions;
        int i3 = 0;
        int hashCode = (i2 + (list != null ? list.hashCode() : 0)) * 31;
        SuggestBuyItem suggestBuyItem = this.suggest;
        int hashCode2 = (hashCode + (suggestBuyItem != null ? suggestBuyItem.hashCode() : 0)) * 31;
        String str = this.adProfit;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.howToPlay;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return ((hashCode3 + i3) * 31) + this.walkDogId;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DogHomeRsp(tickets=");
        sb.append(this.tickets);
        sb.append(", freeCoin=");
        sb.append(this.freeCoin);
        sb.append(", positions=");
        sb.append(this.positions);
        sb.append(", suggest=");
        sb.append(this.suggest);
        sb.append(", adProfit=");
        sb.append(this.adProfit);
        sb.append(", howToPlay=");
        sb.append(this.howToPlay);
        sb.append(", walkDogId=");
        sb.append(this.walkDogId);
        sb.append(")");
        return sb.toString();
    }

    public DogHomeRsp(int i, long j, List<PositionItem> list, SuggestBuyItem suggestBuyItem, String str, String str2, int i2) {
        C8271i.m35386b(list, "positions");
        C8271i.m35386b(suggestBuyItem, "suggest");
        C8271i.m35386b(str, "adProfit");
        C8271i.m35386b(str2, "howToPlay");
        this.tickets = i;
        this.freeCoin = j;
        this.positions = list;
        this.suggest = suggestBuyItem;
        this.adProfit = str;
        this.howToPlay = str2;
        this.walkDogId = i2;
    }

    public final long getFreeCoin() {
        return this.freeCoin;
    }

    public final List<PositionItem> getPositions() {
        return this.positions;
    }

    public final int getTickets() {
        return this.tickets;
    }

    public final void setTickets(int i) {
        this.tickets = i;
    }

    public final String getAdProfit() {
        return this.adProfit;
    }

    public final String getHowToPlay() {
        return this.howToPlay;
    }

    public final SuggestBuyItem getSuggest() {
        return this.suggest;
    }

    public final int getWalkDogId() {
        return this.walkDogId;
    }
}
