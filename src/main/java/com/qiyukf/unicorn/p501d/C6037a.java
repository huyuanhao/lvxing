package com.qiyukf.unicorn.p501d;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.qiyukf.basesdk.p394b.p395a.p404c.C5314b;
import com.qiyukf.basesdk.p412c.C5361a;
import com.qiyukf.basesdk.p412c.p417d.C5411c;
import com.qiyukf.basesdk.p412c.p417d.C5413e;
import com.qiyukf.nimlib.C5743d;
import com.qiyukf.nimlib.p450b.C5728f;
import com.qiyukf.nimlib.sdk.auth.LoginInfo;
import com.qiyukf.nimlib.service.NimService;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.p499b.C6014b;
import com.qiyukf.unicorn.p503f.C6165b;
import com.qiyukf.unicorn.p503f.C6168c;
import com.qiyukf.unicorn.p514h.C6187d;
import com.tencent.mid.core.Constants.ERROR;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.qiyukf.unicorn.d.a */
public final class C6037a {
    /* renamed from: a */
    private static Throwable f18873a;
    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static AtomicBoolean f18874b = new AtomicBoolean(false);

    /* renamed from: com.qiyukf.unicorn.d.a$a */
    private enum C6039a {
        UNKNOWN,
        IN_WRONG_PROCESS,
        INIT_EXCEPTION,
        INIT_BUT_NET_BROKEN,
        INVALID_APP_KEY,
        ASSETS_ABSENT,
        SERVICE_NOT_DECLARED,
        NET_NOT_CONNECTED,
        CAN_NOT_CREATE_USER,
        STATUS_NOT_LOGIN,
        SESSION_STATUS,
        NOTIFICATION_NULL,
        NOTIFICATION_OFF,
        NOTIFICATION_NIM,
        IMAGE_LOADER_NULL
    }

    /* renamed from: com.qiyukf.unicorn.d.a$b */
    private static class C6040b {
        /* renamed from: a */
        C6039a f18892a;
        /* renamed from: b */
        String f18893b;

        C6040b(C6039a aVar, String str) {
            this.f18892a = aVar;
            this.f18893b = str;
        }
    }

    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r3v0, types: [java.io.FileReader] */
    /* JADX WARNING: type inference failed for: r2v0, types: [java.io.FileWriter] */
    /* JADX WARNING: type inference failed for: r3v1, types: [java.io.FileReader] */
    /* JADX WARNING: type inference failed for: r1v4, types: [java.io.FileWriter] */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r2v3, types: [java.io.FileWriter] */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r1v6, types: [java.io.FileReader] */
    /* JADX WARNING: type inference failed for: r3v7, types: [java.io.FileReader] */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v4
  assigns: []
  uses: []
	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:231)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:95)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:88)
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
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0076 A[SYNTHETIC, Splitter:B:35:0x0076] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x007e A[Catch:{ IOException -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008a A[SYNTHETIC, Splitter:B:46:0x008a] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0092 A[Catch:{ IOException -> 0x008e }] */
    /* JADX WARNING: Unknown variable types count: 6 */
    /* renamed from: a */
    private static java.lang.String m24060a(java.lang.String r8) {
        /*
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.io.File r1 = android.os.Environment.getExternalStorageDirectory()
        java.lang.String r1 = r1.getPath()
        r0.append(r1)
        java.lang.String r1 = "/qiyu_diagnose_result.log"
        r0.append(r1)
        java.lang.String r0 = r0.toString()
        r1 = 0
        java.io.FileWriter r2 = new java.io.FileWriter     // Catch:{ IOException -> 0x006f, all -> 0x006b }
        r2.<init>(r0)     // Catch:{ IOException -> 0x006f, all -> 0x006b }
        r2.write(r8)     // Catch:{ IOException -> 0x0067, all -> 0x0064 }
        com.qiyukf.basesdk.a.c r8 = com.qiyukf.basesdk.p393a.C5264a.m21615a()     // Catch:{ IOException -> 0x0067, all -> 0x0064 }
        if (r8 == 0) goto L_0x005b
        java.lang.String r8 = r8.mo27111b()     // Catch:{ IOException -> 0x0067, all -> 0x0064 }
        java.io.FileReader r3 = new java.io.FileReader     // Catch:{ IOException -> 0x0067, all -> 0x0064 }
        r3.<init>(r8)     // Catch:{ IOException -> 0x0067, all -> 0x0064 }
        java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x0059, all -> 0x0057 }
        r1.<init>(r8)     // Catch:{ IOException -> 0x0059, all -> 0x0057 }
        long r4 = r1.length()     // Catch:{ IOException -> 0x0059, all -> 0x0057 }
        r6 = 102400(0x19000, double:5.05923E-319)
        int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
        if (r8 <= 0) goto L_0x0045
        long r4 = r4 - r6
        r3.skip(r4)     // Catch:{ IOException -> 0x0059, all -> 0x0057 }
    L_0x0045:
        r8 = 1024(0x400, float:1.435E-42)
        char[] r8 = new char[r8]     // Catch:{ IOException -> 0x0059, all -> 0x0057 }
    L_0x0049:
        int r1 = r3.read(r8)     // Catch:{ IOException -> 0x0059, all -> 0x0057 }
        r4 = -1
        if (r1 == r4) goto L_0x0055
        r4 = 0
        r2.write(r8, r4, r1)     // Catch:{ IOException -> 0x0059, all -> 0x0057 }
        goto L_0x0049
    L_0x0055:
        r1 = r3
        goto L_0x005b
    L_0x0057:
        r8 = move-exception
        goto L_0x0088
    L_0x0059:
        r8 = move-exception
        goto L_0x0069
    L_0x005b:
        r2.close()     // Catch:{ IOException -> 0x007a }
        if (r1 == 0) goto L_0x0085
        r1.close()     // Catch:{ IOException -> 0x007a }
        goto L_0x0085
    L_0x0064:
        r8 = move-exception
        r3 = r1
        goto L_0x0088
    L_0x0067:
        r8 = move-exception
        r3 = r1
    L_0x0069:
        r1 = r2
        goto L_0x0071
    L_0x006b:
        r8 = move-exception
        r2 = r1
        r3 = r2
        goto L_0x0088
    L_0x006f:
        r8 = move-exception
        r3 = r1
    L_0x0071:
        r8.printStackTrace()     // Catch:{ all -> 0x0086 }
        if (r1 == 0) goto L_0x007c
        r1.close()     // Catch:{ IOException -> 0x007a }
        goto L_0x007c
    L_0x007a:
        r8 = move-exception
        goto L_0x0082
    L_0x007c:
        if (r3 == 0) goto L_0x0085
        r3.close()     // Catch:{ IOException -> 0x007a }
        goto L_0x0085
    L_0x0082:
        r8.printStackTrace()
    L_0x0085:
        return r0
    L_0x0086:
        r8 = move-exception
        r2 = r1
    L_0x0088:
        if (r2 == 0) goto L_0x0090
        r2.close()     // Catch:{ IOException -> 0x008e }
        goto L_0x0090
    L_0x008e:
        r0 = move-exception
        goto L_0x0096
    L_0x0090:
        if (r3 == 0) goto L_0x0099
        r3.close()     // Catch:{ IOException -> 0x008e }
        goto L_0x0099
    L_0x0096:
        r0.printStackTrace()
    L_0x0099:
        throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.unicorn.p501d.C6037a.m24060a(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    private static String m24061a(List<C6040b> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("problems found: ");
        String str = "line.separator";
        sb.append(System.getProperty(str));
        for (C6040b bVar : list) {
            StringBuilder sb2 = new StringBuilder("**");
            sb2.append(bVar.f18892a);
            sb2.append("** ");
            sb2.append(bVar.f18893b);
            sb.append(sb2.toString());
            sb.append(System.getProperty(str));
        }
        sb.append("============================");
        sb.append(System.getProperty(str));
        sb.append(C6041b.m24069a());
        sb.append(System.getProperty(str));
        String sb3 = sb.toString();
        Log.e("Diagnose", sb3);
        return m24060a(sb3);
    }

    /* renamed from: a */
    public static void m24063a(final Context context) {
        if (!f18874b.getAndSet(true)) {
            C5361a.m22013a().mo27317c().post(new Runnable() {
                public final void run() {
                    String b = C6037a.m24066c(context);
                    StringBuilder sb = new StringBuilder("log path: ");
                    sb.append(b);
                    Log.e("Diagnose", sb.toString());
                    Context context = context;
                    StringBuilder sb2 = new StringBuilder("dump log to: ");
                    sb2.append(b);
                    Toast.makeText(context, sb2.toString(), 1).show();
                    C6037a.f18874b.set(false);
                }
            });
        }
    }

    /* renamed from: a */
    public static void m24064a(Throwable th) {
        f18873a = th;
    }

    /* access modifiers changed from: private|static */
    /* renamed from: c */
    public static String m24066c(Context context) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            ArrayList arrayList = new ArrayList();
            C6040b bVar = null;
            try {
                C6029d.m24026a();
            } catch (Throwable unused) {
                bVar = !C5413e.m22155b(applicationContext) ? new C6040b(C6039a.IN_WRONG_PROCESS, C5413e.m22152a(applicationContext)) : f18873a != null ? new C6040b(C6039a.INIT_EXCEPTION, Log.getStackTraceString(f18873a)) : new C6040b(C6039a.UNKNOWN, "unknown problem in initialization");
            }
            if (bVar == null) {
                bVar = m24067d(applicationContext);
            }
            if (bVar == null) {
                bVar = m24068e(applicationContext);
            }
            if (bVar != null) {
                arrayList.add(bVar);
                return m24061a((List<C6040b>) arrayList);
            }
            if (!C5743d.m23120e().logined()) {
                C6039a aVar = C6039a.STATUS_NOT_LOGIN;
                StringBuilder sb = new StringBuilder("status is ");
                sb.append(C5743d.m23120e());
                arrayList.add(new C6040b(aVar, sb.toString()));
            }
            C6039a aVar2 = C6039a.SESSION_STATUS;
            C6187d g = C6029d.m24047g();
            StringBuilder sb2 = new StringBuilder("queue: ");
            String str = ERROR.CMD_FORMAT_ERROR;
            sb2.append(g.mo29277a(str));
            sb2.append(", type: ");
            sb2.append(g.mo29301f(str));
            sb2.append(", isSelecting: ");
            sb2.append(C6187d.m24552j(str));
            arrayList.add(new C6040b(aVar2, sb2.toString()));
            if (C6029d.m24045e().statusBarNotificationConfig == null) {
                arrayList.add(new C6040b(C6039a.NOTIFICATION_NULL, "notify config is not set"));
            }
            if (!C6014b.m23969l()) {
                arrayList.add(new C6040b(C6039a.NOTIFICATION_OFF, "notify toggle is off now"));
            }
            try {
                Class.forName("com.netease.nim.sdk.NimClient");
                arrayList.add(new C6040b(C6039a.NOTIFICATION_NIM, "maybe confusing with nim"));
            } catch (Exception unused2) {
            }
            if (C6029d.m24046f() == null) {
                arrayList.add(new C6040b(C6039a.IMAGE_LOADER_NULL, "ImageLoader is null"));
            }
            return m24061a((List<C6040b>) arrayList);
        }
        throw new NullPointerException("diagnose context is null");
    }

    /* renamed from: d */
    private static C6040b m24067d(Context context) {
        String str = "appkey: ";
        if (new LoginInfo(C6014b.m23921a(), C6014b.m23934b()).valid()) {
            return null;
        }
        if (!C5411c.m22135b(context)) {
            return new C6040b(C6039a.INIT_BUT_NET_BROKEN, "init when network is not available");
        }
        String d = C6029d.m24043d();
        if (TextUtils.isEmpty(d) || !d.toLowerCase().equals(d)) {
            return new C6040b(C6039a.INVALID_APP_KEY, d);
        }
        String str2 = "Diagnose";
        Log.e(str2, "checking network connection...");
        try {
            C5314b.m21851b(C5728f.m23060a(), "GET", str2);
            try {
                C6165b a = C6168c.m24475a(d, C6014b.m23948d());
                if (a != null && a.mo29234a() != null && a.mo29234a().valid()) {
                    return new C6040b(C6039a.UNKNOWN, "unknown error when create nim user");
                }
                C6039a aVar = C6039a.CAN_NOT_CREATE_USER;
                StringBuilder sb = new StringBuilder(str);
                sb.append(d);
                sb.append(", response: ");
                sb.append(a);
                return new C6040b(aVar, sb.toString());
            } catch (Exception e) {
                C6039a aVar2 = C6039a.CAN_NOT_CREATE_USER;
                StringBuilder sb2 = new StringBuilder(str);
                sb2.append(d);
                sb2.append(", ");
                sb2.append(Log.getStackTraceString(e));
                return new C6040b(aVar2, sb2.toString());
            }
        } catch (Exception e2) {
            return new C6040b(C6039a.NET_NOT_CONNECTED, Log.getStackTraceString(e2));
        }
    }

    /* renamed from: e */
    private static C6040b m24068e(Context context) {
        try {
            context.getAssets().open("keystore_unicorn");
            try {
                context.getPackageManager().getServiceInfo(new ComponentName(context.getPackageName(), NimService.class.getName()), 0);
                return null;
            } catch (NameNotFoundException unused) {
                return new C6040b(C6039a.SERVICE_NOT_DECLARED, "NimService not found in AndroidManifest");
            }
        } catch (IOException unused2) {
            return new C6040b(C6039a.ASSETS_ABSENT, "assets folder is absent");
        }
    }
}
