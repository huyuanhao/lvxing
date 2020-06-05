package com.yanzhenjie.durban.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.yanzhenjie.durban.R;
import com.yanzhenjie.durban.p630a.CropBoundsChangeListener;
import com.yanzhenjie.durban.p630a.OverlayViewChangeListener;

public class CropView extends FrameLayout {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public GestureCropImageView f26541a;
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final OverlayView f26542b;

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public CropView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CropView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.durban_crop_view, this, true);
        this.f26541a = (GestureCropImageView) findViewById(R.id.image_view_crop);
        this.f26542b = (OverlayView) findViewById(R.id.view_overlay);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.durban_CropView);
        this.f26542b.mo37908a(obtainStyledAttributes);
        this.f26541a.mo37870a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        m33893a();
    }

    /* renamed from: a */
    private void m33893a() {
        this.f26541a.setCropBoundsChangeListener(new CropBoundsChangeListener() {
            /* renamed from: a */
            public void mo37812a(float f) {
                CropView.this.f26542b.setTargetAspectRatio(f);
            }
        });
        this.f26542b.setOverlayViewChangeListener(new OverlayViewChangeListener() {
            /* renamed from: a */
            public void mo37813a(RectF rectF) {
                CropView.this.f26541a.setCropRect(rectF);
            }
        });
    }

    public GestureCropImageView getCropImageView() {
        return this.f26541a;
    }

    public OverlayView getOverlayView() {
        return this.f26542b;
    }
}
