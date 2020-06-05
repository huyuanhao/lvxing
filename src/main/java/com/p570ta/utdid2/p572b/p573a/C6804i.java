package com.p570ta.utdid2.p572b.p573a;

/* compiled from: StringUtils */
/* renamed from: com.ta.utdid2.b.a.i */
public class C6804i {
    /* renamed from: a */
    public static boolean m29034a(String str) {
        return str == null || str.length() <= 0;
    }

    /* renamed from: a */
    public static int m29033a(String str) {
        if (str.length() <= 0) {
            return 0;
        }
        int i = 0;
        for (char c : str.toCharArray()) {
            i = (i * 31) + c;
        }
        return i;
    }
}
