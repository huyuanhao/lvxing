package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.os.Build;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd.DrawVideoListener;
import com.bytedance.sdk.openadsdk.core.GlobalInfo;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.VisibilityChecker;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.INativeVideoController.C2324a;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.INativeVideoController.C2325b;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.INativeVideoController.C2326c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoController.C2334a;
import com.bytedance.sdk.openadsdk.multipro.p205d.SPMultiHelper;
import com.bytedance.sdk.openadsdk.p165c.AdEventManager;
import com.bytedance.sdk.openadsdk.p188g.TTNetClient;
import com.bytedance.sdk.openadsdk.utils.C2538ak;
import com.bytedance.sdk.openadsdk.utils.C2538ak.C2539a;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.C2566w;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.bytedance.sdk.openadsdk.utils.UIUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class NativeVideoTsView extends FrameLayout implements C2324a, C2334a, C2539a {
    /* renamed from: A */
    private AtomicBoolean f8033A;
    /* renamed from: a */
    protected final MaterialMeta f8034a;
    /* renamed from: b */
    protected INativeVideoController f8035b;
    /* renamed from: c */
    protected FrameLayout f8036c;
    /* renamed from: d */
    protected boolean f8037d;
    /* renamed from: e */
    protected RelativeLayout f8038e;
    /* renamed from: f */
    protected ImageView f8039f;
    /* renamed from: g */
    protected ImageView f8040g;
    /* renamed from: h */
    protected ImageView f8041h;
    /* renamed from: i */
    protected String f8042i;
    /* renamed from: j */
    protected int f8043j;
    /* renamed from: k */
    AtomicBoolean f8044k;
    /* renamed from: l */
    boolean f8045l;
    /* renamed from: m */
    public C2322a f8046m;
    /* renamed from: n */
    private final Context f8047n;
    /* access modifiers changed from: private */
    /* renamed from: o */
    public ViewGroup f8048o;
    /* renamed from: p */
    private boolean f8049p;
    /* renamed from: q */
    private boolean f8050q;
    /* renamed from: r */
    private boolean f8051r;
    /* renamed from: s */
    private long f8052s;
    /* renamed from: t */
    private final C2538ak f8053t;
    /* renamed from: u */
    private boolean f8054u;
    /* renamed from: v */
    private final String f8055v;
    /* renamed from: w */
    private ViewStub f8056w;
    /* renamed from: x */
    private C2325b f8057x;
    /* renamed from: y */
    private final AtomicBoolean f8058y;
    /* renamed from: z */
    private boolean f8059z;

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView$a */
    public interface C2322a {
        /* renamed from: a */
        void mo15052a(boolean z, long j, long j2, long j3, boolean z2);
    }

    /* renamed from: a */
    public void mo14911a() {
    }

    /* renamed from: b */
    public void mo14914b(long j, int i) {
    }

    public void setDrawVideoListener(DrawVideoListener drawVideoListener) {
        INativeVideoController cVar = this.f8035b;
        if (cVar != null) {
            ((NativeVideoController) cVar).mo16119a(drawVideoListener);
        }
    }

    public void setControllerStatusCallBack(C2322a aVar) {
        this.f8046m = aVar;
    }

    /* renamed from: a */
    public void mo14912a(long j, int i) {
        C2325b bVar = this.f8057x;
        if (bVar != null) {
            bVar.mo15049d_();
        }
    }

    /* renamed from: d */
    private void mo15858d() {
        mo14912a(0, 0);
        this.f8057x = null;
    }

    /* renamed from: a */
    public void mo14913a(long j, long j2) {
        C2325b bVar = this.f8057x;
        if (bVar != null) {
            bVar.mo15046a(j, j2);
        }
    }

    public NativeVideoTsView(Context context, MaterialMeta kVar) {
        this(context, kVar, false);
    }

    public NativeVideoTsView(Context context, MaterialMeta kVar, boolean z) {
        this(context, kVar, z, "embeded_ad");
    }

    public NativeVideoTsView(Context context, MaterialMeta kVar, boolean z, String str) {
        super(context);
        this.f8049p = true;
        this.f8037d = true;
        this.f8050q = false;
        this.f8042i = "embeded_ad";
        this.f8043j = 50;
        this.f8051r = true;
        this.f8044k = new AtomicBoolean(false);
        this.f8053t = new C2538ak(this);
        this.f8054u = false;
        this.f8055v = Build.MODEL;
        this.f8045l = false;
        this.f8058y = new AtomicBoolean(false);
        this.f8059z = true;
        this.f8033A = new AtomicBoolean(false);
        this.f8042i = str;
        this.f8047n = context;
        this.f8034a = kVar;
        this.f8050q = z;
        setContentDescription("NativeVideoAdView");
        mo15856b();
        m10418i();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo15856b() {
        MaterialMeta kVar = this.f8034a;
        if (kVar != null) {
            int d = ToolUtils.m12018d(kVar.mo15428P());
            int c = InternalContainer.m10069h().mo15779c(d);
            if (c == 1) {
                this.f8049p = C2566w.m12245d(this.f8047n);
            } else if (c == 2) {
                boolean z = C2566w.m12246e(this.f8047n) || C2566w.m12245d(this.f8047n);
                this.f8049p = z;
            } else if (c == 3) {
                this.f8049p = false;
            } else if (c == 4) {
                this.f8045l = true;
            }
            if (!this.f8050q) {
                this.f8037d = InternalContainer.m10069h().mo15774a(d);
            } else {
                this.f8037d = false;
            }
            if ("splash_ad".equals(this.f8042i)) {
                this.f8049p = true;
                this.f8037d = true;
            }
            INativeVideoController cVar = this.f8035b;
            if (cVar != null) {
                cVar.mo15980e(this.f8049p);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f8050q) {
            C2322a aVar = this.f8046m;
            if (aVar != null) {
                INativeVideoController cVar = this.f8035b;
                if (cVar != null) {
                    aVar.mo15052a(cVar.mo15998v(), this.f8035b.mo15994r(), this.f8035b.mo15991o(), this.f8035b.mo15989m(), this.f8049p);
                }
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* renamed from: a */
    private View m10414a(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        frameLayout.setId(ResourceHelp.m11935e(this.f8047n, "tt_native_video_layout"));
        layoutParams.gravity = 17;
        frameLayout.setVisibility(8);
        this.f8048o = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context);
        LayoutParams layoutParams2 = new LayoutParams(-1, -1);
        frameLayout2.setId(ResourceHelp.m11935e(this.f8047n, "tt_native_video_frame"));
        layoutParams2.gravity = 17;
        frameLayout2.setLayoutParams(layoutParams2);
        frameLayout.addView(frameLayout2);
        this.f8036c = frameLayout2;
        ViewStub viewStub = new ViewStub(context);
        LayoutParams layoutParams3 = new LayoutParams(-1, -1);
        viewStub.setId(ResourceHelp.m11935e(this.f8047n, "tt_native_video_img_cover_viewStub"));
        viewStub.setLayoutResource(ResourceHelp.m11936f(this.f8047n, "tt_native_video_img_cover_layout"));
        viewStub.setLayoutParams(layoutParams3);
        frameLayout.addView(viewStub);
        this.f8056w = viewStub;
        return frameLayout;
    }

    /* renamed from: i */
    private void m10418i() {
        addView(m10414a(this.f8047n));
        m10420k();
    }

    /* renamed from: f */
    public void mo16097f() {
        if (this.f8047n != null) {
            ViewStub viewStub = this.f8056w;
            if (viewStub != null && viewStub.getParent() != null && this.f8034a != null && this.f8038e == null) {
                this.f8038e = (RelativeLayout) this.f8056w.inflate();
                if (!(this.f8034a.mo15512z() == null || this.f8034a.mo15512z().mo15601f() == null)) {
                    TTNetClient.m11428a(this.f8047n).mo16653a(this.f8034a.mo15512z().mo15601f(), this.f8039f);
                }
                this.f8039f = (ImageView) findViewById(ResourceHelp.m11935e(this.f8047n, "tt_native_video_img_id"));
                this.f8041h = (ImageView) findViewById(ResourceHelp.m11935e(this.f8047n, "tt_native_video_play"));
                m10419j();
            }
        }
    }

    /* renamed from: j */
    private void m10419j() {
        if ((this instanceof NativeDrawVideoTsView) && !this.f8044k.get() && GlobalInfo.m9616c().mo15689s() != null) {
            this.f8041h.setImageBitmap(GlobalInfo.m9616c().mo15689s());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f8041h.getLayoutParams();
            int a = (int) UIUtils.m12048a(getContext(), (float) this.f8043j);
            layoutParams.width = a;
            layoutParams.height = a;
            this.f8041h.setLayoutParams(layoutParams);
            this.f8044k.set(true);
        }
    }

    /* renamed from: k */
    private void m10420k() {
        NativeVideoController fVar = new NativeVideoController(this.f8047n, this.f8036c, this.f8034a, this.f8042i, !m10431v());
        this.f8035b = fVar;
        m10421l();
        this.f8048o.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                ((NativeVideoController) NativeVideoTsView.this.f8035b).mo16117a(NativeVideoTsView.this.f8048o.getWidth(), NativeVideoTsView.this.f8048o.getHeight());
                NativeVideoTsView.this.f8048o.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    public void setVideoAdLoadListener(C2326c cVar) {
        INativeVideoController cVar2 = this.f8035b;
        if (cVar2 != null) {
            cVar2.mo15960a(cVar);
        }
    }

    public void setNativeVideoAdListener(C2324a aVar) {
        INativeVideoController cVar = this.f8035b;
        if (cVar != null) {
            cVar.mo15959a(aVar);
        }
    }

    /* renamed from: a */
    public boolean mo16094a(long j, boolean z, boolean z2) {
        int i;
        long j2;
        long j3 = j;
        this.f8048o.setVisibility(0);
        if (this.f8035b == null) {
            this.f8035b = new NativeVideoController(this.f8047n, this.f8036c, this.f8034a, this.f8042i);
            m10421l();
        }
        this.f8052s = j3;
        if (!m10431v()) {
            return true;
        }
        this.f8035b.mo15972b(false);
        boolean a = this.f8035b.mo15965a(this.f8034a.mo15512z().mo15603g(), this.f8034a.mo15425M(), this.f8048o.getWidth(), this.f8048o.getHeight(), null, this.f8034a.mo15428P(), j, m10430u());
        int i2 = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
        if ((i2 > 0 && !z && !z2) || (i2 > 0 && z)) {
            INativeVideoController cVar = this.f8035b;
            if (cVar != null) {
                j2 = cVar.mo15991o();
                i = this.f8035b.mo15993q();
            } else {
                j2 = 0;
                i = 0;
            }
            AdEventManager.m8386a(this.f8047n, this.f8034a, this.f8042i, "feed_continue", j2, i, ToolUtils.m11997a(this.f8034a, this.f8035b.mo15990n(), this.f8035b.mo15996t()));
        }
        return a;
    }

    /* renamed from: l */
    private void m10421l() {
        INativeVideoController cVar = this.f8035b;
        if (cVar != null) {
            cVar.mo15980e(this.f8049p);
            ((NativeVideoController) this.f8035b).mo16121a((C2334a) this);
            this.f8035b.mo15959a((C2324a) this);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m10422m();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        m10422m();
    }

    /* renamed from: m */
    private void m10422m() {
        INativeVideoController cVar = this.f8035b;
        if (cVar == null) {
            m10420k();
        } else if ((cVar instanceof NativeVideoController) && !m10431v()) {
            ((NativeVideoController) this.f8035b).mo16132x();
        }
        if (this.f8035b != null && this.f8058y.get()) {
            this.f8058y.set(false);
            mo15856b();
            if (mo16098g()) {
                UIUtils.m12059a((View) this.f8038e, 8);
                ImageView imageView = this.f8040g;
                if (imageView != null) {
                    UIUtils.m12059a((View) imageView, 8);
                }
                this.f8035b.mo15965a(this.f8034a.mo15512z().mo15603g(), this.f8034a.mo15425M(), this.f8048o.getWidth(), this.f8048o.getHeight(), null, this.f8034a.mo15428P(), 0, m10430u());
                this.f8035b.mo15978d(false);
                return;
            }
            String str = "NativeVideoAdView";
            if (this.f8035b.mo15998v()) {
                StringBuilder sb = new StringBuilder();
                sb.append("attachTask-mNativeVideoController.isPlayComplete()=");
                sb.append(this.f8035b.mo15998v());
                C2564t.m12220b(str, sb.toString());
                mo16095b(true);
                return;
            }
            C2564t.m12222c(str, "attachTask.......mRlImgCover.....VISIBLE");
            mo16097f();
            UIUtils.m12059a((View) this.f8038e, 0);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m10423n();
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        m10423n();
    }

    /* renamed from: n */
    private void m10423n() {
        this.f8046m = null;
        mo16100h();
        m10424o();
    }

    /* renamed from: o */
    private void m10424o() {
        if (!this.f8058y.get()) {
            this.f8058y.set(true);
            INativeVideoController cVar = this.f8035b;
            if (cVar != null) {
                cVar.mo15964a(true);
            }
        }
        this.f8033A.set(false);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 4 || i == 8) {
            m10424o();
        }
    }

    /* renamed from: a */
    public void mo14813a(Message message) {
        if (message.what == 1) {
            m10425p();
        }
    }

    /* renamed from: p */
    private void m10425p() {
        m10416c(VisibilityChecker.m11004a(this, 50, 5));
        this.f8053t.sendEmptyMessageDelayed(1, 500);
    }

    /* renamed from: q */
    private boolean m10426q() {
        boolean z = false;
        if (m10431v()) {
            return false;
        }
        String str = "sp_multi_native_video_data";
        boolean a = SPMultiHelper.m11877a(str, "key_video_isfromvideodetailpage", false);
        if (SPMultiHelper.m11877a(str, "key_video_is_from_detail_page", false) || a) {
            z = true;
        }
        return z;
    }

    /* renamed from: r */
    private void m10427r() {
        if (!m10431v()) {
            String str = "sp_multi_native_video_data";
            SPMultiHelper.m11870a(str, "key_video_isfromvideodetailpage", Boolean.valueOf(false));
            SPMultiHelper.m11870a(str, "key_video_is_from_detail_page", Boolean.valueOf(false));
        }
    }

    /* renamed from: c */
    private void m10416c(boolean z) {
        if (!(this.f8034a == null || this.f8035b == null)) {
            boolean q = m10426q();
            m10427r();
            if (q && this.f8035b.mo15998v()) {
                StringBuilder sb = new StringBuilder();
                sb.append("changeVideoStatus---isFromDetailPage()=");
                sb.append(q);
                sb.append("，mNativeVideoController.isPlayComplete()=");
                sb.append(this.f8035b.mo15998v());
                C2564t.m12220b("NativeVideoAdView", sb.toString());
                mo16095b(true);
                mo15858d();
            } else if (!z || this.f8035b.mo15998v() || this.f8035b.mo15995s()) {
                if (this.f8035b.mo15996t() != null && this.f8035b.mo15996t().mo16067g()) {
                    this.f8035b.mo15984h();
                    C2325b bVar = this.f8057x;
                    if (bVar != null) {
                        bVar.mo15048d();
                    }
                }
            } else if (this.f8035b.mo15996t() == null || !this.f8035b.mo15996t().mo16069i()) {
                if (this.f8049p && this.f8035b.mo15996t() == null) {
                    if (!this.f8058y.get()) {
                        this.f8058y.set(true);
                    }
                    this.f8033A.set(false);
                    m10422m();
                }
            } else if (this.f8049p) {
                if ("ALP-AL00".equals(this.f8055v)) {
                    this.f8035b.mo15986j();
                } else {
                    ((NativeVideoController) this.f8035b).mo16131g(q);
                }
                C2325b bVar2 = this.f8057x;
                if (bVar2 != null) {
                    bVar2.mo15047c();
                }
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m10428s();
        if (m10426q()) {
            INativeVideoController cVar = this.f8035b;
            if (cVar != null && cVar.mo15998v()) {
                m10427r();
                UIUtils.m12059a((View) this.f8038e, 8);
                mo16095b(true);
                mo15858d();
                return;
            }
        }
        mo15856b();
        if (!m10431v() && mo16098g()) {
            INativeVideoController cVar2 = this.f8035b;
            if (cVar2 != null && !cVar2.mo15995s()) {
                if (this.f8053t != null) {
                    if (z) {
                        INativeVideoController cVar3 = this.f8035b;
                        if (cVar3 != null && !cVar3.mo15998v()) {
                            this.f8053t.obtainMessage(1).sendToTarget();
                        }
                    }
                    this.f8053t.removeMessages(1);
                    m10416c(false);
                }
                return;
            }
        }
        if (!mo16098g()) {
            if (!z) {
                INativeVideoController cVar4 = this.f8035b;
                if (!(cVar4 == null || cVar4.mo15996t() == null || !this.f8035b.mo15996t().mo16067g())) {
                    this.f8053t.removeMessages(1);
                    m10416c(false);
                }
            }
            if (z) {
                this.f8053t.obtainMessage(1).sendToTarget();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        m10428s();
        if (this.f8059z) {
            this.f8059z = i == 0;
        }
        if (m10426q()) {
            INativeVideoController cVar = this.f8035b;
            if (cVar != null && cVar.mo15998v()) {
                m10427r();
                UIUtils.m12059a((View) this.f8038e, 8);
                mo16095b(true);
                mo15858d();
                return;
            }
        }
        mo15856b();
        if (!m10431v() && mo16098g()) {
            INativeVideoController cVar2 = this.f8035b;
            if (cVar2 != null && !cVar2.mo15995s()) {
                if (this.f8051r) {
                    this.f8035b.mo15965a(this.f8034a.mo15512z().mo15603g(), this.f8034a.mo15425M(), this.f8048o.getWidth(), this.f8048o.getHeight(), null, this.f8034a.mo15428P(), this.f8052s, m10430u());
                    this.f8051r = false;
                    UIUtils.m12059a((View) this.f8038e, 8);
                }
                if (i == 0 && this.f8053t != null) {
                    INativeVideoController cVar3 = this.f8035b;
                    if (cVar3 != null && !cVar3.mo15998v()) {
                        this.f8053t.obtainMessage(1).sendToTarget();
                    }
                }
            }
        }
    }

    /* renamed from: s */
    private void m10428s() {
        String str = "key_video_is_update_flag";
        String str2 = "sp_multi_native_video_data";
        boolean z = this.f8035b == null || m10431v() || !SPMultiHelper.m11877a(str2, str, false);
        if (!z) {
            boolean a = SPMultiHelper.m11877a(str2, "key_native_video_complete", false);
            long a2 = SPMultiHelper.m11866a(str2, "key_video_current_play_position", 0);
            long a3 = SPMultiHelper.m11866a(str2, "key_video_total_play_duration", this.f8035b.mo15991o());
            long a4 = SPMultiHelper.m11866a(str2, "key_video_duration", this.f8035b.mo15994r());
            this.f8035b.mo15978d(a);
            this.f8035b.mo15950a(a2);
            this.f8035b.mo15966b(a3);
            this.f8035b.mo15973c(a4);
            SPMultiHelper.m11870a(str2, str, Boolean.valueOf(false));
            StringBuilder sb = new StringBuilder();
            sb.append("onResumeFeedNativeVideoControllerData-isComplete=");
            sb.append(a);
            sb.append(",position=");
            sb.append(a2);
            sb.append(",totalPlayDuration=");
            sb.append(a3);
            sb.append(",duration=");
            sb.append(a4);
            C2564t.m12226e("MultiProcess", sb.toString());
        }
    }

    public void setNativeVideoController(INativeVideoController cVar) {
        this.f8035b = cVar;
    }

    public INativeVideoController getNativeVideoController() {
        return this.f8035b;
    }

    /* renamed from: g */
    public boolean mo16098g() {
        return this.f8049p;
    }

    public void setIsAutoPlay(boolean z) {
        if (!this.f8054u) {
            int c = InternalContainer.m10069h().mo15779c(ToolUtils.m12018d(this.f8034a.mo15428P()));
            if (z && c != 4 && (!C2566w.m12246e(this.f8047n) ? !C2566w.m12245d(this.f8047n) : !m10429t())) {
                z = false;
            }
            this.f8049p = z;
            INativeVideoController cVar = this.f8035b;
            if (cVar != null) {
                cVar.mo15980e(this.f8049p);
            }
            if (!this.f8049p) {
                mo16097f();
                RelativeLayout relativeLayout = this.f8038e;
                if (relativeLayout != null) {
                    UIUtils.m12059a((View) relativeLayout, 0);
                    TTNetClient.m11428a(this.f8047n).mo16653a(this.f8034a.mo15512z().mo15601f(), this.f8039f);
                }
            } else {
                UIUtils.m12059a((View) this.f8038e, 8);
            }
            this.f8054u = true;
        }
    }

    /* renamed from: t */
    private boolean m10429t() {
        return 2 == InternalContainer.m10069h().mo15779c(ToolUtils.m12018d(this.f8034a.mo15428P()));
    }

    /* renamed from: u */
    private boolean m10430u() {
        return this.f8037d;
    }

    public void setIsQuiet(boolean z) {
        this.f8037d = z;
        INativeVideoController cVar = this.f8035b;
        if (cVar != null) {
            cVar.mo15975c(z);
        }
    }

    /* renamed from: v */
    private boolean m10431v() {
        return this.f8050q;
    }

    public void setVideoAdInteractionListener(C2325b bVar) {
        this.f8057x = bVar;
    }

    /* renamed from: e */
    public void mo16096e() {
        C2325b bVar = this.f8057x;
        if (bVar != null) {
            bVar.mo15050e();
        }
    }

    /* renamed from: a */
    public void mo16093a(int i) {
        mo15856b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo15857c() {
        if (C2566w.m12244c(InternalContainer.m10059a()) != 0) {
            if (this.f8035b.mo15996t() != null) {
                if (this.f8035b.mo15996t().mo16067g()) {
                    m10416c(false);
                    C2538ak akVar = this.f8053t;
                    if (akVar != null) {
                        akVar.removeMessages(1);
                    }
                    mo15855a(true);
                    return;
                } else if (this.f8035b.mo15996t().mo16069i()) {
                    m10416c(true);
                    C2538ak akVar2 = this.f8053t;
                    if (akVar2 != null) {
                        akVar2.sendEmptyMessageDelayed(1, 500);
                    }
                    mo15855a(false);
                    return;
                }
            }
            if (!mo16098g() && !this.f8033A.get()) {
                this.f8033A.set(true);
                m10432w();
                this.f8035b.mo15965a(this.f8034a.mo15512z().mo15603g(), this.f8034a.mo15425M(), this.f8048o.getWidth(), this.f8048o.getHeight(), null, this.f8034a.mo15428P(), this.f8052s, m10430u());
                C2538ak akVar3 = this.f8053t;
                if (akVar3 != null) {
                    akVar3.sendEmptyMessageDelayed(1, 500);
                }
                mo15855a(false);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo15855a(boolean z) {
        if (this.f8040g == null) {
            this.f8040g = new ImageView(getContext());
            if (GlobalInfo.m9616c().mo15689s() != null) {
                this.f8040g.setImageBitmap(GlobalInfo.m9616c().mo15689s());
            } else {
                this.f8040g.setImageResource(ResourceHelp.m11934d(InternalContainer.m10059a(), "tt_new_play_video"));
            }
            this.f8040g.setScaleType(ScaleType.FIT_XY);
            int a = (int) UIUtils.m12048a(getContext(), (float) this.f8043j);
            int a2 = (int) UIUtils.m12048a(getContext(), 10.0f);
            LayoutParams layoutParams = new LayoutParams(a, a);
            layoutParams.gravity = 17;
            layoutParams.rightMargin = a2;
            layoutParams.bottomMargin = a2;
            this.f8048o.addView(this.f8040g, layoutParams);
        }
        if (z) {
            this.f8040g.setVisibility(0);
        } else {
            this.f8040g.setVisibility(8);
        }
    }

    /* renamed from: b */
    public void mo16095b(boolean z) {
        INativeVideoController cVar = this.f8035b;
        if (cVar != null) {
            cVar.mo15978d(z);
            NativeVideoLayout u = this.f8035b.mo15997u();
            if (u != null) {
                u.mo16205w();
                View s = u.mo16201s();
                if (s != null) {
                    if (s.getParent() != null) {
                        ((ViewGroup) s.getParent()).removeView(s);
                    }
                    s.setVisibility(0);
                    addView(s);
                    u.mo16147a(this.f8034a, new WeakReference<>(this.f8047n), false);
                }
            }
        }
    }

    /* renamed from: h */
    public void mo16100h() {
        INativeVideoController cVar = this.f8035b;
        if (cVar != null) {
            NativeVideoLayout u = cVar.mo15997u();
            if (u != null) {
                u.mo16159e();
                View s = u.mo16201s();
                if (s != null) {
                    s.setVisibility(8);
                    if (s.getParent() != null) {
                        ((ViewGroup) s.getParent()).removeView(s);
                    }
                }
            }
        }
    }

    /* renamed from: w */
    private void m10432w() {
        UIUtils.m12086d((View) this.f8040g);
        UIUtils.m12086d((View) this.f8038e);
    }
}
