package retrofit2;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.C8358aa;
import okhttp3.C8504s;
import okhttp3.C8506t;
import okhttp3.C8506t.C8507a;
import okhttp3.C8510v;
import okhttp3.C8518z;
import okhttp3.C8518z.C8519a;
import okhttp3.FormBody.C8502a;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody.C8511a;
import okhttp3.MultipartBody.C8512b;
import okio.C8525c;
import okio.C8528d;

/* compiled from: RequestBuilder */
/* renamed from: retrofit2.k */
final class C8656k {
    /* renamed from: a */
    private static final char[] f29393a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    /* renamed from: b */
    private final String f29394b;
    /* renamed from: c */
    private final C8506t f29395c;
    @Nullable
    /* renamed from: d */
    private String f29396d;
    @Nullable
    /* renamed from: e */
    private C8507a f29397e;
    /* renamed from: f */
    private final C8519a f29398f = new C8519a();
    @Nullable
    /* renamed from: g */
    private C8510v f29399g;
    /* renamed from: h */
    private final boolean f29400h;
    @Nullable
    /* renamed from: i */
    private C8511a f29401i;
    @Nullable
    /* renamed from: j */
    private C8502a f29402j;
    @Nullable
    /* renamed from: k */
    private C8358aa f29403k;

    /* compiled from: RequestBuilder */
    /* renamed from: retrofit2.k$a */
    private static class C8657a extends C8358aa {
        /* renamed from: a */
        private final C8358aa f29404a;
        /* renamed from: b */
        private final C8510v f29405b;

        C8657a(C8358aa aaVar, C8510v vVar) {
            this.f29404a = aaVar;
            this.f29405b = vVar;
        }

        /* renamed from: b */
        public C8510v mo40084b() {
            return this.f29405b;
        }

        /* renamed from: c */
        public long mo40085c() throws IOException {
            return this.f29404a.mo40085c();
        }

        /* renamed from: a */
        public void mo40083a(C8528d dVar) throws IOException {
            this.f29404a.mo40083a(dVar);
        }
    }

    C8656k(String str, C8506t tVar, @Nullable String str2, @Nullable C8504s sVar, @Nullable C8510v vVar, boolean z, boolean z2, boolean z3) {
        this.f29394b = str;
        this.f29395c = tVar;
        this.f29396d = str2;
        this.f29399g = vVar;
        this.f29400h = z;
        if (sVar != null) {
            this.f29398f.mo40659a(sVar);
        }
        if (z2) {
            this.f29402j = new C8502a();
        } else if (z3) {
            this.f29401i = new C8511a();
            this.f29401i.mo40594a(MultipartBody.f28915e);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo41343a(Object obj) {
        this.f29396d = obj.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo41344a(String str, String str2) {
        if ("Content-Type".equalsIgnoreCase(str)) {
            C8510v b = C8510v.m36598b(str2);
            if (b != null) {
                this.f29399g = b;
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Malformed content type: ");
            sb.append(str2);
            throw new IllegalArgumentException(sb.toString());
        }
        this.f29398f.mo40662b(str, str2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo41345a(String str, String str2, boolean z) {
        String str3 = this.f29396d;
        if (str3 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            sb.append(str);
            sb.append("}");
            this.f29396d = str3.replace(sb.toString(), m37577a(str2, z));
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    private static String m37577a(String str, boolean z) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt < 32 || codePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(codePointAt) != -1 || (!z && (codePointAt == 47 || codePointAt == 37))) {
                C8525c cVar = new C8525c();
                cVar.mo40724a(str, 0, i);
                m37578a(cVar, str, i, length, z);
                return cVar.mo40777q();
            }
            i += Character.charCount(codePointAt);
        }
        return str;
    }

    /* renamed from: a */
    private static void m37578a(C8525c cVar, String str, int i, int i2, boolean z) {
        C8525c cVar2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt < 32 || codePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(codePointAt) != -1 || (!z && (codePointAt == 47 || codePointAt == 37))) {
                    if (cVar2 == null) {
                        cVar2 = new C8525c();
                    }
                    cVar2.mo40722a(codePointAt);
                    while (!cVar2.mo40755f()) {
                        byte i3 = cVar2.mo40763i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                        cVar.mo40765i(37);
                        cVar.mo40765i((int) f29393a[(i3 >> 4) & 15]);
                        cVar.mo40765i((int) f29393a[i3 & 15]);
                    }
                } else {
                    cVar.mo40722a(codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo41349b(String str, @Nullable String str2, boolean z) {
        String str3 = this.f29396d;
        if (str3 != null) {
            this.f29397e = this.f29395c.mo40553d(str3);
            if (this.f29397e != null) {
                this.f29396d = null;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Malformed URL. Base: ");
                sb.append(this.f29395c);
                sb.append(", Relative: ");
                sb.append(this.f29396d);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        if (z) {
            this.f29397e.mo40578b(str, str2);
        } else {
            this.f29397e.mo40573a(str, str2);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo41350c(String str, String str2, boolean z) {
        if (z) {
            this.f29402j.mo40524b(str, str2);
        } else {
            this.f29402j.mo40522a(str, str2);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo41347a(C8504s sVar, C8358aa aaVar) {
        this.f29401i.mo40593a(sVar, aaVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo41348a(C8512b bVar) {
        this.f29401i.mo40595a(bVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo41346a(C8358aa aaVar) {
        this.f29403k = aaVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C8518z mo41342a() {
        C8506t tVar;
        C8507a aVar = this.f29397e;
        if (aVar != null) {
            tVar = aVar.mo40580c();
        } else {
            tVar = this.f29395c.mo40550c(this.f29396d);
            if (tVar == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Malformed URL. Base: ");
                sb.append(this.f29395c);
                sb.append(", Relative: ");
                sb.append(this.f29396d);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        C8358aa aaVar = this.f29403k;
        if (aaVar == null) {
            C8502a aVar2 = this.f29402j;
            if (aVar2 != null) {
                aaVar = aVar2.mo40523a();
            } else {
                C8511a aVar3 = this.f29401i;
                if (aVar3 != null) {
                    aaVar = aVar3.mo40596a();
                } else if (this.f29400h) {
                    aaVar = C8358aa.m35767a((C8510v) null, new byte[0]);
                }
            }
        }
        C8510v vVar = this.f29399g;
        if (vVar != null) {
            if (aaVar != null) {
                aaVar = new C8657a(aaVar, vVar);
            } else {
                this.f29398f.mo40662b("Content-Type", vVar.toString());
            }
        }
        return this.f29398f.mo40660a(tVar).mo40657a(this.f29394b, aaVar).mo40663b();
    }
}
