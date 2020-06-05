package com.bytedance.sdk.p145a.p147b;

import com.bytedance.sdk.p145a.p146a.BufferedSink;
import com.bytedance.sdk.p145a.p147b.p148a.C1876c;
import java.io.IOException;

/* renamed from: com.bytedance.sdk.a.b.ac */
public abstract class RequestBody {
    /* renamed from: a */
    public abstract MediaType mo13934a();

    /* renamed from: a */
    public abstract void mo13935a(BufferedSink dVar) throws IOException;

    /* renamed from: b */
    public long mo13936b() throws IOException {
        return -1;
    }

    /* renamed from: a */
    public static RequestBody m7367a(MediaType yVar, byte[] bArr) {
        return m7368a(yVar, bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static RequestBody m7368a(final MediaType yVar, final byte[] bArr, final int i, final int i2) {
        if (bArr != null) {
            C1876c.m6960a((long) bArr.length, (long) i, (long) i2);
            return new RequestBody() {
                /* renamed from: a */
                public MediaType mo13934a() {
                    return yVar;
                }

                /* renamed from: b */
                public long mo13936b() {
                    return (long) i2;
                }

                /* renamed from: a */
                public void mo13935a(BufferedSink dVar) throws IOException {
                    dVar.mo13538c(bArr, i, i2);
                }
            };
        }
        throw new NullPointerException("content == null");
    }
}
