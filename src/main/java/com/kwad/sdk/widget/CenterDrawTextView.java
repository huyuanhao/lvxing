package com.kwad.sdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

public class CenterDrawTextView extends TextView {
    public CenterDrawTextView(Context context) {
        super(context);
    }

    public CenterDrawTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Drawable[] compoundDrawables = getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 3) {
            Drawable drawable = compoundDrawables[2];
            if (drawable != null) {
                float measureText = getPaint().measureText(getText().toString()) + ((float) drawable.getIntrinsicWidth()) + ((float) getCompoundDrawablePadding());
                setPadding(0, 0, (int) (((float) getWidth()) - measureText), 0);
                canvas.translate((((float) getWidth()) - measureText) / 2.0f, 0.0f);
            }
        }
        super.onDraw(canvas);
    }
}
