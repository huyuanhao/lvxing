package com.yanzhenjie.album.p628a;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.yanzhenjie.album.a.a */
public class DoubleClickWrapper implements OnClickListener {
    /* renamed from: a */
    private final OnClickListener f26096a;
    /* renamed from: b */
    private long f26097b;

    public DoubleClickWrapper(OnClickListener onClickListener) {
        this.f26096a = onClickListener;
    }

    public void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f26097b <= 500) {
            this.f26096a.onClick(view);
        }
        this.f26097b = currentTimeMillis;
    }
}
