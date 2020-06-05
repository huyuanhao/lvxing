package com.akexorcist.roundcornerprogressbar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class RoundCornerTextView extends TextView {
    /* renamed from: a */
    private C0949a f1796a;

    /* renamed from: com.akexorcist.roundcornerprogressbar.RoundCornerTextView$a */
    public interface C0949a {
        /* renamed from: a */
        void mo10209a(TextView textView);
    }

    public RoundCornerTextView(Context context) {
        super(context);
    }

    public RoundCornerTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RoundCornerTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        C0949a aVar = this.f1796a;
        if (aVar != null) {
            aVar.mo10209a(this);
        }
    }

    public void setOnSizeChangedListener(C0949a aVar) {
        this.f1796a = aVar;
    }
}
