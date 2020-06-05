package com.qiyukf.basesdk.p412c.p416c;

import android.text.util.Linkify.MatchFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.qiyukf.basesdk.c.c.b */
public final class C5402b {
    /* renamed from: a */
    public static final Pattern f17373a = Pattern.compile("((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))");
    /* renamed from: b */
    public static final Pattern f17374b;
    /* renamed from: c */
    public static final Pattern f17375c;
    /* renamed from: d */
    public static final MatchFilter f17376d = new MatchFilter() {
        public final boolean acceptMatch(CharSequence charSequence, int i, int i2) {
            if (i == 0) {
                return true;
            }
            return charSequence.charAt(i + -1) != '@' && !((String) charSequence).regionMatches(i - 3, "://", 0, 3);
        }
    };

    /* renamed from: com.qiyukf.basesdk.c.c.b$a */
    public static class C5404a {
        /* renamed from: a */
        public String f17377a;
        /* renamed from: b */
        public int f17378b;
        /* renamed from: c */
        public int f17379c;
    }

    static {
        StringBuilder sb = new StringBuilder("(([a-zA-Z0-9]([a-zA-Z0-9\\-]{0,61}[a-zA-Z0-9]){0,1}\\.)+[a-zA-Z]{2,63}|");
        sb.append(f17373a);
        sb.append(")");
        f17374b = Pattern.compile(sb.toString());
        StringBuilder sb2 = new StringBuilder("((?:(http|https|Http|Https|HTTP|HTTPS|rtsp|Rtsp|RTSP):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?(?:");
        sb2.append(f17374b);
        sb2.append(")(?:\\:\\d{1,5})?)(\\/(?:(?:[a-zA-Z0-9¡-퟿豈-﷏ﷰ-￯\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?(?:\\b|$)");
        f17375c = Pattern.compile(sb2.toString());
    }

    /* renamed from: a */
    public static List<C5404a> m22111a(String str) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = f17375c.matcher(str);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (f17376d.acceptMatch(str, start, end)) {
                C5404a aVar = new C5404a();
                aVar.f17377a = m22112b(matcher.group(0));
                aVar.f17378b = start;
                aVar.f17379c = end;
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private static String m22112b(String str) {
        boolean z;
        String[] strArr = {"http://", "https://", "rtsp://"};
        int i = 0;
        while (true) {
            z = true;
            if (i >= 3) {
                z = false;
                break;
            }
            if (str.regionMatches(true, 0, strArr[i], 0, strArr[i].length())) {
                if (!str.regionMatches(false, 0, strArr[i], 0, strArr[i].length())) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(strArr[i]);
                    sb.append(str.substring(strArr[i].length()));
                    str = sb.toString();
                }
            } else {
                i++;
            }
        }
        if (z) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(strArr[0]);
        sb2.append(str);
        return sb2.toString();
    }
}
