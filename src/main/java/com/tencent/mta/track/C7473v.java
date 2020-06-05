package com.tencent.mta.track;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.v */
public class C7473v {
    /* renamed from: a */
    private final C7475x f25032a = new C7475x();

    /* renamed from: a */
    public void mo36426a(View view, List list, C7474w wVar) {
        if (!list.isEmpty()) {
            if (this.f25032a.mo36428a()) {
                Log.w("PathFinder", "Path is too deep, there is no memory to perfrom the finding");
                return;
            }
            C7476y yVar = (C7476y) list.get(0);
            List subList = list.subList(1, list.size());
            View a = m32349a(yVar, view, this.f25032a.mo36429b());
            this.f25032a.mo36431c();
            if (a != null) {
                m32352b(a, subList, wVar);
            }
        }
    }

    /* renamed from: b */
    private void m32352b(View view, List list, C7474w wVar) {
        if (list.isEmpty()) {
            wVar.accumulate(view);
        } else if (this.f25032a.mo36428a()) {
            Log.w("PathFinder", "Path is too deep, there is no memory to perfrom the finding");
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            C7476y yVar = (C7476y) list.get(0);
            List subList = list.subList(1, list.size());
            int childCount = viewGroup.getChildCount();
            int b = this.f25032a.mo36429b();
            for (int i = 0; i < childCount; i++) {
                View a = m32349a(yVar, viewGroup.getChildAt(i), b);
                if (a != null) {
                    m32352b(a, subList, wVar);
                }
                if (yVar.f25037c >= 0 && this.f25032a.mo36427a(b) > yVar.f25037c) {
                    break;
                }
            }
            this.f25032a.mo36431c();
        }
    }

    /* renamed from: a */
    private View m32349a(C7476y yVar, View view, int i) {
        int a = this.f25032a.mo36427a(i);
        if (m32350a(yVar, view)) {
            this.f25032a.mo36430b(i);
            if (yVar.f25037c == -1 || yVar.f25037c == a) {
                return view;
            }
        }
        if (yVar.f25035a == 1 && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt != null) {
                    View a2 = m32349a(yVar, childAt, i);
                    if (a2 != null) {
                        return a2;
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private boolean m32350a(C7476y yVar, View view) {
        if (yVar.f25036b != null && !m32351a((Object) view, yVar.f25036b)) {
            return false;
        }
        if (-1 == yVar.f25038d || view.getId() == yVar.f25038d) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m32351a(Object obj, String str) {
        for (Class<Object> cls = obj.getClass(); cls.getCanonicalName() != null; cls = cls.getSuperclass()) {
            if (cls.getCanonicalName().equals(str)) {
                return true;
            }
            if (cls == Object.class) {
                break;
            }
        }
        return false;
    }
}
