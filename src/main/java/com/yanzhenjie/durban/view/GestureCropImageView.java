package com.yanzhenjie.durban.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import com.yanzhenjie.durban.p632c.RotationGestureDetector;
import com.yanzhenjie.durban.p632c.RotationGestureDetector.C7797b;

public class GestureCropImageView extends CropImageView {
    /* renamed from: i */
    private ScaleGestureDetector f26545i;
    /* renamed from: j */
    private RotationGestureDetector f26546j;
    /* renamed from: k */
    private GestureDetector f26547k;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public float f26548l;
    /* access modifiers changed from: private */
    /* renamed from: m */
    public float f26549m;
    /* renamed from: n */
    private boolean f26550n;
    /* renamed from: o */
    private boolean f26551o;
    /* renamed from: p */
    private int f26552p;

    /* renamed from: com.yanzhenjie.durban.view.GestureCropImageView$a */
    private class C7804a extends SimpleOnGestureListener {
        private C7804a() {
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            GestureCropImageView gestureCropImageView = GestureCropImageView.this;
            gestureCropImageView.mo37869a(gestureCropImageView.getDoubleTapTargetScale(), motionEvent.getX(), motionEvent.getY(), 200);
            return super.onDoubleTap(motionEvent);
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            GestureCropImageView.this.mo37933a(-f, -f2);
            return true;
        }
    }

    /* renamed from: com.yanzhenjie.durban.view.GestureCropImageView$b */
    private class C7805b extends C7797b {
        private C7805b() {
        }

        /* renamed from: a */
        public boolean mo37847a(RotationGestureDetector iVar) {
            GestureCropImageView.this.mo37935d(iVar.mo37845a(), GestureCropImageView.this.f26548l, GestureCropImageView.this.f26549m);
            return true;
        }
    }

    /* renamed from: com.yanzhenjie.durban.view.GestureCropImageView$c */
    private class C7806c extends SimpleOnScaleGestureListener {
        private C7806c() {
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            GestureCropImageView.this.mo37878c(scaleGestureDetector.getScaleFactor(), GestureCropImageView.this.f26548l, GestureCropImageView.this.f26549m);
            return true;
        }
    }

    public GestureCropImageView(Context context) {
        super(context);
        this.f26550n = true;
        this.f26551o = true;
        this.f26552p = 5;
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f26550n = true;
        this.f26551o = true;
        this.f26552p = 5;
    }

    public void setScaleEnabled(boolean z) {
        this.f26551o = z;
    }

    public void setRotateEnabled(boolean z) {
        this.f26550n = z;
    }

    public void setDoubleTapScaleSteps(int i) {
        this.f26552p = i;
    }

    public int getDoubleTapScaleSteps() {
        return this.f26552p;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 0) {
            mo37866a();
        }
        if (motionEvent.getPointerCount() > 1) {
            this.f26548l = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
            this.f26549m = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
        }
        this.f26547k.onTouchEvent(motionEvent);
        if (this.f26551o) {
            this.f26545i.onTouchEvent(motionEvent);
        }
        if (this.f26550n) {
            this.f26546j.mo37846a(motionEvent);
        }
        if ((motionEvent.getAction() & 255) == 1) {
            mo37873b();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo37897e() {
        super.mo37897e();
        m33899f();
    }

    /* access modifiers changed from: protected */
    public float getDoubleTapTargetScale() {
        return getCurrentScale() * ((float) Math.pow((double) (getMaxScale() / getMinScale()), (double) (1.0f / ((float) this.f26552p))));
    }

    /* renamed from: f */
    private void m33899f() {
        this.f26547k = new GestureDetector(getContext(), new C7804a(), null, true);
        this.f26545i = new ScaleGestureDetector(getContext(), new C7806c());
        this.f26546j = new RotationGestureDetector(new C7805b());
    }
}
