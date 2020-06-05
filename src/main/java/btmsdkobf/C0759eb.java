package btmsdkobf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import btmsdkobf.C0704ds.C0707b;
import btmsdkobf.C0718dy.C0735c;
import btmsdkobf.C0718dy.C0736d;
import btmsdkobf.C0718dy.C0737e;
import com.p522qq.p523e.comm.constants.ErrorCode.OtherError;
import com.p522qq.taf.jce.JceStruct;
import com.tencent.p605ep.common.adapt.iservice.net.ESharkCode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: btmsdkobf.eb */
public class C0759eb implements C0735c, C0736d, C0737e {
    /* renamed from: lb */
    private static volatile C0759eb f721lb;
    /* renamed from: lc */
    private static int f722lc;
    /* renamed from: ld */
    private static final long[] f723ld = {100, 60000, 120000};
    private final String TAG = "SharkProtocolQueue";
    /* renamed from: gZ */
    private C0695dl f724gZ;
    /* access modifiers changed from: private */
    /* renamed from: hA */
    public C0718dy f725hA;
    /* access modifiers changed from: private */
    /* renamed from: jh */
    public ExecutorService f726jh;
    /* access modifiers changed from: private */
    /* renamed from: js */
    public Handler f727js = new Handler(C0716dx.getLooper()) {
        public void handleMessage(Message message) {
            int size;
            final C0801ej ejVar;
            int i = 0;
            switch (message.what) {
                case 1:
                    C0759eb.this.f727js.removeMessages(1);
                    C0770e eVar = new C0770e();
                    ArrayList arrayList = new ArrayList();
                    synchronized (C0759eb.this.f729kK) {
                        Iterator it = C0759eb.this.f729kK.iterator();
                        while (it.hasNext()) {
                            C0769d dVar = (C0769d) it.next();
                            boolean b = C0759eb.this.f731kM != null ? C0759eb.this.f731kM.mo9488b(dVar.f788kz, dVar.f781kA) : true;
                            if ((dVar.f784kD & 1073741824) == 0) {
                                if (dVar.f793lF.mo9326bt()) {
                                    C0712dv.m412br().mo9323s(dVar.f779ir);
                                } else if (b) {
                                    eVar.mo9423a(Integer.valueOf(dVar.f779ir), dVar);
                                    i++;
                                }
                            } else if (b) {
                                eVar.f798lJ.add(dVar);
                                i++;
                            }
                            arrayList.add(dVar);
                        }
                        C0759eb.this.f729kK.clear();
                        if (arrayList.size() > 0) {
                            C0759eb.this.f729kK.addAll(arrayList);
                        }
                    }
                    if (i > 0) {
                        C0759eb.this.f726jh.submit(eVar);
                        return;
                    }
                    return;
                case 2:
                    C0716dx.f584iN = true;
                    C0849fg.m911d("SharkProtocolQueue", "[shark_init]=========== MSG_INIT_FINISH ==========");
                    synchronized (C0759eb.this.f729kK) {
                        size = C0759eb.this.f729kK.size();
                    }
                    if (size > 0) {
                        C0759eb.this.f727js.sendEmptyMessage(1);
                    }
                    if (C0759eb.this.f732kN) {
                        C0759eb.this.mo9414y(false);
                    }
                    if (C0759eb.this.f733kO) {
                        C0759eb.this.mo9414y(true);
                    }
                    if (C0759eb.this.f734kP) {
                        C0759eb.this.mo9405bU();
                    }
                    if (C0759eb.this.f735kQ) {
                        C0759eb.this.mo9400bB();
                    }
                    if (C0759eb.this.f736kR) {
                        C0759eb.this.onReady();
                    }
                    if (C0759eb.this.f737kS) {
                        C0759eb.this.mo9406bV();
                    }
                    if (C0759eb.this.f738kT) {
                        C0759eb.this.mo9402bG();
                    }
                    if (C0759eb.this.f739kU) {
                        C0759eb.this.mo9403bH();
                    }
                    if (C0759eb.this.f740kV) {
                        C0759eb.this.mo9399ap();
                    }
                    if (C0759eb.this.f742kX) {
                        C0759eb.this.mo9404bS();
                    }
                    if (C0759eb.this.f741kW != null) {
                        Iterator it2 = C0759eb.this.f741kW.iterator();
                        while (it2.hasNext()) {
                            C0700dq dqVar = (C0700dq) it2.next();
                            if (dqVar != null) {
                                C0759eb.this.mo9409c(dqVar.f531hY, dqVar.f532hZ, dqVar.f533hv);
                            }
                        }
                        C0759eb.this.f741kW = null;
                    }
                    if (C0759eb.this.f743kY) {
                        C0759eb.this.f743kY = false;
                        String guid = C0759eb.this.getGuid();
                        if (!TextUtils.isEmpty(guid)) {
                            C0849fg.m914i("SharkProtocolQueue", "[cu_guid] notifyGuidGot on init finished");
                            C0759eb.this.m594d(0, guid);
                        }
                    }
                    if (C0759eb.this.f744kZ) {
                        C0759eb.this.mo9407bW();
                    }
                    if (C0759eb.this.f747la) {
                        C0759eb.this.mo9408bX();
                        return;
                    }
                    return;
                case 3:
                    C0849fg.m911d("SharkProtocolQueue", "[shark_push]handle MSG_CLEAR_EXPIRED_PUSH");
                    ArrayList<C0767b> arrayList2 = new ArrayList<>();
                    ArrayList arrayList3 = new ArrayList();
                    synchronized (C0759eb.this.f728kJ) {
                        if (C0759eb.this.f728kJ.size() > 0) {
                            long currentTimeMillis = System.currentTimeMillis();
                            for (C0767b bVar : C0759eb.this.f728kJ) {
                                if (currentTimeMillis - bVar.f771lv >= 600000) {
                                    arrayList2.add(bVar);
                                } else {
                                    arrayList3.add(bVar);
                                }
                            }
                            C0759eb.this.f728kJ.clear();
                            C0759eb.this.f728kJ.addAll(arrayList3);
                        }
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("[shark_push]handle MSG_CLEAR_EXPIRED_PUSH, expired: ");
                    sb.append(arrayList2.size());
                    sb.append(" remain: ");
                    sb.append(arrayList3.size());
                    C0849fg.m911d("SharkProtocolQueue", sb.toString());
                    if (arrayList2.size() > 0) {
                        for (C0767b bVar2 : arrayList2) {
                            if (bVar2.f774ly == 0) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("[shark_push]sendPushResp() for expired push, cmd: ");
                                sb2.append(bVar2.f772lw.f383dO);
                                sb2.append(" pushId: ");
                                sb2.append(bVar2.f769fl);
                                C0849fg.m911d("SharkProtocolQueue", sb2.toString());
                                C0759eb.this.mo9394a(bVar2.f772lw.f385fm, bVar2.f769fl, bVar2.f772lw.f383dO, null, null, -2, ESharkCode.ERR_SHARK_TCP_PUSH_RET_CODE_SHARK_GOT_IT);
                            } else {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("[shark_push]no need to sendPushResp() for expired gift, cmd: ");
                                sb3.append(bVar2.f772lw.f383dO);
                                sb3.append(" pushId: ");
                                sb3.append(bVar2.f769fl);
                                C0849fg.m911d("SharkProtocolQueue", sb3.toString());
                            }
                        }
                        return;
                    }
                    return;
                case 4:
                    C0849fg.m911d("SharkProtocolQueue", "[shark_push]handle MSG_CLEAR_PUSH_CACHE");
                    ArrayList<C0767b> arrayList4 = new ArrayList<>();
                    synchronized (C0759eb.this.f728kJ) {
                        if (C0759eb.this.f728kJ.size() > 0) {
                            arrayList4.addAll(C0759eb.this.f728kJ);
                            C0759eb.this.f728kJ.clear();
                        }
                    }
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("[shark_push]handle MSG_CLEAR_PUSH_CACHE, ");
                    sb4.append(arrayList4.size());
                    sb4.append(" -> 0");
                    C0849fg.m911d("SharkProtocolQueue", sb4.toString());
                    if (arrayList4.size() > 0) {
                        for (C0767b bVar3 : arrayList4) {
                            if (bVar3.f774ly == 0) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("[shark_push]sendPushResp() on push cleared, cmd: ");
                                sb5.append(bVar3.f772lw.f383dO);
                                sb5.append(" pushId: ");
                                sb5.append(bVar3.f769fl);
                                C0849fg.m911d("SharkProtocolQueue", sb5.toString());
                                C0759eb.this.mo9394a(bVar3.f772lw.f385fm, bVar3.f769fl, bVar3.f772lw.f383dO, null, null, -2, ESharkCode.ERR_SHARK_TCP_PUSH_RET_CODE_SHARK_GOT_IT);
                            } else {
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append("[shark_push]no need to sendPushResp() on gift cleared, cmd: ");
                                sb6.append(bVar3.f772lw.f383dO);
                                sb6.append(" pushId: ");
                                sb6.append(bVar3.f769fl);
                                C0849fg.m911d("SharkProtocolQueue", sb6.toString());
                            }
                        }
                        return;
                    }
                    return;
                case 5:
                    final int i2 = message.arg1;
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("[shark_push]handle MSG_CHECK_CACHED_PUSH for cmd: ");
                    sb7.append(i2);
                    C0849fg.m911d("SharkProtocolQueue", sb7.toString());
                    synchronized (C0759eb.this.f745kk) {
                        ejVar = (C0801ej) C0759eb.this.f745kk.get(Integer.valueOf(i2));
                    }
                    final ArrayList arrayList5 = new ArrayList();
                    ArrayList arrayList6 = new ArrayList();
                    synchronized (C0759eb.this.f728kJ) {
                        if (C0759eb.this.f728kJ.size() > 0) {
                            for (C0767b bVar4 : C0759eb.this.f728kJ) {
                                if (bVar4.f772lw.f383dO == i2) {
                                    arrayList5.add(bVar4);
                                } else {
                                    arrayList6.add(bVar4);
                                }
                            }
                            C0759eb.this.f728kJ.clear();
                            C0759eb.this.f728kJ.addAll(arrayList6);
                        }
                    }
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append("[shark_push]handle MSG_CHECK_CACHED_PUSH, fixed: ");
                    sb8.append(arrayList5.size());
                    sb8.append(" remain: ");
                    sb8.append(arrayList6.size());
                    C0849fg.m911d("SharkProtocolQueue", sb8.toString());
                    if (ejVar != null && arrayList5.size() > 0) {
                        C0845fd.m898cN().addTask(new Runnable() {
                            public void run() {
                                for (C0767b bVar : arrayList5) {
                                    String str = " pushId: ";
                                    String str2 = "SharkProtocolQueue";
                                    if (bVar.f774ly == 0) {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("[shark_push]handle cached push, cmd: ");
                                        sb.append(i2);
                                        sb.append(str);
                                        sb.append(bVar.f769fl);
                                        C0849fg.m911d(str2, sb.toString());
                                        C0759eb.this.m580a(bVar.f769fl, bVar.f772lw, bVar.f773lx, ejVar);
                                    } else {
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append("[shark_push]handle cached gift, cmd: ");
                                        sb2.append(i2);
                                        sb2.append(str);
                                        sb2.append(bVar.f769fl);
                                        C0849fg.m911d(str2, sb2.toString());
                                        C0759eb.this.m588b(bVar.f769fl, bVar.f772lw, bVar.f773lx, ejVar);
                                    }
                                }
                            }
                        }, "shark callback: check cached push");
                        return;
                    }
                    return;
                case 6:
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append("[shark_vip] handle: MSG_RESET_VIP_RULE, expired VipRule: ");
                    sb9.append(C0759eb.this.f731kM);
                    C0849fg.m914i("SharkProtocolQueue", sb9.toString());
                    C0759eb.this.f731kM = null;
                    C0849fg.m914i("SharkProtocolQueue", "[shark_vip] triggle MSG_SEND_SHARK on VipRule expired ");
                    if (C0716dx.f584iN) {
                        C0759eb.this.f727js.sendEmptyMessage(1);
                        return;
                    }
                    return;
                case 7:
                    C0849fg.m914i("SharkProtocolQueue", "[cu_guid]handle: MSG_REQUEST_REG_GUID");
                    C0685df.m286n(C0652cl.m85D());
                    return;
                default:
                    return;
            }
        }
    };
    /* access modifiers changed from: private */
    /* renamed from: kJ */
    public List<C0767b> f728kJ = new ArrayList();
    /* access modifiers changed from: private */
    /* renamed from: kK */
    public ArrayList<C0769d> f729kK = new ArrayList<>();
    /* renamed from: kL */
    private C0808en<Long> f730kL = new C0808en<>(1000);
    /* access modifiers changed from: private */
    /* renamed from: kM */
    public C0806el f731kM;
    /* access modifiers changed from: private */
    /* renamed from: kN */
    public boolean f732kN = false;
    /* access modifiers changed from: private */
    /* renamed from: kO */
    public boolean f733kO = false;
    /* access modifiers changed from: private */
    /* renamed from: kP */
    public boolean f734kP = false;
    /* access modifiers changed from: private */
    /* renamed from: kQ */
    public boolean f735kQ = false;
    /* access modifiers changed from: private */
    /* renamed from: kR */
    public boolean f736kR = false;
    /* access modifiers changed from: private */
    /* renamed from: kS */
    public boolean f737kS = false;
    /* access modifiers changed from: private */
    /* renamed from: kT */
    public boolean f738kT = false;
    /* access modifiers changed from: private */
    /* renamed from: kU */
    public boolean f739kU = false;
    /* access modifiers changed from: private */
    /* renamed from: kV */
    public boolean f740kV = false;
    /* access modifiers changed from: private */
    /* renamed from: kW */
    public LinkedList<C0700dq> f741kW = null;
    /* access modifiers changed from: private */
    /* renamed from: kX */
    public boolean f742kX = false;
    /* access modifiers changed from: private */
    /* renamed from: kY */
    public boolean f743kY = false;
    /* access modifiers changed from: private */
    /* renamed from: kZ */
    public boolean f744kZ = false;
    /* access modifiers changed from: private */
    /* renamed from: kk */
    public TreeMap<Integer, C0801ej<JceStruct, C0696dm, C0768c>> f745kk = new TreeMap<>();
    /* access modifiers changed from: private */
    /* renamed from: kl */
    public Handler f746kl = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (message.what == 11) {
                Object[] objArr = (Object[]) message.obj;
                C0769d dVar = (C0769d) objArr[0];
                if (dVar.f787kw <= 0) {
                    dVar.f785kE.mo9159a(dVar.f779ir, ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue(), dVar.f783kC);
                } else if (dVar.f791lD != null) {
                    dVar.f791lD.mo9294a(dVar.f786kg, dVar.f787kw, dVar.f779ir, ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue(), dVar.f790lC);
                }
            }
        }
    };
    /* access modifiers changed from: private */
    /* renamed from: la */
    public boolean f747la = false;
    /* renamed from: le */
    private List<C0691dh> f748le = new ArrayList();
    /* renamed from: lf */
    private List<C0691dh> f749lf = new ArrayList();
    /* renamed from: lg */
    private List<C0733a> f750lg = new ArrayList();
    /* renamed from: lh */
    private C0765a f751lh = null;
    /* access modifiers changed from: private */
    public Context mContext = C0652cl.m85D();

    /* renamed from: btmsdkobf.eb$a */
    private final class C0765a extends BroadcastReceiver {
        /* renamed from: lq */
        private boolean f764lq;

        private C0765a() {
        }

        /* access modifiers changed from: private */
        /* renamed from: l */
        public void m646l(Context context) {
            if (!this.f764lq) {
                try {
                    String packageName = context.getPackageName();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(String.format("action.guid.got:%s", new Object[]{packageName}));
                    intentFilter.addAction(String.format("action.rsa.got:%s", new Object[]{packageName}));
                    intentFilter.addAction(String.format("action.reg.guid:%s", new Object[]{packageName}));
                    intentFilter.addAction(String.format("action.up.rsa:%s", new Object[]{packageName}));
                    intentFilter.addAction(String.format("action.d.a:%s", new Object[]{packageName}));
                    context.registerReceiver(this, intentFilter);
                    this.f764lq = true;
                } catch (Throwable th) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("[cu_guid] register: ");
                    sb.append(th);
                    C0849fg.m910a("SharkProtocolQueue", sb.toString(), th);
                    th.printStackTrace();
                }
            }
        }

        public void onReceive(final Context context, final Intent intent) {
            final String action = intent.getAction();
            if (intent.getPackage().compareToIgnoreCase(C0652cl.m85D().getPackageName()) == 0) {
                C0845fd.m898cN().addTask(new Runnable() {
                    public void run() {
                        String packageName = context.getPackageName();
                        String format = String.format("action.guid.got:%s", new Object[]{packageName});
                        String format2 = String.format("action.rsa.got:%s", new Object[]{packageName});
                        String format3 = String.format("action.reg.guid:%s", new Object[]{packageName});
                        String format4 = String.format("action.up.rsa:%s", new Object[]{packageName});
                        String format5 = String.format("action.d.a:%s", new Object[]{packageName});
                        String str = "k.rc";
                        String str2 = "SharkProtocolQueue";
                        if (format.equals(action)) {
                            C0759eb.this.f727js.removeMessages(7);
                            int intExtra = intent.getIntExtra(str, -1);
                            String stringExtra = intent.getStringExtra("k.g");
                            if (intExtra == 0 && !C0716dx.m428ar()) {
                                C0849fg.m914i(str2, "[cu_guid] doOnRecv(), !sendProcess, refreshGuid on recv broadcast");
                                C0759eb.this.mo9414y(true);
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append("[cu_guid] doOnRecv(), notifyGuidGot on recv broadcast: ");
                            sb.append(action);
                            C0849fg.m914i(str2, sb.toString());
                            C0759eb.this.m594d(intExtra, stringExtra);
                        } else if (format2.equals(action)) {
                            int intExtra2 = intent.getIntExtra(str, -1);
                            C0707b bVar = null;
                            if (intExtra2 == 0) {
                                bVar = new C0707b();
                                bVar.f551im = intent.getStringExtra("k.r.k");
                                bVar.f550il = intent.getStringExtra("k.r.s");
                                if (!C0716dx.m428ar()) {
                                    C0849fg.m914i(str2, "[rsa_key] doOnRecv(), !sendProcess, refreshRsaKey on recv broadcast");
                                    C0759eb.this.mo9414y(false);
                                }
                            }
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("[rsa_key] doOnRecv(), notifyRsaKeyGot on recv broadcast: ");
                            sb2.append(action);
                            C0849fg.m914i(str2, sb2.toString());
                            C0759eb.this.m587b(intExtra2, bVar);
                        } else if (format3.equals(action)) {
                            if (C0716dx.m428ar()) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("[rsa_key] doOnRecv(), triggerRegGuid on recv broadcast: ");
                                sb3.append(action);
                                C0849fg.m914i(str2, sb3.toString());
                                C0759eb.this.mo9400bB();
                            }
                        } else if (format4.equals(action)) {
                            if (C0716dx.m428ar()) {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("[rsa_key] doOnRecv(), triggerUpdateRsaKey on recv broadcast: ");
                                sb4.append(action);
                                C0849fg.m914i(str2, sb4.toString());
                                C0759eb.this.mo9405bU();
                            }
                        } else if (format5.equals(action) && C0716dx.m428ar()) {
                            try {
                                int intExtra3 = intent.getIntExtra("k.sa", 0);
                                if (intExtra3 == 1) {
                                    Bundle extras = intent.getExtras();
                                    C0759eb.this.mo9397a((C0806el) extras.getSerializable("v.r"), extras.getLong("vt.m", 35000));
                                } else if (intExtra3 == 2) {
                                    C0759eb.this.mo9404bS();
                                }
                            } catch (Throwable th) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("[shark_vip] doOnRecv(), setVipRule: ");
                                sb5.append(th);
                                C0849fg.m910a(str2, sb5.toString(), th);
                            }
                        }
                    }
                }, "GuidOrRsaKeyGotReceiver onRecv");
            }
        }
    }

    /* renamed from: btmsdkobf.eb$b */
    private class C0767b {
        /* renamed from: fl */
        long f769fl;
        /* renamed from: lv */
        long f771lv;
        /* renamed from: lw */
        C0647cg f772lw;
        /* renamed from: lx */
        byte[] f773lx;
        /* renamed from: ly */
        int f774ly = 0;

        public C0767b(int i, long j, long j2, C0647cg cgVar, byte[] bArr) {
            this.f774ly = i;
            this.f771lv = j;
            this.f769fl = j2;
            this.f772lw = cgVar;
            this.f773lx = bArr;
        }
    }

    /* renamed from: btmsdkobf.eb$c */
    public static class C0768c {
        /* renamed from: lA */
        public long f775lA;
        /* renamed from: lz */
        public boolean f776lz;

        public C0768c(boolean z, long j) {
            this.f776lz = z;
            this.f775lA = j;
        }
    }

    /* renamed from: btmsdkobf.eb$d */
    private class C0769d {
        /* renamed from: fl */
        public long f777fl;
        /* renamed from: fq */
        public int f778fq;
        /* renamed from: ir */
        public int f779ir;
        /* renamed from: jP */
        public long f780jP = System.currentTimeMillis();
        /* renamed from: kA */
        public long f781kA;
        /* renamed from: kB */
        public JceStruct f782kB;
        /* renamed from: kC */
        public JceStruct f783kC;
        /* renamed from: kD */
        public int f784kD;
        /* renamed from: kE */
        public C0693dj f785kE;
        /* renamed from: kg */
        public int f786kg;
        /* renamed from: kw */
        public int f787kw;
        /* renamed from: kz */
        public int f788kz;
        /* renamed from: lB */
        public byte[] f789lB;
        /* renamed from: lC */
        public byte[] f790lC;
        /* renamed from: lD */
        public C0694dk f791lD;
        /* renamed from: lE */
        public int f792lE;
        /* renamed from: lF */
        public C0715dw f793lF;
        /* renamed from: lG */
        public long f794lG = -1;
        /* renamed from: lH */
        public long f795lH = 0;

        C0769d(int i, int i2, long j, int i3, JceStruct jceStruct, byte[] bArr, JceStruct jceStruct2, int i4, C0693dj djVar, C0694dk dkVar) {
            this.f786kg = i;
            this.f787kw = i2;
            this.f781kA = j;
            this.f788kz = i3;
            this.f782kB = jceStruct;
            this.f789lB = bArr;
            this.f783kC = jceStruct2;
            this.f784kD = i4;
            this.f785kE = djVar;
            this.f791lD = dkVar;
            this.f793lF = new C0715dw();
        }

        /* renamed from: bJ */
        public boolean mo9421bJ() {
            long abs = Math.abs(System.currentTimeMillis() - this.f780jP);
            long j = this.f794lG;
            if (j <= 0) {
                j = 30000;
            }
            boolean z = abs >= j;
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append("cmdId|");
                sb.append(this.f788kz);
                sb.append("|mIpcSeqNo|");
                sb.append(this.f787kw);
                sb.append("|mSeqNo|");
                sb.append(this.f779ir);
                sb.append("|pushId|");
                sb.append(this.f777fl);
                sb.append("|mCallerIdent|");
                sb.append(this.f781kA);
                sb.append("|callBackTimeout|");
                sb.append(this.f794lG);
                sb.append("|time(s)|");
                sb.append(abs / 1000);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[ocean][time_out]SharkProtocolQueue.SharkSendTask.isTimeOut(), ");
                sb2.append(sb.toString());
                C0849fg.m912e(ESharkCode.SHARK_OCEAN, sb2.toString());
            }
            return z;
        }
    }

    /* renamed from: btmsdkobf.eb$e */
    private class C0770e implements Runnable {
        /* renamed from: lI */
        private TreeMap<Integer, C0769d> f797lI;
        /* access modifiers changed from: private */
        /* renamed from: lJ */
        public ArrayList<C0769d> f798lJ;
        /* renamed from: lK */
        private Handler f799lK;
        /* renamed from: lL */
        private Handler f800lL;

        private C0770e() {
            this.f797lI = new TreeMap<>();
            this.f798lJ = new ArrayList<>();
            this.f799lK = new Handler(C0716dx.getLooper()) {
                public void handleMessage(Message message) {
                    C0791eh ehVar = (C0791eh) message.obj;
                    C0647cg cgVar = new C0647cg();
                    cgVar.f388fq = -11050000;
                    cgVar.f386fn = message.what;
                    if (ehVar != null) {
                        cgVar.f383dO = ehVar.f856hY;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("接收超时：seq: ");
                    sb.append(cgVar.f386fn);
                    sb.append(" cmdId: ");
                    sb.append(cgVar.f383dO);
                    C0849fg.m912e("SharkProtocolQueue", sb.toString());
                    C0770e.this.m654d(cgVar);
                }
            };
            this.f800lL = new Handler(C0716dx.getLooper()) {
                public void handleMessage(Message message) {
                    if (message.what == 1) {
                        C0647cg cgVar = new C0647cg();
                        cgVar.f388fq = -10000017;
                        cgVar.f386fn = message.arg1;
                        cgVar.f383dO = message.arg2;
                        StringBuilder sb = new StringBuilder();
                        sb.append("[time_out]发送请求超时： seq: ");
                        sb.append(cgVar.f386fn);
                        sb.append(" cmdId: ");
                        sb.append(cgVar.f383dO);
                        C0849fg.m912e("SharkProtocolQueue", sb.toString());
                        C0770e.this.m654d(cgVar);
                    }
                }
            };
        }

        /* renamed from: B */
        private void m648B(int i) {
            Set<Entry> bR = mo9424bR();
            synchronized (this.f797lI) {
                this.f797lI.clear();
            }
            for (Entry entry : bR) {
                try {
                    m650a((C0647cg) null, (C0769d) entry.getValue(), Integer.valueOf(((C0769d) entry.getValue()).f788kz), Integer.valueOf(i), Integer.valueOf(-1));
                } catch (Throwable th) {
                    C0849fg.m913e("SharkProtocolQueue", "callback crash", th);
                }
            }
        }

        /* renamed from: a */
        private void m650a(C0647cg cgVar, C0769d dVar, Integer num, Integer num2, Integer num3) {
            dVar.f793lF.setState(2);
            int l = C0673cz.m215l(num2.intValue());
            C0712dv br = C0712dv.m412br();
            int intValue = num.intValue();
            if (cgVar == null) {
                br.mo9318a("SharkProtocolQueue", intValue, dVar.f779ir, cgVar, 30, l);
                C0712dv.m412br().mo9324t(dVar.f779ir);
            } else {
                br.mo9318a("SharkProtocolQueue", intValue, cgVar.f386fn, cgVar, 30, l);
                C0712dv.m412br().mo9324t(cgVar.f386fn);
            }
            if (dVar.f785kE != null || dVar.f791lD != null) {
                int g = C0668cv.m143g(dVar.f784kD);
                if (g == 8) {
                    C0759eb.this.f746kl.sendMessage(C0759eb.this.f746kl.obtainMessage(11, new Object[]{dVar, num, Integer.valueOf(l), num3}));
                } else if (g != 16) {
                    final C0769d dVar2 = dVar;
                    final Integer num4 = num;
                    final int i = l;
                    final Integer num5 = num3;
                    C07777 r2 = new Runnable() {
                        public void run() {
                            if (dVar2.f791lD == null || dVar2.f787kw <= 0) {
                                dVar2.f785kE.mo9159a(dVar2.f779ir, num4.intValue(), i, num5.intValue(), dVar2.f783kC);
                            } else {
                                dVar2.f791lD.mo9294a(dVar2.f786kg, dVar2.f787kw, dVar2.f779ir, num4.intValue(), i, num5.intValue(), dVar2.f790lC);
                            }
                        }
                    };
                    if (num.intValue() == 2016 || num.intValue() == 12016) {
                        C0845fd.m898cN().addUrgentTask(r2, "shark callback(urgent)");
                    } else {
                        C0845fd.m898cN().addTask(r2, "shark callback");
                    }
                } else if (dVar.f791lD == null || dVar.f787kw <= 0) {
                    dVar.f785kE.mo9159a(dVar.f779ir, num.intValue(), l, num3.intValue(), dVar.f783kC);
                } else {
                    dVar.f791lD.mo9294a(dVar.f786kg, dVar.f787kw, dVar.f779ir, num.intValue(), l, num3.intValue(), dVar.f790lC);
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m653b(boolean z, int i, int i2, ArrayList<C0647cg> arrayList) {
            if (i == 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    C0647cg cgVar = (C0647cg) it.next();
                    if (mo9422A(cgVar.f386fn)) {
                        m654d(cgVar);
                    } else if (C0759eb.m590b(cgVar)) {
                        C0759eb.this.mo9357a(z, i2, cgVar);
                    } else if (C0759eb.m592c(cgVar)) {
                        C0759eb.this.mo9358b(z, i2, cgVar);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("No callback xx: cmd : ");
                        sb.append(cgVar.f383dO);
                        sb.append(" seqNo : ");
                        sb.append(cgVar.f385fm);
                        sb.append(" refSeqNo : ");
                        sb.append(cgVar.f386fn);
                        C0849fg.m916w("SharkProtocolQueue", sb.toString());
                    }
                }
                return;
            }
            m648B(i);
        }

        /* JADX INFO: used method not loaded: btmsdkobf.dd.a(android.content.Context, byte[], byte[], int):null, types can be incorrect */
        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x002c, code lost:
            if (r13.f387fo == null) goto L_0x00a8;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0030, code lost:
            if (r13.f388fq != 0) goto L_0x00a8;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
            if (r4.f791lD == null) goto L_0x0059;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0038, code lost:
            if (r4.f787kw <= 0) goto L_0x0059;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
            r0 = btmsdkobf.C0683dd.m254a(btmsdkobf.C0759eb.m612u(r12.f801li), btmsdkobf.C0759eb.m613v(r12.f801li).mo9333ac().f551im.getBytes(), r13.f387fo, r13.f390ft);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x007a, code lost:
            r1 = btmsdkobf.C0683dd.m248a(btmsdkobf.C0759eb.m612u(r12.f801li), btmsdkobf.C0759eb.m613v(r12.f801li).mo9333ac().f551im.getBytes(), r13.f387fo, r4.f783kC, false, r13.f390ft);
            r0 = null;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x007d, code lost:
            if (r1 != null) goto L_0x00a9;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x007f, code lost:
            if (r0 != null) goto L_0x00a9;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0083, code lost:
            if (r4.f783kC == null) goto L_0x00a9;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0085, code lost:
            r13.f388fq = btmsdkobf.C0673cz.m215l(-11000300);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x008f, code lost:
            r2 = move-exception;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0090, code lost:
            r11 = r2;
            r2 = r0;
            r0 = r11;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0094, code lost:
            r0 = th;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0095, code lost:
            r2 = null;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0096, code lost:
            btmsdkobf.C0849fg.m913e("SharkProtocolQueue", "sashimi decode fail", r0);
            r13.f388fq = btmsdkobf.C0673cz.m215l(-11000900);
            r0 = r2;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a8, code lost:
            r0 = null;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ab, code lost:
            if (r4.f790lC != r0) goto L_0x00ad;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ad, code lost:
            r4.f790lC = r0;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b1, code lost:
            if (r4.f783kC != r1) goto L_0x00b3;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b3, code lost:
            r4.f783kC = r1;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
            m650a(r13, r4, java.lang.Integer.valueOf(r13.f383dO), java.lang.Integer.valueOf(r13.f388fq), java.lang.Integer.valueOf(r13.f389fr));
     */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00cd, code lost:
            r13 = move-exception;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ce, code lost:
            btmsdkobf.C0849fg.m910a("SharkProtocolQueue", "callback crash", (java.lang.Throwable) r13);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d5, code lost:
            return;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
            r1 = null;
     */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00ad  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00b3  */
        /* renamed from: d */
        public void m654d(btmsdkobf.C0647cg r13) {
            /*
            r12 = this;
            android.os.Handler r0 = r12.f799lK
            int r1 = r13.f386fn
            r0.removeMessages(r1)
            java.util.TreeMap<java.lang.Integer, btmsdkobf.eb$d> r0 = r12.f797lI
            monitor-enter(r0)
            java.util.TreeMap<java.lang.Integer, btmsdkobf.eb$d> r1 = r12.f797lI     // Catch:{ all -> 0x00d6 }
            int r2 = r13.f386fn     // Catch:{ all -> 0x00d6 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x00d6 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x00d6 }
            r4 = r1
            btmsdkobf.eb$d r4 = (btmsdkobf.C0759eb.C0769d) r4     // Catch:{ all -> 0x00d6 }
            if (r4 != 0) goto L_0x001d
            monitor-exit(r0)     // Catch:{ all -> 0x00d6 }
            return
        L_0x001d:
            java.util.TreeMap<java.lang.Integer, btmsdkobf.eb$d> r1 = r12.f797lI     // Catch:{ all -> 0x00d6 }
            int r2 = r13.f386fn     // Catch:{ all -> 0x00d6 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x00d6 }
            r1.remove(r2)     // Catch:{ all -> 0x00d6 }
            monitor-exit(r0)     // Catch:{ all -> 0x00d6 }
            byte[] r0 = r13.f387fo
            r1 = 0
            if (r0 == 0) goto L_0x00a8
            int r0 = r13.f388fq
            if (r0 != 0) goto L_0x00a8
            btmsdkobf.dk r0 = r4.f791lD     // Catch:{ all -> 0x0094 }
            if (r0 == 0) goto L_0x0059
            int r0 = r4.f787kw     // Catch:{ all -> 0x0094 }
            if (r0 <= 0) goto L_0x0059
            btmsdkobf.eb r0 = btmsdkobf.C0759eb.this     // Catch:{ all -> 0x0094 }
            android.content.Context r0 = r0.mContext     // Catch:{ all -> 0x0094 }
            btmsdkobf.eb r2 = btmsdkobf.C0759eb.this     // Catch:{ all -> 0x0094 }
            btmsdkobf.dy r2 = r2.f725hA     // Catch:{ all -> 0x0094 }
            btmsdkobf.ds$b r2 = r2.mo9333ac()     // Catch:{ all -> 0x0094 }
            java.lang.String r2 = r2.f551im     // Catch:{ all -> 0x0094 }
            byte[] r2 = r2.getBytes()     // Catch:{ all -> 0x0094 }
            byte[] r3 = r13.f387fo     // Catch:{ all -> 0x0094 }
            int r5 = r13.f390ft     // Catch:{ all -> 0x0094 }
            byte[] r0 = btmsdkobf.C0683dd.m254a(r0, r2, r3, r5)     // Catch:{ all -> 0x0094 }
            goto L_0x007d
        L_0x0059:
            btmsdkobf.eb r0 = btmsdkobf.C0759eb.this     // Catch:{ all -> 0x0094 }
            android.content.Context r5 = r0.mContext     // Catch:{ all -> 0x0094 }
            btmsdkobf.eb r0 = btmsdkobf.C0759eb.this     // Catch:{ all -> 0x0094 }
            btmsdkobf.dy r0 = r0.f725hA     // Catch:{ all -> 0x0094 }
            btmsdkobf.ds$b r0 = r0.mo9333ac()     // Catch:{ all -> 0x0094 }
            java.lang.String r0 = r0.f551im     // Catch:{ all -> 0x0094 }
            byte[] r6 = r0.getBytes()     // Catch:{ all -> 0x0094 }
            byte[] r7 = r13.f387fo     // Catch:{ all -> 0x0094 }
            com.qq.taf.jce.JceStruct r8 = r4.f783kC     // Catch:{ all -> 0x0094 }
            r9 = 0
            int r10 = r13.f390ft     // Catch:{ all -> 0x0094 }
            com.qq.taf.jce.JceStruct r0 = btmsdkobf.C0683dd.m248a(r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0094 }
            r11 = r1
            r1 = r0
            r0 = r11
        L_0x007d:
            if (r1 != 0) goto L_0x00a9
            if (r0 != 0) goto L_0x00a9
            com.qq.taf.jce.JceStruct r2 = r4.f783kC     // Catch:{ all -> 0x008f }
            if (r2 == 0) goto L_0x00a9
            r2 = -11000300(0xffffffffff582614, float:-2.8731096E38)
            int r2 = btmsdkobf.C0673cz.m215l(r2)     // Catch:{ all -> 0x008f }
            r13.f388fq = r2     // Catch:{ all -> 0x008f }
            goto L_0x00a9
        L_0x008f:
            r2 = move-exception
            r11 = r2
            r2 = r0
            r0 = r11
            goto L_0x0096
        L_0x0094:
            r0 = move-exception
            r2 = r1
        L_0x0096:
            java.lang.String r3 = "SharkProtocolQueue"
            java.lang.String r5 = "sashimi decode fail"
            btmsdkobf.C0849fg.m913e(r3, r5, r0)
            r0 = -11000900(0xffffffffff5823bc, float:-2.872988E38)
            int r0 = btmsdkobf.C0673cz.m215l(r0)
            r13.f388fq = r0
            r0 = r2
            goto L_0x00a9
        L_0x00a8:
            r0 = r1
        L_0x00a9:
            byte[] r2 = r4.f790lC
            if (r2 == r0) goto L_0x00af
            r4.f790lC = r0
        L_0x00af:
            com.qq.taf.jce.JceStruct r0 = r4.f783kC
            if (r0 == r1) goto L_0x00b5
            r4.f783kC = r1
        L_0x00b5:
            int r0 = r13.f383dO     // Catch:{ Exception -> 0x00cd }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x00cd }
            int r0 = r13.f388fq     // Catch:{ Exception -> 0x00cd }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x00cd }
            int r0 = r13.f389fr     // Catch:{ Exception -> 0x00cd }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x00cd }
            r2 = r12
            r3 = r13
            r2.m650a(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x00cd }
            goto L_0x00d5
        L_0x00cd:
            r13 = move-exception
            java.lang.String r0 = "SharkProtocolQueue"
            java.lang.String r1 = "callback crash"
            btmsdkobf.C0849fg.m910a(r0, r1, r13)
        L_0x00d5:
            return
        L_0x00d6:
            r13 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00d6 }
            throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0759eb.C0770e.m654d(btmsdkobf.cg):void");
        }

        /* renamed from: A */
        public boolean mo9422A(int i) {
            boolean containsKey;
            synchronized (this.f797lI) {
                containsKey = this.f797lI.containsKey(Integer.valueOf(i));
            }
            return containsKey;
        }

        /* renamed from: a */
        public void mo9423a(Integer num, C0769d dVar) {
            this.f797lI.put(num, dVar);
        }

        /* renamed from: bR */
        public Set<Entry<Integer, C0769d>> mo9424bR() {
            TreeMap treeMap;
            synchronized (this.f797lI) {
                treeMap = (TreeMap) this.f797lI.clone();
            }
            return treeMap.entrySet();
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(9:42|43|44|(1:46)(1:47)|48|49|(1:51)(2:52|(1:54)(2:55|(1:57)(1:58)))|59|84) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x0244 */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x024a A[Catch:{ Exception -> 0x02ef }] */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x024e A[Catch:{ Exception -> 0x02ef }] */
        public void run() {
            /*
            r24 = this;
            r1 = r24
            java.lang.String r2 = "SharkProtocolQueue"
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ Exception -> 0x02ef }
            r8.<init>()     // Catch:{ Exception -> 0x02ef }
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ Exception -> 0x02ef }
            r14.<init>()     // Catch:{ Exception -> 0x02ef }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x02ef }
            r0.<init>()     // Catch:{ Exception -> 0x02ef }
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ Exception -> 0x02ef }
            r15.<init>()     // Catch:{ Exception -> 0x02ef }
            java.util.Set r3 = r24.mo9424bR()     // Catch:{ Exception -> 0x02ef }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x02ef }
            r4 = 0
            r22 = r4
        L_0x0024:
            boolean r6 = r3.hasNext()     // Catch:{ Exception -> 0x02ef }
            r7 = 0
            if (r6 == 0) goto L_0x0170
            java.lang.Object r6 = r3.next()     // Catch:{ Exception -> 0x02ef }
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch:{ Exception -> 0x02ef }
            java.lang.Object r9 = r6.getValue()     // Catch:{ Exception -> 0x02ef }
            btmsdkobf.eb$d r9 = (btmsdkobf.C0759eb.C0769d) r9     // Catch:{ Exception -> 0x02ef }
            btmsdkobf.dw r9 = r9.f793lF     // Catch:{ Exception -> 0x02ef }
            boolean r9 = r9.mo9326bt()     // Catch:{ Exception -> 0x02ef }
            if (r9 != 0) goto L_0x0024
            java.lang.Object r9 = r6.getValue()     // Catch:{ Exception -> 0x02ef }
            btmsdkobf.eb$d r9 = (btmsdkobf.C0759eb.C0769d) r9     // Catch:{ Exception -> 0x02ef }
            boolean r9 = r9.mo9421bJ()     // Catch:{ Exception -> 0x02ef }
            r10 = 1
            if (r9 == 0) goto L_0x0066
            android.os.Handler r7 = r1.f800lL     // Catch:{ Exception -> 0x02ef }
            java.lang.Object r9 = r6.getValue()     // Catch:{ Exception -> 0x02ef }
            btmsdkobf.eb$d r9 = (btmsdkobf.C0759eb.C0769d) r9     // Catch:{ Exception -> 0x02ef }
            int r9 = r9.f779ir     // Catch:{ Exception -> 0x02ef }
            java.lang.Object r6 = r6.getValue()     // Catch:{ Exception -> 0x02ef }
            btmsdkobf.eb$d r6 = (btmsdkobf.C0759eb.C0769d) r6     // Catch:{ Exception -> 0x02ef }
            int r6 = r6.f788kz     // Catch:{ Exception -> 0x02ef }
            android.os.Message r6 = r7.obtainMessage(r10, r9, r6)     // Catch:{ Exception -> 0x02ef }
            r6.sendToTarget()     // Catch:{ Exception -> 0x02ef }
            goto L_0x0024
        L_0x0066:
            java.lang.Object r9 = r6.getValue()     // Catch:{ Exception -> 0x02ef }
            btmsdkobf.eb$d r9 = (btmsdkobf.C0759eb.C0769d) r9     // Catch:{ Exception -> 0x02ef }
            btmsdkobf.dw r9 = r9.f793lF     // Catch:{ Exception -> 0x02ef }
            r9.setState(r10)     // Catch:{ Exception -> 0x02ef }
            btmsdkobf.by r9 = new btmsdkobf.by     // Catch:{ Exception -> 0x02ef }
            r9.m40575init()     // Catch:{ Exception -> 0x02ef }
            java.lang.Object r10 = r6.getValue()     // Catch:{ Exception -> 0x02ef }
            btmsdkobf.eb$d r10 = (btmsdkobf.C0759eb.C0769d) r10     // Catch:{ Exception -> 0x02ef }
            int r10 = r10.f788kz     // Catch:{ Exception -> 0x02ef }
            r9.f357dO = r10     // Catch:{ Exception -> 0x02ef }
            java.lang.Object r10 = r6.getValue()     // Catch:{ Exception -> 0x02ef }
            btmsdkobf.eb$d r10 = (btmsdkobf.C0759eb.C0769d) r10     // Catch:{ Exception -> 0x02ef }
            int r10 = r10.f779ir     // Catch:{ Exception -> 0x02ef }
            r9.f358fm = r10     // Catch:{ Exception -> 0x02ef }
            java.lang.Object r10 = r6.getValue()     // Catch:{ Exception -> 0x02ef }
            btmsdkobf.eb$d r10 = (btmsdkobf.C0759eb.C0769d) r10     // Catch:{ Exception -> 0x02ef }
            long r10 = r10.f781kA     // Catch:{ Exception -> 0x02ef }
            r9.f361fp = r10     // Catch:{ Exception -> 0x02ef }
            r10 = 0
            r9.f359fn = r10     // Catch:{ Exception -> 0x02ef }
            r9.f360fo = r7     // Catch:{ Exception -> 0x02ef }
            java.lang.Object r7 = r6.getValue()     // Catch:{ Exception -> 0x02ef }
            btmsdkobf.eb$d r7 = (btmsdkobf.C0759eb.C0769d) r7     // Catch:{ Exception -> 0x02ef }
            byte[] r7 = r7.f789lB     // Catch:{ Exception -> 0x02ef }
            if (r7 == 0) goto L_0x00ba
            java.lang.Object r7 = r6.getValue()     // Catch:{ Exception -> 0x02ef }
            btmsdkobf.eb$d r7 = (btmsdkobf.C0759eb.C0769d) r7     // Catch:{ Exception -> 0x02ef }
            byte[] r7 = r7.f789lB     // Catch:{ Exception -> 0x02ef }
            btmsdkobf.eb r10 = btmsdkobf.C0759eb.this     // Catch:{ Exception -> 0x02ef }
            android.content.Context r10 = r10.mContext     // Catch:{ Exception -> 0x02ef }
            int r11 = r9.f357dO     // Catch:{ Exception -> 0x02ef }
            byte[] r7 = btmsdkobf.C0683dd.m253a(r10, r7, r11, r9)     // Catch:{ Exception -> 0x02ef }
            r9.f360fo = r7     // Catch:{ Exception -> 0x02ef }
            goto L_0x00d0
        L_0x00ba:
            java.lang.Object r7 = r6.getValue()     // Catch:{ Exception -> 0x02ef }
            btmsdkobf.eb$d r7 = (btmsdkobf.C0759eb.C0769d) r7     // Catch:{ Exception -> 0x02ef }
            com.qq.taf.jce.JceStruct r7 = r7.f782kB     // Catch:{ Exception -> 0x02ef }
            btmsdkobf.eb r10 = btmsdkobf.C0759eb.this     // Catch:{ Exception -> 0x02ef }
            android.content.Context r10 = r10.mContext     // Catch:{ Exception -> 0x02ef }
            int r11 = r9.f357dO     // Catch:{ Exception -> 0x02ef }
            byte[] r7 = btmsdkobf.C0683dd.m252a(r10, r7, r11, r9)     // Catch:{ Exception -> 0x02ef }
            r9.f360fo = r7     // Catch:{ Exception -> 0x02ef }
        L_0x00d0:
            java.lang.Object r7 = r6.getValue()     // Catch:{ Exception -> 0x02ef }
            btmsdkobf.eb$d r7 = (btmsdkobf.C0759eb.C0769d) r7     // Catch:{ Exception -> 0x02ef }
            long r10 = r7.f794lG     // Catch:{ Exception -> 0x02ef }
            int r7 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r7 > 0) goto L_0x00de
            r10 = 30000(0x7530, double:1.4822E-319)
        L_0x00de:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ef }
            r7.<init>()     // Catch:{ Exception -> 0x02ef }
            java.lang.String r12 = "[shark_timer]对seq: "
            r7.append(r12)     // Catch:{ Exception -> 0x02ef }
            int r12 = r9.f358fm     // Catch:{ Exception -> 0x02ef }
            r7.append(r12)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r12 = "计时(ms): "
            r7.append(r12)     // Catch:{ Exception -> 0x02ef }
            r7.append(r10)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x02ef }
            btmsdkobf.C0849fg.m915v(r2, r7)     // Catch:{ Exception -> 0x02ef }
            btmsdkobf.eh r7 = new btmsdkobf.eh     // Catch:{ Exception -> 0x02ef }
            int r12 = r9.f357dO     // Catch:{ Exception -> 0x02ef }
            r7.m40729init(r12)     // Catch:{ Exception -> 0x02ef }
            android.os.Handler r12 = r1.f799lK     // Catch:{ Exception -> 0x02ef }
            int r13 = r9.f358fm     // Catch:{ Exception -> 0x02ef }
            android.os.Message r7 = android.os.Message.obtain(r12, r13, r7)     // Catch:{ Exception -> 0x02ef }
            android.os.Handler r12 = r1.f799lK     // Catch:{ Exception -> 0x02ef }
            r12.sendMessageDelayed(r7, r10)     // Catch:{ Exception -> 0x02ef }
            java.lang.Object r7 = r6.getValue()     // Catch:{ Exception -> 0x02ef }
            btmsdkobf.eb$d r7 = (btmsdkobf.C0759eb.C0769d) r7     // Catch:{ Exception -> 0x02ef }
            int r7 = r7.f784kD     // Catch:{ Exception -> 0x02ef }
            r7 = r7 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x0120
            r8.add(r9)     // Catch:{ Exception -> 0x02ef }
            goto L_0x0143
        L_0x0120:
            java.lang.Object r7 = r6.getValue()     // Catch:{ Exception -> 0x02ef }
            btmsdkobf.eb$d r7 = (btmsdkobf.C0759eb.C0769d) r7     // Catch:{ Exception -> 0x02ef }
            int r7 = r7.f784kD     // Catch:{ Exception -> 0x02ef }
            r7 = r7 & 512(0x200, float:7.175E-43)
            if (r7 == 0) goto L_0x0130
            r14.add(r9)     // Catch:{ Exception -> 0x02ef }
            goto L_0x0143
        L_0x0130:
            java.lang.Object r7 = r6.getValue()     // Catch:{ Exception -> 0x02ef }
            btmsdkobf.eb$d r7 = (btmsdkobf.C0759eb.C0769d) r7     // Catch:{ Exception -> 0x02ef }
            int r7 = r7.f784kD     // Catch:{ Exception -> 0x02ef }
            r7 = r7 & 1024(0x400, float:1.435E-42)
            if (r7 == 0) goto L_0x0140
            r0.add(r9)     // Catch:{ Exception -> 0x02ef }
            goto L_0x0143
        L_0x0140:
            r15.add(r9)     // Catch:{ Exception -> 0x02ef }
        L_0x0143:
            btmsdkobf.dv r16 = btmsdkobf.C0712dv.m412br()     // Catch:{ Exception -> 0x02ef }
            java.lang.String r17 = "SharkProtocolQueue"
            int r7 = r9.f357dO     // Catch:{ Exception -> 0x02ef }
            int r10 = r9.f358fm     // Catch:{ Exception -> 0x02ef }
            r21 = 0
            r18 = r7
            r19 = r10
            r20 = r9
            r16.mo9316a(r17, r18, r19, r20, r21)     // Catch:{ Exception -> 0x02ef }
            java.lang.Object r7 = r6.getValue()     // Catch:{ Exception -> 0x02ef }
            btmsdkobf.eb$d r7 = (btmsdkobf.C0759eb.C0769d) r7     // Catch:{ Exception -> 0x02ef }
            long r9 = r7.f795lH     // Catch:{ Exception -> 0x02ef }
            int r7 = (r9 > r22 ? 1 : (r9 == r22 ? 0 : -1))
            if (r7 <= 0) goto L_0x0024
            java.lang.Object r6 = r6.getValue()     // Catch:{ Exception -> 0x02ef }
            btmsdkobf.eb$d r6 = (btmsdkobf.C0759eb.C0769d) r6     // Catch:{ Exception -> 0x02ef }
            long r6 = r6.f795lH     // Catch:{ Exception -> 0x02ef }
            r22 = r6
            goto L_0x0024
        L_0x0170:
            java.util.ArrayList<btmsdkobf.eb$d> r3 = r1.f798lJ     // Catch:{ Exception -> 0x02ef }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x02ef }
        L_0x0176:
            boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x02ef }
            if (r4 == 0) goto L_0x027c
            java.lang.Object r4 = r3.next()     // Catch:{ Exception -> 0x02ef }
            btmsdkobf.eb$d r4 = (btmsdkobf.C0759eb.C0769d) r4     // Catch:{ Exception -> 0x02ef }
            boolean r5 = r4.mo9421bJ()     // Catch:{ Exception -> 0x02ef }
            java.lang.String r6 = " pushId: "
            if (r5 == 0) goto L_0x01d5
            int r5 = r4.f788kz     // Catch:{ Exception -> 0x02ef }
            r9 = 1103(0x44f, float:1.546E-42)
            if (r5 != r9) goto L_0x01af
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ef }
            r5.<init>()     // Catch:{ Exception -> 0x02ef }
            java.lang.String r9 = "[time_out]发送push的业务回包超时： mSeqNo: "
            r5.append(r9)     // Catch:{ Exception -> 0x02ef }
            int r9 = r4.f779ir     // Catch:{ Exception -> 0x02ef }
            r5.append(r9)     // Catch:{ Exception -> 0x02ef }
            r5.append(r6)     // Catch:{ Exception -> 0x02ef }
            long r9 = r4.f777fl     // Catch:{ Exception -> 0x02ef }
            r5.append(r9)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x02ef }
        L_0x01ab:
            btmsdkobf.C0849fg.m912e(r2, r4)     // Catch:{ Exception -> 0x02ef }
            goto L_0x0176
        L_0x01af:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ef }
            r5.<init>()     // Catch:{ Exception -> 0x02ef }
            java.lang.String r9 = "[time_out]发送push的自动回包超时： mSeqNo: "
            r5.append(r9)     // Catch:{ Exception -> 0x02ef }
            int r9 = r4.f779ir     // Catch:{ Exception -> 0x02ef }
            r5.append(r9)     // Catch:{ Exception -> 0x02ef }
            r5.append(r6)     // Catch:{ Exception -> 0x02ef }
            long r9 = r4.f777fl     // Catch:{ Exception -> 0x02ef }
            r5.append(r9)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r6 = " mCmdId: "
            r5.append(r6)     // Catch:{ Exception -> 0x02ef }
            int r4 = r4.f788kz     // Catch:{ Exception -> 0x02ef }
            r5.append(r4)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x02ef }
            goto L_0x01ab
        L_0x01d5:
            btmsdkobf.by r5 = new btmsdkobf.by     // Catch:{ Exception -> 0x02ef }
            r5.m40575init()     // Catch:{ Exception -> 0x02ef }
            int r9 = r4.f788kz     // Catch:{ Exception -> 0x02ef }
            r5.f357dO = r9     // Catch:{ Exception -> 0x02ef }
            btmsdkobf.di r9 = btmsdkobf.C0709du.m406bn()     // Catch:{ Exception -> 0x02ef }
            int r9 = r9.mo9293bf()     // Catch:{ Exception -> 0x02ef }
            r5.f358fm = r9     // Catch:{ Exception -> 0x02ef }
            int r9 = r4.f779ir     // Catch:{ Exception -> 0x02ef }
            r5.f359fn = r9     // Catch:{ Exception -> 0x02ef }
            r5.f360fo = r7     // Catch:{ Exception -> 0x02ef }
            int r9 = r4.f778fq     // Catch:{ Exception -> 0x02ef }
            r5.f362fq = r9     // Catch:{ Exception -> 0x02ef }
            int r9 = r4.f792lE     // Catch:{ Exception -> 0x02ef }
            r5.f363fr = r9     // Catch:{ Exception -> 0x02ef }
            btmsdkobf.bx r9 = new btmsdkobf.bx     // Catch:{ Exception -> 0x02ef }
            r9.m40573init()     // Catch:{ Exception -> 0x02ef }
            long r10 = r4.f777fl     // Catch:{ Exception -> 0x02ef }
            r9.f354fl = r10     // Catch:{ Exception -> 0x02ef }
            r5.f364fs = r9     // Catch:{ Exception -> 0x02ef }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ef }
            r9.<init>()     // Catch:{ Exception -> 0x02ef }
            java.lang.String r10 = "resp push, seqNo: "
            r9.append(r10)     // Catch:{ Exception -> 0x02ef }
            int r10 = r5.f358fm     // Catch:{ Exception -> 0x02ef }
            r9.append(r10)     // Catch:{ Exception -> 0x02ef }
            r9.append(r6)     // Catch:{ Exception -> 0x02ef }
            long r10 = r4.f777fl     // Catch:{ Exception -> 0x02ef }
            r9.append(r10)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r6 = r9.toString()     // Catch:{ Exception -> 0x02ef }
            btmsdkobf.C0849fg.m914i(r2, r6)     // Catch:{ Exception -> 0x02ef }
            byte[] r6 = r4.f789lB     // Catch:{ Exception -> 0x0244 }
            if (r6 == 0) goto L_0x0234
            byte[] r6 = r4.f789lB     // Catch:{ Exception -> 0x0244 }
            btmsdkobf.eb r9 = btmsdkobf.C0759eb.this     // Catch:{ Exception -> 0x0244 }
            android.content.Context r9 = r9.mContext     // Catch:{ Exception -> 0x0244 }
            int r10 = r5.f357dO     // Catch:{ Exception -> 0x0244 }
            byte[] r6 = btmsdkobf.C0683dd.m253a(r9, r6, r10, r5)     // Catch:{ Exception -> 0x0244 }
            r5.f360fo = r6     // Catch:{ Exception -> 0x0244 }
            goto L_0x0244
        L_0x0234:
            com.qq.taf.jce.JceStruct r6 = r4.f782kB     // Catch:{ Exception -> 0x0244 }
            btmsdkobf.eb r9 = btmsdkobf.C0759eb.this     // Catch:{ Exception -> 0x0244 }
            android.content.Context r9 = r9.mContext     // Catch:{ Exception -> 0x0244 }
            int r10 = r5.f357dO     // Catch:{ Exception -> 0x0244 }
            byte[] r6 = btmsdkobf.C0683dd.m252a(r9, r6, r10, r5)     // Catch:{ Exception -> 0x0244 }
            r5.f360fo = r6     // Catch:{ Exception -> 0x0244 }
        L_0x0244:
            int r6 = r4.f784kD     // Catch:{ Exception -> 0x02ef }
            r6 = r6 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x024e
            r8.add(r5)     // Catch:{ Exception -> 0x02ef }
            goto L_0x0265
        L_0x024e:
            int r6 = r4.f784kD     // Catch:{ Exception -> 0x02ef }
            r6 = r6 & 512(0x200, float:7.175E-43)
            if (r6 == 0) goto L_0x0258
            r14.add(r5)     // Catch:{ Exception -> 0x02ef }
            goto L_0x0265
        L_0x0258:
            int r4 = r4.f784kD     // Catch:{ Exception -> 0x02ef }
            r4 = r4 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x0262
            r0.add(r5)     // Catch:{ Exception -> 0x02ef }
            goto L_0x0265
        L_0x0262:
            r15.add(r5)     // Catch:{ Exception -> 0x02ef }
        L_0x0265:
            btmsdkobf.dv r16 = btmsdkobf.C0712dv.m412br()     // Catch:{ Exception -> 0x02ef }
            java.lang.String r17 = "SharkProtocolQueue"
            int r4 = r5.f357dO     // Catch:{ Exception -> 0x02ef }
            int r6 = r5.f358fm     // Catch:{ Exception -> 0x02ef }
            r21 = 0
            r18 = r4
            r19 = r6
            r20 = r5
            r16.mo9316a(r17, r18, r19, r20, r21)     // Catch:{ Exception -> 0x02ef }
            goto L_0x0176
        L_0x027c:
            int r3 = r8.size()     // Catch:{ Exception -> 0x02ef }
            if (r3 <= 0) goto L_0x0295
            btmsdkobf.eb r3 = btmsdkobf.C0759eb.this     // Catch:{ Exception -> 0x02ef }
            btmsdkobf.dy r3 = r3.f725hA     // Catch:{ Exception -> 0x02ef }
            r4 = 2048(0x800, float:2.87E-42)
            r7 = 1
            btmsdkobf.eb$e$3 r9 = new btmsdkobf.eb$e$3     // Catch:{ Exception -> 0x02ef }
            r9.m40711init()     // Catch:{ Exception -> 0x02ef }
            r5 = r22
            r3.mo9329a(r4, r5, r7, r8, r9)     // Catch:{ Exception -> 0x02ef }
        L_0x0295:
            int r3 = r14.size()     // Catch:{ Exception -> 0x02ef }
            if (r3 <= 0) goto L_0x02b1
            btmsdkobf.eb r3 = btmsdkobf.C0759eb.this     // Catch:{ Exception -> 0x02ef }
            btmsdkobf.dy r9 = r3.f725hA     // Catch:{ Exception -> 0x02ef }
            r10 = 512(0x200, float:7.175E-43)
            r13 = 1
            btmsdkobf.eb$e$4 r3 = new btmsdkobf.eb$e$4     // Catch:{ Exception -> 0x02ef }
            r3.m40712init()     // Catch:{ Exception -> 0x02ef }
            r11 = r22
            r4 = r15
            r15 = r3
            r9.mo9329a(r10, r11, r13, r14, r15)     // Catch:{ Exception -> 0x02ef }
            goto L_0x02b2
        L_0x02b1:
            r4 = r15
        L_0x02b2:
            int r3 = r0.size()     // Catch:{ Exception -> 0x02ef }
            if (r3 <= 0) goto L_0x02d0
            btmsdkobf.eb r3 = btmsdkobf.C0759eb.this     // Catch:{ Exception -> 0x02ef }
            btmsdkobf.dy r15 = r3.f725hA     // Catch:{ Exception -> 0x02ef }
            r16 = 1024(0x400, float:1.435E-42)
            r19 = 1
            btmsdkobf.eb$e$5 r3 = new btmsdkobf.eb$e$5     // Catch:{ Exception -> 0x02ef }
            r3.m40713init()     // Catch:{ Exception -> 0x02ef }
            r17 = r22
            r20 = r0
            r21 = r3
            r15.mo9329a(r16, r17, r19, r20, r21)     // Catch:{ Exception -> 0x02ef }
        L_0x02d0:
            int r0 = r4.size()     // Catch:{ Exception -> 0x02ef }
            if (r0 <= 0) goto L_0x030e
            btmsdkobf.eb r0 = btmsdkobf.C0759eb.this     // Catch:{ Exception -> 0x02ef }
            btmsdkobf.dy r15 = r0.f725hA     // Catch:{ Exception -> 0x02ef }
            r16 = 0
            r19 = 1
            btmsdkobf.eb$e$6 r0 = new btmsdkobf.eb$e$6     // Catch:{ Exception -> 0x02ef }
            r0.m40714init()     // Catch:{ Exception -> 0x02ef }
            r17 = r22
            r20 = r4
            r21 = r0
            r15.mo9329a(r16, r17, r19, r20, r21)     // Catch:{ Exception -> 0x02ef }
            goto L_0x030e
        L_0x02ef:
            r0 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "run shark task e: "
            r3.append(r4)
            java.lang.String r4 = r0.toString()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            btmsdkobf.C0849fg.m913e(r2, r3, r0)
            r0 = -10001200(0xffffffffff6764d0, float:-3.0757512E38)
            r1.m648B(r0)
        L_0x030e:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0759eb.C0770e.run():void");
        }
    }

    private C0759eb() {
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0076 A[Catch:{ Exception -> 0x00f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0087 A[Catch:{ Exception -> 0x00f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009a A[SYNTHETIC, Splitter:B:25:0x009a] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d9 A[Catch:{ Exception -> 0x00f6 }] */
    /* renamed from: a */
    public void m580a(long r17, btmsdkobf.C0647cg r19, byte[] r20, btmsdkobf.C0801ej<com.p522qq.taf.jce.JceStruct, btmsdkobf.C0696dm, btmsdkobf.C0759eb.C0768c> r21) {
        /*
        r16 = this;
        r9 = r16
        r10 = r17
        r12 = r19
        r13 = r21
        byte[] r0 = r12.f387fo
        r14 = 0
        java.lang.String r15 = "SharkProtocolQueue"
        if (r0 == 0) goto L_0x006d
        T r0 = r13.f895mQ
        btmsdkobf.eb$c r0 = (btmsdkobf.C0759eb.C0768c) r0
        boolean r0 = r0.f776lz
        if (r0 == 0) goto L_0x004a
        android.content.Context r0 = r9.mContext     // Catch:{ Exception -> 0x0026 }
        byte[] r1 = r12.f387fo     // Catch:{ Exception -> 0x0026 }
        int r2 = r12.f390ft     // Catch:{ Exception -> 0x0026 }
        r4 = r20
        byte[] r0 = btmsdkobf.C0683dd.m254a(r0, r4, r1, r2)     // Catch:{ Exception -> 0x0026 }
        r6 = r14
        r14 = r0
        goto L_0x006e
    L_0x0026:
        r0 = move-exception
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r2 = "[shark_push]handleCallbackForPush(), dataForReceive2JceBytes exception: "
    L_0x002e:
        r1.append(r2)
        r1.append(r0)
        java.lang.String r1 = r1.toString()
        btmsdkobf.C0849fg.m910a(r15, r1, r0)
        int r2 = r12.f385fm
        int r5 = r12.f383dO
        r6 = 0
        r7 = 0
        r8 = -1
        r1 = r16
        r3 = r17
        r1.mo9393a(r2, r3, r5, r6, r7, r8)
        goto L_0x006d
    L_0x004a:
        r4 = r20
        F r0 = r13.first
        if (r0 == 0) goto L_0x006d
        android.content.Context r3 = r9.mContext     // Catch:{ Exception -> 0x0064 }
        byte[] r5 = r12.f387fo     // Catch:{ Exception -> 0x0064 }
        F r0 = r13.first     // Catch:{ Exception -> 0x0064 }
        r6 = r0
        com.qq.taf.jce.JceStruct r6 = (com.p522qq.taf.jce.JceStruct) r6     // Catch:{ Exception -> 0x0064 }
        r7 = 1
        int r8 = r12.f390ft     // Catch:{ Exception -> 0x0064 }
        r4 = r20
        com.qq.taf.jce.JceStruct r0 = btmsdkobf.C0683dd.m248a(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0064 }
        r6 = r0
        goto L_0x006e
    L_0x0064:
        r0 = move-exception
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r2 = "[shark_push]handleCallbackForPush(), dataForReceive2JceStruct exception: "
        goto L_0x002e
    L_0x006d:
        r6 = r14
    L_0x006e:
        T r0 = r13.f895mQ     // Catch:{ Exception -> 0x00f6 }
        btmsdkobf.eb$c r0 = (btmsdkobf.C0759eb.C0768c) r0     // Catch:{ Exception -> 0x00f6 }
        boolean r0 = r0.f776lz     // Catch:{ Exception -> 0x00f6 }
        if (r0 == 0) goto L_0x0087
        S r0 = r13.second     // Catch:{ Exception -> 0x00f6 }
        r1 = r0
        btmsdkobf.dn r1 = (btmsdkobf.C0697dn) r1     // Catch:{ Exception -> 0x00f6 }
        int r2 = r12.f385fm     // Catch:{ Exception -> 0x00f6 }
        int r5 = r12.f383dO     // Catch:{ Exception -> 0x00f6 }
        r3 = r17
        r6 = r14
        btmsdkobf.ej r0 = r1.mo9298a(r2, r3, r5, r6)     // Catch:{ Exception -> 0x00f6 }
        goto L_0x0096
    L_0x0087:
        S r0 = r13.second     // Catch:{ Exception -> 0x00f6 }
        r1 = r0
        btmsdkobf.dm r1 = (btmsdkobf.C0696dm) r1     // Catch:{ Exception -> 0x00f6 }
        int r2 = r12.f385fm     // Catch:{ Exception -> 0x00f6 }
        int r5 = r12.f383dO     // Catch:{ Exception -> 0x00f6 }
        r3 = r17
        btmsdkobf.ej r0 = r1.mo9297a(r2, r3, r5, r6)     // Catch:{ Exception -> 0x00f6 }
    L_0x0096:
        java.lang.String r1 = "|cmd|"
        if (r0 == 0) goto L_0x00d9
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f6 }
        r2.<init>()     // Catch:{ Exception -> 0x00f6 }
        java.lang.String r3 = "[shark_push]handleCallbackForPush(), send PushStatus for user: |pushId|"
        r2.append(r3)     // Catch:{ Exception -> 0x00f6 }
        r2.append(r10)     // Catch:{ Exception -> 0x00f6 }
        r2.append(r1)     // Catch:{ Exception -> 0x00f6 }
        S r1 = r0.second     // Catch:{ Exception -> 0x00f6 }
        r2.append(r1)     // Catch:{ Exception -> 0x00f6 }
        java.lang.String r1 = "|JceStruct|"
        r2.append(r1)     // Catch:{ Exception -> 0x00f6 }
        T r1 = r0.f895mQ     // Catch:{ Exception -> 0x00f6 }
        r2.append(r1)     // Catch:{ Exception -> 0x00f6 }
        java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x00f6 }
        btmsdkobf.C0849fg.m914i(r15, r1)     // Catch:{ Exception -> 0x00f6 }
        int r2 = r12.f385fm     // Catch:{ Exception -> 0x00f6 }
        S r1 = r0.second     // Catch:{ Exception -> 0x00f6 }
        java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x00f6 }
        int r5 = r1.intValue()     // Catch:{ Exception -> 0x00f6 }
        T r0 = r0.f895mQ     // Catch:{ Exception -> 0x00f6 }
        r6 = r0
        com.qq.taf.jce.JceStruct r6 = (com.p522qq.taf.jce.JceStruct) r6     // Catch:{ Exception -> 0x00f6 }
        r7 = 0
        r8 = 1
        r1 = r16
        r3 = r17
        r1.mo9393a(r2, r3, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00f6 }
        goto L_0x010b
    L_0x00d9:
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f6 }
        r0.<init>()     // Catch:{ Exception -> 0x00f6 }
        java.lang.String r2 = "[shark_push]handleCallbackForPush(), donot send PushStatus for user: |pushId|"
        r0.append(r2)     // Catch:{ Exception -> 0x00f6 }
        r0.append(r10)     // Catch:{ Exception -> 0x00f6 }
        r0.append(r1)     // Catch:{ Exception -> 0x00f6 }
        int r1 = r12.f383dO     // Catch:{ Exception -> 0x00f6 }
        r0.append(r1)     // Catch:{ Exception -> 0x00f6 }
        java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00f6 }
        btmsdkobf.C0849fg.m914i(r15, r0)     // Catch:{ Exception -> 0x00f6 }
        goto L_0x010b
    L_0x00f6:
        r0 = move-exception
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r2 = "[shark_push]handleCallbackForPush(), callback exception: "
        r1.append(r2)
        r1.append(r0)
        java.lang.String r1 = r1.toString()
        btmsdkobf.C0849fg.m910a(r15, r1, r0)
    L_0x010b:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0759eb.m580a(long, btmsdkobf.cg, byte[], btmsdkobf.ej):void");
    }

    /* renamed from: a */
    public static boolean m584a(C0647cg cgVar) {
        boolean z = false;
        if (cgVar == null) {
            return false;
        }
        if (cgVar.f386fn != 0) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m587b(int i, C0707b bVar) {
        ArrayList<C0733a> arrayList = new ArrayList<>();
        synchronized (this.f750lg) {
            if (this.f750lg.size() > 0) {
                arrayList.addAll(this.f750lg);
            }
        }
        if (arrayList.size() > 0) {
            for (C0733a a : arrayList) {
                a.mo9348a(i, bVar);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0074 A[Catch:{ Exception -> 0x00a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0083 A[Catch:{ Exception -> 0x00a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0093 A[Catch:{ Exception -> 0x00a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    public void m588b(long r10, btmsdkobf.C0647cg r12, byte[] r13, btmsdkobf.C0801ej<com.p522qq.taf.jce.JceStruct, btmsdkobf.C0696dm, btmsdkobf.C0759eb.C0768c> r14) {
        /*
        r9 = this;
        byte[] r13 = r12.f387fo
        r0 = 0
        java.lang.String r1 = "SharkProtocolQueue"
        if (r13 == 0) goto L_0x006a
        T r13 = r14.f895mQ
        btmsdkobf.eb$c r13 = (btmsdkobf.C0759eb.C0768c) r13
        boolean r13 = r13.f776lz
        if (r13 == 0) goto L_0x003e
        android.content.Context r13 = r9.mContext     // Catch:{ Exception -> 0x0028 }
        btmsdkobf.dy r2 = r9.f725hA     // Catch:{ Exception -> 0x0028 }
        btmsdkobf.ds$b r2 = r2.mo9333ac()     // Catch:{ Exception -> 0x0028 }
        java.lang.String r2 = r2.f551im     // Catch:{ Exception -> 0x0028 }
        byte[] r2 = r2.getBytes()     // Catch:{ Exception -> 0x0028 }
        byte[] r3 = r12.f387fo     // Catch:{ Exception -> 0x0028 }
        int r4 = r12.f390ft     // Catch:{ Exception -> 0x0028 }
        byte[] r13 = btmsdkobf.C0683dd.m254a(r13, r2, r3, r4)     // Catch:{ Exception -> 0x0028 }
        r7 = r13
        r8 = r0
        goto L_0x006c
    L_0x0028:
        r13 = move-exception
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        java.lang.String r3 = "[shark_push]handleCallbackForGift(), dataForReceive2JceBytes exception: "
    L_0x0030:
        r2.append(r3)
        r2.append(r13)
        java.lang.String r2 = r2.toString()
        btmsdkobf.C0849fg.m910a(r1, r2, r13)
        goto L_0x006a
    L_0x003e:
        F r13 = r14.first
        if (r13 == 0) goto L_0x006a
        android.content.Context r2 = r9.mContext     // Catch:{ Exception -> 0x0061 }
        btmsdkobf.dy r13 = r9.f725hA     // Catch:{ Exception -> 0x0061 }
        btmsdkobf.ds$b r13 = r13.mo9333ac()     // Catch:{ Exception -> 0x0061 }
        java.lang.String r13 = r13.f551im     // Catch:{ Exception -> 0x0061 }
        byte[] r3 = r13.getBytes()     // Catch:{ Exception -> 0x0061 }
        byte[] r4 = r12.f387fo     // Catch:{ Exception -> 0x0061 }
        F r13 = r14.first     // Catch:{ Exception -> 0x0061 }
        r5 = r13
        com.qq.taf.jce.JceStruct r5 = (com.p522qq.taf.jce.JceStruct) r5     // Catch:{ Exception -> 0x0061 }
        r6 = 1
        int r7 = r12.f390ft     // Catch:{ Exception -> 0x0061 }
        com.qq.taf.jce.JceStruct r13 = btmsdkobf.C0683dd.m248a(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0061 }
        r8 = r13
        r7 = r0
        goto L_0x006c
    L_0x0061:
        r13 = move-exception
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        java.lang.String r3 = "[shark_push]handleCallbackForGift(), dataForReceive2JceStruct exception: "
        goto L_0x0030
    L_0x006a:
        r7 = r0
        r8 = r7
    L_0x006c:
        T r13 = r14.f895mQ     // Catch:{ Exception -> 0x00a5 }
        btmsdkobf.eb$c r13 = (btmsdkobf.C0759eb.C0768c) r13     // Catch:{ Exception -> 0x00a5 }
        boolean r13 = r13.f776lz     // Catch:{ Exception -> 0x00a5 }
        if (r13 == 0) goto L_0x0083
        S r13 = r14.second     // Catch:{ Exception -> 0x00a5 }
        r2 = r13
        btmsdkobf.dn r2 = (btmsdkobf.C0697dn) r2     // Catch:{ Exception -> 0x00a5 }
        int r3 = r12.f385fm     // Catch:{ Exception -> 0x00a5 }
        int r6 = r12.f383dO     // Catch:{ Exception -> 0x00a5 }
        r4 = r10
        btmsdkobf.ej r10 = r2.mo9298a(r3, r4, r6, r7)     // Catch:{ Exception -> 0x00a5 }
        goto L_0x0091
    L_0x0083:
        S r13 = r14.second     // Catch:{ Exception -> 0x00a5 }
        r3 = r13
        btmsdkobf.dm r3 = (btmsdkobf.C0696dm) r3     // Catch:{ Exception -> 0x00a5 }
        int r4 = r12.f385fm     // Catch:{ Exception -> 0x00a5 }
        int r7 = r12.f383dO     // Catch:{ Exception -> 0x00a5 }
        r5 = r10
        btmsdkobf.ej r10 = r3.mo9297a(r4, r5, r7, r8)     // Catch:{ Exception -> 0x00a5 }
    L_0x0091:
        if (r10 == 0) goto L_0x00ba
        int r11 = r12.f385fm     // Catch:{ Exception -> 0x00a5 }
        S r12 = r10.second     // Catch:{ Exception -> 0x00a5 }
        java.lang.Integer r12 = (java.lang.Integer) r12     // Catch:{ Exception -> 0x00a5 }
        int r12 = r12.intValue()     // Catch:{ Exception -> 0x00a5 }
        T r10 = r10.f895mQ     // Catch:{ Exception -> 0x00a5 }
        com.qq.taf.jce.JceStruct r10 = (com.p522qq.taf.jce.JceStruct) r10     // Catch:{ Exception -> 0x00a5 }
        r9.mo9392a(r11, r12, r10)     // Catch:{ Exception -> 0x00a5 }
        goto L_0x00ba
    L_0x00a5:
        r10 = move-exception
        java.lang.StringBuilder r11 = new java.lang.StringBuilder
        r11.<init>()
        java.lang.String r12 = "[shark_push]handleCallbackForGift(), callback exception: "
        r11.append(r12)
        r11.append(r10)
        java.lang.String r11 = r11.toString()
        btmsdkobf.C0849fg.m910a(r1, r11, r10)
    L_0x00ba:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0759eb.m588b(long, btmsdkobf.cg, byte[], btmsdkobf.ej):void");
    }

    /* renamed from: b */
    public static boolean m590b(C0647cg cgVar) {
        return (cgVar == null || cgVar.f386fn != 0 || cgVar.f384fD == null || cgVar.f384fD.f380fl == 0) ? false : true;
    }

    /* renamed from: bT */
    public static C0759eb m591bT() {
        if (f721lb == null) {
            synchronized (C0759eb.class) {
                if (f721lb == null) {
                    f721lb = new C0759eb();
                }
            }
        }
        return f721lb;
    }

    /* renamed from: c */
    public static boolean m592c(C0647cg cgVar) {
        boolean z = false;
        if (cgVar == null) {
            return false;
        }
        if (!m584a(cgVar) && !m590b(cgVar)) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m594d(int i, String str) {
        ArrayList<C0691dh> arrayList = new ArrayList<>();
        synchronized (this.f748le) {
            if (this.f748le.size() > 0) {
                arrayList.addAll(this.f748le);
                this.f748le.clear();
            }
        }
        synchronized (this.f749lf) {
            if (this.f749lf.size() > 0) {
                arrayList.addAll(this.f749lf);
            }
        }
        if (arrayList.size() > 0) {
            for (C0691dh b : arrayList) {
                b.mo9292b(i, str);
            }
        }
    }

    /* renamed from: a */
    public long mo9357a(boolean z, int i, C0647cg cgVar) {
        C0801ej ejVar;
        List<C0767b> list;
        boolean z2 = z;
        C0647cg cgVar2 = cgVar;
        if (cgVar2 == null || !m590b(cgVar)) {
            return -1;
        }
        long j = 0;
        if (cgVar2.f384fD != null) {
            j = cgVar2.f384fD.f380fl;
        }
        long j2 = j;
        StringBuilder sb = new StringBuilder();
        sb.append("[shark_push]onPush(), ECmd: ");
        sb.append(cgVar2.f383dO);
        sb.append(" seqNo: ");
        sb.append(cgVar2.f385fm);
        sb.append(" pushId: ");
        sb.append(j2);
        sb.append(" isTcpChannel: ");
        sb.append(z2);
        C0849fg.m911d("SharkProtocolQueue", sb.toString());
        mo9395a(j2, cgVar2.f383dO, i, cgVar2.f385fm, (int) ESharkCode.ERR_SHARK_TCP_PUSH_RET_CODE_SHARK_GOT_IT);
        if (cgVar2.f388fq != 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[shark_push]onPush(), push with error, drop it, ECmd: ");
            sb2.append(cgVar2.f383dO);
            sb2.append(" seqNo: ");
            sb2.append(cgVar2.f385fm);
            sb2.append(" pushId: ");
            sb2.append(j2);
            sb2.append(" isTcpChannel: ");
            sb2.append(z2);
            sb2.append(" retCode: ");
            sb2.append(cgVar2.f388fq);
            C0849fg.m912e("SharkProtocolQueue", sb2.toString());
            return -1;
        } else if (this.f730kL.mo9490b(Long.valueOf(j2))) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("[shark_push]onPush(), push duplicate, drop it, ECmd: ");
            sb3.append(cgVar2.f383dO);
            sb3.append(" seqNo: ");
            sb3.append(cgVar2.f385fm);
            sb3.append(" pushId: ");
            sb3.append(j2);
            C0849fg.m916w("SharkProtocolQueue", sb3.toString());
            return -1;
        } else {
            this.f730kL.push(Long.valueOf(j2));
            synchronized (this.f745kk) {
                ejVar = (C0801ej) this.f745kk.get(Integer.valueOf(cgVar2.f383dO));
            }
            if (ejVar == null) {
                List<C0767b> list2 = this.f728kJ;
                synchronized (list2) {
                    try {
                        List<C0767b> list3 = this.f728kJ;
                        r1 = r1;
                        C0767b bVar = r1;
                        list = list2;
                        try {
                            C0767b bVar2 = new C0767b(0, System.currentTimeMillis(), j2, cgVar, this.f725hA.mo9333ac().f551im.getBytes());
                            list3.add(bVar);
                            int size = this.f728kJ.size();
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("[shark_push]onPush(), nobody listen to it, ECmd: ");
                            sb4.append(cgVar2.f383dO);
                            sb4.append(" seqNo: ");
                            sb4.append(cgVar2.f385fm);
                            sb4.append(" pushId: ");
                            sb4.append(j2);
                            sb4.append(" cache for ");
                            sb4.append(OtherError.CONTAINER_INVISIBLE_ERROR);
                            sb4.append("s pushSize: ");
                            sb4.append(size);
                            C0849fg.m916w("SharkProtocolQueue", sb4.toString());
                            this.f727js.removeMessages(3);
                            if (size >= 20) {
                                this.f727js.sendEmptyMessageDelayed(3, 2000);
                            }
                            this.f727js.sendEmptyMessageDelayed(3, 600000);
                            return -1;
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        list = list2;
                        throw th;
                    }
                }
            } else {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[shark_push]onPush(), someone listen to it, callback now, ECmd: ");
                sb5.append(cgVar2.f383dO);
                sb5.append(" seqNo: ");
                sb5.append(cgVar2.f385fm);
                sb5.append(" pushId: ");
                sb5.append(j2);
                C0849fg.m911d("SharkProtocolQueue", sb5.toString());
                m580a(j2, cgVar, this.f725hA.mo9333ac().f551im.getBytes(), ejVar);
                if (ejVar.f895mQ != null) {
                    return ((C0768c) ejVar.f895mQ).f775lA;
                }
                return -1;
            }
        }
    }

    /* renamed from: a */
    public WeakReference<C0715dw> mo9391a(int i, int i2, int i3, long j, long j2, int i4, JceStruct jceStruct, byte[] bArr, JceStruct jceStruct2, int i5, C0693dj djVar, C0694dk dkVar, long j3, long j4) {
        int i6 = i3;
        long j5 = j3;
        StringBuilder sb = new StringBuilder();
        sb.append("sendShark() cmdId: ");
        sb.append(i4);
        sb.append(" pushSeqNo: ");
        sb.append(i6);
        C0849fg.m911d("SharkProtocolQueue", sb.toString());
        if (i6 > 0) {
            return mo9393a(i3, j, i4, jceStruct, bArr, 1);
        }
        long j6 = j5;
        C0769d dVar = new C0769d(i, i2, j2, i4, jceStruct, bArr, jceStruct2, i5, djVar, dkVar);
        dVar.f779ir = C0709du.m406bn().mo9293bf();
        dVar.f794lG = j6;
        dVar.f795lH = j4;
        long j7 = j6;
        synchronized (this.f729kK) {
            this.f729kK.add(dVar);
        }
        C0712dv.m412br().mo9315a(dVar.f779ir, j7, null);
        if (C0716dx.f584iN) {
            this.f727js.sendEmptyMessage(1);
        }
        return new WeakReference<>(dVar.f793lF);
    }

    /* renamed from: a */
    public WeakReference<C0715dw> mo9392a(int i, final int i2, JceStruct jceStruct) {
        StringBuilder sb = new StringBuilder();
        sb.append("[shark_push]sendGiftResp(): giftSeqNo: ");
        sb.append(i);
        String str = " acmdId: ";
        sb.append(str);
        sb.append(i2);
        String str2 = " respStruct: ";
        sb.append(str2);
        sb.append(jceStruct);
        String str3 = "SharkProtocolQueue";
        C0849fg.m914i(str3, sb.toString());
        if (i2 == 156) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[ip_list]sendGiftResp(): giftSeqNo: ");
            sb2.append(i);
            sb2.append(str);
            sb2.append(i2);
            sb2.append(str2);
            sb2.append(jceStruct);
            C0849fg.m915v(str3, sb2.toString());
        }
        return C0716dx.m434bx().mo9429a(i2, jceStruct, null, 0, new C0693dj() {
            /* renamed from: a */
            public void mo9159a(int i, int i2, int i3, int i4, JceStruct jceStruct) {
                StringBuilder sb = new StringBuilder();
                sb.append("[shark_push]sendGiftResp()-onFinish() seqNo: ");
                sb.append(i);
                String str = " cmdId: ";
                sb.append(str);
                sb.append(i2);
                String str2 = " retCode: ";
                sb.append(str2);
                sb.append(i3);
                String str3 = " dataRetCode: ";
                sb.append(str3);
                sb.append(i4);
                String str4 = "SharkProtocolQueue";
                C0849fg.m914i(str4, sb.toString());
                if (i2 == 156) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("[ip_list]sendGiftResp()-onFinish() seqNo: ");
                    sb2.append(i);
                    sb2.append(str);
                    sb2.append(i2);
                    sb2.append(str2);
                    sb2.append(i3);
                    sb2.append(str3);
                    sb2.append(i4);
                    sb2.append(" resp: ");
                    sb2.append(jceStruct);
                    C0849fg.m915v(str4, sb2.toString());
                }
            }
        });
    }

    /* renamed from: a */
    public WeakReference<C0715dw> mo9393a(int i, long j, int i2, JceStruct jceStruct, byte[] bArr, int i3) {
        return mo9394a(i, j, i2, jceStruct, bArr, i3, 0);
    }

    /* renamed from: a */
    public WeakReference<C0715dw> mo9394a(int i, long j, int i2, JceStruct jceStruct, byte[] bArr, int i3, int i4) {
        int i5 = i;
        long j2 = j;
        int i6 = i2;
        byte[] bArr2 = bArr;
        int i7 = i3;
        int i8 = i4;
        StringBuilder sb = new StringBuilder();
        sb.append("[shark_push]sendPushResp(), pushSeqNo: ");
        sb.append(i5);
        sb.append(" pushId: ");
        sb.append(j2);
        sb.append(" cmdId: ");
        sb.append(i6);
        sb.append(" result: ");
        sb.append(i7);
        sb.append(" retCode: ");
        sb.append(i8);
        C0849fg.m911d("SharkProtocolQueue", sb.toString());
        C0628bq bqVar = new C0628bq();
        bqVar.f274dO = i6;
        bqVar.status = i7;
        if (bArr2 != null && bArr2.length > 0) {
            bqVar.f275dP = bArr2;
        } else if (jceStruct != null) {
            bqVar.f275dP = C0699dp.m381b(jceStruct);
        }
        C0769d dVar = r1;
        C0769d dVar2 = new C0769d(0, 0, -1, 1103, jceStruct, C0683dd.m256a(bqVar), null, 1073741824, null, null);
        C0769d dVar3 = dVar;
        dVar3.f779ir = i5;
        dVar3.f777fl = j;
        dVar3.f778fq = i8;
        synchronized (this.f729kK) {
            this.f729kK.add(dVar3);
        }
        if (C0716dx.f584iN) {
            this.f727js.sendEmptyMessage(1);
        }
        return new WeakReference<>(dVar3.f793lF);
    }

    /* renamed from: a */
    public void mo9395a(long j, int i, int i2, int i3, int i4) {
        long j2 = j;
        int i5 = i3;
        int i6 = i4;
        StringBuilder sb = new StringBuilder();
        sb.append("autoReplyPush()  pushId: ");
        sb.append(j2);
        sb.append(" cmdId: ");
        int i7 = i;
        sb.append(i7);
        sb.append(" serverSharkSeqNo: ");
        sb.append(i2);
        sb.append(" serverSashimiSeqNo: ");
        sb.append(i5);
        sb.append(" errCode: ");
        sb.append(i6);
        C0849fg.m911d("SharkProtocolQueue", sb.toString());
        C0769d dVar = r1;
        C0769d dVar2 = new C0769d(Process.myPid(), 0, 0, i7, null, new byte[0], null, 1073741824, null, null);
        C0769d dVar3 = dVar;
        dVar3.f778fq = i6;
        dVar3.f779ir = i5;
        dVar3.f777fl = j;
        synchronized (this.f729kK) {
            this.f729kK.add(dVar3);
        }
        if (C0716dx.f584iN) {
            this.f727js.sendEmptyMessage(1);
        }
    }

    /* renamed from: a */
    public void mo9359a(long j, int i, JceStruct jceStruct, int i2, C0696dm dmVar, boolean z) {
        if (dmVar != null) {
            synchronized (this.f745kk) {
                this.f745kk.put(Integer.valueOf(i), new C0801ej(jceStruct, dmVar, new C0768c(z, j)));
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[shark_push]registerSharkPush(), for cmd: ");
            sb.append(i);
            C0849fg.m911d("SharkProtocolQueue", sb.toString());
            if (C0716dx.f584iN) {
                this.f727js.obtainMessage(5, i, 0).sendToTarget();
            }
        }
    }

    /* renamed from: a */
    public void mo9360a(C0691dh dhVar) {
        if (dhVar != null) {
            synchronized (this.f749lf) {
                if (!this.f749lf.contains(dhVar)) {
                    this.f749lf.add(dhVar);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo9396a(final C0691dh dhVar, boolean z) {
        if (dhVar != null) {
            final String guid = getGuid();
            if (TextUtils.isEmpty(guid)) {
                this.f743kY = true;
                synchronized (this.f748le) {
                    if (!this.f748le.contains(dhVar)) {
                        this.f748le.add(dhVar);
                    }
                }
                if (z) {
                    synchronized (this) {
                        if (f722lc < f723ld.length) {
                            this.f727js.removeMessages(7);
                            this.f727js.sendEmptyMessageDelayed(7, f723ld[f722lc]);
                            f722lc++;
                        }
                    }
                }
            } else {
                C0845fd.m898cN().addUrgentTask(new Runnable() {
                    public void run() {
                        dhVar.mo9292b(0, guid);
                    }
                }, "shark callback: guid got");
            }
        }
    }

    /* renamed from: a */
    public void mo9361a(C0733a aVar) {
        if (aVar != null) {
            synchronized (this.f750lg) {
                if (!this.f750lg.contains(aVar)) {
                    this.f750lg.add(aVar);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo9397a(C0806el elVar, long j) {
        if (elVar != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("[shark_vip] setVipRule(): ");
            sb.append(elVar);
            sb.append(", valid time(ms): ");
            sb.append(j);
            C0849fg.m914i("SharkProtocolQueue", sb.toString());
            this.f731kM = elVar;
            this.f727js.removeMessages(6);
            if (j > 0) {
                this.f727js.sendEmptyMessageDelayed(6, j);
            }
        }
    }

    /* renamed from: an */
    public void mo9398an() {
        C0849fg.m914i("SharkProtocolQueue", "[shark_init]initAsync()");
        C0718dy dyVar = new C0718dy(C0652cl.m85D(), this.f724gZ, this, this, this, C0716dx.m431bu(), C0716dx.m432bv());
        this.f725hA = dyVar;
        this.f726jh = Executors.newSingleThreadExecutor();
        C0712dv.m412br().mo9322b(this.f724gZ);
        this.f727js.sendEmptyMessage(2);
    }

    /* renamed from: ap */
    public void mo9399ap() {
        if (C0716dx.f584iN) {
            this.f725hA.mo9341bI();
        } else {
            this.f740kV = true;
        }
    }

    /* renamed from: b */
    public long mo9358b(boolean z, int i, C0647cg cgVar) {
        C0801ej ejVar;
        int size;
        if (cgVar == null || !m592c(cgVar)) {
            return -1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[shark_push]onGotGift(), ECmd: ");
        sb.append(cgVar.f383dO);
        sb.append(" seqNo: ");
        sb.append(cgVar.f385fm);
        sb.append(" pushId: ");
        sb.append(0);
        sb.append(" isTcpChannel: ");
        sb.append(z);
        C0849fg.m911d("SharkProtocolQueue", sb.toString());
        if (cgVar.f388fq != 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[shark_push]onGotGift(), gift with error, drop it, ECmd: ");
            sb2.append(cgVar.f383dO);
            sb2.append(" seqNo: ");
            sb2.append(cgVar.f385fm);
            sb2.append(" pushId: ");
            sb2.append(0);
            sb2.append(" isTcpChannel: ");
            sb2.append(z);
            sb2.append(" retCode: ");
            sb2.append(cgVar.f388fq);
            C0849fg.m912e("SharkProtocolQueue", sb2.toString());
            return -1;
        }
        synchronized (this.f745kk) {
            ejVar = (C0801ej) this.f745kk.get(Integer.valueOf(cgVar.f383dO));
        }
        if (ejVar == null) {
            synchronized (this.f728kJ) {
                List<C0767b> list = this.f728kJ;
                C0767b bVar = new C0767b(1, System.currentTimeMillis(), 0, cgVar, this.f725hA.mo9333ac().f551im.getBytes());
                list.add(bVar);
                size = this.f728kJ.size();
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("[shark_push]onGotGift(), nobody listen to it, ECmd: ");
            sb3.append(cgVar.f383dO);
            sb3.append(" seqNo: ");
            sb3.append(cgVar.f385fm);
            sb3.append(" cache for ");
            sb3.append(OtherError.CONTAINER_INVISIBLE_ERROR);
            sb3.append("s pushSize: ");
            sb3.append(size);
            C0849fg.m916w("SharkProtocolQueue", sb3.toString());
            this.f727js.removeMessages(3);
            if (size >= 20) {
                this.f727js.sendEmptyMessageDelayed(3, 2000);
            }
            this.f727js.sendEmptyMessageDelayed(3, 600000);
            return -1;
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("[shark_push]onGotGift(), someone listen to it, callback now, ECmd: ");
        sb4.append(cgVar.f383dO);
        sb4.append(" seqNo: ");
        sb4.append(cgVar.f385fm);
        C0849fg.m911d("SharkProtocolQueue", sb4.toString());
        m588b(0, cgVar, this.f725hA.mo9333ac().f551im.getBytes(), ejVar);
        if (ejVar.f895mQ != null) {
            return ((C0768c) ejVar.f895mQ).f775lA;
        }
        return -1;
    }

    /* renamed from: b */
    public void mo9362b(C0691dh dhVar) {
        if (dhVar != null) {
            synchronized (this.f749lf) {
                if (this.f749lf.contains(dhVar)) {
                    this.f749lf.remove(dhVar);
                }
            }
        }
    }

    /* renamed from: b */
    public void mo9363b(C0733a aVar) {
        if (aVar != null) {
            synchronized (this.f750lg) {
                if (this.f750lg.contains(aVar)) {
                    this.f750lg.remove(aVar);
                }
            }
        }
    }

    /* renamed from: bB */
    public void mo9400bB() {
        if (C0716dx.f584iN) {
            this.f725hA.mo9335bB();
        } else {
            this.f735kQ = true;
        }
    }

    /* renamed from: bF */
    public C0695dl mo9401bF() {
        return this.f724gZ;
    }

    /* renamed from: bG */
    public void mo9402bG() {
        if (C0716dx.f584iN) {
            this.f725hA.mo9339bG();
        } else {
            this.f738kT = true;
        }
    }

    /* renamed from: bH */
    public void mo9403bH() {
        if (C0716dx.f584iN) {
            this.f725hA.mo9340bH();
        } else {
            this.f739kU = true;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: bS */
    public void mo9404bS() {
        if (C0716dx.f584iN) {
            this.f727js.removeMessages(4);
            this.f727js.sendEmptyMessage(4);
            return;
        }
        this.f742kX = true;
    }

    /* renamed from: bU */
    public void mo9405bU() {
        if (C0716dx.f584iN) {
            this.f725hA.mo9343e(1000);
        } else {
            this.f734kP = true;
        }
    }

    /* renamed from: bV */
    public void mo9406bV() {
        if (C0716dx.m428ar()) {
            if (C0716dx.f584iN) {
                this.f725hA.mo9336bD().mo9472bV();
            } else {
                this.f737kS = true;
            }
        }
    }

    /* renamed from: bW */
    public void mo9407bW() {
        if (C0716dx.m428ar()) {
            if (C0716dx.f584iN) {
                this.f725hA.mo9336bD().mo9473bW();
            } else {
                this.f744kZ = true;
            }
        }
    }

    /* renamed from: bX */
    public void mo9408bX() {
        if (C0716dx.m428ar()) {
            if (C0716dx.f584iN) {
                this.f725hA.mo9336bD().mo9474bX();
            } else {
                this.f747la = true;
            }
        }
    }

    /* renamed from: c */
    public void mo9409c(int i, int i2, int i3) {
        if (C0716dx.f584iN) {
            this.f725hA.mo9342c(i, i2, i3);
            return;
        }
        if (this.f741kW == null) {
            this.f741kW = new LinkedList<>();
        }
        this.f741kW.add(new C0700dq(i, i2, i3));
    }

    /* renamed from: c */
    public void mo9410c(C0695dl dlVar) {
        C0849fg.m911d("SharkProtocolQueue", "[shark_init]initSync()");
        this.f724gZ = dlVar;
        synchronized (this) {
            if (this.f751lh == null) {
                this.f751lh = new C0765a();
                this.f751lh.m646l(this.mContext);
                C0849fg.m911d("SharkProtocolQueue", "[shark_init][cu_guid][rsa_key] initSync(), register guid & rsakey event");
            }
        }
    }

    /* renamed from: e */
    public C0696dm mo9411e(int i, int i2) {
        C0696dm dmVar;
        synchronized (this.f745kk) {
            dmVar = this.f745kk.containsKey(Integer.valueOf(i)) ? (C0696dm) ((C0801ej) this.f745kk.remove(Integer.valueOf(i))).second : null;
        }
        return dmVar;
    }

    public String getGuid() {
        C0718dy dyVar = this.f725hA;
        return dyVar == null ? "" : dyVar.getGuid();
    }

    public void onReady() {
        if (C0716dx.f584iN) {
            C0718dy dyVar = this.f725hA;
            if (dyVar != null) {
                dyVar.onReady();
            }
        } else {
            this.f736kR = true;
        }
    }

    /* renamed from: y */
    public void mo9414y(boolean z) {
        if (z) {
            if (C0716dx.f584iN) {
                this.f725hA.mo9332aT();
            } else {
                this.f733kO = true;
            }
        } else if (C0716dx.f584iN) {
            this.f725hA.mo9337bE();
        } else {
            this.f732kN = true;
        }
    }
}
