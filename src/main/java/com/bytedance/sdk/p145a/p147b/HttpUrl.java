package com.bytedance.sdk.p145a.p147b;

import com.bytedance.sdk.p145a.p146a.Buffer;
import com.bytedance.sdk.p145a.p147b.p148a.C1876c;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Marker;

/* renamed from: com.bytedance.sdk.a.b.v */
public final class HttpUrl {
    /* renamed from: d */
    private static final char[] f5961d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    /* renamed from: a */
    final String f5962a;
    /* renamed from: b */
    final String f5963b;
    /* renamed from: c */
    final int f5964c;
    /* renamed from: e */
    private final String f5965e;
    /* renamed from: f */
    private final String f5966f;
    /* renamed from: g */
    private final List<String> f5967g;
    /* renamed from: h */
    private final List<String> f5968h;
    /* renamed from: i */
    private final String f5969i;
    /* renamed from: j */
    private final String f5970j;

    /* compiled from: HttpUrl */
    /* renamed from: com.bytedance.sdk.a.b.v$a */
    public static final class C1937a {
        /* renamed from: a */
        String f5971a;
        /* renamed from: b */
        String f5972b;
        /* renamed from: c */
        String f5973c;
        /* renamed from: d */
        String f5974d;
        /* renamed from: e */
        int f5975e = -1;
        /* renamed from: f */
        final List<String> f5976f = new ArrayList();
        /* renamed from: g */
        List<String> f5977g;
        /* renamed from: h */
        String f5978h;

        /* compiled from: HttpUrl */
        /* renamed from: com.bytedance.sdk.a.b.v$a$a */
        enum C1938a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public C1937a() {
            String str = "";
            this.f5972b = str;
            this.f5973c = str;
            this.f5976f.add(str);
        }

        /* renamed from: a */
        public C1937a mo14106a(String str) {
            if (str != null) {
                String str2 = "http";
                if (str.equalsIgnoreCase(str2)) {
                    this.f5971a = str2;
                } else {
                    String str3 = "https";
                    if (str.equalsIgnoreCase(str3)) {
                        this.f5971a = str3;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("unexpected scheme: ");
                        sb.append(str);
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
                return this;
            }
            throw new NullPointerException("scheme == null");
        }

        /* renamed from: b */
        public C1937a mo14108b(String str) {
            if (str != null) {
                this.f5972b = HttpUrl.m7540a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("username == null");
        }

        /* renamed from: c */
        public C1937a mo14109c(String str) {
            if (str != null) {
                this.f5973c = HttpUrl.m7540a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("password == null");
        }

        /* renamed from: d */
        public C1937a mo14111d(String str) {
            if (str != null) {
                String e = m7572e(str, 0, str.length());
                if (e != null) {
                    this.f5974d = e;
                    return this;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("unexpected host: ");
                sb.append(str);
                throw new IllegalArgumentException(sb.toString());
            }
            throw new NullPointerException("host == null");
        }

        /* renamed from: a */
        public C1937a mo14105a(int i) {
            if (i <= 0 || i > 65535) {
                StringBuilder sb = new StringBuilder();
                sb.append("unexpected port: ");
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
            }
            this.f5975e = i;
            return this;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public int mo14103a() {
            int i = this.f5975e;
            return i != -1 ? i : HttpUrl.m7536a(this.f5971a);
        }

        /* renamed from: e */
        public C1937a mo14112e(String str) {
            List<String> list;
            if (str != null) {
                list = HttpUrl.m7547b(HttpUrl.m7540a(str, " \"'<>#", true, false, true, true));
            } else {
                list = null;
            }
            this.f5977g = list;
            return this;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public C1937a mo14107b() {
            int size = this.f5976f.size();
            for (int i = 0; i < size; i++) {
                this.f5976f.set(i, HttpUrl.m7540a((String) this.f5976f.get(i), "[]", true, true, false, true));
            }
            List<String> list = this.f5977g;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) this.f5977g.get(i2);
                    if (str != null) {
                        this.f5977g.set(i2, HttpUrl.m7540a(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.f5978h;
            if (str2 != null) {
                this.f5978h = HttpUrl.m7540a(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        /* renamed from: c */
        public HttpUrl mo14110c() {
            if (this.f5971a == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.f5974d != null) {
                return new HttpUrl(this);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f5971a);
            sb.append("://");
            if (!this.f5972b.isEmpty() || !this.f5973c.isEmpty()) {
                sb.append(this.f5972b);
                if (!this.f5973c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f5973c);
                }
                sb.append('@');
            }
            if (this.f5974d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.f5974d);
                sb.append(']');
            } else {
                sb.append(this.f5974d);
            }
            int a = mo14103a();
            if (a != HttpUrl.m7536a(this.f5971a)) {
                sb.append(':');
                sb.append(a);
            }
            HttpUrl.m7545a(sb, this.f5976f);
            if (this.f5977g != null) {
                sb.append('?');
                HttpUrl.m7548b(sb, this.f5977g);
            }
            if (this.f5978h != null) {
                sb.append('#');
                sb.append(this.f5978h);
            }
            return sb.toString();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C1938a mo14104a(HttpUrl vVar, String str) {
            int i;
            int a;
            int i2;
            HttpUrl vVar2 = vVar;
            String str2 = str;
            int a2 = C1876c.m6947a(str2, 0, str.length());
            int b = C1876c.m6970b(str2, a2, str.length());
            if (m7568b(str2, a2, b) != -1) {
                if (str.regionMatches(true, a2, "https:", 0, 6)) {
                    this.f5971a = "https";
                    a2 += 6;
                } else {
                    if (!str.regionMatches(true, a2, "http:", 0, 5)) {
                        return C1938a.UNSUPPORTED_SCHEME;
                    }
                    this.f5971a = "http";
                    a2 += 5;
                }
            } else if (vVar2 == null) {
                return C1938a.MISSING_SCHEME;
            } else {
                this.f5971a = vVar2.f5962a;
            }
            int c = m7569c(str2, a2, b);
            char c2 = '?';
            char c3 = '#';
            if (c >= 2 || vVar2 == null || !vVar2.f5962a.equals(this.f5971a)) {
                int i3 = a2 + c;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    a = C1876c.m6949a(str2, i3, b, "@/\\?#");
                    char charAt = a != b ? str2.charAt(a) : 65535;
                    if (charAt == 65535 || charAt == c3 || charAt == '/' || charAt == '\\' || charAt == c2) {
                        i = a;
                        int d = m7570d(str2, i3, i);
                        int i4 = d + 1;
                    } else {
                        if (charAt == '@') {
                            String str3 = "%40";
                            if (!z) {
                                int a3 = C1876c.m6948a(str2, i3, a, ':');
                                int i5 = a3;
                                String str4 = str3;
                                i2 = a;
                                String a4 = HttpUrl.m7538a(str, i3, a3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                if (z2) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(this.f5972b);
                                    sb.append(str4);
                                    sb.append(a4);
                                    a4 = sb.toString();
                                }
                                this.f5972b = a4;
                                if (i5 != i2) {
                                    this.f5973c = HttpUrl.m7538a(str, i5 + 1, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                    z = true;
                                }
                                z2 = true;
                            } else {
                                String str5 = str3;
                                i2 = a;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(this.f5973c);
                                sb2.append(str5);
                                sb2.append(HttpUrl.m7538a(str, i3, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null));
                                this.f5973c = sb2.toString();
                            }
                            i3 = i2 + 1;
                        }
                        c2 = '?';
                        c3 = '#';
                    }
                }
                i = a;
                int d2 = m7570d(str2, i3, i);
                int i42 = d2 + 1;
                if (i42 < i) {
                    this.f5974d = m7572e(str2, i3, d2);
                    this.f5975e = m7573f(str2, i42, i);
                    if (this.f5975e == -1) {
                        return C1938a.INVALID_PORT;
                    }
                } else {
                    this.f5974d = m7572e(str2, i3, d2);
                    this.f5975e = HttpUrl.m7536a(this.f5971a);
                }
                if (this.f5974d == null) {
                    return C1938a.INVALID_HOST;
                }
            } else {
                this.f5972b = vVar.mo14089d();
                this.f5973c = vVar.mo14090e();
                this.f5974d = vVar2.f5963b;
                this.f5975e = vVar2.f5964c;
                this.f5976f.clear();
                this.f5976f.addAll(vVar.mo14096i());
                if (a2 == b || str2.charAt(a2) == '#') {
                    mo14112e(vVar.mo14097j());
                }
                i = a2;
            }
            int a5 = C1876c.m6949a(str2, i, b, "?#");
            m7566a(str2, i, a5);
            if (a5 < b && str2.charAt(a5) == '?') {
                int a6 = C1876c.m6948a(str2, a5, b, '#');
                this.f5977g = HttpUrl.m7547b(HttpUrl.m7538a(str, a5 + 1, a6, " \"'<>#", true, false, true, true, null));
                a5 = a6;
            }
            if (a5 < b && str2.charAt(a5) == '#') {
                this.f5978h = HttpUrl.m7538a(str, 1 + a5, b, "", true, false, false, false, null);
            }
            return C1938a.SUCCESS;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Regions count limit reached
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:89)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
            	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:694)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
            	at java.util.ArrayList.forEach(ArrayList.java:1249)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at java.util.ArrayList.forEach(ArrayList.java:1249)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:30)
            	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
            	at java.util.ArrayList.forEach(ArrayList.java:1249)
            	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
            	at jadx.core.ProcessClass.process(ProcessClass.java:35)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0044 A[SYNTHETIC] */
        /* renamed from: a */
        private void m7566a(java.lang.String r11, int r12, int r13) {
            /*
            r10 = this;
            if (r12 != r13) goto L_0x0003
            return
        L_0x0003:
            char r0 = r11.charAt(r12)
            r1 = 47
            java.lang.String r2 = ""
            r3 = 1
            if (r0 == r1) goto L_0x001e
            r1 = 92
            if (r0 != r1) goto L_0x0013
            goto L_0x001e
        L_0x0013:
            java.util.List<java.lang.String> r0 = r10.f5976f
            int r1 = r0.size()
            int r1 = r1 - r3
            r0.set(r1, r2)
            goto L_0x0029
        L_0x001e:
            java.util.List<java.lang.String> r0 = r10.f5976f
            r0.clear()
            java.util.List<java.lang.String> r0 = r10.f5976f
            r0.add(r2)
            goto L_0x0041
        L_0x0029:
            r6 = r12
            if (r6 >= r13) goto L_0x0044
            java.lang.String r12 = "/\\"
            int r12 = com.bytedance.sdk.p145a.p147b.p148a.C1876c.m6949a(r11, r6, r13, r12)
            if (r12 >= r13) goto L_0x0036
            r0 = 1
            goto L_0x0037
        L_0x0036:
            r0 = 0
        L_0x0037:
            r9 = 1
            r4 = r10
            r5 = r11
            r7 = r12
            r8 = r0
            r4.m7567a(r5, r6, r7, r8, r9)
            if (r0 == 0) goto L_0x0029
        L_0x0041:
            int r12 = r12 + 1
            goto L_0x0029
        L_0x0044:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.p145a.p147b.HttpUrl.C1937a.m7566a(java.lang.String, int, int):void");
        }

        /* renamed from: a */
        private void m7567a(String str, int i, int i2, boolean z, boolean z2) {
            String a = HttpUrl.m7538a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (!m7574f(a)) {
                if (m7575g(a)) {
                    m7571d();
                    return;
                }
                List<String> list = this.f5976f;
                if (((String) list.get(list.size() - 1)).isEmpty()) {
                    List<String> list2 = this.f5976f;
                    list2.set(list2.size() - 1, a);
                } else {
                    this.f5976f.add(a);
                }
                if (z) {
                    this.f5976f.add("");
                }
            }
        }

        /* renamed from: f */
        private boolean m7574f(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        /* renamed from: g */
        private boolean m7575g(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        /* renamed from: d */
        private void m7571d() {
            List<String> list = this.f5976f;
            String str = "";
            if (!((String) list.remove(list.size() - 1)).isEmpty() || this.f5976f.isEmpty()) {
                this.f5976f.add(str);
                return;
            }
            List<String> list2 = this.f5976f;
            list2.set(list2.size() - 1, str);
        }

        /* renamed from: b */
        private static int m7568b(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char charAt2 = str.charAt(i);
                    if ((charAt2 < 'a' || charAt2 > 'z') && ((charAt2 < 'A' || charAt2 > 'Z') && !((charAt2 >= '0' && charAt2 <= '9') || charAt2 == '+' || charAt2 == '-'))) {
                        if (charAt2 != '.') {
                            if (charAt2 == ':') {
                                return i;
                            }
                        }
                    }
                }
            }
            return -1;
        }

        /* renamed from: c */
        private static int m7569c(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        /* renamed from: d */
        private static int m7570d(String str, int i, int i2) {
            int i3;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt == '[') {
                    do {
                        i = i3 + 1;
                        if (i >= i2) {
                            break;
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        /* renamed from: e */
        private static String m7572e(String str, int i, int i2) {
            return C1876c.m6954a(HttpUrl.m7539a(str, i, i2, false));
        }

        /* renamed from: f */
        private static int m7573f(String str, int i, int i2) {
            try {
                int parseInt = Integer.parseInt(HttpUrl.m7538a(str, i, i2, "", false, false, false, true, null));
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
    }

    HttpUrl(C1937a aVar) {
        this.f5962a = aVar.f5971a;
        this.f5965e = m7541a(aVar.f5972b, false);
        this.f5966f = m7541a(aVar.f5973c, false);
        this.f5963b = aVar.f5974d;
        this.f5964c = aVar.mo14103a();
        this.f5967g = m7542a(aVar.f5976f, false);
        String str = null;
        this.f5968h = aVar.f5977g != null ? m7542a(aVar.f5977g, true) : null;
        if (aVar.f5978h != null) {
            str = m7541a(aVar.f5978h, false);
        }
        this.f5969i = str;
        this.f5970j = aVar.toString();
    }

    /* renamed from: a */
    public URI mo14084a() {
        String aVar = mo14101n().mo14107b().toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e) {
            try {
                return URI.create(aVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: b */
    public String mo14085b() {
        return this.f5962a;
    }

    /* renamed from: c */
    public boolean mo14087c() {
        return this.f5962a.equals("https");
    }

    /* renamed from: d */
    public String mo14089d() {
        if (this.f5965e.isEmpty()) {
            return "";
        }
        int length = this.f5962a.length() + 3;
        String str = this.f5970j;
        return this.f5970j.substring(length, C1876c.m6949a(str, length, str.length(), ":@"));
    }

    /* renamed from: e */
    public String mo14090e() {
        if (this.f5966f.isEmpty()) {
            return "";
        }
        return this.f5970j.substring(this.f5970j.indexOf(58, this.f5962a.length() + 3) + 1, this.f5970j.indexOf(64));
    }

    /* renamed from: f */
    public String mo14092f() {
        return this.f5963b;
    }

    /* renamed from: g */
    public int mo14093g() {
        return this.f5964c;
    }

    /* renamed from: a */
    public static int m7536a(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    /* renamed from: h */
    public String mo14094h() {
        int indexOf = this.f5970j.indexOf(47, this.f5962a.length() + 3);
        String str = this.f5970j;
        return this.f5970j.substring(indexOf, C1876c.m6949a(str, indexOf, str.length(), "?#"));
    }

    /* renamed from: a */
    static void m7545a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append((String) list.get(i));
        }
    }

    /* renamed from: i */
    public List<String> mo14096i() {
        int indexOf = this.f5970j.indexOf(47, this.f5962a.length() + 3);
        String str = this.f5970j;
        int a = C1876c.m6949a(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < a) {
            int i = indexOf + 1;
            int a2 = C1876c.m6948a(this.f5970j, i, a, '/');
            arrayList.add(this.f5970j.substring(i, a2));
            indexOf = a2;
        }
        return arrayList;
    }

    /* renamed from: j */
    public String mo14097j() {
        if (this.f5968h == null) {
            return null;
        }
        int indexOf = this.f5970j.indexOf(63) + 1;
        String str = this.f5970j;
        return this.f5970j.substring(indexOf, C1876c.m6948a(str, indexOf, str.length(), '#'));
    }

    /* renamed from: b */
    static void m7548b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = (String) list.get(i);
            String str2 = (String) list.get(i + 1);
            if (i > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    /* renamed from: b */
    static List<String> m7547b(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    /* renamed from: k */
    public String mo14098k() {
        if (this.f5968h == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        m7548b(sb, this.f5968h);
        return sb.toString();
    }

    /* renamed from: l */
    public String mo14099l() {
        if (this.f5969i == null) {
            return null;
        }
        return this.f5970j.substring(this.f5970j.indexOf(35) + 1);
    }

    /* renamed from: m */
    public String mo14100m() {
        String str = "";
        return mo14088d("/...").mo14108b(str).mo14109c(str).mo14110c().toString();
    }

    /* renamed from: c */
    public HttpUrl mo14086c(String str) {
        C1937a d = mo14088d(str);
        if (d != null) {
            return d.mo14110c();
        }
        return null;
    }

    /* renamed from: n */
    public C1937a mo14101n() {
        C1937a aVar = new C1937a();
        aVar.f5971a = this.f5962a;
        aVar.f5972b = mo14089d();
        aVar.f5973c = mo14090e();
        aVar.f5974d = this.f5963b;
        aVar.f5975e = this.f5964c != m7536a(this.f5962a) ? this.f5964c : -1;
        aVar.f5976f.clear();
        aVar.f5976f.addAll(mo14096i());
        aVar.mo14112e(mo14097j());
        aVar.f5978h = mo14099l();
        return aVar;
    }

    /* renamed from: d */
    public C1937a mo14088d(String str) {
        C1937a aVar = new C1937a();
        if (aVar.mo14104a(this, str) == C1938a.SUCCESS) {
            return aVar;
        }
        return null;
    }

    /* renamed from: e */
    public static HttpUrl m7549e(String str) {
        C1937a aVar = new C1937a();
        if (aVar.mo14104a(null, str) == C1938a.SUCCESS) {
            return aVar.mo14110c();
        }
        return null;
    }

    /* renamed from: a */
    public static HttpUrl m7537a(URL url) {
        return m7549e(url.toString());
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && ((HttpUrl) obj).f5970j.equals(this.f5970j);
    }

    public int hashCode() {
        return this.f5970j.hashCode();
    }

    public String toString() {
        return this.f5970j;
    }

    /* renamed from: a */
    static String m7541a(String str, boolean z) {
        return m7539a(str, 0, str.length(), z);
    }

    /* renamed from: a */
    private List<String> m7542a(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = (String) list.get(i);
            arrayList.add(str != null ? m7541a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: a */
    static String m7539a(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                Buffer cVar = new Buffer();
                cVar.mo13524a(str, i, i3);
                m7544a(cVar, str, i3, i2, z);
                return cVar.mo13570o();
            }
        }
        return str.substring(i, i2);
    }

    /* renamed from: a */
    static void m7544a(Buffer cVar, String str, int i, int i2, boolean z) {
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt == 37) {
                int i3 = i + 2;
                if (i3 < i2) {
                    int a = C1876c.m6946a(str.charAt(i + 1));
                    int a2 = C1876c.m6946a(str.charAt(i3));
                    if (!(a == -1 || a2 == -1)) {
                        cVar.mo13559i((a << 4) + a2);
                        i = i3;
                        i += Character.charCount(codePointAt);
                    }
                    cVar.mo13520a(codePointAt);
                    i += Character.charCount(codePointAt);
                }
            }
            if (codePointAt == 43 && z) {
                cVar.mo13559i(32);
                i += Character.charCount(codePointAt);
            }
            cVar.mo13520a(codePointAt);
            i += Character.charCount(codePointAt);
        }
    }

    /* renamed from: a */
    static boolean m7546a(String str, int i, int i2) {
        int i3 = i + 2;
        if (i3 >= i2 || str.charAt(i) != '%' || C1876c.m6946a(str.charAt(i + 1)) == -1 || C1876c.m6946a(str.charAt(i3)) == -1) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    static String m7538a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        String str3 = str;
        int i3 = i2;
        int i4 = i;
        while (i4 < i3) {
            int codePointAt = str.codePointAt(i4);
            if (codePointAt < 32 || codePointAt == 127 || (codePointAt >= 128 && z4)) {
                String str4 = str2;
            } else {
                String str5 = str2;
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || m7546a(str, i4, i2)))) && (codePointAt != 43 || !z3))) {
                    i4 += Character.charCount(codePointAt);
                }
            }
            Buffer cVar = new Buffer();
            int i5 = i;
            cVar.mo13524a(str, i, i4);
            m7543a(cVar, str, i4, i2, str2, z, z2, z3, z4, charset);
            return cVar.mo13570o();
        }
        int i6 = i;
        return str.substring(i, i2);
    }

    /* renamed from: a */
    static void m7543a(Buffer cVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        Buffer cVar2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt == 43 && z3) {
                    cVar.mo13534b(z ? Marker.ANY_NON_NULL_MARKER : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z || (z2 && !m7546a(str, i, i2)))))) {
                    if (cVar2 == null) {
                        cVar2 = new Buffer();
                    }
                    if (charset == null || charset.equals(C1876c.f5402e)) {
                        cVar2.mo13520a(codePointAt);
                    } else {
                        cVar2.mo13525a(str, i, Character.charCount(codePointAt) + i, charset);
                    }
                    while (!cVar2.mo13546e()) {
                        byte h = cVar2.mo13554h() & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                        cVar.mo13559i(37);
                        cVar.mo13559i((int) f5961d[(h >> 4) & 15]);
                        cVar.mo13559i((int) f5961d[h & 15]);
                    }
                } else {
                    cVar.mo13520a(codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    /* renamed from: a */
    static String m7540a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return m7538a(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}
