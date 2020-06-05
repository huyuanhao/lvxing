package btmsdkobf;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import btmsdkobf.C0739dz.C0745a;
import btmsdkobf.C0846fe.C0847a;

/* renamed from: btmsdkobf.dr */
public class C0701dr implements C0745a {
    /* renamed from: R */
    private static Object f534R = new Object();
    /* renamed from: ia */
    private static C0701dr f535ia = null;
    /* access modifiers changed from: private */
    /* renamed from: ib */
    public int f536ib;
    /* renamed from: ic */
    private long f537ic;
    /* renamed from: id */
    private boolean f538id;
    /* renamed from: ie */
    private long f539ie;
    /* renamed from: if */
    private HandlerThread f540if;
    private Handler mHandler;

    /* renamed from: btmsdkobf.dr$a */
    private class C0703a extends Handler {
        public C0703a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what == 1) {
                C0701dr.this.m389bm();
            }
        }
    }

    private C0701dr() {
        this.f536ib = -6;
        this.f537ic = 0;
        this.f538id = false;
        this.f539ie = 0;
        this.f540if = null;
        this.mHandler = null;
        this.f540if = C0845fd.m898cN().newFreeHandlerThread("Shark-Network-Detect-HandlerThread");
        this.f540if.start();
        this.mHandler = new C0703a(this.f540if.getLooper());
        C0849fg.m914i("NetworkDetector", "[detect_conn]init, register & start detect");
        C0739dz.m545bM().mo9367a((C0745a) this);
        this.mHandler.sendEmptyMessageDelayed(1, 5000);
    }

    /* renamed from: bj */
    public static C0701dr m387bj() {
        C0701dr drVar;
        synchronized (f534R) {
            if (f535ia == null) {
                f535ia = new C0701dr();
            }
            drVar = f535ia;
        }
        return drVar;
    }

    /* renamed from: bl */
    private boolean m388bl() {
        return C0871h.m970m();
    }

    /* access modifiers changed from: private */
    /* renamed from: bm */
    public boolean m389bm() {
        String str;
        String str2 = "NetworkDetector";
        C0849fg.m914i(str2, "[detect_conn]detectSync()");
        this.f538id = true;
        try {
            str = C0846fe.m899a((C0847a) new C0847a() {
                /* renamed from: c */
                public void mo9305c(boolean z, boolean z2) {
                    C0701dr drVar;
                    int i;
                    StringBuilder sb = new StringBuilder();
                    sb.append("[detect_conn]detectSync(), network error? ");
                    sb.append(z2);
                    C0849fg.m914i("NetworkDetector", sb.toString());
                    if (z2) {
                        drVar = C0701dr.this;
                        i = -3;
                    } else if (z) {
                        drVar = C0701dr.this;
                        i = -2;
                    } else {
                        drVar = C0701dr.this;
                        i = 0;
                    }
                    drVar.f536ib = i;
                }
            });
        } catch (Throwable th) {
            this.f536ib = -3;
            StringBuilder sb = new StringBuilder();
            sb.append("[detect_conn]detectSync(), exception: ");
            sb.append(th.toString());
            C0849fg.m912e(str2, sb.toString());
            str = null;
        }
        this.f538id = false;
        this.f539ie = System.currentTimeMillis();
        boolean isEmpty = true ^ TextUtils.isEmpty(str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[detect_conn]detectSync(),  isNeed wifi approve? ");
        sb2.append(isEmpty);
        sb2.append(" url: ");
        sb2.append(str);
        sb2.append(" state: ");
        sb2.append(m390q(this.f536ib));
        C0849fg.m914i(str2, sb2.toString());
        return isEmpty;
    }

    /* renamed from: q */
    public static String m390q(int i) {
        String str = "NETWORK_STATE_NOT_INIT";
        switch (i) {
            case -6:
                return str;
            case -5:
                return "NETWORK_STATE_UNRELIABLE";
            case -4:
                return "NETWORK_STATE_CHANGING";
            case -3:
                return "NETWORK_STATE_UNREACHABLE";
            case -2:
                return "NETWORK_STATE_NEED_APPROVE_WIFI";
            case -1:
                return "NETWORK_STATE_NOCONNECT";
            case 0:
                return "NETWORK_STATE_OK";
            default:
                return str;
        }
    }

    /* renamed from: b */
    public int mo9300b(boolean z, boolean z2) {
        int i;
        if (m388bl()) {
            i = -1;
        } else {
            boolean z3 = this.f539ie > 0 && Math.abs(System.currentTimeMillis() - this.f539ie) <= 300000;
            if (z) {
                m389bm();
            } else {
                if (z2 && !z3 && Math.abs(System.currentTimeMillis() - this.f539ie) > 60000) {
                    this.mHandler.removeMessages(1);
                    this.mHandler.sendEmptyMessage(1);
                }
                if (this.f536ib == 0 && !z3) {
                    i = -5;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[detect_conn]getNetworkState(), mNetworkState: ");
            sb.append(m390q(this.f536ib));
            C0849fg.m914i("NetworkDetector", sb.toString());
            return this.f536ib;
        }
        this.f536ib = i;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[detect_conn]getNetworkState(), mNetworkState: ");
        sb2.append(m390q(this.f536ib));
        C0849fg.m914i("NetworkDetector", sb2.toString());
        return this.f536ib;
    }

    /* renamed from: bk */
    public void mo9301bk() {
        C0849fg.m914i("NetworkDetector", "[detect_conn] onNetworkingchanging");
        this.f536ib = -4;
        this.f537ic = System.currentTimeMillis();
    }

    /* renamed from: d */
    public boolean mo9302d(long j) {
        return this.f536ib == -4 && Math.abs(System.currentTimeMillis() - this.f537ic) < j;
    }

    public void onConnected() {
        mo9301bk();
        boolean z = this.f539ie > 0 && Math.abs(System.currentTimeMillis() - this.f539ie) < 60000;
        String str = "NetworkDetector";
        if (z || this.f538id) {
            C0849fg.m914i(str, "[detect_conn]onConnected(), trigger detect in 60000");
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, 60000);
            return;
        }
        C0849fg.m914i(str, "[detect_conn]onConnected(), trigger detect in 5s");
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, 5000);
    }

    public void onDisconnected() {
        C0849fg.m914i("NetworkDetector", "[detect_conn]onDisconnected()");
        mo9301bk();
        this.mHandler.removeMessages(1);
        this.f536ib = -1;
    }
}
