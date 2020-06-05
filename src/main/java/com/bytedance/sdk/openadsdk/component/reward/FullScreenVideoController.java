package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.INativeVideoController;
import com.bytedance.sdk.openadsdk.core.video.p176b.BaseVideoController;
import com.bytedance.sdk.openadsdk.p165c.AdEventManager;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import java.util.Map;

/* renamed from: com.bytedance.sdk.openadsdk.component.reward.b */
public class FullScreenVideoController extends BaseVideoController {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo15106a() {
        return 2;
    }

    public FullScreenVideoController(Context context, ViewGroup viewGroup, MaterialMeta kVar) {
        super(context, viewGroup, kVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo15107a(int i, int i2) {
        if (this.f7947b != null) {
            boolean z = mo16002z();
            String str = z ? "play_error" : "play_start_error";
            Map a = ToolUtils.m11996a(this.f7947b, i, i2, mo15996t());
            a.put("play_type", Integer.valueOf(ToolUtils.m11990a((INativeVideoController) this, this.f7952g)));
            if (z) {
                a.put("duration", Long.valueOf(mo15991o()));
                a.put("percent", Integer.valueOf(mo15993q()));
                a.put("buffers_time", Long.valueOf(mo15990n()));
            }
            AdEventManager.m8412k((Context) this.f7946a.get(), this.f7947b, "fullscreen_interstitial_ad", str, a);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo15108b() {
        Map B = mo15948B();
        B.put("play_type", Integer.valueOf(ToolUtils.m11990a((INativeVideoController) this, this.f7952g)));
        AdEventManager.m8386a((Context) this.f7946a.get(), this.f7947b, "fullscreen_interstitial_ad", "feed_over", this.f7948c, 100, B);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo15109c() {
        Map B = mo15948B();
        B.put("play_type", Integer.valueOf(ToolUtils.m11990a((INativeVideoController) this, this.f7952g)));
        AdEventManager.m8386a((Context) this.f7946a.get(), this.f7947b, "fullscreen_interstitial_ad", "play_pause", mo15991o(), mo15993q(), B);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo15110d() {
        Map B = mo15948B();
        B.put("play_type", Integer.valueOf(ToolUtils.m11990a((INativeVideoController) this, this.f7952g)));
        AdEventManager.m8386a((Context) this.f7946a.get(), this.f7947b, "fullscreen_interstitial_ad", "continue_play", this.f7953h, mo15993q(), B);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo15111e() {
        Map A = mo15947A();
        A.put("play_type", Integer.valueOf(ToolUtils.m11990a((INativeVideoController) this, this.f7952g)));
        AdEventManager.m8411j((Context) this.f7946a.get(), this.f7947b, "fullscreen_interstitial_ad", "feed_play", A);
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo15112f() {
        Map A = mo15947A();
        A.put("play_type", Integer.valueOf(ToolUtils.m11990a((INativeVideoController) this, this.f7952g)));
        AdEventManager.m8411j((Context) this.f7946a.get(), this.f7947b, "fullscreen_interstitial_ad", "feed_play", A);
    }
}
