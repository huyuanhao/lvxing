package com.bytedance.sdk.openadsdk.core.p169c;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd.AdInteractionListener;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.EmptyView.C2202a;
import com.bytedance.sdk.openadsdk.core.InsertAdDialog;
import com.bytedance.sdk.openadsdk.core.InsertAdDialog.C2262a;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ExpressBackupListener;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ExpressClickCreativeListener;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ExpressClickListener;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.TTNativeExpressAdStub;
import com.bytedance.sdk.openadsdk.core.p167a.ClickListener.C2203a;
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

/* renamed from: com.bytedance.sdk.openadsdk.core.c.b */
public class TTInteractionExpressAdImpl extends TTNativeExpressAdStub {
    /* renamed from: a */
    InteractionExpressBackupView f7295a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public NativeExpressView f7296b;
    /* access modifiers changed from: private|final */
    /* renamed from: c */
    public final Context f7297c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public MaterialMeta f7298d;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public ExpressAdInteractionListener f7299f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public AdInteractionListener f7300g;
    /* renamed from: h */
    private TTAppDownloadListener f7301h;
    /* renamed from: i */
    private TTAdDislikeImpl f7302i;
    /* access modifiers changed from: private */
    /* renamed from: j */
    public ITTDownloadAdapter f7303j;
    /* renamed from: k */
    private Dialog f7304k;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public FrameLayout f7305l;
    /* access modifiers changed from: private */
    /* renamed from: m */
    public String f7306m = "interaction";

    public TTInteractionExpressAdImpl(Context context, MaterialMeta kVar, AdSlot adSlot) {
        this.f7297c = context;
        this.f7298d = kVar;
        this.f7296b = new NativeExpressView(context, kVar, adSlot, this.f7306m);
        m9195a(this.f7296b, this.f7298d);
    }

    public View getExpressAdView() {
        return this.f7296b;
    }

    public int getImageMode() {
        MaterialMeta kVar = this.f7298d;
        if (kVar == null) {
            return -1;
        }
        return kVar.mo15429Q();
    }

    public List<FilterWord> getFilterWords() {
        MaterialMeta kVar = this.f7298d;
        if (kVar == null) {
            return null;
        }
        return kVar.mo15430R();
    }

    public void setExpressInteractionListener(ExpressAdInteractionListener expressAdInteractionListener) {
        this.f7299f = expressAdInteractionListener;
        this.f7296b.setExpressInteractionListener(expressAdInteractionListener);
    }

    public void setExpressInteractionListener(AdInteractionListener adInteractionListener) {
        this.f7300g = adInteractionListener;
        this.f7299f = adInteractionListener;
        this.f7296b.setExpressInteractionListener(adInteractionListener);
    }

    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        this.f7301h = tTAppDownloadListener;
        ITTDownloadAdapter aVar = this.f7303j;
        if (aVar != null) {
            aVar.mo16509a(this.f7301h);
        }
    }

    public Map<String, Object> getMediaExtraInfo() {
        MaterialMeta kVar = this.f7298d;
        if (kVar != null) {
            return kVar.mo15436X();
        }
        return null;
    }

    public int getInteractionType() {
        MaterialMeta kVar = this.f7298d;
        if (kVar == null) {
            return -1;
        }
        return kVar.mo15414B();
    }

    public void render() {
        this.f7296b.mo15878h();
    }

    public void destroy() {
        NativeExpressView nativeExpressView = this.f7296b;
        if (nativeExpressView != null) {
            nativeExpressView.mo15881k();
        }
    }

    public void setDislikeCallback(Activity activity, DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback != null && activity != null) {
            m9194a(activity, dislikeInteractionCallback);
        }
    }

    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        if (tTDislikeDialogAbstract == null) {
            C2564t.m12219b("dialog is null, please check");
            return;
        }
        tTDislikeDialogAbstract.setMaterialMeta(this.f7298d);
        NativeExpressView nativeExpressView = this.f7296b;
        if (nativeExpressView != null) {
            nativeExpressView.setOuterDislike(tTDislikeDialogAbstract);
        }
    }

    /* renamed from: a */
    private void m9194a(Activity activity, DislikeInteractionCallback dislikeInteractionCallback) {
        if (this.f7302i == null) {
            this.f7302i = new TTAdDislikeImpl(activity, this.f7298d);
        }
        this.f7302i.setDislikeInteractionCallback(dislikeInteractionCallback);
        NativeExpressView nativeExpressView = this.f7296b;
        if (nativeExpressView != null) {
            nativeExpressView.setDislike(this.f7302i);
        }
    }

    /* renamed from: a */
    private ITTDownloadAdapter m9191a(MaterialMeta kVar) {
        if (kVar.mo15414B() == 4) {
            return TTDownloadFactory.m11071a(this.f7297c, kVar, this.f7306m);
        }
        return null;
    }

    /* renamed from: a */
    private void m9195a(NativeExpressView nativeExpressView, final MaterialMeta kVar) {
        this.f7298d = kVar;
        this.f7296b.setBackupListener(new ExpressBackupListener() {
            /* renamed from: a */
            public boolean mo15189a(NativeExpressView nativeExpressView, int i) {
                TTInteractionExpressAdImpl.this.f7296b.mo15882l();
                TTInteractionExpressAdImpl.this.f7295a = new InteractionExpressBackupView(nativeExpressView.getContext());
                TTInteractionExpressAdImpl.this.f7295a.mo15316a(TTInteractionExpressAdImpl.this.f7298d, TTInteractionExpressAdImpl.this.f7296b, TTInteractionExpressAdImpl.this.f7303j);
                return true;
            }
        });
        this.f7303j = m9191a(kVar);
        ITTDownloadAdapter aVar = this.f7303j;
        if (aVar != null) {
            aVar.mo16513b();
            if (nativeExpressView.getContext() != null && (nativeExpressView.getContext() instanceof Activity)) {
                this.f7303j.mo16507a((Activity) nativeExpressView.getContext());
            }
        }
        AdEventManager.m8392a(kVar);
        EmptyView a = m9189a((ViewGroup) nativeExpressView);
        if (a == null) {
            a = new EmptyView(this.f7297c, nativeExpressView);
            nativeExpressView.addView(a);
        }
        ITTDownloadAdapter aVar2 = this.f7303j;
        if (aVar2 != null) {
            aVar2.mo16508a((View) a);
        }
        a.setCallback(new C2202a() {
            /* renamed from: a */
            public void mo14918a(boolean z) {
                StringBuilder sb = new StringBuilder();
                sb.append("ExpressView onWindowFocusChanged=");
                sb.append(z);
                C2564t.m12220b("TTInteractionExpressAd", sb.toString());
                if (TTInteractionExpressAdImpl.this.f7303j == null) {
                    return;
                }
                if (z) {
                    if (TTInteractionExpressAdImpl.this.f7303j != null) {
                        TTInteractionExpressAdImpl.this.f7303j.mo16513b();
                    }
                } else if (TTInteractionExpressAdImpl.this.f7303j != null) {
                    TTInteractionExpressAdImpl.this.f7303j.mo16516c();
                }
            }

            /* renamed from: a */
            public void mo14916a() {
                if (TTInteractionExpressAdImpl.this.f7303j != null) {
                    TTInteractionExpressAdImpl.this.f7303j.mo16504a();
                }
            }

            /* renamed from: b */
            public void mo14919b() {
                if (TTInteractionExpressAdImpl.this.f7303j != null) {
                    TTInteractionExpressAdImpl.this.f7303j.mo16518d();
                }
            }

            /* renamed from: a */
            public void mo14917a(View view) {
                C2564t.m12220b("TTInteractionExpressAd", "ExpressView SHOW");
                HashMap hashMap = new HashMap();
                hashMap.put("dynamic_show_type", Integer.valueOf(TTInteractionExpressAdImpl.this.f7296b.mo15883m()));
                AdEventManager.m8389a(TTInteractionExpressAdImpl.this.f7297c, kVar, TTInteractionExpressAdImpl.this.f7306m, (Map<String, Object>) hashMap);
                if (TTInteractionExpressAdImpl.this.f7299f != null) {
                    TTInteractionExpressAdImpl.this.f7299f.onAdShow(view, kVar.mo15414B());
                }
                if (kVar.mo15433U()) {
                    ToolUtils.m12001a(kVar, view);
                }
                if (!TTInteractionExpressAdImpl.this.f7863e.getAndSet(true) && TTInteractionExpressAdImpl.this.f7296b != null) {
                    UIUtils.m12056a(TTInteractionExpressAdImpl.this.f7297c, TTInteractionExpressAdImpl.this.f7298d, TTInteractionExpressAdImpl.this.f7306m, (WebView) TTInteractionExpressAdImpl.this.f7296b.getWebView());
                }
                if (TTInteractionExpressAdImpl.this.f7296b != null) {
                    TTInteractionExpressAdImpl.this.f7296b.mo15879i();
                    TTInteractionExpressAdImpl.this.f7296b.mo15872g();
                }
            }
        });
        ExpressClickListener eVar = new ExpressClickListener(this.f7297c, kVar, this.f7306m, 3);
        eVar.mo15277a((View) nativeExpressView);
        eVar.mo15283a(this.f7303j);
        this.f7296b.setClickListener(eVar);
        ExpressClickCreativeListener dVar = new ExpressClickCreativeListener(this.f7297c, kVar, this.f7306m, 3);
        dVar.mo15277a((View) nativeExpressView);
        dVar.mo15283a(this.f7303j);
        dVar.mo15280a((C2203a) new C2203a() {
            /* renamed from: a */
            public void mo15083a(View view, int i) {
                if (i == 2 || i == 3 || i == 5) {
                    TTInteractionExpressAdImpl.this.m9192a();
                }
            }
        });
        this.f7296b.setClickCreativeListener(dVar);
        ITTDownloadAdapter aVar3 = this.f7303j;
        if (aVar3 != null) {
            aVar3.mo16509a(this.f7301h);
        }
        a.setNeedCheckingShow(true);
    }

    /* renamed from: a */
    private EmptyView m9189a(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    public void showInteractionExpressAd(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            if (Looper.getMainLooper() != Looper.myLooper()) {
                C2564t.m12219b("不能在子线程调用 TTInteractionExpressAd.showInteractionAd");
                return;
            }
            m9193a(activity);
        }
    }

    /* renamed from: a */
    private void m9193a(Activity activity) {
        if (this.f7304k == null) {
            this.f7304k = new InsertAdDialog(activity);
            this.f7304k.setOnDismissListener(new OnDismissListener() {
                public void onDismiss(DialogInterface dialogInterface) {
                    if (TTInteractionExpressAdImpl.this.f7303j != null) {
                        TTInteractionExpressAdImpl.this.f7303j.mo16518d();
                    }
                    AdEventManager.m8381a(TTInteractionExpressAdImpl.this.f7297c, TTInteractionExpressAdImpl.this.f7298d, "interaction");
                    if (TTInteractionExpressAdImpl.this.f7300g != null) {
                        TTInteractionExpressAdImpl.this.f7300g.onAdDismiss();
                    }
                    C2564t.m12220b("TTInteractionExpressAd", "dislike事件发出");
                }
            });
            ((InsertAdDialog) this.f7304k).mo15835a(true, new C2262a() {
                /* renamed from: a */
                public void mo15091a(ImageView imageView, ImageView imageView2, FrameLayout frameLayout) {
                    TTInteractionExpressAdImpl.this.f7305l = frameLayout;
                    TTInteractionExpressAdImpl.this.f7305l.addView(TTInteractionExpressAdImpl.this.f7296b, new LayoutParams(-1, -1));
                }

                /* renamed from: a */
                public void mo15090a(View view) {
                    TTInteractionExpressAdImpl.this.m9192a();
                }
            });
        }
        InteractionExpressBackupView aVar = this.f7295a;
        if (aVar != null) {
            aVar.mo15315a(this.f7304k);
        }
        if (!this.f7304k.isShowing()) {
            this.f7304k.show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9192a() {
        Dialog dialog = this.f7304k;
        if (dialog != null) {
            dialog.dismiss();
        }
    }
}
