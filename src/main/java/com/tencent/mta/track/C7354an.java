package com.tencent.mta.track;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import java.util.Iterator;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.an */
class C7354an implements ActivityLifecycleCallbacks {
    /* renamed from: a */
    final /* synthetic */ C7350aj f24890a;
    /* renamed from: b */
    private final C7353am f24891b = new C7353am(this.f24890a);
    /* renamed from: c */
    private boolean f24892c = false;

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public C7354an(C7350aj ajVar) {
        this.f24890a = ajVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo35873a() {
        this.f24892c = true;
        this.f24891b.mo35870a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo35874b() {
        this.f24892c = false;
        this.f24891b.mo35871b();
    }

    public void onActivityResumed(Activity activity) {
        Intent intent = activity.getIntent();
        if (intent != null) {
            Uri data = intent.getData();
            if (data != null && data.toString().startsWith("mtaautotrack")) {
                this.f24890a.mo35860b();
            }
        }
        boolean z = this.f24892c;
        this.f24890a.f24885i.add(activity);
        Iterator it = this.f24890a.f24886j.iterator();
        while (it.hasNext()) {
            if (((String) it.next()).equals(activity.getClass().getCanonicalName())) {
                return;
            }
        }
        this.f24890a.f24882f.mo35864b(activity);
    }

    public void onActivityPaused(Activity activity) {
        this.f24890a.f24885i.remove(activity);
        this.f24890a.f24882f.mo35863a(activity);
        if (this.f24890a.f24882f.mo35865b()) {
            this.f24891b.mo35871b();
        }
    }

    public void onActivityStopped(Activity activity) {
        if (this.f24890a.f24885i.size() == 0) {
            StatisticsDataAPI.sharedInstance(this.f24890a.f24879c).mo35809a();
        }
    }
}
