package com.tencent.bugly.beta.tinker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.util.TinkerLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Formatter;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* compiled from: BUGLY */
public class TinkerUtils {
    public static final int ERROR_PATCH_CONDITION_NOT_SATISFIED = -24;
    public static final int ERROR_PATCH_CRASH_LIMIT = -23;
    public static final int ERROR_PATCH_GOOGLEPLAY_CHANNEL = -20;
    public static final int ERROR_PATCH_MEMORY_LIMIT = -22;
    public static final int ERROR_PATCH_ROM_SPACE = -21;
    public static final int MIN_MEMORY_HEAP_SIZE = 45;
    public static final String PLATFORM = "platform";
    private static final String TAG = "Tinker.TinkerUtils";
    private static boolean background = false;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.beta.tinker.TinkerUtils$ScreenState */
    public static class ScreenState {

        /* compiled from: BUGLY */
        /* renamed from: com.tencent.bugly.beta.tinker.TinkerUtils$ScreenState$IOnScreenOff */
        interface IOnScreenOff {
            void onScreenOff();
        }

        ScreenState(Context context, final IOnScreenOff iOnScreenOff) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            context.registerReceiver(new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    String action = intent == null ? "" : intent.getAction();
                    TinkerLog.i(TinkerUtils.TAG, "ScreenReceiver action [%s] ", new Object[]{action});
                    if ("android.intent.action.SCREEN_OFF".equals(action)) {
                        IOnScreenOff iOnScreenOff = iOnScreenOff;
                        if (iOnScreenOff != null) {
                            iOnScreenOff.onScreenOff();
                        }
                        context.unregisterReceiver(this);
                    }
                }
            }, intentFilter);
        }
    }

    public static boolean isGooglePlay() {
        return false;
    }

    public static boolean isBackground() {
        return background;
    }

    public static void setBackground(boolean z) {
        background = z;
    }

    public static int checkForPatchRecover(long j, int i) {
        if (isGooglePlay()) {
            return -20;
        }
        if (i < 45) {
            return -22;
        }
        return !checkRomSpaceEnough(j) ? -21 : 0;
    }

    public static boolean isXposedExists(Throwable th) {
        for (StackTraceElement className : th.getStackTrace()) {
            String className2 = className.getClassName();
            if (className2 != null && className2.contains("de.robv.android.xposed.XposedBridge")) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002e  */
    @java.lang.Deprecated
    public static boolean checkRomSpaceEnough(long r8) {
        /*
        r0 = 0
        java.io.File r2 = android.os.Environment.getDataDirectory()     // Catch:{ Exception -> 0x0028 }
        android.os.StatFs r3 = new android.os.StatFs     // Catch:{ Exception -> 0x0028 }
        java.lang.String r2 = r2.getPath()     // Catch:{ Exception -> 0x0028 }
        r3.<init>(r2)     // Catch:{ Exception -> 0x0028 }
        int r2 = r3.getAvailableBlocks()     // Catch:{ Exception -> 0x0028 }
        long r4 = (long) r2     // Catch:{ Exception -> 0x0028 }
        int r2 = r3.getBlockSize()     // Catch:{ Exception -> 0x0028 }
        long r6 = (long) r2
        long r4 = r4 * r6
        int r2 = r3.getBlockCount()     // Catch:{ Exception -> 0x0029 }
        long r6 = (long) r2     // Catch:{ Exception -> 0x0029 }
        int r2 = r3.getBlockSize()     // Catch:{ Exception -> 0x0029 }
        long r2 = (long) r2
        long r2 = r2 * r6
        goto L_0x002a
    L_0x0028:
        r4 = r0
    L_0x0029:
        r2 = r0
    L_0x002a:
        int r6 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
        if (r6 == 0) goto L_0x0034
        int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
        if (r0 <= 0) goto L_0x0034
        r8 = 1
        return r8
    L_0x0034:
        r8 = 0
        return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.tinker.TinkerUtils.checkRomSpaceEnough(long):boolean");
    }

    public static String getExceptionCauseString(Throwable th) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        while (th != null) {
            try {
                if (th.getCause() == null) {
                    break;
                }
                th = th.getCause();
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (th != null) {
            th.printStackTrace(printStream);
        }
        String visualString = toVisualString(byteArrayOutputStream.toString());
        try {
            byteArrayOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return visualString;
    }

    private static String toVisualString(String str) {
        boolean z;
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        if (charArray == null) {
            return null;
        }
        int i = 0;
        while (true) {
            if (i >= charArray.length) {
                z = false;
                break;
            } else if (charArray[i] > 127) {
                charArray[i] = 0;
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            str = new String(charArray, 0, i);
        }
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0071 A[SYNTHETIC, Splitter:B:38:0x0071] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007b A[SYNTHETIC, Splitter:B:43:0x007b] */
    public static boolean copy(java.io.File r5, java.io.File r6) throws java.io.IOException {
        /*
        r0 = 0
        if (r5 == 0) goto L_0x0084
        if (r6 != 0) goto L_0x0007
        goto L_0x0084
    L_0x0007:
        boolean r1 = r5.exists()
        if (r1 != 0) goto L_0x000e
        return r0
    L_0x000e:
        r1 = 0
        java.lang.String r2 = r6.getAbsolutePath()     // Catch:{ all -> 0x006d }
        java.lang.String r3 = java.io.File.separator     // Catch:{ all -> 0x006d }
        int r3 = r2.lastIndexOf(r3)     // Catch:{ all -> 0x006d }
        java.lang.String r2 = r2.substring(r0, r3)     // Catch:{ all -> 0x006d }
        java.io.File r3 = new java.io.File     // Catch:{ all -> 0x006d }
        r3.<init>(r2)     // Catch:{ all -> 0x006d }
        boolean r2 = r3.exists()     // Catch:{ all -> 0x006d }
        if (r2 != 0) goto L_0x002b
        r3.mkdirs()     // Catch:{ all -> 0x006d }
    L_0x002b:
        java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ all -> 0x006d }
        java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x006d }
        r3.<init>(r5)     // Catch:{ all -> 0x006d }
        r2.<init>(r3)     // Catch:{ all -> 0x006d }
        java.io.BufferedOutputStream r5 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0069 }
        java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x0069 }
        r3.<init>(r6)     // Catch:{ all -> 0x0069 }
        r5.<init>(r3)     // Catch:{ all -> 0x0069 }
        r6 = 5120(0x1400, float:7.175E-42)
        byte[] r6 = new byte[r6]     // Catch:{ all -> 0x0063 }
    L_0x0043:
        int r1 = r2.read(r6)     // Catch:{ all -> 0x0063 }
        r3 = -1
        if (r1 == r3) goto L_0x004e
        r5.write(r6, r0, r1)     // Catch:{ all -> 0x0063 }
        goto L_0x0043
    L_0x004e:
        r5.flush()     // Catch:{ all -> 0x0063 }
        r6 = 1
        r2.close()     // Catch:{ IOException -> 0x0056 }
        goto L_0x005a
    L_0x0056:
        r0 = move-exception
        r0.printStackTrace()
    L_0x005a:
        r5.close()     // Catch:{ IOException -> 0x005e }
        goto L_0x0062
    L_0x005e:
        r5 = move-exception
        r5.printStackTrace()
    L_0x0062:
        return r6
    L_0x0063:
        r6 = move-exception
        r1 = r2
        r4 = r6
        r6 = r5
        r5 = r4
        goto L_0x006f
    L_0x0069:
        r5 = move-exception
        r6 = r1
        r1 = r2
        goto L_0x006f
    L_0x006d:
        r5 = move-exception
        r6 = r1
    L_0x006f:
        if (r1 == 0) goto L_0x0079
        r1.close()     // Catch:{ IOException -> 0x0075 }
        goto L_0x0079
    L_0x0075:
        r0 = move-exception
        r0.printStackTrace()
    L_0x0079:
        if (r6 == 0) goto L_0x0083
        r6.close()     // Catch:{ IOException -> 0x007f }
        goto L_0x0083
    L_0x007f:
        r6 = move-exception
        r6.printStackTrace()
    L_0x0083:
        throw r5
    L_0x0084:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.tinker.TinkerUtils.copy(java.io.File, java.io.File):boolean");
    }

    public static String getSignature(Context context) {
        String str = "";
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            if (signatureArr == null || signatureArr.length <= 0) {
                return str;
            }
            X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()));
            MessageDigest.getInstance("SHA-1");
            return new String(x509Certificate.getEncoded());
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String bytesToHexString(byte[] bArr, boolean z) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(r0 * 2);
        Formatter formatter = new Formatter(stringBuffer);
        for (byte valueOf : bArr) {
            formatter.format("%02x", new Object[]{Byte.valueOf(valueOf)});
        }
        formatter.close();
        String stringBuffer2 = stringBuffer.toString();
        return z ? stringBuffer2.toUpperCase() : stringBuffer2.toLowerCase();
    }

    public static byte[] readJarEntry(File file, String str) {
        if (file != null) {
            try {
                if (file.exists()) {
                    if (!TextUtils.isEmpty(str)) {
                        return readJarEntry(new JarFile(file), str);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] readJarEntry(JarFile jarFile, String str) {
        if (jarFile != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return readJarEntry(jarFile, jarFile.getJarEntry(str));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] readJarEntry(JarFile jarFile, JarEntry jarEntry) {
        if (!(jarFile == null || jarEntry == null)) {
            try {
                return readBytes(jarFile.getInputStream(jarEntry));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] readBytes(InputStream inputStream) {
        try {
            byte[] bArr = new byte[512];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void rollbackPatch(Context context) {
        Tinker.with(context).rollbackPatch();
    }
}
