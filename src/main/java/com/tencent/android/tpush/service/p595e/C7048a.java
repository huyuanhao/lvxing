package com.tencent.android.tpush.service.p595e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.p522qq.taf.jce.JceStruct;
import com.tencent.android.tpush.p580b.C6864a;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.e.a */
public class C7048a {
    /* renamed from: a */
    public static int f23428a = 0;
    /* renamed from: b */
    private static final String f23429b = C7048a.class.getSimpleName();
    /* renamed from: c */
    private static Uri f23430c = Uri.parse("content://telephony/carriers/preferapn");

    /* renamed from: a */
    public static byte m30138a(Context context) {
        int c = m30141c(context);
        if (c == 1) {
            return 2;
        }
        if (c == 2) {
            return 3;
        }
        if (c == 4) {
            return 1;
        }
        if (c == 8) {
            return 4;
        }
        if (c == 16) {
            return 5;
        }
        if (c == 32) {
            return 6;
        }
        if (c == 64) {
            return 7;
        }
        if (c == 256) {
            return 8;
        }
        if (c == 512) {
            return 9;
        }
        if (c == 1024) {
            return 10;
        }
        if (c != 2048) {
            return 0;
        }
        return JceStruct.STRUCT_END;
    }

    /* JADX INFO: unreachable blocks removed: 1, instructions: 1 */
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:37:0x0047 in {} preds:[B:26:0x0037, B:29:0x003b]
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
    public static java.lang.String m30140b(android.content.Context r8) {
        /*
        r0 = 0
        android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ Exception -> 0x003f }
        android.net.Uri r2 = f23430c     // Catch:{ Exception -> 0x003f }
        r3 = 0     // Catch:{ Exception -> 0x003f }
        r4 = 0     // Catch:{ Exception -> 0x003f }
        r5 = 0     // Catch:{ Exception -> 0x003f }
        r6 = 0     // Catch:{ Exception -> 0x003f }
        android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x003f }
        if (r8 != 0) goto L_0x0017
        if (r8 == 0) goto L_0x0016
        r8.close()     // Catch:{ Exception -> 0x0016 }
    L_0x0016:
        return r0
    L_0x0017:
        r8.moveToFirst()     // Catch:{ Exception -> 0x0038, all -> 0x0036 }
        boolean r1 = r8.isAfterLast()     // Catch:{ Exception -> 0x0038, all -> 0x0036 }
        if (r1 == 0) goto L_0x0026
        if (r8 == 0) goto L_0x0025
        r8.close()     // Catch:{ Exception -> 0x0025 }
    L_0x0025:
        return r0
    L_0x0026:
        java.lang.String r0 = "proxy"
        int r0 = r8.getColumnIndex(r0)     // Catch:{ Exception -> 0x0038, all -> 0x0036 }
        java.lang.String r0 = r8.getString(r0)     // Catch:{ Exception -> 0x0038, all -> 0x0036 }
        if (r8 == 0) goto L_0x0035
        r8.close()     // Catch:{ Exception -> 0x0035 }
    L_0x0035:
        return r0
    L_0x0036:
        r0 = move-exception
        goto L_0x0047
    L_0x0038:
        r0 = r8
        goto L_0x003f
    L_0x003a:
        r8 = move-exception
        r7 = r0
        r0 = r8
        r8 = r7
        goto L_0x0047
    L_0x003f:
        java.lang.String r8 = ""
        if (r0 == 0) goto L_0x0046
        r0.close()     // Catch:{ Exception -> 0x0046 }
    L_0x0046:
        return r8
    L_0x0047:
        if (r8 == 0) goto L_0x004c
        r8.close()     // Catch:{ Exception -> 0x004c }
    L_0x004c:
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.service.p595e.C7048a.m30140b(android.content.Context):java.lang.String");
    }

    /* renamed from: c */
    public static int m30141c(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return 128;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return 128;
            }
            if (activeNetworkInfo.getTypeName().toUpperCase(Locale.US).equals("WIFI")) {
                return 2;
            }
            if (activeNetworkInfo.getExtraInfo() == null) {
                return 128;
            }
            String lowerCase = activeNetworkInfo.getExtraInfo().toLowerCase(Locale.US);
            if (lowerCase.startsWith("cmwap")) {
                return 1;
            }
            if (!lowerCase.startsWith("cmnet")) {
                if (!lowerCase.startsWith("epc.tmobile.com")) {
                    if (lowerCase.startsWith("uniwap")) {
                        return 16;
                    }
                    if (lowerCase.startsWith("uninet")) {
                        return 8;
                    }
                    if (lowerCase.startsWith("wap")) {
                        return 64;
                    }
                    if (lowerCase.startsWith("net")) {
                        return 32;
                    }
                    if (lowerCase.startsWith("ctwap")) {
                        return 512;
                    }
                    if (lowerCase.startsWith("ctnet")) {
                        return 256;
                    }
                    if (lowerCase.startsWith("3gwap")) {
                        return 1024;
                    }
                    if (lowerCase.startsWith("3gnet")) {
                        return 2048;
                    }
                    if (lowerCase.startsWith("#777")) {
                        String b = m30140b(context);
                        if (b == null || b.length() <= 0) {
                            return 256;
                        }
                        return 512;
                    }
                    return 128;
                }
            }
            return 4;
        } catch (Exception e) {
            C6864a.m29302d(f23429b, "getMProxyType>>> ", e);
        }
    }

    /* renamed from: a */
    public static boolean m30139a() {
        boolean z = false;
        try {
            Process exec = Runtime.getRuntime().exec("ping -c 1 -w 10 www.qq.com");
            int waitFor = exec.waitFor();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            while (bufferedReader.readLine() != null) {
            }
            bufferedReader.close();
            exec.destroy();
            if (waitFor == 0) {
                z = true;
            }
            return z;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: d */
    public static boolean m30142d(Context context) {
        boolean z = false;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                if (connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected()) {
                    z = true;
                }
                return z;
            }
        } catch (Exception e) {
            if (m30139a()) {
                return true;
            }
            C6864a.m29302d(f23429b, "APNUtil -> checkNetWork", e);
            f23428a++;
            if (f23428a >= 5) {
                f23428a = 0;
                return true;
            }
        }
        return false;
    }
}
