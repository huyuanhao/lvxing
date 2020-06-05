package okhttp3;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* compiled from: MediaType */
/* renamed from: okhttp3.v */
public final class C8510v {
    /* renamed from: a */
    private static final Pattern f28905a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    /* renamed from: b */
    private static final Pattern f28906b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    /* renamed from: c */
    private final String f28907c;
    /* renamed from: d */
    private final String f28908d;
    /* renamed from: e */
    private final String f28909e;
    @Nullable
    /* renamed from: f */
    private final String f28910f;

    private C8510v(String str, String str2, String str3, @Nullable String str4) {
        this.f28907c = str;
        this.f28908d = str2;
        this.f28909e = str3;
        this.f28910f = str4;
    }

    /* renamed from: a */
    public static C8510v m36597a(String str) {
        Matcher matcher = f28905a.matcher(str);
        if (matcher.lookingAt()) {
            String lowerCase = matcher.group(1).toLowerCase(Locale.US);
            String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
            String str2 = null;
            Matcher matcher2 = f28906b.matcher(str);
            int end = matcher.end();
            while (end < str.length()) {
                matcher2.region(end, str.length());
                String str3 = "\" for: \"";
                if (matcher2.lookingAt()) {
                    String group = matcher2.group(1);
                    if (group != null && group.equalsIgnoreCase("charset")) {
                        String group2 = matcher2.group(2);
                        if (group2 != null) {
                            String str4 = "'";
                            if (group2.startsWith(str4) && group2.endsWith(str4) && group2.length() > 2) {
                                group2 = group2.substring(1, group2.length() - 1);
                            }
                        } else {
                            group2 = matcher2.group(3);
                        }
                        if (str2 == null || group2.equalsIgnoreCase(str2)) {
                            str2 = group2;
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Multiple charsets defined: \"");
                            sb.append(str2);
                            sb.append("\" and: \"");
                            sb.append(group2);
                            sb.append(str3);
                            sb.append(str);
                            sb.append('\"');
                            throw new IllegalArgumentException(sb.toString());
                        }
                    }
                    end = matcher2.end();
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Parameter is not formatted correctly: \"");
                    sb2.append(str.substring(end));
                    sb2.append(str3);
                    sb2.append(str);
                    sb2.append('\"');
                    throw new IllegalArgumentException(sb2.toString());
                }
            }
            return new C8510v(str, lowerCase, lowerCase2, str2);
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("No subtype found for: \"");
        sb3.append(str);
        sb3.append('\"');
        throw new IllegalArgumentException(sb3.toString());
    }

    @Nullable
    /* renamed from: b */
    public static C8510v m36598b(String str) {
        try {
            return m36597a(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public String mo40587a() {
        return this.f28908d;
    }

    @Nullable
    /* renamed from: b */
    public Charset mo40589b() {
        return mo40588a((Charset) null);
    }

    @Nullable
    /* renamed from: a */
    public Charset mo40588a(@Nullable Charset charset) {
        try {
            return this.f28910f != null ? Charset.forName(this.f28910f) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public String toString() {
        return this.f28907c;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof C8510v) && ((C8510v) obj).f28907c.equals(this.f28907c);
    }

    public int hashCode() {
        return this.f28907c.hashCode();
    }
}
