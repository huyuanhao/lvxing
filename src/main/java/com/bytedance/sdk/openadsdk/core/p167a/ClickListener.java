package com.bytedance.sdk.openadsdk.core.p167a;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.GlobalInfo;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.WebHelper;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupViewClickListener;
import com.bytedance.sdk.openadsdk.core.p170d.ClickEventModel;
import com.bytedance.sdk.openadsdk.core.p170d.ClickEventModel.C2224a;
import com.bytedance.sdk.openadsdk.core.p170d.DynamicClickInfo.C2226a;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.INativeVideoController;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.p165c.AdEventManager;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.bytedance.sdk.openadsdk.utils.UIUtils;
import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: com.bytedance.sdk.openadsdk.core.a.b */
public class ClickListener extends InteractionListener {
    /* renamed from: c */
    protected Context f7197c;
    /* renamed from: d */
    protected final MaterialMeta f7198d;
    /* renamed from: e */
    protected final String f7199e;
    /* renamed from: f */
    protected final int f7200f;
    /* renamed from: g */
    protected WeakReference<View> f7201g;
    /* renamed from: h */
    protected WeakReference<View> f7202h;
    /* renamed from: i */
    protected ClickEventModel f7203i;
    /* renamed from: j */
    protected C2203a f7204j;
    /* renamed from: k */
    protected TTNativeAd f7205k;
    /* renamed from: l */
    protected INativeVideoController f7206l;
    /* renamed from: m */
    protected boolean f7207m = false;
    /* renamed from: n */
    protected ITTDownloadAdapter f7208n;
    /* renamed from: o */
    protected Map<String, Object> f7209o;
    /* renamed from: p */
    protected TTNativeExpressAd f7210p;
    /* renamed from: q */
    protected BackupViewClickListener f7211q;

    /* compiled from: ClickListener */
    /* renamed from: com.bytedance.sdk.openadsdk.core.a.b$a */
    public interface C2203a {
        /* renamed from: a */
        void mo15083a(View view, int i);
    }

    /* renamed from: a */
    public void mo15283a(ITTDownloadAdapter aVar) {
        this.f7208n = aVar;
    }

    /* renamed from: a */
    public void mo15281a(BackupViewClickListener aVar) {
        this.f7211q = aVar;
    }

    /* renamed from: a */
    public void mo15278a(TTNativeAd tTNativeAd) {
        this.f7205k = tTNativeAd;
    }

    /* renamed from: a */
    public void mo15279a(TTNativeExpressAd tTNativeExpressAd) {
        this.f7210p = tTNativeExpressAd;
    }

    /* renamed from: c */
    public void mo15287c(boolean z) {
        this.f7207m = z;
    }

    /* renamed from: a */
    public void mo15282a(INativeVideoController cVar) {
        this.f7206l = cVar;
    }

    public ClickListener(Context context, MaterialMeta kVar, String str, int i) {
        this.f7197c = context;
        this.f7198d = kVar;
        this.f7199e = str;
        this.f7200f = i;
    }

    /* renamed from: a */
    public void mo15280a(C2203a aVar) {
        this.f7204j = aVar;
    }

    /* renamed from: a */
    public void mo15277a(View view) {
        this.f7201g = new WeakReference<>(view);
    }

    /* renamed from: b */
    public void mo15286b(View view) {
        this.f7202h = new WeakReference<>(view);
    }

    /* renamed from: a */
    public void mo15284a(Map<String, Object> map) {
        this.f7209o = map;
    }

    /* renamed from: a */
    public void mo14920a(View view, int i, int i2, int i3, int i4) {
        View view2;
        if (!mo15285a(1)) {
            if (this.f7197c == null) {
                this.f7197c = InternalContainer.m10059a();
            }
            if (this.f7197c != null) {
                long j = this.f7223v;
                long j2 = this.f7224w;
                WeakReference<View> weakReference = this.f7201g;
                if (weakReference == null) {
                    view2 = null;
                } else {
                    view2 = (View) weakReference.get();
                }
                WeakReference<View> weakReference2 = this.f7202h;
                this.f7203i = mo15276a(i, i2, i3, i4, j, j2, view2, weakReference2 == null ? null : (View) weakReference2.get());
                C2203a aVar = this.f7204j;
                if (aVar != null) {
                    aVar.mo15083a(view, -1);
                }
                boolean q = this.f7198d.mo15503q();
                boolean a = WebHelper.m11011a(this.f7197c, this.f7198d, this.f7200f, this.f7205k, this.f7210p, q ? this.f7199e : ToolUtils.m11993a(this.f7200f), this.f7208n, q);
                if (!a) {
                    MaterialMeta kVar = this.f7198d;
                    if (!(kVar == null || kVar.mo15427O() == null || this.f7198d.mo15427O().mo15381c() != 2)) {
                        return;
                    }
                }
                AdEventManager.m8391a(this.f7197c, "click", this.f7198d, this.f7203i, this.f7199e, a, this.f7209o);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public ClickEventModel mo15276a(int i, int i2, int i3, int i4, long j, long j2, View view, View view2) {
        return new C2224a().mo15372e(i).mo15370d(i2).mo15368c(i3).mo15365b(i4).mo15366b(j).mo15361a(j2).mo15367b(UIUtils.m12067a(view)).mo15363a(UIUtils.m12067a(view2)).mo15369c(UIUtils.m12077b(view)).mo15371d(UIUtils.m12077b(view2)).mo15373f(this.f7225x).mo15374g(this.f7226y).mo15375h(this.f7227z).mo15362a(this.f7218B).mo15360a(GlobalInfo.m9616c().mo15668b() ? 1 : 2).mo15364a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo15285a(int i) {
        if (this.f7211q == null) {
            return false;
        }
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        WeakReference<View> weakReference = this.f7202h;
        if (weakReference != null) {
            iArr = UIUtils.m12067a((View) weakReference.get());
            iArr2 = UIUtils.m12077b((View) this.f7202h.get());
        }
        this.f7211q.mo15854a(i, new C2226a().mo15401d(this.f7219r).mo15400c(this.f7220s).mo15398b(this.f7221t).mo15395a(this.f7222u).mo15399b(this.f7223v).mo15396a(this.f7224w).mo15402e(iArr[0]).mo15403f(iArr[1]).mo15404g(iArr2[0]).mo15405h(iArr2[1]).mo15397a());
        return true;
    }
}
