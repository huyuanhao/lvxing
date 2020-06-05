package mtopsdk.mtop.util;

import android.os.Process;
import mtopsdk.common.util.TBSdkLog;

/* compiled from: MtopSDKThreadPoolExecutorFactory */
/* renamed from: mtopsdk.mtop.util.c */
class C8338c extends Thread {
    /* renamed from: a */
    private /* synthetic */ C8337a f28031a;

    C8338c(C8337a aVar, Runnable runnable, String str) {
        this.f28031a = aVar;
        super(runnable, str);
    }

    public void run() {
        String str = "mtopsdk.MtopSDKThreadPoolExecutorFactory";
        try {
            Process.setThreadPriority(this.f28031a.f28028a);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("[run]Thread set thread priority error ---");
            sb.append(th.toString());
            TBSdkLog.m35510c(str, sb.toString());
        }
        try {
            super.run();
        } catch (Throwable th2) {
            StringBuilder sb2 = new StringBuilder("[run]Thread run error ---");
            sb2.append(th2.toString());
            TBSdkLog.m35510c(str, sb2.toString());
        }
    }
}
