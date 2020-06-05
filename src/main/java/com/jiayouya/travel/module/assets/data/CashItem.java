package com.jiayouya.travel.module.assets.data;

import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, mo39189d2 = {"Lcom/jiayouya/travel/module/assets/data/CashItem;", "", "value", "", "(Ljava/lang/String;)V", "isSelected", "", "()Z", "setSelected", "(Z)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "other", "hashCode", "", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: CashItem.kt */
public final class CashItem {
    private boolean isSelected;
    private final String value;

    public static /* synthetic */ CashItem copy$default(CashItem cashItem, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cashItem.value;
        }
        return cashItem.copy(str);
    }

    public final String component1() {
        return this.value;
    }

    public final CashItem copy(String str) {
        C8271i.m35386b(str, ArgKey.KEY_VALUE);
        return new CashItem(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r1.value, (java.lang.Object) ((com.jiayouya.travel.module.assets.data.CashItem) r2).value) != false) goto L_0x0015;
     */
    public boolean equals(java.lang.Object r2) {
        /*
        r1 = this;
        if (r1 == r2) goto L_0x0015
        boolean r0 = r2 instanceof com.jiayouya.travel.module.assets.data.CashItem
        if (r0 == 0) goto L_0x0013
        com.jiayouya.travel.module.assets.data.CashItem r2 = (com.jiayouya.travel.module.assets.data.CashItem) r2
        java.lang.String r0 = r1.value
        java.lang.String r2 = r2.value
        boolean r2 = kotlin.jvm.internal.C8271i.m35384a(r0, r2)
        if (r2 == 0) goto L_0x0013
        goto L_0x0015
    L_0x0013:
        r2 = 0
        return r2
    L_0x0015:
        r2 = 1
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.assets.data.CashItem.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.value;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashItem(value=");
        sb.append(this.value);
        sb.append(")");
        return sb.toString();
    }

    public CashItem(String str) {
        C8271i.m35386b(str, ArgKey.KEY_VALUE);
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }
}
