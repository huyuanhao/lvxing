package ezy.sdk3rd.social.sdk;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import ezy.sdk3rd.social.sdk.IResult;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: Sdk */
/* renamed from: ezy.sdk3rd.social.sdk.h */
public class C8036h<T extends IResult> {
    /* renamed from: a */
    private Map<String, T> f27299a = new HashMap();
    /* renamed from: b */
    private Map<Activity, Map<String, T>> f27300b = new WeakHashMap();
    /* renamed from: c */
    private Map<String, IFactory<T>> f27301c = new HashMap();
    /* renamed from: d */
    private OnCallback f27302d;

    /* compiled from: Sdk */
    /* renamed from: ezy.sdk3rd.social.sdk.h$a */
    private class C8037a implements ActivityLifecycleCallbacks {
        /* renamed from: b */
        private final Activity f27304b;
        /* renamed from: c */
        private final IResult f27305c;

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        public C8037a(Activity activity, IResult eVar) {
            this.f27304b = activity;
            this.f27305c = eVar;
        }

        public void onActivityDestroyed(Activity activity) {
            if (activity == this.f27304b) {
                activity.getApplication().unregisterActivityLifecycleCallbacks(this);
                IResult eVar = this.f27305c;
                if (eVar instanceof IDisposable) {
                    ((IDisposable) eVar).onDispose();
                }
            }
        }
    }

    /* renamed from: a */
    public OnCallback mo38620a() {
        return this.f27302d;
    }

    /* renamed from: a */
    public void mo38621a(String str, String str2, Class cls) {
        this.f27301c.put(str, new DefaultFactory(str, str2, cls));
    }

    /* renamed from: a */
    public boolean mo38622a(String str) {
        return this.f27301c.get(str) != null;
    }

    /* renamed from: a */
    public T mo38619a(Activity activity, String str) {
        Map map = (Map) this.f27300b.get(activity);
        if (map == null) {
            map = new HashMap();
            this.f27300b.put(activity, map);
        }
        T t = (IResult) map.get(str);
        if (t == null) {
            IFactory dVar = (IFactory) this.f27301c.get(str);
            if (dVar != null) {
                t = dVar.mo38618a(activity);
                if (t != null) {
                    map.put(str, t);
                    activity.getApplication().registerActivityLifecycleCallbacks(new C8037a(activity, t));
                }
            }
        }
        return t;
    }
}
