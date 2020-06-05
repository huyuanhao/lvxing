package com.scwang.smartrefresh.layout.header;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.p527a.RefreshHeader;
import com.scwang.smartrefresh.layout.p527a.RefreshKernel;
import com.scwang.smartrefresh.layout.p527a.RefreshLayout;
import com.scwang.smartrefresh.layout.p529c.DensityUtil;

public class FalsifyHeader extends InternalAbstract implements RefreshHeader {
    /* renamed from: i */
    protected RefreshKernel f20909i;

    public FalsifyHeader(Context context) {
        this(context, null);
    }

    public FalsifyHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FalsifyHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int a = DensityUtil.m25572a(5.0f);
            Paint paint = new Paint();
            paint.setStyle(Style.STROKE);
            paint.setColor(-858993460);
            paint.setStrokeWidth((float) DensityUtil.m25572a(1.0f));
            float f = (float) a;
            paint.setPathEffect(new DashPathEffect(new float[]{f, f, f, f}, 1.0f));
            canvas.drawRect(f, f, (float) (getWidth() - a), (float) (getBottom() - a), paint);
            TextView textView = new TextView(getContext());
            textView.setText(getResources().getString(R.string.srl_component_falsify, new Object[]{getClass().getSimpleName(), Float.valueOf(DensityUtil.m25571a(getHeight()))}));
            textView.setTextColor(-858993460);
            textView.setGravity(17);
            textView.measure(MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
            textView.layout(0, 0, getWidth(), getHeight());
            textView.draw(canvas);
        }
    }

    /* renamed from: a */
    public void mo30677a(RefreshKernel iVar, int i, int i2) {
        this.f20909i = iVar;
    }

    /* renamed from: a */
    public void mo30671a(RefreshLayout jVar, int i, int i2) {
        RefreshKernel iVar = this.f20909i;
        if (iVar != null) {
            iVar.mo30929a(RefreshState.None);
            this.f20909i.mo30929a(RefreshState.RefreshFinish);
        }
    }
}
