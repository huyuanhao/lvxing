package okhttp3;

import com.p522qq.taf.jce.JceStruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;
import okhttp3.internal.C8417c;
import okio.ByteString;
import okio.C8528d;

/* renamed from: okhttp3.w */
public final class MultipartBody extends C8358aa {
    /* renamed from: a */
    public static final C8510v f28911a = C8510v.m36597a("multipart/mixed");
    /* renamed from: b */
    public static final C8510v f28912b = C8510v.m36597a("multipart/alternative");
    /* renamed from: c */
    public static final C8510v f28913c = C8510v.m36597a("multipart/digest");
    /* renamed from: d */
    public static final C8510v f28914d = C8510v.m36597a("multipart/parallel");
    /* renamed from: e */
    public static final C8510v f28915e = C8510v.m36597a("multipart/form-data");
    /* renamed from: f */
    private static final byte[] f28916f = {58, 32};
    /* renamed from: g */
    private static final byte[] f28917g = {JceStruct.SIMPLE_LIST, 10};
    /* renamed from: h */
    private static final byte[] f28918h = {45, 45};
    /* renamed from: i */
    private final ByteString f28919i;
    /* renamed from: j */
    private final C8510v f28920j;
    /* renamed from: k */
    private final C8510v f28921k;
    /* renamed from: l */
    private final List<C8512b> f28922l;
    /* renamed from: m */
    private long f28923m = -1;

    /* compiled from: MultipartBody */
    /* renamed from: okhttp3.w$a */
    public static final class C8511a {
        /* renamed from: a */
        private final ByteString f28924a;
        /* renamed from: b */
        private C8510v f28925b;
        /* renamed from: c */
        private final List<C8512b> f28926c;

        public C8511a() {
            this(UUID.randomUUID().toString());
        }

        public C8511a(String str) {
            this.f28925b = MultipartBody.f28911a;
            this.f28926c = new ArrayList();
            this.f28924a = ByteString.encodeUtf8(str);
        }

        /* renamed from: a */
        public C8511a mo40594a(C8510v vVar) {
            if (vVar == null) {
                throw new NullPointerException("type == null");
            } else if (vVar.mo40587a().equals("multipart")) {
                this.f28925b = vVar;
                return this;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("multipart != ");
                sb.append(vVar);
                throw new IllegalArgumentException(sb.toString());
            }
        }

        /* renamed from: a */
        public C8511a mo40593a(@Nullable C8504s sVar, C8358aa aaVar) {
            return mo40595a(C8512b.m36610a(sVar, aaVar));
        }

        /* renamed from: a */
        public C8511a mo40595a(C8512b bVar) {
            if (bVar != null) {
                this.f28926c.add(bVar);
                return this;
            }
            throw new NullPointerException("part == null");
        }

        /* renamed from: a */
        public MultipartBody mo40596a() {
            if (!this.f28926c.isEmpty()) {
                return new MultipartBody(this.f28924a, this.f28925b, this.f28926c);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }
    }

    /* compiled from: MultipartBody */
    /* renamed from: okhttp3.w$b */
    public static final class C8512b {
        @Nullable
        /* renamed from: a */
        final C8504s f28927a;
        /* renamed from: b */
        final C8358aa f28928b;

        /* renamed from: a */
        public static C8512b m36610a(@Nullable C8504s sVar, C8358aa aaVar) {
            if (aaVar == null) {
                throw new NullPointerException("body == null");
            } else if (sVar != null && sVar.mo40533a("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            } else if (sVar == null || sVar.mo40533a("Content-Length") == null) {
                return new C8512b(sVar, aaVar);
            } else {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
        }

        private C8512b(@Nullable C8504s sVar, C8358aa aaVar) {
            this.f28927a = sVar;
            this.f28928b = aaVar;
        }
    }

    MultipartBody(ByteString byteString, C8510v vVar, List<C8512b> list) {
        this.f28919i = byteString;
        this.f28920j = vVar;
        StringBuilder sb = new StringBuilder();
        sb.append(vVar);
        sb.append("; boundary=");
        sb.append(byteString.utf8());
        this.f28921k = C8510v.m36597a(sb.toString());
        this.f28922l = C8417c.m36034a(list);
    }

    /* renamed from: b */
    public C8510v mo40084b() {
        return this.f28921k;
    }

    /* renamed from: c */
    public long mo40085c() throws IOException {
        long j = this.f28923m;
        if (j != -1) {
            return j;
        }
        long a = m36602a(null, true);
        this.f28923m = a;
        return a;
    }

    /* renamed from: a */
    public void mo40083a(C8528d dVar) throws IOException {
        m36602a(dVar, false);
    }

    /* JADX WARNING: type inference failed for: r13v1, types: [okio.d] */
    /* JADX WARNING: type inference failed for: r0v1 */
    /* JADX WARNING: type inference failed for: r13v3, types: [okio.c] */
    /* JADX WARNING: type inference failed for: r13v4 */
    /* JADX WARNING: type inference failed for: r13v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* renamed from: a */
    private long m36602a(@javax.annotation.Nullable okio.C8528d r13, boolean r14) throws java.io.IOException {
        /*
        r12 = this;
        if (r14 == 0) goto L_0x0009
        okio.c r13 = new okio.c
        r13.m55563init()
        r0 = r13
        goto L_0x000a
    L_0x0009:
        r0 = 0
    L_0x000a:
        java.util.List<okhttp3.w$b> r1 = r12.f28922l
        int r1 = r1.size()
        r2 = 0
        r3 = 0
        r4 = r3
        r3 = 0
    L_0x0015:
        if (r3 >= r1) goto L_0x00a7
        java.util.List<okhttp3.w$b> r6 = r12.f28922l
        java.lang.Object r6 = r6.get(r3)
        okhttp3.w$b r6 = (okhttp3.MultipartBody.C8512b) r6
        okhttp3.s r7 = r6.f28927a
        okhttp3.aa r6 = r6.f28928b
        byte[] r8 = f28918h
        r13.mo40743c(r8)
        okio.ByteString r8 = r12.f28919i
        r13.mo40739b(r8)
        byte[] r8 = f28917g
        r13.mo40743c(r8)
        if (r7 == 0) goto L_0x0059
        int r8 = r7.mo40531a()
        r9 = 0
    L_0x0039:
        if (r9 >= r8) goto L_0x0059
        java.lang.String r10 = r7.mo40532a(r9)
        okio.d r10 = r13.mo40738b(r10)
        byte[] r11 = f28916f
        okio.d r10 = r10.mo40743c(r11)
        java.lang.String r11 = r7.mo40534b(r9)
        okio.d r10 = r10.mo40738b(r11)
        byte[] r11 = f28917g
        r10.mo40743c(r11)
        int r9 = r9 + 1
        goto L_0x0039
    L_0x0059:
        okhttp3.v r7 = r6.mo40084b()
        if (r7 == 0) goto L_0x0072
        java.lang.String r8 = "Content-Type: "
        okio.d r8 = r13.mo40738b(r8)
        java.lang.String r7 = r7.toString()
        okio.d r7 = r8.mo40738b(r7)
        byte[] r8 = f28917g
        r7.mo40743c(r8)
    L_0x0072:
        long r7 = r6.mo40085c()
        r9 = -1
        int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
        if (r11 == 0) goto L_0x008c
        java.lang.String r9 = "Content-Length: "
        okio.d r9 = r13.mo40738b(r9)
        okio.d r9 = r9.mo40771l(r7)
        byte[] r10 = f28917g
        r9.mo40743c(r10)
        goto L_0x0092
    L_0x008c:
        if (r14 == 0) goto L_0x0092
        r0.mo40781t()
        return r9
    L_0x0092:
        byte[] r9 = f28917g
        r13.mo40743c(r9)
        if (r14 == 0) goto L_0x009b
        long r4 = r4 + r7
        goto L_0x009e
    L_0x009b:
        r6.mo40083a(r13)
    L_0x009e:
        byte[] r6 = f28917g
        r13.mo40743c(r6)
        int r3 = r3 + 1
        goto L_0x0015
    L_0x00a7:
        byte[] r1 = f28918h
        r13.mo40743c(r1)
        okio.ByteString r1 = r12.f28919i
        r13.mo40739b(r1)
        byte[] r1 = f28918h
        r13.mo40743c(r1)
        byte[] r1 = f28917g
        r13.mo40743c(r1)
        if (r14 == 0) goto L_0x00c5
        long r13 = r0.mo40734b()
        long r4 = r4 + r13
        r0.mo40781t()
    L_0x00c5:
        return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.MultipartBody.m36602a(okio.d, boolean):long");
    }
}
