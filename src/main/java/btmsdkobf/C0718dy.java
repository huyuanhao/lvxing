package btmsdkobf;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import btmsdkobf.C0704ds.C0707b;
import btmsdkobf.C0786ef.C0789a;
import btmsdkobf.C0792ei.C0798d;
import com.p522qq.taf.jce.JceStruct;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.p605ep.common.adapt.iservice.net.ESharkCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: btmsdkobf.dy */
public class C0718dy implements C0798d {
    /* access modifiers changed from: private */
    /* renamed from: hN */
    public C0695dl f594hN;
    /* access modifiers changed from: private|final */
    /* renamed from: hO */
    public final Object f595hO = new Object();
    /* renamed from: iX */
    private C0786ef f596iX;
    /* access modifiers changed from: private */
    /* renamed from: iY */
    public C0704ds f597iY;
    /* access modifiers changed from: private */
    /* renamed from: iZ */
    public C0685df f598iZ;
    /* access modifiers changed from: private */
    /* renamed from: ja */
    public C0802ek f599ja;
    /* access modifiers changed from: private */
    /* renamed from: jb */
    public C0737e f600jb;
    /* access modifiers changed from: private */
    /* renamed from: jc */
    public SparseArray<C0684de> f601jc = null;
    /* access modifiers changed from: private */
    /* renamed from: jd */
    public C0738f f602jd = null;
    /* access modifiers changed from: private */
    /* renamed from: je */
    public C0738f f603je = null;
    /* access modifiers changed from: private */
    /* renamed from: jf */
    public ArrayList<C0738f> f604jf = new ArrayList<>();
    /* access modifiers changed from: private */
    /* renamed from: jg */
    public LinkedHashMap<Integer, C0738f> f605jg = new LinkedHashMap<>();
    /* access modifiers changed from: private */
    /* renamed from: jh */
    public ExecutorService f606jh;
    /* access modifiers changed from: private */
    /* renamed from: ji */
    public boolean f607ji;
    /* access modifiers changed from: private */
    /* renamed from: jj */
    public long f608jj = 0;
    /* access modifiers changed from: private */
    /* renamed from: jk */
    public boolean f609jk = false;
    /* access modifiers changed from: private */
    /* renamed from: jl */
    public boolean f610jl = false;
    /* renamed from: jm */
    private long f611jm = 0;
    /* renamed from: jn */
    private long f612jn = 0;
    /* renamed from: jo */
    private C0735c f613jo;
    /* renamed from: jp */
    private C0789a f614jp = new C0789a() {
        /* renamed from: a */
        public void mo9346a(boolean z, int i, byte[] bArr, C0738f fVar) {
            C0738f fVar2;
            String str;
            C0738f fVar3;
            boolean z2 = z;
            int i2 = i;
            byte[] bArr2 = bArr;
            C0738f fVar4 = fVar;
            StringBuilder sb = new StringBuilder();
            sb.append("onFinish(), retCode: ");
            sb.append(i2);
            C0849fg.m914i("SharkNetwork", sb.toString());
            if (i2 != 0) {
                C0718dy.this.m462a(z2, i2, fVar4);
            } else if (bArr2 == null) {
                C0849fg.m912e("SharkNetwork", "onFinish() null == retData");
                C0718dy.this.m462a(z2, -21000005, fVar4);
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onFinish() retData.length: ");
                sb2.append(bArr2.length);
                C0849fg.m911d("SharkNetwork", sb2.toString());
                char c = 0;
                if (C0716dx.m437l(bArr)) {
                    int b = C0712dv.m412br().mo9321b(bArr2[0]);
                    if (b >= 0) {
                        synchronized (C0718dy.this.f605jg) {
                            fVar3 = (C0738f) C0718dy.this.f605jg.get(Integer.valueOf(b));
                        }
                        if (fVar3 != null) {
                            C0718dy.this.m463a(z, fVar3, 0, 0, null);
                        }
                    }
                } else {
                    try {
                        C0648ch j = C0699dp.m383j(bArr);
                        if (j == null) {
                            C0849fg.m912e("SharkNetwork", "onFinish() null == obj");
                            C0718dy.this.m462a(z2, -21000400, fVar4);
                            return;
                        }
                        C0648ch chVar = j;
                        ArrayList<C0647cg> arrayList = chVar.f392fF;
                        int i3 = chVar.f394fn;
                        if (C0718dy.this.f602jd != null && C0718dy.this.f602jd.f646jK == i3) {
                            fVar2 = C0718dy.this.f602jd;
                        } else if (C0718dy.this.f603je == null || C0718dy.this.f603je.f646jK != i3) {
                            synchronized (C0718dy.this.f605jg) {
                                fVar2 = (C0738f) C0718dy.this.f605jg.get(Integer.valueOf(i3));
                            }
                        } else {
                            fVar2 = C0718dy.this.f603je;
                        }
                        C0738f fVar5 = fVar2;
                        char c2 = 1;
                        if (arrayList != null) {
                            Iterator it = arrayList.iterator();
                            int i4 = 0;
                            while (it.hasNext()) {
                                C0647cg cgVar = (C0647cg) it.next();
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("[");
                                sb3.append(i4);
                                sb3.append("]收包：cmd id:[");
                                sb3.append(cgVar.f383dO);
                                sb3.append("]seqNo:[");
                                sb3.append(cgVar.f385fm);
                                sb3.append("]refSeqNo:[");
                                sb3.append(cgVar.f386fn);
                                sb3.append("]retCode:[");
                                sb3.append(cgVar.f388fq);
                                sb3.append("]dataRetCode:[");
                                sb3.append(cgVar.f389fr);
                                sb3.append("]");
                                C0849fg.m914i("SharkNetwork_CMDID", sb3.toString());
                                i4++;
                            }
                        }
                        if (arrayList == null) {
                            C0849fg.m912e("SharkNetwork", "onFinish() null == respSashimiList");
                            C0718dy.this.m463a(z, fVar5, -21000005, chVar.f393fm, null);
                            return;
                        }
                        C0718dy.m479c(arrayList);
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("onFinish() sharkSeq: ");
                        sb4.append(i3);
                        sb4.append(" ssTag: ");
                        sb4.append(fVar5);
                        sb4.append(" shark回包或push个数: ");
                        sb4.append(arrayList.size());
                        C0849fg.m911d("SharkNetwork", sb4.toString());
                        boolean a = C0718dy.this.m483d(arrayList);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("[rsa_key]onFinish() 密钥是否过期：");
                        sb5.append(a ? "是" : "否");
                        C0849fg.m914i("SharkNetwork", sb5.toString());
                        if (a) {
                            C0718dy.this.f607ji = true;
                            C0718dy.this.f617js.removeMessages(1);
                            C0718dy.this.f617js.sendEmptyMessageDelayed(1, 100);
                            return;
                        }
                        ArrayList a2 = C0718dy.this.m453a(fVar5, z2, chVar, arrayList);
                        if (a2 != null && a2.size() > 0) {
                            Iterator it2 = a2.iterator();
                            while (it2.hasNext()) {
                                C0647cg cgVar2 = (C0647cg) it2.next();
                                if (cgVar2 != null) {
                                    C0712dv br = C0712dv.m412br();
                                    int i5 = cgVar2.f383dO;
                                    int i6 = cgVar2.f386fn;
                                    if (bArr2 != null) {
                                        Object[] objArr = new Object[2];
                                        objArr[c] = Integer.valueOf(bArr2.length + 4);
                                        objArr[c2] = Integer.valueOf(arrayList.size());
                                        str = String.format("%d/%d", objArr);
                                    } else {
                                        str = null;
                                    }
                                    C0647cg cgVar3 = cgVar2;
                                    br.mo9319a("SharkNetwork", i5, i6, cgVar2, 17, i, str);
                                    C0790eg F = C0790eg.m716F(cgVar3.f386fn);
                                    if (F != null) {
                                        F.f845mh = String.valueOf(C0683dd.m265m(C0718dy.this.mContext));
                                        F.errorCode = cgVar3.f388fq;
                                        F.mo9462E(cgVar3.f383dO);
                                        F.mo9465f(C0718dy.this.f594hN);
                                    }
                                    c2 = 1;
                                    c = 0;
                                }
                            }
                        }
                        C0718dy.this.m463a(z, fVar5, 0, chVar.f393fm, a2);
                        C0718dy.this.m475bC();
                    } catch (Exception e) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("onFinish() e: ");
                        sb6.append(e.toString());
                        C0849fg.m912e("SharkNetwork", sb6.toString());
                        C0718dy.this.m462a(z2, -21000400, fVar4);
                    }
                }
            }
        }

        /* renamed from: b */
        public void mo9347b(boolean z, int i, C0738f fVar) {
            StringBuilder sb;
            String str = " retCode: ";
            String str2 = "onSendFailed(), isTcpChannel: ";
            String str3 = "SharkNetwork";
            if (fVar != null) {
                sb = new StringBuilder();
                sb.append(str2);
                sb.append(z);
                sb.append(str);
                sb.append(i);
                sb.append(" seqNo: ");
                sb.append(fVar.f646jK);
            } else {
                sb = new StringBuilder();
                sb.append(str2);
                sb.append(z);
                sb.append(str);
                sb.append(i);
            }
            C0849fg.m912e(str3, sb.toString());
            if (i != 0) {
                C0718dy.this.m462a(z, i, fVar);
            }
        }
    };
    /* renamed from: jq */
    private boolean f615jq = true;
    /* renamed from: jr */
    private boolean f616jr = true;
    /* access modifiers changed from: private */
    /* renamed from: js */
    public Handler f617js = new Handler(C0716dx.getLooper()) {
        /* renamed from: b */
        private void m524b(final boolean z, final C0738f fVar) {
            C0718dy.this.f606jh.submit(new Runnable() {
                public void run() {
                    C0684de deVar;
                    if (C0718dy.this.f601jc != null) {
                        if (!fVar.f642jG) {
                            synchronized (C0718dy.this.f601jc) {
                                C0684de deVar2 = (C0684de) C0718dy.this.f601jc.get(997);
                                if (deVar2 != null && !deVar2.mo9270aP()) {
                                    C0849fg.m916w("SharkNetwork", "[network_control] cloud cmd: fp donot connect, use http channel");
                                    fVar.f644jI = true;
                                }
                            }
                        }
                        ArrayList<C0636by> arrayList = fVar.f649jN;
                        if (arrayList != null && arrayList.size() > 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("[network_control] before control, sashimis.size(): ");
                            sb.append(arrayList.size());
                            C0849fg.m914i("SharkNetwork", sb.toString());
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                C0636by byVar = (C0636by) it.next();
                                if (byVar != null) {
                                    synchronized (C0718dy.this.f601jc) {
                                        deVar = (C0684de) C0718dy.this.f601jc.get(byVar.f357dO);
                                    }
                                    if (deVar != null) {
                                        if (deVar.mo9270aP()) {
                                            deVar.mo9271aQ();
                                        } else {
                                            it.remove();
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append("network ctrl donot connect, cmdid : ");
                                            sb2.append(byVar.f357dO);
                                            C0849fg.m914i("SharkNetwork", sb2.toString());
                                            StringBuilder sb3 = new StringBuilder();
                                            sb3.append("[network_control] cloud cmd: donot connect, cmdid : ");
                                            sb3.append(byVar.f357dO);
                                            C0849fg.m916w("SharkNetwork", sb3.toString());
                                            C0647cg cgVar = new C0647cg();
                                            cgVar.f383dO = byVar.f357dO;
                                            cgVar.f388fq = -7;
                                            C0718dy.this.m465a(true, false, fVar, -20000007, 0, cgVar);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    ArrayList<C0636by> arrayList2 = fVar.f649jN;
                    if (arrayList2 == null || arrayList2.size() <= 0) {
                        C0849fg.m916w("SharkNetwork", "[network_control] no sashimi can connect, control by cloud cmd!");
                        return;
                    }
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("[network_control] after control, sashimis.size(): ");
                    sb4.append(arrayList2.size());
                    C0849fg.m914i("SharkNetwork", sb4.toString());
                    try {
                        C0718dy.this.mo9328a(z, fVar);
                    } catch (Throwable th) {
                        C0849fg.m912e("SharkNetwork", th.toString());
                    }
                }
            });
        }

        /* JADX WARNING: Code restructure failed: missing block: B:33:0x013e, code lost:
            r5 = r0.iterator();
     */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0146, code lost:
            if (r5.hasNext() == false) goto L_0x01cc;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0148, code lost:
            r0 = (btmsdkobf.C0718dy.C0738f) r5.next();
     */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x014e, code lost:
            if (r0 != null) goto L_0x0151;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0157, code lost:
            if (btmsdkobf.C0718dy.m492l(r4.f623jv) == false) goto L_0x0166;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0159, code lost:
            btmsdkobf.C0849fg.m916w("SharkNetwork", "[rsa_key] MSG_SHARK_SEND, rsakey expired suddenly, handleOnNeedRsaKey()");
            btmsdkobf.C0718dy.m473b(r4.f623jv, true);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0165, code lost:
            return;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0168, code lost:
            if (r0.f641jF == false) goto L_0x016e;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x016a, code lost:
            m524b(false, r0);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x016e, code lost:
            m524b(true, r0);
     */
        public void handleMessage(android.os.Message r5) {
            /*
            r4 = this;
            int r0 = r5.what
            r1 = 2
            r2 = 1
            r3 = 0
            switch(r0) {
                case 0: goto L_0x0182;
                case 1: goto L_0x00b9;
                case 2: goto L_0x0099;
                case 3: goto L_0x007c;
                case 4: goto L_0x0070;
                case 5: goto L_0x005f;
                case 6: goto L_0x004d;
                case 7: goto L_0x003b;
                case 8: goto L_0x0029;
                case 9: goto L_0x0017;
                case 10: goto L_0x000a;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x01cc
        L_0x000a:
            btmsdkobf.dy r5 = btmsdkobf.C0718dy.this
            java.util.concurrent.ExecutorService r5 = r5.f606jh
            btmsdkobf.dy$4$5 r0 = new btmsdkobf.dy$4$5
            r0.m40669init()
            goto L_0x00b4
        L_0x0017:
            java.lang.String r5 = "SharkNetwork"
            java.lang.String r0 = "[cu_vid]deal msg: MSG_UPDATE_VID_IFNEED"
            btmsdkobf.C0849fg.m914i(r5, r0)
            btmsdkobf.dy r5 = btmsdkobf.C0718dy.this
            btmsdkobf.ek r5 = r5.f599ja
            r5.mo9486b(r3, r3)
            goto L_0x01cc
        L_0x0029:
            java.lang.String r5 = "SharkNetwork"
            java.lang.String r0 = "[cu_vid]deal msg: MSG_REGISTER_VID_IFNEED"
            btmsdkobf.C0849fg.m914i(r5, r0)
            btmsdkobf.dy r5 = btmsdkobf.C0718dy.this
            btmsdkobf.ek r5 = r5.f599ja
            r5.mo9485ap()
            goto L_0x01cc
        L_0x003b:
            java.lang.String r5 = "SharkNetwork"
            java.lang.String r0 = "[rsa_key]handle: MSG_REQUEST_SENDPROCESS_UPDATE_RSAKEY"
            btmsdkobf.C0849fg.m914i(r5, r0)
            btmsdkobf.dy r5 = btmsdkobf.C0718dy.this
            android.content.Context r5 = r5.mContext
            btmsdkobf.C0704ds.m399o(r5)
            goto L_0x01cc
        L_0x004d:
            java.lang.String r5 = "SharkNetwork"
            java.lang.String r0 = "[cu_guid]handle: MSG_REQUEST_SENDPROCESS_GET_GUID"
            btmsdkobf.C0849fg.m914i(r5, r0)
            btmsdkobf.dy r5 = btmsdkobf.C0718dy.this
            android.content.Context r5 = r5.mContext
            btmsdkobf.C0685df.m286n(r5)
            goto L_0x01cc
        L_0x005f:
            btmsdkobf.dy r5 = btmsdkobf.C0718dy.this
            android.content.Context r5 = r5.mContext
            btmsdkobf.dy r0 = btmsdkobf.C0718dy.this
            btmsdkobf.ds$b r0 = r0.mo9333ac()
            btmsdkobf.C0704ds.m396a(r5, r3, r0)
            goto L_0x01cc
        L_0x0070:
            btmsdkobf.dy r5 = btmsdkobf.C0718dy.this
            java.util.concurrent.ExecutorService r5 = r5.f606jh
            btmsdkobf.dy$4$4 r0 = new btmsdkobf.dy$4$4
            r0.m40668init()
            goto L_0x00b4
        L_0x007c:
            java.lang.String r5 = "SharkNetwork"
            java.lang.String r0 = "[cu_guid]MSG_SHARK_GET_GUID"
            btmsdkobf.C0849fg.m914i(r5, r0)
            btmsdkobf.dy r5 = btmsdkobf.C0718dy.this
            android.os.Handler r5 = r5.f617js
            r0 = 3
            r5.removeMessages(r0)
            btmsdkobf.dy r5 = btmsdkobf.C0718dy.this
            java.util.concurrent.ExecutorService r5 = r5.f606jh
            btmsdkobf.dy$4$3 r0 = new btmsdkobf.dy$4$3
            r0.m40666init()
            goto L_0x00b4
        L_0x0099:
            btmsdkobf.dy r5 = btmsdkobf.C0718dy.this
            android.os.Handler r5 = r5.f617js
            r5.removeMessages(r1)
            java.lang.String r5 = "SharkNetwork"
            java.lang.String r0 = "[rsa_key]msg: MSG_SHARK_UPDATE_RSAKEY"
            btmsdkobf.C0849fg.m914i(r5, r0)
            btmsdkobf.dy r5 = btmsdkobf.C0718dy.this
            java.util.concurrent.ExecutorService r5 = r5.f606jh
            btmsdkobf.dy$4$2 r0 = new btmsdkobf.dy$4$2
            r0.m40664init()
        L_0x00b4:
            r5.submit(r0)
            goto L_0x01cc
        L_0x00b9:
            java.lang.String r5 = "SharkNetwork"
            java.lang.String r0 = "MSG_SHARK_SEND"
            btmsdkobf.C0849fg.m914i(r5, r0)
            btmsdkobf.dy r5 = btmsdkobf.C0718dy.this
            android.os.Handler r5 = r5.f617js
            r5.removeMessages(r2)
            btmsdkobf.dy r5 = btmsdkobf.C0718dy.this
            btmsdkobf.ds r5 = r5.f597iY
            btmsdkobf.ds$b r5 = r5.mo9308ac()
            java.lang.String r0 = r5.f550il
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0175
            java.lang.String r5 = r5.f551im
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L_0x00e5
            goto L_0x0175
        L_0x00e5:
            btmsdkobf.dy r5 = btmsdkobf.C0718dy.this
            boolean r5 = r5.f607ji
            if (r5 == 0) goto L_0x00fa
            java.lang.String r5 = "SharkNetwork"
            java.lang.String r0 = "[rsa_key] MSG_SHARK_SEND, rsakey expired, handleOnNeedRsaKey()"
            btmsdkobf.C0849fg.m916w(r5, r0)
            btmsdkobf.dy r5 = btmsdkobf.C0718dy.this
            r5.m501x(r2)
            return
        L_0x00fa:
            btmsdkobf.dy r5 = btmsdkobf.C0718dy.this
            btmsdkobf.df r5 = r5.f598iZ
            boolean r5 = r5.mo9275aS()
            if (r5 == 0) goto L_0x0113
            java.lang.String r5 = "SharkNetwork"
            java.lang.String r0 = "[cu_guid] MSG_SHARK_SEND, without guid, handleOnNeedGuid()"
            btmsdkobf.C0849fg.m916w(r5, r0)
            btmsdkobf.dy r5 = btmsdkobf.C0718dy.this
            r5.m474bA()
            return
        L_0x0113:
            btmsdkobf.dy r5 = btmsdkobf.C0718dy.this
            java.util.ArrayList r5 = r5.f604jf
            monitor-enter(r5)
            btmsdkobf.dy r0 = btmsdkobf.C0718dy.this     // Catch:{ all -> 0x0172 }
            java.util.ArrayList r0 = r0.f604jf     // Catch:{ all -> 0x0172 }
            int r0 = r0.size()     // Catch:{ all -> 0x0172 }
            if (r0 > 0) goto L_0x0128
            monitor-exit(r5)     // Catch:{ all -> 0x0172 }
            return
        L_0x0128:
            btmsdkobf.dy r0 = btmsdkobf.C0718dy.this     // Catch:{ all -> 0x0172 }
            java.util.ArrayList r0 = r0.f604jf     // Catch:{ all -> 0x0172 }
            java.lang.Object r0 = r0.clone()     // Catch:{ all -> 0x0172 }
            java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch:{ all -> 0x0172 }
            btmsdkobf.dy r1 = btmsdkobf.C0718dy.this     // Catch:{ all -> 0x0172 }
            java.util.ArrayList r1 = r1.f604jf     // Catch:{ all -> 0x0172 }
            r1.clear()     // Catch:{ all -> 0x0172 }
            monitor-exit(r5)     // Catch:{ all -> 0x0172 }
            java.util.Iterator r5 = r0.iterator()
        L_0x0142:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x01cc
            java.lang.Object r0 = r5.next()
            btmsdkobf.dy$f r0 = (btmsdkobf.C0718dy.C0738f) r0
            if (r0 != 0) goto L_0x0151
            goto L_0x0142
        L_0x0151:
            btmsdkobf.dy r1 = btmsdkobf.C0718dy.this
            boolean r1 = r1.f607ji
            if (r1 == 0) goto L_0x0166
            java.lang.String r5 = "SharkNetwork"
            java.lang.String r0 = "[rsa_key] MSG_SHARK_SEND, rsakey expired suddenly, handleOnNeedRsaKey()"
            btmsdkobf.C0849fg.m916w(r5, r0)
            btmsdkobf.dy r5 = btmsdkobf.C0718dy.this
            r5.m501x(r2)
            return
        L_0x0166:
            boolean r1 = r0.f641jF
            if (r1 == 0) goto L_0x016e
            r4.m524b(r3, r0)
            goto L_0x0142
        L_0x016e:
            r4.m524b(r2, r0)
            goto L_0x0142
        L_0x0172:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0172 }
            throw r0
        L_0x0175:
            java.lang.String r5 = "SharkNetwork"
            java.lang.String r0 = "[rsa_key] MSG_SHARK_SEND, without rsakey, handleOnNeedRsaKey()"
            btmsdkobf.C0849fg.m916w(r5, r0)
            btmsdkobf.dy r5 = btmsdkobf.C0718dy.this
            r5.m501x(r3)
            return
        L_0x0182:
            btmsdkobf.dy r0 = btmsdkobf.C0718dy.this
            android.os.Handler r0 = r0.f617js
            r0.removeMessages(r3)
            btmsdkobf.dy r0 = btmsdkobf.C0718dy.this
            btmsdkobf.dy$f r0 = r0.f602jd
            if (r0 == 0) goto L_0x01a8
            int r0 = r5.arg1
            if (r0 != r2) goto L_0x01a8
            java.lang.String r5 = "SharkNetwork"
            java.lang.String r0 = "MSG_SHARK_SEND_VIP mSharkSendRsa"
            btmsdkobf.C0849fg.m914i(r5, r0)
            btmsdkobf.dy r5 = btmsdkobf.C0718dy.this
            btmsdkobf.dy$f r5 = r5.f602jd
            r4.m524b(r3, r5)
            goto L_0x01cc
        L_0x01a8:
            btmsdkobf.dy r0 = btmsdkobf.C0718dy.this
            btmsdkobf.dy$f r0 = r0.f603je
            if (r0 == 0) goto L_0x01c5
            int r5 = r5.arg1
            if (r5 != r1) goto L_0x01c5
            java.lang.String r5 = "SharkNetwork"
            java.lang.String r0 = "MSG_SHARK_SEND_VIP mSharkSendGuid"
            btmsdkobf.C0849fg.m914i(r5, r0)
            btmsdkobf.dy r5 = btmsdkobf.C0718dy.this
            btmsdkobf.dy$f r5 = r5.f603je
            r4.m524b(r2, r5)
            goto L_0x01cc
        L_0x01c5:
            java.lang.String r5 = "SharkNetwork"
            java.lang.String r0 = "MSG_SHARK_SEND_VIP null"
            btmsdkobf.C0849fg.m912e(r5, r0)
        L_0x01cc:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0718dy.C07224.handleMessage(android.os.Message):void");
        }
    };
    /* renamed from: jt */
    private long f618jt = 0;
    /* renamed from: ju */
    private Handler f619ju = new Handler(C0716dx.getLooper()) {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                C0718dy.this.m471b((C0738f) message.obj);
            }
        }
    };
    /* access modifiers changed from: private */
    public Context mContext;

    /* renamed from: btmsdkobf.dy$a */
    interface C0733a {
        /* renamed from: a */
        void mo9348a(int i, C0707b bVar);
    }

    /* renamed from: btmsdkobf.dy$b */
    public interface C0734b {
        /* renamed from: a */
        void mo9278a(boolean z, int i, int i2, ArrayList<C0647cg> arrayList);
    }

    /* renamed from: btmsdkobf.dy$c */
    public interface C0735c {
        /* renamed from: a */
        long mo9357a(boolean z, int i, C0647cg cgVar);

        /* renamed from: b */
        long mo9358b(boolean z, int i, C0647cg cgVar);
    }

    /* renamed from: btmsdkobf.dy$d */
    public interface C0736d {
        /* renamed from: a */
        void mo9359a(long j, int i, JceStruct jceStruct, int i2, C0696dm dmVar, boolean z);
    }

    /* renamed from: btmsdkobf.dy$e */
    public interface C0737e {
        /* renamed from: a */
        void mo9360a(C0691dh dhVar);

        /* renamed from: a */
        void mo9361a(C0733a aVar);

        /* renamed from: b */
        void mo9362b(C0691dh dhVar);

        /* renamed from: b */
        void mo9363b(C0733a aVar);
    }

    /* renamed from: btmsdkobf.dy$f */
    public static class C0738f {
        /* renamed from: jB */
        public int f637jB = 0;
        /* renamed from: jC */
        public boolean f638jC = false;
        /* renamed from: jD */
        public boolean f639jD = false;
        /* renamed from: jE */
        public boolean f640jE = false;
        /* renamed from: jF */
        public boolean f641jF = false;
        /* renamed from: jG */
        public boolean f642jG = false;
        /* renamed from: jH */
        public boolean f643jH = false;
        /* renamed from: jI */
        public boolean f644jI = false;
        /* renamed from: jJ */
        public boolean f645jJ = false;
        /* renamed from: jK */
        public int f646jK;
        /* renamed from: jL */
        public C0707b f647jL;
        /* renamed from: jM */
        public long f648jM;
        /* renamed from: jN */
        public ArrayList<C0636by> f649jN;
        /* renamed from: jO */
        public C0734b f650jO;
        /* renamed from: jP */
        public long f651jP = System.currentTimeMillis();
        /* renamed from: jQ */
        public boolean f652jQ = false;
        /* renamed from: jR */
        public byte f653jR = 0;
        /* renamed from: jS */
        public long f654jS = -1;

        public C0738f(int i, boolean z, boolean z2, boolean z3, long j, ArrayList<C0636by> arrayList, C0734b bVar, long j2) {
            this.f637jB = i;
            this.f638jC = z;
            this.f641jF = z2;
            this.f642jG = z3;
            this.f648jM = j;
            this.f649jN = arrayList;
            this.f650jO = bVar;
            this.f646jK = C0709du.m407bo().mo9293bf();
            this.f654jS = j2;
        }

        /* renamed from: bJ */
        public boolean mo9364bJ() {
            long abs = Math.abs(System.currentTimeMillis() - this.f651jP);
            boolean z = abs >= 30000;
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append("[ocean][time_out]SharkNetwork.SharkSend.isTimeOut(), SharkSend.seqNoTag: ");
                sb.append(this.f646jK);
                sb.append(" time(s): ");
                sb.append(abs / 1000);
                String sb2 = sb.toString();
                String str = ESharkCode.SHARK_OCEAN;
                C0849fg.m912e(str, sb2);
                ArrayList<C0636by> arrayList = this.f649jN;
                if (arrayList != null) {
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        C0636by byVar = (C0636by) this.f649jN.get(i);
                        if (byVar != null) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("[ocean][time_out]SharkNetwork.SharkSend.isTimeOut(), cmdId|");
                            sb3.append(byVar.f357dO);
                            sb3.append("|seqNo|");
                            sb3.append(byVar.f358fm);
                            C0849fg.m912e(str, sb3.toString());
                        }
                    }
                }
            }
            return z;
        }

        /* renamed from: bK */
        public boolean mo9365bK() {
            return this.f641jF || this.f642jG;
        }

        /* renamed from: bL */
        public boolean mo9366bL() {
            return this.f638jC;
        }
    }

    public C0718dy(Context context, C0695dl dlVar, C0737e eVar, C0735c cVar, C0736d dVar, boolean z, String str) {
        Context context2 = context;
        C0736d dVar2 = dVar;
        boolean z2 = z;
        StringBuilder sb = new StringBuilder();
        sb.append("[shark_init]SharkNetwork() isTest: ");
        sb.append(z2);
        sb.append(" serverAdd: ");
        String str2 = str;
        sb.append(str2);
        C0849fg.m914i("SharkNetwork", sb.toString());
        this.mContext = context2;
        C0695dl dlVar2 = dlVar;
        this.f594hN = dlVar2;
        this.f600jb = eVar;
        this.f613jo = cVar;
        this.f597iY = new C0704ds(context, this);
        this.f598iZ = new C0685df(context, this, z2);
        this.f599ja = new C0802ek(context, this, z2);
        this.f606jh = Executors.newSingleThreadExecutor();
        C0786ef efVar = new C0786ef(this.f594hN.mo9234ar(), context2, dlVar2, z2, this.f614jp, this, dVar, this, str2);
        this.f596iX = efVar;
        if (this.f594hN.mo9234ar()) {
            m456a(dVar2);
            this.f599ja.mo9487c(dVar2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public C0801ej<Long, Integer, JceStruct> m449a(long j, int i, C0619bh bhVar) {
        String str = "SharkNetwork";
        if (bhVar == null) {
            C0849fg.m916w(str, "[ip_list]handleHIPList(), scHIPList == null");
            return null;
        }
        C0814ep ck = this.f596iX.mo9460ck();
        if (ck != null) {
            ck.mo9280a(j, i, bhVar);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[ip_list]report push status, |pushId=");
        sb.append(j);
        C0849fg.m911d(str, sb.toString());
        C0615bd bdVar = new C0615bd();
        bdVar.f191cy = bhVar.f207cy;
        return new C0801ej<>(Long.valueOf(j), Integer.valueOf(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL), bdVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public C0801ej<Long, Integer, JceStruct> m450a(long j, int i, C0641ca caVar) {
        String str = "SharkNetwork";
        if (caVar == null) {
            C0849fg.m916w(str, "[cu_guid_p]handlePushRefreshGuid(), scPushRefreshGuid == null");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[cu_guid_p]handlePushRefreshGuid(), |pushId=");
        sb.append(j);
        sb.append("|serverShasimiSeqNo=");
        sb.append(i);
        C0849fg.m915v(str, sb.toString());
        this.f598iZ.mo9273a(true, caVar.f375fh);
        return null;
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final ArrayList<C0647cg> m453a(C0738f fVar, boolean z, C0648ch chVar, ArrayList<C0647cg> arrayList) {
        if (arrayList == null) {
            return null;
        }
        ArrayList<C0647cg> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            C0647cg cgVar = (C0647cg) arrayList.get(i);
            if (cgVar != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("checkFilterList(), rs.refSeqNo: ");
                sb.append(cgVar.f386fn);
                sb.append(" rs.cmd: ");
                sb.append(cgVar.f383dO);
                sb.append(" rs.retCode: ");
                sb.append(cgVar.f388fq);
                sb.append(" rs.dataRetCode: ");
                sb.append(cgVar.f389fr);
                sb.append(" rs.data.length: ");
                sb.append(cgVar.f387fo != null ? cgVar.f387fo.length : 0);
                C0849fg.m914i("SharkNetwork", sb.toString());
                if (!m469a(z, chVar, cgVar)) {
                    arrayList2.add(cgVar);
                }
            }
        }
        return arrayList2;
    }

    /* renamed from: a */
    private void m456a(C0736d dVar) {
        C0736d dVar2 = dVar;
        C07316 r6 = new C0696dm() {
            /* renamed from: a */
            public C0801ej<Long, Integer, JceStruct> mo9297a(int i, long j, int i2, JceStruct jceStruct) {
                if (jceStruct == null) {
                    C0849fg.m912e("SharkNetwork", "[ip_list][cu_guid_p]onRecvPush() null == push");
                    return null;
                } else if (i2 == 10155) {
                    return C0718dy.this.m449a(j, i, (C0619bh) jceStruct);
                } else {
                    if (i2 != 15081) {
                        return null;
                    }
                    return C0718dy.this.m450a(j, i, (C0641ca) jceStruct);
                }
            }
        };
        dVar2.mo9359a(0, 10155, new C0619bh(), 0, r6, false);
        dVar2.mo9359a(0, 15081, new C0641ca(), 0, r6, false);
        C0849fg.m914i("SharkNetwork", "[ip_list][cu_guid_p]registerSharkPush, Cmd_SCHIPList,Cmd_SCPushRefreshGuid: 10155,15081");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00da A[LOOP:0: B:22:0x00d4->B:24:0x00da, LOOP_END] */
    /* renamed from: a */
    public void m462a(boolean r8, int r9, btmsdkobf.C0718dy.C0738f r10) {
        /*
        r7 = this;
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = "runError(), ret = "
        r0.append(r1)
        r0.append(r9)
        java.lang.String r1 = " isTcpChannel: "
        r0.append(r1)
        r0.append(r8)
        java.lang.String r0 = r0.toString()
        java.lang.String r1 = "SharkNetwork"
        btmsdkobf.C0849fg.m914i(r1, r0)
        if (r10 != 0) goto L_0x0028
        java.lang.String r8 = "SharkNetwork"
        java.lang.String r9 = "runError(), failedSharkSend == null"
        btmsdkobf.C0849fg.m916w(r8, r9)
        return
    L_0x0028:
        java.util.ArrayList r0 = new java.util.ArrayList
        r0.<init>()
        btmsdkobf.dy$f r1 = r7.f602jd
        if (r1 == 0) goto L_0x004b
        int r1 = r1.f646jK
        int r2 = r10.f646jK
        if (r1 != r2) goto L_0x004b
        java.lang.String r10 = "SharkNetwork"
        java.lang.String r1 = "runError(), updating rsa, only callback rsa"
        btmsdkobf.C0849fg.m914i(r10, r1)
        btmsdkobf.dy$f r10 = r7.f602jd
        r0.add(r10)
        btmsdkobf.dy$f r10 = r7.f602jd
    L_0x0045:
        int r10 = r10.f646jK
        r7.m500x(r10)
        goto L_0x00ae
    L_0x004b:
        btmsdkobf.dy$f r1 = r7.f603je
        if (r1 == 0) goto L_0x0064
        int r1 = r1.f646jK
        int r2 = r10.f646jK
        if (r1 != r2) goto L_0x0064
        java.lang.String r10 = "SharkNetwork"
        java.lang.String r1 = "runError(), updating guid, only callback guid"
        btmsdkobf.C0849fg.m914i(r10, r1)
        btmsdkobf.dy$f r10 = r7.f603je
        r0.add(r10)
        btmsdkobf.dy$f r10 = r7.f603je
        goto L_0x0045
    L_0x0064:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r2 = "runError(), call back failed for this seqNo: "
        r1.append(r2)
        int r2 = r10.f646jK
        r1.append(r2)
        java.lang.String r1 = r1.toString()
        java.lang.String r2 = "SharkNetwork"
        btmsdkobf.C0849fg.m914i(r2, r1)
        r0.add(r10)
        int r10 = r10.f646jK
        r7.m500x(r10)
        java.util.ArrayList<btmsdkobf.dy$f> r10 = r7.f604jf
        monitor-enter(r10)
        java.lang.String r1 = "SharkNetwork"
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00eb }
        r2.<init>()     // Catch:{ all -> 0x00eb }
        java.lang.String r3 = "runError(), callback failed for mSharkQueueWaiting, size(): "
        r2.append(r3)     // Catch:{ all -> 0x00eb }
        java.util.ArrayList<btmsdkobf.dy$f> r3 = r7.f604jf     // Catch:{ all -> 0x00eb }
        int r3 = r3.size()     // Catch:{ all -> 0x00eb }
        r2.append(r3)     // Catch:{ all -> 0x00eb }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00eb }
        btmsdkobf.C0849fg.m911d(r1, r2)     // Catch:{ all -> 0x00eb }
        java.util.ArrayList<btmsdkobf.dy$f> r1 = r7.f604jf     // Catch:{ all -> 0x00eb }
        r0.addAll(r1)     // Catch:{ all -> 0x00eb }
        java.util.ArrayList<btmsdkobf.dy$f> r1 = r7.f604jf     // Catch:{ all -> 0x00eb }
        r1.clear()     // Catch:{ all -> 0x00eb }
        monitor-exit(r10)     // Catch:{ all -> 0x00eb }
    L_0x00ae:
        java.lang.StringBuilder r10 = new java.lang.StringBuilder
        r10.<init>()
        java.lang.String r1 = "runError(), callback error, ret: "
        r10.append(r1)
        r10.append(r9)
        java.lang.String r1 = " values.size(): "
        r10.append(r1)
        int r1 = r0.size()
        r10.append(r1)
        java.lang.String r10 = r10.toString()
        java.lang.String r1 = "SharkNetwork"
        btmsdkobf.C0849fg.m914i(r1, r10)
        java.util.Iterator r10 = r0.iterator()
    L_0x00d4:
        boolean r0 = r10.hasNext()
        if (r0 == 0) goto L_0x00ea
        java.lang.Object r0 = r10.next()
        r3 = r0
        btmsdkobf.dy$f r3 = (btmsdkobf.C0718dy.C0738f) r3
        r5 = 0
        r6 = 0
        r1 = r7
        r2 = r8
        r4 = r9
        r1.m463a(r2, r3, r4, r5, r6)
        goto L_0x00d4
    L_0x00ea:
        return
    L_0x00eb:
        r8 = move-exception
        monitor-exit(r10)     // Catch:{ all -> 0x00eb }
        throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0718dy.m462a(boolean, int, btmsdkobf.dy$f):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m463a(boolean z, C0738f fVar, int i, int i2, ArrayList<C0647cg> arrayList) {
        m466a(false, z, fVar, i, i2, arrayList);
    }

    /* renamed from: a */
    private void m464a(boolean z, boolean z2, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("onSharkVipError(), retCode = ");
        sb.append(i);
        sb.append(" 事件： ");
        sb.append(z2 ? "交换密钥" : "注册guid");
        C0849fg.m911d("SharkNetwork", sb.toString());
        ArrayList arrayList = new ArrayList();
        synchronized (this.f605jg) {
            String str = "SharkNetwork";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onSharkVipError(), callback failed for all sending: ");
            sb2.append(this.f605jg.keySet());
            C0849fg.m911d(str, sb2.toString());
            arrayList.addAll(this.f605jg.values());
            this.f605jg.clear();
        }
        synchronized (this.f604jf) {
            String str2 = "SharkNetwork";
            StringBuilder sb3 = new StringBuilder();
            sb3.append("onSharkVipError(), callback failed for mSharkQueueWaiting, size(): ");
            sb3.append(this.f604jf.size());
            C0849fg.m911d(str2, sb3.toString());
            arrayList.addAll(this.f604jf);
            this.f604jf.clear();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            m463a(z, (C0738f) it.next(), i, 0, null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m465a(boolean z, boolean z2, C0738f fVar, int i, int i2, C0647cg cgVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(cgVar);
        m466a(z, z2, fVar, i, i2, arrayList);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
            if (r3.f649jN.size() > 0) goto L_0x0015;
     */
    /* renamed from: a */
    private void m466a(boolean r1, boolean r2, btmsdkobf.C0718dy.C0738f r3, int r4, int r5, java.util.ArrayList<btmsdkobf.C0647cg> r6) {
        /*
        r0 = this;
        if (r3 == 0) goto L_0x0023
        if (r1 == 0) goto L_0x0010
        java.util.ArrayList<btmsdkobf.by> r1 = r3.f649jN     // Catch:{ Exception -> 0x001b }
        if (r1 == 0) goto L_0x0010
        java.util.ArrayList<btmsdkobf.by> r1 = r3.f649jN     // Catch:{ Exception -> 0x001b }
        int r1 = r1.size()     // Catch:{ Exception -> 0x001b }
        if (r1 > 0) goto L_0x0015
    L_0x0010:
        int r1 = r3.f646jK     // Catch:{ Exception -> 0x001b }
        r0.m500x(r1)     // Catch:{ Exception -> 0x001b }
    L_0x0015:
        btmsdkobf.dy$b r1 = r3.f650jO     // Catch:{ Exception -> 0x001b }
        r1.mo9278a(r2, r4, r5, r6)     // Catch:{ Exception -> 0x001b }
        goto L_0x0023
    L_0x001b:
        r1 = move-exception
        java.lang.String r2 = "SharkNetwork"
        java.lang.String r3 = "runError() callback crash"
        btmsdkobf.C0849fg.m913e(r2, r3, r1)
    L_0x0023:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0718dy.m466a(boolean, boolean, btmsdkobf.dy$f, int, int, java.util.ArrayList):void");
    }

    /* renamed from: a */
    private boolean m469a(boolean z, C0648ch chVar, C0647cg cgVar) {
        boolean z2;
        StringBuilder sb;
        StringBuilder sb2;
        boolean z3 = z;
        C0648ch chVar2 = chVar;
        C0647cg cgVar2 = cgVar;
        if (cgVar2 == null) {
            return false;
        }
        boolean b = C0759eb.m590b(cgVar);
        String str = ESharkCode.SHARK_OCEAN;
        String str2 = "|pushId|";
        String str3 = "";
        String str4 = "|ret|";
        String str5 = "|refSeqNo|";
        String str6 = "|seqNo|";
        String str7 = "|ECmd|";
        String str8 = "sharkSeqNo|";
        String str9 = "tcp|";
        String str10 = "http|";
        String str11 = "[ocean]guid|";
        if (b) {
            this.f613jo.mo9357a(z3, chVar2.f393fm, cgVar2);
            sb = new StringBuilder();
            sb.append(str11);
            sb.append(this.f598iZ.getGuid());
            sb.append("|push|通道|");
            if (!z3) {
                str9 = str10;
            }
            sb.append(str9);
            sb.append(str8);
            sb.append(chVar2.f393fm);
            sb.append(str7);
            sb.append(cgVar2.f383dO);
            sb.append(str6);
            sb.append(cgVar2.f385fm);
            sb.append(str5);
            sb.append(cgVar2.f386fn);
            sb.append(str4);
            sb.append(0);
            if (cgVar2.f384fD != null) {
                sb2 = new StringBuilder();
            }
            sb.append(str3);
            C0849fg.m914i(str, sb.toString());
            z2 = true;
            return z2;
        } else if (C0759eb.m592c(cgVar)) {
            this.f613jo.mo9358b(z3, chVar2.f393fm, cgVar2);
            sb = new StringBuilder();
            sb.append(str11);
            sb.append(this.f598iZ.getGuid());
            sb.append("|gift|通道|");
            if (!z3) {
                str9 = str10;
            }
            sb.append(str9);
            sb.append(str8);
            sb.append(chVar2.f393fm);
            sb.append(str7);
            sb.append(cgVar2.f383dO);
            sb.append(str6);
            sb.append(cgVar2.f385fm);
            sb.append(str5);
            sb.append(cgVar2.f386fn);
            sb.append(str4);
            sb.append(0);
            if (cgVar2.f384fD != null) {
                sb2 = new StringBuilder();
            }
            sb.append(str3);
            C0849fg.m914i(str, sb.toString());
            z2 = true;
            return z2;
        } else {
            z2 = false;
            return z2;
        }
        sb2.append(str2);
        sb2.append(cgVar2.f384fD.f380fl);
        str3 = sb2.toString();
        sb.append(str3);
        C0849fg.m914i(str, sb.toString());
        z2 = true;
        return z2;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m471b(final C0738f fVar) {
        if (fVar != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("runTimeout(), will check timeout for sharkSend with seqNoTag: ");
            sb.append(fVar.f646jK);
            C0849fg.m911d("SharkNetwork", sb.toString());
            this.f619ju.removeMessages(1, fVar);
            C0845fd.m898cN().addTask(new Runnable() {
                public void run() {
                    C0738f c = C0718dy.this.m500x(fVar.f646jK);
                    if (c != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("runTimeout(), sharkSend.seqNoTag: ");
                        sb.append(fVar.f646jK);
                        sb.append(" isSent: ");
                        sb.append(fVar.f652jQ);
                        C0849fg.m914i("SharkNetwork", sb.toString());
                        C0718dy.this.m463a(fVar.f643jH, c, c.f652jQ ? -21050000 : -21000020, 0, null);
                    }
                }
            }, "runTimeout");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bA */
    public void m474bA() {
        m499w(4);
        if (C0716dx.m429as()) {
            C0849fg.m914i("SharkNetwork", "[cu_guid] handleOnNeedGuid(), isSemiSendProcess, no guid, regGuidListener() & requestSendProcessRegisterGuid()");
            C07202 r0 = new C0691dh() {
                /* renamed from: b */
                public void mo9292b(int i, String str) {
                    C0849fg.m914i("SharkNetwork", "[cu_guid] IGuidCallback.onCallback(), unregGuidListener(this) and call onGuidRegisterResult(errCode)");
                    if (C0718dy.this.f600jb != null) {
                        C0718dy.this.f600jb.mo9362b((C0691dh) this);
                    }
                    C0718dy.this.m502y(i);
                }
            };
            C0737e eVar = this.f600jb;
            if (eVar != null) {
                eVar.mo9360a((C0691dh) r0);
            }
            long j = 2000;
            if (this.f615jq) {
                this.f615jq = false;
                j = 0;
            }
            this.f617js.removeMessages(6);
            this.f617js.sendEmptyMessageDelayed(6, j);
            return;
        }
        mo9335bB();
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* renamed from: bC */
    public synchronized void m475bC() {
        if (this.f594hN.mo9234ar()) {
            if (this.f618jt == 0 || System.currentTimeMillis() - this.f618jt > 300000) {
                this.f618jt = System.currentTimeMillis();
                this.f617js.removeMessages(8);
                this.f617js.sendEmptyMessage(8);
                C0849fg.m914i("SharkNetwork", "[cu_vid]triggerRegVidIfNeed(), send msg: MSG_REGISTER_VID_IFNEED in 5s");
            }
        }
    }

    /* renamed from: c */
    private void m478c(C0738f fVar) {
        String str = "SharkNetwork";
        if (fVar == null || fVar.f649jN == null || fVar.f647jL == null || fVar.f647jL.f551im == null) {
            C0849fg.m912e(str, "[rsa_key]revertClientSashimiData() something null");
            return;
        }
        Iterator it = fVar.f649jN.iterator();
        while (it.hasNext()) {
            C0636by byVar = (C0636by) it.next();
            if (byVar != null) {
                if (byVar.f360fo != null) {
                    if ((byVar.f365ft & 2) == 0) {
                        byVar.f360fo = C0683dd.decrypt(byVar.f360fo, fVar.f647jL.f551im.getBytes());
                    }
                    if (byVar.f360fo != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("[rsa_key]revertClientSashimiData(), revert succ, cmd: ");
                        sb.append(byVar.f357dO);
                        sb.append(" len: ");
                        sb.append(byVar.f360fo.length);
                        C0849fg.m911d(str, sb.toString());
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("[rsa_key]revertClientSashimiData(), revert failed, cmd: ");
                        sb2.append(byVar.f357dO);
                        C0849fg.m912e(str, sb2.toString());
                    }
                    C0712dv.m412br().mo9316a("SharkNetwork", byVar.f357dO, byVar.f358fm, byVar, 13);
                }
            }
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: c */
    public static void m479c(ArrayList<C0647cg> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C0647cg cgVar = (C0647cg) it.next();
                if (cgVar != null) {
                    if (cgVar.f388fq == 3) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("[shark_v4][shark_fin]mazu said need sharkfin, cmdId: ");
                        sb.append(cgVar.f383dO);
                        sb.append(" ClientSashimi.seqNo: ");
                        sb.append(cgVar.f386fn);
                        sb.append(" ServerSashimi.seqNo: ");
                        sb.append(cgVar.f385fm);
                        C0849fg.m914i("SharkNetwork", sb.toString());
                        C0683dd.m257aN();
                        return;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public boolean m483d(ArrayList<C0647cg> arrayList) {
        if (arrayList == null || arrayList.size() != 1) {
            return false;
        }
        C0647cg cgVar = (C0647cg) arrayList.get(0);
        if (cgVar == null) {
            return false;
        }
        return 2 == cgVar.f388fq;
    }

    /* renamed from: w */
    private void m499w(int i) {
        ArrayList arrayList;
        synchronized (this.f604jf) {
            arrayList = (ArrayList) this.f604jf.clone();
        }
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C0738f fVar = (C0738f) it.next();
                if (!(fVar == null || fVar.f649jN == null)) {
                    if (fVar.f649jN.size() > 0) {
                        Iterator it2 = fVar.f649jN.iterator();
                        while (it2.hasNext()) {
                            C0636by byVar = (C0636by) it2.next();
                            if (byVar != null) {
                                C0712dv.m412br().mo9316a("SharkNetwork", byVar.f357dO, byVar.f358fm, byVar, i);
                            }
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public C0738f m500x(int i) {
        C0738f fVar;
        StringBuilder sb = new StringBuilder();
        sb.append("removeSendingBySeqNoTag() seqNoTag: ");
        sb.append(i);
        C0849fg.m911d("SharkNetwork", sb.toString());
        synchronized (this.f605jg) {
            fVar = (C0738f) this.f605jg.remove(Integer.valueOf(i));
        }
        return fVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public void m501x(boolean z) {
        m499w(z ? 3 : 2);
        long j = 0;
        int i = 0;
        String str = "SharkNetwork";
        if (C0716dx.m429as()) {
            C0849fg.m915v(str, "[rsa_key] handleOnNeedRsaKey(), isSemiSendProcess, regRsaKeyListener() & requestSendProcessUpdateRsaKey()");
            C07213 r9 = new C0733a() {
                /* renamed from: a */
                public void mo9348a(int i, C0707b bVar) {
                    C0849fg.m914i("SharkNetwork", "[rsa_key] IRsaKeyListener.onCallback(), isSemiSendProcess, unregRsaKeyListener(this) and call onRsaKeyUpdated(errCode)");
                    if (C0718dy.this.f600jb != null) {
                        C0718dy.this.f600jb.mo9363b((C0733a) this);
                    }
                    C0718dy.this.m503z(i);
                }
            };
            C0737e eVar = this.f600jb;
            if (eVar != null) {
                eVar.mo9361a((C0733a) r9);
            }
            if (this.f616jr) {
                this.f616jr = false;
            } else {
                j = 2000;
            }
            this.f617js.removeMessages(7);
            this.f617js.sendEmptyMessageDelayed(7, j);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[rsa_key] handleOnNeedRsaKey(), isSendProcess, triggerUpdateRsaKey() in(ms) ");
        if (z) {
            i = 2000;
        }
        sb.append(i);
        C0849fg.m915v(str, sb.toString());
        if (z) {
            j = 2000;
        }
        mo9343e(j);
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public void m502y(int i) {
        if (i == 0) {
            this.f617js.sendEmptyMessage(1);
            return;
        }
        int abs = i > 0 ? Math.abs(ESharkCode.ERR_FOR_GUID_FAILED) + i : ESharkCode.ERR_FOR_GUID_FAILED + i;
        StringBuilder sb = new StringBuilder();
        sb.append("[cu_guid] onGuidRegisterResult(), guid failed, call onSharkVipError(), ");
        sb.append(abs);
        C0849fg.m914i("SharkNetwork", sb.toString());
        m464a(false, false, abs);
    }

    /* access modifiers changed from: private */
    /* renamed from: z */
    public void m503z(int i) {
        if (i == 0) {
            this.f608jj = System.currentTimeMillis();
            this.f607ji = false;
            synchronized (this.f595hO) {
                if (this.f610jl) {
                    C0849fg.m916w("SharkNetwork", "[cu_guid] onRsaKeyUpdateResult(), update rsa succ, allow register guid!");
                    this.f610jl = false;
                }
            }
            ArrayList<C0738f> arrayList = new ArrayList<>();
            synchronized (this.f605jg) {
                if (this.f605jg.size() > 0) {
                    for (C0738f fVar : this.f605jg.values()) {
                        if (fVar.f639jD || fVar.f640jE) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("[cu_guid][cu_guid] onRsaKeyUpdateResult(), rsa or guid, should not revert and resend after rsa updated, rsa?");
                            sb.append(fVar.f639jD);
                            sb.append(" guid?");
                            sb.append(fVar.f640jE);
                            C0849fg.m914i("SharkNetwork", sb.toString());
                        } else {
                            arrayList.add(fVar);
                        }
                    }
                    this.f605jg.clear();
                }
            }
            if (arrayList.size() > 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[cu_guid] onRsaKeyUpdateResult(), rsa succ, revert and resend data, size: ");
                sb2.append(arrayList.size());
                C0849fg.m914i("SharkNetwork", sb2.toString());
                for (C0738f c : arrayList) {
                    m478c(c);
                }
                synchronized (this.f604jf) {
                    this.f604jf.addAll(arrayList);
                }
            } else {
                C0849fg.m914i("SharkNetwork", "[cu_guid] onRsaKeyUpdateResult(), rsa succ, no need to revert and resend data");
            }
            C0849fg.m914i("SharkNetwork", "[cu_guid] onRsaKeyUpdateResult(), rsa succ, send MSG_SHARK_SEND");
            this.f617js.sendEmptyMessage(1);
            return;
        }
        int abs = i > 0 ? Math.abs(ESharkCode.ERR_FOR_RSAKEY_FAILED) + i : ESharkCode.ERR_FOR_RSAKEY_FAILED + i;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("[cu_guid] onRsaKeyUpdateResult(), rsa failed, call onSharkVipError(), ");
        sb3.append(abs);
        C0849fg.m914i("SharkNetwork", sb3.toString());
        m464a(false, true, abs);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0707b mo9328a(boolean z, C0738f fVar) {
        C0707b bVar = null;
        if (fVar == null) {
            return null;
        }
        if (z) {
            bVar = this.f597iY.mo9308ac();
            fVar.f647jL = bVar;
            Iterator it = fVar.f649jN.iterator();
            while (it.hasNext()) {
                C0636by byVar = (C0636by) it.next();
                if (byVar != null) {
                    if (byVar.f360fo != null && byVar.f360fo.length > 0 && (byVar.f365ft & 2) == 0) {
                        byVar.f360fo = C0683dd.encrypt(byVar.f360fo, bVar.f551im.getBytes());
                        if (byVar.f360fo == null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("[ocean][rsa_key]encrypt failed, cmdId: ");
                            sb.append(byVar.f357dO);
                            C0849fg.m912e("SharkNetwork", sb.toString());
                        }
                    }
                }
            }
        }
        if (fVar.f649jN != null && fVar.f649jN.size() > 0) {
            Iterator it2 = fVar.f649jN.iterator();
            while (it2.hasNext()) {
                C0636by byVar2 = (C0636by) it2.next();
                if (byVar2 != null) {
                    if (byVar2.f359fn == 0) {
                        fVar.f645jJ = true;
                    }
                    C0712dv.m412br().mo9316a("SharkNetwork", byVar2.f357dO, byVar2.f358fm, byVar2, 5);
                }
            }
        }
        synchronized (this.f605jg) {
            String str = "SharkNetwork";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("spSend() sharkSend.seqNoTag: ");
            sb2.append(fVar.f646jK);
            C0849fg.m911d(str, sb2.toString());
            this.f605jg.put(Integer.valueOf(fVar.f646jK), fVar);
        }
        this.f619ju.sendMessageDelayed(Message.obtain(this.f619ju, 1, fVar), fVar.f654jS > 0 ? fVar.f654jS : 30000);
        this.f596iX.mo9461d(fVar);
        return bVar;
    }

    /* renamed from: a */
    public void mo9329a(int i, long j, boolean z, ArrayList<C0636by> arrayList, C0734b bVar) {
        C0738f fVar = new C0738f(i, false, false, false, j, arrayList, bVar, 0);
        mo9330a(fVar);
        if (z) {
            this.f598iZ.mo9273a(false, (String) null);
        }
    }

    /* renamed from: a */
    public void mo9330a(C0738f fVar) {
        if (fVar != null && fVar.f650jO != null && fVar.f649jN != null && fVar.f649jN.size() > 0) {
            synchronized (this.f604jf) {
                this.f604jf.add(fVar);
                StringBuilder sb = new StringBuilder();
                sb.append("asyncSendShark() mSharkQueueWaiting.size(): ");
                sb.append(this.f604jf.size());
                C0849fg.m914i("SharkNetwork", sb.toString());
            }
            Iterator it = fVar.f649jN.iterator();
            while (it.hasNext()) {
                C0636by byVar = (C0636by) it.next();
                if (byVar != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("[");
                    sb2.append(0);
                    sb2.append("]发包请求：cmd id:[");
                    sb2.append(byVar.f357dO);
                    sb2.append("]seqNo:[");
                    sb2.append(byVar.f358fm);
                    sb2.append("]refSeqNo:[");
                    sb2.append(byVar.f359fn);
                    sb2.append("]retCode:[");
                    sb2.append(byVar.f362fq);
                    sb2.append("]dataRetCode:[");
                    sb2.append(byVar.f363fr);
                    sb2.append("]");
                    C0849fg.m914i("SharkNetwork_CMDID", sb2.toString());
                    C0712dv.m412br().mo9316a("SharkNetwork", byVar.f357dO, byVar.f358fm, byVar, 1);
                }
            }
            this.f617js.sendEmptyMessage(1);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9331a(ArrayList<C0636by> arrayList, C0734b bVar) {
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            C0636by byVar = (C0636by) it.next();
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(i);
            sb.append("]Rsa发包请求：cmd id:[");
            sb.append(byVar.f357dO);
            sb.append("]seqNo:[");
            sb.append(byVar.f358fm);
            sb.append("]refSeqNo:[");
            sb.append(byVar.f359fn);
            sb.append("]retCode:[");
            sb.append(byVar.f362fq);
            sb.append("]dataRetCode:[");
            sb.append(byVar.f363fr);
            sb.append("]");
            C0849fg.m914i("SharkNetwork_CMDID", sb.toString());
            i++;
        }
        C0738f fVar = new C0738f(0, true, false, false, 0, arrayList, bVar, 0);
        this.f602jd = fVar;
        this.f602jd.f639jD = true;
        this.f617js.obtainMessage(0, 1, 0).sendToTarget();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: aT */
    public void mo9332aT() {
        C0849fg.m914i("SharkNetwork", "[cu_guid]refreshGuid()");
        this.f598iZ.mo9276aT();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ac */
    public C0707b mo9333ac() {
        return this.f597iY.mo9308ac();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo9334b(ArrayList<C0636by> arrayList, C0734b bVar) {
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            C0636by byVar = (C0636by) it.next();
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(i);
            sb.append("]Guid发包请求：cmd id:[");
            sb.append(byVar.f357dO);
            sb.append("]seqNo:[");
            sb.append(byVar.f358fm);
            sb.append("]refSeqNo:[");
            sb.append(byVar.f359fn);
            sb.append("]retCode:[");
            sb.append(byVar.f362fq);
            sb.append("]dataRetCode:[");
            sb.append(byVar.f363fr);
            sb.append("]");
            C0849fg.m914i("SharkNetwork_CMDID", sb.toString());
            i++;
        }
        C0738f fVar = new C0738f(0, true, false, false, 0, arrayList, bVar, 0);
        this.f603je = fVar;
        this.f603je.f640jE = true;
        this.f617js.obtainMessage(0, 2, 0).sendToTarget();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: bB */
    public void mo9335bB() {
        synchronized (this.f595hO) {
            if (!this.f610jl || C0833ex.m868a(System.currentTimeMillis(), this.f612jn, 3)) {
                this.f610jl = true;
                this.f612jn = System.currentTimeMillis();
                this.f617js.removeMessages(3);
                this.f617js.sendEmptyMessageDelayed(3, 1000);
                return;
            }
            C0849fg.m916w("SharkNetwork", "[cu_guid]registering guid, ignore");
        }
    }

    /* renamed from: bD */
    public C0792ei mo9336bD() {
        return this.f596iX.mo9459bD();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: bE */
    public void mo9337bE() {
        C0849fg.m914i("SharkNetwork", "[rsa_key]refreshRsaKey()");
        this.f597iY.refresh();
    }

    /* access modifiers changed from: protected */
    /* renamed from: bF */
    public C0695dl mo9338bF() {
        return this.f594hN;
    }

    /* renamed from: bG */
    public void mo9339bG() {
        if (this.f617js != null) {
            C0849fg.m915v("SharkNetwork", "[cu_guid]send msg: guid info changed, check update guid in 15s");
            this.f617js.removeMessages(4);
            this.f617js.sendEmptyMessage(4);
        }
    }

    /* renamed from: bH */
    public void mo9340bH() {
        if (this.f617js != null) {
            C0849fg.m914i("SharkNetwork", "[cu_vid] updateVidIfNeed(), send MSG_UPDATE_VID_IFNEED in 2s");
            this.f617js.removeMessages(9);
            this.f617js.sendEmptyMessageDelayed(9, 2000);
        }
    }

    /* renamed from: bI */
    public void mo9341bI() {
        m475bC();
    }

    /* renamed from: c */
    public void mo9342c(int i, int i2, int i3) {
        if (i2 > 0) {
            if (this.f601jc == null) {
                synchronized (C0718dy.class) {
                    if (this.f601jc == null) {
                        this.f601jc = new SparseArray<>();
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("network_control_");
            sb.append(i);
            C0684de deVar = new C0684de(sb.toString(), (long) (i2 * 1000), i3);
            synchronized (this.f601jc) {
                this.f601jc.append(i, deVar);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[network_control]handleNetworkControl : cmdid|");
                sb2.append(i);
                sb2.append("|timeSpan|");
                sb2.append(i2);
                sb2.append("|maxTimes|");
                sb2.append(i3);
                sb2.append(" size: ");
                sb2.append(this.f601jc.size());
                C0849fg.m911d("SharkNetwork", sb2.toString());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo9343e(long j) {
        synchronized (this.f595hO) {
            if (!this.f609jk || C0833ex.m868a(System.currentTimeMillis(), this.f611jm, 3)) {
                this.f609jk = true;
                this.f611jm = System.currentTimeMillis();
                this.f617js.removeMessages(2);
                this.f617js.sendEmptyMessageDelayed(2, j);
            }
        }
    }

    public String getGuid() {
        return this.f598iZ.getGuid();
    }

    public void onReady() {
        C0849fg.m915v("SharkNetwork", "[cu_guid]onReady(), check update guid");
        this.f598iZ.mo9273a(true, (String) null);
    }
}
