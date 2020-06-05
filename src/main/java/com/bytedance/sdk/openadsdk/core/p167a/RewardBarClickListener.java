package com.bytedance.sdk.openadsdk.core.p167a;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;

/* renamed from: com.bytedance.sdk.openadsdk.core.a.e */
public abstract class RewardBarClickListener extends ClickCreativeListener {
    /* renamed from: a_ */
    public abstract void mo14871a_(View view, int i, int i2, int i3, int i4);

    public RewardBarClickListener(Context context, MaterialMeta kVar, String str, int i) {
        super(context, kVar, str, i);
    }

    /* renamed from: a */
    public void mo14920a(View view, int i, int i2, int i3, int i4) {
        mo14871a_(view, i, i2, i3, i4);
        super.mo14920a(view, i, i2, i3, i4);
    }
}
