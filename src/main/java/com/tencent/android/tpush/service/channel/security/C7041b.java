package com.tencent.android.tpush.service.channel.security;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.channel.security.b */
public class C7041b extends FilterInputStream {
    /* renamed from: a */
    private static final char[] f23413a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    /* renamed from: b */
    private static final int[] f23414b = new int[128];
    /* renamed from: c */
    private int f23415c;
    /* renamed from: d */
    private int f23416d;

    static {
        for (int i = 0; i < 64; i++) {
            f23414b[f23413a[i]] = i;
        }
    }

    public C7041b(InputStream inputStream) {
        super(inputStream);
    }

    public int read() {
        int read;
        do {
            read = this.in.read();
            if (read == -1) {
                return -1;
            }
        } while (Character.isWhitespace((char) read));
        this.f23415c++;
        if (read == 61) {
            return -1;
        }
        int i = f23414b[read];
        int i2 = (this.f23415c - 1) % 4;
        if (i2 == 0) {
            this.f23416d = i & 63;
            return read();
        } else if (i2 == 1) {
            int i3 = ((this.f23416d << 2) + (i >> 4)) & 255;
            this.f23416d = i & 15;
            return i3;
        } else if (i2 == 2) {
            int i4 = ((this.f23416d << 4) + (i >> 2)) & 255;
            this.f23416d = i & 3;
            return i4;
        } else if (i2 == 3) {
            return ((this.f23416d << 6) + i) & 255;
        } else {
            return -1;
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        if (bArr.length >= (i2 + i) - 1) {
            int i3 = 0;
            while (i3 < i2) {
                int read = read();
                if (read == -1 && i3 == 0) {
                    return -1;
                }
                if (read == -1) {
                    break;
                }
                bArr[i + i3] = (byte) read;
                i3++;
            }
            return i3;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("The input buffer is too small: ");
        sb.append(i2);
        sb.append(" bytes requested starting at offset ");
        sb.append(i);
        sb.append(" while the buffer  is only ");
        sb.append(bArr.length);
        sb.append(" bytes long.");
        throw new IOException(sb.toString());
    }

    /* renamed from: a */
    public static byte[] m30105a(String str) {
        byte[] bArr = new byte[0];
        try {
            bArr = str.getBytes("UTF-8");
        } catch (Exception unused) {
        }
        C7041b bVar = new C7041b(new ByteArrayInputStream(bArr));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) (((double) bArr.length) * 0.67d));
        try {
            byte[] bArr2 = new byte[4096];
            while (true) {
                int read = bVar.read(bArr2);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    bVar.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException unused2) {
            return null;
        }
    }
}
