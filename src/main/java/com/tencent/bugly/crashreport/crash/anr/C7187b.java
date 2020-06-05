package com.tencent.bugly.crashreport.crash.anr;

import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.Context;
import android.os.FileObserver;
import android.os.Process;
import com.tencent.android.tpush.common.Constants;
import com.tencent.bugly.BuglyStrategy.C7120a;
import com.tencent.bugly.crashreport.common.info.C7174a;
import com.tencent.bugly.crashreport.common.info.C7175b;
import com.tencent.bugly.crashreport.common.strategy.C7177a;
import com.tencent.bugly.crashreport.crash.C7190b;
import com.tencent.bugly.crashreport.crash.C7192c;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.C7212ae;
import com.tencent.bugly.proguard.C7224am;
import com.tencent.bugly.proguard.C7226an;
import com.tencent.bugly.proguard.C7228ap;
import com.tencent.bugly.proguard.C7232aq;
import com.tencent.bugly.proguard.C7234as;
import com.tencent.bugly.proguard.C7235at;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.anr.b */
public class C7187b implements C7235at {
    /* renamed from: a */
    private AtomicInteger f24164a = new AtomicInteger(0);
    /* renamed from: b */
    private long f24165b = -1;
    /* renamed from: c */
    private final Context f24166c;
    /* renamed from: d */
    private final C7174a f24167d;
    /* renamed from: e */
    private final C7224am f24168e;
    /* renamed from: f */
    private final C7177a f24169f;
    /* renamed from: g */
    private final String f24170g;
    /* renamed from: h */
    private final C7190b f24171h;
    /* renamed from: i */
    private FileObserver f24172i;
    /* renamed from: j */
    private boolean f24173j = true;
    /* renamed from: k */
    private C7234as f24174k;
    /* renamed from: l */
    private int f24175l;

    public C7187b(Context context, C7177a aVar, C7174a aVar2, C7224am amVar, C7212ae aeVar, C7190b bVar, C7120a aVar3) {
        this.f24166c = C7232aq.m31172a(context);
        this.f24170g = context.getDir("bugly", 0).getAbsolutePath();
        this.f24167d = aVar2;
        this.f24168e = amVar;
        this.f24169f = aVar;
        this.f24171h = bVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public ProcessErrorStateInfo mo34647a(Context context, long j) {
        if (j < 0) {
            j = 0;
        }
        try {
            C7226an.m31147c("to find!", new Object[0]);
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME);
            long j2 = j / 500;
            int i = 0;
            while (true) {
                C7226an.m31147c("waiting!", new Object[0]);
                List<ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
                if (processesInErrorState != null) {
                    for (ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                        if (processErrorStateInfo.condition == 2) {
                            C7226an.m31147c("found!", new Object[0]);
                            return processErrorStateInfo;
                        }
                    }
                }
                C7232aq.m31209b(500);
                int i2 = i + 1;
                if (((long) i) >= j2) {
                    C7226an.m31147c("end!", new Object[0]);
                    break;
                }
                i = i2;
            }
        } catch (Exception e) {
            C7226an.m31145b(e);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C7186a mo34649a(Context context, ProcessErrorStateInfo processErrorStateInfo, long j, Map<String, String> map) {
        File filesDir = context.getFilesDir();
        StringBuilder sb = new StringBuilder();
        sb.append("bugly/bugly_trace_");
        sb.append(j);
        sb.append(".txt");
        File file = new File(filesDir, sb.toString());
        C7186a aVar = new C7186a();
        aVar.f24159c = j;
        aVar.f24160d = file.getAbsolutePath();
        String str = "";
        aVar.f24157a = processErrorStateInfo != null ? processErrorStateInfo.processName : str;
        aVar.f24162f = processErrorStateInfo != null ? processErrorStateInfo.shortMsg : str;
        if (processErrorStateInfo != null) {
            str = processErrorStateInfo.longMsg;
        }
        aVar.f24161e = str;
        aVar.f24158b = map;
        if (map != null) {
            for (String str2 : map.keySet()) {
                if (str2.startsWith("main(")) {
                    aVar.f24163g = (String) map.get(str2);
                }
            }
        }
        Object[] objArr = new Object[6];
        int i = 0;
        objArr[0] = Long.valueOf(aVar.f24159c);
        objArr[1] = aVar.f24160d;
        objArr[2] = aVar.f24157a;
        objArr[3] = aVar.f24162f;
        objArr[4] = aVar.f24161e;
        if (aVar.f24158b != null) {
            i = aVar.f24158b.size();
        }
        objArr[5] = Integer.valueOf(i);
        C7226an.m31147c("anr tm:%d\ntr:%s\nproc:%s\nsMsg:%s\n lMsg:%s\n threads:%d", objArr);
        return aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public CrashDetailBean mo34648a(C7186a aVar) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        try {
            crashDetailBean.f24095C = C7175b.m30833i();
            crashDetailBean.f24096D = C7175b.m30829g();
            crashDetailBean.f24097E = C7175b.m30837k();
            crashDetailBean.f24098F = this.f24167d.mo34603p();
            crashDetailBean.f24099G = this.f24167d.mo34602o();
            crashDetailBean.f24100H = this.f24167d.mo34604q();
            crashDetailBean.f24138w = C7232aq.m31180a(this.f24166c, C7192c.f24191e, C7192c.f24194h);
            crashDetailBean.f24117b = 3;
            crashDetailBean.f24120e = this.f24167d.mo34595h();
            crashDetailBean.f24121f = this.f24167d.f24035p;
            crashDetailBean.f24122g = this.f24167d.mo34610w();
            crashDetailBean.f24128m = this.f24167d.mo34593g();
            crashDetailBean.f24129n = "ANR_EXCEPTION";
            crashDetailBean.f24130o = aVar.f24162f;
            crashDetailBean.f24132q = aVar.f24163g;
            crashDetailBean.f24108P = new HashMap();
            crashDetailBean.f24108P.put("BUGLY_CR_01", aVar.f24161e);
            int i = -1;
            if (crashDetailBean.f24132q != null) {
                i = crashDetailBean.f24132q.indexOf("\n");
            }
            crashDetailBean.f24131p = i > 0 ? crashDetailBean.f24132q.substring(0, i) : "GET_FAIL";
            crashDetailBean.f24133r = aVar.f24159c;
            if (crashDetailBean.f24132q != null) {
                crashDetailBean.f24136u = C7232aq.m31207b(crashDetailBean.f24132q.getBytes());
            }
            crashDetailBean.f24141z = aVar.f24158b;
            crashDetailBean.f24093A = aVar.f24157a;
            crashDetailBean.f24094B = "main(1)";
            crashDetailBean.f24101I = this.f24167d.mo34612y();
            crashDetailBean.f24123h = this.f24167d.mo34609v();
            crashDetailBean.f24124i = this.f24167d.mo34564J();
            crashDetailBean.f24137v = aVar.f24160d;
            crashDetailBean.f24105M = this.f24167d.f24039t;
            crashDetailBean.f24106N = this.f24167d.f23989a;
            crashDetailBean.f24107O = this.f24167d.mo34579a();
            crashDetailBean.f24109Q = this.f24167d.mo34562H();
            crashDetailBean.f24110R = this.f24167d.mo34563I();
            crashDetailBean.f24111S = this.f24167d.mo34556B();
            crashDetailBean.f24112T = this.f24167d.mo34561G();
            this.f24171h.mo34682c(crashDetailBean);
            crashDetailBean.f24140y = C7228ap.m31160a();
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
        }
        return crashDetailBean;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0139 A[Catch:{ all -> 0x012e }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0165 A[SYNTHETIC, Splitter:B:61:0x0165] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0177 A[SYNTHETIC, Splitter:B:69:0x0177] */
    /* renamed from: a */
    public boolean mo34655a(java.lang.String r17, java.lang.String r18, java.lang.String r19) {
        /*
        r16 = this;
        r1 = r18
        r0 = r19
        java.lang.String r2 = "main"
        java.lang.String r3 = ":"
        r4 = 1
        r5 = r17
        com.tencent.bugly.crashreport.crash.anr.TraceFileHelper$a r5 = com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.readTargetDumpInfo(r0, r5, r4)
        r6 = 0
        if (r5 == 0) goto L_0x01c5
        java.util.Map<java.lang.String, java.lang.String[]> r7 = r5.f24156d
        if (r7 == 0) goto L_0x01c5
        java.util.Map<java.lang.String, java.lang.String[]> r7 = r5.f24156d
        int r7 = r7.size()
        if (r7 > 0) goto L_0x0020
        goto L_0x01c5
    L_0x0020:
        java.io.File r0 = new java.io.File
        r0.<init>(r1)
        r7 = 2
        boolean r8 = r0.exists()     // Catch:{ Exception -> 0x0191 }
        if (r8 != 0) goto L_0x0040
        java.io.File r8 = r0.getParentFile()     // Catch:{ Exception -> 0x0191 }
        boolean r8 = r8.exists()     // Catch:{ Exception -> 0x0191 }
        if (r8 != 0) goto L_0x003d
        java.io.File r8 = r0.getParentFile()     // Catch:{ Exception -> 0x0191 }
        r8.mkdirs()     // Catch:{ Exception -> 0x0191 }
    L_0x003d:
        r0.createNewFile()     // Catch:{ Exception -> 0x0191 }
    L_0x0040:
        boolean r8 = r0.exists()
        if (r8 == 0) goto L_0x0187
        boolean r8 = r0.canWrite()
        if (r8 != 0) goto L_0x004e
        goto L_0x0187
    L_0x004e:
        r1 = 0
        java.io.BufferedWriter r8 = new java.io.BufferedWriter     // Catch:{ IOException -> 0x0132 }
        java.io.FileWriter r9 = new java.io.FileWriter     // Catch:{ IOException -> 0x0132 }
        r9.<init>(r0, r6)     // Catch:{ IOException -> 0x0132 }
        r8.<init>(r9)     // Catch:{ IOException -> 0x0132 }
        java.util.Map<java.lang.String, java.lang.String[]> r0 = r5.f24156d     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        java.lang.Object r0 = r0.get(r2)     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        java.lang.String[] r0 = (java.lang.String[]) r0     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        java.lang.String r1 = "\n\n"
        java.lang.String r9 = "\n"
        java.lang.String r10 = " :\n"
        r11 = 3
        if (r0 == 0) goto L_0x0099
        int r12 = r0.length     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        if (r12 < r11) goto L_0x0099
        r12 = r0[r6]     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        r13 = r0[r4]     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        r0 = r0[r7]     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        r14.<init>()     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        java.lang.String r15 = "\"main\" tid="
        r14.append(r15)     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        r14.append(r0)     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        r14.append(r10)     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        r14.append(r12)     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        r14.append(r9)     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        r14.append(r13)     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        r14.append(r1)     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        java.lang.String r0 = r14.toString()     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        r8.write(r0)     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        r8.flush()     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
    L_0x0099:
        java.util.Map<java.lang.String, java.lang.String[]> r0 = r5.f24156d     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        java.util.Set r0 = r0.entrySet()     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        java.util.Iterator r0 = r0.iterator()     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
    L_0x00a3:
        boolean r5 = r0.hasNext()     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        if (r5 == 0) goto L_0x0119
        java.lang.Object r5 = r0.next()     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        java.lang.Object r12 = r5.getKey()     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        java.lang.String r12 = (java.lang.String) r12     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        boolean r12 = r12.equals(r2)     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        if (r12 == 0) goto L_0x00bc
        goto L_0x00a3
    L_0x00bc:
        java.lang.Object r12 = r5.getValue()     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        if (r12 == 0) goto L_0x0117
        java.lang.Object r12 = r5.getValue()     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        java.lang.String[] r12 = (java.lang.String[]) r12     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        int r12 = r12.length     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        if (r12 < r11) goto L_0x0117
        java.lang.Object r12 = r5.getValue()     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        java.lang.String[] r12 = (java.lang.String[]) r12     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        r12 = r12[r6]     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        java.lang.Object r13 = r5.getValue()     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        java.lang.String[] r13 = (java.lang.String[]) r13     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        r13 = r13[r4]     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        java.lang.Object r14 = r5.getValue()     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        java.lang.String[] r14 = (java.lang.String[]) r14     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        r14 = r14[r7]     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        r15.<init>()     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        java.lang.String r11 = "\""
        r15.append(r11)     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        java.lang.Object r5 = r5.getKey()     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        r15.append(r5)     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        java.lang.String r5 = "\" tid="
        r15.append(r5)     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        r15.append(r14)     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        r15.append(r10)     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        r15.append(r12)     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        r15.append(r9)     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        r15.append(r13)     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        r15.append(r1)     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        java.lang.String r5 = r15.toString()     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        r8.write(r5)     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
        r8.flush()     // Catch:{ IOException -> 0x012b, all -> 0x0129 }
    L_0x0117:
        r11 = 3
        goto L_0x00a3
    L_0x0119:
        r8.close()     // Catch:{ IOException -> 0x011d }
        goto L_0x0128
    L_0x011d:
        r0 = move-exception
        r1 = r0
        boolean r0 = com.tencent.bugly.proguard.C7226an.m31142a(r1)
        if (r0 != 0) goto L_0x0128
        r1.printStackTrace()
    L_0x0128:
        return r4
    L_0x0129:
        r0 = move-exception
        goto L_0x0130
    L_0x012b:
        r0 = move-exception
        r1 = r8
        goto L_0x0133
    L_0x012e:
        r0 = move-exception
        r8 = r1
    L_0x0130:
        r1 = r0
        goto L_0x0175
    L_0x0132:
        r0 = move-exception
    L_0x0133:
        boolean r2 = com.tencent.bugly.proguard.C7226an.m31142a(r0)     // Catch:{ all -> 0x012e }
        if (r2 != 0) goto L_0x013c
        r0.printStackTrace()     // Catch:{ all -> 0x012e }
    L_0x013c:
        java.lang.String r2 = "dump trace fail %s"
        java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x012e }
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x012e }
        r5.<init>()     // Catch:{ all -> 0x012e }
        java.lang.Class r7 = r0.getClass()     // Catch:{ all -> 0x012e }
        java.lang.String r7 = r7.getName()     // Catch:{ all -> 0x012e }
        r5.append(r7)     // Catch:{ all -> 0x012e }
        r5.append(r3)     // Catch:{ all -> 0x012e }
        java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x012e }
        r5.append(r0)     // Catch:{ all -> 0x012e }
        java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x012e }
        r4[r6] = r0     // Catch:{ all -> 0x012e }
        com.tencent.bugly.proguard.C7226an.m31149e(r2, r4)     // Catch:{ all -> 0x012e }
        if (r1 == 0) goto L_0x0174
        r1.close()     // Catch:{ IOException -> 0x0169 }
        goto L_0x0174
    L_0x0169:
        r0 = move-exception
        r1 = r0
        boolean r0 = com.tencent.bugly.proguard.C7226an.m31142a(r1)
        if (r0 != 0) goto L_0x0174
        r1.printStackTrace()
    L_0x0174:
        return r6
    L_0x0175:
        if (r8 == 0) goto L_0x0186
        r8.close()     // Catch:{ IOException -> 0x017b }
        goto L_0x0186
    L_0x017b:
        r0 = move-exception
        r2 = r0
        boolean r0 = com.tencent.bugly.proguard.C7226an.m31142a(r2)
        if (r0 != 0) goto L_0x0186
        r2.printStackTrace()
    L_0x0186:
        throw r1
    L_0x0187:
        java.lang.Object[] r0 = new java.lang.Object[r4]
        r0[r6] = r1
        java.lang.String r1 = "backup file create fail %s"
        com.tencent.bugly.proguard.C7226an.m31149e(r1, r0)
        return r6
    L_0x0191:
        r0 = move-exception
        boolean r2 = com.tencent.bugly.proguard.C7226an.m31142a(r0)
        if (r2 != 0) goto L_0x019b
        r0.printStackTrace()
    L_0x019b:
        java.lang.Object[] r2 = new java.lang.Object[r7]
        java.lang.StringBuilder r5 = new java.lang.StringBuilder
        r5.<init>()
        java.lang.Class r7 = r0.getClass()
        java.lang.String r7 = r7.getName()
        r5.append(r7)
        r5.append(r3)
        java.lang.String r0 = r0.getMessage()
        r5.append(r0)
        java.lang.String r0 = r5.toString()
        r2[r6] = r0
        r2[r4] = r1
        java.lang.String r0 = "backup file create error! %s  %s"
        com.tencent.bugly.proguard.C7226an.m31149e(r0, r2)
        return r6
    L_0x01c5:
        java.lang.Object[] r1 = new java.lang.Object[r4]
        r1[r6] = r0
        java.lang.String r0 = "not found trace dump for %s"
        com.tencent.bugly.proguard.C7226an.m31149e(r0, r1)
        return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.anr.C7187b.mo34655a(java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    /* renamed from: a */
    public boolean mo34653a() {
        return this.f24164a.get() != 0;
    }

    /* renamed from: a */
    public boolean mo34654a(Context context, String str, ProcessErrorStateInfo processErrorStateInfo, long j, Map<String, String> map) {
        C7186a a = mo34649a(context, processErrorStateInfo, j, map);
        if (!this.f24169f.mo34623b()) {
            C7226an.m31149e("crash report sync remote fail, will not upload to Bugly , print local for helpful!", new Object[0]);
            C7190b.m30914a("ANR", C7232aq.m31178a(), a.f24157a, "main", a.f24161e, null);
            return false;
        } else if (!this.f24169f.mo34624c().f24060j) {
            C7226an.m31148d("ANR Report is closed!", new Object[0]);
            return false;
        } else {
            C7226an.m31141a("found visiable anr , start to upload!", new Object[0]);
            CrashDetailBean a2 = mo34648a(a);
            if (a2 == null) {
                C7226an.m31149e("pack anr fail!", new Object[0]);
                return false;
            }
            C7192c.m30937a().mo34689a(a2);
            if (a2.f24116a >= 0) {
                C7226an.m31141a("backup anr record success!", new Object[0]);
            } else {
                C7226an.m31148d("backup anr record fail!", new Object[0]);
            }
            if (str != null && new File(str).exists()) {
                this.f24164a.set(3);
                if (mo34655a(str, a.f24160d, a.f24157a)) {
                    C7226an.m31141a("backup trace success", new Object[0]);
                }
            }
            C7190b.m30914a("ANR", C7232aq.m31178a(), a.f24157a, "main", a.f24161e, a2);
            if (!this.f24171h.mo34676a(a2)) {
                this.f24171h.mo34673a(a2, 3000, true);
            }
            this.f24171h.mo34681b(a2);
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            com.tencent.bugly.proguard.C7226an.m31147c("read trace first dump for create time!", new java.lang.Object[0]);
            r0 = com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.readFirstDumpInfo(r11, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
            if (r0 == null) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
            r5 = r0.f24155c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
            r5 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
            if (r5 != -1) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
            com.tencent.bugly.proguard.C7226an.m31148d("trace dump fail could not get time!", new java.lang.Object[0]);
            r5 = java.lang.System.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003c, code lost:
            r7 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0049, code lost:
            if (java.lang.Math.abs(r7 - r10.f24165b) >= 10000) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004b, code lost:
            com.tencent.bugly.proguard.C7226an.m31148d("should not process ANR too Fre in %d", java.lang.Integer.valueOf(com.tencent.qqpim.discovery.internal.protocol.C7516p.f25219Cf));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            r10.f24165b = r7;
            r10.f24164a.set(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            r9 = com.tencent.bugly.proguard.C7232aq.m31188a(com.tencent.bugly.crashreport.crash.C7192c.f24192f, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006d, code lost:
            if (r9 == null) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0073, code lost:
            if (r9.size() > 0) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0076, code lost:
            r6 = mo34647a(r10.f24166c, 10000);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007c, code lost:
            if (r6 != null) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x007e, code lost:
            com.tencent.bugly.proguard.C7226an.m31147c("proc state is unvisiable!", new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008c, code lost:
            if (r6.pid == android.os.Process.myPid()) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008e, code lost:
            com.tencent.bugly.proguard.C7226an.m31147c("not mind proc!", r6.processName);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x009a, code lost:
            com.tencent.bugly.proguard.C7226an.m31141a("found visiable anr , start to process!", new java.lang.Object[0]);
            mo34654a(r10.f24166c, r11, r6, r7, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a9, code lost:
            com.tencent.bugly.proguard.C7226an.m31148d("can't get all thread skip this anr", new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b1, code lost:
            r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b2, code lost:
            com.tencent.bugly.proguard.C7226an.m31142a(r11);
            com.tencent.bugly.proguard.C7226an.m31149e("get all thread stack fail!", new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00bd, code lost:
            r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c2, code lost:
            if (com.tencent.bugly.proguard.C7226an.m31142a(r11) == false) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c4, code lost:
            r11.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00c7, code lost:
            com.tencent.bugly.proguard.C7226an.m31149e("handle anr error %s", r11.getClass().toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00de, code lost:
            r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00df, code lost:
            r10.f24164a.set(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e4, code lost:
            throw r11;
     */
    /* renamed from: a */
    public final void mo34651a(java.lang.String r11) {
        /*
        r10 = this;
        monitor-enter(r10)
        java.util.concurrent.atomic.AtomicInteger r0 = r10.f24164a     // Catch:{ all -> 0x00e5 }
        int r0 = r0.get()     // Catch:{ all -> 0x00e5 }
        r1 = 0
        if (r0 == 0) goto L_0x0013
        java.lang.String r11 = "trace started return "
        java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch:{ all -> 0x00e5 }
        com.tencent.bugly.proguard.C7226an.m31147c(r11, r0)     // Catch:{ all -> 0x00e5 }
        monitor-exit(r10)     // Catch:{ all -> 0x00e5 }
        return
    L_0x0013:
        java.util.concurrent.atomic.AtomicInteger r0 = r10.f24164a     // Catch:{ all -> 0x00e5 }
        r2 = 1
        r0.set(r2)     // Catch:{ all -> 0x00e5 }
        monitor-exit(r10)     // Catch:{ all -> 0x00e5 }
        java.lang.String r0 = "read trace first dump for create time!"
        java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x00bd }
        com.tencent.bugly.proguard.C7226an.m31147c(r0, r3)     // Catch:{ all -> 0x00bd }
        com.tencent.bugly.crashreport.crash.anr.TraceFileHelper$a r0 = com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.readFirstDumpInfo(r11, r1)     // Catch:{ all -> 0x00bd }
        r3 = -1
        if (r0 == 0) goto L_0x002c
        long r5 = r0.f24155c     // Catch:{ all -> 0x00bd }
        goto L_0x002d
    L_0x002c:
        r5 = r3
    L_0x002d:
        int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
        if (r0 != 0) goto L_0x003c
        java.lang.String r0 = "trace dump fail could not get time!"
        java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x00bd }
        com.tencent.bugly.proguard.C7226an.m31148d(r0, r3)     // Catch:{ all -> 0x00bd }
        long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00bd }
    L_0x003c:
        r7 = r5
        long r3 = r10.f24165b     // Catch:{ all -> 0x00bd }
        long r3 = r7 - r3
        long r3 = java.lang.Math.abs(r3)     // Catch:{ all -> 0x00bd }
        r5 = 10000(0x2710, double:4.9407E-320)
        int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
        if (r0 >= 0) goto L_0x0060
        java.lang.String r11 = "should not process ANR too Fre in %d"
        java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ all -> 0x00bd }
        r3 = 10000(0x2710, float:1.4013E-41)
        java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00bd }
        r0[r1] = r3     // Catch:{ all -> 0x00bd }
        com.tencent.bugly.proguard.C7226an.m31148d(r11, r0)     // Catch:{ all -> 0x00bd }
    L_0x005a:
        java.util.concurrent.atomic.AtomicInteger r11 = r10.f24164a
        r11.set(r1)
        return
    L_0x0060:
        r10.f24165b = r7     // Catch:{ all -> 0x00bd }
        java.util.concurrent.atomic.AtomicInteger r0 = r10.f24164a     // Catch:{ all -> 0x00bd }
        r0.set(r2)     // Catch:{ all -> 0x00bd }
        int r0 = com.tencent.bugly.crashreport.crash.C7192c.f24192f     // Catch:{ all -> 0x00b1 }
        java.util.Map r9 = com.tencent.bugly.proguard.C7232aq.m31188a(r0, r1)     // Catch:{ all -> 0x00b1 }
        if (r9 == 0) goto L_0x00a9
        int r0 = r9.size()     // Catch:{ all -> 0x00bd }
        if (r0 > 0) goto L_0x0076
        goto L_0x00a9
    L_0x0076:
        android.content.Context r0 = r10.f24166c     // Catch:{ all -> 0x00bd }
        android.app.ActivityManager$ProcessErrorStateInfo r6 = r10.mo34647a(r0, r5)     // Catch:{ all -> 0x00bd }
        if (r6 != 0) goto L_0x0086
        java.lang.String r11 = "proc state is unvisiable!"
        java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch:{ all -> 0x00bd }
        com.tencent.bugly.proguard.C7226an.m31147c(r11, r0)     // Catch:{ all -> 0x00bd }
        goto L_0x005a
    L_0x0086:
        int r0 = r6.pid     // Catch:{ all -> 0x00bd }
        int r3 = android.os.Process.myPid()     // Catch:{ all -> 0x00bd }
        if (r0 == r3) goto L_0x009a
        java.lang.String r11 = "not mind proc!"
        java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ all -> 0x00bd }
        java.lang.String r3 = r6.processName     // Catch:{ all -> 0x00bd }
        r0[r1] = r3     // Catch:{ all -> 0x00bd }
        com.tencent.bugly.proguard.C7226an.m31147c(r11, r0)     // Catch:{ all -> 0x00bd }
        goto L_0x005a
    L_0x009a:
        java.lang.String r0 = "found visiable anr , start to process!"
        java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x00bd }
        com.tencent.bugly.proguard.C7226an.m31141a(r0, r3)     // Catch:{ all -> 0x00bd }
        android.content.Context r4 = r10.f24166c     // Catch:{ all -> 0x00bd }
        r3 = r10
        r5 = r11
        r3.mo34654a(r4, r5, r6, r7, r9)     // Catch:{ all -> 0x00bd }
        goto L_0x00d8
    L_0x00a9:
        java.lang.String r11 = "can't get all thread skip this anr"
        java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch:{ all -> 0x00bd }
        com.tencent.bugly.proguard.C7226an.m31148d(r11, r0)     // Catch:{ all -> 0x00bd }
        goto L_0x005a
    L_0x00b1:
        r11 = move-exception
        com.tencent.bugly.proguard.C7226an.m31142a(r11)     // Catch:{ all -> 0x00bd }
        java.lang.String r11 = "get all thread stack fail!"
        java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch:{ all -> 0x00bd }
        com.tencent.bugly.proguard.C7226an.m31149e(r11, r0)     // Catch:{ all -> 0x00bd }
        goto L_0x005a
    L_0x00bd:
        r11 = move-exception
        boolean r0 = com.tencent.bugly.proguard.C7226an.m31142a(r11)     // Catch:{ all -> 0x00de }
        if (r0 != 0) goto L_0x00c7
        r11.printStackTrace()     // Catch:{ all -> 0x00de }
    L_0x00c7:
        java.lang.String r0 = "handle anr error %s"
        java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x00de }
        java.lang.Class r11 = r11.getClass()     // Catch:{ all -> 0x00de }
        java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00de }
        r2[r1] = r11     // Catch:{ all -> 0x00de }
        com.tencent.bugly.proguard.C7226an.m31149e(r0, r2)     // Catch:{ all -> 0x00de }
    L_0x00d8:
        java.util.concurrent.atomic.AtomicInteger r11 = r10.f24164a
        r11.set(r1)
        return
    L_0x00de:
        r11 = move-exception
        java.util.concurrent.atomic.AtomicInteger r0 = r10.f24164a
        r0.set(r1)
        throw r11
    L_0x00e5:
        r11 = move-exception
        monitor-exit(r10)     // Catch:{ all -> 0x00e5 }
        throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.anr.C7187b.mo34651a(java.lang.String):void");
    }

    /* access modifiers changed from: protected|declared_synchronized */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0048, code lost:
            return;
     */
    /* renamed from: b */
    public synchronized void mo34657b() {
        /*
        r4 = this;
        monitor-enter(r4)
        boolean r0 = r4.mo34660d()     // Catch:{ all -> 0x0049 }
        r1 = 0
        if (r0 == 0) goto L_0x0011
        java.lang.String r0 = "start when started!"
        java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0049 }
        com.tencent.bugly.proguard.C7226an.m31148d(r0, r1)     // Catch:{ all -> 0x0049 }
        monitor-exit(r4)
        return
    L_0x0011:
        com.tencent.bugly.crashreport.crash.anr.b$1 r0 = new com.tencent.bugly.crashreport.crash.anr.b$1     // Catch:{ all -> 0x0049 }
        java.lang.String r2 = "/data/anr/"
        r3 = 8
        r0.m52508init(r2, r3)     // Catch:{ all -> 0x0049 }
        r4.f24172i = r0     // Catch:{ all -> 0x0049 }
        android.os.FileObserver r0 = r4.f24172i     // Catch:{ all -> 0x0033 }
        r0.startWatching()     // Catch:{ all -> 0x0033 }
        java.lang.String r0 = "start anr monitor!"
        java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ all -> 0x0033 }
        com.tencent.bugly.proguard.C7226an.m31141a(r0, r2)     // Catch:{ all -> 0x0033 }
        com.tencent.bugly.proguard.am r0 = r4.f24168e     // Catch:{ all -> 0x0033 }
        com.tencent.bugly.crashreport.crash.anr.b$2 r2 = new com.tencent.bugly.crashreport.crash.anr.b$2     // Catch:{ all -> 0x0033 }
        r2.m52509init()     // Catch:{ all -> 0x0033 }
        r0.mo34832a(r2)     // Catch:{ all -> 0x0033 }
        goto L_0x0047
    L_0x0033:
        r0 = move-exception
        r2 = 0
        r4.f24172i = r2     // Catch:{ all -> 0x0049 }
        java.lang.String r2 = "start anr monitor failed!"
        java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0049 }
        com.tencent.bugly.proguard.C7226an.m31148d(r2, r1)     // Catch:{ all -> 0x0049 }
        boolean r1 = com.tencent.bugly.proguard.C7226an.m31142a(r0)     // Catch:{ all -> 0x0049 }
        if (r1 != 0) goto L_0x0047
        r0.printStackTrace()     // Catch:{ all -> 0x0049 }
    L_0x0047:
        monitor-exit(r4)
        return
    L_0x0049:
        r0 = move-exception
        monitor-exit(r4)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.anr.C7187b.mo34657b():void");
    }

    /* access modifiers changed from: protected|declared_synchronized */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
            return;
     */
    /* renamed from: c */
    public synchronized void mo34659c() {
        /*
        r3 = this;
        monitor-enter(r3)
        boolean r0 = r3.mo34660d()     // Catch:{ all -> 0x0034 }
        r1 = 0
        if (r0 != 0) goto L_0x0011
        java.lang.String r0 = "close when closed!"
        java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0034 }
        com.tencent.bugly.proguard.C7226an.m31148d(r0, r1)     // Catch:{ all -> 0x0034 }
        monitor-exit(r3)
        return
    L_0x0011:
        android.os.FileObserver r0 = r3.f24172i     // Catch:{ all -> 0x0021 }
        r0.stopWatching()     // Catch:{ all -> 0x0021 }
        r0 = 0
        r3.f24172i = r0     // Catch:{ all -> 0x0021 }
        java.lang.String r0 = "close anr monitor!"
        java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ all -> 0x0021 }
        com.tencent.bugly.proguard.C7226an.m31148d(r0, r2)     // Catch:{ all -> 0x0021 }
        goto L_0x0032
    L_0x0021:
        r0 = move-exception
        java.lang.String r2 = "stop anr monitor failed!"
        java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0034 }
        com.tencent.bugly.proguard.C7226an.m31148d(r2, r1)     // Catch:{ all -> 0x0034 }
        boolean r1 = com.tencent.bugly.proguard.C7226an.m31142a(r0)     // Catch:{ all -> 0x0034 }
        if (r1 != 0) goto L_0x0032
        r0.printStackTrace()     // Catch:{ all -> 0x0034 }
    L_0x0032:
        monitor-exit(r3)
        return
    L_0x0034:
        r0 = move-exception
        monitor-exit(r3)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.anr.C7187b.mo34659c():void");
    }

    /* access modifiers changed from: protected|declared_synchronized */
    /* renamed from: d */
    public synchronized boolean mo34660d() {
        return this.f24172i != null;
    }

    /* access modifiers changed from: protected|declared_synchronized */
    /* renamed from: a */
    public synchronized void mo34652a(boolean z) {
        if (z) {
            mo34657b();
        } else {
            mo34659c();
        }
    }

    /* renamed from: e */
    public synchronized boolean mo34661e() {
        return this.f24173j;
    }

    /* renamed from: c */
    private synchronized void m30891c(boolean z) {
        if (this.f24173j != z) {
            C7226an.m31141a("user change anr %b", Boolean.valueOf(z));
            this.f24173j = z;
        }
    }

    /* renamed from: b */
    public void mo34658b(boolean z) {
        m30891c(z);
        boolean e = mo34661e();
        C7177a a = C7177a.m30857a();
        if (a != null) {
            e = e && a.mo34624c().f24057g;
        }
        if (e != mo34660d()) {
            C7226an.m31141a("anr changed to %b", Boolean.valueOf(e));
            mo34652a(e);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:20|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            r12 = new java.lang.StringBuilder();
            r12.append("Trace file that has invalid format: ");
            r12.append(r11);
            com.tencent.bugly.proguard.C7226an.m31147c(r12.toString(), new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x004f */
    /* renamed from: f */
    public void mo34662f() {
        /*
        r14 = this;
        long r0 = com.tencent.bugly.proguard.C7232aq.m31204b()
        long r2 = com.tencent.bugly.crashreport.crash.C7192c.f24193g
        long r0 = r0 - r2
        java.io.File r2 = new java.io.File
        java.lang.String r3 = r14.f24170g
        r2.<init>(r3)
        boolean r3 = r2.exists()
        if (r3 == 0) goto L_0x008c
        boolean r3 = r2.isDirectory()
        if (r3 == 0) goto L_0x008c
        java.io.File[] r2 = r2.listFiles()     // Catch:{ all -> 0x0088 }
        if (r2 == 0) goto L_0x0087
        int r3 = r2.length     // Catch:{ all -> 0x0088 }
        if (r3 != 0) goto L_0x0024
        goto L_0x0087
    L_0x0024:
        java.lang.String r3 = "bugly_trace_"
        java.lang.String r4 = ".txt"
        r5 = 12
        int r6 = r2.length     // Catch:{ all -> 0x0088 }
        r7 = 0
        r8 = 0
        r9 = 0
    L_0x002e:
        if (r8 >= r6) goto L_0x0070
        r10 = r2[r8]     // Catch:{ all -> 0x0088 }
        java.lang.String r11 = r10.getName()     // Catch:{ all -> 0x0088 }
        boolean r12 = r11.startsWith(r3)     // Catch:{ all -> 0x0088 }
        if (r12 == 0) goto L_0x006d
        int r12 = r11.indexOf(r4)     // Catch:{ all -> 0x004f }
        if (r12 <= 0) goto L_0x0065
        java.lang.String r12 = r11.substring(r5, r12)     // Catch:{ all -> 0x004f }
        long r11 = java.lang.Long.parseLong(r12)     // Catch:{ all -> 0x004f }
        int r13 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
        if (r13 < 0) goto L_0x0065
        goto L_0x006d
    L_0x004f:
        java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0088 }
        r12.<init>()     // Catch:{ all -> 0x0088 }
        java.lang.String r13 = "Trace file that has invalid format: "
        r12.append(r13)     // Catch:{ all -> 0x0088 }
        r12.append(r11)     // Catch:{ all -> 0x0088 }
        java.lang.String r11 = r12.toString()     // Catch:{ all -> 0x0088 }
        java.lang.Object[] r12 = new java.lang.Object[r7]     // Catch:{ all -> 0x0088 }
        com.tencent.bugly.proguard.C7226an.m31147c(r11, r12)     // Catch:{ all -> 0x0088 }
    L_0x0065:
        boolean r10 = r10.delete()     // Catch:{ all -> 0x0088 }
        if (r10 == 0) goto L_0x006d
        int r9 = r9 + 1
    L_0x006d:
        int r8 = r8 + 1
        goto L_0x002e
    L_0x0070:
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0088 }
        r0.<init>()     // Catch:{ all -> 0x0088 }
        java.lang.String r1 = "Number of overdue trace files that has deleted: "
        r0.append(r1)     // Catch:{ all -> 0x0088 }
        r0.append(r9)     // Catch:{ all -> 0x0088 }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0088 }
        java.lang.Object[] r1 = new java.lang.Object[r7]     // Catch:{ all -> 0x0088 }
        com.tencent.bugly.proguard.C7226an.m31147c(r0, r1)     // Catch:{ all -> 0x0088 }
        goto L_0x008c
    L_0x0087:
        return
    L_0x0088:
        r0 = move-exception
        com.tencent.bugly.proguard.C7226an.m31142a(r0)
    L_0x008c:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.anr.C7187b.mo34662f():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0054, code lost:
            return;
     */
    /* renamed from: a */
    public synchronized void mo34650a(com.tencent.bugly.crashreport.common.strategy.StrategyBean r6) {
        /*
        r5 = this;
        monitor-enter(r5)
        if (r6 != 0) goto L_0x0005
        monitor-exit(r5)
        return
    L_0x0005:
        boolean r0 = r6.f24060j     // Catch:{ all -> 0x0055 }
        boolean r1 = r5.mo34660d()     // Catch:{ all -> 0x0055 }
        r2 = 0
        r3 = 1
        if (r0 == r1) goto L_0x001e
        java.lang.String r0 = "server anr changed to %b"
        java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ all -> 0x0055 }
        boolean r4 = r6.f24060j     // Catch:{ all -> 0x0055 }
        java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x0055 }
        r1[r2] = r4     // Catch:{ all -> 0x0055 }
        com.tencent.bugly.proguard.C7226an.m31148d(r0, r1)     // Catch:{ all -> 0x0055 }
    L_0x001e:
        int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0055 }
        r1 = 19
        if (r0 > r1) goto L_0x0048
        boolean r6 = r6.f24060j     // Catch:{ all -> 0x0055 }
        if (r6 == 0) goto L_0x0030
        boolean r6 = r5.mo34661e()     // Catch:{ all -> 0x0055 }
        if (r6 == 0) goto L_0x0030
        r6 = 1
        goto L_0x0031
    L_0x0030:
        r6 = 0
    L_0x0031:
        boolean r0 = r5.mo34660d()     // Catch:{ all -> 0x0055 }
        if (r6 == r0) goto L_0x0053
        java.lang.String r0 = "anr changed to %b"
        java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ all -> 0x0055 }
        java.lang.Boolean r3 = java.lang.Boolean.valueOf(r6)     // Catch:{ all -> 0x0055 }
        r1[r2] = r3     // Catch:{ all -> 0x0055 }
        com.tencent.bugly.proguard.C7226an.m31141a(r0, r1)     // Catch:{ all -> 0x0055 }
        r5.mo34652a(r6)     // Catch:{ all -> 0x0055 }
        goto L_0x0053
    L_0x0048:
        boolean r6 = r6.f24060j     // Catch:{ all -> 0x0055 }
        if (r6 == 0) goto L_0x0050
        r5.mo34664h()     // Catch:{ all -> 0x0055 }
        goto L_0x0053
    L_0x0050:
        r5.mo34665i()     // Catch:{ all -> 0x0055 }
    L_0x0053:
        monitor-exit(r5)
        return
    L_0x0055:
        r6 = move-exception
        monitor-exit(r5)
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.anr.C7187b.mo34650a(com.tencent.bugly.crashreport.common.strategy.StrategyBean):void");
    }

    /* renamed from: g */
    public void mo34663g() {
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i < 30) {
                try {
                    C7226an.m31141a("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", Integer.valueOf(i2));
                    C7232aq.m31209b(5000);
                    i = i2;
                } catch (Throwable th) {
                    if (!C7226an.m31142a(th)) {
                        th.printStackTrace();
                        return;
                    }
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public boolean mo34656a(Thread thread) {
        new HashMap();
        if (thread.getName().contains("main")) {
            ProcessErrorStateInfo a = mo34647a(this.f24166c, 10000);
            if (a == null) {
                C7226an.m31147c("anr handler onThreadBlock proc state is unvisiable!", new Object[0]);
                return false;
            } else if (a.pid != Process.myPid()) {
                C7226an.m31147c("onThreadBlock not mind proc!", a.processName);
                return false;
            } else {
                try {
                    Map a2 = C7232aq.m31188a(200000, false);
                    C7226an.m31141a("onThreadBlock found visiable anr , start to process!", new Object[0]);
                    mo34654a(this.f24166c, "", a, System.currentTimeMillis(), a2);
                } catch (Throwable unused) {
                    return false;
                }
            }
        } else {
            C7226an.m31147c("anr handler onThreadBlock only care main thread", new Object[0]);
        }
        return true;
    }

    /* renamed from: h */
    public boolean mo34664h() {
        C7234as asVar = this.f24174k;
        if (asVar != null && asVar.isAlive()) {
            return false;
        }
        this.f24174k = new C7234as();
        C7234as asVar2 = this.f24174k;
        StringBuilder sb = new StringBuilder();
        sb.append("Bugly-ThreadMonitor");
        int i = this.f24175l;
        this.f24175l = i + 1;
        sb.append(i);
        asVar2.setName(sb.toString());
        this.f24174k.mo34848a();
        this.f24174k.mo34851a((C7235at) this);
        return this.f24174k.mo34856d();
    }

    /* renamed from: i */
    public boolean mo34665i() {
        C7234as asVar = this.f24174k;
        if (asVar == null) {
            return false;
        }
        asVar.mo34852b();
        this.f24174k.mo34854b((C7235at) this);
        boolean c = this.f24174k.mo34855c();
        this.f24174k = null;
        return c;
    }
}
