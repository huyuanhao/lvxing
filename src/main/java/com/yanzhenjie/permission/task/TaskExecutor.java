package com.yanzhenjie.permission.task;

import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public abstract class TaskExecutor<T> extends AsyncTask<Void, Void, T> {
    /* renamed from: a */
    private static Executor f26698a = Executors.newSingleThreadExecutor();
    /* renamed from: b */
    private Dialog f26699b;

    /* renamed from: a */
    public abstract void mo38066a(T t);

    public TaskExecutor(Context context) {
        this.f26699b = new WaitDialog(context);
        this.f26699b.setCancelable(false);
    }

    /* access modifiers changed from: protected|final */
    public final void onPreExecute() {
        if (!this.f26699b.isShowing()) {
            this.f26699b.show();
        }
    }

    /* access modifiers changed from: protected|final */
    public final void onPostExecute(T t) {
        if (this.f26699b.isShowing()) {
            this.f26699b.dismiss();
        }
        mo38066a(t);
    }

    /* renamed from: a */
    public final void mo38079a() {
        executeOnExecutor(f26698a, new Void[0]);
    }
}
