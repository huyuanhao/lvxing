package com.jiayouya.travel.module.travel.data;

import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/MergeDialItem;", "", "id", "", "name", "", "image", "(ILjava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getImage", "()Ljava/lang/String;", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: MergeDialItem.kt */
public final class MergeDialItem {
    /* renamed from: id */
    private final int f11910id;
    private final String image;
    private final String name;

    public static /* synthetic */ MergeDialItem copy$default(MergeDialItem mergeDialItem, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mergeDialItem.f11910id;
        }
        if ((i2 & 2) != 0) {
            str = mergeDialItem.name;
        }
        if ((i2 & 4) != 0) {
            str2 = mergeDialItem.image;
        }
        return mergeDialItem.copy(i, str, str2);
    }

    public final int component1() {
        return this.f11910id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.image;
    }

    public final MergeDialItem copy(int i, String str, String str2) {
        C8271i.m35386b(str, ArgKey.KEY_NAME);
        C8271i.m35386b(str2, "image");
        return new MergeDialItem(i, str, str2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof MergeDialItem) {
                MergeDialItem mergeDialItem = (MergeDialItem) obj;
                if (!(this.f11910id == mergeDialItem.f11910id) || !C8271i.m35384a((Object) this.name, (Object) mergeDialItem.name) || !C8271i.m35384a((Object) this.image, (Object) mergeDialItem.image)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.f11910id * 31;
        String str = this.name;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.image;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MergeDialItem(id=");
        sb.append(this.f11910id);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", image=");
        sb.append(this.image);
        sb.append(")");
        return sb.toString();
    }

    public MergeDialItem(int i, String str, String str2) {
        C8271i.m35386b(str, ArgKey.KEY_NAME);
        C8271i.m35386b(str2, "image");
        this.f11910id = i;
        this.name = str;
        this.image = str2;
    }

    public final int getId() {
        return this.f11910id;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getName() {
        return this.name;
    }
}
