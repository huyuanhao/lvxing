package com.jiayouya.travel.module.travel.data;

import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0002\u0010\nJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\tHÆ\u0003JA\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\f¨\u0006\""}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/HandbookItem;", "", "id", "", "name", "", "image", "desc", "intro", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getDesc", "()Ljava/lang/String;", "getId", "()I", "getImage", "getIntro", "()Ljava/util/List;", "isFirst", "", "()Z", "setFirst", "(Z)V", "getName", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: HandbookItem.kt */
public final class HandbookItem {
    private final String desc;
    /* renamed from: id */
    private final int f11905id;
    private final String image;
    private final List<String> intro;
    private boolean isFirst;
    private final String name;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<java.lang.String>, for r8v0, types: [java.util.List] */
    public static /* synthetic */ com.jiayouya.travel.module.travel.data.HandbookItem copy$default(com.jiayouya.travel.module.travel.data.HandbookItem r3, int r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, java.util.List<java.lang.String> r8, int r9, java.lang.Object r10) {
        /*
        r10 = r9 & 1
        if (r10 == 0) goto L_0x0006
        int r4 = r3.f11905id
    L_0x0006:
        r10 = r9 & 2
        if (r10 == 0) goto L_0x000c
        java.lang.String r5 = r3.name
    L_0x000c:
        r10 = r5
        r5 = r9 & 4
        if (r5 == 0) goto L_0x0013
        java.lang.String r6 = r3.image
    L_0x0013:
        r0 = r6
        r5 = r9 & 8
        if (r5 == 0) goto L_0x001a
        java.lang.String r7 = r3.desc
    L_0x001a:
        r1 = r7
        r5 = r9 & 16
        if (r5 == 0) goto L_0x0021
        java.util.List<java.lang.String> r8 = r3.intro
    L_0x0021:
        r2 = r8
        r5 = r3
        r6 = r4
        r7 = r10
        r8 = r0
        r9 = r1
        r10 = r2
        com.jiayouya.travel.module.travel.data.HandbookItem r3 = r5.copy(r6, r7, r8, r9, r10)
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.travel.data.HandbookItem.copy$default(com.jiayouya.travel.module.travel.data.HandbookItem, int, java.lang.String, java.lang.String, java.lang.String, java.util.List, int, java.lang.Object):com.jiayouya.travel.module.travel.data.HandbookItem");
    }

    public final int component1() {
        return this.f11905id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.image;
    }

    public final String component4() {
        return this.desc;
    }

    public final List<String> component5() {
        return this.intro;
    }

    public final HandbookItem copy(int i, String str, String str2, String str3, List<String> list) {
        C8271i.m35386b(str, ArgKey.KEY_NAME);
        C8271i.m35386b(str2, "image");
        C8271i.m35386b(str3, ArgKey.KEY_DESC);
        C8271i.m35386b(list, "intro");
        HandbookItem handbookItem = new HandbookItem(i, str, str2, str3, list);
        return handbookItem;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof HandbookItem) {
                HandbookItem handbookItem = (HandbookItem) obj;
                if (!(this.f11905id == handbookItem.f11905id) || !C8271i.m35384a((Object) this.name, (Object) handbookItem.name) || !C8271i.m35384a((Object) this.image, (Object) handbookItem.image) || !C8271i.m35384a((Object) this.desc, (Object) handbookItem.desc) || !C8271i.m35384a((Object) this.intro, (Object) handbookItem.intro)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.f11905id * 31;
        String str = this.name;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.image;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.desc;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        List<String> list = this.intro;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode3 + i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HandbookItem(id=");
        sb.append(this.f11905id);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", image=");
        sb.append(this.image);
        sb.append(", desc=");
        sb.append(this.desc);
        sb.append(", intro=");
        sb.append(this.intro);
        sb.append(")");
        return sb.toString();
    }

    public HandbookItem(int i, String str, String str2, String str3, List<String> list) {
        C8271i.m35386b(str, ArgKey.KEY_NAME);
        C8271i.m35386b(str2, "image");
        C8271i.m35386b(str3, ArgKey.KEY_DESC);
        C8271i.m35386b(list, "intro");
        this.f11905id = i;
        this.name = str;
        this.image = str2;
        this.desc = str3;
        this.intro = list;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getId() {
        return this.f11905id;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getName() {
        return this.name;
    }

    public final List<String> getIntro() {
        return this.intro;
    }

    public final boolean isFirst() {
        return this.isFirst;
    }

    public final void setFirst(boolean z) {
        this.isFirst = z;
    }
}
