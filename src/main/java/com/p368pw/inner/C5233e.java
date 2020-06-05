package com.p368pw.inner;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.p368pw.inner.base.C5139c;
import com.p368pw.inner.base.p384a.C5125f;
import com.p368pw.inner.base.p384a.C5125f.C5127a;
import com.p368pw.inner.base.p385b.C5131a;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5208r;
import com.p368pw.inner.base.stat.C5224e;
import com.p368pw.inner.p369a.p370a.p373c.C4853i;
import com.p368pw.inner.p369a.p370a.p373c.p375b.C4842a;
import java.lang.ref.SoftReference;

/* renamed from: com.pw.inner.e */
public class C5233e implements ActivityLifecycleCallbacks {
    /* renamed from: a */
    private static volatile Context f17041a;
    /* renamed from: b */
    private boolean f17042b = false;
    /* renamed from: c */
    private String f17043c = null;
    /* renamed from: d */
    private SoftReference<Activity> f17044d;
    /* renamed from: e */
    private boolean f17045e = false;

    /* renamed from: com.pw.inner.e$a */
    private static class C5236a {
        /* access modifiers changed from: private|static */
        /* renamed from: a */
        public static C5233e f17050a = new C5233e();
    }

    /* renamed from: a */
    public static C5233e m21558a() {
        return C5236a.f17050a;
    }

    /* renamed from: b */
    public static Context m21559b() {
        if (f17041a != null) {
            return f17041a;
        }
        throw new IllegalStateException("not init");
    }

    /* renamed from: a */
    public synchronized void mo26925a(final Application application, String str, String str2) {
        if (application == null) {
            C5205o.m21465b("application is null");
            return;
        }
        f17041a = application.getApplicationContext();
        if (TextUtils.isEmpty(str)) {
            C5205o.m21465b("appkey is null");
            return;
        } else if (!this.f17042b) {
            try {
                application.registerActivityLifecycleCallbacks(this);
                this.f17043c = str;
                C5237f.m21576a(f17041a, str);
                C5237f.m21581b(f17041a, str2);
                C5125f.m21216a().mo26724a(f17041a, (C5127a) new C5127a() {
                    /* renamed from: a */
                    public void mo26730a() {
                        C4853i.m19921a().mo25864a((Context) application);
                    }
                });
                C5139c.m21256a().mo26745a(f17041a);
                C5224e.m21525a().mo26910a(f17041a);
                C5069b.m21115a().mo26581a(f17041a);
                C5131a.m21242a().mo26735a(f17041a);
                C5208r.m21482b(new Runnable() {
                    public void run() {
                        C4842a.m19880a((Context) application);
                    }
                });
                this.f17042b = true;
                C5205o.m21466c("init success");
            } catch (Throwable th) {
                C5205o.m21464a(th);
            }
        } else {
            return;
        }
        return;
    }

    /* renamed from: a */
    public void mo26926a(boolean z) {
        C5205o.f16928a = z;
        C5205o.m21467d("debug mode");
    }

    /* renamed from: b */
    public void mo26927b(boolean z) {
        this.f17045e = z;
    }

    /* renamed from: c */
    public String mo26928c() {
        return this.f17043c;
    }

    /* renamed from: d */
    public boolean mo26929d() {
        return this.f17045e;
    }

    /* renamed from: e */
    public Activity mo26930e() {
        return (Activity) this.f17044d.get();
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        this.f17044d = new SoftReference<>(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
