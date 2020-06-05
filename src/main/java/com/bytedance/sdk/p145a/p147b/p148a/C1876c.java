package com.bytedance.sdk.p145a.p147b.p148a;

import android.support.p000v4.media.session.PlaybackStateCompat;
import com.bytedance.sdk.p145a.p146a.Buffer;
import com.bytedance.sdk.p145a.p146a.ByteString;
import com.bytedance.sdk.p145a.p146a.Source;
import com.bytedance.sdk.p145a.p147b.HttpUrl;
import com.bytedance.sdk.p145a.p147b.RequestBody;
import com.bytedance.sdk.p145a.p147b.ResponseBody;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* compiled from: Util */
/* renamed from: com.bytedance.sdk.a.b.a.c */
public final class C1876c {
    /* renamed from: a */
    public static final byte[] f5398a = new byte[0];
    /* renamed from: b */
    public static final String[] f5399b = new String[0];
    /* renamed from: c */
    public static final ResponseBody f5400c = ResponseBody.m7408a(null, f5398a);
    /* renamed from: d */
    public static final RequestBody f5401d = RequestBody.m7367a(null, f5398a);
    /* renamed from: e */
    public static final Charset f5402e = Charset.forName("UTF-8");
    /* renamed from: f */
    public static final Charset f5403f = Charset.forName("ISO-8859-1");
    /* renamed from: g */
    public static final TimeZone f5404g = TimeZone.getTimeZone("GMT");
    /* renamed from: h */
    public static final Comparator<String> f5405h = new Comparator<String>() {
        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    };
    /* renamed from: i */
    private static final ByteString f5406i = ByteString.m6704b("efbbbf");
    /* renamed from: j */
    private static final ByteString f5407j = ByteString.m6704b("feff");
    /* renamed from: k */
    private static final ByteString f5408k = ByteString.m6704b("fffe");
    /* renamed from: l */
    private static final ByteString f5409l = ByteString.m6704b("0000ffff");
    /* renamed from: m */
    private static final ByteString f5410m = ByteString.m6704b("ffff0000");
    /* renamed from: n */
    private static final Charset f5411n = Charset.forName("UTF-16BE");
    /* renamed from: o */
    private static final Charset f5412o = Charset.forName("UTF-16LE");
    /* renamed from: p */
    private static final Charset f5413p = Charset.forName("UTF-32BE");
    /* renamed from: q */
    private static final Charset f5414q = Charset.forName("UTF-32LE");
    /* renamed from: r */
    private static final Pattern f5415r = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    /* renamed from: a */
    public static int m6946a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'a';
        if (c < 'a' || c > 'f') {
            c2 = 'A';
            if (c < 'A' || c > 'F') {
                return -1;
            }
        }
        return (c - c2) + 10;
    }

    /* renamed from: a */
    public static void m6960a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /* renamed from: a */
    public static boolean m6965a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    public static void m6961a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m6962a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e) {
                if (!m6964a(e)) {
                    throw e;
                }
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static boolean m6963a(Source sVar, int i, TimeUnit timeUnit) {
        try {
            return m6971b(sVar, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m6971b(Source sVar, int i, TimeUnit timeUnit) throws IOException {
        long nanoTime = System.nanoTime();
        long d = sVar.mo13512a().mo13616k_() ? sVar.mo13512a().mo13611d() - nanoTime : Long.MAX_VALUE;
        sVar.mo13512a().mo13609a(Math.min(d, timeUnit.toNanos((long) i)) + nanoTime);
        try {
            Buffer cVar = new Buffer();
            while (sVar.mo13511a(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                cVar.mo13573r();
            }
            if (d == Long.MAX_VALUE) {
                sVar.mo13512a().mo13613f();
            } else {
                sVar.mo13512a().mo13609a(nanoTime + d);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (d == Long.MAX_VALUE) {
                sVar.mo13512a().mo13613f();
            } else {
                sVar.mo13512a().mo13609a(nanoTime + d);
            }
            return false;
        } catch (Throwable th) {
            if (d == Long.MAX_VALUE) {
                sVar.mo13512a().mo13613f();
            } else {
                sVar.mo13512a().mo13609a(nanoTime + d);
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static <T> List<T> m6957a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    /* renamed from: a */
    public static <T> List<T> m6958a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    /* renamed from: a */
    public static ThreadFactory m6959a(final String str, final boolean z) {
        return new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    /* renamed from: a */
    public static String[] m6967a(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (comparator.compare(str, strArr2[i]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i++;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: b */
    public static boolean m6972b(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (!(strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0)) {
            for (String str : strArr) {
                for (String compare : strArr2) {
                    if (comparator.compare(str, compare) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static String m6953a(HttpUrl vVar, boolean z) {
        String str;
        String str2 = ":";
        if (vVar.mo14092f().contains(str2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(vVar.mo14092f());
            sb.append("]");
            str = sb.toString();
        } else {
            str = vVar.mo14092f();
        }
        if (!z && vVar.mo14093g() == HttpUrl.m7536a(vVar.mo14085b())) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(str2);
        sb2.append(vVar.mo14093g());
        return sb2.toString();
    }

    /* renamed from: a */
    public static boolean m6964a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    /* renamed from: a */
    public static int m6951a(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(strArr[i], str) == 0) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static String[] m6968a(String[] strArr, String str) {
        String[] strArr2 = new String[(strArr.length + 1)];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[strArr2.length - 1] = str;
        return strArr2;
    }

    /* renamed from: a */
    public static int m6947a(String str, int i, int i2) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: b */
    public static int m6970b(String str, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            char charAt = str.charAt(i3);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i3 + 1;
            }
        }
        return i;
    }

    /* renamed from: c */
    public static String m6973c(String str, int i, int i2) {
        int a = m6947a(str, i, i2);
        return str.substring(a, m6970b(str, a, i2));
    }

    /* renamed from: a */
    public static int m6949a(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    public static int m6948a(String str, int i, int i2, char c) {
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    public static String m6954a(String str) {
        InetAddress inetAddress;
        if (str.contains(":")) {
            if (!str.startsWith("[") || !str.endsWith("]")) {
                inetAddress = m6975d(str, 0, str.length());
            } else {
                inetAddress = m6975d(str, 1, str.length() - 1);
            }
            if (inetAddress == null) {
                return null;
            }
            byte[] address = inetAddress.getAddress();
            if (address.length == 16) {
                return m6956a(address);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid IPv6 address: '");
            sb.append(str);
            sb.append("'");
            throw new AssertionError(sb.toString());
        }
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (!lowerCase.isEmpty() && !m6976d(lowerCase)) {
                return lowerCase;
            }
            return null;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* renamed from: d */
    private static boolean m6976d(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static int m6969b(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: c */
    public static boolean m6974c(String str) {
        return f5415r.matcher(str).matches();
    }

    /* renamed from: a */
    public static String m6955a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    /* renamed from: a */
    public static int m6950a(String str, long j, TimeUnit timeUnit) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" < 0");
            throw new IllegalArgumentException(sb.toString());
        } else if (timeUnit != null) {
            long millis = timeUnit.toMillis(j);
            if (millis > 2147483647L) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(" too large.");
                throw new IllegalArgumentException(sb2.toString());
            } else if (millis != 0 || i <= 0) {
                return (int) millis;
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(" too small.");
                throw new IllegalArgumentException(sb3.toString());
            }
        } else {
            throw new NullPointerException("unit == null");
        }
    }

    /* renamed from: a */
    public static AssertionError m6952a(String str, Exception exc) {
        return (AssertionError) new AssertionError(str).initCause(exc);
    }

    /* renamed from: d */
    private static InetAddress m6975d(String str, int i, int i2) {
        int i3;
        byte[] bArr = new byte[16];
        int i4 = 0;
        int i5 = -1;
        int i6 = -1;
        while (true) {
            if (i >= i2) {
                break;
            } else if (i3 == bArr.length) {
                return null;
            } else {
                int i7 = i + 2;
                if (i7 > i2 || !str.regionMatches(i, "::", 0, 2)) {
                    if (i3 != 0) {
                        if (str.regionMatches(i, ":", 0, 1)) {
                            i++;
                        } else if (!str.regionMatches(i, ".", 0, 1) || !m6966a(str, i6, i2, bArr, i3 - 2)) {
                            return null;
                        } else {
                            i3 += 2;
                        }
                    }
                    i6 = i;
                } else if (i5 != -1) {
                    return null;
                } else {
                    i3 += 2;
                    i5 = i3;
                    if (i7 == i2) {
                        break;
                    }
                    i6 = i7;
                }
                i = i6;
                int i8 = 0;
                while (i < i2) {
                    int a = m6946a(str.charAt(i));
                    if (a == -1) {
                        break;
                    }
                    i8 = (i8 << 4) + a;
                    i++;
                }
                int i9 = i - i6;
                if (i9 == 0 || i9 > 4) {
                    return null;
                }
                int i10 = i3 + 1;
                bArr[i3] = (byte) ((i8 >>> 8) & 255);
                i4 = i10 + 1;
                bArr[i10] = (byte) (i8 & 255);
            }
        }
        if (i3 != bArr.length) {
            if (i5 == -1) {
                return null;
            }
            int i11 = i3 - i5;
            System.arraycopy(bArr, i5, bArr, bArr.length - i11, i11);
            Arrays.fill(bArr, i5, (bArr.length - i3) + i5, 0);
        }
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException unused) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    private static boolean m6966a(String str, int i, int i2, byte[] bArr, int i3) {
        int i4 = i3;
        while (i < i2) {
            if (i4 == bArr.length) {
                return false;
            }
            if (i4 != i3) {
                if (str.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int i5 = i;
            int i6 = 0;
            while (i5 < i2) {
                char charAt = str.charAt(i5);
                if (charAt < '0' || charAt > '9') {
                    break;
                } else if (i6 == 0 && i != i5) {
                    return false;
                } else {
                    i6 = ((i6 * 10) + charAt) - 48;
                    if (i6 > 255) {
                        return false;
                    }
                    i5++;
                }
            }
            if (i5 - i == 0) {
                return false;
            }
            int i7 = i4 + 1;
            bArr[i4] = (byte) i6;
            i4 = i7;
            i = i5;
        }
        if (i4 != i3 + 4) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private static String m6956a(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        while (i2 < bArr.length) {
            int i5 = i2;
            while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i2;
            if (i6 > i4 && i6 >= 4) {
                i3 = i2;
                i4 = i6;
            }
            i2 = i5 + 2;
        }
        Buffer cVar = new Buffer();
        while (i < bArr.length) {
            if (i == i3) {
                cVar.mo13559i(58);
                i += i4;
                if (i == 16) {
                    cVar.mo13559i(58);
                }
            } else {
                if (i > 0) {
                    cVar.mo13559i(58);
                }
                cVar.mo13564k((long) (((bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8) | (bArr[i + 1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED)));
                i += 2;
            }
        }
        return cVar.mo13570o();
    }
}
