package com.jiayouya.travel.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.jiayouya.travel.R;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo39189d2 = {"Lcom/jiayouya/travel/common/widget/RiseText;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "animator", "Lcom/jiayouya/travel/common/widget/RiseAnimator;", "getAnimator", "()Lcom/jiayouya/travel/common/widget/RiseAnimator;", "riseTo", "", "to", "", "from", "", "setDuration", "duration", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: RiseText.kt */
public class RiseText extends AppCompatTextView {
    /* renamed from: a */
    private final RiseAnimator f9667a;

    public RiseText(Context context, AttributeSet attributeSet) {
        C8271i.m35386b(context, "context");
        C8271i.m35386b(attributeSet, "attributeSet");
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RiseText);
        String string = obtainStyledAttributes.getString(1);
        if (string == null) {
            string = "0.##";
        }
        int i = obtainStyledAttributes.getInt(0, 1000);
        RiseAnimator a = new RiseAnimator(string).mo20026a((TextView) this, "--");
        C8271i.m35382a((Object) a, "RiseAnimator(formatStr).listen(this, \"--\")");
        this.f9667a = a;
        this.f9667a.setDuration((long) i);
        obtainStyledAttributes.recycle();
        setIncludeFontPadding(false);
    }

    public final RiseAnimator getAnimator() {
        return this.f9667a;
    }

    /* renamed from: a */
    public final void mo20021a(double d, double d2) {
        this.f9667a.mo20027a(d, d2);
    }

    public final void setDuration(long j) {
        this.f9667a.setDuration(j);
    }
}
