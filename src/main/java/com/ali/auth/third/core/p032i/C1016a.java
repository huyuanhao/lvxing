package com.ali.auth.third.core.p032i;

import android.os.AsyncTask;

/* renamed from: com.ali.auth.third.core.i.a */
public abstract class C1016a<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    /* renamed from: a */
    public abstract Result mo10274a(Params... paramsArr);

    /* renamed from: a */
    public abstract void mo10281a();

    /* renamed from: a */
    public abstract void mo10282a(Throwable th);

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected|varargs */
    public Result doInBackground(Params... paramsArr) {
        try {
            Result a = mo10274a(paramsArr);
            mo10281a();
            return a;
        } catch (Throwable th) {
            mo10281a();
            throw th;
        }
    }
}
