package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;

/* renamed from: com.alibaba.fastjson.parser.d */
public final class JSONReaderScanner extends JSONLexerBase {
    /* renamed from: r */
    private static final ThreadLocal<char[]> f2788r = new ThreadLocal<>();
    /* renamed from: s */
    private Reader f2789s;
    /* renamed from: t */
    private char[] f2790t;
    /* renamed from: u */
    private int f2791u;

    /* renamed from: d */
    public final char mo11268d(int i) {
        int i2 = this.f2791u;
        if (i >= i2) {
            if (i2 == -1) {
                if (i < this.f2780h) {
                    return this.f2790t[i];
                }
                return 26;
            } else if (this.f2777e == 0) {
                char[] cArr = this.f2790t;
                char[] cArr2 = new char[((cArr.length * 3) / 2)];
                System.arraycopy(cArr, this.f2777e, cArr2, 0, this.f2791u);
                int length = cArr2.length;
                int i3 = this.f2791u;
                try {
                    this.f2791u += this.f2789s.read(cArr2, i3, length - i3);
                    this.f2790t = cArr2;
                } catch (IOException e) {
                    throw new JSONException(e.getMessage(), e);
                }
            } else {
                int i4 = this.f2791u - this.f2777e;
                if (i4 > 0) {
                    System.arraycopy(this.f2790t, this.f2777e, this.f2790t, 0, i4);
                }
                try {
                    this.f2791u = this.f2789s.read(this.f2790t, i4, this.f2790t.length - i4);
                    int i5 = this.f2791u;
                    if (i5 == 0) {
                        throw new JSONException("illegal state, textLength is zero");
                    } else if (i5 == -1) {
                        return 26;
                    } else {
                        this.f2791u = i5 + i4;
                        i -= this.f2777e;
                        this.f2781i -= this.f2777e;
                        this.f2777e = 0;
                    }
                } catch (IOException e2) {
                    throw new JSONException(e2.getMessage(), e2);
                }
            }
        }
        return this.f2790t[i];
    }

    /* renamed from: a */
    public final int mo11257a(char c, int i) {
        int i2 = i - this.f2777e;
        while (true) {
            char d = mo11268d(this.f2777e + i2);
            if (c == d) {
                return i2 + this.f2777e;
            }
            if (d == 26) {
                return -1;
            }
            i2++;
        }
    }

    /* renamed from: a */
    public final String mo11259a(int i, int i2, int i3, SymbolTable iVar) {
        return iVar.mo11303a(this.f2790t, i, i2, i3);
    }

    /* renamed from: f */
    public final char mo11225f() {
        int i = this.f2777e + 1;
        this.f2777e = i;
        int i2 = this.f2791u;
        if (i >= i2) {
            if (i2 == -1) {
                return 26;
            }
            if (this.f2780h > 0) {
                int i3 = this.f2791u - this.f2780h;
                if (this.f2776d == '\"' && i3 > 0) {
                    i3--;
                }
                char[] cArr = this.f2790t;
                System.arraycopy(cArr, i3, cArr, 0, this.f2780h);
            }
            this.f2781i = -1;
            int i4 = this.f2780h;
            this.f2777e = i4;
            try {
                int i5 = this.f2777e;
                int length = this.f2790t.length - i5;
                if (length == 0) {
                    char[] cArr2 = new char[(this.f2790t.length * 2)];
                    System.arraycopy(this.f2790t, 0, cArr2, 0, this.f2790t.length);
                    this.f2790t = cArr2;
                    length = this.f2790t.length - i5;
                }
                this.f2791u = this.f2789s.read(this.f2790t, this.f2777e, length);
                int i6 = this.f2791u;
                if (i6 == 0) {
                    throw new JSONException("illegal stat, textLength is zero");
                } else if (i6 == -1) {
                    this.f2776d = 26;
                    return 26;
                } else {
                    this.f2791u = i6 + this.f2777e;
                    i = i4;
                }
            } catch (IOException e) {
                throw new JSONException(e.getMessage(), e);
            }
        }
        char c = this.f2790t[i];
        this.f2776d = c;
        return c;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo11260a(int i, int i2, char[] cArr) {
        System.arraycopy(this.f2790t, i, cArr, 0, i2);
    }

    /* renamed from: o */
    public final boolean mo11282o(char[] cArr) {
        for (int i = 0; i < cArr.length; i++) {
            if (mo11268d(this.f2777e + i) != cArr[i]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: t */
    public byte[] mo11241t() {
        if (this.f2773a != 26) {
            return IOUtils.m3198a(this.f2790t, this.f2781i + 1, this.f2780h);
        }
        throw new JSONException("TODO");
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo11261a(int i, char[] cArr, int i2, int i3) {
        System.arraycopy(this.f2790t, i, cArr, i2, i3);
    }

    /* renamed from: l */
    public final String mo11233l() {
        if (this.f2782j) {
            return new String(this.f2779g, 0, this.f2780h);
        }
        int i = this.f2781i + 1;
        if (i < 0) {
            throw new IllegalStateException();
        } else if (i <= this.f2790t.length - this.f2780h) {
            return new String(this.f2790t, i, this.f2780h);
        } else {
            throw new IllegalStateException();
        }
    }

    /* renamed from: a */
    public final String mo11258a(int i, int i2) {
        if (i2 >= 0) {
            return new String(this.f2790t, i, i2);
        }
        throw new StringIndexOutOfBoundsException(i2);
    }

    /* renamed from: b */
    public final char[] mo11266b(int i, int i2) {
        if (i2 < 0) {
            throw new StringIndexOutOfBoundsException(i2);
        } else if (i == 0) {
            return this.f2790t;
        } else {
            char[] cArr = new char[i2];
            System.arraycopy(this.f2790t, i, cArr, 0, i2);
            return cArr;
        }
    }

    /* renamed from: s */
    public final String mo11240s() {
        int i = this.f2781i;
        if (i == -1) {
            i = 0;
        }
        char d = mo11268d((this.f2780h + i) - 1);
        int i2 = this.f2780h;
        if (d == 'L' || d == 'S' || d == 'B' || d == 'F' || d == 'D') {
            i2--;
        }
        return new String(this.f2790t, i, i2);
    }

    /* renamed from: k */
    public final BigDecimal mo11232k() {
        int i = this.f2781i;
        if (i == -1) {
            i = 0;
        }
        char d = mo11268d((this.f2780h + i) - 1);
        int i2 = this.f2780h;
        if (d == 'L' || d == 'S' || d == 'B' || d == 'F' || d == 'D') {
            i2--;
        }
        return new BigDecimal(this.f2790t, i, i2);
    }

    public void close() {
        super.close();
        char[] cArr = this.f2790t;
        if (cArr.length <= 65536) {
            f2788r.set(cArr);
        }
        this.f2790t = null;
        IOUtils.m3194a((Closeable) this.f2789s);
    }

    /* renamed from: C */
    public boolean mo11249C() {
        if (this.f2791u == -1 || this.f2777e == this.f2790t.length) {
            return true;
        }
        return this.f2776d == 26 && this.f2777e + 1 == this.f2790t.length;
    }

    /* renamed from: p */
    public final boolean mo11237p() {
        int i = 0;
        while (true) {
            char c = this.f2790t[i];
            if (c == 26) {
                this.f2773a = 20;
                return true;
            } else if (!m2776j(c)) {
                return false;
            } else {
                i++;
            }
        }
    }
}
