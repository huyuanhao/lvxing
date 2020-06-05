package com.jiayouya.travel.module.travel.data;

import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/LuckPoolRsp;", "", "tickets", "", "desc", "", "pool", "", "Lcom/jiayouya/travel/module/travel/data/LuckPoolItem;", "(ILjava/lang/String;Ljava/util/List;)V", "getDesc", "()Ljava/lang/String;", "getPool", "()Ljava/util/List;", "getTickets", "()I", "setTickets", "(I)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: LuckPoolRsp.kt */
public final class LuckPoolRsp {
    private final String desc;
    private final List<LuckPoolItem> pool;
    private int tickets;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<com.jiayouya.travel.module.travel.data.LuckPoolItem>, for r3v0, types: [java.util.List] */
    public static /* synthetic */ com.jiayouya.travel.module.travel.data.LuckPoolRsp copy$default(com.jiayouya.travel.module.travel.data.LuckPoolRsp r0, int r1, java.lang.String r2, java.util.List<com.jiayouya.travel.module.travel.data.LuckPoolItem> r3, int r4, java.lang.Object r5) {
        /*
        r5 = r4 & 1
        if (r5 == 0) goto L_0x0006
        int r1 = r0.tickets
    L_0x0006:
        r5 = r4 & 2
        if (r5 == 0) goto L_0x000c
        java.lang.String r2 = r0.desc
    L_0x000c:
        r4 = r4 & 4
        if (r4 == 0) goto L_0x0012
        java.util.List<com.jiayouya.travel.module.travel.data.LuckPoolItem> r3 = r0.pool
    L_0x0012:
        com.jiayouya.travel.module.travel.data.LuckPoolRsp r0 = r0.copy(r1, r2, r3)
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.travel.data.LuckPoolRsp.copy$default(com.jiayouya.travel.module.travel.data.LuckPoolRsp, int, java.lang.String, java.util.List, int, java.lang.Object):com.jiayouya.travel.module.travel.data.LuckPoolRsp");
    }

    public final int component1() {
        return this.tickets;
    }

    public final String component2() {
        return this.desc;
    }

    public final List<LuckPoolItem> component3() {
        return this.pool;
    }

    public final LuckPoolRsp copy(int i, String str, List<LuckPoolItem> list) {
        C8271i.m35386b(str, ArgKey.KEY_DESC);
        C8271i.m35386b(list, "pool");
        return new LuckPoolRsp(i, str, list);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof LuckPoolRsp) {
                LuckPoolRsp luckPoolRsp = (LuckPoolRsp) obj;
                if (!(this.tickets == luckPoolRsp.tickets) || !C8271i.m35384a((Object) this.desc, (Object) luckPoolRsp.desc) || !C8271i.m35384a((Object) this.pool, (Object) luckPoolRsp.pool)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.tickets * 31;
        String str = this.desc;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        List<LuckPoolItem> list = this.pool;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LuckPoolRsp(tickets=");
        sb.append(this.tickets);
        sb.append(", desc=");
        sb.append(this.desc);
        sb.append(", pool=");
        sb.append(this.pool);
        sb.append(")");
        return sb.toString();
    }

    public LuckPoolRsp(int i, String str, List<LuckPoolItem> list) {
        C8271i.m35386b(str, ArgKey.KEY_DESC);
        C8271i.m35386b(list, "pool");
        this.tickets = i;
        this.desc = str;
        this.pool = list;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final List<LuckPoolItem> getPool() {
        return this.pool;
    }

    public final int getTickets() {
        return this.tickets;
    }

    public final void setTickets(int i) {
        this.tickets = i;
    }
}
