package okio;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* compiled from: BufferedSink */
/* renamed from: okio.d */
public interface C8528d extends WritableByteChannel, C8546q {
    /* renamed from: a */
    long mo40719a(C8547r rVar) throws IOException;

    /* renamed from: b */
    C8528d mo40738b(String str) throws IOException;

    /* renamed from: b */
    C8528d mo40739b(ByteString byteString) throws IOException;

    /* renamed from: c */
    C8525c mo40741c();

    /* renamed from: c */
    C8528d mo40743c(byte[] bArr) throws IOException;

    /* renamed from: c */
    C8528d mo40744c(byte[] bArr, int i, int i2) throws IOException;

    void flush() throws IOException;

    /* renamed from: g */
    C8528d mo40757g(int i) throws IOException;

    /* renamed from: h */
    C8528d mo40760h(int i) throws IOException;

    /* renamed from: i */
    C8528d mo40765i(int i) throws IOException;

    /* renamed from: k */
    C8528d mo40770k(long j) throws IOException;

    /* renamed from: l */
    C8528d mo40771l(long j) throws IOException;

    /* renamed from: x */
    C8528d mo40787x() throws IOException;
}
