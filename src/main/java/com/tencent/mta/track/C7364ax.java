package com.tencent.mta.track;

import android.util.Log;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map.Entry;
import java.util.WeakHashMap;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.ax */
public class C7364ax extends C7369bb {
    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final int f24933a;
    /* renamed from: b */
    private final WeakHashMap f24934b = new WeakHashMap();

    public C7364ax(List list, int i, C7461u uVar, C7370bc bcVar) {
        super(list, uVar, bcVar, false);
        this.f24933a = i;
    }

    /* renamed from: a */
    public void mo35896a() {
        for (Entry entry : this.f24934b.entrySet()) {
            View view = (View) entry.getKey();
            C7365ay ayVar = (C7365ay) entry.getValue();
            AccessibilityDelegate c = m31775c(view);
            if (c == ayVar) {
                view.setAccessibilityDelegate(ayVar.mo35898a());
            } else if (c instanceof C7365ay) {
                ((C7365ay) c).mo35899a(ayVar);
            }
        }
        this.f24934b.clear();
    }

    public void accumulate(View view) {
        AccessibilityDelegate c = m31775c(view);
        if (!(c instanceof C7365ay) || !((C7365ay) c).mo35900a(mo35906b())) {
            if (StatisticsDataAPI.f24839a.booleanValue()) {
                Log.i("ViewVisitor", String.format("ClickVisitor accumulated. View %s", new Object[]{view.toString()}));
            }
            C7365ay ayVar = new C7365ay(this, c);
            view.setAccessibilityDelegate(ayVar);
            this.f24934b.put(view, ayVar);
        }
    }

    /* renamed from: c */
    private AccessibilityDelegate m31775c(View view) {
        try {
            return (AccessibilityDelegate) view.getClass().getMethod("getAccessibilityDelegate", new Class[0]).invoke(view, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException unused) {
        } catch (InvocationTargetException e) {
            Log.w("ViewVisitor", "getAccessibilityDelegate threw an exception when called.", e);
        }
        return null;
    }
}
