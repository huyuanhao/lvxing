package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener;
import com.bytedance.sdk.openadsdk.core.EmptyView.C2202a;
import com.bytedance.sdk.openadsdk.core.p167a.ClickCreativeListener;
import com.bytedance.sdk.openadsdk.core.p167a.ClickListener;
import com.bytedance.sdk.openadsdk.core.p167a.ClickListener.C2203a;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.downloadnew.TTDownloadFactory;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.p165c.AdEventManager;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import java.util.List;

/* renamed from: com.bytedance.sdk.openadsdk.core.n */
public class InteractionManager {
    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final MaterialMeta f7739a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public ITTDownloadAdapter f7740b;
    /* access modifiers changed from: private|final */
    /* renamed from: c */
    public final Context f7741c;
    /* access modifiers changed from: private|final */
    /* renamed from: d */
    public final TTNativeAd f7742d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public String f7743e = "embeded_ad";

    public InteractionManager(Context context, TTNativeAd tTNativeAd, MaterialMeta kVar, String str) {
        this.f7742d = tTNativeAd;
        this.f7739a = kVar;
        this.f7741c = context;
        this.f7743e = str;
        if (this.f7739a.mo15414B() == 4) {
            this.f7740b = TTDownloadFactory.m11071a(this.f7741c, this.f7739a, this.f7743e);
        }
    }

    /* renamed from: a */
    public void mo15840a(Activity activity) {
        ITTDownloadAdapter aVar = this.f7740b;
        if (aVar != null) {
            aVar.mo16507a(activity);
        }
    }

    /* renamed from: a */
    public ITTDownloadAdapter mo15839a() {
        return this.f7740b;
    }

    /* renamed from: a */
    public void mo15841a(ViewGroup viewGroup, List<View> list, List<View> list2, View view, final AdInteractionListener adInteractionListener) {
        ITTDownloadAdapter aVar = this.f7740b;
        if (aVar != null) {
            aVar.mo16513b();
        }
        AdEventManager.m8392a(this.f7739a);
        EmptyView a = m9903a(viewGroup);
        if (a == null) {
            a = new EmptyView(this.f7741c, viewGroup);
            viewGroup.addView(a);
        }
        a.mo15258a();
        a.setRefClickViews(list);
        a.setRefCreativeViews(list2);
        ITTDownloadAdapter aVar2 = this.f7740b;
        if (aVar2 != null) {
            aVar2.mo16508a((View) a);
        }
        Context context = this.f7741c;
        MaterialMeta kVar = this.f7739a;
        String str = this.f7743e;
        ClickListener bVar = new ClickListener(context, kVar, str, ToolUtils.m11991a(str));
        bVar.mo15277a((View) viewGroup);
        bVar.mo15286b(view);
        bVar.mo15283a(this.f7740b);
        bVar.mo15278a(this.f7742d);
        bVar.mo15280a((C2203a) new C2203a() {
            /* renamed from: a */
            public void mo15083a(View view, int i) {
                AdInteractionListener adInteractionListener = adInteractionListener;
                if (adInteractionListener != null) {
                    adInteractionListener.onAdClicked(view, InteractionManager.this.f7742d);
                }
            }
        });
        Context context2 = this.f7741c;
        MaterialMeta kVar2 = this.f7739a;
        String str2 = this.f7743e;
        ClickCreativeListener aVar3 = new ClickCreativeListener(context2, kVar2, str2, ToolUtils.m11991a(str2));
        aVar3.mo15277a((View) viewGroup);
        aVar3.mo15286b(view);
        aVar3.mo15283a(this.f7740b);
        aVar3.mo15278a(this.f7742d);
        aVar3.mo15280a((C2203a) new C2203a() {
            /* renamed from: a */
            public void mo15083a(View view, int i) {
                AdInteractionListener adInteractionListener = adInteractionListener;
                if (adInteractionListener != null) {
                    adInteractionListener.onAdCreativeClick(view, InteractionManager.this.f7742d);
                }
            }
        });
        a.mo15259a(list, bVar);
        a.mo15259a(list2, aVar3);
        a.setCallback(new C2202a() {
            /* renamed from: a */
            public void mo14918a(boolean z) {
                if (InteractionManager.this.f7740b == null) {
                    return;
                }
                if (z) {
                    InteractionManager.this.f7740b.mo16513b();
                } else {
                    InteractionManager.this.f7740b.mo16516c();
                }
            }

            /* renamed from: a */
            public void mo14916a() {
                if (InteractionManager.this.f7740b != null) {
                    InteractionManager.this.f7740b.mo16504a();
                }
            }

            /* renamed from: b */
            public void mo14919b() {
                if (InteractionManager.this.f7740b != null) {
                    InteractionManager.this.f7740b.mo16518d();
                }
            }

            /* renamed from: a */
            public void mo14917a(View view) {
                AdEventManager.m8389a(InteractionManager.this.f7741c, InteractionManager.this.f7739a, InteractionManager.this.f7743e, null);
                AdInteractionListener adInteractionListener = adInteractionListener;
                if (adInteractionListener != null) {
                    adInteractionListener.onAdShow(InteractionManager.this.f7742d);
                }
                if (InteractionManager.this.f7739a.mo15433U()) {
                    ToolUtils.m12001a(InteractionManager.this.f7739a, view);
                }
            }
        });
        a.setNeedCheckingShow(true);
    }

    /* renamed from: a */
    private EmptyView m9903a(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void mo15842a(TTAppDownloadListener tTAppDownloadListener) {
        ITTDownloadAdapter aVar = this.f7740b;
        if (aVar != null) {
            aVar.mo16509a(tTAppDownloadListener);
        }
    }
}
