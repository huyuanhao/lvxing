package mtopsdk.common.util;

import java.util.Locale;

/* compiled from: StringUtils */
/* renamed from: mtopsdk.common.util.d */
public class C8330d {
    /* renamed from: a */
    public static boolean m35523a(String str) {
        return !m35525b(str);
    }

    /* renamed from: b */
    public static boolean m35525b(String str) {
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
    public static String m35522a(String str, String str2) {
        if (m35525b(str) || m35525b(str2)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str.trim());
        sb.append("$");
        sb.append(str2.trim());
        return sb.toString();
    }

    /* renamed from: b */
    public static String m35524b(String str, String str2) {
        if (m35525b(str) || m35525b(str2)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str.trim());
        sb.append("$");
        sb.append(str2.trim());
        return sb.toString().toLowerCase(Locale.US);
    }
}
