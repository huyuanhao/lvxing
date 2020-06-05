package com.bytedance.tea.crash.p212a;

import android.os.FileObserver;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.core.imageloader.core.download.BaseImageDownloader;

/* renamed from: com.bytedance.tea.crash.a.a */
public class ANRFileObserver extends FileObserver {
    /* renamed from: a */
    private final ANRManager f9200a;
    /* renamed from: b */
    private final int f9201b = BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT;
    /* access modifiers changed from: private|volatile */
    /* renamed from: c */
    public volatile boolean f9202c = true;

    /* compiled from: ANRFileObserver */
    /* renamed from: com.bytedance.tea.crash.a.a$a */
    private final class C2572a extends Thread {
        /* renamed from: b */
        private int f9204b;

        C2572a(int i) {
            this.f9204b = i;
        }

        public void run() {
            SystemClock.sleep((long) this.f9204b);
            ANRFileObserver.this.f9202c = true;
        }
    }

    public ANRFileObserver(ANRManager cVar, String str, int i) {
        super(str, i);
        if (cVar == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("params is not right path is null or ANRManager is null");
        }
        this.f9200a = cVar;
    }

    public void onEvent(int i, String str) {
        if (this.f9202c && i == 8 && !TextUtils.isEmpty(str) && str.contains("trace")) {
            ANRManager cVar = this.f9200a;
            if (cVar != null) {
                this.f9202c = false;
                StringBuilder sb = new StringBuilder();
                sb.append("/data/anr/");
                sb.append(str);
                cVar.mo16962a(200, sb.toString(), 80);
                getClass();
                new C2572a(BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT).start();
            }
        }
    }
}
