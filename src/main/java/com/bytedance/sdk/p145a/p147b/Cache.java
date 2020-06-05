package com.bytedance.sdk.p145a.p147b;

import com.bytedance.sdk.p145a.p147b.p148a.p149a.C1871d;
import com.bytedance.sdk.p145a.p147b.p148a.p149a.InternalCache;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* renamed from: com.bytedance.sdk.a.b.f */
public final class Cache implements Closeable, Flushable {
    /* renamed from: a */
    final InternalCache f5762a;
    /* renamed from: b */
    final C1871d f5763b;

    public void flush() throws IOException {
        this.f5763b.flush();
    }

    public void close() throws IOException {
        this.f5763b.close();
    }
}
