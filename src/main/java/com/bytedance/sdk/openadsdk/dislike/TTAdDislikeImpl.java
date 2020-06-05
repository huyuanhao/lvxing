package com.bytedance.sdk.openadsdk.dislike;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeDialogDefault.C2393a;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.Predicate;

/* renamed from: com.bytedance.sdk.openadsdk.dislike.b */
public class TTAdDislikeImpl implements TTAdDislike {
    /* renamed from: a */
    private final Context f8499a;
    /* renamed from: b */
    private MaterialMeta f8500b;
    /* renamed from: c */
    private TTDislikeDialogDefault f8501c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public DislikeInteractionCallback f8502d;

    public TTAdDislikeImpl(Context context, MaterialMeta kVar) {
        Predicate.m12254a(context, "Dislike 初始化必须使用activity,请在TTAdManager.createAdNative(activity)中传入");
        this.f8499a = context;
        this.f8500b = kVar;
        m11047a();
    }

    /* renamed from: a */
    private void m11047a() {
        this.f8501c = new TTDislikeDialogDefault(this.f8499a, this.f8500b);
        this.f8501c.mo16459a((C2393a) new C2393a() {
            /* renamed from: a */
            public void mo16454a() {
                C2564t.m12220b("TTAdDislikeImpl", "onDislikeShow: ");
            }

            /* renamed from: a */
            public void mo16455a(int i, FilterWord filterWord) {
                String str = "TTAdDislikeImpl";
                try {
                    if (!filterWord.hasSecondOptions() && TTAdDislikeImpl.this.f8502d != null) {
                        TTAdDislikeImpl.this.f8502d.onSelected(i, filterWord.getName());
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("onDislikeSelected: ");
                    sb.append(i);
                    sb.append(", ");
                    sb.append(String.valueOf(filterWord.getName()));
                    C2564t.m12226e(str, sb.toString());
                } catch (Throwable th) {
                    C2564t.m12223c(str, "dislike callback selected error: ", th);
                }
            }

            /* renamed from: b */
            public void mo16456b() {
                C2564t.m12226e("TTAdDislikeImpl", "onDislikeDismiss: ");
            }

            /* renamed from: c */
            public void mo16457c() {
                C2564t.m12226e("TTAdDislikeImpl", "onDislikeOptionBack: ");
            }
        });
    }

    public void showDislikeDialog() {
        Context context = this.f8499a;
        boolean z = (context instanceof Activity) && !((Activity) context).isFinishing();
        if (z) {
            this.f8501c.show();
        }
    }

    /* renamed from: a */
    public void mo16453a(MaterialMeta kVar) {
        this.f8501c.mo16458a(kVar);
    }

    public void setDislikeInteractionCallback(DislikeInteractionCallback dislikeInteractionCallback) {
        this.f8502d = dislikeInteractionCallback;
    }
}
