package com.jiayouya.travel.module.common.widget;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;

public class SimplePagerAdapter extends PagerAdapter {
    /* renamed from: a */
    private Fragment[] f11347a;
    /* renamed from: b */
    private FragmentManager f11348b;
    /* renamed from: c */
    private FragmentTransaction f11349c = null;
    /* renamed from: d */
    private Fragment f11350d = null;

    /* renamed from: a */
    private void m13614a(String str) {
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable saveState() {
        return null;
    }

    public void startUpdate(ViewGroup viewGroup) {
    }

    public SimplePagerAdapter(FragmentManager fragmentManager, Fragment[] fragmentArr) {
        this.f11348b = fragmentManager;
        this.f11347a = fragmentArr;
    }

    public int getCount() {
        return this.f11347a.length;
    }

    /* renamed from: a */
    private static String m13613a(int i, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("ezy:tabs:");
        sb.append(i);
        sb.append(":");
        sb.append(j);
        return sb.toString();
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.f11349c == null) {
            this.f11349c = this.f11348b.beginTransaction();
        }
        long j = (long) i;
        Fragment fragment = this.f11347a[i];
        if (!fragment.isAdded()) {
            this.f11349c.add(viewGroup.getId(), fragment, m13613a(viewGroup.getId(), j));
            StringBuilder sb = new StringBuilder();
            sb.append("Adding item #");
            sb.append(j);
            sb.append(": f=");
            sb.append(fragment);
            m13614a(sb.toString());
        }
        this.f11349c.show(fragment);
        if (fragment != this.f11350d) {
            fragment.setMenuVisibility(false);
            fragment.setUserVisibleHint(false);
        }
        return fragment;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.f11349c == null) {
            this.f11349c = this.f11348b.beginTransaction();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("hide item #");
        sb.append(i);
        sb.append(": f=");
        sb.append(obj);
        sb.append(" v=");
        Fragment fragment = (Fragment) obj;
        sb.append(fragment.getView());
        m13614a(sb.toString());
        this.f11349c.hide(fragment);
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f11350d;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                this.f11350d.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.f11350d = fragment;
        }
    }

    public void finishUpdate(ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.f11349c;
        if (fragmentTransaction != null) {
            fragmentTransaction.commitAllowingStateLoss();
            this.f11349c = null;
            this.f11348b.executePendingTransactions();
        }
    }

    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }
}
