package okio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* compiled from: BufferedSource */
/* renamed from: okio.e */
public interface C8529e extends ReadableByteChannel, C8547r {
    /* renamed from: a */
    long mo40716a(byte b) throws IOException;

    /* renamed from: a */
    long mo40718a(C8546q qVar) throws IOException;

    /* renamed from: a */
    String mo40721a(Charset charset) throws IOException;

    /* renamed from: a */
    void mo40729a(long j) throws IOException;

    /* renamed from: a */
    void mo40730a(byte[] bArr) throws IOException;

    /* renamed from: a */
    boolean mo40731a(long j, ByteString byteString) throws IOException;

    /* renamed from: c */
    ByteString mo40740c(long j) throws IOException;

    /* renamed from: c */
    C8525c mo40741c();

    /* renamed from: e */
    String mo40749e(long j) throws IOException;

    /* renamed from: f */
    boolean mo40755f() throws IOException;

    /* renamed from: g */
    InputStream mo40756g();

    /* renamed from: g */
    byte[] mo40758g(long j) throws IOException;

    /* renamed from: h */
    void mo40761h(long j) throws IOException;

    /* renamed from: i */
    byte mo40763i() throws IOException;

    /* renamed from: j */
    short mo40768j() throws IOException;

    /* renamed from: k */
    int mo40769k() throws IOException;

    /* renamed from: l */
    short mo40772l() throws IOException;

    /* renamed from: m */
    int mo40773m() throws IOException;

    /* renamed from: n */
    long mo40774n() throws IOException;

    /* renamed from: o */
    long mo40775o() throws IOException;

    /* renamed from: r */
    String mo40778r() throws IOException;

    /* renamed from: s */
    byte[] mo40780s() throws IOException;
}
