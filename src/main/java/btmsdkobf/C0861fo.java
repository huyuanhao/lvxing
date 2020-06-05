package btmsdkobf;

import android.os.Debug;
import android.os.HandlerThread;
import btmsdkobf.C0863fp.C0864a;
import btmsdkobf.C0866fr.C0867a;
import btmsdkobf.C0866fr.C0869c;
import java.util.HashMap;

/* renamed from: btmsdkobf.fo */
public class C0861fo {
    /* access modifiers changed from: private|static */
    /* renamed from: oI */
    public static HashMap<Thread, C0869c> f1021oI = new HashMap<>();
    /* access modifiers changed from: private|static */
    /* renamed from: oJ */
    public static C0867a f1022oJ;
    /* renamed from: oK */
    private static C0864a f1023oK = new C0864a() {
        /* renamed from: a */
        public void mo9593a(Thread thread, Runnable runnable) {
            C0869c cVar = new C0869c();
            cVar.taskType = 3;
            cVar.f1027fp = ((C0860fn) thread).mo9590by();
            cVar.name = thread.getName();
            cVar.priority = thread.getPriority();
            cVar.f1029oO = -1;
            cVar.f1030oP = -1;
            C0861fo.f1021oI.put(thread, cVar);
            C0861fo.m950da();
            C0861fo.f1022oJ.mo9583a(cVar, C0861fo.activeCount());
        }

        /* renamed from: b */
        public void mo9594b(Thread thread, Runnable runnable) {
            C0869c cVar = (C0869c) C0861fo.f1021oI.remove(thread);
            if (cVar != null) {
                cVar.f1029oO = System.currentTimeMillis() - cVar.f1029oO;
                cVar.f1030oP = Debug.threadCpuTimeNanos() - cVar.f1030oP;
                C0861fo.m950da();
                C0861fo.f1022oJ.mo9584b(cVar);
            }
        }

        public void beforeExecute(Thread thread, Runnable runnable) {
            C0869c cVar = (C0869c) C0861fo.f1021oI.get(thread);
            if (cVar != null) {
                C0861fo.m950da();
                C0861fo.f1022oJ.mo9582a(cVar);
                cVar.f1029oO = System.currentTimeMillis();
                cVar.f1030oP = Debug.threadCpuTimeNanos();
            }
        }
    };

    /* renamed from: a */
    public static HandlerThread m949a(String str, int i, long j) {
        return new C0860fn(str, i, j);
    }

    public static int activeCount() {
        return f1021oI.size();
    }

    /* access modifiers changed from: private|static */
    /* renamed from: da */
    public static void m950da() {
        if (f1022oJ == null) {
            f1022oJ = C0856fm.m933cU();
        }
    }

    /* renamed from: db */
    public static C0864a m951db() {
        return f1023oK;
    }
}
