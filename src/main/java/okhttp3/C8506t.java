package okhttp3;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.C8417c;
import okio.C8525c;
import org.slf4j.Marker;

/* compiled from: HttpUrl */
/* renamed from: okhttp3.t */
public final class C8506t {
    /* renamed from: d */
    private static final char[] f28887d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    /* renamed from: a */
    final String f28888a;
    /* renamed from: b */
    final String f28889b;
    /* renamed from: c */
    final int f28890c;
    /* renamed from: e */
    private final String f28891e;
    /* renamed from: f */
    private final String f28892f;
    /* renamed from: g */
    private final List<String> f28893g;
    @Nullable
    /* renamed from: h */
    private final List<String> f28894h;
    @Nullable
    /* renamed from: i */
    private final String f28895i;
    /* renamed from: j */
    private final String f28896j;

    /* compiled from: HttpUrl */
    /* renamed from: okhttp3.t$a */
    public static final class C8507a {
        @Nullable
        /* renamed from: a */
        String f28897a;
        /* renamed from: b */
        String f28898b;
        /* renamed from: c */
        String f28899c;
        @Nullable
        /* renamed from: d */
        String f28900d;
        /* renamed from: e */
        int f28901e = -1;
        /* renamed from: f */
        final List<String> f28902f = new ArrayList();
        @Nullable
        /* renamed from: g */
        List<String> f28903g;
        @Nullable
        /* renamed from: h */
        String f28904h;

        public C8507a() {
            String str = "";
            this.f28898b = str;
            this.f28899c = str;
            this.f28902f.add(str);
        }

        /* renamed from: a */
        public C8507a mo40572a(String str) {
            if (str != null) {
                String str2 = "http";
                if (str.equalsIgnoreCase(str2)) {
                    this.f28897a = str2;
                } else {
                    String str3 = "https";
                    if (str.equalsIgnoreCase(str3)) {
                        this.f28897a = str3;
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
        public C8507a mo40577b(String str) {
            if (str != null) {
                this.f28898b = C8506t.m36535a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("username == null");
        }

        /* renamed from: c */
        public C8507a mo40579c(String str) {
            if (str != null) {
                this.f28899c = C8506t.m36535a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("password == null");
        }

        /* renamed from: d */
        public C8507a mo40581d(String str) {
            if (str != null) {
                String e = m36572e(str, 0, str.length());
                if (e != null) {
                    this.f28900d = e;
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
        public C8507a mo40571a(int i) {
            if (i <= 0 || i > 65535) {
                StringBuilder sb = new StringBuilder();
                sb.append("unexpected port: ");
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
            }
            this.f28901e = i;
            return this;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public int mo40570a() {
            int i = this.f28901e;
            return i != -1 ? i : C8506t.m36532a(this.f28897a);
        }

        /* renamed from: e */
        public C8507a mo40582e(String str) {
            if (str != null) {
                m36567a(str, 0, str.length(), false, true);
                return this;
            }
            throw new NullPointerException("encodedPathSegment == null");
        }

        /* renamed from: b */
        public C8507a mo40576b(int i) {
            this.f28902f.remove(i);
            if (this.f28902f.isEmpty()) {
                this.f28902f.add("");
            }
            return this;
        }

        /* renamed from: f */
        public C8507a mo40583f(String str) {
            if (str == null) {
                throw new NullPointerException("encodedPath == null");
            } else if (str.startsWith("/")) {
                m36566a(str, 0, str.length());
                return this;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("unexpected encodedPath: ");
                sb.append(str);
                throw new IllegalArgumentException(sb.toString());
            }
        }

        /* renamed from: g */
        public C8507a mo40584g(@Nullable String str) {
            List<String> list;
            if (str != null) {
                list = C8506t.m36543b(C8506t.m36535a(str, " \"'<>#", true, false, true, true));
            } else {
                list = null;
            }
            this.f28903g = list;
            return this;
        }

        /* renamed from: a */
        public C8507a mo40573a(String str, @Nullable String str2) {
            String str3;
            if (str != null) {
                if (this.f28903g == null) {
                    this.f28903g = new ArrayList();
                }
                this.f28903g.add(C8506t.m36535a(str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
                List<String> list = this.f28903g;
                if (str2 != null) {
                    str3 = C8506t.m36535a(str2, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true);
                } else {
                    str3 = null;
                }
                list.add(str3);
                return this;
            }
            throw new NullPointerException("name == null");
        }

        /* renamed from: b */
        public C8507a mo40578b(String str, @Nullable String str2) {
            String str3;
            if (str != null) {
                if (this.f28903g == null) {
                    this.f28903g = new ArrayList();
                }
                this.f28903g.add(C8506t.m36535a(str, " \"'<>#&=", true, false, true, true));
                List<String> list = this.f28903g;
                if (str2 != null) {
                    str3 = C8506t.m36535a(str2, " \"'<>#&=", true, false, true, true);
                } else {
                    str3 = null;
                }
                list.add(str3);
                return this;
            }
            throw new NullPointerException("encodedName == null");
        }

        /* renamed from: h */
        public C8507a mo40585h(@Nullable String str) {
            String str2;
            if (str != null) {
                str2 = C8506t.m36535a(str, "", false, false, false, false);
            } else {
                str2 = null;
            }
            this.f28904h = str2;
            return this;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public C8507a mo40575b() {
            int size = this.f28902f.size();
            for (int i = 0; i < size; i++) {
                this.f28902f.set(i, C8506t.m36535a((String) this.f28902f.get(i), "[]", true, true, false, true));
            }
            List<String> list = this.f28903g;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) this.f28903g.get(i2);
                    if (str != null) {
                        this.f28903g.set(i2, C8506t.m36535a(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.f28904h;
            if (str2 != null) {
                this.f28904h = C8506t.m36535a(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        /* renamed from: c */
        public C8506t mo40580c() {
            if (this.f28897a == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.f28900d != null) {
                return new C8506t(this);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f28897a);
            sb.append("://");
            if (!this.f28898b.isEmpty() || !this.f28899c.isEmpty()) {
                sb.append(this.f28898b);
                if (!this.f28899c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f28899c);
                }
                sb.append('@');
            }
            if (this.f28900d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.f28900d);
                sb.append(']');
            } else {
                sb.append(this.f28900d);
            }
            int a = mo40570a();
            if (a != C8506t.m36532a(this.f28897a)) {
                sb.append(':');
                sb.append(a);
            }
            C8506t.m36539a(sb, this.f28902f);
            if (this.f28903g != null) {
                sb.append('?');
                C8506t.m36544b(sb, this.f28903g);
            }
            if (this.f28904h != null) {
                sb.append('#');
                sb.append(this.f28904h);
            }
            return sb.toString();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C8507a mo40574a(@Nullable C8506t tVar, String str) {
            int a;
            int i;
            C8506t tVar2 = tVar;
            String str2 = str;
            int a2 = C8417c.m36023a(str2, 0, str.length());
            int b = C8417c.m36050b(str2, a2, str.length());
            int b2 = m36568b(str2, a2, b);
            if (b2 != -1) {
                if (str.regionMatches(true, a2, "https:", 0, 6)) {
                    this.f28897a = "https";
                    a2 += 6;
                } else {
                    if (str.regionMatches(true, a2, "http:", 0, 5)) {
                        this.f28897a = "http";
                        a2 += 5;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected URL scheme 'http' or 'https' but was '");
                        sb.append(str2.substring(0, b2));
                        sb.append("'");
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
            } else if (tVar2 != null) {
                this.f28897a = tVar2.f28888a;
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int c = m36569c(str2, a2, b);
            char c2 = '?';
            char c3 = '#';
            if (c >= 2 || tVar2 == null || !tVar2.f28888a.equals(this.f28897a)) {
                int i2 = a2 + c;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    a = C8417c.m36025a(str2, i2, b, "@/\\?#");
                    char charAt = a != b ? str2.charAt(a) : 65535;
                    if (charAt == 65535 || charAt == c3 || charAt == '/' || charAt == '\\' || charAt == c2) {
                        int i3 = a;
                        int d = m36570d(str2, i2, i3);
                        int i4 = d + 1;
                    } else {
                        if (charAt == '@') {
                            String str3 = "%40";
                            if (!z) {
                                int a3 = C8417c.m36024a(str2, i2, a, ':');
                                int i5 = a3;
                                String str4 = str3;
                                i = a;
                                String a4 = C8506t.m36533a(str, i2, a3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                if (z2) {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(this.f28898b);
                                    sb2.append(str4);
                                    sb2.append(a4);
                                    a4 = sb2.toString();
                                }
                                this.f28898b = a4;
                                if (i5 != i) {
                                    this.f28899c = C8506t.m36533a(str, i5 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                    z = true;
                                }
                                z2 = true;
                            } else {
                                String str5 = str3;
                                i = a;
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(this.f28899c);
                                sb3.append(str5);
                                sb3.append(C8506t.m36533a(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null));
                                this.f28899c = sb3.toString();
                            }
                            i2 = i + 1;
                        }
                        c2 = '?';
                        c3 = '#';
                    }
                }
                int i32 = a;
                int d2 = m36570d(str2, i2, i32);
                int i42 = d2 + 1;
                if (i42 < i32) {
                    this.f28900d = m36572e(str2, i2, d2);
                    this.f28901e = m36573f(str2, i42, i32);
                    if (this.f28901e == -1) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Invalid URL port: \"");
                        sb4.append(str2.substring(i42, i32));
                        sb4.append('\"');
                        throw new IllegalArgumentException(sb4.toString());
                    }
                } else {
                    this.f28900d = m36572e(str2, i2, d2);
                    this.f28901e = C8506t.m36532a(this.f28897a);
                }
                if (this.f28900d != null) {
                    a2 = i32;
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Invalid URL host: \"");
                    sb5.append(str2.substring(i2, d2));
                    sb5.append('\"');
                    throw new IllegalArgumentException(sb5.toString());
                }
            } else {
                this.f28898b = tVar.mo40552d();
                this.f28899c = tVar.mo40554e();
                this.f28900d = tVar2.f28889b;
                this.f28901e = tVar2.f28890c;
                this.f28902f.clear();
                this.f28902f.addAll(tVar.mo40561j());
                if (a2 == b || str2.charAt(a2) == '#') {
                    mo40584g(tVar.mo40563l());
                }
            }
            int a5 = C8417c.m36025a(str2, a2, b, "?#");
            m36566a(str2, a2, a5);
            if (a5 < b && str2.charAt(a5) == '?') {
                int a6 = C8417c.m36024a(str2, a5, b, '#');
                this.f28903g = C8506t.m36543b(C8506t.m36533a(str, a5 + 1, a6, " \"'<>#", true, false, true, true, null));
                a5 = a6;
            }
            if (a5 < b && str2.charAt(a5) == '#') {
                this.f28904h = C8506t.m36533a(str, 1 + a5, b, "", true, false, false, false, null);
            }
            return this;
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
        private void m36566a(java.lang.String r11, int r12, int r13) {
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
            java.util.List<java.lang.String> r0 = r10.f28902f
            int r1 = r0.size()
            int r1 = r1 - r3
            r0.set(r1, r2)
            goto L_0x0029
        L_0x001e:
            java.util.List<java.lang.String> r0 = r10.f28902f
            r0.clear()
            java.util.List<java.lang.String> r0 = r10.f28902f
            r0.add(r2)
            goto L_0x0041
        L_0x0029:
            r6 = r12
            if (r6 >= r13) goto L_0x0044
            java.lang.String r12 = "/\\"
            int r12 = okhttp3.internal.C8417c.m36025a(r11, r6, r13, r12)
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
            r4.m36567a(r5, r6, r7, r8, r9)
            if (r0 == 0) goto L_0x0029
        L_0x0041:
            int r12 = r12 + 1
            goto L_0x0029
        L_0x0044:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.C8506t.C8507a.m36566a(java.lang.String, int, int):void");
        }

        /* renamed from: a */
        private void m36567a(String str, int i, int i2, boolean z, boolean z2) {
            String a = C8506t.m36533a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (!m36574i(a)) {
                if (m36575j(a)) {
                    m36571d();
                    return;
                }
                List<String> list = this.f28902f;
                if (((String) list.get(list.size() - 1)).isEmpty()) {
                    List<String> list2 = this.f28902f;
                    list2.set(list2.size() - 1, a);
                } else {
                    this.f28902f.add(a);
                }
                if (z) {
                    this.f28902f.add("");
                }
            }
        }

        /* renamed from: i */
        private boolean m36574i(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        /* renamed from: j */
        private boolean m36575j(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        /* renamed from: d */
        private void m36571d() {
            List<String> list = this.f28902f;
            String str = "";
            if (!((String) list.remove(list.size() - 1)).isEmpty() || this.f28902f.isEmpty()) {
                this.f28902f.add(str);
                return;
            }
            List<String> list2 = this.f28902f;
            list2.set(list2.size() - 1, str);
        }

        /* renamed from: b */
        private static int m36568b(String str, int i, int i2) {
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
        private static int m36569c(String str, int i, int i2) {
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
        private static int m36570d(String str, int i, int i2) {
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
        private static String m36572e(String str, int i, int i2) {
            return C8417c.m36029a(C8506t.m36534a(str, i, i2, false));
        }

        /* renamed from: f */
        private static int m36573f(String str, int i, int i2) {
            try {
                int parseInt = Integer.parseInt(C8506t.m36533a(str, i, i2, "", false, false, false, true, null));
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
    }

    C8506t(C8507a aVar) {
        this.f28888a = aVar.f28897a;
        this.f28891e = m36537a(aVar.f28898b, false);
        this.f28892f = m36537a(aVar.f28899c, false);
        this.f28889b = aVar.f28900d;
        this.f28890c = aVar.mo40570a();
        this.f28893g = m36538a(aVar.f28902f, false);
        String str = null;
        this.f28894h = aVar.f28903g != null ? m36538a(aVar.f28903g, true) : null;
        if (aVar.f28904h != null) {
            str = m36537a(aVar.f28904h, false);
        }
        this.f28895i = str;
        this.f28896j = aVar.toString();
    }

    /* renamed from: a */
    public URI mo40548a() {
        String aVar = mo40568q().mo40575b().toString();
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
    public String mo40549b() {
        return this.f28888a;
    }

    /* renamed from: c */
    public boolean mo40551c() {
        return this.f28888a.equals("https");
    }

    /* renamed from: d */
    public String mo40552d() {
        if (this.f28891e.isEmpty()) {
            return "";
        }
        int length = this.f28888a.length() + 3;
        String str = this.f28896j;
        return this.f28896j.substring(length, C8417c.m36025a(str, length, str.length(), ":@"));
    }

    /* renamed from: e */
    public String mo40554e() {
        if (this.f28892f.isEmpty()) {
            return "";
        }
        return this.f28896j.substring(this.f28896j.indexOf(58, this.f28888a.length() + 3) + 1, this.f28896j.indexOf(64));
    }

    /* renamed from: f */
    public String mo40556f() {
        return this.f28889b;
    }

    /* renamed from: g */
    public int mo40557g() {
        return this.f28890c;
    }

    /* renamed from: a */
    public static int m36532a(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    /* renamed from: h */
    public int mo40558h() {
        return this.f28893g.size();
    }

    /* renamed from: i */
    public String mo40560i() {
        int indexOf = this.f28896j.indexOf(47, this.f28888a.length() + 3);
        String str = this.f28896j;
        return this.f28896j.substring(indexOf, C8417c.m36025a(str, indexOf, str.length(), "?#"));
    }

    /* renamed from: a */
    static void m36539a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append((String) list.get(i));
        }
    }

    /* renamed from: j */
    public List<String> mo40561j() {
        int indexOf = this.f28896j.indexOf(47, this.f28888a.length() + 3);
        String str = this.f28896j;
        int a = C8417c.m36025a(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < a) {
            int i = indexOf + 1;
            int a2 = C8417c.m36024a(this.f28896j, i, a, '/');
            arrayList.add(this.f28896j.substring(i, a2));
            indexOf = a2;
        }
        return arrayList;
    }

    /* renamed from: k */
    public List<String> mo40562k() {
        return this.f28893g;
    }

    @Nullable
    /* renamed from: l */
    public String mo40563l() {
        if (this.f28894h == null) {
            return null;
        }
        int indexOf = this.f28896j.indexOf(63) + 1;
        String str = this.f28896j;
        return this.f28896j.substring(indexOf, C8417c.m36024a(str, indexOf, str.length(), '#'));
    }

    /* renamed from: b */
    static void m36544b(StringBuilder sb, List<String> list) {
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
    static List<String> m36543b(String str) {
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

    @Nullable
    /* renamed from: m */
    public String mo40564m() {
        if (this.f28894h == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        m36544b(sb, this.f28894h);
        return sb.toString();
    }

    @Nullable
    /* renamed from: n */
    public String mo40565n() {
        if (this.f28895i == null) {
            return null;
        }
        return this.f28896j.substring(this.f28896j.indexOf(35) + 1);
    }

    @Nullable
    /* renamed from: o */
    public String mo40566o() {
        return this.f28895i;
    }

    /* renamed from: p */
    public String mo40567p() {
        String str = "";
        return mo40553d("/...").mo40577b(str).mo40579c(str).mo40580c().toString();
    }

    @Nullable
    /* renamed from: c */
    public C8506t mo40550c(String str) {
        C8507a d = mo40553d(str);
        if (d != null) {
            return d.mo40580c();
        }
        return null;
    }

    /* renamed from: q */
    public C8507a mo40568q() {
        C8507a aVar = new C8507a();
        aVar.f28897a = this.f28888a;
        aVar.f28898b = mo40552d();
        aVar.f28899c = mo40554e();
        aVar.f28900d = this.f28889b;
        aVar.f28901e = this.f28890c != m36532a(this.f28888a) ? this.f28890c : -1;
        aVar.f28902f.clear();
        aVar.f28902f.addAll(mo40561j());
        aVar.mo40584g(mo40563l());
        aVar.f28904h = mo40565n();
        return aVar;
    }

    @Nullable
    /* renamed from: d */
    public C8507a mo40553d(String str) {
        try {
            return new C8507a().mo40574a(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @Nullable
    /* renamed from: e */
    public static C8506t m36545e(String str) {
        try {
            return m36546f(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* renamed from: f */
    public static C8506t m36546f(String str) {
        return new C8507a().mo40574a((C8506t) null, str).mo40580c();
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof C8506t) && ((C8506t) obj).f28896j.equals(this.f28896j);
    }

    public int hashCode() {
        return this.f28896j.hashCode();
    }

    public String toString() {
        return this.f28896j;
    }

    /* renamed from: a */
    static String m36537a(String str, boolean z) {
        return m36534a(str, 0, str.length(), z);
    }

    /* renamed from: a */
    private List<String> m36538a(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = (String) list.get(i);
            arrayList.add(str != null ? m36537a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: a */
    static String m36534a(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                C8525c cVar = new C8525c();
                cVar.mo40724a(str, i, i3);
                m36541a(cVar, str, i3, i2, z);
                return cVar.mo40777q();
            }
        }
        return str.substring(i, i2);
    }

    /* renamed from: a */
    static void m36541a(C8525c cVar, String str, int i, int i2, boolean z) {
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt == 37) {
                int i3 = i + 2;
                if (i3 < i2) {
                    int a = C8417c.m36022a(str.charAt(i + 1));
                    int a2 = C8417c.m36022a(str.charAt(i3));
                    if (!(a == -1 || a2 == -1)) {
                        cVar.mo40765i((a << 4) + a2);
                        i = i3;
                        i += Character.charCount(codePointAt);
                    }
                    cVar.mo40722a(codePointAt);
                    i += Character.charCount(codePointAt);
                }
            }
            if (codePointAt == 43 && z) {
                cVar.mo40765i(32);
                i += Character.charCount(codePointAt);
            }
            cVar.mo40722a(codePointAt);
            i += Character.charCount(codePointAt);
        }
    }

    /* renamed from: a */
    static boolean m36542a(String str, int i, int i2) {
        int i3 = i + 2;
        if (i3 >= i2 || str.charAt(i) != '%' || C8417c.m36022a(str.charAt(i + 1)) == -1 || C8417c.m36022a(str.charAt(i3)) == -1) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    static String m36533a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        String str3 = str;
        int i3 = i2;
        int i4 = i;
        while (i4 < i3) {
            int codePointAt = str.codePointAt(i4);
            if (codePointAt < 32 || codePointAt == 127 || (codePointAt >= 128 && z4)) {
                String str4 = str2;
            } else {
                String str5 = str2;
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || m36542a(str, i4, i2)))) && (codePointAt != 43 || !z3))) {
                    i4 += Character.charCount(codePointAt);
                }
            }
            C8525c cVar = new C8525c();
            int i5 = i;
            cVar.mo40724a(str, i, i4);
            m36540a(cVar, str, i4, i2, str2, z, z2, z3, z4, charset);
            return cVar.mo40777q();
        }
        int i6 = i;
        return str.substring(i, i2);
    }

    /* renamed from: a */
    static void m36540a(C8525c cVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        C8525c cVar2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt == 43 && z3) {
                    cVar.mo40738b(z ? Marker.ANY_NON_NULL_MARKER : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z || (z2 && !m36542a(str, i, i2)))))) {
                    if (cVar2 == null) {
                        cVar2 = new C8525c();
                    }
                    if (charset == null || charset.equals(C8417c.f28532e)) {
                        cVar2.mo40722a(codePointAt);
                    } else {
                        cVar2.mo40725a(str, i, Character.charCount(codePointAt) + i, charset);
                    }
                    while (!cVar2.mo40755f()) {
                        byte i3 = cVar2.mo40763i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                        cVar.mo40765i(37);
                        cVar.mo40765i((int) f28887d[(i3 >> 4) & 15]);
                        cVar.mo40765i((int) f28887d[i3 & 15]);
                    }
                } else {
                    cVar.mo40722a(codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    /* renamed from: a */
    static String m36536a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        return m36533a(str, 0, str.length(), str2, z, z2, z3, z4, charset);
    }

    /* renamed from: a */
    static String m36535a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return m36533a(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}
