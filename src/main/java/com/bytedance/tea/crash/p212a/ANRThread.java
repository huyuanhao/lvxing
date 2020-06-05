package com.bytedance.tea.crash.p212a;

import com.bytedance.tea.crash.p218e.LooperMessageManager;
import com.bytedance.tea.crash.p218e.LooperTrace;
import java.io.File;

/* renamed from: com.bytedance.tea.crash.a.d */
public class ANRThread implements Runnable {
    /* renamed from: a */
    private long f9212a;
    /* renamed from: b */
    private final ANRManager f9213b;
    /* access modifiers changed from: private|volatile */
    /* renamed from: c */
    public volatile boolean f9214c = false;
    /* renamed from: d */
    private Runnable f9215d = new Runnable() {
        public void run() {
            ANRThread.this.f9214c = false;
        }
    };

    ANRThread(ANRManager cVar) {
        this.f9213b = cVar;
        this.f9212a = m12280a();
        LooperTrace.m12472a(2);
        LooperMessageManager.m12459a().mo17050a(4500, this.f9215d);
        LooperMessageManager.m12459a().mo17051a(5000, this, 40, 5000);
    }

    public void run() {
        String str;
        int i;
        if (!this.f9214c) {
            if (m12282b()) {
                i = 200;
                str = "/data/anr/traces.txt";
            } else {
                str = null;
                i = 100;
            }
            if (this.f9213b.mo16962a(i, str, 25)) {
                this.f9214c = true;
            }
        }
    }

    /* renamed from: a */
    private long m12280a() {
        File file = new File("/data/anr/traces.txt");
        if (file.exists()) {
            return file.lastModified();
        }
        return 0;
    }

    /* renamed from: b */
    private boolean m12282b() {
        File file = new File("/data/anr/traces.txt");
        return file.exists() && file.canRead();
    }
}
