package com.bytedance.sdk.p145a.p146a;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* renamed from: com.bytedance.sdk.a.a.d */
public interface BufferedSink extends Sink, WritableByteChannel {
    /* renamed from: b */
    BufferedSink mo13534b(String str) throws IOException;

    /* renamed from: c */
    Buffer mo13535c();

    /* renamed from: c */
    BufferedSink mo13537c(byte[] bArr) throws IOException;

    /* renamed from: c */
    BufferedSink mo13538c(byte[] bArr, int i, int i2) throws IOException;

    void flush() throws IOException;

    /* renamed from: g */
    BufferedSink mo13552g(int i) throws IOException;

    /* renamed from: h */
    BufferedSink mo13555h(int i) throws IOException;

    /* renamed from: i */
    BufferedSink mo13559i(int i) throws IOException;

    /* renamed from: k */
    BufferedSink mo13564k(long j) throws IOException;

    /* renamed from: l */
    BufferedSink mo13567l(long j) throws IOException;

    /* renamed from: u */
    BufferedSink mo13578u() throws IOException;
}
