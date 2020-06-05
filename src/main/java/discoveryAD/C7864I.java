package discoveryAD;

import android.os.Bundle;
import android.view.View;
import com.tencent.qqpim.discovery.AdDisplayModel;

/* renamed from: discoveryAD.I */
class C7864I implements Runnable {
    /* renamed from: Tc */
    final /* synthetic */ AdDisplayModel f26755Tc;
    final /* synthetic */ C7867L this$0;
    /* renamed from: vd */
    final /* synthetic */ View f26756vd;
    /* renamed from: wd */
    final /* synthetic */ Bundle f26757wd;

    C7864I(C7867L l, View view, AdDisplayModel adDisplayModel, Bundle bundle) {
        this.this$0 = l;
        this.f26756vd = view;
        this.f26755Tc = adDisplayModel;
        this.f26757wd = bundle;
    }

    public void run() {
        this.this$0.m34215a(this.f26756vd, this.f26755Tc, this.f26757wd);
    }
}
