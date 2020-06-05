package com.bytedance.sdk.openadsdk.component.banner;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTBannerAd;
import com.bytedance.sdk.openadsdk.TTBannerAd.AdInteractionListener;
import com.bytedance.sdk.openadsdk.component.banner.BannerAdManager.C2105a;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.EmptyView.C2202a;
import com.bytedance.sdk.openadsdk.core.p167a.ClickCreativeListener;
import com.bytedance.sdk.openadsdk.core.p167a.ClickListener.C2203a;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.dislike.TTAdDislikeImpl;
import com.bytedance.sdk.openadsdk.downloadnew.TTDownloadFactory;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.p165c.AdEventManager;
import com.bytedance.sdk.openadsdk.utils.C2538ak;
import com.bytedance.sdk.openadsdk.utils.C2538ak.C2539a;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.tencent.bugly.BuglyStrategy.C7120a;
import discoveryAD.C7895e;
import java.util.Map;

/* renamed from: com.bytedance.sdk.openadsdk.component.banner.e */
public class TTBannerAdImpl implements TTBannerAd, C2539a {
    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final BannerView f6868a;
    /* renamed from: b */
    private final BannerAdInfo f6869b;
    /* access modifiers changed from: private|final */
    /* renamed from: c */
    public final Context f6870c;
    /* renamed from: d */
    private C2538ak f6871d;
    /* renamed from: e */
    private int f6872e;
    /* renamed from: f */
    private MaterialMeta f6873f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public AdInteractionListener f6874g;
    /* renamed from: h */
    private TTAppDownloadListener f6875h;
    /* renamed from: i */
    private TTAdDislikeImpl f6876i;
    /* renamed from: j */
    private final BannerAdManager f6877j;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public ITTDownloadAdapter f6878k;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public String f6879l = "banner_ad";
    /* renamed from: m */
    private AdSlot f6880m;

    public TTBannerAdImpl(Context context, BannerAdInfo aVar, AdSlot adSlot) {
        this.f6870c = context;
        this.f6869b = aVar;
        this.f6880m = adSlot;
        this.f6873f = aVar.mo15055b();
        this.f6868a = new BannerView(context);
        this.f6877j = BannerAdManager.m8563a(this.f6870c);
        m8613a(this.f6868a.mo15072b(), aVar);
    }

    public View getBannerView() {
        return this.f6868a;
    }

    public void setBannerInteractionListener(AdInteractionListener adInteractionListener) {
        this.f6874g = adInteractionListener;
    }

    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        this.f6875h = tTAppDownloadListener;
        ITTDownloadAdapter aVar = this.f6878k;
        if (aVar != null) {
            aVar.mo16509a(this.f6875h);
        }
    }

    public int getInteractionType() {
        MaterialMeta kVar = this.f6873f;
        if (kVar == null) {
            return -1;
        }
        return kVar.mo15414B();
    }

    public TTAdDislike getDislikeDialog(DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback == null) {
            return null;
        }
        m8618b(dislikeInteractionCallback);
        return this.f6876i;
    }

    public void setShowDislikeIcon(DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback != null) {
            m8611a(dislikeInteractionCallback);
        }
    }

    public void setSlideIntervalTime(int i) {
        if (i > 0) {
            this.f6879l = "slide_banner_ad";
            m8613a(this.f6868a.mo15072b(), this.f6869b);
            this.f6868a.mo15064a();
            this.f6868a.mo15065a(1000);
            if (i < 30000) {
                i = C7120a.MAX_USERDATA_VALUE_LENGTH;
            } else if (i > 120000) {
                i = C7895e.f26888Cc;
            }
            this.f6872e = i;
            this.f6871d = new C2538ak(Looper.getMainLooper(), this);
        }
    }

    public Map<String, Object> getMediaExtraInfo() {
        MaterialMeta kVar = this.f6873f;
        if (kVar != null) {
            return kVar.mo15436X();
        }
        return null;
    }

    /* renamed from: a */
    private void m8611a(DislikeInteractionCallback dislikeInteractionCallback) {
        m8618b(dislikeInteractionCallback);
        this.f6868a.mo15066a(this.f6876i);
    }

    /* renamed from: b */
    private void m8618b(DislikeInteractionCallback dislikeInteractionCallback) {
        if (this.f6876i == null) {
            this.f6876i = new TTAdDislikeImpl(this.f6870c, this.f6873f);
        }
        this.f6876i.setDislikeInteractionCallback(dislikeInteractionCallback);
    }

    /* renamed from: a */
    public void mo14813a(Message message) {
        if (message.what == 1) {
            m8610a();
        }
    }

    /* renamed from: a */
    private void m8610a() {
        this.f6877j.mo15057a(this.f6880m, (C2105a) new C2105a() {
            /* renamed from: a */
            public void mo15059a(BannerAdInfo aVar) {
                TTBannerAdImpl.this.m8612a(aVar);
                TTBannerAdImpl.this.f6868a.mo15075e();
                TTBannerAdImpl.this.m8617b();
            }

            /* renamed from: a */
            public void mo15058a() {
                TTBannerAdImpl.this.m8617b();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8617b() {
        C2538ak akVar = this.f6871d;
        if (akVar != null) {
            akVar.removeCallbacksAndMessages(null);
            this.f6871d.sendEmptyMessageDelayed(1, (long) this.f6872e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m8619c() {
        C2538ak akVar = this.f6871d;
        if (akVar != null) {
            akVar.removeCallbacksAndMessages(null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8612a(BannerAdInfo aVar) {
        if (this.f6868a.mo15073c() != null && !this.f6868a.mo15076f()) {
            m8613a(this.f6868a.mo15073c(), aVar);
        }
    }

    /* renamed from: a */
    private ITTDownloadAdapter m8609a(MaterialMeta kVar) {
        if (kVar.mo15414B() == 4) {
            return TTDownloadFactory.m11071a(this.f6870c, kVar, this.f6879l);
        }
        return null;
    }

    /* renamed from: a */
    private void m8613a(BannerCellView cVar, BannerAdInfo aVar) {
        cVar.mo15061a(aVar.mo15054a());
        final MaterialMeta b = aVar.mo15055b();
        this.f6873f = b;
        this.f6876i = new TTAdDislikeImpl(this.f6870c, this.f6873f);
        cVar.mo15062a(b);
        this.f6878k = m8609a(b);
        ITTDownloadAdapter aVar2 = this.f6878k;
        if (aVar2 != null) {
            aVar2.mo16513b();
            if (cVar.getContext() != null && (cVar.getContext() instanceof Activity)) {
                this.f6878k.mo16507a((Activity) cVar.getContext());
            }
        }
        AdEventManager.m8392a(b);
        EmptyView a = m8608a((ViewGroup) cVar);
        if (a == null) {
            a = new EmptyView(this.f6870c, cVar);
            cVar.addView(a);
        }
        ITTDownloadAdapter aVar3 = this.f6878k;
        if (aVar3 != null) {
            aVar3.mo16508a((View) a);
        }
        a.setCallback(new C2202a() {
            /* renamed from: a */
            public void mo14918a(boolean z) {
                if (TTBannerAdImpl.this.f6878k != null) {
                    if (z) {
                        if (TTBannerAdImpl.this.f6878k != null) {
                            TTBannerAdImpl.this.f6878k.mo16513b();
                        }
                    } else if (TTBannerAdImpl.this.f6878k != null) {
                        TTBannerAdImpl.this.f6878k.mo16516c();
                    }
                }
                String str = "TTBannerAd";
                if (z) {
                    TTBannerAdImpl.this.m8617b();
                    C2564t.m12220b(str, "获得焦点，开始计时");
                    return;
                }
                C2564t.m12220b(str, "失去焦点，停止计时");
                TTBannerAdImpl.this.m8619c();
            }

            /* renamed from: a */
            public void mo14916a() {
                if (TTBannerAdImpl.this.f6878k != null) {
                    TTBannerAdImpl.this.f6878k.mo16504a();
                }
            }

            /* renamed from: b */
            public void mo14919b() {
                TTBannerAdImpl.this.m8619c();
                if (TTBannerAdImpl.this.f6878k != null) {
                    TTBannerAdImpl.this.f6878k.mo16518d();
                }
            }

            /* renamed from: a */
            public void mo14917a(View view) {
                TTBannerAdImpl.this.m8617b();
                C2564t.m12220b("TTBannerAd", "BANNER SHOW");
                AdEventManager.m8389a(TTBannerAdImpl.this.f6870c, b, TTBannerAdImpl.this.f6879l, null);
                if (TTBannerAdImpl.this.f6874g != null) {
                    TTBannerAdImpl.this.f6874g.onAdShow(view, b.mo15414B());
                }
                if (b.mo15433U()) {
                    ToolUtils.m12001a(b, view);
                }
            }
        });
        ClickCreativeListener aVar4 = new ClickCreativeListener(this.f6870c, b, this.f6879l, 2);
        aVar4.mo15277a((View) cVar);
        aVar4.mo15286b(this.f6868a.mo15074d());
        aVar4.mo15283a(this.f6878k);
        aVar4.mo15280a((C2203a) new C2203a() {
            /* renamed from: a */
            public void mo15083a(View view, int i) {
                if (TTBannerAdImpl.this.f6874g != null) {
                    TTBannerAdImpl.this.f6874g.onAdClicked(view, i);
                }
            }
        });
        cVar.setOnClickListener(aVar4);
        cVar.setOnTouchListener(aVar4);
        ITTDownloadAdapter aVar5 = this.f6878k;
        if (aVar5 != null) {
            aVar5.mo16509a(this.f6875h);
        }
        a.setNeedCheckingShow(true);
    }

    /* renamed from: a */
    private EmptyView m8608a(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }
}
