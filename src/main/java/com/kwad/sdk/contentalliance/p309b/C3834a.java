package com.kwad.sdk.contentalliance.p309b;

import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import com.kwad.sdk.core.p319c.C4065b;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.sdk.contentalliance.b.a */
public abstract class C3834a extends PagerAdapter {
    /* renamed from: a */
    protected final SparseArray<List<Fragment>> f12963a = new SparseArray<>();
    /* renamed from: b */
    protected Fragment f12964b = null;
    /* renamed from: c */
    private final FragmentManager f12965c;
    /* renamed from: d */
    private FragmentTransaction f12966d = null;
    /* renamed from: e */
    private boolean f12967e;

    public C3834a(FragmentManager fragmentManager) {
        this.f12965c = fragmentManager;
    }

    /* renamed from: a */
    private static String m15921a(int i, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("android:switcher:");
        sb.append(i);
        sb.append(":");
        sb.append(j);
        return sb.toString();
    }

    /* renamed from: c */
    private List<Fragment> m15922c(int i) {
        return (List) this.f12963a.get(i);
    }

    /* renamed from: d */
    private long m15923d(int i) {
        return (long) i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo23241a(int i) {
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo23242a(Fragment fragment) {
        return 0;
    }

    /* renamed from: a */
    public abstract Fragment mo23243a(int i, int i2);

    /* renamed from: a */
    public abstract void mo23244a(Fragment fragment, int i, int i2);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo23245b(int i) {
        return true;
    }

    /* renamed from: b */
    public abstract boolean mo23246b(Fragment fragment);

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.f12966d == null) {
            this.f12966d = this.f12965c.beginTransaction();
        }
        Fragment fragment = (Fragment) obj;
        if (!this.f12967e) {
            this.f12966d.detach(fragment);
            if (mo23246b(fragment)) {
                int a = mo23242a(fragment);
                if (mo23245b(a)) {
                    List c = m15922c(a);
                    if (c == null) {
                        c = new ArrayList();
                        this.f12963a.put(a, c);
                    }
                    c.add(fragment);
                    return;
                }
            } else {
                return;
            }
        }
        this.f12966d.remove(fragment);
    }

    public void finishUpdate(ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.f12966d;
        if (fragmentTransaction != null) {
            try {
                fragmentTransaction.commitNowAllowingStateLoss();
            } catch (Exception e) {
                C4065b.m16865a(e);
            }
            this.f12966d = null;
        }
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.f12966d == null) {
            this.f12966d = this.f12965c.beginTransaction();
        }
        long d = m15923d(i);
        int a = mo23241a(i);
        Fragment fragment = null;
        List c = m15922c(a);
        if (c != null && c.size() > 0) {
            fragment = (Fragment) c.remove(0);
        }
        if (fragment != null) {
            mo23244a(fragment, i, a);
            this.f12966d.attach(fragment);
        } else {
            fragment = mo23243a(i, a);
            mo23244a(fragment, i, a);
            this.f12966d.add(viewGroup.getId(), fragment, m15921a(viewGroup.getId(), d));
        }
        if (fragment != this.f12964b) {
            fragment.setMenuVisibility(false);
            fragment.setUserVisibleHint(false);
        }
        return fragment;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable saveState() {
        return null;
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f12964b;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                this.f12964b.setUserVisibleHint(false);
            }
            fragment.setMenuVisibility(true);
            fragment.setUserVisibleHint(true);
            this.f12964b = fragment;
        }
    }

    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            StringBuilder sb = new StringBuilder();
            sb.append("ViewPager with adapter ");
            sb.append(this);
            sb.append(" requires a view id");
            throw new IllegalStateException(sb.toString());
        }
    }
}
