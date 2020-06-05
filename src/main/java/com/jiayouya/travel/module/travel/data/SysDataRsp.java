package com.jiayouya.travel.module.travel.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JA\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006$"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/data/SysDataRsp;", "", "coin", "", "needUpdate", "", "lastSysTime", "nextSysTime", "", "positions", "", "Lcom/jiayouya/travel/module/travel/data/PositionItem;", "(Ljava/lang/String;ZLjava/lang/String;JLjava/util/List;)V", "getCoin", "()Ljava/lang/String;", "isLocalRestoreSys", "()Z", "setLocalRestoreSys", "(Z)V", "getLastSysTime", "getNeedUpdate", "getNextSysTime", "()J", "getPositions", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: SysDataRsp.kt */
public final class SysDataRsp {
    private final String coin;
    private boolean isLocalRestoreSys;
    private final String lastSysTime;
    private final boolean needUpdate;
    private final long nextSysTime;
    private final List<PositionItem> positions;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<com.jiayouya.travel.module.travel.data.PositionItem>, for r10v0, types: [java.util.List] */
    public static /* synthetic */ com.jiayouya.travel.module.travel.data.SysDataRsp copy$default(com.jiayouya.travel.module.travel.data.SysDataRsp r4, java.lang.String r5, boolean r6, java.lang.String r7, long r8, java.util.List<com.jiayouya.travel.module.travel.data.PositionItem> r10, int r11, java.lang.Object r12) {
        /*
        r12 = r11 & 1
        if (r12 == 0) goto L_0x0006
        java.lang.String r5 = r4.coin
    L_0x0006:
        r12 = r11 & 2
        if (r12 == 0) goto L_0x000c
        boolean r6 = r4.needUpdate
    L_0x000c:
        r12 = r6
        r6 = r11 & 4
        if (r6 == 0) goto L_0x0013
        java.lang.String r7 = r4.lastSysTime
    L_0x0013:
        r0 = r7
        r6 = r11 & 8
        if (r6 == 0) goto L_0x001a
        long r8 = r4.nextSysTime
    L_0x001a:
        r1 = r8
        r6 = r11 & 16
        if (r6 == 0) goto L_0x0021
        java.util.List<com.jiayouya.travel.module.travel.data.PositionItem> r10 = r4.positions
    L_0x0021:
        r3 = r10
        r6 = r4
        r7 = r5
        r8 = r12
        r9 = r0
        r10 = r1
        r12 = r3
        com.jiayouya.travel.module.travel.data.SysDataRsp r4 = r6.copy(r7, r8, r9, r10, r12)
        return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.travel.data.SysDataRsp.copy$default(com.jiayouya.travel.module.travel.data.SysDataRsp, java.lang.String, boolean, java.lang.String, long, java.util.List, int, java.lang.Object):com.jiayouya.travel.module.travel.data.SysDataRsp");
    }

    public final String component1() {
        return this.coin;
    }

    public final boolean component2() {
        return this.needUpdate;
    }

    public final String component3() {
        return this.lastSysTime;
    }

    public final long component4() {
        return this.nextSysTime;
    }

    public final List<PositionItem> component5() {
        return this.positions;
    }

    public final SysDataRsp copy(String str, boolean z, String str2, long j, List<PositionItem> list) {
        C8271i.m35386b(str, "coin");
        C8271i.m35386b(str2, "lastSysTime");
        C8271i.m35386b(list, "positions");
        SysDataRsp sysDataRsp = new SysDataRsp(str, z, str2, j, list);
        return sysDataRsp;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof SysDataRsp) {
                SysDataRsp sysDataRsp = (SysDataRsp) obj;
                if (C8271i.m35384a((Object) this.coin, (Object) sysDataRsp.coin)) {
                    if ((this.needUpdate == sysDataRsp.needUpdate) && C8271i.m35384a((Object) this.lastSysTime, (Object) sysDataRsp.lastSysTime)) {
                        if (!(this.nextSysTime == sysDataRsp.nextSysTime) || !C8271i.m35384a((Object) this.positions, (Object) sysDataRsp.positions)) {
                            return false;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.coin;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.needUpdate;
        if (z) {
            z = true;
        }
        int i2 = (hashCode + z) * 31;
        String str2 = this.lastSysTime;
        int hashCode2 = (i2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        long j = this.nextSysTime;
        int i3 = (hashCode2 + ((int) (j ^ (j >>> 32)))) * 31;
        List<PositionItem> list = this.positions;
        if (list != null) {
            i = list.hashCode();
        }
        return i3 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SysDataRsp(coin=");
        sb.append(this.coin);
        sb.append(", needUpdate=");
        sb.append(this.needUpdate);
        sb.append(", lastSysTime=");
        sb.append(this.lastSysTime);
        sb.append(", nextSysTime=");
        sb.append(this.nextSysTime);
        sb.append(", positions=");
        sb.append(this.positions);
        sb.append(")");
        return sb.toString();
    }

    public SysDataRsp(String str, boolean z, String str2, long j, List<PositionItem> list) {
        C8271i.m35386b(str, "coin");
        C8271i.m35386b(str2, "lastSysTime");
        C8271i.m35386b(list, "positions");
        this.coin = str;
        this.needUpdate = z;
        this.lastSysTime = str2;
        this.nextSysTime = j;
        this.positions = list;
    }

    public final String getCoin() {
        return this.coin;
    }

    public final String getLastSysTime() {
        return this.lastSysTime;
    }

    public final boolean getNeedUpdate() {
        return this.needUpdate;
    }

    public final long getNextSysTime() {
        return this.nextSysTime;
    }

    public final List<PositionItem> getPositions() {
        return this.positions;
    }

    public final boolean isLocalRestoreSys() {
        return this.isLocalRestoreSys;
    }

    public final void setLocalRestoreSys(boolean z) {
        this.isLocalRestoreSys = z;
    }
}
