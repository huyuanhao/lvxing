package com.jiayouya.travel.module.common.widget;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.jiayouya.travel.module.common.widget.a */
public class FragmentSwitcher {
    /* renamed from: a */
    Map<String, Fragment> f11351a = new HashMap();
    /* renamed from: b */
    private FragmentActivity f11352b;
    /* renamed from: c */
    private FragmentManager f11353c;
    /* renamed from: d */
    private Fragment f11354d = null;
    /* renamed from: e */
    private int f11355e;

    public FragmentSwitcher(FragmentActivity fragmentActivity, int i) {
        this.f11352b = fragmentActivity;
        this.f11353c = fragmentActivity.getSupportFragmentManager();
        this.f11355e = i;
    }

    /* renamed from: a */
    public void mo20756a(String str, Fragment fragment) {
        this.f11351a.put(str, fragment);
    }

    /* renamed from: a */
    public void mo20755a(String str) {
        if (this.f11351a.containsKey(str)) {
            Fragment fragment = (Fragment) this.f11351a.get(str);
            if (fragment != this.f11354d) {
                FragmentTransaction beginTransaction = this.f11353c.beginTransaction();
                Fragment fragment2 = this.f11354d;
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(false);
                    this.f11354d.setUserVisibleHint(false);
                    beginTransaction.hide(this.f11354d);
                }
                this.f11354d = fragment;
                if (!fragment.isAdded()) {
                    beginTransaction.add(this.f11355e, fragment, str);
                } else {
                    beginTransaction.show(fragment);
                }
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
                beginTransaction.commitAllowingStateLoss();
                this.f11353c.executePendingTransactions();
            }
        }
    }
}
