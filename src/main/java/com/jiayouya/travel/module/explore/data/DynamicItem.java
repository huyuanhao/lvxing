package com.jiayouya.travel.module.explore.data;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, mo39189d2 = {"Lcom/jiayouya/travel/module/explore/data/DynamicItem;", "", "type", "", "text", "", "time", "", "(ILjava/lang/String;J)V", "getText", "()Ljava/lang/String;", "getTime", "()J", "getType", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: ExploreIndex.kt */
public final class DynamicItem {
    private final String text;
    private final long time;
    private final int type;

    public static /* synthetic */ DynamicItem copy$default(DynamicItem dynamicItem, int i, String str, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = dynamicItem.type;
        }
        if ((i2 & 2) != 0) {
            str = dynamicItem.text;
        }
        if ((i2 & 4) != 0) {
            j = dynamicItem.time;
        }
        return dynamicItem.copy(i, str, j);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.text;
    }

    public final long component3() {
        return this.time;
    }

    public final DynamicItem copy(int i, String str, long j) {
        C8271i.m35386b(str, "text");
        return new DynamicItem(i, str, j);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof DynamicItem) {
                DynamicItem dynamicItem = (DynamicItem) obj;
                if ((this.type == dynamicItem.type) && C8271i.m35384a((Object) this.text, (Object) dynamicItem.text)) {
                    if (this.time == dynamicItem.time) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.type * 31;
        String str = this.text;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        long j = this.time;
        return hashCode + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DynamicItem(type=");
        sb.append(this.type);
        sb.append(", text=");
        sb.append(this.text);
        sb.append(", time=");
        sb.append(this.time);
        sb.append(")");
        return sb.toString();
    }

    public DynamicItem(int i, String str, long j) {
        C8271i.m35386b(str, "text");
        this.type = i;
        this.text = str;
        this.time = j;
    }

    public final String getText() {
        return this.text;
    }

    public final long getTime() {
        return this.time;
    }

    public final int getType() {
        return this.type;
    }
}
