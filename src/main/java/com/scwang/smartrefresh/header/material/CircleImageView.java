package com.scwang.smartrefresh.header.material;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.widget.ImageView;

public class CircleImageView extends ImageView {
    /* renamed from: a */
    int f20677a;

    /* renamed from: com.scwang.smartrefresh.header.material.CircleImageView$a */
    private class C6476a extends OvalShape {
        /* renamed from: b */
        private RadialGradient f20679b;
        /* renamed from: c */
        private Paint f20680c = new Paint();

        C6476a(int i) {
            CircleImageView.this.f20677a = i;
            m25447a((int) super.rect().width());
        }

        /* access modifiers changed from: protected */
        public void onResize(float f, float f2) {
            super.onResize(f, f2);
            m25447a((int) f);
        }

        public void draw(Canvas canvas, Paint paint) {
            CircleImageView circleImageView = CircleImageView.this;
            int width = circleImageView.getWidth() / 2;
            float f = (float) width;
            float height = (float) (circleImageView.getHeight() / 2);
            canvas.drawCircle(f, height, f, this.f20680c);
            canvas.drawCircle(f, height, (float) (width - CircleImageView.this.f20677a), paint);
        }

        /* renamed from: a */
        private void m25447a(int i) {
            float f = (float) (i / 2);
            RadialGradient radialGradient = new RadialGradient(f, f, (float) CircleImageView.this.f20677a, new int[]{1023410176, 0}, null, TileMode.CLAMP);
            this.f20679b = radialGradient;
            this.f20680c.setShader(this.f20679b);
        }
    }

    public CircleImageView(Context context, int i) {
        ShapeDrawable shapeDrawable;
        super(context);
        float f = getResources().getDisplayMetrics().density;
        int i2 = (int) (1.75f * f);
        int i3 = (int) (0.0f * f);
        this.f20677a = (int) (3.5f * f);
        if (VERSION.SDK_INT >= 21) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            setElevation(f * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new C6476a(this.f20677a));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer((float) this.f20677a, (float) i3, (float) i2, 503316480);
            int i4 = this.f20677a;
            setPadding(i4, i4, i4, i4);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(i);
        if (VERSION.SDK_INT >= 16) {
            setBackground(shapeDrawable);
        } else {
            setBackgroundDrawable(shapeDrawable);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (VERSION.SDK_INT < 21) {
            super.setMeasuredDimension(getMeasuredWidth() + (this.f20677a * 2), getMeasuredHeight() + (this.f20677a * 2));
        }
    }
}
