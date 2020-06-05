package androidx.core.text;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\b¨\u0006\u0002"}, mo39189d2 = {"htmlEncode", "", "core-ktx_release"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: String.kt */
public final class StringKt {
    public static final String htmlEncode(String str) {
        C8271i.m35386b(str, "$this$htmlEncode");
        String htmlEncode = TextUtils.htmlEncode(str);
        C8271i.m35382a((Object) htmlEncode, "TextUtils.htmlEncode(this)");
        return htmlEncode;
    }
}
