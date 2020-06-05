package okio;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* compiled from: Sink */
/* renamed from: okio.q */
public interface C8546q extends Closeable, Flushable {
    /* renamed from: a */
    C8548s mo40271a();

    /* renamed from: a_ */
    void mo40231a_(C8525c cVar, long j) throws IOException;

    void close() throws IOException;

    void flush() throws IOException;
}
