package com.jiayouya.travel.module.common.data;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/data/SystemNotice;", "", "image", "", "route", "id", "title", "isForce", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "getImage", "()Z", "getRoute", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: SystemNotice.kt */
public final class SystemNotice {
    /* renamed from: id */
    private final String f11297id;
    private final String image;
    private final boolean isForce;
    private final String route;
    private final String title;

    public static /* synthetic */ SystemNotice copy$default(SystemNotice systemNotice, String str, String str2, String str3, String str4, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = systemNotice.image;
        }
        if ((i & 2) != 0) {
            str2 = systemNotice.route;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = systemNotice.f11297id;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = systemNotice.title;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            z = systemNotice.isForce;
        }
        return systemNotice.copy(str, str5, str6, str7, z);
    }

    public final String component1() {
        return this.image;
    }

    public final String component2() {
        return this.route;
    }

    public final String component3() {
        return this.f11297id;
    }

    public final String component4() {
        return this.title;
    }

    public final boolean component5() {
        return this.isForce;
    }

    public final SystemNotice copy(String str, String str2, String str3, String str4, boolean z) {
        C8271i.m35386b(str, "image");
        C8271i.m35386b(str2, "route");
        C8271i.m35386b(str3, "id");
        C8271i.m35386b(str4, "title");
        SystemNotice systemNotice = new SystemNotice(str, str2, str3, str4, z);
        return systemNotice;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof SystemNotice) {
                SystemNotice systemNotice = (SystemNotice) obj;
                if (C8271i.m35384a((Object) this.image, (Object) systemNotice.image) && C8271i.m35384a((Object) this.route, (Object) systemNotice.route) && C8271i.m35384a((Object) this.f11297id, (Object) systemNotice.f11297id) && C8271i.m35384a((Object) this.title, (Object) systemNotice.title)) {
                    if (this.isForce == systemNotice.isForce) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.image;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.route;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f11297id;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.title;
        if (str4 != null) {
            i = str4.hashCode();
        }
        int i2 = (hashCode3 + i) * 31;
        boolean z = this.isForce;
        if (z) {
            z = true;
        }
        return i2 + z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SystemNotice(image=");
        sb.append(this.image);
        sb.append(", route=");
        sb.append(this.route);
        sb.append(", id=");
        sb.append(this.f11297id);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", isForce=");
        sb.append(this.isForce);
        sb.append(")");
        return sb.toString();
    }

    public SystemNotice(String str, String str2, String str3, String str4, boolean z) {
        C8271i.m35386b(str, "image");
        C8271i.m35386b(str2, "route");
        C8271i.m35386b(str3, "id");
        C8271i.m35386b(str4, "title");
        this.image = str;
        this.route = str2;
        this.f11297id = str3;
        this.title = str4;
        this.isForce = z;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getRoute() {
        return this.route;
    }

    public final String getId() {
        return this.f11297id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean isForce() {
        return this.isForce;
    }
}
