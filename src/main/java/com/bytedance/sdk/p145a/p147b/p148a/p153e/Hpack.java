package com.bytedance.sdk.p145a.p147b.p148a.p153e;

import com.bytedance.sdk.p145a.p146a.Buffer;
import com.bytedance.sdk.p145a.p146a.BufferedSource;
import com.bytedance.sdk.p145a.p146a.ByteString;
import com.bytedance.sdk.p145a.p146a.Okio;
import com.bytedance.sdk.p145a.p146a.Source;
import com.bytedance.sdk.p145a.p147b.p148a.C1876c;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.bytedance.sdk.a.b.a.e.d */
final class Hpack {
    /* renamed from: a */
    static final Header[] f5490a;
    /* renamed from: b */
    static final Map<ByteString, Integer> f5491b = m7059a();

    /* compiled from: Hpack */
    /* renamed from: com.bytedance.sdk.a.b.a.e.d$a */
    static final class C1888a {
        /* renamed from: a */
        Header[] f5492a;
        /* renamed from: b */
        int f5493b;
        /* renamed from: c */
        int f5494c;
        /* renamed from: d */
        int f5495d;
        /* renamed from: e */
        private final List<Header> f5496e;
        /* renamed from: f */
        private final BufferedSource f5497f;
        /* renamed from: g */
        private final int f5498g;
        /* renamed from: h */
        private int f5499h;

        C1888a(int i, Source sVar) {
            this(i, i, sVar);
        }

        C1888a(int i, int i2, Source sVar) {
            this.f5496e = new ArrayList();
            this.f5492a = new Header[8];
            this.f5493b = this.f5492a.length - 1;
            this.f5494c = 0;
            this.f5495d = 0;
            this.f5498g = i;
            this.f5499h = i2;
            this.f5497f = Okio.m6747a(sVar);
        }

        /* renamed from: d */
        private void m7064d() {
            int i = this.f5499h;
            int i2 = this.f5495d;
            if (i >= i2) {
                return;
            }
            if (i == 0) {
                m7066e();
            } else {
                m7060a(i2 - i);
            }
        }

        /* renamed from: e */
        private void m7066e() {
            Arrays.fill(this.f5492a, null);
            this.f5493b = this.f5492a.length - 1;
            this.f5494c = 0;
            this.f5495d = 0;
        }

        /* renamed from: a */
        private int m7060a(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f5492a.length;
                while (true) {
                    length--;
                    if (length < this.f5493b || i <= 0) {
                        Header[] cVarArr = this.f5492a;
                        int i3 = this.f5493b;
                        System.arraycopy(cVarArr, i3 + 1, cVarArr, i3 + 1 + i2, this.f5494c);
                        this.f5493b += i2;
                    } else {
                        i -= this.f5492a[length].f5489i;
                        this.f5495d -= this.f5492a[length].f5489i;
                        this.f5494c--;
                        i2++;
                    }
                }
                Header[] cVarArr2 = this.f5492a;
                int i32 = this.f5493b;
                System.arraycopy(cVarArr2, i32 + 1, cVarArr2, i32 + 1 + i2, this.f5494c);
                this.f5493b += i2;
            }
            return i2;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo13762a() throws IOException {
            while (!this.f5497f.mo13546e()) {
                byte h = this.f5497f.mo13554h() & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                if (h == Byte.MIN_VALUE) {
                    throw new IOException("index == 0");
                } else if ((h & Byte.MIN_VALUE) == Byte.MIN_VALUE) {
                    m7062b(mo13761a((int) h, 127) - 1);
                } else if (h == 64) {
                    m7070g();
                } else if ((h & 64) == 64) {
                    m7067e(mo13761a((int) h, 63) - 1);
                } else if ((h & 32) == 32) {
                    this.f5499h = mo13761a((int) h, 31);
                    int i = this.f5499h;
                    if (i < 0 || i > this.f5498g) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Invalid dynamic table size update ");
                        sb.append(this.f5499h);
                        throw new IOException(sb.toString());
                    }
                    m7064d();
                } else if (h == 16 || h == 0) {
                    m7069f();
                } else {
                    m7065d(mo13761a((int) h, 15) - 1);
                }
            }
        }

        /* renamed from: b */
        public List<Header> mo13763b() {
            ArrayList arrayList = new ArrayList(this.f5496e);
            this.f5496e.clear();
            return arrayList;
        }

        /* renamed from: b */
        private void m7062b(int i) throws IOException {
            if (m7071g(i)) {
                this.f5496e.add(Hpack.f5490a[i]);
                return;
            }
            int c = m7063c(i - Hpack.f5490a.length);
            if (c >= 0) {
                Header[] cVarArr = this.f5492a;
                if (c <= cVarArr.length - 1) {
                    this.f5496e.add(cVarArr[c]);
                    return;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Header index too large ");
            sb.append(i + 1);
            throw new IOException(sb.toString());
        }

        /* renamed from: c */
        private int m7063c(int i) {
            return this.f5493b + 1 + i;
        }

        /* renamed from: d */
        private void m7065d(int i) throws IOException {
            this.f5496e.add(new Header(m7068f(i), mo13764c()));
        }

        /* renamed from: f */
        private void m7069f() throws IOException {
            this.f5496e.add(new Header(Hpack.m7058a(mo13764c()), mo13764c()));
        }

        /* renamed from: e */
        private void m7067e(int i) throws IOException {
            m7061a(-1, new Header(m7068f(i), mo13764c()));
        }

        /* renamed from: g */
        private void m7070g() throws IOException {
            m7061a(-1, new Header(Hpack.m7058a(mo13764c()), mo13764c()));
        }

        /* renamed from: f */
        private ByteString m7068f(int i) {
            if (m7071g(i)) {
                return Hpack.f5490a[i].f5487g;
            }
            return this.f5492a[m7063c(i - Hpack.f5490a.length)].f5487g;
        }

        /* renamed from: g */
        private boolean m7071g(int i) {
            return i >= 0 && i <= Hpack.f5490a.length - 1;
        }

        /* renamed from: a */
        private void m7061a(int i, Header cVar) {
            this.f5496e.add(cVar);
            int i2 = cVar.f5489i;
            if (i != -1) {
                i2 -= this.f5492a[m7063c(i)].f5489i;
            }
            int i3 = this.f5499h;
            if (i2 > i3) {
                m7066e();
                return;
            }
            int a = m7060a((this.f5495d + i2) - i3);
            if (i == -1) {
                int i4 = this.f5494c + 1;
                Header[] cVarArr = this.f5492a;
                if (i4 > cVarArr.length) {
                    Header[] cVarArr2 = new Header[(cVarArr.length * 2)];
                    System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                    this.f5493b = this.f5492a.length - 1;
                    this.f5492a = cVarArr2;
                }
                int i5 = this.f5493b;
                this.f5493b = i5 - 1;
                this.f5492a[i5] = cVar;
                this.f5494c++;
            } else {
                this.f5492a[i + m7063c(i) + a] = cVar;
            }
            this.f5495d += i2;
        }

        /* renamed from: h */
        private int m7072h() throws IOException {
            return this.f5497f.mo13554h() & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public int mo13761a(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int h = m7072h();
                if ((h & 128) == 0) {
                    return i2 + (h << i4);
                }
                i2 += (h & 127) << i4;
                i4 += 7;
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public ByteString mo13764c() throws IOException {
            int h = m7072h();
            boolean z = (h & 128) == 128;
            int a = mo13761a(h, 127);
            if (z) {
                return ByteString.m6703a(Huffman.m7226a().mo13847a(this.f5497f.mo13553g((long) a)));
            }
            return this.f5497f.mo13539c((long) a);
        }
    }

    /* compiled from: Hpack */
    /* renamed from: com.bytedance.sdk.a.b.a.e.d$b */
    static final class C1889b {
        /* renamed from: a */
        int f5500a;
        /* renamed from: b */
        int f5501b;
        /* renamed from: c */
        Header[] f5502c;
        /* renamed from: d */
        int f5503d;
        /* renamed from: e */
        int f5504e;
        /* renamed from: f */
        int f5505f;
        /* renamed from: g */
        private final Buffer f5506g;
        /* renamed from: h */
        private final boolean f5507h;
        /* renamed from: i */
        private int f5508i;
        /* renamed from: j */
        private boolean f5509j;

        C1889b(Buffer cVar) {
            this(4096, true, cVar);
        }

        C1889b(int i, boolean z, Buffer cVar) {
            this.f5508i = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            this.f5502c = new Header[8];
            this.f5503d = this.f5502c.length - 1;
            this.f5504e = 0;
            this.f5505f = 0;
            this.f5500a = i;
            this.f5501b = i;
            this.f5507h = z;
            this.f5506g = cVar;
        }

        /* renamed from: a */
        private void m7077a() {
            Arrays.fill(this.f5502c, null);
            this.f5503d = this.f5502c.length - 1;
            this.f5504e = 0;
            this.f5505f = 0;
        }

        /* renamed from: b */
        private int m7079b(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f5502c.length;
                while (true) {
                    length--;
                    if (length < this.f5503d || i <= 0) {
                        Header[] cVarArr = this.f5502c;
                        int i3 = this.f5503d;
                        System.arraycopy(cVarArr, i3 + 1, cVarArr, i3 + 1 + i2, this.f5504e);
                        Header[] cVarArr2 = this.f5502c;
                        int i4 = this.f5503d;
                        Arrays.fill(cVarArr2, i4 + 1, i4 + 1 + i2, null);
                        this.f5503d += i2;
                    } else {
                        i -= this.f5502c[length].f5489i;
                        this.f5505f -= this.f5502c[length].f5489i;
                        this.f5504e--;
                        i2++;
                    }
                }
                Header[] cVarArr3 = this.f5502c;
                int i32 = this.f5503d;
                System.arraycopy(cVarArr3, i32 + 1, cVarArr3, i32 + 1 + i2, this.f5504e);
                Header[] cVarArr22 = this.f5502c;
                int i42 = this.f5503d;
                Arrays.fill(cVarArr22, i42 + 1, i42 + 1 + i2, null);
                this.f5503d += i2;
            }
            return i2;
        }

        /* renamed from: a */
        private void m7078a(Header cVar) {
            int i = cVar.f5489i;
            int i2 = this.f5501b;
            if (i > i2) {
                m7077a();
                return;
            }
            m7079b((this.f5505f + i) - i2);
            int i3 = this.f5504e + 1;
            Header[] cVarArr = this.f5502c;
            if (i3 > cVarArr.length) {
                Header[] cVarArr2 = new Header[(cVarArr.length * 2)];
                System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                this.f5503d = this.f5502c.length - 1;
                this.f5502c = cVarArr2;
            }
            int i4 = this.f5503d;
            this.f5503d = i4 - 1;
            this.f5502c[i4] = cVar;
            this.f5504e++;
            this.f5505f += i;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo13768a(List<Header> list) throws IOException {
            int i;
            int i2;
            int i3;
            if (this.f5509j) {
                int i4 = this.f5508i;
                if (i4 < this.f5501b) {
                    mo13766a(i4, 31, 32);
                }
                this.f5509j = false;
                this.f5508i = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                mo13766a(this.f5501b, 31, 32);
            }
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                Header cVar = (Header) list.get(i5);
                ByteString f = cVar.f5487g.mo13599f();
                ByteString fVar = cVar.f5488h;
                Integer num = (Integer) Hpack.f5491b.get(f);
                if (num != null) {
                    i2 = num.intValue() + 1;
                    if (i2 > 1 && i2 < 8) {
                        if (C1876c.m6965a((Object) Hpack.f5490a[i2 - 1].f5488h, (Object) fVar)) {
                            i = i2;
                        } else if (C1876c.m6965a((Object) Hpack.f5490a[i2].f5488h, (Object) fVar)) {
                            i = i2;
                            i2++;
                        }
                    }
                    i = i2;
                    i2 = -1;
                } else {
                    i2 = -1;
                    i = -1;
                }
                if (i2 == -1) {
                    int i6 = this.f5503d + 1;
                    int length = this.f5502c.length;
                    while (true) {
                        if (i6 >= length) {
                            break;
                        }
                        if (C1876c.m6965a((Object) this.f5502c[i6].f5487g, (Object) f)) {
                            if (C1876c.m6965a((Object) this.f5502c[i6].f5488h, (Object) fVar)) {
                                i2 = Hpack.f5490a.length + (i6 - this.f5503d);
                                break;
                            } else if (i == -1) {
                                i = (i6 - this.f5503d) + Hpack.f5490a.length;
                            }
                        }
                        i6++;
                    }
                }
                if (i2 != -1) {
                    mo13766a(i2, 127, 128);
                } else if (i3 == -1) {
                    this.f5506g.mo13559i(64);
                    mo13767a(f);
                    mo13767a(fVar);
                    m7078a(cVar);
                } else if (!f.mo13591a(Header.f5481a) || Header.f5486f.equals(f)) {
                    mo13766a(i3, 63, 64);
                    mo13767a(fVar);
                    m7078a(cVar);
                } else {
                    mo13766a(i3, 15, 0);
                    mo13767a(fVar);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo13766a(int i, int i2, int i3) {
            if (i < i2) {
                this.f5506g.mo13559i(i | i3);
                return;
            }
            this.f5506g.mo13559i(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.f5506g.mo13559i(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.f5506g.mo13559i(i4);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo13767a(ByteString fVar) throws IOException {
            if (!this.f5507h || Huffman.m7226a().mo13845a(fVar) >= fVar.mo13600g()) {
                mo13766a(fVar.mo13600g(), 127, 0);
                this.f5506g.mo13522a(fVar);
                return;
            }
            Buffer cVar = new Buffer();
            Huffman.m7226a().mo13846a(fVar, cVar);
            ByteString n = cVar.mo13569n();
            mo13766a(n.mo13600g(), 127, 128);
            this.f5506g.mo13522a(n);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo13765a(int i) {
            this.f5500a = i;
            int min = Math.min(i, 16384);
            int i2 = this.f5501b;
            if (i2 != min) {
                if (min < i2) {
                    this.f5508i = Math.min(this.f5508i, min);
                }
                this.f5509j = true;
                this.f5501b = min;
                m7080b();
            }
        }

        /* renamed from: b */
        private void m7080b() {
            int i = this.f5501b;
            int i2 = this.f5505f;
            if (i >= i2) {
                return;
            }
            if (i == 0) {
                m7077a();
            } else {
                m7079b(i2 - i);
            }
        }
    }

    static {
        String str = "";
        f5490a = new Header[]{new Header(Header.f5486f, str), new Header(Header.f5483c, "GET"), new Header(Header.f5483c, "POST"), new Header(Header.f5484d, "/"), new Header(Header.f5484d, "/index.html"), new Header(Header.f5485e, "http"), new Header(Header.f5485e, "https"), new Header(Header.f5482b, "200"), new Header(Header.f5482b, "204"), new Header(Header.f5482b, "206"), new Header(Header.f5482b, "304"), new Header(Header.f5482b, "400"), new Header(Header.f5482b, "404"), new Header(Header.f5482b, "500"), new Header("accept-charset", str), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", str), new Header("accept-ranges", str), new Header("accept", str), new Header("access-control-allow-origin", str), new Header("age", str), new Header("allow", str), new Header("authorization", str), new Header("cache-control", str), new Header("content-disposition", str), new Header("content-encoding", str), new Header("content-language", str), new Header("content-length", str), new Header("content-location", str), new Header("content-range", str), new Header("content-type", str), new Header("cookie", str), new Header(MessageKey.MSG_DATE, str), new Header("etag", str), new Header("expect", str), new Header("expires", str), new Header("from", str), new Header("host", str), new Header("if-match", str), new Header("if-modified-since", str), new Header("if-none-match", str), new Header("if-range", str), new Header("if-unmodified-since", str), new Header("last-modified", str), new Header("link", str), new Header("location", str), new Header("max-forwards", str), new Header("proxy-authenticate", str), new Header("proxy-authorization", str), new Header("range", str), new Header("referer", str), new Header("refresh", str), new Header("retry-after", str), new Header("server", str), new Header("set-cookie", str), new Header("strict-transport-security", str), new Header("transfer-encoding", str), new Header("user-agent", str), new Header("vary", str), new Header("via", str), new Header("www-authenticate", str)};
    }

    /* renamed from: a */
    private static Map<ByteString, Integer> m7059a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f5490a.length);
        int i = 0;
        while (true) {
            Header[] cVarArr = f5490a;
            if (i >= cVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(cVarArr[i].f5487g)) {
                linkedHashMap.put(f5490a[i].f5487g, Integer.valueOf(i));
            }
            i++;
        }
    }

    /* renamed from: a */
    static ByteString m7058a(ByteString fVar) throws IOException {
        int g = fVar.mo13600g();
        int i = 0;
        while (i < g) {
            byte a = fVar.mo13585a(i);
            if (a < 65 || a > 90) {
                i++;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("PROTOCOL_ERROR response malformed: mixed case name: ");
                sb.append(fVar.mo13587a());
                throw new IOException(sb.toString());
            }
        }
        return fVar;
    }
}
