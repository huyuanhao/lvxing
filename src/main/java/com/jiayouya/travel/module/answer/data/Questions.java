package com.jiayouya.travel.module.answer.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u001d"}, mo39189d2 = {"Lcom/jiayouya/travel/module/answer/data/Questions;", "", "id", "", "question", "isSingle", "", "answers", "", "Lcom/jiayouya/travel/module/answer/data/AnswerItem;", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;)V", "getAnswers", "()Ljava/util/List;", "setAnswers", "(Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "()Z", "getQuestion", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: Questions.kt */
public final class Questions {
    private List<AnswerItem> answers;
    /* renamed from: id */
    private final String f11223id;
    private final boolean isSingle;
    private final String question;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<com.jiayouya.travel.module.answer.data.AnswerItem>, for r4v0, types: [java.util.List] */
    public static /* synthetic */ com.jiayouya.travel.module.answer.data.Questions copy$default(com.jiayouya.travel.module.answer.data.Questions r0, java.lang.String r1, java.lang.String r2, boolean r3, java.util.List<com.jiayouya.travel.module.answer.data.AnswerItem> r4, int r5, java.lang.Object r6) {
        /*
        r6 = r5 & 1
        if (r6 == 0) goto L_0x0006
        java.lang.String r1 = r0.f11223id
    L_0x0006:
        r6 = r5 & 2
        if (r6 == 0) goto L_0x000c
        java.lang.String r2 = r0.question
    L_0x000c:
        r6 = r5 & 4
        if (r6 == 0) goto L_0x0012
        boolean r3 = r0.isSingle
    L_0x0012:
        r5 = r5 & 8
        if (r5 == 0) goto L_0x0018
        java.util.List<com.jiayouya.travel.module.answer.data.AnswerItem> r4 = r0.answers
    L_0x0018:
        com.jiayouya.travel.module.answer.data.Questions r0 = r0.copy(r1, r2, r3, r4)
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.answer.data.Questions.copy$default(com.jiayouya.travel.module.answer.data.Questions, java.lang.String, java.lang.String, boolean, java.util.List, int, java.lang.Object):com.jiayouya.travel.module.answer.data.Questions");
    }

    public final String component1() {
        return this.f11223id;
    }

    public final String component2() {
        return this.question;
    }

    public final boolean component3() {
        return this.isSingle;
    }

    public final List<AnswerItem> component4() {
        return this.answers;
    }

    public final Questions copy(String str, String str2, boolean z, List<AnswerItem> list) {
        C8271i.m35386b(str, "id");
        C8271i.m35386b(str2, "question");
        C8271i.m35386b(list, "answers");
        return new Questions(str, str2, z, list);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Questions) {
                Questions questions = (Questions) obj;
                if (C8271i.m35384a((Object) this.f11223id, (Object) questions.f11223id) && C8271i.m35384a((Object) this.question, (Object) questions.question)) {
                    if (!(this.isSingle == questions.isSingle) || !C8271i.m35384a((Object) this.answers, (Object) questions.answers)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f11223id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.question;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z = this.isSingle;
        if (z) {
            z = true;
        }
        int i2 = (hashCode2 + z) * 31;
        List<AnswerItem> list = this.answers;
        if (list != null) {
            i = list.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Questions(id=");
        sb.append(this.f11223id);
        sb.append(", question=");
        sb.append(this.question);
        sb.append(", isSingle=");
        sb.append(this.isSingle);
        sb.append(", answers=");
        sb.append(this.answers);
        sb.append(")");
        return sb.toString();
    }

    public Questions(String str, String str2, boolean z, List<AnswerItem> list) {
        C8271i.m35386b(str, "id");
        C8271i.m35386b(str2, "question");
        C8271i.m35386b(list, "answers");
        this.f11223id = str;
        this.question = str2;
        this.isSingle = z;
        this.answers = list;
    }

    public final List<AnswerItem> getAnswers() {
        return this.answers;
    }

    public final String getId() {
        return this.f11223id;
    }

    public final String getQuestion() {
        return this.question;
    }

    public final boolean isSingle() {
        return this.isSingle;
    }

    public final void setAnswers(List<AnswerItem> list) {
        C8271i.m35386b(list, "<set-?>");
        this.answers = list;
    }
}
