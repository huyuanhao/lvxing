package com.p530ss.android.socialbase.downloader.p568l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* renamed from: com.ss.android.socialbase.downloader.l.f */
public class WeakDownloadHandler extends Handler {
    /* renamed from: a */
    private final WeakReference<C6749a> f22358a;

    /* compiled from: WeakDownloadHandler */
    /* renamed from: com.ss.android.socialbase.downloader.l.f$a */
    public interface C6749a {
        /* renamed from: a */
        void mo31460a(Message message);
    }

    public WeakDownloadHandler(Looper looper, C6749a aVar) {
        super(looper);
        this.f22358a = new WeakReference<>(aVar);
    }

    public void handleMessage(Message message) {
        C6749a aVar = (C6749a) this.f22358a.get();
        if (aVar != null && message != null) {
            aVar.mo31460a(message);
        }
    }
}
