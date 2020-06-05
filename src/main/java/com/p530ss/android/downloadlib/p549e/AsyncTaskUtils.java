package com.p530ss.android.downloadlib.p549e;

import android.os.AsyncTask;
import com.p530ss.android.downloadlib.DownloadComponentManager;

/* renamed from: com.ss.android.downloadlib.e.b */
public class AsyncTaskUtils {
    /* renamed from: a */
    static final C6584a f21428a = new C6585b();

    /* compiled from: AsyncTaskUtils */
    /* renamed from: com.ss.android.downloadlib.e.b$a */
    private static class C6584a {
        private C6584a() {
        }

        /* renamed from: a */
        public <T> void mo31410a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.execute(tArr);
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: AsyncTaskUtils */
    /* renamed from: com.ss.android.downloadlib.e.b$b */
    private static class C6585b extends C6584a {
        private C6585b() {
            super();
        }

        /* renamed from: a */
        public <T> void mo31410a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(DownloadComponentManager.m26440a().mo31387b(), tArr);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public static <T> void m26485a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        f21428a.mo31410a(asyncTask, tArr);
    }
}
