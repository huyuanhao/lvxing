package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import okhttp3.internal.C8417c;
import okio.ByteString;
import okio.C8528d;
import okio.C8535k;
import okio.C8547r;

/* compiled from: RequestBody */
/* renamed from: okhttp3.aa */
public abstract class C8358aa {
    /* renamed from: a */
    public abstract void mo40083a(C8528d dVar) throws IOException;

    @Nullable
    /* renamed from: b */
    public abstract C8510v mo40084b();

    /* renamed from: c */
    public long mo40085c() throws IOException {
        return -1;
    }

    /* renamed from: a */
    public static C8358aa m35765a(@Nullable C8510v vVar, String str) {
        Charset charset = C8417c.f28532e;
        if (vVar != null) {
            charset = vVar.mo40589b();
            if (charset == null) {
                charset = C8417c.f28532e;
                StringBuilder sb = new StringBuilder();
                sb.append(vVar);
                sb.append("; charset=utf-8");
                vVar = C8510v.m36598b(sb.toString());
            }
        }
        return m35767a(vVar, str.getBytes(charset));
    }

    /* renamed from: a */
    public static C8358aa m35766a(@Nullable final C8510v vVar, final ByteString byteString) {
        return new C8358aa() {
            @Nullable
            /* renamed from: b */
            public C8510v mo40084b() {
                return C8510v.this;
            }

            /* renamed from: c */
            public long mo40085c() throws IOException {
                return (long) byteString.size();
            }

            /* renamed from: a */
            public void mo40083a(C8528d dVar) throws IOException {
                dVar.mo40739b(byteString);
            }
        };
    }

    /* renamed from: a */
    public static C8358aa m35767a(@Nullable C8510v vVar, byte[] bArr) {
        return m35768a(vVar, bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static C8358aa m35768a(@Nullable final C8510v vVar, final byte[] bArr, final int i, final int i2) {
        if (bArr != null) {
            C8417c.m36039a((long) bArr.length, (long) i, (long) i2);
            return new C8358aa() {
                @Nullable
                /* renamed from: b */
                public C8510v mo40084b() {
                    return C8510v.this;
                }

                /* renamed from: c */
                public long mo40085c() {
                    return (long) i2;
                }

                /* renamed from: a */
                public void mo40083a(C8528d dVar) throws IOException {
                    dVar.mo40744c(bArr, i, i2);
                }
            };
        }
        throw new NullPointerException("content == null");
    }

    /* renamed from: a */
    public static C8358aa m35764a(@Nullable final C8510v vVar, final File file) {
        if (file != null) {
            return new C8358aa() {
                @Nullable
                /* renamed from: b */
                public C8510v mo40084b() {
                    return C8510v.this;
                }

                /* renamed from: c */
                public long mo40085c() {
                    return file.length();
                }

                /* renamed from: a */
                public void mo40083a(C8528d dVar) throws IOException {
                    C8547r rVar = null;
                    try {
                        rVar = C8535k.m36854a(file);
                        dVar.mo40719a(rVar);
                    } finally {
                        C8417c.m36040a((Closeable) rVar);
                    }
                }
            };
        }
        throw new NullPointerException("content == null");
    }
}
