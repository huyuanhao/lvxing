package btmsdkobf;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Pair;
import btmsdkobf.C0709du.C0710a;
import com.p522qq.taf.jce.JceStruct;
import com.tencent.p605ep.common.adapt.iservice.net.ESharkCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: btmsdkobf.ea */
public final class C0749ea {
    /* renamed from: km */
    private static C0749ea f674km;
    /* access modifiers changed from: private */
    /* renamed from: hN */
    public C0695dl f675hN;
    /* access modifiers changed from: private|final */
    /* renamed from: hO */
    public final Object f676hO = new Object();
    /* access modifiers changed from: private */
    /* renamed from: js */
    public Handler f677js = new Handler(C0716dx.getLooper()) {
        public void handleMessage(Message message) {
            if (message.what == 1) {
                try {
                    C0749ea.this.f677js.removeMessages(1);
                    C0758b bVar = new C0758b();
                    synchronized (C0749ea.this.f676hO) {
                        Iterator it = C0749ea.this.f682ki.iterator();
                        while (it.hasNext()) {
                            C0757a aVar = (C0757a) it.next();
                            bVar.mo9388a(Integer.valueOf(aVar.f715kw), aVar);
                            if ((aVar.f708kD & 1073741824) == 0) {
                                C0749ea.this.f683kj.put(Integer.valueOf(aVar.f715kw), aVar);
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append(C0749ea.this.f680kg);
                            sb.append(" sendShark() MSG_SEND_PROXY_TASK task.mIpcSeqNo: ");
                            sb.append(aVar.f715kw);
                            C0849fg.m911d("SharkProcessProxy", sb.toString());
                        }
                        C0749ea.this.f682ki.clear();
                    }
                    C0749ea.this.f681kh.submit(bVar);
                } catch (Exception e) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("exception: ");
                    sb2.append(e);
                    C0849fg.m912e("SharkProcessProxy", sb2.toString());
                }
            }
        }
    };
    /* access modifiers changed from: private */
    /* renamed from: ju */
    public Handler f678ju = new Handler(C0716dx.getLooper()) {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 0) {
                C0749ea.this.m559a((C0757a) message.obj);
            }
        }
    };
    /* renamed from: kf */
    private C0710a f679kf;
    /* access modifiers changed from: private */
    /* renamed from: kg */
    public int f680kg = Process.myPid();
    /* access modifiers changed from: private */
    /* renamed from: kh */
    public ExecutorService f681kh;
    /* access modifiers changed from: private */
    /* renamed from: ki */
    public ArrayList<C0757a> f682ki = new ArrayList<>();
    /* access modifiers changed from: private */
    /* renamed from: kj */
    public TreeMap<Integer, C0757a> f683kj = new TreeMap<>();
    /* renamed from: kk */
    private TreeMap<Integer, Pair<JceStruct, C0696dm>> f684kk = new TreeMap<>();
    /* renamed from: kl */
    private Handler f685kl = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (message.what == 11) {
                Object[] objArr = (Object[]) message.obj;
                C0757a aVar = (C0757a) objArr[0];
                if (aVar.f709kE != null) {
                    aVar.f709kE.mo9159a(((Integer) objArr[1]).intValue(), aVar.f718kz, ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue(), aVar.f707kC);
                }
            }
        }
    };

    /* renamed from: btmsdkobf.ea$a */
    public class C0757a {
        /* renamed from: kA */
        public long f705kA;
        /* renamed from: kB */
        public JceStruct f706kB;
        /* renamed from: kC */
        public JceStruct f707kC;
        /* renamed from: kD */
        public int f708kD;
        /* renamed from: kE */
        public C0693dj f709kE;
        /* renamed from: kF */
        public long f710kF = -1;
        /* renamed from: kG */
        public long f711kG = -1;
        /* renamed from: kH */
        public long f712kH = System.currentTimeMillis();
        /* renamed from: kg */
        public int f713kg;
        /* renamed from: kn */
        final /* synthetic */ C0749ea f714kn;
        /* renamed from: kw */
        public int f715kw;
        /* renamed from: kx */
        public int f716kx;
        /* renamed from: ky */
        public long f717ky;
        /* renamed from: kz */
        public int f718kz;

        C0757a(C0749ea eaVar, int i, int i2, int i3, long j, long j2, int i4, JceStruct jceStruct, JceStruct jceStruct2, int i5, C0693dj djVar, long j3, long j4) {
            this.f714kn = eaVar;
            this.f713kg = i;
            this.f715kw = i2;
            this.f716kx = i3;
            this.f717ky = j;
            this.f718kz = i4;
            this.f705kA = j2;
            this.f706kB = jceStruct;
            this.f707kC = jceStruct2;
            this.f708kD = i5;
            this.f709kE = djVar;
            this.f710kF = j3;
            this.f711kG = j4;
        }

        /* renamed from: bJ */
        public boolean mo9387bJ() {
            long abs = Math.abs(System.currentTimeMillis() - this.f712kH);
            long j = this.f710kF;
            if (j <= 0) {
                j = 35000;
            }
            boolean z = abs >= j;
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append("cmdId|");
                sb.append(this.f718kz);
                sb.append("|mIpcSeqNo|");
                sb.append(this.f715kw);
                sb.append("|mPushSeqNo|");
                sb.append(this.f716kx);
                sb.append("|mPushId|");
                sb.append(this.f717ky);
                sb.append("|mCallerIdent|");
                sb.append(this.f705kA);
                sb.append("|mTimeout|");
                sb.append(this.f710kF);
                sb.append("|time(s)|");
                sb.append(abs / 1000);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[ocean][time_out]SharkProcessProxy.SharkProxyTask.isTimeOut(), ");
                sb2.append(sb.toString());
                C0849fg.m912e(ESharkCode.SHARK_OCEAN, sb2.toString());
            }
            return z;
        }
    }

    /* renamed from: btmsdkobf.ea$b */
    private class C0758b implements Runnable {
        /* renamed from: kI */
        private TreeMap<Integer, C0757a> f719kI;

        private C0758b() {
            this.f719kI = new TreeMap<>();
        }

        /* renamed from: a */
        public void mo9388a(Integer num, C0757a aVar) {
            this.f719kI.put(num, aVar);
        }

        /* renamed from: bR */
        public Set<Entry<Integer, C0757a>> mo9389bR() {
            TreeMap treeMap;
            synchronized (this.f719kI) {
                treeMap = (TreeMap) this.f719kI.clone();
            }
            return treeMap.entrySet();
        }

        public void run() {
            int i;
            StringBuilder sb;
            String str;
            C0758b bVar = this;
            boolean m = C0871h.m970m();
            for (Entry entry : mo9389bR()) {
                String str2 = " retCode: ";
                String str3 = "SharkProcessProxy";
                if (!m) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(C0749ea.this.f680kg);
                    sb2.append(" run, 无物理网络");
                    C0849fg.m914i(str3, sb2.toString());
                    i = -1000002;
                    C0749ea.this.mo9375a(Process.myPid(), ((C0757a) entry.getValue()).f715kw, 0, ((C0757a) entry.getValue()).f718kz, null, -1000002, 0);
                    sb = new StringBuilder();
                    str = "[ocean]SharkProxyTaskRunnable.run(), no network: cmdId: ";
                } else if (((C0757a) entry.getValue()).mo9387bJ()) {
                    i = -1000017;
                    C0749ea.this.mo9375a(Process.myPid(), ((C0757a) entry.getValue()).f715kw, 0, ((C0757a) entry.getValue()).f718kz, null, -1000017, 0);
                    sb = new StringBuilder();
                    str = "[ocean][time_out]SharkProxyTaskRunnable.run(), send time out, stats by onConnnect(): cmdId: ";
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(C0749ea.this.f680kg);
                    sb3.append(" onPostToSendingProcess() mPid: ");
                    sb3.append(((C0757a) entry.getValue()).f713kg);
                    sb3.append(" mCallerIdent: ");
                    sb3.append(((C0757a) entry.getValue()).f705kA);
                    sb3.append(" mIpcSeqNo: ");
                    sb3.append(((C0757a) entry.getValue()).f715kw);
                    sb3.append(" mPushSeqNo: ");
                    sb3.append(((C0757a) entry.getValue()).f716kx);
                    sb3.append(" mPushId: ");
                    sb3.append(((C0757a) entry.getValue()).f717ky);
                    sb3.append(" mCmdId: ");
                    sb3.append(((C0757a) entry.getValue()).f718kz);
                    sb3.append(" mFlag: ");
                    sb3.append(((C0757a) entry.getValue()).f708kD);
                    sb3.append(" mTimeout: ");
                    sb3.append(((C0757a) entry.getValue()).f710kF);
                    C0849fg.m914i(str3, sb3.toString());
                    C0749ea.this.f678ju.sendMessageDelayed(Message.obtain(C0749ea.this.f678ju, 0, entry.getValue()), 35000);
                    boolean z = m;
                    C0749ea.this.f675hN.mo9222a(((C0757a) entry.getValue()).f713kg, ((C0757a) entry.getValue()).f705kA, ((C0757a) entry.getValue()).f715kw, ((C0757a) entry.getValue()).f716kx, ((C0757a) entry.getValue()).f717ky, ((C0757a) entry.getValue()).f718kz, C0683dd.m256a(((C0757a) entry.getValue()).f706kB), ((C0757a) entry.getValue()).f708kD, ((C0757a) entry.getValue()).f710kF, ((C0757a) entry.getValue()).f711kG, ((C0757a) entry.getValue()).f712kH);
                    bVar = this;
                    m = z;
                }
                sb.append(str);
                sb.append(((C0757a) entry.getValue()).f718kz);
                sb.append(str2);
                sb.append(i);
                C0849fg.m916w(str3, sb.toString());
                C0749ea.this.f675hN.mo9257i(((C0757a) entry.getValue()).f718kz, i);
            }
        }
    }

    private C0749ea(C0695dl dlVar) {
        this.f675hN = dlVar;
        this.f679kf = new C0710a();
        this.f681kh = Executors.newSingleThreadExecutor();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m559a(final C0757a aVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("runTimeout() sharkProxyTask: ");
        sb.append(aVar.f715kw);
        C0849fg.m911d("SharkProcessProxy", sb.toString());
        this.f678ju.removeMessages(0, aVar);
        synchronized (this.f676hO) {
            if (this.f683kj.containsKey(Integer.valueOf(aVar.f715kw))) {
                C0845fd.m898cN().addTask(new Runnable() {
                    public void run() {
                        C0749ea.this.mo9375a(Process.myPid(), aVar.f715kw, 0, aVar.f718kz, null, C0673cz.m215l(-2050000), 0);
                    }
                }, "sharkProcessProxyTimeout");
            }
        }
    }

    /* renamed from: bQ */
    public static synchronized C0749ea m562bQ() {
        C0749ea eaVar;
        synchronized (C0749ea.class) {
            if (f674km == null) {
                f674km = new C0749ea(C0759eb.m591bT().mo9401bF());
            }
            eaVar = f674km;
        }
        return eaVar;
    }

    /* renamed from: a */
    public void mo9375a(int i, int i2, int i3, int i4, byte[] bArr, int i5, int i6) {
        if (this.f680kg != i) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f680kg);
            sb.append(" callBack() not my pid's response, its pid is: ");
            sb.append(i);
            C0849fg.m916w("SharkProcessProxy", sb.toString());
            return;
        }
        C0845fd cN = C0845fd.m898cN();
        final int i7 = i2;
        final byte[] bArr2 = bArr;
        final int i8 = i4;
        final int i9 = i3;
        final int i10 = i5;
        final int i11 = i6;
        C07556 r0 = new Runnable() {
            public void run() {
                C0757a aVar;
                try {
                    synchronized (C0749ea.this.f676hO) {
                        aVar = (C0757a) C0749ea.this.f683kj.remove(Integer.valueOf(i7));
                    }
                    if (aVar == null) {
                        String str = "SharkProcessProxy";
                        StringBuilder sb = new StringBuilder();
                        sb.append(C0749ea.this.f680kg);
                        sb.append(" callBack(), no callback for ipcSeqNo: ");
                        sb.append(i7);
                        C0849fg.m912e(str, sb.toString());
                        return;
                    }
                    C0749ea.this.f678ju.removeMessages(0, aVar);
                    JceStruct a = C0683dd.m249a(bArr2, aVar.f707kC);
                    if (aVar.f707kC != a) {
                        aVar.f707kC = a;
                    }
                    aVar.f718kz = i8;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(C0749ea.this.f680kg);
                    sb2.append(" callBack() ipcSeqNo: ");
                    sb2.append(i7);
                    sb2.append(" seqNo: ");
                    sb2.append(i9);
                    sb2.append(" cmdId: ");
                    sb2.append(i8);
                    sb2.append(" retCode: ");
                    sb2.append(i10);
                    sb2.append(" dataRetCode: ");
                    sb2.append(i11);
                    C0849fg.m914i("SharkProcessProxy", sb2.toString());
                    C0749ea.this.mo9378a(aVar, Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11));
                } catch (Exception e) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("exception: ");
                    sb3.append(e);
                    C0849fg.m912e("SharkProcessProxy", sb3.toString());
                }
            }
        };
        cN.addTask(r0, "shark callback");
    }

    /* renamed from: a */
    public void mo9376a(int i, long j, int i2, long j2, int i3, JceStruct jceStruct, JceStruct jceStruct2, int i4, C0693dj djVar, long j3, long j4) {
        int i5 = i;
        long j5 = j;
        int i6 = i2;
        long j6 = j2;
        int i7 = i3;
        JceStruct jceStruct3 = jceStruct;
        JceStruct jceStruct4 = jceStruct2;
        int i8 = i4;
        C0693dj djVar2 = djVar;
        long j7 = j3;
        long j8 = j4;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f680kg);
        sb.append(" sendShark()");
        C0849fg.m911d("SharkProcessProxy", sb.toString());
        C0757a aVar = r1;
        C0757a aVar2 = new C0757a(this, i5, this.f679kf.mo9293bf(), i6, j6, j5, i7, jceStruct3, jceStruct4, i8, djVar2, j7, j8);
        synchronized (this.f676hO) {
            this.f682ki.add(aVar);
        }
        this.f677js.sendEmptyMessage(1);
    }

    /* renamed from: a */
    public void mo9377a(long j, int i, JceStruct jceStruct, int i2, C0696dm dmVar) {
        synchronized (this.f684kk) {
            String str = "SharkProcessProxy";
            StringBuilder sb = new StringBuilder();
            sb.append(this.f680kg);
            sb.append(" registerSharkPush() callIdent: ");
            sb.append(j);
            sb.append(" cmdId: ");
            sb.append(i);
            sb.append(" flag: ");
            sb.append(i2);
            C0849fg.m911d(str, sb.toString());
            if (!this.f684kk.containsKey(Integer.valueOf(i))) {
                this.f684kk.put(Integer.valueOf(i), new Pair(jceStruct, dmVar));
                C0845fd cN = C0845fd.m898cN();
                final long j2 = j;
                final int i3 = i;
                final int i4 = i2;
                C07534 r1 = new Runnable() {
                    public void run() {
                        if (C0749ea.this.f675hN != null) {
                            C0749ea.this.f675hN.mo9223a(j2, i3, i4);
                        } else {
                            C0849fg.m912e("SharkProcessProxy", "shark register push failed");
                        }
                    }
                };
                cN.addTask(r1, "shark register push");
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[shark_push]registerSharkPush(), only one listener is allowed for current version! callIdent: ");
                sb2.append(j);
                sb2.append(" cmdId: ");
                sb2.append(i);
                sb2.append(" flag: ");
                sb2.append(i2);
                String sb3 = sb2.toString();
                if (!C0716dx.m433bw()) {
                    C0849fg.m912e("SharkProcessProxy", sb3);
                } else {
                    throw new RuntimeException(sb3);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9378a(C0757a aVar, Integer num, Integer num2, Integer num3) {
        C0757a aVar2 = aVar;
        Integer num4 = num;
        Integer num5 = num2;
        Integer num6 = num3;
        if (aVar2.f709kE != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("[ocean]procallback: ECmd|");
            sb.append(aVar2.f718kz);
            sb.append("|ipcSeqNo|");
            sb.append(aVar2.f715kw);
            sb.append("|seqNo|");
            sb.append(num);
            sb.append("|ret|");
            sb.append(num5);
            sb.append("|dataRetCode|");
            sb.append(num6);
            sb.append("|ident|");
            sb.append(aVar2.f705kA);
            C0849fg.m911d(ESharkCode.SHARK_OCEAN, sb.toString());
            int g = C0668cv.m143g(aVar2.f708kD);
            if (g == 8) {
                this.f685kl.sendMessage(this.f685kl.obtainMessage(11, new Object[]{aVar2, num4, num5, num6}));
            } else if (g != 16) {
                aVar2.f709kE.mo9159a(num.intValue(), aVar2.f718kz, num2.intValue(), num3.intValue(), aVar2.f707kC);
            } else {
                aVar2.f709kE.mo9159a(num.intValue(), aVar2.f718kz, num2.intValue(), num3.intValue(), aVar2.f707kC);
            }
        }
    }

    /* renamed from: e */
    public C0696dm mo9379e(final int i, final int i2) {
        C0696dm dmVar;
        synchronized (this.f684kk) {
            String str = "SharkProcessProxy";
            StringBuilder sb = new StringBuilder();
            sb.append(this.f680kg);
            sb.append("unregisterSharkPush() cmdId: ");
            sb.append(i);
            sb.append(" flag: ");
            sb.append(i2);
            C0849fg.m911d(str, sb.toString());
            if (this.f684kk.containsKey(Integer.valueOf(i))) {
                dmVar = (C0696dm) ((Pair) this.f684kk.remove(Integer.valueOf(i))).second;
                C0845fd.m898cN().addTask(new Runnable() {
                    public void run() {
                        C0749ea.this.f675hN.mo9253f(i, i2);
                    }
                }, "shark unregist push");
            } else {
                dmVar = null;
            }
        }
        return dmVar;
    }
}
