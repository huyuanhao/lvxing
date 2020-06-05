package com.app.hubert.guide.lifecycle;

import android.app.Fragment;
import com.app.hubert.guide.p128b.LogUtil;

/* renamed from: com.app.hubert.guide.lifecycle.c */
public class ListenerFragment extends Fragment {
    /* renamed from: a */
    FragmentLifecycle f4066a;

    /* renamed from: a */
    public void mo12311a(FragmentLifecycle aVar) {
        this.f4066a = aVar;
    }

    public void onStart() {
        super.onStart();
        LogUtil.m4778a("onStart: ");
        this.f4066a.mo12308b();
    }

    public void onStop() {
        super.onStop();
        this.f4066a.mo12309c();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f4066a.mo12306a();
    }

    public void onDestroy() {
        super.onDestroy();
        LogUtil.m4778a("onDestroy: ");
        this.f4066a.mo12310d();
    }
}
