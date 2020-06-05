package androidx.core.text;

import android.text.Html.ImageGetter;
import android.text.Html.TagHandler;
import android.text.Spanned;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\b\u001a\u0017\u0010\t\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u0004H\b¨\u0006\u000b"}, mo39189d2 = {"parseAsHtml", "Landroid/text/Spanned;", "", "flags", "", "imageGetter", "Landroid/text/Html$ImageGetter;", "tagHandler", "Landroid/text/Html$TagHandler;", "toHtml", "option", "core-ktx_release"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: Html.kt */
public final class HtmlKt {
    public static /* synthetic */ Spanned parseAsHtml$default(String str, int i, ImageGetter imageGetter, TagHandler tagHandler, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            imageGetter = null;
        }
        if ((i2 & 4) != 0) {
            tagHandler = null;
        }
        C8271i.m35386b(str, "$this$parseAsHtml");
        Spanned fromHtml = HtmlCompat.fromHtml(str, i, imageGetter, tagHandler);
        C8271i.m35382a((Object) fromHtml, "HtmlCompat.fromHtml(this… imageGetter, tagHandler)");
        return fromHtml;
    }

    public static final Spanned parseAsHtml(String str, int i, ImageGetter imageGetter, TagHandler tagHandler) {
        C8271i.m35386b(str, "$this$parseAsHtml");
        Spanned fromHtml = HtmlCompat.fromHtml(str, i, imageGetter, tagHandler);
        C8271i.m35382a((Object) fromHtml, "HtmlCompat.fromHtml(this… imageGetter, tagHandler)");
        return fromHtml;
    }

    public static /* synthetic */ String toHtml$default(Spanned spanned, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        C8271i.m35386b(spanned, "$this$toHtml");
        String html = HtmlCompat.toHtml(spanned, i);
        C8271i.m35382a((Object) html, "HtmlCompat.toHtml(this, option)");
        return html;
    }

    public static final String toHtml(Spanned spanned, int i) {
        C8271i.m35386b(spanned, "$this$toHtml");
        String html = HtmlCompat.toHtml(spanned, i);
        C8271i.m35382a((Object) html, "HtmlCompat.toHtml(this, option)");
        return html;
    }
}
