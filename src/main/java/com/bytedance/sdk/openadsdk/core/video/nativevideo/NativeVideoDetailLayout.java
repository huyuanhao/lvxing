package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.IMediaLayout.C2323a;
import com.bytedance.sdk.openadsdk.core.video.p178d.MediaHelper;
import com.bytedance.sdk.openadsdk.core.widget.VideoOnTouchLayout;
import com.bytedance.sdk.openadsdk.p188g.TTNetClient;
import com.bytedance.sdk.openadsdk.utils.C2538ak;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;
import com.bytedance.sdk.openadsdk.utils.UIUtils;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.Locale;

/* renamed from: com.bytedance.sdk.openadsdk.core.video.nativevideo.g */
public class NativeVideoDetailLayout extends NativeVideoLayout {
    /* renamed from: J */
    private TextView f8122J;
    /* renamed from: K */
    private ImageView f8123K;
    /* renamed from: L */
    private View f8124L;
    /* renamed from: M */
    private TextView f8125M;
    /* renamed from: N */
    private TextView f8126N;
    /* renamed from: O */
    private TextView f8127O;
    /* renamed from: P */
    private ImageView f8128P;
    /* renamed from: Q */
    private View f8129Q;
    /* renamed from: R */
    private ImageView f8130R;
    /* renamed from: S */
    private TextView f8131S;
    /* renamed from: T */
    private View f8132T;
    /* renamed from: U */
    private SeekBar f8133U;
    /* renamed from: V */
    private TextView f8134V;
    /* renamed from: W */
    private TextView f8135W;
    /* renamed from: X */
    private ImageView f8136X;
    /* renamed from: Y */
    private final C2538ak f8137Y;
    /* access modifiers changed from: private */
    /* renamed from: Z */
    public boolean f8138Z;
    /* renamed from: aA */
    private boolean f8139aA;
    /* renamed from: aB */
    private boolean f8140aB;
    /* renamed from: aa */
    private boolean f8141aa;
    /* renamed from: ab */
    private int f8142ab;
    /* renamed from: ac */
    private int f8143ac;
    /* renamed from: ad */
    private int f8144ad;
    /* renamed from: ae */
    private int f8145ae;
    /* renamed from: af */
    private int f8146af;
    /* renamed from: ag */
    private final Rect f8147ag;
    /* renamed from: ah */
    private ColorStateList f8148ah;
    /* renamed from: ai */
    private float f8149ai;
    /* renamed from: aj */
    private final Rect f8150aj;
    /* renamed from: ak */
    private int f8151ak;
    /* renamed from: al */
    private boolean f8152al;
    /* renamed from: am */
    private int f8153am;
    /* renamed from: an */
    private int f8154an;
    /* renamed from: ao */
    private VideoOnTouchLayout f8155ao;
    /* access modifiers changed from: private */
    /* renamed from: ap */
    public boolean f8156ap;
    /* renamed from: aq */
    private final OnTouchListener f8157aq;
    /* renamed from: ar */
    private float f8158ar;
    /* renamed from: as */
    private ColorStateList f8159as;
    /* renamed from: at */
    private float f8160at;
    /* renamed from: au */
    private final Rect f8161au;
    /* renamed from: av */
    private float f8162av;
    /* renamed from: aw */
    private ColorStateList f8163aw;
    /* renamed from: ax */
    private float f8164ax;
    /* renamed from: ay */
    private final Rect f8165ay;
    /* renamed from: az */
    private final Rect f8166az;

    public NativeVideoDetailLayout(Context context, View view, boolean z, EnumSet<C2323a> enumSet, MaterialMeta kVar, INativeVideoController cVar, boolean z2) {
        super(context, view, z, enumSet, kVar, cVar, z2);
        this.f8137Y = new C2538ak(this);
        this.f8138Z = false;
        this.f8141aa = false;
        this.f8142ab = 0;
        this.f8143ac = 0;
        this.f8144ad = 0;
        this.f8145ae = 0;
        this.f8146af = 0;
        this.f8147ag = new Rect();
        this.f8150aj = new Rect();
        this.f8151ak = 0;
        this.f8153am = 0;
        this.f8154an = 0;
        this.f8155ao = null;
        this.f8156ap = false;
        this.f8157aq = new OnTouchListener() {
            /* renamed from: b */
            private float f8174b;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                float x = motionEvent.getX();
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked != 0) {
                    boolean z = true;
                    if (actionMasked == 1) {
                        NativeVideoDetailLayout gVar = NativeVideoDetailLayout.this;
                        if (Math.abs(this.f8174b - motionEvent.getX()) >= 10.0f) {
                            z = false;
                        }
                        gVar.f8156ap = z;
                    } else if (actionMasked == 2) {
                        view.getParent().requestDisallowInterceptTouchEvent(true);
                    } else if (actionMasked == 3) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                } else {
                    this.f8174b = x;
                }
                return false;
            }
        };
        this.f8161au = new Rect();
        this.f8165ay = new Rect();
        this.f8166az = new Rect();
        this.f8213z = InternalContainer.m10059a().getApplicationContext();
        mo16193c(z2);
        this.f8188a = view;
        this.f8208u = z;
        this.f8155ao = new VideoOnTouchLayout(this);
        this.f8155ao.mo16317a(this.f8208u);
        DisplayMetrics displayMetrics = this.f8213z.getResources().getDisplayMetrics();
        this.f8153am = displayMetrics.widthPixels;
        this.f8154an = displayMetrics.heightPixels;
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

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo16144a(Context context, View view) {
        super.mo16144a(context, view);
        this.f8122J = (TextView) view.findViewById(ResourceHelp.m11935e(context, "tt_video_back"));
        this.f8123K = (ImageView) view.findViewById(ResourceHelp.m11935e(context, "tt_video_close"));
        this.f8124L = view.findViewById(ResourceHelp.m11935e(context, "tt_video_top_layout"));
        this.f8128P = (ImageView) view.findViewById(ResourceHelp.m11935e(context, "tt_video_fullscreen_back"));
        this.f8125M = (TextView) view.findViewById(ResourceHelp.m11935e(context, "tt_video_title"));
        this.f8126N = (TextView) view.findViewById(ResourceHelp.m11935e(context, "tt_video_top_title"));
        this.f8127O = (TextView) view.findViewById(ResourceHelp.m11935e(context, "tt_video_current_time"));
        this.f8129Q = view.findViewById(ResourceHelp.m11935e(context, "tt_video_loading_retry"));
        this.f8130R = (ImageView) view.findViewById(ResourceHelp.m11935e(context, "tt_video_retry"));
        this.f8131S = (TextView) view.findViewById(ResourceHelp.m11935e(context, "tt_video_retry_des"));
        this.f8133U = (SeekBar) view.findViewById(ResourceHelp.m11935e(context, "tt_video_seekbar"));
        this.f8134V = (TextView) view.findViewById(ResourceHelp.m11935e(context, "tt_video_time_left_time"));
        this.f8135W = (TextView) view.findViewById(ResourceHelp.m11935e(context, "tt_video_time_play"));
        this.f8132T = view.findViewById(ResourceHelp.m11935e(context, "tt_video_ad_bottom_layout"));
        this.f8136X = (ImageView) view.findViewById(ResourceHelp.m11935e(context, "tt_video_ad_full_screen"));
        this.f8194g = (ViewStub) view.findViewById(ResourceHelp.m11935e(context, "tt_video_ad_cover"));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo16140a() {
        super.mo16140a();
        this.f8155ao.mo16316a(this.f8188a);
        ImageView imageView = this.f8123K;
        int i = 8;
        int i2 = (this.f8208u || this.f8211x.contains(C2323a.hideCloseBtn)) ? 8 : 0;
        UIUtils.m12059a((View) imageView, i2);
        this.f8123K.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (NativeVideoDetailLayout.this.mo16200r()) {
                    NativeVideoDetailLayout.this.f8176B.mo15974c(NativeVideoDetailLayout.this, view);
                }
            }
        });
        TextView textView = this.f8122J;
        if (!this.f8208u || this.f8211x.contains(C2323a.alwayShowBackBtn)) {
            i = 0;
        }
        UIUtils.m12059a((View) textView, i);
        this.f8122J.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (NativeVideoDetailLayout.this.mo16200r()) {
                    NativeVideoDetailLayout.this.f8176B.mo15977d(NativeVideoDetailLayout.this, view);
                }
            }
        });
        this.f8128P.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (NativeVideoDetailLayout.this.mo16200r()) {
                    NativeVideoDetailLayout.this.f8176B.mo15979e(NativeVideoDetailLayout.this, view);
                }
            }
        });
        this.f8130R.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                NativeVideoDetailLayout.this.mo16190b(false, true);
                NativeVideoDetailLayout.this.mo16160f();
                NativeVideoDetailLayout.this.mo16158d();
                if (NativeVideoDetailLayout.this.mo16200r()) {
                    NativeVideoDetailLayout.this.f8176B.mo15981f(NativeVideoDetailLayout.this, view);
                }
            }
        });
        this.f8136X.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (NativeVideoDetailLayout.this.mo16200r()) {
                    NativeVideoDetailLayout.this.f8176B.mo15970b((IMediaLayout) NativeVideoDetailLayout.this, view);
                }
            }
        });
        this.f8133U.setThumbOffset(0);
        this.f8133U.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (!NativeVideoDetailLayout.this.f8138Z && NativeVideoDetailLayout.this.f8213z != null) {
                    seekBar.setThumb(ResourceHelp.m11933c(InternalContainer.m10059a(), "tt_seek_thumb_normal"));
                }
                if (NativeVideoDetailLayout.this.mo16200r()) {
                    seekBar.setThumbOffset(0);
                    NativeVideoDetailLayout.this.f8176B.mo15951a((IMediaLayout) NativeVideoDetailLayout.this, seekBar.getProgress());
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                if (!NativeVideoDetailLayout.this.f8138Z && NativeVideoDetailLayout.this.f8213z != null) {
                    seekBar.setThumb(ResourceHelp.m11933c(InternalContainer.m10059a(), "tt_seek_thumb_press"));
                }
                if (NativeVideoDetailLayout.this.mo16200r()) {
                    seekBar.setThumbOffset(0);
                    NativeVideoDetailLayout.this.f8176B.mo15967b((IMediaLayout) NativeVideoDetailLayout.this, seekBar.getProgress());
                }
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (NativeVideoDetailLayout.this.mo16200r()) {
                    NativeVideoDetailLayout.this.f8176B.mo15952a(NativeVideoDetailLayout.this, i, z);
                }
            }
        });
        this.f8133U.setOnTouchListener(this.f8157aq);
    }

    /* renamed from: b */
    public void mo16152b() {
        this.f8137Y.removeMessages(1);
        this.f8137Y.sendMessageDelayed(this.f8137Y.obtainMessage(1), 2000);
    }

    /* renamed from: c */
    public void mo16156c() {
        this.f8137Y.removeMessages(1);
    }

    /* renamed from: a */
    public void mo16149a(boolean z) {
        int i = mo16162h() ? this.f8154an : this.f8204q;
        int i2 = mo16162h() ? this.f8153am : this.f8205r;
        if (this.f8207t > 0 && this.f8206s > 0 && i > 0) {
            if (!mo16163i() && !mo16162h() && !this.f8211x.contains(C2323a.fixedSize)) {
                i2 = this.f8213z.getResources().getDimensionPixelSize(ResourceHelp.m11938h(this.f8213z, "tt_video_container_maxheight"));
            }
            int i3 = (int) (((float) this.f8207t) * ((((float) i) * 1.0f) / ((float) this.f8206s)));
            if (i3 > i2) {
                i = (int) (((float) this.f8206s) * ((((float) i2) * 1.0f) / ((float) this.f8207t)));
            } else {
                i2 = i3;
            }
            if (!z && !mo16162h()) {
                i = this.f8204q;
                i2 = this.f8205r;
            }
            this.f8189b.mo16215a(i, i2);
        }
    }

    /* renamed from: a */
    public void mo16148a(String str) {
        TextView textView = this.f8125M;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.f8126N;
        if (textView2 != null) {
            textView2.setText(str);
        }
    }

    /* renamed from: a */
    public void mo16141a(int i) {
        View view = this.f8132T;
        if (view == null || view.getVisibility() != 0) {
            UIUtils.m12059a((View) this.f8202o, 0);
            this.f8133U.setProgress(i);
            this.f8202o.setProgress(i);
            return;
        }
        UIUtils.m12059a((View) this.f8202o, 8);
    }

    /* renamed from: a */
    public void mo16143a(long j, long j2) {
        this.f8134V.setText(MediaHelper.m10403a(j2));
        this.f8135W.setText(MediaHelper.m10403a(j));
        this.f8133U.setProgress(MediaHelper.m10402a(j, j2));
    }

    /* renamed from: d */
    public void mo16158d() {
        UIUtils.m12088e(this.f8191d);
        UIUtils.m12088e(this.f8192e);
        UIUtils.m12086d(this.f8129Q);
        if (!(this.f8193f == null || this.f8212y == null || this.f8212y.mo15512z() == null || this.f8212y.mo15512z().mo15601f() == null)) {
            UIUtils.m12088e((View) this.f8193f);
            TTNetClient.m11428a(this.f8213z).mo16653a(this.f8212y.mo15512z().mo15601f(), this.f8193f);
        }
        if (this.f8190c.getVisibility() == 0) {
            UIUtils.m12059a((View) this.f8190c, 8);
        }
    }

    /* renamed from: e */
    public void mo16159e() {
        mo16150a(false, this.f8208u);
        mo16204v();
    }

    /* renamed from: a */
    public void mo16142a(long j) {
        this.f8135W.setText(MediaHelper.m10403a(j));
    }

    /* renamed from: a */
    public void mo16147a(MaterialMeta kVar, WeakReference<Context> weakReference, boolean z) {
        if (kVar != null) {
            mo16181a(this.f8188a, InternalContainer.m10059a());
            mo16150a(false, this.f8208u);
            UIUtils.m12059a(this.f8195h, 0);
            UIUtils.m12059a((View) this.f8196i, 0);
            UIUtils.m12059a(this.f8197j, 0);
            if (!(this.f8196i == null || this.f8212y == null || this.f8212y.mo15512z() == null || this.f8212y.mo15512z().mo15601f() == null)) {
                TTNetClient.m11428a(this.f8213z).mo16653a(this.f8212y.mo15512z().mo15601f(), this.f8196i);
            }
            String str = !TextUtils.isEmpty(kVar.mo15413A()) ? kVar.mo15413A() : !TextUtils.isEmpty(kVar.mo15422J()) ? kVar.mo15422J() : !TextUtils.isEmpty(kVar.mo15423K()) ? kVar.mo15423K() : "";
            if (this.f8212y != null && this.f8212y.mo15415C() != null && this.f8212y.mo15415C().mo15406a() != null) {
                UIUtils.m12059a((View) this.f8198k, 0);
                UIUtils.m12059a((View) this.f8199l, 4);
                if (this.f8198k != null) {
                    TTNetClient.m11428a(this.f8213z).mo16653a(this.f8212y.mo15415C().mo15406a(), (ImageView) this.f8198k);
                    this.f8198k.setOnClickListener(this.f8180F);
                    this.f8198k.setOnTouchListener(this.f8180F);
                }
            } else if (!TextUtils.isEmpty(str)) {
                UIUtils.m12059a((View) this.f8198k, 4);
                UIUtils.m12059a((View) this.f8199l, 0);
                if (this.f8199l != null) {
                    this.f8199l.setText(str.substring(0, 1));
                    this.f8199l.setOnClickListener(this.f8180F);
                    this.f8199l.setOnTouchListener(this.f8180F);
                }
            }
            if (this.f8200m != null && !TextUtils.isEmpty(str)) {
                this.f8200m.setText(str);
            }
            UIUtils.m12059a((View) this.f8200m, 0);
            UIUtils.m12059a((View) this.f8201n, 0);
            int B = kVar.mo15414B();
            String str2 = "tt_video_mobile_go_detail";
            String str3 = (B == 2 || B == 3) ? ResourceHelp.m11931a(this.f8213z, str2) : B != 4 ? B != 5 ? ResourceHelp.m11931a(this.f8213z, str2) : ResourceHelp.m11931a(this.f8213z, "tt_video_dial_phone") : ResourceHelp.m11931a(this.f8213z, "tt_video_download_apk");
            if (this.f8201n != null) {
                this.f8201n.setText(str3);
                this.f8201n.setOnClickListener(this.f8180F);
                this.f8201n.setOnTouchListener(this.f8180F);
            }
        }
    }

    /* renamed from: f */
    public void mo16160f() {
        UIUtils.m12086d(this.f8191d);
        UIUtils.m12086d(this.f8129Q);
    }

    /* renamed from: g */
    public void mo16161g() {
        this.f8133U.setProgress(0);
        this.f8133U.setSecondaryProgress(0);
        this.f8202o.setProgress(0);
        this.f8202o.setSecondaryProgress(0);
        String str = "tt_00_00";
        this.f8134V.setText(ResourceHelp.m11932b(this.f8213z, str));
        this.f8135W.setText(ResourceHelp.m11932b(this.f8213z, str));
        mo16157c(8);
        if (mo16206x()) {
            this.f8189b.setVisibility(8);
        }
        if (this.f8193f != null) {
            this.f8193f.setImageDrawable(null);
        }
        mo16157c(8);
        UIUtils.m12059a(this.f8132T, 8);
        UIUtils.m12059a(this.f8195h, 8);
        UIUtils.m12059a((View) this.f8196i, 8);
        UIUtils.m12059a(this.f8197j, 8);
        UIUtils.m12059a((View) this.f8198k, 8);
        UIUtils.m12059a((View) this.f8199l, 8);
        UIUtils.m12059a((View) this.f8200m, 8);
        if (this.f8175A != null) {
            this.f8175A.mo16321a(true);
        }
    }

    /* renamed from: h */
    public boolean mo16162h() {
        return this.f8138Z;
    }

    /* renamed from: i */
    public boolean mo16163i() {
        return this.f8208u;
    }

    /* renamed from: a */
    public void mo16146a(ViewGroup viewGroup) {
        if (viewGroup != null && (this.f8188a.getLayoutParams() instanceof MarginLayoutParams)) {
            this.f8138Z = true;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f8188a.getLayoutParams();
            this.f8143ac = marginLayoutParams.leftMargin;
            this.f8142ab = marginLayoutParams.topMargin;
            this.f8144ad = marginLayoutParams.width;
            this.f8145ae = marginLayoutParams.height;
            marginLayoutParams.width = -1;
            marginLayoutParams.height = -1;
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.leftMargin = 0;
            this.f8188a.setLayoutParams(marginLayoutParams);
            LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                int[] rules = layoutParams2.getRules();
                this.f8146af = rules.length > 0 ? rules[3] : 0;
                layoutParams2.addRule(3, 0);
                viewGroup.setLayoutParams(layoutParams2);
            }
            if (layoutParams instanceof MarginLayoutParams) {
                MarginLayoutParams marginLayoutParams2 = (MarginLayoutParams) layoutParams;
                this.f8147ag.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                UIUtils.m12074b((View) viewGroup, 0, 0, 0, 0);
            }
            mo16149a(true);
            this.f8136X.setImageDrawable(ResourceHelp.m11933c(this.f8213z, "tt_shrink_video"));
            this.f8133U.setThumb(ResourceHelp.m11933c(this.f8213z, "tt_seek_thumb_fullscreen_selector"));
            this.f8133U.setThumbOffset(0);
            MediaHelper.m10404a(this.f8188a, false);
            m10619e(this.f8138Z);
            UIUtils.m12059a(this.f8124L, 8);
            if (!this.f8208u) {
                UIUtils.m12059a((View) this.f8123K, 8);
                UIUtils.m12059a((View) this.f8122J, 8);
            } else if (this.f8211x.contains(C2323a.hideCloseBtn)) {
                UIUtils.m12059a((View) this.f8123K, 8);
            }
        }
    }

    /* renamed from: b */
    public void mo16153b(ViewGroup viewGroup) {
        C2564t.m12226e("FullScreen", "Detail exitFullScreen.....");
        if (!(viewGroup == null || this.f8188a == null || !(this.f8188a.getLayoutParams() instanceof MarginLayoutParams))) {
            this.f8138Z = false;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f8188a.getLayoutParams();
            marginLayoutParams.width = this.f8144ad;
            marginLayoutParams.height = this.f8145ae;
            marginLayoutParams.leftMargin = this.f8143ac;
            marginLayoutParams.topMargin = this.f8142ab;
            this.f8188a.setLayoutParams(marginLayoutParams);
            LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.addRule(3, this.f8146af);
                viewGroup.setLayoutParams(layoutParams2);
            }
            if (layoutParams instanceof MarginLayoutParams) {
                UIUtils.m12074b((View) viewGroup, this.f8147ag.left, this.f8147ag.top, this.f8147ag.right, this.f8147ag.bottom);
            }
            mo16149a(true);
            this.f8136X.setImageDrawable(ResourceHelp.m11933c(this.f8213z, "tt_enlarge_video"));
            this.f8133U.setThumb(ResourceHelp.m11933c(this.f8213z, "tt_seek_thumb_normal"));
            this.f8133U.setThumbOffset(0);
            MediaHelper.m10404a(this.f8188a, true);
            m10619e(this.f8138Z);
            UIUtils.m12059a(this.f8124L, 8);
            if (this.f8211x.contains(C2323a.alwayShowBackBtn)) {
                UIUtils.m12059a((View) this.f8122J, 0);
            }
        }
    }

    /* renamed from: e */
    private void m10619e(boolean z) {
        if (z) {
            m10620y();
        } else {
            m10621z();
        }
    }

    /* renamed from: y */
    private void m10620y() {
        DisplayMetrics displayMetrics = this.f8213z.getResources().getDisplayMetrics();
        TextView textView = this.f8135W;
        String str = "tt_video_shaoow_color_fullscreen";
        String str2 = "tt_ssxinzi15";
        if (textView != null) {
            this.f8158ar = textView.getTextSize();
            this.f8135W.setTextSize(2, 14.0f);
            this.f8159as = this.f8135W.getTextColors();
            if (this.f8159as != null) {
                this.f8135W.setTextColor(ResourceHelp.m11939i(this.f8213z, str2));
            }
            this.f8160at = this.f8135W.getAlpha();
            this.f8135W.setAlpha(0.85f);
            this.f8135W.setShadowLayer(0.0f, UIUtils.m12048a(this.f8213z, 0.5f), UIUtils.m12048a(this.f8213z, 0.5f), ResourceHelp.m11939i(this.f8213z, str));
            LayoutParams layoutParams = this.f8135W.getLayoutParams();
            if (layoutParams instanceof MarginLayoutParams) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
                this.f8161au.set(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                UIUtils.m12074b((View) this.f8135W, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.f8161au.top, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), this.f8161au.bottom);
            }
        }
        TextView textView2 = this.f8134V;
        if (textView2 != null) {
            this.f8162av = textView2.getTextSize();
            this.f8134V.setTextSize(2, 14.0f);
            this.f8163aw = this.f8134V.getTextColors();
            if (this.f8163aw != null) {
                this.f8134V.setTextColor(ResourceHelp.m11939i(this.f8213z, str2));
            }
            this.f8164ax = this.f8134V.getAlpha();
            this.f8134V.setAlpha(0.85f);
            this.f8134V.setShadowLayer(0.0f, UIUtils.m12048a(this.f8213z, 0.5f), UIUtils.m12048a(this.f8213z, 0.5f), ResourceHelp.m11939i(this.f8213z, str));
            LayoutParams layoutParams2 = this.f8134V.getLayoutParams();
            if (layoutParams2 instanceof MarginLayoutParams) {
                MarginLayoutParams marginLayoutParams2 = (MarginLayoutParams) layoutParams2;
                this.f8165ay.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                UIUtils.m12074b((View) this.f8134V, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), this.f8165ay.top, this.f8165ay.right, this.f8165ay.bottom);
            }
        }
        ImageView imageView = this.f8136X;
        if (imageView != null) {
            LayoutParams layoutParams3 = imageView.getLayoutParams();
            if (layoutParams3 instanceof MarginLayoutParams) {
                MarginLayoutParams marginLayoutParams3 = (MarginLayoutParams) layoutParams3;
                this.f8166az.set(marginLayoutParams3.leftMargin, marginLayoutParams3.topMargin, marginLayoutParams3.rightMargin, marginLayoutParams3.bottomMargin);
                UIUtils.m12074b((View) this.f8136X, this.f8166az.left, this.f8166az.top, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.f8166az.bottom);
            }
        }
        ImageView imageView2 = this.f8136X;
        if (imageView2 != null) {
            imageView2.setImageDrawable(ResourceHelp.m11933c(this.f8213z, "tt_shrink_fullscreen"));
        }
        TextView textView3 = this.f8126N;
        if (textView3 != null) {
            this.f8148ah = textView3.getTextColors();
            if (this.f8148ah != null) {
                this.f8126N.setTextColor(ResourceHelp.m11939i(this.f8213z, str2));
            }
            this.f8149ai = this.f8126N.getAlpha();
            this.f8126N.setAlpha(0.85f);
            LayoutParams layoutParams4 = this.f8126N.getLayoutParams();
            if (layoutParams4 instanceof MarginLayoutParams) {
                MarginLayoutParams marginLayoutParams4 = (MarginLayoutParams) layoutParams4;
                this.f8150aj.set(marginLayoutParams4.leftMargin, marginLayoutParams4.topMargin, marginLayoutParams4.rightMargin, marginLayoutParams4.bottomMargin);
                UIUtils.m12074b((View) this.f8126N, (int) TypedValue.applyDimension(1, 1.0f, displayMetrics), this.f8165ay.top, this.f8165ay.right, this.f8165ay.bottom);
            }
        }
        View view = this.f8124L;
        if (view != null) {
            LayoutParams layoutParams5 = view.getLayoutParams();
            this.f8151ak = layoutParams5.height;
            layoutParams5.height = (int) TypedValue.applyDimension(1, 49.0f, displayMetrics);
            this.f8124L.setLayoutParams(layoutParams5);
            this.f8124L.setBackgroundResource(ResourceHelp.m11934d(this.f8213z, "tt_shadow_fullscreen_top"));
        }
        mo16190b(this.f8152al, true);
    }

    /* renamed from: z */
    private void m10621z() {
        TextView textView = this.f8135W;
        String str = "tt_video_shadow_color";
        if (textView != null) {
            textView.setTextSize(0, this.f8158ar);
            ColorStateList colorStateList = this.f8159as;
            if (colorStateList != null) {
                this.f8135W.setTextColor(colorStateList);
            }
            this.f8135W.setAlpha(this.f8160at);
            this.f8135W.setShadowLayer(UIUtils.m12048a(this.f8213z, 1.0f), 0.0f, 0.0f, ResourceHelp.m11939i(this.f8213z, str));
            UIUtils.m12074b((View) this.f8135W, this.f8161au.left, this.f8161au.top, this.f8161au.right, this.f8161au.bottom);
        }
        TextView textView2 = this.f8134V;
        if (textView2 != null) {
            textView2.setTextSize(0, this.f8162av);
            ColorStateList colorStateList2 = this.f8163aw;
            if (colorStateList2 != null) {
                this.f8134V.setTextColor(colorStateList2);
            }
            this.f8134V.setAlpha(this.f8164ax);
            this.f8134V.setShadowLayer(UIUtils.m12048a(this.f8213z, 1.0f), 0.0f, 0.0f, ResourceHelp.m11939i(this.f8213z, str));
            UIUtils.m12074b((View) this.f8134V, this.f8165ay.left, this.f8165ay.top, this.f8165ay.right, this.f8165ay.bottom);
        }
        ImageView imageView = this.f8136X;
        if (imageView != null) {
            UIUtils.m12074b((View) imageView, this.f8166az.left, this.f8166az.top, this.f8166az.right, this.f8166az.bottom);
        }
        ImageView imageView2 = this.f8136X;
        if (imageView2 != null) {
            imageView2.setImageDrawable(ResourceHelp.m11933c(this.f8213z, "tt_enlarge_video"));
        }
        TextView textView3 = this.f8126N;
        if (textView3 != null) {
            ColorStateList colorStateList3 = this.f8148ah;
            if (colorStateList3 != null) {
                textView3.setTextColor(colorStateList3);
            }
            this.f8126N.setAlpha(this.f8149ai);
            UIUtils.m12074b((View) this.f8126N, this.f8165ay.left, this.f8165ay.top, this.f8165ay.right, this.f8165ay.bottom);
        }
        View view = this.f8124L;
        if (view != null) {
            LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = this.f8151ak;
            this.f8124L.setLayoutParams(layoutParams);
            this.f8124L.setBackgroundResource(ResourceHelp.m11934d(this.f8213z, "tt_video_black_desc_gradient"));
        }
        mo16190b(this.f8152al, true);
    }

    /* renamed from: a */
    public void mo14813a(Message message) {
        if (message.what == 1) {
            mo16164j();
        }
    }

    /* renamed from: a */
    public void mo16151a(boolean z, boolean z2, boolean z3) {
        UIUtils.m12059a(this.f8132T, 0);
        UIUtils.m12059a((View) this.f8202o, 0);
        int i = 8;
        if (this.f8138Z) {
            UIUtils.m12059a(this.f8124L, 0);
            UIUtils.m12059a((View) this.f8126N, 0);
        } else if (z3) {
            UIUtils.m12059a(this.f8124L, 8);
        }
        ImageView imageView = this.f8190c;
        int i2 = (!z || this.f8191d.getVisibility() == 0) ? 8 : 0;
        UIUtils.m12059a((View) imageView, i2);
        if (!this.f8208u && !this.f8138Z) {
            if (!this.f8211x.contains(C2323a.hideCloseBtn) && !z3) {
                UIUtils.m12059a((View) this.f8123K, 0);
            }
            TextView textView = this.f8122J;
            if (!z3) {
                i = 0;
            }
            UIUtils.m12059a((View) textView, i);
        }
        UIUtils.m12059a((View) this.f8134V, 0);
        UIUtils.m12059a((View) this.f8135W, 0);
        UIUtils.m12059a((View) this.f8133U, 0);
    }

    /* renamed from: a */
    public void mo16150a(boolean z, boolean z2) {
        UIUtils.m12059a(this.f8132T, 8);
        UIUtils.m12059a(this.f8124L, 8);
        UIUtils.m12059a((View) this.f8202o, z ? 0 : 8);
        UIUtils.m12059a((View) this.f8190c, 8);
        if (!this.f8208u && !this.f8138Z) {
            UIUtils.m12059a((View) this.f8123K, 8);
            if (!this.f8211x.contains(C2323a.alwayShowBackBtn)) {
                UIUtils.m12059a((View) this.f8122J, 8);
            }
        } else if (this.f8211x.contains(C2323a.hideCloseBtn)) {
            UIUtils.m12059a((View) this.f8123K, 8);
        }
        if (z2) {
            UIUtils.m12059a((View) this.f8123K, 8);
            UIUtils.m12059a((View) this.f8122J, 8);
        }
        mo16154b(false);
    }

    /* renamed from: j */
    public void mo16164j() {
        mo16150a(true, false);
    }

    /* renamed from: b */
    public boolean mo16155b(int i) {
        SeekBar seekBar = this.f8133U;
        return seekBar != null && i > seekBar.getSecondaryProgress();
    }

    /* renamed from: b */
    public void mo16154b(boolean z) {
        if (this.f8125M != null) {
            int i = 8;
            if (this.f8208u) {
                UIUtils.m12059a((View) this.f8125M, 8);
                return;
            }
            TextView textView = this.f8125M;
            if (z) {
                i = 0;
            }
            UIUtils.m12059a((View) textView, i);
        }
    }

    /* renamed from: k */
    public boolean mo16165k() {
        return this.f8209v;
    }

    /* renamed from: c */
    public void mo16157c(int i) {
        this.f8210w = i;
        UIUtils.m12059a(this.f8188a, i);
        if (i != 0) {
            this.f8140aB = false;
        } else if (this.f8139aA) {
            this.f8140aB = true;
        }
    }

    /* renamed from: a */
    public void mo16145a(View view, boolean z) {
        if (mo16162h()) {
            String format = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
            if (this.f8212y != null && !TextUtils.isEmpty(this.f8212y.mo15422J())) {
                mo16148a(this.f8212y.mo15422J());
            }
            this.f8127O.setText(format);
        } else {
            String str = "";
            mo16148a(str);
            this.f8127O.setText(str);
        }
        if (!this.f8177C) {
            boolean z2 = false;
            boolean z3 = this.f8208u && !this.f8138Z;
            mo16154b(z3);
            if (mo16200r()) {
                INewMediaCallback dVar = this.f8176B;
                if (this.f8191d.getVisibility() != 0) {
                    z2 = true;
                }
                dVar.mo15958a(this, view, true, z2);
            }
        }
    }

    /* renamed from: l */
    public void mo16166l() {
        mo16164j();
        mo16154b(false);
    }

    /* renamed from: m */
    public boolean mo16167m() {
        return this.f8175A != null && this.f8175A.mo16322a();
    }
}
