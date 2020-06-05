package com.bytedance.sdk.p145a.p146a;

import java.io.Closeable;
import java.io.IOException;

/* renamed from: com.bytedance.sdk.a.a.s */
public interface Source extends Closeable {
    /* renamed from: a */
    long mo13511a(Buffer cVar, long j) throws IOException;

    /* renamed from: a */
    Timeout mo13512a();

    void close() throws IOException;
}
