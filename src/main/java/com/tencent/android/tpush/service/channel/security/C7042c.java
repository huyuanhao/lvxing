package com.tencent.android.tpush.service.channel.security;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.channel.security.c */
public class C7042c extends FilterOutputStream {
    /* renamed from: a */
    private static final char[] f23417a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    /* renamed from: b */
    private int f23418b;
    /* renamed from: c */
    private int f23419c;

    public C7042c(OutputStream outputStream) {
        super(outputStream);
    }

    public void write(int i) {
        if (i < 0) {
            i += 256;
        }
        int i2 = this.f23418b;
        if (i2 % 3 == 0) {
            int i3 = i >> 2;
            this.f23419c = i & 3;
            this.out.write(f23417a[i3]);
        } else if (i2 % 3 == 1) {
            int i4 = ((this.f23419c << 4) + (i >> 4)) & 63;
            this.f23419c = i & 15;
            this.out.write(f23417a[i4]);
        } else if (i2 % 3 == 2) {
            this.out.write(f23417a[((this.f23419c << 2) + (i >> 6)) & 63]);
            this.out.write(f23417a[i & 63]);
            this.f23419c = 0;
        }
        this.f23418b++;
        if (this.f23418b % 57 == 0) {
            this.out.write(10);
        }
    }

    public void write(byte[] bArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            write(bArr[i + i3]);
        }
    }

    public void close() {
        int i = this.f23418b;
        if (i % 3 == 1) {
            this.out.write(f23417a[(this.f23419c << 4) & 63]);
            this.out.write(61);
            this.out.write(61);
        } else if (i % 3 == 2) {
            this.out.write(f23417a[(this.f23419c << 2) & 63]);
            this.out.write(61);
        }
        super.close();
    }

    /* renamed from: a */
    public static String m30106a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) (((double) bArr.length) * 1.37d));
        C7042c cVar = new C7042c(byteArrayOutputStream);
        try {
            cVar.write(bArr);
            cVar.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toString("UTF-8");
        } catch (IOException unused) {
            return null;
        }
    }
}
