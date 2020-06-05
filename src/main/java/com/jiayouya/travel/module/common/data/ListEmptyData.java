package com.jiayouya.travel.module.common.data;

import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0015"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/data/ListEmptyData;", "", "desc", "", "img", "", "(Ljava/lang/String;I)V", "getDesc", "()Ljava/lang/String;", "getImg", "()I", "setImg", "(I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: ListEmptyData.kt */
public final class ListEmptyData {
    private final String desc;
    private int img;

    public ListEmptyData() {
        this(null, 0, 3, null);
    }

    public static /* synthetic */ ListEmptyData copy$default(ListEmptyData listEmptyData, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = listEmptyData.desc;
        }
        if ((i2 & 2) != 0) {
            i = listEmptyData.img;
        }
        return listEmptyData.copy(str, i);
    }

    public final String component1() {
        return this.desc;
    }

    public final int component2() {
        return this.img;
    }

    public final ListEmptyData copy(String str, int i) {
        C8271i.m35386b(str, ArgKey.KEY_DESC);
        return new ListEmptyData(str, i);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ListEmptyData) {
                ListEmptyData listEmptyData = (ListEmptyData) obj;
                if (C8271i.m35384a((Object) this.desc, (Object) listEmptyData.desc)) {
                    if (this.img == listEmptyData.img) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.desc;
        return ((str != null ? str.hashCode() : 0) * 31) + this.img;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ListEmptyData(desc=");
        sb.append(this.desc);
        sb.append(", img=");
        sb.append(this.img);
        sb.append(")");
        return sb.toString();
    }

    public ListEmptyData(String str, int i) {
        C8271i.m35386b(str, ArgKey.KEY_DESC);
        this.desc = str;
        this.img = i;
    }

    public /* synthetic */ ListEmptyData(String str, int i, int i2, DefaultConstructorMarker fVar) {
        if ((i2 & 1) != 0) {
            str = "暂无数据";
        }
        if ((i2 & 2) != 0) {
            i = -1;
        }
        this(str, i);
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getImg() {
        return this.img;
    }

    public final void setImg(int i) {
        this.img = i;
    }
}
