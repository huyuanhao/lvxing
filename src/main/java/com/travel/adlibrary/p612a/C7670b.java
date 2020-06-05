package com.travel.adlibrary.p612a;

import com.travel.adlibrary.AdSdk.AdType;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, mo39189d2 = {"Lcom/travel/adlibrary/common/AdPlatform;", "", "id", "", "plat", "", "(Ljava/lang/String;I)V", "getId", "()Ljava/lang/String;", "getPlat", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "lib.ad_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: AdOptions.kt */
/* renamed from: com.travel.adlibrary.a.b */
public final class C7670b {
    /* renamed from: a */
    private final String f25922a;
    /* renamed from: b */
    private final int f25923b;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof C7670b) {
                C7670b bVar = (C7670b) obj;
                if (C8271i.m35384a((Object) this.f25922a, (Object) bVar.f25922a)) {
                    if (this.f25923b == bVar.f25923b) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f25922a;
        return ((str != null ? str.hashCode() : 0) * 31) + this.f25923b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdPlatform(id=");
        sb.append(this.f25922a);
        sb.append(", plat=");
        sb.append(this.f25923b);
        sb.append(")");
        return sb.toString();
    }

    public C7670b(String str, @AdType int i) {
        C8271i.m35386b(str, "id");
        this.f25922a = str;
        this.f25923b = i;
    }

    /* renamed from: a */
    public final String mo37318a() {
        return this.f25922a;
    }

    /* renamed from: b */
    public final int mo37319b() {
        return this.f25923b;
    }
}
