package com.scwang.smartrefresh.layout.p527a;

import android.view.View;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.p528b.OnStateChangedListener;

/* renamed from: com.scwang.smartrefresh.layout.a.h */
public interface RefreshInternal extends OnStateChangedListener {
    /* renamed from: a */
    int mo30670a(RefreshLayout jVar, boolean z);

    /* renamed from: a */
    void mo30951a(float f, int i, int i2);

    /* renamed from: a */
    void mo30677a(RefreshKernel iVar, int i, int i2);

    /* renamed from: a */
    void mo30671a(RefreshLayout jVar, int i, int i2);

    /* renamed from: a */
    void mo30672a(boolean z, float f, int i, int i2, int i3);

    /* renamed from: b */
    void mo30679b(RefreshLayout jVar, int i, int i2);

    /* renamed from: f */
    boolean mo30952f();

    SpinnerStyle getSpinnerStyle();

    View getView();

    void setPrimaryColors(int... iArr);
}
