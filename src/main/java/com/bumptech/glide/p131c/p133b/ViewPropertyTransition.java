package com.bumptech.glide.p131c.p133b;

import android.view.View;
import com.bumptech.glide.p131c.p133b.Transition.C1611a;

/* renamed from: com.bumptech.glide.c.b.j */
public class ViewPropertyTransition<R> implements Transition<R> {
    /* renamed from: a */
    private final C1613a f4222a;

    /* compiled from: ViewPropertyTransition */
    /* renamed from: com.bumptech.glide.c.b.j$a */
    public interface C1613a {
        /* renamed from: a */
        void mo12514a(View view);
    }

    public ViewPropertyTransition(C1613a aVar) {
        this.f4222a = aVar;
    }

    /* renamed from: a */
    public boolean mo12508a(R r, C1611a aVar) {
        if (aVar.mo12512b() != null) {
            this.f4222a.mo12514a(aVar.mo12512b());
        }
        return false;
    }
}
