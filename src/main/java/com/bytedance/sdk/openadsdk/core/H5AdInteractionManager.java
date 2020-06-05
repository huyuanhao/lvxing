package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ExpressClickCreativeListener;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ExpressClickListener;
import com.bytedance.sdk.openadsdk.core.p170d.DynamicClickInfo;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.downloadnew.TTDownloadFactory;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;

/* renamed from: com.bytedance.sdk.openadsdk.core.i */
public class H5AdInteractionManager {
    /* renamed from: a */
    private final Context f7706a;
    /* renamed from: b */
    private final MaterialMeta f7707b;
    /* renamed from: c */
    private ITTDownloadAdapter f7708c;
    /* renamed from: d */
    private ExpressClickListener f7709d;
    /* renamed from: e */
    private ExpressClickCreativeListener f7710e;
    /* renamed from: f */
    private View f7711f;
    /* renamed from: g */
    private String f7712g = "rewarded_video";

    public H5AdInteractionManager(Context context, MaterialMeta kVar, View view) {
        this.f7707b = kVar;
        this.f7706a = context;
        this.f7711f = view;
        this.f7712g = ToolUtils.m12009b(ToolUtils.m12014c(kVar.mo15428P()));
        if (this.f7707b.mo15414B() == 4) {
            this.f7708c = TTDownloadFactory.m11071a(this.f7706a, this.f7707b, this.f7712g);
        }
        String str = this.f7712g;
        this.f7709d = new ExpressClickListener(context, kVar, str, ToolUtils.m11991a(str));
        this.f7709d.mo15277a(this.f7711f);
        this.f7709d.mo15283a(this.f7708c);
        String str2 = this.f7712g;
        this.f7710e = new ExpressClickCreativeListener(context, kVar, str2, ToolUtils.m11991a(str2));
        this.f7710e.mo15277a(this.f7711f);
        this.f7710e.mo15283a(this.f7708c);
    }

    /* renamed from: a */
    public void mo15825a(int i, DynamicClickInfo iVar) {
        if (i != -1 && iVar != null) {
            int i2 = iVar.f7378a;
            int i3 = iVar.f7379b;
            int i4 = iVar.f7380c;
            int i5 = iVar.f7381d;
            if (i == 1) {
                ExpressClickListener eVar = this.f7709d;
                if (eVar != null) {
                    eVar.mo15902a(iVar);
                    this.f7709d.mo14920a(this.f7711f, i2, i3, i4, i5);
                }
            } else if (i == 2) {
                ExpressClickCreativeListener dVar = this.f7710e;
                if (dVar != null) {
                    dVar.mo15901a(iVar);
                    this.f7710e.mo14920a(this.f7711f, i2, i3, i4, i5);
                }
            }
        }
    }
}
