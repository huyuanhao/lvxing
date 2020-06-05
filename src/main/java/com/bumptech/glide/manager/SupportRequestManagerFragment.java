package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.util.HashSet;
import java.util.Set;

public class SupportRequestManagerFragment extends Fragment {
    /* renamed from: a */
    private final ActivityFragmentLifecycle f4856a;
    /* renamed from: b */
    private final RequestManagerTreeNode f4857b;
    /* renamed from: c */
    private final Set<SupportRequestManagerFragment> f4858c;
    /* renamed from: d */
    private SupportRequestManagerFragment f4859d;
    /* renamed from: e */
    private RequestManager f4860e;
    /* renamed from: f */
    private Fragment f4861f;

    /* renamed from: com.bumptech.glide.manager.SupportRequestManagerFragment$a */
    private class C1753a implements RequestManagerTreeNode {
        C1753a() {
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append("{fragment=");
            sb.append(SupportRequestManagerFragment.this);
            sb.append("}");
            return sb.toString();
        }
    }

    public SupportRequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }

    public SupportRequestManagerFragment(ActivityFragmentLifecycle aVar) {
        this.f4857b = new C1753a();
        this.f4858c = new HashSet();
        this.f4856a = aVar;
    }

    /* renamed from: a */
    public void mo13151a(RequestManager iVar) {
        this.f4860e = iVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public ActivityFragmentLifecycle mo13149a() {
        return this.f4856a;
    }

    /* renamed from: b */
    public RequestManager mo13152b() {
        return this.f4860e;
    }

    /* renamed from: c */
    public RequestManagerTreeNode mo13153c() {
        return this.f4857b;
    }

    /* renamed from: a */
    private void m6012a(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f4858c.add(supportRequestManagerFragment);
    }

    /* renamed from: b */
    private void m6013b(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f4858c.remove(supportRequestManagerFragment);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo13150a(Fragment fragment) {
        this.f4861f = fragment;
        if (fragment != null && fragment.getActivity() != null) {
            m6011a(fragment.getActivity());
        }
    }

    /* renamed from: d */
    private Fragment m6014d() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f4861f;
    }

    /* renamed from: a */
    private void m6011a(FragmentActivity fragmentActivity) {
        m6015e();
        this.f4859d = Glide.m5169a((Context) fragmentActivity).mo12538g().mo13181b(fragmentActivity);
        if (!equals(this.f4859d)) {
            this.f4859d.m6012a(this);
        }
    }

    /* renamed from: e */
    private void m6015e() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.f4859d;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.m6013b(this);
            this.f4859d = null;
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            m6011a(getActivity());
        } catch (IllegalStateException e) {
            String str = "SupportRMFragment";
            if (Log.isLoggable(str, 5)) {
                Log.w(str, "Unable to register fragment with root", e);
            }
        }
    }

    public void onDetach() {
        super.onDetach();
        this.f4861f = null;
        m6015e();
    }

    public void onStart() {
        super.onStart();
        this.f4856a.mo13155a();
    }

    public void onStop() {
        super.onStop();
        this.f4856a.mo13157b();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f4856a.mo13159c();
        m6015e();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{parent=");
        sb.append(m6014d());
        sb.append("}");
        return sb.toString();
    }
}
