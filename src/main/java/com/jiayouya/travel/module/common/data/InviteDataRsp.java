package com.jiayouya.travel.module.common.data;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\bHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/data/InviteDataRsp;", "", "inviteCode", "", "children", "fans", "ruleUrl", "status", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getChildren", "()Ljava/lang/String;", "getFans", "getInviteCode", "getRuleUrl", "getStatus", "()I", "setStatus", "(I)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: InviteDataRsp.kt */
public final class InviteDataRsp {
    private final String children;
    private final String fans;
    private final String inviteCode;
    private final String ruleUrl;
    private int status;

    public static /* synthetic */ InviteDataRsp copy$default(InviteDataRsp inviteDataRsp, String str, String str2, String str3, String str4, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = inviteDataRsp.inviteCode;
        }
        if ((i2 & 2) != 0) {
            str2 = inviteDataRsp.children;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = inviteDataRsp.fans;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            str4 = inviteDataRsp.ruleUrl;
        }
        String str7 = str4;
        if ((i2 & 16) != 0) {
            i = inviteDataRsp.status;
        }
        return inviteDataRsp.copy(str, str5, str6, str7, i);
    }

    public final String component1() {
        return this.inviteCode;
    }

    public final String component2() {
        return this.children;
    }

    public final String component3() {
        return this.fans;
    }

    public final String component4() {
        return this.ruleUrl;
    }

    public final int component5() {
        return this.status;
    }

    public final InviteDataRsp copy(String str, String str2, String str3, String str4, int i) {
        C8271i.m35386b(str, "inviteCode");
        C8271i.m35386b(str2, "children");
        C8271i.m35386b(str3, "fans");
        C8271i.m35386b(str4, "ruleUrl");
        InviteDataRsp inviteDataRsp = new InviteDataRsp(str, str2, str3, str4, i);
        return inviteDataRsp;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof InviteDataRsp) {
                InviteDataRsp inviteDataRsp = (InviteDataRsp) obj;
                if (C8271i.m35384a((Object) this.inviteCode, (Object) inviteDataRsp.inviteCode) && C8271i.m35384a((Object) this.children, (Object) inviteDataRsp.children) && C8271i.m35384a((Object) this.fans, (Object) inviteDataRsp.fans) && C8271i.m35384a((Object) this.ruleUrl, (Object) inviteDataRsp.ruleUrl)) {
                    if (this.status == inviteDataRsp.status) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.inviteCode;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.children;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.fans;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.ruleUrl;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return ((hashCode3 + i) * 31) + this.status;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InviteDataRsp(inviteCode=");
        sb.append(this.inviteCode);
        sb.append(", children=");
        sb.append(this.children);
        sb.append(", fans=");
        sb.append(this.fans);
        sb.append(", ruleUrl=");
        sb.append(this.ruleUrl);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(")");
        return sb.toString();
    }

    public InviteDataRsp(String str, String str2, String str3, String str4, int i) {
        C8271i.m35386b(str, "inviteCode");
        C8271i.m35386b(str2, "children");
        C8271i.m35386b(str3, "fans");
        C8271i.m35386b(str4, "ruleUrl");
        this.inviteCode = str;
        this.children = str2;
        this.fans = str3;
        this.ruleUrl = str4;
        this.status = i;
    }

    public final String getChildren() {
        return this.children;
    }

    public final String getFans() {
        return this.fans;
    }

    public final String getInviteCode() {
        return this.inviteCode;
    }

    public final String getRuleUrl() {
        return this.ruleUrl;
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setStatus(int i) {
        this.status = i;
    }
}
