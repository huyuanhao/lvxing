package com.jiayouya.travel.common.p243a;

import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.SpannableString;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.widget.RoundedBackgroundSpan;
import com.jiayouya.travel.module.common.data.ListEmptyData;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0002\u0010\fJ\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000fH\u0007J\u001a\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J\u001a\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000fH\u0007¨\u0006\u0019"}, mo39189d2 = {"Lcom/jiayouya/travel/common/adapter/TextViewAdapter;", "", "()V", "adapt", "", "view", "Landroid/widget/TextView;", "item", "Lcom/jiayouya/travel/module/common/data/ListEmptyData;", "adaptTextSize", "textSize", "", "(Landroid/widget/TextView;Ljava/lang/Float;)V", "adaptTextStyle", "isBold", "", "(Landroid/widget/TextView;Ljava/lang/Boolean;)V", "adapt_deleteLine", "textView", "flag", "adapt_html", "value", "", "adapt_platform", "adapt_underline", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
@BindingMethods({@BindingMethod(attribute = "android:lines", method = "setLines", type = TextView.class)})
/* renamed from: com.jiayouya.travel.common.a.d */
public final class TextViewAdapter {
    /* renamed from: a */
    public static final TextViewAdapter f9561a = new TextViewAdapter();

    private TextViewAdapter() {
    }

    @JvmStatic
    @BindingAdapter({"html"})
    /* renamed from: a */
    public static final void m12787a(TextView textView, String str) {
        C8271i.m35386b(textView, "view");
        if (str == null) {
            textView.setText("");
        } else {
            textView.setText(Html.fromHtml(str));
        }
    }

    @JvmStatic
    @BindingAdapter({"empty"})
    /* renamed from: a */
    public static final void m12786a(TextView textView, ListEmptyData listEmptyData) {
        C8271i.m35386b(textView, "view");
        if (!(listEmptyData == null || listEmptyData.getImg() == -1)) {
            Drawable drawable = ContextCompat.getDrawable(textView.getContext(), listEmptyData.getImg());
            if (drawable != null) {
                C8271i.m35382a((Object) drawable, "ContextCompat.getDrawabl…text, item.img) ?: return");
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                textView.setCompoundDrawables(null, drawable, null, null);
            }
        }
    }

    @JvmStatic
    @BindingAdapter({"platform"})
    /* renamed from: b */
    public static final void m12788b(TextView textView, String str) {
        C8271i.m35386b(textView, "textView");
        if (str != null) {
            RoundedBackgroundSpan cVar = new RoundedBackgroundSpan(textView.getContext(), C8271i.m35384a((Object) str, (Object) "淘宝") ? R.color.green_start : R.color.orange_FFA229, str, R.color.white);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" ");
            sb.append(textView.getText());
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(cVar, 0, str.length(), 33);
            textView.setText(spannableString);
        }
    }
}
