package com.jiayouya.travel.common.p244b;

import android.text.TextUtils;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, mo39189d2 = {"isEmpty", "", "Landroid/widget/TextView;", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.common.b.j */
public final class TextViewEx {
    /* renamed from: a */
    public static final boolean m12838a(TextView textView) {
        C8271i.m35386b(textView, "$this$isEmpty");
        return TextUtils.isEmpty(textView.getText());
    }
}
