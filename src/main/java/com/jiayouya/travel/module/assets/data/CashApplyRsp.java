package com.jiayouya.travel.module.assets.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import com.tencent.stat.apkreader.ChannelReader;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001f"}, mo39189d2 = {"Lcom/jiayouya/travel/module/assets/data/CashApplyRsp;", "Landroid/os/Parcelable;", "desc", "", "amount", "fee", "channel", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/String;", "getChannel", "getDesc", "getFee", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: CashApplyRsp.kt */
public final class CashApplyRsp implements Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    private final String amount;
    private final String channel;
    private final String desc;
    private final String fee;

    @Metadata(mo39187bv = {1, 0, 3}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* renamed from: com.jiayouya.travel.module.assets.data.CashApplyRsp$Creator */
    public static class Creator implements android.os.Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            C8271i.m35386b(parcel, "in");
            return new CashApplyRsp(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new CashApplyRsp[i];
        }
    }

    public static /* synthetic */ CashApplyRsp copy$default(CashApplyRsp cashApplyRsp, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cashApplyRsp.desc;
        }
        if ((i & 2) != 0) {
            str2 = cashApplyRsp.amount;
        }
        if ((i & 4) != 0) {
            str3 = cashApplyRsp.fee;
        }
        if ((i & 8) != 0) {
            str4 = cashApplyRsp.channel;
        }
        return cashApplyRsp.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.desc;
    }

    public final String component2() {
        return this.amount;
    }

    public final String component3() {
        return this.fee;
    }

    public final String component4() {
        return this.channel;
    }

    public final CashApplyRsp copy(String str, String str2, String str3, String str4) {
        C8271i.m35386b(str, ArgKey.KEY_DESC);
        C8271i.m35386b(str2, "amount");
        C8271i.m35386b(str3, "fee");
        C8271i.m35386b(str4, ChannelReader.CHANNEL_KEY);
        return new CashApplyRsp(str, str2, str3, str4);
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r2.channel, (java.lang.Object) r3.channel) != false) goto L_0x0033;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0033
        boolean r0 = r3 instanceof com.jiayouya.travel.module.assets.data.CashApplyRsp
        if (r0 == 0) goto L_0x0031
        com.jiayouya.travel.module.assets.data.CashApplyRsp r3 = (com.jiayouya.travel.module.assets.data.CashApplyRsp) r3
        java.lang.String r0 = r2.desc
        java.lang.String r1 = r3.desc
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0031
        java.lang.String r0 = r2.amount
        java.lang.String r1 = r3.amount
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0031
        java.lang.String r0 = r2.fee
        java.lang.String r1 = r3.fee
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0031
        java.lang.String r0 = r2.channel
        java.lang.String r3 = r3.channel
        boolean r3 = kotlin.jvm.internal.C8271i.m35384a(r0, r3)
        if (r3 == 0) goto L_0x0031
        goto L_0x0033
    L_0x0031:
        r3 = 0
        return r3
    L_0x0033:
        r3 = 1
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.assets.data.CashApplyRsp.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.desc;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.amount;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.fee;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.channel;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashApplyRsp(desc=");
        sb.append(this.desc);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(", fee=");
        sb.append(this.fee);
        sb.append(", channel=");
        sb.append(this.channel);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C8271i.m35386b(parcel, "parcel");
        parcel.writeString(this.desc);
        parcel.writeString(this.amount);
        parcel.writeString(this.fee);
        parcel.writeString(this.channel);
    }

    public CashApplyRsp(String str, String str2, String str3, String str4) {
        C8271i.m35386b(str, ArgKey.KEY_DESC);
        C8271i.m35386b(str2, "amount");
        C8271i.m35386b(str3, "fee");
        C8271i.m35386b(str4, ChannelReader.CHANNEL_KEY);
        this.desc = str;
        this.amount = str2;
        this.fee = str3;
        this.channel = str4;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getFee() {
        return this.fee;
    }
}
