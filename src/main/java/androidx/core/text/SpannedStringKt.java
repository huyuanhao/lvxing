package androidx.core.text;

import android.text.Spanned;
import android.text.SpannedString;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\u001a:\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\b¢\u0006\u0002\u0010\b\u001a\r\u0010\t\u001a\u00020\u0004*\u00020\nH\b¨\u0006\u000b"}, mo39189d2 = {"getSpans", "", "T", "", "Landroid/text/Spanned;", "start", "", "end", "(Landroid/text/Spanned;II)[Ljava/lang/Object;", "toSpanned", "", "core-ktx_release"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: SpannedString.kt */
public final class SpannedStringKt {
    public static final Spanned toSpanned(CharSequence charSequence) {
        C8271i.m35386b(charSequence, "$this$toSpanned");
        SpannedString valueOf = SpannedString.valueOf(charSequence);
        C8271i.m35382a((Object) valueOf, "SpannedString.valueOf(this)");
        return valueOf;
    }

    static /* synthetic */ Object[] getSpans$default(Spanned spanned, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = spanned.length();
        }
        C8271i.m35381a(4, "T");
        Object[] spans = spanned.getSpans(i, i2, Object.class);
        C8271i.m35382a((Object) spans, "getSpans(start, end, T::class.java)");
        return spans;
    }

    private static final <T> T[] getSpans(Spanned spanned, int i, int i2) {
        C8271i.m35381a(4, "T");
        T[] spans = spanned.getSpans(i, i2, Object.class);
        C8271i.m35382a((Object) spans, "getSpans(start, end, T::class.java)");
        return spans;
    }
}
