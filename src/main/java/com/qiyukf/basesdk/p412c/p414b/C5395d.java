package com.qiyukf.basesdk.p412c.p414b;

import android.text.SpannableStringBuilder;

/* renamed from: com.qiyukf.basesdk.c.b.d */
public final class C5395d {
    /* renamed from: a */
    private C5376b f17359a;
    /* renamed from: b */
    private C5398f f17360b;
    /* renamed from: c */
    private C5396a f17361c;
    /* renamed from: d */
    private String f17362d;
    /* renamed from: e */
    private String f17363e;

    /* renamed from: com.qiyukf.basesdk.c.b.d$a */
    public interface C5396a {
        /* renamed from: a */
        CharSequence mo27350a(SpannableStringBuilder spannableStringBuilder);
    }

    private C5395d(String str) {
        this.f17362d = str;
    }

    /* renamed from: a */
    public static C5395d m22089a(String str) {
        return new C5395d(str);
    }

    /* renamed from: a */
    public final C5395d mo27345a(C5376b bVar) {
        this.f17359a = bVar;
        return this;
    }

    /* renamed from: a */
    public final C5395d mo27346a(C5396a aVar) {
        this.f17361c = aVar;
        return this;
    }

    /* renamed from: a */
    public final C5395d mo27347a(C5398f fVar) {
        this.f17360b = fVar;
        return this;
    }

    /* JADX WARNING: type inference failed for: r0v6, types: [java.lang.CharSequence] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    public final void mo27348a(android.widget.TextView r13) {
        /*
        r12 = this;
        java.lang.String r0 = r12.f17362d
        boolean r0 = android.text.TextUtils.isEmpty(r0)
        if (r0 == 0) goto L_0x000e
        java.lang.String r0 = ""
        r13.setText(r0)
        return
    L_0x000e:
        com.qiyukf.basesdk.c.b.a r0 = new com.qiyukf.basesdk.c.b.a
        r0.m49491init()
        com.qiyukf.basesdk.c.b.c r1 = new com.qiyukf.basesdk.c.b.c
        r1.m49501init()
        java.util.ArrayList r2 = new java.util.ArrayList
        r2.<init>()
        r0.mo27318a(r13)
        com.qiyukf.basesdk.c.b.b r3 = r12.f17359a
        r0.mo27319a(r3)
        java.lang.String r3 = r12.f17362d
        r0.mo27320a(r3)
        r1.mo27340a(r13)
        java.lang.String r3 = r12.f17362d
        java.lang.String r3 = com.qiyukf.basesdk.p412c.p414b.C5378c.m22068a(r3)
        r12.f17362d = r3
        java.lang.String r3 = r12.f17362d
        android.text.Spanned r0 = android.text.Html.fromHtml(r3, r0, r1)
        boolean r1 = r0 instanceof android.text.SpannableStringBuilder
        if (r1 == 0) goto L_0x0042
        android.text.SpannableStringBuilder r0 = (android.text.SpannableStringBuilder) r0
        goto L_0x0048
    L_0x0042:
        android.text.SpannableStringBuilder r1 = new android.text.SpannableStringBuilder
        r1.<init>(r0)
        r0 = r1
    L_0x0048:
        r2.clear()
        int r1 = r0.length()
        java.lang.Class<android.text.style.ImageSpan> r3 = android.text.style.ImageSpan.class
        r4 = 0
        java.lang.Object[] r1 = r0.getSpans(r4, r1, r3)
        android.text.style.ImageSpan[] r1 = (android.text.style.ImageSpan[]) r1
        r3 = 0
    L_0x0059:
        int r5 = r1.length
        if (r3 >= r5) goto L_0x0099
        r5 = r1[r3]
        java.lang.String r6 = r5.getSource()
        int r7 = r0.getSpanStart(r5)
        int r5 = r0.getSpanEnd(r5)
        r2.add(r6)
        com.qiyukf.basesdk.c.b.a.a r6 = new com.qiyukf.basesdk.c.b.a.a
        android.content.Context r8 = r13.getContext()
        r6.m49496init(r8, r2, r3)
        com.qiyukf.basesdk.c.b.f r8 = r12.f17360b
        r6.mo27329a(r8)
        java.lang.Class<android.text.style.ClickableSpan> r8 = android.text.style.ClickableSpan.class
        java.lang.Object[] r8 = r0.getSpans(r7, r5, r8)
        android.text.style.ClickableSpan[] r8 = (android.text.style.ClickableSpan[]) r8
        if (r8 == 0) goto L_0x0091
        int r9 = r8.length
        r10 = 0
    L_0x0087:
        if (r10 >= r9) goto L_0x0091
        r11 = r8[r10]
        r0.removeSpan(r11)
        int r10 = r10 + 1
        goto L_0x0087
    L_0x0091:
        r8 = 33
        r0.setSpan(r6, r7, r5, r8)
        int r3 = r3 + 1
        goto L_0x0059
    L_0x0099:
        int r1 = r0.length()
        java.lang.Class<android.text.style.URLSpan> r2 = android.text.style.URLSpan.class
        java.lang.Object[] r1 = r0.getSpans(r4, r1, r2)
        android.text.style.URLSpan[] r1 = (android.text.style.URLSpan[]) r1
        if (r1 == 0) goto L_0x00d3
        int r2 = r1.length
    L_0x00a8:
        if (r4 >= r2) goto L_0x00d3
        r3 = r1[r4]
        int r5 = r0.getSpanStart(r3)
        int r6 = r0.getSpanEnd(r3)
        r0.removeSpan(r3)
        com.qiyukf.basesdk.c.b.a.b r7 = new com.qiyukf.basesdk.c.b.a.b
        android.content.Context r8 = r13.getContext()
        java.lang.String r3 = r3.getURL()
        java.lang.String r9 = r12.f17363e
        r7.m49498init(r8, r3, r9)
        com.qiyukf.basesdk.c.b.f r3 = r12.f17360b
        r7.mo27332a(r3)
        r3 = 34
        r0.setSpan(r7, r5, r6, r3)
        int r4 = r4 + 1
        goto L_0x00a8
    L_0x00d3:
        int r1 = r0.length()
        if (r1 <= 0) goto L_0x00f5
        int r1 = r0.length()
        int r1 = r1 + -1
        char r1 = r0.charAt(r1)
        r2 = 10
        if (r1 != r2) goto L_0x00f5
        int r1 = r0.length()
        int r1 = r1 + -1
        int r2 = r0.length()
        r0.delete(r1, r2)
        goto L_0x00d3
    L_0x00f5:
        com.qiyukf.basesdk.c.b.d$a r1 = r12.f17361c
        if (r1 == 0) goto L_0x00fd
        java.lang.CharSequence r0 = r1.mo27350a(r0)
    L_0x00fd:
        r13.setText(r0)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.p412c.p414b.C5395d.mo27348a(android.widget.TextView):void");
    }

    /* renamed from: b */
    public final C5395d mo27349b(String str) {
        this.f17363e = str;
        return this;
    }
}
