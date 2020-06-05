package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import com.bytedance.sdk.openadsdk.core.GlobalInfo;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.p188g.TTNetClient;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.bytedance.sdk.openadsdk.utils.UIUtils;

public class NativeDrawVideoTsView extends NativeVideoTsView implements OnClickListener {
    /* renamed from: n */
    private boolean f8032n = false;

    public NativeDrawVideoTsView(Context context, MaterialMeta kVar) {
        super(context, kVar);
        setOnClickListener(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo15856b() {
        this.f8037d = false;
        this.f8042i = "draw_ad";
        InternalContainer.m10069h().mo15814s(String.valueOf(ToolUtils.m12018d(this.f8034a.mo15428P())));
        super.mo15856b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo15857c() {
        if (this.f8032n) {
            super.mo15857c();
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        this.f8032n = z;
    }

    /* renamed from: a */
    public void mo16090a(Bitmap bitmap, int i) {
        GlobalInfo.m9616c().mo15655a(bitmap);
        this.f8043j = i;
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        if (this.f8040g == null || this.f8040g.getVisibility() != 0) {
            super.onWindowVisibilityChanged(i);
        } else {
            m10410i();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (this.f8040g == null || this.f8040g.getVisibility() != 0) {
            super.onWindowFocusChanged(z);
        } else {
            m10410i();
        }
    }

    /* renamed from: d */
    private void m10409d() {
        UIUtils.m12059a((View) this.f8038e, 0);
        UIUtils.m12059a((View) this.f8039f, 0);
        UIUtils.m12059a((View) this.f8041h, 8);
    }

    /* renamed from: i */
    private void m10410i() {
        mo16097f();
        if (this.f8038e != null) {
            if (this.f8038e.getVisibility() != 0) {
                TTNetClient.m11428a(getContext()).mo16653a(this.f8034a.mo15512z().mo15601f(), this.f8039f);
            } else {
                return;
            }
        }
        m10409d();
    }

    public void onClick(View view) {
        if (this.f8040g != null && this.f8040g.getVisibility() == 0) {
            UIUtils.m12086d((View) this.f8038e);
        }
        mo15857c();
    }
}
