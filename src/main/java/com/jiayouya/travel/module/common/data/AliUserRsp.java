package com.jiayouya.travel.module.common.data;

import com.tencent.p605ep.commonbase.software.AppEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/data/AliUserRsp;", "", "uid", "", "nickname", "city", "avatar", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "getCity", "getNickname", "getUid", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: AliUserRsp.kt */
public final class AliUserRsp {
    private final String avatar;
    private final String city;
    private final String nickname;
    private final String uid;

    public static /* synthetic */ AliUserRsp copy$default(AliUserRsp aliUserRsp, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aliUserRsp.uid;
        }
        if ((i & 2) != 0) {
            str2 = aliUserRsp.nickname;
        }
        if ((i & 4) != 0) {
            str3 = aliUserRsp.city;
        }
        if ((i & 8) != 0) {
            str4 = aliUserRsp.avatar;
        }
        return aliUserRsp.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.uid;
    }

    public final String component2() {
        return this.nickname;
    }

    public final String component3() {
        return this.city;
    }

    public final String component4() {
        return this.avatar;
    }

    public final AliUserRsp copy(String str, String str2, String str3, String str4) {
        C8271i.m35386b(str, AppEntity.KEY_UID);
        C8271i.m35386b(str2, "nickname");
        C8271i.m35386b(str3, "city");
        C8271i.m35386b(str4, "avatar");
        return new AliUserRsp(str, str2, str3, str4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r2.avatar, (java.lang.Object) r3.avatar) != false) goto L_0x0033;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0033
        boolean r0 = r3 instanceof com.jiayouya.travel.module.common.data.AliUserRsp
        if (r0 == 0) goto L_0x0031
        com.jiayouya.travel.module.common.data.AliUserRsp r3 = (com.jiayouya.travel.module.common.data.AliUserRsp) r3
        java.lang.String r0 = r2.uid
        java.lang.String r1 = r3.uid
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0031
        java.lang.String r0 = r2.nickname
        java.lang.String r1 = r3.nickname
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0031
        java.lang.String r0 = r2.city
        java.lang.String r1 = r3.city
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0031
        java.lang.String r0 = r2.avatar
        java.lang.String r3 = r3.avatar
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
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.common.data.AliUserRsp.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.uid;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.nickname;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.city;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.avatar;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AliUserRsp(uid=");
        sb.append(this.uid);
        sb.append(", nickname=");
        sb.append(this.nickname);
        sb.append(", city=");
        sb.append(this.city);
        sb.append(", avatar=");
        sb.append(this.avatar);
        sb.append(")");
        return sb.toString();
    }

    public AliUserRsp(String str, String str2, String str3, String str4) {
        C8271i.m35386b(str, AppEntity.KEY_UID);
        C8271i.m35386b(str2, "nickname");
        C8271i.m35386b(str3, "city");
        C8271i.m35386b(str4, "avatar");
        this.uid = str;
        this.nickname = str2;
        this.city = str3;
        this.avatar = str4;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final String getUid() {
        return this.uid;
    }
}
