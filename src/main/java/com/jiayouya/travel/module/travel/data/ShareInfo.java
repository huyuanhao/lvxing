package com.jiayouya.travel.module.travel.data;

import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/ShareInfo;", "", "url", "", "desc", "inviteCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getInviteCode", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: ShareInfo.kt */
public final class ShareInfo {
    private final String desc;
    private final String inviteCode;
    private final String url;

    public static /* synthetic */ ShareInfo copy$default(ShareInfo shareInfo, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shareInfo.url;
        }
        if ((i & 2) != 0) {
            str2 = shareInfo.desc;
        }
        if ((i & 4) != 0) {
            str3 = shareInfo.inviteCode;
        }
        return shareInfo.copy(str, str2, str3);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.desc;
    }

    public final String component3() {
        return this.inviteCode;
    }

    public final ShareInfo copy(String str, String str2, String str3) {
        C8271i.m35386b(str, "url");
        C8271i.m35386b(str2, ArgKey.KEY_DESC);
        C8271i.m35386b(str3, "inviteCode");
        return new ShareInfo(str, str2, str3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r2.inviteCode, (java.lang.Object) r3.inviteCode) != false) goto L_0x0029;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0029
        boolean r0 = r3 instanceof com.jiayouya.travel.module.travel.data.ShareInfo
        if (r0 == 0) goto L_0x0027
        com.jiayouya.travel.module.travel.data.ShareInfo r3 = (com.jiayouya.travel.module.travel.data.ShareInfo) r3
        java.lang.String r0 = r2.url
        java.lang.String r1 = r3.url
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0027
        java.lang.String r0 = r2.desc
        java.lang.String r1 = r3.desc
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0027
        java.lang.String r0 = r2.inviteCode
        java.lang.String r3 = r3.inviteCode
        boolean r3 = kotlin.jvm.internal.C8271i.m35384a(r0, r3)
        if (r3 == 0) goto L_0x0027
        goto L_0x0029
    L_0x0027:
        r3 = 0
        return r3
    L_0x0029:
        r3 = 1
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.travel.data.ShareInfo.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.url;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.desc;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.inviteCode;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShareInfo(url=");
        sb.append(this.url);
        sb.append(", desc=");
        sb.append(this.desc);
        sb.append(", inviteCode=");
        sb.append(this.inviteCode);
        sb.append(")");
        return sb.toString();
    }

    public ShareInfo(String str, String str2, String str3) {
        C8271i.m35386b(str, "url");
        C8271i.m35386b(str2, ArgKey.KEY_DESC);
        C8271i.m35386b(str3, "inviteCode");
        this.url = str;
        this.desc = str2;
        this.inviteCode = str3;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getInviteCode() {
        return this.inviteCode;
    }

    public final String getUrl() {
        return this.url;
    }
}
