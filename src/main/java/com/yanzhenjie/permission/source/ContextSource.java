package com.yanzhenjie.permission.source;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import java.lang.reflect.Method;

public class ContextSource extends C7847b {
    /* renamed from: a */
    private Context f26696a;

    public ContextSource(Context context) {
        this.f26696a = context;
    }

    /* renamed from: a */
    public Context mo38075a() {
        return this.f26696a;
    }

    /* renamed from: a */
    public void mo38076a(Intent intent) {
        intent.addFlags(268435456);
        this.f26696a.startActivity(intent);
    }

    /* renamed from: a */
    public void mo38077a(Intent intent, int i) {
        throw new UnsupportedOperationException("Unsupported operation.");
    }

    /* renamed from: a */
    public boolean mo38078a(String str) {
        if (VERSION.SDK_INT < 23) {
            return false;
        }
        PackageManager packageManager = this.f26696a.getPackageManager();
        try {
            Method method = packageManager.getClass().getMethod("shouldShowRequestPermissionRationale", new Class[]{String.class});
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return ((Boolean) method.invoke(packageManager, new Object[]{str})).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }
}
