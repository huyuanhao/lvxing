package com.jiayouya.travel.module.travel.data;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/OpenHbRsp;", "", "type", "", "number", "", "(ILjava/lang/String;)V", "getNumber", "()Ljava/lang/String;", "getType", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: OpenHbRsp.kt */
public final class OpenHbRsp {
    private final String number;
    private final int type;

    public static /* synthetic */ OpenHbRsp copy$default(OpenHbRsp openHbRsp, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = openHbRsp.type;
        }
        if ((i2 & 2) != 0) {
            str = openHbRsp.number;
        }
        return openHbRsp.copy(i, str);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.number;
    }

    public final OpenHbRsp copy(int i, String str) {
        C8271i.m35386b(str, "number");
        return new OpenHbRsp(i, str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof OpenHbRsp) {
                OpenHbRsp openHbRsp = (OpenHbRsp) obj;
                if (!(this.type == openHbRsp.type) || !C8271i.m35384a((Object) this.number, (Object) openHbRsp.number)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.type * 31;
        String str = this.number;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OpenHbRsp(type=");
        sb.append(this.type);
        sb.append(", number=");
        sb.append(this.number);
        sb.append(")");
        return sb.toString();
    }

    public OpenHbRsp(int i, String str) {
        C8271i.m35386b(str, "number");
        this.type = i;
        this.number = str;
    }

    public final String getNumber() {
        return this.number;
    }

    public final int getType() {
        return this.type;
    }
}
