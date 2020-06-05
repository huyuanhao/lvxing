package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Message;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd.DrawVideoListener;
import com.bytedance.sdk.openadsdk.core.GlobalInfo;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p167a.ClickCreativeListener;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.p170d.VideoInfo;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.IMediaLayout.C2323a;
import com.bytedance.sdk.openadsdk.core.video.renderview.IRenderCallback;
import com.bytedance.sdk.openadsdk.core.video.renderview.IRenderView;
import com.bytedance.sdk.openadsdk.core.video.renderview.SSRenderSurfaceView;
import com.bytedance.sdk.openadsdk.core.video.renderview.SSRenderTextureView;
import com.bytedance.sdk.openadsdk.core.widget.RoundImageView;
import com.bytedance.sdk.openadsdk.core.widget.VideoOnTouchLayout.C2363a;
import com.bytedance.sdk.openadsdk.core.widget.VideoTrafficTipLayout;
import com.bytedance.sdk.openadsdk.core.widget.VideoTrafficTipLayout.C2366b;
import com.bytedance.sdk.openadsdk.downloadnew.TTDownloadFactory;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter.C2417a;
import com.bytedance.sdk.openadsdk.p165c.AdEventManager;
import com.bytedance.sdk.openadsdk.p188g.TTNetClient;
import com.bytedance.sdk.openadsdk.utils.C2538ak.C2539a;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.bytedance.sdk.openadsdk.utils.UIUtils;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.core.video.nativevideo.h */
public class NativeVideoLayout implements IMediaLayout, IRenderCallback, C2363a, C2366b, C2539a {
    /* renamed from: A */
    VideoTrafficTipLayout f8175A;
    /* renamed from: B */
    INewMediaCallback f8176B;
    /* renamed from: C */
    boolean f8177C;
    /* renamed from: D */
    ITTDownloadAdapter f8178D;
    /* renamed from: E */
    INativeVideoController f8179E;
    /* renamed from: F */
    ClickCreativeListener f8180F;
    /* renamed from: G */
    ClickCreativeListener f8181G;
    /* renamed from: H */
    DrawVideoListener f8182H;
    /* renamed from: I */
    boolean f8183I;
    /* renamed from: J */
    private View f8184J;
    /* renamed from: K */
    private TextView f8185K;
    /* renamed from: L */
    private TextView f8186L;
    /* renamed from: M */
    private final String f8187M;
    /* renamed from: a */
    View f8188a;
    /* renamed from: b */
    IRenderView f8189b;
    /* renamed from: c */
    ImageView f8190c;
    /* renamed from: d */
    View f8191d;
    /* renamed from: e */
    View f8192e;
    /* renamed from: f */
    ImageView f8193f;
    /* renamed from: g */
    ViewStub f8194g;
    /* renamed from: h */
    View f8195h;
    /* renamed from: i */
    ImageView f8196i;
    /* renamed from: j */
    View f8197j;
    /* renamed from: k */
    RoundImageView f8198k;
    /* renamed from: l */
    TextView f8199l;
    /* renamed from: m */
    TextView f8200m;
    /* renamed from: n */
    TextView f8201n;
    /* renamed from: o */
    ProgressBar f8202o;
    /* renamed from: p */
    ViewStub f8203p;
    /* renamed from: q */
    int f8204q;
    /* renamed from: r */
    int f8205r;
    /* renamed from: s */
    int f8206s;
    /* renamed from: t */
    int f8207t;
    /* renamed from: u */
    boolean f8208u;
    /* renamed from: v */
    boolean f8209v;
    /* renamed from: w */
    int f8210w;
    /* renamed from: x */
    EnumSet<C2323a> f8211x;
    /* renamed from: y */
    MaterialMeta f8212y;
    /* renamed from: z */
    Context f8213z;

    /* renamed from: a */
    public void mo16142a(long j) {
    }

    /* renamed from: a */
    public void mo16143a(long j, long j2) {
    }

    /* renamed from: a */
    public void mo14813a(Message message) {
    }

    /* renamed from: a */
    public void mo16145a(View view, boolean z) {
    }

    /* renamed from: a */
    public void mo16146a(ViewGroup viewGroup) {
    }

    /* renamed from: a */
    public void mo16148a(String str) {
    }

    /* renamed from: a */
    public void mo16149a(boolean z) {
    }

    /* renamed from: b */
    public void mo16152b() {
    }

    /* renamed from: b */
    public void mo16187b(SurfaceTexture surfaceTexture) {
    }

    /* renamed from: b */
    public void mo16188b(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    /* renamed from: b */
    public void mo16153b(ViewGroup viewGroup) {
    }

    /* renamed from: b */
    public void mo16154b(boolean z) {
    }

    /* renamed from: b */
    public boolean mo16155b(int i) {
        return false;
    }

    /* renamed from: c */
    public void mo16156c() {
    }

    /* renamed from: h */
    public boolean mo16162h() {
        return false;
    }

    /* renamed from: l */
    public void mo16166l() {
    }

    public NativeVideoLayout(Context context, View view, boolean z, EnumSet<C2323a> enumSet, MaterialMeta kVar, INativeVideoController cVar, boolean z2) {
        this.f8208u = true;
        this.f8177C = true;
        this.f8183I = true;
        this.f8187M = Build.MODEL;
        if (!(this instanceof NativeVideoDetailLayout)) {
            this.f8213z = InternalContainer.m10059a().getApplicationContext();
            mo16193c(z2);
            this.f8188a = view;
            this.f8208u = z;
            if (enumSet == null) {
                enumSet = EnumSet.noneOf(C2323a.class);
            }
            this.f8211x = enumSet;
            this.f8179E = cVar;
            this.f8212y = kVar;
            mo16157c(8);
            mo16144a(context, this.f8188a);
            mo16140a();
            mo16196n();
        }
    }

    public NativeVideoLayout(Context context, View view, boolean z, EnumSet<C2323a> enumSet, MaterialMeta kVar, INativeVideoController cVar) {
        this(context, view, z, enumSet, kVar, cVar, true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public void mo16196n() {
        int i;
        String str;
        String str2 = this.f8177C ? "embeded_ad" : "embeded_ad_landingpage";
        if (ToolUtils.m12006a(this.f8212y)) {
            str = this.f8177C ? "draw_ad" : "draw_ad_landingpage";
            i = 6;
        } else if (ToolUtils.m12017c(this.f8212y)) {
            str = "rewarded_video";
            i = 7;
        } else if (ToolUtils.m12021d(this.f8212y)) {
            str = "fullscreen_interstitial_ad";
            i = 5;
        } else {
            str = str2;
            i = 1;
        }
        if (this.f8212y.mo15414B() == 4) {
            this.f8178D = TTDownloadFactory.m11071a(this.f8213z, this.f8212y, str);
            this.f8178D.mo16505a(2, (C2417a) new C2417a() {
                /* renamed from: a */
                public boolean mo14872a(int i, MaterialMeta kVar, String str, String str2, Object obj) {
                    if (i == 2 && kVar != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        if (str2.equals("click_start_play")) {
                            AdEventManager.m8388a(NativeVideoLayout.this.f8213z, NativeVideoLayout.this.f8212y, str, NativeVideoLayout.this.f8177C ? "click_start" : "click_start_detail", (JSONObject) null);
                            return false;
                        } else if (str2.equals("click_open")) {
                            if (NativeVideoLayout.this.f8177C) {
                                AdEventManager.m8418q(NativeVideoLayout.this.f8213z, NativeVideoLayout.this.f8212y, str, ToolUtils.m12029f(NativeVideoLayout.this.f8212y), null);
                            } else {
                                AdEventManager.m8417p(NativeVideoLayout.this.f8213z, NativeVideoLayout.this.f8212y, str, "click_open_detail", null);
                            }
                            return false;
                        }
                    }
                    return true;
                }
            });
        }
        m10656z();
        this.f8180F = new ClickCreativeListener(this.f8213z, this.f8212y, str, i);
        this.f8180F.mo15273b(true);
        if (this.f8177C) {
            this.f8180F.mo15271a(true);
        } else {
            this.f8180F.mo15271a(false);
        }
        this.f8180F.mo15282a(this.f8179E);
        this.f8180F.mo15287c(true);
        ITTDownloadAdapter aVar = this.f8178D;
        if (aVar != null) {
            ClickCreativeListener aVar2 = this.f8180F;
            if (aVar2 != null) {
                aVar2.mo15283a(aVar);
            }
        }
        if (m10655y()) {
            C23432 r3 = new ClickCreativeListener(this.f8213z, this.f8212y, str, i) {
                /* renamed from: b */
                public boolean mo15274b() {
                    boolean a = NativeVideoLayout.this.f8175A != null ? NativeVideoLayout.this.f8175A.mo16322a() : false;
                    StringBuilder sb = new StringBuilder();
                    sb.append("isVisible=");
                    sb.append(a);
                    sb.append(",mPlayBtn.getVisibility() == VISIBLE->");
                    sb.append(NativeVideoLayout.this.f8190c.getVisibility() == 0);
                    C2564t.m12222c("ClickCreativeListener", sb.toString());
                    if (a || NativeVideoLayout.this.f8190c.getVisibility() == 0) {
                        return true;
                    }
                    return false;
                }

                /* renamed from: c */
                public boolean mo15275c() {
                    return (NativeVideoLayout.this.f8195h != null && NativeVideoLayout.this.f8195h.getVisibility() == 0) || (NativeVideoLayout.this.f8197j != null && NativeVideoLayout.this.f8197j.getVisibility() == 0) || ((NativeVideoLayout.this.f8198k != null && NativeVideoLayout.this.f8198k.getVisibility() == 0) || (NativeVideoLayout.this.f8199l != null && NativeVideoLayout.this.f8199l.getVisibility() == 0));
                }
            };
            this.f8181G = r3;
            this.f8181G.mo15273b(true);
            if (this.f8177C) {
                this.f8181G.mo15271a(true);
            } else {
                this.f8181G.mo15271a(false);
            }
            this.f8181G.mo15282a(this.f8179E);
            this.f8181G.mo15287c(true);
            ITTDownloadAdapter aVar3 = this.f8178D;
            if (aVar3 != null) {
                this.f8181G.mo15283a(aVar3);
            }
            View view = this.f8188a;
            if (view != null) {
                view.setOnClickListener(this.f8181G);
                this.f8188a.setOnTouchListener(this.f8181G);
            }
        }
    }

    /* renamed from: y */
    private boolean m10655y() {
        MaterialMeta kVar = this.f8212y;
        if (kVar != null && kVar.mo15475e() == 1 && (this.f8212y.mo15429Q() == 5 || this.f8212y.mo15429Q() == 15)) {
            return true;
        }
        return false;
    }

    /* renamed from: z */
    private void m10656z() {
        Context context = this.f8213z;
        if (context != null && this.f8188a != null) {
            C23443 r1 = new View(context) {
                /* renamed from: b */
                private final AtomicBoolean f8217b = new AtomicBoolean(true);

                /* access modifiers changed from: protected */
                public void onMeasure(int i, int i2) {
                    super.onMeasure(0, 0);
                }

                public void onWindowFocusChanged(boolean z) {
                    super.onWindowFocusChanged(z);
                    if (NativeVideoLayout.this.f8178D == null) {
                        return;
                    }
                    if (z) {
                        NativeVideoLayout.this.f8178D.mo16513b();
                    } else {
                        NativeVideoLayout.this.f8178D.mo16516c();
                    }
                }

                /* access modifiers changed from: protected */
                public void onAttachedToWindow() {
                    super.onAttachedToWindow();
                    m10719a();
                }

                public void onFinishTemporaryDetach() {
                    super.onFinishTemporaryDetach();
                    m10719a();
                }

                /* renamed from: a */
                private void m10719a() {
                    if (this.f8217b.getAndSet(false) && NativeVideoLayout.this.f8178D != null) {
                        NativeVideoLayout.this.f8178D.mo16504a();
                    }
                }

                /* renamed from: b */
                private void m10720b() {
                    if (!this.f8217b.getAndSet(true) && NativeVideoLayout.this.f8178D != null) {
                        NativeVideoLayout.this.f8178D.mo16518d();
                    }
                }

                /* access modifiers changed from: protected */
                public void onDetachedFromWindow() {
                    super.onDetachedFromWindow();
                    m10720b();
                }

                public void onStartTemporaryDetach() {
                    super.onStartTemporaryDetach();
                    m10720b();
                }
            };
            View view = this.f8188a;
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).addView(r1, 0, new LayoutParams(0, 0));
            }
        }
    }

    /* renamed from: o */
    public IRenderView mo16197o() {
        return this.f8189b;
    }

    /* renamed from: A */
    private boolean m10651A() {
        if (!"C8817D".equals(this.f8187M)) {
            if (!"M5".equals(this.f8187M)) {
                if (!"R7t".equals(this.f8187M)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo16144a(Context context, View view) {
        View view2;
        long currentTimeMillis = System.currentTimeMillis();
        String a = ToolUtils.m11994a(context);
        if (a == null) {
            a = "0";
        }
        boolean z = VERSION.SDK_INT != 20 || Integer.valueOf(a).intValue() >= 1572864;
        String str = "NewLiveViewLayout";
        if (m10651A() || !z || !GlobalInfo.m9616c().mo15688r() || VERSION.SDK_INT < 14) {
            view2 = new SSRenderSurfaceView(this.f8213z);
            C2564t.m12220b(str, "use SurfaceView......");
        } else {
            view2 = new SSRenderTextureView(this.f8213z);
            C2564t.m12220b(str, "use TextureView......");
        }
        if (view instanceof RelativeLayout) {
            LayoutParams layoutParams = new LayoutParams(-2, -2);
            layoutParams.addRule(13);
            ((RelativeLayout) view).addView(view2, 0, layoutParams);
        }
        UIUtils.m12059a(view2, 8);
        this.f8189b = (IRenderView) view2;
        this.f8190c = (ImageView) view.findViewById(ResourceHelp.m11935e(context, "tt_video_play"));
        this.f8202o = (ProgressBar) view.findViewById(ResourceHelp.m11935e(context, "tt_video_progress"));
        this.f8191d = view.findViewById(ResourceHelp.m11935e(context, "tt_video_loading_retry_layout"));
        this.f8192e = view.findViewById(ResourceHelp.m11935e(context, "tt_video_loading_progress"));
        this.f8193f = (ImageView) view.findViewById(ResourceHelp.m11935e(context, "tt_video_loading_cover_image"));
        this.f8194g = (ViewStub) view.findViewById(ResourceHelp.m11935e(context, "tt_video_ad_cover"));
        this.f8203p = (ViewStub) view.findViewById(ResourceHelp.m11935e(context, "tt_video_draw_layout_viewStub"));
        StringBuilder sb = new StringBuilder();
        sb.append("NativeVideoLayout**findViews use time :");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        C2564t.m12220b("useTime", sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo16181a(View view, Context context) {
        if (view != null && context != null) {
            ViewStub viewStub = this.f8194g;
            if (viewStub != null && viewStub.getParent() != null && this.f8195h == null) {
                this.f8195h = this.f8194g.inflate();
                this.f8196i = (ImageView) view.findViewById(ResourceHelp.m11935e(context, "tt_video_ad_finish_cover_image"));
                this.f8197j = view.findViewById(ResourceHelp.m11935e(context, "tt_video_ad_cover_center_layout"));
                this.f8198k = (RoundImageView) view.findViewById(ResourceHelp.m11935e(context, "tt_video_ad_logo_image"));
                this.f8199l = (TextView) view.findViewById(ResourceHelp.m11935e(context, "tt_video_btn_ad_image_tv"));
                this.f8200m = (TextView) view.findViewById(ResourceHelp.m11935e(context, "tt_video_ad_name"));
                this.f8201n = (TextView) view.findViewById(ResourceHelp.m11935e(context, "tt_video_ad_button"));
            }
        }
    }

    /* renamed from: b */
    private void m10652b(View view, Context context) {
        if (view != null && context != null) {
            ViewStub viewStub = this.f8203p;
            if (viewStub != null && viewStub.getParent() != null && this.f8184J == null) {
                this.f8203p.inflate();
                this.f8184J = view.findViewById(ResourceHelp.m11935e(context, "tt_video_ad_cover_center_layout_draw"));
                this.f8185K = (TextView) view.findViewById(ResourceHelp.m11935e(context, "tt_video_ad_button_draw"));
                this.f8186L = (TextView) view.findViewById(ResourceHelp.m11935e(context, "tt_video_ad_replay"));
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: p */
    public void mo16198p() {
        if (this.f8176B != null && this.f8175A == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f8175A = new VideoTrafficTipLayout();
            this.f8175A.mo16319a(this.f8213z, this.f8188a);
            this.f8175A.mo16320a(this.f8176B, (C2366b) this);
            StringBuilder sb = new StringBuilder();
            sb.append("mVideoTrafficTipLayout use time :");
            sb.append(System.currentTimeMillis() - currentTimeMillis);
            C2564t.m12220b("useTime", sb.toString());
        }
    }

    /* renamed from: a */
    public boolean mo16184a(int i, VideoInfo rVar) {
        VideoTrafficTipLayout eVar = this.f8175A;
        return eVar == null || eVar.mo16323a(i, rVar);
    }

    /* renamed from: q */
    public void mo16199q() {
        VideoTrafficTipLayout eVar = this.f8175A;
        if (eVar != null) {
            eVar.mo16321a(false);
        }
    }

    /* renamed from: a */
    public void mo16183a(IMediaCallback aVar) {
        if (aVar instanceof INewMediaCallback) {
            this.f8176B = (INewMediaCallback) aVar;
            mo16198p();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: r */
    public boolean mo16200r() {
        if (this.f8176B != null) {
            return true;
        }
        C2564t.m12226e("NewLiveViewLayout", "callback is null");
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo16140a() {
        this.f8189b.mo16216a(this);
        this.f8190c.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (NativeVideoLayout.this.mo16200r() && (NativeVideoLayout.this.f8201n == null || NativeVideoLayout.this.f8201n.getVisibility() != 0)) {
                    NativeVideoLayout.this.f8176B.mo15956a((IMediaLayout) NativeVideoLayout.this, view);
                }
            }
        });
    }

    /* renamed from: d */
    public void mo16194d(int i) {
        UIUtils.m12059a(this.f8188a, 0);
        IRenderView bVar = this.f8189b;
        if (bVar != null) {
            bVar.setVisibility(i);
        }
    }

    /* renamed from: c */
    public void mo16193c(boolean z) {
        this.f8177C = z;
        if (this.f8177C) {
            ClickCreativeListener aVar = this.f8180F;
            if (aVar != null) {
                aVar.mo15271a(true);
            }
            ClickCreativeListener aVar2 = this.f8181G;
            if (aVar2 != null) {
                aVar2.mo15271a(true);
                return;
            }
            return;
        }
        ClickCreativeListener aVar3 = this.f8180F;
        if (aVar3 != null) {
            aVar3.mo15271a(false);
        }
        ClickCreativeListener aVar4 = this.f8181G;
        if (aVar4 != null) {
            aVar4.mo15271a(false);
        }
    }

    /* renamed from: a */
    public void mo16177a(int i, int i2) {
        if (i == -1) {
            i = UIUtils.m12078c(this.f8213z);
        }
        if (i > 0) {
            this.f8204q = i;
            if (mo16163i() || mo16162h() || this.f8211x.contains(C2323a.fixedSize)) {
                this.f8205r = i2;
            } else {
                this.f8205r = m10653e(i);
            }
            mo16186b(this.f8204q, this.f8205r);
        }
    }

    /* renamed from: b */
    public void mo16190b(boolean z, boolean z2) {
        ImageView imageView = this.f8190c;
        if (imageView == null) {
            return;
        }
        if (z) {
            imageView.setImageResource(ResourceHelp.m11934d(this.f8213z, "tt_play_movebar_textpage"));
        } else {
            imageView.setImageResource(ResourceHelp.m11934d(this.f8213z, "tt_stop_movebar_textpage"));
        }
    }

    /* renamed from: b */
    public void mo16186b(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.f8188a.getLayoutParams();
        if (i == -1 || i == -2 || i > 0) {
            layoutParams.width = i;
        }
        if (i2 == -1 || i2 == -2 || i2 > 0) {
            layoutParams.height = i2;
        }
        this.f8188a.setLayoutParams(layoutParams);
    }

    /* renamed from: e */
    private int m10653e(int i) {
        if (this.f8206s <= 0 || this.f8207t <= 0) {
            return 0;
        }
        int dimensionPixelSize = this.f8213z.getResources().getDimensionPixelSize(ResourceHelp.m11938h(this.f8213z, "tt_video_container_maxheight"));
        int dimensionPixelSize2 = this.f8213z.getResources().getDimensionPixelSize(ResourceHelp.m11938h(this.f8213z, "tt_video_container_minheight"));
        int i2 = (int) (((float) this.f8207t) * ((((float) i) * 1.0f) / ((float) this.f8206s)));
        if (i2 > dimensionPixelSize) {
            i2 = dimensionPixelSize;
        } else if (i2 < dimensionPixelSize2) {
            i2 = dimensionPixelSize2;
        }
        return i2;
    }

    /* renamed from: c */
    public void mo16191c(int i, int i2) {
        this.f8206s = i;
        this.f8207t = i2;
    }

    /* renamed from: a */
    public void mo16141a(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("setSeekProgress-percent=");
        sb.append(i);
        C2564t.m12222c("Progress", sb.toString());
        UIUtils.m12059a((View) this.f8202o, 0);
        this.f8202o.setProgress(i);
    }

    /* renamed from: c */
    public void mo16192c(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.f8188a.getParent() != null) {
                ((ViewGroup) this.f8188a.getParent()).removeView(this.f8188a);
            }
            viewGroup.addView(this.f8188a);
            mo16157c(0);
        }
    }

    /* renamed from: s */
    public View mo16201s() {
        return this.f8188a;
    }

    /* renamed from: d */
    public void mo16158d() {
        UIUtils.m12088e(this.f8191d);
        UIUtils.m12088e(this.f8192e);
        if (this.f8193f != null) {
            MaterialMeta kVar = this.f8212y;
            if (!(kVar == null || kVar.mo15512z() == null || this.f8212y.mo15512z().mo15601f() == null)) {
                UIUtils.m12088e((View) this.f8193f);
                TTNetClient.m11428a(this.f8213z).mo16653a(this.f8212y.mo15512z().mo15601f(), this.f8193f);
            }
        }
        if (this.f8190c.getVisibility() == 0) {
            UIUtils.m12059a((View) this.f8190c, 8);
        }
    }

    /* renamed from: t */
    public void mo16202t() {
        UIUtils.m12088e(this.f8191d);
        UIUtils.m12088e(this.f8192e);
        if (this.f8190c.getVisibility() == 0) {
            UIUtils.m12059a((View) this.f8190c, 8);
        }
    }

    /* renamed from: e */
    public void mo16159e() {
        mo16150a(false, this.f8208u);
        mo16204v();
    }

    /* renamed from: u */
    public void mo16203u() {
        UIUtils.m12059a(this.f8188a, 0);
        IRenderView bVar = this.f8189b;
        if (bVar != null) {
            View view = bVar.getView();
            if (view instanceof TextureView) {
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    int indexOfChild = viewGroup.indexOfChild(view);
                    viewGroup.removeView(view);
                    viewGroup.addView(view, indexOfChild);
                }
            }
            UIUtils.m12059a(view, 8);
            UIUtils.m12059a(view, 0);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: v */
    public void mo16204v() {
        UIUtils.m12059a(this.f8195h, 8);
        UIUtils.m12059a((View) this.f8196i, 8);
        UIUtils.m12059a(this.f8197j, 8);
        UIUtils.m12059a((View) this.f8198k, 8);
        UIUtils.m12059a((View) this.f8199l, 8);
        UIUtils.m12059a((View) this.f8200m, 8);
        UIUtils.m12059a((View) this.f8201n, 8);
    }

    /* renamed from: f */
    private void m10654f(int i) {
        UIUtils.m12059a(this.f8197j, i);
        UIUtils.m12059a(this.f8184J, i);
    }

    /* renamed from: d */
    public void mo16195d(boolean z) {
        this.f8183I = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:84:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0205  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x021a  */
    /* renamed from: a */
    public void mo16147a(com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta r5, java.lang.ref.WeakReference<android.content.Context> r6, boolean r7) {
        /*
        r4 = this;
        if (r5 != 0) goto L_0x0003
        return
    L_0x0003:
        boolean r6 = r4.f8208u
        r7 = 0
        r4.mo16150a(r7, r6)
        android.view.View r6 = r4.f8188a
        android.content.Context r0 = com.bytedance.sdk.openadsdk.core.InternalContainer.m10059a()
        r4.mo16181a(r6, r0)
        android.view.View r6 = r4.f8195h
        if (r6 == 0) goto L_0x0019
        com.bytedance.sdk.openadsdk.utils.UIUtils.m12059a(r6, r7)
    L_0x0019:
        android.widget.ImageView r6 = r4.f8196i
        if (r6 == 0) goto L_0x0020
        com.bytedance.sdk.openadsdk.utils.UIUtils.m12059a(r6, r7)
    L_0x0020:
        com.bytedance.sdk.openadsdk.core.d.k r6 = r4.f8212y
        boolean r6 = com.bytedance.sdk.openadsdk.utils.ToolUtils.m12006a(r6)
        if (r6 == 0) goto L_0x00a3
        android.view.View r6 = r4.f8188a
        android.content.Context r0 = com.bytedance.sdk.openadsdk.core.InternalContainer.m10059a()
        r4.m10652b(r6, r0)
        android.view.View r6 = r4.f8197j
        r0 = 8
        com.bytedance.sdk.openadsdk.utils.UIUtils.m12059a(r6, r0)
        android.widget.ImageView r6 = r4.f8196i
        com.bytedance.sdk.openadsdk.utils.UIUtils.m12059a(r6, r7)
        android.view.View r6 = r4.f8184J
        com.bytedance.sdk.openadsdk.utils.UIUtils.m12059a(r6, r7)
        android.widget.TextView r6 = r4.f8185K
        com.bytedance.sdk.openadsdk.utils.UIUtils.m12059a(r6, r7)
        android.widget.TextView r6 = r4.f8186L
        com.bytedance.sdk.openadsdk.utils.UIUtils.m12059a(r6, r7)
        android.widget.TextView r6 = r4.f8186L
        if (r6 == 0) goto L_0x005f
        android.content.Context r6 = com.bytedance.sdk.openadsdk.core.InternalContainer.m10059a()
        int r6 = com.bytedance.sdk.openadsdk.utils.C2566w.m12244c(r6)
        if (r6 != 0) goto L_0x005f
        android.widget.TextView r6 = r4.f8186L
        com.bytedance.sdk.openadsdk.utils.UIUtils.m12059a(r6, r0)
    L_0x005f:
        android.view.View r6 = r4.f8195h
        if (r6 == 0) goto L_0x006b
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h$5 r0 = new com.bytedance.sdk.openadsdk.core.video.nativevideo.h$5
        r0.m43865init()
        r6.setOnClickListener(r0)
    L_0x006b:
        android.widget.ImageView r6 = r4.f8196i
        if (r6 == 0) goto L_0x00d7
        com.bytedance.sdk.openadsdk.core.d.k r6 = r4.f8212y
        if (r6 == 0) goto L_0x00d7
        com.bytedance.sdk.openadsdk.core.d.r r6 = r6.mo15512z()
        if (r6 == 0) goto L_0x00d7
        com.bytedance.sdk.openadsdk.core.d.k r6 = r4.f8212y
        com.bytedance.sdk.openadsdk.core.d.r r6 = r6.mo15512z()
        java.lang.String r6 = r6.mo15601f()
        if (r6 == 0) goto L_0x00d7
        com.bytedance.sdk.openadsdk.core.d.k r6 = r4.f8212y
        com.bytedance.sdk.openadsdk.core.d.r r6 = r6.mo15512z()
        double r0 = r6.mo15596d()
        long r0 = (long) r0
        com.bytedance.sdk.openadsdk.core.d.k r6 = r4.f8212y
        com.bytedance.sdk.openadsdk.core.d.r r6 = r6.mo15512z()
        java.lang.String r6 = r6.mo15603g()
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h$6 r2 = new com.bytedance.sdk.openadsdk.core.video.nativevideo.h$6
        r2.m43866init()
        com.bytedance.sdk.openadsdk.core.video.p178d.MediaUtils.m10405a(r0, r6, r2)
        goto L_0x00d7
    L_0x00a3:
        android.view.View r6 = r4.f8197j
        com.bytedance.sdk.openadsdk.utils.UIUtils.m12059a(r6, r7)
        android.widget.ImageView r6 = r4.f8196i
        if (r6 == 0) goto L_0x00d7
        com.bytedance.sdk.openadsdk.core.d.k r6 = r4.f8212y
        if (r6 == 0) goto L_0x00d7
        com.bytedance.sdk.openadsdk.core.d.r r6 = r6.mo15512z()
        if (r6 == 0) goto L_0x00d7
        com.bytedance.sdk.openadsdk.core.d.k r6 = r4.f8212y
        com.bytedance.sdk.openadsdk.core.d.r r6 = r6.mo15512z()
        java.lang.String r6 = r6.mo15601f()
        if (r6 == 0) goto L_0x00d7
        android.content.Context r6 = r4.f8213z
        com.bytedance.sdk.openadsdk.g.e r6 = com.bytedance.sdk.openadsdk.p188g.TTNetClient.m11428a(r6)
        com.bytedance.sdk.openadsdk.core.d.k r0 = r4.f8212y
        com.bytedance.sdk.openadsdk.core.d.r r0 = r0.mo15512z()
        java.lang.String r0 = r0.mo15601f()
        android.widget.ImageView r1 = r4.f8196i
        r6.mo16653a(r0, r1)
    L_0x00d7:
        java.lang.String r6 = r5.mo15413A()
        boolean r6 = android.text.TextUtils.isEmpty(r6)
        if (r6 != 0) goto L_0x00e6
        java.lang.String r6 = r5.mo15413A()
        goto L_0x0106
    L_0x00e6:
        java.lang.String r6 = r5.mo15422J()
        boolean r6 = android.text.TextUtils.isEmpty(r6)
        if (r6 != 0) goto L_0x00f5
        java.lang.String r6 = r5.mo15422J()
        goto L_0x0106
    L_0x00f5:
        java.lang.String r6 = r5.mo15423K()
        boolean r6 = android.text.TextUtils.isEmpty(r6)
        if (r6 != 0) goto L_0x0104
        java.lang.String r6 = r5.mo15423K()
        goto L_0x0106
    L_0x0104:
        java.lang.String r6 = ""
    L_0x0106:
        com.bytedance.sdk.openadsdk.core.widget.RoundImageView r0 = r4.f8198k
        r1 = 4
        if (r0 == 0) goto L_0x0164
        com.bytedance.sdk.openadsdk.core.d.k r0 = r4.f8212y
        if (r0 == 0) goto L_0x0164
        com.bytedance.sdk.openadsdk.core.d.j r0 = r0.mo15415C()
        if (r0 == 0) goto L_0x0164
        com.bytedance.sdk.openadsdk.core.d.k r0 = r4.f8212y
        com.bytedance.sdk.openadsdk.core.d.j r0 = r0.mo15415C()
        java.lang.String r0 = r0.mo15406a()
        if (r0 == 0) goto L_0x0164
        com.bytedance.sdk.openadsdk.core.widget.RoundImageView r0 = r4.f8198k
        com.bytedance.sdk.openadsdk.utils.UIUtils.m12059a(r0, r7)
        android.widget.TextView r0 = r4.f8199l
        com.bytedance.sdk.openadsdk.utils.UIUtils.m12059a(r0, r1)
        android.content.Context r0 = r4.f8213z
        com.bytedance.sdk.openadsdk.g.e r0 = com.bytedance.sdk.openadsdk.p188g.TTNetClient.m11428a(r0)
        com.bytedance.sdk.openadsdk.core.d.k r2 = r4.f8212y
        com.bytedance.sdk.openadsdk.core.d.j r2 = r2.mo15415C()
        java.lang.String r2 = r2.mo15406a()
        com.bytedance.sdk.openadsdk.core.widget.RoundImageView r3 = r4.f8198k
        r0.mo16653a(r2, r3)
        boolean r0 = r4.m10655y()
        if (r0 == 0) goto L_0x0155
        com.bytedance.sdk.openadsdk.core.widget.RoundImageView r0 = r4.f8198k
        com.bytedance.sdk.openadsdk.core.a.a r2 = r4.f8181G
        r0.setOnClickListener(r2)
        com.bytedance.sdk.openadsdk.core.widget.RoundImageView r0 = r4.f8198k
        com.bytedance.sdk.openadsdk.core.a.a r2 = r4.f8181G
        r0.setOnTouchListener(r2)
        goto L_0x01a3
    L_0x0155:
        com.bytedance.sdk.openadsdk.core.widget.RoundImageView r0 = r4.f8198k
        com.bytedance.sdk.openadsdk.core.a.a r2 = r4.f8180F
        r0.setOnClickListener(r2)
        com.bytedance.sdk.openadsdk.core.widget.RoundImageView r0 = r4.f8198k
        com.bytedance.sdk.openadsdk.core.a.a r2 = r4.f8180F
        r0.setOnTouchListener(r2)
        goto L_0x01a3
    L_0x0164:
        boolean r0 = android.text.TextUtils.isEmpty(r6)
        if (r0 != 0) goto L_0x01a3
        com.bytedance.sdk.openadsdk.core.widget.RoundImageView r0 = r4.f8198k
        com.bytedance.sdk.openadsdk.utils.UIUtils.m12059a(r0, r1)
        android.widget.TextView r0 = r4.f8199l
        com.bytedance.sdk.openadsdk.utils.UIUtils.m12059a(r0, r7)
        android.widget.TextView r0 = r4.f8199l
        if (r0 == 0) goto L_0x01a3
        r2 = 1
        java.lang.String r2 = r6.substring(r7, r2)
        r0.setText(r2)
        boolean r0 = r4.m10655y()
        if (r0 == 0) goto L_0x0195
        android.widget.TextView r0 = r4.f8199l
        com.bytedance.sdk.openadsdk.core.a.a r2 = r4.f8181G
        r0.setOnClickListener(r2)
        android.widget.TextView r0 = r4.f8199l
        com.bytedance.sdk.openadsdk.core.a.a r2 = r4.f8181G
        r0.setOnTouchListener(r2)
        goto L_0x01a3
    L_0x0195:
        android.widget.TextView r0 = r4.f8199l
        com.bytedance.sdk.openadsdk.core.a.a r2 = r4.f8180F
        r0.setOnClickListener(r2)
        android.widget.TextView r0 = r4.f8199l
        com.bytedance.sdk.openadsdk.core.a.a r2 = r4.f8180F
        r0.setOnTouchListener(r2)
    L_0x01a3:
        android.widget.TextView r0 = r4.f8200m
        if (r0 == 0) goto L_0x01b2
        boolean r0 = android.text.TextUtils.isEmpty(r6)
        if (r0 != 0) goto L_0x01b2
        android.widget.TextView r0 = r4.f8200m
        r0.setText(r6)
    L_0x01b2:
        android.widget.TextView r6 = r4.f8200m
        com.bytedance.sdk.openadsdk.utils.UIUtils.m12059a(r6, r7)
        android.widget.TextView r6 = r4.f8201n
        com.bytedance.sdk.openadsdk.utils.UIUtils.m12059a(r6, r7)
        int r5 = r5.mo15414B()
        r6 = 2
        java.lang.String r7 = "tt_video_mobile_go_detail"
        if (r5 == r6) goto L_0x01e6
        r6 = 3
        if (r5 == r6) goto L_0x01e6
        if (r5 == r1) goto L_0x01dd
        r6 = 5
        if (r5 == r6) goto L_0x01d4
        android.content.Context r5 = r4.f8213z
        java.lang.String r5 = com.bytedance.sdk.openadsdk.utils.ResourceHelp.m11931a(r5, r7)
        goto L_0x01ec
    L_0x01d4:
        android.content.Context r5 = r4.f8213z
        java.lang.String r6 = "tt_video_dial_phone"
        java.lang.String r5 = com.bytedance.sdk.openadsdk.utils.ResourceHelp.m11931a(r5, r6)
        goto L_0x01ec
    L_0x01dd:
        android.content.Context r5 = r4.f8213z
        java.lang.String r6 = "tt_video_download_apk"
        java.lang.String r5 = com.bytedance.sdk.openadsdk.utils.ResourceHelp.m11931a(r5, r6)
        goto L_0x01ec
    L_0x01e6:
        android.content.Context r5 = r4.f8213z
        java.lang.String r5 = com.bytedance.sdk.openadsdk.utils.ResourceHelp.m11931a(r5, r7)
    L_0x01ec:
        android.widget.TextView r6 = r4.f8201n
        if (r6 == 0) goto L_0x0201
        r6.setText(r5)
        android.widget.TextView r6 = r4.f8201n
        com.bytedance.sdk.openadsdk.core.a.a r7 = r4.f8180F
        r6.setOnClickListener(r7)
        android.widget.TextView r6 = r4.f8201n
        com.bytedance.sdk.openadsdk.core.a.a r7 = r4.f8180F
        r6.setOnTouchListener(r7)
    L_0x0201:
        android.widget.TextView r6 = r4.f8185K
        if (r6 == 0) goto L_0x0216
        r6.setText(r5)
        android.widget.TextView r5 = r4.f8185K
        com.bytedance.sdk.openadsdk.core.a.a r6 = r4.f8180F
        r5.setOnClickListener(r6)
        android.widget.TextView r5 = r4.f8185K
        com.bytedance.sdk.openadsdk.core.a.a r6 = r4.f8180F
        r5.setOnTouchListener(r6)
    L_0x0216:
        boolean r5 = r4.f8183I
        if (r5 != 0) goto L_0x021d
        r4.m10654f(r1)
    L_0x021d:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoLayout.mo16147a(com.bytedance.sdk.openadsdk.core.d.k, java.lang.ref.WeakReference, boolean):void");
    }

    /* renamed from: w */
    public void mo16205w() {
        UIUtils.m12086d(this.f8191d);
        UIUtils.m12086d(this.f8192e);
        ImageView imageView = this.f8193f;
        if (imageView != null) {
            UIUtils.m12086d((View) imageView);
        }
    }

    /* renamed from: f */
    public void mo16160f() {
        UIUtils.m12086d(this.f8191d);
    }

    /* renamed from: a */
    public void mo16179a(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == this.f8189b.getHolder()) {
            this.f8209v = true;
            if (mo16200r()) {
                this.f8176B.mo15954a((IMediaLayout) this, surfaceHolder);
            }
        }
    }

    /* renamed from: a */
    public void mo16180a(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (surfaceHolder == this.f8189b.getHolder() && mo16200r()) {
            this.f8176B.mo15955a(this, surfaceHolder, i, i2, i3);
        }
    }

    /* renamed from: b */
    public void mo16189b(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == this.f8189b.getHolder()) {
            this.f8209v = false;
            if (mo16200r()) {
                this.f8176B.mo15969b((IMediaLayout) this, surfaceHolder);
            }
        }
    }

    /* renamed from: a */
    public void mo16178a(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f8209v = true;
        if (mo16200r()) {
            this.f8176B.mo15953a((IMediaLayout) this, surfaceTexture);
        }
    }

    /* renamed from: a */
    public boolean mo16185a(SurfaceTexture surfaceTexture) {
        this.f8209v = false;
        if (mo16200r()) {
            this.f8176B.mo15968b((IMediaLayout) this, surfaceTexture);
        }
        return true;
    }

    /* renamed from: g */
    public void mo16161g() {
        this.f8202o.setProgress(0);
        this.f8202o.setSecondaryProgress(0);
        mo16157c(8);
        if (mo16206x()) {
            this.f8189b.setVisibility(8);
        }
        ImageView imageView = this.f8193f;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        mo16157c(8);
        UIUtils.m12059a(this.f8195h, 8);
        UIUtils.m12059a((View) this.f8196i, 8);
        UIUtils.m12059a(this.f8197j, 8);
        UIUtils.m12059a((View) this.f8198k, 8);
        UIUtils.m12059a((View) this.f8199l, 8);
        UIUtils.m12059a((View) this.f8200m, 8);
        VideoTrafficTipLayout eVar = this.f8175A;
        if (eVar != null) {
            eVar.mo16321a(true);
        }
    }

    /* renamed from: i */
    public boolean mo16163i() {
        return this.f8208u;
    }

    /* renamed from: a */
    public void mo16151a(boolean z, boolean z2, boolean z3) {
        int i = 0;
        UIUtils.m12059a((View) this.f8202o, 0);
        ImageView imageView = this.f8190c;
        if (!z || this.f8191d.getVisibility() == 0) {
            i = 8;
        }
        UIUtils.m12059a((View) imageView, i);
    }

    /* renamed from: a */
    public void mo16150a(boolean z, boolean z2) {
        UIUtils.m12059a((View) this.f8202o, z ? 0 : 8);
        UIUtils.m12059a((View) this.f8190c, 8);
    }

    /* renamed from: j */
    public void mo16164j() {
        mo16150a(true, false);
    }

    /* renamed from: k */
    public boolean mo16165k() {
        return this.f8209v;
    }

    /* renamed from: c */
    public void mo16157c(int i) {
        this.f8210w = i;
        UIUtils.m12059a(this.f8188a, i);
    }

    /* renamed from: m */
    public boolean mo16167m() {
        VideoTrafficTipLayout eVar = this.f8175A;
        return eVar != null && eVar.mo16322a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: x */
    public boolean mo16206x() {
        return !this.f8211x.contains(C2323a.alwayShowMediaView) || this.f8208u;
    }

    /* renamed from: a */
    public void mo16182a(DrawVideoListener drawVideoListener) {
        this.f8182H = drawVideoListener;
        ClickCreativeListener aVar = this.f8180F;
        if (aVar != null) {
            aVar.mo15270a(drawVideoListener);
        }
    }
}
