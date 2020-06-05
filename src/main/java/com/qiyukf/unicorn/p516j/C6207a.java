package com.qiyukf.unicorn.p516j;

import android.os.Handler;
import com.qiyukf.basesdk.p412c.C5361a;

/* renamed from: com.qiyukf.unicorn.j.a */
public abstract class C6207a<Param, Result> {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public Handler f19386a = C5361a.m22014b();
    /* renamed from: b */
    private Handler f19387b;

    public C6207a(String str) {
        this.f19387b = C5361a.m22013a().mo27316a(str);
    }

    /* renamed from: a */
    public abstract Result mo27678a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo27679a(Result result) {
    }

    /* renamed from: a */
    public final void mo29406a(final Param... paramArr) {
        this.f19387b.post(new Runnable() {
            public final void run() {
                final Object a = C6207a.this.mo27678a();
                C6207a.this.f19386a.post(new Runnable() {
                    public final void run() {
                        C6207a.this.mo27679a(a);
                    }
                });
            }
        });
    }
}
