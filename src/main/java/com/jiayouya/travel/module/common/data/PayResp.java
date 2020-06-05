package com.jiayouya.travel.module.common.data;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/data/PayResp;", "", "payOrderId", "", "method", "credential", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCredential", "()Ljava/lang/String;", "getMethod", "getPayOrderId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: PayResp.kt */
public final class PayResp {
    private final String credential;
    private final String method;
    private final String payOrderId;

    public static /* synthetic */ PayResp copy$default(PayResp payResp, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = payResp.payOrderId;
        }
        if ((i & 2) != 0) {
            str2 = payResp.method;
        }
        if ((i & 4) != 0) {
            str3 = payResp.credential;
        }
        return payResp.copy(str, str2, str3);
    }

    public final String component1() {
        return this.payOrderId;
    }

    public final String component2() {
        return this.method;
    }

    public final String component3() {
        return this.credential;
    }

    public final PayResp copy(String str, String str2, String str3) {
        C8271i.m35386b(str, "payOrderId");
        C8271i.m35386b(str2, "method");
        C8271i.m35386b(str3, "credential");
        return new PayResp(str, str2, str3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r2.credential, (java.lang.Object) r3.credential) != false) goto L_0x0029;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0029
        boolean r0 = r3 instanceof com.jiayouya.travel.module.common.data.PayResp
        if (r0 == 0) goto L_0x0027
        com.jiayouya.travel.module.common.data.PayResp r3 = (com.jiayouya.travel.module.common.data.PayResp) r3
        java.lang.String r0 = r2.payOrderId
        java.lang.String r1 = r3.payOrderId
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0027
        java.lang.String r0 = r2.method
        java.lang.String r1 = r3.method
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x0027
        java.lang.String r0 = r2.credential
        java.lang.String r3 = r3.credential
        boolean r3 = kotlin.jvm.internal.C8271i.m35384a(r0, r3)
        if (r3 == 0) goto L_0x0027
        goto L_0x0029
    L_0x0027:
        r3 = 0
        return r3
    L_0x0029:
        r3 = 1
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.common.data.PayResp.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.payOrderId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.method;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.credential;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PayResp(payOrderId=");
        sb.append(this.payOrderId);
        sb.append(", method=");
        sb.append(this.method);
        sb.append(", credential=");
        sb.append(this.credential);
        sb.append(")");
        return sb.toString();
    }

    public PayResp(String str, String str2, String str3) {
        C8271i.m35386b(str, "payOrderId");
        C8271i.m35386b(str2, "method");
        C8271i.m35386b(str3, "credential");
        this.payOrderId = str;
        this.method = str2;
        this.credential = str3;
    }

    public final String getPayOrderId() {
        return this.payOrderId;
    }

    public final String getMethod() {
        return this.method;
    }

    public final String getCredential() {
        return this.credential;
    }
}
