package com.p368pw.inner.p369a.p379e;

import android.content.Context;
import android.widget.RelativeLayout;
import com.p368pw.inner.base.p387d.p391d.C5183b;

/* renamed from: com.pw.inner.a.e.b */
public abstract class C4929b extends RelativeLayout {
    /* renamed from: a */
    protected int f15947a;
    /* renamed from: b */
    protected C4930a f15948b;

    /* renamed from: com.pw.inner.a.e.b$a */
    public interface C4930a {
        /* renamed from: a */
        void mo26125a(String str, C5183b bVar, boolean z);

        /* renamed from: s */
        void mo26126s();
    }

    public C4929b(Context context) {
        this(context, -1);
    }

    public C4929b(Context context, int i) {
        super(context);
        this.f15947a = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo26122a() {
        C4930a aVar = this.f15948b;
        if (aVar != null) {
            aVar.mo26126s();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo26123a(String str) {
        C4930a aVar = this.f15948b;
        if (aVar != null) {
            aVar.mo26125a(str, C5183b.m21360a(), true);
        }
    }

    public void setEndpageListener(C4930a aVar) {
        this.f15948b = aVar;
    }
}
