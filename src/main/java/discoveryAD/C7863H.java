package discoveryAD;

import android.view.View;
import android.view.ViewGroup;

/* renamed from: discoveryAD.H */
class C7863H implements Runnable {
    final /* synthetic */ C7867L this$0;
    /* renamed from: vd */
    final /* synthetic */ View f26754vd;

    C7863H(C7867L l, View view) {
        this.this$0 = l;
        this.f26754vd = view;
    }

    public void run() {
        View view = this.f26754vd;
        if (view instanceof ViewGroup) {
            view.setOnClickListener(null);
            this.this$0.m34223b((ViewGroup) this.f26754vd);
        }
    }
}
