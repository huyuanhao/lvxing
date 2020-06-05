package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.p170d.DynamicClickInfo;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.bytedance.sdk.openadsdk.utils.UIUtils;

public class FullRewardExpressBackupView extends BackupView {
    /* renamed from: h */
    private View f7759h;
    /* renamed from: i */
    private NativeExpressView f7760i;
    /* renamed from: j */
    private FrameLayout f7761j;
    /* renamed from: k */
    private ITTDownloadAdapter f7762k;

    public FullRewardExpressBackupView(Context context) {
        super(context);
        this.f7750a = context;
    }

    /* renamed from: a */
    public void mo15865a(MaterialMeta kVar, NativeExpressView nativeExpressView, ITTDownloadAdapter aVar) {
        C2564t.m12220b("FullRewardExpressBackupView", "show backup view");
        setBackgroundColor(-1);
        this.f7751b = kVar;
        this.f7760i = nativeExpressView;
        this.f7762k = aVar;
        if (ToolUtils.m12014c(this.f7751b.mo15428P()) == 7) {
            this.f7754e = "rewarded_video";
        } else {
            this.f7754e = "fullscreen_interstitial_ad";
        }
        m9928b();
        this.f7760i.addView(this, new LayoutParams(-2, -2));
    }

    /* renamed from: b */
    private void m9928b() {
        this.f7755f = UIUtils.m12079c(this.f7750a, (float) this.f7760i.getExpectExpressWidth());
        this.f7756g = UIUtils.m12079c(this.f7750a, (float) this.f7760i.getExpectExpressWidth());
        LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(this.f7755f, this.f7756g);
        }
        layoutParams.width = this.f7755f;
        layoutParams.height = this.f7756g;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        this.f7751b.mo15485h();
        m9929c();
    }

    /* renamed from: c */
    private void m9929c() {
        this.f7759h = LayoutInflater.from(this.f7750a).inflate(ResourceHelp.m11936f(this.f7750a, "tt_backup_full_reward"), this, true);
        this.f7761j = (FrameLayout) this.f7759h.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_video_container"));
        this.f7761j.removeAllViews();
    }

    public FrameLayout getVideoContainer() {
        return this.f7761j;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo15294a(int i, DynamicClickInfo iVar) {
        NativeExpressView nativeExpressView = this.f7760i;
        if (nativeExpressView != null) {
            nativeExpressView.mo15184a(i, iVar);
        }
    }
}
