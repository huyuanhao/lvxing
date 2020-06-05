package com.yanzhenjie.album.mvp;

import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleOwner;

class BaseView$2 implements GenericLifecycleObserver {
    /* renamed from: a */
    final /* synthetic */ BaseView f26331a;

    BaseView$2(BaseView bVar) {
        this.f26331a = bVar;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Event event) {
        if (event == Event.ON_RESUME) {
            this.f26331a.m33599l();
        } else if (event == Event.ON_PAUSE) {
            this.f26331a.m33600m();
        } else if (event == Event.ON_STOP) {
            this.f26331a.m33601n();
        } else if (event == Event.ON_DESTROY) {
            this.f26331a.m33602o();
        }
    }
}
