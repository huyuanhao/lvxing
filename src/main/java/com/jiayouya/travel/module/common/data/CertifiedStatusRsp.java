package com.jiayouya.travel.module.common.data;

import kotlin.Metadata;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/data/CertifiedStatusRsp;", "", "status", "", "(I)V", "getStatus", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: CertifiedStatusRsp.kt */
public final class CertifiedStatusRsp {
    private final int status;

    public static /* synthetic */ CertifiedStatusRsp copy$default(CertifiedStatusRsp certifiedStatusRsp, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = certifiedStatusRsp.status;
        }
        return certifiedStatusRsp.copy(i);
    }

    public final int component1() {
        return this.status;
    }

    public final CertifiedStatusRsp copy(int i) {
        return new CertifiedStatusRsp(i);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CertifiedStatusRsp) {
                if (this.status == ((CertifiedStatusRsp) obj).status) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.status;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CertifiedStatusRsp(status=");
        sb.append(this.status);
        sb.append(")");
        return sb.toString();
    }

    public CertifiedStatusRsp(int i) {
        this.status = i;
    }

    public final int getStatus() {
        return this.status;
    }
}
