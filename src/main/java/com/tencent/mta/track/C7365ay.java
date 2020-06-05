package com.tencent.mta.track;

import android.view.View;
import android.view.View.AccessibilityDelegate;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.ay */
class C7365ay extends AccessibilityDelegate {
    /* renamed from: a */
    final /* synthetic */ C7364ax f24935a;
    /* renamed from: b */
    private AccessibilityDelegate f24936b;

    public C7365ay(C7364ax axVar, AccessibilityDelegate accessibilityDelegate) {
        this.f24935a = axVar;
        this.f24936b = accessibilityDelegate;
    }

    /* renamed from: a */
    public AccessibilityDelegate mo35898a() {
        return this.f24936b;
    }

    /* renamed from: a */
    public boolean mo35900a(String str) {
        if (this.f24935a.mo35906b().equals(str)) {
            return true;
        }
        AccessibilityDelegate accessibilityDelegate = this.f24936b;
        if (accessibilityDelegate instanceof C7365ay) {
            return ((C7365ay) accessibilityDelegate).mo35900a(str);
        }
        return false;
    }

    /* renamed from: a */
    public void mo35899a(C7365ay ayVar) {
        AccessibilityDelegate accessibilityDelegate = this.f24936b;
        if (accessibilityDelegate == ayVar) {
            this.f24936b = ayVar.mo35898a();
        } else if (accessibilityDelegate instanceof C7365ay) {
            ((C7365ay) accessibilityDelegate).mo35899a(ayVar);
        }
    }

    public void sendAccessibilityEvent(View view, int i) {
        if (i == this.f24935a.f24933a) {
            this.f24935a.mo35907b(view);
        }
        AccessibilityDelegate accessibilityDelegate = this.f24936b;
        if (accessibilityDelegate != null) {
            accessibilityDelegate.sendAccessibilityEvent(view, i);
        }
    }
}
