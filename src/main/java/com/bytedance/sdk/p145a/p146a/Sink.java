package com.bytedance.sdk.p145a.p146a;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* renamed from: com.bytedance.sdk.a.a.r */
public interface Sink extends Closeable, Flushable {
    /* renamed from: a */
    Timeout mo13506a();

    /* renamed from: a_ */
    void mo13507a_(Buffer cVar, long j) throws IOException;

    void close() throws IOException;

    void flush() throws IOException;
}
