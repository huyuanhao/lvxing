package btmsdkobf;

import android.content.Context;
import android.net.NetworkInfo;
import btmsdkobf.C0718dy.C0738f;
import btmsdkobf.C0815eq.C0817b;
import com.tencent.p605ep.common.adapt.iservice.net.ESharkCode;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/* renamed from: btmsdkobf.es */
public class C0819es {
    /* renamed from: ha */
    protected C0814ep f915ha;
    private Context mContext;
    /* renamed from: ng */
    private byte f916ng;
    /* renamed from: nh */
    private boolean f917nh;
    /* renamed from: ni */
    private String f918ni;
    /* renamed from: nj */
    private volatile boolean f919nj;
    /* renamed from: nk */
    private Thread f920nk;
    /* renamed from: nl */
    private final Object f921nl;
    /* renamed from: nm */
    private Socket f922nm;
    /* renamed from: nn */
    private DataOutputStream f923nn;
    /* renamed from: no */
    private DataInputStream f924no;
    /* access modifiers changed from: private */
    /* renamed from: np */
    public C0823a f925np;
    /* renamed from: nq */
    private boolean f926nq;

    /* renamed from: btmsdkobf.es$a */
    public interface C0823a {
        /* renamed from: H */
        void mo9469H(int i);

        /* renamed from: a */
        void mo9470a(int i, Object obj);

        /* renamed from: c */
        void mo9475c(int i, byte[] bArr);
    }

    public C0819es(Context context, byte b, boolean z, C0823a aVar, C0814ep epVar) {
        this.f916ng = 0;
        this.f917nh = true;
        this.f918ni = "";
        this.f919nj = true;
        this.f921nl = new Object();
        this.f926nq = false;
        this.mContext = context;
        this.f916ng = b;
        this.f917nh = z;
        this.f925np = aVar;
        this.f915ha = epVar;
    }

    public C0819es(Context context, C0823a aVar, C0814ep epVar) {
        this(context, 0, false, aVar, epVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0078, code lost:
            return 0;
     */
    /* renamed from: a */
    private synchronized int m825a(android.content.Context r3, boolean r4) {
        /*
        r2 = this;
        monitor-enter(r2)
        java.lang.String r3 = "TcpNetwork"
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0079 }
        r0.<init>()     // Catch:{ all -> 0x0079 }
        java.lang.String r1 = "[tcp_control]start() isRestart "
        r0.append(r1)     // Catch:{ all -> 0x0079 }
        r0.append(r4)     // Catch:{ all -> 0x0079 }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0079 }
        btmsdkobf.C0849fg.m911d(r3, r0)     // Catch:{ all -> 0x0079 }
        boolean r3 = r2.isStarted()     // Catch:{ all -> 0x0079 }
        r0 = 0
        if (r3 == 0) goto L_0x0027
        java.lang.String r3 = "TcpNetwork"
        java.lang.String r4 = "start() already started"
        btmsdkobf.C0849fg.m911d(r3, r4)     // Catch:{ all -> 0x0079 }
        monitor-exit(r2)
        return r0
    L_0x0027:
        boolean r3 = r2.mo9514m()     // Catch:{ all -> 0x0079 }
        if (r3 != 0) goto L_0x0039
        java.lang.String r3 = "TcpNetwork"
        java.lang.String r4 = "start(), no connect"
        btmsdkobf.C0849fg.m911d(r3, r4)     // Catch:{ all -> 0x0079 }
        r3 = -220000(0xfffffffffffca4a0, float:NaN)
        monitor-exit(r2)
        return r3
    L_0x0039:
        btmsdkobf.es$a r3 = r2.f925np     // Catch:{ all -> 0x0079 }
        if (r3 == 0) goto L_0x0043
        btmsdkobf.es$a r3 = r2.f925np     // Catch:{ all -> 0x0079 }
        r1 = 3
        r3.mo9469H(r1)     // Catch:{ all -> 0x0079 }
    L_0x0043:
        btmsdkobf.ep r3 = r2.f915ha     // Catch:{ all -> 0x0079 }
        int r3 = r2.m826a(r3)     // Catch:{ all -> 0x0079 }
        if (r3 == 0) goto L_0x0054
        java.lang.String r4 = "TcpNetwork"
        java.lang.String r0 = "[tcp_control]connect failed, donot startRcvThread()"
        btmsdkobf.C0849fg.m916w(r4, r0)     // Catch:{ all -> 0x0079 }
        monitor-exit(r2)
        return r3
    L_0x0054:
        r2.f919nj = r0     // Catch:{ all -> 0x0079 }
        byte r3 = r2.f916ng     // Catch:{ all -> 0x0079 }
        if (r3 != 0) goto L_0x0064
        java.lang.String r3 = "TcpNetwork"
        java.lang.String r1 = "[tcp_control]connect succ, startRcvThread()"
        btmsdkobf.C0849fg.m911d(r3, r1)     // Catch:{ all -> 0x0079 }
        r2.m838cy()     // Catch:{ all -> 0x0079 }
    L_0x0064:
        btmsdkobf.es$a r3 = r2.f925np     // Catch:{ all -> 0x0079 }
        if (r3 == 0) goto L_0x0077
        if (r4 == 0) goto L_0x0071
        btmsdkobf.es$a r3 = r2.f925np     // Catch:{ all -> 0x0079 }
        r4 = 5
        r3.mo9469H(r4)     // Catch:{ all -> 0x0079 }
        goto L_0x0077
    L_0x0071:
        btmsdkobf.es$a r3 = r2.f925np     // Catch:{ all -> 0x0079 }
        r4 = 4
        r3.mo9469H(r4)     // Catch:{ all -> 0x0079 }
    L_0x0077:
        monitor-exit(r2)
        return r0
    L_0x0079:
        r3 = move-exception
        monitor-exit(r2)
        throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0819es.m825a(android.content.Context, boolean):int");
    }

    /* renamed from: a */
    private int m826a(C0814ep epVar) {
        int i;
        long j;
        C0814ep epVar2 = epVar;
        String str = "TcpNetwork";
        C0849fg.m911d(str, "[tcp_control] checkSocketWithRetry()");
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        epVar2.mo9286o(true);
        int r = epVar2.mo9289r(true);
        C0817b bVar = null;
        long j2 = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= r) {
                i = i3;
                j = j2;
                break;
            }
            bVar = epVar2.mo9284m(true);
            if (bVar != null) {
                long currentTimeMillis2 = System.currentTimeMillis();
                i = m831b(bVar);
                j = System.currentTimeMillis() - currentTimeMillis2;
                StringBuilder sb = new StringBuilder();
                sb.append("checkSocketWithRetry(), ipPoint ");
                sb.append(bVar.toString());
                sb.append(" localIp ");
                sb.append(m836cE());
                sb.append(" localPort ");
                sb.append(m837cF());
                sb.append(" ret: ");
                sb.append(i);
                C0849fg.m914i(str, sb.toString());
                if (i != 0 && C0673cz.m216m(i)) {
                    if (i2 == 0 && C0716dx.m438r("tcp connect")) {
                        i = ESharkCode.ERR_NETWORK_NEED_WIFIAPPROVEMENT;
                        break;
                    }
                    epVar2.mo9285n(true);
                    long j3 = j;
                    i3 = i;
                    j2 = j3;
                } else {
                    break;
                }
            }
            i2++;
        }
        epVar2.mo9287p(i == 0);
        if (bVar != null) {
            final C0790eg egVar = new C0790eg();
            egVar.f842me = bVar.mo9500cu();
            egVar.f843mf = String.valueOf(bVar.getPort());
            egVar.f845mh = String.valueOf(C0683dd.m265m(this.mContext));
            egVar.f847mj = j;
            egVar.errorCode = i;
            egVar.f848mk = this.f918ni;
            egVar.f844mg = i2 < r ? i2 + 1 : r;
            egVar.mo9466f(epVar2.mo9288q(true));
            if (i2 != r) {
                z = false;
            }
            if (z) {
                C0845fd.m898cN().addTask(new Runnable() {
                    public void run() {
                        C0790eg egVar = egVar;
                        egVar.f852mo = true;
                        egVar.f853mp = C0716dx.m440s("tcp connect");
                        egVar.f849ml = "true";
                        C0759eb bT = C0759eb.m591bT();
                        if (bT != null) {
                            egVar.mo9463d(bT.mo9401bF());
                        }
                    }
                }, "uploadConnectInfo");
            } else {
                egVar.f852mo = false;
                egVar.f849ml = "false";
                C0759eb bT = C0759eb.m591bT();
                if (bT != null) {
                    egVar.mo9463d(bT.mo9401bF());
                }
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[tcp_control] checkSocketWithRetry(), ret: ");
        sb2.append(i);
        sb2.append(" time: ");
        sb2.append(System.currentTimeMillis() - currentTimeMillis);
        C0849fg.m914i(str, sb2.toString());
        return i;
    }

    /* renamed from: a */
    private Socket m827a(InetAddress inetAddress, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("acquireSocketWithTimeOut, addr: ");
        sb.append(inetAddress);
        sb.append(", port: ");
        sb.append(i);
        String str = "TcpNetwork";
        C0849fg.m914i(str, sb.toString());
        Socket socket = new Socket();
        socket.setSoLinger(false, 0);
        socket.connect(new InetSocketAddress(inetAddress, i), 15000);
        C0849fg.m914i(str, "acquireSocketWithTimeOut end");
        return socket;
    }

    /* renamed from: a */
    private boolean m829a(C0817b bVar) {
        String str = "TcpNetwork";
        C0849fg.m911d(str, "[tcp_control]startSocket()");
        if (!m834cB()) {
            C0849fg.m914i(str, "startSocket() 1");
            m833cA();
        }
        C0849fg.m914i(str, "startSocket() 2");
        InetAddress byName = InetAddress.getByName(bVar.mo9500cu());
        C0849fg.m914i(str, "startSocket() 3");
        this.f922nm = m827a(byName, bVar.getPort());
        C0849fg.m914i(str, "startSocket() 4");
        byte b = this.f916ng;
        if (b == 0) {
            this.f923nn = new DataOutputStream(this.f922nm.getOutputStream());
            C0849fg.m914i(str, "startSocket() 5");
            this.f924no = new DataInputStream(this.f922nm.getInputStream());
        } else if (b == 1) {
            this.f922nm.setSoTimeout(15000);
        }
        C0849fg.m914i(str, "startSocket() 6");
        return mo9510cC();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            r1.f918ni = "";
            btmsdkobf.C0849fg.m914i("TcpNetwork", "sendDataInAsync() succ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c9, code lost:
            return 0;
     */
    /* renamed from: b */
    private int m830b(btmsdkobf.C0718dy.C0738f r18, byte[] r19) {
        /*
        r17 = this;
        r1 = r17
        r0 = r18
        r2 = r19
        java.net.Socket r3 = r1.f922nm     // Catch:{ SocketException -> 0x00f2, all -> 0x00cd }
        monitor-enter(r3)     // Catch:{ SocketException -> 0x00f2, all -> 0x00cd }
        boolean r4 = r17.mo9510cC()     // Catch:{ all -> 0x00ca }
        if (r4 != 0) goto L_0x0014
        r0 = -180000(0xfffffffffffd40e0, float:NaN)
        monitor-exit(r3)     // Catch:{ all -> 0x00ca }
        return r0
    L_0x0014:
        java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x00ca }
        r4.<init>()     // Catch:{ all -> 0x00ca }
        java.io.DataOutputStream r5 = new java.io.DataOutputStream     // Catch:{ all -> 0x00ca }
        r5.<init>(r4)     // Catch:{ all -> 0x00ca }
        int r6 = r2.length     // Catch:{ all -> 0x00ca }
        r5.writeInt(r6)     // Catch:{ all -> 0x00ca }
        r5.write(r2)     // Catch:{ all -> 0x00ca }
        byte[] r2 = r4.toByteArray()     // Catch:{ all -> 0x00ca }
        java.lang.String r4 = "TcpNetwork"
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ca }
        r5.<init>()     // Catch:{ all -> 0x00ca }
        java.lang.String r6 = "[tcp_control]sendDataInAsync(), bf [tcp send] bytes: "
        r5.append(r6)     // Catch:{ all -> 0x00ca }
        int r6 = r2.length     // Catch:{ all -> 0x00ca }
        r5.append(r6)     // Catch:{ all -> 0x00ca }
        java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00ca }
        btmsdkobf.C0849fg.m914i(r4, r5)     // Catch:{ all -> 0x00ca }
        java.io.DataOutputStream r4 = r1.f923nn     // Catch:{ all -> 0x00ca }
        r4.write(r2)     // Catch:{ all -> 0x00ca }
        java.lang.String r4 = "TcpNetwork"
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ca }
        r5.<init>()     // Catch:{ all -> 0x00ca }
        java.lang.String r6 = "[flow_control][tcp_control]sendDataInAsync(), [tcp send] bytes: "
        r5.append(r6)     // Catch:{ all -> 0x00ca }
        int r6 = r2.length     // Catch:{ all -> 0x00ca }
        r5.append(r6)     // Catch:{ all -> 0x00ca }
        java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00ca }
        btmsdkobf.C0849fg.m911d(r4, r5)     // Catch:{ all -> 0x00ca }
        r4 = 0
        if (r0 == 0) goto L_0x00bd
        java.util.ArrayList<btmsdkobf.by> r5 = r0.f649jN     // Catch:{ all -> 0x00ca }
        if (r5 == 0) goto L_0x00bd
        java.util.ArrayList<btmsdkobf.by> r5 = r0.f649jN     // Catch:{ all -> 0x00ca }
        int r5 = r5.size()     // Catch:{ all -> 0x00ca }
        if (r5 <= 0) goto L_0x00bd
        java.util.ArrayList<btmsdkobf.by> r5 = r0.f649jN     // Catch:{ all -> 0x00ca }
        int r5 = r5.size()     // Catch:{ all -> 0x00ca }
        java.util.ArrayList<btmsdkobf.by> r0 = r0.f649jN     // Catch:{ all -> 0x00ca }
        java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00ca }
    L_0x0077:
        boolean r6 = r0.hasNext()     // Catch:{ all -> 0x00ca }
        if (r6 == 0) goto L_0x00bd
        java.lang.Object r6 = r0.next()     // Catch:{ all -> 0x00ca }
        btmsdkobf.by r6 = (btmsdkobf.C0636by) r6     // Catch:{ all -> 0x00ca }
        if (r6 != 0) goto L_0x0086
        goto L_0x0077
    L_0x0086:
        btmsdkobf.dv r7 = btmsdkobf.C0712dv.m412br()     // Catch:{ all -> 0x00ca }
        java.lang.String r8 = "TcpNetwork"
        int r9 = r6.f357dO     // Catch:{ all -> 0x00ca }
        int r10 = r6.f358fm     // Catch:{ all -> 0x00ca }
        r12 = 12
        r13 = 0
        java.lang.String r11 = "%d/%d"
        r14 = 2
        java.lang.Object[] r14 = new java.lang.Object[r14]     // Catch:{ all -> 0x00ca }
        int r15 = r2.length     // Catch:{ all -> 0x00ca }
        java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ all -> 0x00ca }
        r14[r4] = r15     // Catch:{ all -> 0x00ca }
        r15 = 1
        java.lang.Integer r16 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x00ca }
        r14[r15] = r16     // Catch:{ all -> 0x00ca }
        java.lang.String r14 = java.lang.String.format(r11, r14)     // Catch:{ all -> 0x00ca }
        r11 = r6
        r7.mo9317a(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x00ca }
        int r7 = r6.f359fn     // Catch:{ all -> 0x00ca }
        if (r7 != 0) goto L_0x0077
        btmsdkobf.eg r7 = new btmsdkobf.eg     // Catch:{ all -> 0x00ca }
        r7.m40728init()     // Catch:{ all -> 0x00ca }
        int r6 = r6.f358fm     // Catch:{ all -> 0x00ca }
        btmsdkobf.C0790eg.m717a(r7, r6)     // Catch:{ all -> 0x00ca }
        goto L_0x0077
    L_0x00bd:
        monitor-exit(r3)     // Catch:{ all -> 0x00ca }
        java.lang.String r0 = ""
        r1.f918ni = r0     // Catch:{ SocketException -> 0x00f2, all -> 0x00cd }
        java.lang.String r0 = "TcpNetwork"
        java.lang.String r2 = "sendDataInAsync() succ"
        btmsdkobf.C0849fg.m914i(r0, r2)     // Catch:{ SocketException -> 0x00f2, all -> 0x00cd }
        return r4
    L_0x00ca:
        r0 = move-exception
        monitor-exit(r3)     // Catch:{ all -> 0x00ca }
        throw r0     // Catch:{ SocketException -> 0x00f2, all -> 0x00cd }
    L_0x00cd:
        r0 = move-exception
        java.lang.String r2 = r0.toString()
        r1.f918ni = r2
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        java.lang.String r3 = "sendDataInAsync() Throwable: "
        r2.append(r3)
        java.lang.String r0 = r0.toString()
        r2.append(r0)
        java.lang.String r0 = r2.toString()
        java.lang.String r2 = "TcpNetwork"
        btmsdkobf.C0849fg.m912e(r2, r0)
        r0 = -320000(0xfffffffffffb1e00, float:NaN)
        return r0
    L_0x00f2:
        r0 = move-exception
        java.lang.String r2 = r0.toString()
        r1.f918ni = r2
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        java.lang.String r3 = "sendDataInAsync() SocketException: "
        r2.append(r3)
        java.lang.String r0 = r0.toString()
        r2.append(r0)
        java.lang.String r0 = r2.toString()
        java.lang.String r2 = "TcpNetwork"
        btmsdkobf.C0849fg.m912e(r2, r0)
        r0 = -330000(0xfffffffffffaf6f0, float:NaN)
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0819es.m830b(btmsdkobf.dy$f, byte[]):int");
    }

    /* renamed from: b */
    private int m831b(C0817b bVar) {
        int i;
        String str;
        String str2 = "TcpNetwork";
        C0849fg.m911d(str2, "[tcp_control]checkSocket()");
        if (bVar == null) {
            return -10;
        }
        int i2 = 0;
        if (mo9510cC()) {
            C0849fg.m916w(str2, "[tcp_control]checkSocket(), already contected");
            return 0;
        }
        try {
            if (m829a(bVar)) {
                C0849fg.m915v(str2, "[tcp_control]checkSocket(), startSocket succ, set: mIsIgnoreStopExption = false");
                this.f926nq = false;
            } else {
                i2 = ESharkCode.ERR_NETWORK_START_SOCKET_FAILED;
            }
            this.f918ni = "";
            i = i2;
        } catch (UnknownHostException e) {
            C0849fg.m910a(str2, "checkSocket(), UnknownHostException: ", (Throwable) e);
            C0823a aVar = this.f925np;
            if (aVar != null) {
                aVar.mo9470a(7, bVar);
            }
            this.f918ni = e.toString();
            i = ESharkCode.ERR_NETWORK_UNKNOWNHOSTEXCEPTION;
        } catch (SocketTimeoutException e2) {
            C0849fg.m910a(str2, "checkSocket(), SocketTimeoutException: ", (Throwable) e2);
            C0823a aVar2 = this.f925np;
            if (aVar2 != null) {
                aVar2.mo9470a(8, bVar);
            }
            this.f918ni = e2.toString();
            i = ESharkCode.ERR_NETWORK_SOCKETTIMEOUTEXCEPTION;
        } catch (ConnectException e3) {
            i = C0673cz.m211a(e3.toString(), ESharkCode.ERR_NETWORK_CONNECT_ELSE);
            C0849fg.m910a(str2, "checkSocket(), ConnectException: ", (Throwable) e3);
            C0823a aVar3 = this.f925np;
            if (aVar3 != null) {
                aVar3.mo9470a(9, bVar);
            }
            str = e3.toString();
            this.f918ni = str;
        } catch (SocketException e4) {
            i = C0673cz.m211a(e4.toString(), ESharkCode.ERR_NETWORK_SOCKET_ELSE);
            C0849fg.m910a(str2, "checkSocket(), SocketException: ", (Throwable) e4);
            C0823a aVar4 = this.f925np;
            if (aVar4 != null) {
                aVar4.mo9470a(9, bVar);
            }
            str = e4.toString();
            this.f918ni = str;
        } catch (SecurityException e5) {
            i = C0673cz.m211a(e5.toString(), ESharkCode.ERR_NETWORK_SECURITY_ELSE);
            C0849fg.m910a(str2, "checkSocket(), SecurityException: ", (Throwable) e5);
            C0823a aVar5 = this.f925np;
            if (aVar5 != null) {
                aVar5.mo9470a(9, bVar);
            }
            str = e5.toString();
            this.f918ni = str;
        } catch (Throwable th) {
            i = ESharkCode.ERR_NETWORK_UNKNOWN;
            C0849fg.m910a(str2, "checkSocket(), Throwable: ", th);
            C0823a aVar6 = this.f925np;
            if (aVar6 != null) {
                aVar6.mo9470a(9, bVar);
            }
            str = th.toString();
            this.f918ni = str;
        }
        return i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0028, code lost:
            if (m834cB() == false) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
            btmsdkobf.C0849fg.m916w("TcpNetwork", "[tcp_control]stopSocket(), already closed");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
            return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
            btmsdkobf.C0849fg.m914i("TcpNetwork", "stopSocket() 2");
            r3 = r8.f921nl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
            monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            btmsdkobf.C0849fg.m914i("TcpNetwork", "stopSocket() 3");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0049, code lost:
            if (r8.f922nm.isInputShutdown() != false) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004b, code lost:
            r8.f922nm.shutdownInput();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0051, code lost:
            r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0052, code lost:
            r5 = "TcpNetwork";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            r6 = new java.lang.StringBuilder();
            r6.append("stopSocket(), mSocket.shutdownInput() ");
            r6.append(r2);
            btmsdkobf.C0849fg.m911d(r5, r6.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
            btmsdkobf.C0849fg.m914i("TcpNetwork", "stopSocket() 1");
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008e A[Catch:{ all -> 0x0094 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00da  */
    /* renamed from: cA */
    private int m833cA() {
        /*
        r8 = this;
        java.lang.String r0 = "TcpNetwork"
        java.lang.String r1 = "[tcp_control]stopSocket()"
        btmsdkobf.C0849fg.m914i(r0, r1)
        long r0 = java.lang.System.currentTimeMillis()
        java.lang.Object r2 = r8.f921nl
        monitor-enter(r2)
        java.net.Socket r3 = r8.f922nm     // Catch:{ all -> 0x0183 }
        r4 = 0
        if (r3 != 0) goto L_0x001c
        java.lang.String r0 = "TcpNetwork"
        java.lang.String r1 = "[tcp_control]stopSocket(), mSocket is null"
        btmsdkobf.C0849fg.m916w(r0, r1)     // Catch:{ all -> 0x0183 }
        monitor-exit(r2)     // Catch:{ all -> 0x0183 }
        return r4
    L_0x001c:
        monitor-exit(r2)     // Catch:{ all -> 0x0183 }
        java.lang.String r2 = "TcpNetwork"
        java.lang.String r3 = "stopSocket() 1"
        btmsdkobf.C0849fg.m914i(r2, r3)
        boolean r2 = r8.m834cB()
        if (r2 == 0) goto L_0x0032
        java.lang.String r0 = "TcpNetwork"
        java.lang.String r1 = "[tcp_control]stopSocket(), already closed"
        btmsdkobf.C0849fg.m916w(r0, r1)
        return r4
    L_0x0032:
        java.lang.String r2 = "TcpNetwork"
        java.lang.String r3 = "stopSocket() 2"
        btmsdkobf.C0849fg.m914i(r2, r3)
        java.lang.Object r3 = r8.f921nl
        monitor-enter(r3)
        java.lang.String r2 = "TcpNetwork"
        java.lang.String r5 = "stopSocket() 3"
        btmsdkobf.C0849fg.m914i(r2, r5)     // Catch:{ all -> 0x0180 }
        java.net.Socket r2 = r8.f922nm     // Catch:{ all -> 0x0051 }
        boolean r2 = r2.isInputShutdown()     // Catch:{ all -> 0x0051 }
        if (r2 != 0) goto L_0x0068
        java.net.Socket r2 = r8.f922nm     // Catch:{ all -> 0x0051 }
        r2.shutdownInput()     // Catch:{ all -> 0x0051 }
        goto L_0x0068
    L_0x0051:
        r2 = move-exception
        java.lang.String r5 = "TcpNetwork"
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0180 }
        r6.<init>()     // Catch:{ all -> 0x0180 }
        java.lang.String r7 = "stopSocket(), mSocket.shutdownInput() "
        r6.append(r7)     // Catch:{ all -> 0x0180 }
        r6.append(r2)     // Catch:{ all -> 0x0180 }
        java.lang.String r2 = r6.toString()     // Catch:{ all -> 0x0180 }
        btmsdkobf.C0849fg.m911d(r5, r2)     // Catch:{ all -> 0x0180 }
    L_0x0068:
        java.lang.String r2 = "TcpNetwork"
        java.lang.String r5 = "stopSocket() 4"
        btmsdkobf.C0849fg.m914i(r2, r5)     // Catch:{ all -> 0x0180 }
        java.io.DataInputStream r2 = r8.f924no     // Catch:{ all -> 0x0075 }
        r2.close()     // Catch:{ all -> 0x0075 }
        goto L_0x007f
    L_0x0075:
        r2 = move-exception
        java.lang.String r5 = "TcpNetwork"
        java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x0180 }
        btmsdkobf.C0849fg.m911d(r5, r2)     // Catch:{ all -> 0x0180 }
    L_0x007f:
        java.lang.String r2 = "TcpNetwork"
        java.lang.String r5 = "stopSocket() 5"
        btmsdkobf.C0849fg.m914i(r2, r5)     // Catch:{ all -> 0x0180 }
        java.net.Socket r2 = r8.f922nm     // Catch:{ all -> 0x0094 }
        boolean r2 = r2.isOutputShutdown()     // Catch:{ all -> 0x0094 }
        if (r2 != 0) goto L_0x00ab
        java.net.Socket r2 = r8.f922nm     // Catch:{ all -> 0x0094 }
        r2.shutdownOutput()     // Catch:{ all -> 0x0094 }
        goto L_0x00ab
    L_0x0094:
        r2 = move-exception
        java.lang.String r5 = "TcpNetwork"
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0180 }
        r6.<init>()     // Catch:{ all -> 0x0180 }
        java.lang.String r7 = "stopSocket(), mSocket.shutdownOutput() "
        r6.append(r7)     // Catch:{ all -> 0x0180 }
        r6.append(r2)     // Catch:{ all -> 0x0180 }
        java.lang.String r2 = r6.toString()     // Catch:{ all -> 0x0180 }
        btmsdkobf.C0849fg.m911d(r5, r2)     // Catch:{ all -> 0x0180 }
    L_0x00ab:
        java.lang.String r2 = "TcpNetwork"
        java.lang.String r5 = "stopSocket() 6"
        btmsdkobf.C0849fg.m914i(r2, r5)     // Catch:{ all -> 0x0180 }
        java.io.DataOutputStream r2 = r8.f923nn     // Catch:{ all -> 0x00b8 }
        r2.close()     // Catch:{ all -> 0x00b8 }
        goto L_0x00cf
    L_0x00b8:
        r2 = move-exception
        java.lang.String r5 = "TcpNetwork"
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0180 }
        r6.<init>()     // Catch:{ all -> 0x0180 }
        java.lang.String r7 = "stopSocket(), mSocketWriter.close() "
        r6.append(r7)     // Catch:{ all -> 0x0180 }
        r6.append(r2)     // Catch:{ all -> 0x0180 }
        java.lang.String r2 = r6.toString()     // Catch:{ all -> 0x0180 }
        btmsdkobf.C0849fg.m911d(r5, r2)     // Catch:{ all -> 0x0180 }
    L_0x00cf:
        monitor-exit(r3)     // Catch:{ all -> 0x0180 }
        java.lang.String r2 = "TcpNetwork"
        java.lang.String r3 = "stopSocket() 7"
        btmsdkobf.C0849fg.m914i(r2, r3)     // Catch:{ InterruptedException -> 0x013c, IOException -> 0x011d, all -> 0x00fe }
        java.lang.Object r2 = r8.f921nl     // Catch:{ InterruptedException -> 0x013c, IOException -> 0x011d, all -> 0x00fe }
        monitor-enter(r2)     // Catch:{ InterruptedException -> 0x013c, IOException -> 0x011d, all -> 0x00fe }
        java.lang.String r3 = "TcpNetwork"
        java.lang.String r5 = "stopSocket() 8"
        btmsdkobf.C0849fg.m914i(r3, r5)     // Catch:{ all -> 0x00fb }
        java.net.Socket r3 = r8.f922nm     // Catch:{ all -> 0x00fb }
        r3.close()     // Catch:{ all -> 0x00fb }
        r3 = 0
        r8.f922nm = r3     // Catch:{ all -> 0x00fb }
        java.lang.String r3 = "TcpNetwork"
        java.lang.String r5 = "stopSocket() 9"
        btmsdkobf.C0849fg.m914i(r3, r5)     // Catch:{ all -> 0x00fb }
        monitor-exit(r2)     // Catch:{ all -> 0x00fb }
        r2 = 2000(0x7d0, double:9.88E-321)
        java.lang.Thread.sleep(r2)     // Catch:{ InterruptedException -> 0x013c, IOException -> 0x011d, all -> 0x00fe }
        java.lang.String r2 = ""
        r8.f918ni = r2     // Catch:{ InterruptedException -> 0x013c, IOException -> 0x011d, all -> 0x00fe }
        goto L_0x015c
    L_0x00fb:
        r3 = move-exception
        monitor-exit(r2)     // Catch:{ all -> 0x00fb }
        throw r3     // Catch:{ InterruptedException -> 0x013c, IOException -> 0x011d, all -> 0x00fe }
    L_0x00fe:
        r2 = move-exception
        r4 = -900000(0xfffffffffff24460, float:NaN)
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        java.lang.String r5 = "stopSocket(), Throwable: "
        r3.append(r5)
        r3.append(r2)
        java.lang.String r3 = r3.toString()
        java.lang.String r5 = "TcpNetwork"
        btmsdkobf.C0849fg.m911d(r5, r3)
        java.lang.String r2 = r2.toString()
        goto L_0x015a
    L_0x011d:
        r2 = move-exception
        r4 = -140000(0xfffffffffffddd20, float:NaN)
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        java.lang.String r5 = "stopSocket(), IOException: "
        r3.append(r5)
        r3.append(r2)
        java.lang.String r3 = r3.toString()
        java.lang.String r5 = "TcpNetwork"
        btmsdkobf.C0849fg.m911d(r5, r3)
        java.lang.String r2 = r2.toString()
        goto L_0x015a
    L_0x013c:
        r2 = move-exception
        r4 = -270000(0xfffffffffffbe150, float:NaN)
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        java.lang.String r5 = "stopSocket(), InterruptedException: "
        r3.append(r5)
        r3.append(r2)
        java.lang.String r3 = r3.toString()
        java.lang.String r5 = "TcpNetwork"
        btmsdkobf.C0849fg.m911d(r5, r3)
        java.lang.String r2 = r2.toString()
    L_0x015a:
        r8.f918ni = r2
    L_0x015c:
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        java.lang.String r3 = "[tcp_control]stopSocket(), ret: "
        r2.append(r3)
        r2.append(r4)
        java.lang.String r3 = " stop action use(ms): "
        r2.append(r3)
        long r5 = java.lang.System.currentTimeMillis()
        long r5 = r5 - r0
        r2.append(r5)
        java.lang.String r0 = r2.toString()
        java.lang.String r1 = "TcpNetwork"
        btmsdkobf.C0849fg.m914i(r1, r0)
        return r4
    L_0x0180:
        r0 = move-exception
        monitor-exit(r3)     // Catch:{ all -> 0x0180 }
        throw r0
    L_0x0183:
        r0 = move-exception
        monitor-exit(r2)     // Catch:{ all -> 0x0183 }
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0819es.m833cA():int");
    }

    /* renamed from: cB */
    private boolean m834cB() {
        C0849fg.m914i("TcpNetwork", "isSocketClosed()");
        synchronized (this.f921nl) {
            C0849fg.m914i("TcpNetwork", "isSocketClosed() 1");
            if (this.f922nm == null) {
                return true;
            }
            boolean isClosed = this.f922nm.isClosed();
            C0849fg.m914i("TcpNetwork", "isSocketClosed() 2");
            return isClosed;
        }
    }

    /* renamed from: cD */
    private NetworkInfo m835cD() {
        try {
            return C0871h.getActiveNetworkInfo();
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("getActiveNetworkInfo--- \n");
            sb.append(th.getMessage());
            C0849fg.m916w("TcpNetwork", sb.toString());
            return null;
        }
    }

    /* renamed from: cE */
    private String m836cE() {
        synchronized (this.f921nl) {
            if (this.f922nm == null) {
                String str = "null";
                return str;
            }
            String inetAddress = this.f922nm.getLocalAddress().toString();
            return inetAddress;
        }
    }

    /* renamed from: cF */
    private int m837cF() {
        synchronized (this.f921nl) {
            if (this.f922nm == null) {
                return 0;
            }
            int localPort = this.f922nm.getLocalPort();
            return localPort;
        }
    }

    /* renamed from: cy */
    private void m838cy() {
        this.f920nk = new Thread("RcvThread") {
            public void run() {
                String str = "TcpNetwork";
                C0849fg.m911d(str, "[tcp_control]RcvThread start...");
                C0819es.this.m839cz();
                C0849fg.m911d(str, "[tcp_control]RcvThread end!");
            }
        };
        this.f920nk.setPriority(10);
        this.f920nk.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: cz */
    public void m839cz() {
        C0823a aVar;
        int i;
        String str = "[tcp_control]ignore stop exption";
        String str2 = "TcpNetwork";
        C0849fg.m911d(str2, "[tcp_control]recv()...");
        while (!this.f919nj) {
            try {
                int readInt = this.f917nh ? this.f924no.readInt() : 0;
                int readInt2 = this.f924no.readInt();
                if (readInt2 >= 1000000) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("[flow_control][tcp_control]包有误，数据过大，size >= 1000000, [tcp receive] bytes: ");
                    sb.append(readInt2);
                    C0849fg.m912e(str2, sb.toString());
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[flow_control][tcp_control]recv(), [tcp receive] bytes: ");
                sb2.append(readInt2 + 4);
                C0849fg.m911d(str2, sb2.toString());
                byte[] a = C0815eq.m821a(this.f924no, 0, readInt2, null);
                if (a == null) {
                    C0849fg.m912e(str2, "[tcp_control]recv(), respData == null");
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("[tcp_control]notifyOnReceiveData(), respData.length(): ");
                    sb3.append(a.length);
                    C0849fg.m911d(str2, sb3.toString());
                    m841d(readInt, a);
                }
            } catch (SocketException e) {
                th = e;
                StringBuilder sb4 = new StringBuilder();
                sb4.append("[tcp_control]recv(), SocketException: ");
                sb4.append(th);
                C0849fg.m913e(str2, sb4.toString(), th);
                if (!this.f926nq) {
                    m840d(true, false);
                    aVar = this.f925np;
                    if (aVar != null) {
                        i = 10;
                        aVar.mo9470a(i, th);
                    }
                }
                C0849fg.m911d(str2, str);
                this.f919nj = true;
            } catch (EOFException e2) {
                th = e2;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[tcp_control]recv() EOFException: ");
                sb5.append(th);
                C0849fg.m913e(str2, sb5.toString(), th);
                if (!this.f926nq) {
                    m840d(true, false);
                    aVar = this.f925np;
                    if (aVar != null) {
                        i = 11;
                        aVar.mo9470a(i, th);
                    }
                }
                C0849fg.m911d(str2, str);
                this.f919nj = true;
            } catch (Throwable th) {
                th = th;
                StringBuilder sb6 = new StringBuilder();
                sb6.append("[tcp_control]recv() Throwable: ");
                sb6.append(th);
                C0849fg.m913e(str2, sb6.toString(), th);
                if (!this.f926nq) {
                    m840d(true, false);
                    aVar = this.f925np;
                    if (aVar != null) {
                        i = 12;
                        aVar.mo9470a(i, th);
                    }
                }
                C0849fg.m911d(str2, str);
                this.f919nj = true;
            }
        }
        if (!this.f926nq) {
            stop();
        }
        C0849fg.m911d(str2, "[tcp_control]recv(), recv thread is stopped, set: mIsIgnoreStopExption = false");
        this.f926nq = false;
        C0849fg.m911d(str2, "[tcp_control]recv(), end!!!");
    }

    /* renamed from: d */
    private synchronized int m840d(boolean z, boolean z2) {
        int cA;
        String str = "TcpNetwork";
        StringBuilder sb = new StringBuilder();
        sb.append("[tcp_control]stop(),  bySvr: ");
        sb.append(z);
        sb.append(" isRestart: ");
        sb.append(z2);
        C0849fg.m914i(str, sb.toString());
        if (!z) {
            C0849fg.m911d("TcpNetwork", "[tcp_control]stop(), !bySvr, set: mIsIgnoreStopExption = true");
            this.f926nq = true;
        }
        this.f919nj = true;
        cA = m833cA();
        if (cA != 0) {
            if (this.f925np != null) {
                C0823a aVar = this.f925np;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("stop socket failed: ");
                sb2.append(this.f918ni);
                aVar.mo9470a(6, sb2.toString());
            }
        } else if (this.f925np != null) {
            if (z) {
                this.f925np.mo9469H(0);
            } else if (z2) {
                this.f925np.mo9469H(2);
            } else {
                this.f925np.mo9469H(1);
            }
        }
        return cA;
    }

    /* renamed from: d */
    private void m841d(final int i, final byte[] bArr) {
        if (this.f925np != null) {
            C0845fd.m898cN().addTask(new Runnable() {
                public void run() {
                    try {
                        C0819es.this.f925np.mo9475c(i, bArr);
                    } catch (Throwable th) {
                        C0849fg.m912e("TcpNetwork", th.getMessage());
                    }
                }
            }, "shark-onreceive-callback");
        }
    }

    private boolean isStarted() {
        return !this.f919nj;
    }

    /* renamed from: m */
    private int m842m(byte[] bArr) {
        try {
            this.f923nn.writeInt(bArr.length);
            this.f923nn.write(bArr);
            return 0;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("sendDataInSync() Throwable: ");
            sb.append(th.toString());
            C0849fg.m912e("TcpNetwork", sb.toString());
            return ESharkCode.ERR_NETWORK_EXCEPTION_1;
        }
    }

    /* renamed from: a */
    public int mo9509a(C0738f fVar, byte[] bArr) {
        if (m834cB()) {
            return ESharkCode.ERR_NETWORK_SOCKET_CLOSED;
        }
        if (!mo9510cC()) {
            return ESharkCode.ERR_NETWORK_SOCKET_NOT_CONNECTED;
        }
        if (fVar.mo9364bJ()) {
            C0849fg.m912e("TcpNetwork", "[time_out]sendDataAsync(), send time out");
            return -17;
        }
        int i = -1;
        byte b = this.f916ng;
        if (b == 0) {
            i = m830b(fVar, bArr);
        } else if (b == 1) {
            i = m842m(bArr);
        }
        return i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: cC */
    public boolean mo9510cC() {
        C0849fg.m914i("TcpNetwork", "isSocketConnected()");
        synchronized (this.f921nl) {
            C0849fg.m914i("TcpNetwork", "isSocketConnected() 1");
            boolean z = false;
            if (this.f922nm == null) {
                return false;
            }
            C0849fg.m914i("TcpNetwork", "isSocketConnected() 2");
            if (!m834cB() && this.f922nm.isConnected()) {
                z = true;
            }
            C0849fg.m914i("TcpNetwork", "isSocketConnected() 3");
            return z;
        }
    }

    /* renamed from: ck */
    public C0814ep mo9511ck() {
        return this.f915ha;
    }

    /* renamed from: cw */
    public String mo9512cw() {
        return this.f918ni;
    }

    /* access modifiers changed from: protected */
    /* renamed from: cx */
    public int mo9513cx() {
        return m840d(false, true) != 0 ? ESharkCode.ERR_NETWORK_CLOSE_FAILED : m825a(this.mContext, true);
    }

    /* renamed from: m */
    public boolean mo9514m() {
        NetworkInfo cD = m835cD();
        if (cD == null) {
            return false;
        }
        return cD.isConnected();
    }

    /* renamed from: q */
    public int mo9515q(Context context) {
        return m825a(context, false);
    }

    public int stop() {
        return m840d(false, false);
    }
}
