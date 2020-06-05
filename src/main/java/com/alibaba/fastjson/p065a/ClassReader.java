package com.alibaba.fastjson.p065a;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.alibaba.fastjson.a.b */
public class ClassReader {
    /* renamed from: a */
    public final byte[] f2526a;
    /* renamed from: b */
    public final int f2527b;
    /* renamed from: c */
    private final int[] f2528c;
    /* renamed from: d */
    private final String[] f2529d;
    /* renamed from: e */
    private final int f2530e;

    public ClassReader(InputStream inputStream) throws IOException {
        int i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            i = 0;
            if (read == -1) {
                break;
            } else if (read > 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            }
        }
        inputStream.close();
        this.f2526a = byteArrayOutputStream.toByteArray();
        this.f2528c = new int[m2454a(8)];
        int length = this.f2528c.length;
        this.f2529d = new String[length];
        int i2 = 1;
        int i3 = 10;
        while (i2 < length) {
            int i4 = i3 + 1;
            this.f2528c[i2] = i4;
            byte b = this.f2526a[i3];
            int i5 = 5;
            if (b == 1) {
                i5 = m2454a(i4) + 3;
                if (i5 > i) {
                    i = i5;
                }
            } else if (b != 15) {
                if (!(b == 18 || b == 3 || b == 4)) {
                    if (b != 5 && b != 6) {
                        switch (b) {
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                                break;
                            default:
                                i5 = 3;
                                break;
                        }
                    } else {
                        i5 = 9;
                        i2++;
                    }
                }
            } else {
                i5 = 4;
            }
            i3 += i5;
            i2++;
        }
        this.f2530e = i;
        this.f2527b = i3;
    }

    /* renamed from: a */
    public void mo11011a(TypeCollector kVar) {
        char[] cArr = new char[this.f2530e];
        int i = this.f2527b;
        int i2 = this.f2528c[m2454a(i + 4)];
        int a = m2454a(i + 6);
        int i3 = i + 8;
        for (int i4 = 0; i4 < a; i4++) {
            i3 += 2;
        }
        int i5 = i3 + 2;
        int i6 = i5;
        for (int a2 = m2454a(i3); a2 > 0; a2--) {
            i6 += 8;
            for (int a3 = m2454a(i6 + 6); a3 > 0; a3--) {
                i6 += m2458b(i6 + 2) + 6;
            }
        }
        int i7 = i6 + 2;
        for (int a4 = m2454a(i6); a4 > 0; a4--) {
            i7 += 8;
            for (int a5 = m2454a(i7 + 6); a5 > 0; a5--) {
                i7 += m2458b(i7 + 2) + 6;
            }
        }
        int i8 = i7 + 2;
        for (int a6 = m2454a(i7); a6 > 0; a6--) {
            i8 += m2458b(i8 + 2) + 6;
        }
        for (int a7 = m2454a(i3); a7 > 0; a7--) {
            i5 += 8;
            for (int a8 = m2454a(i5 + 6); a8 > 0; a8--) {
                i5 += m2458b(i5 + 2) + 6;
            }
        }
        int i9 = i5 + 2;
        for (int a9 = m2454a(i5); a9 > 0; a9--) {
            i9 = m2455a(kVar, cArr, i9);
        }
    }

    /* renamed from: a */
    private int m2455a(TypeCollector kVar, char[] cArr, int i) {
        int a = m2454a(i);
        String a2 = m2457a(i + 2, cArr);
        String a3 = m2457a(i + 4, cArr);
        int i2 = i + 8;
        int i3 = 0;
        int i4 = 0;
        for (int a4 = m2454a(i + 6); a4 > 0; a4--) {
            String a5 = m2457a(i2, cArr);
            int b = m2458b(i2 + 2);
            int i5 = i2 + 6;
            if (a5.equals("Code")) {
                i4 = i5;
            }
            i2 = i5 + b;
        }
        MethodCollector a6 = kVar.mo11047a(a, a2, a3);
        if (!(a6 == null || i4 == 0)) {
            int b2 = i4 + 8 + m2458b(i4 + 4);
            int i6 = b2 + 2;
            for (int a7 = m2454a(b2); a7 > 0; a7--) {
                i6 += 8;
            }
            int i7 = i6 + 2;
            int i8 = 0;
            for (int a8 = m2454a(i6); a8 > 0; a8--) {
                String a9 = m2457a(i7, cArr);
                if (a9.equals("LocalVariableTable")) {
                    i3 = i7 + 6;
                } else if (a9.equals("LocalVariableTypeTable")) {
                    i8 = i7 + 6;
                }
                i7 += m2458b(i7 + 2) + 6;
            }
            if (i3 != 0) {
                if (i8 != 0) {
                    int a10 = m2454a(i8) * 3;
                    int i9 = i8 + 2;
                    int[] iArr = new int[a10];
                    while (a10 > 0) {
                        int i10 = a10 - 1;
                        iArr[i10] = i9 + 6;
                        int i11 = i10 - 1;
                        iArr[i11] = m2454a(i9 + 8);
                        a10 = i11 - 1;
                        iArr[a10] = m2454a(i9);
                        i9 += 10;
                    }
                }
                int i12 = i3 + 2;
                for (int a11 = m2454a(i3); a11 > 0; a11--) {
                    a6.mo11029a(m2457a(i12 + 4, cArr), m2454a(i12 + 8));
                    i12 += 10;
                }
            }
        }
        return i2;
    }

    /* renamed from: a */
    private int m2454a(int i) {
        byte[] bArr = this.f2526a;
        return (bArr[i + 1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | ((bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8);
    }

    /* renamed from: b */
    private int m2458b(int i) {
        byte[] bArr = this.f2526a;
        return (bArr[i + 3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | ((bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 24) | ((bArr[i + 1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16) | ((bArr[i + 2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8);
    }

    /* renamed from: a */
    private String m2457a(int i, char[] cArr) {
        int a = m2454a(i);
        String[] strArr = this.f2529d;
        String str = strArr[a];
        if (str != null) {
            return str;
        }
        int i2 = this.f2528c[a];
        String a2 = m2456a(i2 + 2, m2454a(i2), cArr);
        strArr[a] = a2;
        return a2;
    }

    /* renamed from: a */
    private String m2456a(int i, int i2, char[] cArr) {
        byte b;
        int i3 = i2 + i;
        byte[] bArr = this.f2526a;
        int i4 = 0;
        char c = 0;
        int i5 = 0;
        while (i < i3) {
            int i6 = i + 1;
            byte b2 = bArr[i];
            if (c != 0) {
                if (c == 1) {
                    int i7 = i4 + 1;
                    cArr[i4] = (char) ((b2 & 63) | (i5 << 6));
                    i4 = i7;
                    c = 0;
                } else if (c == 2) {
                    b = (b2 & 63) | (i5 << 6);
                }
                i = i6;
            } else {
                byte b3 = b2 & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                if (b3 < Byte.MIN_VALUE) {
                    int i8 = i4 + 1;
                    cArr[i4] = (char) b3;
                    i4 = i8;
                } else if (b3 >= -32 || b3 <= -65) {
                    i5 = (char) (b3 & 15);
                    c = 2;
                } else {
                    b = b3 & 31;
                }
                i = i6;
            }
            i5 = (char) b;
            c = 1;
            i = i6;
        }
        return new String(cArr, 0, i4);
    }
}
