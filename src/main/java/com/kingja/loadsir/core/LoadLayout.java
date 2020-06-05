package com.kingja.loadsir.core;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.kingja.loadsir.LoadSirUtil;
import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.callback.Callback.OnReloadListener;
import com.kingja.loadsir.callback.SuccessCallback;
import java.util.HashMap;
import java.util.Map;

public class LoadLayout extends FrameLayout {
    /* renamed from: a */
    private Map<Class<? extends Callback>, Callback> f12344a;
    /* renamed from: b */
    private Context f12345b;
    /* renamed from: c */
    private OnReloadListener f12346c;
    /* renamed from: d */
    private Class<? extends Callback> f12347d;
    /* renamed from: e */
    private Class<? extends Callback> f12348e;

    public LoadLayout(Context context) {
        super(context);
        this.f12344a = new HashMap();
    }

    public LoadLayout(Context context, OnReloadListener onReloadListener) {
        this(context);
        this.f12345b = context;
        this.f12346c = onReloadListener;
    }

    public void setupSuccessLayout(Callback callback) {
        mo22623a(callback);
        View rootView = callback.getRootView();
        rootView.setVisibility(8);
        addView(rootView);
        this.f12348e = SuccessCallback.class;
    }

    public void setupCallback(Callback callback) {
        Callback copy = callback.copy();
        copy.setCallback(null, this.f12345b, this.f12346c);
        mo22623a(copy);
    }

    /* renamed from: a */
    public void mo22623a(Callback callback) {
        if (!this.f12344a.containsKey(callback.getClass())) {
            this.f12344a.put(callback.getClass(), callback);
        }
    }

    /* renamed from: a */
    public void mo22624a(Class<? extends Callback> cls) {
        m14990d(cls);
        if (LoadSirUtil.m14976a()) {
            m14989c(cls);
        } else {
            m14988b(cls);
        }
    }

    public Class<? extends Callback> getCurrentCallback() {
        return this.f12348e;
    }

    /* renamed from: b */
    private void m14988b(final Class<? extends Callback> cls) {
        post(new Runnable() {
            public void run() {
                LoadLayout.this.m14989c(cls);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m14989c(Class<? extends Callback> cls) {
        Class<? extends Callback> cls2 = this.f12347d;
        if (cls2 != null) {
            if (cls2 != cls) {
                ((Callback) this.f12344a.get(cls2)).onDetach();
            } else {
                return;
            }
        }
        if (getChildCount() > 1) {
            removeViewAt(1);
        }
        for (Class<SuccessCallback> cls3 : this.f12344a.keySet()) {
            if (cls3 == cls) {
                SuccessCallback successCallback = (SuccessCallback) this.f12344a.get(SuccessCallback.class);
                if (cls3 == SuccessCallback.class) {
                    successCallback.show();
                } else {
                    successCallback.showWithCallback(((Callback) this.f12344a.get(cls3)).getSuccessVisible());
                    View rootView = ((Callback) this.f12344a.get(cls3)).getRootView();
                    addView(rootView);
                    ((Callback) this.f12344a.get(cls3)).onAttach(this.f12345b, rootView);
                }
                this.f12347d = cls;
            }
        }
        this.f12348e = cls;
    }

    /* renamed from: d */
    private void m14990d(Class<? extends Callback> cls) {
        if (!this.f12344a.containsKey(cls)) {
            throw new IllegalArgumentException(String.format("The Callback (%s) is nonexistent.", new Object[]{cls.getSimpleName()}));
        }
    }
}
