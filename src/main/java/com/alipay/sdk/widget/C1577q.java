package com.alipay.sdk.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.alipay.sdk.widget.WebViewWindow.C1558c;

/* renamed from: com.alipay.sdk.widget.q */
class C1577q implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ WebViewWindow f4016a;

    C1577q(WebViewWindow webViewWindow) {
        this.f4016a = webViewWindow;
    }

    public void onClick(View view) {
        C1558c a = this.f4016a.f3978i;
        if (a != null) {
            view.setEnabled(false);
            WebViewWindow.f3970f.postDelayed(new C1578r(this, view), 256);
            if (view == this.f4016a.f3971a) {
                a.mo12242a(this.f4016a);
            } else if (view == this.f4016a.f3973c) {
                a.mo12243b(this.f4016a);
            }
        }
    }
}
