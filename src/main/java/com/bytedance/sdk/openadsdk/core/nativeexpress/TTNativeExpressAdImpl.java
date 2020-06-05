package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd.AdInteractionListener;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.EmptyView.C2202a;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.dislike.TTAdDislikeImpl;
import com.bytedance.sdk.openadsdk.downloadnew.TTDownloadFactory;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.p165c.AdEventManager;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.bytedance.sdk.openadsdk.utils.UIUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.bytedance.sdk.openadsdk.core.nativeexpress.k */
public class TTNativeExpressAdImpl extends TTNativeExpressAdStub {
    /* renamed from: a */
    protected NativeExpressView f7850a;
    /* renamed from: b */
    protected final Context f7851b;
    /* renamed from: c */
    protected MaterialMeta f7852c;
    /* renamed from: d */
    protected String f7853d = "embeded_ad";
    /* access modifiers changed from: private */
    /* renamed from: f */
    public ExpressAdInteractionListener f7854f;
    /* renamed from: g */
    private TTAppDownloadListener f7855g;
    /* renamed from: h */
    private DislikeInteractionCallback f7856h;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public TTAdDislikeImpl f7857i;
    /* access modifiers changed from: private */
    /* renamed from: j */
    public TTDislikeDialogAbstract f7858j;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public ITTDownloadAdapter f7859k;

    public TTNativeExpressAdImpl(Context context, MaterialMeta kVar, AdSlot adSlot) {
        this.f7851b = context;
        this.f7852c = kVar;
        mo15911a(context, kVar, adSlot);
    }

    /* renamed from: a */
    public void mo15911a(Context context, MaterialMeta kVar, AdSlot adSlot) {
        this.f7850a = new NativeExpressView(context, kVar, adSlot, this.f7853d);
        mo15912a(this.f7850a, this.f7852c);
    }

    public View getExpressAdView() {
        return this.f7850a;
    }

    public int getImageMode() {
        MaterialMeta kVar = this.f7852c;
        if (kVar == null) {
            return -1;
        }
        return kVar.mo15429Q();
    }

    public List<FilterWord> getFilterWords() {
        MaterialMeta kVar = this.f7852c;
        if (kVar == null) {
            return null;
        }
        return kVar.mo15430R();
    }

    public void setExpressInteractionListener(ExpressAdInteractionListener expressAdInteractionListener) {
        this.f7854f = expressAdInteractionListener;
        this.f7850a.setExpressInteractionListener(expressAdInteractionListener);
    }

    public void setExpressInteractionListener(AdInteractionListener adInteractionListener) {
        this.f7854f = adInteractionListener;
        this.f7850a.setExpressInteractionListener(adInteractionListener);
    }

    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        this.f7855g = tTAppDownloadListener;
        ITTDownloadAdapter aVar = this.f7859k;
        if (aVar != null) {
            aVar.mo16509a(this.f7855g);
        }
    }

    public Map<String, Object> getMediaExtraInfo() {
        MaterialMeta kVar = this.f7852c;
        if (kVar != null) {
            return kVar.mo15436X();
        }
        return null;
    }

    public int getInteractionType() {
        MaterialMeta kVar = this.f7852c;
        if (kVar == null) {
            return -1;
        }
        return kVar.mo15414B();
    }

    public void render() {
        this.f7850a.mo15878h();
    }

    public void destroy() {
        NativeExpressView nativeExpressView = this.f7850a;
        if (nativeExpressView != null) {
            nativeExpressView.mo15881k();
        }
    }

    public void setDislikeCallback(Activity activity, DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback != null && activity != null) {
            this.f7856h = dislikeInteractionCallback;
            m10046a(activity, dislikeInteractionCallback);
        }
    }

    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        if (tTDislikeDialogAbstract == null) {
            C2564t.m12219b("dialog is null, please check");
            return;
        }
        this.f7858j = tTDislikeDialogAbstract;
        tTDislikeDialogAbstract.setMaterialMeta(this.f7852c);
        NativeExpressView nativeExpressView = this.f7850a;
        if (nativeExpressView != null) {
            nativeExpressView.setOuterDislike(tTDislikeDialogAbstract);
        }
    }

    /* renamed from: a */
    private void m10046a(Activity activity, DislikeInteractionCallback dislikeInteractionCallback) {
        if (this.f7857i == null) {
            this.f7857i = new TTAdDislikeImpl(activity, this.f7852c);
        }
        this.f7857i.setDislikeInteractionCallback(dislikeInteractionCallback);
        NativeExpressView nativeExpressView = this.f7850a;
        if (nativeExpressView != null) {
            nativeExpressView.setDislike(this.f7857i);
        }
    }

    /* renamed from: a */
    private ITTDownloadAdapter m10044a(MaterialMeta kVar) {
        if (kVar.mo15414B() == 4) {
            return TTDownloadFactory.m11071a(this.f7851b, kVar, this.f7853d);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo15912a(NativeExpressView nativeExpressView, final MaterialMeta kVar) {
        this.f7852c = kVar;
        nativeExpressView.setBackupListener(new ExpressBackupListener() {
            /* renamed from: a */
            public boolean mo15189a(NativeExpressView nativeExpressView, int i) {
                nativeExpressView.mo15882l();
                FeedExpressBackupView hVar = new FeedExpressBackupView(nativeExpressView.getContext());
                hVar.mo15903a(TTNativeExpressAdImpl.this.f7852c, nativeExpressView, TTNativeExpressAdImpl.this.f7859k);
                hVar.setDislikeInner(TTNativeExpressAdImpl.this.f7857i);
                hVar.setDislikeOuter(TTNativeExpressAdImpl.this.f7858j);
                return true;
            }
        });
        this.f7859k = m10044a(kVar);
        ITTDownloadAdapter aVar = this.f7859k;
        if (aVar != null) {
            aVar.mo16513b();
            if (nativeExpressView.getContext() != null && (nativeExpressView.getContext() instanceof Activity)) {
                this.f7859k.mo16507a((Activity) nativeExpressView.getContext());
            }
        }
        AdEventManager.m8392a(kVar);
        EmptyView a = m10043a((ViewGroup) nativeExpressView);
        if (a == null) {
            a = new EmptyView(this.f7851b, nativeExpressView);
            nativeExpressView.addView(a);
        }
        ITTDownloadAdapter aVar2 = this.f7859k;
        if (aVar2 != null) {
            aVar2.mo16508a((View) a);
        }
        a.setCallback(new C2202a() {
            /* renamed from: a */
            public void mo14918a(boolean z) {
                if (TTNativeExpressAdImpl.this.f7859k == null) {
                    return;
                }
                if (z) {
                    if (TTNativeExpressAdImpl.this.f7859k != null) {
                        TTNativeExpressAdImpl.this.f7859k.mo16513b();
                    }
                } else if (TTNativeExpressAdImpl.this.f7859k != null) {
                    TTNativeExpressAdImpl.this.f7859k.mo16516c();
                }
            }

            /* renamed from: a */
            public void mo14916a() {
                if (TTNativeExpressAdImpl.this.f7859k != null) {
                    TTNativeExpressAdImpl.this.f7859k.mo16504a();
                }
            }

            /* renamed from: b */
            public void mo14919b() {
                if (TTNativeExpressAdImpl.this.f7859k != null) {
                    TTNativeExpressAdImpl.this.f7859k.mo16518d();
                }
            }

            /* renamed from: a */
            public void mo14917a(View view) {
                C2564t.m12220b("TTNativeExpressAd", "ExpressView SHOW");
                HashMap hashMap = new HashMap();
                hashMap.put("dynamic_show_type", Integer.valueOf(TTNativeExpressAdImpl.this.f7850a.mo15883m()));
                AdEventManager.m8389a(TTNativeExpressAdImpl.this.f7851b, kVar, TTNativeExpressAdImpl.this.f7853d, (Map<String, Object>) hashMap);
                if (TTNativeExpressAdImpl.this.f7854f != null) {
                    TTNativeExpressAdImpl.this.f7854f.onAdShow(view, kVar.mo15414B());
                }
                if (kVar.mo15433U()) {
                    ToolUtils.m12001a(kVar, view);
                }
                if (!TTNativeExpressAdImpl.this.f7863e.getAndSet(true) && TTNativeExpressAdImpl.this.f7850a != null) {
                    UIUtils.m12056a(TTNativeExpressAdImpl.this.f7851b, TTNativeExpressAdImpl.this.f7852c, TTNativeExpressAdImpl.this.f7853d, (WebView) TTNativeExpressAdImpl.this.f7850a.getWebView());
                }
                if (TTNativeExpressAdImpl.this.f7850a != null) {
                    TTNativeExpressAdImpl.this.f7850a.mo15879i();
                    TTNativeExpressAdImpl.this.f7850a.mo15872g();
                }
            }
        });
        Context context = this.f7851b;
        String str = this.f7853d;
        ExpressClickListener eVar = new ExpressClickListener(context, kVar, str, ToolUtils.m11991a(str));
        eVar.mo15277a((View) nativeExpressView);
        eVar.mo15283a(this.f7859k);
        eVar.mo15279a((TTNativeExpressAd) this);
        this.f7850a.setClickListener(eVar);
        Context context2 = this.f7851b;
        String str2 = this.f7853d;
        ExpressClickCreativeListener dVar = new ExpressClickCreativeListener(context2, kVar, str2, ToolUtils.m11991a(str2));
        dVar.mo15277a((View) nativeExpressView);
        dVar.mo15283a(this.f7859k);
        dVar.mo15279a((TTNativeExpressAd) this);
        this.f7850a.setClickCreativeListener(dVar);
        ITTDownloadAdapter aVar3 = this.f7859k;
        if (aVar3 != null) {
            aVar3.mo16509a(this.f7855g);
        }
        a.setNeedCheckingShow(true);
    }

    /* renamed from: a */
    private EmptyView m10043a(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }
}
