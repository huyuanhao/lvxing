package com.qiyukf.basesdk.p412c.p416c;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.qiyukf.basesdk.c.c.d */
public class C5406d {
    /* renamed from: a */
    private static Map<String, Character> f17380a;
    /* renamed from: b */
    private static Pattern f17381b;

    /* renamed from: a */
    public static String m22116a() {
        return UUID.randomUUID().toString();
    }

    /* renamed from: a */
    public static String m22117a(float f) {
        return String.format(Locale.US, "%d%%", new Object[]{Integer.valueOf((int) (f * 100.0f))});
    }

    /* renamed from: a */
    public static String m22118a(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        String str2 = "";
        if (lastIndexOf == -1) {
            return str2;
        }
        int i = lastIndexOf + 1;
        for (int i2 = i; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && (charAt < '0' || charAt > '9'))) {
                return str2;
            }
        }
        return str.substring(i, str.length());
    }

    /* renamed from: a */
    public static boolean m22119a(CharSequence charSequence) {
        if (charSequence == null) {
            return true;
        }
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (charAt != ' ' && charAt != 10 && charAt != 9 && charAt != 13) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static String m22120b() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /* renamed from: b */
    public static String m22121b(String str) {
        int lastIndexOf = str.lastIndexOf(47);
        return lastIndexOf != -1 ? str.substring(lastIndexOf + 1, str.length()) : str;
    }

    /* renamed from: c */
    public static String m22122c(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        String a = m22118a(str.toLowerCase());
        if (!TextUtils.isEmpty(a)) {
            str2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(a);
        }
        return str2;
    }

    /* renamed from: d */
    public static String m22123d(String str) {
        if (f17380a == null || f17381b == null) {
            synchronized (C5406d.class) {
                if (f17380a == null || f17381b == null) {
                    HashMap hashMap = new HashMap(8);
                    f17380a = hashMap;
                    hashMap.put("&quot;", Character.valueOf('\"'));
                    f17380a.put("&amp;", Character.valueOf('&'));
                    f17380a.put("&lt;", Character.valueOf('<'));
                    f17380a.put("&gt;", Character.valueOf('>'));
                    f17380a.put("&#39;", Character.valueOf('\''));
                    f17380a.put("&nbsp;", Character.valueOf(' '));
                    f17381b = Pattern.compile("&quot;|&amp;|&lt;|&gt;|&#39;|&nbsp;");
                }
            }
        }
        Matcher matcher = f17381b.matcher(str);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            sb.append(str, i, start);
            Character ch = (Character) f17380a.get(str.substring(start, end));
            if (ch != null) {
                sb.append(ch);
            } else {
                sb.append(str, start, end);
            }
            i = end;
        }
        if (i == 0) {
            return str;
        }
        if (i < str.length()) {
            sb.append(str, i, str.length());
        }
        return sb.toString();
    }
}
