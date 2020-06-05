package com.tencent.p605ep.commonbase.api;

import android.content.Context;

/* renamed from: com.tencent.ep.commonbase.api.BaseManager */
public abstract class BaseManager {
    public static final int TYPE_AUTO = 0;
    public static final int TYPE_FOREVER = 1;
    public static final int TYPE_ONCE = 2;
    @Deprecated
    /* renamed from: a */
    private BaseManager f24692a;

    @Deprecated
    protected static final boolean isExpired() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public <ImplType extends BaseManager> ImplType getImpl() {
        return this.f24692a;
    }

    public int getSingletonType() {
        BaseManager baseManager = this.f24692a;
        if (baseManager != null) {
            return baseManager.getSingletonType();
        }
        return 0;
    }

    public abstract void onCreate(Context context);

    public void onDestroy(Context context) {
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public <ImplType extends BaseManager> void setImpl(ImplType impltype) {
        this.f24692a = impltype;
    }
}
