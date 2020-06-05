package com.tencent.mta.track;

import android.view.View;
import java.util.List;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.bd */
public class C7371bd extends C7369bb {
    /* renamed from: a */
    private boolean f24946a = false;

    /* renamed from: a */
    public void mo35896a() {
    }

    public C7371bd(List list, C7461u uVar, C7370bc bcVar) {
        super(list, uVar, bcVar, false);
    }

    public void accumulate(View view) {
        if (view != null && !this.f24946a) {
            mo35907b(view);
        }
        this.f24946a = view != null;
    }
}
