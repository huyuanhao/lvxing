package com.tencent.bugly.beta.p602ui;

import android.view.KeyEvent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.ui.b */
public abstract class C7143b extends Fragment {
    /* renamed from: m */
    protected boolean f23779m = false;

    /* renamed from: a */
    public abstract boolean mo34441a(int i, KeyEvent keyEvent);

    /* renamed from: b */
    public synchronized boolean mo34442b() {
        return this.f23779m;
    }

    /* renamed from: a */
    public synchronized void mo34434a() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public void onResume() {
        super.onResume();
        synchronized (this) {
            this.f23779m = true;
        }
    }

    public void onPause() {
        super.onPause();
        synchronized (this) {
            this.f23779m = false;
        }
    }
}
