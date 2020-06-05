package com.bytedance.sdk.adnet.core;

import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.p162e.IRetryPolicy;

/* renamed from: com.bytedance.sdk.adnet.core.g */
public class DefaultRetryPolicy implements IRetryPolicy {
    /* renamed from: a */
    private int f6240a;
    /* renamed from: b */
    private int f6241b;
    /* renamed from: c */
    private int f6242c;
    /* renamed from: d */
    private final float f6243d;

    public DefaultRetryPolicy() {
        this(2500, 1, 1.0f);
    }

    /* renamed from: a */
    public DefaultRetryPolicy mo14330a(int i) {
        this.f6240a = i;
        return this;
    }

    /* renamed from: b */
    public DefaultRetryPolicy mo14333b(int i) {
        this.f6242c = i;
        return this;
    }

    public DefaultRetryPolicy(int i, int i2, float f) {
        this.f6240a = i;
        this.f6242c = i2;
        this.f6243d = f;
    }

    /* renamed from: a */
    public int mo14329a() {
        return this.f6240a;
    }

    /* renamed from: b */
    public int mo14332b() {
        return this.f6241b;
    }

    /* renamed from: a */
    public void mo14331a(VAdError vAdError) throws VAdError {
        this.f6241b++;
        int i = this.f6240a;
        this.f6240a = i + ((int) (((float) i) * this.f6243d));
        if (!mo14334c()) {
            throw vAdError;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo14334c() {
        return this.f6241b <= this.f6242c;
    }
}
