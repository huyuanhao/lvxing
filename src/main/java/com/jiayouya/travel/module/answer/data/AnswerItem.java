package com.jiayouya.travel.module.answer.data;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\nHÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001b"}, mo39189d2 = {"Lcom/jiayouya/travel/module/answer/data/AnswerItem;", "", "id", "", "answer", "(Ljava/lang/String;Ljava/lang/String;)V", "getAnswer", "()Ljava/lang/String;", "getId", "index", "", "getIndex", "()I", "setIndex", "(I)V", "isSelected", "", "()Z", "setSelected", "(Z)V", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: Questions.kt */
public final class AnswerItem {
    private final String answer;
    /* renamed from: id */
    private final String f11222id;
    private int index;
    private boolean isSelected;

    public static /* synthetic */ AnswerItem copy$default(AnswerItem answerItem, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = answerItem.f11222id;
        }
        if ((i & 2) != 0) {
            str2 = answerItem.answer;
        }
        return answerItem.copy(str, str2);
    }

    public final String component1() {
        return this.f11222id;
    }

    public final String component2() {
        return this.answer;
    }

    public final AnswerItem copy(String str, String str2) {
        C8271i.m35386b(str, "id");
        C8271i.m35386b(str2, "answer");
        return new AnswerItem(str, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r2.answer, (java.lang.Object) r3.answer) != false) goto L_0x001f;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001f
        boolean r0 = r3 instanceof com.jiayouya.travel.module.answer.data.AnswerItem
        if (r0 == 0) goto L_0x001d
        com.jiayouya.travel.module.answer.data.AnswerItem r3 = (com.jiayouya.travel.module.answer.data.AnswerItem) r3
        java.lang.String r0 = r2.f11222id
        java.lang.String r1 = r3.f11222id
        boolean r0 = kotlin.jvm.internal.C8271i.m35384a(r0, r1)
        if (r0 == 0) goto L_0x001d
        java.lang.String r0 = r2.answer
        java.lang.String r3 = r3.answer
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
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.answer.data.AnswerItem.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.f11222id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.answer;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AnswerItem(id=");
        sb.append(this.f11222id);
        sb.append(", answer=");
        sb.append(this.answer);
        sb.append(")");
        return sb.toString();
    }

    public AnswerItem(String str, String str2) {
        C8271i.m35386b(str, "id");
        C8271i.m35386b(str2, "answer");
        this.f11222id = str;
        this.answer = str2;
    }

    public final String getAnswer() {
        return this.answer;
    }

    public final String getId() {
        return this.f11222id;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final int getIndex() {
        return this.index;
    }

    public final void setIndex(int i) {
        this.index = i;
    }
}
