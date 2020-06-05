package btmsdkobf;

import android.content.Context;
import android.os.Debug;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import btmsdkobf.C0853fk.C0854a;
import btmsdkobf.C0866fr.C0867a;
import btmsdkobf.C0866fr.C0868b;
import btmsdkobf.C0866fr.C0869c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;

/* renamed from: btmsdkobf.fm */
public class C0856fm implements C0854a, C0866fr {
    /* access modifiers changed from: private|static */
    /* renamed from: oB */
    public static long f1000oB = 0;
    /* access modifiers changed from: private|static */
    /* renamed from: oC */
    public static long f1001oC = 0;
    /* renamed from: oE */
    private static C0867a f1002oE = new C0867a() {
        /* renamed from: a */
        public void mo9582a(C0869c cVar) {
            Iterator it = C0856fm.f1003or.iterator();
            while (it.hasNext()) {
                ((C0867a) it.next()).mo9582a(cVar);
            }
        }

        /* renamed from: a */
        public void mo9583a(C0869c cVar, int i) {
            Iterator it = C0856fm.f1003or.iterator();
            while (it.hasNext()) {
                ((C0867a) it.next()).mo9583a(cVar, i);
            }
        }

        /* renamed from: b */
        public void mo9584b(C0869c cVar) {
            Iterator it = C0856fm.f1003or.iterator();
            while (it.hasNext()) {
                ((C0867a) it.next()).mo9584b(cVar);
            }
        }
    };
    /* access modifiers changed from: private|static */
    /* renamed from: or */
    public static ArrayList<C0867a> f1003or = new ArrayList<>();
    /* renamed from: R */
    private Object f1004R = new Object();
    /* renamed from: oA */
    private C0859b f1005oA;
    /* renamed from: oD */
    private volatile boolean f1006oD = false;
    /* renamed from: oq */
    private ArrayList<C0868b> f1007oq = new ArrayList<>();
    /* renamed from: os */
    protected PriorityBlockingQueue<Runnable> f1008os = new PriorityBlockingQueue<>(5);
    /* renamed from: ot */
    protected LinkedList<C0858a> f1009ot = new LinkedList<>();
    /* renamed from: ou */
    protected ArrayList<C0858a> f1010ou = new ArrayList<>();
    /* renamed from: ov */
    protected HashMap<C0858a, Thread> f1011ov = new HashMap<>();
    /* renamed from: ow */
    private int f1012ow = m928cO();
    /* renamed from: ox */
    protected C0853fk f1013ox = null;
    /* renamed from: oy */
    private boolean f1014oy = false;
    /* renamed from: oz */
    private HandlerThread f1015oz;

    /* renamed from: btmsdkobf.fm$a */
    class C0858a implements Comparable<C0858a>, Runnable {
        /* renamed from: oF */
        private C0869c f1016oF = new C0869c();

        public C0858a(int i, Runnable runnable, String str, long j, boolean z, Object obj) {
            if (str == null || str.length() == 0) {
                str = runnable.getClass().getName();
            }
            C0869c cVar = this.f1016oF;
            cVar.taskType = 1;
            cVar.priority = i;
            cVar.name = str;
            cVar.f1027fp = j;
            cVar.f1032oR = runnable;
            cVar.f1031oQ = z;
            cVar.f1033oS = obj;
            cVar.f1028oN = System.currentTimeMillis();
        }

        /* renamed from: a */
        public int compareTo(C0858a aVar) {
            int abs = (int) (Math.abs(System.currentTimeMillis() - this.f1016oF.f1028oN) / 200);
            int i = this.f1016oF.priority;
            if (abs > 0) {
                i += abs;
            }
            return aVar.f1016oF.priority - i;
        }

        /* renamed from: cY */
        public C0869c mo9586cY() {
            return this.f1016oF;
        }

        public void run() {
            try {
                if (this.f1016oF != null && this.f1016oF.f1032oR != null) {
                    this.f1016oF.f1032oR.run();
                }
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("run (Throwable):");
                sb.append(th.toString());
                C0848ff.m906e("ThreadPool", sb.toString());
            }
        }
    }

    /* renamed from: btmsdkobf.fm$b */
    class C0859b extends Handler {
        public C0859b(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what == 1) {
                removeMessages(message.what);
                if (C0856fm.this.m932cT()) {
                    String str = "ThreadPool";
                    C0848ff.m907i(str, "thread pool is pause");
                    long currentTimeMillis = System.currentTimeMillis();
                    if (C0856fm.f1000oB > 0 && Math.abs(C0856fm.f1001oC - currentTimeMillis) > C0856fm.f1000oB) {
                        C0848ff.m907i(str, "thread pool is auto wakeup");
                        C0856fm.this.mo9581cS();
                    }
                    sendEmptyMessageDelayed(1, 1000);
                    return;
                }
                C0856fm.this.m930cQ();
            }
        }
    }

    public C0856fm(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("core pool size: ");
        sb.append(this.f1012ow);
        C0848ff.m907i("ThreadPool", sb.toString());
        C0853fk fkVar = new C0853fk(0, this.f1012ow + 2, 3, TimeUnit.SECONDS, this.f1008os, new CallerRunsPolicy());
        this.f1013ox = fkVar;
        this.f1013ox.mo9568a(this);
        this.f1015oz = new HandlerThread("TMS_THREAD_POOL_HANDLER");
        this.f1015oz.start();
        this.f1005oA = new C0859b(this.f1015oz.getLooper());
    }

    /* renamed from: cO */
    private int m928cO() {
        int availableProcessors = (Runtime.getRuntime().availableProcessors() * 4) + 2;
        if (availableProcessors > 16) {
            return 16;
        }
        return availableProcessors;
    }

    /* renamed from: cP */
    private int m929cP() {
        return m928cO() * 2;
    }

    /* access modifiers changed from: private */
    /* renamed from: cQ */
    public void m930cQ() {
        try {
            synchronized (this.f1004R) {
                if (!this.f1009ot.isEmpty()) {
                    Iterator it = this.f1009ot.iterator();
                    if (it != null && it.hasNext()) {
                        C0858a aVar = (C0858a) it.next();
                        it.remove();
                        m931cR();
                        this.f1013ox.execute(aVar);
                        Iterator it2 = f1003or.iterator();
                        while (it2.hasNext()) {
                            ((C0867a) it2.next()).mo9583a(aVar.mo9586cY(), this.f1013ox.getActiveCount());
                        }
                    }
                }
                if (!this.f1009ot.isEmpty()) {
                    this.f1005oA.sendEmptyMessage(1);
                }
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("executeTask (Throwable):");
            sb.append(th.toString());
            C0848ff.m906e("ThreadPool", sb.toString());
        }
    }

    /* renamed from: cR */
    private void m931cR() {
        int corePoolSize = this.f1013ox.getCorePoolSize();
        int i = this.f1012ow;
        if (corePoolSize < i) {
            this.f1013ox.setCorePoolSize(i);
            this.f1013ox.setMaximumPoolSize(this.f1012ow);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: cT */
    public boolean m932cT() {
        return this.f1006oD;
    }

    /* renamed from: cU */
    public static C0867a m933cU() {
        return f1002oE;
    }

    /* renamed from: a */
    public HandlerThread mo9577a(String str, int i, long j) {
        return C0861fo.m949a(str, i, j);
    }

    /* renamed from: a */
    public void mo9578a(int i, Runnable runnable, String str, long j, boolean z, Object obj) {
        synchronized (this.f1004R) {
            C0858a aVar = new C0858a(i, runnable, str, j, z, obj);
            this.f1009ot.add(aVar);
            this.f1010ou.add(aVar);
            this.f1005oA.sendEmptyMessage(1);
        }
    }

    /* renamed from: a */
    public void mo9579a(Runnable runnable, String str, long j, boolean z, Object obj) {
        mo9578a(5, runnable, str, j, z, obj);
    }

    public void afterExecute(Runnable runnable, Throwable th) {
        boolean z;
        synchronized (this.f1004R) {
            C0858a aVar = (C0858a) runnable;
            Iterator it = this.f1011ov.keySet().iterator();
            if (it != null) {
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    C0858a aVar2 = (C0858a) it.next();
                    if (aVar2 != null && aVar2.equals(aVar)) {
                        it.remove();
                        z = true;
                        break;
                    }
                }
                if (z) {
                    aVar.mo9586cY().f1029oO = System.currentTimeMillis() - aVar.mo9586cY().f1029oO;
                    aVar.mo9586cY().f1030oP = Debug.threadCpuTimeNanos() - aVar.mo9586cY().f1030oP;
                    Iterator it2 = f1003or.iterator();
                    while (it2.hasNext()) {
                        ((C0867a) it2.next()).mo9584b(aVar.mo9586cY());
                    }
                }
            }
            int activeCount = this.f1013ox.getActiveCount();
            int size = this.f1013ox.getQueue().size();
            int corePoolSize = this.f1013ox.getCorePoolSize();
            if (activeCount == 1 && size == 0) {
                if (corePoolSize > 0) {
                    this.f1012ow = m928cO();
                    this.f1013ox.setCorePoolSize(0);
                    this.f1013ox.setMaximumPoolSize(this.f1012ow + 2);
                }
                Iterator it3 = this.f1007oq.iterator();
                while (it3.hasNext()) {
                    ((C0868b) it3.next()).mo9599dg();
                }
                this.f1014oy = false;
            }
        }
    }

    /* renamed from: b */
    public void mo9580b(Runnable runnable, String str, long j, boolean z, Object obj) {
        synchronized (this.f1004R) {
            C0858a aVar = new C0858a(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, runnable, str, j, z, obj);
            this.f1010ou.add(aVar);
            this.f1013ox.execute(aVar);
            if (this.f1013ox.getActiveCount() < this.f1012ow || this.f1012ow >= m929cP()) {
                m931cR();
            } else {
                this.f1012ow++;
                this.f1013ox.setCorePoolSize(this.f1012ow);
                this.f1013ox.setMaximumPoolSize(this.f1012ow);
                StringBuilder sb = new StringBuilder();
                sb.append("expand urgent core pool size: ");
                sb.append(this.f1012ow);
                C0848ff.m907i("ThreadPool", sb.toString());
            }
            Iterator it = f1003or.iterator();
            while (it.hasNext()) {
                ((C0867a) it.next()).mo9583a(aVar.mo9586cY(), this.f1013ox.getActiveCount());
            }
        }
    }

    public void beforeExecute(Thread thread, Runnable runnable) {
        synchronized (this.f1004R) {
            Iterator it = this.f1010ou.iterator();
            if (it != null) {
                C0858a aVar = (C0858a) runnable;
                int i = aVar.mo9586cY().priority;
                if (i < 1) {
                    i = 1;
                } else if (i > 10) {
                    i = 10;
                }
                thread.setPriority(i);
                boolean z = false;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C0858a aVar2 = (C0858a) it.next();
                    if (aVar2 != null && aVar2.equals(aVar)) {
                        it.remove();
                        z = true;
                        break;
                    }
                }
                if (z) {
                    if (!this.f1014oy) {
                        Iterator it2 = this.f1007oq.iterator();
                        while (it2.hasNext()) {
                            ((C0868b) it2.next()).mo9598df();
                        }
                    }
                    Iterator it3 = f1003or.iterator();
                    while (it3.hasNext()) {
                        ((C0867a) it3.next()).mo9582a(aVar.mo9586cY());
                    }
                    aVar.mo9586cY().f1029oO = System.currentTimeMillis();
                    aVar.mo9586cY().f1030oP = Debug.threadCpuTimeNanos();
                    this.f1011ov.put(aVar, thread);
                    thread.setName(aVar.mo9586cY().name);
                    this.f1014oy = true;
                }
            }
        }
    }

    /* renamed from: cS */
    public void mo9581cS() {
        synchronized (this.f1004R) {
            this.f1006oD = false;
            f1001oC = 0;
            f1000oB = 0;
            C0848ff.m907i("ThreadPool", "wake up threa pool");
        }
    }
}
