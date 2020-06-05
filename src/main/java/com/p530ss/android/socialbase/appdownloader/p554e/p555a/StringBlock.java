package com.p530ss.android.socialbase.appdownloader.p554e.p555a;

import java.io.IOException;

/* renamed from: com.ss.android.socialbase.appdownloader.e.a.f */
public class StringBlock {
    /* renamed from: a */
    private int[] f21568a;
    /* renamed from: b */
    private int[] f21569b;

    /* renamed from: a */
    public static StringBlock m26811a(IntReader dVar) throws IOException {
        ChunkUtil.m26798a(dVar, 1835009);
        int b = dVar.mo31531b();
        int b2 = dVar.mo31531b();
        int b3 = dVar.mo31531b();
        dVar.mo31531b();
        int b4 = dVar.mo31531b();
        int b5 = dVar.mo31531b();
        StringBlock fVar = new StringBlock();
        fVar.f21568a = dVar.mo31532b(b2);
        if (b3 != 0) {
            dVar.mo31532b(b3);
        }
        int i = (b5 == 0 ? b : b5) - b4;
        String str = ").";
        if (i % 4 == 0) {
            fVar.f21569b = dVar.mo31532b(i / 4);
            if (b5 != 0) {
                int i2 = b - b5;
                if (i2 % 4 == 0) {
                    dVar.mo31532b(i2 / 4);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Style data size is not multiple of 4 (");
                    sb.append(i2);
                    sb.append(str);
                    throw new IOException(sb.toString());
                }
            }
            return fVar;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("String data size is not multiple of 4 (");
        sb2.append(i);
        sb2.append(str);
        throw new IOException(sb2.toString());
    }

    /* renamed from: a */
    public String mo31535a(int i) {
        if (i >= 0) {
            int[] iArr = this.f21568a;
            if (iArr != null && i < iArr.length) {
                int i2 = iArr[i];
                int a = m26810a(this.f21569b, i2);
                StringBuilder sb = new StringBuilder(a);
                while (a != 0) {
                    i2 += 2;
                    sb.append((char) m26810a(this.f21569b, i2));
                    a--;
                }
                return sb.toString();
            }
        }
        return null;
    }

    private StringBlock() {
    }

    /* renamed from: a */
    private static final int m26810a(int[] iArr, int i) {
        int i2 = iArr[i / 4];
        return (i % 4) / 2 == 0 ? i2 & 65535 : i2 >>> 16;
    }
}
