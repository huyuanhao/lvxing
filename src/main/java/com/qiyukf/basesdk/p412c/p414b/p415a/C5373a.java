package com.qiyukf.basesdk.p412c.p414b.p415a;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.qiyukf.basesdk.p412c.p414b.C5398f;
import java.util.List;

/* renamed from: com.qiyukf.basesdk.c.b.a.a */
public final class C5373a extends ClickableSpan {
    /* renamed from: a */
    private C5398f f17330a;
    /* renamed from: b */
    private Context f17331b;
    /* renamed from: c */
    private List<String> f17332c;
    /* renamed from: d */
    private int f17333d;

    public C5373a(Context context, List<String> list, int i) {
        this.f17331b = context;
        this.f17332c = list;
        this.f17333d = i;
    }

    /* renamed from: a */
    public final void mo27329a(C5398f fVar) {
        this.f17330a = fVar;
    }

    public final void onClick(View view) {
        C5398f fVar = this.f17330a;
        if (fVar != null) {
            fVar.mo27352a(this.f17331b, this.f17332c, this.f17333d);
        }
    }

    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(textPaint.linkColor);
        textPaint.setUnderlineText(false);
    }
}
