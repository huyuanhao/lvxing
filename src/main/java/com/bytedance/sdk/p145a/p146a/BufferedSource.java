package com.bytedance.sdk.p145a.p146a;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;

/* renamed from: com.bytedance.sdk.a.a.e */
public interface BufferedSource extends Source, ReadableByteChannel {
    /* renamed from: a */
    long mo13517a(byte b) throws IOException;

    /* renamed from: a */
    void mo13527a(long j) throws IOException;

    /* renamed from: a */
    void mo13528a(byte[] bArr) throws IOException;

    @Deprecated
    /* renamed from: c */
    Buffer mo13535c();

    /* renamed from: c */
    ByteString mo13539c(long j) throws IOException;

    /* renamed from: e */
    String mo13545e(long j) throws IOException;

    /* renamed from: e */
    boolean mo13546e() throws IOException;

    /* renamed from: f */
    InputStream mo13549f();

    /* renamed from: g */
    byte[] mo13553g(long j) throws IOException;

    /* renamed from: h */
    byte mo13554h() throws IOException;

    /* renamed from: h */
    void mo13556h(long j) throws IOException;

    /* renamed from: i */
    short mo13560i() throws IOException;

    /* renamed from: j */
    int mo13562j() throws IOException;

    /* renamed from: k */
    short mo13565k() throws IOException;

    /* renamed from: l */
    int mo13566l() throws IOException;

    /* renamed from: m */
    long mo13568m() throws IOException;

    /* renamed from: p */
    String mo13571p() throws IOException;
}
