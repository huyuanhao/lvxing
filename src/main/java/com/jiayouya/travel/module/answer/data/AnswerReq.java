package com.jiayouya.travel.module.answer.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo39189d2 = {"Lcom/jiayouya/travel/module/answer/data/AnswerReq;", "", "q_id", "", "a_ids", "", "(Ljava/lang/String;Ljava/util/List;)V", "getA_ids", "()Ljava/util/List;", "getQ_id", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: AnswerReq.kt */
public final class AnswerReq {
    private final List<String> a_ids;
    private final String q_id;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<java.lang.String>, for r2v0, types: [java.util.List] */
    public static /* synthetic */ com.jiayouya.travel.module.answer.data.AnswerReq copy$default(com.jiayouya.travel.module.answer.data.AnswerReq r0, java.lang.String r1, java.util.List<java.lang.String> r2, int r3, java.lang.Object r4) {
        /*
        r4 = r3 & 1
        if (r4 == 0) goto L_0x0006
        java.lang.String r1 = r0.q_id
    L_0x0006:
        r3 = r3 & 2
        if (r3 == 0) goto L_0x000c
        java.util.List<java.lang.String> r2 = r0.a_ids
    L_0x000c:
        com.jiayouya.travel.module.answer.data.AnswerReq r0 = r0.copy(r1, r2)
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.answer.data.AnswerReq.copy$default(com.jiayouya.travel.module.answer.data.AnswerReq, java.lang.String, java.util.List, int, java.lang.Object):com.jiayouya.travel.module.answer.data.AnswerReq");
    }

    public final String component1() {
        return this.q_id;
    }

    public final List<String> component2() {
        return this.a_ids;
    }

    public final AnswerReq copy(String str, List<String> list) {
        C8271i.m35386b(str, "q_id");
        C8271i.m35386b(list, "a_ids");
        return new AnswerReq(str, list);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r2.a_ids, (java.lang.Object) r3.a_ids) != false) goto L_0x001f;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001f
        boolean r0 = r3 instanceof com.jiayouya.travel.module.answer.data.AnswerReq
        if (r0 == 0) goto L_0x001d
        com.jiayouya.travel.module.answer.data.AnswerReq r3 = (com.jiayouya.travel.module.answer.data.AnswerReq) r3
        java.lang.String r0 = r2.q_id
        java.lang.String r1 = r3.q_id
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x001d
        java.util.List<java.lang.String> r0 = r2.a_ids
        java.util.List<java.lang.String> r3 = r3.a_ids
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
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.answer.data.AnswerReq.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.q_id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<String> list = this.a_ids;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AnswerReq(q_id=");
        sb.append(this.q_id);
        sb.append(", a_ids=");
        sb.append(this.a_ids);
        sb.append(")");
        return sb.toString();
    }

    public AnswerReq(String str, List<String> list) {
        C8271i.m35386b(str, "q_id");
        C8271i.m35386b(list, "a_ids");
        this.q_id = str;
        this.a_ids = list;
    }

    public final List<String> getA_ids() {
        return this.a_ids;
    }

    public final String getQ_id() {
        return this.q_id;
    }
}
