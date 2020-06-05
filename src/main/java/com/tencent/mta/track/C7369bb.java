package com.tencent.mta.track;

import android.view.View;
import java.util.List;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.bb */
abstract class C7369bb extends C7363aw {
    /* renamed from: a */
    private final C7370bc f24943a;
    /* renamed from: b */
    private final C7461u f24944b;
    /* renamed from: c */
    private final boolean f24945c;

    public C7369bb(List list, C7461u uVar, C7370bc bcVar, boolean z) {
        super(list);
        this.f24943a = bcVar;
        this.f24944b = uVar;
        this.f24945c = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35907b(View view) {
        this.f24943a.mo35908a(view, this.f24944b, this.f24945c);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo35906b() {
        return this.f24944b.f24999b;
    }
}
