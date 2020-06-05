package com.jiayouya.travel.module.common.data;

import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import com.tencent.p605ep.commonbase.software.AppEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001e\b\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jg\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\bHÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006("}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/data/User;", "", "uid", "", "nickname", "avatar", "mobile", "state", "", "isBindAliPay", "", "bindAliType", "adIdInfoFlow", "host", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZILjava/lang/String;Ljava/lang/String;)V", "getAdIdInfoFlow", "()Ljava/lang/String;", "getAvatar", "getBindAliType", "()I", "getHost", "()Z", "getMobile", "getNickname", "getState", "getUid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: User.kt */
public final class User {
    private final String adIdInfoFlow;
    private final String avatar;
    private final int bindAliType;
    private final String host;
    private final boolean isBindAliPay;
    private final String mobile;
    private final String nickname;
    private final int state;
    private final String uid;

    public static /* synthetic */ User copy$default(User user, String str, String str2, String str3, String str4, int i, boolean z, int i2, String str5, String str6, int i3, Object obj) {
        User user2 = user;
        int i4 = i3;
        return user.copy((i4 & 1) != 0 ? user2.uid : str, (i4 & 2) != 0 ? user2.nickname : str2, (i4 & 4) != 0 ? user2.avatar : str3, (i4 & 8) != 0 ? user2.mobile : str4, (i4 & 16) != 0 ? user2.state : i, (i4 & 32) != 0 ? user2.isBindAliPay : z, (i4 & 64) != 0 ? user2.bindAliType : i2, (i4 & 128) != 0 ? user2.adIdInfoFlow : str5, (i4 & 256) != 0 ? user2.host : str6);
    }

    public final String component1() {
        return this.uid;
    }

    public final String component2() {
        return this.nickname;
    }

    public final String component3() {
        return this.avatar;
    }

    public final String component4() {
        return this.mobile;
    }

    public final int component5() {
        return this.state;
    }

    public final boolean component6() {
        return this.isBindAliPay;
    }

    public final int component7() {
        return this.bindAliType;
    }

    public final String component8() {
        return this.adIdInfoFlow;
    }

    public final String component9() {
        return this.host;
    }

    public final User copy(String str, String str2, String str3, String str4, int i, boolean z, int i2, String str5, String str6) {
        String str7 = str;
        C8271i.m35386b(str, AppEntity.KEY_UID);
        String str8 = str2;
        C8271i.m35386b(str2, "nickname");
        String str9 = str3;
        C8271i.m35386b(str3, "avatar");
        String str10 = str4;
        C8271i.m35386b(str4, ArgKey.KEY_MOBILE);
        User user = new User(str7, str8, str9, str10, i, z, i2, str5, str6);
        return user;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof User) {
                User user = (User) obj;
                if (C8271i.m35384a((Object) this.uid, (Object) user.uid) && C8271i.m35384a((Object) this.nickname, (Object) user.nickname) && C8271i.m35384a((Object) this.avatar, (Object) user.avatar) && C8271i.m35384a((Object) this.mobile, (Object) user.mobile)) {
                    if (this.state == user.state) {
                        if (this.isBindAliPay == user.isBindAliPay) {
                            if (!(this.bindAliType == user.bindAliType) || !C8271i.m35384a((Object) this.adIdInfoFlow, (Object) user.adIdInfoFlow) || !C8271i.m35384a((Object) this.host, (Object) user.host)) {
                                return false;
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.uid;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.nickname;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.avatar;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.mobile;
        int hashCode4 = (((hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.state) * 31;
        boolean z = this.isBindAliPay;
        if (z) {
            z = true;
        }
        int i2 = (((hashCode4 + z) * 31) + this.bindAliType) * 31;
        String str5 = this.adIdInfoFlow;
        int hashCode5 = (i2 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.host;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User(uid=");
        sb.append(this.uid);
        sb.append(", nickname=");
        sb.append(this.nickname);
        sb.append(", avatar=");
        sb.append(this.avatar);
        sb.append(", mobile=");
        sb.append(this.mobile);
        sb.append(", state=");
        sb.append(this.state);
        sb.append(", isBindAliPay=");
        sb.append(this.isBindAliPay);
        sb.append(", bindAliType=");
        sb.append(this.bindAliType);
        sb.append(", adIdInfoFlow=");
        sb.append(this.adIdInfoFlow);
        sb.append(", host=");
        sb.append(this.host);
        sb.append(")");
        return sb.toString();
    }

    public User(String str, String str2, String str3, String str4, int i, boolean z, int i2, String str5, String str6) {
        C8271i.m35386b(str, AppEntity.KEY_UID);
        C8271i.m35386b(str2, "nickname");
        C8271i.m35386b(str3, "avatar");
        C8271i.m35386b(str4, ArgKey.KEY_MOBILE);
        this.uid = str;
        this.nickname = str2;
        this.avatar = str3;
        this.mobile = str4;
        this.state = i;
        this.isBindAliPay = z;
        this.bindAliType = i2;
        this.adIdInfoFlow = str5;
        this.host = str6;
    }

    public final String getUid() {
        return this.uid;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getMobile() {
        return this.mobile;
    }

    public final int getState() {
        return this.state;
    }

    public final boolean isBindAliPay() {
        return this.isBindAliPay;
    }

    public final int getBindAliType() {
        return this.bindAliType;
    }

    public final String getAdIdInfoFlow() {
        return this.adIdInfoFlow;
    }

    public final String getHost() {
        return this.host;
    }
}
