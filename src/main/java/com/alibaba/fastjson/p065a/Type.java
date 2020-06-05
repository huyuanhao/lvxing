package com.alibaba.fastjson.p065a;

import com.tencent.android.tpush.SettingsContentProvider;

/* renamed from: com.alibaba.fastjson.a.j */
public class Type {
    /* renamed from: a */
    public static final Type f2581a = new Type(0, null, 1443168256, 1);
    /* renamed from: b */
    public static final Type f2582b = new Type(1, null, 1509950721, 1);
    /* renamed from: c */
    public static final Type f2583c = new Type(2, null, 1124075009, 1);
    /* renamed from: d */
    public static final Type f2584d = new Type(3, null, 1107297537, 1);
    /* renamed from: e */
    public static final Type f2585e = new Type(4, null, 1392510721, 1);
    /* renamed from: f */
    public static final Type f2586f = new Type(5, null, 1224736769, 1);
    /* renamed from: g */
    public static final Type f2587g = new Type(6, null, 1174536705, 1);
    /* renamed from: h */
    public static final Type f2588h = new Type(7, null, 1241579778, 1);
    /* renamed from: i */
    public static final Type f2589i = new Type(8, null, 1141048066, 1);
    /* renamed from: j */
    protected final int f2590j;
    /* renamed from: k */
    private final char[] f2591k;
    /* renamed from: l */
    private final int f2592l;
    /* renamed from: m */
    private final int f2593m;

    private Type(int i, char[] cArr, int i2, int i3) {
        this.f2590j = i;
        this.f2591k = cArr;
        this.f2592l = i2;
        this.f2593m = i3;
    }

    /* renamed from: a */
    public static Type m2508a(String str) {
        return m2509a(str.toCharArray(), 0);
    }

    /* renamed from: b */
    public static int m2510b(String str) {
        int i;
        int i2 = 1;
        int i3 = 1;
        int i4 = 1;
        while (true) {
            i = i3 + 1;
            char charAt = str.charAt(i3);
            if (charAt == ')') {
                break;
            } else if (charAt == 'L') {
                while (true) {
                    i3 = i + 1;
                    if (str.charAt(i) == ';') {
                        break;
                    }
                    i = i3;
                }
                i4++;
            } else {
                i4 = (charAt == 'D' || charAt == 'J') ? i4 + 2 : i4 + 1;
                i3 = i;
            }
        }
        char charAt2 = str.charAt(i);
        int i5 = i4 << 2;
        if (charAt2 == 'V') {
            i2 = 0;
        } else if (charAt2 == 'D' || charAt2 == 'J') {
            i2 = 2;
        }
        return i5 | i2;
    }

    /* renamed from: a */
    private static Type m2509a(char[] cArr, int i) {
        int i2;
        char c = cArr[i];
        if (c == 'F') {
            return f2587g;
        }
        if (c == 'S') {
            return f2585e;
        }
        if (c == 'V') {
            return f2581a;
        }
        if (c == 'I') {
            return f2586f;
        }
        if (c == 'J') {
            return f2588h;
        }
        if (c == 'Z') {
            return f2582b;
        }
        if (c != '[') {
            switch (c) {
                case 'B':
                    return f2584d;
                case 'C':
                    return f2583c;
                case 'D':
                    return f2589i;
                default:
                    int i3 = 1;
                    while (cArr[i + i3] != ';') {
                        i3++;
                    }
                    return new Type(10, cArr, i + 1, i3 - 1);
            }
        } else {
            int i4 = 1;
            while (true) {
                i2 = i + i4;
                if (cArr[i2] != '[') {
                    break;
                }
                i4++;
            }
            if (cArr[i2] == 'L') {
                while (true) {
                    i4++;
                    if (cArr[i + i4] == ';') {
                        break;
                    }
                }
            }
            return new Type(9, cArr, i, i4 + 1);
        }
    }

    /* renamed from: a */
    public String mo11044a() {
        return new String(this.f2591k, this.f2592l, this.f2593m);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo11045b() {
        return new String(this.f2591k, this.f2592l, this.f2593m);
    }

    /* renamed from: d */
    private int m2512d() {
        int i = 1;
        while (this.f2591k[this.f2592l + i] == '[') {
            i++;
        }
        return i;
    }

    /* renamed from: c */
    static Type[] m2511c(String str) {
        char[] charArray = str.toCharArray();
        int i = 1;
        int i2 = 1;
        int i3 = 0;
        while (true) {
            int i4 = i2 + 1;
            char c = charArray[i2];
            if (c == ')') {
                break;
            } else if (c == 'L') {
                while (true) {
                    i2 = i4 + 1;
                    if (charArray[i4] == ';') {
                        break;
                    }
                    i4 = i2;
                }
                i3++;
            } else {
                if (c != '[') {
                    i3++;
                }
                i2 = i4;
            }
        }
        Type[] jVarArr = new Type[i3];
        int i5 = 0;
        while (charArray[i] != ')') {
            jVarArr[i5] = m2509a(charArray, i);
            i += jVarArr[i5].f2593m + (jVarArr[i5].f2590j == 10 ? 2 : 0);
            i5++;
        }
        return jVarArr;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo11046c() {
        switch (this.f2590j) {
            case 0:
                return "void";
            case 1:
                return SettingsContentProvider.BOOLEAN_TYPE;
            case 2:
                return "char";
            case 3:
                return "byte";
            case 4:
                return "short";
            case 5:
                return "int";
            case 6:
                return SettingsContentProvider.FLOAT_TYPE;
            case 7:
                return SettingsContentProvider.LONG_TYPE;
            case 8:
                return "double";
            case 9:
                StringBuffer stringBuffer = new StringBuffer(m2509a(this.f2591k, this.f2592l + m2512d()).mo11046c());
                for (int d = m2512d(); d > 0; d--) {
                    stringBuffer.append("[]");
                }
                return stringBuffer.toString();
            default:
                return new String(this.f2591k, this.f2592l, this.f2593m).replace('/', '.');
        }
    }
}
