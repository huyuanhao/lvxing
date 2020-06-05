package com.bytedance.sdk.openadsdk.component.reward.top;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.utils.C2564t;

public class TopProxyLayout extends View implements ITopLayout<TopProxyLayout> {
    /* renamed from: a */
    private ITopLayout f7026a;

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
    }

    public void draw(Canvas canvas) {
    }

    public TopProxyLayout(Context context) {
        this(context, null);
    }

    public TopProxyLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopProxyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setVisibility(8);
        setWillNotDraw(true);
    }

    /* renamed from: a */
    public TopProxyLayout mo15179a(boolean z, MaterialMeta kVar) {
        View view;
        boolean z2 = true;
        if (!kVar.mo15503q() || kVar.mo15466c() != 1) {
            z2 = false;
        }
        if (!kVar.mo15457ac() || z2) {
            view = new TopLayout1(getContext()).mo15162a(z, kVar);
        } else {
            view = new TopLayoutDislike2(getContext()).mo15175a(z, kVar);
        }
        if (view instanceof ITopLayout) {
            this.f7026a = (ITopLayout) view;
            ViewParent parent = getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                m8820a(view, (ViewGroup) parent);
            }
            return this;
        }
        C2564t.m12226e("TopProxyLayout", "view not implements ITopLayout interface");
        return this;
    }

    /* renamed from: a */
    private void m8820a(View view, ViewGroup viewGroup) {
        int indexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, indexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, indexOfChild);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setShowSkip(boolean z) {
        ITopLayout aVar = this.f7026a;
        if (aVar != null) {
            aVar.setShowSkip(z);
        }
    }

    public void setSkipEnable(boolean z) {
        ITopLayout aVar = this.f7026a;
        if (aVar != null) {
            aVar.setSkipEnable(z);
        }
    }

    public void setShowSound(boolean z) {
        ITopLayout aVar = this.f7026a;
        if (aVar != null) {
            aVar.setShowSound(z);
        }
    }

    public void setSoundMute(boolean z) {
        ITopLayout aVar = this.f7026a;
        if (aVar != null) {
            aVar.setSoundMute(z);
        }
    }

    public void setShowCountDown(boolean z) {
        ITopLayout aVar = this.f7026a;
        if (aVar != null) {
            aVar.setShowCountDown(z);
        }
    }

    /* renamed from: a */
    public void mo15164a(CharSequence charSequence, CharSequence charSequence2) {
        ITopLayout aVar = this.f7026a;
        if (aVar != null) {
            aVar.mo15164a(charSequence, charSequence2);
        }
    }

    public void setShowDislike(boolean z) {
        ITopLayout aVar = this.f7026a;
        if (aVar != null) {
            aVar.setShowDislike(z);
        }
    }

    public void setListener(ITopListener bVar) {
        ITopLayout aVar = this.f7026a;
        if (aVar != null) {
            aVar.setListener(bVar);
        }
    }

    /* renamed from: a */
    public void mo15163a() {
        ITopLayout aVar = this.f7026a;
        if (aVar != null) {
            aVar.mo15163a();
        }
    }

    /* renamed from: b */
    public void mo15165b() {
        ITopLayout aVar = this.f7026a;
        if (aVar != null) {
            aVar.mo15165b();
        }
    }
}
