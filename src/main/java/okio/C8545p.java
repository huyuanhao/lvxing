package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* compiled from: SegmentedByteString */
/* renamed from: okio.p */
final class C8545p extends ByteString {
    final transient int[] directory;
    final transient byte[][] segments;

    C8545p(C8525c cVar, int i) {
        super(null);
        C8550t.m36938a(cVar.f29018b, 0, (long) i);
        int i2 = 0;
        C8543n nVar = cVar.f29017a;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (nVar.f29048c != nVar.f29047b) {
                i3 += nVar.f29048c - nVar.f29047b;
                i4++;
                nVar = nVar.f29051f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.segments = new byte[i4][];
        this.directory = new int[(i4 * 2)];
        C8543n nVar2 = cVar.f29017a;
        int i5 = 0;
        while (i2 < i) {
            this.segments[i5] = nVar2.f29046a;
            i2 += nVar2.f29048c - nVar2.f29047b;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.directory;
            iArr[i5] = i2;
            iArr[this.segments.length + i5] = nVar2.f29047b;
            nVar2.f29049d = true;
            i5++;
            nVar2 = nVar2.f29051f;
        }
    }

    public String utf8() {
        return m36920a().utf8();
    }

    public String string(Charset charset) {
        return m36920a().string(charset);
    }

    public String base64() {
        return m36920a().base64();
    }

    public String hex() {
        return m36920a().hex();
    }

    public ByteString toAsciiLowercase() {
        return m36920a().toAsciiLowercase();
    }

    public ByteString toAsciiUppercase() {
        return m36920a().toAsciiUppercase();
    }

    public ByteString md5() {
        return m36920a().md5();
    }

    public ByteString sha1() {
        return m36920a().sha1();
    }

    public ByteString sha256() {
        return m36920a().sha256();
    }

    public ByteString hmacSha1(ByteString byteString) {
        return m36920a().hmacSha1(byteString);
    }

    public ByteString hmacSha256(ByteString byteString) {
        return m36920a().hmacSha256(byteString);
    }

    public String base64Url() {
        return m36920a().base64Url();
    }

    public ByteString substring(int i) {
        return m36920a().substring(i);
    }

    public ByteString substring(int i, int i2) {
        return m36920a().substring(i, i2);
    }

    public byte getByte(int i) {
        int i2;
        C8550t.m36938a((long) this.directory[this.segments.length - 1], (long) i, 1);
        int a = m36919a(i);
        if (a == 0) {
            i2 = 0;
        } else {
            i2 = this.directory[a - 1];
        }
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        return bArr[a][(i - i2) + iArr[bArr.length + a]];
    }

    /* renamed from: a */
    private int m36919a(int i) {
        int binarySearch = Arrays.binarySearch(this.directory, 0, this.segments.length, i + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    public int size() {
        return this.directory[this.segments.length - 1];
    }

    public byte[] toByteArray() {
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.directory;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.segments[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    public void write(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            int length = this.segments.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int[] iArr = this.directory;
                int i3 = iArr[length + i];
                int i4 = iArr[i];
                outputStream.write(this.segments[i], i3, i4 - i2);
                i++;
                i2 = i4;
            }
            return;
        }
        throw new IllegalArgumentException("out == null");
    }

    /* access modifiers changed from: 0000 */
    public void write(C8525c cVar) {
        int length = this.segments.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.directory;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            C8543n nVar = new C8543n(this.segments[i], i3, (i3 + i4) - i2, true, false);
            if (cVar.f29017a == null) {
                nVar.f29052g = nVar;
                nVar.f29051f = nVar;
                cVar.f29017a = nVar;
            } else {
                cVar.f29017a.f29052g.mo40830a(nVar);
            }
            i++;
            i2 = i4;
        }
        cVar.f29018b += (long) i2;
    }

    public boolean rangeEquals(int i, ByteString byteString, int i2, int i3) {
        int i4;
        if (i < 0 || i > size() - i3) {
            return false;
        }
        int a = m36919a(i);
        while (i3 > 0) {
            if (a == 0) {
                i4 = 0;
            } else {
                i4 = this.directory[a - 1];
            }
            int min = Math.min(i3, ((this.directory[a] - i4) + i4) - i);
            int[] iArr = this.directory;
            byte[][] bArr = this.segments;
            if (!byteString.rangeEquals(i2, bArr[a], (i - i4) + iArr[bArr.length + a], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            a++;
        }
        return true;
    }

    public boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        int i4;
        if (i < 0 || i > size() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int a = m36919a(i);
        while (i3 > 0) {
            if (a == 0) {
                i4 = 0;
            } else {
                i4 = this.directory[a - 1];
            }
            int min = Math.min(i3, ((this.directory[a] - i4) + i4) - i);
            int[] iArr = this.directory;
            byte[][] bArr2 = this.segments;
            if (!C8550t.m36940a(bArr2[a], (i - i4) + iArr[bArr2.length + a], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            a++;
        }
        return true;
    }

    public int indexOf(byte[] bArr, int i) {
        return m36920a().indexOf(bArr, i);
    }

    public int lastIndexOf(byte[] bArr, int i) {
        return m36920a().lastIndexOf(bArr, i);
    }

    /* renamed from: a */
    private ByteString m36920a() {
        return new ByteString(toByteArray());
    }

    /* access modifiers changed from: 0000 */
    public byte[] internalArray() {
        return toByteArray();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
            if (rangeEquals(0, r5, 0, size()) != false) goto L_0x0021;
     */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = 1
        if (r5 != r4) goto L_0x0004
        return r0
    L_0x0004:
        boolean r1 = r5 instanceof okio.ByteString
        r2 = 0
        if (r1 == 0) goto L_0x0020
        okio.ByteString r5 = (okio.ByteString) r5
        int r1 = r5.size()
        int r3 = r4.size()
        if (r1 != r3) goto L_0x0020
        int r1 = r4.size()
        boolean r5 = r4.rangeEquals(r2, r5, r2, r1)
        if (r5 == 0) goto L_0x0020
        goto L_0x0021
    L_0x0020:
        r0 = 0
    L_0x0021:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.C8545p.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int length = this.segments.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.segments[i2];
            int[] iArr = this.directory;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.hashCode = i3;
        return i3;
    }

    public String toString() {
        return m36920a().toString();
    }

    private Object writeReplace() {
        return m36920a();
    }
}
