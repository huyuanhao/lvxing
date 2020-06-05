package com.bytedance.sdk.p145a.p147b.p148a.p153e;

import java.io.IOException;

/* renamed from: com.bytedance.sdk.a.b.a.e.o */
public final class StreamResetException extends IOException {
    /* renamed from: a */
    public final ErrorCode f5652a;

    public StreamResetException(ErrorCode bVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("stream was reset: ");
        sb.append(bVar);
        super(sb.toString());
        this.f5652a = bVar;
    }
}
