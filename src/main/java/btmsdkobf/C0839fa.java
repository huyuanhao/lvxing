package btmsdkobf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: btmsdkobf.fa */
public class C0839fa extends BroadcastReceiver {
    private static Object lock = new Object();
    /* renamed from: nV */
    private static C0839fa f971nV;
    /* renamed from: gI */
    private boolean f972gI;
    /* renamed from: nT */
    private State f973nT = State.DISCONNECTED;
    /* access modifiers changed from: private */
    /* renamed from: nU */
    public LinkedList<C0842a> f974nU = new LinkedList<>();

    /* renamed from: btmsdkobf.fa$a */
    public interface C0842a {
        /* renamed from: Z */
        void mo9191Z();

        /* renamed from: aa */
        void mo9192aa();
    }

    private C0839fa() {
    }

    /* renamed from: s */
    public static C0839fa m889s(Context context) {
        if (f971nV == null) {
            synchronized (lock) {
                if (f971nV == null) {
                    if (context == null) {
                        return null;
                    }
                    f971nV = new C0839fa();
                    f971nV.m890t(context);
                }
            }
        }
        return f971nV;
    }

    /* renamed from: t */
    private void m890t(Context context) {
        m891u(context);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:4|5|6|(1:8)(1:10)|9|11|12|(2:13|14)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001d */
    /* renamed from: u */
    private synchronized void m891u(android.content.Context r3) {
        /*
        r2 = this;
        monitor-enter(r2)
        boolean r0 = r2.f972gI     // Catch:{ all -> 0x0035 }
        if (r0 != 0) goto L_0x0033
        java.lang.String r0 = "connectivity"
        java.lang.Object r0 = r3.getSystemService(r0)     // Catch:{ all -> 0x001d }
        android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch:{ all -> 0x001d }
        android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()     // Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x001a
        android.net.NetworkInfo$State r0 = r0.getState()     // Catch:{ all -> 0x001d }
    L_0x0017:
        r2.f973nT = r0     // Catch:{ all -> 0x001d }
        goto L_0x001d
    L_0x001a:
        android.net.NetworkInfo$State r0 = android.net.NetworkInfo.State.DISCONNECTED     // Catch:{ all -> 0x001d }
        goto L_0x0017
    L_0x001d:
        android.content.IntentFilter r0 = new android.content.IntentFilter     // Catch:{ all -> 0x0035 }
        r0.<init>()     // Catch:{ all -> 0x0035 }
        java.lang.String r1 = "android.net.conn.CONNECTIVITY_CHANGE"
        r0.addAction(r1)     // Catch:{ all -> 0x0035 }
        r1 = 2147483647(0x7fffffff, float:NaN)
        r0.setPriority(r1)     // Catch:{ all -> 0x0035 }
        r3.registerReceiver(r2, r0)     // Catch:{ all -> 0x0033 }
        r3 = 1
        r2.f972gI = r3     // Catch:{ all -> 0x0033 }
    L_0x0033:
        monitor-exit(r2)
        return
    L_0x0035:
        r3 = move-exception
        monitor-exit(r2)
        throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0839fa.m891u(android.content.Context):void");
    }

    /* renamed from: a */
    public void mo9538a(C0842a aVar) {
        synchronized (this.f974nU) {
            this.f974nU.add(aVar);
        }
    }

    public void onReceive(Context context, Intent intent) {
        C0845fd cN;
        Runnable r0;
        String str;
        String action = intent.getAction();
        Bundle extras = intent.getExtras();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            State state = ((NetworkInfo) extras.getParcelable("networkInfo")).getState();
            if (state == State.CONNECTED) {
                if (this.f973nT.compareTo(State.DISCONNECTED) == 0) {
                    cN = C0845fd.m898cN();
                    r0 = new Runnable() {
                        public void run() {
                            LinkedList linkedList;
                            synchronized (C0839fa.this.f974nU) {
                                linkedList = (LinkedList) C0839fa.this.f974nU.clone();
                            }
                            if (linkedList != null) {
                                Iterator it = linkedList.iterator();
                                while (it.hasNext()) {
                                    ((C0842a) it.next()).mo9191Z();
                                }
                            }
                        }
                    };
                    str = "monitor_toConnected";
                }
                this.f973nT = state;
            } else if (state == State.DISCONNECTED) {
                if (this.f973nT.compareTo(State.CONNECTED) == 0) {
                    cN = C0845fd.m898cN();
                    r0 = new Runnable() {
                        public void run() {
                            LinkedList linkedList;
                            synchronized (C0839fa.this.f974nU) {
                                linkedList = (LinkedList) C0839fa.this.f974nU.clone();
                            }
                            if (linkedList != null) {
                                Iterator it = linkedList.iterator();
                                while (it.hasNext()) {
                                    ((C0842a) it.next()).mo9192aa();
                                }
                            }
                        }
                    };
                    str = "monitor_toDisconnected";
                }
                this.f973nT = state;
            } else {
                return;
            }
            cN.addUrgentTask(r0, str);
            this.f973nT = state;
        }
    }
}
