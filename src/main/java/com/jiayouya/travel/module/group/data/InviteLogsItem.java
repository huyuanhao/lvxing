package com.jiayouya.travel.module.group.data;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JY\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006$"}, mo39189d2 = {"Lcom/jiayouya/travel/module/group/data/InviteLogsItem;", "", "qq", "", "wx", "maxLevel", "avatar", "nickname", "inviteTime", "isCertified", "", "contribution", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "getContribution", "getInviteTime", "()Z", "getMaxLevel", "getNickname", "getQq", "getWx", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: InviteLogsItem.kt */
public final class InviteLogsItem {
    private final String avatar;
    private final String contribution;
    private final String inviteTime;
    private final boolean isCertified;
    private final String maxLevel;
    private final String nickname;
    /* renamed from: qq */
    private final String f11481qq;
    /* renamed from: wx */
    private final String f11482wx;

    public static /* synthetic */ InviteLogsItem copy$default(InviteLogsItem inviteLogsItem, String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, int i, Object obj) {
        InviteLogsItem inviteLogsItem2 = inviteLogsItem;
        int i2 = i;
        return inviteLogsItem.copy((i2 & 1) != 0 ? inviteLogsItem2.f11481qq : str, (i2 & 2) != 0 ? inviteLogsItem2.f11482wx : str2, (i2 & 4) != 0 ? inviteLogsItem2.maxLevel : str3, (i2 & 8) != 0 ? inviteLogsItem2.avatar : str4, (i2 & 16) != 0 ? inviteLogsItem2.nickname : str5, (i2 & 32) != 0 ? inviteLogsItem2.inviteTime : str6, (i2 & 64) != 0 ? inviteLogsItem2.isCertified : z, (i2 & 128) != 0 ? inviteLogsItem2.contribution : str7);
    }

    public final String component1() {
        return this.f11481qq;
    }

    public final String component2() {
        return this.f11482wx;
    }

    public final String component3() {
        return this.maxLevel;
    }

    public final String component4() {
        return this.avatar;
    }

    public final String component5() {
        return this.nickname;
    }

    public final String component6() {
        return this.inviteTime;
    }

    public final boolean component7() {
        return this.isCertified;
    }

    public final String component8() {
        return this.contribution;
    }

    public final InviteLogsItem copy(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7) {
        String str8 = str;
        C8271i.m35386b(str, "qq");
        String str9 = str2;
        C8271i.m35386b(str2, "wx");
        String str10 = str3;
        C8271i.m35386b(str3, "maxLevel");
        String str11 = str4;
        C8271i.m35386b(str4, "avatar");
        String str12 = str5;
        C8271i.m35386b(str5, "nickname");
        String str13 = str6;
        C8271i.m35386b(str13, "inviteTime");
        String str14 = str7;
        C8271i.m35386b(str14, "contribution");
        InviteLogsItem inviteLogsItem = new InviteLogsItem(str8, str9, str10, str11, str12, str13, z, str14);
        return inviteLogsItem;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof InviteLogsItem) {
                InviteLogsItem inviteLogsItem = (InviteLogsItem) obj;
                if (C8271i.m35384a((Object) this.f11481qq, (Object) inviteLogsItem.f11481qq) && C8271i.m35384a((Object) this.f11482wx, (Object) inviteLogsItem.f11482wx) && C8271i.m35384a((Object) this.maxLevel, (Object) inviteLogsItem.maxLevel) && C8271i.m35384a((Object) this.avatar, (Object) inviteLogsItem.avatar) && C8271i.m35384a((Object) this.nickname, (Object) inviteLogsItem.nickname) && C8271i.m35384a((Object) this.inviteTime, (Object) inviteLogsItem.inviteTime)) {
                    if (!(this.isCertified == inviteLogsItem.isCertified) || !C8271i.m35384a((Object) this.contribution, (Object) inviteLogsItem.contribution)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f11481qq;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f11482wx;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.maxLevel;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.avatar;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.nickname;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.inviteTime;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        boolean z = this.isCertified;
        if (z) {
            z = true;
        }
        int i2 = (hashCode6 + z) * 31;
        String str7 = this.contribution;
        if (str7 != null) {
            i = str7.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InviteLogsItem(qq=");
        sb.append(this.f11481qq);
        sb.append(", wx=");
        sb.append(this.f11482wx);
        sb.append(", maxLevel=");
        sb.append(this.maxLevel);
        sb.append(", avatar=");
        sb.append(this.avatar);
        sb.append(", nickname=");
        sb.append(this.nickname);
        sb.append(", inviteTime=");
        sb.append(this.inviteTime);
        sb.append(", isCertified=");
        sb.append(this.isCertified);
        sb.append(", contribution=");
        sb.append(this.contribution);
        sb.append(")");
        return sb.toString();
    }

    public InviteLogsItem(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7) {
        C8271i.m35386b(str, "qq");
        C8271i.m35386b(str2, "wx");
        C8271i.m35386b(str3, "maxLevel");
        C8271i.m35386b(str4, "avatar");
        C8271i.m35386b(str5, "nickname");
        C8271i.m35386b(str6, "inviteTime");
        C8271i.m35386b(str7, "contribution");
        this.f11481qq = str;
        this.f11482wx = str2;
        this.maxLevel = str3;
        this.avatar = str4;
        this.nickname = str5;
        this.inviteTime = str6;
        this.isCertified = z;
        this.contribution = str7;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getMaxLevel() {
        return this.maxLevel;
    }

    public final String getQq() {
        return this.f11481qq;
    }

    public final String getWx() {
        return this.f11482wx;
    }

    public final String getContribution() {
        return this.contribution;
    }

    public final String getInviteTime() {
        return this.inviteTime;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final boolean isCertified() {
        return this.isCertified;
    }
}
