package btmsdkobf;

import android.os.HandlerThread;

/* renamed from: btmsdkobf.fd */
public class C0845fd {
    /* renamed from: nZ */
    private static volatile C0845fd f978nZ;
    /* renamed from: lA */
    private long f979lA = 1;
    /* renamed from: nY */
    private C0855fl f980nY = new C0855fl(C0652cl.m85D());

    private C0845fd() {
    }

    /* renamed from: cN */
    public static C0845fd m898cN() {
        if (f978nZ == null) {
            synchronized (C0845fd.class) {
                if (f978nZ == null) {
                    f978nZ = new C0845fd();
                }
            }
        }
        return f978nZ;
    }

    public void addTask(Runnable runnable, String str) {
        this.f980nY.mo9575a(runnable, str, this.f979lA);
    }

    public void addUrgentTask(Runnable runnable, String str) {
        this.f980nY.mo9576b(runnable, str, this.f979lA);
    }

    public HandlerThread newFreeHandlerThread(String str) {
        return this.f980nY.mo9574a(str, 0, this.f979lA);
    }
}
