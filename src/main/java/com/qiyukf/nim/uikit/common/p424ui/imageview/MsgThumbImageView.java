package com.qiyukf.nim.uikit.common.p424ui.imageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.qiyukf.nim.uikit.C5426a;

/* renamed from: com.qiyukf.nim.uikit.common.ui.imageview.MsgThumbImageView */
public class MsgThumbImageView extends ImageView {
    /* renamed from: b */
    private static final Paint f17614b;
    /* renamed from: a */
    private Drawable f17615a;

    static {
        Paint paint = new Paint();
        f17614b = paint;
        paint.setAntiAlias(true);
        f17614b.setFilterBitmap(true);
        f17614b.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
    }

    public MsgThumbImageView(Context context) {
        super(context);
    }

    public MsgThumbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MsgThumbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: a */
    private void m22335a(int i) {
        this.f17615a = i != 0 ? ContextCompat.getDrawable(getContext(), i) : null;
    }

    /* renamed from: a */
    private void m22336a(int i, int i2) {
        LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    public final void mo27538a(int i, int i2, int i3, int i4) {
        m22336a(i2, i3);
        m22335a(i4);
        setImageDrawable(ContextCompat.getDrawable(getContext(), i));
    }

    /* renamed from: a */
    public final void mo27539a(Bitmap bitmap, int i, int i2, int i3) {
        m22336a(i, i2);
        m22335a(i3);
        setImageBitmap(bitmap);
    }

    /* renamed from: a */
    public final void mo27540a(String str, int i, int i2, int i3) {
        m22336a(i, i2);
        m22335a(i3);
        StringBuilder sb = new StringBuilder("file://");
        sb.append(str);
        C5426a.m22179a(sb.toString(), (ImageView) this, i, i2);
    }

    public boolean isOpaque() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f17615a != null) {
            int width = getWidth();
            int height = getHeight();
            float f = (float) width;
            float f2 = (float) height;
            canvas.saveLayer(0.0f, 0.0f, f, f2, null, 31);
            Drawable drawable = this.f17615a;
            if (drawable != null) {
                drawable.setBounds(0, 0, width, height);
                this.f17615a.draw(canvas);
            }
            canvas.saveLayer(0.0f, 0.0f, f, f2, f17614b, 31);
            super.onDraw(canvas);
            canvas.restore();
            canvas.restore();
            return;
        }
        super.onDraw(canvas);
    }
}
