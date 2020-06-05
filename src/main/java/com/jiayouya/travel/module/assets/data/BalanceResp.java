package com.jiayouya.travel.module.assets.data;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\r¨\u0006\u0016"}, mo39189d2 = {"Lcom/jiayouya/travel/module/assets/data/BalanceResp;", "", "balance", "", "isBindAli", "", "aliPay", "", "(Ljava/lang/String;ZI)V", "getAliPay", "()I", "getBalance", "()Ljava/lang/String;", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: BalanceResp.kt */
public final class BalanceResp {
    private final int aliPay;
    private final String balance;
    private final boolean isBindAli;

    public static /* synthetic */ BalanceResp copy$default(BalanceResp balanceResp, String str, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = balanceResp.balance;
        }
        if ((i2 & 2) != 0) {
            z = balanceResp.isBindAli;
        }
        if ((i2 & 4) != 0) {
            i = balanceResp.aliPay;
        }
        return balanceResp.copy(str, z, i);
    }

    public final String component1() {
        return this.balance;
    }

    public final boolean component2() {
        return this.isBindAli;
    }

    public final int component3() {
        return this.aliPay;
    }

    public final BalanceResp copy(String str, boolean z, int i) {
        C8271i.m35386b(str, "balance");
        return new BalanceResp(str, z, i);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof BalanceResp) {
                BalanceResp balanceResp = (BalanceResp) obj;
                if (C8271i.m35384a((Object) this.balance, (Object) balanceResp.balance)) {
                    if (this.isBindAli == balanceResp.isBindAli) {
                        if (this.aliPay == balanceResp.aliPay) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.balance;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.isBindAli;
        if (z) {
            z = true;
        }
        return ((hashCode + z) * 31) + this.aliPay;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BalanceResp(balance=");
        sb.append(this.balance);
        sb.append(", isBindAli=");
        sb.append(this.isBindAli);
        sb.append(", aliPay=");
        sb.append(this.aliPay);
        sb.append(")");
        return sb.toString();
    }

    public BalanceResp(String str, boolean z, int i) {
        C8271i.m35386b(str, "balance");
        this.balance = str;
        this.isBindAli = z;
        this.aliPay = i;
    }

    public final int getAliPay() {
        return this.aliPay;
    }

    public final String getBalance() {
        return this.balance;
    }

    public final boolean isBindAli() {
        return this.isBindAli;
    }
}
