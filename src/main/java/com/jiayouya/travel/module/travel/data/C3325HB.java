package com.jiayouya.travel.module.travel.data;

import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003JG\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\bHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\t\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0011\"\u0004\b\u0013\u0010\u0014¨\u0006!"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/HB;", "", "desc", "", "hbId", "desc2", "amount", "position", "", "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getAmount", "()Ljava/lang/String;", "getDesc", "getDesc2", "getHbId", "getPosition", "()I", "getType", "setType", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: MergeDogRsp.kt */
/* renamed from: com.jiayouya.travel.module.travel.data.HB */
public final class C3325HB {
    private final String amount;
    private final String desc;
    private final String desc2;
    private final String hbId;
    private final int position;
    private int type;

    public static /* synthetic */ C3325HB copy$default(C3325HB hb, String str, String str2, String str3, String str4, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = hb.desc;
        }
        if ((i3 & 2) != 0) {
            str2 = hb.hbId;
        }
        String str5 = str2;
        if ((i3 & 4) != 0) {
            str3 = hb.desc2;
        }
        String str6 = str3;
        if ((i3 & 8) != 0) {
            str4 = hb.amount;
        }
        String str7 = str4;
        if ((i3 & 16) != 0) {
            i = hb.position;
        }
        int i4 = i;
        if ((i3 & 32) != 0) {
            i2 = hb.type;
        }
        return hb.copy(str, str5, str6, str7, i4, i2);
    }

    public final String component1() {
        return this.desc;
    }

    public final String component2() {
        return this.hbId;
    }

    public final String component3() {
        return this.desc2;
    }

    public final String component4() {
        return this.amount;
    }

    public final int component5() {
        return this.position;
    }

    public final int component6() {
        return this.type;
    }

    public final C3325HB copy(String str, String str2, String str3, String str4, int i, int i2) {
        C8271i.m35386b(str, ArgKey.KEY_DESC);
        C8271i.m35386b(str2, "hbId");
        C8271i.m35386b(str4, "amount");
        C3325HB hb = new C3325HB(str, str2, str3, str4, i, i2);
        return hb;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof C3325HB) {
                C3325HB hb = (C3325HB) obj;
                if (C8271i.m35384a((Object) this.desc, (Object) hb.desc) && C8271i.m35384a((Object) this.hbId, (Object) hb.hbId) && C8271i.m35384a((Object) this.desc2, (Object) hb.desc2) && C8271i.m35384a((Object) this.amount, (Object) hb.amount)) {
                    if (this.position == hb.position) {
                        if (this.type == hb.type) {
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
        String str = this.desc;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.hbId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.desc2;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.amount;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return ((((hashCode3 + i) * 31) + this.position) * 31) + this.type;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HB(desc=");
        sb.append(this.desc);
        sb.append(", hbId=");
        sb.append(this.hbId);
        sb.append(", desc2=");
        sb.append(this.desc2);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(", position=");
        sb.append(this.position);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(")");
        return sb.toString();
    }

    public C3325HB(String str, String str2, String str3, String str4, int i, int i2) {
        C8271i.m35386b(str, ArgKey.KEY_DESC);
        C8271i.m35386b(str2, "hbId");
        C8271i.m35386b(str4, "amount");
        this.desc = str;
        this.hbId = str2;
        this.desc2 = str3;
        this.amount = str4;
        this.position = i;
        this.type = i2;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getHbId() {
        return this.hbId;
    }

    public /* synthetic */ C3325HB(String str, String str2, String str3, String str4, int i, int i2, int i3, DefaultConstructorMarker fVar) {
        String str5 = "";
        String str6 = (i3 & 2) != 0 ? str5 : str2;
        String str7 = (i3 & 4) != 0 ? null : str3;
        if ((i3 & 8) == 0) {
            str5 = str4;
        }
        this(str, str6, str7, str5, (i3 & 16) != 0 ? -1 : i, (i3 & 32) != 0 ? 1 : i2);
    }

    public final String getDesc2() {
        return this.desc2;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final int getPosition() {
        return this.position;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }
}
