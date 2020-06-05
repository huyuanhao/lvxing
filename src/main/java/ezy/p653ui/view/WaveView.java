package ezy.p653ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ezy.ui.view.WaveView */
public class WaveView extends View {
    private List<Circle> mCircleList;
    /* access modifiers changed from: private */
    public Runnable mCreateCircle;
    /* access modifiers changed from: private */
    public long mDuration;
    /* access modifiers changed from: private */
    public float mInitialRadius;
    /* access modifiers changed from: private */
    public Interpolator mInterpolator;
    /* access modifiers changed from: private */
    public boolean mIsRunning;
    private long mLastCreateTime;
    /* access modifiers changed from: private */
    public float mMaxRadius;
    private float mMaxRadiusRate;
    private boolean mMaxRadiusSet;
    private Paint mPaint;
    /* access modifiers changed from: private */
    public int mSpeed;

    /* renamed from: ezy.ui.view.WaveView$Circle */
    private class Circle {
        /* access modifiers changed from: private */
        public long mCreateTime = System.currentTimeMillis();

        public Circle() {
        }

        public int getAlpha() {
            return (int) ((0.5f - WaveView.this.mInterpolator.getInterpolation((((float) (System.currentTimeMillis() - this.mCreateTime)) * 0.5f) / ((float) WaveView.this.mDuration))) * 255.0f);
        }

        public float getCurrentRadius() {
            return WaveView.this.mInitialRadius + (WaveView.this.mInterpolator.getInterpolation((((float) (System.currentTimeMillis() - this.mCreateTime)) * 1.0f) / ((float) WaveView.this.mDuration)) * (WaveView.this.mMaxRadius - WaveView.this.mInitialRadius));
        }
    }

    public WaveView(Context context) {
        this(context, null);
    }

    public WaveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInitialRadius = 100.0f;
        this.mMaxRadiusRate = 0.85f;
        this.mDuration = 2000;
        this.mSpeed = 1000;
        this.mInterpolator = new LinearInterpolator();
        this.mCircleList = new ArrayList();
        this.mCreateCircle = new Runnable() {
            public void run() {
                if (WaveView.this.mIsRunning) {
                    WaveView.this.newCircle();
                    WaveView waveView = WaveView.this;
                    waveView.postDelayed(waveView.mCreateCircle, (long) WaveView.this.mSpeed);
                }
            }
        };
        this.mPaint = new Paint(1);
        setStyle(Style.FILL);
    }

    public void setStyle(Style style) {
        this.mPaint.setStyle(style);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (!this.mMaxRadiusSet) {
            this.mMaxRadius = (((float) Math.min(i, i2)) * this.mMaxRadiusRate) / 2.0f;
        }
    }

    public void setMaxRadiusRate(float f) {
        this.mMaxRadiusRate = f;
    }

    public void setColor(int i) {
        this.mPaint.setColor(i);
    }

    public void start() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.mCreateCircle.run();
        }
    }

    public void stop() {
        this.mIsRunning = false;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Iterator it = this.mCircleList.iterator();
        while (it.hasNext()) {
            Circle circle = (Circle) it.next();
            if (System.currentTimeMillis() - circle.mCreateTime < this.mDuration) {
                this.mPaint.setAlpha(circle.getAlpha());
                canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), circle.getCurrentRadius(), this.mPaint);
            } else {
                it.remove();
            }
        }
        if (this.mCircleList.size() > 0) {
            postInvalidateDelayed(10);
        }
    }

    public void setInitialRadius(float f) {
        this.mInitialRadius = f;
    }

    public void setDuration(long j) {
        this.mDuration = j;
    }

    public void setMaxRadius(float f) {
        this.mMaxRadius = f;
        this.mMaxRadiusSet = true;
    }

    public void setSpeed(int i) {
        this.mSpeed = i;
    }

    /* access modifiers changed from: private */
    public void newCircle() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mLastCreateTime >= ((long) this.mSpeed)) {
            this.mCircleList.add(new Circle());
            invalidate();
            this.mLastCreateTime = currentTimeMillis;
        }
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
        if (this.mInterpolator == null) {
            this.mInterpolator = new LinearInterpolator();
        }
    }
}
