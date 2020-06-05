package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;

/* renamed from: com.alibaba.fastjson.parser.i */
public class SymbolTable {
    /* renamed from: a */
    private final String[] f2816a;
    /* renamed from: b */
    private final int f2817b;

    public SymbolTable(int i) {
        this.f2817b = i - 1;
        this.f2816a = new String[i];
        String str = "$ref";
        mo11301a(str, 0, 4, str.hashCode());
        mo11301a(JSON.DEFAULT_TYPE_KEY, 0, JSON.DEFAULT_TYPE_KEY.length(), JSON.DEFAULT_TYPE_KEY.hashCode());
    }

    /* renamed from: a */
    public String mo11303a(char[] cArr, int i, int i2, int i3) {
        int i4 = this.f2817b & i3;
        String str = this.f2816a[i4];
        if (str != null) {
            boolean z = false;
            if (i3 == str.hashCode() && i2 == str.length()) {
                int i5 = 0;
                while (true) {
                    if (i5 >= i2) {
                        z = true;
                        break;
                    } else if (cArr[i + i5] != str.charAt(i5)) {
                        break;
                    } else {
                        i5++;
                    }
                }
            }
            return z ? str : new String(cArr, i, i2);
        }
        String intern = new String(cArr, i, i2).intern();
        this.f2816a[i4] = intern;
        return intern;
    }

    /* renamed from: a */
    public String mo11301a(String str, int i, int i2, int i3) {
        return mo11302a(str, i, i2, i3, false);
    }

    /* renamed from: a */
    public String mo11302a(String str, int i, int i2, int i3, boolean z) {
        int i4 = this.f2817b & i3;
        String str2 = this.f2816a[i4];
        if (str2 == null) {
            if (i2 != str.length()) {
                str = m2922a(str, i, i2);
            }
            String intern = str.intern();
            this.f2816a[i4] = intern;
            return intern;
        } else if (i3 == str2.hashCode() && i2 == str2.length() && str.startsWith(str2, i)) {
            return str2;
        } else {
            String a = m2922a(str, i, i2);
            if (z) {
                this.f2816a[i4] = a;
            }
            return a;
        }
    }

    /* renamed from: a */
    private static String m2922a(String str, int i, int i2) {
        char[] cArr = new char[i2];
        str.getChars(i, i2 + i, cArr, 0);
        return new String(cArr);
    }
}
