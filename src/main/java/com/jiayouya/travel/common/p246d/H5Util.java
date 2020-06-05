package com.jiayouya.travel.common.p246d;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000 \n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, mo39189d2 = {"getClickableHtml", "", "spannedHtml", "Landroid/text/Spanned;", "setLinkClickable", "", "clickableHtmlBuilder", "Landroid/text/SpannableStringBuilder;", "urlSpan", "Landroid/text/style/URLSpan;", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.common.d.g */
public final class H5Util {

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo39189d2 = {"com/jiayouya/travel/common/util/H5UtilKt$setLinkClickable$clickableSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: H5Util.kt */
    /* renamed from: com.jiayouya.travel.common.d.g$a */
    public static final class C2898a extends ClickableSpan {
        /* renamed from: a */
        final /* synthetic */ URLSpan f9635a;

        C2898a(URLSpan uRLSpan) {
            this.f9635a = uRLSpan;
        }

        public void onClick(View view) {
            C8271i.m35386b(view, "widget");
            String url = this.f9635a.getURL();
            Router mVar = Router.f9644a;
            C8271i.m35382a((Object) url, "s");
            Router.m12969a(mVar, url, null, null, 6, null);
        }
    }

    /* renamed from: a */
    public static final void m12959a(SpannableStringBuilder spannableStringBuilder, URLSpan uRLSpan) {
        C8271i.m35386b(spannableStringBuilder, "clickableHtmlBuilder");
        C8271i.m35386b(uRLSpan, "urlSpan");
        spannableStringBuilder.setSpan(new C2898a(uRLSpan), spannableStringBuilder.getSpanStart(uRLSpan), spannableStringBuilder.getSpanEnd(uRLSpan), spannableStringBuilder.getSpanFlags(uRLSpan));
    }

    /* renamed from: a */
    public static final CharSequence m12958a(Spanned spanned) {
        C8271i.m35386b(spanned, "spannedHtml");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spanned);
        URLSpan[] uRLSpanArr = (URLSpan[]) spannableStringBuilder.getSpans(0, spanned.length(), URLSpan.class);
        C8271i.m35382a((Object) uRLSpanArr, "urls");
        for (URLSpan uRLSpan : uRLSpanArr) {
            C8271i.m35382a((Object) uRLSpan, "it");
            m12959a(spannableStringBuilder, uRLSpan);
        }
        return spannableStringBuilder;
    }
}
