package okhttp3.internal.http2;

import com.tencent.android.tpush.common.MessageKey;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.internal.C8417c;
import okio.ByteString;
import okio.C8525c;
import okio.C8529e;
import okio.C8535k;
import okio.C8547r;

/* compiled from: Hpack */
/* renamed from: okhttp3.internal.http2.b */
final class C8454b {
    /* renamed from: a */
    static final C8453a[] f28661a;
    /* renamed from: b */
    static final Map<ByteString, Integer> f28662b = m36225a();

    /* compiled from: Hpack */
    /* renamed from: okhttp3.internal.http2.b$a */
    static final class C8455a {
        /* renamed from: a */
        C8453a[] f28663a;
        /* renamed from: b */
        int f28664b;
        /* renamed from: c */
        int f28665c;
        /* renamed from: d */
        int f28666d;
        /* renamed from: e */
        private final List<C8453a> f28667e;
        /* renamed from: f */
        private final C8529e f28668f;
        /* renamed from: g */
        private final int f28669g;
        /* renamed from: h */
        private int f28670h;

        C8455a(int i, C8547r rVar) {
            this(i, i, rVar);
        }

        C8455a(int i, int i2, C8547r rVar) {
            this.f28667e = new ArrayList();
            this.f28663a = new C8453a[8];
            this.f28664b = this.f28663a.length - 1;
            this.f28665c = 0;
            this.f28666d = 0;
            this.f28669g = i;
            this.f28670h = i2;
            this.f28668f = C8535k.m36849a(rVar);
        }

        /* renamed from: d */
        private void m36231d() {
            int i = this.f28670h;
            int i2 = this.f28666d;
            if (i >= i2) {
                return;
            }
            if (i == 0) {
                m36233e();
            } else {
                m36227a(i2 - i);
            }
        }

        /* renamed from: e */
        private void m36233e() {
            Arrays.fill(this.f28663a, null);
            this.f28664b = this.f28663a.length - 1;
            this.f28665c = 0;
            this.f28666d = 0;
        }

        /* renamed from: a */
        private int m36227a(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f28663a.length;
                while (true) {
                    length--;
                    if (length < this.f28664b || i <= 0) {
                        C8453a[] aVarArr = this.f28663a;
                        int i3 = this.f28664b;
                        System.arraycopy(aVarArr, i3 + 1, aVarArr, i3 + 1 + i2, this.f28665c);
                        this.f28664b += i2;
                    } else {
                        i -= this.f28663a[length].f28660i;
                        this.f28666d -= this.f28663a[length].f28660i;
                        this.f28665c--;
                        i2++;
                    }
                }
                C8453a[] aVarArr2 = this.f28663a;
                int i32 = this.f28664b;
                System.arraycopy(aVarArr2, i32 + 1, aVarArr2, i32 + 1 + i2, this.f28665c);
                this.f28664b += i2;
            }
            return i2;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo40358a() throws IOException {
            while (!this.f28668f.mo40755f()) {
                byte i = this.f28668f.mo40763i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                if (i == Byte.MIN_VALUE) {
                    throw new IOException("index == 0");
                } else if ((i & Byte.MIN_VALUE) == Byte.MIN_VALUE) {
                    m36229b(mo40357a((int) i, 127) - 1);
                } else if (i == 64) {
                    m36237g();
                } else if ((i & 64) == 64) {
                    m36234e(mo40357a((int) i, 63) - 1);
                } else if ((i & 32) == 32) {
                    this.f28670h = mo40357a((int) i, 31);
                    int i2 = this.f28670h;
                    if (i2 < 0 || i2 > this.f28669g) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Invalid dynamic table size update ");
                        sb.append(this.f28670h);
                        throw new IOException(sb.toString());
                    }
                    m36231d();
                } else if (i == 16 || i == 0) {
                    m36236f();
                } else {
                    m36232d(mo40357a((int) i, 15) - 1);
                }
            }
        }

        /* renamed from: b */
        public List<C8453a> mo40359b() {
            ArrayList arrayList = new ArrayList(this.f28667e);
            this.f28667e.clear();
            return arrayList;
        }

        /* renamed from: b */
        private void m36229b(int i) throws IOException {
            if (m36238g(i)) {
                this.f28667e.add(C8454b.f28661a[i]);
                return;
            }
            int c = m36230c(i - C8454b.f28661a.length);
            if (c >= 0) {
                C8453a[] aVarArr = this.f28663a;
                if (c < aVarArr.length) {
                    this.f28667e.add(aVarArr[c]);
                    return;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Header index too large ");
            sb.append(i + 1);
            throw new IOException(sb.toString());
        }

        /* renamed from: c */
        private int m36230c(int i) {
            return this.f28664b + 1 + i;
        }

        /* renamed from: d */
        private void m36232d(int i) throws IOException {
            this.f28667e.add(new C8453a(m36235f(i), mo40360c()));
        }

        /* renamed from: f */
        private void m36236f() throws IOException {
            this.f28667e.add(new C8453a(C8454b.m36226a(mo40360c()), mo40360c()));
        }

        /* renamed from: e */
        private void m36234e(int i) throws IOException {
            m36228a(-1, new C8453a(m36235f(i), mo40360c()));
        }

        /* renamed from: g */
        private void m36237g() throws IOException {
            m36228a(-1, new C8453a(C8454b.m36226a(mo40360c()), mo40360c()));
        }

        /* renamed from: f */
        private ByteString m36235f(int i) throws IOException {
            if (m36238g(i)) {
                return C8454b.f28661a[i].f28658g;
            }
            int c = m36230c(i - C8454b.f28661a.length);
            if (c >= 0) {
                C8453a[] aVarArr = this.f28663a;
                if (c < aVarArr.length) {
                    return aVarArr[c].f28658g;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Header index too large ");
            sb.append(i + 1);
            throw new IOException(sb.toString());
        }

        /* renamed from: g */
        private boolean m36238g(int i) {
            return i >= 0 && i <= C8454b.f28661a.length - 1;
        }

        /* renamed from: a */
        private void m36228a(int i, C8453a aVar) {
            this.f28667e.add(aVar);
            int i2 = aVar.f28660i;
            if (i != -1) {
                i2 -= this.f28663a[m36230c(i)].f28660i;
            }
            int i3 = this.f28670h;
            if (i2 > i3) {
                m36233e();
                return;
            }
            int a = m36227a((this.f28666d + i2) - i3);
            if (i == -1) {
                int i4 = this.f28665c + 1;
                C8453a[] aVarArr = this.f28663a;
                if (i4 > aVarArr.length) {
                    C8453a[] aVarArr2 = new C8453a[(aVarArr.length * 2)];
                    System.arraycopy(aVarArr, 0, aVarArr2, aVarArr.length, aVarArr.length);
                    this.f28664b = this.f28663a.length - 1;
                    this.f28663a = aVarArr2;
                }
                int i5 = this.f28664b;
                this.f28664b = i5 - 1;
                this.f28663a[i5] = aVar;
                this.f28665c++;
            } else {
                this.f28663a[i + m36230c(i) + a] = aVar;
            }
            this.f28666d += i2;
        }

        /* renamed from: h */
        private int m36239h() throws IOException {
            return this.f28668f.mo40763i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public int mo40357a(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int h = m36239h();
                if ((h & 128) == 0) {
                    return i2 + (h << i4);
                }
                i2 += (h & 127) << i4;
                i4 += 7;
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public ByteString mo40360c() throws IOException {
            int h = m36239h();
            boolean z = (h & 128) == 128;
            int a = mo40357a(h, 127);
            if (z) {
                return ByteString.m36697of(C8483i.m36399a().mo40444a(this.f28668f.mo40758g((long) a)));
            }
            return this.f28668f.mo40740c((long) a);
        }
    }

    /* compiled from: Hpack */
    /* renamed from: okhttp3.internal.http2.b$b */
    static final class C8456b {
        /* renamed from: a */
        int f28671a;
        /* renamed from: b */
        int f28672b;
        /* renamed from: c */
        C8453a[] f28673c;
        /* renamed from: d */
        int f28674d;
        /* renamed from: e */
        int f28675e;
        /* renamed from: f */
        int f28676f;
        /* renamed from: g */
        private final C8525c f28677g;
        /* renamed from: h */
        private final boolean f28678h;
        /* renamed from: i */
        private int f28679i;
        /* renamed from: j */
        private boolean f28680j;

        C8456b(C8525c cVar) {
            this(4096, true, cVar);
        }

        C8456b(int i, boolean z, C8525c cVar) {
            this.f28679i = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            this.f28673c = new C8453a[8];
            this.f28674d = this.f28673c.length - 1;
            this.f28675e = 0;
            this.f28676f = 0;
            this.f28671a = i;
            this.f28672b = i;
            this.f28678h = z;
            this.f28677g = cVar;
        }

        /* renamed from: a */
        private void m36244a() {
            Arrays.fill(this.f28673c, null);
            this.f28674d = this.f28673c.length - 1;
            this.f28675e = 0;
            this.f28676f = 0;
        }

        /* renamed from: b */
        private int m36246b(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f28673c.length;
                while (true) {
                    length--;
                    if (length < this.f28674d || i <= 0) {
                        C8453a[] aVarArr = this.f28673c;
                        int i3 = this.f28674d;
                        System.arraycopy(aVarArr, i3 + 1, aVarArr, i3 + 1 + i2, this.f28675e);
                        C8453a[] aVarArr2 = this.f28673c;
                        int i4 = this.f28674d;
                        Arrays.fill(aVarArr2, i4 + 1, i4 + 1 + i2, null);
                        this.f28674d += i2;
                    } else {
                        i -= this.f28673c[length].f28660i;
                        this.f28676f -= this.f28673c[length].f28660i;
                        this.f28675e--;
                        i2++;
                    }
                }
                C8453a[] aVarArr3 = this.f28673c;
                int i32 = this.f28674d;
                System.arraycopy(aVarArr3, i32 + 1, aVarArr3, i32 + 1 + i2, this.f28675e);
                C8453a[] aVarArr22 = this.f28673c;
                int i42 = this.f28674d;
                Arrays.fill(aVarArr22, i42 + 1, i42 + 1 + i2, null);
                this.f28674d += i2;
            }
            return i2;
        }

        /* renamed from: a */
        private void m36245a(C8453a aVar) {
            int i = aVar.f28660i;
            int i2 = this.f28672b;
            if (i > i2) {
                m36244a();
                return;
            }
            m36246b((this.f28676f + i) - i2);
            int i3 = this.f28675e + 1;
            C8453a[] aVarArr = this.f28673c;
            if (i3 > aVarArr.length) {
                C8453a[] aVarArr2 = new C8453a[(aVarArr.length * 2)];
                System.arraycopy(aVarArr, 0, aVarArr2, aVarArr.length, aVarArr.length);
                this.f28674d = this.f28673c.length - 1;
                this.f28673c = aVarArr2;
            }
            int i4 = this.f28674d;
            this.f28674d = i4 - 1;
            this.f28673c[i4] = aVar;
            this.f28675e++;
            this.f28676f += i;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo40363a(List<C8453a> list) throws IOException {
            int i;
            int i2;
            int i3;
            if (this.f28680j) {
                int i4 = this.f28679i;
                if (i4 < this.f28672b) {
                    mo40362a(i4, 31, 32);
                }
                this.f28680j = false;
                this.f28679i = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                mo40362a(this.f28672b, 31, 32);
            }
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                C8453a aVar = (C8453a) list.get(i5);
                ByteString asciiLowercase = aVar.f28658g.toAsciiLowercase();
                ByteString byteString = aVar.f28659h;
                Integer num = (Integer) C8454b.f28662b.get(asciiLowercase);
                if (num != null) {
                    i2 = num.intValue() + 1;
                    if (i2 > 1 && i2 < 8) {
                        if (C8417c.m36044a((Object) C8454b.f28661a[i2 - 1].f28659h, (Object) byteString)) {
                            i = i2;
                        } else if (C8417c.m36044a((Object) C8454b.f28661a[i2].f28659h, (Object) byteString)) {
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
                    int i6 = this.f28674d + 1;
                    int length = this.f28673c.length;
                    while (true) {
                        if (i6 >= length) {
                            break;
                        }
                        if (C8417c.m36044a((Object) this.f28673c[i6].f28658g, (Object) asciiLowercase)) {
                            if (C8417c.m36044a((Object) this.f28673c[i6].f28659h, (Object) byteString)) {
                                i2 = C8454b.f28661a.length + (i6 - this.f28674d);
                                break;
                            } else if (i == -1) {
                                i = (i6 - this.f28674d) + C8454b.f28661a.length;
                            }
                        }
                        i6++;
                    }
                }
                if (i2 != -1) {
                    mo40362a(i2, 127, 128);
                } else if (i3 == -1) {
                    this.f28677g.mo40765i(64);
                    mo40364a(asciiLowercase);
                    mo40364a(byteString);
                    m36245a(aVar);
                } else if (!asciiLowercase.startsWith(C8453a.f28652a) || C8453a.f28657f.equals(asciiLowercase)) {
                    mo40362a(i3, 63, 64);
                    mo40364a(byteString);
                    m36245a(aVar);
                } else {
                    mo40362a(i3, 15, 0);
                    mo40364a(byteString);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo40362a(int i, int i2, int i3) {
            if (i < i2) {
                this.f28677g.mo40765i(i | i3);
                return;
            }
            this.f28677g.mo40765i(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.f28677g.mo40765i(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.f28677g.mo40765i(i4);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo40364a(ByteString byteString) throws IOException {
            if (!this.f28678h || C8483i.m36399a().mo40442a(byteString) >= byteString.size()) {
                mo40362a(byteString.size(), 127, 0);
                this.f28677g.mo40739b(byteString);
                return;
            }
            C8525c cVar = new C8525c();
            C8483i.m36399a().mo40443a(byteString, cVar);
            ByteString p = cVar.mo40776p();
            mo40362a(p.size(), 127, 128);
            this.f28677g.mo40739b(p);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo40361a(int i) {
            this.f28671a = i;
            int min = Math.min(i, 16384);
            int i2 = this.f28672b;
            if (i2 != min) {
                if (min < i2) {
                    this.f28679i = Math.min(this.f28679i, min);
                }
                this.f28680j = true;
                this.f28672b = min;
                m36247b();
            }
        }

        /* renamed from: b */
        private void m36247b() {
            int i = this.f28672b;
            int i2 = this.f28676f;
            if (i >= i2) {
                return;
            }
            if (i == 0) {
                m36244a();
            } else {
                m36246b(i2 - i);
            }
        }
    }

    static {
        String str = "";
        f28661a = new C8453a[]{new C8453a(C8453a.f28657f, str), new C8453a(C8453a.f28654c, "GET"), new C8453a(C8453a.f28654c, "POST"), new C8453a(C8453a.f28655d, "/"), new C8453a(C8453a.f28655d, "/index.html"), new C8453a(C8453a.f28656e, "http"), new C8453a(C8453a.f28656e, "https"), new C8453a(C8453a.f28653b, "200"), new C8453a(C8453a.f28653b, "204"), new C8453a(C8453a.f28653b, "206"), new C8453a(C8453a.f28653b, "304"), new C8453a(C8453a.f28653b, "400"), new C8453a(C8453a.f28653b, "404"), new C8453a(C8453a.f28653b, "500"), new C8453a("accept-charset", str), new C8453a("accept-encoding", "gzip, deflate"), new C8453a("accept-language", str), new C8453a("accept-ranges", str), new C8453a("accept", str), new C8453a("access-control-allow-origin", str), new C8453a("age", str), new C8453a("allow", str), new C8453a("authorization", str), new C8453a("cache-control", str), new C8453a("content-disposition", str), new C8453a("content-encoding", str), new C8453a("content-language", str), new C8453a("content-length", str), new C8453a("content-location", str), new C8453a("content-range", str), new C8453a("content-type", str), new C8453a("cookie", str), new C8453a(MessageKey.MSG_DATE, str), new C8453a("etag", str), new C8453a("expect", str), new C8453a("expires", str), new C8453a("from", str), new C8453a("host", str), new C8453a("if-match", str), new C8453a("if-modified-since", str), new C8453a("if-none-match", str), new C8453a("if-range", str), new C8453a("if-unmodified-since", str), new C8453a("last-modified", str), new C8453a("link", str), new C8453a("location", str), new C8453a("max-forwards", str), new C8453a("proxy-authenticate", str), new C8453a("proxy-authorization", str), new C8453a("range", str), new C8453a("referer", str), new C8453a("refresh", str), new C8453a("retry-after", str), new C8453a("server", str), new C8453a("set-cookie", str), new C8453a("strict-transport-security", str), new C8453a("transfer-encoding", str), new C8453a("user-agent", str), new C8453a("vary", str), new C8453a("via", str), new C8453a("www-authenticate", str)};
    }

    /* renamed from: a */
    private static Map<ByteString, Integer> m36225a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f28661a.length);
        int i = 0;
        while (true) {
            C8453a[] aVarArr = f28661a;
            if (i >= aVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(aVarArr[i].f28658g)) {
                linkedHashMap.put(f28661a[i].f28658g, Integer.valueOf(i));
            }
            i++;
        }
    }

    /* renamed from: a */
    static ByteString m36226a(ByteString byteString) throws IOException {
        int size = byteString.size();
        int i = 0;
        while (i < size) {
            byte b = byteString.getByte(i);
            if (b < 65 || b > 90) {
                i++;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("PROTOCOL_ERROR response malformed: mixed case name: ");
                sb.append(byteString.utf8());
                throw new IOException(sb.toString());
            }
        }
        return byteString;
    }
}
