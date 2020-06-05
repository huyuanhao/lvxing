package com.app.hubert.guide.lifecycle;

import androidx.fragment.app.Fragment;
import com.app.hubert.guide.p128b.LogUtil;

public class V4ListenerFragment extends Fragment {
    /* renamed from: a */
    FragmentLifecycle f4065a;

    /* renamed from: a */
    public void mo12307a(FragmentLifecycle aVar) {
        this.f4065a = aVar;
    }

    public void onStart() {
        super.onStart();
        LogUtil.m4778a("onStart: ");
        this.f4065a.mo12308b();
    }

    public void onStop() {
        super.onStop();
        this.f4065a.mo12309c();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f4065a.mo12306a();
    }

    public void onDestroy() {
        super.onDestroy();
        LogUtil.m4778a("onDestroy: ");
        this.f4065a.mo12310d();
    }
}
