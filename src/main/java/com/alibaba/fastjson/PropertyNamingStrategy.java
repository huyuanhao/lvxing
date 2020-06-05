package com.alibaba.fastjson;

public enum PropertyNamingStrategy {
    CamelCase,
    PascalCase,
    SnakeCase,
    KebabCase;

    /* renamed from: com.alibaba.fastjson.PropertyNamingStrategy$1 */
    static /* synthetic */ class C12341 {
        /* renamed from: a */
        static final /* synthetic */ int[] f2523a = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
            com.alibaba.fastjson.PropertyNamingStrategy[] r0 = com.alibaba.fastjson.PropertyNamingStrategy.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f2523a = r0
            int[] r0 = f2523a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.alibaba.fastjson.PropertyNamingStrategy r1 = com.alibaba.fastjson.PropertyNamingStrategy.SnakeCase     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f2523a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.alibaba.fastjson.PropertyNamingStrategy r1 = com.alibaba.fastjson.PropertyNamingStrategy.KebabCase     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = f2523a     // Catch:{ NoSuchFieldError -> 0x002a }
            com.alibaba.fastjson.PropertyNamingStrategy r1 = com.alibaba.fastjson.PropertyNamingStrategy.PascalCase     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            int[] r0 = f2523a     // Catch:{ NoSuchFieldError -> 0x0035 }
            com.alibaba.fastjson.PropertyNamingStrategy r1 = com.alibaba.fastjson.PropertyNamingStrategy.CamelCase     // Catch:{ NoSuchFieldError -> 0x0035 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.PropertyNamingStrategy.C12341.m41537clinit():void");
        }
    }

    public String translate(String str) {
        int i = C12341.f2523a[ordinal()];
        int i2 = 0;
        if (i == 1) {
            StringBuilder sb = new StringBuilder();
            while (i2 < str.length()) {
                char charAt = str.charAt(i2);
                if (charAt < 'A' || charAt > 'Z') {
                    sb.append(charAt);
                } else {
                    char c = (char) (charAt + ' ');
                    if (i2 > 0) {
                        sb.append('_');
                    }
                    sb.append(c);
                }
                i2++;
            }
            return sb.toString();
        } else if (i == 2) {
            StringBuilder sb2 = new StringBuilder();
            while (i2 < str.length()) {
                char charAt2 = str.charAt(i2);
                if (charAt2 < 'A' || charAt2 > 'Z') {
                    sb2.append(charAt2);
                } else {
                    char c2 = (char) (charAt2 + ' ');
                    if (i2 > 0) {
                        sb2.append('-');
                    }
                    sb2.append(c2);
                }
                i2++;
            }
            return sb2.toString();
        } else if (i == 3) {
            char charAt3 = str.charAt(0);
            if (charAt3 < 'a' || charAt3 > 'z') {
                return str;
            }
            char[] charArray = str.toCharArray();
            charArray[0] = (char) (charArray[0] - ' ');
            return new String(charArray);
        } else if (i != 4) {
            return str;
        } else {
            char charAt4 = str.charAt(0);
            if (charAt4 < 'A' || charAt4 > 'Z') {
                return str;
            }
            char[] charArray2 = str.toCharArray();
            charArray2[0] = (char) (charArray2[0] + ' ');
            return new String(charArray2);
        }
    }
}
