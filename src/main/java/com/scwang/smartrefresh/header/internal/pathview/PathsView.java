package com.scwang.smartrefresh.header.internal.pathview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class PathsView extends View {
    /* renamed from: a */
    protected PathsDrawable f20658a;

    public PathsView(Context context) {
        this(context, null);
    }

    public PathsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20658a = new PathsDrawable();
        this.f20658a = new PathsDrawable();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getTag() instanceof String) {
            mo30800a(getTag().toString());
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        PathsDrawable bVar = this.f20658a;
        super.setMeasuredDimension(View.resolveSize(bVar.getBounds().width() + getPaddingLeft() + getPaddingRight(), i), View.resolveSize(bVar.getBounds().height() + getPaddingTop() + getPaddingBottom(), i2));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f20658a.setBounds(getPaddingLeft(), getPaddingTop(), Math.max((i3 - i) - getPaddingRight(), getPaddingLeft()), Math.max((i4 - i2) - getPaddingTop(), getPaddingTop()));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.f20658a.draw(canvas);
    }

    /* renamed from: a */
    public boolean mo30800a(String... strArr) {
        return this.f20658a.mo30809a(strArr);
    }

    /* renamed from: a */
    public void mo30799a(int... iArr) {
        this.f20658a.mo30807a(iArr);
    }
}
