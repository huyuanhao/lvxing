package ezy.sdk3rd.social.sdk;

import android.app.Activity;

/* renamed from: ezy.sdk3rd.social.sdk.a */
public class DefaultCallback<R> implements OnCallback<R> {
    /* renamed from: a */
    OnCallback<R> f27295a;
    /* renamed from: b */
    OnSucceed<R> f27296b;

    public DefaultCallback(OnCallback<R> fVar, OnSucceed<R> gVar) {
        this.f27295a = fVar;
        this.f27296b = gVar;
    }

    /* renamed from: a */
    public void mo20727a(Activity activity) {
        OnCallback<R> fVar = this.f27295a;
        if (fVar != null) {
            fVar.mo20727a(activity);
        }
    }

    /* renamed from: b */
    public void mo20731b(Activity activity) {
        OnCallback<R> fVar = this.f27295a;
        if (fVar != null) {
            fVar.mo20731b(activity);
        }
    }

    /* renamed from: a */
    public void mo20728a(Activity activity, int i, String str) {
        OnCallback<R> fVar = this.f27295a;
        if (fVar != null) {
            fVar.mo20728a(activity, i, str);
        }
    }

    /* renamed from: a */
    public void mo20729a(Activity activity, R r) {
        OnCallback<R> fVar = this.f27295a;
        if (fVar != null) {
            fVar.mo20729a(activity, r);
        }
        OnSucceed<R> gVar = this.f27296b;
        if (gVar != null) {
            gVar.mo21148a(r);
        }
    }
}
