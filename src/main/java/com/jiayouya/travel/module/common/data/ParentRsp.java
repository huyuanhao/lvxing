package com.jiayouya.travel.module.common.data;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/data/ParentRsp;", "", "maxLevel", "", "nickname", "phone", "wx", "qq", "avatar", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "getMaxLevel", "getNickname", "getPhone", "getQq", "getWx", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: ParentRsp.kt */
public final class ParentRsp {
    private final String avatar;
    private final String maxLevel;
    private final String nickname;
    private final String phone;
    /* renamed from: qq */
    private final String f11294qq;
    /* renamed from: wx */
    private final String f11295wx;

    public static /* synthetic */ ParentRsp copy$default(ParentRsp parentRsp, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = parentRsp.maxLevel;
        }
        if ((i & 2) != 0) {
            str2 = parentRsp.nickname;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = parentRsp.phone;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = parentRsp.f11295wx;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = parentRsp.f11294qq;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = parentRsp.avatar;
        }
        return parentRsp.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.maxLevel;
    }

    public final String component2() {
        return this.nickname;
    }

    public final String component3() {
        return this.phone;
    }

    public final String component4() {
        return this.f11295wx;
    }

    public final String component5() {
        return this.f11294qq;
    }

    public final String component6() {
        return this.avatar;
    }

    public final ParentRsp copy(String str, String str2, String str3, String str4, String str5, String str6) {
        C8271i.m35386b(str, "maxLevel");
        C8271i.m35386b(str2, "nickname");
        C8271i.m35386b(str3, "phone");
        C8271i.m35386b(str4, "wx");
        C8271i.m35386b(str5, "qq");
        C8271i.m35386b(str6, "avatar");
        ParentRsp parentRsp = new ParentRsp(str, str2, str3, str4, str5, str6);
        return parentRsp;
    }

    /* JADX INFO: used method not loaded: kotlin.jvm.internal.i.a(java.lang.Object, java.lang.Object):null, types can be incorrect */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r2.avatar, (java.lang.Object) r3.avatar) != false) goto L_0x0047;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0047
        boolean r0 = r3 instanceof com.jiayouya.travel.module.common.data.ParentRsp
        if (r0 == 0) goto L_0x0045
        com.jiayouya.travel.module.common.data.ParentRsp r3 = (com.jiayouya.travel.module.common.data.ParentRsp) r3
        java.lang.String r0 = r2.maxLevel
        java.lang.String r1 = r3.maxLevel
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0045
        java.lang.String r0 = r2.nickname
        java.lang.String r1 = r3.nickname
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0045
        java.lang.String r0 = r2.phone
        java.lang.String r1 = r3.phone
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0045
        java.lang.String r0 = r2.f11295wx
        java.lang.String r1 = r3.f11295wx
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0045
        java.lang.String r0 = r2.f11294qq
        java.lang.String r1 = r3.f11294qq
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0045
        java.lang.String r0 = r2.avatar
        java.lang.String r3 = r3.avatar
        boolean r3 = kotlin.jvm.internal.C8271i.m35384a(r0, r3)
        if (r3 == 0) goto L_0x0045
        goto L_0x0047
    L_0x0045:
        r3 = 0
        return r3
    L_0x0047:
        r3 = 1
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.common.data.ParentRsp.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.maxLevel;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.nickname;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.phone;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f11295wx;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f11294qq;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.avatar;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ParentRsp(maxLevel=");
        sb.append(this.maxLevel);
        sb.append(", nickname=");
        sb.append(this.nickname);
        sb.append(", phone=");
        sb.append(this.phone);
        sb.append(", wx=");
        sb.append(this.f11295wx);
        sb.append(", qq=");
        sb.append(this.f11294qq);
        sb.append(", avatar=");
        sb.append(this.avatar);
        sb.append(")");
        return sb.toString();
    }

    public ParentRsp(String str, String str2, String str3, String str4, String str5, String str6) {
        C8271i.m35386b(str, "maxLevel");
        C8271i.m35386b(str2, "nickname");
        C8271i.m35386b(str3, "phone");
        C8271i.m35386b(str4, "wx");
        C8271i.m35386b(str5, "qq");
        C8271i.m35386b(str6, "avatar");
        this.maxLevel = str;
        this.nickname = str2;
        this.phone = str3;
        this.f11295wx = str4;
        this.f11294qq = str5;
        this.avatar = str6;
    }

    public final String getMaxLevel() {
        return this.maxLevel;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getWx() {
        return this.f11295wx;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getQq() {
        return this.f11294qq;
    }
}
