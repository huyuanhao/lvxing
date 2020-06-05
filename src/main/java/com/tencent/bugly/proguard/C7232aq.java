package com.tencent.bugly.proguard;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Process;
import com.tencent.android.tpush.common.Constants;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.bugly.crashreport.common.info.C7174a;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.aq */
public class C7232aq {
    /* renamed from: a */
    private static Map<String, String> f24426a = null;
    /* renamed from: b */
    private static boolean f24427b = false;

    /* renamed from: a */
    public static String m31183a(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.getBuffer().toString();
        } catch (Throwable th2) {
            if (!C7226an.m31142a(th2)) {
                th2.printStackTrace();
            }
            return "fail";
        }
    }

    /* renamed from: a */
    public static String m31178a() {
        return m31179a(System.currentTimeMillis());
    }

    /* renamed from: a */
    public static String m31179a(long j) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(j));
        } catch (Exception unused) {
            return new Date().toString();
        }
    }

    /* renamed from: a */
    public static String m31184a(Date date) {
        if (date == null) {
            return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(date);
        } catch (Exception unused) {
            return new Date().toString();
        }
    }

    /* renamed from: a */
    public static byte[] m31203a(byte[] bArr, int i, String str) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        C7226an.m31147c("rqdp{  enD:} %d %d", Integer.valueOf(bArr.length), Integer.valueOf(i));
        try {
            C7244bb a = C7243ba.m31259a(i);
            if (a == null) {
                return null;
            }
            a.mo34860a(str);
            return a.mo34862b(bArr);
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: b */
    public static byte[] m31217b(byte[] bArr, int i, String str) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        try {
            C7244bb a = C7243ba.m31259a(i);
            if (a == null) {
                return null;
            }
            a.mo34860a(str);
            return a.mo34861a(bArr);
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
            C7226an.m31148d("encrytype %d %s", Integer.valueOf(i), str);
            return null;
        }
    }

    /* JADX WARNING: type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r8v1, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r8v2, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r6v6, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r6v11 */
    /* JADX WARNING: type inference failed for: r8v3 */
    /* JADX WARNING: type inference failed for: r8v4 */
    /* JADX WARNING: type inference failed for: r8v5 */
    /* JADX WARNING: type inference failed for: r8v6, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r6v14, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r8v7 */
    /* JADX WARNING: type inference failed for: r8v8 */
    /* JADX WARNING: type inference failed for: r8v9 */
    /* JADX WARNING: type inference failed for: r8v10 */
    /* JADX WARNING: type inference failed for: r6v15 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.String, code=null, for r8v0, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r8v4
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
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005b A[Catch:{ all -> 0x0094 }, LOOP:0: B:22:0x005b->B:24:0x0061, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006b A[Catch:{ all -> 0x0094 }, LOOP:1: B:25:0x0065->B:27:0x006b, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007e A[SYNTHETIC, Splitter:B:30:0x007e] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009e A[Catch:{ all -> 0x00bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a3 A[SYNTHETIC, Splitter:B:48:0x00a3] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ad A[SYNTHETIC, Splitter:B:53:0x00ad] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x006f A[EDGE_INSN: B:74:0x006f->B:28:0x006f ?: BREAK  
EDGE_INSN: B:74:0x006f->B:28:0x006f ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 7 */
    /* renamed from: a */
    public static byte[] m31200a(java.io.File r6, java.lang.String r7, ? r8) {
        /*
        r0 = 0
        if (r7 == 0) goto L_0x00d6
        int r1 = r7.length()
        if (r1 != 0) goto L_0x000b
        goto L_0x00d6
    L_0x000b:
        r1 = 0
        java.lang.Object[] r2 = new java.lang.Object[r1]
        java.lang.String r3 = "rqdp{  ZF start}"
        com.tencent.bugly.proguard.C7226an.m31147c(r3, r2)
        java.lang.String r2 = "rqdp{  ZF end}"
        if (r6 == 0) goto L_0x0031
        boolean r3 = r6.exists()     // Catch:{ all -> 0x002d }
        if (r3 == 0) goto L_0x0031
        boolean r3 = r6.canRead()     // Catch:{ all -> 0x002d }
        if (r3 == 0) goto L_0x0031
        java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ all -> 0x002d }
        r8.<init>(r6)     // Catch:{ all -> 0x002d }
        java.lang.String r6 = r6.getName()     // Catch:{ all -> 0x0096 }
        goto L_0x0033
    L_0x002d:
        r6 = move-exception
        r8 = r0
        r4 = r8
        goto L_0x0098
    L_0x0031:
        r6 = r8
        r8 = r0
    L_0x0033:
        java.lang.String r3 = "UTF-8"
        byte[] r7 = r7.getBytes(r3)     // Catch:{ all -> 0x0096 }
        java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0096 }
        r3.<init>(r7)     // Catch:{ all -> 0x0096 }
        java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0096 }
        r7.<init>()     // Catch:{ all -> 0x0096 }
        java.util.zip.ZipOutputStream r4 = new java.util.zip.ZipOutputStream     // Catch:{ all -> 0x0096 }
        r4.<init>(r7)     // Catch:{ all -> 0x0096 }
        r5 = 8
        r4.setMethod(r5)     // Catch:{ all -> 0x0094 }
        java.util.zip.ZipEntry r5 = new java.util.zip.ZipEntry     // Catch:{ all -> 0x0094 }
        r5.<init>(r6)     // Catch:{ all -> 0x0094 }
        r4.putNextEntry(r5)     // Catch:{ all -> 0x0094 }
        r6 = 1024(0x400, float:1.435E-42)
        byte[] r6 = new byte[r6]     // Catch:{ all -> 0x0094 }
        if (r8 == 0) goto L_0x0065
    L_0x005b:
        int r5 = r8.read(r6)     // Catch:{ all -> 0x0094 }
        if (r5 <= 0) goto L_0x0065
        r4.write(r6, r1, r5)     // Catch:{ all -> 0x0094 }
        goto L_0x005b
    L_0x0065:
        int r5 = r3.read(r6)     // Catch:{ all -> 0x0094 }
        if (r5 <= 0) goto L_0x006f
        r4.write(r6, r1, r5)     // Catch:{ all -> 0x0094 }
        goto L_0x0065
    L_0x006f:
        r4.closeEntry()     // Catch:{ all -> 0x0094 }
        r4.flush()     // Catch:{ all -> 0x0094 }
        r4.finish()     // Catch:{ all -> 0x0094 }
        byte[] r6 = r7.toByteArray()     // Catch:{ all -> 0x0094 }
        if (r8 == 0) goto L_0x0086
        r8.close()     // Catch:{ IOException -> 0x0082 }
        goto L_0x0086
    L_0x0082:
        r7 = move-exception
        r7.printStackTrace()
    L_0x0086:
        r4.close()     // Catch:{ IOException -> 0x008a }
        goto L_0x008e
    L_0x008a:
        r7 = move-exception
        r7.printStackTrace()
    L_0x008e:
        java.lang.Object[] r7 = new java.lang.Object[r1]
        com.tencent.bugly.proguard.C7226an.m31147c(r2, r7)
        return r6
    L_0x0094:
        r6 = move-exception
        goto L_0x0098
    L_0x0096:
        r6 = move-exception
        r4 = r0
    L_0x0098:
        boolean r7 = com.tencent.bugly.proguard.C7226an.m31142a(r6)     // Catch:{ all -> 0x00bb }
        if (r7 != 0) goto L_0x00a1
        r6.printStackTrace()     // Catch:{ all -> 0x00bb }
    L_0x00a1:
        if (r8 == 0) goto L_0x00ab
        r8.close()     // Catch:{ IOException -> 0x00a7 }
        goto L_0x00ab
    L_0x00a7:
        r6 = move-exception
        r6.printStackTrace()
    L_0x00ab:
        if (r4 == 0) goto L_0x00b5
        r4.close()     // Catch:{ IOException -> 0x00b1 }
        goto L_0x00b5
    L_0x00b1:
        r6 = move-exception
        r6.printStackTrace()
    L_0x00b5:
        java.lang.Object[] r6 = new java.lang.Object[r1]
        com.tencent.bugly.proguard.C7226an.m31147c(r2, r6)
        return r0
    L_0x00bb:
        r6 = move-exception
        if (r8 == 0) goto L_0x00c6
        r8.close()     // Catch:{ IOException -> 0x00c2 }
        goto L_0x00c6
    L_0x00c2:
        r7 = move-exception
        r7.printStackTrace()
    L_0x00c6:
        if (r4 == 0) goto L_0x00d0
        r4.close()     // Catch:{ IOException -> 0x00cc }
        goto L_0x00d0
    L_0x00cc:
        r7 = move-exception
        r7.printStackTrace()
    L_0x00d0:
        java.lang.Object[] r7 = new java.lang.Object[r1]
        com.tencent.bugly.proguard.C7226an.m31147c(r2, r7)
        throw r6
    L_0x00d6:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7232aq.m31200a(java.io.File, java.lang.String, java.lang.String):byte[]");
    }

    /* renamed from: a */
    public static byte[] m31201a(byte[] bArr, int i) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(bArr.length);
        objArr[1] = i == 2 ? "Gzip" : "zip";
        C7226an.m31147c("[Util] Zip %d bytes data with type %s", objArr);
        try {
            C7237av a = C7236au.m31244a(i);
            if (a == null) {
                return null;
            }
            return a.mo34858a(bArr);
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: b */
    public static byte[] m31215b(byte[] bArr, int i) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(bArr.length);
        objArr[1] = i == 2 ? "Gzip" : "zip";
        C7226an.m31147c("[Util] Unzip %d bytes data with type %s", objArr);
        try {
            C7237av a = C7236au.m31244a(i);
            if (a == null) {
                return null;
            }
            return a.mo34859b(bArr);
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m31202a(byte[] bArr, int i, int i2, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return m31203a(m31201a(bArr, i), i2, str);
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: b */
    public static byte[] m31216b(byte[] bArr, int i, int i2, String str) {
        try {
            return m31215b(m31217b(bArr, i2, str), i);
        } catch (Exception e) {
            if (!C7226an.m31142a(e)) {
                e.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: b */
    public static long m31204b() {
        try {
            return (((System.currentTimeMillis() + ((long) TimeZone.getDefault().getRawOffset())) / 86400000) * 86400000) - ((long) TimeZone.getDefault().getRawOffset());
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
            return -1;
        }
    }

    /* renamed from: a */
    public static String m31185a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            if (hexString.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString().toUpperCase();
    }

    /* renamed from: b */
    public static String m31207b(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "NULL";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(bArr);
            return m31185a(instance.digest());
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x004b A[Catch:{ all -> 0x006a }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0050 A[SYNTHETIC, Splitter:B:30:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x005c A[Catch:{ all -> 0x006a }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0061 A[SYNTHETIC, Splitter:B:39:0x0061] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x006d A[SYNTHETIC, Splitter:B:46:0x006d] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:25:0x0045=Splitter:B:25:0x0045, B:34:0x0056=Splitter:B:34:0x0056} */
    /* renamed from: a */
    public static java.lang.String m31182a(java.io.File r4, java.lang.String r5) {
        /*
        r0 = 0
        if (r4 == 0) goto L_0x0076
        boolean r1 = r4.exists()
        if (r1 == 0) goto L_0x0076
        boolean r1 = r4.canRead()
        if (r1 != 0) goto L_0x0011
        goto L_0x0076
    L_0x0011:
        java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0054, NoSuchAlgorithmException -> 0x0043, all -> 0x0040 }
        r1.<init>(r4)     // Catch:{ IOException -> 0x0054, NoSuchAlgorithmException -> 0x0043, all -> 0x0040 }
        java.security.MessageDigest r4 = java.security.MessageDigest.getInstance(r5)     // Catch:{ IOException -> 0x003e, NoSuchAlgorithmException -> 0x003c }
        r5 = 102400(0x19000, float:1.43493E-40)
        byte[] r5 = new byte[r5]     // Catch:{ IOException -> 0x003e, NoSuchAlgorithmException -> 0x003c }
    L_0x001f:
        int r2 = r1.read(r5)     // Catch:{ IOException -> 0x003e, NoSuchAlgorithmException -> 0x003c }
        r3 = -1
        if (r2 == r3) goto L_0x002b
        r3 = 0
        r4.update(r5, r3, r2)     // Catch:{ IOException -> 0x003e, NoSuchAlgorithmException -> 0x003c }
        goto L_0x001f
    L_0x002b:
        byte[] r4 = r4.digest()     // Catch:{ IOException -> 0x003e, NoSuchAlgorithmException -> 0x003c }
        java.lang.String r4 = m31185a(r4)     // Catch:{ IOException -> 0x003e, NoSuchAlgorithmException -> 0x003c }
        r1.close()     // Catch:{ IOException -> 0x0037 }
        goto L_0x003b
    L_0x0037:
        r5 = move-exception
        r5.printStackTrace()
    L_0x003b:
        return r4
    L_0x003c:
        r4 = move-exception
        goto L_0x0045
    L_0x003e:
        r4 = move-exception
        goto L_0x0056
    L_0x0040:
        r4 = move-exception
        r1 = r0
        goto L_0x006b
    L_0x0043:
        r4 = move-exception
        r1 = r0
    L_0x0045:
        boolean r5 = com.tencent.bugly.proguard.C7226an.m31142a(r4)     // Catch:{ all -> 0x006a }
        if (r5 != 0) goto L_0x004e
        r4.printStackTrace()     // Catch:{ all -> 0x006a }
    L_0x004e:
        if (r1 == 0) goto L_0x0069
        r1.close()     // Catch:{ IOException -> 0x0065 }
        goto L_0x0069
    L_0x0054:
        r4 = move-exception
        r1 = r0
    L_0x0056:
        boolean r5 = com.tencent.bugly.proguard.C7226an.m31142a(r4)     // Catch:{ all -> 0x006a }
        if (r5 != 0) goto L_0x005f
        r4.printStackTrace()     // Catch:{ all -> 0x006a }
    L_0x005f:
        if (r1 == 0) goto L_0x0069
        r1.close()     // Catch:{ IOException -> 0x0065 }
        goto L_0x0069
    L_0x0065:
        r4 = move-exception
        r4.printStackTrace()
    L_0x0069:
        return r0
    L_0x006a:
        r4 = move-exception
    L_0x006b:
        if (r1 == 0) goto L_0x0075
        r1.close()     // Catch:{ IOException -> 0x0071 }
        goto L_0x0075
    L_0x0071:
        r5 = move-exception
        r5.printStackTrace()
    L_0x0075:
        throw r4
    L_0x0076:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7232aq.m31182a(java.io.File, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x00bf A[Catch:{ all -> 0x00dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c4 A[SYNTHETIC, Splitter:B:62:0x00c4] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00ce A[SYNTHETIC, Splitter:B:67:0x00ce] */
    /* renamed from: a */
    public static boolean m31194a(java.io.File r7, java.io.File r8, int r9) {
        /*
        java.lang.String r0 = "rqdp{  ZF end}"
        r1 = 0
        java.lang.Object[] r2 = new java.lang.Object[r1]
        java.lang.String r3 = "rqdp{  ZF start}"
        com.tencent.bugly.proguard.C7226an.m31147c(r3, r2)
        if (r7 == 0) goto L_0x0100
        if (r8 == 0) goto L_0x0100
        boolean r2 = r7.equals(r8)
        if (r2 == 0) goto L_0x0016
        goto L_0x0100
    L_0x0016:
        boolean r2 = r7.exists()
        if (r2 == 0) goto L_0x00f8
        boolean r2 = r7.canRead()
        if (r2 != 0) goto L_0x0024
        goto L_0x00f8
    L_0x0024:
        java.io.File r2 = r8.getParentFile()     // Catch:{ all -> 0x0045 }
        if (r2 == 0) goto L_0x003b
        java.io.File r2 = r8.getParentFile()     // Catch:{ all -> 0x0045 }
        boolean r2 = r2.exists()     // Catch:{ all -> 0x0045 }
        if (r2 != 0) goto L_0x003b
        java.io.File r2 = r8.getParentFile()     // Catch:{ all -> 0x0045 }
        r2.mkdirs()     // Catch:{ all -> 0x0045 }
    L_0x003b:
        boolean r2 = r8.exists()     // Catch:{ all -> 0x0045 }
        if (r2 != 0) goto L_0x004f
        r8.createNewFile()     // Catch:{ all -> 0x0045 }
        goto L_0x004f
    L_0x0045:
        r2 = move-exception
        boolean r3 = com.tencent.bugly.proguard.C7226an.m31142a(r2)
        if (r3 != 0) goto L_0x004f
        r2.printStackTrace()
    L_0x004f:
        boolean r2 = r8.exists()
        if (r2 == 0) goto L_0x00f7
        boolean r2 = r8.canRead()
        if (r2 != 0) goto L_0x005d
        goto L_0x00f7
    L_0x005d:
        r2 = 0
        java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x00b6 }
        r3.<init>(r7)     // Catch:{ all -> 0x00b6 }
        java.util.zip.ZipOutputStream r4 = new java.util.zip.ZipOutputStream     // Catch:{ all -> 0x00b3 }
        java.io.BufferedOutputStream r5 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x00b3 }
        java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ all -> 0x00b3 }
        r6.<init>(r8)     // Catch:{ all -> 0x00b3 }
        r5.<init>(r6)     // Catch:{ all -> 0x00b3 }
        r4.<init>(r5)     // Catch:{ all -> 0x00b3 }
        r8 = 8
        r4.setMethod(r8)     // Catch:{ all -> 0x00b1 }
        java.util.zip.ZipEntry r8 = new java.util.zip.ZipEntry     // Catch:{ all -> 0x00b1 }
        java.lang.String r7 = r7.getName()     // Catch:{ all -> 0x00b1 }
        r8.<init>(r7)     // Catch:{ all -> 0x00b1 }
        r4.putNextEntry(r8)     // Catch:{ all -> 0x00b1 }
        r7 = 1000(0x3e8, float:1.401E-42)
        if (r9 <= r7) goto L_0x0088
        r7 = r9
    L_0x0088:
        byte[] r7 = new byte[r7]     // Catch:{ all -> 0x00b1 }
    L_0x008a:
        int r8 = r3.read(r7)     // Catch:{ all -> 0x00b1 }
        if (r8 <= 0) goto L_0x0094
        r4.write(r7, r1, r8)     // Catch:{ all -> 0x00b1 }
        goto L_0x008a
    L_0x0094:
        r4.flush()     // Catch:{ all -> 0x00b1 }
        r4.closeEntry()     // Catch:{ all -> 0x00b1 }
        r7 = 1
        r3.close()     // Catch:{ IOException -> 0x009f }
        goto L_0x00a3
    L_0x009f:
        r8 = move-exception
        r8.printStackTrace()
    L_0x00a3:
        r4.close()     // Catch:{ IOException -> 0x00a7 }
        goto L_0x00ab
    L_0x00a7:
        r8 = move-exception
        r8.printStackTrace()
    L_0x00ab:
        java.lang.Object[] r8 = new java.lang.Object[r1]
        com.tencent.bugly.proguard.C7226an.m31147c(r0, r8)
        return r7
    L_0x00b1:
        r7 = move-exception
        goto L_0x00b9
    L_0x00b3:
        r7 = move-exception
        r4 = r2
        goto L_0x00b9
    L_0x00b6:
        r7 = move-exception
        r3 = r2
        r4 = r3
    L_0x00b9:
        boolean r8 = com.tencent.bugly.proguard.C7226an.m31142a(r7)     // Catch:{ all -> 0x00dc }
        if (r8 != 0) goto L_0x00c2
        r7.printStackTrace()     // Catch:{ all -> 0x00dc }
    L_0x00c2:
        if (r3 == 0) goto L_0x00cc
        r3.close()     // Catch:{ IOException -> 0x00c8 }
        goto L_0x00cc
    L_0x00c8:
        r7 = move-exception
        r7.printStackTrace()
    L_0x00cc:
        if (r4 == 0) goto L_0x00d6
        r4.close()     // Catch:{ IOException -> 0x00d2 }
        goto L_0x00d6
    L_0x00d2:
        r7 = move-exception
        r7.printStackTrace()
    L_0x00d6:
        java.lang.Object[] r7 = new java.lang.Object[r1]
        com.tencent.bugly.proguard.C7226an.m31147c(r0, r7)
        return r1
    L_0x00dc:
        r7 = move-exception
        if (r3 == 0) goto L_0x00e7
        r3.close()     // Catch:{ IOException -> 0x00e3 }
        goto L_0x00e7
    L_0x00e3:
        r8 = move-exception
        r8.printStackTrace()
    L_0x00e7:
        if (r4 == 0) goto L_0x00f1
        r4.close()     // Catch:{ IOException -> 0x00ed }
        goto L_0x00f1
    L_0x00ed:
        r8 = move-exception
        r8.printStackTrace()
    L_0x00f1:
        java.lang.Object[] r8 = new java.lang.Object[r1]
        com.tencent.bugly.proguard.C7226an.m31147c(r0, r8)
        throw r7
    L_0x00f7:
        return r1
    L_0x00f8:
        java.lang.Object[] r7 = new java.lang.Object[r1]
        java.lang.String r8 = "rqdp{  !sFile.exists() || !sFile.canRead(),pls check ,return!}"
        com.tencent.bugly.proguard.C7226an.m31148d(r8, r7)
        return r1
    L_0x0100:
        java.lang.Object[] r7 = new java.lang.Object[r1]
        java.lang.String r8 = "rqdp{  err ZF 1R!}"
        com.tencent.bugly.proguard.C7226an.m31148d(r8, r7)
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7232aq.m31194a(java.io.File, java.io.File, int):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ad A[Catch:{ all -> 0x00c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b2 A[SYNTHETIC, Splitter:B:41:0x00b2] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00bc A[SYNTHETIC, Splitter:B:46:0x00bc] */
    /* renamed from: a */
    public static java.util.ArrayList<java.lang.String> m31187a(android.content.Context r5, java.lang.String r6) {
        /*
        boolean r5 = com.tencent.bugly.crashreport.common.info.AppInfo.m30747f(r5)
        if (r5 == 0) goto L_0x0016
        java.util.ArrayList r5 = new java.util.ArrayList
        java.lang.String r6 = "unknown(low memory)"
        java.lang.String[] r6 = new java.lang.String[]{r6}
        java.util.List r6 = java.util.Arrays.asList(r6)
        r5.<init>(r6)
        return r5
    L_0x0016:
        java.util.ArrayList r5 = new java.util.ArrayList
        r5.<init>()
        r0 = 0
        java.lang.String r1 = "/system/bin/sh"
        java.io.File r2 = new java.io.File     // Catch:{ all -> 0x00a4 }
        r2.<init>(r1)     // Catch:{ all -> 0x00a4 }
        boolean r2 = r2.exists()     // Catch:{ all -> 0x00a4 }
        if (r2 == 0) goto L_0x0034
        java.io.File r2 = new java.io.File     // Catch:{ all -> 0x00a4 }
        r2.<init>(r1)     // Catch:{ all -> 0x00a4 }
        boolean r2 = r2.canExecute()     // Catch:{ all -> 0x00a4 }
        if (r2 != 0) goto L_0x0036
    L_0x0034:
        java.lang.String r1 = "sh"
    L_0x0036:
        java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x00a4 }
        r3 = 2
        java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ all -> 0x00a4 }
        r4 = 0
        r3[r4] = r1     // Catch:{ all -> 0x00a4 }
        r1 = 1
        java.lang.String r4 = "-c"
        r3[r1] = r4     // Catch:{ all -> 0x00a4 }
        java.util.List r1 = java.util.Arrays.asList(r3)     // Catch:{ all -> 0x00a4 }
        r2.<init>(r1)     // Catch:{ all -> 0x00a4 }
        r2.add(r6)     // Catch:{ all -> 0x00a4 }
        java.lang.Runtime r6 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x00a4 }
        r1 = 3
        java.lang.String[] r1 = new java.lang.String[r1]     // Catch:{ all -> 0x00a4 }
        java.lang.Object[] r1 = r2.toArray(r1)     // Catch:{ all -> 0x00a4 }
        java.lang.String[] r1 = (java.lang.String[]) r1     // Catch:{ all -> 0x00a4 }
        java.lang.Process r6 = r6.exec(r1)     // Catch:{ all -> 0x00a4 }
        java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x00a4 }
        java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x00a4 }
        java.io.InputStream r3 = r6.getInputStream()     // Catch:{ all -> 0x00a4 }
        r2.<init>(r3)     // Catch:{ all -> 0x00a4 }
        r1.<init>(r2)     // Catch:{ all -> 0x00a4 }
    L_0x006c:
        java.lang.String r2 = r1.readLine()     // Catch:{ all -> 0x00a1 }
        if (r2 == 0) goto L_0x0076
        r5.add(r2)     // Catch:{ all -> 0x00a1 }
        goto L_0x006c
    L_0x0076:
        java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x00a1 }
        java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x00a1 }
        java.io.InputStream r6 = r6.getErrorStream()     // Catch:{ all -> 0x00a1 }
        r3.<init>(r6)     // Catch:{ all -> 0x00a1 }
        r2.<init>(r3)     // Catch:{ all -> 0x00a1 }
    L_0x0084:
        java.lang.String r6 = r2.readLine()     // Catch:{ all -> 0x009f }
        if (r6 == 0) goto L_0x008e
        r5.add(r6)     // Catch:{ all -> 0x009f }
        goto L_0x0084
    L_0x008e:
        r1.close()     // Catch:{ IOException -> 0x0092 }
        goto L_0x0096
    L_0x0092:
        r6 = move-exception
        r6.printStackTrace()
    L_0x0096:
        r2.close()     // Catch:{ IOException -> 0x009a }
        goto L_0x009e
    L_0x009a:
        r6 = move-exception
        r6.printStackTrace()
    L_0x009e:
        return r5
    L_0x009f:
        r5 = move-exception
        goto L_0x00a7
    L_0x00a1:
        r5 = move-exception
        r2 = r0
        goto L_0x00a7
    L_0x00a4:
        r5 = move-exception
        r1 = r0
        r2 = r1
    L_0x00a7:
        boolean r6 = com.tencent.bugly.proguard.C7226an.m31142a(r5)     // Catch:{ all -> 0x00c5 }
        if (r6 != 0) goto L_0x00b0
        r5.printStackTrace()     // Catch:{ all -> 0x00c5 }
    L_0x00b0:
        if (r1 == 0) goto L_0x00ba
        r1.close()     // Catch:{ IOException -> 0x00b6 }
        goto L_0x00ba
    L_0x00b6:
        r5 = move-exception
        r5.printStackTrace()
    L_0x00ba:
        if (r2 == 0) goto L_0x00c4
        r2.close()     // Catch:{ IOException -> 0x00c0 }
        goto L_0x00c4
    L_0x00c0:
        r5 = move-exception
        r5.printStackTrace()
    L_0x00c4:
        return r0
    L_0x00c5:
        r5 = move-exception
        if (r1 == 0) goto L_0x00d0
        r1.close()     // Catch:{ IOException -> 0x00cc }
        goto L_0x00d0
    L_0x00cc:
        r6 = move-exception
        r6.printStackTrace()
    L_0x00d0:
        if (r2 == 0) goto L_0x00da
        r2.close()     // Catch:{ IOException -> 0x00d6 }
        goto L_0x00da
    L_0x00d6:
        r6 = move-exception
        r6.printStackTrace()
    L_0x00da:
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7232aq.m31187a(android.content.Context, java.lang.String):java.util.ArrayList");
    }

    /* renamed from: b */
    public static String m31205b(Context context, String str) {
        Class<C7232aq> cls = C7232aq.class;
        String str2 = "";
        if (str == null || str.trim().equals(str2)) {
            return str2;
        }
        if (f24426a == null) {
            f24426a = new HashMap();
            ArrayList<String> a = m31187a(context, "getprop");
            if (a != null && a.size() > 0) {
                C7226an.m31143b(cls, "Successfully get 'getprop' list.", new Object[0]);
                Pattern compile = Pattern.compile("\\[(.+)\\]: \\[(.*)\\]");
                for (String matcher : a) {
                    Matcher matcher2 = compile.matcher(matcher);
                    if (matcher2.find()) {
                        f24426a.put(matcher2.group(1), matcher2.group(2));
                    }
                }
                C7226an.m31143b(cls, "System properties number: %d.", Integer.valueOf(f24426a.size()));
            }
        }
        return f24426a.containsKey(str) ? (String) f24426a.get(str) : "fail";
    }

    /* renamed from: b */
    public static void m31209b(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0064, code lost:
            if (r7 != null) goto L_0x0056;
     */
    /* renamed from: a */
    public static void m31190a(android.content.Context r6, java.lang.String r7, java.lang.String r8, int r9) {
        /*
        r6 = 1
        java.lang.Object[] r0 = new java.lang.Object[r6]
        r1 = 0
        r0[r1] = r7
        java.lang.String r2 = "rqdp{  sv sd start} %s"
        com.tencent.bugly.proguard.C7226an.m31147c(r2, r0)
        if (r8 == 0) goto L_0x007f
        java.lang.String r0 = r8.trim()
        int r0 = r0.length()
        if (r0 > 0) goto L_0x0018
        goto L_0x007f
    L_0x0018:
        java.io.File r0 = new java.io.File
        r0.<init>(r7)
        boolean r7 = r0.exists()     // Catch:{ all -> 0x006e }
        if (r7 != 0) goto L_0x0033
        java.io.File r7 = r0.getParentFile()     // Catch:{ all -> 0x006e }
        if (r7 == 0) goto L_0x0030
        java.io.File r7 = r0.getParentFile()     // Catch:{ all -> 0x006e }
        r7.mkdirs()     // Catch:{ all -> 0x006e }
    L_0x0030:
        r0.createNewFile()     // Catch:{ all -> 0x006e }
    L_0x0033:
        r7 = 0
        long r2 = r0.length()     // Catch:{ all -> 0x005a }
        long r4 = (long) r9     // Catch:{ all -> 0x005a }
        int r9 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
        if (r9 < 0) goto L_0x0044
        java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ all -> 0x005a }
        r6.<init>(r0, r1)     // Catch:{ all -> 0x005a }
        r7 = r6
        goto L_0x004a
    L_0x0044:
        java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ all -> 0x005a }
        r9.<init>(r0, r6)     // Catch:{ all -> 0x005a }
        r7 = r9
    L_0x004a:
        java.lang.String r6 = "UTF-8"
        byte[] r6 = r8.getBytes(r6)     // Catch:{ all -> 0x005a }
        r7.write(r6)     // Catch:{ all -> 0x005a }
        r7.flush()     // Catch:{ all -> 0x005a }
    L_0x0056:
        r7.close()     // Catch:{ all -> 0x006e }
        goto L_0x0078
    L_0x005a:
        r6 = move-exception
        boolean r8 = com.tencent.bugly.proguard.C7226an.m31142a(r6)     // Catch:{ all -> 0x0067 }
        if (r8 != 0) goto L_0x0064
        r6.printStackTrace()     // Catch:{ all -> 0x0067 }
    L_0x0064:
        if (r7 == 0) goto L_0x0078
        goto L_0x0056
    L_0x0067:
        r6 = move-exception
        if (r7 == 0) goto L_0x006d
        r7.close()     // Catch:{ all -> 0x006e }
    L_0x006d:
        throw r6     // Catch:{ all -> 0x006e }
    L_0x006e:
        r6 = move-exception
        boolean r7 = com.tencent.bugly.proguard.C7226an.m31142a(r6)
        if (r7 != 0) goto L_0x0078
        r6.printStackTrace()
    L_0x0078:
        java.lang.Object[] r6 = new java.lang.Object[r1]
        java.lang.String r7 = "rqdp{  sv sd end}"
        com.tencent.bugly.proguard.C7226an.m31147c(r7, r6)
    L_0x007f:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7232aq.m31190a(android.content.Context, java.lang.String, java.lang.String, int):void");
    }

    /* renamed from: a */
    public static boolean m31196a(String str) {
        return str == null || str.trim().length() <= 0;
    }

    /* renamed from: b */
    public static void m31211b(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.isFile() && file.exists() && file.canWrite()) {
                file.delete();
            }
        }
    }

    /* renamed from: c */
    public static byte[] m31222c(long j) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(j);
            return sb.toString().getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    public static long m31218c(byte[] bArr) {
        long j = -1;
        if (bArr == null) {
            return -1;
        }
        try {
            j = Long.parseLong(new String(bArr, "utf-8"));
            return j;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return j;
        }
    }

    /* renamed from: a */
    public static Context m31172a(Context context) {
        if (context == null) {
            return context;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return context;
    }

    /* renamed from: b */
    public static String m31206b(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    /* renamed from: a */
    public static void m31192a(Class<?> cls, String str, Object obj, Object obj2) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj2, obj);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static Object m31176a(String str, String str2, Object obj, Class<?>[] clsArr, Object[] objArr) {
        try {
            Method declaredMethod = Class.forName(str).getDeclaredMethod(str2, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static void m31191a(Parcel parcel, Map<String, PlugInBean> map) {
        if (map == null || map.size() <= 0) {
            parcel.writeBundle(null);
            return;
        }
        int size = map.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        for (Entry entry : map.entrySet()) {
            arrayList.add(entry.getKey());
            arrayList2.add(entry.getValue());
        }
        Bundle bundle = new Bundle();
        bundle.putInt("pluginNum", arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("pluginKey");
            sb.append(i);
            bundle.putString(sb.toString(), (String) arrayList.get(i));
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            StringBuilder sb2 = new StringBuilder();
            String str = "pluginVal";
            sb2.append(str);
            sb2.append(i2);
            sb2.append("plugInId");
            bundle.putString(sb2.toString(), ((PlugInBean) arrayList2.get(i2)).f23959a);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(i2);
            sb3.append("plugInUUID");
            bundle.putString(sb3.toString(), ((PlugInBean) arrayList2.get(i2)).f23961c);
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append(i2);
            sb4.append("plugInVersion");
            bundle.putString(sb4.toString(), ((PlugInBean) arrayList2.get(i2)).f23960b);
        }
        parcel.writeBundle(bundle);
    }

    /* renamed from: a */
    public static Map<String, PlugInBean> m31189a(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        HashMap hashMap = null;
        if (readBundle == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int intValue = ((Integer) readBundle.get("pluginNum")).intValue();
        for (int i = 0; i < intValue; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("pluginKey");
            sb.append(i);
            arrayList.add(readBundle.getString(sb.toString()));
        }
        for (int i2 = 0; i2 < intValue; i2++) {
            StringBuilder sb2 = new StringBuilder();
            String str = "pluginVal";
            sb2.append(str);
            sb2.append(i2);
            sb2.append("plugInId");
            String string = readBundle.getString(sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(i2);
            sb3.append("plugInUUID");
            String string2 = readBundle.getString(sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append(i2);
            sb4.append("plugInVersion");
            arrayList2.add(new PlugInBean(string, readBundle.getString(sb4.toString()), string2));
        }
        if (arrayList.size() == arrayList2.size()) {
            hashMap = new HashMap(arrayList.size());
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                hashMap.put(arrayList.get(i3), PlugInBean.class.cast(arrayList2.get(i3)));
            }
        } else {
            C7226an.m31149e("map plugin parcel error!", new Object[0]);
        }
        return hashMap;
    }

    /* renamed from: b */
    public static void m31210b(Parcel parcel, Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            parcel.writeBundle(null);
            return;
        }
        int size = map.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        for (Entry entry : map.entrySet()) {
            arrayList.add(entry.getKey());
            arrayList2.add(entry.getValue());
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("keys", arrayList);
        bundle.putStringArrayList("values", arrayList2);
        parcel.writeBundle(bundle);
    }

    /* renamed from: b */
    public static Map<String, String> m31208b(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        HashMap hashMap = null;
        if (readBundle == null) {
            return null;
        }
        ArrayList stringArrayList = readBundle.getStringArrayList("keys");
        ArrayList stringArrayList2 = readBundle.getStringArrayList("values");
        if (stringArrayList == null || stringArrayList2 == null || stringArrayList.size() != stringArrayList2.size()) {
            C7226an.m31149e("map parcel error!", new Object[0]);
        } else {
            hashMap = new HashMap(stringArrayList.size());
            for (int i = 0; i < stringArrayList.size(); i++) {
                hashMap.put(stringArrayList.get(i), stringArrayList2.get(i));
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    public static byte[] m31199a(Parcelable parcelable) {
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    /* renamed from: d */
    public static Parcel m31223d(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        return obtain;
    }

    /* renamed from: a */
    public static <T> T m31177a(byte[] bArr, Creator<T> creator) {
        Parcel d = m31223d(bArr);
        try {
            T createFromParcel = creator.createFromParcel(d);
            if (d != null) {
                d.recycle();
            }
            return createFromParcel;
        } catch (Throwable th) {
            if (d != null) {
                d.recycle();
            }
            throw th;
        }
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [java.lang.Process, java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v1, types: [java.lang.Process, java.lang.String]
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY]]
  uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], java.lang.Process, java.lang.String]
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
    /* renamed from: a */
    public static java.lang.String m31180a(android.content.Context r6, int r7, java.lang.String r8) {
        /*
        java.lang.String r0 = "android.permission.READ_LOGS"
        boolean r6 = com.tencent.bugly.crashreport.common.info.AppInfo.m30742a(r6, r0)
        r0 = 0
        r1 = 0
        if (r6 != 0) goto L_0x0012
        java.lang.Object[] r6 = new java.lang.Object[r1]
        java.lang.String r7 = "no read_log permission!"
        com.tencent.bugly.proguard.C7226an.m31148d(r7, r6)
        return r0
    L_0x0012:
        java.lang.String r6 = "threadtime"
        java.lang.String r2 = "-v"
        java.lang.String r3 = "-d"
        java.lang.String r4 = "logcat"
        if (r8 != 0) goto L_0x0021
        java.lang.String[] r6 = new java.lang.String[]{r4, r3, r2, r6}
        goto L_0x0038
    L_0x0021:
        r5 = 6
        java.lang.String[] r5 = new java.lang.String[r5]
        r5[r1] = r4
        r4 = 1
        r5[r4] = r3
        r3 = 2
        r5[r3] = r2
        r2 = 3
        r5[r2] = r6
        r6 = 4
        java.lang.String r2 = "-s"
        r5[r6] = r2
        r6 = 5
        r5[r6] = r8
        r6 = r5
    L_0x0038:
        java.lang.StringBuilder r8 = new java.lang.StringBuilder
        r8.<init>()
        java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x009d }
        java.lang.Process r0 = r2.exec(r6)     // Catch:{ all -> 0x009d }
        java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ all -> 0x009d }
        java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x009d }
        java.io.InputStream r3 = r0.getInputStream()     // Catch:{ all -> 0x009d }
        r2.<init>(r3)     // Catch:{ all -> 0x009d }
        r6.<init>(r2)     // Catch:{ all -> 0x009d }
    L_0x0053:
        java.lang.String r2 = r6.readLine()     // Catch:{ all -> 0x009d }
        if (r2 == 0) goto L_0x0072
        r8.append(r2)     // Catch:{ all -> 0x009d }
        java.lang.String r2 = "\n"
        r8.append(r2)     // Catch:{ all -> 0x009d }
        if (r7 <= 0) goto L_0x0053
        int r2 = r8.length()     // Catch:{ all -> 0x009d }
        if (r2 <= r7) goto L_0x0053
        int r2 = r8.length()     // Catch:{ all -> 0x009d }
        int r2 = r2 - r7
        r8.delete(r1, r2)     // Catch:{ all -> 0x009d }
        goto L_0x0053
    L_0x0072:
        java.lang.String r6 = r8.toString()     // Catch:{ all -> 0x009d }
        if (r0 == 0) goto L_0x009c
        java.io.OutputStream r7 = r0.getOutputStream()     // Catch:{ IOException -> 0x0080 }
        r7.close()     // Catch:{ IOException -> 0x0080 }
        goto L_0x0084
    L_0x0080:
        r7 = move-exception
        r7.printStackTrace()
    L_0x0084:
        java.io.InputStream r7 = r0.getInputStream()     // Catch:{ IOException -> 0x008c }
        r7.close()     // Catch:{ IOException -> 0x008c }
        goto L_0x0090
    L_0x008c:
        r7 = move-exception
        r7.printStackTrace()
    L_0x0090:
        java.io.InputStream r7 = r0.getErrorStream()     // Catch:{ IOException -> 0x0098 }
        r7.close()     // Catch:{ IOException -> 0x0098 }
        goto L_0x009c
    L_0x0098:
        r7 = move-exception
        r7.printStackTrace()
    L_0x009c:
        return r6
    L_0x009d:
        r6 = move-exception
        boolean r7 = com.tencent.bugly.proguard.C7226an.m31142a(r6)     // Catch:{ all -> 0x00ef }
        if (r7 != 0) goto L_0x00a7
        r6.printStackTrace()     // Catch:{ all -> 0x00ef }
    L_0x00a7:
        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ef }
        r7.<init>()     // Catch:{ all -> 0x00ef }
        java.lang.String r1 = "\n[error:"
        r7.append(r1)     // Catch:{ all -> 0x00ef }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00ef }
        r7.append(r6)     // Catch:{ all -> 0x00ef }
        java.lang.String r6 = "]"
        r7.append(r6)     // Catch:{ all -> 0x00ef }
        java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x00ef }
        r8.append(r6)     // Catch:{ all -> 0x00ef }
        java.lang.String r6 = r8.toString()     // Catch:{ all -> 0x00ef }
        if (r0 == 0) goto L_0x00ee
        java.io.OutputStream r7 = r0.getOutputStream()     // Catch:{ IOException -> 0x00d2 }
        r7.close()     // Catch:{ IOException -> 0x00d2 }
        goto L_0x00d6
    L_0x00d2:
        r7 = move-exception
        r7.printStackTrace()
    L_0x00d6:
        java.io.InputStream r7 = r0.getInputStream()     // Catch:{ IOException -> 0x00de }
        r7.close()     // Catch:{ IOException -> 0x00de }
        goto L_0x00e2
    L_0x00de:
        r7 = move-exception
        r7.printStackTrace()
    L_0x00e2:
        java.io.InputStream r7 = r0.getErrorStream()     // Catch:{ IOException -> 0x00ea }
        r7.close()     // Catch:{ IOException -> 0x00ea }
        goto L_0x00ee
    L_0x00ea:
        r7 = move-exception
        r7.printStackTrace()
    L_0x00ee:
        return r6
    L_0x00ef:
        r6 = move-exception
        if (r0 == 0) goto L_0x0116
        java.io.OutputStream r7 = r0.getOutputStream()     // Catch:{ IOException -> 0x00fa }
        r7.close()     // Catch:{ IOException -> 0x00fa }
        goto L_0x00fe
    L_0x00fa:
        r7 = move-exception
        r7.printStackTrace()
    L_0x00fe:
        java.io.InputStream r7 = r0.getInputStream()     // Catch:{ IOException -> 0x0106 }
        r7.close()     // Catch:{ IOException -> 0x0106 }
        goto L_0x010a
    L_0x0106:
        r7 = move-exception
        r7.printStackTrace()
    L_0x010a:
        java.io.InputStream r7 = r0.getErrorStream()     // Catch:{ IOException -> 0x0112 }
        r7.close()     // Catch:{ IOException -> 0x0112 }
        goto L_0x0116
    L_0x0112:
        r7 = move-exception
        r7.printStackTrace()
    L_0x0116:
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7232aq.m31180a(android.content.Context, int, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static Map<String, String> m31188a(int i, boolean z) {
        HashMap hashMap = new HashMap(12);
        Map allStackTraces = Thread.getAllStackTraces();
        if (allStackTraces == null) {
            return null;
        }
        Thread thread = Looper.getMainLooper().getThread();
        if (!allStackTraces.containsKey(thread)) {
            allStackTraces.put(thread, thread.getStackTrace());
        }
        long id = Thread.currentThread().getId();
        StringBuilder sb = new StringBuilder();
        for (Entry entry : allStackTraces.entrySet()) {
            if (!z || id != ((Thread) entry.getKey()).getId()) {
                int i2 = 0;
                sb.setLength(0);
                if (entry.getValue() != null) {
                    if (((StackTraceElement[]) entry.getValue()).length != 0) {
                        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) entry.getValue();
                        int length = stackTraceElementArr.length;
                        while (true) {
                            if (i2 >= length) {
                                break;
                            }
                            StackTraceElement stackTraceElement = stackTraceElementArr[i2];
                            if (i > 0 && sb.length() >= i) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("\n[Stack over limit size :");
                                sb2.append(i);
                                sb2.append(" , has been cut!]");
                                sb.append(sb2.toString());
                                break;
                            }
                            sb.append(stackTraceElement.toString());
                            sb.append("\n");
                            i2++;
                        }
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(((Thread) entry.getKey()).getName());
                        sb3.append("(");
                        sb3.append(((Thread) entry.getKey()).getId());
                        sb3.append(")");
                        hashMap.put(sb3.toString(), sb.toString());
                    }
                }
            }
        }
        return hashMap;
    }

    /* renamed from: b */
    public static boolean m31213b(Context context) {
        try {
            if (VERSION.SDK_INT >= 14) {
                return C7174a.m30754b().mo34579a();
            }
            String packageName = context.getPackageName();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME);
            if (activityManager != null) {
                List runningTasks = activityManager.getRunningTasks(1);
                return runningTasks != null && !runningTasks.isEmpty() && ((RunningTaskInfo) runningTasks.get(0)).topActivity.getPackageName().equals(packageName);
            }
            return true;
        } catch (SecurityException unused) {
            C7226an.m31149e("无法获取GET_TASK权限，将在通知栏提醒升级，如需弹窗提醒，请在AndroidManifest.xml中添加GET_TASKS权限：\n<uses-permission android:name=\"android.permission.GET_TASKS\" />\n", new Object[0]);
        } catch (Exception e) {
            if (!C7226an.m31145b(e)) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0035 A[SYNTHETIC, Splitter:B:20:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0053 A[SYNTHETIC, Splitter:B:27:0x0053] */
    /* renamed from: a */
    public static synchronized byte[] m31197a(int r7) {
        /*
        java.lang.Class<com.tencent.bugly.proguard.aq> r0 = com.tencent.bugly.proguard.C7232aq.class
        monitor-enter(r0)
        r1 = 0
        int r2 = r7 / 8
        byte[] r2 = new byte[r2]     // Catch:{ Exception -> 0x0026, all -> 0x0023 }
        java.io.DataInputStream r3 = new java.io.DataInputStream     // Catch:{ Exception -> 0x0026, all -> 0x0023 }
        java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0026, all -> 0x0023 }
        java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x0026, all -> 0x0023 }
        java.lang.String r6 = "/dev/urandom"
        r5.<init>(r6)     // Catch:{ Exception -> 0x0026, all -> 0x0023 }
        r4.<init>(r5)     // Catch:{ Exception -> 0x0026, all -> 0x0023 }
        r3.<init>(r4)     // Catch:{ Exception -> 0x0026, all -> 0x0023 }
        r3.readFully(r2)     // Catch:{ Exception -> 0x0021 }
        r3.close()     // Catch:{ Exception -> 0x0059 }
        monitor-exit(r0)
        return r2
    L_0x0021:
        r2 = move-exception
        goto L_0x0028
    L_0x0023:
        r7 = move-exception
        r3 = r1
        goto L_0x0051
    L_0x0026:
        r2 = move-exception
        r3 = r1
    L_0x0028:
        java.lang.String r4 = "Failed to read from /dev/urandom : %s"
        r5 = 1
        java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0050 }
        r6 = 0
        r5[r6] = r2     // Catch:{ all -> 0x0050 }
        com.tencent.bugly.proguard.C7226an.m31149e(r4, r5)     // Catch:{ all -> 0x0050 }
        if (r3 == 0) goto L_0x0038
        r3.close()     // Catch:{ Exception -> 0x0059 }
    L_0x0038:
        java.lang.String r2 = "AES"
        javax.crypto.KeyGenerator r2 = javax.crypto.KeyGenerator.getInstance(r2)     // Catch:{ Exception -> 0x0059 }
        java.security.SecureRandom r3 = new java.security.SecureRandom     // Catch:{ Exception -> 0x0059 }
        r3.<init>()     // Catch:{ Exception -> 0x0059 }
        r2.init(r7, r3)     // Catch:{ Exception -> 0x0059 }
        javax.crypto.SecretKey r7 = r2.generateKey()     // Catch:{ Exception -> 0x0059 }
        byte[] r7 = r7.getEncoded()     // Catch:{ Exception -> 0x0059 }
        monitor-exit(r0)
        return r7
    L_0x0050:
        r7 = move-exception
    L_0x0051:
        if (r3 == 0) goto L_0x0056
        r3.close()     // Catch:{ Exception -> 0x0059 }
    L_0x0056:
        throw r7     // Catch:{ Exception -> 0x0059 }
    L_0x0057:
        r7 = move-exception
        goto L_0x0065
    L_0x0059:
        r7 = move-exception
        boolean r2 = com.tencent.bugly.proguard.C7226an.m31145b(r7)     // Catch:{ all -> 0x0057 }
        if (r2 != 0) goto L_0x0063
        r7.printStackTrace()     // Catch:{ all -> 0x0057 }
    L_0x0063:
        monitor-exit(r0)
        return r1
    L_0x0065:
        monitor-exit(r0)
        throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7232aq.m31197a(int):byte[]");
    }

    /* renamed from: a */
    public static byte[] m31198a(int i, byte[] bArr, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
            if (VERSION.SDK_INT >= 21) {
                if (!f24427b) {
                    instance.init(i, secretKeySpec, new GCMParameterSpec(instance.getBlockSize() * 8, bArr2));
                    return instance.doFinal(bArr);
                }
            }
            instance.init(i, secretKeySpec, new IvParameterSpec(bArr2));
            return instance.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException e) {
            f24427b = true;
            throw e;
        } catch (Exception e2) {
            if (!C7226an.m31145b(e2)) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: b */
    public static byte[] m31214b(int i, byte[] bArr, byte[] bArr2) {
        Key key;
        try {
            KeyFactory instance = KeyFactory.getInstance("RSA");
            if (i == 1) {
                key = instance.generatePublic(new X509EncodedKeySpec(bArr2));
            } else {
                key = instance.generatePrivate(new PKCS8EncodedKeySpec(bArr2));
            }
            Cipher instance2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance2.init(i, key);
            return instance2.doFinal(bArr);
        } catch (Exception e) {
            if (!C7226an.m31145b(e)) {
                e.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m31193a(Context context, String str, long j) {
        C7226an.m31147c("[Util] Try to lock file:%s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getFilesDir());
            sb.append(File.separator);
            sb.append(str);
            File file = new File(sb.toString());
            if (file.exists()) {
                if (System.currentTimeMillis() - file.lastModified() < j) {
                    return false;
                }
                C7226an.m31147c("[Util] Lock file (%s) is expired, unlock it.", str);
                m31220c(context, str);
            }
            if (file.createNewFile()) {
                C7226an.m31147c("[Util] Successfully locked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                return true;
            }
            C7226an.m31147c("[Util] Failed to locked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return false;
        } catch (Throwable th) {
            C7226an.m31142a(th);
            return false;
        }
    }

    /* renamed from: c */
    public static boolean m31220c(Context context, String str) {
        C7226an.m31147c("[Util] Try to unlock file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getFilesDir());
            sb.append(File.separator);
            sb.append(str);
            File file = new File(sb.toString());
            if (!file.exists()) {
                return true;
            }
            if (!file.delete()) {
                return false;
            }
            C7226an.m31147c("[Util] Successfully unlocked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return true;
        } catch (Throwable th) {
            C7226an.m31142a(th);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0067 A[SYNTHETIC, Splitter:B:30:0x0067] */
    /* renamed from: a */
    public static java.lang.String m31181a(java.io.File r5, int r6, boolean r7) {
        /*
        r0 = 0
        if (r5 == 0) goto L_0x007c
        boolean r1 = r5.exists()
        if (r1 == 0) goto L_0x007c
        boolean r1 = r5.canRead()
        if (r1 != 0) goto L_0x0011
        goto L_0x007c
    L_0x0011:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0060 }
        r1.<init>()     // Catch:{ all -> 0x0060 }
        java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0060 }
        java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x0060 }
        java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ all -> 0x0060 }
        r4.<init>(r5)     // Catch:{ all -> 0x0060 }
        java.lang.String r5 = "utf-8"
        r3.<init>(r4, r5)     // Catch:{ all -> 0x0060 }
        r2.<init>(r3)     // Catch:{ all -> 0x0060 }
    L_0x0027:
        java.lang.String r5 = r2.readLine()     // Catch:{ all -> 0x005e }
        if (r5 == 0) goto L_0x0051
        r1.append(r5)     // Catch:{ all -> 0x005e }
        java.lang.String r5 = "\n"
        r1.append(r5)     // Catch:{ all -> 0x005e }
        if (r6 <= 0) goto L_0x0027
        int r5 = r1.length()     // Catch:{ all -> 0x005e }
        if (r5 <= r6) goto L_0x0027
        if (r7 == 0) goto L_0x0047
        int r5 = r1.length()     // Catch:{ all -> 0x005e }
        r1.delete(r6, r5)     // Catch:{ all -> 0x005e }
        goto L_0x0051
    L_0x0047:
        r5 = 0
        int r3 = r1.length()     // Catch:{ all -> 0x005e }
        int r3 = r3 - r6
        r1.delete(r5, r3)     // Catch:{ all -> 0x005e }
        goto L_0x0027
    L_0x0051:
        java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x005e }
        r2.close()     // Catch:{ Exception -> 0x0059 }
        goto L_0x005d
    L_0x0059:
        r6 = move-exception
        com.tencent.bugly.proguard.C7226an.m31142a(r6)
    L_0x005d:
        return r5
    L_0x005e:
        r5 = move-exception
        goto L_0x0062
    L_0x0060:
        r5 = move-exception
        r2 = r0
    L_0x0062:
        com.tencent.bugly.proguard.C7226an.m31142a(r5)     // Catch:{ all -> 0x0070 }
        if (r2 == 0) goto L_0x006f
        r2.close()     // Catch:{ Exception -> 0x006b }
        goto L_0x006f
    L_0x006b:
        r5 = move-exception
        com.tencent.bugly.proguard.C7226an.m31142a(r5)
    L_0x006f:
        return r0
    L_0x0070:
        r5 = move-exception
        if (r2 == 0) goto L_0x007b
        r2.close()     // Catch:{ Exception -> 0x0077 }
        goto L_0x007b
    L_0x0077:
        r6 = move-exception
        com.tencent.bugly.proguard.C7226an.m31142a(r6)
    L_0x007b:
        throw r5
    L_0x007c:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C7232aq.m31181a(java.io.File, int, boolean):java.lang.String");
    }

    /* renamed from: a */
    public static BufferedReader m31174a(File file) {
        if (file != null && file.exists() && file.canRead()) {
            try {
                return new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            } catch (Throwable th) {
                C7226an.m31142a(th);
            }
        }
        return null;
    }

    /* renamed from: a */
    public static BufferedReader m31175a(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            File file = new File(str, str2);
            if (file.exists()) {
                if (file.canRead()) {
                    return m31174a(file);
                }
            }
            return null;
        } catch (NullPointerException e) {
            C7226an.m31142a(e);
            return null;
        }
    }

    /* renamed from: a */
    public static Thread m31186a(Runnable runnable, String str) {
        try {
            Thread thread = new Thread(runnable);
            thread.setName(str);
            thread.start();
            return thread;
        } catch (Throwable th) {
            C7226an.m31149e("[Util] Failed to start a thread to execute task with message: %s", th.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m31195a(Runnable runnable) {
        if (runnable != null) {
            C7224am a = C7224am.m31132a();
            if (a != null) {
                return a.mo34832a(runnable);
            }
            String[] split = runnable.getClass().getName().split("\\.");
            if (m31186a(runnable, split[split.length - 1]) != null) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m31221c(String str) {
        if (m31196a(str)) {
            return false;
        }
        if (str.length() > 255) {
            C7226an.m31141a("URL(%s)'s length is larger than 255.", str);
            return false;
        } else if (str.toLowerCase().startsWith("http")) {
            return true;
        } else {
            C7226an.m31141a("URL(%s) is not start with \"http\".", str);
            return false;
        }
    }

    /* renamed from: a */
    public static SharedPreferences m31173a(String str, Context context) {
        if (context != null) {
            return context.getSharedPreferences(str, 0);
        }
        return null;
    }

    /* renamed from: b */
    public static void m31212b(String str, String str2) {
        if (C7174a.m30754b() != null && C7174a.m30754b().f23976N != null) {
            C7174a.m30754b().f23976N.edit().putString(str, str2).apply();
        }
    }

    /* renamed from: c */
    public static String m31219c(String str, String str2) {
        return (C7174a.m30754b() == null || C7174a.m30754b().f23976N == null) ? "" : C7174a.m30754b().f23976N.getString(str, str2);
    }
}
