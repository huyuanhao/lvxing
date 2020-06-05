package com.jiayouya.travel;

import android.app.Activity;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, mo39189d2 = {"Lcom/jiayouya/travel/ActivityStack;", "", "()V", "topActivity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "getTopActivity", "()Ljava/lang/ref/WeakReference;", "setTopActivity", "(Ljava/lang/ref/WeakReference;)V", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: App.kt */
/* renamed from: com.jiayouya.travel.a */
public final class C2834a {
    /* renamed from: a */
    public static final C2834a f9542a = new C2834a();
    /* renamed from: b */
    private static WeakReference<Activity> f9543b = new WeakReference<>(null);

    private C2834a() {
    }

    /* renamed from: a */
    public final WeakReference<Activity> mo19812a() {
        return f9543b;
    }

    /* renamed from: a */
    public final void mo19813a(WeakReference<Activity> weakReference) {
        C8271i.m35386b(weakReference, "<set-?>");
        f9543b = weakReference;
    }
}
