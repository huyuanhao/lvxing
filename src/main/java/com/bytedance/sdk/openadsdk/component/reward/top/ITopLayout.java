package com.bytedance.sdk.openadsdk.component.reward.top;

import android.view.View;

/* renamed from: com.bytedance.sdk.openadsdk.component.reward.top.a */
public interface ITopLayout<T extends View> {
    /* renamed from: a */
    void mo15163a();

    /* renamed from: a */
    void mo15164a(CharSequence charSequence, CharSequence charSequence2);

    /* renamed from: b */
    void mo15165b();

    void setListener(ITopListener bVar);

    void setShowCountDown(boolean z);

    void setShowDislike(boolean z);

    void setShowSkip(boolean z);

    void setShowSound(boolean z);

    void setSkipEnable(boolean z);

    void setSoundMute(boolean z);
}
