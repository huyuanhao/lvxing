package com.bytedance.sdk.p145a.p146a;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.bytedance.sdk.a.a.l */
public final class Okio {
    /* renamed from: a */
    static final Logger f5262a = Logger.getLogger(Okio.class.getName());

    private Okio() {
    }

    /* renamed from: a */
    public static BufferedSource m6747a(Source sVar) {
        return new RealBufferedSource(sVar);
    }

    /* renamed from: a */
    public static BufferedSink m6746a(Sink rVar) {
        return new RealBufferedSink(rVar);
    }

    /* renamed from: a */
    private static Sink m6748a(final OutputStream outputStream, final Timeout tVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (tVar != null) {
            return new Sink() {
                /* renamed from: a_ */
                public void mo13507a_(Buffer cVar, long j) throws IOException {
                    C1868u.m6834a(cVar.f5243b, 0, j);
                    while (j > 0) {
                        tVar.mo13614g();
                        Segment oVar = cVar.f5242a;
                        int min = (int) Math.min(j, (long) (oVar.f5277c - oVar.f5276b));
                        outputStream.write(oVar.f5275a, oVar.f5276b, min);
                        oVar.f5276b += min;
                        long j2 = (long) min;
                        j -= j2;
                        cVar.f5243b -= j2;
                        if (oVar.f5276b == oVar.f5277c) {
                            cVar.f5242a = oVar.mo13637b();
                            SegmentPool.m6801a(oVar);
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
                public Timeout mo13506a() {
                    return tVar;
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
    public static Sink m6749a(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getOutputStream() != null) {
            AsyncTimeout c = m6754c(socket);
            return c.mo13498a(m6748a(socket.getOutputStream(), (Timeout) c));
        } else {
            throw new IOException("socket's output stream == null");
        }
    }

    /* renamed from: a */
    public static Source m6750a(InputStream inputStream) {
        return m6751a(inputStream, new Timeout());
    }

    /* renamed from: a */
    private static Source m6751a(final InputStream inputStream, final Timeout tVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (tVar != null) {
            return new Source() {
                /* renamed from: a */
                public long mo13511a(Buffer cVar, long j) throws IOException {
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
                            tVar.mo13614g();
                            Segment e = cVar.mo13544e(1);
                            int read = inputStream.read(e.f5275a, e.f5277c, (int) Math.min(j, (long) (8192 - e.f5277c)));
                            if (read == -1) {
                                return -1;
                            }
                            e.f5277c += read;
                            long j2 = (long) read;
                            cVar.f5243b += j2;
                            return j2;
                        } catch (AssertionError e2) {
                            if (Okio.m6752a(e2)) {
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
                public Timeout mo13512a() {
                    return tVar;
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

    /* renamed from: b */
    public static Source m6753b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getInputStream() != null) {
            AsyncTimeout c = m6754c(socket);
            return c.mo13499a(m6751a(socket.getInputStream(), (Timeout) c));
        } else {
            throw new IOException("socket's input stream == null");
        }
    }

    /* renamed from: c */
    private static AsyncTimeout m6754c(final Socket socket) {
        return new AsyncTimeout() {
            /* access modifiers changed from: protected */
            /* renamed from: b */
            public IOException mo13503b(IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            /* access modifiers changed from: protected */
            /* renamed from: c */
            public void mo13505c() {
                String str = "Failed to close timed out socket ";
                try {
                    socket.close();
                } catch (Exception e) {
                    Logger logger = Okio.f5262a;
                    Level level = Level.WARNING;
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(socket);
                    logger.log(level, sb.toString(), e);
                } catch (AssertionError e2) {
                    if (Okio.m6752a(e2)) {
                        Logger logger2 = Okio.f5262a;
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
    static boolean m6752a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
