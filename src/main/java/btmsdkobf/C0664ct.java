package btmsdkobf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import btmsdkobf.C0638c.C0640a;
import btmsdkobf.C0839fa.C0842a;
import com.kwad.sdk.core.response.model.AdConfigData;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/* renamed from: btmsdkobf.ct */
public class C0664ct {
    /* renamed from: gD */
    static Object f448gD = new Object();
    /* renamed from: gE */
    static volatile long f449gE = -1;
    /* renamed from: gF */
    static volatile boolean f450gF = false;
    /* renamed from: gG */
    static C0666a f451gG = null;
    /* renamed from: gH */
    private static LinkedList<C0640a> f452gH = new LinkedList<>();

    /* renamed from: btmsdkobf.ct$a */
    static class C0666a extends BroadcastReceiver implements C0842a {
        /* renamed from: gI */
        public static boolean f453gI = false;

        C0666a() {
        }

        /* renamed from: Z */
        public void mo9191Z() {
            if (C0652cl.m84C()) {
                C0664ct.m136X();
                if (C0871h.m972o()) {
                    C0638c.m80g();
                    C0638c.m81h();
                }
            }
        }

        /* renamed from: aa */
        public void mo9192aa() {
        }

        /* renamed from: l */
        public synchronized void mo9193l(Context context) {
            if (!f453gI) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.USER_PRESENT");
                intentFilter.setPriority(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                context.registerReceiver(this, intentFilter);
                C0839fa s = C0839fa.m889s(context);
                if (s != null) {
                    s.mo9538a((C0842a) this);
                }
                f453gI = true;
            }
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                if (("android.intent.action.USER_PRESENT".equals(intent.getAction()) ? (char) 3 : 65535) != 65535 && C0652cl.m84C()) {
                    C0664ct.m136X();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0056, code lost:
            if (r4 <= r10) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0060, code lost:
            if (java.lang.Math.abs(r0 - r4) >= 86400000) goto L_0x0064;
     */
    /* renamed from: V */
    static boolean m134V() {
        /*
        long r0 = java.lang.System.currentTimeMillis()
        btmsdkobf.fb r2 = btmsdkobf.C0843fb.m895cM()
        java.lang.String r3 = "rs_rt"
        r4 = -1
        long r4 = r2.getLong(r3, r4)
        r2 = 0
        r6 = 0
        int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
        if (r8 >= 0) goto L_0x001f
        btmsdkobf.fb r4 = btmsdkobf.C0843fb.m895cM()
        r4.putLong(r3, r0)
        return r2
    L_0x001f:
        r3 = 1
        r6 = 86400000(0x5265c00, double:4.2687272E-316)
        int r8 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
        if (r8 <= 0) goto L_0x0059
        long r8 = r0 - r4
        int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
        if (r10 < 0) goto L_0x002e
        goto L_0x0064
    L_0x002e:
        java.util.Calendar r8 = java.util.Calendar.getInstance()
        r9 = 11
        r8.set(r9, r2)
        r9 = 12
        r8.set(r9, r2)
        r9 = 13
        r8.set(r9, r2)
        int r9 = m135W()
        long r10 = r8.getTimeInMillis()
        long r8 = (long) r9
        r12 = 1000(0x3e8, double:4.94E-321)
        long r8 = r8 * r12
        long r10 = r10 + r8
        int r8 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
        if (r8 <= 0) goto L_0x0054
        long r10 = r10 - r6
    L_0x0054:
        int r0 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
        if (r0 > 0) goto L_0x0063
        goto L_0x0064
    L_0x0059:
        long r0 = r0 - r4
        long r0 = java.lang.Math.abs(r0)
        int r4 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
        if (r4 < 0) goto L_0x0063
        goto L_0x0064
    L_0x0063:
        r3 = 0
    L_0x0064:
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0664ct.m134V():boolean");
    }

    /* renamed from: W */
    static int m135W() {
        String str = "rs_tt";
        int i = C0843fb.m895cM().getInt(str, -1);
        if (i > 0) {
            return i;
        }
        int d = m138d(1, 20);
        C0843fb.m895cM().putInt(str, d);
        return d;
    }

    /* renamed from: X */
    public static void m136X() {
        synchronized (f448gD) {
            C0848ff.m905d("ReportService", "checkPullReport");
            if (m134V()) {
                if (C0871h.m970m()) {
                    C0845fd.m898cN().addTask(new Runnable() {
                        public void run() {
                            if (System.currentTimeMillis() - C0664ct.f449gE >= 600000) {
                                C0664ct.f449gE = System.currentTimeMillis();
                                C0654cn.m92L();
                                C0664ct.m137Y();
                                C0843fb.m895cM().putLong("rs_rt", System.currentTimeMillis());
                                C0652cl.setAutoConnectionSwitch(C0652cl.m85D(), true);
                            }
                        }
                    }, "xxx");
                    return;
                }
            }
            C0848ff.m905d("ReportService", "checkPullReport, isNeedReport or isNetworkConnected [false]");
        }
    }

    /* renamed from: Y */
    public static synchronized void m137Y() {
        LinkedList linkedList;
        synchronized (C0664ct.class) {
            try {
                synchronized (f452gH) {
                    linkedList = (LinkedList) f452gH.clone();
                }
                if (linkedList != null) {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        C0640a aVar = (C0640a) it.next();
                        if (aVar != null) {
                            aVar.mo9160i();
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: d */
    static int m138d(int i, int i2) {
        int i3 = i2 - i;
        if (i3 < 0) {
            return -1;
        }
        Random random = new Random();
        random.setSeed(System.currentTimeMillis() + ((long) System.identityHashCode(random)));
        return ((((int) (random.nextDouble() * ((double) i3))) + i) * AdConfigData.DEFAULT_REQUEST_INTERVAL) + (((int) (random.nextDouble() * 60.0d)) * 60) + ((int) (random.nextDouble() * 60.0d));
    }

    public static void init() {
        if (f451gG == null) {
            f451gG = new C0666a();
            f451gG.mo9193l(C0652cl.m85D());
        }
    }
}
