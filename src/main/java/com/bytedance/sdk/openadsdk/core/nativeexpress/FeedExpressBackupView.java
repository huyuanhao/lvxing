package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p170d.DynamicClickInfo;
import com.bytedance.sdk.openadsdk.core.p170d.Image;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.C2322a;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.p188g.TTNetClient;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.C2566w;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.bytedance.sdk.openadsdk.utils.UIUtils;
import java.util.Locale;

/* renamed from: com.bytedance.sdk.openadsdk.core.nativeexpress.h */
class FeedExpressBackupView extends BackupView {
    /* renamed from: j */
    private static Mode[] f7832j = {new Mode(2, 3.0241935f, 375, 124), new Mode(3, 1.25f, 375, 300), new Mode(4, 1.4044944f, 375, 267), new Mode(16, 1.25f, 375, 300), new Mode(5, 1.25f, 375, 300), new Mode(15, 1.25f, 375, 300)};
    /* renamed from: h */
    boolean f7833h = true;
    /* renamed from: i */
    boolean f7834i = true;
    /* renamed from: k */
    private int f7835k;
    /* renamed from: l */
    private View f7836l;
    /* renamed from: m */
    private NativeExpressView f7837m;
    /* renamed from: n */
    private ITTDownloadAdapter f7838n;

    public FeedExpressBackupView(Context context) {
        super(context);
        this.f7750a = context;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo15903a(MaterialMeta kVar, NativeExpressView nativeExpressView, ITTDownloadAdapter aVar) {
        C2564t.m12220b("FeedExpressBackupView", "show backup view");
        setBackgroundColor(-1);
        this.f7751b = kVar;
        this.f7837m = nativeExpressView;
        this.f7838n = aVar;
        this.f7835k = ToolUtils.m12018d(this.f7751b.mo15428P());
        m10027b(this.f7835k);
        m10028c();
        this.f7837m.addView(this, new LayoutParams(-2, -2));
    }

    /* renamed from: c */
    private void m10028c() {
        Mode a = m10025a(this.f7751b.mo15429Q());
        this.f7755f = UIUtils.m12079c(this.f7750a, (float) this.f7837m.getExpectExpressWidth());
        this.f7756g = UIUtils.m12079c(this.f7750a, (float) this.f7837m.getExpectExpressHeight());
        if (this.f7755f <= 0) {
            this.f7755f = UIUtils.m12078c(this.f7750a);
        }
        if (this.f7756g <= 0) {
            this.f7756g = Float.valueOf(((float) this.f7755f) / a.f7847b).intValue();
        }
        if (this.f7755f > 0 && this.f7755f > UIUtils.m12078c(this.f7750a)) {
            float c = ((float) UIUtils.m12078c(this.f7750a)) / ((float) this.f7755f);
            this.f7755f = UIUtils.m12078c(this.f7750a);
            this.f7756g = Float.valueOf(((float) this.f7756g) * c).intValue();
        }
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
        if (ToolUtils.m12014c(this.f7751b.mo15428P()) == 9) {
            this.f7754e = "draw_ad";
            m10033h();
            return;
        }
        this.f7754e = "embeded_ad";
        int Q = this.f7751b.mo15429Q();
        if (Q == 2) {
            m10029d();
        } else if (Q == 3) {
            m10031f();
        } else if (Q == 4) {
            m10030e();
        } else if (Q == 5) {
            m10034i();
        } else if (Q == 15) {
            m10032g();
        } else if (Q == 16) {
            m10035j();
        }
    }

    /* renamed from: a */
    private Mode m10025a(int i) {
        Mode[] iVarArr = f7832j;
        Mode iVar = iVarArr[0];
        try {
            for (Mode iVar2 : iVarArr) {
                if (iVar2.f7846a == i) {
                    return iVar2;
                }
            }
            return iVar;
        } catch (Throwable unused) {
            return iVar;
        }
    }

    /* renamed from: a */
    private void m10026a(ImageView imageView) {
        TTNetClient.m11428a(this.f7750a).mo16653a(((Image) this.f7751b.mo15418F().get(0)).mo15406a(), imageView);
    }

    /* renamed from: d */
    private void m10029d() {
        this.f7836l = LayoutInflater.from(this.f7750a).inflate(ResourceHelp.m11936f(this.f7750a, "tt_backup_feed_img_small"), this, true);
        ImageView imageView = (ImageView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_close"));
        TextView textView = (TextView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_desc"));
        TextView textView2 = (TextView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_title"));
        m10026a((ImageView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_img")));
        textView.setText(getDescription());
        textView2.setText(getTitle());
        imageView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                FeedExpressBackupView.this.mo15843a();
            }
        });
        mo15844a((View) this, true);
    }

    /* renamed from: e */
    private void m10030e() {
        this.f7836l = LayoutInflater.from(this.f7750a).inflate(ResourceHelp.m11936f(this.f7750a, "tt_backup_feed_img_group"), this, true);
        ImageView imageView = (ImageView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_img_1"));
        ImageView imageView2 = (ImageView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_img_2"));
        ImageView imageView3 = (ImageView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_img_3"));
        ImageView imageView4 = (ImageView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_icon"));
        ImageView imageView5 = (ImageView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_close"));
        TextView textView = (TextView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_desc"));
        TextView textView2 = (TextView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_title"));
        TextView textView3 = (TextView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_download"));
        String a = ((Image) this.f7751b.mo15418F().get(0)).mo15406a();
        String a2 = ((Image) this.f7751b.mo15418F().get(1)).mo15406a();
        String a3 = ((Image) this.f7751b.mo15418F().get(2)).mo15406a();
        TTNetClient.m11428a(this.f7750a).mo16653a(a, imageView);
        TTNetClient.m11428a(this.f7750a).mo16653a(a2, imageView2);
        TTNetClient.m11428a(this.f7750a).mo16653a(a3, imageView3);
        TTNetClient.m11428a(this.f7750a).mo16653a(this.f7751b.mo15415C().mo15406a(), imageView4);
        imageView5.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                FeedExpressBackupView.this.mo15843a();
            }
        });
        textView.setText(getDescription());
        textView2.setText(getTitle());
        if (!TextUtils.isEmpty(this.f7751b.mo15424L())) {
            textView3.setText(this.f7751b.mo15424L());
        }
        mo15844a((View) this, false);
        mo15844a((View) textView3, true);
    }

    /* renamed from: f */
    private void m10031f() {
        this.f7836l = LayoutInflater.from(this.f7750a).inflate(ResourceHelp.m11936f(this.f7750a, "tt_backup_feed_horizontal"), this, true);
        this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_video_container")).setVisibility(8);
        this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_img_container")).setVisibility(0);
        ImageView imageView = (ImageView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_img"));
        ImageView imageView2 = (ImageView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_close"));
        TextView textView = (TextView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_desc"));
        TextView textView2 = (TextView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_title"));
        TextView textView3 = (TextView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_download"));
        imageView.setAdjustViewBounds(true);
        imageView.setMaxHeight(this.f7756g);
        m10026a(imageView);
        imageView2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                FeedExpressBackupView.this.mo15843a();
            }
        });
        textView.setText(getDescription());
        textView2.setText(getTitle());
        if (!TextUtils.isEmpty(this.f7751b.mo15424L())) {
            textView3.setText(this.f7751b.mo15424L());
        }
        mo15844a((View) this, false);
        mo15844a((View) textView3, true);
    }

    /* renamed from: g */
    private void m10032g() {
        this.f7836l = LayoutInflater.from(this.f7750a).inflate(ResourceHelp.m11936f(this.f7750a, "tt_backup_feed_vertical"), this, true);
        this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_video_container")).setVisibility(0);
        this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_img_container")).setVisibility(8);
        FrameLayout frameLayout = (FrameLayout) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_video_container_inner"));
        ImageView imageView = (ImageView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_close"));
        TextView textView = (TextView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_desc"));
        TextView textView2 = (TextView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_title"));
        TextView textView3 = (TextView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_video_name1"));
        TextView textView4 = (TextView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_video_name2"));
        TextView textView5 = (TextView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_download"));
        TextView textView6 = (TextView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_video_score"));
        TTRatingBar tTRatingBar = (TTRatingBar) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_video_score_bar"));
        TTNetClient.m11428a(this.f7750a).mo16653a(this.f7751b.mo15415C().mo15406a(), (ImageView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_video_icon")));
        imageView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                FeedExpressBackupView.this.mo15843a();
            }
        });
        int e = this.f7751b.mo15426N() != null ? this.f7751b.mo15426N().mo15350e() : 4;
        textView6.setText(String.format(Locale.getDefault(), "%.1f", new Object[]{Float.valueOf((float) e)}));
        tTRatingBar.setStarEmptyNum(1);
        tTRatingBar.setStarFillNum(e);
        tTRatingBar.setStarImageWidth((float) UIUtils.m12079c(this.f7750a, 15.0f));
        tTRatingBar.setStarImageHeight((float) UIUtils.m12079c(this.f7750a, 14.0f));
        tTRatingBar.setStarImagePadding((float) UIUtils.m12079c(this.f7750a, 4.0f));
        tTRatingBar.mo16263a();
        textView3.setText(getNameOrSource());
        textView4.setText(getTitle());
        textView.setText(getDescription());
        textView2.setText(getTitle());
        if (!TextUtils.isEmpty(this.f7751b.mo15424L())) {
            textView5.setText(this.f7751b.mo15424L());
        }
        View b = mo15904b();
        if (b != null) {
            int i = (this.f7755f * 123) / 375;
            int i2 = (i * 16) / 9;
            frameLayout.removeAllViews();
            frameLayout.addView(b, new LayoutParams(i, i2));
        }
        mo15844a((View) this, false);
        mo15844a((View) textView5, true);
    }

    /* renamed from: h */
    private void m10033h() {
        this.f7836l = LayoutInflater.from(this.f7750a).inflate(ResourceHelp.m11936f(this.f7750a, "tt_backup_draw"), this, true);
        FrameLayout frameLayout = (FrameLayout) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_video_container"));
        TextView textView = (TextView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_desc"));
        TextView textView2 = (TextView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_title"));
        TextView textView3 = (TextView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_download"));
        textView.setText(getDescription());
        textView2.setText(getTitle());
        if (!TextUtils.isEmpty(this.f7751b.mo15424L())) {
            textView3.setText(this.f7751b.mo15424L());
        }
        View b = mo15904b();
        if (b != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(b, new LayoutParams(-1, -1));
        }
        mo15844a((View) textView2, false);
        mo15844a((View) textView, false);
        mo15844a((View) textView3, true);
    }

    /* renamed from: i */
    private void m10034i() {
        this.f7836l = LayoutInflater.from(this.f7750a).inflate(ResourceHelp.m11936f(this.f7750a, "tt_backup_feed_horizontal"), this, true);
        FrameLayout frameLayout = (FrameLayout) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_video_container"));
        frameLayout.setVisibility(0);
        this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_img_container")).setVisibility(8);
        TextView textView = (TextView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_desc"));
        TextView textView2 = (TextView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_title"));
        TextView textView3 = (TextView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_download"));
        ((ImageView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_close"))).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                FeedExpressBackupView.this.mo15843a();
            }
        });
        textView.setText(getDescription());
        textView2.setText(getTitle());
        if (!TextUtils.isEmpty(this.f7751b.mo15424L())) {
            textView3.setText(this.f7751b.mo15424L());
        }
        View b = mo15904b();
        if (b != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(b, new LayoutParams(this.f7755f, (this.f7755f * 9) / 16));
        }
        mo15844a((View) this, false);
        mo15844a((View) textView3, true);
    }

    /* renamed from: j */
    private void m10035j() {
        this.f7836l = LayoutInflater.from(this.f7750a).inflate(ResourceHelp.m11936f(this.f7750a, "tt_backup_feed_vertical"), this, true);
        this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_video_container")).setVisibility(8);
        this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_img_container")).setVisibility(0);
        ImageView imageView = (ImageView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_close"));
        TextView textView = (TextView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_desc"));
        TextView textView2 = (TextView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_title"));
        TextView textView3 = (TextView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_download"));
        m10026a((ImageView) this.f7836l.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_img")));
        imageView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                FeedExpressBackupView.this.mo15843a();
            }
        });
        textView.setText(getDescription());
        textView2.setText(getTitle());
        if (!TextUtils.isEmpty(this.f7751b.mo15424L())) {
            textView3.setText(this.f7751b.mo15424L());
        }
        mo15844a((View) this, false);
        mo15844a((View) textView3, true);
    }

    /* renamed from: b */
    public View mo15904b() {
        NativeVideoTsView nativeVideoTsView;
        if (!(this.f7751b == null || this.f7750a == null)) {
            if (m10036k()) {
                try {
                    nativeVideoTsView = new NativeVideoTsView(this.f7750a, this.f7751b);
                    nativeVideoTsView.setControllerStatusCallBack(new C2322a() {
                        /* renamed from: a */
                        public void mo15052a(boolean z, long j, long j2, long j3, boolean z2) {
                        }
                    });
                    nativeVideoTsView.setIsAutoPlay(this.f7833h);
                    nativeVideoTsView.setIsQuiet(this.f7834i);
                } catch (Throwable unused) {
                }
                if (m10036k() || nativeVideoTsView == null || !nativeVideoTsView.mo16094a(0, true, false)) {
                    return null;
                }
                return nativeVideoTsView;
            }
            nativeVideoTsView = null;
            if (m10036k()) {
            }
        }
        return null;
    }

    /* renamed from: b */
    private void m10027b(int i) {
        this.f7834i = InternalContainer.m10069h().mo15774a(this.f7835k);
        int c = InternalContainer.m10069h().mo15779c(i);
        if (3 == c) {
            this.f7833h = false;
        } else if (1 == c && C2566w.m12245d(this.f7750a)) {
            this.f7833h = true;
        } else if (2 != c) {
        } else {
            if (C2566w.m12246e(this.f7750a) || C2566w.m12245d(this.f7750a)) {
                this.f7833h = true;
            }
        }
    }

    /* renamed from: k */
    private boolean m10036k() {
        return this.f7751b != null && (this.f7751b.mo15429Q() == 5 || this.f7751b.mo15429Q() == 15);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo15294a(int i, DynamicClickInfo iVar) {
        NativeExpressView nativeExpressView = this.f7837m;
        if (nativeExpressView != null) {
            nativeExpressView.mo15184a(i, iVar);
        }
    }
}
