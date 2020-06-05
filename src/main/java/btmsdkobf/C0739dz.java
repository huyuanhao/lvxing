package btmsdkobf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: btmsdkobf.dz */
public class C0739dz extends BroadcastReceiver {
    /* renamed from: ka */
    private static Object f655ka = new Object();
    /* renamed from: kc */
    private static C0739dz f656kc = null;
    /* renamed from: jT */
    private long f657jT = 0;
    /* renamed from: jU */
    private boolean f658jU = false;
    /* renamed from: jV */
    private State f659jV = State.UNKNOWN;
    /* renamed from: jW */
    private String f660jW = null;
    /* renamed from: jX */
    private String f661jX = null;
    /* access modifiers changed from: private */
    /* renamed from: jY */
    public LinkedList<C0745a> f662jY = new LinkedList<>();
    /* access modifiers changed from: private */
    /* renamed from: jZ */
    public LinkedList<C0746b> f663jZ = new LinkedList<>();
    /* renamed from: kb */
    private Object f664kb = new Object();
    private Handler mHandler = new Handler(C0716dx.getLooper()) {
        public void handleMessage(Message message) {
            if (message.what == 1) {
                C0739dz.this.m543aV();
            }
        }
    };

    /* renamed from: btmsdkobf.dz$a */
    public interface C0745a {
        void onConnected();

        void onDisconnected();
    }

    /* renamed from: btmsdkobf.dz$b */
    public interface C0746b {
        /* renamed from: bs */
        void mo9325bs();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m540a(Intent intent) {
        synchronized (this.f664kb) {
            if (this.f657jT <= 0 || System.currentTimeMillis() - this.f657jT > 2000) {
                C0701dr.m387bj().mo9301bk();
                this.mHandler.removeMessages(1);
                this.mHandler.sendEmptyMessageDelayed(1, 5000);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("[conn_monitor]doOnRecv(), ignore for just register: ");
                sb.append(System.currentTimeMillis() - this.f657jT);
                C0849fg.m911d("SharkNetworkReceiver", sb.toString());
            }
            Bundle extras = intent.getExtras();
            if (extras != null) {
                NetworkInfo networkInfo = (NetworkInfo) extras.getParcelable("networkInfo");
                if (networkInfo != null) {
                    State state = networkInfo.getState();
                    String typeName = networkInfo.getTypeName();
                    String subtypeName = networkInfo.getSubtypeName();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("[conn_monitor]doOnRecv(), Sate: ");
                    sb2.append(this.f659jV);
                    sb2.append(" -> ");
                    sb2.append(state);
                    C0849fg.m914i("SharkNetworkReceiver", sb2.toString());
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("[conn_monitor]doOnRecv(), type: ");
                    sb3.append(this.f660jW);
                    sb3.append(" -> ");
                    sb3.append(typeName);
                    C0849fg.m914i("SharkNetworkReceiver", sb3.toString());
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("[conn_monitor]doOnRecv(), subType: ");
                    sb4.append(this.f661jX);
                    sb4.append(" -> ");
                    sb4.append(subtypeName);
                    C0849fg.m914i("SharkNetworkReceiver", sb4.toString());
                    if (state == State.CONNECTED) {
                        if (this.f659jV != State.CONNECTED) {
                            m547bO();
                        }
                    } else if (state == State.DISCONNECTED && this.f659jV != State.DISCONNECTED) {
                        m546bN();
                    }
                    this.f659jV = state;
                    this.f660jW = typeName;
                    this.f661jX = subtypeName;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: aV */
    public void m543aV() {
        C0845fd.m898cN().addUrgentTask(new Runnable() {
            public void run() {
                LinkedList linkedList;
                C0849fg.m911d("SharkNetworkReceiver", "[conn_monitor]handleNetworkChange()");
                synchronized (C0739dz.this.f663jZ) {
                    linkedList = (LinkedList) C0739dz.this.f663jZ.clone();
                }
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    C0746b bVar = (C0746b) it.next();
                    if (bVar != null) {
                        bVar.mo9325bs();
                    }
                }
            }
        }, "network_change");
    }

    /* renamed from: bM */
    public static C0739dz m545bM() {
        if (f656kc == null) {
            synchronized (f655ka) {
                if (f656kc == null) {
                    f656kc = new C0739dz();
                }
            }
        }
        f656kc.m548bP();
        return f656kc;
    }

    /* renamed from: bN */
    private void m546bN() {
        C0845fd.m898cN().addUrgentTask(new Runnable() {
            public void run() {
                LinkedList linkedList;
                C0849fg.m911d("SharkNetworkReceiver", "[conn_monitor]handleChange2DisConnected(), 有网络 -> 无网络");
                synchronized (C0739dz.this.f662jY) {
                    linkedList = (LinkedList) C0739dz.this.f662jY.clone();
                }
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    C0745a aVar = (C0745a) it.next();
                    if (aVar != null) {
                        aVar.onDisconnected();
                    }
                }
            }
        }, "network_disconnected");
    }

    /* renamed from: bO */
    private void m547bO() {
        C0845fd.m898cN().addUrgentTask(new Runnable() {
            public void run() {
                LinkedList linkedList;
                C0849fg.m911d("SharkNetworkReceiver", "[conn_monitor]handleChange2Connected(), 无网络 -> 有网络");
                C0689dg aU = C0689dg.m299aU();
                StringBuilder sb = new StringBuilder();
                sb.append("[conn_monitor][ip_list]handleChange2Connected(), notify hiplist first: ");
                sb.append(aU != null);
                C0849fg.m911d("SharkNetworkReceiver", sb.toString());
                if (aU != null) {
                    aU.mo9281aV();
                }
                synchronized (C0739dz.this.f662jY) {
                    linkedList = (LinkedList) C0739dz.this.f662jY.clone();
                }
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    C0745a aVar = (C0745a) it.next();
                    if (aVar != null) {
                        aVar.onConnected();
                    }
                }
            }
        }, "network_connected");
    }

    /* renamed from: bP */
    private void m548bP() {
        try {
            Context D = C0652cl.m85D();
            if (D != null) {
                m550p(D);
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("[conn_monitor]checkInit(), registerConnectivityIfNeed() failed: ");
            sb.append(th);
            C0849fg.m912e("SharkNetworkReceiver", sb.toString());
        }
    }

    /* renamed from: p */
    private synchronized void m550p(Context context) {
        String str;
        String sb;
        if (!this.f658jU) {
            try {
                NetworkInfo activeNetworkInfo = C0871h.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    this.f659jV = activeNetworkInfo.getState();
                    this.f660jW = activeNetworkInfo.getTypeName();
                    this.f661jX = activeNetworkInfo.getSubtypeName();
                    str = "SharkNetworkReceiver";
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("[conn_monitor]registerConnectivRityIfNeed(), got mLastState: ");
                    sb2.append(this.f659jV);
                    sb = sb2.toString();
                } else {
                    this.f659jV = State.DISCONNECTED;
                    str = "SharkNetworkReceiver";
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("[conn_monitor]registerConnectivRityIfNeed(), not got, set mLastState: ");
                    sb3.append(this.f659jV);
                    sb = sb3.toString();
                }
                C0849fg.m911d(str, sb);
            } catch (Exception e) {
                String str2 = "SharkNetworkReceiver";
                StringBuilder sb4 = new StringBuilder();
                sb4.append("[conn_monitor]getActiveNetworkInfo() failed: ");
                sb4.append(e);
                C0849fg.m912e(str2, sb4.toString());
            }
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                intentFilter.setPriority(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                context.registerReceiver(this, intentFilter);
                this.f657jT = System.currentTimeMillis();
                this.f658jU = true;
                C0849fg.m914i("SharkNetworkReceiver", "[conn_monitor]registerConnectivityIfNeed() succ");
            } catch (Throwable th) {
                String str3 = "SharkNetworkReceiver";
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[conn_monitor]registerConnectivityIfNeed() failed: ");
                sb5.append(th);
                C0849fg.m912e(str3, sb5.toString());
            }
        }
        return;
    }

    /* renamed from: a */
    public void mo9367a(C0745a aVar) {
        if (aVar != null) {
            synchronized (this.f662jY) {
                if (!this.f662jY.contains(aVar)) {
                    this.f662jY.add(aVar);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo9368a(C0746b bVar) {
        if (bVar != null) {
            synchronized (this.f663jZ) {
                if (!this.f663jZ.contains(bVar)) {
                    this.f663jZ.add(bVar);
                }
            }
        }
    }

    public void onReceive(Context context, final Intent intent) {
        if (intent != null && intent.getAction() != null) {
            String action = intent.getAction();
            StringBuilder sb = new StringBuilder();
            sb.append("[conn_monitor]doOnRecv(), action: ");
            sb.append(action);
            C0849fg.m911d("SharkNetworkReceiver", sb.toString());
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                this.mHandler.post(new Runnable() {
                    public void run() {
                        if (C0652cl.m84C()) {
                            C0739dz.this.m540a(intent);
                        }
                    }
                });
            }
        }
    }
}
