package com.uber.autodispose.android.p619a;

import android.os.Looper;
import com.uber.autodispose.android.AutoDisposeAndroidPlugins;
import p655io.reactivex.p664d.BooleanSupplier;

/* renamed from: com.uber.autodispose.android.a.a */
public class AutoDisposeAndroidUtil {
    /* renamed from: a */
    private static final BooleanSupplier f25974a = C7695$$Lambda$a$X2WCqeHm1KjBE9b0mrq1QpsBOw.INSTANCE;

    /* access modifiers changed from: private|static|synthetic */
    /* renamed from: b */
    public static /* synthetic */ boolean m33059b() throws Exception {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* renamed from: a */
    public static boolean m33058a() {
        return AutoDisposeAndroidPlugins.m33057a(f25974a);
    }
}
