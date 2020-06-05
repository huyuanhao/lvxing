package com.alibaba.mtl.log.p077d;

/* renamed from: com.alibaba.mtl.log.d.n */
public class RC4 {

    /* compiled from: RC4 */
    /* renamed from: com.alibaba.mtl.log.d.n$a */
    private static class C1327a {
        /* renamed from: a */
        public int[] f3416a;
        /* renamed from: b */
        public int f3417b;
        /* renamed from: c */
        public int f3418c;

        private C1327a() {
            this.f3416a = new int[256];
        }
    }

    /* renamed from: a */
    public static byte[] m3857a(byte[] bArr, String str) {
        if (!(bArr == null || str == null)) {
            C1327a a = m3855a(str);
            if (a != null) {
                return m3856a(bArr, a);
            }
        }
        return null;
    }

    /* renamed from: a */
    private static C1327a m3855a(String str) {
        if (str == null) {
            return null;
        }
        C1327a aVar = new C1327a();
        int i = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            aVar.f3416a[i2] = i2;
        }
        aVar.f3417b = 0;
        aVar.f3418c = 0;
        int i3 = 0;
        int i4 = 0;
        while (i < 256) {
            try {
                i4 = ((str.charAt(i3) + aVar.f3416a[i]) + i4) % 256;
                int i5 = aVar.f3416a[i];
                aVar.f3416a[i] = aVar.f3416a[i4];
                aVar.f3416a[i4] = i5;
                i3 = (i3 + 1) % str.length();
                i++;
            } catch (Exception unused) {
                return null;
            }
        }
        return aVar;
    }

    /* renamed from: a */
    private static byte[] m3856a(byte[] bArr, C1327a aVar) {
        if (bArr == null || aVar == null) {
            return null;
        }
        int i = aVar.f3417b;
        int i2 = aVar.f3418c;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) % 256;
            i2 = (aVar.f3416a[i] + i2) % 256;
            int i4 = aVar.f3416a[i];
            aVar.f3416a[i] = aVar.f3416a[i2];
            aVar.f3416a[i2] = i4;
            int i5 = (aVar.f3416a[i] + aVar.f3416a[i2]) % 256;
            bArr[i3] = (byte) (aVar.f3416a[i5] ^ bArr[i3]);
        }
        aVar.f3417b = i;
        aVar.f3418c = i2;
        return bArr;
    }
}
