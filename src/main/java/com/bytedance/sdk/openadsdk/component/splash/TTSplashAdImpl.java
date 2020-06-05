package com.bytedance.sdk.openadsdk.component.splash;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.EmptyView.C2202a;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ExpressClickCreativeListener;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ExpressClickListener;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.p167a.ClickCreativeListener;
import com.bytedance.sdk.openadsdk.core.p167a.ClickListener.C2203a;
import com.bytedance.sdk.openadsdk.core.p170d.Image;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.INativeVideoController.C2324a;
import com.bytedance.sdk.openadsdk.core.widget.TTCountdownView;
import com.bytedance.sdk.openadsdk.core.widget.TTCountdownView.C2354a;
import com.bytedance.sdk.openadsdk.downloadnew.TTDownloadFactory;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.p165c.AdEventManager;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.ImageBytesHelper;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.bytedance.sdk.openadsdk.utils.UIUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.bytedance.sdk.openadsdk.component.splash.e */
public class TTSplashAdImpl implements TTSplashAd {
    /* renamed from: a */
    public AtomicBoolean f7152a = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    /* renamed from: b */
    public int f7153b = 3;
    /* access modifiers changed from: private|final */
    /* renamed from: c */
    public final Context f7154c;
    /* access modifiers changed from: private|final */
    /* renamed from: d */
    public final MaterialMeta f7155d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public TsView f7156e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public AdInteractionListener f7157f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public boolean f7158g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public long f7159h = 0;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public ITTDownloadAdapter f7160i;
    /* access modifiers changed from: private */
    /* renamed from: j */
    public SplashVideoController f7161j;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public String f7162k = null;
    /* renamed from: l */
    private boolean f7163l = false;
    /* renamed from: m */
    private boolean f7164m = false;
    /* access modifiers changed from: private */
    /* renamed from: n */
    public boolean f7165n;
    /* access modifiers changed from: private */
    /* renamed from: o */
    public boolean f7166o = true;
    /* renamed from: p */
    private int f7167p = -1;
    /* access modifiers changed from: private */
    /* renamed from: q */
    public NativeExpressView f7168q;
    /* access modifiers changed from: private */
    /* renamed from: r */
    public String f7169r;
    /* renamed from: s */
    private AdSlot f7170s;
    /* access modifiers changed from: private */
    /* renamed from: t */
    public ExpressAdInteractionListener f7171t;
    /* access modifiers changed from: private */
    /* renamed from: u */
    public AtomicBoolean f7172u = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    /* renamed from: v */
    public AtomicBoolean f7173v = new AtomicBoolean(false);

    TTSplashAdImpl(Context context, MaterialMeta kVar, AdSlot adSlot, String str) {
        this.f7154c = context;
        this.f7155d = kVar;
        this.f7164m = kVar.mo15435W();
        this.f7170s = adSlot;
        this.f7169r = str;
        m9001b();
    }

    TTSplashAdImpl(Context context, MaterialMeta kVar, String str, AdSlot adSlot, String str2) {
        this.f7154c = context;
        this.f7155d = kVar;
        this.f7164m = kVar.mo15435W();
        this.f7162k = str;
        this.f7170s = adSlot;
        this.f7169r = str2;
        m9001b();
    }

    /* renamed from: b */
    private void m9001b() {
        this.f7156e = new TsView(this.f7154c);
        AdEventManager.m8392a(this.f7155d);
        if (this.f7155d.mo15512z() != null && this.f7164m) {
            this.f7156e.setVideoViewVisibility(0);
            this.f7156e.setImageViewVisibility(8);
            this.f7156e.setVoiceViewListener(new OnClickListener() {
                public void onClick(View view) {
                    int i;
                    if (TTSplashAdImpl.this.f7166o) {
                        i = ResourceHelp.m11934d(TTSplashAdImpl.this.f7154c, "tt_splash_unmute");
                    } else {
                        i = ResourceHelp.m11934d(TTSplashAdImpl.this.f7154c, "tt_splash_mute");
                    }
                    TTSplashAdImpl.this.f7156e.setVoiceViewImageResource(i);
                    TTSplashAdImpl eVar = TTSplashAdImpl.this;
                    eVar.f7166o = !eVar.f7166o;
                    if (TTSplashAdImpl.this.f7161j != null) {
                        TTSplashAdImpl.this.f7161j.mo15975c(TTSplashAdImpl.this.f7166o);
                    }
                }
            });
        }
        if (!this.f7164m) {
            this.f7156e.setVideoViewVisibility(8);
            this.f7156e.setImageViewVisibility(0);
        }
        if (this.f7155d.mo15482g() == 0) {
            TsView tsView = this.f7156e;
            if (tsView != null) {
                tsView.setAdlogoViewVisibility(8);
            }
        } else {
            TsView tsView2 = this.f7156e;
            if (tsView2 != null) {
                tsView2.setAdlogoViewVisibility(0);
            }
        }
        if (this.f7155d.mo15432T() <= 0) {
            m8994a(3);
        } else {
            this.f7153b = this.f7155d.mo15432T();
            m8994a(this.f7153b);
        }
        m9008e();
        m9006d();
    }

    /* renamed from: c */
    private boolean m9004c() {
        this.f7161j = new SplashVideoController(this.f7154c, this.f7156e.getVideoContainer(), this.f7155d);
        StringBuilder sb = new StringBuilder();
        sb.append("mVideoCachePath:");
        sb.append(this.f7162k);
        C2564t.m12226e("wzj", sb.toString());
        this.f7161j.mo15959a((C2324a) new C2324a() {
            /* renamed from: a */
            public void mo14912a(long j, int i) {
            }

            /* renamed from: a */
            public void mo14913a(long j, long j2) {
            }

            /* renamed from: b */
            public void mo14914b(long j, int i) {
            }

            /* renamed from: a */
            public void mo14911a() {
                if (TTSplashAdImpl.this.f7161j != null) {
                    TTSplashAdImpl.this.f7161j.mo15988l();
                }
                if (TTSplashAdImpl.this.f7157f != null) {
                    TTSplashAdImpl.this.f7157f.onAdTimeOver();
                }
            }
        });
        boolean a = this.f7161j.mo15965a(this.f7162k, this.f7155d.mo15425M(), this.f7156e.getVideoContainer().getWidth(), this.f7156e.getVideoContainer().getHeight(), null, this.f7155d.mo15428P(), 0, this.f7166o);
        this.f7165n = a;
        return a;
    }

    public void renderExpressAd(ExpressAdInteractionListener expressAdInteractionListener) {
        if (expressAdInteractionListener != null) {
            NativeExpressView nativeExpressView = this.f7168q;
            if (nativeExpressView != null) {
                this.f7171t = expressAdInteractionListener;
                nativeExpressView.mo15878h();
            }
        }
    }

    /* renamed from: d */
    private void m9006d() {
        MaterialMeta kVar = this.f7155d;
        if (!(kVar == null || kVar.mo15510x() == null)) {
            if (this.f7155d.mo15512z() == null) {
                this.f7168q = new NativeExpressView(this.f7154c, this.f7155d, this.f7170s, this.f7169r);
            } else if (!TextUtils.isEmpty(this.f7162k)) {
                this.f7168q = new NativeExpressVideoView(this.f7154c, this.f7155d, this.f7170s, this.f7169r);
            }
            NativeExpressView nativeExpressView = this.f7168q;
            if (nativeExpressView != null) {
                m8996a(nativeExpressView, this.f7155d);
                this.f7168q.setExpressInteractionListener(new ExpressAdInteractionListener() {
                    public void onAdShow(View view, int i) {
                    }

                    public void onAdClicked(View view, int i) {
                        if (TTSplashAdImpl.this.f7171t != null) {
                            TTSplashAdImpl.this.f7171t.onAdClicked(view, i);
                        }
                        if (TTSplashAdImpl.this.f7157f != null) {
                            TTSplashAdImpl.this.f7157f.onAdClicked(view, i);
                        }
                        if (i != 4 && i != -1) {
                            TTCountdownView countDownView = TTSplashAdImpl.this.f7156e.getCountDownView();
                            if (countDownView != null) {
                                countDownView.setCountdownListener(null);
                                if (!TTSplashAdImpl.this.f7166o) {
                                    TTSplashAdImpl.this.f7156e.setVoiceViewImageResource(ResourceHelp.m11934d(TTSplashAdImpl.this.f7154c, "tt_splash_mute"));
                                    TTSplashAdImpl eVar = TTSplashAdImpl.this;
                                    eVar.f7166o = !eVar.f7166o;
                                }
                            }
                            TTSplashAdImpl.this.f7153b = 0;
                        }
                    }

                    public void onRenderFail(View view, String str, int i) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("onRenderFail:");
                        sb.append(str);
                        C2564t.m12226e("splash", sb.toString());
                        if (TTSplashAdImpl.this.f7171t != null) {
                            TTSplashAdImpl.this.f7171t.onRenderFail(view, str, i);
                        }
                    }

                    public void onRenderSuccess(View view, float f, float f2) {
                        if (view != null && f > 0.0f && f2 > 0.0f && !TTSplashAdImpl.this.f7172u.get()) {
                            TTSplashAdImpl.this.f7156e.setExpressView(TTSplashAdImpl.this.f7168q);
                            if (TTSplashAdImpl.this.f7171t != null) {
                                TTSplashAdImpl.this.f7171t.onRenderSuccess(view, f, f2);
                            }
                            TTSplashAdImpl.this.f7173v.set(true);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: a */
    private void m8996a(NativeExpressView nativeExpressView, MaterialMeta kVar) {
        this.f7160i = m8993a(kVar);
        ITTDownloadAdapter aVar = this.f7160i;
        if (aVar != null) {
            aVar.mo16513b();
            if (nativeExpressView.getContext() != null && (nativeExpressView.getContext() instanceof Activity)) {
                this.f7160i.mo16507a((Activity) nativeExpressView.getContext());
            }
        }
        AdEventManager.m8392a(kVar);
        EmptyView emptyView = new EmptyView(this.f7154c, nativeExpressView);
        ITTDownloadAdapter aVar2 = this.f7160i;
        if (aVar2 != null) {
            aVar2.mo16508a((View) emptyView);
        }
        emptyView.setCallback(new C2202a() {
            /* renamed from: a */
            public void mo14918a(boolean z) {
                if (TTSplashAdImpl.this.f7160i == null) {
                    return;
                }
                if (z) {
                    if (TTSplashAdImpl.this.f7160i != null) {
                        TTSplashAdImpl.this.f7160i.mo16513b();
                    }
                } else if (TTSplashAdImpl.this.f7160i != null) {
                    TTSplashAdImpl.this.f7160i.mo16516c();
                }
            }

            /* renamed from: a */
            public void mo14916a() {
                if (TTSplashAdImpl.this.f7160i != null) {
                    TTSplashAdImpl.this.f7160i.mo16504a();
                }
            }

            /* renamed from: b */
            public void mo14919b() {
                if (TTSplashAdImpl.this.f7160i != null) {
                    TTSplashAdImpl.this.f7160i.mo16518d();
                }
            }

            /* renamed from: a */
            public void mo14917a(View view) {
                if (TTSplashAdImpl.this.f7168q != null) {
                    TTSplashAdImpl.this.f7168q.mo15872g();
                }
            }
        });
        HashMap hashMap = new HashMap();
        hashMap.put("splash_show_type", Integer.valueOf(3));
        Context context = this.f7154c;
        String str = this.f7169r;
        ExpressClickListener eVar = new ExpressClickListener(context, kVar, str, ToolUtils.m11991a(str));
        eVar.mo15277a((View) nativeExpressView);
        eVar.mo15283a(this.f7160i);
        eVar.mo15284a((Map<String, Object>) hashMap);
        this.f7168q.setClickListener(eVar);
        Context context2 = this.f7154c;
        String str2 = this.f7169r;
        ExpressClickCreativeListener dVar = new ExpressClickCreativeListener(context2, kVar, str2, ToolUtils.m11991a(str2));
        dVar.mo15277a((View) nativeExpressView);
        dVar.mo15283a(this.f7160i);
        dVar.mo15284a((Map<String, Object>) hashMap);
        this.f7168q.setClickCreativeListener(dVar);
        emptyView.setNeedCheckingShow(true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo15251a(byte[] bArr) {
        if (m9002b(bArr)) {
            this.f7156e.setGifView(bArr);
        } else if (this.f7155d.mo15418F() != null && this.f7155d.mo15418F().get(0) != null) {
            this.f7156e.setDrawable(ImageBytesHelper.m12183a(bArr, ((Image) this.f7155d.mo15418F().get(0)).mo15409b()));
        }
    }

    /* renamed from: b */
    private boolean m9002b(byte[] bArr) {
        return bArr != null && bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70;
    }

    /* renamed from: e */
    private void m9008e() {
        if (this.f7155d.mo15512z() == null) {
            this.f7167p = 0;
        } else if (this.f7162k != null) {
            this.f7167p = 1;
        } else {
            this.f7167p = 2;
        }
        this.f7160i = m8993a(this.f7155d);
        EmptyView emptyView = new EmptyView(this.f7154c, this.f7156e);
        emptyView.setAdType(3);
        this.f7156e.addView(emptyView);
        ITTDownloadAdapter aVar = this.f7160i;
        if (aVar != null) {
            aVar.mo16508a((View) emptyView);
        }
        emptyView.setCallback(new C2202a() {
            /* renamed from: a */
            public void mo14918a(boolean z) {
                if (TTSplashAdImpl.this.f7160i == null) {
                    return;
                }
                if (z) {
                    TTSplashAdImpl.this.f7160i.mo16513b();
                } else {
                    TTSplashAdImpl.this.f7160i.mo16516c();
                }
            }

            /* renamed from: a */
            public void mo14916a() {
                TTSplashAdImpl.this.f7172u.set(true);
                if (TTSplashAdImpl.this.f7160i != null) {
                    TTSplashAdImpl.this.f7160i.mo16504a();
                }
                if (TTSplashAdImpl.this.f7160i != null && TTSplashAdImpl.this.f7156e != null && TTSplashAdImpl.this.f7156e.getParent() != null) {
                    Context context = null;
                    try {
                        context = ((View) TTSplashAdImpl.this.f7156e.getParent()).getContext();
                    } catch (Exception unused) {
                    }
                    if (context != null && (context instanceof Activity)) {
                        TTSplashAdImpl.this.f7160i.mo16507a((Activity) context);
                    }
                }
            }

            /* renamed from: b */
            public void mo14919b() {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    public void run() {
                        if (TTSplashAdImpl.this.f7160i != null) {
                            TTSplashAdImpl.this.f7160i.mo16518d();
                        }
                    }
                }, 1000);
            }

            /* renamed from: a */
            public void mo14917a(View view) {
                TTSplashAdImpl.this.f7172u.set(true);
                TTSplashAdImpl.this.f7159h = System.currentTimeMillis();
                HashMap hashMap = new HashMap();
                String str = "splash_show_type";
                if (TTSplashAdImpl.this.f7155d != null) {
                    if (TTSplashAdImpl.this.f7155d.mo15512z() == null) {
                        hashMap.put(str, Integer.valueOf(0));
                    } else if (TTSplashAdImpl.this.f7162k != null) {
                        hashMap.put(str, Integer.valueOf(1));
                    } else {
                        hashMap.put(str, Integer.valueOf(2));
                    }
                }
                if (TTSplashAdImpl.this.f7173v.get()) {
                    hashMap.put(str, Integer.valueOf(3));
                    if (!TTSplashAdImpl.this.f7152a.getAndSet(true) && TTSplashAdImpl.this.f7168q != null) {
                        UIUtils.m12056a(TTSplashAdImpl.this.f7154c, TTSplashAdImpl.this.f7155d, TTSplashAdImpl.this.f7169r, (WebView) TTSplashAdImpl.this.f7168q.getWebView());
                    }
                }
                AdEventManager.m8389a(TTSplashAdImpl.this.f7154c, TTSplashAdImpl.this.f7155d, TTSplashAdImpl.this.f7169r, (Map<String, Object>) hashMap);
                if (!TTSplashAdImpl.this.f7158g && TTSplashAdImpl.this.f7156e != null) {
                    TTCountdownView countDownView = TTSplashAdImpl.this.f7156e.getCountDownView();
                    if (countDownView != null) {
                        countDownView.setCountdownListener(new C2354a() {
                            /* renamed from: a */
                            public void mo15255a() {
                            }

                            /* renamed from: b */
                            public void mo15256b() {
                                if (TTSplashAdImpl.this.f7157f != null) {
                                    TTSplashAdImpl.this.f7157f.onAdTimeOver();
                                }
                                try {
                                    if (TTSplashAdImpl.this.f7161j != null) {
                                        if (TTSplashAdImpl.this.f7161j.mo16002z()) {
                                            TTSplashAdImpl.this.f7161j.mo15975c(true);
                                        }
                                        if (!TTSplashAdImpl.this.f7173v.get()) {
                                            TTSplashAdImpl.this.f7161j.mo15108b();
                                        }
                                        TTSplashAdImpl.this.f7161j.mo15988l();
                                    }
                                } catch (Throwable unused) {
                                }
                            }
                        });
                        countDownView.mo16250a();
                    }
                }
                if (TTSplashAdImpl.this.f7157f != null) {
                    TTSplashAdImpl.this.f7157f.onAdShow(TTSplashAdImpl.this.f7156e, TTSplashAdImpl.this.f7155d.mo15414B());
                }
                if (TTSplashAdImpl.this.f7155d.mo15433U()) {
                    ToolUtils.m12001a(TTSplashAdImpl.this.f7155d, view);
                }
                C2564t.m12220b("TTSplashAdImpl", "bindViewInteraction 开屏广告展示");
            }
        });
        emptyView.setNeedCheckingShow(true);
        HashMap hashMap = new HashMap();
        hashMap.put("splash_show_type", Integer.valueOf(this.f7167p));
        ClickCreativeListener aVar2 = new ClickCreativeListener(this.f7154c, this.f7155d, this.f7169r, 4);
        aVar2.mo15284a((Map<String, Object>) hashMap);
        aVar2.mo15277a((View) this.f7156e);
        aVar2.mo15286b(this.f7156e.getDislikeView());
        aVar2.mo15283a(this.f7160i);
        aVar2.mo15280a((C2203a) new C2203a() {
            /* renamed from: a */
            public void mo15083a(View view, int i) {
                if (TTSplashAdImpl.this.f7157f != null) {
                    TTSplashAdImpl.this.f7157f.onAdClicked(view, i);
                }
                if (i != 4 && i != -1) {
                    TTCountdownView countDownView = TTSplashAdImpl.this.f7156e.getCountDownView();
                    if (countDownView != null) {
                        countDownView.setCountdownListener(null);
                        if (TTSplashAdImpl.this.f7161j != null && !TTSplashAdImpl.this.f7166o) {
                            TTSplashAdImpl.this.f7156e.setVoiceViewImageResource(ResourceHelp.m11934d(TTSplashAdImpl.this.f7154c, "tt_splash_mute"));
                            TTSplashAdImpl eVar = TTSplashAdImpl.this;
                            eVar.f7166o = !eVar.f7166o;
                            TTSplashAdImpl.this.f7161j.mo15975c(true);
                        }
                    }
                    TTSplashAdImpl.this.f7153b = 0;
                }
            }
        });
        this.f7156e.setOnClickListenerInternal(aVar2);
        this.f7156e.setOnTouchListenerInternal(aVar2);
        this.f7156e.setSkipListener(new OnClickListener() {
            public void onClick(View view) {
                if (!(TTSplashAdImpl.this.f7155d == null || TTSplashAdImpl.this.f7155d.mo15512z() == null || !TTSplashAdImpl.this.f7165n || TTSplashAdImpl.this.f7161j == null)) {
                    TTSplashAdImpl.this.f7161j.mo15988l();
                    if (!TTSplashAdImpl.this.f7173v.get()) {
                        TTSplashAdImpl eVar = TTSplashAdImpl.this;
                        eVar.m8997a(eVar.f7169r, "feed_break");
                    }
                }
                if (!TextUtils.isEmpty(TTSplashAdImpl.this.f7155d.mo15428P())) {
                    long j = 0;
                    if (TTSplashAdImpl.this.f7159h > 0) {
                        j = System.currentTimeMillis() - TTSplashAdImpl.this.f7159h;
                    }
                    AdEventManager.m8379a(TTSplashAdImpl.this.f7154c, j, TTSplashAdImpl.this.f7155d);
                }
                if (TTSplashAdImpl.this.f7157f != null) {
                    TTSplashAdImpl.this.f7153b = 0;
                    TTSplashAdImpl.this.f7157f.onAdSkip();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8997a(String str, String str2) {
        SplashVideoController dVar = this.f7161j;
        if (dVar != null) {
            String str3 = str;
            String str4 = str2;
            AdEventManager.m8386a(this.f7154c, this.f7155d, str3, str4, this.f7161j.mo15991o(), this.f7161j.mo15993q(), ToolUtils.m11997a(this.f7155d, dVar.mo15990n(), this.f7161j.mo15996t()));
        }
    }

    public View getSplashView() {
        MaterialMeta kVar = this.f7155d;
        if (kVar == null || kVar.mo15512z() == null || this.f7156e.getVideoContainer() == null || this.f7162k == null || m9004c()) {
            return this.f7156e;
        }
        return null;
    }

    public int getInteractionType() {
        MaterialMeta kVar = this.f7155d;
        if (kVar == null) {
            return -1;
        }
        return kVar.mo15414B();
    }

    public void setSplashInteractionListener(AdInteractionListener adInteractionListener) {
        this.f7157f = adInteractionListener;
    }

    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        ITTDownloadAdapter aVar = this.f7160i;
        if (aVar != null) {
            aVar.mo16509a(tTAppDownloadListener);
        }
    }

    /* renamed from: a */
    private ITTDownloadAdapter m8993a(MaterialMeta kVar) {
        if (kVar.mo15414B() == 4) {
            return TTDownloadFactory.m11071a(this.f7154c, kVar, this.f7169r);
        }
        return null;
    }

    public void setNotAllowSdkCountdown() {
        this.f7158g = true;
        TsView tsView = this.f7156e;
        if (tsView != null) {
            tsView.setSkipIconVisibility(8);
        }
    }

    public Map<String, Object> getMediaExtraInfo() {
        MaterialMeta kVar = this.f7155d;
        if (kVar != null) {
            return kVar.mo15436X();
        }
        return null;
    }

    /* renamed from: a */
    public boolean mo15252a() {
        MaterialMeta kVar = this.f7155d;
        if (kVar == null || kVar.mo15510x() == null) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private void m8994a(int i) {
        TsView tsView = this.f7156e;
        if (tsView != null) {
            tsView.setCountDownTime(i);
        }
    }
}
