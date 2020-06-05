package com.scwang.smartrefresh.header;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import com.scwang.smartrefresh.header.waterdrop.WaterDropView;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.internal.ProgressDrawable;
import com.scwang.smartrefresh.layout.p527a.RefreshHeader;
import com.scwang.smartrefresh.layout.p527a.RefreshLayout;
import com.scwang.smartrefresh.layout.p529c.DensityUtil;

public class WaterDropHeader extends InternalAbstract implements RefreshHeader {
    /* renamed from: a */
    protected RefreshState f20526a;
    /* renamed from: b */
    protected ImageView f20527b;
    /* renamed from: c */
    protected WaterDropView f20528c;
    /* renamed from: d */
    protected ProgressDrawable f20529d;
    /* renamed from: e */
    protected MaterialProgressDrawable f20530e;

    public WaterDropHeader(Context context) {
        this(context, null);
    }

    public WaterDropHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WaterDropHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        DensityUtil bVar = new DensityUtil();
        this.f20937ab = SpinnerStyle.Scale;
        this.f20528c = new WaterDropView(context);
        this.f20528c.mo30819a(0);
        addView(this.f20528c, -1, -1);
        this.f20529d = new ProgressDrawable();
        ProgressDrawable cVar = this.f20529d;
        cVar.setCallback(this);
        cVar.setBounds(0, 0, bVar.mo30968b(20.0f), bVar.mo30968b(20.0f));
        this.f20527b = new ImageView(context);
        this.f20530e = new MaterialProgressDrawable(this.f20527b);
        this.f20530e.mo30775b(-1);
        this.f20530e.setAlpha(255);
        this.f20530e.mo30772a(-1, -16737844, -48060, -10053376, -5609780, -30720);
        this.f20527b.setImageDrawable(this.f20530e);
        addView(this.f20527b, bVar.mo30968b(30.0f), bVar.mo30968b(30.0f));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        ImageView imageView = this.f20527b;
        WaterDropView waterDropView = this.f20528c;
        LayoutParams layoutParams = (LayoutParams) imageView.getLayoutParams();
        imageView.measure(MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824), MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824));
        waterDropView.measure(MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i), Integer.MIN_VALUE), i2);
        super.setMeasuredDimension(View.resolveSize(Math.max(imageView.getMeasuredWidth(), waterDropView.getMeasuredWidth()), i), View.resolveSize(Math.max(imageView.getMeasuredHeight(), waterDropView.getMeasuredHeight()), i2));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ImageView imageView = this.f20527b;
        WaterDropView waterDropView = this.f20528c;
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = waterDropView.getMeasuredWidth();
        int i5 = measuredWidth / 2;
        int i6 = measuredWidth2 / 2;
        int i7 = i5 - i6;
        waterDropView.layout(i7, 0, i7 + measuredWidth2, waterDropView.getMeasuredHeight() + 0);
        int measuredWidth3 = imageView.getMeasuredWidth();
        int measuredHeight = imageView.getMeasuredHeight();
        int i8 = measuredWidth3 / 2;
        int i9 = i5 - i8;
        int i10 = i6 - i8;
        int i11 = (measuredWidth2 - measuredWidth3) / 2;
        if (i10 + measuredHeight > waterDropView.getBottom() - i11) {
            i10 = (waterDropView.getBottom() - i11) - measuredHeight;
        }
        imageView.layout(i9, i10, measuredWidth3 + i9, measuredHeight + i10);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        WaterDropView waterDropView = this.f20528c;
        ProgressDrawable cVar = this.f20529d;
        if (this.f20526a == RefreshState.Refreshing) {
            canvas.save();
            canvas.translate((float) ((getWidth() / 2) - (cVar.getBounds().width() / 2)), (float) ((this.f20528c.getMaxCircleRadius() + waterDropView.getPaddingTop()) - (cVar.getBounds().height() / 2)));
            cVar.draw(canvas);
            canvas.restore();
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidate();
    }

    /* renamed from: a */
    public void mo30672a(boolean z, float f, int i, int i2, int i3) {
        if (z || !(this.f20526a == RefreshState.Refreshing || this.f20526a == RefreshState.RefreshReleased)) {
            WaterDropView waterDropView = this.f20528c;
            waterDropView.mo30820a(Math.max(i, 0), i3 + i2);
            waterDropView.postInvalidate();
        }
        if (z) {
            float f2 = (float) i2;
            float max = (((float) Math.max(((double) Math.min(1.0f, Math.abs((((float) i) * 1.0f) / f2))) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
            double max2 = (double) (Math.max(0.0f, Math.min((float) (Math.abs(i) - i2), f2 * 2.0f) / f2) / 4.0f);
            float f3 = max * 0.8f;
            float pow = (((0.4f * max) - 16.0f) + (((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f * 2.0f)) * 0.5f;
            this.f20530e.mo30771a(true);
            this.f20530e.mo30768a(0.0f, Math.min(0.8f, f3));
            this.f20530e.mo30767a(Math.min(1.0f, max));
            this.f20530e.mo30773b(pow);
        }
    }

    /* renamed from: a */
    public void mo30678a(RefreshLayout jVar, RefreshState refreshState, RefreshState refreshState2) {
        WaterDropView waterDropView = this.f20528c;
        ImageView imageView = this.f20527b;
        this.f20526a = refreshState2;
        switch (refreshState2) {
            case None:
                waterDropView.setVisibility(0);
                imageView.setVisibility(0);
                return;
            case PullDownToRefresh:
                waterDropView.setVisibility(0);
                imageView.setVisibility(0);
                return;
            case ReleaseToRefresh:
                waterDropView.setVisibility(0);
                imageView.setVisibility(0);
                return;
            case RefreshFinish:
                waterDropView.setVisibility(8);
                imageView.setVisibility(8);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public void mo30671a(RefreshLayout jVar, int i, int i2) {
        ImageView imageView = this.f20527b;
        final WaterDropView waterDropView = this.f20528c;
        this.f20529d.start();
        imageView.setVisibility(8);
        this.f20528c.mo30817a().start();
        waterDropView.animate().setDuration(150).alpha(0.0f).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                waterDropView.setVisibility(8);
                waterDropView.setAlpha(1.0f);
            }
        });
    }

    /* renamed from: a */
    public int mo30670a(RefreshLayout jVar, boolean z) {
        this.f20529d.stop();
        return 0;
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            this.f20528c.setIndicatorColor(iArr[0]);
        }
    }
}
