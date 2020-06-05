package com.jiayouya.travel.module.common.data;

import com.google.gson.annotations.SerializedName;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003JE\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010!\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\bHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\r¨\u0006%"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/data/PayChannelItem;", "", "name", "", "logo", "desc", "tips", "status", "", "isSelected", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V", "getDesc", "()Ljava/lang/String;", "()Z", "setSelected", "(Z)V", "key", "getKey", "setKey", "(Ljava/lang/String;)V", "getLogo", "getName", "getStatus", "()I", "getTips", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: PayChannelItem.kt */
public final class PayChannelItem {
    private final String desc;
    private boolean isSelected;
    @SerializedName(alternate = {"id"}, value = "key")
    private String key = "";
    private final String logo;
    private final String name;
    private final int status;
    private final String tips;

    public static /* synthetic */ PayChannelItem copy$default(PayChannelItem payChannelItem, String str, String str2, String str3, String str4, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = payChannelItem.name;
        }
        if ((i2 & 2) != 0) {
            str2 = payChannelItem.logo;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = payChannelItem.desc;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            str4 = payChannelItem.tips;
        }
        String str7 = str4;
        if ((i2 & 16) != 0) {
            i = payChannelItem.status;
        }
        int i3 = i;
        if ((i2 & 32) != 0) {
            z = payChannelItem.isSelected;
        }
        return payChannelItem.copy(str, str5, str6, str7, i3, z);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.logo;
    }

    public final String component3() {
        return this.desc;
    }

    public final String component4() {
        return this.tips;
    }

    public final int component5() {
        return this.status;
    }

    public final boolean component6() {
        return this.isSelected;
    }

    public final PayChannelItem copy(String str, String str2, String str3, String str4, int i, boolean z) {
        C8271i.m35386b(str, ArgKey.KEY_NAME);
        C8271i.m35386b(str2, "logo");
        C8271i.m35386b(str3, ArgKey.KEY_DESC);
        C8271i.m35386b(str4, "tips");
        PayChannelItem payChannelItem = new PayChannelItem(str, str2, str3, str4, i, z);
        return payChannelItem;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof PayChannelItem) {
                PayChannelItem payChannelItem = (PayChannelItem) obj;
                if (C8271i.m35384a((Object) this.name, (Object) payChannelItem.name) && C8271i.m35384a((Object) this.logo, (Object) payChannelItem.logo) && C8271i.m35384a((Object) this.desc, (Object) payChannelItem.desc) && C8271i.m35384a((Object) this.tips, (Object) payChannelItem.tips)) {
                    if (this.status == payChannelItem.status) {
                        if (this.isSelected == payChannelItem.isSelected) {
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
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.logo;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.desc;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.tips;
        if (str4 != null) {
            i = str4.hashCode();
        }
        int i2 = (((hashCode3 + i) * 31) + this.status) * 31;
        boolean z = this.isSelected;
        if (z) {
            z = true;
        }
        return i2 + z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PayChannelItem(name=");
        sb.append(this.name);
        sb.append(", logo=");
        sb.append(this.logo);
        sb.append(", desc=");
        sb.append(this.desc);
        sb.append(", tips=");
        sb.append(this.tips);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", isSelected=");
        sb.append(this.isSelected);
        sb.append(")");
        return sb.toString();
    }

    public PayChannelItem(String str, String str2, String str3, String str4, int i, boolean z) {
        C8271i.m35386b(str, ArgKey.KEY_NAME);
        C8271i.m35386b(str2, "logo");
        C8271i.m35386b(str3, ArgKey.KEY_DESC);
        C8271i.m35386b(str4, "tips");
        this.name = str;
        this.logo = str2;
        this.desc = str3;
        this.tips = str4;
        this.status = i;
        this.isSelected = z;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getLogo() {
        return this.logo;
    }

    public final String getName() {
        return this.name;
    }

    public final String getTips() {
        return this.tips;
    }

    public final int getStatus() {
        return this.status;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final String getKey() {
        return this.key;
    }

    public final void setKey(String str) {
        C8271i.m35386b(str, "<set-?>");
        this.key = str;
    }
}
