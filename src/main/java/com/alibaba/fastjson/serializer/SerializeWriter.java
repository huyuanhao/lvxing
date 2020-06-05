package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import com.p522qq.taf.jce.JceStruct;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.charset.Charset;

/* renamed from: com.alibaba.fastjson.serializer.ba */
public final class SerializeWriter extends Writer {
    /* renamed from: r */
    static final int f2905r = (((((((((SerializerFeature.UseSingleQuotes.mask | 0) | SerializerFeature.BrowserCompatible.mask) | SerializerFeature.PrettyFormat.mask) | SerializerFeature.WriteEnumUsingToString.mask) | SerializerFeature.WriteNonStringValueAsString.mask) | SerializerFeature.WriteSlashAsSpecial.mask) | SerializerFeature.IgnoreErrorGetter.mask) | SerializerFeature.WriteClassName.mask) | SerializerFeature.NotWriteDefaultValue.mask);
    /* renamed from: s */
    private static final ThreadLocal<char[]> f2906s = new ThreadLocal<>();
    /* renamed from: t */
    private static final ThreadLocal<byte[]> f2907t = new ThreadLocal<>();
    /* renamed from: a */
    protected char[] f2908a;
    /* renamed from: b */
    protected int f2909b;
    /* renamed from: c */
    protected int f2910c;
    /* renamed from: d */
    protected boolean f2911d;
    /* renamed from: e */
    protected boolean f2912e;
    /* renamed from: f */
    protected boolean f2913f;
    /* renamed from: g */
    protected boolean f2914g;
    /* renamed from: h */
    protected boolean f2915h;
    /* renamed from: i */
    protected boolean f2916i;
    /* renamed from: j */
    protected boolean f2917j;
    /* renamed from: k */
    protected boolean f2918k;
    /* renamed from: l */
    protected boolean f2919l;
    /* renamed from: m */
    protected boolean f2920m;
    /* renamed from: n */
    protected char f2921n;
    /* renamed from: o */
    protected int f2922o;
    /* renamed from: p */
    protected boolean f2923p;
    /* renamed from: q */
    protected long f2924q;
    /* renamed from: u */
    private final Writer f2925u;

    public SerializeWriter() {
        this(null);
    }

    public SerializeWriter(Writer writer) {
        this(writer, JSON.DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY);
    }

    public SerializeWriter(Writer writer, int i, SerializerFeature... serializerFeatureArr) {
        this.f2922o = -1;
        this.f2925u = writer;
        this.f2908a = (char[]) f2906s.get();
        if (this.f2908a != null) {
            f2906s.set(null);
        } else {
            this.f2908a = new char[2048];
        }
        for (SerializerFeature mask : serializerFeatureArr) {
            i |= mask.getMask();
        }
        this.f2910c = i;
        mo11373a();
    }

    /* renamed from: a */
    public void mo11382a(SerializerFeature serializerFeature, boolean z) {
        if (z) {
            this.f2910c |= serializerFeature.getMask();
            if (serializerFeature == SerializerFeature.WriteEnumUsingToString) {
                this.f2910c &= ~SerializerFeature.WriteEnumUsingName.getMask();
            } else if (serializerFeature == SerializerFeature.WriteEnumUsingName) {
                this.f2910c &= ~SerializerFeature.WriteEnumUsingToString.getMask();
            }
        } else {
            this.f2910c = (~serializerFeature.getMask()) & this.f2910c;
        }
        mo11373a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo11373a() {
        boolean z = true;
        this.f2912e = (this.f2910c & SerializerFeature.QuoteFieldNames.mask) != 0;
        this.f2911d = (this.f2910c & SerializerFeature.UseSingleQuotes.mask) != 0;
        this.f2913f = (this.f2910c & SerializerFeature.SortField.mask) != 0;
        this.f2914g = (this.f2910c & SerializerFeature.DisableCircularReferenceDetect.mask) != 0;
        this.f2915h = (this.f2910c & SerializerFeature.BeanToArray.mask) != 0;
        this.f2916i = (this.f2910c & SerializerFeature.WriteNonStringValueAsString.mask) != 0;
        this.f2917j = (this.f2910c & SerializerFeature.NotWriteDefaultValue.mask) != 0;
        this.f2918k = (this.f2910c & SerializerFeature.WriteEnumUsingName.mask) != 0;
        this.f2919l = (this.f2910c & SerializerFeature.WriteEnumUsingToString.mask) != 0;
        boolean z2 = this.f2912e && (this.f2910c & f2905r) == 0 && (this.f2915h || this.f2918k);
        this.f2920m = z2;
        this.f2921n = this.f2911d ? '\'' : '\"';
        if ((this.f2910c & SerializerFeature.BrowserSecure.mask) == 0) {
            z = false;
        }
        this.f2923p = z;
        long j = this.f2923p ? 5764610843043954687L : (this.f2910c & SerializerFeature.WriteSlashAsSpecial.mask) != 0 ? 140758963191807L : 21474836479L;
        this.f2924q = j;
    }

    /* renamed from: a */
    public boolean mo11391a(SerializerFeature serializerFeature) {
        return (serializerFeature.mask & this.f2910c) != 0;
    }

    /* renamed from: a */
    public boolean mo11390a(int i) {
        return (i & this.f2910c) != 0;
    }

    public void write(int i) {
        int i2 = this.f2909b + 1;
        if (i2 > this.f2908a.length) {
            if (this.f2925u == null) {
                mo11398b(i2);
            } else {
                flush();
                i2 = 1;
            }
        }
        this.f2908a[this.f2909b] = (char) i;
        this.f2909b = i2;
    }

    public void write(char[] cArr, int i, int i2) {
        int i3;
        int i4;
        if (i >= 0 && i <= cArr.length && i2 >= 0) {
            int i5 = i + i2;
            if (i5 <= cArr.length && i5 >= 0) {
                if (i2 != 0) {
                    int i6 = this.f2909b + i2;
                    if (i6 > this.f2908a.length) {
                        if (this.f2925u == null) {
                            mo11398b(i6);
                        } else {
                            do {
                                char[] cArr2 = this.f2908a;
                                int length = cArr2.length;
                                int i7 = this.f2909b;
                                int i8 = length - i7;
                                System.arraycopy(cArr, i4, cArr2, i7, i8);
                                this.f2909b = this.f2908a.length;
                                flush();
                                i2 = i3 - i8;
                                i = i4 + i8;
                            } while (i2 > this.f2908a.length);
                            i6 = i2;
                        }
                    }
                    System.arraycopy(cArr, i, this.f2908a, this.f2909b, i2);
                    this.f2909b = i6;
                    return;
                }
                return;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    /* renamed from: b */
    public void mo11398b(int i) {
        int i2 = this.f2922o;
        if (i2 == -1 || i < i2) {
            char[] cArr = this.f2908a;
            int length = cArr.length + (cArr.length >> 1) + 1;
            if (length >= i) {
                i = length;
            }
            char[] cArr2 = new char[i];
            System.arraycopy(this.f2908a, 0, cArr2, 0, this.f2909b);
            this.f2908a = cArr2;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("serialize exceeded MAX_OUTPUT_LENGTH=");
        sb.append(this.f2922o);
        sb.append(", minimumCapacity=");
        sb.append(i);
        throw new JSONException(sb.toString());
    }

    /* renamed from: a */
    public SerializeWriter append(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "null" : charSequence.toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    /* renamed from: a */
    public SerializeWriter append(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            charSequence = "null";
        }
        String charSequence2 = charSequence.subSequence(i, i2).toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    /* renamed from: a */
    public SerializeWriter append(char c) {
        write((int) c);
        return this;
    }

    public void write(String str, int i, int i2) {
        int i3;
        int i4 = this.f2909b + i2;
        if (i4 > this.f2908a.length) {
            if (this.f2925u == null) {
                mo11398b(i4);
            } else {
                while (true) {
                    char[] cArr = this.f2908a;
                    int length = cArr.length;
                    int i5 = this.f2909b;
                    int i6 = length - i5;
                    i3 = i + i6;
                    str.getChars(i, i3, cArr, i5);
                    this.f2909b = this.f2908a.length;
                    flush();
                    i2 -= i6;
                    if (i2 <= this.f2908a.length) {
                        break;
                    }
                    i = i3;
                }
                i4 = i2;
                i = i3;
            }
        }
        str.getChars(i, i2 + i, this.f2908a, this.f2909b);
        this.f2909b = i4;
    }

    /* renamed from: a */
    public int mo11369a(OutputStream outputStream, Charset charset) throws IOException {
        if (this.f2925u != null) {
            throw new UnsupportedOperationException("writer not null");
        } else if (charset == IOUtils.f3014b) {
            return m3054a(outputStream);
        } else {
            byte[] bytes = new String(this.f2908a, 0, this.f2909b).getBytes(charset);
            outputStream.write(bytes);
            return bytes.length;
        }
    }

    /* renamed from: a */
    public byte[] mo11392a(Charset charset) {
        if (this.f2925u != null) {
            throw new UnsupportedOperationException("writer not null");
        } else if (charset == IOUtils.f3014b) {
            return m3055c();
        } else {
            return new String(this.f2908a, 0, this.f2909b).getBytes(charset);
        }
    }

    /* renamed from: a */
    private int m3054a(OutputStream outputStream) throws IOException {
        int i = (int) (((double) this.f2909b) * 3.0d);
        byte[] bArr = (byte[]) f2907t.get();
        if (bArr == null) {
            bArr = new byte[8192];
            f2907t.set(bArr);
        }
        if (bArr.length < i) {
            bArr = new byte[i];
        }
        int a = IOUtils.m3189a(this.f2908a, 0, this.f2909b, bArr);
        outputStream.write(bArr, 0, a);
        return a;
    }

    /* renamed from: c */
    private byte[] m3055c() {
        int i = (int) (((double) this.f2909b) * 3.0d);
        byte[] bArr = (byte[]) f2907t.get();
        if (bArr == null) {
            bArr = new byte[8192];
            f2907t.set(bArr);
        }
        if (bArr.length < i) {
            bArr = new byte[i];
        }
        int a = IOUtils.m3189a(this.f2908a, 0, this.f2909b, bArr);
        byte[] bArr2 = new byte[a];
        System.arraycopy(bArr, 0, bArr2, 0, a);
        return bArr2;
    }

    public String toString() {
        return new String(this.f2908a, 0, this.f2909b);
    }

    public void close() {
        if (this.f2925u != null && this.f2909b > 0) {
            flush();
        }
        char[] cArr = this.f2908a;
        if (cArr.length <= 131072) {
            f2906s.set(cArr);
        }
        this.f2908a = null;
    }

    public void write(String str) {
        if (str == null) {
            mo11396b();
        } else {
            write(str, 0, str.length());
        }
    }

    /* renamed from: c */
    public void mo11403c(int i) {
        if (i == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int a = i < 0 ? IOUtils.m3186a(-i) + 1 : IOUtils.m3186a(i);
        int i2 = this.f2909b + a;
        if (i2 > this.f2908a.length) {
            if (this.f2925u == null) {
                mo11398b(i2);
            } else {
                char[] cArr = new char[a];
                IOUtils.m3192a(i, a, cArr);
                write(cArr, 0, cArr.length);
                return;
            }
        }
        IOUtils.m3192a(i, i2, this.f2908a);
        this.f2909b = i2;
    }

    /* renamed from: a */
    public void mo11388a(byte[] bArr) {
        byte[] bArr2 = bArr;
        if (mo11390a(SerializerFeature.WriteClassName.mask)) {
            mo11401b(bArr);
            return;
        }
        int length = bArr2.length;
        char c = this.f2911d ? '\'' : '\"';
        if (length == 0) {
            write(this.f2911d ? "''" : "\"\"");
            return;
        }
        char[] cArr = IOUtils.f3028p;
        int i = (length / 3) * 3;
        int i2 = length - 1;
        int i3 = ((i2 / 3) + 1) << 2;
        int i4 = this.f2909b;
        int i5 = i3 + i4 + 2;
        int i6 = 0;
        if (i5 > this.f2908a.length) {
            if (this.f2925u != null) {
                write((int) c);
                int i7 = 0;
                while (i7 < i) {
                    int i8 = i7 + 1;
                    int i9 = i8 + 1;
                    byte b = ((bArr2[i7] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16) | ((bArr2[i8] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8);
                    int i10 = i9 + 1;
                    byte b2 = b | (bArr2[i9] & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
                    write((int) cArr[(b2 >>> 18) & 63]);
                    write((int) cArr[(b2 >>> JceStruct.ZERO_TAG) & 63]);
                    write((int) cArr[(b2 >>> 6) & 63]);
                    write((int) cArr[b2 & 63]);
                    i7 = i10;
                }
                int i11 = length - i;
                if (i11 > 0) {
                    int i12 = (bArr2[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 10;
                    if (i11 == 2) {
                        i6 = (bArr2[i2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 2;
                    }
                    int i13 = i12 | i6;
                    write((int) cArr[i13 >> 12]);
                    write((int) cArr[(i13 >>> 6) & 63]);
                    write((int) i11 == 2 ? cArr[i13 & 63] : '=');
                    write(61);
                }
                write((int) c);
                return;
            }
            mo11398b(i5);
        }
        this.f2909b = i5;
        int i14 = i4 + 1;
        this.f2908a[i4] = c;
        int i15 = 0;
        while (i15 < i) {
            int i16 = i15 + 1;
            int i17 = i16 + 1;
            byte b3 = ((bArr2[i15] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16) | ((bArr2[i16] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8);
            int i18 = i17 + 1;
            byte b4 = b3 | (bArr2[i17] & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            char[] cArr2 = this.f2908a;
            int i19 = i14 + 1;
            cArr2[i14] = cArr[(b4 >>> 18) & 63];
            int i20 = i19 + 1;
            cArr2[i19] = cArr[(b4 >>> JceStruct.ZERO_TAG) & 63];
            int i21 = i20 + 1;
            cArr2[i20] = cArr[(b4 >>> 6) & 63];
            i14 = i21 + 1;
            cArr2[i21] = cArr[b4 & 63];
            i15 = i18;
        }
        int i22 = length - i;
        if (i22 > 0) {
            int i23 = (bArr2[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 10;
            if (i22 == 2) {
                i6 = (bArr2[i2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 2;
            }
            int i24 = i23 | i6;
            char[] cArr3 = this.f2908a;
            cArr3[i5 - 5] = cArr[i24 >> 12];
            cArr3[i5 - 4] = cArr[(i24 >>> 6) & 63];
            cArr3[i5 - 3] = i22 == 2 ? cArr[i24 & 63] : '=';
            this.f2908a[i5 - 2] = '=';
        }
        this.f2908a[i5 - 1] = c;
    }

    /* renamed from: b */
    public void mo11401b(byte[] bArr) {
        int i = 2;
        int length = this.f2909b + (bArr.length * 2) + 3;
        int i2 = 0;
        if (length > this.f2908a.length) {
            if (this.f2925u != null) {
                char[] cArr = new char[(bArr.length + 3)];
                cArr[0] = 'x';
                cArr[1] = '\'';
                while (i2 < bArr.length) {
                    byte b = bArr[i2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                    int i3 = b >> 4;
                    byte b2 = b & 15;
                    int i4 = i + 1;
                    cArr[i] = (char) (i3 + (i3 < 10 ? 48 : 55));
                    i = i4 + 1;
                    cArr[i4] = (char) (b2 + (b2 < 10 ? (byte) 48 : 55));
                    i2++;
                }
                cArr[i] = '\'';
                try {
                    this.f2925u.write(cArr);
                    return;
                } catch (IOException e) {
                    throw new JSONException("writeBytes error.", e);
                }
            } else {
                mo11398b(length);
            }
        }
        char[] cArr2 = this.f2908a;
        int i5 = this.f2909b;
        this.f2909b = i5 + 1;
        cArr2[i5] = 'x';
        int i6 = this.f2909b;
        this.f2909b = i6 + 1;
        cArr2[i6] = '\'';
        while (i2 < bArr.length) {
            byte b3 = bArr[i2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
            int i7 = b3 >> 4;
            byte b4 = b3 & 15;
            char[] cArr3 = this.f2908a;
            int i8 = this.f2909b;
            this.f2909b = i8 + 1;
            cArr3[i8] = (char) (i7 + (i7 < 10 ? 48 : 55));
            char[] cArr4 = this.f2908a;
            int i9 = this.f2909b;
            this.f2909b = i9 + 1;
            cArr4[i9] = (char) (b4 + (b4 < 10 ? (byte) 48 : 55));
            i2++;
        }
        char[] cArr5 = this.f2908a;
        int i10 = this.f2909b;
        this.f2909b = i10 + 1;
        cArr5[i10] = '\'';
    }

    /* renamed from: a */
    public void mo11379a(float f, boolean z) {
        if (Float.isNaN(f) || Float.isInfinite(f)) {
            mo11396b();
            return;
        }
        String f2 = Float.toString(f);
        if (mo11391a(SerializerFeature.WriteNullNumberAsZero) && f2.endsWith(".0")) {
            f2 = f2.substring(0, f2.length() - 2);
        }
        write(f2);
        if (z && mo11391a(SerializerFeature.WriteClassName)) {
            write(70);
        }
    }

    /* renamed from: a */
    public void mo11378a(double d, boolean z) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            mo11396b();
            return;
        }
        String d2 = Double.toString(d);
        if (mo11391a(SerializerFeature.WriteNullNumberAsZero) && d2.endsWith(".0")) {
            d2 = d2.substring(0, d2.length() - 2);
        }
        write(d2);
        if (z && mo11391a(SerializerFeature.WriteClassName)) {
            write(68);
        }
    }

    /* renamed from: a */
    public void mo11383a(Enum<?> enumR) {
        if (enumR == null) {
            mo11396b();
            return;
        }
        String str = null;
        if (this.f2918k && !this.f2919l) {
            str = enumR.name();
        } else if (this.f2919l) {
            str = enumR.toString();
        }
        if (str != null) {
            int i = mo11391a(SerializerFeature.UseSingleQuotes) ? 39 : 34;
            write(i);
            write(str);
            write(i);
        } else {
            mo11403c(enumR.ordinal());
        }
    }

    /* renamed from: a */
    public void mo11381a(long j) {
        boolean z = mo11391a(SerializerFeature.BrowserCompatible) && !mo11391a(SerializerFeature.WriteClassName) && (j > 9007199254740991L || j < -9007199254740991L);
        if (j == Long.MIN_VALUE) {
            if (z) {
                write("\"-9223372036854775808\"");
            } else {
                write("-9223372036854775808");
            }
            return;
        }
        int a = j < 0 ? IOUtils.m3187a(-j) + 1 : IOUtils.m3187a(j);
        int i = this.f2909b + a;
        if (z) {
            i += 2;
        }
        if (i > this.f2908a.length) {
            if (this.f2925u == null) {
                mo11398b(i);
            } else {
                char[] cArr = new char[a];
                IOUtils.m3193a(j, a, cArr);
                if (z) {
                    write(34);
                    write(cArr, 0, cArr.length);
                    write(34);
                } else {
                    write(cArr, 0, cArr.length);
                }
                return;
            }
        }
        if (z) {
            char[] cArr2 = this.f2908a;
            cArr2[this.f2909b] = '\"';
            int i2 = i - 1;
            IOUtils.m3193a(j, i2, cArr2);
            this.f2908a[i2] = '\"';
        } else {
            IOUtils.m3193a(j, i, this.f2908a);
        }
        this.f2909b = i;
    }

    /* renamed from: b */
    public void mo11396b() {
        write("null");
    }

    /* renamed from: b */
    public void mo11399b(SerializerFeature serializerFeature) {
        mo11380a(0, serializerFeature.mask);
    }

    /* renamed from: a */
    public void mo11380a(int i, int i2) {
        if ((i & i2) == 0 && (this.f2910c & i2) == 0) {
            mo11396b();
            return;
        }
        if (i2 == SerializerFeature.WriteNullListAsEmpty.mask) {
            write("[]");
        } else if (i2 == SerializerFeature.WriteNullStringAsEmpty.mask) {
            mo11384a("");
        } else if (i2 == SerializerFeature.WriteNullBooleanAsFalse.mask) {
            write("false");
        } else if (i2 == SerializerFeature.WriteNullNumberAsZero.mask) {
            write(48);
        } else {
            mo11396b();
        }
    }

    /* renamed from: a */
    public void mo11385a(String str, char c) {
        int i;
        int i2;
        int i3;
        int i4;
        String str2 = str;
        char c2 = c;
        if (str2 == null) {
            mo11396b();
            if (c2 != 0) {
                write((int) c2);
            }
            return;
        }
        int length = str.length();
        int i5 = this.f2909b + length + 2;
        if (c2 != 0) {
            i5++;
        }
        if (i > this.f2908a.length) {
            if (this.f2925u != null) {
                write(34);
                for (int i6 = 0; i6 < str.length(); i6++) {
                    char charAt = str2.charAt(i6);
                    if (!mo11391a(SerializerFeature.BrowserSecure) || !(charAt == '(' || charAt == ')' || charAt == '<' || charAt == '>')) {
                        if (mo11391a(SerializerFeature.BrowserCompatible)) {
                            if (charAt == 8 || charAt == 12 || charAt == 10 || charAt == 13 || charAt == 9 || charAt == '\"' || charAt == '/' || charAt == '\\') {
                                write(92);
                                write((int) IOUtils.f3022j[charAt]);
                            } else if (charAt < ' ') {
                                write(92);
                                write(117);
                                write(48);
                                write(48);
                                int i7 = charAt * 2;
                                write((int) IOUtils.f3023k[i7]);
                                write((int) IOUtils.f3023k[i7 + 1]);
                            } else if (charAt >= 127) {
                                write(92);
                                write(117);
                                write((int) IOUtils.f3015c[(charAt >>> 12) & 15]);
                                write((int) IOUtils.f3015c[(charAt >>> 8) & 15]);
                                write((int) IOUtils.f3015c[(charAt >>> 4) & 15]);
                                write((int) IOUtils.f3015c[charAt & 15]);
                            }
                        } else if ((charAt < IOUtils.f3018f.length && IOUtils.f3018f[charAt] != 0) || (charAt == '/' && mo11391a(SerializerFeature.WriteSlashAsSpecial))) {
                            write(92);
                            if (IOUtils.f3018f[charAt] == 4) {
                                write(117);
                                write((int) IOUtils.f3015c[(charAt >>> 12) & 15]);
                                write((int) IOUtils.f3015c[(charAt >>> 8) & 15]);
                                write((int) IOUtils.f3015c[(charAt >>> 4) & 15]);
                                write((int) IOUtils.f3015c[charAt & 15]);
                            } else {
                                write((int) IOUtils.f3022j[charAt]);
                            }
                        }
                        write((int) charAt);
                    } else {
                        write(92);
                        write(117);
                        write((int) IOUtils.f3015c[(charAt >>> 12) & 15]);
                        write((int) IOUtils.f3015c[(charAt >>> 8) & 15]);
                        write((int) IOUtils.f3015c[(charAt >>> 4) & 15]);
                        write((int) IOUtils.f3015c[charAt & 15]);
                    }
                }
                write(34);
                if (c2 != 0) {
                    write((int) c2);
                }
                return;
            }
            mo11398b(i);
        }
        int i8 = this.f2909b;
        int i9 = i8 + 1;
        int i10 = i9 + length;
        char[] cArr = this.f2908a;
        cArr[i8] = '\"';
        str2.getChars(0, length, cArr, i9);
        this.f2909b = i;
        int i11 = -1;
        if (mo11391a(SerializerFeature.BrowserCompatible)) {
            for (int i12 = i9; i12 < i10; i12++) {
                char c3 = this.f2908a[i12];
                if (c3 == '\"' || c3 == '/' || c3 == '\\' || c3 == 8 || c3 == 12 || c3 == 10 || c3 == 13 || c3 == 9) {
                    i++;
                } else if (c3 >= ' ' && c3 < 127) {
                } else {
                    i += 5;
                }
                i11 = i12;
            }
            if (i > this.f2908a.length) {
                mo11398b(i);
            }
            this.f2909b = i;
            while (i11 >= i9) {
                char[] cArr2 = this.f2908a;
                char c4 = cArr2[i11];
                if (c4 == 8 || c4 == 12 || c4 == 10 || c4 == 13 || c4 == 9) {
                    char[] cArr3 = this.f2908a;
                    int i13 = i11 + 1;
                    System.arraycopy(cArr3, i13, cArr3, i11 + 2, (i10 - i11) - 1);
                    char[] cArr4 = this.f2908a;
                    cArr4[i11] = '\\';
                    cArr4[i13] = IOUtils.f3022j[c4];
                } else if (c4 == '\"' || c4 == '/' || c4 == '\\') {
                    char[] cArr5 = this.f2908a;
                    int i14 = i11 + 1;
                    System.arraycopy(cArr5, i14, cArr5, i11 + 2, (i10 - i11) - 1);
                    char[] cArr6 = this.f2908a;
                    cArr6[i11] = '\\';
                    cArr6[i14] = c4;
                } else {
                    if (c4 < ' ') {
                        int i15 = i11 + 1;
                        System.arraycopy(cArr2, i15, cArr2, i11 + 6, (i10 - i11) - 1);
                        char[] cArr7 = this.f2908a;
                        cArr7[i11] = '\\';
                        cArr7[i15] = 'u';
                        cArr7[i11 + 2] = '0';
                        cArr7[i11 + 3] = '0';
                        int i16 = c4 * 2;
                        cArr7[i11 + 4] = IOUtils.f3023k[i16];
                        this.f2908a[i11 + 5] = IOUtils.f3023k[i16 + 1];
                    } else if (c4 >= 127) {
                        int i17 = i11 + 1;
                        System.arraycopy(cArr2, i17, cArr2, i11 + 6, (i10 - i11) - 1);
                        char[] cArr8 = this.f2908a;
                        cArr8[i11] = '\\';
                        cArr8[i17] = 'u';
                        cArr8[i11 + 2] = IOUtils.f3015c[(c4 >>> 12) & 15];
                        this.f2908a[i11 + 3] = IOUtils.f3015c[(c4 >>> 8) & 15];
                        this.f2908a[i11 + 4] = IOUtils.f3015c[(c4 >>> 4) & 15];
                        this.f2908a[i11 + 5] = IOUtils.f3015c[c4 & 15];
                    } else {
                        i11--;
                    }
                    i10 += 5;
                    i11--;
                }
                i10++;
                i11--;
            }
            if (c2 != 0) {
                char[] cArr9 = this.f2908a;
                int i18 = this.f2909b;
                cArr9[i18 - 2] = '\"';
                cArr9[i18 - 1] = c2;
            } else {
                this.f2908a[this.f2909b - 1] = '\"';
            }
            return;
        }
        int i19 = i;
        int i20 = 0;
        char c5 = 0;
        int i21 = -1;
        int i22 = -1;
        for (int i23 = i9; i23 < i10; i23++) {
            char c6 = this.f2908a[i23];
            if (c6 >= ']') {
                if (c6 >= 127 && (c6 == 8232 || c6 == 8233 || c6 < 160)) {
                    if (i21 == i2) {
                        i21 = i23;
                    }
                    i20++;
                    i19 += 4;
                }
            } else {
                boolean z = (c6 < '@' && (this.f2924q & (1 << c6)) != 0) || c6 == '\\';
                if (z) {
                    i20++;
                    if (c6 == '(' || c6 == ')' || c6 == '<' || c6 == '>' || (c6 < IOUtils.f3018f.length && IOUtils.f3018f[c6] == 4)) {
                        int i24 = i19 + 4;
                    }
                    i2 = -1;
                    if (i21 == -1) {
                        i21 = i23;
                        i22 = i21;
                        c5 = c6;
                    }
                } else {
                    i2 = -1;
                }
            }
            i22 = i23;
            c5 = c6;
        }
        if (i20 > 0) {
            int i25 = i19 + i20;
            if (i25 > this.f2908a.length) {
                mo11398b(i25);
            }
            this.f2909b = i25;
            if (i20 == 1) {
                if (c5 == 8232) {
                    int i26 = i22 + 1;
                    int i27 = i22 + 6;
                    int i28 = (i10 - i22) - 1;
                    char[] cArr10 = this.f2908a;
                    System.arraycopy(cArr10, i26, cArr10, i27, i28);
                    char[] cArr11 = this.f2908a;
                    cArr11[i22] = '\\';
                    cArr11[i26] = 'u';
                    int i29 = i26 + 1;
                    cArr11[i29] = '2';
                    int i30 = i29 + 1;
                    cArr11[i30] = '0';
                    int i31 = i30 + 1;
                    cArr11[i31] = '2';
                    cArr11[i31 + 1] = '8';
                } else if (c5 == 8233) {
                    int i32 = i22 + 1;
                    int i33 = i22 + 6;
                    int i34 = (i10 - i22) - 1;
                    char[] cArr12 = this.f2908a;
                    System.arraycopy(cArr12, i32, cArr12, i33, i34);
                    char[] cArr13 = this.f2908a;
                    cArr13[i22] = '\\';
                    cArr13[i32] = 'u';
                    int i35 = i32 + 1;
                    cArr13[i35] = '2';
                    int i36 = i35 + 1;
                    cArr13[i36] = '0';
                    int i37 = i36 + 1;
                    cArr13[i37] = '2';
                    cArr13[i37 + 1] = '9';
                } else if (c5 == '(' || c5 == ')' || c5 == '<' || c5 == '>') {
                    int i38 = i22 + 1;
                    int i39 = i22 + 6;
                    int i40 = (i10 - i22) - 1;
                    char[] cArr14 = this.f2908a;
                    System.arraycopy(cArr14, i38, cArr14, i39, i40);
                    char[] cArr15 = this.f2908a;
                    cArr15[i22] = '\\';
                    cArr15[i38] = 'u';
                    int i41 = i38 + 1;
                    cArr15[i41] = IOUtils.f3015c[(c5 >>> 12) & 15];
                    int i42 = i41 + 1;
                    this.f2908a[i42] = IOUtils.f3015c[(c5 >>> 8) & 15];
                    int i43 = i42 + 1;
                    this.f2908a[i43] = IOUtils.f3015c[(c5 >>> 4) & 15];
                    this.f2908a[i43 + 1] = IOUtils.f3015c[c5 & 15];
                } else if (c5 >= IOUtils.f3018f.length || IOUtils.f3018f[c5] != 4) {
                    int i44 = i22 + 1;
                    int i45 = i22 + 2;
                    int i46 = (i10 - i22) - 1;
                    char[] cArr16 = this.f2908a;
                    System.arraycopy(cArr16, i44, cArr16, i45, i46);
                    char[] cArr17 = this.f2908a;
                    cArr17[i22] = '\\';
                    cArr17[i44] = IOUtils.f3022j[c5];
                } else {
                    int i47 = i22 + 1;
                    int i48 = i22 + 6;
                    int i49 = (i10 - i22) - 1;
                    char[] cArr18 = this.f2908a;
                    System.arraycopy(cArr18, i47, cArr18, i48, i49);
                    char[] cArr19 = this.f2908a;
                    cArr19[i22] = '\\';
                    int i50 = i47 + 1;
                    cArr19[i47] = 'u';
                    int i51 = i50 + 1;
                    cArr19[i50] = IOUtils.f3015c[(c5 >>> 12) & 15];
                    int i52 = i51 + 1;
                    this.f2908a[i51] = IOUtils.f3015c[(c5 >>> 8) & 15];
                    int i53 = i52 + 1;
                    this.f2908a[i52] = IOUtils.f3015c[(c5 >>> 4) & 15];
                    this.f2908a[i53] = IOUtils.f3015c[c5 & 15];
                }
            } else if (i20 > 1) {
                for (int i54 = i21 - i9; i54 < str.length(); i54++) {
                    char charAt2 = str2.charAt(i54);
                    if (!this.f2923p || !(charAt2 == '(' || charAt2 == ')' || charAt2 == '<' || charAt2 == '>')) {
                        if (charAt2 >= IOUtils.f3018f.length || IOUtils.f3018f[charAt2] == 0) {
                            if (charAt2 != '/' || !mo11391a(SerializerFeature.WriteSlashAsSpecial)) {
                                if (charAt2 == 8232 || charAt2 == 8233) {
                                    char[] cArr20 = this.f2908a;
                                    int i55 = i3 + 1;
                                    cArr20[i3] = '\\';
                                    int i56 = i55 + 1;
                                    cArr20[i55] = 'u';
                                    int i57 = i56 + 1;
                                    cArr20[i56] = IOUtils.f3015c[(charAt2 >>> 12) & 15];
                                    int i58 = i57 + 1;
                                    this.f2908a[i57] = IOUtils.f3015c[(charAt2 >>> 8) & 15];
                                    int i59 = i58 + 1;
                                    this.f2908a[i58] = IOUtils.f3015c[(charAt2 >>> 4) & 15];
                                    int i60 = i59 + 1;
                                    this.f2908a[i59] = IOUtils.f3015c[charAt2 & 15];
                                    i3 = i60;
                                } else {
                                    int i61 = i3 + 1;
                                    this.f2908a[i3] = charAt2;
                                    i3 = i61;
                                }
                            }
                        }
                        int i62 = i3 + 1;
                        this.f2908a[i3] = '\\';
                        if (IOUtils.f3018f[charAt2] == 4) {
                            char[] cArr21 = this.f2908a;
                            int i63 = i62 + 1;
                            cArr21[i62] = 'u';
                            int i64 = i63 + 1;
                            cArr21[i63] = IOUtils.f3015c[(charAt2 >>> 12) & 15];
                            int i65 = i64 + 1;
                            this.f2908a[i64] = IOUtils.f3015c[(charAt2 >>> 8) & 15];
                            int i66 = i65 + 1;
                            this.f2908a[i65] = IOUtils.f3015c[(charAt2 >>> 4) & 15];
                            i4 = i66 + 1;
                            this.f2908a[i66] = IOUtils.f3015c[charAt2 & 15];
                        } else {
                            i4 = i62 + 1;
                            this.f2908a[i62] = IOUtils.f3022j[charAt2];
                        }
                        i3 = i4;
                    } else {
                        char[] cArr22 = this.f2908a;
                        int i67 = i3 + 1;
                        cArr22[i3] = '\\';
                        int i68 = i67 + 1;
                        cArr22[i67] = 'u';
                        int i69 = i68 + 1;
                        cArr22[i68] = IOUtils.f3015c[(charAt2 >>> 12) & 15];
                        int i70 = i69 + 1;
                        this.f2908a[i69] = IOUtils.f3015c[(charAt2 >>> 8) & 15];
                        int i71 = i70 + 1;
                        this.f2908a[i70] = IOUtils.f3015c[(charAt2 >>> 4) & 15];
                        int i72 = i71 + 1;
                        this.f2908a[i71] = IOUtils.f3015c[charAt2 & 15];
                        i3 = i72;
                    }
                }
            }
        }
        if (c2 != 0) {
            char[] cArr23 = this.f2908a;
            int i73 = this.f2909b;
            cArr23[i73 - 2] = '\"';
            cArr23[i73 - 1] = c2;
        } else {
            this.f2908a[this.f2909b - 1] = '\"';
        }
    }

    /* renamed from: a */
    public void mo11387a(boolean z) {
        if (z) {
            write("true");
        } else {
            write("false");
        }
    }

    /* renamed from: a */
    public void mo11375a(char c, String str, int i) {
        if (i == Integer.MIN_VALUE || !this.f2912e) {
            write((int) c);
            mo11404c(str);
            mo11403c(i);
            return;
        }
        int a = i < 0 ? IOUtils.m3186a(-i) + 1 : IOUtils.m3186a(i);
        int length = str.length();
        int i2 = this.f2909b + length + 4 + a;
        if (i2 > this.f2908a.length) {
            if (this.f2925u != null) {
                write((int) c);
                mo11404c(str);
                mo11403c(i);
                return;
            }
            mo11398b(i2);
        }
        int i3 = this.f2909b;
        this.f2909b = i2;
        char[] cArr = this.f2908a;
        cArr[i3] = c;
        int i4 = i3 + length + 1;
        cArr[i3 + 1] = this.f2921n;
        str.getChars(0, length, cArr, i3 + 2);
        char[] cArr2 = this.f2908a;
        cArr2[i4 + 1] = this.f2921n;
        cArr2[i4 + 2] = ':';
        IOUtils.m3192a(i, this.f2909b, cArr2);
    }

    /* renamed from: a */
    public void mo11376a(char c, String str, long j) {
        if (j == Long.MIN_VALUE || !this.f2912e) {
            write((int) c);
            mo11404c(str);
            mo11381a(j);
            return;
        }
        int a = j < 0 ? IOUtils.m3187a(-j) + 1 : IOUtils.m3187a(j);
        int length = str.length();
        int i = this.f2909b + length + 4 + a;
        if (i > this.f2908a.length) {
            if (this.f2925u != null) {
                write((int) c);
                mo11404c(str);
                mo11381a(j);
                return;
            }
            mo11398b(i);
        }
        int i2 = this.f2909b;
        this.f2909b = i;
        char[] cArr = this.f2908a;
        cArr[i2] = c;
        int i3 = i2 + length + 1;
        cArr[i2 + 1] = this.f2921n;
        str.getChars(0, length, cArr, i2 + 2);
        char[] cArr2 = this.f2908a;
        cArr2[i3 + 1] = this.f2921n;
        cArr2[i3 + 2] = ':';
        IOUtils.m3193a(j, this.f2909b, cArr2);
    }

    /* renamed from: a */
    public void mo11374a(char c, String str, double d) {
        write((int) c);
        mo11404c(str);
        mo11378a(d, false);
    }

    /* renamed from: a */
    public void mo11377a(char c, String str, String str2) {
        if (!this.f2912e) {
            write((int) c);
            mo11404c(str);
            if (str2 == null) {
                mo11396b();
            } else {
                mo11384a(str2);
            }
        } else if (this.f2911d) {
            write((int) c);
            mo11404c(str);
            if (str2 == null) {
                mo11396b();
            } else {
                mo11384a(str2);
            }
        } else if (mo11391a(SerializerFeature.BrowserCompatible)) {
            write((int) c);
            mo11385a(str, ':');
            mo11385a(str2, 0);
        } else {
            mo11397b(c, str, str2);
        }
    }

    /* renamed from: b */
    public void mo11397b(char c, String str, String str2) {
        int i;
        int i2;
        int i3;
        int i4;
        String str3 = str;
        String str4 = str2;
        int length = str.length();
        int i5 = this.f2909b;
        if (str4 == null) {
            i2 = i5 + length + 8;
            i = 4;
        } else {
            i = str2.length();
            i2 = i5 + length + i + 6;
        }
        if (i2 > this.f2908a.length) {
            if (this.f2925u != null) {
                write((int) c);
                mo11385a(str3, ':');
                mo11385a(str4, 0);
                return;
            }
            mo11398b(i2);
        }
        char[] cArr = this.f2908a;
        int i6 = this.f2909b;
        cArr[i6] = c;
        int i7 = i6 + 2;
        int i8 = i7 + length;
        cArr[i6 + 1] = '\"';
        str3.getChars(0, length, cArr, i7);
        this.f2909b = i2;
        char[] cArr2 = this.f2908a;
        cArr2[i8] = '\"';
        int i9 = i8 + 1;
        int i10 = i9 + 1;
        cArr2[i9] = ':';
        if (str4 == null) {
            int i11 = i10 + 1;
            cArr2[i10] = 'n';
            int i12 = i11 + 1;
            cArr2[i11] = 'u';
            int i13 = i12 + 1;
            cArr2[i12] = 'l';
            cArr2[i13] = 'l';
            return;
        }
        int i14 = i10 + 1;
        cArr2[i10] = '\"';
        int i15 = i14 + i;
        str4.getChars(0, i, cArr2, i14);
        int i16 = i2;
        int i17 = 0;
        char c2 = 0;
        int i18 = -1;
        int i19 = -1;
        for (int i20 = i14; i20 < i15; i20++) {
            char c3 = this.f2908a[i20];
            if (c3 >= ']') {
                if (c3 >= 127 && (c3 == 8232 || c3 == 8233 || c3 < 160)) {
                    if (i18 == -1) {
                        i18 = i20;
                    }
                    i17++;
                    i16 += 4;
                }
            } else {
                boolean z = (c3 < '@' && (this.f2924q & (1 << c3)) != 0) || c3 == '\\';
                if (z) {
                    i17++;
                    if (c3 == '(' || c3 == ')' || c3 == '<' || c3 == '>' || (c3 < IOUtils.f3018f.length && IOUtils.f3018f[c3] == 4)) {
                        int i21 = i16 + 4;
                    }
                    if (i18 == -1) {
                        i18 = i20;
                        i19 = i18;
                        c2 = c3;
                    }
                }
            }
            i19 = i20;
            c2 = c3;
        }
        if (i17 > 0) {
            int i22 = i16 + i17;
            if (i22 > this.f2908a.length) {
                mo11398b(i22);
            }
            this.f2909b = i22;
            if (i17 == 1) {
                if (c2 == 8232) {
                    int i23 = i19 + 1;
                    int i24 = i19 + 6;
                    int i25 = (i15 - i19) - 1;
                    char[] cArr3 = this.f2908a;
                    System.arraycopy(cArr3, i23, cArr3, i24, i25);
                    char[] cArr4 = this.f2908a;
                    cArr4[i19] = '\\';
                    cArr4[i23] = 'u';
                    int i26 = i23 + 1;
                    cArr4[i26] = '2';
                    int i27 = i26 + 1;
                    cArr4[i27] = '0';
                    int i28 = i27 + 1;
                    cArr4[i28] = '2';
                    cArr4[i28 + 1] = '8';
                } else if (c2 == 8233) {
                    int i29 = i19 + 1;
                    int i30 = i19 + 6;
                    int i31 = (i15 - i19) - 1;
                    char[] cArr5 = this.f2908a;
                    System.arraycopy(cArr5, i29, cArr5, i30, i31);
                    char[] cArr6 = this.f2908a;
                    cArr6[i19] = '\\';
                    cArr6[i29] = 'u';
                    int i32 = i29 + 1;
                    cArr6[i32] = '2';
                    int i33 = i32 + 1;
                    cArr6[i33] = '0';
                    int i34 = i33 + 1;
                    cArr6[i34] = '2';
                    cArr6[i34 + 1] = '9';
                } else if (c2 == '(' || c2 == ')' || c2 == '<' || c2 == '>') {
                    int i35 = i19 + 1;
                    int i36 = i19 + 6;
                    int i37 = (i15 - i19) - 1;
                    char[] cArr7 = this.f2908a;
                    System.arraycopy(cArr7, i35, cArr7, i36, i37);
                    char[] cArr8 = this.f2908a;
                    cArr8[i19] = '\\';
                    int i38 = i35 + 1;
                    cArr8[i35] = 'u';
                    int i39 = i38 + 1;
                    cArr8[i38] = IOUtils.f3015c[(c2 >>> 12) & 15];
                    int i40 = i39 + 1;
                    this.f2908a[i39] = IOUtils.f3015c[(c2 >>> 8) & 15];
                    int i41 = i40 + 1;
                    this.f2908a[i40] = IOUtils.f3015c[(c2 >>> 4) & 15];
                    this.f2908a[i41] = IOUtils.f3015c[c2 & 15];
                } else if (c2 >= IOUtils.f3018f.length || IOUtils.f3018f[c2] != 4) {
                    int i42 = i19 + 1;
                    int i43 = i19 + 2;
                    int i44 = (i15 - i19) - 1;
                    char[] cArr9 = this.f2908a;
                    System.arraycopy(cArr9, i42, cArr9, i43, i44);
                    char[] cArr10 = this.f2908a;
                    cArr10[i19] = '\\';
                    cArr10[i42] = IOUtils.f3022j[c2];
                } else {
                    int i45 = i19 + 1;
                    int i46 = i19 + 6;
                    int i47 = (i15 - i19) - 1;
                    char[] cArr11 = this.f2908a;
                    System.arraycopy(cArr11, i45, cArr11, i46, i47);
                    char[] cArr12 = this.f2908a;
                    cArr12[i19] = '\\';
                    int i48 = i45 + 1;
                    cArr12[i45] = 'u';
                    int i49 = i48 + 1;
                    cArr12[i48] = IOUtils.f3015c[(c2 >>> 12) & 15];
                    int i50 = i49 + 1;
                    this.f2908a[i49] = IOUtils.f3015c[(c2 >>> 8) & 15];
                    int i51 = i50 + 1;
                    this.f2908a[i50] = IOUtils.f3015c[(c2 >>> 4) & 15];
                    this.f2908a[i51] = IOUtils.f3015c[c2 & 15];
                }
            } else if (i17 > 1) {
                for (int i52 = i18 - i14; i52 < str2.length(); i52++) {
                    char charAt = str4.charAt(i52);
                    if (this.f2923p) {
                        if (charAt == '(' || charAt == ')' || charAt == '<' || charAt == '>') {
                            char[] cArr13 = this.f2908a;
                            int i53 = i3 + 1;
                            cArr13[i3] = '\\';
                            int i54 = i53 + 1;
                            cArr13[i53] = 'u';
                            int i55 = i54 + 1;
                            cArr13[i54] = IOUtils.f3015c[(charAt >>> 12) & 15];
                            int i56 = i55 + 1;
                            this.f2908a[i55] = IOUtils.f3015c[(charAt >>> 8) & 15];
                            int i57 = i56 + 1;
                            this.f2908a[i56] = IOUtils.f3015c[(charAt >>> 4) & 15];
                            int i58 = i57 + 1;
                            this.f2908a[i57] = IOUtils.f3015c[charAt & 15];
                            i3 = i58;
                        }
                        if ((charAt >= IOUtils.f3018f.length && IOUtils.f3018f[charAt] != 0) || (charAt == '/' && mo11391a(SerializerFeature.WriteSlashAsSpecial))) {
                            int i59 = i3 + 1;
                            this.f2908a[i3] = '\\';
                            if (IOUtils.f3018f[charAt] == 4) {
                                char[] cArr14 = this.f2908a;
                                int i60 = i59 + 1;
                                cArr14[i59] = 'u';
                                int i61 = i60 + 1;
                                cArr14[i60] = IOUtils.f3015c[(charAt >>> 12) & 15];
                                int i62 = i61 + 1;
                                this.f2908a[i61] = IOUtils.f3015c[(charAt >>> 8) & 15];
                                int i63 = i62 + 1;
                                this.f2908a[i62] = IOUtils.f3015c[(charAt >>> 4) & 15];
                                i4 = i63 + 1;
                                this.f2908a[i63] = IOUtils.f3015c[charAt & 15];
                            } else {
                                i4 = i59 + 1;
                                this.f2908a[i59] = IOUtils.f3022j[charAt];
                            }
                            i3 = i4;
                        } else if (charAt != 8232 || charAt == 8233) {
                            char[] cArr15 = this.f2908a;
                            int i64 = i3 + 1;
                            cArr15[i3] = '\\';
                            int i65 = i64 + 1;
                            cArr15[i64] = 'u';
                            int i66 = i65 + 1;
                            cArr15[i65] = IOUtils.f3015c[(charAt >>> 12) & 15];
                            int i67 = i66 + 1;
                            this.f2908a[i66] = IOUtils.f3015c[(charAt >>> 8) & 15];
                            int i68 = i67 + 1;
                            this.f2908a[i67] = IOUtils.f3015c[(charAt >>> 4) & 15];
                            int i69 = i68 + 1;
                            this.f2908a[i68] = IOUtils.f3015c[charAt & 15];
                            i3 = i69;
                        } else {
                            int i70 = i3 + 1;
                            this.f2908a[i3] = charAt;
                            i3 = i70;
                        }
                    } else {
                        if (charAt >= IOUtils.f3018f.length) {
                        }
                        if (charAt != 8232) {
                        }
                        char[] cArr152 = this.f2908a;
                        int i642 = i3 + 1;
                        cArr152[i3] = '\\';
                        int i652 = i642 + 1;
                        cArr152[i642] = 'u';
                        int i662 = i652 + 1;
                        cArr152[i652] = IOUtils.f3015c[(charAt >>> 12) & 15];
                        int i672 = i662 + 1;
                        this.f2908a[i662] = IOUtils.f3015c[(charAt >>> 8) & 15];
                        int i682 = i672 + 1;
                        this.f2908a[i672] = IOUtils.f3015c[(charAt >>> 4) & 15];
                        int i692 = i682 + 1;
                        this.f2908a[i682] = IOUtils.f3015c[charAt & 15];
                        i3 = i692;
                    }
                }
            }
        }
        this.f2908a[this.f2909b - 1] = '\"';
    }

    /* renamed from: a */
    public void mo11384a(String str) {
        if (this.f2911d) {
            mo11400b(str);
        } else {
            mo11385a(str, 0);
        }
    }

    /* renamed from: a */
    public void mo11389a(char[] cArr) {
        if (this.f2911d) {
            mo11402b(cArr);
        } else {
            mo11385a(new String(cArr), 0);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo11400b(String str) {
        int i = 0;
        if (str == null) {
            int i2 = this.f2909b + 4;
            if (i2 > this.f2908a.length) {
                mo11398b(i2);
            }
            "null".getChars(0, 4, this.f2908a, this.f2909b);
            this.f2909b = i2;
            return;
        }
        int length = str.length();
        int i3 = this.f2909b + length + 2;
        if (i3 > this.f2908a.length) {
            if (this.f2925u != null) {
                write(39);
                while (i < str.length()) {
                    char charAt = str.charAt(i);
                    if (charAt <= 13 || charAt == '\\' || charAt == '\'' || (charAt == '/' && mo11391a(SerializerFeature.WriteSlashAsSpecial))) {
                        write(92);
                        write((int) IOUtils.f3022j[charAt]);
                    } else {
                        write((int) charAt);
                    }
                    i++;
                }
                write(39);
                return;
            }
            mo11398b(i3);
        }
        int i4 = this.f2909b;
        int i5 = i4 + 1;
        int i6 = i5 + length;
        char[] cArr = this.f2908a;
        cArr[i4] = '\'';
        str.getChars(0, length, cArr, i5);
        this.f2909b = i3;
        int i7 = -1;
        char c = 0;
        for (int i8 = i5; i8 < i6; i8++) {
            char c2 = this.f2908a[i8];
            if (c2 <= 13 || c2 == '\\' || c2 == '\'' || (c2 == '/' && mo11391a(SerializerFeature.WriteSlashAsSpecial))) {
                i++;
                i7 = i8;
                c = c2;
            }
        }
        int i9 = i3 + i;
        if (i9 > this.f2908a.length) {
            mo11398b(i9);
        }
        this.f2909b = i9;
        if (i == 1) {
            char[] cArr2 = this.f2908a;
            int i10 = i7 + 1;
            System.arraycopy(cArr2, i10, cArr2, i7 + 2, (i6 - i7) - 1);
            char[] cArr3 = this.f2908a;
            cArr3[i7] = '\\';
            cArr3[i10] = IOUtils.f3022j[c];
        } else if (i > 1) {
            char[] cArr4 = this.f2908a;
            int i11 = i7 + 1;
            System.arraycopy(cArr4, i11, cArr4, i7 + 2, (i6 - i7) - 1);
            char[] cArr5 = this.f2908a;
            cArr5[i7] = '\\';
            cArr5[i11] = IOUtils.f3022j[c];
            int i12 = i6 + 1;
            for (int i13 = i11 - 2; i13 >= i5; i13--) {
                char c3 = this.f2908a[i13];
                if (c3 <= 13 || c3 == '\\' || c3 == '\'' || (c3 == '/' && mo11391a(SerializerFeature.WriteSlashAsSpecial))) {
                    char[] cArr6 = this.f2908a;
                    int i14 = i13 + 1;
                    System.arraycopy(cArr6, i14, cArr6, i13 + 2, (i12 - i13) - 1);
                    char[] cArr7 = this.f2908a;
                    cArr7[i13] = '\\';
                    cArr7[i14] = IOUtils.f3022j[c3];
                    i12++;
                }
            }
        }
        this.f2908a[this.f2909b - 1] = '\'';
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo11402b(char[] cArr) {
        int i = 0;
        if (cArr == null) {
            int i2 = this.f2909b + 4;
            if (i2 > this.f2908a.length) {
                mo11398b(i2);
            }
            "null".getChars(0, 4, this.f2908a, this.f2909b);
            this.f2909b = i2;
            return;
        }
        int length = cArr.length;
        int i3 = this.f2909b + length + 2;
        if (i3 > this.f2908a.length) {
            if (this.f2925u != null) {
                write(39);
                while (i < cArr.length) {
                    char c = cArr[i];
                    if (c <= 13 || c == '\\' || c == '\'' || (c == '/' && mo11391a(SerializerFeature.WriteSlashAsSpecial))) {
                        write(92);
                        write((int) IOUtils.f3022j[c]);
                    } else {
                        write((int) c);
                    }
                    i++;
                }
                write(39);
                return;
            }
            mo11398b(i3);
        }
        int i4 = this.f2909b;
        int i5 = i4 + 1;
        int i6 = length + i5;
        char[] cArr2 = this.f2908a;
        cArr2[i4] = '\'';
        System.arraycopy(cArr, 0, cArr2, i5, cArr.length);
        this.f2909b = i3;
        int i7 = -1;
        char c2 = 0;
        for (int i8 = i5; i8 < i6; i8++) {
            char c3 = this.f2908a[i8];
            if (c3 <= 13 || c3 == '\\' || c3 == '\'' || (c3 == '/' && mo11391a(SerializerFeature.WriteSlashAsSpecial))) {
                i++;
                i7 = i8;
                c2 = c3;
            }
        }
        int i9 = i3 + i;
        if (i9 > this.f2908a.length) {
            mo11398b(i9);
        }
        this.f2909b = i9;
        if (i == 1) {
            char[] cArr3 = this.f2908a;
            int i10 = i7 + 1;
            System.arraycopy(cArr3, i10, cArr3, i7 + 2, (i6 - i7) - 1);
            char[] cArr4 = this.f2908a;
            cArr4[i7] = '\\';
            cArr4[i10] = IOUtils.f3022j[c2];
        } else if (i > 1) {
            char[] cArr5 = this.f2908a;
            int i11 = i7 + 1;
            System.arraycopy(cArr5, i11, cArr5, i7 + 2, (i6 - i7) - 1);
            char[] cArr6 = this.f2908a;
            cArr6[i7] = '\\';
            cArr6[i11] = IOUtils.f3022j[c2];
            int i12 = i6 + 1;
            for (int i13 = i11 - 2; i13 >= i5; i13--) {
                char c4 = this.f2908a[i13];
                if (c4 <= 13 || c4 == '\\' || c4 == '\'' || (c4 == '/' && mo11391a(SerializerFeature.WriteSlashAsSpecial))) {
                    char[] cArr7 = this.f2908a;
                    int i14 = i13 + 1;
                    System.arraycopy(cArr7, i14, cArr7, i13 + 2, (i12 - i13) - 1);
                    char[] cArr8 = this.f2908a;
                    cArr8[i13] = '\\';
                    cArr8[i14] = IOUtils.f3022j[c4];
                    i12++;
                }
            }
        }
        this.f2908a[this.f2909b - 1] = '\'';
    }

    /* renamed from: c */
    public void mo11404c(String str) {
        mo11386a(str, false);
    }

    /* renamed from: a */
    public void mo11386a(String str, boolean z) {
        if (str == null) {
            write("null:");
            return;
        }
        if (this.f2911d) {
            if (this.f2912e) {
                mo11400b(str);
                write(58);
            } else {
                m3056d(str);
            }
        } else if (this.f2912e) {
            mo11385a(str, ':');
        } else {
            boolean z2 = str.length() == 0;
            int i = 0;
            while (true) {
                if (i >= str.length()) {
                    break;
                }
                char charAt = str.charAt(i);
                boolean z3 = (charAt < '@' && (this.f2924q & (1 << charAt)) != 0) || charAt == '\\';
                if (z3) {
                    z2 = true;
                    break;
                }
                i++;
            }
            if (z2) {
                mo11385a(str, ':');
            } else {
                write(str);
                write(58);
            }
        }
    }

    /* renamed from: d */
    private void m3056d(String str) {
        int i;
        String str2 = str;
        byte[] bArr = IOUtils.f3019g;
        int length = str.length();
        boolean z = true;
        int i2 = this.f2909b + length + 1;
        int i3 = 0;
        if (i2 > this.f2908a.length) {
            if (this.f2925u == null) {
                mo11398b(i2);
            } else if (length == 0) {
                write(39);
                write(39);
                write(58);
                return;
            } else {
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        z = false;
                        break;
                    }
                    char charAt = str2.charAt(i4);
                    if (charAt < bArr.length && bArr[charAt] != 0) {
                        break;
                    }
                    i4++;
                }
                if (z) {
                    write(39);
                }
                while (i3 < length) {
                    char charAt2 = str2.charAt(i3);
                    if (charAt2 >= bArr.length || bArr[charAt2] == 0) {
                        write((int) charAt2);
                    } else {
                        write(92);
                        write((int) IOUtils.f3022j[charAt2]);
                    }
                    i3++;
                }
                if (z) {
                    write(39);
                }
                write(58);
                return;
            }
        }
        if (length == 0) {
            int i5 = this.f2909b;
            if (i5 + 3 > this.f2908a.length) {
                mo11398b(i5 + 3);
            }
            char[] cArr = this.f2908a;
            int i6 = this.f2909b;
            this.f2909b = i6 + 1;
            cArr[i6] = '\'';
            int i7 = this.f2909b;
            this.f2909b = i7 + 1;
            cArr[i7] = '\'';
            int i8 = this.f2909b;
            this.f2909b = i8 + 1;
            cArr[i8] = ':';
            return;
        }
        int i9 = this.f2909b;
        int i10 = i9 + length;
        str2.getChars(0, length, this.f2908a, i9);
        this.f2909b = i2;
        int i11 = i9;
        boolean z2 = false;
        while (i11 < i10) {
            char[] cArr2 = this.f2908a;
            char c = cArr2[i11];
            if (c >= bArr.length || bArr[c] == 0) {
                i = i11;
            } else if (!z2) {
                i2 += 3;
                if (i2 > cArr2.length) {
                    mo11398b(i2);
                }
                this.f2909b = i2;
                char[] cArr3 = this.f2908a;
                int i12 = i11 + 1;
                System.arraycopy(cArr3, i12, cArr3, i11 + 3, (i10 - i11) - 1);
                char[] cArr4 = this.f2908a;
                System.arraycopy(cArr4, i3, cArr4, 1, i11);
                char[] cArr5 = this.f2908a;
                cArr5[i9] = '\'';
                cArr5[i12] = '\\';
                int i13 = i12 + 1;
                cArr5[i13] = IOUtils.f3022j[c];
                i10 += 2;
                this.f2908a[this.f2909b - 2] = '\'';
                i = i13;
                z2 = true;
            } else {
                i2++;
                if (i2 > cArr2.length) {
                    mo11398b(i2);
                }
                this.f2909b = i2;
                char[] cArr6 = this.f2908a;
                i = i11 + 1;
                System.arraycopy(cArr6, i, cArr6, i11 + 2, i10 - i11);
                char[] cArr7 = this.f2908a;
                cArr7[i11] = '\\';
                cArr7[i] = IOUtils.f3022j[c];
                i10++;
            }
            i11 = i + 1;
            i3 = 0;
        }
        this.f2908a[i2 - 1] = ':';
    }

    public void flush() {
        Writer writer = this.f2925u;
        if (writer != null) {
            try {
                writer.write(this.f2908a, 0, this.f2909b);
                this.f2925u.flush();
                this.f2909b = 0;
            } catch (IOException e) {
                throw new JSONException(e.getMessage(), e);
            }
        }
    }
}
