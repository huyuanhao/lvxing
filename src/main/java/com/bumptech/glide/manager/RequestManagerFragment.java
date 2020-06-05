package com.bumptech.glide.manager;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.util.HashSet;
import java.util.Set;

@Deprecated
/* renamed from: com.bumptech.glide.manager.k */
public class RequestManagerFragment extends Fragment {
    /* renamed from: a */
    private final ActivityFragmentLifecycle f4872a;
    /* renamed from: b */
    private final RequestManagerTreeNode f4873b;
    /* renamed from: c */
    private final Set<RequestManagerFragment> f4874c;
    /* renamed from: d */
    private RequestManager f4875d;
    /* renamed from: e */
    private RequestManagerFragment f4876e;
    /* renamed from: f */
    private Fragment f4877f;

    /* compiled from: RequestManagerFragment */
    /* renamed from: com.bumptech.glide.manager.k$a */
    private class C1756a implements RequestManagerTreeNode {
        C1756a() {
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append("{fragment=");
            sb.append(RequestManagerFragment.this);
            sb.append("}");
            return sb.toString();
        }
    }

    public RequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }

    RequestManagerFragment(ActivityFragmentLifecycle aVar) {
        this.f4873b = new C1756a();
        this.f4874c = new HashSet();
        this.f4872a = aVar;
    }

    /* renamed from: a */
    public void mo13165a(RequestManager iVar) {
        this.f4875d = iVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public ActivityFragmentLifecycle mo13163a() {
        return this.f4872a;
    }

    /* renamed from: b */
    public RequestManager mo13166b() {
        return this.f4875d;
    }

    /* renamed from: c */
    public RequestManagerTreeNode mo13167c() {
        return this.f4873b;
    }

    /* renamed from: a */
    private void m6037a(RequestManagerFragment kVar) {
        this.f4874c.add(kVar);
    }

    /* renamed from: b */
    private void m6038b(RequestManagerFragment kVar) {
        this.f4874c.remove(kVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo13164a(Fragment fragment) {
        this.f4877f = fragment;
        if (fragment != null && fragment.getActivity() != null) {
            m6036a(fragment.getActivity());
        }
    }

    /* renamed from: d */
    private Fragment m6039d() {
        Fragment parentFragment = VERSION.SDK_INT >= 17 ? getParentFragment() : null;
        return parentFragment != null ? parentFragment : this.f4877f;
    }

    /* renamed from: a */
    private void m6036a(Activity activity) {
        m6040e();
        this.f4876e = Glide.m5169a((Context) activity).mo12538g().mo13182b(activity);
        if (!equals(this.f4876e)) {
            this.f4876e.m6037a(this);
        }
    }

    /* renamed from: e */
    private void m6040e() {
        RequestManagerFragment kVar = this.f4876e;
        if (kVar != null) {
            kVar.m6038b(this);
            this.f4876e = null;
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            m6036a(activity);
        } catch (IllegalStateException e) {
            String str = "RMFragment";
            if (Log.isLoggable(str, 5)) {
                Log.w(str, "Unable to register fragment with root", e);
            }
        }
    }

    public void onDetach() {
        super.onDetach();
        m6040e();
    }

    public void onStart() {
        super.onStart();
        this.f4872a.mo13155a();
    }

    public void onStop() {
        super.onStop();
        this.f4872a.mo13157b();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f4872a.mo13159c();
        m6040e();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{parent=");
        sb.append(m6039d());
        sb.append("}");
        return sb.toString();
    }
}
