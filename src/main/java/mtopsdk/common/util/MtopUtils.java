package mtopsdk.common.util;

import android.os.Looper;
import android.text.TextUtils;
import java.lang.Character.UnicodeBlock;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: mtopsdk.common.util.b */
public final class MtopUtils {
    /* renamed from: a */
    public static final List<String> f27841a = Collections.singletonList("mtop.common.gettimestamp$*");
    /* renamed from: b */
    private static AtomicInteger f27842b = new AtomicInteger();
    /* renamed from: c */
    private static final char[] f27843c = {'E', 'T', 'A', 'O', 'I', 'N', 'S', 'R', 'H', 'L', 'D', 'C', 'U', 'M', 'F', 'P', 'G', 'W', 'Y', 'B', 'V', 'K', 'X', 'J', 'Q', 'Z'};
    /* renamed from: d */
    private static final char[] f27844d = {'e', 't', 'a', 'o', 'i', 'n', 's', 'r', 'h', 'l', 'd', 'c', 'u', 'm', 'f', 'p', 'g', 'w', 'y', 'b', 'v', 'k', 'x', 'j', 'q', 'z'};
    /* renamed from: e */
    private static final char[] f27845e = {'8', '6', '1', '5', '9', '2', '3', '0', '4', '7'};

    /* renamed from: a */
    public static int m35516a() {
        return f27842b.incrementAndGet() & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    /* renamed from: b */
    public static boolean m35519b() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    /* renamed from: a */
    public static String m35517a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("//")) {
                StringBuilder sb = new StringBuilder("http:");
                sb.append(str);
                str = sb.toString();
            }
            try {
                int indexOf = str.indexOf("?");
                if (indexOf != -1) {
                    return str.substring(0, indexOf);
                }
                int indexOf2 = str.indexOf("#");
                return indexOf2 != -1 ? str.substring(0, indexOf2) : str;
            } catch (Exception unused) {
            }
        }
        return "";
    }

    /* renamed from: b */
    public static String m35518b(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt >= 'A' && charAt <= 'Z') {
                charAt = f27843c[charAt - 'A'];
            } else if (charAt >= 'a' && charAt <= 'z') {
                charAt = f27844d[charAt - 'a'];
            } else if (charAt >= '0' && charAt <= '9') {
                charAt = f27845e[charAt - '0'];
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    /* renamed from: c */
    public static final boolean m35520c(String str) {
        if (str == null) {
            return false;
        }
        char[] charArray = str.toCharArray();
        int i = 0;
        while (i < charArray.length) {
            char c = charArray[i];
            try {
                UnicodeBlock of = UnicodeBlock.of(c);
                if (of == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == UnicodeBlock.GENERAL_PUNCTUATION || of == UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of == UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
                    return true;
                }
                i++;
            } catch (Throwable unused) {
                if (c >= 19968 && c <= 40959) {
                    return true;
                }
            }
        }
        return false;
    }
}
