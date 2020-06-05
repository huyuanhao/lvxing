package ezy.p642a;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.C8271i;
import kotlin.text.C8313m;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0002\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\u0002\u001a\n\u0010\t\u001a\u00020\n*\u00020\u0002¨\u0006\u000b"}, mo39189d2 = {"getDouble", "", "Landroid/widget/TextView;", "getFloat", "", "getInt", "", "getLong", "", "getString", "", "lib.common_release"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* renamed from: ezy.a.c */
public final class TextView {
    /* renamed from: a */
    public static final String m34747a(android.widget.TextView textView) {
        C8271i.m35386b(textView, "$this$getString");
        String obj = textView.getText().toString();
        if (obj != null) {
            return C8313m.m35483b(obj).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    /* renamed from: b */
    public static final int m34748b(android.widget.TextView textView) {
        C8271i.m35386b(textView, "$this$getInt");
        CharSequence text = textView.getText();
        C8271i.m35382a((Object) text, "text");
        if (C8313m.m35462a(text)) {
            return 0;
        }
        String obj = textView.getText().toString();
        if (obj != null) {
            return Integer.parseInt(C8313m.m35483b(obj).toString());
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }
}
