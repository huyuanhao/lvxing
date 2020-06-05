package com.tencent.mta.track;

import android.content.Context;
import android.os.Message;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.a */
class C7340a {
    /* renamed from: d */
    private static final Map f24861d = new HashMap();
    /* renamed from: a */
    private final C7367b f24862a = new C7367b(this);
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final Context f24863b;
    /* renamed from: c */
    private final DbAdapter f24864c;

    /* renamed from: a */
    private static byte[] m31665a(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    C7340a(Context context, String str) {
        this.f24863b = context;
        this.f24864c = new DbAdapter(this.f24863b, str);
    }

    /* renamed from: a */
    public static C7340a m31664a(Context context, String str) {
        C7340a aVar;
        synchronized (f24861d) {
            Context applicationContext = context.getApplicationContext();
            if (!f24861d.containsKey(applicationContext)) {
                aVar = new C7340a(applicationContext, str);
                f24861d.put(applicationContext, aVar);
            } else {
                aVar = (C7340a) f24861d.get(applicationContext);
            }
        }
        return aVar;
    }

    /* renamed from: a */
    public void mo35835a(C7377h hVar) {
        Message obtain = Message.obtain();
        obtain.what = 4;
        obtain.obj = hVar;
        this.f24862a.mo35902a(obtain);
    }

    /* renamed from: a */
    public void mo35834a() {
        Message obtain = Message.obtain();
        obtain.what = 3;
        this.f24862a.mo35902a(obtain);
    }

    /* JADX INFO: unreachable blocks removed: 1, instructions: 1 */
    /* access modifiers changed from: private */
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:28:0x0104 in {} preds:[B:27:0x0103, B:15:0x009e]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.calcImmediateDominators(BlockProcessor.java:303)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:255)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:55)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:30)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
        	at jadx.core.ProcessClass.process(ProcessClass.java:35)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        */
    /* renamed from: b */
    public java.lang.String m31668b() {
        /*
        r16 = this;
        r1 = r16
        java.lang.String r2 = "version"
        java.lang.String r3 = "fetchCheckConfigure : "
        java.lang.String r4 = "Track"
        java.lang.String r5 = "UTF-8"
        r6 = 0
        java.net.Socket r7 = new java.net.Socket     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        android.content.Context r8 = r1.f24863b     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        com.tencent.mta.track.StatisticsDataAPI r8 = com.tencent.mta.track.StatisticsDataAPI.sharedInstance(r8)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        java.lang.String r8 = r8.mo35812c()     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r9 = 4002(0xfa2, float:5.608E-42)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r7.<init>(r8, r9)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r8 = 10000(0x2710, float:1.4013E-41)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r7.setSoTimeout(r8)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        java.io.OutputStream r8 = r7.getOutputStream()     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        android.content.Context r9 = r1.f24863b     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        java.lang.String r10 = "TA_APPKEY"     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        java.lang.Object r9 = com.tencent.mta.track.util.C7468g.m32339a(r9, r10, r6)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        java.lang.String r10 = ""
        if (r9 == 0) goto L_0x0036
        java.lang.String r9 = r9.toString()     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        goto L_0x0037     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
    L_0x0036:
        r9 = r10     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
    L_0x0037:
        android.content.Context r11 = r1.f24863b     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        android.content.pm.PackageManager r11 = r11.getPackageManager()     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        android.content.Context r12 = r1.f24863b     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        java.lang.String r12 = r12.getPackageName()     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r13 = 0     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        android.content.pm.PackageInfo r11 = r11.getPackageInfo(r12, r13)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r12.<init>()     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        java.lang.String r14 = "reqType"
        java.lang.String r15 = "query"
        r12.put(r14, r15)     // Catch:{ JSONException -> 0x0101 }
        org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0101 }
        r14.<init>()     // Catch:{ JSONException -> 0x0101 }
        org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0101 }
        r15.<init>()     // Catch:{ JSONException -> 0x0101 }
        org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0101 }
        r15.<init>()     // Catch:{ JSONException -> 0x0101 }
        java.lang.String r6 = "platform"     // Catch:{ JSONException -> 0x0101 }
        java.lang.String r13 = "MTA"     // Catch:{ JSONException -> 0x0101 }
        r15.put(r6, r13)     // Catch:{ JSONException -> 0x0101 }
        java.lang.String r6 = "accessID"     // Catch:{ JSONException -> 0x0101 }
        r15.put(r6, r9)     // Catch:{ JSONException -> 0x0101 }
        java.lang.String r6 = "3.4.0"     // Catch:{ JSONException -> 0x0101 }
        r15.put(r2, r6)     // Catch:{ JSONException -> 0x0101 }
        java.lang.String r6 = "SDK"     // Catch:{ JSONException -> 0x0101 }
        r14.put(r6, r15)     // Catch:{ JSONException -> 0x0101 }
        org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0101 }
        r6.<init>()     // Catch:{ JSONException -> 0x0101 }
        java.lang.String r9 = "name"     // Catch:{ JSONException -> 0x0101 }
        java.lang.String r13 = r11.packageName     // Catch:{ JSONException -> 0x0101 }
        r6.put(r9, r13)     // Catch:{ JSONException -> 0x0101 }
        java.lang.String r9 = r11.versionName     // Catch:{ JSONException -> 0x0101 }
        r6.put(r2, r9)     // Catch:{ JSONException -> 0x0101 }
        java.lang.String r9 = "APP"     // Catch:{ JSONException -> 0x0101 }
        r14.put(r9, r6)     // Catch:{ JSONException -> 0x0101 }
        org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0101 }
        r6.<init>()     // Catch:{ JSONException -> 0x0101 }
        java.lang.String r9 = "osVersion"     // Catch:{ JSONException -> 0x0101 }
        java.lang.String r11 = android.os.Build.VERSION.RELEASE     // Catch:{ JSONException -> 0x0101 }
        if (r11 != 0) goto L_0x00a1
        java.lang.String r11 = "UNKNOWN"
        goto L_0x00a3
    L_0x009d:
        r0 = move-exception
        r2 = r0
        r11 = r10
        goto L_0x0104
    L_0x00a1:
        java.lang.String r11 = android.os.Build.VERSION.RELEASE     // Catch:{ JSONException -> 0x0101 }
    L_0x00a3:
        r6.put(r9, r11)     // Catch:{ JSONException -> 0x0101 }
        java.lang.String r9 = "model"     // Catch:{ JSONException -> 0x0101 }
        java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0101 }
        r11.<init>()     // Catch:{ JSONException -> 0x0101 }
        java.lang.String r13 = android.os.Build.BRAND     // Catch:{ JSONException -> 0x0101 }
        r11.append(r13)     // Catch:{ JSONException -> 0x0101 }
        java.lang.String r13 = "-"     // Catch:{ JSONException -> 0x0101 }
        r11.append(r13)     // Catch:{ JSONException -> 0x0101 }
        java.lang.String r13 = android.os.Build.MODEL     // Catch:{ JSONException -> 0x0101 }
        r11.append(r13)     // Catch:{ JSONException -> 0x0101 }
        java.lang.String r11 = r11.toString()     // Catch:{ JSONException -> 0x0101 }
        r6.put(r9, r11)     // Catch:{ JSONException -> 0x0101 }
        java.lang.String r9 = "apiVersion"     // Catch:{ JSONException -> 0x0101 }
        int r11 = android.os.Build.VERSION.SDK_INT     // Catch:{ JSONException -> 0x0101 }
        r6.put(r9, r11)     // Catch:{ JSONException -> 0x0101 }
        java.lang.String r9 = "deviceID"     // Catch:{ JSONException -> 0x0101 }
        android.content.Context r11 = r1.f24863b     // Catch:{ JSONException -> 0x0101 }
        java.lang.String r11 = com.tencent.mta.track.util.C7468g.m32342b(r11)     // Catch:{ JSONException -> 0x0101 }
        r6.put(r9, r11)     // Catch:{ JSONException -> 0x0101 }
        java.lang.String r9 = "device"     // Catch:{ JSONException -> 0x0101 }
        r14.put(r9, r6)     // Catch:{ JSONException -> 0x0101 }
        org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0101 }
        r6.<init>()     // Catch:{ JSONException -> 0x0101 }
        android.content.Context r9 = r1.f24863b     // Catch:{ JSONException -> 0x0101 }
        java.lang.String r9 = com.tencent.mta.track.util.C7468g.m32343c(r9)     // Catch:{ JSONException -> 0x0101 }
        r6.put(r2, r9)     // Catch:{ JSONException -> 0x0101 }
        java.lang.String r2 = "ts"     // Catch:{ JSONException -> 0x0101 }
        android.content.Context r9 = r1.f24863b     // Catch:{ JSONException -> 0x0101 }
        r11 = r10
        long r9 = com.tencent.mta.track.util.C7468g.m32344d(r9)     // Catch:{ JSONException -> 0x00ff }
        r6.put(r2, r9)     // Catch:{ JSONException -> 0x00ff }
        java.lang.String r2 = "config"     // Catch:{ JSONException -> 0x00ff }
        r14.put(r2, r6)     // Catch:{ JSONException -> 0x00ff }
        java.lang.String r2 = "args"     // Catch:{ JSONException -> 0x00ff }
        r12.put(r2, r14)     // Catch:{ JSONException -> 0x00ff }
        goto L_0x0107
    L_0x00ff:
        r0 = move-exception
        goto L_0x0103
    L_0x0101:
        r0 = move-exception
        r11 = r10
    L_0x0103:
        r2 = r0
    L_0x0104:
        r2.printStackTrace()     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
    L_0x0107:
        java.lang.String r2 = r12.toString()     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        byte[] r2 = r2.getBytes(r5)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        int r6 = r2.length     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        java.lang.String r9 = r2.toString()     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        int r9 = r9.length()     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        java.io.ByteArrayOutputStream r10 = new java.io.ByteArrayOutputStream     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r10.<init>(r9)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        java.util.zip.GZIPOutputStream r9 = new java.util.zip.GZIPOutputStream     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r9.<init>(r10)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r9.write(r2)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r9.close()     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        byte[] r2 = r10.toByteArray()     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        byte[] r2 = com.tencent.mta.track.util.C7467f.m32335a(r2)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r9 = -1792502487(0xffffffff95289529, float:-3.4044996E-26)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        byte[] r9 = m31665a(r9)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r12 = 4     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r13 = 0     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r8.write(r9, r13, r12)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        int r2 = r2.length     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        int r2 = r2 + 20     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        byte[] r2 = m31665a(r2)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r8.write(r2, r13, r12)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r2 = 1     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        byte[] r2 = m31665a(r2)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r8.write(r2, r13, r12)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r2 = 196608(0x30000, float:2.75506E-40)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        byte[] r2 = m31665a(r2)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r8.write(r2, r13, r12)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        byte[] r2 = m31665a(r6)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        byte[] r6 = r10.toByteArray()     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        byte[] r2 = m31667a(r2, r6)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        byte[] r2 = com.tencent.mta.track.util.C7467f.m32335a(r2)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        byte[] r6 = r10.toByteArray()     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        int r6 = r6.length     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        int r6 = r6 + r12     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r9 = 0     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r8.write(r2, r9, r6)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        java.io.InputStream r2 = r7.getInputStream()     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        byte[] r6 = new byte[r12]     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r8 = 10240(0x2800, float:1.4349E-41)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        byte[] r8 = new byte[r8]     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        int r9 = r2.read(r8)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r10 = -1     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        if (r9 == r10) goto L_0x0201     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r9 = 0     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        java.lang.System.arraycopy(r8, r9, r6, r9, r12)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        java.lang.System.arraycopy(r8, r12, r6, r9, r12)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        int r10 = m31671c(r6)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r13 = 8     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        java.lang.System.arraycopy(r8, r13, r6, r9, r12)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r13 = 12     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        java.lang.System.arraycopy(r8, r13, r6, r9, r12)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        java.lang.String r6 = m31670b(r6)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        java.lang.String r9 = "00000000"     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        boolean r9 = r6.equals(r9)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r12 = 16     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        if (r9 == 0) goto L_0x01b2     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        int r10 = r10 - r12     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        byte[] r6 = new byte[r10]     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r9 = 0     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        java.lang.System.arraycopy(r8, r12, r6, r9, r10)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        java.lang.String r10 = new java.lang.String     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r10.<init>(r6, r5)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        goto L_0x0202     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
    L_0x01b2:
        java.lang.String r9 = "00030000"     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        boolean r9 = r6.equals(r9)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        if (r9 == 0) goto L_0x01cf     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        int r10 = r10 - r12     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        byte[] r6 = new byte[r10]     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r9 = 0     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        java.lang.System.arraycopy(r8, r12, r6, r9, r10)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        byte[] r6 = com.tencent.mta.track.util.C7467f.m32337b(r6)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        byte[] r6 = m31666a(r6)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        java.lang.String r10 = new java.lang.String     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r10.<init>(r6, r5)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        goto L_0x0202     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
    L_0x01cf:
        java.lang.String r9 = "00020000"     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        boolean r9 = r6.equals(r9)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        if (r9 == 0) goto L_0x01e8     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        int r10 = r10 - r12     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        byte[] r6 = new byte[r10]     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r9 = 0     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        java.lang.System.arraycopy(r8, r12, r6, r9, r10)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        byte[] r6 = com.tencent.mta.track.util.C7467f.m32337b(r6)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        java.lang.String r10 = new java.lang.String     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r10.<init>(r6, r5)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        goto L_0x0202     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
    L_0x01e8:
        java.lang.String r9 = "00010000"     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        boolean r6 = r6.equals(r9)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        if (r6 == 0) goto L_0x0201     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        int r10 = r10 - r12     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        byte[] r6 = new byte[r10]     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r9 = 0     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        java.lang.System.arraycopy(r8, r12, r6, r9, r10)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        byte[] r6 = m31666a(r6)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        java.lang.String r10 = new java.lang.String     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r10.<init>(r6, r5)     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        goto L_0x0202     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
    L_0x0201:
        r10 = r11     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
    L_0x0202:
        r7.shutdownOutput()     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r7.close()     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        r2.close()     // Catch:{ UnknownHostException -> 0x0251, IOException -> 0x023c, NameNotFoundException -> 0x0227, all -> 0x020c }
        return r10
    L_0x020c:
        r0 = move-exception
        r2 = r0
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        java.lang.String r5 = "fetchCheckConfigure Throwable e = "
        r3.append(r5)
        java.lang.String r2 = r2.toString()
        r3.append(r2)
        java.lang.String r2 = r3.toString()
        android.util.Log.e(r4, r2)
        goto L_0x0265
    L_0x0227:
        r0 = move-exception
        r2 = r0
        java.lang.StringBuilder r5 = new java.lang.StringBuilder
        r5.<init>()
        r5.append(r3)
        r5.append(r2)
        java.lang.String r2 = r5.toString()
        android.util.Log.e(r4, r2)
        goto L_0x0265
    L_0x023c:
        r0 = move-exception
        r2 = r0
        java.lang.StringBuilder r5 = new java.lang.StringBuilder
        r5.<init>()
        r5.append(r3)
        r5.append(r2)
        java.lang.String r2 = r5.toString()
        android.util.Log.e(r4, r2)
        goto L_0x0265
    L_0x0251:
        r0 = move-exception
        r2 = r0
        java.lang.StringBuilder r5 = new java.lang.StringBuilder
        r5.<init>()
        r5.append(r3)
        r5.append(r2)
        java.lang.String r2 = r5.toString()
        android.util.Log.e(r4, r2)
    L_0x0265:
        r2 = 0
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mta.track.C7340a.m31668b():java.lang.String");
    }

    /* renamed from: b */
    private static String m31670b(byte[] bArr) {
        String str = "";
        StringBuilder sb = new StringBuilder(str);
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            if (hexString.length() == 1) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("0");
                sb2.append(hexString);
                hexString = sb2.toString();
            }
            sb.append(hexString);
            sb.append(str);
        }
        return sb.toString().toUpperCase().trim();
    }

    /* renamed from: a */
    private static byte[] m31667a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    /* renamed from: a */
    public static byte[] m31666a(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            byte[] bArr2 = new byte[4096];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length * 2);
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayInputStream.close();
                    gZIPInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: c */
    private static int m31671c(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            i += (bArr[i2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << ((3 - i2) * 8);
        }
        return i;
    }
}
