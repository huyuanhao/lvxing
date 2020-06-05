package com.kwad.sdk.core.diskcache.p321a;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* renamed from: com.kwad.sdk.core.diskcache.a.a */
public final class C4070a implements Closeable {
    /* renamed from: a */
    static final Pattern f13683a = Pattern.compile("[a-z0-9_-]{1,120}");
    /* access modifiers changed from: private|static|final */
    /* renamed from: p */
    public static final OutputStream f13684p = new OutputStream() {
        public void write(int i) {
        }
    };
    /* renamed from: b */
    final ThreadPoolExecutor f13685b;
    /* access modifiers changed from: private|final */
    /* renamed from: c */
    public final File f13686c;
    /* renamed from: d */
    private final File f13687d;
    /* renamed from: e */
    private final File f13688e;
    /* renamed from: f */
    private final File f13689f;
    /* renamed from: g */
    private final int f13690g;
    /* renamed from: h */
    private long f13691h;
    /* access modifiers changed from: private|final */
    /* renamed from: i */
    public final int f13692i;
    /* renamed from: j */
    private long f13693j = 0;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public Writer f13694k;
    /* renamed from: l */
    private final LinkedHashMap<String, C4075b> f13695l = new LinkedHashMap<>(0, 0.75f, true);
    /* access modifiers changed from: private */
    /* renamed from: m */
    public int f13696m;
    /* renamed from: n */
    private long f13697n = 0;
    /* renamed from: o */
    private final Callable<Void> f13698o;

    /* renamed from: com.kwad.sdk.core.diskcache.a.a$a */
    public final class C4073a {
        /* access modifiers changed from: private|final */
        /* renamed from: b */
        public final C4075b f13701b;
        /* access modifiers changed from: private|final */
        /* renamed from: c */
        public final boolean[] f13702c;
        /* access modifiers changed from: private */
        /* renamed from: d */
        public boolean f13703d;
        /* renamed from: e */
        private boolean f13704e;

        /* renamed from: com.kwad.sdk.core.diskcache.a.a$a$a */
        private class C4074a extends FilterOutputStream {
            private C4074a(OutputStream outputStream) {
                super(outputStream);
            }

            public void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    C4073a.this.f13703d = true;
                }
            }

            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    C4073a.this.f13703d = true;
                }
            }

            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException unused) {
                    C4073a.this.f13703d = true;
                }
            }

            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException unused) {
                    C4073a.this.f13703d = true;
                }
            }
        }

        private C4073a(C4075b bVar) {
            this.f13701b = bVar;
            this.f13702c = bVar.f13709d ? null : new boolean[C4070a.this.f13692i];
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002e */
        /* renamed from: a */
        public java.io.OutputStream mo23744a(int r4) {
            /*
            r3 = this;
            if (r4 < 0) goto L_0x0053
            com.kwad.sdk.core.diskcache.a.a r0 = com.kwad.sdk.core.diskcache.p321a.C4070a.this
            int r0 = r0.f13692i
            if (r4 >= r0) goto L_0x0053
            com.kwad.sdk.core.diskcache.a.a r0 = com.kwad.sdk.core.diskcache.p321a.C4070a.this
            monitor-enter(r0)
            com.kwad.sdk.core.diskcache.a.a$b r1 = r3.f13701b     // Catch:{ all -> 0x0050 }
            com.kwad.sdk.core.diskcache.a.a$a r1 = r1.f13710e     // Catch:{ all -> 0x0050 }
            if (r1 != r3) goto L_0x004a
            com.kwad.sdk.core.diskcache.a.a$b r1 = r3.f13701b     // Catch:{ all -> 0x0050 }
            boolean r1 = r1.f13709d     // Catch:{ all -> 0x0050 }
            if (r1 != 0) goto L_0x0022
            boolean[] r1 = r3.f13702c     // Catch:{ all -> 0x0050 }
            r2 = 1
            r1[r4] = r2     // Catch:{ all -> 0x0050 }
        L_0x0022:
            com.kwad.sdk.core.diskcache.a.a$b r1 = r3.f13701b     // Catch:{ all -> 0x0050 }
            java.io.File r4 = r1.mo23753b(r4)     // Catch:{ all -> 0x0050 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x002e }
            r1.<init>(r4)     // Catch:{ FileNotFoundException -> 0x002e }
            goto L_0x003c
        L_0x002e:
            com.kwad.sdk.core.diskcache.a.a r1 = com.kwad.sdk.core.diskcache.p321a.C4070a.this     // Catch:{ all -> 0x0050 }
            java.io.File r1 = r1.f13686c     // Catch:{ all -> 0x0050 }
            r1.mkdirs()     // Catch:{ all -> 0x0050 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0044 }
            r1.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0044 }
        L_0x003c:
            com.kwad.sdk.core.diskcache.a.a$a$a r4 = new com.kwad.sdk.core.diskcache.a.a$a$a     // Catch:{ all -> 0x0050 }
            r2 = 0
            r4.m47884init(r1)     // Catch:{ all -> 0x0050 }
            monitor-exit(r0)     // Catch:{ all -> 0x0050 }
            return r4
        L_0x0044:
            java.io.OutputStream r4 = com.kwad.sdk.core.diskcache.p321a.C4070a.f13684p     // Catch:{ all -> 0x0050 }
            monitor-exit(r0)     // Catch:{ all -> 0x0050 }
            return r4
        L_0x004a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0050 }
            r4.<init>()     // Catch:{ all -> 0x0050 }
            throw r4     // Catch:{ all -> 0x0050 }
        L_0x0050:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0050 }
            throw r4
        L_0x0053:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected index "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = " to be greater than 0 and less than the maximum value count of "
            r1.append(r4)
            com.kwad.sdk.core.diskcache.a.a r4 = com.kwad.sdk.core.diskcache.p321a.C4070a.this
            int r4 = r4.f13692i
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.diskcache.p321a.C4070a.C4073a.mo23744a(int):java.io.OutputStream");
        }

        /* renamed from: a */
        public void mo23745a() {
            if (this.f13703d) {
                C4070a.this.m16897a(this, false);
                C4070a.this.mo23738b(this.f13701b.f13707b);
            } else {
                C4070a.this.m16897a(this, true);
            }
            this.f13704e = true;
        }

        /* renamed from: b */
        public void mo23746b() {
            C4070a.this.m16897a(this, false);
        }
    }

    /* renamed from: com.kwad.sdk.core.diskcache.a.a$b */
    private final class C4075b {
        /* access modifiers changed from: private|final */
        /* renamed from: b */
        public final String f13707b;
        /* access modifiers changed from: private|final */
        /* renamed from: c */
        public final long[] f13708c;
        /* access modifiers changed from: private */
        /* renamed from: d */
        public boolean f13709d;
        /* access modifiers changed from: private */
        /* renamed from: e */
        public C4073a f13710e;
        /* access modifiers changed from: private */
        /* renamed from: f */
        public long f13711f;

        private C4075b(String str) {
            this.f13707b = str;
            this.f13708c = new long[C4070a.this.f13692i];
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m16931a(String[] strArr) {
            if (strArr.length == C4070a.this.f13692i) {
                int i = 0;
                while (i < strArr.length) {
                    try {
                        this.f13708c[i] = Long.parseLong(strArr[i]);
                        i++;
                    } catch (NumberFormatException unused) {
                        throw m16933b(strArr);
                    }
                }
                return;
            }
            throw m16933b(strArr);
        }

        /* renamed from: b */
        private IOException m16933b(String[] strArr) {
            StringBuilder sb = new StringBuilder();
            sb.append("unexpected journal line: ");
            sb.append(Arrays.toString(strArr));
            throw new IOException(sb.toString());
        }

        /* renamed from: a */
        public File mo23751a(int i) {
            return new File(C4070a.this.f13686c, this.f13707b);
        }

        /* renamed from: a */
        public String mo23752a() {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j : this.f13708c) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        /* renamed from: b */
        public File mo23753b(int i) {
            File f = C4070a.this.f13686c;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f13707b);
            sb.append(".tmp");
            return new File(f, sb.toString());
        }
    }

    private C4070a(File file, int i, int i2, long j) {
        File file2 = file;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f13685b = threadPoolExecutor;
        this.f13698o = new Callable<Void>() {
            /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
            return null;
     */
            /* renamed from: a */
            public java.lang.Void call() {
                /*
                r4 = this;
                com.kwad.sdk.core.diskcache.a.a r0 = com.kwad.sdk.core.diskcache.p321a.C4070a.this
                monitor-enter(r0)
                com.kwad.sdk.core.diskcache.a.a r1 = com.kwad.sdk.core.diskcache.p321a.C4070a.this     // Catch:{ all -> 0x0028 }
                java.io.Writer r1 = r1.f13694k     // Catch:{ all -> 0x0028 }
                r2 = 0
                if (r1 != 0) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x000e:
                com.kwad.sdk.core.diskcache.a.a r1 = com.kwad.sdk.core.diskcache.p321a.C4070a.this     // Catch:{ all -> 0x0028 }
                r1.m16914j()     // Catch:{ all -> 0x0028 }
                com.kwad.sdk.core.diskcache.a.a r1 = com.kwad.sdk.core.diskcache.p321a.C4070a.this     // Catch:{ all -> 0x0028 }
                boolean r1 = r1.m16912h()     // Catch:{ all -> 0x0028 }
                if (r1 == 0) goto L_0x0026
                com.kwad.sdk.core.diskcache.a.a r1 = com.kwad.sdk.core.diskcache.p321a.C4070a.this     // Catch:{ all -> 0x0028 }
                r1.m16911g()     // Catch:{ all -> 0x0028 }
                com.kwad.sdk.core.diskcache.a.a r1 = com.kwad.sdk.core.diskcache.p321a.C4070a.this     // Catch:{ all -> 0x0028 }
                r3 = 0
                r1.f13696m = r3     // Catch:{ all -> 0x0028 }
            L_0x0026:
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x0028:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.diskcache.p321a.C4070a.C40711.call():java.lang.Void");
            }
        };
        this.f13686c = file2;
        this.f13690g = i;
        this.f13687d = new File(file2, "journal");
        this.f13688e = new File(file2, "journal.tmp");
        this.f13689f = new File(file2, "journal.bkp");
        this.f13692i = i2;
        this.f13691h = j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
            return null;
     */
    /* renamed from: a */
    private synchronized com.kwad.sdk.core.diskcache.p321a.C4070a.C4073a m16894a(java.lang.String r6, long r7) {
        /*
        r5 = this;
        monitor-enter(r5)
        r5.m16913i()     // Catch:{ all -> 0x0061 }
        r5.m16906d(r6)     // Catch:{ all -> 0x0061 }
        java.util.LinkedHashMap<java.lang.String, com.kwad.sdk.core.diskcache.a.a$b> r0 = r5.f13695l     // Catch:{ all -> 0x0061 }
        java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0061 }
        com.kwad.sdk.core.diskcache.a.a$b r0 = (com.kwad.sdk.core.diskcache.p321a.C4070a.C4075b) r0     // Catch:{ all -> 0x0061 }
        r1 = -1
        r3 = 0
        int r4 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
        if (r4 == 0) goto L_0x0022
        if (r0 == 0) goto L_0x0020
        long r1 = r0.f13711f     // Catch:{ all -> 0x0061 }
        int r4 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
        if (r4 == 0) goto L_0x0022
    L_0x0020:
        monitor-exit(r5)
        return r3
    L_0x0022:
        if (r0 != 0) goto L_0x002f
        com.kwad.sdk.core.diskcache.a.a$b r0 = new com.kwad.sdk.core.diskcache.a.a$b     // Catch:{ all -> 0x0061 }
        r0.m47886init(r6)     // Catch:{ all -> 0x0061 }
        java.util.LinkedHashMap<java.lang.String, com.kwad.sdk.core.diskcache.a.a$b> r7 = r5.f13695l     // Catch:{ all -> 0x0061 }
        r7.put(r6, r0)     // Catch:{ all -> 0x0061 }
        goto L_0x0037
    L_0x002f:
        com.kwad.sdk.core.diskcache.a.a$a r7 = r0.f13710e     // Catch:{ all -> 0x0061 }
        if (r7 == 0) goto L_0x0037
        monitor-exit(r5)
        return r3
    L_0x0037:
        com.kwad.sdk.core.diskcache.a.a$a r7 = new com.kwad.sdk.core.diskcache.a.a$a     // Catch:{ all -> 0x0061 }
        r7.m47882init(r0)     // Catch:{ all -> 0x0061 }
        r0.f13710e = r7     // Catch:{ all -> 0x0061 }
        java.io.Writer r8 = r5.f13694k     // Catch:{ all -> 0x0061 }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
        r0.<init>()     // Catch:{ all -> 0x0061 }
        java.lang.String r1 = "DIRTY "
        r0.append(r1)     // Catch:{ all -> 0x0061 }
        r0.append(r6)     // Catch:{ all -> 0x0061 }
        r6 = 10
        r0.append(r6)     // Catch:{ all -> 0x0061 }
        java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x0061 }
        r8.write(r6)     // Catch:{ all -> 0x0061 }
        java.io.Writer r6 = r5.f13694k     // Catch:{ all -> 0x0061 }
        r6.flush()     // Catch:{ all -> 0x0061 }
        monitor-exit(r5)
        return r7
    L_0x0061:
        r6 = move-exception
        monitor-exit(r5)
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.diskcache.p321a.C4070a.m16894a(java.lang.String, long):com.kwad.sdk.core.diskcache.a.a$a");
    }

    /* renamed from: a */
    public static C4070a m16895a(File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    m16900a(file2, file3, false);
                }
            }
            C4070a aVar = new C4070a(file, i, i2, j);
            if (aVar.f13687d.exists()) {
                try {
                    aVar.m16908e();
                    aVar.m16910f();
                    return aVar;
                } catch (IOException e) {
                    PrintStream printStream = System.out;
                    StringBuilder sb = new StringBuilder();
                    sb.append("DiskLruCache ");
                    sb.append(file);
                    sb.append(" is corrupt: ");
                    sb.append(e.getMessage());
                    sb.append(", removing");
                    printStream.println(sb.toString());
                    aVar.mo23739c();
                }
            }
            file.mkdirs();
            C4070a aVar2 = new C4070a(file, i, i2, j);
            aVar2.m16911g();
            return aVar2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0109, code lost:
            return;
     */
    /* renamed from: a */
    public synchronized void m16897a(com.kwad.sdk.core.diskcache.p321a.C4070a.C4073a r10, boolean r11) {
        /*
        r9 = this;
        monitor-enter(r9)
        com.kwad.sdk.core.diskcache.a.a$b r0 = r10.f13701b     // Catch:{ all -> 0x0110 }
        com.kwad.sdk.core.diskcache.a.a$a r1 = r0.f13710e     // Catch:{ all -> 0x0110 }
        if (r1 != r10) goto L_0x010a
        r1 = 0
        if (r11 == 0) goto L_0x004d
        boolean r2 = r0.f13709d     // Catch:{ all -> 0x0110 }
        if (r2 != 0) goto L_0x004d
        r2 = 0
    L_0x0015:
        int r3 = r9.f13692i     // Catch:{ all -> 0x0110 }
        if (r2 >= r3) goto L_0x004d
        boolean[] r3 = r10.f13702c     // Catch:{ all -> 0x0110 }
        boolean r3 = r3[r2]     // Catch:{ all -> 0x0110 }
        if (r3 == 0) goto L_0x0033
        java.io.File r3 = r0.mo23753b(r2)     // Catch:{ all -> 0x0110 }
        boolean r3 = r3.exists()     // Catch:{ all -> 0x0110 }
        if (r3 != 0) goto L_0x0030
        r10.mo23746b()     // Catch:{ all -> 0x0110 }
        monitor-exit(r9)
        return
    L_0x0030:
        int r2 = r2 + 1
        goto L_0x0015
    L_0x0033:
        r10.mo23746b()     // Catch:{ all -> 0x0110 }
        java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0110 }
        java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0110 }
        r11.<init>()     // Catch:{ all -> 0x0110 }
        java.lang.String r0 = "Newly created entry didn't create value for index "
        r11.append(r0)     // Catch:{ all -> 0x0110 }
        r11.append(r2)     // Catch:{ all -> 0x0110 }
        java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0110 }
        r10.<init>(r11)     // Catch:{ all -> 0x0110 }
        throw r10     // Catch:{ all -> 0x0110 }
    L_0x004d:
        int r10 = r9.f13692i     // Catch:{ all -> 0x0110 }
        if (r1 >= r10) goto L_0x0081
        java.io.File r10 = r0.mo23753b(r1)     // Catch:{ all -> 0x0110 }
        if (r11 == 0) goto L_0x007b
        boolean r2 = r10.exists()     // Catch:{ all -> 0x0110 }
        if (r2 == 0) goto L_0x007e
        java.io.File r2 = r0.mo23751a(r1)     // Catch:{ all -> 0x0110 }
        r10.renameTo(r2)     // Catch:{ all -> 0x0110 }
        long[] r10 = r0.f13708c     // Catch:{ all -> 0x0110 }
        r3 = r10[r1]     // Catch:{ all -> 0x0110 }
        long r5 = r2.length()     // Catch:{ all -> 0x0110 }
        long[] r10 = r0.f13708c     // Catch:{ all -> 0x0110 }
        r10[r1] = r5     // Catch:{ all -> 0x0110 }
        long r7 = r9.f13693j     // Catch:{ all -> 0x0110 }
        long r7 = r7 - r3
        long r7 = r7 + r5
        r9.f13693j = r7     // Catch:{ all -> 0x0110 }
        goto L_0x007e
    L_0x007b:
        m16899a(r10)     // Catch:{ all -> 0x0110 }
    L_0x007e:
        int r1 = r1 + 1
        goto L_0x004d
    L_0x0081:
        int r10 = r9.f13696m     // Catch:{ all -> 0x0110 }
        r1 = 1
        int r10 = r10 + r1
        r9.f13696m = r10     // Catch:{ all -> 0x0110 }
        r10 = 0
        r0.f13710e = r10     // Catch:{ all -> 0x0110 }
        boolean r10 = r0.f13709d     // Catch:{ all -> 0x0110 }
        r10 = r10 | r11
        r2 = 10
        if (r10 == 0) goto L_0x00c8
        r0.f13709d = r1     // Catch:{ all -> 0x0110 }
        java.io.Writer r10 = r9.f13694k     // Catch:{ all -> 0x0110 }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0110 }
        r1.<init>()     // Catch:{ all -> 0x0110 }
        java.lang.String r3 = "CLEAN "
        r1.append(r3)     // Catch:{ all -> 0x0110 }
        java.lang.String r3 = r0.f13707b     // Catch:{ all -> 0x0110 }
        r1.append(r3)     // Catch:{ all -> 0x0110 }
        java.lang.String r3 = r0.mo23752a()     // Catch:{ all -> 0x0110 }
        r1.append(r3)     // Catch:{ all -> 0x0110 }
        r1.append(r2)     // Catch:{ all -> 0x0110 }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0110 }
        r10.write(r1)     // Catch:{ all -> 0x0110 }
        if (r11 == 0) goto L_0x00ee
        long r10 = r9.f13697n     // Catch:{ all -> 0x0110 }
        r1 = 1
        long r1 = r1 + r10
        r9.f13697n = r1     // Catch:{ all -> 0x0110 }
        r0.f13711f = r10     // Catch:{ all -> 0x0110 }
        goto L_0x00ee
    L_0x00c8:
        java.util.LinkedHashMap<java.lang.String, com.kwad.sdk.core.diskcache.a.a$b> r10 = r9.f13695l     // Catch:{ all -> 0x0110 }
        java.lang.String r11 = r0.f13707b     // Catch:{ all -> 0x0110 }
        r10.remove(r11)     // Catch:{ all -> 0x0110 }
        java.io.Writer r10 = r9.f13694k     // Catch:{ all -> 0x0110 }
        java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0110 }
        r11.<init>()     // Catch:{ all -> 0x0110 }
        java.lang.String r1 = "REMOVE "
        r11.append(r1)     // Catch:{ all -> 0x0110 }
        java.lang.String r0 = r0.f13707b     // Catch:{ all -> 0x0110 }
        r11.append(r0)     // Catch:{ all -> 0x0110 }
        r11.append(r2)     // Catch:{ all -> 0x0110 }
        java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0110 }
        r10.write(r11)     // Catch:{ all -> 0x0110 }
    L_0x00ee:
        java.io.Writer r10 = r9.f13694k     // Catch:{ all -> 0x0110 }
        r10.flush()     // Catch:{ all -> 0x0110 }
        long r10 = r9.f13693j     // Catch:{ all -> 0x0110 }
        long r0 = r9.f13691h     // Catch:{ all -> 0x0110 }
        int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
        if (r2 > 0) goto L_0x0101
        boolean r10 = r9.m16912h()     // Catch:{ all -> 0x0110 }
        if (r10 == 0) goto L_0x0108
    L_0x0101:
        java.util.concurrent.ThreadPoolExecutor r10 = r9.f13685b     // Catch:{ all -> 0x0110 }
        java.util.concurrent.Callable<java.lang.Void> r11 = r9.f13698o     // Catch:{ all -> 0x0110 }
        r10.submit(r11)     // Catch:{ all -> 0x0110 }
    L_0x0108:
        monitor-exit(r9)
        return
    L_0x010a:
        java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0110 }
        r10.<init>()     // Catch:{ all -> 0x0110 }
        throw r10     // Catch:{ all -> 0x0110 }
    L_0x0110:
        r10 = move-exception
        monitor-exit(r9)
        throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.diskcache.p321a.C4070a.m16897a(com.kwad.sdk.core.diskcache.a.a$a, boolean):void");
    }

    /* renamed from: a */
    private static void m16899a(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* renamed from: a */
    private static void m16900a(File file, File file2, boolean z) {
        if (z) {
            m16899a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* renamed from: c */
    private void m16902c(String str) {
        String str2;
        int indexOf = str.indexOf(32);
        String str3 = "unexpected journal line: ";
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                str2 = str.substring(i);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f13695l.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i, indexOf2);
            }
            C4075b bVar = (C4075b) this.f13695l.get(str2);
            if (bVar == null) {
                bVar = new C4075b(str2);
                this.f13695l.put(str2, bVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                bVar.f13709d = true;
                bVar.f13710e = null;
                bVar.m16931a(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                bVar.f13710e = new C4073a(bVar);
            } else if (!(indexOf2 == -1 && indexOf == 4 && str.startsWith("READ"))) {
                StringBuilder sb = new StringBuilder();
                sb.append(str3);
                sb.append(str);
                throw new IOException(sb.toString());
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str3);
        sb2.append(str);
        throw new IOException(sb2.toString());
    }

    /* renamed from: d */
    private void m16906d(String str) {
        if (!f13683a.matcher(str).matches()) {
            StringBuilder sb = new StringBuilder();
            sb.append("keys must match regex [a-z0-9_-]{1,120}: \"");
            sb.append(str);
            sb.append("\"");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|(1:19)(1:20)|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            r9.f13696m = r0 - r9.f13695l.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
            if (r1.mo23755b() != false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006e, code lost:
            m16911g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0072, code lost:
            r9.f13694k = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(r9.f13687d, true), com.kwad.sdk.core.diskcache.p321a.C4078c.f13718a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008b, code lost:
            return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005f */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x008c=Splitter:B:23:0x008c, B:16:0x005f=Splitter:B:16:0x005f} */
    /* renamed from: e */
    private void m16908e() {
        /*
        r9 = this;
        java.lang.String r0 = ", "
        com.kwad.sdk.core.diskcache.a.b r1 = new com.kwad.sdk.core.diskcache.a.b
        java.io.FileInputStream r2 = new java.io.FileInputStream
        java.io.File r3 = r9.f13687d
        r2.<init>(r3)
        java.nio.charset.Charset r3 = com.kwad.sdk.core.diskcache.p321a.C4078c.f13718a
        r1.m47888init(r2, r3)
        java.lang.String r2 = r1.mo23754a()     // Catch:{ all -> 0x00ba }
        java.lang.String r3 = r1.mo23754a()     // Catch:{ all -> 0x00ba }
        java.lang.String r4 = r1.mo23754a()     // Catch:{ all -> 0x00ba }
        java.lang.String r5 = r1.mo23754a()     // Catch:{ all -> 0x00ba }
        java.lang.String r6 = r1.mo23754a()     // Catch:{ all -> 0x00ba }
        java.lang.String r7 = "libcore.io.DiskLruCache"
        boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x00ba }
        if (r7 == 0) goto L_0x008c
        java.lang.String r7 = "1"
        boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x00ba }
        if (r7 == 0) goto L_0x008c
        int r7 = r9.f13690g     // Catch:{ all -> 0x00ba }
        java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x00ba }
        boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x00ba }
        if (r4 == 0) goto L_0x008c
        int r4 = r9.f13692i     // Catch:{ all -> 0x00ba }
        java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x00ba }
        boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00ba }
        if (r4 == 0) goto L_0x008c
        java.lang.String r4 = ""
        boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x00ba }
        if (r4 == 0) goto L_0x008c
        r0 = 0
    L_0x0055:
        java.lang.String r2 = r1.mo23754a()     // Catch:{ EOFException -> 0x005f }
        r9.m16902c(r2)     // Catch:{ EOFException -> 0x005f }
        int r0 = r0 + 1
        goto L_0x0055
    L_0x005f:
        java.util.LinkedHashMap<java.lang.String, com.kwad.sdk.core.diskcache.a.a$b> r2 = r9.f13695l     // Catch:{ all -> 0x00ba }
        int r2 = r2.size()     // Catch:{ all -> 0x00ba }
        int r0 = r0 - r2
        r9.f13696m = r0     // Catch:{ all -> 0x00ba }
        boolean r0 = r1.mo23755b()     // Catch:{ all -> 0x00ba }
        if (r0 == 0) goto L_0x0072
        r9.m16911g()     // Catch:{ all -> 0x00ba }
        goto L_0x0088
    L_0x0072:
        java.io.BufferedWriter r0 = new java.io.BufferedWriter     // Catch:{ all -> 0x00ba }
        java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x00ba }
        java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x00ba }
        java.io.File r4 = r9.f13687d     // Catch:{ all -> 0x00ba }
        r5 = 1
        r3.<init>(r4, r5)     // Catch:{ all -> 0x00ba }
        java.nio.charset.Charset r4 = com.kwad.sdk.core.diskcache.p321a.C4078c.f13718a     // Catch:{ all -> 0x00ba }
        r2.<init>(r3, r4)     // Catch:{ all -> 0x00ba }
        r0.<init>(r2)     // Catch:{ all -> 0x00ba }
        r9.f13694k = r0     // Catch:{ all -> 0x00ba }
    L_0x0088:
        com.kwad.sdk.core.diskcache.p321a.C4078c.m16945a(r1)
        return
    L_0x008c:
        java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x00ba }
        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ba }
        r7.<init>()     // Catch:{ all -> 0x00ba }
        java.lang.String r8 = "unexpected journal header: ["
        r7.append(r8)     // Catch:{ all -> 0x00ba }
        r7.append(r2)     // Catch:{ all -> 0x00ba }
        r7.append(r0)     // Catch:{ all -> 0x00ba }
        r7.append(r3)     // Catch:{ all -> 0x00ba }
        r7.append(r0)     // Catch:{ all -> 0x00ba }
        r7.append(r5)     // Catch:{ all -> 0x00ba }
        r7.append(r0)     // Catch:{ all -> 0x00ba }
        r7.append(r6)     // Catch:{ all -> 0x00ba }
        java.lang.String r0 = "]"
        r7.append(r0)     // Catch:{ all -> 0x00ba }
        java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x00ba }
        r4.<init>(r0)     // Catch:{ all -> 0x00ba }
        throw r4     // Catch:{ all -> 0x00ba }
    L_0x00ba:
        r0 = move-exception
        com.kwad.sdk.core.diskcache.p321a.C4078c.m16945a(r1)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.diskcache.p321a.C4070a.m16908e():void");
    }

    /* renamed from: f */
    private void m16910f() {
        m16899a(this.f13688e);
        Iterator it = this.f13695l.values().iterator();
        while (it.hasNext()) {
            C4075b bVar = (C4075b) it.next();
            int i = 0;
            if (bVar.f13710e == null) {
                while (i < this.f13692i) {
                    this.f13693j += bVar.f13708c[i];
                    i++;
                }
            } else {
                bVar.f13710e = null;
                while (i < this.f13692i) {
                    m16899a(bVar.mo23751a(i));
                    m16899a(bVar.mo23753b(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private|declared_synchronized */
    /* renamed from: g */
    public synchronized void m16911g() {
        String sb;
        if (this.f13694k != null) {
            this.f13694k.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f13688e), C4078c.f13718a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f13690g));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f13692i));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (C4075b bVar : this.f13695l.values()) {
                if (bVar.f13710e != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("DIRTY ");
                    sb2.append(bVar.f13707b);
                    sb2.append(10);
                    sb = sb2.toString();
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("CLEAN ");
                    sb3.append(bVar.f13707b);
                    sb3.append(bVar.mo23752a());
                    sb3.append(10);
                    sb = sb3.toString();
                }
                bufferedWriter.write(sb);
            }
            bufferedWriter.close();
            if (this.f13687d.exists()) {
                m16900a(this.f13687d, this.f13689f, true);
            }
            m16900a(this.f13688e, this.f13687d, false);
            this.f13689f.delete();
            this.f13694k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f13687d, true), C4078c.f13718a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public boolean m16912h() {
        int i = this.f13696m;
        return i >= 2000 && i >= this.f13695l.size();
    }

    /* renamed from: i */
    private void m16913i() {
        if (this.f13694k == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m16914j() {
        while (this.f13693j > this.f13691h) {
            mo23738b((String) ((Entry) this.f13695l.entrySet().iterator().next()).getKey());
        }
    }

    /* renamed from: a */
    public C4073a mo23735a(String str) {
        return m16894a(str, -1);
    }

    /* renamed from: a */
    public File mo23736a() {
        return this.f13686c;
    }

    /* renamed from: b */
    public synchronized void mo23737b() {
        m16913i();
        m16914j();
        this.f13694k.flush();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0090, code lost:
            return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0092, code lost:
            return false;
     */
    /* renamed from: b */
    public synchronized boolean mo23738b(java.lang.String r8) {
        /*
        r7 = this;
        monitor-enter(r7)
        r7.m16913i()     // Catch:{ all -> 0x0093 }
        r7.m16906d(r8)     // Catch:{ all -> 0x0093 }
        java.util.LinkedHashMap<java.lang.String, com.kwad.sdk.core.diskcache.a.a$b> r0 = r7.f13695l     // Catch:{ all -> 0x0093 }
        java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x0093 }
        com.kwad.sdk.core.diskcache.a.a$b r0 = (com.kwad.sdk.core.diskcache.p321a.C4070a.C4075b) r0     // Catch:{ all -> 0x0093 }
        r1 = 0
        if (r0 == 0) goto L_0x0091
        com.kwad.sdk.core.diskcache.a.a$a r2 = r0.f13710e     // Catch:{ all -> 0x0093 }
        if (r2 == 0) goto L_0x001a
        goto L_0x0091
    L_0x001a:
        int r2 = r7.f13692i     // Catch:{ all -> 0x0093 }
        if (r1 >= r2) goto L_0x005c
        java.io.File r2 = r0.mo23751a(r1)     // Catch:{ all -> 0x0093 }
        boolean r3 = r2.exists()     // Catch:{ all -> 0x0093 }
        if (r3 == 0) goto L_0x0046
        boolean r3 = r2.delete()     // Catch:{ all -> 0x0093 }
        if (r3 == 0) goto L_0x002f
        goto L_0x0046
    L_0x002f:
        java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x0093 }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0093 }
        r0.<init>()     // Catch:{ all -> 0x0093 }
        java.lang.String r1 = "failed to delete "
        r0.append(r1)     // Catch:{ all -> 0x0093 }
        r0.append(r2)     // Catch:{ all -> 0x0093 }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0093 }
        r8.<init>(r0)     // Catch:{ all -> 0x0093 }
        throw r8     // Catch:{ all -> 0x0093 }
    L_0x0046:
        long r2 = r7.f13693j     // Catch:{ all -> 0x0093 }
        long[] r4 = r0.f13708c     // Catch:{ all -> 0x0093 }
        r5 = r4[r1]     // Catch:{ all -> 0x0093 }
        long r2 = r2 - r5
        r7.f13693j = r2     // Catch:{ all -> 0x0093 }
        long[] r2 = r0.f13708c     // Catch:{ all -> 0x0093 }
        r3 = 0
        r2[r1] = r3     // Catch:{ all -> 0x0093 }
        int r1 = r1 + 1
        goto L_0x001a
    L_0x005c:
        int r0 = r7.f13696m     // Catch:{ all -> 0x0093 }
        r1 = 1
        int r0 = r0 + r1
        r7.f13696m = r0     // Catch:{ all -> 0x0093 }
        java.io.Writer r0 = r7.f13694k     // Catch:{ all -> 0x0093 }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0093 }
        r2.<init>()     // Catch:{ all -> 0x0093 }
        java.lang.String r3 = "REMOVE "
        r2.append(r3)     // Catch:{ all -> 0x0093 }
        r2.append(r8)     // Catch:{ all -> 0x0093 }
        r3 = 10
        r2.append(r3)     // Catch:{ all -> 0x0093 }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0093 }
        r0.append(r2)     // Catch:{ all -> 0x0093 }
        java.util.LinkedHashMap<java.lang.String, com.kwad.sdk.core.diskcache.a.a$b> r0 = r7.f13695l     // Catch:{ all -> 0x0093 }
        r0.remove(r8)     // Catch:{ all -> 0x0093 }
        boolean r8 = r7.m16912h()     // Catch:{ all -> 0x0093 }
        if (r8 == 0) goto L_0x008f
        java.util.concurrent.ThreadPoolExecutor r8 = r7.f13685b     // Catch:{ all -> 0x0093 }
        java.util.concurrent.Callable<java.lang.Void> r0 = r7.f13698o     // Catch:{ all -> 0x0093 }
        r8.submit(r0)     // Catch:{ all -> 0x0093 }
    L_0x008f:
        monitor-exit(r7)
        return r1
    L_0x0091:
        monitor-exit(r7)
        return r1
    L_0x0093:
        r8 = move-exception
        monitor-exit(r7)
        throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.diskcache.p321a.C4070a.mo23738b(java.lang.String):boolean");
    }

    /* renamed from: c */
    public void mo23739c() {
        close();
        C4078c.m16946a(this.f13686c);
    }

    public synchronized void close() {
        if (this.f13694k != null) {
            Iterator it = new ArrayList(this.f13695l.values()).iterator();
            while (it.hasNext()) {
                C4075b bVar = (C4075b) it.next();
                if (bVar.f13710e != null) {
                    bVar.f13710e.mo23746b();
                }
            }
            m16914j();
            this.f13694k.close();
            this.f13694k = null;
        }
    }
}
