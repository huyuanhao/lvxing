package com.qiyukf.basesdk.p412c.p414b.p415a;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import com.qiyukf.basesdk.p412c.p414b.C5398f;

/* renamed from: com.qiyukf.basesdk.c.b.a.b */
public final class C5374b extends ClickableSpan {
    /* renamed from: a */
    private C5398f f17334a;
    /* renamed from: b */
    private Context f17335b;
    /* renamed from: c */
    private String f17336c;
    /* renamed from: d */
    private String f17337d;

    public C5374b(Context context, String str, String str2) {
        this.f17335b = context;
        this.f17336c = str;
        this.f17337d = str2;
    }

    /* renamed from: a */
    public final void mo27332a(C5398f fVar) {
        this.f17334a = fVar;
    }

    public final void onClick(View view) {
        C5398f fVar = this.f17334a;
        if (fVar != null) {
            fVar.mo27351a(this.f17335b, this.f17336c, this.f17337d);
        }
    }
}
