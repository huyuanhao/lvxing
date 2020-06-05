package com.kingja.loadsir.core;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.callback.Callback.OnReloadListener;
import com.kingja.loadsir.callback.SuccessCallback;
import com.kingja.loadsir.core.LoadSir.C3599a;
import java.util.List;

/* renamed from: com.kingja.loadsir.core.b */
public class LoadService<T> {
    /* renamed from: a */
    private LoadLayout f12351a;
    /* renamed from: b */
    private Convertor<T> f12352b;

    LoadService(Convertor<T> aVar, TargetContext dVar, OnReloadListener onReloadListener, C3599a aVar2) {
        this.f12352b = aVar;
        Context a = dVar.mo22638a();
        View b = dVar.mo22639b();
        LayoutParams layoutParams = b.getLayoutParams();
        this.f12351a = new LoadLayout(a, onReloadListener);
        this.f12351a.setupSuccessLayout(new SuccessCallback(b, a, onReloadListener));
        if (dVar.mo22641d() != null) {
            dVar.mo22641d().addView(this.f12351a, dVar.mo22640c(), layoutParams);
        }
        m14993a(aVar2);
    }

    /* renamed from: a */
    private void m14993a(C3599a aVar) {
        List<Callback> a = aVar.mo22635a();
        Class b = aVar.mo22636b();
        if (a != null && a.size() > 0) {
            for (Callback callback : a) {
                this.f12351a.setupCallback(callback);
            }
        }
        if (b != null) {
            this.f12351a.mo22624a(b);
        }
    }

    /* renamed from: a */
    public void mo22629a() {
        this.f12351a.mo22624a(SuccessCallback.class);
    }

    /* renamed from: a */
    public void mo22630a(Class<? extends Callback> cls) {
        this.f12351a.mo22624a(cls);
    }
}
