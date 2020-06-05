package com.jiayouya.travel.module.travel.data;

import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/HbInfo;", "", "hbId", "", "desc", "", "title", "image", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getHbId", "()I", "getImage", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: UpgradeHb.kt */
public final class HbInfo {
    private final String desc;
    private final int hbId;
    private final String image;
    private final String title;

    public static /* synthetic */ HbInfo copy$default(HbInfo hbInfo, int i, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = hbInfo.hbId;
        }
        if ((i2 & 2) != 0) {
            str = hbInfo.desc;
        }
        if ((i2 & 4) != 0) {
            str2 = hbInfo.title;
        }
        if ((i2 & 8) != 0) {
            str3 = hbInfo.image;
        }
        return hbInfo.copy(i, str, str2, str3);
    }

    public final int component1() {
        return this.hbId;
    }

    public final String component2() {
        return this.desc;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.image;
    }

    public final HbInfo copy(int i, String str, String str2, String str3) {
        C8271i.m35386b(str, ArgKey.KEY_DESC);
        C8271i.m35386b(str2, "title");
        C8271i.m35386b(str3, "image");
        return new HbInfo(i, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof HbInfo) {
                HbInfo hbInfo = (HbInfo) obj;
                if (!(this.hbId == hbInfo.hbId) || !C8271i.m35384a((Object) this.desc, (Object) hbInfo.desc) || !C8271i.m35384a((Object) this.title, (Object) hbInfo.title) || !C8271i.m35384a((Object) this.image, (Object) hbInfo.image)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hbId * 31;
        String str = this.desc;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.image;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HbInfo(hbId=");
        sb.append(this.hbId);
        sb.append(", desc=");
        sb.append(this.desc);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", image=");
        sb.append(this.image);
        sb.append(")");
        return sb.toString();
    }

    public HbInfo(int i, String str, String str2, String str3) {
        C8271i.m35386b(str, ArgKey.KEY_DESC);
        C8271i.m35386b(str2, "title");
        C8271i.m35386b(str3, "image");
        this.hbId = i;
        this.desc = str;
        this.title = str2;
        this.image = str3;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getHbId() {
        return this.hbId;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getTitle() {
        return this.title;
    }
}
