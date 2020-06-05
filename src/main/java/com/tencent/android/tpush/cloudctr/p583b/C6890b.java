package com.tencent.android.tpush.cloudctr.p583b;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.android.tpush.p580b.C6864a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.cloudctr.b.b */
public class C6890b {
    /* renamed from: a */
    private static String f22950a = "cloudcontrol Md5";

    /* renamed from: a */
    public static boolean m29431a(String str, File file) {
        if (TextUtils.isEmpty(str) || file == null) {
            C6864a.m29308i(f22950a, "MD5 string empty or updateFile null");
            return false;
        }
        String a = m29430a(file);
        if (a == null) {
            C6864a.m29308i(f22950a, "calculatedDigest null");
            return false;
        }
        String str2 = f22950a;
        StringBuilder sb = new StringBuilder();
        sb.append("Calculated digest: ");
        sb.append(a);
        C6864a.m29286a(str2, sb.toString());
        String str3 = f22950a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Provided digest: ");
        sb2.append(str);
        C6864a.m29286a(str3, sb2.toString());
        return a.equalsIgnoreCase(str);
    }

    /* renamed from: a */
    public static String m29430a(File file) {
        String str = "Exception on closing MD5 input stream";
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[8192];
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        instance.update(bArr, 0, read);
                    } catch (IOException e) {
                        throw new RuntimeException("Unable to process file for MD5", e);
                    } catch (Throwable th) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            Log.e(f22950a, str, e2);
                        }
                        throw th;
                    }
                }
                String replace = String.format("%32s", new Object[]{new BigInteger(1, instance.digest()).toString(16)}).replace(' ', '0');
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                    Log.e(f22950a, str, e3);
                }
                return replace;
            } catch (FileNotFoundException e4) {
                Log.e(f22950a, "Exception while getting FileInputStream", e4);
                return null;
            }
        } catch (NoSuchAlgorithmException e5) {
            C6864a.m29302d(f22950a, "Exception while getting digest", e5);
            return null;
        }
    }
}
