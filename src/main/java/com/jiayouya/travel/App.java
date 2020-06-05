package com.jiayouya.travel;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import androidx.multidex.MultiDexApplication;
import com.p006a.p007a.LeakCanary;
import com.tencent.android.otherPush.StubAppUtils;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Ref.IntRef;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0002¨\u0006\n"}, mo39189d2 = {"Lcom/jiayouya/travel/App;", "Landroidx/multidex/MultiDexApplication;", "()V", "attachBaseContext", "", "base", "Landroid/content/Context;", "onCreate", "registerLifecycle", "Companion", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: App.kt */
public final class App extends MultiDexApplication {
    /* renamed from: a */
    public static App f9532a;
    /* renamed from: b */
    public static final C2823a f9533b = new C2823a(null);

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, mo39189d2 = {"Lcom/jiayouya/travel/App$Companion;", "", "()V", "INSTANCE", "Lcom/jiayouya/travel/App;", "INSTANCE$annotations", "getINSTANCE", "()Lcom/jiayouya/travel/App;", "setINSTANCE", "(Lcom/jiayouya/travel/App;)V", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: App.kt */
    /* renamed from: com.jiayouya.travel.App$a */
    public static final class C2823a {
        private C2823a() {
        }

        public /* synthetic */ C2823a(DefaultConstructorMarker fVar) {
            this();
        }

        /* renamed from: a */
        public final App mo19801a() {
            App a = App.f9532a;
            if (a == null) {
                C8271i.m35387b("INSTANCE");
            }
            return a;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000f"}, mo39189d2 = {"com/jiayouya/travel/App$registerLifecycle$1", "Landroid/app/Application$ActivityLifecycleCallbacks;", "onActivityCreated", "", "p0", "Landroid/app/Activity;", "p1", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "a", "onActivitySaveInstanceState", "onActivityStarted", "onActivityStopped", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: App.kt */
    /* renamed from: com.jiayouya.travel.App$b */
    public static final class C2824b implements ActivityLifecycleCallbacks {
        /* renamed from: a */
        final /* synthetic */ IntRef f9534a;

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        C2824b(IntRef intRef) {
            this.f9534a = intRef;
        }

        public void onActivityResumed(Activity activity) {
            Activity activity2 = (Activity) C2834a.f9542a.mo19812a().get();
            if (activity2 == null || (!C8271i.m35384a((Object) activity2, (Object) activity))) {
                C2834a.f9542a.mo19813a(new WeakReference(activity));
            }
        }

        public void onActivityStarted(Activity activity) {
            this.f9534a.element++;
        }

        public void onActivityStopped(Activity activity) {
            this.f9534a.element--;
            int i = this.f9534a.element;
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        C8271i.m35386b(context, "base");
        super.attachBaseContext(context);
        StubAppUtils.attachBaseContext(context);
    }

    public void onCreate() {
        super.onCreate();
        if (!LeakCanary.m1058a(this)) {
            f9532a = this;
            Launcher.f9545a.mo19815a((Application) this);
            m12733b();
        }
    }

    /* renamed from: b */
    private final void m12733b() {
        IntRef intRef = new IntRef();
        intRef.element = 0;
        registerActivityLifecycleCallbacks(new C2824b(intRef));
    }
}
