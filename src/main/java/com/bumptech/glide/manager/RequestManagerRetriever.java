package com.bumptech.glide.manager;

import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.util.C1772j;
import com.bumptech.glide.util.Preconditions;
import com.tencent.android.tpush.SettingsContentProvider;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.bumptech.glide.manager.l */
public class RequestManagerRetriever implements Callback {
    /* renamed from: i */
    private static final C1758a f4879i = new C1758a() {
        /* renamed from: a */
        public RequestManager mo12411a(Glide eVar, Lifecycle hVar, RequestManagerTreeNode mVar, Context context) {
            return new RequestManager(eVar, hVar, mVar, context);
        }
    };
    /* renamed from: a */
    final Map<FragmentManager, RequestManagerFragment> f4880a = new HashMap();
    /* renamed from: b */
    final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> f4881b = new HashMap();
    /* renamed from: c */
    private volatile RequestManager f4882c;
    /* renamed from: d */
    private final Handler f4883d;
    /* renamed from: e */
    private final C1758a f4884e;
    /* renamed from: f */
    private final ArrayMap<View, Fragment> f4885f = new ArrayMap<>();
    /* renamed from: g */
    private final ArrayMap<View, android.app.Fragment> f4886g = new ArrayMap<>();
    /* renamed from: h */
    private final Bundle f4887h = new Bundle();

    /* compiled from: RequestManagerRetriever */
    /* renamed from: com.bumptech.glide.manager.l$a */
    public interface C1758a {
        /* renamed from: a */
        RequestManager mo12411a(Glide eVar, Lifecycle hVar, RequestManagerTreeNode mVar, Context context);
    }

    public RequestManagerRetriever(C1758a aVar) {
        if (aVar == null) {
            aVar = f4879i;
        }
        this.f4884e = aVar;
        this.f4883d = new Handler(Looper.getMainLooper(), this);
    }

    /* renamed from: b */
    private RequestManager m6054b(Context context) {
        if (this.f4882c == null) {
            synchronized (this) {
                if (this.f4882c == null) {
                    this.f4882c = this.f4884e.mo12411a(Glide.m5169a(context.getApplicationContext()), new ApplicationLifecycle(), new EmptyRequestManagerTreeNode(), context.getApplicationContext());
                }
            }
        }
        return this.f4882c;
    }

    /* renamed from: a */
    public RequestManager mo13177a(Context context) {
        if (context != null) {
            if (C1772j.m6159b() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    return mo13180a((FragmentActivity) context);
                }
                if (context instanceof Activity) {
                    return mo13175a((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    return mo13177a(((ContextWrapper) context).getBaseContext());
                }
            }
            return m6054b(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    /* renamed from: a */
    public RequestManager mo13180a(FragmentActivity fragmentActivity) {
        if (C1772j.m6161c()) {
            return mo13177a(fragmentActivity.getApplicationContext());
        }
        m6057c((Activity) fragmentActivity);
        return m6049a((Context) fragmentActivity, fragmentActivity.getSupportFragmentManager(), (Fragment) null, m6058d(fragmentActivity));
    }

    /* renamed from: a */
    public RequestManager mo13179a(Fragment fragment) {
        Preconditions.m6139a(fragment.getActivity(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (C1772j.m6161c()) {
            return mo13177a(fragment.getActivity().getApplicationContext());
        }
        return m6049a((Context) fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    /* renamed from: a */
    public RequestManager mo13175a(Activity activity) {
        if (C1772j.m6161c()) {
            return mo13177a(activity.getApplicationContext());
        }
        m6057c(activity);
        return m6048a((Context) activity, activity.getFragmentManager(), (android.app.Fragment) null, m6058d(activity));
    }

    /* renamed from: a */
    public RequestManager mo13178a(View view) {
        if (C1772j.m6161c()) {
            return mo13177a(view.getContext().getApplicationContext());
        }
        Preconditions.m6138a(view);
        Preconditions.m6139a(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity c = m6056c(view.getContext());
        if (c == null) {
            return mo13177a(view.getContext().getApplicationContext());
        }
        if (c instanceof FragmentActivity) {
            Fragment a = m6047a(view, (FragmentActivity) c);
            return a != null ? mo13179a(a) : mo13175a(c);
        }
        android.app.Fragment a2 = m6046a(view, c);
        if (a2 == null) {
            return mo13175a(c);
        }
        return mo13176a(a2);
    }

    /* renamed from: a */
    private static void m6053a(Collection<Fragment> collection, Map<View, Fragment> map) {
        if (collection != null) {
            for (Fragment fragment : collection) {
                if (fragment != null) {
                    if (fragment.getView() != null) {
                        map.put(fragment.getView(), fragment);
                        m6053a((Collection<Fragment>) fragment.getChildFragmentManager().getFragments(), map);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private Fragment m6047a(View view, FragmentActivity fragmentActivity) {
        this.f4885f.clear();
        m6053a((Collection<Fragment>) fragmentActivity.getSupportFragmentManager().getFragments(), (Map<View, Fragment>) this.f4885f);
        View findViewById = fragmentActivity.findViewById(16908290);
        Fragment fragment = null;
        while (!view.equals(findViewById)) {
            fragment = (Fragment) this.f4885f.get(view);
            if (fragment != null || !(view.getParent() instanceof View)) {
                break;
            }
            view = (View) view.getParent();
        }
        this.f4885f.clear();
        return fragment;
    }

    @Deprecated
    /* renamed from: a */
    private android.app.Fragment m6046a(View view, Activity activity) {
        this.f4886g.clear();
        m6052a(activity.getFragmentManager(), this.f4886g);
        View findViewById = activity.findViewById(16908290);
        android.app.Fragment fragment = null;
        while (!view.equals(findViewById)) {
            fragment = (android.app.Fragment) this.f4886g.get(view);
            if (fragment != null || !(view.getParent() instanceof View)) {
                break;
            }
            view = (View) view.getParent();
        }
        this.f4886g.clear();
        return fragment;
    }

    @Deprecated
    /* renamed from: a */
    private void m6052a(FragmentManager fragmentManager, ArrayMap<View, android.app.Fragment> arrayMap) {
        if (VERSION.SDK_INT >= 26) {
            for (android.app.Fragment fragment : fragmentManager.getFragments()) {
                if (fragment.getView() != null) {
                    arrayMap.put(fragment.getView(), fragment);
                    m6052a(fragment.getChildFragmentManager(), arrayMap);
                }
            }
            return;
        }
        m6055b(fragmentManager, arrayMap);
    }

    @Deprecated
    /* renamed from: b */
    private void m6055b(FragmentManager fragmentManager, ArrayMap<View, android.app.Fragment> arrayMap) {
        int i = 0;
        while (true) {
            Bundle bundle = this.f4887h;
            int i2 = i + 1;
            String str = SettingsContentProvider.KEY;
            bundle.putInt(str, i);
            android.app.Fragment fragment = null;
            try {
                fragment = fragmentManager.getFragment(this.f4887h, str);
            } catch (Exception unused) {
            }
            if (fragment != null) {
                if (fragment.getView() != null) {
                    arrayMap.put(fragment.getView(), fragment);
                    if (VERSION.SDK_INT >= 17) {
                        m6052a(fragment.getChildFragmentManager(), arrayMap);
                    }
                }
                i = i2;
            } else {
                return;
            }
        }
    }

    /* renamed from: c */
    private Activity m6056c(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return m6056c(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    /* renamed from: c */
    private static void m6057c(Activity activity) {
        if (VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @Deprecated
    /* renamed from: a */
    public RequestManager mo13176a(android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        } else if (C1772j.m6161c() || VERSION.SDK_INT < 17) {
            return mo13177a(fragment.getActivity().getApplicationContext());
        } else {
            return m6048a((Context) fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
        }
    }

    /* access modifiers changed from: 0000 */
    @Deprecated
    /* renamed from: b */
    public RequestManagerFragment mo13182b(Activity activity) {
        return m6051a(activity.getFragmentManager(), (android.app.Fragment) null, m6058d(activity));
    }

    /* renamed from: a */
    private RequestManagerFragment m6051a(FragmentManager fragmentManager, android.app.Fragment fragment, boolean z) {
        String str = "com.bumptech.glide.manager";
        RequestManagerFragment kVar = (RequestManagerFragment) fragmentManager.findFragmentByTag(str);
        if (kVar == null) {
            kVar = (RequestManagerFragment) this.f4880a.get(fragmentManager);
            if (kVar == null) {
                kVar = new RequestManagerFragment();
                kVar.mo13164a(fragment);
                if (z) {
                    kVar.mo13163a().mo13155a();
                }
                this.f4880a.put(fragmentManager, kVar);
                fragmentManager.beginTransaction().add(kVar, str).commitAllowingStateLoss();
                this.f4883d.obtainMessage(1, fragmentManager).sendToTarget();
            }
        }
        return kVar;
    }

    @Deprecated
    /* renamed from: a */
    private RequestManager m6048a(Context context, FragmentManager fragmentManager, android.app.Fragment fragment, boolean z) {
        RequestManagerFragment a = m6051a(fragmentManager, fragment, z);
        RequestManager b = a.mo13166b();
        if (b != null) {
            return b;
        }
        RequestManager a2 = this.f4884e.mo12411a(Glide.m5169a(context), a.mo13163a(), a.mo13167c(), context);
        a.mo13165a(a2);
        return a2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public SupportRequestManagerFragment mo13181b(FragmentActivity fragmentActivity) {
        return m6050a(fragmentActivity.getSupportFragmentManager(), (Fragment) null, m6058d(fragmentActivity));
    }

    /* renamed from: d */
    private static boolean m6058d(Activity activity) {
        return !activity.isFinishing();
    }

    /* renamed from: a */
    private SupportRequestManagerFragment m6050a(androidx.fragment.app.FragmentManager fragmentManager, Fragment fragment, boolean z) {
        String str = "com.bumptech.glide.manager";
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag(str);
        if (supportRequestManagerFragment == null) {
            supportRequestManagerFragment = (SupportRequestManagerFragment) this.f4881b.get(fragmentManager);
            if (supportRequestManagerFragment == null) {
                supportRequestManagerFragment = new SupportRequestManagerFragment();
                supportRequestManagerFragment.mo13150a(fragment);
                if (z) {
                    supportRequestManagerFragment.mo13149a().mo13155a();
                }
                this.f4881b.put(fragmentManager, supportRequestManagerFragment);
                fragmentManager.beginTransaction().add((Fragment) supportRequestManagerFragment, str).commitAllowingStateLoss();
                this.f4883d.obtainMessage(2, fragmentManager).sendToTarget();
            }
        }
        return supportRequestManagerFragment;
    }

    /* renamed from: a */
    private RequestManager m6049a(Context context, androidx.fragment.app.FragmentManager fragmentManager, Fragment fragment, boolean z) {
        SupportRequestManagerFragment a = m6050a(fragmentManager, fragment, z);
        RequestManager b = a.mo13152b();
        if (b != null) {
            return b;
        }
        RequestManager a2 = this.f4884e.mo12411a(Glide.m5169a(context), a.mo13149a(), a.mo13153c(), context);
        a.mo13151a(a2);
        return a2;
    }

    public boolean handleMessage(Message message) {
        Object obj;
        int i = message.what;
        Object obj2 = null;
        boolean z = true;
        if (i == 1) {
            obj2 = (FragmentManager) message.obj;
            obj = this.f4880a.remove(obj2);
        } else if (i != 2) {
            z = false;
            obj = null;
        } else {
            obj2 = (androidx.fragment.app.FragmentManager) message.obj;
            obj = this.f4881b.remove(obj2);
        }
        if (z && obj == null) {
            String str = "RMRetriever";
            if (Log.isLoggable(str, 5)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to remove expected request manager fragment, manager: ");
                sb.append(obj2);
                Log.w(str, sb.toString());
            }
        }
        return z;
    }
}
