package com.kwad.sdk.mvp;

import android.content.Context;
import android.view.View;
import com.kwad.sdk.p306a.C3809l;
import java.util.ArrayList;
import java.util.List;

public class Presenter {
    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final List<Presenter> f14591a = new ArrayList();
    /* access modifiers changed from: private */
    /* renamed from: b */
    public View f14592b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public Object f14593c;
    /* renamed from: d */
    private PresenterState f14594d = PresenterState.INIT;

    /* renamed from: com.kwad.sdk.mvp.Presenter$PresenterState */
    private enum PresenterState {
        INIT(0) {
            public void performCallState(Presenter presenter) {
            }
        },
        CREATE(1) {
            public void performCallState(Presenter presenter) {
                for (Presenter a : presenter.f14591a) {
                    a.mo24761a(presenter.f14592b);
                }
            }
        },
        BIND(2) {
            /* access modifiers changed from: 0000 */
            public void performCallState(Presenter presenter) {
                for (Presenter a : presenter.f14591a) {
                    a.mo24763a(presenter.f14593c);
                }
            }
        },
        UNBIND(3) {
            /* access modifiers changed from: 0000 */
            public void performCallState(Presenter presenter) {
                for (Presenter j : presenter.f14591a) {
                    j.mo24764j();
                }
            }
        },
        DESTROY(4) {
            /* access modifiers changed from: 0000 */
            public void performCallState(Presenter presenter) {
                for (Presenter k : presenter.f14591a) {
                    k.mo24765k();
                }
            }
        };
        
        private int mIndex;

        private PresenterState(int i) {
            this.mIndex = i;
        }

        public int index() {
            return this.mIndex;
        }

        public abstract void performCallState(Presenter presenter);
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final <T extends View> T mo24760a(String str) {
        return this.f14592b.findViewById(C3809l.m15789a(mo24770p(), str));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23338a() {
    }

    /* renamed from: a */
    public final void mo24761a(View view) {
        this.f14594d = PresenterState.CREATE;
        this.f14592b = view;
        mo23339b();
        this.f14594d.performCallState(this);
    }

    /* renamed from: a */
    public final void mo24762a(Presenter presenter) {
        this.f14591a.add(presenter);
        if (mo24767m() && !presenter.mo24767m()) {
            mo24761a(this.f14592b);
        }
    }

    /* renamed from: a */
    public final void mo24763a(Object obj) {
        if (this.f14594d == PresenterState.INIT || this.f14594d == PresenterState.DESTROY) {
            StringBuilder sb = new StringBuilder();
            sb.append("current state is ");
            sb.append(this.f14594d);
            sb.append("，can't bind");
            throw new IllegalArgumentException(sb.toString());
        }
        if (this.f14594d == PresenterState.BIND) {
            mo24764j();
        }
        this.f14594d = PresenterState.BIND;
        this.f14593c = obj;
        mo23338a();
        this.f14594d.performCallState(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23339b() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23340c() {
    }

    /* renamed from: d */
    public void mo23342d() {
        for (Presenter d : this.f14591a) {
            d.mo23342d();
        }
    }

    /* renamed from: e */
    public void mo23343e() {
        for (Presenter e : this.f14591a) {
            e.mo23343e();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo23421f() {
    }

    /* renamed from: j */
    public final void mo24764j() {
        this.f14594d = PresenterState.UNBIND;
        mo23340c();
        this.f14594d.performCallState(this);
    }

    /* renamed from: k */
    public final void mo24765k() {
        if (this.f14594d == PresenterState.BIND) {
            mo24764j();
        }
        this.f14594d = PresenterState.DESTROY;
        mo23421f();
        this.f14594d.performCallState(this);
    }

    /* renamed from: l */
    public void mo24766l() {
        for (Presenter l : this.f14591a) {
            l.mo24766l();
        }
    }

    /* renamed from: m */
    public final boolean mo24767m() {
        return this.f14594d.index() >= PresenterState.CREATE.index();
    }

    /* renamed from: n */
    public View mo24768n() {
        return this.f14592b;
    }

    /* renamed from: o */
    public Object mo24769o() {
        return this.f14593c;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: p */
    public final Context mo24770p() {
        View view = this.f14592b;
        if (view == null) {
            return null;
        }
        return view.getContext();
    }
}
