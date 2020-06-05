package com.bytedance.sdk.p145a.p147b;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.bytedance.sdk.a.b.y */
public final class MediaType {
    /* renamed from: a */
    private static final Pattern f5991a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    /* renamed from: b */
    private static final Pattern f5992b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    /* renamed from: c */
    private final String f5993c;
    /* renamed from: d */
    private final String f5994d;
    /* renamed from: e */
    private final String f5995e;
    /* renamed from: f */
    private final String f5996f;

    private MediaType(String str, String str2, String str3, String str4) {
        this.f5993c = str;
        this.f5994d = str2;
        this.f5995e = str3;
        this.f5996f = str4;
    }

    /* renamed from: a */
    public static MediaType m7593a(String str) {
        Matcher matcher = f5991a.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String lowerCase = matcher.group(1).toLowerCase(Locale.US);
        String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = f5992b.matcher(str);
        String str2 = null;
        for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            String group = matcher2.group(1);
            if (group != null && group.equalsIgnoreCase("charset")) {
                String group2 = matcher2.group(2);
                if (group2 != null) {
                    String str3 = "'";
                    if (group2.startsWith(str3) && group2.endsWith(str3) && group2.length() > 2) {
                        group2 = group2.substring(1, group2.length() - 1);
                    }
                } else {
                    group2 = matcher2.group(3);
                }
                if (str2 != null && !group2.equalsIgnoreCase(str2)) {
                    return null;
                }
                str2 = group2;
            }
        }
        return new MediaType(str, lowerCase, lowerCase2, str2);
    }

    public String toString() {
        return this.f5993c;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MediaType) && ((MediaType) obj).f5993c.equals(this.f5993c);
    }

    public int hashCode() {
        return this.f5993c.hashCode();
    }
}
