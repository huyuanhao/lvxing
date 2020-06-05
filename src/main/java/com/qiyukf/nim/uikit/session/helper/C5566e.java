package com.qiyukf.nim.uikit.session.helper;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.qiyukf.basesdk.p412c.p416c.C5402b;
import com.qiyukf.basesdk.p412c.p416c.C5402b.C5404a;
import java.util.List;

/* renamed from: com.qiyukf.nim.uikit.session.helper.e */
public final class C5566e {
    /* renamed from: a */
    public static SpannableStringBuilder m22593a(Context context, CharSequence charSequence) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        m22594a(context, spannableStringBuilder);
        return spannableStringBuilder;
    }

    /* renamed from: a */
    private static void m22594a(Context context, SpannableStringBuilder spannableStringBuilder) {
        List<C5404a> a = C5402b.m22111a(spannableStringBuilder.toString());
        if (a.size() != 0) {
            for (C5404a aVar : a) {
                spannableStringBuilder.setSpan(new C5556b(context, aVar.f17377a), aVar.f17378b, aVar.f17379c, 33);
            }
        }
    }
}
