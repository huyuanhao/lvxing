package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* compiled from: Okio */
/* renamed from: okio.k */
public final class C8535k {
    /* renamed from: a */
    static final Logger f29033a = Logger.getLogger(C8535k.class.getName());

    private C8535k() {
    }

    /* renamed from: a */
    public static C8529e m36849a(C8547r rVar) {
        return new C8541m(rVar);
    }

    /* renamed from: a */
    public static C8528d m36848a(C8546q qVar) {
        return new C8540l(qVar);
    }

    /* renamed from: a */
    public static C8546q m36851a(OutputStream outputStream) {
        return m36852a(outputStream, new C8548s());
    }

    /* renamed from: a */
    private static C8546q m36852a(final OutputStream outputStream, final C8548s sVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (sVar != null) {
            return new C8546q() {
                /* renamed from: a_ */
                public void mo40231a_(C8525c cVar, long j) throws IOException {
                    C8550t.m36938a(cVar.f29018b, 0, j);
                    while (j > 0) {
                        C8548s.this.mo40807g();
                        C8543n nVar = cVar.f29017a;
                        int min = (int) Math.min(j, (long) (nVar.f29048c - nVar.f29047b));
                        outputStream.write(nVar.f29046a, nVar.f29047b, min);
                        nVar.f29047b += min;
                        long j2 = (long) min;
                        j -= j2;
                        cVar.f29018b -= j2;
                        if (nVar.f29047b == nVar.f29048c) {
                            cVar.f29017a = nVar.mo40832b();
                            C8544o.m36918a(nVar);
                        }
                    }
                }

                public void flush() throws IOException {
                    outputStream.flush();
                }

                public void close() throws IOException {
                    outputStream.close();
                }

                /* renamed from: a */
                public C8548s mo40271a() {
                    return C8548s.this;
                }

                public String toString() {
                    StringBuilder sb = new StringBuilder();
                    sb.append("sink(");
                    sb.append(outputStream);
                    sb.append(")");
                    return sb.toString();
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    /* renamed from: a */
    public static C8546q m36853a(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getOutputStream() != null) {
            C8520a c = m36860c(socket);
            return c.mo40706a(m36852a(socket.getOutputStream(), (C8548s) c));
        } else {
            throw new IOException("socket's output stream == null");
        }
    }

    /* renamed from: a */
    public static C8547r m36855a(InputStream inputStream) {
        return m36856a(inputStream, new C8548s());
    }

    /* renamed from: a */
    private static C8547r m36856a(final InputStream inputStream, final C8548s sVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (sVar != null) {
            return new C8547r() {
                /* renamed from: a */
                public long mo40202a(C8525c cVar, long j) throws IOException {
                    int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                    if (i < 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("byteCount < 0: ");
                        sb.append(j);
                        throw new IllegalArgumentException(sb.toString());
                    } else if (i == 0) {
                        return 0;
                    } else {
                        try {
                            C8548s.this.mo40807g();
                            C8543n e = cVar.mo40751e(1);
                            int read = inputStream.read(e.f29046a, e.f29048c, (int) Math.min(j, (long) (8192 - e.f29048c)));
                            if (read == -1) {
                                return -1;
                            }
                            e.f29048c += read;
                            long j2 = (long) read;
                            cVar.f29018b += j2;
                            return j2;
                        } catch (AssertionError e2) {
                            if (C8535k.m36857a(e2)) {
                                throw new IOException(e2);
                            }
                            throw e2;
                        }
                    }
                }

                public void close() throws IOException {
                    inputStream.close();
                }

                /* renamed from: a */
                public C8548s mo40203a() {
                    return C8548s.this;
                }

                public String toString() {
                    StringBuilder sb = new StringBuilder();
                    sb.append("source(");
                    sb.append(inputStream);
                    sb.append(")");
                    return sb.toString();
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    /* renamed from: a */
    public static C8547r m36854a(File file) throws FileNotFoundException {
        if (file != null) {
            return m36855a((InputStream) new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    /* renamed from: b */
    public static C8546q m36858b(File file) throws FileNotFoundException {
        if (file != null) {
            return m36851a((OutputStream) new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    /* renamed from: c */
    public static C8546q m36861c(File file) throws FileNotFoundException {
        if (file != null) {
            return m36851a((OutputStream) new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    /* renamed from: a */
    public static C8546q m36850a() {
        return new C8546q() {
            public void close() throws IOException {
            }

            public void flush() throws IOException {
            }

            /* renamed from: a_ */
            public void mo40231a_(C8525c cVar, long j) throws IOException {
                cVar.mo40761h(j);
            }

            /* renamed from: a */
            public C8548s mo40271a() {
                return C8548s.f29055c;
            }
        };
    }

    /* renamed from: b */
    public static C8547r m36859b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getInputStream() != null) {
            C8520a c = m36860c(socket);
            return c.mo40707a(m36856a(socket.getInputStream(), (C8548s) c));
        } else {
            throw new IOException("socket's input stream == null");
        }
    }

    /* renamed from: c */
    private static C8520a m36860c(final Socket socket) {
        return new C8520a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public IOException mo40423a(@Nullable IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo40424a() {
                String str = "Failed to close timed out socket ";
                try {
                    socket.close();
                } catch (Exception e) {
                    Logger logger = C8535k.f29033a;
                    Level level = Level.WARNING;
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(socket);
                    logger.log(level, sb.toString(), e);
                } catch (AssertionError e2) {
                    if (C8535k.m36857a(e2)) {
                        Logger logger2 = C8535k.f29033a;
                        Level level2 = Level.WARNING;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append(socket);
                        logger2.log(level2, sb2.toString(), e2);
                        return;
                    }
                    throw e2;
                }
            }
        };
    }

    /* renamed from: a */
    static boolean m36857a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
