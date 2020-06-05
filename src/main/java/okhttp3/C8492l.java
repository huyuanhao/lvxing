package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.internal.C8417c;
import okhttp3.internal.p698b.C8407d;

/* compiled from: Cookie */
/* renamed from: okhttp3.l */
public final class C8492l {
    /* renamed from: a */
    private static final Pattern f28851a = Pattern.compile("(\\d{2,4})[^\\d]*");
    /* renamed from: b */
    private static final Pattern f28852b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    /* renamed from: c */
    private static final Pattern f28853c = Pattern.compile("(\\d{1,2})[^\\d]*");
    /* renamed from: d */
    private static final Pattern f28854d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    /* renamed from: e */
    private final String f28855e;
    /* renamed from: f */
    private final String f28856f;
    /* renamed from: g */
    private final long f28857g;
    /* renamed from: h */
    private final String f28858h;
    /* renamed from: i */
    private final String f28859i;
    /* renamed from: j */
    private final boolean f28860j;
    /* renamed from: k */
    private final boolean f28861k;
    /* renamed from: l */
    private final boolean f28862l;
    /* renamed from: m */
    private final boolean f28863m;

    private C8492l(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f28855e = str;
        this.f28856f = str2;
        this.f28857g = j;
        this.f28858h = str3;
        this.f28859i = str4;
        this.f28860j = z;
        this.f28861k = z2;
        this.f28863m = z3;
        this.f28862l = z4;
    }

    /* renamed from: a */
    public String mo40481a() {
        return this.f28855e;
    }

    /* renamed from: b */
    public String mo40483b() {
        return this.f28856f;
    }

    /* renamed from: a */
    private static boolean m36454a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        if (!str.endsWith(str2) || str.charAt((str.length() - str2.length()) - 1) != '.' || C8417c.m36054c(str)) {
            return false;
        }
        return true;
    }

    @Nullable
    /* renamed from: a */
    public static C8492l m36453a(C8506t tVar, String str) {
        return m36452a(System.currentTimeMillis(), tVar, str);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0131  */
    @javax.annotation.Nullable
    /* renamed from: a */
    static okhttp3.C8492l m36452a(long r24, okhttp3.C8506t r26, java.lang.String r27) {
        /*
        r0 = r27
        int r1 = r27.length()
        r2 = 59
        r3 = 0
        int r4 = okhttp3.internal.C8417c.m36024a(r0, r3, r1, r2)
        r5 = 61
        int r6 = okhttp3.internal.C8417c.m36024a(r0, r3, r4, r5)
        r7 = 0
        if (r6 != r4) goto L_0x0017
        return r7
    L_0x0017:
        java.lang.String r9 = okhttp3.internal.C8417c.m36053c(r0, r3, r6)
        boolean r8 = r9.isEmpty()
        if (r8 != 0) goto L_0x0146
        int r8 = okhttp3.internal.C8417c.m36049b(r9)
        r10 = -1
        if (r8 == r10) goto L_0x002a
        goto L_0x0146
    L_0x002a:
        r8 = 1
        int r6 = r6 + r8
        java.lang.String r6 = okhttp3.internal.C8417c.m36053c(r0, r6, r4)
        int r11 = okhttp3.internal.C8417c.m36049b(r6)
        if (r11 == r10) goto L_0x0037
        return r7
    L_0x0037:
        int r4 = r4 + r8
        r10 = -1
        r12 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
        r8 = r7
        r19 = r8
        r14 = r10
        r21 = r12
        r17 = 0
        r18 = 0
        r20 = 1
        r23 = 0
    L_0x004d:
        if (r4 >= r1) goto L_0x00c1
        int r7 = okhttp3.internal.C8417c.m36024a(r0, r4, r1, r2)
        int r2 = okhttp3.internal.C8417c.m36024a(r0, r4, r7, r5)
        java.lang.String r4 = okhttp3.internal.C8417c.m36053c(r0, r4, r2)
        if (r2 >= r7) goto L_0x0064
        int r2 = r2 + 1
        java.lang.String r2 = okhttp3.internal.C8417c.m36053c(r0, r2, r7)
        goto L_0x0066
    L_0x0064:
        java.lang.String r2 = ""
    L_0x0066:
        java.lang.String r5 = "expires"
        boolean r5 = r4.equalsIgnoreCase(r5)
        if (r5 == 0) goto L_0x0079
        int r4 = r2.length()     // Catch:{ IllegalArgumentException -> 0x00b9 }
        long r4 = m36450a(r2, r3, r4)     // Catch:{ IllegalArgumentException -> 0x00b9 }
        r21 = r4
        goto L_0x0086
    L_0x0079:
        java.lang.String r5 = "max-age"
        boolean r5 = r4.equalsIgnoreCase(r5)
        if (r5 == 0) goto L_0x0089
        long r4 = m36449a(r2)     // Catch:{  }
        r14 = r4
    L_0x0086:
        r23 = 1
        goto L_0x00b9
    L_0x0089:
        java.lang.String r5 = "domain"
        boolean r5 = r4.equalsIgnoreCase(r5)
        if (r5 == 0) goto L_0x0099
        java.lang.String r2 = m36455b(r2)     // Catch:{ IllegalArgumentException -> 0x00b9 }
        r8 = r2
        r20 = 0
        goto L_0x00b9
    L_0x0099:
        java.lang.String r5 = "path"
        boolean r5 = r4.equalsIgnoreCase(r5)
        if (r5 == 0) goto L_0x00a4
        r19 = r2
        goto L_0x00b9
    L_0x00a4:
        java.lang.String r2 = "secure"
        boolean r2 = r4.equalsIgnoreCase(r2)
        if (r2 == 0) goto L_0x00af
        r17 = 1
        goto L_0x00b9
    L_0x00af:
        java.lang.String r2 = "httponly"
        boolean r2 = r4.equalsIgnoreCase(r2)
        if (r2 == 0) goto L_0x00b9
        r18 = 1
    L_0x00b9:
        int r4 = r7 + 1
        r2 = 59
        r5 = 61
        r7 = 0
        goto L_0x004d
    L_0x00c1:
        r0 = -9223372036854775808
        int r2 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
        if (r2 != 0) goto L_0x00c9
    L_0x00c7:
        r11 = r0
        goto L_0x00ee
    L_0x00c9:
        int r0 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1))
        if (r0 == 0) goto L_0x00ec
        r0 = 9223372036854775(0x20c49ba5e353f7, double:4.663754807431093E-308)
        int r2 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
        if (r2 > 0) goto L_0x00db
        r0 = 1000(0x3e8, double:4.94E-321)
        long r14 = r14 * r0
        goto L_0x00e0
    L_0x00db:
        r14 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
    L_0x00e0:
        long r0 = r24 + r14
        int r2 = (r0 > r24 ? 1 : (r0 == r24 ? 0 : -1))
        if (r2 < 0) goto L_0x00ea
        int r2 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
        if (r2 <= 0) goto L_0x00c7
    L_0x00ea:
        r11 = r12
        goto L_0x00ee
    L_0x00ec:
        r11 = r21
    L_0x00ee:
        java.lang.String r0 = r26.mo40556f()
        if (r8 != 0) goto L_0x00f7
        r13 = r0
        r1 = 0
        goto L_0x0101
    L_0x00f7:
        boolean r1 = m36454a(r0, r8)
        if (r1 != 0) goto L_0x00ff
        r1 = 0
        return r1
    L_0x00ff:
        r1 = 0
        r13 = r8
    L_0x0101:
        int r0 = r0.length()
        int r2 = r13.length()
        if (r0 == r2) goto L_0x0116
        okhttp3.internal.publicsuffix.PublicSuffixDatabase r0 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.m36424a()
        java.lang.String r0 = r0.mo40459a(r13)
        if (r0 != 0) goto L_0x0116
        return r1
    L_0x0116:
        java.lang.String r0 = "/"
        r7 = r19
        if (r7 == 0) goto L_0x0125
        boolean r1 = r7.startsWith(r0)
        if (r1 != 0) goto L_0x0123
        goto L_0x0125
    L_0x0123:
        r14 = r7
        goto L_0x0136
    L_0x0125:
        java.lang.String r1 = r26.mo40560i()
        r2 = 47
        int r2 = r1.lastIndexOf(r2)
        if (r2 == 0) goto L_0x0135
        java.lang.String r0 = r1.substring(r3, r2)
    L_0x0135:
        r14 = r0
    L_0x0136:
        okhttp3.l r0 = new okhttp3.l
        r8 = r0
        r10 = r6
        r15 = r17
        r16 = r18
        r17 = r20
        r18 = r23
        r8.m55515init(r9, r10, r11, r13, r14, r15, r16, r17, r18)
        return r0
    L_0x0146:
        r0 = r7
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.C8492l.m36452a(long, okhttp3.t, java.lang.String):okhttp3.l");
    }

    /* renamed from: a */
    private static long m36450a(String str, int i, int i2) {
        int a = m36448a(str, i, i2, false);
        Matcher matcher = f28854d.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        while (a < i2) {
            int a2 = m36448a(str, a + 1, i2, true);
            matcher.region(a, a2);
            if (i4 == -1 && matcher.usePattern(f28854d).matches()) {
                int parseInt = Integer.parseInt(matcher.group(1));
                int parseInt2 = Integer.parseInt(matcher.group(2));
                i8 = Integer.parseInt(matcher.group(3));
                i7 = parseInt2;
                i4 = parseInt;
            } else if (i5 == -1 && matcher.usePattern(f28853c).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
            } else if (i6 == -1 && matcher.usePattern(f28852b).matches()) {
                i6 = f28852b.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
            } else if (i3 == -1 && matcher.usePattern(f28851a).matches()) {
                i3 = Integer.parseInt(matcher.group(1));
            }
            a = m36448a(str, a2 + 1, i2, false);
        }
        if (i3 >= 70 && i3 <= 99) {
            i3 += 1900;
        }
        if (i3 >= 0 && i3 <= 69) {
            i3 += 2000;
        }
        if (i3 < 1601) {
            throw new IllegalArgumentException();
        } else if (i6 == -1) {
            throw new IllegalArgumentException();
        } else if (i5 < 1 || i5 > 31) {
            throw new IllegalArgumentException();
        } else if (i4 < 0 || i4 > 23) {
            throw new IllegalArgumentException();
        } else if (i7 < 0 || i7 > 59) {
            throw new IllegalArgumentException();
        } else if (i8 < 0 || i8 > 59) {
            throw new IllegalArgumentException();
        } else {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(C8417c.f28534g);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i3);
            gregorianCalendar.set(2, i6 - 1);
            gregorianCalendar.set(5, i5);
            gregorianCalendar.set(11, i4);
            gregorianCalendar.set(12, i7);
            gregorianCalendar.set(13, i8);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
    }

    /* renamed from: a */
    private static int m36448a(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char charAt = str.charAt(i);
            boolean z2 = (charAt < ' ' && charAt != 9) || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'));
            if (z2 == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    private static long m36449a(String str) {
        long j = Long.MIN_VALUE;
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 0) {
                j = parseLong;
            }
            return j;
        } catch (NumberFormatException e) {
            if (str.matches("-?\\d+")) {
                if (!str.startsWith("-")) {
                    j = Long.MAX_VALUE;
                }
                return j;
            }
            throw e;
        }
    }

    /* renamed from: b */
    private static String m36455b(String str) {
        String str2 = ".";
        if (!str.endsWith(str2)) {
            if (str.startsWith(str2)) {
                str = str.substring(1);
            }
            String a = C8417c.m36029a(str);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    public static List<C8492l> m36451a(C8506t tVar, C8504s sVar) {
        List b = sVar.mo40535b("Set-Cookie");
        int size = b.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            C8492l a = m36453a(tVar, (String) b.get(i));
            if (a != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(a);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public String toString() {
        return mo40482a(false);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo40482a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f28855e);
        sb.append('=');
        sb.append(this.f28856f);
        if (this.f28862l) {
            if (this.f28857g == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(C8407d.m35972a(new Date(this.f28857g)));
            }
        }
        if (!this.f28863m) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.f28858h);
        }
        sb.append("; path=");
        sb.append(this.f28859i);
        if (this.f28860j) {
            sb.append("; secure");
        }
        if (this.f28861k) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public boolean equals(@Nullable Object obj) {
        boolean z = false;
        if (!(obj instanceof C8492l)) {
            return false;
        }
        C8492l lVar = (C8492l) obj;
        if (lVar.f28855e.equals(this.f28855e) && lVar.f28856f.equals(this.f28856f) && lVar.f28858h.equals(this.f28858h) && lVar.f28859i.equals(this.f28859i) && lVar.f28857g == this.f28857g && lVar.f28860j == this.f28860j && lVar.f28861k == this.f28861k && lVar.f28862l == this.f28862l && lVar.f28863m == this.f28863m) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        int hashCode = (((((((527 + this.f28855e.hashCode()) * 31) + this.f28856f.hashCode()) * 31) + this.f28858h.hashCode()) * 31) + this.f28859i.hashCode()) * 31;
        long j = this.f28857g;
        return ((((((((hashCode + ((int) (j ^ (j >>> 32)))) * 31) + (!this.f28860j)) * 31) + (!this.f28861k)) * 31) + (!this.f28862l)) * 31) + (!this.f28863m);
    }
}
