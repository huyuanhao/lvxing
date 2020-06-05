package com.jiayouya.travel.module.group.data;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, mo39189d2 = {"Lcom/jiayouya/travel/module/group/data/Channel;", "", "profit", "", "contactInfo", "status", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getContactInfo", "()Ljava/lang/String;", "getProfit", "getStatus", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: GroupIndexRsp.kt */
public final class Channel {
    private final String contactInfo;
    private final String profit;
    private final int status;

    public static /* synthetic */ Channel copy$default(Channel channel, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = channel.profit;
        }
        if ((i2 & 2) != 0) {
            str2 = channel.contactInfo;
        }
        if ((i2 & 4) != 0) {
            i = channel.status;
        }
        return channel.copy(str, str2, i);
    }

    public final String component1() {
        return this.profit;
    }

    public final String component2() {
        return this.contactInfo;
    }

    public final int component3() {
        return this.status;
    }

    public final Channel copy(String str, String str2, int i) {
        C8271i.m35386b(str, "profit");
        C8271i.m35386b(str2, "contactInfo");
        return new Channel(str, str2, i);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Channel) {
                Channel channel = (Channel) obj;
                if (C8271i.m35384a((Object) this.profit, (Object) channel.profit) && C8271i.m35384a((Object) this.contactInfo, (Object) channel.contactInfo)) {
                    if (this.status == channel.status) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.profit;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.contactInfo;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode + i) * 31) + this.status;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Channel(profit=");
        sb.append(this.profit);
        sb.append(", contactInfo=");
        sb.append(this.contactInfo);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(")");
        return sb.toString();
    }

    public Channel(String str, String str2, int i) {
        C8271i.m35386b(str, "profit");
        C8271i.m35386b(str2, "contactInfo");
        this.profit = str;
        this.contactInfo = str2;
        this.status = i;
    }

    public final String getContactInfo() {
        return this.contactInfo;
    }

    public final String getProfit() {
        return this.profit;
    }

    public final int getStatus() {
        return this.status;
    }
}
