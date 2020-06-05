package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.IOUtils;
import com.kwad.sdk.core.response.model.AdConfigData;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.TimeZone;

/* renamed from: com.alibaba.fastjson.parser.e */
public final class JSONScanner extends JSONLexerBase {
    /* renamed from: r */
    private final String f2792r;
    /* renamed from: s */
    private final int f2793s;

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0044, code lost:
            if (r11 <= 57) goto L_0x0047;
     */
    /* renamed from: a */
    static boolean m2870a(char r4, char r5, char r6, char r7, char r8, char r9, int r10, int r11) {
        /*
        r0 = 49
        r1 = 0
        if (r4 < r0) goto L_0x0049
        r2 = 51
        if (r4 <= r2) goto L_0x000a
        goto L_0x0049
    L_0x000a:
        r4 = 48
        if (r5 < r4) goto L_0x0049
        r3 = 57
        if (r5 <= r3) goto L_0x0013
        goto L_0x0049
    L_0x0013:
        if (r6 < r4) goto L_0x0049
        if (r6 <= r3) goto L_0x0018
        goto L_0x0049
    L_0x0018:
        if (r7 < r4) goto L_0x0049
        if (r7 <= r3) goto L_0x001d
        goto L_0x0049
    L_0x001d:
        r5 = 50
        if (r8 != r4) goto L_0x0026
        if (r9 < r0) goto L_0x0025
        if (r9 <= r3) goto L_0x002f
    L_0x0025:
        return r1
    L_0x0026:
        if (r8 != r0) goto L_0x0049
        if (r9 == r4) goto L_0x002f
        if (r9 == r0) goto L_0x002f
        if (r9 == r5) goto L_0x002f
        return r1
    L_0x002f:
        if (r10 != r4) goto L_0x0036
        if (r11 < r0) goto L_0x0035
        if (r11 <= r3) goto L_0x0047
    L_0x0035:
        return r1
    L_0x0036:
        if (r10 == r0) goto L_0x0042
        if (r10 != r5) goto L_0x003b
        goto L_0x0042
    L_0x003b:
        if (r10 != r2) goto L_0x0041
        if (r11 == r4) goto L_0x0047
        if (r11 == r0) goto L_0x0047
    L_0x0041:
        return r1
    L_0x0042:
        if (r11 < r4) goto L_0x0049
        if (r11 <= r3) goto L_0x0047
        goto L_0x0049
    L_0x0047:
        r4 = 1
        return r4
    L_0x0049:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.m2870a(char, char, char, char, char, char, int, int):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001d, code lost:
            if (r6 <= '4') goto L_0x0020;
     */
    /* renamed from: b */
    private boolean m2873b(char r5, char r6, char r7, char r8, char r9, char r10) {
        /*
        r4 = this;
        r0 = 57
        r1 = 0
        r2 = 48
        if (r5 != r2) goto L_0x000c
        if (r6 < r2) goto L_0x000b
        if (r6 <= r0) goto L_0x0020
    L_0x000b:
        return r1
    L_0x000c:
        r3 = 49
        if (r5 != r3) goto L_0x0015
        if (r6 < r2) goto L_0x0014
        if (r6 <= r0) goto L_0x0020
    L_0x0014:
        return r1
    L_0x0015:
        r3 = 50
        if (r5 != r3) goto L_0x0042
        if (r6 < r2) goto L_0x0042
        r5 = 52
        if (r6 <= r5) goto L_0x0020
        goto L_0x0042
    L_0x0020:
        r5 = 53
        r6 = 54
        if (r7 < r2) goto L_0x002d
        if (r7 > r5) goto L_0x002d
        if (r8 < r2) goto L_0x002c
        if (r8 <= r0) goto L_0x0032
    L_0x002c:
        return r1
    L_0x002d:
        if (r7 != r6) goto L_0x0042
        if (r8 == r2) goto L_0x0032
        return r1
    L_0x0032:
        if (r9 < r2) goto L_0x003b
        if (r9 > r5) goto L_0x003b
        if (r10 < r2) goto L_0x003a
        if (r10 <= r0) goto L_0x0040
    L_0x003a:
        return r1
    L_0x003b:
        if (r9 != r6) goto L_0x0042
        if (r10 == r2) goto L_0x0040
        return r1
    L_0x0040:
        r5 = 1
        return r5
    L_0x0042:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.m2873b(char, char, char, char, char, char):boolean");
    }

    public JSONScanner(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONScanner(String str, int i) {
        super(i);
        this.f2792r = str;
        this.f2793s = this.f2792r.length();
        this.f2777e = -1;
        mo11225f();
        if (this.f2776d == 65279) {
            mo11225f();
        }
    }

    /* renamed from: d */
    public final char mo11268d(int i) {
        if (i >= this.f2793s) {
            return 26;
        }
        return this.f2792r.charAt(i);
    }

    /* renamed from: f */
    public final char mo11225f() {
        char c;
        int i = this.f2777e + 1;
        this.f2777e = i;
        if (i >= this.f2793s) {
            c = 26;
        } else {
            c = this.f2792r.charAt(i);
        }
        this.f2776d = c;
        return c;
    }

    public JSONScanner(char[] cArr, int i, int i2) {
        this(new String(cArr, 0, i), i2);
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo11260a(int i, int i2, char[] cArr) {
        this.f2792r.getChars(i, i2 + i, cArr, 0);
    }

    /* renamed from: a */
    static boolean m2871a(String str, int i, char[] cArr) {
        int length = cArr.length;
        if (length + i > str.length()) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (cArr[i2] != str.charAt(i + i2)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: o */
    public final boolean mo11282o(char[] cArr) {
        return m2871a(this.f2792r, this.f2777e, cArr);
    }

    /* renamed from: a */
    public final int mo11257a(char c, int i) {
        return this.f2792r.indexOf(c, i);
    }

    /* renamed from: a */
    public final String mo11259a(int i, int i2, int i3, SymbolTable iVar) {
        return iVar.mo11301a(this.f2792r, i, i2, i3);
    }

    /* renamed from: t */
    public byte[] mo11241t() {
        if (this.f2773a != 26) {
            return IOUtils.m3197a(this.f2792r, this.f2781i + 1, this.f2780h);
        }
        int i = this.f2781i + 1;
        int i2 = this.f2780h;
        if (i2 % 2 == 0) {
            byte[] bArr = new byte[(i2 / 2)];
            for (int i3 = 0; i3 < bArr.length; i3++) {
                int i4 = (i3 * 2) + i;
                char charAt = this.f2792r.charAt(i4);
                char charAt2 = this.f2792r.charAt(i4 + 1);
                char c = '0';
                int i5 = charAt - (charAt <= '9' ? '0' : '7');
                if (charAt2 > '9') {
                    c = '7';
                }
                bArr[i3] = (byte) ((i5 << 4) | (charAt2 - c));
            }
            return bArr;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("illegal state. ");
        sb.append(i2);
        throw new JSONException(sb.toString());
    }

    /* renamed from: l */
    public final String mo11233l() {
        if (!this.f2782j) {
            return mo11258a(this.f2781i + 1, this.f2780h);
        }
        return new String(this.f2779g, 0, this.f2780h);
    }

    /* renamed from: a */
    public final String mo11258a(int i, int i2) {
        if (!ASMUtils.f2991b) {
            return this.f2792r.substring(i, i2 + i);
        }
        if (i2 < this.f2779g.length) {
            this.f2792r.getChars(i, i + i2, this.f2779g, 0);
            return new String(this.f2779g, 0, i2);
        }
        char[] cArr = new char[i2];
        this.f2792r.getChars(i, i2 + i, cArr, 0);
        return new String(cArr);
    }

    /* renamed from: b */
    public final char[] mo11266b(int i, int i2) {
        if (!ASMUtils.f2991b || i2 >= this.f2779g.length) {
            char[] cArr = new char[i2];
            this.f2792r.getChars(i, i2 + i, cArr, 0);
            return cArr;
        }
        this.f2792r.getChars(i, i2 + i, this.f2779g, 0);
        return this.f2779g;
    }

    /* renamed from: s */
    public final String mo11240s() {
        char d = mo11268d((this.f2781i + this.f2780h) - 1);
        int i = this.f2780h;
        if (d == 'L' || d == 'S' || d == 'B' || d == 'F' || d == 'D') {
            i--;
        }
        return mo11258a(this.f2781i, i);
    }

    /* renamed from: k */
    public final BigDecimal mo11232k() {
        char d = mo11268d((this.f2781i + this.f2780h) - 1);
        int i = this.f2780h;
        if (d == 'L' || d == 'S' || d == 'B' || d == 'F' || d == 'D') {
            i--;
        }
        int i2 = this.f2781i;
        if (i < this.f2779g.length) {
            this.f2792r.getChars(i2, i2 + i, this.f2779g, 0);
            return new BigDecimal(this.f2779g, 0, i);
        }
        char[] cArr = new char[i];
        this.f2792r.getChars(i2, i + i2, cArr, 0);
        return new BigDecimal(cArr);
    }

    /* renamed from: K */
    public boolean mo11284K() {
        return mo11288b(true);
    }

    /* renamed from: b */
    public boolean mo11288b(boolean z) {
        return m2872a(z, this.f2793s - this.f2777e);
    }

    /* JADX WARNING: type inference failed for: r0v13, types: [char] */
    /* JADX WARNING: type inference failed for: r1v14, types: [char] */
    /* JADX WARNING: type inference failed for: r13v2, types: [int] */
    /* JADX WARNING: type inference failed for: r8v4, types: [int] */
    /* JADX WARNING: type inference failed for: r7v3, types: [int] */
    /* JADX WARNING: type inference failed for: r2v12, types: [char] */
    /* JADX WARNING: type inference failed for: r3v12, types: [char] */
    /* JADX WARNING: type inference failed for: r5v9, types: [char] */
    /* JADX WARNING: type inference failed for: r8v7 */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: type inference failed for: r13v5 */
    /* JADX WARNING: type inference failed for: r7v6 */
    /* JADX WARNING: type inference failed for: r8v8 */
    /* JADX WARNING: type inference failed for: r13v6 */
    /* JADX WARNING: type inference failed for: r13v11 */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00e9, code lost:
            if (r5 != ' ') goto L_0x00f0;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0202  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0394  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x03c1 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x03fe  */
    /* JADX WARNING: Unknown variable types count: 9 */
    /* renamed from: a */
    private boolean m2872a(boolean r36, int r37) {
        /*
        r35 = this;
        r9 = r35
        r10 = r37
        r11 = 8
        r12 = 0
        if (r10 >= r11) goto L_0x000a
        return r12
    L_0x000a:
        int r0 = r9.f2777e
        char r13 = r9.mo11268d(r0)
        int r0 = r9.f2777e
        r14 = 1
        int r0 = r0 + r14
        char r15 = r9.mo11268d(r0)
        int r0 = r9.f2777e
        r8 = 2
        int r0 = r0 + r8
        char r0 = r9.mo11268d(r0)
        int r1 = r9.f2777e
        r16 = 3
        int r1 = r1 + 3
        char r7 = r9.mo11268d(r1)
        int r1 = r9.f2777e
        int r1 = r1 + 4
        char r1 = r9.mo11268d(r1)
        int r2 = r9.f2777e
        r6 = 5
        int r2 = r2 + r6
        char r2 = r9.mo11268d(r2)
        int r3 = r9.f2777e
        r17 = 6
        int r3 = r3 + 6
        char r3 = r9.mo11268d(r3)
        int r4 = r9.f2777e
        int r4 = r4 + 7
        char r4 = r9.mo11268d(r4)
        r5 = 57
        r11 = 48
        if (r36 != 0) goto L_0x00c9
        r6 = 13
        if (r10 <= r6) goto L_0x00c8
        int r6 = r9.f2777e
        int r6 = r6 + r10
        int r6 = r6 - r14
        char r6 = r9.mo11268d(r6)
        int r14 = r9.f2777e
        int r14 = r14 + r10
        int r14 = r14 - r8
        char r14 = r9.mo11268d(r14)
        r8 = 47
        if (r13 != r8) goto L_0x00c8
        r8 = 68
        if (r15 != r8) goto L_0x00c8
        r8 = 97
        if (r0 != r8) goto L_0x00c8
        r8 = 116(0x74, float:1.63E-43)
        if (r7 != r8) goto L_0x00c8
        r8 = 101(0x65, float:1.42E-43)
        if (r1 != r8) goto L_0x00c8
        r8 = 40
        if (r2 != r8) goto L_0x00c8
        r8 = 47
        if (r6 != r8) goto L_0x00c8
        r6 = 41
        if (r14 != r6) goto L_0x00c8
        r0 = -1
        r0 = 6
        r1 = -1
    L_0x0089:
        if (r0 >= r10) goto L_0x00a0
        int r2 = r9.f2777e
        int r2 = r2 + r0
        char r2 = r9.mo11268d(r2)
        r3 = 43
        if (r2 != r3) goto L_0x0098
        r1 = r0
        goto L_0x009d
    L_0x0098:
        if (r2 < r11) goto L_0x00a0
        if (r2 <= r5) goto L_0x009d
        goto L_0x00a0
    L_0x009d:
        int r0 = r0 + 1
        goto L_0x0089
    L_0x00a0:
        r0 = -1
        if (r1 != r0) goto L_0x00a4
        return r12
    L_0x00a4:
        int r0 = r9.f2777e
        int r0 = r0 + 6
        int r2 = r9.f2777e
        int r2 = r2 + r1
        int r2 = r2 - r0
        java.lang.String r0 = r9.mo11258a(r0, r2)
        long r0 = java.lang.Long.parseLong(r0)
        java.util.TimeZone r2 = r9.f2784l
        java.util.Locale r3 = r9.f2785m
        java.util.Calendar r2 = java.util.Calendar.getInstance(r2, r3)
        r9.f2783k = r2
        java.util.Calendar r2 = r9.f2783k
        r2.setTimeInMillis(r0)
        r6 = 5
        r9.f2773a = r6
    L_0x00c6:
        r0 = 1
        return r0
    L_0x00c8:
        r6 = 5
    L_0x00c9:
        r14 = 9
        r11 = 14
        r12 = 45
        r19 = 10
        r5 = 8
        if (r10 == r5) goto L_0x04e1
        if (r10 == r11) goto L_0x04e1
        r5 = 16
        if (r10 != r5) goto L_0x00f0
        int r5 = r9.f2777e
        int r5 = r5 + 10
        char r5 = r9.mo11268d(r5)
        r6 = 84
        if (r5 == r6) goto L_0x00ec
        r6 = 32
        if (r5 == r6) goto L_0x00ec
        goto L_0x00f0
    L_0x00ec:
        r14 = r13
        r6 = 5
        goto L_0x04e2
    L_0x00f0:
        r5 = 17
        if (r10 != r5) goto L_0x00ff
        int r5 = r9.f2777e
        int r5 = r5 + 6
        char r5 = r9.mo11268d(r5)
        if (r5 == r12) goto L_0x00ff
        goto L_0x00ec
    L_0x00ff:
        if (r10 >= r14) goto L_0x0103
        r5 = 0
        return r5
    L_0x0103:
        int r5 = r9.f2777e
        r6 = 8
        int r5 = r5 + r6
        char r5 = r9.mo11268d(r5)
        int r6 = r9.f2777e
        int r6 = r6 + r14
        char r6 = r9.mo11268d(r6)
        if (r1 != r12) goto L_0x0117
        if (r4 == r12) goto L_0x011f
    L_0x0117:
        r8 = 47
        if (r1 != r8) goto L_0x012a
        r8 = 47
        if (r4 != r8) goto L_0x012a
    L_0x011f:
        r8 = r3
        r31 = r5
        r32 = r6
        r33 = 10
    L_0x0126:
        r5 = r0
        r6 = r2
        goto L_0x01ea
    L_0x012a:
        if (r1 != r12) goto L_0x014a
        if (r3 != r12) goto L_0x014a
        r1 = 32
        if (r5 != r1) goto L_0x013e
        r5 = r0
        r8 = r2
        r32 = r4
        r6 = 48
        r31 = 48
        r33 = 8
        goto L_0x01ea
    L_0x013e:
        r8 = r2
        r31 = r4
        r32 = r5
        r6 = 48
        r33 = 9
    L_0x0147:
        r5 = r0
        goto L_0x01ea
    L_0x014a:
        r8 = 46
        if (r0 != r8) goto L_0x0152
        r8 = 46
        if (r2 == r8) goto L_0x0156
    L_0x0152:
        if (r0 != r12) goto L_0x0166
        if (r2 != r12) goto L_0x0166
    L_0x0156:
        r8 = r1
        r31 = r13
        r32 = r15
        r33 = 10
        r13 = r3
        r15 = r4
        r34 = r7
        r7 = r6
        r6 = r34
        goto L_0x01ea
    L_0x0166:
        r8 = 24180(0x5e74, float:3.3883E-41)
        if (r1 == r8) goto L_0x0172
        r8 = 45380(0xb144, float:6.3591E-41)
        if (r1 != r8) goto L_0x0170
        goto L_0x0172
    L_0x0170:
        r1 = 0
        return r1
    L_0x0172:
        r1 = 26376(0x6708, float:3.696E-41)
        if (r4 == r1) goto L_0x01b1
        r1 = 50900(0xc6d4, float:7.1326E-41)
        if (r4 != r1) goto L_0x017c
        goto L_0x01b1
    L_0x017c:
        r1 = 26376(0x6708, float:3.696E-41)
        if (r3 == r1) goto L_0x0188
        r1 = 50900(0xc6d4, float:7.1326E-41)
        if (r3 != r1) goto L_0x0186
        goto L_0x0188
    L_0x0186:
        r1 = 0
        return r1
    L_0x0188:
        r1 = 26085(0x65e5, float:3.6553E-41)
        if (r5 == r1) goto L_0x01a6
        r1 = 51068(0xc77c, float:7.1562E-41)
        if (r5 != r1) goto L_0x0192
        goto L_0x01a6
    L_0x0192:
        r1 = 26085(0x65e5, float:3.6553E-41)
        if (r6 == r1) goto L_0x019e
        r1 = 51068(0xc77c, float:7.1562E-41)
        if (r6 != r1) goto L_0x019c
        goto L_0x019e
    L_0x019c:
        r1 = 0
        return r1
    L_0x019e:
        r8 = r2
        r31 = r4
        r32 = r5
        r6 = 48
        goto L_0x01e6
    L_0x01a6:
        r5 = r0
        r8 = r2
        r32 = r4
        r6 = 48
        r31 = 48
        r33 = 10
        goto L_0x01ea
    L_0x01b1:
        r1 = 26085(0x65e5, float:3.6553E-41)
        if (r6 == r1) goto L_0x01e0
        r1 = 51068(0xc77c, float:7.1562E-41)
        if (r6 != r1) goto L_0x01bb
        goto L_0x01e0
    L_0x01bb:
        int r1 = r9.f2777e
        int r1 = r1 + 10
        char r1 = r9.mo11268d(r1)
        r4 = 26085(0x65e5, float:3.6553E-41)
        if (r1 == r4) goto L_0x01d7
        int r1 = r9.f2777e
        int r1 = r1 + 10
        char r1 = r9.mo11268d(r1)
        r4 = 51068(0xc77c, float:7.1562E-41)
        if (r1 != r4) goto L_0x01d5
        goto L_0x01d7
    L_0x01d5:
        r1 = 0
        return r1
    L_0x01d7:
        r8 = r3
        r31 = r5
        r32 = r6
        r33 = 11
        goto L_0x0126
    L_0x01e0:
        r6 = r2
        r8 = r3
        r32 = r5
        r31 = 48
    L_0x01e6:
        r33 = 10
        goto L_0x0147
    L_0x01ea:
        r23 = r13
        r24 = r15
        r25 = r5
        r26 = r7
        r27 = r6
        r28 = r8
        r29 = r31
        r30 = r32
        boolean r0 = m2870a(r23, r24, r25, r26, r27, r28, r29, r30)
        if (r0 != 0) goto L_0x0202
        r0 = 0
        return r0
    L_0x0202:
        r0 = r35
        r1 = r13
        r2 = r15
        r3 = r5
        r4 = r7
        r13 = 57
        r5 = r6
        r15 = 5
        r6 = r8
        r7 = r31
        r13 = 58
        r14 = 2
        r8 = r32
        r0.m2869a(r1, r2, r3, r4, r5, r6, r7, r8)
        int r0 = r9.f2777e
        int r0 = r0 + r33
        char r7 = r9.mo11268d(r0)
        r0 = 84
        if (r7 == r0) goto L_0x02cf
        r0 = 32
        if (r7 != r0) goto L_0x022b
        if (r36 != 0) goto L_0x022b
        goto L_0x02cf
    L_0x022b:
        r0 = 34
        if (r7 == r0) goto L_0x02a4
        r0 = 26
        if (r7 == r0) goto L_0x02a4
        r0 = 26085(0x65e5, float:3.6553E-41)
        if (r7 == r0) goto L_0x02a4
        r0 = 51068(0xc77c, float:7.1562E-41)
        if (r7 != r0) goto L_0x023d
        goto L_0x02a4
    L_0x023d:
        r0 = 43
        if (r7 == r0) goto L_0x0246
        if (r7 != r12) goto L_0x0244
        goto L_0x0246
    L_0x0244:
        r0 = 0
        return r0
    L_0x0246:
        int r0 = r9.f2793s
        int r1 = r33 + 6
        if (r0 != r1) goto L_0x02a2
        int r0 = r9.f2777e
        int r0 = r0 + r33
        int r0 = r0 + 3
        char r0 = r9.mo11268d(r0)
        if (r0 != r13) goto L_0x02a0
        int r0 = r9.f2777e
        int r0 = r0 + r33
        int r0 = r0 + 4
        char r0 = r9.mo11268d(r0)
        r1 = 48
        if (r0 != r1) goto L_0x02a0
        int r0 = r9.f2777e
        int r0 = r0 + r33
        int r0 = r0 + r15
        char r0 = r9.mo11268d(r0)
        if (r0 == r1) goto L_0x0272
        goto L_0x02a0
    L_0x0272:
        r1 = 48
        r2 = 48
        r3 = 48
        r4 = 48
        r5 = 48
        r6 = 48
        r0 = r35
        r0.mo11287a(r1, r2, r3, r4, r5, r6)
        java.util.Calendar r0 = r9.f2783k
        r1 = 0
        r0.set(r11, r1)
        int r0 = r9.f2777e
        int r0 = r0 + r33
        r1 = 1
        int r0 = r0 + r1
        char r0 = r9.mo11268d(r0)
        int r2 = r9.f2777e
        int r2 = r2 + r33
        int r2 = r2 + r14
        char r2 = r9.mo11268d(r2)
        r9.mo11285a(r7, r0, r2)
        return r1
    L_0x02a0:
        r0 = 0
        return r0
    L_0x02a2:
        r0 = 0
        return r0
    L_0x02a4:
        r0 = 0
        java.util.Calendar r1 = r9.f2783k
        r2 = 11
        r1.set(r2, r0)
        java.util.Calendar r1 = r9.f2783k
        r2 = 12
        r1.set(r2, r0)
        java.util.Calendar r1 = r9.f2783k
        r2 = 13
        r1.set(r2, r0)
        java.util.Calendar r1 = r9.f2783k
        r1.set(r11, r0)
        int r0 = r9.f2777e
        int r0 = r0 + r33
        r9.f2777e = r0
        char r0 = r9.mo11268d(r0)
        r9.f2776d = r0
        r9.f2773a = r15
        goto L_0x00c6
    L_0x02cf:
        int r7 = r33 + 9
        if (r10 >= r7) goto L_0x02d5
        r0 = 0
        return r0
    L_0x02d5:
        r0 = 0
        int r1 = r9.f2777e
        int r1 = r1 + r33
        int r1 = r1 + 3
        char r1 = r9.mo11268d(r1)
        if (r1 == r13) goto L_0x02e3
        return r0
    L_0x02e3:
        int r1 = r9.f2777e
        int r1 = r1 + r33
        int r1 = r1 + 6
        char r1 = r9.mo11268d(r1)
        if (r1 == r13) goto L_0x02f0
        return r0
    L_0x02f0:
        int r0 = r9.f2777e
        int r0 = r0 + r33
        r1 = 1
        int r0 = r0 + r1
        char r8 = r9.mo11268d(r0)
        int r0 = r9.f2777e
        int r0 = r0 + r33
        int r0 = r0 + r14
        char r21 = r9.mo11268d(r0)
        int r0 = r9.f2777e
        int r0 = r0 + r33
        int r0 = r0 + 4
        char r22 = r9.mo11268d(r0)
        int r0 = r9.f2777e
        int r0 = r0 + r33
        int r0 = r0 + r15
        char r23 = r9.mo11268d(r0)
        int r0 = r9.f2777e
        int r0 = r0 + r33
        int r0 = r0 + 7
        char r24 = r9.mo11268d(r0)
        int r0 = r9.f2777e
        int r0 = r0 + r33
        r1 = 8
        int r0 = r0 + r1
        char r18 = r9.mo11268d(r0)
        r0 = r35
        r1 = r8
        r2 = r21
        r3 = r22
        r4 = r23
        r5 = r24
        r6 = r18
        boolean r0 = r0.m2873b(r1, r2, r3, r4, r5, r6)
        if (r0 != 0) goto L_0x0340
        r0 = 0
        return r0
    L_0x0340:
        r0 = r35
        r1 = r8
        r2 = r21
        r3 = r22
        r4 = r23
        r5 = r24
        r6 = r18
        r0.mo11287a(r1, r2, r3, r4, r5, r6)
        int r0 = r9.f2777e
        int r0 = r0 + r33
        r1 = 9
        int r0 = r0 + r1
        char r0 = r9.mo11268d(r0)
        r1 = 46
        if (r0 != r1) goto L_0x04a9
        int r0 = r33 + 11
        if (r10 >= r0) goto L_0x0365
        r1 = 0
        return r1
    L_0x0365:
        int r1 = r9.f2777e
        int r1 = r1 + r33
        int r1 = r1 + 10
        char r1 = r9.mo11268d(r1)
        r2 = 48
        if (r1 < r2) goto L_0x04a7
        r3 = 57
        if (r1 <= r3) goto L_0x0379
        goto L_0x04a7
    L_0x0379:
        int r1 = r1 - r2
        if (r10 <= r0) goto L_0x0391
        int r0 = r9.f2777e
        int r0 = r0 + r33
        r4 = 11
        int r0 = r0 + r4
        char r0 = r9.mo11268d(r0)
        if (r0 < r2) goto L_0x0391
        if (r0 > r3) goto L_0x0391
        int r1 = r1 * 10
        int r0 = r0 - r2
        int r1 = r1 + r0
        r0 = 2
        goto L_0x0392
    L_0x0391:
        r0 = 1
    L_0x0392:
        if (r0 != r14) goto L_0x03ac
        int r2 = r9.f2777e
        int r2 = r2 + r33
        int r2 = r2 + 12
        char r2 = r9.mo11268d(r2)
        r3 = 48
        if (r2 < r3) goto L_0x03ac
        r4 = 57
        if (r2 > r4) goto L_0x03ac
        int r1 = r1 * 10
        int r2 = r2 - r3
        int r1 = r1 + r2
        r6 = 3
        goto L_0x03ad
    L_0x03ac:
        r6 = r0
    L_0x03ad:
        java.util.Calendar r0 = r9.f2783k
        r0.set(r11, r1)
        int r0 = r9.f2777e
        int r0 = r0 + r33
        int r0 = r0 + 10
        int r0 = r0 + r6
        char r1 = r9.mo11268d(r0)
        r0 = 43
        if (r1 == r0) goto L_0x03ed
        if (r1 != r12) goto L_0x03c4
        goto L_0x03ed
    L_0x03c4:
        r0 = 90
        if (r1 != r0) goto L_0x03ea
        java.util.Calendar r0 = r9.f2783k
        java.util.TimeZone r0 = r0.getTimeZone()
        int r0 = r0.getRawOffset()
        if (r0 == 0) goto L_0x03e7
        r0 = 0
        java.lang.String[] r1 = java.util.TimeZone.getAvailableIDs(r0)
        int r2 = r1.length
        if (r2 <= 0) goto L_0x03e7
        r1 = r1[r0]
        java.util.TimeZone r0 = java.util.TimeZone.getTimeZone(r1)
        java.util.Calendar r1 = r9.f2783k
        r1.setTimeZone(r0)
    L_0x03e7:
        r12 = 1
        goto L_0x047b
    L_0x03ea:
        r12 = 0
        goto L_0x047b
    L_0x03ed:
        int r0 = r9.f2777e
        int r0 = r0 + r33
        int r0 = r0 + 10
        int r0 = r0 + r6
        r2 = 1
        int r0 = r0 + r2
        char r2 = r9.mo11268d(r0)
        r0 = 48
        if (r2 < r0) goto L_0x04a5
        r3 = 49
        if (r2 <= r3) goto L_0x0404
        goto L_0x04a5
    L_0x0404:
        int r3 = r9.f2777e
        int r3 = r3 + r33
        int r3 = r3 + 10
        int r3 = r3 + r6
        int r3 = r3 + r14
        char r3 = r9.mo11268d(r3)
        if (r3 < r0) goto L_0x04a3
        r0 = 57
        if (r3 <= r0) goto L_0x0418
        goto L_0x04a3
    L_0x0418:
        int r0 = r9.f2777e
        int r0 = r0 + r33
        int r0 = r0 + 10
        int r0 = r0 + r6
        int r0 = r0 + 3
        char r0 = r9.mo11268d(r0)
        if (r0 != r13) goto L_0x0453
        int r0 = r9.f2777e
        int r0 = r0 + r33
        int r0 = r0 + 10
        int r0 = r0 + r6
        int r0 = r0 + 4
        char r0 = r9.mo11268d(r0)
        r4 = 48
        if (r0 == r4) goto L_0x043e
        r4 = 51
        if (r0 == r4) goto L_0x043e
        r4 = 0
        return r4
    L_0x043e:
        r4 = 0
        int r5 = r9.f2777e
        int r5 = r5 + r33
        int r5 = r5 + 10
        int r5 = r5 + r6
        int r5 = r5 + r15
        char r5 = r9.mo11268d(r5)
        r7 = 48
        if (r5 == r7) goto L_0x0450
        return r4
    L_0x0450:
        r4 = r0
        r12 = 6
        goto L_0x0476
    L_0x0453:
        r7 = 48
        if (r0 != r7) goto L_0x0471
        int r0 = r9.f2777e
        int r0 = r0 + r33
        int r0 = r0 + 10
        int r0 = r0 + r6
        int r0 = r0 + 4
        char r0 = r9.mo11268d(r0)
        if (r0 == r7) goto L_0x046c
        r4 = 51
        if (r0 == r4) goto L_0x046c
        r4 = 0
        return r4
    L_0x046c:
        r4 = r0
        r5 = 48
        r12 = 5
        goto L_0x0476
    L_0x0471:
        r4 = 48
        r5 = 48
        r12 = 3
    L_0x0476:
        r0 = r35
        r0.mo11286a(r1, r2, r3, r4, r5)
    L_0x047b:
        int r0 = r9.f2777e
        int r33 = r33 + 10
        int r33 = r33 + r6
        int r33 = r33 + r12
        int r0 = r0 + r33
        char r0 = r9.mo11268d(r0)
        r1 = 26
        if (r0 == r1) goto L_0x0493
        r1 = 34
        if (r0 == r1) goto L_0x0493
        r1 = 0
        return r1
    L_0x0493:
        int r0 = r9.f2777e
        int r0 = r0 + r33
        r9.f2777e = r0
        char r0 = r9.mo11268d(r0)
        r9.f2776d = r0
        r9.f2773a = r15
        goto L_0x00c6
    L_0x04a3:
        r1 = 0
        return r1
    L_0x04a5:
        r1 = 0
        return r1
    L_0x04a7:
        r1 = 0
        return r1
    L_0x04a9:
        r1 = 0
        java.util.Calendar r2 = r9.f2783k
        r2.set(r11, r1)
        int r1 = r9.f2777e
        int r1 = r1 + r7
        r9.f2777e = r1
        char r1 = r9.mo11268d(r1)
        r9.f2776d = r1
        r9.f2773a = r15
        r1 = 90
        if (r0 != r1) goto L_0x04df
        java.util.Calendar r0 = r9.f2783k
        java.util.TimeZone r0 = r0.getTimeZone()
        int r0 = r0.getRawOffset()
        if (r0 == 0) goto L_0x04df
        r0 = 0
        java.lang.String[] r1 = java.util.TimeZone.getAvailableIDs(r0)
        int r2 = r1.length
        if (r2 <= 0) goto L_0x04df
        r0 = r1[r0]
        java.util.TimeZone r0 = java.util.TimeZone.getTimeZone(r0)
        java.util.Calendar r1 = r9.f2783k
        r1.setTimeZone(r0)
    L_0x04df:
        r0 = 1
        return r0
    L_0x04e1:
        r14 = r13
    L_0x04e2:
        r8 = 57
        r13 = 58
        if (r36 == 0) goto L_0x04ea
        r5 = 0
        return r5
    L_0x04ea:
        int r5 = r9.f2777e
        r16 = 8
        int r5 = r5 + 8
        char r16 = r9.mo11268d(r5)
        if (r1 != r12) goto L_0x04fa
        if (r4 != r12) goto L_0x04fa
        r5 = 1
        goto L_0x04fb
    L_0x04fa:
        r5 = 0
    L_0x04fb:
        if (r5 == 0) goto L_0x0503
        r12 = 16
        if (r10 != r12) goto L_0x0503
        r12 = 1
        goto L_0x0504
    L_0x0503:
        r12 = 0
    L_0x0504:
        if (r5 == 0) goto L_0x050d
        r5 = 17
        if (r10 != r5) goto L_0x050d
        r17 = 1
        goto L_0x050f
    L_0x050d:
        r17 = 0
    L_0x050f:
        if (r17 != 0) goto L_0x051d
        if (r12 == 0) goto L_0x0514
        goto L_0x051d
    L_0x0514:
        r20 = r1
        r21 = r2
        r22 = r3
        r23 = r4
        goto L_0x052e
    L_0x051d:
        int r1 = r9.f2777e
        r4 = 9
        int r1 = r1 + r4
        char r1 = r9.mo11268d(r1)
        r23 = r1
        r20 = r2
        r21 = r3
        r22 = r16
    L_0x052e:
        r1 = r14
        r2 = r15
        r3 = r0
        r4 = r7
        r5 = r20
        r6 = r21
        r24 = r7
        r7 = r22
        r8 = r23
        boolean r1 = m2870a(r1, r2, r3, r4, r5, r6, r7, r8)
        if (r1 != 0) goto L_0x0544
        r1 = 0
        return r1
    L_0x0544:
        r3 = r0
        r0 = r35
        r1 = r14
        r2 = r15
        r4 = r24
        r5 = r20
        r6 = r21
        r7 = r22
        r8 = r23
        r0.m2869a(r1, r2, r3, r4, r5, r6, r7, r8)
        r0 = 8
        if (r10 == r0) goto L_0x062b
        int r0 = r9.f2777e
        r1 = 9
        int r0 = r0 + r1
        char r0 = r9.mo11268d(r0)
        int r1 = r9.f2777e
        int r1 = r1 + 10
        char r1 = r9.mo11268d(r1)
        int r2 = r9.f2777e
        r3 = 11
        int r2 = r2 + r3
        char r2 = r9.mo11268d(r2)
        int r3 = r9.f2777e
        int r3 = r3 + 12
        char r3 = r9.mo11268d(r3)
        int r4 = r9.f2777e
        int r4 = r4 + 13
        char r4 = r9.mo11268d(r4)
        if (r17 == 0) goto L_0x0598
        r5 = 84
        if (r1 != r5) goto L_0x0598
        if (r4 != r13) goto L_0x0598
        int r5 = r9.f2777e
        int r5 = r5 + 16
        char r5 = r9.mo11268d(r5)
        r6 = 90
        if (r5 == r6) goto L_0x05a4
    L_0x0598:
        if (r12 == 0) goto L_0x05bd
        r5 = 32
        if (r1 == r5) goto L_0x05a2
        r5 = 84
        if (r1 != r5) goto L_0x05bd
    L_0x05a2:
        if (r4 != r13) goto L_0x05bd
    L_0x05a4:
        int r0 = r9.f2777e
        int r0 = r0 + r11
        char r0 = r9.mo11268d(r0)
        int r1 = r9.f2777e
        int r1 = r1 + 15
        char r1 = r9.mo11268d(r1)
        r8 = r0
        r12 = r1
        r16 = r2
        r7 = r3
        r13 = 48
        r14 = 48
        goto L_0x05c2
    L_0x05bd:
        r7 = r0
        r8 = r1
        r12 = r2
        r13 = r3
        r14 = r4
    L_0x05c2:
        r0 = r35
        r1 = r16
        r2 = r7
        r3 = r8
        r4 = r12
        r5 = r13
        r6 = r14
        boolean r0 = r0.m2873b(r1, r2, r3, r4, r5, r6)
        if (r0 != 0) goto L_0x05d3
        r0 = 0
        return r0
    L_0x05d3:
        r0 = 17
        if (r10 != r0) goto L_0x0613
        if (r17 != 0) goto L_0x0613
        int r0 = r9.f2777e
        int r0 = r0 + r11
        char r0 = r9.mo11268d(r0)
        int r1 = r9.f2777e
        int r1 = r1 + 15
        char r1 = r9.mo11268d(r1)
        int r2 = r9.f2777e
        int r2 = r2 + 16
        char r2 = r9.mo11268d(r2)
        r3 = 48
        if (r0 < r3) goto L_0x0611
        r4 = 57
        if (r0 <= r4) goto L_0x05f9
        goto L_0x0611
    L_0x05f9:
        if (r1 < r3) goto L_0x060f
        if (r1 <= r4) goto L_0x05fe
        goto L_0x060f
    L_0x05fe:
        if (r2 < r3) goto L_0x060d
        if (r2 <= r4) goto L_0x0603
        goto L_0x060d
    L_0x0603:
        int r0 = r0 - r3
        int r0 = r0 * 100
        int r1 = r1 - r3
        int r1 = r1 * 10
        int r0 = r0 + r1
        int r2 = r2 - r3
        int r0 = r0 + r2
        goto L_0x0615
    L_0x060d:
        r5 = 0
        return r5
    L_0x060f:
        r5 = 0
        return r5
    L_0x0611:
        r5 = 0
        return r5
    L_0x0613:
        r5 = 0
        r0 = 0
    L_0x0615:
        r1 = 48
        int r16 = r16 + -48
        int r16 = r16 * 10
        int r7 = r7 - r1
        int r2 = r16 + r7
        int r8 = r8 - r1
        int r8 = r8 * 10
        int r12 = r12 - r1
        int r12 = r12 + r8
        int r13 = r13 - r1
        int r13 = r13 * 10
        int r14 = r14 - r1
        int r1 = r13 + r14
        r5 = r12
        goto L_0x062f
    L_0x062b:
        r5 = 0
        r0 = 0
        r1 = 0
        r2 = 0
    L_0x062f:
        java.util.Calendar r3 = r9.f2783k
        r4 = 11
        r3.set(r4, r2)
        java.util.Calendar r2 = r9.f2783k
        r3 = 12
        r2.set(r3, r5)
        java.util.Calendar r2 = r9.f2783k
        r3 = 13
        r2.set(r3, r1)
        java.util.Calendar r1 = r9.f2783k
        r1.set(r11, r0)
        r0 = 5
        r9.f2773a = r0
        goto L_0x00c6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.m2872a(boolean, int):boolean");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo11287a(char c, char c2, char c3, char c4, char c5, char c6) {
        int i = ((c3 - '0') * 10) + (c4 - '0');
        int i2 = ((c5 - '0') * 10) + (c6 - '0');
        this.f2783k.set(11, ((c - '0') * 10) + (c2 - '0'));
        this.f2783k.set(12, i);
        this.f2783k.set(13, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo11285a(char c, char c2, char c3) {
        mo11286a(c, c2, c3, '0', '0');
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo11286a(char c, char c2, char c3, char c4, char c5) {
        int i = ((((c2 - '0') * 10) + (c3 - '0')) * AdConfigData.DEFAULT_REQUEST_INTERVAL * 1000) + ((((c4 - '0') * 10) + (c5 - '0')) * 60 * 1000);
        if (c == '-') {
            i = -i;
        }
        if (this.f2783k.getTimeZone().getRawOffset() != i) {
            String[] availableIDs = TimeZone.getAvailableIDs(i);
            if (availableIDs.length > 0) {
                this.f2783k.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
            }
        }
    }

    /* renamed from: a */
    private void m2869a(char c, char c2, char c3, char c4, char c5, char c6, char c7, char c8) {
        this.f2783k = Calendar.getInstance(this.f2784l, this.f2785m);
        int i = (((c5 - '0') * 10) + (c6 - '0')) - 1;
        int i2 = ((c7 - '0') * 10) + (c8 - '0');
        this.f2783k.set(1, ((c - '0') * 1000) + ((c2 - '0') * 100) + ((c3 - '0') * 10) + (c4 - '0'));
        this.f2783k.set(2, i);
        this.f2783k.set(5, i2);
    }

    /* renamed from: C */
    public boolean mo11249C() {
        if (this.f2777e != this.f2793s) {
            return this.f2776d == 26 && this.f2777e + 1 == this.f2793s;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00af  */
    /* renamed from: d */
    public int mo11269d(char[] r14) {
        /*
        r13 = this;
        r0 = 0
        r13.f2786n = r0
        int r1 = r13.f2777e
        char r2 = r13.f2776d
        java.lang.String r3 = r13.f2792r
        int r4 = r13.f2777e
        boolean r3 = m2871a(r3, r4, r14)
        if (r3 != 0) goto L_0x0015
        r14 = -2
        r13.f2786n = r14
        return r0
    L_0x0015:
        int r3 = r13.f2777e
        int r14 = r14.length
        int r3 = r3 + r14
        int r14 = r3 + 1
        char r3 = r13.mo11268d(r3)
        r4 = 34
        r5 = 1
        if (r3 != r4) goto L_0x0026
        r6 = 1
        goto L_0x0027
    L_0x0026:
        r6 = 0
    L_0x0027:
        if (r6 == 0) goto L_0x0030
        int r3 = r14 + 1
        char r14 = r13.mo11268d(r14)
        goto L_0x0033
    L_0x0030:
        r12 = r3
        r3 = r14
        r14 = r12
    L_0x0033:
        r7 = 45
        if (r14 != r7) goto L_0x0039
        r7 = 1
        goto L_0x003a
    L_0x0039:
        r7 = 0
    L_0x003a:
        if (r7 == 0) goto L_0x0045
        int r14 = r3 + 1
        char r3 = r13.mo11268d(r3)
        r12 = r3
        r3 = r14
        r14 = r12
    L_0x0045:
        r8 = 48
        r9 = -1
        if (r14 < r8) goto L_0x0119
        r10 = 57
        if (r14 > r10) goto L_0x0119
        int r14 = r14 - r8
    L_0x004f:
        int r11 = r3 + 1
        char r3 = r13.mo11268d(r3)
        if (r3 < r8) goto L_0x0060
        if (r3 > r10) goto L_0x0060
        int r14 = r14 * 10
        int r3 = r3 + -48
        int r14 = r14 + r3
        r3 = r11
        goto L_0x004f
    L_0x0060:
        r8 = 46
        if (r3 != r8) goto L_0x0067
        r13.f2786n = r9
        return r0
    L_0x0067:
        if (r14 >= 0) goto L_0x006c
        r13.f2786n = r9
        return r0
    L_0x006c:
        if (r6 == 0) goto L_0x007b
        if (r3 == r4) goto L_0x0073
        r13.f2786n = r9
        return r0
    L_0x0073:
        int r3 = r11 + 1
        char r4 = r13.mo11268d(r11)
    L_0x0079:
        r11 = r3
        r3 = r4
    L_0x007b:
        r4 = 125(0x7d, float:1.75E-43)
        r6 = 44
        if (r3 == r6) goto L_0x0094
        if (r3 != r4) goto L_0x0084
        goto L_0x0094
    L_0x0084:
        boolean r3 = m2776j(r3)
        if (r3 == 0) goto L_0x0091
        int r3 = r11 + 1
        char r4 = r13.mo11268d(r11)
        goto L_0x0079
    L_0x0091:
        r13.f2786n = r9
        return r0
    L_0x0094:
        int r11 = r11 - r5
        r13.f2777e = r11
        r8 = 16
        if (r3 != r6) goto L_0x00af
        int r0 = r13.f2777e
        int r0 = r0 + r5
        r13.f2777e = r0
        char r0 = r13.mo11268d(r0)
        r13.f2776d = r0
        r0 = 3
        r13.f2786n = r0
        r13.f2773a = r8
        if (r7 == 0) goto L_0x00ae
        int r14 = -r14
    L_0x00ae:
        return r14
    L_0x00af:
        if (r3 != r4) goto L_0x0115
        r13.f2777e = r11
        int r3 = r13.f2777e
        int r3 = r3 + r5
        r13.f2777e = r3
        char r3 = r13.mo11268d(r3)
    L_0x00bc:
        if (r3 != r6) goto L_0x00cc
        r13.f2773a = r8
        int r0 = r13.f2777e
        int r0 = r0 + r5
        r13.f2777e = r0
        char r0 = r13.mo11268d(r0)
        r13.f2776d = r0
        goto L_0x00fa
    L_0x00cc:
        r10 = 93
        if (r3 != r10) goto L_0x00e0
        r0 = 15
        r13.f2773a = r0
        int r0 = r13.f2777e
        int r0 = r0 + r5
        r13.f2777e = r0
        char r0 = r13.mo11268d(r0)
        r13.f2776d = r0
        goto L_0x00fa
    L_0x00e0:
        if (r3 != r4) goto L_0x00f2
        r0 = 13
        r13.f2773a = r0
        int r0 = r13.f2777e
        int r0 = r0 + r5
        r13.f2777e = r0
        char r0 = r13.mo11268d(r0)
        r13.f2776d = r0
        goto L_0x00fa
    L_0x00f2:
        r10 = 26
        if (r3 != r10) goto L_0x00fe
        r0 = 20
        r13.f2773a = r0
    L_0x00fa:
        r0 = 4
        r13.f2786n = r0
        goto L_0x0115
    L_0x00fe:
        boolean r3 = m2776j(r3)
        if (r3 == 0) goto L_0x010e
        int r3 = r13.f2777e
        int r3 = r3 + r5
        r13.f2777e = r3
        char r3 = r13.mo11268d(r3)
        goto L_0x00bc
    L_0x010e:
        r13.f2777e = r1
        r13.f2776d = r2
        r13.f2786n = r9
        return r0
    L_0x0115:
        if (r7 == 0) goto L_0x0118
        int r14 = -r14
    L_0x0118:
        return r14
    L_0x0119:
        r13.f2786n = r9
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.mo11269d(char[]):int");
    }

    /* renamed from: b */
    public String mo11265b(char[] cArr) {
        this.f2786n = 0;
        int i = this.f2777e;
        char c = this.f2776d;
        while (!m2871a(this.f2792r, this.f2777e, cArr)) {
            if (m2776j(this.f2776d)) {
                mo11225f();
            } else {
                this.f2786n = -2;
                return mo11247A();
            }
        }
        int length = this.f2777e + cArr.length;
        int i2 = length + 1;
        if (mo11268d(length) != '\"') {
            this.f2786n = -1;
            return mo11247A();
        }
        int a = mo11257a('\"', i2);
        if (a != -1) {
            String a2 = mo11258a(i2, a - i2);
            if (a2.indexOf(92) != -1) {
                while (true) {
                    int i3 = a - 1;
                    int i4 = 0;
                    while (i3 >= 0 && mo11268d(i3) == '\\') {
                        i4++;
                        i3--;
                    }
                    if (i4 % 2 == 0) {
                        break;
                    }
                    a = mo11257a('\"', a + 1);
                }
                int length2 = a - ((this.f2777e + cArr.length) + 1);
                a2 = m2775a(mo11266b(this.f2777e + cArr.length + 1, length2), length2);
            }
            char d = mo11268d(a + 1);
            while (d != ',' && d != '}') {
                if (m2776j(d)) {
                    a++;
                    d = mo11268d(a + 1);
                } else {
                    this.f2786n = -1;
                    return mo11247A();
                }
            }
            this.f2777e = a + 1;
            this.f2776d = d;
            if (d == ',') {
                int i5 = this.f2777e + 1;
                this.f2777e = i5;
                this.f2776d = mo11268d(i5);
                this.f2786n = 3;
                return a2;
            }
            int i6 = this.f2777e + 1;
            this.f2777e = i6;
            char d2 = mo11268d(i6);
            if (d2 == ',') {
                this.f2773a = 16;
                int i7 = this.f2777e + 1;
                this.f2777e = i7;
                this.f2776d = mo11268d(i7);
            } else if (d2 == ']') {
                this.f2773a = 15;
                int i8 = this.f2777e + 1;
                this.f2777e = i8;
                this.f2776d = mo11268d(i8);
            } else if (d2 == '}') {
                this.f2773a = 13;
                int i9 = this.f2777e + 1;
                this.f2777e = i9;
                this.f2776d = mo11268d(i9);
            } else if (d2 == 26) {
                this.f2773a = 20;
            } else {
                this.f2777e = i;
                this.f2776d = c;
                this.f2786n = -1;
                return mo11247A();
            }
            this.f2786n = 4;
            return a2;
        }
        throw new JSONException("unclosed str");
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e5  */
    /* renamed from: n */
    public java.util.Date mo11281n(char[] r20) {
        /*
        r19 = this;
        r0 = r19
        r1 = r20
        r2 = 0
        r0.f2786n = r2
        int r3 = r0.f2777e
        char r4 = r0.f2776d
        java.lang.String r5 = r0.f2792r
        int r6 = r0.f2777e
        boolean r5 = m2871a(r5, r6, r1)
        r6 = 0
        if (r5 != 0) goto L_0x001a
        r1 = -2
        r0.f2786n = r1
        return r6
    L_0x001a:
        int r5 = r0.f2777e
        int r1 = r1.length
        int r5 = r5 + r1
        int r1 = r5 + 1
        char r5 = r0.mo11268d(r5)
        r7 = 34
        r8 = 125(0x7d, float:1.75E-43)
        r9 = 44
        r10 = -1
        r11 = 1
        if (r5 != r7) goto L_0x007b
        int r5 = r0.mo11257a(r7, r1)
        if (r5 == r10) goto L_0x0073
        int r7 = r5 - r1
        r0.f2777e = r1
        boolean r1 = r0.m2872a(r2, r7)
        if (r1 == 0) goto L_0x006e
        java.util.Calendar r1 = r0.f2783k
        java.util.Date r1 = r1.getTime()
        int r2 = r5 + 1
        char r2 = r0.mo11268d(r2)
        r0.f2777e = r3
    L_0x004c:
        if (r2 == r9) goto L_0x0063
        if (r2 != r8) goto L_0x0051
        goto L_0x0063
    L_0x0051:
        boolean r2 = m2776j(r2)
        if (r2 == 0) goto L_0x0060
        int r5 = r5 + 1
        int r2 = r5 + 1
        char r2 = r0.mo11268d(r2)
        goto L_0x004c
    L_0x0060:
        r0.f2786n = r10
        return r6
    L_0x0063:
        int r5 = r5 + r11
        r0.f2777e = r5
        r0.f2776d = r2
        r18 = r2
        r2 = r1
        r1 = r18
        goto L_0x00d0
    L_0x006e:
        r0.f2777e = r3
        r0.f2786n = r10
        return r6
    L_0x0073:
        com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException
        java.lang.String r2 = "unclosed str"
        r1.m41526init(r2)
        throw r1
    L_0x007b:
        r7 = 45
        r12 = 57
        r13 = 48
        if (r5 == r7) goto L_0x008b
        if (r5 < r13) goto L_0x0088
        if (r5 > r12) goto L_0x0088
        goto L_0x008b
    L_0x0088:
        r0.f2786n = r10
        return r6
    L_0x008b:
        if (r5 != r7) goto L_0x0095
        int r2 = r1 + 1
        char r5 = r0.mo11268d(r1)
        r1 = r2
        r2 = 1
    L_0x0095:
        r14 = 0
        if (r5 < r13) goto L_0x00be
        if (r5 > r12) goto L_0x00be
        int r5 = r5 + -48
        long r6 = (long) r5
    L_0x009e:
        int r5 = r1 + 1
        char r1 = r0.mo11268d(r1)
        if (r1 < r13) goto L_0x00b6
        if (r1 > r12) goto L_0x00b6
        r16 = 10
        long r6 = r6 * r16
        int r1 = r1 + -48
        long r12 = (long) r1
        long r6 = r6 + r12
        r1 = r5
        r12 = 57
        r13 = 48
        goto L_0x009e
    L_0x00b6:
        if (r1 == r9) goto L_0x00ba
        if (r1 != r8) goto L_0x00c0
    L_0x00ba:
        int r5 = r5 - r11
        r0.f2777e = r5
        goto L_0x00c0
    L_0x00be:
        r1 = r5
        r6 = r14
    L_0x00c0:
        int r5 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
        if (r5 >= 0) goto L_0x00c8
        r0.f2786n = r10
    L_0x00c6:
        r1 = 0
        return r1
    L_0x00c8:
        if (r2 == 0) goto L_0x00cb
        long r6 = -r6
    L_0x00cb:
        java.util.Date r2 = new java.util.Date
        r2.<init>(r6)
    L_0x00d0:
        r5 = 16
        if (r1 != r9) goto L_0x00e5
        int r1 = r0.f2777e
        int r1 = r1 + r11
        r0.f2777e = r1
        char r1 = r0.mo11268d(r1)
        r0.f2776d = r1
        r1 = 3
        r0.f2786n = r1
        r0.f2773a = r5
        return r2
    L_0x00e5:
        int r1 = r0.f2777e
        int r1 = r1 + r11
        r0.f2777e = r1
        char r1 = r0.mo11268d(r1)
        if (r1 != r9) goto L_0x00fe
        r0.f2773a = r5
        int r1 = r0.f2777e
        int r1 = r1 + r11
        r0.f2777e = r1
        char r1 = r0.mo11268d(r1)
        r0.f2776d = r1
        goto L_0x012c
    L_0x00fe:
        r5 = 93
        if (r1 != r5) goto L_0x0112
        r1 = 15
        r0.f2773a = r1
        int r1 = r0.f2777e
        int r1 = r1 + r11
        r0.f2777e = r1
        char r1 = r0.mo11268d(r1)
        r0.f2776d = r1
        goto L_0x012c
    L_0x0112:
        if (r1 != r8) goto L_0x0124
        r1 = 13
        r0.f2773a = r1
        int r1 = r0.f2777e
        int r1 = r1 + r11
        r0.f2777e = r1
        char r1 = r0.mo11268d(r1)
        r0.f2776d = r1
        goto L_0x012c
    L_0x0124:
        r5 = 26
        if (r1 != r5) goto L_0x0130
        r1 = 20
        r0.f2773a = r1
    L_0x012c:
        r1 = 4
        r0.f2786n = r1
        return r2
    L_0x0130:
        r0.f2777e = r3
        r0.f2776d = r4
        r0.f2786n = r10
        goto L_0x00c6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.mo11281n(char[]):java.util.Date");
    }

    /* renamed from: c */
    public long mo11267c(char[] cArr) {
        this.f2786n = 0;
        if (!m2871a(this.f2792r, this.f2777e, cArr)) {
            this.f2786n = -2;
            return 0;
        }
        int length = this.f2777e + cArr.length;
        int i = length + 1;
        if (mo11268d(length) != '\"') {
            this.f2786n = -1;
            return 0;
        }
        long j = -3750763034362895579L;
        while (true) {
            int i2 = i + 1;
            char d = mo11268d(i);
            if (d == '\"') {
                this.f2777e = i2;
                char d2 = mo11268d(this.f2777e);
                this.f2776d = d2;
                while (d2 != ',') {
                    if (d2 == '}') {
                        mo11225f();
                        mo11218c();
                        char e = mo11223e();
                        if (e == ',') {
                            this.f2773a = 16;
                            int i3 = this.f2777e + 1;
                            this.f2777e = i3;
                            this.f2776d = mo11268d(i3);
                        } else if (e == ']') {
                            this.f2773a = 15;
                            int i4 = this.f2777e + 1;
                            this.f2777e = i4;
                            this.f2776d = mo11268d(i4);
                        } else if (e == '}') {
                            this.f2773a = 13;
                            int i5 = this.f2777e + 1;
                            this.f2777e = i5;
                            this.f2776d = mo11268d(i5);
                        } else if (e == 26) {
                            this.f2773a = 20;
                        } else {
                            this.f2786n = -1;
                            return 0;
                        }
                        this.f2786n = 4;
                        return j;
                    } else if (m2776j(d2)) {
                        int i6 = this.f2777e + 1;
                        this.f2777e = i6;
                        d2 = mo11268d(i6);
                    } else {
                        this.f2786n = -1;
                        return 0;
                    }
                }
                int i7 = this.f2777e + 1;
                this.f2777e = i7;
                this.f2776d = mo11268d(i7);
                this.f2786n = 3;
                return j;
            } else if (i2 > this.f2793s) {
                this.f2786n = -1;
                return 0;
            } else {
                j = (j ^ ((long) d)) * 1099511628211L;
                i = i2;
            }
        }
    }

    /* renamed from: g */
    public long mo11272g(char[] cArr) {
        int i;
        char c;
        boolean z;
        long j;
        int i2;
        char d;
        int i3;
        char c2;
        char[] cArr2 = cArr;
        this.f2786n = 0;
        int i4 = this.f2777e;
        char c3 = this.f2776d;
        if (!m2871a(this.f2792r, this.f2777e, cArr2)) {
            this.f2786n = -2;
            return 0;
        }
        int length = this.f2777e + cArr2.length;
        int i5 = length + 1;
        char d2 = mo11268d(length);
        boolean z2 = d2 == '\"';
        if (z2) {
            i = i5 + 1;
            c = mo11268d(i5);
        } else {
            char c4 = d2;
            i = i5;
            c = c4;
        }
        if (c == '-') {
            int i6 = i + 1;
            z = true;
            char d3 = mo11268d(i);
            i = i6;
            c = d3;
        } else {
            z = false;
        }
        if (c >= '0') {
            char c5 = '9';
            if (c <= '9') {
                int i7 = i4;
                long j2 = (long) (c - '0');
                while (true) {
                    i2 = i + 1;
                    d = mo11268d(i);
                    if (d >= '0' && d <= c5) {
                        j2 = (j * 10) + ((long) (d - '0'));
                        i = i2;
                        c5 = '9';
                    }
                }
                if (d == '.') {
                    this.f2786n = -1;
                    return 0;
                }
                if (!z2) {
                    char c6 = d;
                    i3 = i2;
                    c2 = c6;
                } else if (d != '\"') {
                    this.f2786n = -1;
                    return 0;
                } else {
                    i3 = i2 + 1;
                    c2 = mo11268d(i2);
                }
                if (c2 == ',' || c2 == '}') {
                    this.f2777e = i3 - 1;
                }
                boolean z3 = j >= 0 || (j == Long.MIN_VALUE && z);
                if (!z3) {
                    this.f2777e = i7;
                    this.f2776d = c3;
                    this.f2786n = -1;
                    return 0;
                }
                int i8 = i7;
                while (c2 != ',') {
                    if (c2 == '}') {
                        int i9 = this.f2777e + 1;
                        this.f2777e = i9;
                        char d4 = mo11268d(i9);
                        while (true) {
                            if (d4 == ',') {
                                this.f2773a = 16;
                                int i10 = this.f2777e + 1;
                                this.f2777e = i10;
                                this.f2776d = mo11268d(i10);
                                break;
                            } else if (d4 == ']') {
                                this.f2773a = 15;
                                int i11 = this.f2777e + 1;
                                this.f2777e = i11;
                                this.f2776d = mo11268d(i11);
                                break;
                            } else if (d4 == '}') {
                                this.f2773a = 13;
                                int i12 = this.f2777e + 1;
                                this.f2777e = i12;
                                this.f2776d = mo11268d(i12);
                                break;
                            } else if (d4 == 26) {
                                this.f2773a = 20;
                                break;
                            } else if (m2776j(d4)) {
                                int i13 = this.f2777e + 1;
                                this.f2777e = i13;
                                d4 = mo11268d(i13);
                            } else {
                                this.f2777e = i8;
                                this.f2776d = c3;
                                this.f2786n = -1;
                                return 0;
                            }
                        }
                        this.f2786n = 4;
                        if (z) {
                            j = -j;
                        }
                        return j;
                    } else if (m2776j(c2)) {
                        this.f2777e = i3;
                        int i14 = i3 + 1;
                        char d5 = mo11268d(i3);
                        i3 = i14;
                        c2 = d5;
                    } else {
                        this.f2786n = -1;
                        return 0;
                    }
                }
                int i15 = this.f2777e + 1;
                this.f2777e = i15;
                this.f2776d = mo11268d(i15);
                this.f2786n = 3;
                this.f2773a = 16;
                if (z) {
                    j = -j;
                }
                return j;
            }
        }
        this.f2777e = i4;
        this.f2776d = c3;
        this.f2786n = -1;
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x00fe A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x010f  */
    /* renamed from: f */
    public boolean mo11271f(char[] r11) {
        /*
        r10 = this;
        r0 = 0
        r10.f2786n = r0
        java.lang.String r1 = r10.f2792r
        int r2 = r10.f2777e
        boolean r1 = m2871a(r1, r2, r11)
        if (r1 != 0) goto L_0x0011
        r11 = -2
        r10.f2786n = r11
        return r0
    L_0x0011:
        int r1 = r10.f2777e
        int r2 = r10.f2777e
        int r11 = r11.length
        int r2 = r2 + r11
        int r11 = r2 + 1
        char r2 = r10.mo11268d(r2)
        r3 = 34
        r4 = 1
        if (r2 != r3) goto L_0x0024
        r5 = 1
        goto L_0x0025
    L_0x0024:
        r5 = 0
    L_0x0025:
        if (r5 == 0) goto L_0x002e
        int r2 = r11 + 1
        char r11 = r10.mo11268d(r11)
        goto L_0x0031
    L_0x002e:
        r9 = r2
        r2 = r11
        r11 = r9
    L_0x0031:
        r6 = 116(0x74, float:1.63E-43)
        r7 = 101(0x65, float:1.42E-43)
        r8 = -1
        if (r11 != r6) goto L_0x0074
        int r11 = r2 + 1
        char r2 = r10.mo11268d(r2)
        r6 = 114(0x72, float:1.6E-43)
        if (r2 == r6) goto L_0x0045
        r10.f2786n = r8
        return r0
    L_0x0045:
        int r2 = r11 + 1
        char r11 = r10.mo11268d(r11)
        r6 = 117(0x75, float:1.64E-43)
        if (r11 == r6) goto L_0x0052
        r10.f2786n = r8
        return r0
    L_0x0052:
        int r11 = r2 + 1
        char r2 = r10.mo11268d(r2)
        if (r2 == r7) goto L_0x005d
        r10.f2786n = r8
        return r0
    L_0x005d:
        if (r5 == 0) goto L_0x006b
        int r2 = r11 + 1
        char r11 = r10.mo11268d(r11)
        if (r11 == r3) goto L_0x006a
        r10.f2786n = r8
        return r0
    L_0x006a:
        r11 = r2
    L_0x006b:
        r10.f2777e = r11
        int r11 = r10.f2777e
        char r11 = r10.mo11268d(r11)
        goto L_0x00db
    L_0x0074:
        r6 = 102(0x66, float:1.43E-43)
        if (r11 != r6) goto L_0x00c1
        int r11 = r2 + 1
        char r2 = r10.mo11268d(r2)
        r6 = 97
        if (r2 == r6) goto L_0x0085
        r10.f2786n = r8
        return r0
    L_0x0085:
        int r2 = r11 + 1
        char r11 = r10.mo11268d(r11)
        r6 = 108(0x6c, float:1.51E-43)
        if (r11 == r6) goto L_0x0092
        r10.f2786n = r8
        return r0
    L_0x0092:
        int r11 = r2 + 1
        char r2 = r10.mo11268d(r2)
        r6 = 115(0x73, float:1.61E-43)
        if (r2 == r6) goto L_0x009f
        r10.f2786n = r8
        return r0
    L_0x009f:
        int r2 = r11 + 1
        char r11 = r10.mo11268d(r11)
        if (r11 == r7) goto L_0x00aa
        r10.f2786n = r8
        return r0
    L_0x00aa:
        if (r5 == 0) goto L_0x00b7
        int r11 = r2 + 1
        char r2 = r10.mo11268d(r2)
        if (r2 == r3) goto L_0x00b8
        r10.f2786n = r8
        return r0
    L_0x00b7:
        r11 = r2
    L_0x00b8:
        r10.f2777e = r11
        int r11 = r10.f2777e
        char r11 = r10.mo11268d(r11)
        goto L_0x00f7
    L_0x00c1:
        r6 = 49
        if (r11 != r6) goto L_0x00dd
        if (r5 == 0) goto L_0x00d2
        int r11 = r2 + 1
        char r2 = r10.mo11268d(r2)
        if (r2 == r3) goto L_0x00d3
        r10.f2786n = r8
        return r0
    L_0x00d2:
        r11 = r2
    L_0x00d3:
        r10.f2777e = r11
        int r11 = r10.f2777e
        char r11 = r10.mo11268d(r11)
    L_0x00db:
        r2 = 1
        goto L_0x00f8
    L_0x00dd:
        r6 = 48
        if (r11 != r6) goto L_0x018c
        if (r5 == 0) goto L_0x00ee
        int r11 = r2 + 1
        char r2 = r10.mo11268d(r2)
        if (r2 == r3) goto L_0x00ef
        r10.f2786n = r8
        return r0
    L_0x00ee:
        r11 = r2
    L_0x00ef:
        r10.f2777e = r11
        int r11 = r10.f2777e
        char r11 = r10.mo11268d(r11)
    L_0x00f7:
        r2 = 0
    L_0x00f8:
        r3 = 16
        r5 = 44
        if (r11 != r5) goto L_0x010f
        int r11 = r10.f2777e
        int r11 = r11 + r4
        r10.f2777e = r11
        char r11 = r10.mo11268d(r11)
        r10.f2776d = r11
        r11 = 3
        r10.f2786n = r11
        r10.f2773a = r3
        goto L_0x015d
    L_0x010f:
        r6 = 125(0x7d, float:1.75E-43)
        if (r11 != r6) goto L_0x0171
        int r11 = r10.f2777e
        int r11 = r11 + r4
        r10.f2777e = r11
        char r11 = r10.mo11268d(r11)
    L_0x011c:
        if (r11 != r5) goto L_0x012c
        r10.f2773a = r3
        int r11 = r10.f2777e
        int r11 = r11 + r4
        r10.f2777e = r11
        char r11 = r10.mo11268d(r11)
        r10.f2776d = r11
        goto L_0x015a
    L_0x012c:
        r1 = 93
        if (r11 != r1) goto L_0x0140
        r11 = 15
        r10.f2773a = r11
        int r11 = r10.f2777e
        int r11 = r11 + r4
        r10.f2777e = r11
        char r11 = r10.mo11268d(r11)
        r10.f2776d = r11
        goto L_0x015a
    L_0x0140:
        if (r11 != r6) goto L_0x0152
        r11 = 13
        r10.f2773a = r11
        int r11 = r10.f2777e
        int r11 = r11 + r4
        r10.f2777e = r11
        char r11 = r10.mo11268d(r11)
        r10.f2776d = r11
        goto L_0x015a
    L_0x0152:
        r1 = 26
        if (r11 != r1) goto L_0x015e
        r11 = 20
        r10.f2773a = r11
    L_0x015a:
        r11 = 4
        r10.f2786n = r11
    L_0x015d:
        return r2
    L_0x015e:
        boolean r11 = m2776j(r11)
        if (r11 == 0) goto L_0x016e
        int r11 = r10.f2777e
        int r11 = r11 + r4
        r10.f2777e = r11
        char r11 = r10.mo11268d(r11)
        goto L_0x011c
    L_0x016e:
        r10.f2786n = r8
        return r0
    L_0x0171:
        boolean r11 = m2776j(r11)
        if (r11 == 0) goto L_0x0182
        int r11 = r10.f2777e
        int r11 = r11 + r4
        r10.f2777e = r11
        char r11 = r10.mo11268d(r11)
        goto L_0x00f8
    L_0x0182:
        r10.f2777e = r1
        int r11 = r10.f2777e
        r10.mo11268d(r11)
        r10.f2786n = r8
        return r0
    L_0x018c:
        r10.f2786n = r8
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.mo11271f(char[]):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ea  */
    /* renamed from: a */
    public final int mo11206a(char r13) {
        /*
        r12 = this;
        r0 = 0
        r12.f2786n = r0
        int r1 = r12.f2777e
        int r2 = r1 + 1
        char r1 = r12.mo11268d(r1)
    L_0x000b:
        boolean r3 = m2776j(r1)
        if (r3 == 0) goto L_0x001b
        int r1 = r2 + 1
        char r2 = r12.mo11268d(r2)
        r11 = r2
        r2 = r1
        r1 = r11
        goto L_0x000b
    L_0x001b:
        r3 = 34
        r4 = 1
        if (r1 != r3) goto L_0x0022
        r5 = 1
        goto L_0x0023
    L_0x0022:
        r5 = 0
    L_0x0023:
        if (r5 == 0) goto L_0x002e
        int r1 = r2 + 1
        char r2 = r12.mo11268d(r2)
        r11 = r2
        r2 = r1
        r1 = r11
    L_0x002e:
        r6 = 45
        if (r1 != r6) goto L_0x0033
        goto L_0x0034
    L_0x0033:
        r4 = 0
    L_0x0034:
        if (r4 == 0) goto L_0x003f
        int r1 = r2 + 1
        char r2 = r12.mo11268d(r2)
        r11 = r2
        r2 = r1
        r1 = r11
    L_0x003f:
        r6 = 16
        r7 = 48
        r8 = -1
        if (r1 < r7) goto L_0x00a1
        r9 = 57
        if (r1 > r9) goto L_0x00a1
        int r1 = r1 - r7
    L_0x004b:
        int r10 = r2 + 1
        char r2 = r12.mo11268d(r2)
        if (r2 < r7) goto L_0x005c
        if (r2 > r9) goto L_0x005c
        int r1 = r1 * 10
        int r2 = r2 + -48
        int r1 = r1 + r2
        r2 = r10
        goto L_0x004b
    L_0x005c:
        r7 = 46
        if (r2 != r7) goto L_0x0063
        r12.f2786n = r8
        return r0
    L_0x0063:
        if (r5 == 0) goto L_0x0071
        if (r2 == r3) goto L_0x006a
        r12.f2786n = r8
        return r0
    L_0x006a:
        int r2 = r10 + 1
        char r3 = r12.mo11268d(r10)
        goto L_0x0073
    L_0x0071:
        r3 = r2
        r2 = r10
    L_0x0073:
        if (r1 >= 0) goto L_0x0078
        r12.f2786n = r8
        return r0
    L_0x0078:
        if (r3 != r13) goto L_0x008d
        r12.f2777e = r2
        int r13 = r12.f2777e
        char r13 = r12.mo11268d(r13)
        r12.f2776d = r13
        r13 = 3
        r12.f2786n = r13
        r12.f2773a = r6
        if (r4 == 0) goto L_0x008c
        int r1 = -r1
    L_0x008c:
        return r1
    L_0x008d:
        boolean r0 = m2776j(r3)
        if (r0 == 0) goto L_0x009b
        int r0 = r2 + 1
        char r3 = r12.mo11268d(r2)
        r2 = r0
        goto L_0x0078
    L_0x009b:
        r12.f2786n = r8
        if (r4 == 0) goto L_0x00a0
        int r1 = -r1
    L_0x00a0:
        return r1
    L_0x00a1:
        r13 = 110(0x6e, float:1.54E-43)
        if (r1 != r13) goto L_0x010f
        int r13 = r2 + 1
        char r1 = r12.mo11268d(r2)
        r2 = 117(0x75, float:1.64E-43)
        if (r1 != r2) goto L_0x010f
        int r1 = r13 + 1
        char r13 = r12.mo11268d(r13)
        r2 = 108(0x6c, float:1.51E-43)
        if (r13 != r2) goto L_0x010f
        int r13 = r1 + 1
        char r1 = r12.mo11268d(r1)
        if (r1 != r2) goto L_0x010f
        r1 = 5
        r12.f2786n = r1
        int r2 = r13 + 1
        char r13 = r12.mo11268d(r13)
        if (r5 == 0) goto L_0x00d7
        if (r13 != r3) goto L_0x00d7
        int r13 = r2 + 1
        char r2 = r12.mo11268d(r2)
    L_0x00d4:
        r11 = r2
        r2 = r13
        r13 = r11
    L_0x00d7:
        r3 = 44
        if (r13 != r3) goto L_0x00ea
        r12.f2777e = r2
        int r13 = r12.f2777e
        char r13 = r12.mo11268d(r13)
        r12.f2776d = r13
        r12.f2786n = r1
        r12.f2773a = r6
        return r0
    L_0x00ea:
        r3 = 93
        if (r13 != r3) goto L_0x00ff
        r12.f2777e = r2
        int r13 = r12.f2777e
        char r13 = r12.mo11268d(r13)
        r12.f2776d = r13
        r12.f2786n = r1
        r13 = 15
        r12.f2773a = r13
        return r0
    L_0x00ff:
        boolean r13 = m2776j(r13)
        if (r13 == 0) goto L_0x010c
        int r13 = r2 + 1
        char r2 = r12.mo11268d(r2)
        goto L_0x00d4
    L_0x010c:
        r12.f2786n = r8
        return r0
    L_0x010f:
        r12.f2786n = r8
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.mo11206a(char):int");
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
    public double mo11221d(char r22) {
        /*
        r21 = this;
        r0 = r21
        r1 = 0
        r0.f2786n = r1
        int r2 = r0.f2777e
        int r3 = r2 + 1
        char r2 = r0.mo11268d(r2)
        r4 = 34
        if (r2 != r4) goto L_0x0013
        r6 = 1
        goto L_0x0014
    L_0x0013:
        r6 = 0
    L_0x0014:
        if (r6 == 0) goto L_0x0021
        int r2 = r3 + 1
        char r3 = r0.mo11268d(r3)
        r20 = r3
        r3 = r2
        r2 = r20
    L_0x0021:
        r7 = 45
        if (r2 != r7) goto L_0x0027
        r8 = 1
        goto L_0x0028
    L_0x0027:
        r8 = 0
    L_0x0028:
        if (r8 == 0) goto L_0x0035
        int r2 = r3 + 1
        char r3 = r0.mo11268d(r3)
        r20 = r3
        r3 = r2
        r2 = r20
    L_0x0035:
        r9 = 16
        r10 = 0
        r12 = -1
        r13 = 48
        if (r2 < r13) goto L_0x0118
        r14 = 57
        if (r2 > r14) goto L_0x0118
        int r2 = r2 - r13
        long r1 = (long) r2
    L_0x0044:
        int r15 = r3 + 1
        char r3 = r0.mo11268d(r3)
        r17 = 10
        if (r3 < r13) goto L_0x005a
        if (r3 > r14) goto L_0x005a
        long r1 = r1 * r17
        int r3 = r3 + -48
        long r4 = (long) r3
        long r1 = r1 + r4
        r3 = r15
        r4 = 34
        goto L_0x0044
    L_0x005a:
        r4 = 46
        if (r3 != r4) goto L_0x0060
        r4 = 1
        goto L_0x0061
    L_0x0060:
        r4 = 0
    L_0x0061:
        if (r4 == 0) goto L_0x0095
        int r3 = r15 + 1
        char r4 = r0.mo11268d(r15)
        if (r4 < r13) goto L_0x0092
        if (r4 > r14) goto L_0x0092
        long r1 = r1 * r17
        int r4 = r4 - r13
        long r4 = (long) r4
        long r1 = r1 + r4
        r4 = r17
    L_0x0074:
        int r15 = r3 + 1
        char r3 = r0.mo11268d(r3)
        if (r3 < r13) goto L_0x008d
        if (r3 > r14) goto L_0x008d
        long r1 = r1 * r17
        int r3 = r3 + -48
        r19 = r15
        long r14 = (long) r3
        long r1 = r1 + r14
        long r4 = r4 * r17
        r3 = r19
        r14 = 57
        goto L_0x0074
    L_0x008d:
        r19 = r15
        r15 = r19
        goto L_0x0097
    L_0x0092:
        r0.f2786n = r12
        return r10
    L_0x0095:
        r4 = 1
    L_0x0097:
        r14 = 101(0x65, float:1.42E-43)
        if (r3 == r14) goto L_0x00a3
        r14 = 69
        if (r3 != r14) goto L_0x00a0
        goto L_0x00a3
    L_0x00a0:
        r16 = 0
        goto L_0x00a5
    L_0x00a3:
        r16 = 1
    L_0x00a5:
        if (r16 == 0) goto L_0x00cb
        int r3 = r15 + 1
        char r14 = r0.mo11268d(r15)
        r15 = 43
        if (r14 == r15) goto L_0x00b7
        if (r14 != r7) goto L_0x00b4
        goto L_0x00b7
    L_0x00b4:
        r15 = r3
        r3 = r14
        goto L_0x00be
    L_0x00b7:
        int r7 = r3 + 1
        char r3 = r0.mo11268d(r3)
        r15 = r7
    L_0x00be:
        if (r3 < r13) goto L_0x00cb
        r7 = 57
        if (r3 > r7) goto L_0x00cb
        int r3 = r15 + 1
        char r14 = r0.mo11268d(r15)
        goto L_0x00b4
    L_0x00cb:
        if (r6 == 0) goto L_0x00e5
        r6 = 34
        if (r3 == r6) goto L_0x00d4
        r0.f2786n = r12
        return r10
    L_0x00d4:
        int r3 = r15 + 1
        char r6 = r0.mo11268d(r15)
        int r7 = r0.f2777e
        r10 = 1
        int r7 = r7 + r10
        int r10 = r3 - r7
        int r10 = r10 + -2
        r15 = r3
        r3 = r6
        goto L_0x00ec
    L_0x00e5:
        r10 = 1
        int r7 = r0.f2777e
        int r6 = r15 - r7
        int r10 = r6 + -1
    L_0x00ec:
        if (r16 != 0) goto L_0x00f9
        r6 = 20
        if (r10 >= r6) goto L_0x00f9
        double r1 = (double) r1
        double r4 = (double) r4
        double r1 = r1 / r4
        if (r8 == 0) goto L_0x0101
        double r1 = -r1
        goto L_0x0101
    L_0x00f9:
        java.lang.String r1 = r0.mo11258a(r7, r10)
        double r1 = java.lang.Double.parseDouble(r1)
    L_0x0101:
        r4 = r22
        if (r3 != r4) goto L_0x0115
        r0.f2777e = r15
        int r3 = r0.f2777e
        char r3 = r0.mo11268d(r3)
        r0.f2776d = r3
        r3 = 3
        r0.f2786n = r3
        r0.f2773a = r9
        return r1
    L_0x0115:
        r0.f2786n = r12
        return r1
    L_0x0118:
        r1 = 110(0x6e, float:1.54E-43)
        if (r2 != r1) goto L_0x018a
        int r1 = r3 + 1
        char r2 = r0.mo11268d(r3)
        r3 = 117(0x75, float:1.64E-43)
        if (r2 != r3) goto L_0x018a
        int r2 = r1 + 1
        char r1 = r0.mo11268d(r1)
        r3 = 108(0x6c, float:1.51E-43)
        if (r1 != r3) goto L_0x018a
        int r1 = r2 + 1
        char r2 = r0.mo11268d(r2)
        if (r2 != r3) goto L_0x018a
        r2 = 5
        r0.f2786n = r2
        int r3 = r1 + 1
        char r1 = r0.mo11268d(r1)
        if (r6 == 0) goto L_0x0152
        r4 = 34
        if (r1 != r4) goto L_0x0152
        int r1 = r3 + 1
        char r3 = r0.mo11268d(r3)
    L_0x014d:
        r20 = r3
        r3 = r1
        r1 = r20
    L_0x0152:
        r4 = 44
        if (r1 != r4) goto L_0x0165
        r0.f2777e = r3
        int r1 = r0.f2777e
        char r1 = r0.mo11268d(r1)
        r0.f2776d = r1
        r0.f2786n = r2
        r0.f2773a = r9
        return r10
    L_0x0165:
        r4 = 93
        if (r1 != r4) goto L_0x017a
        r0.f2777e = r3
        int r1 = r0.f2777e
        char r1 = r0.mo11268d(r1)
        r0.f2776d = r1
        r0.f2786n = r2
        r1 = 15
        r0.f2773a = r1
        return r10
    L_0x017a:
        boolean r1 = m2776j(r1)
        if (r1 == 0) goto L_0x0187
        int r1 = r3 + 1
        char r3 = r0.mo11268d(r3)
        goto L_0x014d
    L_0x0187:
        r0.f2786n = r12
        return r10
    L_0x018a:
        r0.f2786n = r12
        return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.mo11221d(char):double");
    }

    /* JADX WARNING: Removed duplicated region for block: B:67:0x00ff  */
    /* renamed from: b */
    public long mo11213b(char r20) {
        /*
        r19 = this;
        r0 = r19
        r1 = 0
        r0.f2786n = r1
        int r2 = r0.f2777e
        int r3 = r2 + 1
        char r2 = r0.mo11268d(r2)
        r4 = 34
        r5 = 1
        if (r2 != r4) goto L_0x0014
        r6 = 1
        goto L_0x0015
    L_0x0014:
        r6 = 0
    L_0x0015:
        if (r6 == 0) goto L_0x0022
        int r2 = r3 + 1
        char r3 = r0.mo11268d(r3)
        r18 = r3
        r3 = r2
        r2 = r18
    L_0x0022:
        r7 = 45
        if (r2 != r7) goto L_0x0028
        r7 = 1
        goto L_0x0029
    L_0x0028:
        r7 = 0
    L_0x0029:
        if (r7 == 0) goto L_0x0036
        int r2 = r3 + 1
        char r3 = r0.mo11268d(r3)
        r18 = r3
        r3 = r2
        r2 = r18
    L_0x0036:
        r9 = 48
        r10 = -1
        r11 = 0
        if (r2 < r9) goto L_0x00b2
        r13 = 57
        if (r2 > r13) goto L_0x00b2
        int r2 = r2 - r9
        long r14 = (long) r2
    L_0x0043:
        int r2 = r3 + 1
        char r3 = r0.mo11268d(r3)
        if (r3 < r9) goto L_0x0059
        if (r3 > r13) goto L_0x0059
        r16 = 10
        long r14 = r14 * r16
        int r3 = r3 + -48
        long r8 = (long) r3
        long r14 = r14 + r8
        r3 = r2
        r9 = 48
        goto L_0x0043
    L_0x0059:
        r8 = 46
        if (r3 != r8) goto L_0x0060
        r0.f2786n = r10
        return r11
    L_0x0060:
        if (r6 == 0) goto L_0x0072
        if (r3 == r4) goto L_0x0067
        r0.f2786n = r10
        return r11
    L_0x0067:
        int r3 = r2 + 1
        char r2 = r0.mo11268d(r2)
        r18 = r3
        r3 = r2
        r2 = r18
    L_0x0072:
        int r4 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
        if (r4 >= 0) goto L_0x007e
        r8 = -9223372036854775808
        int r4 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
        if (r4 != 0) goto L_0x007f
        if (r7 == 0) goto L_0x007f
    L_0x007e:
        r1 = 1
    L_0x007f:
        if (r1 != 0) goto L_0x0084
        r0.f2786n = r10
        return r11
    L_0x0084:
        r1 = r20
    L_0x0086:
        if (r3 != r1) goto L_0x009d
        r0.f2777e = r2
        int r1 = r0.f2777e
        char r1 = r0.mo11268d(r1)
        r0.f2776d = r1
        r1 = 3
        r0.f2786n = r1
        r1 = 16
        r0.f2773a = r1
        if (r7 == 0) goto L_0x009c
        long r14 = -r14
    L_0x009c:
        return r14
    L_0x009d:
        boolean r3 = m2776j(r3)
        if (r3 == 0) goto L_0x00af
        int r3 = r2 + 1
        char r2 = r0.mo11268d(r2)
        r18 = r3
        r3 = r2
        r2 = r18
        goto L_0x0086
    L_0x00af:
        r0.f2786n = r10
        return r14
    L_0x00b2:
        r1 = 110(0x6e, float:1.54E-43)
        if (r2 != r1) goto L_0x0126
        int r1 = r3 + 1
        char r2 = r0.mo11268d(r3)
        r3 = 117(0x75, float:1.64E-43)
        if (r2 != r3) goto L_0x0126
        int r2 = r1 + 1
        char r1 = r0.mo11268d(r1)
        r3 = 108(0x6c, float:1.51E-43)
        if (r1 != r3) goto L_0x0126
        int r1 = r2 + 1
        char r2 = r0.mo11268d(r2)
        if (r2 != r3) goto L_0x0126
        r2 = 5
        r0.f2786n = r2
        int r3 = r1 + 1
        char r1 = r0.mo11268d(r1)
        if (r6 == 0) goto L_0x00ea
        if (r1 != r4) goto L_0x00ea
        int r1 = r3 + 1
        char r3 = r0.mo11268d(r3)
    L_0x00e5:
        r18 = r3
        r3 = r1
        r1 = r18
    L_0x00ea:
        r4 = 44
        if (r1 != r4) goto L_0x00ff
        r0.f2777e = r3
        int r1 = r0.f2777e
        char r1 = r0.mo11268d(r1)
        r0.f2776d = r1
        r0.f2786n = r2
        r4 = 16
        r0.f2773a = r4
        return r11
    L_0x00ff:
        r4 = 16
        r5 = 93
        if (r1 != r5) goto L_0x0116
        r0.f2777e = r3
        int r1 = r0.f2777e
        char r1 = r0.mo11268d(r1)
        r0.f2776d = r1
        r0.f2786n = r2
        r1 = 15
        r0.f2773a = r1
        return r11
    L_0x0116:
        boolean r1 = m2776j(r1)
        if (r1 == 0) goto L_0x0123
        int r1 = r3 + 1
        char r3 = r0.mo11268d(r3)
        goto L_0x00e5
    L_0x0123:
        r0.f2786n = r10
        return r11
    L_0x0126:
        r0.f2786n = r10
        return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.mo11213b(char):long");
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo11261a(int i, char[] cArr, int i2, int i3) {
        this.f2792r.getChars(i, i3 + i, cArr, i2);
    }

    /* renamed from: x */
    public String mo11245x() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("pos ");
        sb.append(this.f2777e);
        sb.append(", json : ");
        if (this.f2792r.length() < 65536) {
            str = this.f2792r;
        } else {
            str = this.f2792r.substring(0, 65536);
        }
        sb.append(str);
        return sb.toString();
    }
}
