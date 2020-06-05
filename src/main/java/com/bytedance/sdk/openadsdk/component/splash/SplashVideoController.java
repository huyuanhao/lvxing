package com.bytedance.sdk.openadsdk.component.splash;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.video.p176b.BaseVideoController;
import com.bytedance.sdk.openadsdk.p165c.AdEventManager;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import java.util.Map;

/* renamed from: com.bytedance.sdk.openadsdk.component.splash.d */
public class SplashVideoController extends BaseVideoController {
    /* renamed from: i */
    private boolean f7151i = false;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo15106a() {
        return 3;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo15109c() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo15110d() {
    }

    SplashVideoController(Context context, ViewGroup viewGroup, MaterialMeta kVar) {
        super(context, viewGroup, kVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo15107a(int i, int i2) {
        if (this.f7947b != null && i != 308) {
            boolean z = mo16002z();
            String str = z ? "play_error" : "play_start_error";
            Map a = ToolUtils.m11996a(this.f7947b, i, i2, mo15996t());
            if (z) {
                a.put("duration", Long.valueOf(mo15991o()));
                a.put("percent", Integer.valueOf(mo15993q()));
                a.put("buffers_time", Long.valueOf(mo15990n()));
            }
            AdEventManager.m8412k((Context) this.f7946a.get(), this.f7947b, "splash_ad", str, a);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo15108b() {
        if (!this.f7151i) {
            this.f7151i = true;
            AdEventManager.m8386a((Context) this.f7946a.get(), this.f7947b, "splash_ad", "feed_over", this.f7948c, 100, mo15948B());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo15111e() {
        AdEventManager.m8411j((Context) this.f7946a.get(), this.f7947b, "splash_ad", "feed_play", mo15947A());
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo15112f() {
        AdEventManager.m8411j((Context) this.f7946a.get(), this.f7947b, "splash_ad", "feed_play", mo15947A());
    }
}
