package com.jiayouya.travel.module.common.data;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/data/Platform;", "", "id", "", "plat", "", "(Ljava/lang/String;I)V", "getId", "()Ljava/lang/String;", "getPlat", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: AdRsp.kt */
public final class Platform {
    /* renamed from: id */
    private final String f11296id;
    private final int plat;

    public static /* synthetic */ Platform copy$default(Platform platform, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = platform.f11296id;
        }
        if ((i2 & 2) != 0) {
            i = platform.plat;
        }
        return platform.copy(str, i);
    }

    public final String component1() {
        return this.f11296id;
    }

    public final int component2() {
        return this.plat;
    }

    public final Platform copy(String str, int i) {
        C8271i.m35386b(str, "id");
        return new Platform(str, i);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Platform) {
                Platform platform = (Platform) obj;
                if (C8271i.m35384a((Object) this.f11296id, (Object) platform.f11296id)) {
                    if (this.plat == platform.plat) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f11296id;
        return ((str != null ? str.hashCode() : 0) * 31) + this.plat;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Platform(id=");
        sb.append(this.f11296id);
        sb.append(", plat=");
        sb.append(this.plat);
        sb.append(")");
        return sb.toString();
    }

    public Platform(String str, int i) {
        C8271i.m35386b(str, "id");
        this.f11296id = str;
        this.plat = i;
    }

    public final String getId() {
        return this.f11296id;
    }

    public final int getPlat() {
        return this.plat;
    }
}
