package okhttp3.internal;

import android.support.p000v4.media.session.PlaybackStateCompat;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.C8358aa;
import okhttp3.C8364ac;
import okhttp3.C8506t;
import okhttp3.C8510v;
import okio.ByteString;
import okio.C8525c;
import okio.C8529e;
import okio.C8547r;

/* compiled from: Util */
/* renamed from: okhttp3.internal.c */
public final class C8417c {
    /* renamed from: a */
    public static final byte[] f28528a = new byte[0];
    /* renamed from: b */
    public static final String[] f28529b = new String[0];
    /* renamed from: c */
    public static final C8364ac f28530c = C8364ac.m35817a((C8510v) null, f28528a);
    /* renamed from: d */
    public static final C8358aa f28531d = C8358aa.m35767a((C8510v) null, f28528a);
    /* renamed from: e */
    public static final Charset f28532e = Charset.forName("UTF-8");
    /* renamed from: f */
    public static final Charset f28533f = Charset.forName("ISO-8859-1");
    /* renamed from: g */
    public static final TimeZone f28534g = TimeZone.getTimeZone("GMT");
    /* renamed from: h */
    public static final Comparator<String> f28535h = new Comparator<String>() {
        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    };
    /* renamed from: i */
    private static final ByteString f28536i = ByteString.decodeHex("efbbbf");
    /* renamed from: j */
    private static final ByteString f28537j = ByteString.decodeHex("feff");
    /* renamed from: k */
    private static final ByteString f28538k = ByteString.decodeHex("fffe");
    /* renamed from: l */
    private static final ByteString f28539l = ByteString.decodeHex("0000ffff");
    /* renamed from: m */
    private static final ByteString f28540m = ByteString.decodeHex("ffff0000");
    /* renamed from: n */
    private static final Charset f28541n = Charset.forName("UTF-16BE");
    /* renamed from: o */
    private static final Charset f28542o = Charset.forName("UTF-16LE");
    /* renamed from: p */
    private static final Charset f28543p = Charset.forName("UTF-32BE");
    /* renamed from: q */
    private static final Charset f28544q = Charset.forName("UTF-32LE");
    /* renamed from: r */
    private static final Method f28545r;
    /* renamed from: s */
    private static final Pattern f28546s = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    /* renamed from: a */
    public static int m36022a(char c) {
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

    static {
        Method method = null;
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class});
        } catch (Exception unused) {
        }
        f28545r = method;
    }

    /* renamed from: a */
    public static void m36041a(Throwable th, Throwable th2) {
        Method method = f28545r;
        if (method != null) {
            try {
                method.invoke(th, new Object[]{th2});
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m36039a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /* renamed from: a */
    public static boolean m36044a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    public static void m36040a(Closeable closeable) {
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
    public static void m36042a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e) {
                if (!m36043a(e)) {
                    throw e;
                }
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static boolean m36046a(C8547r rVar, int i, TimeUnit timeUnit) {
        try {
            return m36052b(rVar, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m36052b(C8547r rVar, int i, TimeUnit timeUnit) throws IOException {
        long nanoTime = System.nanoTime();
        long d = rVar.mo40203a().mo40809o_() ? rVar.mo40203a().mo40805d() - nanoTime : Long.MAX_VALUE;
        rVar.mo40203a().mo40803a(Math.min(d, timeUnit.toNanos((long) i)) + nanoTime);
        try {
            C8525c cVar = new C8525c();
            while (rVar.mo40202a(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                cVar.mo40781t();
            }
            if (d == Long.MAX_VALUE) {
                rVar.mo40203a().mo40806f();
            } else {
                rVar.mo40203a().mo40803a(nanoTime + d);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (d == Long.MAX_VALUE) {
                rVar.mo40203a().mo40806f();
            } else {
                rVar.mo40203a().mo40803a(nanoTime + d);
            }
            return false;
        } catch (Throwable th) {
            if (d == Long.MAX_VALUE) {
                rVar.mo40203a().mo40806f();
            } else {
                rVar.mo40203a().mo40803a(nanoTime + d);
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static <T> List<T> m36034a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    /* renamed from: a */
    public static <K, V> Map<K, V> m36036a(Map<K, V> map) {
        if (map.isEmpty()) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    /* renamed from: a */
    public static <T> List<T> m36035a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    /* renamed from: a */
    public static ThreadFactory m36037a(final String str, final boolean z) {
        return new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    /* renamed from: a */
    public static String[] m36047a(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
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
    public static boolean m36051b(Comparator<String> comparator, String[] strArr, String[] strArr2) {
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
    public static String m36031a(C8506t tVar, boolean z) {
        String str;
        String str2 = ":";
        if (tVar.mo40556f().contains(str2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(tVar.mo40556f());
            sb.append("]");
            str = sb.toString();
        } else {
            str = tVar.mo40556f();
        }
        if (!z && tVar.mo40557g() == C8506t.m36532a(tVar.mo40549b())) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(str2);
        sb2.append(tVar.mo40557g());
        return sb2.toString();
    }

    /* renamed from: a */
    public static boolean m36043a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    /* renamed from: a */
    public static int m36027a(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(strArr[i], str) == 0) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static String[] m36048a(String[] strArr, String str) {
        String[] strArr2 = new String[(strArr.length + 1)];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[strArr2.length - 1] = str;
        return strArr2;
    }

    /* renamed from: a */
    public static int m36023a(String str, int i, int i2) {
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
    public static int m36050b(String str, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            char charAt = str.charAt(i3);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i3 + 1;
            }
        }
        return i;
    }

    /* renamed from: c */
    public static String m36053c(String str, int i, int i2) {
        int a = m36023a(str, i, i2);
        return str.substring(a, m36050b(str, a, i2));
    }

    /* renamed from: a */
    public static int m36025a(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    public static int m36024a(String str, int i, int i2, char c) {
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    public static String m36029a(String str) {
        InetAddress inetAddress;
        if (str.contains(":")) {
            if (!str.startsWith("[") || !str.endsWith("]")) {
                inetAddress = m36055d(str, 0, str.length());
            } else {
                inetAddress = m36055d(str, 1, str.length() - 1);
            }
            if (inetAddress == null) {
                return null;
            }
            byte[] address = inetAddress.getAddress();
            if (address.length == 16) {
                return m36032a(address);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid IPv6 address: '");
            sb.append(str);
            sb.append("'");
            throw new AssertionError(sb.toString());
        }
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (!lowerCase.isEmpty() && !m36056d(lowerCase)) {
                return lowerCase;
            }
            return null;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* renamed from: d */
    private static boolean m36056d(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static int m36049b(String str) {
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
    public static boolean m36054c(String str) {
        return f28546s.matcher(str).matches();
    }

    /* renamed from: a */
    public static String m36030a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    /* renamed from: a */
    public static Charset m36033a(C8529e eVar, Charset charset) throws IOException {
        if (eVar.mo40731a(0, f28536i)) {
            eVar.mo40761h((long) f28536i.size());
            return f28532e;
        } else if (eVar.mo40731a(0, f28537j)) {
            eVar.mo40761h((long) f28537j.size());
            return f28541n;
        } else if (eVar.mo40731a(0, f28538k)) {
            eVar.mo40761h((long) f28538k.size());
            return f28542o;
        } else if (eVar.mo40731a(0, f28539l)) {
            eVar.mo40761h((long) f28539l.size());
            return f28543p;
        } else if (!eVar.mo40731a(0, f28540m)) {
            return charset;
        } else {
            eVar.mo40761h((long) f28540m.size());
            return f28544q;
        }
    }

    /* renamed from: a */
    public static int m36026a(String str, long j, TimeUnit timeUnit) {
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
    public static AssertionError m36028a(String str, Exception exc) {
        AssertionError assertionError = new AssertionError(str);
        try {
            assertionError.initCause(exc);
        } catch (IllegalStateException unused) {
        }
        return assertionError;
    }

    @Nullable
    /* renamed from: d */
    private static InetAddress m36055d(String str, int i, int i2) {
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
                        } else if (!str.regionMatches(i, ".", 0, 1) || !m36045a(str, i6, i2, bArr, i3 - 2)) {
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
                    int a = m36022a(str.charAt(i));
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
    private static boolean m36045a(String str, int i, int i2, byte[] bArr, int i3) {
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
    private static String m36032a(byte[] bArr) {
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
        C8525c cVar = new C8525c();
        while (i < bArr.length) {
            if (i == i3) {
                cVar.mo40765i(58);
                i += i4;
                if (i == 16) {
                    cVar.mo40765i(58);
                }
            } else {
                if (i > 0) {
                    cVar.mo40765i(58);
                }
                cVar.mo40770k((long) (((bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8) | (bArr[i + 1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED)));
                i += 2;
            }
        }
        return cVar.mo40777q();
    }

    /* renamed from: a */
    public static X509TrustManager m36038a() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init(null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected default trust managers:");
            sb.append(Arrays.toString(trustManagers));
            throw new IllegalStateException(sb.toString());
        } catch (GeneralSecurityException e) {
            throw m36028a("No System TLS", (Exception) e);
        }
    }
}
