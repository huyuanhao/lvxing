package com.bytedance.sdk.openadsdk.core.p167a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd.DrawVideoListener;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.WebHelper;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ExpressClickCreativeListener;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.p165c.AdEventManager;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.C2566w;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;

/* renamed from: com.bytedance.sdk.openadsdk.core.a.a */
public class ClickCreativeListener extends ClickListener {
    /* renamed from: C */
    private DrawVideoListener f7193C;
    /* renamed from: D */
    private int f7194D;
    /* renamed from: a */
    private boolean f7195a = true;
    /* renamed from: b */
    private boolean f7196b = false;

    /* renamed from: b */
    public boolean mo15274b() {
        return false;
    }

    /* renamed from: c */
    public boolean mo15275c() {
        return false;
    }

    /* renamed from: a */
    public void mo15270a(DrawVideoListener drawVideoListener) {
        this.f7193C = drawVideoListener;
    }

    public ClickCreativeListener(Context context, MaterialMeta kVar, String str, int i) {
        super(context, kVar, str, i);
    }

    /* renamed from: a */
    public void mo15271a(boolean z) {
        this.f7195a = z;
    }

    /* renamed from: b */
    public void mo15273b(boolean z) {
        this.f7196b = z;
    }

    /* renamed from: a */
    public void mo14920a(View view, int i, int i2, int i3, int i4) {
        View view2;
        if (!mo15285a(2)) {
            String str = "ClickCreativeListener";
            if (!m9057f() || !m9054c(view)) {
                C2564t.m12220b(str, "走创意区域点击事件.....");
                if (this.f7197c == null) {
                    this.f7197c = InternalContainer.m10059a();
                }
                if (this.f7197c != null) {
                    long j = this.f7223v;
                    long j2 = this.f7224w;
                    if (this.f7201g == null) {
                        view2 = null;
                    } else {
                        view2 = (View) this.f7201g.get();
                    }
                    this.f7203i = mo15276a(i, i2, i3, i4, j, j2, view2, this.f7202h == null ? null : (View) this.f7202h.get());
                    int B = this.f7198d.mo15414B();
                    if (B == 2 || B == 3) {
                        if (this.f7205k != null || this.f7196b) {
                            AdEventManager.m8391a(this.f7197c, "click_button", this.f7198d, this.f7203i, this.f7199e, true, this.f7209o);
                        }
                        WebHelper.m11010a(true);
                        boolean a = WebHelper.m11011a(this.f7197c, this.f7198d, this.f7200f, this.f7205k, this.f7210p, ToolUtils.m11993a(this.f7200f), this.f7208n, true);
                        if (this.f7195a) {
                            AdEventManager.m8391a(this.f7197c, "click", this.f7198d, this.f7203i, this.f7199e, a, this.f7209o);
                        }
                    } else if (B != 4) {
                        if (B != 5) {
                            B = -1;
                        } else {
                            String a2 = m9053a(this.f7199e);
                            if (!TextUtils.isEmpty(a2)) {
                                AdEventManager.m8391a(this.f7197c, "click_call", this.f7198d, this.f7203i, a2, true, this.f7209o);
                            }
                            AdEventManager.m8391a(this.f7197c, "click", this.f7198d, this.f7203i, this.f7199e, ToolUtils.m12024e(view.getContext(), this.f7198d.mo15419G()), this.f7209o);
                        }
                    } else if (this.f7198d.mo15503q() && (this.f7205k != null || this.f7210p != null)) {
                        boolean a3 = WebHelper.m11011a(this.f7197c, this.f7198d, this.f7200f, this.f7205k, this.f7210p, this.f7199e, this.f7208n, true);
                        if (this.f7195a) {
                            AdEventManager.m8391a(this.f7197c, "click", this.f7198d, this.f7203i, this.f7199e, a3, this.f7209o);
                        }
                    } else if (this.f7208n != null) {
                        this.f7208n.mo16522h();
                        if (this.f7195a && this.f7208n.mo16519e()) {
                            AdEventManager.m8391a(this.f7197c, "click", this.f7198d, this.f7203i, this.f7199e, true, this.f7209o);
                        }
                    }
                    if (this.f7204j != null) {
                        this.f7204j.mo15083a(view, B);
                    }
                    if (ToolUtils.m12006a(this.f7198d)) {
                        DrawVideoListener drawVideoListener = this.f7193C;
                        if (drawVideoListener != null) {
                            drawVideoListener.onClick();
                        }
                    }
                    return;
                }
                return;
            }
            C2564t.m12220b(str, "拦截原生视频view走普通点击事件.....");
            super.mo14920a(view, i, i2, i3, i4);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo15272a() {
        boolean z = true;
        if (this.f7198d == null) {
            return true;
        }
        int c = InternalContainer.m10069h().mo15779c(ToolUtils.m12018d(this.f7198d.mo15428P()));
        if (c == 1) {
            return C2566w.m12245d(this.f7197c);
        }
        if (c == 2) {
            if (!C2566w.m12246e(this.f7197c) && !C2566w.m12245d(this.f7197c)) {
                z = false;
            }
            return z;
        } else if (c == 3) {
            return false;
        } else {
            if (c != 4) {
            }
            return true;
        }
    }

    /* renamed from: d */
    private boolean m9055d() {
        if (this.f7198d != null && this.f7198d.mo15475e() == 1 && (this.f7198d.mo15429Q() == 5 || this.f7198d.mo15429Q() == 15)) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    private boolean m9054c(View view) {
        boolean z = false;
        if (view == null) {
            return false;
        }
        String str = "ClickCreativeListener";
        if (view instanceof NativeVideoTsView) {
            C2564t.m12222c(str, "NativeVideoTsView....");
            return true;
        } else if (view.getId() == ResourceHelp.m11935e(this.f7197c, "tt_video_ad_cover_center_layout") || view.getId() == ResourceHelp.m11935e(this.f7197c, "tt_video_ad_logo_image") || view.getId() == ResourceHelp.m11935e(this.f7197c, "tt_video_btn_ad_image_tv") || view.getId() == ResourceHelp.m11935e(this.f7197c, "tt_video_ad_name") || view.getId() == ResourceHelp.m11935e(this.f7197c, "tt_video_ad_button")) {
            C2564t.m12222c(str, "tt_video_ad_cover_center_layout....");
            return true;
        } else if (view.getId() == ResourceHelp.m11935e(this.f7197c, "tt_root_view") || view.getId() == ResourceHelp.m11935e(this.f7197c, "tt_video_play")) {
            C2564t.m12222c(str, "tt_root_view....");
            return true;
        } else {
            if (view instanceof ViewGroup) {
                int i = 0;
                while (true) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    if (i >= viewGroup.getChildCount()) {
                        break;
                    } else if (m9054c(viewGroup.getChildAt(i))) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
            }
            return z;
        }
    }

    /* renamed from: e */
    private boolean m9056e() {
        return this instanceof ExpressClickCreativeListener;
    }

    /* renamed from: f */
    private boolean m9057f() {
        if (this.f7198d == null || m9056e()) {
            return false;
        }
        if (this.f7198d.mo15429Q() != 5 && this.f7198d.mo15429Q() != 15) {
            return false;
        }
        if (this.f7194D == 0) {
            this.f7194D = ToolUtils.m12014c(this.f7198d.mo15428P());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("!isViewVisibility()=");
        sb.append(!mo15274b());
        sb.append(",isAutoPlay()=");
        sb.append(mo15272a());
        sb.append(",!isCoverPageVisibility()=");
        sb.append(!mo15275c());
        C2564t.m12220b("ClickCreativeListener", sb.toString());
        if (this.f7194D == 5 && m9055d() && mo15272a() && !mo15274b() && !mo15275c()) {
            return false;
        }
        int i = this.f7194D;
        if (i == 1 || i == 2 || i == 5) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private java.lang.String m9053a(java.lang.String r8) {
        /*
        r7 = this;
        int r0 = r8.hashCode()
        java.lang.String r1 = "splash_ad"
        r2 = 5
        r3 = 4
        r4 = 3
        r5 = 2
        r6 = 1
        switch(r0) {
            case -1695837674: goto L_0x003f;
            case -712491894: goto L_0x0035;
            case 174971131: goto L_0x002d;
            case 1844104722: goto L_0x0023;
            case 1912999166: goto L_0x0019;
            case 2091589896: goto L_0x000f;
            default: goto L_0x000e;
        }
    L_0x000e:
        goto L_0x0049
    L_0x000f:
        java.lang.String r0 = "slide_banner_ad"
        boolean r8 = r8.equals(r0)
        if (r8 == 0) goto L_0x0049
        r8 = 3
        goto L_0x004a
    L_0x0019:
        java.lang.String r0 = "draw_ad"
        boolean r8 = r8.equals(r0)
        if (r8 == 0) goto L_0x0049
        r8 = 1
        goto L_0x004a
    L_0x0023:
        java.lang.String r0 = "interaction"
        boolean r8 = r8.equals(r0)
        if (r8 == 0) goto L_0x0049
        r8 = 4
        goto L_0x004a
    L_0x002d:
        boolean r8 = r8.equals(r1)
        if (r8 == 0) goto L_0x0049
        r8 = 5
        goto L_0x004a
    L_0x0035:
        java.lang.String r0 = "embeded_ad"
        boolean r8 = r8.equals(r0)
        if (r8 == 0) goto L_0x0049
        r8 = 0
        goto L_0x004a
    L_0x003f:
        java.lang.String r0 = "banner_ad"
        boolean r8 = r8.equals(r0)
        if (r8 == 0) goto L_0x0049
        r8 = 2
        goto L_0x004a
    L_0x0049:
        r8 = -1
    L_0x004a:
        if (r8 == 0) goto L_0x0060
        if (r8 == r6) goto L_0x0060
        java.lang.String r0 = "banner_call"
        if (r8 == r5) goto L_0x005f
        if (r8 == r4) goto L_0x005f
        if (r8 == r3) goto L_0x005c
        if (r8 == r2) goto L_0x005b
        java.lang.String r8 = ""
        return r8
    L_0x005b:
        return r1
    L_0x005c:
        java.lang.String r8 = "interaction_call"
        return r8
    L_0x005f:
        return r0
    L_0x0060:
        java.lang.String r8 = "feed_call"
        return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.p167a.ClickCreativeListener.m9053a(java.lang.String):java.lang.String");
    }
}
