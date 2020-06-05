package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* renamed from: com.alibaba.fastjson.parser.c */
public abstract class JSONLexerBase implements JSONLexer, Closeable {
    /* renamed from: p */
    protected static final char[] f2770p;
    /* renamed from: q */
    protected static final int[] f2771q = new int[103];
    /* renamed from: r */
    private static final ThreadLocal<char[]> f2772r = new ThreadLocal<>();
    /* renamed from: a */
    protected int f2773a;
    /* renamed from: b */
    protected int f2774b;
    /* renamed from: c */
    protected int f2775c;
    /* renamed from: d */
    protected char f2776d;
    /* renamed from: e */
    protected int f2777e;
    /* renamed from: f */
    protected int f2778f;
    /* renamed from: g */
    protected char[] f2779g;
    /* renamed from: h */
    protected int f2780h;
    /* renamed from: i */
    protected int f2781i;
    /* renamed from: j */
    protected boolean f2782j;
    /* renamed from: k */
    protected Calendar f2783k = null;
    /* renamed from: l */
    protected TimeZone f2784l = JSON.defaultTimeZone;
    /* renamed from: m */
    protected Locale f2785m = JSON.defaultLocale;
    /* renamed from: n */
    public int f2786n = 0;
    /* renamed from: o */
    protected String f2787o = null;

    /* renamed from: j */
    public static boolean m2776j(char c) {
        return c <= ' ' && (c == ' ' || c == 10 || c == 13 || c == 9 || c == 12 || c == 8);
    }

    /* renamed from: C */
    public abstract boolean mo11249C();

    /* renamed from: a */
    public abstract int mo11257a(char c, int i);

    /* renamed from: a */
    public abstract String mo11258a(int i, int i2);

    /* renamed from: a */
    public abstract String mo11259a(int i, int i2, int i3, SymbolTable iVar);

    /* renamed from: a */
    public abstract void mo11260a(int i, int i2, char[] cArr);

    /* renamed from: a */
    public abstract void mo11261a(int i, char[] cArr, int i2, int i3);

    /* renamed from: b */
    public abstract char[] mo11266b(int i, int i2);

    /* renamed from: d */
    public abstract char mo11268d(int i);

    /* renamed from: f */
    public abstract char mo11225f();

    /* renamed from: k */
    public abstract BigDecimal mo11232k();

    /* renamed from: l */
    public abstract String mo11233l();

    /* renamed from: o */
    public abstract boolean mo11282o(char[] cArr);

    /* renamed from: s */
    public abstract String mo11240s();

    /* renamed from: x */
    public String mo11245x() {
        return "";
    }

    /* access modifiers changed from: protected|varargs */
    /* renamed from: a */
    public void mo11262a(String str, Object... objArr) {
        this.f2773a = 1;
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("\"");
        sb.append(JSON.DEFAULT_TYPE_KEY);
        sb.append("\":\"");
        f2770p = sb.toString().toCharArray();
        for (int i = 48; i <= 57; i++) {
            f2771q[i] = i - 48;
        }
        for (int i2 = 97; i2 <= 102; i2++) {
            f2771q[i2] = (i2 - 97) + 10;
        }
        for (int i3 = 65; i3 <= 70; i3++) {
            f2771q[i3] = (i3 - 65) + 10;
        }
    }

    public JSONLexerBase(int i) {
        this.f2775c = i;
        if ((i & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.f2787o = "";
        }
        this.f2779g = (char[]) f2772r.get();
        if (this.f2779g == null) {
            this.f2779g = new char[512];
        }
    }

    /* renamed from: d */
    public final void mo11222d() {
        this.f2780h = 0;
        while (true) {
            this.f2774b = this.f2777e;
            char c = this.f2776d;
            if (c == '/') {
                mo11250D();
            } else if (c == '\"') {
                mo11234m();
                return;
            } else if (c == ',') {
                mo11225f();
                this.f2773a = 16;
                return;
            } else if (c < '0' || c > '9') {
                char c2 = this.f2776d;
                if (c2 != '-') {
                    switch (c2) {
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 13:
                        case ' ':
                            mo11225f();
                            break;
                        case '\'':
                            if (mo11212a(Feature.AllowSingleQuotes)) {
                                mo11284K();
                                return;
                            }
                            throw new JSONException("Feature.AllowSingleQuotes is false");
                        case '(':
                            mo11225f();
                            this.f2773a = 10;
                            return;
                        case ')':
                            mo11225f();
                            this.f2773a = 11;
                            return;
                        case '+':
                            mo11225f();
                            mo11229h();
                            return;
                        case '.':
                            mo11225f();
                            this.f2773a = 25;
                            return;
                        case ':':
                            mo11225f();
                            this.f2773a = 17;
                            return;
                        case ';':
                            mo11225f();
                            this.f2773a = 24;
                            return;
                        case 'N':
                        case 'S':
                        case 'T':
                        case 'u':
                            mo11255I();
                            return;
                        case '[':
                            mo11225f();
                            this.f2773a = 14;
                            return;
                        case ']':
                            mo11225f();
                            this.f2773a = 15;
                            return;
                        case 'f':
                            mo11254H();
                            return;
                        case 'n':
                            mo11253G();
                            return;
                        case 't':
                            mo11252F();
                            return;
                        case 'x':
                            mo11256J();
                            return;
                        case '{':
                            mo11225f();
                            this.f2773a = 12;
                            return;
                        case '}':
                            mo11225f();
                            this.f2773a = 13;
                            return;
                        default:
                            if (!mo11249C()) {
                                char c3 = this.f2776d;
                                if (c3 > 31 && c3 != 127) {
                                    mo11262a("illegal.char", String.valueOf(c3));
                                    mo11225f();
                                    break;
                                } else {
                                    mo11225f();
                                    break;
                                }
                            } else if (this.f2773a != 20) {
                                this.f2773a = 20;
                                int i = this.f2778f;
                                this.f2777e = i;
                                this.f2774b = i;
                                break;
                            } else {
                                throw new JSONException("EOF error");
                            }
                    }
                } else {
                    mo11229h();
                    return;
                }
            } else {
                mo11229h();
                return;
            }
        }
    }

    /* renamed from: a */
    public final void mo11211a(int i) {
        this.f2780h = 0;
        while (true) {
            if (i == 2) {
                char c = this.f2776d;
                if (c < '0' || c > '9') {
                    char c2 = this.f2776d;
                    if (c2 == '\"') {
                        this.f2774b = this.f2777e;
                        mo11234m();
                        return;
                    } else if (c2 == '[') {
                        this.f2773a = 14;
                        mo11225f();
                        return;
                    } else if (c2 == '{') {
                        this.f2773a = 12;
                        mo11225f();
                        return;
                    }
                } else {
                    this.f2774b = this.f2777e;
                    mo11229h();
                    return;
                }
            } else if (i == 4) {
                char c3 = this.f2776d;
                if (c3 == '\"') {
                    this.f2774b = this.f2777e;
                    mo11234m();
                    return;
                } else if (c3 < '0' || c3 > '9') {
                    char c4 = this.f2776d;
                    if (c4 == '[') {
                        this.f2773a = 14;
                        mo11225f();
                        return;
                    } else if (c4 == '{') {
                        this.f2773a = 12;
                        mo11225f();
                        return;
                    }
                } else {
                    this.f2774b = this.f2777e;
                    mo11229h();
                    return;
                }
            } else if (i == 12) {
                char c5 = this.f2776d;
                if (c5 == '{') {
                    this.f2773a = 12;
                    mo11225f();
                    return;
                } else if (c5 == '[') {
                    this.f2773a = 14;
                    mo11225f();
                    return;
                }
            } else if (i != 18) {
                if (i != 20) {
                    switch (i) {
                        case 14:
                            char c6 = this.f2776d;
                            if (c6 == '[') {
                                this.f2773a = 14;
                                mo11225f();
                                return;
                            } else if (c6 == '{') {
                                this.f2773a = 12;
                                mo11225f();
                                return;
                            }
                            break;
                        case 15:
                            if (this.f2776d == ']') {
                                this.f2773a = 15;
                                mo11225f();
                                return;
                            }
                            break;
                        case 16:
                            char c7 = this.f2776d;
                            if (c7 == ',') {
                                this.f2773a = 16;
                                mo11225f();
                                return;
                            } else if (c7 == '}') {
                                this.f2773a = 13;
                                mo11225f();
                                return;
                            } else if (c7 == ']') {
                                this.f2773a = 15;
                                mo11225f();
                                return;
                            } else if (c7 == 26) {
                                this.f2773a = 20;
                                return;
                            }
                            break;
                    }
                }
                if (this.f2776d == 26) {
                    this.f2773a = 20;
                    return;
                }
            } else {
                mo11283z();
                return;
            }
            char c8 = this.f2776d;
            if (c8 == ' ' || c8 == 10 || c8 == 13 || c8 == 9 || c8 == 12 || c8 == 8) {
                mo11225f();
            } else {
                mo11222d();
                return;
            }
        }
    }

    /* renamed from: z */
    public final void mo11283z() {
        while (m2776j(this.f2776d)) {
            mo11225f();
        }
        char c = this.f2776d;
        if (c == '_' || c == '$' || Character.isLetter(c)) {
            mo11255I();
        } else {
            mo11222d();
        }
    }

    /* renamed from: o */
    public final void mo11236o() {
        mo11274h(':');
    }

    /* renamed from: h */
    public final void mo11274h(char c) {
        this.f2780h = 0;
        while (true) {
            char c2 = this.f2776d;
            if (c2 == c) {
                mo11225f();
                mo11222d();
                return;
            } else if (c2 == ' ' || c2 == 10 || c2 == 13 || c2 == 9 || c2 == 12 || c2 == 8) {
                mo11225f();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("not match ");
                sb.append(c);
                sb.append(" - ");
                sb.append(this.f2776d);
                sb.append(", info : ");
                sb.append(mo11245x());
                throw new JSONException(sb.toString());
            }
        }
    }

    /* renamed from: a */
    public final int mo11205a() {
        return this.f2773a;
    }

    /* renamed from: b */
    public final String mo11214b() {
        return JSONToken.m2903a(this.f2773a);
    }

    /* renamed from: i */
    public final int mo11230i() {
        return this.f2774b;
    }

    /* renamed from: A */
    public final String mo11247A() {
        return this.f2787o;
    }

    /* renamed from: j */
    public final Number mo11231j() throws NumberFormatException {
        long j;
        long j2;
        boolean z = false;
        if (this.f2781i == -1) {
            this.f2781i = 0;
        }
        int i = this.f2781i;
        int i2 = this.f2780h + i;
        char c = ' ';
        char d = mo11268d(i2 - 1);
        if (d == 'B') {
            i2--;
            c = 'B';
        } else if (d == 'L') {
            i2--;
            c = 'L';
        } else if (d == 'S') {
            i2--;
            c = 'S';
        }
        if (mo11268d(this.f2781i) == '-') {
            j = Long.MIN_VALUE;
            i++;
            z = true;
        } else {
            j = -9223372036854775807L;
        }
        long j3 = -922337203685477580L;
        if (i < i2) {
            j2 = (long) (-(mo11268d(i) - '0'));
            i++;
        } else {
            j2 = 0;
        }
        while (i < i2) {
            int i3 = i + 1;
            int d2 = mo11268d(i) - '0';
            if (j2 < j3) {
                return new BigInteger(mo11240s());
            }
            long j4 = j2 * 10;
            long j5 = (long) d2;
            if (j4 < j + j5) {
                return new BigInteger(mo11240s());
            }
            j2 = j4 - j5;
            i = i3;
            j3 = -922337203685477580L;
        }
        if (!z) {
            long j6 = -j2;
            if (j6 > 2147483647L || c == 'L') {
                return Long.valueOf(j6);
            }
            if (c == 'S') {
                return Short.valueOf((short) ((int) j6));
            }
            if (c == 'B') {
                return Byte.valueOf((byte) ((int) j6));
            }
            return Integer.valueOf((int) j6);
        } else if (i <= this.f2781i + 1) {
            throw new NumberFormatException(mo11240s());
        } else if (j2 < -2147483648L || c == 'L') {
            return Long.valueOf(j2);
        } else {
            if (c == 'S') {
                return Short.valueOf((short) ((int) j2));
            }
            if (c == 'B') {
                return Byte.valueOf((byte) ((int) j2));
            }
            return Integer.valueOf((int) j2);
        }
    }

    /* renamed from: c */
    public final void mo11219c(int i) {
        mo11274h(':');
    }

    /* renamed from: u */
    public float mo11242u() {
        String s = mo11240s();
        float parseFloat = Float.parseFloat(s);
        if (parseFloat == 0.0f || parseFloat == Float.POSITIVE_INFINITY) {
            char charAt = s.charAt(0);
            if (charAt > '0' && charAt <= '9') {
                StringBuilder sb = new StringBuilder();
                sb.append("float overflow : ");
                sb.append(s);
                throw new JSONException(sb.toString());
            }
        }
        return parseFloat;
    }

    /* renamed from: B */
    public double mo11248B() {
        return Double.parseDouble(mo11240s());
    }

    /* renamed from: a */
    public final boolean mo11212a(Feature feature) {
        return mo11216b(feature.mask);
    }

    /* renamed from: b */
    public final boolean mo11216b(int i) {
        return (i & this.f2775c) != 0;
    }

    /* renamed from: e */
    public final char mo11223e() {
        return this.f2776d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: D */
    public void mo11250D() {
        char c;
        mo11225f();
        char c2 = this.f2776d;
        if (c2 == '/') {
            do {
                mo11225f();
                c = this.f2776d;
                if (c == 10) {
                    mo11225f();
                    return;
                }
            } while (c != 26);
        } else if (c2 == '*') {
            mo11225f();
            while (true) {
                char c3 = this.f2776d;
                if (c3 == 26) {
                    return;
                }
                if (c3 == '*') {
                    mo11225f();
                    if (this.f2776d == '/') {
                        mo11225f();
                        return;
                    }
                } else {
                    mo11225f();
                }
            }
        } else {
            throw new JSONException("invalid comment");
        }
    }

    /* renamed from: a */
    public final String mo11209a(SymbolTable iVar) {
        mo11218c();
        char c = this.f2776d;
        if (c == '\"') {
            return mo11210a(iVar, '\"');
        }
        String str = "syntax error";
        if (c == '\'') {
            if (mo11212a(Feature.AllowSingleQuotes)) {
                return mo11210a(iVar, '\'');
            }
            throw new JSONException(str);
        } else if (c == '}') {
            mo11225f();
            this.f2773a = 13;
            return null;
        } else if (c == ',') {
            mo11225f();
            this.f2773a = 16;
            return null;
        } else if (c == 26) {
            this.f2773a = 20;
            return null;
        } else if (mo11212a(Feature.AllowUnQuotedFieldNames)) {
            return mo11215b(iVar);
        } else {
            throw new JSONException(str);
        }
    }

    /* renamed from: a */
    public final String mo11210a(SymbolTable iVar, char c) {
        String str;
        this.f2781i = this.f2777e;
        this.f2780h = 0;
        boolean z = false;
        int i = 0;
        while (true) {
            char f = mo11225f();
            if (f == c) {
                this.f2773a = 4;
                if (!z) {
                    int i2 = this.f2781i;
                    str = mo11259a(i2 == -1 ? 0 : i2 + 1, this.f2780h, i, iVar);
                } else {
                    str = iVar.mo11303a(this.f2779g, 0, this.f2780h, i);
                }
                this.f2780h = 0;
                mo11225f();
                return str;
            } else if (f == 26) {
                throw new JSONException("unclosed.str");
            } else if (f == '\\') {
                if (!z) {
                    int i3 = this.f2780h;
                    char[] cArr = this.f2779g;
                    if (i3 >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i3 <= length) {
                            i3 = length;
                        }
                        char[] cArr2 = new char[i3];
                        char[] cArr3 = this.f2779g;
                        System.arraycopy(cArr3, 0, cArr2, 0, cArr3.length);
                        this.f2779g = cArr2;
                    }
                    mo11261a(this.f2781i + 1, this.f2779g, 0, this.f2780h);
                    z = true;
                }
                char f2 = mo11225f();
                if (f2 == '\"') {
                    i = (i * 31) + 34;
                    mo11275i('\"');
                } else if (f2 != '\'') {
                    if (f2 != 'F') {
                        if (f2 == '\\') {
                            i = (i * 31) + 92;
                            mo11275i('\\');
                        } else if (f2 == 'b') {
                            i = (i * 31) + 8;
                            mo11275i(8);
                        } else if (f2 != 'f') {
                            if (f2 == 'n') {
                                i = (i * 31) + 10;
                                mo11275i(10);
                            } else if (f2 == 'r') {
                                i = (i * 31) + 13;
                                mo11275i(13);
                            } else if (f2 != 'x') {
                                switch (f2) {
                                    case '/':
                                        i = (i * 31) + 47;
                                        mo11275i('/');
                                        break;
                                    case '0':
                                        i = (i * 31) + f2;
                                        mo11275i(0);
                                        break;
                                    case '1':
                                        i = (i * 31) + f2;
                                        mo11275i(1);
                                        break;
                                    case '2':
                                        i = (i * 31) + f2;
                                        mo11275i(2);
                                        break;
                                    case '3':
                                        i = (i * 31) + f2;
                                        mo11275i(3);
                                        break;
                                    case '4':
                                        i = (i * 31) + f2;
                                        mo11275i(4);
                                        break;
                                    case '5':
                                        i = (i * 31) + f2;
                                        mo11275i(5);
                                        break;
                                    case '6':
                                        i = (i * 31) + f2;
                                        mo11275i(6);
                                        break;
                                    case '7':
                                        i = (i * 31) + f2;
                                        mo11275i(7);
                                        break;
                                    default:
                                        switch (f2) {
                                            case 't':
                                                i = (i * 31) + 9;
                                                mo11275i(9);
                                                break;
                                            case 'u':
                                                int parseInt = Integer.parseInt(new String(new char[]{mo11225f(), mo11225f(), mo11225f(), mo11225f()}), 16);
                                                i = (i * 31) + parseInt;
                                                mo11275i((char) parseInt);
                                                break;
                                            case 'v':
                                                i = (i * 31) + 11;
                                                mo11275i(11);
                                                break;
                                            default:
                                                this.f2776d = f2;
                                                throw new JSONException("unclosed.str.lit");
                                        }
                                }
                            } else {
                                char f3 = mo11225f();
                                this.f2776d = f3;
                                char f4 = mo11225f();
                                this.f2776d = f4;
                                int[] iArr = f2771q;
                                char c2 = (char) ((iArr[f3] * 16) + iArr[f4]);
                                i = (i * 31) + c2;
                                mo11275i(c2);
                            }
                        }
                    }
                    i = (i * 31) + 12;
                    mo11275i(12);
                } else {
                    i = (i * 31) + 39;
                    mo11275i('\'');
                }
            } else {
                i = (i * 31) + f;
                if (!z) {
                    this.f2780h++;
                } else {
                    int i4 = this.f2780h;
                    char[] cArr4 = this.f2779g;
                    if (i4 == cArr4.length) {
                        mo11275i(f);
                    } else {
                        this.f2780h = i4 + 1;
                        cArr4[i4] = f;
                    }
                }
            }
        }
    }

    /* renamed from: g */
    public final void mo11228g() {
        this.f2780h = 0;
    }

    /* renamed from: b */
    public final String mo11215b(SymbolTable iVar) {
        boolean z = false;
        if (this.f2773a == 1 && this.f2774b == 0 && this.f2777e == 1) {
            this.f2777e = 0;
        }
        boolean[] zArr = IOUtils.f3016d;
        int i = this.f2776d;
        if (i >= zArr.length || zArr[i]) {
            z = true;
        }
        if (z) {
            boolean[] zArr2 = IOUtils.f3017e;
            this.f2781i = this.f2777e;
            this.f2780h = 1;
            while (true) {
                char f = mo11225f();
                if (f < zArr2.length && !zArr2[f]) {
                    break;
                }
                i = (i * 31) + f;
                this.f2780h++;
            }
            this.f2776d = mo11268d(this.f2777e);
            this.f2773a = 18;
            if (this.f2780h == 4 && i == 3392903 && mo11268d(this.f2781i) == 'n' && mo11268d(this.f2781i + 1) == 'u' && mo11268d(this.f2781i + 2) == 'l' && mo11268d(this.f2781i + 3) == 'l') {
                return null;
            }
            if (iVar == null) {
                return mo11258a(this.f2781i, this.f2780h);
            }
            return mo11259a(this.f2781i, this.f2780h, i, iVar);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("illegal identifier : ");
        sb.append(this.f2776d);
        sb.append(mo11245x());
        throw new JSONException(sb.toString());
    }

    /* renamed from: m */
    public final void mo11234m() {
        this.f2781i = this.f2777e;
        this.f2782j = false;
        while (true) {
            char f = mo11225f();
            if (f == '\"') {
                this.f2773a = 4;
                this.f2776d = mo11225f();
                return;
            }
            String str = "unclosed string : ";
            if (f == 26) {
                if (!mo11249C()) {
                    mo11275i(26);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(f);
                    throw new JSONException(sb.toString());
                }
            } else if (f == '\\') {
                if (!this.f2782j) {
                    this.f2782j = true;
                    int i = this.f2780h;
                    char[] cArr = this.f2779g;
                    if (i >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i <= length) {
                            i = length;
                        }
                        char[] cArr2 = new char[i];
                        char[] cArr3 = this.f2779g;
                        System.arraycopy(cArr3, 0, cArr2, 0, cArr3.length);
                        this.f2779g = cArr2;
                    }
                    mo11260a(this.f2781i + 1, this.f2780h, this.f2779g);
                }
                char f2 = mo11225f();
                if (f2 == '\"') {
                    mo11275i('\"');
                } else if (f2 != '\'') {
                    if (f2 != 'F') {
                        if (f2 == '\\') {
                            mo11275i('\\');
                        } else if (f2 == 'b') {
                            mo11275i(8);
                        } else if (f2 != 'f') {
                            if (f2 == 'n') {
                                mo11275i(10);
                            } else if (f2 == 'r') {
                                mo11275i(13);
                            } else if (f2 != 'x') {
                                switch (f2) {
                                    case '/':
                                        mo11275i('/');
                                        break;
                                    case '0':
                                        mo11275i(0);
                                        break;
                                    case '1':
                                        mo11275i(1);
                                        break;
                                    case '2':
                                        mo11275i(2);
                                        break;
                                    case '3':
                                        mo11275i(3);
                                        break;
                                    case '4':
                                        mo11275i(4);
                                        break;
                                    case '5':
                                        mo11275i(5);
                                        break;
                                    case '6':
                                        mo11275i(6);
                                        break;
                                    case '7':
                                        mo11275i(7);
                                        break;
                                    default:
                                        switch (f2) {
                                            case 't':
                                                mo11275i(9);
                                                break;
                                            case 'u':
                                                mo11275i((char) Integer.parseInt(new String(new char[]{mo11225f(), mo11225f(), mo11225f(), mo11225f()}), 16));
                                                break;
                                            case 'v':
                                                mo11275i(11);
                                                break;
                                            default:
                                                this.f2776d = f2;
                                                StringBuilder sb2 = new StringBuilder();
                                                sb2.append(str);
                                                sb2.append(f2);
                                                throw new JSONException(sb2.toString());
                                        }
                                }
                            } else {
                                char f3 = mo11225f();
                                char f4 = mo11225f();
                                int[] iArr = f2771q;
                                mo11275i((char) ((iArr[f3] * 16) + iArr[f4]));
                            }
                        }
                    }
                    mo11275i(12);
                } else {
                    mo11275i('\'');
                }
            } else if (!this.f2782j) {
                this.f2780h++;
            } else {
                int i2 = this.f2780h;
                char[] cArr4 = this.f2779g;
                if (i2 == cArr4.length) {
                    mo11275i(f);
                } else {
                    this.f2780h = i2 + 1;
                    cArr4[i2] = f;
                }
            }
        }
    }

    /* renamed from: E */
    public Calendar mo11251E() {
        return this.f2783k;
    }

    /* renamed from: v */
    public TimeZone mo11243v() {
        return this.f2784l;
    }

    /* renamed from: w */
    public Locale mo11244w() {
        return this.f2785m;
    }

    /* renamed from: n */
    public final int mo11235n() {
        int i;
        boolean z;
        int i2;
        int i3 = 0;
        if (this.f2781i == -1) {
            this.f2781i = 0;
        }
        int i4 = this.f2781i;
        int i5 = this.f2780h + i4;
        if (mo11268d(i4) == '-') {
            i4++;
            z = true;
            i = Integer.MIN_VALUE;
        } else {
            z = false;
            i = -2147483647;
        }
        if (i4 < i5) {
            int i6 = i4 + 1;
            i3 = -(mo11268d(i4) - '0');
            i4 = i6;
        }
        while (true) {
            if (i4 >= i5) {
                break;
            }
            i2 = i4 + 1;
            char d = mo11268d(i4);
            if (d == 'L' || d == 'S' || d == 'B') {
                i4 = i2;
            } else {
                int i7 = d - '0';
                if (((long) i3) >= -214748364) {
                    int i8 = i3 * 10;
                    if (i8 >= i + i7) {
                        i3 = i8 - i7;
                        i4 = i2;
                    } else {
                        throw new NumberFormatException(mo11240s());
                    }
                } else {
                    throw new NumberFormatException(mo11240s());
                }
            }
        }
        i4 = i2;
        if (!z) {
            return -i3;
        }
        if (i4 > this.f2781i + 1) {
            return i3;
        }
        throw new NumberFormatException(mo11240s());
    }

    public void close() {
        char[] cArr = this.f2779g;
        if (cArr.length <= 8192) {
            f2772r.set(cArr);
        }
        this.f2779g = null;
    }

    /* renamed from: r */
    public final boolean mo11239r() {
        boolean z = false;
        if (this.f2780h != 4) {
            return false;
        }
        if (mo11268d(this.f2781i + 1) == '$' && mo11268d(this.f2781i + 2) == 'r' && mo11268d(this.f2781i + 3) == 'e' && mo11268d(this.f2781i + 4) == 'f') {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public final boolean mo11263a(char[] cArr) {
        while (!mo11282o(cArr)) {
            if (!m2776j(this.f2776d)) {
                return false;
            }
            mo11225f();
        }
        this.f2777e += cArr.length;
        this.f2776d = mo11268d(this.f2777e);
        char c = this.f2776d;
        if (c == '{') {
            mo11225f();
            this.f2773a = 12;
        } else if (c == '[') {
            mo11225f();
            this.f2773a = 14;
        } else if (c == 'S' && mo11268d(this.f2777e + 1) == 'e' && mo11268d(this.f2777e + 2) == 't' && mo11268d(this.f2777e + 3) == '[') {
            this.f2777e += 3;
            this.f2776d = mo11268d(this.f2777e);
            this.f2773a = 21;
        } else {
            mo11222d();
        }
        return true;
    }

    /* renamed from: b */
    public String mo11265b(char[] cArr) {
        this.f2786n = 0;
        if (!mo11282o(cArr)) {
            this.f2786n = -2;
            return mo11247A();
        }
        int length = cArr.length;
        int i = length + 1;
        if (mo11268d(this.f2777e + length) != '\"') {
            this.f2786n = -1;
            return mo11247A();
        }
        int a = mo11257a('\"', this.f2777e + cArr.length + 1);
        if (a != -1) {
            int length2 = this.f2777e + cArr.length + 1;
            String a2 = mo11258a(length2, a - length2);
            if (a2.indexOf(92) != -1) {
                while (true) {
                    int i2 = a - 1;
                    int i3 = 0;
                    while (i2 >= 0 && mo11268d(i2) == '\\') {
                        i3++;
                        i2--;
                    }
                    if (i3 % 2 == 0) {
                        break;
                    }
                    a = mo11257a('\"', a + 1);
                }
                int i4 = this.f2777e;
                int length3 = a - ((cArr.length + i4) + 1);
                a2 = m2775a(mo11266b(i4 + cArr.length + 1, length3), length3);
            }
            int i5 = this.f2777e;
            int length4 = i + (a - ((cArr.length + i5) + 1)) + 1;
            int i6 = length4 + 1;
            char d = mo11268d(i5 + length4);
            if (d == ',') {
                this.f2777e += i6;
                this.f2776d = mo11268d(this.f2777e);
                this.f2786n = 3;
                return a2;
            } else if (d == '}') {
                int i7 = i6 + 1;
                char d2 = mo11268d(this.f2777e + i6);
                if (d2 == ',') {
                    this.f2773a = 16;
                    this.f2777e += i7;
                    this.f2776d = mo11268d(this.f2777e);
                } else if (d2 == ']') {
                    this.f2773a = 15;
                    this.f2777e += i7;
                    this.f2776d = mo11268d(this.f2777e);
                } else if (d2 == '}') {
                    this.f2773a = 13;
                    this.f2777e += i7;
                    this.f2776d = mo11268d(this.f2777e);
                } else if (d2 == 26) {
                    this.f2773a = 20;
                    this.f2777e += i7 - 1;
                    this.f2776d = 26;
                } else {
                    this.f2786n = -1;
                    return mo11247A();
                }
                this.f2786n = 4;
                return a2;
            } else {
                this.f2786n = -1;
                return mo11247A();
            }
        } else {
            throw new JSONException("unclosed str");
        }
    }

    /* renamed from: g */
    public String mo11227g(char c) {
        this.f2786n = 0;
        char d = mo11268d(this.f2777e + 0);
        if (d != 'n') {
            int i = 1;
            while (d != '\"') {
                if (m2776j(d)) {
                    int i2 = i + 1;
                    d = mo11268d(this.f2777e + i);
                    i = i2;
                } else {
                    this.f2786n = -1;
                    return mo11247A();
                }
            }
            int i3 = this.f2777e + i;
            int a = mo11257a('\"', i3);
            if (a != -1) {
                String a2 = mo11258a(this.f2777e + i, a - i3);
                if (a2.indexOf(92) != -1) {
                    while (true) {
                        int i4 = a - 1;
                        int i5 = 0;
                        while (i4 >= 0 && mo11268d(i4) == '\\') {
                            i5++;
                            i4--;
                        }
                        if (i5 % 2 == 0) {
                            break;
                        }
                        a = mo11257a('\"', a + 1);
                    }
                    int i6 = a - i3;
                    a2 = m2775a(mo11266b(this.f2777e + 1, i6), i6);
                }
                int i7 = i + (a - i3) + 1;
                int i8 = i7 + 1;
                char d2 = mo11268d(this.f2777e + i7);
                while (d2 != c) {
                    if (m2776j(d2)) {
                        int i9 = i8 + 1;
                        d2 = mo11268d(this.f2777e + i8);
                        i8 = i9;
                    } else {
                        this.f2786n = -1;
                        return a2;
                    }
                }
                this.f2777e += i8;
                this.f2776d = mo11268d(this.f2777e);
                this.f2786n = 3;
                return a2;
            }
            throw new JSONException("unclosed str");
        } else if (mo11268d(this.f2777e + 1) != 'u' || mo11268d(this.f2777e + 1 + 1) != 'l' || mo11268d(this.f2777e + 1 + 2) != 'l') {
            this.f2786n = -1;
            return null;
        } else if (mo11268d(this.f2777e + 4) == c) {
            this.f2777e += 5;
            this.f2776d = mo11268d(this.f2777e);
            this.f2786n = 3;
            return null;
        } else {
            this.f2786n = -1;
            return null;
        }
    }

    /* renamed from: c */
    public long mo11267c(char[] cArr) {
        this.f2786n = 0;
        if (!mo11282o(cArr)) {
            this.f2786n = -2;
            return 0;
        }
        int length = cArr.length;
        int i = length + 1;
        if (mo11268d(this.f2777e + length) != '\"') {
            this.f2786n = -1;
            return 0;
        }
        long j = -3750763034362895579L;
        while (true) {
            int i2 = i + 1;
            char d = mo11268d(this.f2777e + i);
            if (d == '\"') {
                int i3 = i2 + 1;
                char d2 = mo11268d(this.f2777e + i2);
                if (d2 == ',') {
                    this.f2777e += i3;
                    this.f2776d = mo11268d(this.f2777e);
                    this.f2786n = 3;
                    return j;
                } else if (d2 == '}') {
                    int i4 = i3 + 1;
                    char d3 = mo11268d(this.f2777e + i3);
                    if (d3 == ',') {
                        this.f2773a = 16;
                        this.f2777e += i4;
                        this.f2776d = mo11268d(this.f2777e);
                    } else if (d3 == ']') {
                        this.f2773a = 15;
                        this.f2777e += i4;
                        this.f2776d = mo11268d(this.f2777e);
                    } else if (d3 == '}') {
                        this.f2773a = 13;
                        this.f2777e += i4;
                        this.f2776d = mo11268d(this.f2777e);
                    } else if (d3 == 26) {
                        this.f2773a = 20;
                        this.f2777e += i4 - 1;
                        this.f2776d = 26;
                    } else {
                        this.f2786n = -1;
                        return 0;
                    }
                    this.f2786n = 4;
                    return j;
                } else {
                    this.f2786n = -1;
                    return 0;
                }
            } else {
                j = (j ^ ((long) d)) * 1099511628211L;
                if (d == '\\') {
                    this.f2786n = -1;
                    return 0;
                }
                i = i2;
            }
        }
    }

    /* renamed from: a */
    public Enum<?> mo11207a(Class<?> cls, SymbolTable iVar, char c) {
        String b = mo11264b(iVar, c);
        if (b == null) {
            return null;
        }
        return Enum.valueOf(cls, b);
    }

    /* renamed from: b */
    public String mo11264b(SymbolTable iVar, char c) {
        this.f2786n = 0;
        char d = mo11268d(this.f2777e + 0);
        if (d == 'n') {
            if (mo11268d(this.f2777e + 1) != 'u' || mo11268d(this.f2777e + 1 + 1) != 'l' || mo11268d(this.f2777e + 1 + 2) != 'l') {
                this.f2786n = -1;
                return null;
            } else if (mo11268d(this.f2777e + 4) == c) {
                this.f2777e += 5;
                this.f2776d = mo11268d(this.f2777e);
                this.f2786n = 3;
                return null;
            } else {
                this.f2786n = -1;
                return null;
            }
        } else if (d != '\"') {
            this.f2786n = -1;
            return null;
        } else {
            int i = 1;
            int i2 = 0;
            while (true) {
                int i3 = i + 1;
                char d2 = mo11268d(this.f2777e + i);
                if (d2 == '\"') {
                    int i4 = this.f2777e;
                    int i5 = i4 + 0 + 1;
                    String a = mo11259a(i5, ((i4 + i3) - i5) - 1, i2, iVar);
                    int i6 = i3 + 1;
                    char d3 = mo11268d(this.f2777e + i3);
                    while (d3 != c) {
                        if (m2776j(d3)) {
                            int i7 = i6 + 1;
                            d3 = mo11268d(this.f2777e + i6);
                            i6 = i7;
                        } else {
                            this.f2786n = -1;
                            return a;
                        }
                    }
                    this.f2777e += i6;
                    this.f2776d = mo11268d(this.f2777e);
                    this.f2786n = 3;
                    return a;
                }
                i2 = (i2 * 31) + d2;
                if (d2 == '\\') {
                    this.f2786n = -1;
                    return null;
                }
                i = i3;
            }
        }
    }

    /* renamed from: d */
    public int mo11269d(char[] cArr) {
        int i;
        int i2;
        char d;
        this.f2786n = 0;
        if (!mo11282o(cArr)) {
            this.f2786n = -2;
            return 0;
        }
        int length = cArr.length;
        int i3 = length + 1;
        char d2 = mo11268d(this.f2777e + length);
        boolean z = d2 == '-';
        if (z) {
            int i4 = i3 + 1;
            d2 = mo11268d(this.f2777e + i3);
            i3 = i4;
        }
        if (d2 < '0' || d2 > '9') {
            this.f2786n = -1;
            return 0;
        }
        int i5 = d2 - '0';
        while (true) {
            i2 = i3 + 1;
            d = mo11268d(this.f2777e + i3);
            if (d >= '0' && d <= '9') {
                i5 = (i * 10) + (d - '0');
                i3 = i2;
            }
        }
        if (d == '.') {
            this.f2786n = -1;
            return 0;
        } else if ((i < 0 || i2 > cArr.length + 14) && !(i == Integer.MIN_VALUE && i2 == 17 && z)) {
            this.f2786n = -1;
            return 0;
        } else if (d == ',') {
            this.f2777e += i2;
            this.f2776d = mo11268d(this.f2777e);
            this.f2786n = 3;
            this.f2773a = 16;
            if (z) {
                i = -i;
            }
            return i;
        } else if (d == '}') {
            int i6 = i2 + 1;
            char d3 = mo11268d(this.f2777e + i2);
            if (d3 == ',') {
                this.f2773a = 16;
                this.f2777e += i6;
                this.f2776d = mo11268d(this.f2777e);
            } else if (d3 == ']') {
                this.f2773a = 15;
                this.f2777e += i6;
                this.f2776d = mo11268d(this.f2777e);
            } else if (d3 == '}') {
                this.f2773a = 13;
                this.f2777e += i6;
                this.f2776d = mo11268d(this.f2777e);
            } else if (d3 == 26) {
                this.f2773a = 20;
                this.f2777e += i6 - 1;
                this.f2776d = 26;
            } else {
                this.f2786n = -1;
                return 0;
            }
            this.f2786n = 4;
            if (z) {
                i = -i;
            }
            return i;
        } else {
            this.f2786n = -1;
            return 0;
        }
    }

    /* renamed from: e */
    public final int[] mo11270e(char[] cArr) {
        int i;
        int i2;
        char c;
        int[] iArr;
        boolean z;
        int i3;
        char d;
        char c2;
        int[] iArr2;
        this.f2786n = 0;
        int[] iArr3 = null;
        if (!mo11282o(cArr)) {
            this.f2786n = -2;
            return null;
        }
        int length = cArr.length;
        int i4 = length + 1;
        if (mo11268d(this.f2777e + length) != '[') {
            this.f2786n = -2;
            return null;
        }
        int i5 = i4 + 1;
        char d2 = mo11268d(this.f2777e + i4);
        int[] iArr4 = new int[16];
        if (d2 == ']') {
            i = i5 + 1;
            c = mo11268d(this.f2777e + i5);
            i2 = 0;
        } else {
            int i6 = 0;
            while (true) {
                if (d2 == '-') {
                    int i7 = i5 + 1;
                    d2 = mo11268d(this.f2777e + i5);
                    i5 = i7;
                    z = true;
                } else {
                    z = false;
                }
                if (d2 < '0' || d2 > '9') {
                    int[] iArr5 = iArr3;
                    this.f2786n = -1;
                } else {
                    int i8 = d2 - '0';
                    while (true) {
                        i3 = i5 + 1;
                        d = mo11268d(this.f2777e + i5);
                        if (d >= '0' && d <= '9') {
                            i8 = (i8 * 10) + (d - '0');
                            i5 = i3;
                        }
                    }
                    if (i6 >= iArr4.length) {
                        int[] iArr6 = new int[((iArr4.length * 3) / 2)];
                        System.arraycopy(iArr4, 0, iArr6, 0, i6);
                        iArr4 = iArr6;
                    }
                    i2 = i6 + 1;
                    if (z) {
                        i8 = -i8;
                    }
                    iArr4[i6] = i8;
                    if (d == ',') {
                        i5 = i3 + 1;
                        c2 = mo11268d(this.f2777e + i3);
                        iArr2 = null;
                    } else if (d == ']') {
                        i = i3 + 1;
                        c = mo11268d(this.f2777e + i3);
                        break;
                    } else {
                        iArr2 = null;
                        c2 = d;
                        i5 = i3;
                    }
                    int i9 = i2;
                    iArr3 = iArr2;
                    d2 = c2;
                    i6 = i9;
                }
            }
            int[] iArr52 = iArr3;
            this.f2786n = -1;
            return iArr52;
        }
        if (i2 != iArr4.length) {
            iArr = new int[i2];
            System.arraycopy(iArr4, 0, iArr, 0, i2);
        } else {
            iArr = iArr4;
        }
        if (c == ',') {
            this.f2777e += i - 1;
            mo11225f();
            this.f2786n = 3;
            this.f2773a = 16;
            return iArr;
        } else if (c == '}') {
            int i10 = i + 1;
            char d3 = mo11268d(this.f2777e + i);
            if (d3 == ',') {
                this.f2773a = 16;
                this.f2777e += i10 - 1;
                mo11225f();
            } else if (d3 == ']') {
                this.f2773a = 15;
                this.f2777e += i10 - 1;
                mo11225f();
            } else if (d3 == '}') {
                this.f2773a = 13;
                this.f2777e += i10 - 1;
                mo11225f();
            } else if (d3 == 26) {
                this.f2777e += i10 - 1;
                this.f2773a = 20;
                this.f2776d = 26;
            } else {
                this.f2786n = -1;
                return null;
            }
            this.f2786n = 4;
            return iArr;
        } else {
            this.f2786n = -1;
            return null;
        }
    }

    /* renamed from: e */
    public boolean mo11224e(char c) {
        boolean z = false;
        this.f2786n = 0;
        char d = mo11268d(this.f2777e + 0);
        int i = 2;
        if (d == 't') {
            if (mo11268d(this.f2777e + 1) == 'r' && mo11268d(this.f2777e + 1 + 1) == 'u' && mo11268d(this.f2777e + 1 + 2) == 'e') {
                d = mo11268d(this.f2777e + 4);
                z = true;
                i = 5;
            } else {
                this.f2786n = -1;
                return false;
            }
        } else if (d == 'f') {
            if (mo11268d(this.f2777e + 1) == 'a' && mo11268d(this.f2777e + 1 + 1) == 'l' && mo11268d(this.f2777e + 1 + 2) == 's' && mo11268d(this.f2777e + 1 + 3) == 'e') {
                d = mo11268d(this.f2777e + 5);
                i = 6;
            } else {
                this.f2786n = -1;
                return false;
            }
        } else if (d == '1') {
            d = mo11268d(this.f2777e + 1);
            z = true;
        } else if (d == '0') {
            d = mo11268d(this.f2777e + 1);
        } else {
            i = 1;
        }
        while (d != c) {
            if (m2776j(d)) {
                int i2 = i + 1;
                d = mo11268d(this.f2777e + i);
                i = i2;
            } else {
                this.f2786n = -1;
                return z;
            }
        }
        this.f2777e += i;
        this.f2776d = mo11268d(this.f2777e);
        this.f2786n = 3;
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e5  */
    /* renamed from: a */
    public int mo11206a(char r14) {
        /*
        r13 = this;
        r0 = 0
        r13.f2786n = r0
        int r1 = r13.f2777e
        int r1 = r1 + r0
        char r1 = r13.mo11268d(r1)
        r2 = 34
        r3 = 1
        if (r1 != r2) goto L_0x0011
        r4 = 1
        goto L_0x0012
    L_0x0011:
        r4 = 0
    L_0x0012:
        r5 = 2
        if (r4 == 0) goto L_0x001e
        int r1 = r13.f2777e
        int r1 = r1 + r3
        char r1 = r13.mo11268d(r1)
        r6 = 2
        goto L_0x001f
    L_0x001e:
        r6 = 1
    L_0x001f:
        r7 = 45
        if (r1 != r7) goto L_0x0025
        r7 = 1
        goto L_0x0026
    L_0x0025:
        r7 = 0
    L_0x0026:
        if (r7 == 0) goto L_0x0032
        int r1 = r13.f2777e
        int r8 = r6 + 1
        int r1 = r1 + r6
        char r1 = r13.mo11268d(r1)
        r6 = r8
    L_0x0032:
        r8 = 16
        r9 = 3
        r10 = 48
        r11 = -1
        if (r1 < r10) goto L_0x008e
        r12 = 57
        if (r1 > r12) goto L_0x008e
        int r1 = r1 - r10
    L_0x003f:
        int r2 = r13.f2777e
        int r3 = r6 + 1
        int r2 = r2 + r6
        char r2 = r13.mo11268d(r2)
        if (r2 < r10) goto L_0x0053
        if (r2 > r12) goto L_0x0053
        int r1 = r1 * 10
        int r2 = r2 + -48
        int r1 = r1 + r2
        r6 = r3
        goto L_0x003f
    L_0x0053:
        r4 = 46
        if (r2 != r4) goto L_0x005a
        r13.f2786n = r11
        return r0
    L_0x005a:
        if (r1 >= 0) goto L_0x005f
        r13.f2786n = r11
        return r0
    L_0x005f:
        if (r2 != r14) goto L_0x0076
        int r14 = r13.f2777e
        int r14 = r14 + r3
        r13.f2777e = r14
        int r14 = r13.f2777e
        char r14 = r13.mo11268d(r14)
        r13.f2776d = r14
        r13.f2786n = r9
        r13.f2773a = r8
        if (r7 == 0) goto L_0x0075
        int r1 = -r1
    L_0x0075:
        return r1
    L_0x0076:
        boolean r0 = m2776j(r2)
        if (r0 == 0) goto L_0x0088
        int r0 = r13.f2777e
        int r2 = r3 + 1
        int r0 = r0 + r3
        char r0 = r13.mo11268d(r0)
        r3 = r2
        r2 = r0
        goto L_0x005f
    L_0x0088:
        r13.f2786n = r11
        if (r7 == 0) goto L_0x008d
        int r1 = -r1
    L_0x008d:
        return r1
    L_0x008e:
        r14 = 110(0x6e, float:1.54E-43)
        if (r1 != r14) goto L_0x0110
        int r14 = r13.f2777e
        int r14 = r14 + r6
        char r14 = r13.mo11268d(r14)
        r1 = 117(0x75, float:1.64E-43)
        if (r14 != r1) goto L_0x0110
        int r14 = r13.f2777e
        int r14 = r14 + r6
        int r14 = r14 + r3
        char r14 = r13.mo11268d(r14)
        r1 = 108(0x6c, float:1.51E-43)
        if (r14 != r1) goto L_0x0110
        int r14 = r13.f2777e
        int r14 = r14 + r6
        int r14 = r14 + r5
        char r14 = r13.mo11268d(r14)
        if (r14 != r1) goto L_0x0110
        r14 = 5
        r13.f2786n = r14
        int r6 = r6 + r9
        int r1 = r13.f2777e
        int r3 = r6 + 1
        int r1 = r1 + r6
        char r1 = r13.mo11268d(r1)
        if (r4 == 0) goto L_0x00ce
        if (r1 != r2) goto L_0x00ce
        int r1 = r13.f2777e
        int r2 = r3 + 1
        int r1 = r1 + r3
        char r1 = r13.mo11268d(r1)
        goto L_0x00cf
    L_0x00ce:
        r2 = r3
    L_0x00cf:
        r3 = 44
        if (r1 != r3) goto L_0x00e5
        int r1 = r13.f2777e
        int r1 = r1 + r2
        r13.f2777e = r1
        int r1 = r13.f2777e
        char r1 = r13.mo11268d(r1)
        r13.f2776d = r1
        r13.f2786n = r14
        r13.f2773a = r8
        return r0
    L_0x00e5:
        r3 = 93
        if (r1 != r3) goto L_0x00fd
        int r1 = r13.f2777e
        int r1 = r1 + r2
        r13.f2777e = r1
        int r1 = r13.f2777e
        char r1 = r13.mo11268d(r1)
        r13.f2776d = r1
        r13.f2786n = r14
        r14 = 15
        r13.f2773a = r14
        return r0
    L_0x00fd:
        boolean r1 = m2776j(r1)
        if (r1 == 0) goto L_0x010d
        int r1 = r13.f2777e
        int r3 = r2 + 1
        int r1 = r1 + r2
        char r1 = r13.mo11268d(r1)
        goto L_0x00ce
    L_0x010d:
        r13.f2786n = r11
        return r0
    L_0x0110:
        r13.f2786n = r11
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.mo11206a(char):int");
    }

    /* renamed from: f */
    public boolean mo11271f(char[] cArr) {
        boolean z;
        int i;
        this.f2786n = 0;
        if (!mo11282o(cArr)) {
            this.f2786n = -2;
            return false;
        }
        int length = cArr.length;
        int i2 = length + 1;
        char d = mo11268d(this.f2777e + length);
        if (d == 't') {
            int i3 = i2 + 1;
            if (mo11268d(this.f2777e + i2) != 'r') {
                this.f2786n = -1;
                return false;
            }
            int i4 = i3 + 1;
            if (mo11268d(this.f2777e + i3) != 'u') {
                this.f2786n = -1;
                return false;
            }
            i = i4 + 1;
            if (mo11268d(this.f2777e + i4) != 'e') {
                this.f2786n = -1;
                return false;
            }
            z = true;
        } else if (d == 'f') {
            int i5 = i2 + 1;
            if (mo11268d(this.f2777e + i2) != 'a') {
                this.f2786n = -1;
                return false;
            }
            int i6 = i5 + 1;
            if (mo11268d(this.f2777e + i5) != 'l') {
                this.f2786n = -1;
                return false;
            }
            int i7 = i6 + 1;
            if (mo11268d(this.f2777e + i6) != 's') {
                this.f2786n = -1;
                return false;
            }
            int i8 = i7 + 1;
            if (mo11268d(this.f2777e + i7) != 'e') {
                this.f2786n = -1;
                return false;
            }
            i = i8;
            z = false;
        } else {
            this.f2786n = -1;
            return false;
        }
        int i9 = i + 1;
        char d2 = mo11268d(this.f2777e + i);
        if (d2 == ',') {
            this.f2777e += i9;
            this.f2776d = mo11268d(this.f2777e);
            this.f2786n = 3;
            this.f2773a = 16;
            return z;
        } else if (d2 == '}') {
            int i10 = i9 + 1;
            char d3 = mo11268d(this.f2777e + i9);
            if (d3 == ',') {
                this.f2773a = 16;
                this.f2777e += i10;
                this.f2776d = mo11268d(this.f2777e);
            } else if (d3 == ']') {
                this.f2773a = 15;
                this.f2777e += i10;
                this.f2776d = mo11268d(this.f2777e);
            } else if (d3 == '}') {
                this.f2773a = 13;
                this.f2777e += i10;
                this.f2776d = mo11268d(this.f2777e);
            } else if (d3 == 26) {
                this.f2773a = 20;
                this.f2777e += i10 - 1;
                this.f2776d = 26;
            } else {
                this.f2786n = -1;
                return false;
            }
            this.f2786n = 4;
            return z;
        } else {
            this.f2786n = -1;
            return false;
        }
    }

    /* renamed from: g */
    public long mo11272g(char[] cArr) {
        boolean z;
        int i;
        long j;
        int i2;
        char d;
        char[] cArr2 = cArr;
        this.f2786n = 0;
        if (!mo11282o(cArr)) {
            this.f2786n = -2;
            return 0;
        }
        int length = cArr2.length;
        int i3 = length + 1;
        char d2 = mo11268d(this.f2777e + length);
        if (d2 == '-') {
            i = i3 + 1;
            d2 = mo11268d(this.f2777e + i3);
            z = true;
        } else {
            i = i3;
            z = false;
        }
        if (d2 < '0' || d2 > '9') {
            this.f2786n = -1;
            return 0;
        }
        long j2 = (long) (d2 - '0');
        while (true) {
            i2 = i + 1;
            d = mo11268d(this.f2777e + i);
            if (d >= '0' && d <= '9') {
                j2 = (j * 10) + ((long) (d - '0'));
                i = i2;
            }
        }
        if (d == '.') {
            this.f2786n = -1;
            return 0;
        }
        boolean z2 = i2 - cArr2.length < 21 && (j >= 0 || (j == Long.MIN_VALUE && z));
        if (!z2) {
            this.f2786n = -1;
            return 0;
        } else if (d == ',') {
            this.f2777e += i2;
            this.f2776d = mo11268d(this.f2777e);
            this.f2786n = 3;
            this.f2773a = 16;
            if (z) {
                j = -j;
            }
            return j;
        } else if (d == '}') {
            int i4 = i2 + 1;
            char d3 = mo11268d(this.f2777e + i2);
            if (d3 == ',') {
                this.f2773a = 16;
                this.f2777e += i4;
                this.f2776d = mo11268d(this.f2777e);
            } else if (d3 == ']') {
                this.f2773a = 15;
                this.f2777e += i4;
                this.f2776d = mo11268d(this.f2777e);
            } else if (d3 == '}') {
                this.f2773a = 13;
                this.f2777e += i4;
                this.f2776d = mo11268d(this.f2777e);
            } else if (d3 == 26) {
                this.f2773a = 20;
                this.f2777e += i4 - 1;
                this.f2776d = 26;
            } else {
                this.f2786n = -1;
                return 0;
            }
            this.f2786n = 4;
            if (z) {
                j = -j;
            }
            return j;
        } else {
            this.f2786n = -1;
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:70:0x0122  */
    /* renamed from: b */
    public long mo11213b(char r21) {
        /*
        r20 = this;
        r0 = r20
        r1 = 0
        r0.f2786n = r1
        int r2 = r0.f2777e
        int r2 = r2 + r1
        char r2 = r0.mo11268d(r2)
        r3 = 34
        r4 = 1
        if (r2 != r3) goto L_0x0013
        r5 = 1
        goto L_0x0014
    L_0x0013:
        r5 = 0
    L_0x0014:
        r6 = 2
        if (r5 == 0) goto L_0x0020
        int r2 = r0.f2777e
        int r2 = r2 + r4
        char r2 = r0.mo11268d(r2)
        r7 = 2
        goto L_0x0021
    L_0x0020:
        r7 = 1
    L_0x0021:
        r8 = 45
        if (r2 != r8) goto L_0x0027
        r8 = 1
        goto L_0x0028
    L_0x0027:
        r8 = 0
    L_0x0028:
        if (r8 == 0) goto L_0x0034
        int r2 = r0.f2777e
        int r9 = r7 + 1
        int r2 = r2 + r7
        char r2 = r0.mo11268d(r2)
        r7 = r9
    L_0x0034:
        r9 = 16
        r10 = 3
        r11 = 48
        r12 = -1
        r13 = 0
        if (r2 < r11) goto L_0x00cb
        r15 = 57
        if (r2 > r15) goto L_0x00cb
        int r2 = r2 - r11
        long r1 = (long) r2
    L_0x0044:
        int r6 = r0.f2777e
        int r17 = r7 + 1
        int r6 = r6 + r7
        char r6 = r0.mo11268d(r6)
        if (r6 < r11) goto L_0x005c
        if (r6 > r15) goto L_0x005c
        r18 = 10
        long r1 = r1 * r18
        int r6 = r6 + -48
        long r6 = (long) r6
        long r1 = r1 + r6
        r7 = r17
        goto L_0x0044
    L_0x005c:
        r7 = 46
        if (r6 != r7) goto L_0x0063
        r0.f2786n = r12
        return r13
    L_0x0063:
        int r7 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1))
        if (r7 >= 0) goto L_0x0073
        r18 = -9223372036854775808
        int r7 = (r1 > r18 ? 1 : (r1 == r18 ? 0 : -1))
        if (r7 != 0) goto L_0x0070
        if (r8 == 0) goto L_0x0070
        goto L_0x0073
    L_0x0070:
        r16 = 0
        goto L_0x0075
    L_0x0073:
        r16 = 1
    L_0x0075:
        if (r16 == 0) goto L_0x00bd
        if (r5 == 0) goto L_0x008d
        if (r6 == r3) goto L_0x007e
        r0.f2786n = r12
        return r13
    L_0x007e:
        int r3 = r0.f2777e
        int r4 = r17 + 1
        int r3 = r3 + r17
        char r6 = r0.mo11268d(r3)
        r3 = r21
        r17 = r4
        goto L_0x008f
    L_0x008d:
        r3 = r21
    L_0x008f:
        if (r6 != r3) goto L_0x00a7
        int r3 = r0.f2777e
        int r3 = r3 + r17
        r0.f2777e = r3
        int r3 = r0.f2777e
        char r3 = r0.mo11268d(r3)
        r0.f2776d = r3
        r0.f2786n = r10
        r0.f2773a = r9
        if (r8 == 0) goto L_0x00a6
        long r1 = -r1
    L_0x00a6:
        return r1
    L_0x00a7:
        boolean r4 = m2776j(r6)
        if (r4 == 0) goto L_0x00ba
        int r4 = r0.f2777e
        int r5 = r17 + 1
        int r4 = r4 + r17
        char r6 = r0.mo11268d(r4)
        r17 = r5
        goto L_0x008f
    L_0x00ba:
        r0.f2786n = r12
        return r1
    L_0x00bd:
        int r1 = r0.f2777e
        int r2 = r17 + -1
        java.lang.String r1 = r0.mo11258a(r1, r2)
        java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
        r2.<init>(r1)
        throw r2
    L_0x00cb:
        r1 = 110(0x6e, float:1.54E-43)
        if (r2 != r1) goto L_0x014d
        int r1 = r0.f2777e
        int r1 = r1 + r7
        char r1 = r0.mo11268d(r1)
        r2 = 117(0x75, float:1.64E-43)
        if (r1 != r2) goto L_0x014d
        int r1 = r0.f2777e
        int r1 = r1 + r7
        int r1 = r1 + r4
        char r1 = r0.mo11268d(r1)
        r2 = 108(0x6c, float:1.51E-43)
        if (r1 != r2) goto L_0x014d
        int r1 = r0.f2777e
        int r1 = r1 + r7
        int r1 = r1 + r6
        char r1 = r0.mo11268d(r1)
        if (r1 != r2) goto L_0x014d
        r1 = 5
        r0.f2786n = r1
        int r7 = r7 + r10
        int r2 = r0.f2777e
        int r4 = r7 + 1
        int r2 = r2 + r7
        char r2 = r0.mo11268d(r2)
        if (r5 == 0) goto L_0x010b
        if (r2 != r3) goto L_0x010b
        int r2 = r0.f2777e
        int r3 = r4 + 1
        int r2 = r2 + r4
        char r2 = r0.mo11268d(r2)
        goto L_0x010c
    L_0x010b:
        r3 = r4
    L_0x010c:
        r4 = 44
        if (r2 != r4) goto L_0x0122
        int r2 = r0.f2777e
        int r2 = r2 + r3
        r0.f2777e = r2
        int r2 = r0.f2777e
        char r2 = r0.mo11268d(r2)
        r0.f2776d = r2
        r0.f2786n = r1
        r0.f2773a = r9
        return r13
    L_0x0122:
        r4 = 93
        if (r2 != r4) goto L_0x013a
        int r2 = r0.f2777e
        int r2 = r2 + r3
        r0.f2777e = r2
        int r2 = r0.f2777e
        char r2 = r0.mo11268d(r2)
        r0.f2776d = r2
        r0.f2786n = r1
        r1 = 15
        r0.f2773a = r1
        return r13
    L_0x013a:
        boolean r2 = m2776j(r2)
        if (r2 == 0) goto L_0x014a
        int r2 = r0.f2777e
        int r4 = r3 + 1
        int r2 = r2 + r3
        char r2 = r0.mo11268d(r2)
        goto L_0x010b
    L_0x014a:
        r0.f2786n = r12
        return r13
    L_0x014d:
        r0.f2786n = r12
        return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.mo11213b(char):long");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Regions count limit reached
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:689)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:694)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:694)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:30)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
        	at jadx.core.ProcessClass.process(ProcessClass.java:35)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        */
    /* renamed from: h */
    public final float mo11273h(char[] r20) {
        /*
        r19 = this;
        r0 = r19
        r1 = r20
        r2 = 0
        r0.f2786n = r2
        boolean r3 = r19.mo11282o(r20)
        r4 = 0
        if (r3 != 0) goto L_0x0012
        r1 = -2
        r0.f2786n = r1
        return r4
    L_0x0012:
        int r3 = r1.length
        int r5 = r0.f2777e
        int r6 = r3 + 1
        int r5 = r5 + r3
        char r3 = r0.mo11268d(r5)
        r5 = 34
        r7 = 1
        if (r3 != r5) goto L_0x0023
        r8 = 1
        goto L_0x0024
    L_0x0023:
        r8 = 0
    L_0x0024:
        if (r8 == 0) goto L_0x0030
        int r3 = r0.f2777e
        int r9 = r6 + 1
        int r3 = r3 + r6
        char r3 = r0.mo11268d(r3)
        r6 = r9
    L_0x0030:
        r9 = 45
        if (r3 != r9) goto L_0x0036
        r10 = 1
        goto L_0x0037
    L_0x0036:
        r10 = 0
    L_0x0037:
        if (r10 == 0) goto L_0x0043
        int r3 = r0.f2777e
        int r11 = r6 + 1
        int r3 = r3 + r6
        char r3 = r0.mo11268d(r3)
        r6 = r11
    L_0x0043:
        r14 = -1
        r15 = 48
        if (r3 < r15) goto L_0x019e
        r2 = 57
        if (r3 > r2) goto L_0x019e
        int r3 = r3 - r15
    L_0x004d:
        int r12 = r0.f2777e
        int r17 = r6 + 1
        int r12 = r12 + r6
        char r6 = r0.mo11268d(r12)
        if (r6 < r15) goto L_0x0062
        if (r6 > r2) goto L_0x0062
        int r3 = r3 * 10
        int r6 = r6 + -48
        int r3 = r3 + r6
        r6 = r17
        goto L_0x004d
    L_0x0062:
        r12 = 46
        if (r6 != r12) goto L_0x0068
        r12 = 1
        goto L_0x0069
    L_0x0068:
        r12 = 0
    L_0x0069:
        if (r12 == 0) goto L_0x009f
        int r6 = r0.f2777e
        int r12 = r17 + 1
        int r6 = r6 + r17
        char r6 = r0.mo11268d(r6)
        if (r6 < r15) goto L_0x009c
        if (r6 > r2) goto L_0x009c
        int r3 = r3 * 10
        int r6 = r6 - r15
        int r3 = r3 + r6
        r6 = 10
    L_0x007f:
        int r11 = r0.f2777e
        int r17 = r12 + 1
        int r11 = r11 + r12
        char r11 = r0.mo11268d(r11)
        if (r11 < r15) goto L_0x0096
        if (r11 > r2) goto L_0x0096
        int r3 = r3 * 10
        int r11 = r11 + -48
        int r3 = r3 + r11
        int r6 = r6 * 10
        r12 = r17
        goto L_0x007f
    L_0x0096:
        r18 = r11
        r11 = r6
        r6 = r18
        goto L_0x00a0
    L_0x009c:
        r0.f2786n = r14
        return r4
    L_0x009f:
        r11 = 1
    L_0x00a0:
        r12 = 101(0x65, float:1.42E-43)
        if (r6 == r12) goto L_0x00ac
        r12 = 69
        if (r6 != r12) goto L_0x00a9
        goto L_0x00ac
    L_0x00a9:
        r16 = 0
        goto L_0x00ae
    L_0x00ac:
        r16 = 1
    L_0x00ae:
        if (r16 == 0) goto L_0x00de
        int r6 = r0.f2777e
        int r12 = r17 + 1
        int r6 = r6 + r17
        char r6 = r0.mo11268d(r6)
        r13 = 43
        if (r6 == r13) goto L_0x00c4
        if (r6 != r9) goto L_0x00c1
        goto L_0x00c4
    L_0x00c1:
        r17 = r12
        goto L_0x00cf
    L_0x00c4:
        int r6 = r0.f2777e
        int r9 = r12 + 1
        int r6 = r6 + r12
        char r6 = r0.mo11268d(r6)
    L_0x00cd:
        r17 = r9
    L_0x00cf:
        if (r6 < r15) goto L_0x00de
        if (r6 > r2) goto L_0x00de
        int r6 = r0.f2777e
        int r9 = r17 + 1
        int r6 = r6 + r17
        char r6 = r0.mo11268d(r6)
        goto L_0x00cd
    L_0x00de:
        if (r8 == 0) goto L_0x00fb
        if (r6 == r5) goto L_0x00e5
        r0.f2786n = r14
        return r4
    L_0x00e5:
        int r2 = r0.f2777e
        int r5 = r17 + 1
        int r2 = r2 + r17
        char r6 = r0.mo11268d(r2)
        int r2 = r0.f2777e
        int r1 = r1.length
        int r1 = r1 + r2
        int r1 = r1 + r7
        int r2 = r2 + r5
        int r2 = r2 - r1
        int r2 = r2 + -2
        r17 = r5
        goto L_0x0103
    L_0x00fb:
        int r2 = r0.f2777e
        int r1 = r1.length
        int r1 = r1 + r2
        int r2 = r2 + r17
        int r2 = r2 - r1
        int r2 = r2 - r7
    L_0x0103:
        if (r16 != 0) goto L_0x0110
        r5 = 20
        if (r2 >= r5) goto L_0x0110
        float r1 = (float) r3
        float r2 = (float) r11
        float r1 = r1 / r2
        if (r10 == 0) goto L_0x0118
        float r1 = -r1
        goto L_0x0118
    L_0x0110:
        java.lang.String r1 = r0.mo11258a(r1, r2)
        float r1 = java.lang.Float.parseFloat(r1)
    L_0x0118:
        r2 = 44
        if (r6 != r2) goto L_0x0132
        int r2 = r0.f2777e
        int r2 = r2 + r17
        r0.f2777e = r2
        int r2 = r0.f2777e
        char r2 = r0.mo11268d(r2)
        r0.f2776d = r2
        r2 = 3
        r0.f2786n = r2
        r2 = 16
        r0.f2773a = r2
        return r1
    L_0x0132:
        r2 = 16
        r3 = 125(0x7d, float:1.75E-43)
        if (r6 != r3) goto L_0x019b
        int r3 = r0.f2777e
        int r5 = r17 + 1
        int r3 = r3 + r17
        char r3 = r0.mo11268d(r3)
        r6 = 44
        if (r3 != r6) goto L_0x0156
        r0.f2773a = r2
        int r2 = r0.f2777e
        int r2 = r2 + r5
        r0.f2777e = r2
        int r2 = r0.f2777e
        char r2 = r0.mo11268d(r2)
        r0.f2776d = r2
        goto L_0x0194
    L_0x0156:
        r2 = 93
        if (r3 != r2) goto L_0x016c
        r2 = 15
        r0.f2773a = r2
        int r2 = r0.f2777e
        int r2 = r2 + r5
        r0.f2777e = r2
        int r2 = r0.f2777e
        char r2 = r0.mo11268d(r2)
        r0.f2776d = r2
        goto L_0x0194
    L_0x016c:
        r2 = 125(0x7d, float:1.75E-43)
        if (r3 != r2) goto L_0x0182
        r2 = 13
        r0.f2773a = r2
        int r2 = r0.f2777e
        int r2 = r2 + r5
        r0.f2777e = r2
        int r2 = r0.f2777e
        char r2 = r0.mo11268d(r2)
        r0.f2776d = r2
        goto L_0x0194
    L_0x0182:
        r2 = 26
        if (r3 != r2) goto L_0x0198
        int r2 = r0.f2777e
        int r5 = r5 - r7
        int r2 = r2 + r5
        r0.f2777e = r2
        r2 = 20
        r0.f2773a = r2
        r2 = 26
        r0.f2776d = r2
    L_0x0194:
        r2 = 4
        r0.f2786n = r2
        return r1
    L_0x0198:
        r0.f2786n = r14
        return r4
    L_0x019b:
        r0.f2786n = r14
        return r4
    L_0x019e:
        r1 = 110(0x6e, float:1.54E-43)
        if (r3 != r1) goto L_0x0226
        int r1 = r0.f2777e
        int r1 = r1 + r6
        char r1 = r0.mo11268d(r1)
        r2 = 117(0x75, float:1.64E-43)
        if (r1 != r2) goto L_0x0226
        int r1 = r0.f2777e
        int r1 = r1 + r6
        int r1 = r1 + r7
        char r1 = r0.mo11268d(r1)
        r2 = 108(0x6c, float:1.51E-43)
        if (r1 != r2) goto L_0x0226
        int r1 = r0.f2777e
        int r1 = r1 + r6
        int r1 = r1 + 2
        char r1 = r0.mo11268d(r1)
        if (r1 != r2) goto L_0x0226
        r1 = 5
        r0.f2786n = r1
        int r6 = r6 + 3
        int r2 = r0.f2777e
        int r3 = r6 + 1
        int r2 = r2 + r6
        char r2 = r0.mo11268d(r2)
        if (r8 == 0) goto L_0x01e0
        if (r2 != r5) goto L_0x01e0
        int r2 = r0.f2777e
        int r5 = r3 + 1
        int r2 = r2 + r3
        char r2 = r0.mo11268d(r2)
        r3 = r5
    L_0x01e0:
        r5 = 44
    L_0x01e2:
        if (r2 != r5) goto L_0x01f8
        int r2 = r0.f2777e
        int r2 = r2 + r3
        r0.f2777e = r2
        int r2 = r0.f2777e
        char r2 = r0.mo11268d(r2)
        r0.f2776d = r2
        r0.f2786n = r1
        r6 = 16
        r0.f2773a = r6
        return r4
    L_0x01f8:
        r6 = 16
        r7 = 125(0x7d, float:1.75E-43)
        if (r2 != r7) goto L_0x0212
        int r2 = r0.f2777e
        int r2 = r2 + r3
        r0.f2777e = r2
        int r2 = r0.f2777e
        char r2 = r0.mo11268d(r2)
        r0.f2776d = r2
        r0.f2786n = r1
        r1 = 13
        r0.f2773a = r1
        return r4
    L_0x0212:
        boolean r2 = m2776j(r2)
        if (r2 == 0) goto L_0x0223
        int r2 = r0.f2777e
        int r8 = r3 + 1
        int r2 = r2 + r3
        char r2 = r0.mo11268d(r2)
        r3 = r8
        goto L_0x01e2
    L_0x0223:
        r0.f2786n = r14
        return r4
    L_0x0226:
        r0.f2786n = r14
        return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.mo11273h(char[]):float");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Regions count limit reached
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:689)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:694)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:30)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
        	at jadx.core.ProcessClass.process(ProcessClass.java:35)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        */
    /* renamed from: c */
    public final float mo11217c(char r23) {
        /*
        r22 = this;
        r0 = r22
        r1 = 0
        r0.f2786n = r1
        int r2 = r0.f2777e
        int r2 = r2 + r1
        char r2 = r0.mo11268d(r2)
        r3 = 34
        r4 = 1
        if (r2 != r3) goto L_0x0013
        r5 = 1
        goto L_0x0014
    L_0x0013:
        r5 = 0
    L_0x0014:
        if (r5 == 0) goto L_0x001f
        int r2 = r0.f2777e
        int r2 = r2 + r4
        char r2 = r0.mo11268d(r2)
        r7 = 2
        goto L_0x0020
    L_0x001f:
        r7 = 1
    L_0x0020:
        r8 = 45
        if (r2 != r8) goto L_0x0026
        r9 = 1
        goto L_0x0027
    L_0x0026:
        r9 = 0
    L_0x0027:
        if (r9 == 0) goto L_0x0033
        int r2 = r0.f2777e
        int r10 = r7 + 1
        int r2 = r2 + r7
        char r2 = r0.mo11268d(r2)
        r7 = r10
    L_0x0033:
        r12 = 0
        r13 = -1
        r14 = 48
        if (r2 < r14) goto L_0x012b
        r15 = 57
        if (r2 > r15) goto L_0x012b
        int r2 = r2 - r14
        long r1 = (long) r2
    L_0x003f:
        int r10 = r0.f2777e
        int r17 = r7 + 1
        int r10 = r10 + r7
        char r7 = r0.mo11268d(r10)
        r18 = 10
        if (r7 < r14) goto L_0x0057
        if (r7 > r15) goto L_0x0057
        long r1 = r1 * r18
        int r7 = r7 + -48
        long r6 = (long) r7
        long r1 = r1 + r6
        r7 = r17
        goto L_0x003f
    L_0x0057:
        r20 = 1
        r6 = 46
        if (r7 != r6) goto L_0x005f
        r6 = 1
        goto L_0x0060
    L_0x005f:
        r6 = 0
    L_0x0060:
        if (r6 == 0) goto L_0x0094
        int r6 = r0.f2777e
        int r7 = r17 + 1
        int r6 = r6 + r17
        char r6 = r0.mo11268d(r6)
        if (r6 < r14) goto L_0x0091
        if (r6 > r15) goto L_0x0091
        long r1 = r1 * r18
        int r6 = r6 - r14
        long r10 = (long) r6
        long r1 = r1 + r10
        r20 = r18
    L_0x0077:
        int r6 = r0.f2777e
        int r10 = r7 + 1
        int r6 = r6 + r7
        char r7 = r0.mo11268d(r6)
        if (r7 < r14) goto L_0x008e
        if (r7 > r15) goto L_0x008e
        long r1 = r1 * r18
        int r7 = r7 + -48
        long r6 = (long) r7
        long r1 = r1 + r6
        long r20 = r20 * r18
        r7 = r10
        goto L_0x0077
    L_0x008e:
        r17 = r10
        goto L_0x0094
    L_0x0091:
        r0.f2786n = r13
        return r12
    L_0x0094:
        r10 = r20
        r6 = 101(0x65, float:1.42E-43)
        if (r7 == r6) goto L_0x00a2
        r6 = 69
        if (r7 != r6) goto L_0x009f
        goto L_0x00a2
    L_0x009f:
        r16 = 0
        goto L_0x00a4
    L_0x00a2:
        r16 = 1
    L_0x00a4:
        if (r16 == 0) goto L_0x00d6
        int r6 = r0.f2777e
        int r7 = r17 + 1
        int r6 = r6 + r17
        char r6 = r0.mo11268d(r6)
        r4 = 43
        if (r6 == r4) goto L_0x00bb
        if (r6 != r8) goto L_0x00b7
        goto L_0x00bb
    L_0x00b7:
        r17 = r7
        r7 = r6
        goto L_0x00c7
    L_0x00bb:
        int r4 = r0.f2777e
        int r6 = r7 + 1
        int r4 = r4 + r7
        char r4 = r0.mo11268d(r4)
        r7 = r4
    L_0x00c5:
        r17 = r6
    L_0x00c7:
        if (r7 < r14) goto L_0x00d6
        if (r7 > r15) goto L_0x00d6
        int r4 = r0.f2777e
        int r6 = r17 + 1
        int r4 = r4 + r17
        char r7 = r0.mo11268d(r4)
        goto L_0x00c5
    L_0x00d6:
        if (r5 == 0) goto L_0x00f2
        if (r7 == r3) goto L_0x00dd
        r0.f2786n = r13
        return r12
    L_0x00dd:
        int r3 = r0.f2777e
        int r4 = r17 + 1
        int r3 = r3 + r17
        char r7 = r0.mo11268d(r3)
        int r3 = r0.f2777e
        int r5 = r3 + 1
        int r3 = r3 + r4
        int r3 = r3 - r5
        r6 = 2
        int r3 = r3 - r6
        r17 = r4
        goto L_0x00f9
    L_0x00f2:
        int r5 = r0.f2777e
        int r3 = r5 + r17
        int r3 = r3 - r5
        r4 = 1
        int r3 = r3 - r4
    L_0x00f9:
        if (r16 != 0) goto L_0x0106
        r4 = 20
        if (r3 >= r4) goto L_0x0106
        float r1 = (float) r1
        float r2 = (float) r10
        float r1 = r1 / r2
        if (r9 == 0) goto L_0x010e
        float r1 = -r1
        goto L_0x010e
    L_0x0106:
        java.lang.String r1 = r0.mo11258a(r5, r3)
        float r1 = java.lang.Float.parseFloat(r1)
    L_0x010e:
        r2 = r23
        if (r7 != r2) goto L_0x0128
        int r2 = r0.f2777e
        int r2 = r2 + r17
        r0.f2777e = r2
        int r2 = r0.f2777e
        char r2 = r0.mo11268d(r2)
        r0.f2776d = r2
        r2 = 3
        r0.f2786n = r2
        r2 = 16
        r0.f2773a = r2
        return r1
    L_0x0128:
        r0.f2786n = r13
        return r1
    L_0x012b:
        r1 = 110(0x6e, float:1.54E-43)
        if (r2 != r1) goto L_0x01b5
        int r1 = r0.f2777e
        int r1 = r1 + r7
        char r1 = r0.mo11268d(r1)
        r2 = 117(0x75, float:1.64E-43)
        if (r1 != r2) goto L_0x01b5
        int r1 = r0.f2777e
        int r1 = r1 + r7
        r2 = 1
        int r1 = r1 + r2
        char r1 = r0.mo11268d(r1)
        r2 = 108(0x6c, float:1.51E-43)
        if (r1 != r2) goto L_0x01b5
        int r1 = r0.f2777e
        int r1 = r1 + r7
        r4 = 2
        int r1 = r1 + r4
        char r1 = r0.mo11268d(r1)
        if (r1 != r2) goto L_0x01b5
        r1 = 5
        r0.f2786n = r1
        r2 = 3
        int r7 = r7 + r2
        int r2 = r0.f2777e
        int r4 = r7 + 1
        int r2 = r2 + r7
        char r2 = r0.mo11268d(r2)
        if (r5 == 0) goto L_0x016e
        if (r2 != r3) goto L_0x016e
        int r2 = r0.f2777e
        int r3 = r4 + 1
        int r2 = r2 + r4
        char r2 = r0.mo11268d(r2)
        goto L_0x016f
    L_0x016e:
        r3 = r4
    L_0x016f:
        r4 = 44
        if (r2 != r4) goto L_0x0187
        int r2 = r0.f2777e
        int r2 = r2 + r3
        r0.f2777e = r2
        int r2 = r0.f2777e
        char r2 = r0.mo11268d(r2)
        r0.f2776d = r2
        r0.f2786n = r1
        r4 = 16
        r0.f2773a = r4
        return r12
    L_0x0187:
        r4 = 16
        r5 = 93
        if (r2 != r5) goto L_0x01a1
        int r2 = r0.f2777e
        int r2 = r2 + r3
        r0.f2777e = r2
        int r2 = r0.f2777e
        char r2 = r0.mo11268d(r2)
        r0.f2776d = r2
        r0.f2786n = r1
        r1 = 15
        r0.f2773a = r1
        return r12
    L_0x01a1:
        boolean r2 = m2776j(r2)
        if (r2 == 0) goto L_0x01b2
        int r2 = r0.f2777e
        int r5 = r3 + 1
        int r2 = r2 + r3
        char r2 = r0.mo11268d(r2)
        r3 = r5
        goto L_0x016f
    L_0x01b2:
        r0.f2786n = r13
        return r12
    L_0x01b5:
        r0.f2786n = r13
        return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.mo11217c(char):float");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Regions count limit reached
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:689)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:694)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:30)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
        	at jadx.core.ProcessClass.process(ProcessClass.java:35)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        */
    /* renamed from: d */
    public double mo11221d(char r24) {
        /*
        r23 = this;
        r0 = r23
        r1 = 0
        r0.f2786n = r1
        int r2 = r0.f2777e
        int r2 = r2 + r1
        char r2 = r0.mo11268d(r2)
        r3 = 34
        r4 = 1
        if (r2 != r3) goto L_0x0013
        r5 = 1
        goto L_0x0014
    L_0x0013:
        r5 = 0
    L_0x0014:
        if (r5 == 0) goto L_0x001f
        int r2 = r0.f2777e
        int r2 = r2 + r4
        char r2 = r0.mo11268d(r2)
        r7 = 2
        goto L_0x0020
    L_0x001f:
        r7 = 1
    L_0x0020:
        r8 = 45
        if (r2 != r8) goto L_0x0026
        r9 = 1
        goto L_0x0027
    L_0x0026:
        r9 = 0
    L_0x0027:
        if (r9 == 0) goto L_0x0033
        int r2 = r0.f2777e
        int r10 = r7 + 1
        int r2 = r2 + r7
        char r2 = r0.mo11268d(r2)
        r7 = r10
    L_0x0033:
        r12 = 0
        r14 = -1
        r15 = 48
        if (r2 < r15) goto L_0x013c
        r1 = 57
        if (r2 > r1) goto L_0x013c
        int r2 = r2 - r15
        long r10 = (long) r2
    L_0x0040:
        int r2 = r0.f2777e
        int r17 = r7 + 1
        int r2 = r2 + r7
        char r2 = r0.mo11268d(r2)
        r18 = 10
        if (r2 < r15) goto L_0x0058
        if (r2 > r1) goto L_0x0058
        long r10 = r10 * r18
        int r2 = r2 + -48
        long r6 = (long) r2
        long r10 = r10 + r6
        r7 = r17
        goto L_0x0040
    L_0x0058:
        r6 = 46
        if (r2 != r6) goto L_0x005e
        r6 = 1
        goto L_0x005f
    L_0x005e:
        r6 = 0
    L_0x005f:
        if (r6 == 0) goto L_0x00a0
        int r2 = r0.f2777e
        int r6 = r17 + 1
        int r2 = r2 + r17
        char r2 = r0.mo11268d(r2)
        if (r2 < r15) goto L_0x009d
        if (r2 > r1) goto L_0x009d
        long r10 = r10 * r18
        int r2 = r2 - r15
        long r3 = (long) r2
        long r10 = r10 + r3
        r2 = r18
    L_0x0076:
        int r4 = r0.f2777e
        int r7 = r6 + 1
        int r4 = r4 + r6
        char r4 = r0.mo11268d(r4)
        if (r4 < r15) goto L_0x0093
        if (r4 > r1) goto L_0x0093
        long r10 = r10 * r18
        int r4 = r4 + -48
        r20 = r9
        long r8 = (long) r4
        long r10 = r10 + r8
        long r2 = r2 * r18
        r6 = r7
        r9 = r20
        r8 = 45
        goto L_0x0076
    L_0x0093:
        r20 = r9
        r17 = r7
        r21 = r2
        r2 = r4
        r3 = r21
        goto L_0x00a4
    L_0x009d:
        r0.f2786n = r14
        return r12
    L_0x00a0:
        r20 = r9
        r3 = 1
    L_0x00a4:
        r7 = 101(0x65, float:1.42E-43)
        if (r2 == r7) goto L_0x00b0
        r7 = 69
        if (r2 != r7) goto L_0x00ad
        goto L_0x00b0
    L_0x00ad:
        r16 = 0
        goto L_0x00b2
    L_0x00b0:
        r16 = 1
    L_0x00b2:
        if (r16 == 0) goto L_0x00e4
        int r2 = r0.f2777e
        int r7 = r17 + 1
        int r2 = r2 + r17
        char r2 = r0.mo11268d(r2)
        r8 = 43
        if (r2 == r8) goto L_0x00ca
        r6 = 45
        if (r2 != r6) goto L_0x00c7
        goto L_0x00ca
    L_0x00c7:
        r17 = r7
        goto L_0x00d5
    L_0x00ca:
        int r2 = r0.f2777e
        int r6 = r7 + 1
        int r2 = r2 + r7
        char r2 = r0.mo11268d(r2)
    L_0x00d3:
        r17 = r6
    L_0x00d5:
        if (r2 < r15) goto L_0x00e4
        if (r2 > r1) goto L_0x00e4
        int r2 = r0.f2777e
        int r6 = r17 + 1
        int r2 = r2 + r17
        char r2 = r0.mo11268d(r2)
        goto L_0x00d3
    L_0x00e4:
        if (r5 == 0) goto L_0x0100
        r1 = 34
        if (r2 == r1) goto L_0x00ed
        r0.f2786n = r14
        return r12
    L_0x00ed:
        int r1 = r0.f2777e
        int r2 = r17 + 1
        int r1 = r1 + r17
        char r1 = r0.mo11268d(r1)
        int r5 = r0.f2777e
        int r6 = r5 + 1
        int r5 = r5 + r2
        int r5 = r5 - r6
        r7 = 2
        int r5 = r5 - r7
        goto L_0x010b
    L_0x0100:
        int r6 = r0.f2777e
        int r1 = r6 + r17
        int r1 = r1 - r6
        r5 = 1
        int r5 = r1 + -1
        r1 = r2
        r2 = r17
    L_0x010b:
        if (r16 != 0) goto L_0x0118
        r7 = 20
        if (r5 >= r7) goto L_0x0118
        double r5 = (double) r10
        double r3 = (double) r3
        double r5 = r5 / r3
        if (r20 == 0) goto L_0x0120
        double r5 = -r5
        goto L_0x0120
    L_0x0118:
        java.lang.String r3 = r0.mo11258a(r6, r5)
        double r5 = java.lang.Double.parseDouble(r3)
    L_0x0120:
        r3 = r24
        if (r1 != r3) goto L_0x0139
        int r1 = r0.f2777e
        int r1 = r1 + r2
        r0.f2777e = r1
        int r1 = r0.f2777e
        char r1 = r0.mo11268d(r1)
        r0.f2776d = r1
        r1 = 3
        r0.f2786n = r1
        r1 = 16
        r0.f2773a = r1
        return r5
    L_0x0139:
        r0.f2786n = r14
        return r5
    L_0x013c:
        r1 = 110(0x6e, float:1.54E-43)
        if (r2 != r1) goto L_0x01c7
        int r1 = r0.f2777e
        int r1 = r1 + r7
        char r1 = r0.mo11268d(r1)
        r2 = 117(0x75, float:1.64E-43)
        if (r1 != r2) goto L_0x01c7
        int r1 = r0.f2777e
        int r1 = r1 + r7
        r2 = 1
        int r1 = r1 + r2
        char r1 = r0.mo11268d(r1)
        r2 = 108(0x6c, float:1.51E-43)
        if (r1 != r2) goto L_0x01c7
        int r1 = r0.f2777e
        int r1 = r1 + r7
        r3 = 2
        int r1 = r1 + r3
        char r1 = r0.mo11268d(r1)
        if (r1 != r2) goto L_0x01c7
        r1 = 5
        r0.f2786n = r1
        r2 = 3
        int r7 = r7 + r2
        int r2 = r0.f2777e
        int r3 = r7 + 1
        int r2 = r2 + r7
        char r2 = r0.mo11268d(r2)
        if (r5 == 0) goto L_0x0181
        r4 = 34
        if (r2 != r4) goto L_0x0181
        int r2 = r0.f2777e
        int r4 = r3 + 1
        int r2 = r2 + r3
        char r2 = r0.mo11268d(r2)
        r3 = r4
    L_0x0181:
        r4 = 44
        if (r2 != r4) goto L_0x0199
        int r2 = r0.f2777e
        int r2 = r2 + r3
        r0.f2777e = r2
        int r2 = r0.f2777e
        char r2 = r0.mo11268d(r2)
        r0.f2776d = r2
        r0.f2786n = r1
        r4 = 16
        r0.f2773a = r4
        return r12
    L_0x0199:
        r4 = 16
        r5 = 93
        if (r2 != r5) goto L_0x01b3
        int r2 = r0.f2777e
        int r2 = r2 + r3
        r0.f2777e = r2
        int r2 = r0.f2777e
        char r2 = r0.mo11268d(r2)
        r0.f2776d = r2
        r0.f2786n = r1
        r1 = 15
        r0.f2773a = r1
        return r12
    L_0x01b3:
        boolean r2 = m2776j(r2)
        if (r2 == 0) goto L_0x01c4
        int r2 = r0.f2777e
        int r5 = r3 + 1
        int r2 = r2 + r3
        char r2 = r0.mo11268d(r2)
        r3 = r5
        goto L_0x0181
    L_0x01c4:
        r0.f2786n = r14
        return r12
    L_0x01c7:
        r0.f2786n = r14
        return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.mo11221d(char):double");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Regions count limit reached
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:689)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:694)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:30)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
        	at jadx.core.ProcessClass.process(ProcessClass.java:35)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        */
    /* renamed from: f */
    public java.math.BigDecimal mo11226f(char r18) {
        /*
        r17 = this;
        r0 = r17
        r1 = 0
        r0.f2786n = r1
        int r2 = r0.f2777e
        int r2 = r2 + r1
        char r2 = r0.mo11268d(r2)
        r3 = 34
        r4 = 1
        if (r2 != r3) goto L_0x0013
        r5 = 1
        goto L_0x0014
    L_0x0013:
        r5 = 0
    L_0x0014:
        r6 = 2
        if (r5 == 0) goto L_0x0020
        int r2 = r0.f2777e
        int r2 = r2 + r4
        char r2 = r0.mo11268d(r2)
        r7 = 2
        goto L_0x0021
    L_0x0020:
        r7 = 1
    L_0x0021:
        r8 = 45
        if (r2 != r8) goto L_0x0027
        r9 = 1
        goto L_0x0028
    L_0x0027:
        r9 = 0
    L_0x0028:
        if (r9 == 0) goto L_0x0034
        int r2 = r0.f2777e
        int r9 = r7 + 1
        int r2 = r2 + r7
        char r2 = r0.mo11268d(r2)
        r7 = r9
    L_0x0034:
        r10 = 3
        r11 = 16
        r12 = 44
        r13 = 48
        r14 = -1
        r15 = 0
        if (r2 < r13) goto L_0x0162
        r1 = 57
        if (r2 > r1) goto L_0x0162
    L_0x0043:
        int r2 = r0.f2777e
        int r16 = r7 + 1
        int r2 = r2 + r7
        char r2 = r0.mo11268d(r2)
        if (r2 < r13) goto L_0x0053
        if (r2 > r1) goto L_0x0053
        r7 = r16
        goto L_0x0043
    L_0x0053:
        r7 = 46
        if (r2 != r7) goto L_0x0059
        r7 = 1
        goto L_0x005a
    L_0x0059:
        r7 = 0
    L_0x005a:
        if (r7 == 0) goto L_0x007d
        int r2 = r0.f2777e
        int r7 = r16 + 1
        int r2 = r2 + r16
        char r2 = r0.mo11268d(r2)
        if (r2 < r13) goto L_0x007a
        if (r2 > r1) goto L_0x007a
    L_0x006a:
        int r2 = r0.f2777e
        int r16 = r7 + 1
        int r2 = r2 + r7
        char r2 = r0.mo11268d(r2)
        if (r2 < r13) goto L_0x007d
        if (r2 > r1) goto L_0x007d
        r7 = r16
        goto L_0x006a
    L_0x007a:
        r0.f2786n = r14
        return r15
    L_0x007d:
        r7 = 101(0x65, float:1.42E-43)
        if (r2 == r7) goto L_0x0088
        r7 = 69
        if (r2 != r7) goto L_0x0086
        goto L_0x0088
    L_0x0086:
        r7 = 0
        goto L_0x0089
    L_0x0088:
        r7 = 1
    L_0x0089:
        if (r7 == 0) goto L_0x00b9
        int r2 = r0.f2777e
        int r7 = r16 + 1
        int r2 = r2 + r16
        char r2 = r0.mo11268d(r2)
        r9 = 43
        if (r2 == r9) goto L_0x009f
        if (r2 != r8) goto L_0x009c
        goto L_0x009f
    L_0x009c:
        r16 = r7
        goto L_0x00aa
    L_0x009f:
        int r2 = r0.f2777e
        int r8 = r7 + 1
        int r2 = r2 + r7
        char r2 = r0.mo11268d(r2)
        r16 = r8
    L_0x00aa:
        if (r2 < r13) goto L_0x00b9
        if (r2 > r1) goto L_0x00b9
        int r2 = r0.f2777e
        int r7 = r16 + 1
        int r2 = r2 + r16
        char r2 = r0.mo11268d(r2)
        goto L_0x009c
    L_0x00b9:
        if (r5 == 0) goto L_0x00d4
        if (r2 == r3) goto L_0x00c0
        r0.f2786n = r14
        return r15
    L_0x00c0:
        int r1 = r0.f2777e
        int r2 = r16 + 1
        int r1 = r1 + r16
        char r1 = r0.mo11268d(r1)
        int r3 = r0.f2777e
        int r5 = r3 + 1
        int r3 = r3 + r2
        int r3 = r3 - r5
        int r3 = r3 - r6
        r16 = r2
        goto L_0x00dc
    L_0x00d4:
        int r5 = r0.f2777e
        int r1 = r5 + r16
        int r1 = r1 - r5
        int r3 = r1 + -1
        r1 = r2
    L_0x00dc:
        char[] r2 = r0.mo11266b(r5, r3)
        java.math.BigDecimal r3 = new java.math.BigDecimal
        r3.<init>(r2)
        if (r1 != r12) goto L_0x00fa
        int r1 = r0.f2777e
        int r1 = r1 + r16
        r0.f2777e = r1
        int r1 = r0.f2777e
        char r1 = r0.mo11268d(r1)
        r0.f2776d = r1
        r0.f2786n = r10
        r0.f2773a = r11
        return r3
    L_0x00fa:
        r2 = 93
        if (r1 != r2) goto L_0x015f
        int r1 = r0.f2777e
        int r2 = r16 + 1
        int r1 = r1 + r16
        char r1 = r0.mo11268d(r1)
        if (r1 != r12) goto L_0x011a
        r0.f2773a = r11
        int r1 = r0.f2777e
        int r1 = r1 + r2
        r0.f2777e = r1
        int r1 = r0.f2777e
        char r1 = r0.mo11268d(r1)
        r0.f2776d = r1
        goto L_0x0158
    L_0x011a:
        r5 = 93
        if (r1 != r5) goto L_0x0130
        r1 = 15
        r0.f2773a = r1
        int r1 = r0.f2777e
        int r1 = r1 + r2
        r0.f2777e = r1
        int r1 = r0.f2777e
        char r1 = r0.mo11268d(r1)
        r0.f2776d = r1
        goto L_0x0158
    L_0x0130:
        r5 = 125(0x7d, float:1.75E-43)
        if (r1 != r5) goto L_0x0146
        r1 = 13
        r0.f2773a = r1
        int r1 = r0.f2777e
        int r1 = r1 + r2
        r0.f2777e = r1
        int r1 = r0.f2777e
        char r1 = r0.mo11268d(r1)
        r0.f2776d = r1
        goto L_0x0158
    L_0x0146:
        r5 = 26
        if (r1 != r5) goto L_0x015c
        r1 = 20
        r0.f2773a = r1
        int r1 = r0.f2777e
        int r2 = r2 - r4
        int r1 = r1 + r2
        r0.f2777e = r1
        r1 = 26
        r0.f2776d = r1
    L_0x0158:
        r1 = 4
        r0.f2786n = r1
        return r3
    L_0x015c:
        r0.f2786n = r14
        return r15
    L_0x015f:
        r0.f2786n = r14
        return r15
    L_0x0162:
        r1 = 110(0x6e, float:1.54E-43)
        if (r2 != r1) goto L_0x01e3
        int r1 = r0.f2777e
        int r1 = r1 + r7
        char r1 = r0.mo11268d(r1)
        r2 = 117(0x75, float:1.64E-43)
        if (r1 != r2) goto L_0x01e3
        int r1 = r0.f2777e
        int r1 = r1 + r7
        int r1 = r1 + r4
        char r1 = r0.mo11268d(r1)
        r2 = 108(0x6c, float:1.51E-43)
        if (r1 != r2) goto L_0x01e3
        int r1 = r0.f2777e
        int r1 = r1 + r7
        int r1 = r1 + r6
        char r1 = r0.mo11268d(r1)
        if (r1 != r2) goto L_0x01e3
        r1 = 5
        r0.f2786n = r1
        int r7 = r7 + r10
        int r2 = r0.f2777e
        int r4 = r7 + 1
        int r2 = r2 + r7
        char r2 = r0.mo11268d(r2)
        if (r5 == 0) goto L_0x01a2
        if (r2 != r3) goto L_0x01a2
        int r2 = r0.f2777e
        int r3 = r4 + 1
        int r2 = r2 + r4
        char r2 = r0.mo11268d(r2)
        goto L_0x01a3
    L_0x01a2:
        r3 = r4
    L_0x01a3:
        if (r2 != r12) goto L_0x01b7
        int r2 = r0.f2777e
        int r2 = r2 + r3
        r0.f2777e = r2
        int r2 = r0.f2777e
        char r2 = r0.mo11268d(r2)
        r0.f2776d = r2
        r0.f2786n = r1
        r0.f2773a = r11
        return r15
    L_0x01b7:
        r4 = 125(0x7d, float:1.75E-43)
        if (r2 != r4) goto L_0x01cf
        int r2 = r0.f2777e
        int r2 = r2 + r3
        r0.f2777e = r2
        int r2 = r0.f2777e
        char r2 = r0.mo11268d(r2)
        r0.f2776d = r2
        r0.f2786n = r1
        r1 = 13
        r0.f2773a = r1
        return r15
    L_0x01cf:
        boolean r2 = m2776j(r2)
        if (r2 == 0) goto L_0x01e0
        int r2 = r0.f2777e
        int r5 = r3 + 1
        int r2 = r2 + r3
        char r2 = r0.mo11268d(r2)
        r3 = r5
        goto L_0x01a3
    L_0x01e0:
        r0.f2786n = r14
        return r15
    L_0x01e3:
        r0.f2786n = r14
        return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.mo11226f(char):java.math.BigDecimal");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Regions count limit reached
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:689)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:694)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:694)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:694)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:30)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
        	at jadx.core.ProcessClass.process(ProcessClass.java:35)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        */
    /* renamed from: i */
    public final float[] mo11276i(char[] r19) {
        /*
        r18 = this;
        r0 = r18
        r1 = 0
        r0.f2786n = r1
        boolean r2 = r18.mo11282o(r19)
        r3 = -2
        r4 = 0
        if (r2 != 0) goto L_0x0010
        r0.f2786n = r3
        return r4
    L_0x0010:
        r2 = r19
        int r2 = r2.length
        int r5 = r0.f2777e
        int r6 = r2 + 1
        int r5 = r5 + r2
        char r2 = r0.mo11268d(r5)
        r5 = 91
        if (r2 == r5) goto L_0x0023
        r0.f2786n = r3
        return r4
    L_0x0023:
        int r2 = r0.f2777e
        int r3 = r6 + 1
        int r2 = r2 + r6
        char r2 = r0.mo11268d(r2)
        r5 = 16
        float[] r6 = new float[r5]
        r7 = r6
        r6 = 0
    L_0x0032:
        int r8 = r0.f2777e
        int r8 = r8 + r3
        r9 = 1
        int r8 = r8 - r9
        r10 = 45
        if (r2 != r10) goto L_0x003d
        r11 = 1
        goto L_0x003e
    L_0x003d:
        r11 = 0
    L_0x003e:
        if (r11 == 0) goto L_0x004a
        int r2 = r0.f2777e
        int r12 = r3 + 1
        int r2 = r2 + r3
        char r2 = r0.mo11268d(r2)
        r3 = r12
    L_0x004a:
        r12 = -1
        r13 = 48
        if (r2 < r13) goto L_0x01b3
        r14 = 57
        if (r2 > r14) goto L_0x01b3
        int r2 = r2 + -48
    L_0x0055:
        int r15 = r0.f2777e
        int r16 = r3 + 1
        int r15 = r15 + r3
        char r3 = r0.mo11268d(r15)
        if (r3 < r13) goto L_0x006a
        if (r3 > r14) goto L_0x006a
        int r2 = r2 * 10
        int r3 = r3 + -48
        int r2 = r2 + r3
        r3 = r16
        goto L_0x0055
    L_0x006a:
        r15 = 46
        if (r3 != r15) goto L_0x0070
        r15 = 1
        goto L_0x0071
    L_0x0070:
        r15 = 0
    L_0x0071:
        r5 = 10
        if (r15 == 0) goto L_0x00a4
        int r3 = r0.f2777e
        int r15 = r16 + 1
        int r3 = r3 + r16
        char r3 = r0.mo11268d(r3)
        if (r3 < r13) goto L_0x00a1
        if (r3 > r14) goto L_0x00a1
        int r2 = r2 * 10
        int r3 = r3 + -48
        int r2 = r2 + r3
        r3 = 10
    L_0x008a:
        int r1 = r0.f2777e
        int r16 = r15 + 1
        int r1 = r1 + r15
        char r1 = r0.mo11268d(r1)
        if (r1 < r13) goto L_0x00a6
        if (r1 > r14) goto L_0x00a6
        int r2 = r2 * 10
        int r1 = r1 + -48
        int r2 = r2 + r1
        int r3 = r3 * 10
        r15 = r16
        goto L_0x008a
    L_0x00a1:
        r0.f2786n = r12
        return r4
    L_0x00a4:
        r1 = r3
        r3 = 1
    L_0x00a6:
        r15 = 101(0x65, float:1.42E-43)
        if (r1 == r15) goto L_0x00b1
        r15 = 69
        if (r1 != r15) goto L_0x00af
        goto L_0x00b1
    L_0x00af:
        r15 = 0
        goto L_0x00b2
    L_0x00b1:
        r15 = 1
    L_0x00b2:
        if (r15 == 0) goto L_0x00e3
        int r1 = r0.f2777e
        int r17 = r16 + 1
        int r1 = r1 + r16
        char r1 = r0.mo11268d(r1)
        r4 = 43
        if (r1 == r4) goto L_0x00c8
        if (r1 != r10) goto L_0x00c5
        goto L_0x00c8
    L_0x00c5:
        r16 = r17
        goto L_0x00d4
    L_0x00c8:
        int r1 = r0.f2777e
        int r4 = r17 + 1
        int r1 = r1 + r17
        char r1 = r0.mo11268d(r1)
    L_0x00d2:
        r16 = r4
    L_0x00d4:
        if (r1 < r13) goto L_0x00e3
        if (r1 > r14) goto L_0x00e3
        int r1 = r0.f2777e
        int r4 = r16 + 1
        int r1 = r1 + r16
        char r1 = r0.mo11268d(r1)
        goto L_0x00d2
    L_0x00e3:
        int r4 = r0.f2777e
        int r4 = r4 + r16
        int r4 = r4 - r8
        int r4 = r4 - r9
        if (r15 != 0) goto L_0x00f4
        if (r4 >= r5) goto L_0x00f4
        float r2 = (float) r2
        float r3 = (float) r3
        float r2 = r2 / r3
        if (r11 == 0) goto L_0x00fc
        float r2 = -r2
        goto L_0x00fc
    L_0x00f4:
        java.lang.String r2 = r0.mo11258a(r8, r4)
        float r2 = java.lang.Float.parseFloat(r2)
    L_0x00fc:
        int r3 = r7.length
        r4 = 3
        if (r6 < r3) goto L_0x010c
        int r3 = r7.length
        int r3 = r3 * 3
        int r3 = r3 / 2
        float[] r3 = new float[r3]
        r5 = 0
        java.lang.System.arraycopy(r7, r5, r3, r5, r6)
        r7 = r3
    L_0x010c:
        int r3 = r6 + 1
        r7[r6] = r2
        r2 = 44
        if (r1 != r2) goto L_0x0122
        int r1 = r0.f2777e
        int r2 = r16 + 1
        int r1 = r1 + r16
        char r1 = r0.mo11268d(r1)
        r16 = r2
        goto L_0x01a5
    L_0x0122:
        r5 = 93
        if (r1 != r5) goto L_0x01a5
        int r1 = r0.f2777e
        int r6 = r16 + 1
        int r1 = r1 + r16
        char r1 = r0.mo11268d(r1)
        int r8 = r7.length
        if (r3 == r8) goto L_0x013a
        float[] r8 = new float[r3]
        r10 = 0
        java.lang.System.arraycopy(r7, r10, r8, r10, r3)
        r7 = r8
    L_0x013a:
        if (r1 != r2) goto L_0x014c
        int r1 = r0.f2777e
        int r6 = r6 - r9
        int r1 = r1 + r6
        r0.f2777e = r1
        r18.mo11225f()
        r0.f2786n = r4
        r4 = 16
        r0.f2773a = r4
        return r7
    L_0x014c:
        r4 = 16
        r3 = 125(0x7d, float:1.75E-43)
        if (r1 != r3) goto L_0x01a1
        int r1 = r0.f2777e
        int r8 = r6 + 1
        int r1 = r1 + r6
        char r1 = r0.mo11268d(r1)
        if (r1 != r2) goto L_0x0169
        r0.f2773a = r4
        int r1 = r0.f2777e
        int r8 = r8 - r9
        int r1 = r1 + r8
        r0.f2777e = r1
        r18.mo11225f()
        goto L_0x0199
    L_0x0169:
        if (r1 != r5) goto L_0x0179
        r1 = 15
        r0.f2773a = r1
        int r1 = r0.f2777e
        int r8 = r8 - r9
        int r1 = r1 + r8
        r0.f2777e = r1
        r18.mo11225f()
        goto L_0x0199
    L_0x0179:
        if (r1 != r3) goto L_0x0189
        r1 = 13
        r0.f2773a = r1
        int r1 = r0.f2777e
        int r8 = r8 - r9
        int r1 = r1 + r8
        r0.f2777e = r1
        r18.mo11225f()
        goto L_0x0199
    L_0x0189:
        r2 = 26
        if (r1 != r2) goto L_0x019d
        int r1 = r0.f2777e
        int r8 = r8 - r9
        int r1 = r1 + r8
        r0.f2777e = r1
        r1 = 20
        r0.f2773a = r1
        r0.f2776d = r2
    L_0x0199:
        r1 = 4
        r0.f2786n = r1
        return r7
    L_0x019d:
        r0.f2786n = r12
        r2 = 0
        return r2
    L_0x01a1:
        r2 = 0
        r0.f2786n = r12
        return r2
    L_0x01a5:
        r2 = 0
        r4 = 16
        r10 = 0
        r4 = r2
        r6 = r3
        r3 = r16
        r5 = 16
        r2 = r1
        r1 = 0
        goto L_0x0032
    L_0x01b3:
        r2 = r4
        r0.f2786n = r12
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.mo11276i(char[]):float[]");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Regions count limit reached
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:689)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:694)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:689)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:694)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:694)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:30)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
        	at jadx.core.ProcessClass.process(ProcessClass.java:35)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        */
    /* renamed from: j */
    public final float[][] mo11277j(char[] r20) {
        /*
        r19 = this;
        r0 = r19
        r1 = 0
        r0.f2786n = r1
        boolean r2 = r19.mo11282o(r20)
        r3 = -2
        r4 = 0
        if (r2 != 0) goto L_0x0012
        r0.f2786n = r3
        float[][] r4 = (float[][]) r4
        return r4
    L_0x0012:
        r2 = r20
        int r2 = r2.length
        int r5 = r0.f2777e
        int r6 = r2 + 1
        int r5 = r5 + r2
        char r2 = r0.mo11268d(r5)
        r5 = 91
        if (r2 == r5) goto L_0x0027
        r0.f2786n = r3
        float[][] r4 = (float[][]) r4
        return r4
    L_0x0027:
        int r2 = r0.f2777e
        int r3 = r6 + 1
        int r2 = r2 + r6
        char r2 = r0.mo11268d(r2)
        r6 = 16
        float[][] r7 = new float[r6][]
        r8 = 0
    L_0x0035:
        if (r2 != r5) goto L_0x0227
        int r2 = r0.f2777e
        int r9 = r3 + 1
        int r2 = r2 + r3
        char r2 = r0.mo11268d(r2)
        float[] r3 = new float[r6]
        r10 = 0
    L_0x0043:
        int r11 = r0.f2777e
        int r11 = r11 + r9
        r12 = 1
        int r11 = r11 - r12
        r13 = 45
        if (r2 != r13) goto L_0x004e
        r14 = 1
        goto L_0x004f
    L_0x004e:
        r14 = 0
    L_0x004f:
        if (r14 == 0) goto L_0x005b
        int r2 = r0.f2777e
        int r15 = r9 + 1
        int r2 = r2 + r9
        char r2 = r0.mo11268d(r2)
        goto L_0x005c
    L_0x005b:
        r15 = r9
    L_0x005c:
        r9 = -1
        r5 = 48
        if (r2 < r5) goto L_0x0220
        r6 = 57
        if (r2 > r6) goto L_0x0220
        int r2 = r2 + -48
    L_0x0067:
        int r1 = r0.f2777e
        int r16 = r15 + 1
        int r1 = r1 + r15
        char r1 = r0.mo11268d(r1)
        if (r1 < r5) goto L_0x007c
        if (r1 > r6) goto L_0x007c
        int r2 = r2 * 10
        int r1 = r1 + -48
        int r2 = r2 + r1
        r15 = r16
        goto L_0x0067
    L_0x007c:
        r15 = 46
        if (r1 != r15) goto L_0x00b7
        int r1 = r0.f2777e
        int r15 = r16 + 1
        int r1 = r1 + r16
        char r1 = r0.mo11268d(r1)
        if (r1 < r5) goto L_0x00b2
        if (r1 > r6) goto L_0x00b2
        int r2 = r2 * 10
        int r1 = r1 + -48
        int r2 = r2 + r1
        r1 = 10
    L_0x0095:
        int r12 = r0.f2777e
        int r16 = r15 + 1
        int r12 = r12 + r15
        char r12 = r0.mo11268d(r12)
        if (r12 < r5) goto L_0x00ac
        if (r12 > r6) goto L_0x00ac
        int r2 = r2 * 10
        int r12 = r12 + -48
        int r2 = r2 + r12
        int r1 = r1 * 10
        r15 = r16
        goto L_0x0095
    L_0x00ac:
        r18 = r12
        r12 = r1
        r1 = r18
        goto L_0x00b8
    L_0x00b2:
        r0.f2786n = r9
        float[][] r4 = (float[][]) r4
        return r4
    L_0x00b7:
        r12 = 1
    L_0x00b8:
        r15 = 101(0x65, float:1.42E-43)
        if (r1 == r15) goto L_0x00c3
        r15 = 69
        if (r1 != r15) goto L_0x00c1
        goto L_0x00c3
    L_0x00c1:
        r15 = 0
        goto L_0x00c4
    L_0x00c3:
        r15 = 1
    L_0x00c4:
        if (r15 == 0) goto L_0x00f5
        int r1 = r0.f2777e
        int r17 = r16 + 1
        int r1 = r1 + r16
        char r1 = r0.mo11268d(r1)
        r4 = 43
        if (r1 == r4) goto L_0x00da
        if (r1 != r13) goto L_0x00d7
        goto L_0x00da
    L_0x00d7:
        r16 = r17
        goto L_0x00e6
    L_0x00da:
        int r1 = r0.f2777e
        int r4 = r17 + 1
        int r1 = r1 + r17
        char r1 = r0.mo11268d(r1)
    L_0x00e4:
        r16 = r4
    L_0x00e6:
        if (r1 < r5) goto L_0x00f5
        if (r1 > r6) goto L_0x00f5
        int r1 = r0.f2777e
        int r4 = r16 + 1
        int r1 = r1 + r16
        char r1 = r0.mo11268d(r1)
        goto L_0x00e4
    L_0x00f5:
        int r4 = r0.f2777e
        int r4 = r4 + r16
        int r4 = r4 - r11
        r5 = 1
        int r4 = r4 - r5
        if (r15 != 0) goto L_0x0109
        r5 = 10
        if (r4 >= r5) goto L_0x0109
        float r2 = (float) r2
        float r4 = (float) r12
        float r2 = r2 / r4
        if (r14 == 0) goto L_0x0111
        float r2 = -r2
        goto L_0x0111
    L_0x0109:
        java.lang.String r2 = r0.mo11258a(r11, r4)
        float r2 = java.lang.Float.parseFloat(r2)
    L_0x0111:
        int r4 = r3.length
        r5 = 3
        if (r10 < r4) goto L_0x0121
        int r4 = r3.length
        int r4 = r4 * 3
        int r4 = r4 / 2
        float[] r4 = new float[r4]
        r6 = 0
        java.lang.System.arraycopy(r3, r6, r4, r6, r10)
        r3 = r4
    L_0x0121:
        int r4 = r10 + 1
        r3[r10] = r2
        r2 = 44
        if (r1 != r2) goto L_0x013b
        int r1 = r0.f2777e
        int r2 = r16 + 1
        int r1 = r1 + r16
        char r1 = r0.mo11268d(r1)
        r9 = r2
        r5 = 16
        r6 = 0
        r11 = 0
        r2 = r1
        goto L_0x0217
    L_0x013b:
        r6 = 93
        if (r1 != r6) goto L_0x0210
        int r1 = r0.f2777e
        int r10 = r16 + 1
        int r1 = r1 + r16
        char r1 = r0.mo11268d(r1)
        int r11 = r3.length
        if (r4 == r11) goto L_0x0154
        float[] r11 = new float[r4]
        r12 = 0
        java.lang.System.arraycopy(r3, r12, r11, r12, r4)
        r3 = r11
        goto L_0x0155
    L_0x0154:
        r12 = 0
    L_0x0155:
        int r11 = r7.length
        if (r8 < r11) goto L_0x0162
        int r7 = r7.length
        int r7 = r7 * 3
        int r7 = r7 / 2
        float[][] r7 = new float[r7][]
        java.lang.System.arraycopy(r3, r12, r7, r12, r4)
    L_0x0162:
        int r4 = r8 + 1
        r7[r8] = r3
        if (r1 != r2) goto L_0x0179
        int r1 = r0.f2777e
        int r2 = r10 + 1
        int r1 = r1 + r10
        char r1 = r0.mo11268d(r1)
        r3 = r2
        r5 = 16
        r6 = 0
        r11 = 0
        r2 = r1
        goto L_0x020c
    L_0x0179:
        if (r1 != r6) goto L_0x0206
        int r1 = r0.f2777e
        int r3 = r10 + 1
        int r1 = r1 + r10
        char r1 = r0.mo11268d(r1)
        int r8 = r7.length
        if (r4 == r8) goto L_0x018e
        float[][] r8 = new float[r4][]
        r11 = 0
        java.lang.System.arraycopy(r7, r11, r8, r11, r4)
        r7 = r8
    L_0x018e:
        if (r1 != r2) goto L_0x01a1
        int r1 = r0.f2777e
        r2 = 1
        int r3 = r3 - r2
        int r1 = r1 + r3
        r0.f2777e = r1
        r19.mo11225f()
        r0.f2786n = r5
        r5 = 16
        r0.f2773a = r5
        return r7
    L_0x01a1:
        r5 = 16
        r4 = 125(0x7d, float:1.75E-43)
        if (r1 != r4) goto L_0x01ff
        int r1 = r0.f2777e
        int r4 = r3 + 1
        int r1 = r1 + r3
        char r1 = r0.mo11268d(r1)
        if (r1 != r2) goto L_0x01bf
        r0.f2773a = r5
        int r1 = r0.f2777e
        r2 = 1
        int r4 = r4 - r2
        int r1 = r1 + r4
        r0.f2777e = r1
        r19.mo11225f()
        goto L_0x01f4
    L_0x01bf:
        r2 = 1
        if (r1 != r6) goto L_0x01d0
        r1 = 15
        r0.f2773a = r1
        int r1 = r0.f2777e
        int r4 = r4 - r2
        int r1 = r1 + r4
        r0.f2777e = r1
        r19.mo11225f()
        goto L_0x01f4
    L_0x01d0:
        r3 = 125(0x7d, float:1.75E-43)
        if (r1 != r3) goto L_0x01e2
        r1 = 13
        r0.f2773a = r1
        int r1 = r0.f2777e
        int r4 = r4 - r2
        int r1 = r1 + r4
        r0.f2777e = r1
        r19.mo11225f()
        goto L_0x01f4
    L_0x01e2:
        r3 = 26
        if (r1 != r3) goto L_0x01f8
        int r1 = r0.f2777e
        int r4 = r4 - r2
        int r1 = r1 + r4
        r0.f2777e = r1
        r1 = 20
        r0.f2773a = r1
        r1 = 26
        r0.f2776d = r1
    L_0x01f4:
        r1 = 4
        r0.f2786n = r1
        return r7
    L_0x01f8:
        r0.f2786n = r9
        r6 = 0
        r4 = r6
        float[][] r4 = (float[][]) r4
        return r4
    L_0x01ff:
        r6 = 0
        r0.f2786n = r9
        r4 = r6
        float[][] r4 = (float[][]) r4
        return r4
    L_0x0206:
        r5 = 16
        r6 = 0
        r11 = 0
        r2 = r1
        r3 = r10
    L_0x020c:
        r8 = r4
        r4 = r6
        r1 = 0
        goto L_0x0229
    L_0x0210:
        r5 = 16
        r6 = 0
        r11 = 0
        r2 = r1
        r9 = r16
    L_0x0217:
        r10 = r4
        r4 = r6
        r1 = 0
        r5 = 91
        r6 = 16
        goto L_0x0043
    L_0x0220:
        r6 = r4
        r0.f2786n = r9
        r4 = r6
        float[][] r4 = (float[][]) r4
        return r4
    L_0x0227:
        r5 = 16
    L_0x0229:
        r5 = 91
        r6 = 16
        goto L_0x0035
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.mo11277j(char[]):float[][]");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Regions count limit reached
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:689)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:689)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:689)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:694)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:30)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
        	at jadx.core.ProcessClass.process(ProcessClass.java:35)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        */
    /* renamed from: k */
    public final double mo11278k(char[] r24) {
        /*
        r23 = this;
        r0 = r23
        r1 = r24
        r2 = 0
        r0.f2786n = r2
        boolean r3 = r23.mo11282o(r24)
        r4 = 0
        if (r3 != 0) goto L_0x0013
        r1 = -2
        r0.f2786n = r1
        return r4
    L_0x0013:
        int r3 = r1.length
        int r6 = r0.f2777e
        int r7 = r3 + 1
        int r6 = r6 + r3
        char r3 = r0.mo11268d(r6)
        r6 = 34
        if (r3 != r6) goto L_0x0023
        r9 = 1
        goto L_0x0024
    L_0x0023:
        r9 = 0
    L_0x0024:
        if (r9 == 0) goto L_0x0030
        int r3 = r0.f2777e
        int r10 = r7 + 1
        int r3 = r3 + r7
        char r3 = r0.mo11268d(r3)
        r7 = r10
    L_0x0030:
        r10 = 45
        if (r3 != r10) goto L_0x0036
        r11 = 1
        goto L_0x0037
    L_0x0036:
        r11 = 0
    L_0x0037:
        if (r11 == 0) goto L_0x0043
        int r3 = r0.f2777e
        int r12 = r7 + 1
        int r3 = r3 + r7
        char r3 = r0.mo11268d(r3)
        r7 = r12
    L_0x0043:
        r14 = 44
        r15 = -1
        r2 = 48
        if (r3 < r2) goto L_0x01b9
        r13 = 57
        if (r3 > r13) goto L_0x01b9
        int r3 = r3 - r2
        r17 = r7
        long r6 = (long) r3
    L_0x0052:
        int r3 = r0.f2777e
        int r18 = r17 + 1
        int r3 = r3 + r17
        char r3 = r0.mo11268d(r3)
        r19 = 10
        if (r3 < r2) goto L_0x006f
        if (r3 > r13) goto L_0x006f
        long r6 = r6 * r19
        int r3 = r3 + -48
        r21 = r9
        long r8 = (long) r3
        long r6 = r6 + r8
        r17 = r18
        r9 = r21
        goto L_0x0052
    L_0x006f:
        r21 = r9
        r8 = 46
        if (r3 != r8) goto L_0x0077
        r8 = 1
        goto L_0x0078
    L_0x0077:
        r8 = 0
    L_0x0078:
        if (r8 == 0) goto L_0x00ae
        int r3 = r0.f2777e
        int r8 = r18 + 1
        int r3 = r3 + r18
        char r3 = r0.mo11268d(r3)
        if (r3 < r2) goto L_0x00ab
        if (r3 > r13) goto L_0x00ab
        long r6 = r6 * r19
        int r3 = r3 - r2
        r22 = r11
        long r10 = (long) r3
        long r6 = r6 + r10
        r10 = r19
    L_0x0091:
        int r3 = r0.f2777e
        int r17 = r8 + 1
        int r3 = r3 + r8
        char r3 = r0.mo11268d(r3)
        if (r3 < r2) goto L_0x00b4
        if (r3 > r13) goto L_0x00b4
        long r6 = r6 * r19
        int r3 = r3 + -48
        long r12 = (long) r3
        long r6 = r6 + r12
        long r10 = r10 * r19
        r8 = r17
        r13 = 57
        goto L_0x0091
    L_0x00ab:
        r0.f2786n = r15
        return r4
    L_0x00ae:
        r22 = r11
        r17 = r18
        r10 = 1
    L_0x00b4:
        r12 = 101(0x65, float:1.42E-43)
        if (r3 == r12) goto L_0x00c0
        r12 = 69
        if (r3 != r12) goto L_0x00bd
        goto L_0x00c0
    L_0x00bd:
        r16 = 0
        goto L_0x00c2
    L_0x00c0:
        r16 = 1
    L_0x00c2:
        if (r16 == 0) goto L_0x00f6
        int r3 = r0.f2777e
        int r12 = r17 + 1
        int r3 = r3 + r17
        char r3 = r0.mo11268d(r3)
        r13 = 43
        if (r3 == r13) goto L_0x00da
        r9 = 45
        if (r3 != r9) goto L_0x00d7
        goto L_0x00da
    L_0x00d7:
        r17 = r12
        goto L_0x00e5
    L_0x00da:
        int r3 = r0.f2777e
        int r9 = r12 + 1
        int r3 = r3 + r12
        char r3 = r0.mo11268d(r3)
        r17 = r9
    L_0x00e5:
        if (r3 < r2) goto L_0x00f6
        r9 = 57
        if (r3 > r9) goto L_0x00f6
        int r3 = r0.f2777e
        int r12 = r17 + 1
        int r3 = r3 + r17
        char r3 = r0.mo11268d(r3)
        goto L_0x00d7
    L_0x00f6:
        if (r21 == 0) goto L_0x0116
        r2 = 34
        if (r3 == r2) goto L_0x00ff
        r0.f2786n = r15
        return r4
    L_0x00ff:
        int r2 = r0.f2777e
        int r3 = r17 + 1
        int r2 = r2 + r17
        char r2 = r0.mo11268d(r2)
        int r9 = r0.f2777e
        int r1 = r1.length
        int r1 = r1 + r9
        r12 = 1
        int r1 = r1 + r12
        int r9 = r9 + r3
        int r9 = r9 - r1
        int r9 = r9 + -2
        r17 = r3
        goto L_0x0121
    L_0x0116:
        r12 = 1
        int r2 = r0.f2777e
        int r1 = r1.length
        int r1 = r1 + r2
        int r2 = r2 + r17
        int r2 = r2 - r1
        int r9 = r2 + -1
        r2 = r3
    L_0x0121:
        if (r16 != 0) goto L_0x012e
        r3 = 20
        if (r9 >= r3) goto L_0x012e
        double r6 = (double) r6
        double r9 = (double) r10
        double r6 = r6 / r9
        if (r22 == 0) goto L_0x0136
        double r6 = -r6
        goto L_0x0136
    L_0x012e:
        java.lang.String r1 = r0.mo11258a(r1, r9)
        double r6 = java.lang.Double.parseDouble(r1)
    L_0x0136:
        if (r2 != r14) goto L_0x014e
        int r1 = r0.f2777e
        int r1 = r1 + r17
        r0.f2777e = r1
        int r1 = r0.f2777e
        char r1 = r0.mo11268d(r1)
        r0.f2776d = r1
        r1 = 3
        r0.f2786n = r1
        r1 = 16
        r0.f2773a = r1
        return r6
    L_0x014e:
        r1 = 16
        r3 = 125(0x7d, float:1.75E-43)
        if (r2 != r3) goto L_0x01b6
        int r2 = r0.f2777e
        int r3 = r17 + 1
        int r2 = r2 + r17
        char r2 = r0.mo11268d(r2)
        if (r2 != r14) goto L_0x0170
        r0.f2773a = r1
        int r1 = r0.f2777e
        int r1 = r1 + r3
        r0.f2777e = r1
        int r1 = r0.f2777e
        char r1 = r0.mo11268d(r1)
        r0.f2776d = r1
        goto L_0x01af
    L_0x0170:
        r1 = 93
        if (r2 != r1) goto L_0x0186
        r1 = 15
        r0.f2773a = r1
        int r1 = r0.f2777e
        int r1 = r1 + r3
        r0.f2777e = r1
        int r1 = r0.f2777e
        char r1 = r0.mo11268d(r1)
        r0.f2776d = r1
        goto L_0x01af
    L_0x0186:
        r1 = 125(0x7d, float:1.75E-43)
        if (r2 != r1) goto L_0x019c
        r1 = 13
        r0.f2773a = r1
        int r1 = r0.f2777e
        int r1 = r1 + r3
        r0.f2777e = r1
        int r1 = r0.f2777e
        char r1 = r0.mo11268d(r1)
        r0.f2776d = r1
        goto L_0x01af
    L_0x019c:
        r1 = 26
        if (r2 != r1) goto L_0x01b3
        r1 = 20
        r0.f2773a = r1
        int r1 = r0.f2777e
        r2 = 1
        int r3 = r3 - r2
        int r1 = r1 + r3
        r0.f2777e = r1
        r1 = 26
        r0.f2776d = r1
    L_0x01af:
        r1 = 4
        r0.f2786n = r1
        return r6
    L_0x01b3:
        r0.f2786n = r15
        return r4
    L_0x01b6:
        r0.f2786n = r15
        return r4
    L_0x01b9:
        r17 = r7
        r21 = r9
        r1 = 110(0x6e, float:1.54E-43)
        if (r3 != r1) goto L_0x0249
        int r1 = r0.f2777e
        int r1 = r1 + r17
        char r1 = r0.mo11268d(r1)
        r2 = 117(0x75, float:1.64E-43)
        if (r1 != r2) goto L_0x0249
        int r1 = r0.f2777e
        int r1 = r1 + r17
        r2 = 1
        int r1 = r1 + r2
        char r1 = r0.mo11268d(r1)
        r2 = 108(0x6c, float:1.51E-43)
        if (r1 != r2) goto L_0x0249
        int r1 = r0.f2777e
        int r1 = r1 + r17
        int r1 = r1 + 2
        char r1 = r0.mo11268d(r1)
        if (r1 != r2) goto L_0x0249
        r1 = 5
        r0.f2786n = r1
        int r7 = r17 + 3
        int r2 = r0.f2777e
        int r3 = r7 + 1
        int r2 = r2 + r7
        char r2 = r0.mo11268d(r2)
        if (r21 == 0) goto L_0x0205
        r6 = 34
        if (r2 != r6) goto L_0x0205
        int r2 = r0.f2777e
        int r6 = r3 + 1
        int r2 = r2 + r3
        char r2 = r0.mo11268d(r2)
        r3 = r6
    L_0x0205:
        if (r2 != r14) goto L_0x021b
        int r2 = r0.f2777e
        int r2 = r2 + r3
        r0.f2777e = r2
        int r2 = r0.f2777e
        char r2 = r0.mo11268d(r2)
        r0.f2776d = r2
        r0.f2786n = r1
        r6 = 16
        r0.f2773a = r6
        return r4
    L_0x021b:
        r6 = 16
        r7 = 125(0x7d, float:1.75E-43)
        if (r2 != r7) goto L_0x0235
        int r2 = r0.f2777e
        int r2 = r2 + r3
        r0.f2777e = r2
        int r2 = r0.f2777e
        char r2 = r0.mo11268d(r2)
        r0.f2776d = r2
        r0.f2786n = r1
        r1 = 13
        r0.f2773a = r1
        return r4
    L_0x0235:
        boolean r2 = m2776j(r2)
        if (r2 == 0) goto L_0x0246
        int r2 = r0.f2777e
        int r8 = r3 + 1
        int r2 = r2 + r3
        char r2 = r0.mo11268d(r2)
        r3 = r8
        goto L_0x0205
    L_0x0246:
        r0.f2786n = r15
        return r4
    L_0x0249:
        r0.f2786n = r15
        return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.mo11278k(char[]):double");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Regions count limit reached
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:689)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:694)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:694)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:30)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
        	at jadx.core.ProcessClass.process(ProcessClass.java:35)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        */
    /* renamed from: l */
    public java.math.BigDecimal mo11279l(char[] r19) {
        /*
        r18 = this;
        r0 = r18
        r1 = r19
        r2 = 0
        r0.f2786n = r2
        boolean r3 = r18.mo11282o(r19)
        r4 = 0
        if (r3 != 0) goto L_0x0012
        r1 = -2
        r0.f2786n = r1
        return r4
    L_0x0012:
        int r3 = r1.length
        int r5 = r0.f2777e
        int r6 = r3 + 1
        int r5 = r5 + r3
        char r3 = r0.mo11268d(r5)
        r5 = 34
        r7 = 1
        if (r3 != r5) goto L_0x0023
        r8 = 1
        goto L_0x0024
    L_0x0023:
        r8 = 0
    L_0x0024:
        if (r8 == 0) goto L_0x0030
        int r3 = r0.f2777e
        int r9 = r6 + 1
        int r3 = r3 + r6
        char r3 = r0.mo11268d(r3)
        r6 = r9
    L_0x0030:
        r9 = 45
        if (r3 != r9) goto L_0x0036
        r10 = 1
        goto L_0x0037
    L_0x0036:
        r10 = 0
    L_0x0037:
        if (r10 == 0) goto L_0x0043
        int r3 = r0.f2777e
        int r10 = r6 + 1
        int r3 = r3 + r6
        char r3 = r0.mo11268d(r3)
        r6 = r10
    L_0x0043:
        r10 = 3
        r11 = 16
        r13 = 44
        r14 = 48
        r15 = -1
        if (r3 < r14) goto L_0x0176
        r2 = 57
        if (r3 > r2) goto L_0x0176
    L_0x0051:
        int r3 = r0.f2777e
        int r17 = r6 + 1
        int r3 = r3 + r6
        char r3 = r0.mo11268d(r3)
        if (r3 < r14) goto L_0x0061
        if (r3 > r2) goto L_0x0061
        r6 = r17
        goto L_0x0051
    L_0x0061:
        r6 = 46
        if (r3 != r6) goto L_0x0067
        r6 = 1
        goto L_0x0068
    L_0x0067:
        r6 = 0
    L_0x0068:
        if (r6 == 0) goto L_0x008b
        int r3 = r0.f2777e
        int r6 = r17 + 1
        int r3 = r3 + r17
        char r3 = r0.mo11268d(r3)
        if (r3 < r14) goto L_0x0088
        if (r3 > r2) goto L_0x0088
    L_0x0078:
        int r3 = r0.f2777e
        int r17 = r6 + 1
        int r3 = r3 + r6
        char r3 = r0.mo11268d(r3)
        if (r3 < r14) goto L_0x008b
        if (r3 > r2) goto L_0x008b
        r6 = r17
        goto L_0x0078
    L_0x0088:
        r0.f2786n = r15
        return r4
    L_0x008b:
        r6 = 101(0x65, float:1.42E-43)
        if (r3 == r6) goto L_0x0097
        r6 = 69
        if (r3 != r6) goto L_0x0094
        goto L_0x0097
    L_0x0094:
        r16 = 0
        goto L_0x0099
    L_0x0097:
        r16 = 1
    L_0x0099:
        if (r16 == 0) goto L_0x00c9
        int r3 = r0.f2777e
        int r6 = r17 + 1
        int r3 = r3 + r17
        char r3 = r0.mo11268d(r3)
        r12 = 43
        if (r3 == r12) goto L_0x00af
        if (r3 != r9) goto L_0x00ac
        goto L_0x00af
    L_0x00ac:
        r17 = r6
        goto L_0x00ba
    L_0x00af:
        int r3 = r0.f2777e
        int r9 = r6 + 1
        int r3 = r3 + r6
        char r3 = r0.mo11268d(r3)
        r17 = r9
    L_0x00ba:
        if (r3 < r14) goto L_0x00c9
        if (r3 > r2) goto L_0x00c9
        int r3 = r0.f2777e
        int r6 = r17 + 1
        int r3 = r3 + r17
        char r3 = r0.mo11268d(r3)
        goto L_0x00ac
    L_0x00c9:
        if (r8 == 0) goto L_0x00e6
        if (r3 == r5) goto L_0x00d0
        r0.f2786n = r15
        return r4
    L_0x00d0:
        int r2 = r0.f2777e
        int r3 = r17 + 1
        int r2 = r2 + r17
        char r2 = r0.mo11268d(r2)
        int r5 = r0.f2777e
        int r1 = r1.length
        int r1 = r1 + r5
        int r1 = r1 + r7
        int r5 = r5 + r3
        int r5 = r5 - r1
        int r5 = r5 + -2
        r17 = r3
        goto L_0x00f0
    L_0x00e6:
        int r2 = r0.f2777e
        int r1 = r1.length
        int r1 = r1 + r2
        int r2 = r2 + r17
        int r2 = r2 - r1
        int r5 = r2 + -1
        r2 = r3
    L_0x00f0:
        char[] r1 = r0.mo11266b(r1, r5)
        java.math.BigDecimal r3 = new java.math.BigDecimal
        r3.<init>(r1)
        if (r2 != r13) goto L_0x010e
        int r1 = r0.f2777e
        int r1 = r1 + r17
        r0.f2777e = r1
        int r1 = r0.f2777e
        char r1 = r0.mo11268d(r1)
        r0.f2776d = r1
        r0.f2786n = r10
        r0.f2773a = r11
        return r3
    L_0x010e:
        r1 = 125(0x7d, float:1.75E-43)
        if (r2 != r1) goto L_0x0173
        int r1 = r0.f2777e
        int r2 = r17 + 1
        int r1 = r1 + r17
        char r1 = r0.mo11268d(r1)
        if (r1 != r13) goto L_0x012e
        r0.f2773a = r11
        int r1 = r0.f2777e
        int r1 = r1 + r2
        r0.f2777e = r1
        int r1 = r0.f2777e
        char r1 = r0.mo11268d(r1)
        r0.f2776d = r1
        goto L_0x016c
    L_0x012e:
        r5 = 93
        if (r1 != r5) goto L_0x0144
        r1 = 15
        r0.f2773a = r1
        int r1 = r0.f2777e
        int r1 = r1 + r2
        r0.f2777e = r1
        int r1 = r0.f2777e
        char r1 = r0.mo11268d(r1)
        r0.f2776d = r1
        goto L_0x016c
    L_0x0144:
        r5 = 125(0x7d, float:1.75E-43)
        if (r1 != r5) goto L_0x015a
        r1 = 13
        r0.f2773a = r1
        int r1 = r0.f2777e
        int r1 = r1 + r2
        r0.f2777e = r1
        int r1 = r0.f2777e
        char r1 = r0.mo11268d(r1)
        r0.f2776d = r1
        goto L_0x016c
    L_0x015a:
        r5 = 26
        if (r1 != r5) goto L_0x0170
        r1 = 20
        r0.f2773a = r1
        int r1 = r0.f2777e
        int r2 = r2 - r7
        int r1 = r1 + r2
        r0.f2777e = r1
        r1 = 26
        r0.f2776d = r1
    L_0x016c:
        r1 = 4
        r0.f2786n = r1
        return r3
    L_0x0170:
        r0.f2786n = r15
        return r4
    L_0x0173:
        r0.f2786n = r15
        return r4
    L_0x0176:
        r1 = 110(0x6e, float:1.54E-43)
        if (r3 != r1) goto L_0x01f7
        int r1 = r0.f2777e
        int r1 = r1 + r6
        char r1 = r0.mo11268d(r1)
        r2 = 117(0x75, float:1.64E-43)
        if (r1 != r2) goto L_0x01f7
        int r1 = r0.f2777e
        int r1 = r1 + r6
        int r1 = r1 + r7
        char r1 = r0.mo11268d(r1)
        r2 = 108(0x6c, float:1.51E-43)
        if (r1 != r2) goto L_0x01f7
        int r1 = r0.f2777e
        int r1 = r1 + r6
        int r1 = r1 + 2
        char r1 = r0.mo11268d(r1)
        if (r1 != r2) goto L_0x01f7
        r1 = 5
        r0.f2786n = r1
        int r6 = r6 + r10
        int r2 = r0.f2777e
        int r3 = r6 + 1
        int r2 = r2 + r6
        char r2 = r0.mo11268d(r2)
        if (r8 == 0) goto L_0x01b7
        if (r2 != r5) goto L_0x01b7
        int r2 = r0.f2777e
        int r5 = r3 + 1
        int r2 = r2 + r3
        char r2 = r0.mo11268d(r2)
        r3 = r5
    L_0x01b7:
        if (r2 != r13) goto L_0x01cb
        int r2 = r0.f2777e
        int r2 = r2 + r3
        r0.f2777e = r2
        int r2 = r0.f2777e
        char r2 = r0.mo11268d(r2)
        r0.f2776d = r2
        r0.f2786n = r1
        r0.f2773a = r11
        return r4
    L_0x01cb:
        r5 = 125(0x7d, float:1.75E-43)
        if (r2 != r5) goto L_0x01e3
        int r2 = r0.f2777e
        int r2 = r2 + r3
        r0.f2777e = r2
        int r2 = r0.f2777e
        char r2 = r0.mo11268d(r2)
        r0.f2776d = r2
        r0.f2786n = r1
        r1 = 13
        r0.f2773a = r1
        return r4
    L_0x01e3:
        boolean r2 = m2776j(r2)
        if (r2 == 0) goto L_0x01f4
        int r2 = r0.f2777e
        int r6 = r3 + 1
        int r2 = r2 + r3
        char r2 = r0.mo11268d(r2)
        r3 = r6
        goto L_0x01b7
    L_0x01f4:
        r0.f2786n = r15
        return r4
    L_0x01f7:
        r0.f2786n = r15
        return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.mo11279l(char[]):java.math.BigDecimal");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0084  */
    /* renamed from: m */
    public java.math.BigInteger mo11280m(char[] r20) {
        /*
        r19 = this;
        r0 = r19
        r1 = r20
        r2 = 0
        r0.f2786n = r2
        boolean r3 = r19.mo11282o(r20)
        r4 = 0
        if (r3 != 0) goto L_0x0012
        r1 = -2
        r0.f2786n = r1
        return r4
    L_0x0012:
        int r3 = r1.length
        int r5 = r0.f2777e
        int r6 = r3 + 1
        int r5 = r5 + r3
        char r3 = r0.mo11268d(r5)
        r5 = 34
        r7 = 1
        if (r3 != r5) goto L_0x0023
        r8 = 1
        goto L_0x0024
    L_0x0023:
        r8 = 0
    L_0x0024:
        if (r8 == 0) goto L_0x0030
        int r3 = r0.f2777e
        int r9 = r6 + 1
        int r3 = r3 + r6
        char r3 = r0.mo11268d(r3)
        r6 = r9
    L_0x0030:
        r9 = 45
        if (r3 != r9) goto L_0x0035
        r2 = 1
    L_0x0035:
        if (r2 == 0) goto L_0x0041
        int r3 = r0.f2777e
        int r9 = r6 + 1
        int r3 = r3 + r6
        char r3 = r0.mo11268d(r3)
        r6 = r9
    L_0x0041:
        r9 = 3
        r13 = 48
        r14 = -1
        if (r3 < r13) goto L_0x012c
        r15 = 57
        if (r3 > r15) goto L_0x012c
        int r3 = r3 - r13
        long r10 = (long) r3
    L_0x004d:
        int r3 = r0.f2777e
        int r16 = r6 + 1
        int r3 = r3 + r6
        char r3 = r0.mo11268d(r3)
        if (r3 < r13) goto L_0x0067
        if (r3 > r15) goto L_0x0067
        r17 = 10
        long r10 = r10 * r17
        int r3 = r3 + -48
        long r12 = (long) r3
        long r10 = r10 + r12
        r6 = r16
        r13 = 48
        goto L_0x004d
    L_0x0067:
        if (r8 == 0) goto L_0x0084
        if (r3 == r5) goto L_0x006e
        r0.f2786n = r14
        return r4
    L_0x006e:
        int r3 = r0.f2777e
        int r5 = r16 + 1
        int r3 = r3 + r16
        char r3 = r0.mo11268d(r3)
        int r6 = r0.f2777e
        int r1 = r1.length
        int r1 = r1 + r6
        int r1 = r1 + r7
        int r6 = r6 + r5
        int r6 = r6 - r1
        int r6 = r6 + -2
        r16 = r5
        goto L_0x008d
    L_0x0084:
        int r5 = r0.f2777e
        int r1 = r1.length
        int r1 = r1 + r5
        int r5 = r5 + r16
        int r5 = r5 - r1
        int r6 = r5 + -1
    L_0x008d:
        r5 = 20
        if (r6 < r5) goto L_0x00a2
        if (r2 == 0) goto L_0x0098
        r8 = 21
        if (r6 >= r8) goto L_0x0098
        goto L_0x00a2
    L_0x0098:
        java.lang.String r1 = r0.mo11258a(r1, r6)
        java.math.BigInteger r2 = new java.math.BigInteger
        r2.<init>(r1)
        goto L_0x00a9
    L_0x00a2:
        if (r2 == 0) goto L_0x00a5
        long r10 = -r10
    L_0x00a5:
        java.math.BigInteger r2 = java.math.BigInteger.valueOf(r10)
    L_0x00a9:
        r1 = 44
        if (r3 != r1) goto L_0x00c2
        int r1 = r0.f2777e
        int r1 = r1 + r16
        r0.f2777e = r1
        int r1 = r0.f2777e
        char r1 = r0.mo11268d(r1)
        r0.f2776d = r1
        r0.f2786n = r9
        r1 = 16
        r0.f2773a = r1
        return r2
    L_0x00c2:
        r1 = 16
        r6 = 125(0x7d, float:1.75E-43)
        if (r3 != r6) goto L_0x0129
        int r3 = r0.f2777e
        int r6 = r16 + 1
        int r3 = r3 + r16
        char r3 = r0.mo11268d(r3)
        r8 = 44
        if (r3 != r8) goto L_0x00e6
        r0.f2773a = r1
        int r1 = r0.f2777e
        int r1 = r1 + r6
        r0.f2777e = r1
        int r1 = r0.f2777e
        char r1 = r0.mo11268d(r1)
        r0.f2776d = r1
        goto L_0x0122
    L_0x00e6:
        r1 = 93
        if (r3 != r1) goto L_0x00fc
        r1 = 15
        r0.f2773a = r1
        int r1 = r0.f2777e
        int r1 = r1 + r6
        r0.f2777e = r1
        int r1 = r0.f2777e
        char r1 = r0.mo11268d(r1)
        r0.f2776d = r1
        goto L_0x0122
    L_0x00fc:
        r1 = 125(0x7d, float:1.75E-43)
        if (r3 != r1) goto L_0x0112
        r1 = 13
        r0.f2773a = r1
        int r1 = r0.f2777e
        int r1 = r1 + r6
        r0.f2777e = r1
        int r1 = r0.f2777e
        char r1 = r0.mo11268d(r1)
        r0.f2776d = r1
        goto L_0x0122
    L_0x0112:
        r1 = 26
        if (r3 != r1) goto L_0x0126
        r0.f2773a = r5
        int r1 = r0.f2777e
        int r6 = r6 - r7
        int r1 = r1 + r6
        r0.f2777e = r1
        r1 = 26
        r0.f2776d = r1
    L_0x0122:
        r1 = 4
        r0.f2786n = r1
        return r2
    L_0x0126:
        r0.f2786n = r14
        return r4
    L_0x0129:
        r0.f2786n = r14
        return r4
    L_0x012c:
        r1 = 110(0x6e, float:1.54E-43)
        if (r3 != r1) goto L_0x01b3
        int r1 = r0.f2777e
        int r1 = r1 + r6
        char r1 = r0.mo11268d(r1)
        r2 = 117(0x75, float:1.64E-43)
        if (r1 != r2) goto L_0x01b3
        int r1 = r0.f2777e
        int r1 = r1 + r6
        int r1 = r1 + r7
        char r1 = r0.mo11268d(r1)
        r2 = 108(0x6c, float:1.51E-43)
        if (r1 != r2) goto L_0x01b3
        int r1 = r0.f2777e
        int r1 = r1 + r6
        int r1 = r1 + 2
        char r1 = r0.mo11268d(r1)
        if (r1 != r2) goto L_0x01b3
        r1 = 5
        r0.f2786n = r1
        int r6 = r6 + r9
        int r2 = r0.f2777e
        int r3 = r6 + 1
        int r2 = r2 + r6
        char r2 = r0.mo11268d(r2)
        if (r8 == 0) goto L_0x016d
        if (r2 != r5) goto L_0x016d
        int r2 = r0.f2777e
        int r5 = r3 + 1
        int r2 = r2 + r3
        char r2 = r0.mo11268d(r2)
        r3 = r5
    L_0x016d:
        r5 = 44
    L_0x016f:
        if (r2 != r5) goto L_0x0185
        int r2 = r0.f2777e
        int r2 = r2 + r3
        r0.f2777e = r2
        int r2 = r0.f2777e
        char r2 = r0.mo11268d(r2)
        r0.f2776d = r2
        r0.f2786n = r1
        r6 = 16
        r0.f2773a = r6
        return r4
    L_0x0185:
        r6 = 16
        r7 = 125(0x7d, float:1.75E-43)
        if (r2 != r7) goto L_0x019f
        int r2 = r0.f2777e
        int r2 = r2 + r3
        r0.f2777e = r2
        int r2 = r0.f2777e
        char r2 = r0.mo11268d(r2)
        r0.f2776d = r2
        r0.f2786n = r1
        r1 = 13
        r0.f2773a = r1
        return r4
    L_0x019f:
        boolean r2 = m2776j(r2)
        if (r2 == 0) goto L_0x01b0
        int r2 = r0.f2777e
        int r8 = r3 + 1
        int r2 = r2 + r3
        char r2 = r0.mo11268d(r2)
        r3 = r8
        goto L_0x016f
    L_0x01b0:
        r0.f2786n = r14
        return r4
    L_0x01b3:
        r0.f2786n = r14
        return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.mo11280m(char[]):java.math.BigInteger");
    }

    /* renamed from: n */
    public Date mo11281n(char[] cArr) {
        Date date;
        int i;
        long j;
        int i2;
        char d;
        char[] cArr2 = cArr;
        boolean z = false;
        this.f2786n = 0;
        if (!mo11282o(cArr)) {
            this.f2786n = -2;
            return null;
        }
        int length = cArr2.length;
        int i3 = length + 1;
        char d2 = mo11268d(this.f2777e + length);
        if (d2 == '\"') {
            int a = mo11257a('\"', this.f2777e + cArr2.length + 1);
            if (a != -1) {
                int length2 = this.f2777e + cArr2.length + 1;
                String a2 = mo11258a(length2, a - length2);
                if (a2.indexOf(92) != -1) {
                    while (true) {
                        int i4 = a - 1;
                        int i5 = 0;
                        while (i4 >= 0 && mo11268d(i4) == '\\') {
                            i5++;
                            i4--;
                        }
                        if (i5 % 2 == 0) {
                            break;
                        }
                        a = mo11257a('\"', a + 1);
                    }
                    int i6 = this.f2777e;
                    int length3 = a - ((cArr2.length + i6) + 1);
                    a2 = m2775a(mo11266b(i6 + cArr2.length + 1, length3), length3);
                }
                int i7 = this.f2777e;
                int length4 = i3 + (a - ((cArr2.length + i7) + 1)) + 1;
                i = length4 + 1;
                d2 = mo11268d(i7 + length4);
                JSONScanner eVar = new JSONScanner(a2);
                try {
                    if (eVar.mo11288b(false)) {
                        date = eVar.mo11251E().getTime();
                    } else {
                        this.f2786n = -1;
                        eVar.close();
                        return null;
                    }
                } finally {
                    eVar.close();
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else if (d2 == '-' || (d2 >= '0' && d2 <= '9')) {
            if (d2 == '-') {
                int i8 = i3 + 1;
                d2 = mo11268d(this.f2777e + i3);
                i3 = i8;
                z = true;
            }
            if (d2 < '0' || d2 > '9') {
                i = i3;
                j = 0;
            } else {
                j = (long) (d2 - '0');
                while (true) {
                    i2 = i3 + 1;
                    d = mo11268d(this.f2777e + i3);
                    if (d < '0' || d > '9') {
                        int i9 = i2;
                        d2 = d;
                        i = i9;
                    } else {
                        j = (j * 10) + ((long) (d - '0'));
                        i3 = i2;
                    }
                }
                int i92 = i2;
                d2 = d;
                i = i92;
            }
            if (j < 0) {
                this.f2786n = -1;
                return null;
            }
            if (z) {
                j = -j;
            }
            date = new Date(j);
        } else {
            this.f2786n = -1;
            return null;
        }
        if (d2 == ',') {
            this.f2777e += i;
            this.f2776d = mo11268d(this.f2777e);
            this.f2786n = 3;
            return date;
        } else if (d2 == '}') {
            int i10 = i + 1;
            char d3 = mo11268d(this.f2777e + i);
            if (d3 == ',') {
                this.f2773a = 16;
                this.f2777e += i10;
                this.f2776d = mo11268d(this.f2777e);
            } else if (d3 == ']') {
                this.f2773a = 15;
                this.f2777e += i10;
                this.f2776d = mo11268d(this.f2777e);
            } else if (d3 == '}') {
                this.f2773a = 13;
                this.f2777e += i10;
                this.f2776d = mo11268d(this.f2777e);
            } else if (d3 == 26) {
                this.f2773a = 20;
                this.f2777e += i10 - 1;
                this.f2776d = 26;
            } else {
                this.f2786n = -1;
                return null;
            }
            this.f2786n = 4;
            return date;
        } else {
            this.f2786n = -1;
            return null;
        }
    }

    /* renamed from: F */
    public final void mo11252F() {
        String str = "error parse true";
        if (this.f2776d == 't') {
            mo11225f();
            if (this.f2776d == 'r') {
                mo11225f();
                if (this.f2776d == 'u') {
                    mo11225f();
                    if (this.f2776d == 'e') {
                        mo11225f();
                        char c = this.f2776d;
                        if (c == ' ' || c == ',' || c == '}' || c == ']' || c == 10 || c == 13 || c == 9 || c == 26 || c == 12 || c == 8 || c == ':' || c == '/') {
                            this.f2773a = 6;
                            return;
                        }
                        throw new JSONException("scan true error");
                    }
                    throw new JSONException(str);
                }
                throw new JSONException(str);
            }
            throw new JSONException(str);
        }
        throw new JSONException(str);
    }

    /* renamed from: G */
    public final void mo11253G() {
        if (this.f2776d == 'n') {
            mo11225f();
            char c = this.f2776d;
            if (c == 'u') {
                mo11225f();
                String str = "error parse null";
                if (this.f2776d == 'l') {
                    mo11225f();
                    if (this.f2776d == 'l') {
                        mo11225f();
                        char c2 = this.f2776d;
                        if (c2 == ' ' || c2 == ',' || c2 == '}' || c2 == ']' || c2 == 10 || c2 == 13 || c2 == 9 || c2 == 26 || c2 == 12 || c2 == 8) {
                            this.f2773a = 8;
                            return;
                        }
                        throw new JSONException("scan null error");
                    }
                    throw new JSONException(str);
                }
                throw new JSONException(str);
            }
            String str2 = "error parse new";
            if (c == 'e') {
                mo11225f();
                if (this.f2776d == 'w') {
                    mo11225f();
                    char c3 = this.f2776d;
                    if (c3 == ' ' || c3 == ',' || c3 == '}' || c3 == ']' || c3 == 10 || c3 == 13 || c3 == 9 || c3 == 26 || c3 == 12 || c3 == 8) {
                        this.f2773a = 9;
                        return;
                    }
                    throw new JSONException("scan new error");
                }
                throw new JSONException(str2);
            }
            throw new JSONException(str2);
        }
        throw new JSONException("error parse null or new");
    }

    /* renamed from: H */
    public final void mo11254H() {
        String str = "error parse false";
        if (this.f2776d == 'f') {
            mo11225f();
            if (this.f2776d == 'a') {
                mo11225f();
                if (this.f2776d == 'l') {
                    mo11225f();
                    if (this.f2776d == 's') {
                        mo11225f();
                        if (this.f2776d == 'e') {
                            mo11225f();
                            char c = this.f2776d;
                            if (c == ' ' || c == ',' || c == '}' || c == ']' || c == 10 || c == 13 || c == 9 || c == 26 || c == 12 || c == 8 || c == ':' || c == '/') {
                                this.f2773a = 7;
                                return;
                            }
                            throw new JSONException("scan false error");
                        }
                        throw new JSONException(str);
                    }
                    throw new JSONException(str);
                }
                throw new JSONException(str);
            }
            throw new JSONException(str);
        }
        throw new JSONException(str);
    }

    /* renamed from: I */
    public final void mo11255I() {
        this.f2781i = this.f2777e - 1;
        this.f2782j = false;
        while (true) {
            this.f2780h++;
            mo11225f();
            if (!Character.isLetterOrDigit(this.f2776d)) {
                break;
            }
        }
        String l = mo11233l();
        if ("null".equalsIgnoreCase(l)) {
            this.f2773a = 8;
        } else if ("new".equals(l)) {
            this.f2773a = 9;
        } else if ("true".equals(l)) {
            this.f2773a = 6;
        } else if ("false".equals(l)) {
            this.f2773a = 7;
        } else if ("undefined".equals(l)) {
            this.f2773a = 23;
        } else if ("Set".equals(l)) {
            this.f2773a = 21;
        } else if ("TreeSet".equals(l)) {
            this.f2773a = 22;
        } else {
            this.f2773a = 18;
        }
    }

    /* renamed from: a */
    public static String m2775a(char[] cArr, int i) {
        int i2;
        int i3;
        char[] cArr2 = new char[i];
        int i4 = 0;
        int i5 = 0;
        while (i2 < i) {
            char c = cArr[i2];
            if (c != '\\') {
                int i6 = i5 + 1;
                cArr2[i5] = c;
                i5 = i6;
            } else {
                i2++;
                char c2 = cArr[i2];
                if (c2 == '\"') {
                    i3 = i5 + 1;
                    cArr2[i5] = '\"';
                } else if (c2 != '\'') {
                    if (c2 != 'F') {
                        if (c2 == '\\') {
                            i3 = i5 + 1;
                            cArr2[i5] = '\\';
                        } else if (c2 == 'b') {
                            i3 = i5 + 1;
                            cArr2[i5] = 8;
                        } else if (c2 != 'f') {
                            if (c2 == 'n') {
                                i3 = i5 + 1;
                                cArr2[i5] = 10;
                            } else if (c2 == 'r') {
                                i3 = i5 + 1;
                                cArr2[i5] = 13;
                            } else if (c2 != 'x') {
                                switch (c2) {
                                    case '/':
                                        i3 = i5 + 1;
                                        cArr2[i5] = '/';
                                        break;
                                    case '0':
                                        i3 = i5 + 1;
                                        cArr2[i5] = 0;
                                        break;
                                    case '1':
                                        i3 = i5 + 1;
                                        cArr2[i5] = 1;
                                        break;
                                    case '2':
                                        i3 = i5 + 1;
                                        cArr2[i5] = 2;
                                        break;
                                    case '3':
                                        i3 = i5 + 1;
                                        cArr2[i5] = 3;
                                        break;
                                    case '4':
                                        i3 = i5 + 1;
                                        cArr2[i5] = 4;
                                        break;
                                    case '5':
                                        i3 = i5 + 1;
                                        cArr2[i5] = 5;
                                        break;
                                    case '6':
                                        i3 = i5 + 1;
                                        cArr2[i5] = 6;
                                        break;
                                    case '7':
                                        i3 = i5 + 1;
                                        cArr2[i5] = 7;
                                        break;
                                    default:
                                        switch (c2) {
                                            case 't':
                                                i3 = i5 + 1;
                                                cArr2[i5] = 9;
                                                break;
                                            case 'u':
                                                i3 = i5 + 1;
                                                int i7 = i2 + 1;
                                                int i8 = i7 + 1;
                                                int i9 = i8 + 1;
                                                i2 = i9 + 1;
                                                cArr2[i5] = (char) Integer.parseInt(new String(new char[]{cArr[i7], cArr[i8], cArr[i9], cArr[i2]}), 16);
                                                break;
                                            case 'v':
                                                i3 = i5 + 1;
                                                cArr2[i5] = 11;
                                                break;
                                            default:
                                                throw new JSONException("unclosed.str.lit");
                                        }
                                }
                            } else {
                                i3 = i5 + 1;
                                int[] iArr = f2771q;
                                int i10 = i2 + 1;
                                i2 = i10 + 1;
                                cArr2[i5] = (char) ((iArr[cArr[i10]] * 16) + iArr[cArr[i2]]);
                            }
                        }
                    }
                    i3 = i5 + 1;
                    cArr2[i5] = 12;
                } else {
                    i3 = i5 + 1;
                    cArr2[i5] = '\'';
                }
                i5 = i3;
            }
            i4 = i2 + 1;
        }
        return new String(cArr2, 0, i5);
    }

    /* renamed from: p */
    public boolean mo11237p() {
        int i = 0;
        while (true) {
            char d = mo11268d(i);
            if (d == 26) {
                this.f2773a = 20;
                return true;
            } else if (!m2776j(d)) {
                return false;
            } else {
                i++;
            }
        }
    }

    /* renamed from: c */
    public final void mo11218c() {
        while (true) {
            char c = this.f2776d;
            if (c > '/') {
                return;
            }
            if (c == ' ' || c == 13 || c == 10 || c == 9 || c == 12 || c == 8) {
                mo11225f();
            } else if (c == '/') {
                mo11250D();
            } else {
                return;
            }
        }
    }

    /* renamed from: K */
    private void mo11284K() {
        this.f2781i = this.f2777e;
        this.f2782j = false;
        while (true) {
            char f = mo11225f();
            if (f == '\'') {
                this.f2773a = 4;
                mo11225f();
                return;
            }
            String str = "unclosed single-quote string";
            if (f == 26) {
                if (!mo11249C()) {
                    mo11275i(26);
                } else {
                    throw new JSONException(str);
                }
            } else if (f == '\\') {
                if (!this.f2782j) {
                    this.f2782j = true;
                    int i = this.f2780h;
                    char[] cArr = this.f2779g;
                    if (i > cArr.length) {
                        char[] cArr2 = new char[(i * 2)];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.f2779g = cArr2;
                    }
                    mo11260a(this.f2781i + 1, this.f2780h, this.f2779g);
                }
                char f2 = mo11225f();
                if (f2 == '\"') {
                    mo11275i('\"');
                } else if (f2 != '\'') {
                    if (f2 != 'F') {
                        if (f2 == '\\') {
                            mo11275i('\\');
                        } else if (f2 == 'b') {
                            mo11275i(8);
                        } else if (f2 != 'f') {
                            if (f2 == 'n') {
                                mo11275i(10);
                            } else if (f2 == 'r') {
                                mo11275i(13);
                            } else if (f2 != 'x') {
                                switch (f2) {
                                    case '/':
                                        mo11275i('/');
                                        break;
                                    case '0':
                                        mo11275i(0);
                                        break;
                                    case '1':
                                        mo11275i(1);
                                        break;
                                    case '2':
                                        mo11275i(2);
                                        break;
                                    case '3':
                                        mo11275i(3);
                                        break;
                                    case '4':
                                        mo11275i(4);
                                        break;
                                    case '5':
                                        mo11275i(5);
                                        break;
                                    case '6':
                                        mo11275i(6);
                                        break;
                                    case '7':
                                        mo11275i(7);
                                        break;
                                    default:
                                        switch (f2) {
                                            case 't':
                                                mo11275i(9);
                                                break;
                                            case 'u':
                                                mo11275i((char) Integer.parseInt(new String(new char[]{mo11225f(), mo11225f(), mo11225f(), mo11225f()}), 16));
                                                break;
                                            case 'v':
                                                mo11275i(11);
                                                break;
                                            default:
                                                this.f2776d = f2;
                                                throw new JSONException(str);
                                        }
                                }
                            } else {
                                mo11275i((char) ((f2771q[mo11225f()] * 16) + f2771q[mo11225f()]));
                            }
                        }
                    }
                    mo11275i(12);
                } else {
                    mo11275i('\'');
                }
            } else if (!this.f2782j) {
                this.f2780h++;
            } else {
                int i2 = this.f2780h;
                char[] cArr3 = this.f2779g;
                if (i2 == cArr3.length) {
                    mo11275i(f);
                } else {
                    this.f2780h = i2 + 1;
                    cArr3[i2] = f;
                }
            }
        }
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: i */
    public final void mo11275i(char c) {
        int i = this.f2780h;
        char[] cArr = this.f2779g;
        if (i == cArr.length) {
            char[] cArr2 = new char[(cArr.length * 2)];
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
            this.f2779g = cArr2;
        }
        char[] cArr3 = this.f2779g;
        int i2 = this.f2780h;
        this.f2780h = i2 + 1;
        cArr3[i2] = c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0043  */
    /* renamed from: J */
    public final void mo11256J() {
        /*
        r4 = this;
        char r0 = r4.f2776d
        java.lang.String r1 = "illegal state. "
        r2 = 120(0x78, float:1.68E-43)
        if (r0 != r2) goto L_0x006f
        r4.mo11225f()
        char r0 = r4.f2776d
        r2 = 39
        if (r0 != r2) goto L_0x0058
        int r0 = r4.f2777e
        r4.f2781i = r0
        r4.mo11225f()
    L_0x0018:
        char r0 = r4.mo11225f()
        r3 = 48
        if (r0 < r3) goto L_0x0024
        r3 = 57
        if (r0 <= r3) goto L_0x002c
    L_0x0024:
        r3 = 65
        if (r0 < r3) goto L_0x0033
        r3 = 70
        if (r0 > r3) goto L_0x0033
    L_0x002c:
        int r0 = r4.f2780h
        int r0 = r0 + 1
        r4.f2780h = r0
        goto L_0x0018
    L_0x0033:
        if (r0 != r2) goto L_0x0043
        int r0 = r4.f2780h
        int r0 = r0 + 1
        r4.f2780h = r0
        r4.mo11225f()
        r0 = 26
        r4.f2773a = r0
        return
    L_0x0043:
        com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        r3.append(r1)
        r3.append(r0)
        java.lang.String r0 = r3.toString()
        r2.m41526init(r0)
        throw r2
    L_0x0058:
        com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        r2.append(r1)
        char r1 = r4.f2776d
        r2.append(r1)
        java.lang.String r1 = r2.toString()
        r0.m41526init(r1)
        throw r0
    L_0x006f:
        com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        r2.append(r1)
        char r1 = r4.f2776d
        r2.append(r1)
        java.lang.String r1 = r2.toString()
        r0.m41526init(r1)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.mo11256J():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ce  */
    /* renamed from: h */
    public final void mo11229h() {
        /*
        r9 = this;
        int r0 = r9.f2777e
        r9.f2781i = r0
        char r0 = r9.f2776d
        r1 = 45
        r2 = 1
        if (r0 != r1) goto L_0x0013
        int r0 = r9.f2780h
        int r0 = r0 + r2
        r9.f2780h = r0
        r9.mo11225f()
    L_0x0013:
        char r0 = r9.f2776d
        r3 = 57
        r4 = 48
        if (r0 < r4) goto L_0x0026
        if (r0 > r3) goto L_0x0026
        int r0 = r9.f2780h
        int r0 = r0 + r2
        r9.f2780h = r0
        r9.mo11225f()
        goto L_0x0013
    L_0x0026:
        r0 = 0
        char r5 = r9.f2776d
        r6 = 46
        if (r5 != r6) goto L_0x0045
        int r0 = r9.f2780h
        int r0 = r0 + r2
        r9.f2780h = r0
        r9.mo11225f()
    L_0x0035:
        char r0 = r9.f2776d
        if (r0 < r4) goto L_0x0044
        if (r0 > r3) goto L_0x0044
        int r0 = r9.f2780h
        int r0 = r0 + r2
        r9.f2780h = r0
        r9.mo11225f()
        goto L_0x0035
    L_0x0044:
        r0 = 1
    L_0x0045:
        char r5 = r9.f2776d
        r6 = 76
        if (r5 != r6) goto L_0x0054
        int r1 = r9.f2780h
        int r1 = r1 + r2
        r9.f2780h = r1
        r9.mo11225f()
        goto L_0x0091
    L_0x0054:
        r6 = 83
        if (r5 != r6) goto L_0x0061
        int r1 = r9.f2780h
        int r1 = r1 + r2
        r9.f2780h = r1
        r9.mo11225f()
        goto L_0x0091
    L_0x0061:
        r6 = 66
        if (r5 != r6) goto L_0x006e
        int r1 = r9.f2780h
        int r1 = r1 + r2
        r9.f2780h = r1
        r9.mo11225f()
        goto L_0x0091
    L_0x006e:
        r6 = 70
        if (r5 != r6) goto L_0x007b
        int r0 = r9.f2780h
        int r0 = r0 + r2
        r9.f2780h = r0
        r9.mo11225f()
        goto L_0x00c8
    L_0x007b:
        r7 = 68
        if (r5 != r7) goto L_0x0088
        int r0 = r9.f2780h
        int r0 = r0 + r2
        r9.f2780h = r0
        r9.mo11225f()
        goto L_0x00c8
    L_0x0088:
        r8 = 101(0x65, float:1.42E-43)
        if (r5 == r8) goto L_0x0093
        r8 = 69
        if (r5 != r8) goto L_0x0091
        goto L_0x0093
    L_0x0091:
        r2 = r0
        goto L_0x00c8
    L_0x0093:
        int r0 = r9.f2780h
        int r0 = r0 + r2
        r9.f2780h = r0
        r9.mo11225f()
        char r0 = r9.f2776d
        r5 = 43
        if (r0 == r5) goto L_0x00a3
        if (r0 != r1) goto L_0x00ab
    L_0x00a3:
        int r0 = r9.f2780h
        int r0 = r0 + r2
        r9.f2780h = r0
        r9.mo11225f()
    L_0x00ab:
        char r0 = r9.f2776d
        if (r0 < r4) goto L_0x00ba
        if (r0 > r3) goto L_0x00ba
        int r0 = r9.f2780h
        int r0 = r0 + r2
        r9.f2780h = r0
        r9.mo11225f()
        goto L_0x00ab
    L_0x00ba:
        char r0 = r9.f2776d
        if (r0 == r7) goto L_0x00c0
        if (r0 != r6) goto L_0x00c8
    L_0x00c0:
        int r0 = r9.f2780h
        int r0 = r0 + r2
        r9.f2780h = r0
        r9.mo11225f()
    L_0x00c8:
        if (r2 == 0) goto L_0x00ce
        r0 = 3
        r9.f2773a = r0
        goto L_0x00d1
    L_0x00ce:
        r0 = 2
        r9.f2773a = r0
    L_0x00d1:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.mo11229h():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0085  */
    /* renamed from: q */
    public final long mo11238q() throws java.lang.NumberFormatException {
        /*
        r15 = this;
        int r0 = r15.f2781i
        r1 = 0
        r2 = -1
        if (r0 != r2) goto L_0x0008
        r15.f2781i = r1
    L_0x0008:
        int r0 = r15.f2781i
        int r2 = r15.f2780h
        int r2 = r2 + r0
        char r3 = r15.mo11268d(r0)
        r4 = 45
        r5 = 1
        if (r3 != r4) goto L_0x001c
        r3 = -9223372036854775808
        int r0 = r0 + 1
        r1 = 1
        goto L_0x0021
    L_0x001c:
        r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
    L_0x0021:
        r6 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
        if (r0 >= r2) goto L_0x0034
        int r8 = r0 + 1
        char r0 = r15.mo11268d(r0)
        int r0 = r0 + -48
        int r0 = -r0
        long r9 = (long) r0
    L_0x0032:
        r0 = r8
        goto L_0x0036
    L_0x0034:
        r9 = 0
    L_0x0036:
        if (r0 >= r2) goto L_0x0073
        int r8 = r0 + 1
        char r0 = r15.mo11268d(r0)
        r11 = 76
        if (r0 == r11) goto L_0x0072
        r11 = 83
        if (r0 == r11) goto L_0x0072
        r11 = 66
        if (r0 != r11) goto L_0x004b
        goto L_0x0072
    L_0x004b:
        int r0 = r0 + -48
        int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
        if (r11 < 0) goto L_0x0068
        r11 = 10
        long r9 = r9 * r11
        long r11 = (long) r0
        long r13 = r3 + r11
        int r0 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
        if (r0 < 0) goto L_0x005e
        long r9 = r9 - r11
        goto L_0x0032
    L_0x005e:
        java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
        java.lang.String r1 = r15.mo11240s()
        r0.<init>(r1)
        throw r0
    L_0x0068:
        java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
        java.lang.String r1 = r15.mo11240s()
        r0.<init>(r1)
        throw r0
    L_0x0072:
        r0 = r8
    L_0x0073:
        if (r1 == 0) goto L_0x0085
        int r1 = r15.f2781i
        int r1 = r1 + r5
        if (r0 <= r1) goto L_0x007b
        return r9
    L_0x007b:
        java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
        java.lang.String r1 = r15.mo11240s()
        r0.<init>(r1)
        throw r0
    L_0x0085:
        long r0 = -r9
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.mo11238q():long");
    }

    /* renamed from: a */
    public final Number mo11208a(boolean z) {
        char d = mo11268d((this.f2781i + this.f2780h) - 1);
        if (d == 'F') {
            try {
                return Float.valueOf(Float.parseFloat(mo11240s()));
            } catch (NumberFormatException e) {
                StringBuilder sb = new StringBuilder();
                sb.append(e.getMessage());
                sb.append(", ");
                sb.append(mo11245x());
                throw new JSONException(sb.toString());
            }
        } else if (d == 'D') {
            return Double.valueOf(Double.parseDouble(mo11240s()));
        } else {
            if (z) {
                return mo11232k();
            }
            return Double.valueOf(mo11248B());
        }
    }

    /* renamed from: y */
    public int mo11246y() {
        return this.f2775c;
    }
}
