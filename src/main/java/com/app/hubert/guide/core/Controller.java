package com.app.hubert.guide.core;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.app.hubert.guide.core.GuideLayout.C1586a;
import com.app.hubert.guide.lifecycle.FragmentLifecycleAdapter;
import com.app.hubert.guide.lifecycle.ListenerFragment;
import com.app.hubert.guide.lifecycle.V4ListenerFragment;
import com.app.hubert.guide.model.GuidePage;
import com.app.hubert.guide.p127a.OnGuideChangedListener;
import com.app.hubert.guide.p127a.OnPageChangedListener;
import com.app.hubert.guide.p128b.LogUtil;
import java.lang.reflect.Field;
import java.util.List;

/* renamed from: com.app.hubert.guide.core.b */
public class Controller {
    /* renamed from: a */
    private Activity f4046a;
    /* renamed from: b */
    private Fragment f4047b;
    /* renamed from: c */
    private androidx.fragment.app.Fragment f4048c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public OnGuideChangedListener f4049d;
    /* renamed from: e */
    private OnPageChangedListener f4050e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public String f4051f;
    /* renamed from: g */
    private boolean f4052g;
    /* renamed from: h */
    private int f4053h;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public List<GuidePage> f4054i;
    /* access modifiers changed from: private */
    /* renamed from: j */
    public int f4055j;
    /* renamed from: k */
    private GuideLayout f4056k;
    /* renamed from: l */
    private FrameLayout f4057l;
    /* access modifiers changed from: private */
    /* renamed from: m */
    public SharedPreferences f4058m;
    /* renamed from: n */
    private int f4059n = -1;

    public Controller(Builder aVar) {
        this.f4046a = aVar.f4036a;
        this.f4047b = aVar.f4037b;
        this.f4048c = aVar.f4038c;
        this.f4049d = aVar.f4043h;
        this.f4050e = aVar.f4044i;
        this.f4051f = aVar.f4039d;
        this.f4052g = aVar.f4040e;
        this.f4054i = aVar.f4045j;
        this.f4053h = aVar.f4042g;
        View view = aVar.f4041f;
        if (view == null) {
            view = this.f4046a.findViewById(16908290);
        }
        if (view instanceof FrameLayout) {
            this.f4057l = (FrameLayout) view;
        } else {
            FrameLayout frameLayout = new FrameLayout(this.f4046a);
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            this.f4059n = viewGroup.indexOfChild(view);
            viewGroup.removeView(view);
            int i = this.f4059n;
            if (i >= 0) {
                viewGroup.addView(frameLayout, i, view.getLayoutParams());
            } else {
                viewGroup.addView(frameLayout, view.getLayoutParams());
            }
            frameLayout.addView(view, new LayoutParams(-1, -1));
            this.f4057l = frameLayout;
        }
        this.f4058m = this.f4046a.getSharedPreferences("NewbieGuide", 0);
    }

    /* renamed from: a */
    public void mo12303a() {
        final int i = this.f4058m.getInt(this.f4051f, 0);
        if (this.f4052g || i < this.f4053h) {
            this.f4057l.post(new Runnable() {
                public void run() {
                    if (Controller.this.f4054i == null || Controller.this.f4054i.size() == 0) {
                        throw new IllegalStateException("there is no guide to show!! Please add at least one Page.");
                    }
                    Controller.this.f4055j = 0;
                    Controller.this.m4802c();
                    if (Controller.this.f4049d != null) {
                        Controller.this.f4049d.mo12284a(Controller.this);
                    }
                    Controller.this.m4806e();
                    Controller.this.f4058m.edit().putInt(Controller.this.f4051f, i + 1).apply();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m4802c() {
        GuideLayout guideLayout = new GuideLayout(this.f4046a, (GuidePage) this.f4054i.get(this.f4055j), this);
        guideLayout.setOnGuideLayoutDismissListener(new C1586a() {
            /* renamed from: a */
            public void mo12297a(GuideLayout guideLayout) {
                Controller.this.m4803d();
            }
        });
        this.f4057l.addView(guideLayout, new FrameLayout.LayoutParams(-1, -1));
        this.f4056k = guideLayout;
        OnPageChangedListener eVar = this.f4050e;
        if (eVar != null) {
            eVar.mo12288a(this.f4055j);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m4803d() {
        if (this.f4055j < this.f4054i.size() - 1) {
            this.f4055j++;
            m4802c();
            return;
        }
        OnGuideChangedListener bVar = this.f4049d;
        if (bVar != null) {
            bVar.mo12285b(this);
        }
        m4808f();
    }

    /* renamed from: b */
    public void mo12304b() {
        GuideLayout guideLayout = this.f4056k;
        if (!(guideLayout == null || guideLayout.getParent() == null)) {
            ViewGroup viewGroup = (ViewGroup) this.f4056k.getParent();
            viewGroup.removeView(this.f4056k);
            if (!(viewGroup instanceof FrameLayout)) {
                ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
                View childAt = viewGroup.getChildAt(0);
                viewGroup.removeAllViews();
                if (childAt != null) {
                    int i = this.f4059n;
                    if (i > 0) {
                        viewGroup2.addView(childAt, i, viewGroup.getLayoutParams());
                    } else {
                        viewGroup2.addView(childAt, viewGroup.getLayoutParams());
                    }
                }
            }
        }
        OnGuideChangedListener bVar = this.f4049d;
        if (bVar != null) {
            bVar.mo12285b(this);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m4806e() {
        String str = "listener_fragment";
        if (this.f4047b != null && VERSION.SDK_INT > 16) {
            m4799a(this.f4047b);
            FragmentManager childFragmentManager = this.f4047b.getChildFragmentManager();
            ListenerFragment cVar = (ListenerFragment) childFragmentManager.findFragmentByTag(str);
            if (cVar == null) {
                cVar = new ListenerFragment();
                childFragmentManager.beginTransaction().add(cVar, str).commitAllowingStateLoss();
            }
            cVar.mo12311a(new FragmentLifecycleAdapter() {
                /* renamed from: a */
                public void mo12306a() {
                    LogUtil.m4779b("ListenerFragment.onDestroyView");
                    Controller.this.mo12304b();
                }
            });
        }
        androidx.fragment.app.Fragment fragment = this.f4048c;
        if (fragment != null) {
            androidx.fragment.app.FragmentManager childFragmentManager2 = fragment.getChildFragmentManager();
            V4ListenerFragment v4ListenerFragment = (V4ListenerFragment) childFragmentManager2.findFragmentByTag(str);
            if (v4ListenerFragment == null) {
                v4ListenerFragment = new V4ListenerFragment();
                childFragmentManager2.beginTransaction().add((androidx.fragment.app.Fragment) v4ListenerFragment, str).commitAllowingStateLoss();
            }
            v4ListenerFragment.mo12307a(new FragmentLifecycleAdapter() {
                /* renamed from: a */
                public void mo12306a() {
                    LogUtil.m4779b("v4ListenerFragment.onDestroyView");
                    Controller.this.mo12304b();
                }
            });
        }
    }

    /* renamed from: f */
    private void m4808f() {
        String str = "listener_fragment";
        if (this.f4047b != null && VERSION.SDK_INT > 16) {
            FragmentManager childFragmentManager = this.f4047b.getChildFragmentManager();
            ListenerFragment cVar = (ListenerFragment) childFragmentManager.findFragmentByTag(str);
            if (cVar != null) {
                childFragmentManager.beginTransaction().remove(cVar).commitAllowingStateLoss();
            }
        }
        androidx.fragment.app.Fragment fragment = this.f4048c;
        if (fragment != null) {
            androidx.fragment.app.FragmentManager childFragmentManager2 = fragment.getChildFragmentManager();
            V4ListenerFragment v4ListenerFragment = (V4ListenerFragment) childFragmentManager2.findFragmentByTag(str);
            if (v4ListenerFragment != null) {
                childFragmentManager2.beginTransaction().remove(v4ListenerFragment).commitAllowingStateLoss();
            }
        }
    }

    /* renamed from: a */
    private void m4799a(Fragment fragment) {
        try {
            Field declaredField = Fragment.class.getDeclaredField("mChildFragmentManager");
            declaredField.setAccessible(true);
            declaredField.set(fragment, null);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        }
    }
}
