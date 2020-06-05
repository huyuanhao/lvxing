package com.bytedance.sdk.p145a.p147b;

import com.bytedance.sdk.p145a.p146a.Buffer;
import com.bytedance.sdk.p145a.p146a.BufferedSource;
import com.bytedance.sdk.p145a.p147b.p148a.C1876c;
import java.io.Closeable;
import java.io.InputStream;

/* renamed from: com.bytedance.sdk.a.b.c */
public abstract class ResponseBody implements Closeable {
    /* renamed from: a */
    public abstract long mo13744a();

    /* renamed from: b */
    public abstract BufferedSource mo13745b();

    /* renamed from: c */
    public final InputStream mo13967c() {
        return mo13745b().mo13549f();
    }

    public void close() {
        C1876c.m6961a((Closeable) mo13745b());
    }

    /* renamed from: a */
    public static ResponseBody m7408a(MediaType yVar, byte[] bArr) {
        return m7407a(yVar, (long) bArr.length, new Buffer().mo13537c(bArr));
    }

    /* renamed from: a */
    public static ResponseBody m7407a(final MediaType yVar, final long j, final BufferedSource eVar) {
        if (eVar != null) {
            return new ResponseBody() {
                /* renamed from: a */
                public long mo13744a() {
                    return j;
                }

                /* renamed from: b */
                public BufferedSource mo13745b() {
                    return eVar;
                }
            };
        }
        throw new NullPointerException("source == null");
    }
}
