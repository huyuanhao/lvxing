package com.alipay.p109b.p110a.p111a.p112a;

import android.os.Environment;
import android.util.Base64;
import com.alipay.p109b.p110a.p111a.p112a.p113a.C1461a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* renamed from: com.alipay.b.a.a.a.a */
public final class C1460a {
    /* renamed from: a */
    public static File m4257a() {
        try {
            return (File) Environment.class.getMethod(new String(C1461a.m4269a("Z2V0RXh0ZXJuYWxTdG9yYWdlRGlyZWN0b3J5")), new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m4258a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    /* renamed from: a */
    public static String m4259a(Map<String, String> map, String str, String str2) {
        if (map == null) {
            return str2;
        }
        String str3 = (String) map.get(str);
        return str3 == null ? str2 : str3;
    }

    /* renamed from: a */
    public static boolean m4260a(String str) {
        if (str != null) {
            int length = str.length();
            if (length != 0) {
                for (int i = 0; i < length; i++) {
                    if (!Character.isWhitespace(str.charAt(i))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m4261a(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    /* renamed from: b */
    public static String m4262b(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{str, str2});
        } catch (Exception unused) {
            return str2;
        }
    }

    /* renamed from: b */
    public static boolean m4263b(String str) {
        return !m4260a(str);
    }

    /* renamed from: c */
    public static boolean m4264c(String str) {
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        for (int i = 0; i < length; i++) {
            byte b = bytes[i];
            if ((b >= 0 && b <= 31) || b >= Byte.MAX_VALUE) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    public static String m4265d(String str) {
        return str == null ? "" : str;
    }

    /* renamed from: e */
    public static String m4266e(String str) {
        try {
            if (m4260a(str)) {
                return null;
            }
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(str.getBytes("UTF-8"));
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (byte valueOf : digest) {
                sb.append(String.format("%02x", new Object[]{Byte.valueOf(valueOf)}));
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: f */
    public static String m4267f(String str) {
        try {
            byte[] array = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(str.length()).array();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes("UTF-8"));
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            byte[] bArr = new byte[(byteArrayOutputStream.toByteArray().length + 4)];
            System.arraycopy(array, 0, bArr, 0, 4);
            System.arraycopy(byteArrayOutputStream.toByteArray(), 0, bArr, 4, byteArrayOutputStream.toByteArray().length);
            return Base64.encodeToString(bArr, 8);
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: g */
    public static String m4268g(String str) {
        String str2;
        String str3 = "";
        if (m4260a(str)) {
            return str3;
        }
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes("utf-8"));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = byteArrayInputStream.read(bArr, 0, 1024);
                if (read == -1) {
                    break;
                }
                gZIPOutputStream.write(bArr, 0, read);
            }
            gZIPOutputStream.flush();
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            byteArrayInputStream.close();
            str2 = new String(Base64.encode(byteArray, 2));
        } catch (Exception unused) {
            str2 = str3;
        }
        return str2;
    }
}
