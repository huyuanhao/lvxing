package com.tencent.android.tpush.service.channel.p593c;

import com.tencent.android.tpush.service.channel.exception.IORefusedException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.channel.c.a */
public class C7032a {
    /* renamed from: a */
    protected byte[] f23374a;
    /* renamed from: b */
    protected volatile int f23375b;
    /* renamed from: c */
    protected volatile int f23376c;
    /* renamed from: d */
    protected volatile int f23377d;
    /* renamed from: e */
    protected volatile int f23378e;
    /* renamed from: f */
    protected volatile boolean f23379f;
    /* renamed from: g */
    protected boolean f23380g;
    /* renamed from: h */
    protected InputStream f23381h;
    /* renamed from: i */
    protected boolean f23382i;
    /* renamed from: j */
    protected OutputStream f23383j;
    /* renamed from: k */
    protected boolean f23384k;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.service.channel.c.a$a */
    protected class C7033a extends InputStream {
        public boolean markSupported() {
            return true;
        }

        protected C7033a() {
        }

        public int available() {
            int a;
            synchronized (C7032a.this) {
                if (!C7032a.this.f23382i) {
                    a = C7032a.this.m30075g();
                } else {
                    throw new IOException("InputStream has been closed, it is not ready.");
                }
            }
            return a;
        }

        public void close() {
            synchronized (C7032a.this) {
                C7032a.this.f23382i = true;
            }
        }

        public void mark(int i) {
            synchronized (C7032a.this) {
                if (C7032a.this.f23374a.length - 1 > i) {
                    C7032a.this.f23378e = i;
                    C7032a.this.f23377d = C7032a.this.f23375b;
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            java.lang.Thread.sleep(100);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0053, code lost:
            throw new java.io.IOException("Blocking read operation interrupted.");
     */
        public int read() {
            /*
            r4 = this;
        L_0x0000:
            com.tencent.android.tpush.service.channel.c.a r0 = com.tencent.android.tpush.service.channel.p593c.C7032a.this
            monitor-enter(r0)
            com.tencent.android.tpush.service.channel.c.a r1 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x005c }
            boolean r1 = r1.f23382i     // Catch:{ all -> 0x005c }
            if (r1 != 0) goto L_0x0054
            com.tencent.android.tpush.service.channel.c.a r1 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x005c }
            int r1 = r1.m30075g()     // Catch:{ all -> 0x005c }
            if (r1 <= 0) goto L_0x003c
            com.tencent.android.tpush.service.channel.c.a r1 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x005c }
            byte[] r1 = r1.f23374a     // Catch:{ all -> 0x005c }
            com.tencent.android.tpush.service.channel.c.a r2 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x005c }
            int r2 = r2.f23375b     // Catch:{ all -> 0x005c }
            byte r1 = r1[r2]     // Catch:{ all -> 0x005c }
            r1 = r1 & 255(0xff, float:3.57E-43)
            com.tencent.android.tpush.service.channel.c.a r2 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x005c }
            int r3 = r2.f23375b     // Catch:{ all -> 0x005c }
            int r3 = r3 + 1
            r2.f23375b = r3     // Catch:{ all -> 0x005c }
            com.tencent.android.tpush.service.channel.c.a r2 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x005c }
            int r2 = r2.f23375b     // Catch:{ all -> 0x005c }
            com.tencent.android.tpush.service.channel.c.a r3 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x005c }
            byte[] r3 = r3.f23374a     // Catch:{ all -> 0x005c }
            int r3 = r3.length     // Catch:{ all -> 0x005c }
            if (r2 != r3) goto L_0x0035
            com.tencent.android.tpush.service.channel.c.a r2 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x005c }
            r3 = 0
            r2.f23375b = r3     // Catch:{ all -> 0x005c }
        L_0x0035:
            com.tencent.android.tpush.service.channel.c.a r2 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x005c }
            r2.m30077i()     // Catch:{ all -> 0x005c }
            monitor-exit(r0)     // Catch:{ all -> 0x005c }
            return r1
        L_0x003c:
            com.tencent.android.tpush.service.channel.c.a r1 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x005c }
            boolean r1 = r1.f23384k     // Catch:{ all -> 0x005c }
            if (r1 == 0) goto L_0x0045
            r1 = -1
            monitor-exit(r0)     // Catch:{ all -> 0x005c }
            return r1
        L_0x0045:
            monitor-exit(r0)     // Catch:{ all -> 0x005c }
            r0 = 100
            java.lang.Thread.sleep(r0)     // Catch:{ Exception -> 0x004c }
            goto L_0x0000
        L_0x004c:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Blocking read operation interrupted."
            r0.<init>(r1)
            throw r0
        L_0x0054:
            java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x005c }
            java.lang.String r2 = "InputStream has been closed; cannot read from a closed InputStream."
            r1.<init>(r2)     // Catch:{ all -> 0x005c }
            throw r1     // Catch:{ all -> 0x005c }
        L_0x005c:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005c }
            throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.service.channel.p593c.C7032a.C7033a.read():int");
        }

        public int read(byte[] bArr) {
            return read(bArr, 0, bArr.length);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            java.lang.Thread.sleep(100);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0074, code lost:
            throw new java.io.IOException("Blocking read operation interrupted.");
     */
        public int read(byte[] r6, int r7, int r8) {
            /*
            r5 = this;
        L_0x0000:
            com.tencent.android.tpush.service.channel.c.a r0 = com.tencent.android.tpush.service.channel.p593c.C7032a.this
            monitor-enter(r0)
            com.tencent.android.tpush.service.channel.c.a r1 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x007d }
            boolean r1 = r1.f23382i     // Catch:{ all -> 0x007d }
            if (r1 != 0) goto L_0x0075
            com.tencent.android.tpush.service.channel.c.a r1 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x007d }
            int r1 = r1.m30075g()     // Catch:{ all -> 0x007d }
            if (r1 <= 0) goto L_0x005d
            int r8 = java.lang.Math.min(r8, r1)     // Catch:{ all -> 0x007d }
            com.tencent.android.tpush.service.channel.c.a r1 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x007d }
            byte[] r1 = r1.f23374a     // Catch:{ all -> 0x007d }
            int r1 = r1.length     // Catch:{ all -> 0x007d }
            com.tencent.android.tpush.service.channel.c.a r2 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x007d }
            int r2 = r2.f23375b     // Catch:{ all -> 0x007d }
            int r1 = r1 - r2
            int r1 = java.lang.Math.min(r8, r1)     // Catch:{ all -> 0x007d }
            int r2 = r8 - r1
            com.tencent.android.tpush.service.channel.c.a r3 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x007d }
            byte[] r3 = r3.f23374a     // Catch:{ all -> 0x007d }
            com.tencent.android.tpush.service.channel.c.a r4 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x007d }
            int r4 = r4.f23375b     // Catch:{ all -> 0x007d }
            java.lang.System.arraycopy(r3, r4, r6, r7, r1)     // Catch:{ all -> 0x007d }
            r3 = 0
            if (r2 <= 0) goto L_0x0040
            com.tencent.android.tpush.service.channel.c.a r4 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x007d }
            byte[] r4 = r4.f23374a     // Catch:{ all -> 0x007d }
            int r7 = r7 + r1
            java.lang.System.arraycopy(r4, r3, r6, r7, r2)     // Catch:{ all -> 0x007d }
            com.tencent.android.tpush.service.channel.c.a r6 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x007d }
            r6.f23375b = r2     // Catch:{ all -> 0x007d }
            goto L_0x0047
        L_0x0040:
            com.tencent.android.tpush.service.channel.c.a r6 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x007d }
            int r7 = r6.f23375b     // Catch:{ all -> 0x007d }
            int r7 = r7 + r8
            r6.f23375b = r7     // Catch:{ all -> 0x007d }
        L_0x0047:
            com.tencent.android.tpush.service.channel.c.a r6 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x007d }
            int r6 = r6.f23375b     // Catch:{ all -> 0x007d }
            com.tencent.android.tpush.service.channel.c.a r7 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x007d }
            byte[] r7 = r7.f23374a     // Catch:{ all -> 0x007d }
            int r7 = r7.length     // Catch:{ all -> 0x007d }
            if (r6 != r7) goto L_0x0056
            com.tencent.android.tpush.service.channel.c.a r6 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x007d }
            r6.f23375b = r3     // Catch:{ all -> 0x007d }
        L_0x0056:
            com.tencent.android.tpush.service.channel.c.a r6 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x007d }
            r6.m30077i()     // Catch:{ all -> 0x007d }
            monitor-exit(r0)     // Catch:{ all -> 0x007d }
            return r8
        L_0x005d:
            com.tencent.android.tpush.service.channel.c.a r1 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x007d }
            boolean r1 = r1.f23384k     // Catch:{ all -> 0x007d }
            if (r1 == 0) goto L_0x0066
            r6 = -1
            monitor-exit(r0)     // Catch:{ all -> 0x007d }
            return r6
        L_0x0066:
            monitor-exit(r0)     // Catch:{ all -> 0x007d }
            r0 = 100
            java.lang.Thread.sleep(r0)     // Catch:{ Exception -> 0x006d }
            goto L_0x0000
        L_0x006d:
            java.io.IOException r6 = new java.io.IOException
            java.lang.String r7 = "Blocking read operation interrupted."
            r6.<init>(r7)
            throw r6
        L_0x0075:
            java.io.IOException r6 = new java.io.IOException     // Catch:{ all -> 0x007d }
            java.lang.String r7 = "InputStream has been closed; cannot read from a closed InputStream."
            r6.<init>(r7)     // Catch:{ all -> 0x007d }
            throw r6     // Catch:{ all -> 0x007d }
        L_0x007d:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x007d }
            throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.service.channel.p593c.C7032a.C7033a.read(byte[], int, int):int");
        }

        public void reset() {
            synchronized (C7032a.this) {
                if (!C7032a.this.f23382i) {
                    C7032a.this.f23375b = C7032a.this.f23377d;
                } else {
                    throw new IOException("InputStream has been closed; cannot reset a closed InputStream.");
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            java.lang.Thread.sleep(100);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0064, code lost:
            throw new java.io.IOException("Blocking read operation interrupted.");
     */
        public long skip(long r3) {
            /*
            r2 = this;
        L_0x0000:
            com.tencent.android.tpush.service.channel.c.a r0 = com.tencent.android.tpush.service.channel.p593c.C7032a.this
            monitor-enter(r0)
            com.tencent.android.tpush.service.channel.c.a r1 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x006d }
            boolean r1 = r1.f23382i     // Catch:{ all -> 0x006d }
            if (r1 != 0) goto L_0x0065
            com.tencent.android.tpush.service.channel.c.a r1 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x006d }
            int r1 = r1.m30075g()     // Catch:{ all -> 0x006d }
            if (r1 <= 0) goto L_0x004c
            int r4 = (int) r3     // Catch:{ all -> 0x006d }
            int r3 = java.lang.Math.min(r4, r1)     // Catch:{ all -> 0x006d }
            com.tencent.android.tpush.service.channel.c.a r4 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x006d }
            byte[] r4 = r4.f23374a     // Catch:{ all -> 0x006d }
            int r4 = r4.length     // Catch:{ all -> 0x006d }
            com.tencent.android.tpush.service.channel.c.a r1 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x006d }
            int r1 = r1.f23375b     // Catch:{ all -> 0x006d }
            int r4 = r4 - r1
            int r4 = java.lang.Math.min(r3, r4)     // Catch:{ all -> 0x006d }
            int r4 = r3 - r4
            if (r4 <= 0) goto L_0x002d
            com.tencent.android.tpush.service.channel.c.a r1 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x006d }
            r1.f23375b = r4     // Catch:{ all -> 0x006d }
            goto L_0x0034
        L_0x002d:
            com.tencent.android.tpush.service.channel.c.a r4 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x006d }
            int r1 = r4.f23375b     // Catch:{ all -> 0x006d }
            int r1 = r1 + r3
            r4.f23375b = r1     // Catch:{ all -> 0x006d }
        L_0x0034:
            com.tencent.android.tpush.service.channel.c.a r4 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x006d }
            int r4 = r4.f23375b     // Catch:{ all -> 0x006d }
            com.tencent.android.tpush.service.channel.c.a r1 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x006d }
            byte[] r1 = r1.f23374a     // Catch:{ all -> 0x006d }
            int r1 = r1.length     // Catch:{ all -> 0x006d }
            if (r4 != r1) goto L_0x0044
            com.tencent.android.tpush.service.channel.c.a r4 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x006d }
            r1 = 0
            r4.f23375b = r1     // Catch:{ all -> 0x006d }
        L_0x0044:
            com.tencent.android.tpush.service.channel.c.a r4 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x006d }
            r4.m30077i()     // Catch:{ all -> 0x006d }
            long r3 = (long) r3     // Catch:{ all -> 0x006d }
            monitor-exit(r0)     // Catch:{ all -> 0x006d }
            return r3
        L_0x004c:
            com.tencent.android.tpush.service.channel.c.a r1 = com.tencent.android.tpush.service.channel.p593c.C7032a.this     // Catch:{ all -> 0x006d }
            boolean r1 = r1.f23384k     // Catch:{ all -> 0x006d }
            if (r1 == 0) goto L_0x0056
            r3 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x006d }
            return r3
        L_0x0056:
            monitor-exit(r0)     // Catch:{ all -> 0x006d }
            r0 = 100
            java.lang.Thread.sleep(r0)     // Catch:{ Exception -> 0x005d }
            goto L_0x0000
        L_0x005d:
            java.io.IOException r3 = new java.io.IOException
            java.lang.String r4 = "Blocking read operation interrupted."
            r3.<init>(r4)
            throw r3
        L_0x0065:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x006d }
            java.lang.String r4 = "InputStream has been closed; cannot skip bytes on a closed InputStream."
            r3.<init>(r4)     // Catch:{ all -> 0x006d }
            throw r3     // Catch:{ all -> 0x006d }
        L_0x006d:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006d }
            throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.service.channel.p593c.C7032a.C7033a.skip(long):long");
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.service.channel.c.a$b */
    protected class C7034b extends OutputStream {
        protected C7034b() {
        }

        public void close() {
            synchronized (C7032a.this) {
                if (!C7032a.this.f23384k) {
                    flush();
                }
                C7032a.this.f23384k = true;
            }
        }

        public void flush() {
            if (C7032a.this.f23384k) {
                throw new IOException("OutputStream has been closed; cannot flush a closed OutputStream.");
            } else if (C7032a.this.f23382i) {
                throw new IOException("Buffer closed by inputStream; cannot flush.");
            }
        }

        public void write(byte[] bArr) {
            write(bArr, 0, bArr.length);
        }

        public void write(byte[] bArr, int i, int i2) {
            while (i2 > 0) {
                synchronized (C7032a.this) {
                    if (C7032a.this.f23384k) {
                        throw new IOException("OutputStream has been closed; cannot write to a closed OutputStream.");
                    } else if (!C7032a.this.f23382i) {
                        int c = C7032a.this.m30074f();
                        while (C7032a.this.f23379f && c < i2) {
                            C7032a.this.m30073e();
                            c = C7032a.this.m30074f();
                        }
                        if (!C7032a.this.f23380g) {
                            if (c < i2) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("CircularByteBuffer is full; cannot write ");
                                sb.append(i2);
                                sb.append(" bytes");
                                throw new IORefusedException(sb.toString());
                            }
                        }
                        int min = Math.min(i2, c);
                        int min2 = Math.min(min, C7032a.this.f23374a.length - C7032a.this.f23376c);
                        int min3 = Math.min(min - min2, (C7032a.this.f23374a.length - C7032a.this.f23377d) - 1);
                        int i3 = min2 + min3;
                        if (min2 > 0) {
                            System.arraycopy(bArr, i, C7032a.this.f23374a, C7032a.this.f23376c, min2);
                        }
                        if (min3 > 0) {
                            System.arraycopy(bArr, min2 + i, C7032a.this.f23374a, 0, min3);
                            C7032a.this.f23376c = min3;
                        } else {
                            C7032a.this.f23376c += i3;
                        }
                        if (C7032a.this.f23376c == C7032a.this.f23374a.length) {
                            C7032a.this.f23376c = 0;
                        }
                        i += i3;
                        i2 -= i3;
                    } else {
                        throw new IOException("Buffer closed by InputStream; cannot write to a closed buffer.");
                    }
                }
                if (i2 > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception unused) {
                        throw new IOException("Waiting for available space in buffer interrupted.");
                    }
                }
            }
        }

        public void write(int i) {
            boolean z = false;
            while (!z) {
                synchronized (C7032a.this) {
                    if (C7032a.this.f23384k) {
                        throw new IOException("OutputStream has been closed; cannot write to a closed OutputStream.");
                    } else if (!C7032a.this.f23382i) {
                        int c = C7032a.this.m30074f();
                        while (C7032a.this.f23379f && c < 1) {
                            C7032a.this.m30073e();
                            c = C7032a.this.m30074f();
                        }
                        if (!C7032a.this.f23380g) {
                            if (c < 1) {
                                throw new IORefusedException("CircularByteBuffer is full; cannot write 1 byte");
                            }
                        }
                        if (c > 0) {
                            C7032a.this.f23374a[C7032a.this.f23376c] = (byte) (i & 255);
                            C7032a.this.f23376c++;
                            if (C7032a.this.f23376c == C7032a.this.f23374a.length) {
                                C7032a.this.f23376c = 0;
                            }
                            z = true;
                        }
                    } else {
                        throw new IOException("Buffer closed by InputStream; cannot write to a closed buffer.");
                    }
                }
                if (!z) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception unused) {
                        throw new IOException("Waiting for available space in buffer interrupted.");
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public OutputStream mo33460a() {
        return this.f23383j;
    }

    /* renamed from: b */
    public InputStream mo33461b() {
        return this.f23381h;
    }

    /* renamed from: c */
    public int mo33462c() {
        int g;
        synchronized (this) {
            g = m30075g();
        }
        return g;
    }

    /* renamed from: d */
    public int mo33463d() {
        int f;
        synchronized (this) {
            f = m30074f();
        }
        return f;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m30073e() {
        byte[] bArr = new byte[(this.f23374a.length * 2)];
        int h = m30076h();
        int g = m30075g();
        if (this.f23377d <= this.f23376c) {
            System.arraycopy(this.f23374a, this.f23377d, bArr, 0, this.f23376c - this.f23377d);
        } else {
            int length = this.f23374a.length - this.f23377d;
            System.arraycopy(this.f23374a, this.f23377d, bArr, 0, length);
            System.arraycopy(this.f23374a, 0, bArr, length, this.f23376c);
        }
        this.f23374a = bArr;
        this.f23377d = 0;
        this.f23375b = h;
        this.f23376c = h + g;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public int m30074f() {
        if (this.f23376c < this.f23377d) {
            return (this.f23377d - this.f23376c) - 1;
        }
        return (this.f23374a.length - 1) - (this.f23376c - this.f23377d);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public int m30075g() {
        int length;
        int i;
        if (this.f23375b <= this.f23376c) {
            length = this.f23376c;
            i = this.f23375b;
        } else {
            length = this.f23374a.length;
            i = this.f23375b - this.f23376c;
        }
        return length - i;
    }

    /* renamed from: h */
    private int m30076h() {
        int length;
        int i;
        if (this.f23377d <= this.f23375b) {
            length = this.f23375b;
            i = this.f23377d;
        } else {
            length = this.f23374a.length;
            i = this.f23377d - this.f23375b;
        }
        return length - i;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m30077i() {
        if (m30076h() >= this.f23378e) {
            this.f23377d = this.f23375b;
            this.f23378e = 0;
        }
    }

    public C7032a() {
        this(4096, true);
    }

    public C7032a(int i, boolean z) {
        this.f23375b = 0;
        this.f23376c = 0;
        this.f23377d = 0;
        this.f23378e = 0;
        this.f23379f = false;
        this.f23380g = true;
        this.f23381h = new C7033a();
        this.f23382i = false;
        this.f23383j = new C7034b();
        this.f23384k = false;
        if (i == -1) {
            this.f23374a = new byte[4096];
            this.f23379f = true;
        } else {
            this.f23374a = new byte[i];
            this.f23379f = false;
        }
        this.f23380g = z;
    }
}
