package com.uber.autodispose.android.lifecycle;

import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MethodCallsLogger;

public class LifecycleEventsObservable_ArchLifecycleObserver_LifecycleAdapter implements GeneratedAdapter {
    /* renamed from: a */
    final ArchLifecycleObserver f25982a;

    LifecycleEventsObservable_ArchLifecycleObserver_LifecycleAdapter(ArchLifecycleObserver archLifecycleObserver) {
        this.f25982a = archLifecycleObserver;
    }

    public void callMethods(LifecycleOwner lifecycleOwner, Event event, boolean z, MethodCallsLogger methodCallsLogger) {
        boolean z2 = methodCallsLogger != null;
        if (!z) {
            return;
        }
        if (!z2 || methodCallsLogger.approveCall("onStateChange", 4)) {
            this.f25982a.onStateChange(lifecycleOwner, event);
        }
    }
}
