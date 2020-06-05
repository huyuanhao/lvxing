package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoLayout;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.p188g.TTNetClient;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.bytedance.sdk.openadsdk.utils.UIUtils;

public class ExpressVideoView extends NativeVideoTsView implements OnClickListener {
    /* renamed from: n */
    private boolean f7758n = false;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo15855a(boolean z) {
    }

    public ExpressVideoView(Context context, MaterialMeta kVar, String str) {
        super(context, kVar, false, str);
        if ("draw_ad".equals(str)) {
            this.f7758n = true;
        }
        setOnClickListener(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo15856b() {
        this.f8037d = false;
        InternalContainer.m10069h().mo15814s(String.valueOf(ToolUtils.m12018d(this.f8034a.mo15428P())));
        super.mo15856b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo15857c() {
        if (this.f7758n) {
            super.mo15857c();
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        this.f7758n = z;
    }

    public void setShouldCheckNetChange(boolean z) {
        if (this.f8035b != null) {
            this.f8035b.mo15982f(z);
        }
    }

    /* renamed from: d */
    public void mo15858d() {
        if (this.f8041h != null) {
            UIUtils.m12059a((View) this.f8041h, 8);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        if (this.f8040g == null || this.f8040g.getVisibility() != 0) {
            super.onWindowVisibilityChanged(i);
        } else {
            m9923j();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (this.f8040g == null || this.f8040g.getVisibility() != 0) {
            super.onWindowFocusChanged(z);
        } else {
            m9923j();
        }
    }

    /* renamed from: i */
    private void m9922i() {
        UIUtils.m12059a((View) this.f8038e, 0);
        UIUtils.m12059a((View) this.f8039f, 0);
        UIUtils.m12059a((View) this.f8041h, 8);
    }

    /* renamed from: j */
    private void m9923j() {
        mo16097f();
        if (this.f8038e != null) {
            if (this.f8038e.getVisibility() != 0) {
                TTNetClient.m11428a(getContext()).mo16653a(this.f8034a.mo15512z().mo15601f(), this.f8039f);
            } else {
                return;
            }
        }
        m9922i();
    }

    public void onClick(View view) {
        if (this.f8040g != null && this.f8040g.getVisibility() == 0) {
            UIUtils.m12086d((View) this.f8038e);
        }
        mo15857c();
    }

    public void setShowAdInteractionView(boolean z) {
        if (this.f8035b != null) {
            NativeVideoLayout u = this.f8035b.mo15997u();
            if (u != null) {
                u.mo16195d(z);
            }
        }
    }
}
