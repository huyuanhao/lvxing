package com.scwang.smartrefresh.layout.footer;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import androidx.core.graphics.ColorUtils;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.p527a.RefreshFooter;
import com.scwang.smartrefresh.layout.p527a.RefreshLayout;
import com.scwang.smartrefresh.layout.p529c.DensityUtil;
import com.tencent.p605ep.commonbase.utils.ScreenUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BallPulseFooter extends InternalAbstract implements RefreshFooter {
    /* renamed from: a */
    protected boolean f20847a;
    /* renamed from: b */
    protected boolean f20848b;
    /* renamed from: c */
    protected Paint f20849c;
    /* renamed from: d */
    protected int f20850d;
    /* renamed from: e */
    protected int f20851e;
    /* renamed from: f */
    protected float f20852f;
    /* renamed from: g */
    protected float[] f20853g;
    /* renamed from: h */
    protected boolean f20854h;
    /* renamed from: i */
    protected ArrayList<ValueAnimator> f20855i;
    /* renamed from: j */
    protected Map<ValueAnimator, AnimatorUpdateListener> f20856j;

    /* renamed from: a */
    public boolean mo30950a(boolean z) {
        return false;
    }

    public BallPulseFooter(Context context) {
        this(context, null);
    }

    public BallPulseFooter(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BallPulseFooter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20850d = -1118482;
        this.f20851e = -1615546;
        this.f20853g = new float[]{1.0f, 1.0f, 1.0f};
        this.f20854h = false;
        this.f20856j = new HashMap();
        setMinimumHeight(DensityUtil.m25572a(60.0f));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BallPulseFooter);
        this.f20849c = new Paint();
        this.f20849c.setColor(-1);
        this.f20849c.setStyle(Style.FILL);
        this.f20849c.setAntiAlias(true);
        this.f20937ab = SpinnerStyle.Translate;
        this.f20937ab = SpinnerStyle.values()[obtainStyledAttributes.getInt(R.styleable.BallPulseFooter_srlClassicsSpinnerStyle, this.f20937ab.ordinal())];
        if (obtainStyledAttributes.hasValue(R.styleable.BallPulseFooter_srlNormalColor)) {
            mo30975a(obtainStyledAttributes.getColor(R.styleable.BallPulseFooter_srlNormalColor, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.BallPulseFooter_srlAnimatingColor)) {
            mo30976b(obtainStyledAttributes.getColor(R.styleable.BallPulseFooter_srlAnimatingColor, 0));
        }
        obtainStyledAttributes.recycle();
        this.f20852f = (float) DensityUtil.m25572a(4.0f);
        this.f20855i = new ArrayList<>();
        int[] iArr = {120, ScreenUtil.G8_WIDTH, 360};
        for (final int i2 = 0; i2 < 3; i2++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.3f, 1.0f});
            ofFloat.setDuration(750);
            ofFloat.setRepeatCount(-1);
            ofFloat.setTarget(Integer.valueOf(i2));
            ofFloat.setStartDelay((long) iArr[i2]);
            this.f20856j.put(ofFloat, new AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BallPulseFooter.this.f20853g[i2] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    this.postInvalidate();
                }
            });
            this.f20855i.add(ofFloat);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f20855i != null) {
            for (int i = 0; i < this.f20855i.size(); i++) {
                ((ValueAnimator) this.f20855i.get(i)).cancel();
                ((ValueAnimator) this.f20855i.get(i)).removeAllListeners();
                ((ValueAnimator) this.f20855i.get(i)).removeAllUpdateListeners();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        float min = (float) Math.min(width, height);
        float f = this.f20852f;
        float f2 = (min - (f * 2.0f)) / 6.0f;
        float f3 = 2.0f * f2;
        float f4 = ((float) (width / 2)) - (f + f3);
        float f5 = (float) (height / 2);
        for (int i = 0; i < 3; i++) {
            canvas.save();
            float f6 = (float) i;
            canvas.translate((f3 * f6) + f4 + (this.f20852f * f6), f5);
            float[] fArr = this.f20853g;
            canvas.scale(fArr[i], fArr[i]);
            canvas.drawCircle(0.0f, 0.0f, f2, this.f20849c);
            canvas.restore();
        }
        super.dispatchDraw(canvas);
    }

    /* renamed from: b */
    public void mo30679b(RefreshLayout jVar, int i, int i2) {
        if (!this.f20854h) {
            for (int i3 = 0; i3 < this.f20855i.size(); i3++) {
                ValueAnimator valueAnimator = (ValueAnimator) this.f20855i.get(i3);
                AnimatorUpdateListener animatorUpdateListener = (AnimatorUpdateListener) this.f20856j.get(valueAnimator);
                if (animatorUpdateListener != null) {
                    valueAnimator.addUpdateListener(animatorUpdateListener);
                }
                valueAnimator.start();
            }
            this.f20854h = true;
            this.f20849c.setColor(this.f20851e);
        }
    }

    /* renamed from: a */
    public int mo30670a(RefreshLayout jVar, boolean z) {
        ArrayList<ValueAnimator> arrayList = this.f20855i;
        if (arrayList != null && this.f20854h) {
            this.f20854h = false;
            this.f20853g = new float[]{1.0f, 1.0f, 1.0f};
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ValueAnimator valueAnimator = (ValueAnimator) it.next();
                if (valueAnimator != null) {
                    valueAnimator.removeAllUpdateListeners();
                    valueAnimator.end();
                }
            }
        }
        this.f20849c.setColor(this.f20850d);
        return 0;
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (!this.f20848b && iArr.length > 1) {
            mo30976b(iArr[0]);
            this.f20848b = false;
        }
        if (!this.f20847a) {
            if (iArr.length > 1) {
                mo30975a(iArr[1]);
            } else if (iArr.length > 0) {
                mo30975a(ColorUtils.compositeColors(-1711276033, iArr[0]));
            }
            this.f20847a = false;
        }
    }

    /* renamed from: a */
    public BallPulseFooter mo30975a(int i) {
        this.f20850d = i;
        this.f20847a = true;
        if (!this.f20854h) {
            this.f20849c.setColor(i);
        }
        return this;
    }

    /* renamed from: b */
    public BallPulseFooter mo30976b(int i) {
        this.f20851e = i;
        this.f20848b = true;
        if (this.f20854h) {
            this.f20849c.setColor(i);
        }
        return this;
    }
}
