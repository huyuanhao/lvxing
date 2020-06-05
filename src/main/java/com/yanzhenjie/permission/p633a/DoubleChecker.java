package com.yanzhenjie.permission.p633a;

import android.content.Context;

/* renamed from: com.yanzhenjie.permission.a.h */
public final class DoubleChecker implements PermissionChecker {
    /* renamed from: a */
    private static final PermissionChecker f26621a = new StandardChecker();
    /* renamed from: b */
    private static final PermissionChecker f26622b = new StrictChecker();

    /* renamed from: a */
    public boolean mo38009a(Context context, String... strArr) {
        return f26622b.mo38009a(context, strArr) && f26621a.mo38009a(context, strArr);
    }
}
