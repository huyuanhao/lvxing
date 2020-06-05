package com.kwai.filedownloader.p356d;

import com.kwai.filedownloader.C4583a;

/* renamed from: com.kwai.filedownloader.d.d */
public class C4623d {
    /* renamed from: a */
    public static boolean m18946a(int i) {
        return i < 0;
    }

    /* renamed from: a */
    public static boolean m18947a(int i, int i2) {
        if ((i != 3 && i != 5 && i == i2) || m18946a(i)) {
            return false;
        }
        if (i >= 1 && i <= 6 && i2 >= 10 && i2 <= 11) {
            return false;
        }
        if (i == 1) {
            return i2 != 0;
        }
        if (i == 2) {
            return (i2 == 0 || i2 == 1 || i2 == 6) ? false : true;
        }
        if (i == 3) {
            return (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 6) ? false : true;
        }
        if (i == 5) {
            return (i2 == 1 || i2 == 6) ? false : true;
        }
        if (i != 6) {
            return true;
        }
        return (i2 == 0 || i2 == 1) ? false : true;
    }

    /* renamed from: a */
    public static boolean m18948a(C4583a aVar) {
        return aVar.mo24929v() == 0 || aVar.mo24929v() == 3;
    }

    /* renamed from: b */
    public static boolean m18949b(int i) {
        return i > 0;
    }

    /* renamed from: b */
    public static boolean m18950b(int i, int i2) {
        if ((i != 3 && i != 5 && i == i2) || m18946a(i)) {
            return false;
        }
        if (i2 == -2 || i2 == -1) {
            return true;
        }
        if (i == 0) {
            return i2 == 10;
        }
        if (i == 1) {
            return i2 == 6;
        }
        if (i == 2 || i == 3) {
            return i2 == -3 || i2 == 3 || i2 == 5;
        }
        if (i == 5 || i == 6) {
            return i2 == 2 || i2 == 5;
        }
        if (i == 10) {
            return i2 == 11;
        }
        if (i != 11) {
            return false;
        }
        return i2 == -4 || i2 == -3 || i2 == 1;
    }
}
