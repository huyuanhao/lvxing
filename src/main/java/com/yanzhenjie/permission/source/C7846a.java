package com.yanzhenjie.permission.source;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;

/* compiled from: ActivitySource */
/* renamed from: com.yanzhenjie.permission.source.a */
public class C7846a extends C7847b {
    /* renamed from: a */
    private Activity f26697a;

    public C7846a(Activity activity) {
        this.f26697a = activity;
    }

    /* renamed from: a */
    public Context mo38075a() {
        return this.f26697a;
    }

    /* renamed from: a */
    public void mo38076a(Intent intent) {
        this.f26697a.startActivity(intent);
    }

    /* renamed from: a */
    public void mo38077a(Intent intent, int i) {
        this.f26697a.startActivityForResult(intent, i);
    }

    /* renamed from: a */
    public boolean mo38078a(String str) {
        if (VERSION.SDK_INT < 23) {
            return false;
        }
        return this.f26697a.shouldShowRequestPermissionRationale(str);
    }
}
