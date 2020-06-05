package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.GlobalInfo;
import com.bytedance.sdk.openadsdk.core.p167a.ClickCreativeListener;
import com.bytedance.sdk.openadsdk.core.p170d.ClickEventModel;
import com.bytedance.sdk.openadsdk.core.p170d.ClickEventModel.C2224a;
import com.bytedance.sdk.openadsdk.core.p170d.DynamicClickInfo;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.utils.UIUtils;

/* renamed from: com.bytedance.sdk.openadsdk.core.nativeexpress.d */
public class ExpressClickCreativeListener extends ClickCreativeListener {
    /* renamed from: a */
    private DynamicClickInfo f7829a;

    public ExpressClickCreativeListener(Context context, MaterialMeta kVar, String str, int i) {
        super(context, kVar, str, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public ClickEventModel mo15276a(int i, int i2, int i3, int i4, long j, long j2, View view, View view2) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        long j3;
        int i11;
        long j4;
        this.f7225x = 1;
        this.f7226y = 0;
        this.f7227z = 0;
        int[] a = UIUtils.m12067a(view);
        if (a == null || a.length != 2) {
            i8 = i;
            i7 = i2;
            i6 = i3;
            i5 = i4;
            i10 = 0;
            i9 = 0;
        } else {
            i10 = a[0];
            i9 = a[1];
            i8 = ((int) UIUtils.m12048a(this.f7197c, (float) i)) + i10;
            i7 = ((int) UIUtils.m12048a(this.f7197c, (float) i2)) + i9;
            i6 = ((int) UIUtils.m12048a(this.f7197c, (float) i3)) + i10;
            i5 = ((int) UIUtils.m12048a(this.f7197c, (float) i4)) + i9;
        }
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        DynamicClickInfo iVar = this.f7829a;
        if (iVar != null) {
            j3 = iVar.f7382e;
            j4 = this.f7829a.f7383f;
            iArr[0] = ((int) UIUtils.m12048a(this.f7197c, (float) this.f7829a.f7384g)) + i10;
            iArr[1] = ((int) UIUtils.m12048a(this.f7197c, (float) this.f7829a.f7385h)) + i9;
            int a2 = (int) UIUtils.m12048a(this.f7197c, (float) this.f7829a.f7387j);
            iArr2[0] = (int) UIUtils.m12048a(this.f7197c, (float) this.f7829a.f7386i);
            i11 = 1;
            iArr2[1] = a2;
        } else {
            i11 = 1;
            j3 = j;
            j4 = j2;
        }
        C2224a h = new C2224a().mo15372e(i8).mo15370d(i7).mo15368c(i6).mo15365b(i5).mo15366b(j3).mo15361a(j4).mo15367b(a).mo15363a(iArr).mo15369c(UIUtils.m12077b(view)).mo15371d(iArr2).mo15373f(this.f7225x).mo15374g(this.f7226y).mo15375h(this.f7227z);
        if (!GlobalInfo.m9616c().mo15668b()) {
            i11 = 2;
        }
        return h.mo15360a(i11).mo15362a(this.f7218B).mo15364a();
    }

    /* renamed from: a */
    public void mo15901a(DynamicClickInfo iVar) {
        this.f7829a = iVar;
    }
}
