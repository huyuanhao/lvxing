package com.scwang.smartrefresh.layout.impl;

import android.view.View;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.p527a.RefreshFooter;

public class RefreshFooterWrapper extends InternalAbstract implements RefreshFooter {
    public RefreshFooterWrapper(View view) {
        super(view);
    }

    /* renamed from: a */
    public boolean mo30950a(boolean z) {
        return (this.f20938ac instanceof RefreshFooter) && ((RefreshFooter) this.f20938ac).mo30950a(z);
    }
}
