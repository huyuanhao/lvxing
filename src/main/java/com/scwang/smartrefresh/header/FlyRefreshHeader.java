package com.scwang.smartrefresh.header;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.scwang.smartrefresh.header.flyrefresh.MountainSceneView;
import com.scwang.smartrefresh.layout.header.FalsifyHeader;
import com.scwang.smartrefresh.layout.p527a.RefreshHeader;
import com.scwang.smartrefresh.layout.p527a.RefreshKernel;
import com.scwang.smartrefresh.layout.p527a.RefreshLayout;
import com.scwang.smartrefresh.layout.p529c.DensityUtil;

public class FlyRefreshHeader extends FalsifyHeader implements RefreshHeader {
    /* renamed from: a */
    protected View f20402a;
    /* renamed from: b */
    protected AnimatorSet f20403b;
    /* renamed from: c */
    protected RefreshLayout f20404c;
    /* renamed from: d */
    protected RefreshKernel f20405d;
    /* renamed from: e */
    protected MountainSceneView f20406e;
    /* renamed from: f */
    protected int f20407f = 0;
    /* renamed from: g */
    protected float f20408g;
    /* renamed from: h */
    protected boolean f20409h = false;

    public FlyRefreshHeader(Context context) {
        super(context);
    }

    public FlyRefreshHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FlyRefreshHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: a */
    public void mo30672a(boolean z, float f, int i, int i2, int i3) {
        if (z || !this.f20409h) {
            if (i < 0) {
                if (this.f20407f > 0) {
                    i = 0;
                    f = 0.0f;
                } else {
                    return;
                }
            }
            this.f20407f = i;
            this.f20408g = f;
            MountainSceneView mountainSceneView = this.f20406e;
            if (mountainSceneView != null) {
                mountainSceneView.mo30753a(f);
                this.f20406e.postInvalidate();
            }
            View view = this.f20402a;
            if (view != null) {
                int i4 = i2 + i3;
                if (i4 > 0) {
                    view.setRotation((((float) i) * -45.0f) / ((float) i4));
                } else {
                    view.setRotation(f * -45.0f);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo30671a(RefreshLayout jVar, int i, int i2) {
        this.f20405d.mo30925a(0);
        float f = this.f20408g;
        if (f > 0.0f) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, 0.0f});
            ofFloat.setDuration(300);
            ofFloat.addUpdateListener(new AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlyRefreshHeader.this.mo30672a(true, ((Float) valueAnimator.getAnimatedValue()).floatValue(), 0, 0, 0);
                }
            });
            ofFloat.start();
            this.f20408g = 0.0f;
        }
        if (this.f20402a != null && !this.f20409h) {
            AnimatorSet animatorSet = this.f20403b;
            if (animatorSet != null) {
                animatorSet.end();
                this.f20402a.clearAnimation();
            }
            this.f20409h = true;
            jVar.mo30900i(false);
            int width = ((View) this.f20404c).getWidth() - this.f20402a.getLeft();
            int i3 = ((-(this.f20402a.getTop() - this.f20407f)) * 2) / 3;
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f20402a, "translationX", new float[]{0.0f, (float) width});
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f20402a, "translationY", new float[]{0.0f, (float) i3});
            ofFloat3.setInterpolator(PathInterpolatorCompat.create(0.7f, 1.0f));
            View view = this.f20402a;
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, C7887a.ROTATION, new float[]{view.getRotation(), 0.0f});
            ofFloat4.setInterpolator(new DecelerateInterpolator());
            View view2 = this.f20402a;
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view2, "rotationX", new float[]{view2.getRotationX(), 50.0f});
            ofFloat5.setInterpolator(new DecelerateInterpolator());
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(800);
            View view3 = this.f20402a;
            float[] fArr = {view3.getScaleX(), 0.5f};
            View view4 = this.f20402a;
            animatorSet2.playTogether(new Animator[]{ofFloat2, ofFloat3, ofFloat4, ofFloat5, ObjectAnimator.ofFloat(view3, "scaleX", fArr), ObjectAnimator.ofFloat(view4, "scaleY", new float[]{view4.getScaleY(), 0.5f})});
            this.f20403b = animatorSet2;
            this.f20403b.start();
        }
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            MountainSceneView mountainSceneView = this.f20406e;
            if (mountainSceneView != null) {
                mountainSceneView.setPrimaryColor(iArr[0]);
            }
        }
    }

    /* renamed from: a */
    public void mo30677a(RefreshKernel iVar, int i, int i2) {
        this.f20405d = iVar;
        this.f20404c = iVar.mo30931a();
        this.f20404c.mo30891g(false);
    }

    /* renamed from: a */
    public int mo30670a(RefreshLayout jVar, boolean z) {
        if (this.f20409h) {
            mo30689a();
        }
        return super.mo30670a(jVar, z);
    }

    /* renamed from: a */
    public void mo30689a() {
        mo30690a(null);
    }

    /* renamed from: a */
    public void mo30690a(AnimatorListenerAdapter animatorListenerAdapter) {
        if (this.f20402a != null && this.f20409h && this.f20404c != null) {
            AnimatorSet animatorSet = this.f20403b;
            if (animatorSet != null) {
                animatorSet.end();
                this.f20402a.clearAnimation();
            }
            this.f20409h = false;
            this.f20404c.mo30882d(0);
            int i = -this.f20402a.getRight();
            int i2 = -DensityUtil.m25572a(10.0f);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(800);
            View view = this.f20402a;
            float f = (float) i;
            String str = "translationX";
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, str, new float[]{view.getTranslationX(), f});
            View view2 = this.f20402a;
            float f2 = (float) i2;
            String str2 = "translationY";
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, str2, new float[]{view2.getTranslationY(), f2});
            ofFloat2.setInterpolator(PathInterpolatorCompat.create(0.1f, 1.0f));
            View view3 = this.f20402a;
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view3, C7887a.ROTATION, new float[]{view3.getRotation(), 0.0f});
            View view4 = this.f20402a;
            String str3 = "rotationX";
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view4, str3, new float[]{view4.getRotationX(), 30.0f});
            ofFloat3.setInterpolator(new AccelerateInterpolator());
            View view5 = this.f20402a;
            float[] fArr = {view5.getScaleX(), 0.9f};
            String str4 = "scaleX";
            View view6 = this.f20402a;
            String str5 = "scaleY";
            animatorSet2.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3, ofFloat4, ObjectAnimator.ofFloat(view5, str4, fArr), ObjectAnimator.ofFloat(view6, str5, new float[]{view6.getScaleY(), 0.9f})});
            animatorSet2.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    if (FlyRefreshHeader.this.f20402a != null) {
                        FlyRefreshHeader.this.f20402a.setRotationY(180.0f);
                    }
                }
            });
            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.setDuration(800);
            animatorSet3.setInterpolator(new DecelerateInterpolator());
            animatorSet3.playTogether(new Animator[]{ObjectAnimator.ofFloat(this.f20402a, str, new float[]{f, 0.0f}), ObjectAnimator.ofFloat(this.f20402a, str2, new float[]{f2, 0.0f}), ObjectAnimator.ofFloat(this.f20402a, str3, new float[]{30.0f, 0.0f}), ObjectAnimator.ofFloat(this.f20402a, str4, new float[]{0.9f, 1.0f}), ObjectAnimator.ofFloat(this.f20402a, str5, new float[]{0.9f, 1.0f})});
            animatorSet3.setStartDelay(100);
            final AnimatorListenerAdapter animatorListenerAdapter2 = animatorListenerAdapter;
            animatorSet3.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    if (FlyRefreshHeader.this.f20402a != null) {
                        FlyRefreshHeader.this.f20402a.setRotationY(0.0f);
                    }
                }

                public void onAnimationEnd(Animator animator) {
                    if (FlyRefreshHeader.this.f20404c != null) {
                        FlyRefreshHeader.this.f20404c.mo30900i(true);
                    }
                    AnimatorListenerAdapter animatorListenerAdapter = animatorListenerAdapter2;
                    if (animatorListenerAdapter != null) {
                        animatorListenerAdapter.onAnimationEnd(animator);
                    }
                }
            });
            this.f20403b = new AnimatorSet();
            this.f20403b.playSequentially(new Animator[]{animatorSet2, animatorSet3});
            this.f20403b.start();
        }
    }
}
