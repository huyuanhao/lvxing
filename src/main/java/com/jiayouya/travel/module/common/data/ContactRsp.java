package com.jiayouya.travel.module.common.data;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/data/ContactRsp;", "", "wx", "", "qq", "(Ljava/lang/String;Ljava/lang/String;)V", "getQq", "()Ljava/lang/String;", "getWx", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: ContactRsp.kt */
public final class ContactRsp {
    /* renamed from: qq */
    private final String f11292qq;
    /* renamed from: wx */
    private final String f11293wx;

    public static /* synthetic */ ContactRsp copy$default(ContactRsp contactRsp, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = contactRsp.f11293wx;
        }
        if ((i & 2) != 0) {
            str2 = contactRsp.f11292qq;
        }
        return contactRsp.copy(str, str2);
    }

    public final String component1() {
        return this.f11293wx;
    }

    public final String component2() {
        return this.f11292qq;
    }

    public final ContactRsp copy(String str, String str2) {
        C8271i.m35386b(str, "wx");
        C8271i.m35386b(str2, "qq");
        return new ContactRsp(str, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r2.f11292qq, (java.lang.Object) r3.f11292qq) != false) goto L_0x001f;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001f
        boolean r0 = r3 instanceof com.jiayouya.travel.module.common.data.ContactRsp
        if (r0 == 0) goto L_0x001d
        com.jiayouya.travel.module.common.data.ContactRsp r3 = (com.jiayouya.travel.module.common.data.ContactRsp) r3
        java.lang.String r0 = r2.f11293wx
        java.lang.String r1 = r3.f11293wx
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x001d
        java.lang.String r0 = r2.f11292qq
        java.lang.String r3 = r3.f11292qq
        boolean r3 = kotlin.jvm.internal.C8271i.m35384a(r0, r3)
        if (r3 == 0) goto L_0x001d
        goto L_0x001f
    L_0x001d:
        r3 = 0
        return r3
    L_0x001f:
        r3 = 1
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.common.data.ContactRsp.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.f11293wx;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f11292qq;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ContactRsp(wx=");
        sb.append(this.f11293wx);
        sb.append(", qq=");
        sb.append(this.f11292qq);
        sb.append(")");
        return sb.toString();
    }

    public ContactRsp(String str, String str2) {
        C8271i.m35386b(str, "wx");
        C8271i.m35386b(str2, "qq");
        this.f11293wx = str;
        this.f11292qq = str2;
    }

    public final String getQq() {
        return this.f11292qq;
    }

    public final String getWx() {
        return this.f11293wx;
    }
}
