package com.bumptech.glide.p129a;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.bumptech.glide.a.a */
public final class DiskLruCache implements Closeable {
    /* renamed from: a */
    final ThreadPoolExecutor f4104a;
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final File f4105b;
    /* renamed from: c */
    private final File f4106c;
    /* renamed from: d */
    private final File f4107d;
    /* renamed from: e */
    private final File f4108e;
    /* renamed from: f */
    private final int f4109f;
    /* renamed from: g */
    private long f4110g;
    /* access modifiers changed from: private|final */
    /* renamed from: h */
    public final int f4111h;
    /* renamed from: i */
    private long f4112i = 0;
    /* access modifiers changed from: private */
    /* renamed from: j */
    public Writer f4113j;
    /* renamed from: k */
    private final LinkedHashMap<String, C1600c> f4114k = new LinkedHashMap<>(0, 0.75f, true);
    /* access modifiers changed from: private */
    /* renamed from: l */
    public int f4115l;
    /* renamed from: m */
    private long f4116m = 0;
    /* renamed from: n */
    private final Callable<Void> f4117n;

    /* compiled from: DiskLruCache */
    /* renamed from: com.bumptech.glide.a.a$a */
    private static final class C1598a implements ThreadFactory {
        private C1598a() {
        }

        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    /* compiled from: DiskLruCache */
    /* renamed from: com.bumptech.glide.a.a$b */
    public final class C1599b {
        /* access modifiers changed from: private|final */
        /* renamed from: b */
        public final C1600c f4120b;
        /* access modifiers changed from: private|final */
        /* renamed from: c */
        public final boolean[] f4121c;
        /* renamed from: d */
        private boolean f4122d;

        private C1599b(C1600c cVar) {
            this.f4120b = cVar;
            this.f4121c = cVar.f4128f ? null : new boolean[DiskLruCache.this.f4111h];
        }

        /* renamed from: a */
        public File mo12370a(int i) throws IOException {
            File b;
            synchronized (DiskLruCache.this) {
                if (this.f4120b.f4129g == this) {
                    if (!this.f4120b.f4128f) {
                        this.f4121c[i] = true;
                    }
                    b = this.f4120b.mo12376b(i);
                    if (!DiskLruCache.this.f4105b.exists()) {
                        DiskLruCache.this.f4105b.mkdirs();
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
            return b;
        }

        /* renamed from: a */
        public void mo12371a() throws IOException {
            DiskLruCache.this.m4881a(this, true);
            this.f4122d = true;
        }

        /* renamed from: b */
        public void mo12372b() throws IOException {
            DiskLruCache.this.m4881a(this, false);
        }

        /* renamed from: c */
        public void mo12373c() {
            if (!this.f4122d) {
                try {
                    mo12372b();
                } catch (IOException unused) {
                }
            }
        }
    }

    /* compiled from: DiskLruCache */
    /* renamed from: com.bumptech.glide.a.a$c */
    private final class C1600c {
        /* renamed from: a */
        File[] f4123a;
        /* renamed from: b */
        File[] f4124b;
        /* access modifiers changed from: private|final */
        /* renamed from: d */
        public final String f4126d;
        /* access modifiers changed from: private|final */
        /* renamed from: e */
        public final long[] f4127e;
        /* access modifiers changed from: private */
        /* renamed from: f */
        public boolean f4128f;
        /* access modifiers changed from: private */
        /* renamed from: g */
        public C1599b f4129g;
        /* access modifiers changed from: private */
        /* renamed from: h */
        public long f4130h;

        private C1600c(String str) {
            this.f4126d = str;
            this.f4127e = new long[DiskLruCache.this.f4111h];
            this.f4123a = new File[DiskLruCache.this.f4111h];
            this.f4124b = new File[DiskLruCache.this.f4111h];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < DiskLruCache.this.f4111h; i++) {
                sb.append(i);
                this.f4123a[i] = new File(DiskLruCache.this.f4105b, sb.toString());
                sb.append(".tmp");
                this.f4124b[i] = new File(DiskLruCache.this.f4105b, sb.toString());
                sb.setLength(length);
            }
        }

        /* renamed from: a */
        public String mo12375a() throws IOException {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j : this.f4127e) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m4912a(String[] strArr) throws IOException {
            if (strArr.length == DiskLruCache.this.f4111h) {
                int i = 0;
                while (i < strArr.length) {
                    try {
                        this.f4127e[i] = Long.parseLong(strArr[i]);
                        i++;
                    } catch (NumberFormatException unused) {
                        throw m4914b(strArr);
                    }
                }
                return;
            }
            throw m4914b(strArr);
        }

        /* renamed from: b */
        private IOException m4914b(String[] strArr) throws IOException {
            StringBuilder sb = new StringBuilder();
            sb.append("unexpected journal line: ");
            sb.append(Arrays.toString(strArr));
            throw new IOException(sb.toString());
        }

        /* renamed from: a */
        public File mo12374a(int i) {
            return this.f4123a[i];
        }

        /* renamed from: b */
        public File mo12376b(int i) {
            return this.f4124b[i];
        }
    }

    /* compiled from: DiskLruCache */
    /* renamed from: com.bumptech.glide.a.a$d */
    public final class C1601d {
        /* renamed from: b */
        private final String f4132b;
        /* renamed from: c */
        private final long f4133c;
        /* renamed from: d */
        private final long[] f4134d;
        /* renamed from: e */
        private final File[] f4135e;

        private C1601d(String str, long j, File[] fileArr, long[] jArr) {
            this.f4132b = str;
            this.f4133c = j;
            this.f4135e = fileArr;
            this.f4134d = jArr;
        }

        /* renamed from: a */
        public File mo12377a(int i) {
            return this.f4135e[i];
        }
    }

    private DiskLruCache(File file, int i, int i2, long j) {
        File file2 = file;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new C1598a());
        this.f4104a = threadPoolExecutor;
        this.f4117n = new Callable<Void>() {
            /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
            return null;
     */
            /* renamed from: a */
            public java.lang.Void call() throws java.lang.Exception {
                /*
                r4 = this;
                com.bumptech.glide.a.a r0 = com.bumptech.glide.p129a.DiskLruCache.this
                monitor-enter(r0)
                com.bumptech.glide.a.a r1 = com.bumptech.glide.p129a.DiskLruCache.this     // Catch:{ all -> 0x0028 }
                java.io.Writer r1 = r1.f4113j     // Catch:{ all -> 0x0028 }
                r2 = 0
                if (r1 != 0) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x000e:
                com.bumptech.glide.a.a r1 = com.bumptech.glide.p129a.DiskLruCache.this     // Catch:{ all -> 0x0028 }
                r1.m4896g()     // Catch:{ all -> 0x0028 }
                com.bumptech.glide.a.a r1 = com.bumptech.glide.p129a.DiskLruCache.this     // Catch:{ all -> 0x0028 }
                boolean r1 = r1.m4893e()     // Catch:{ all -> 0x0028 }
                if (r1 == 0) goto L_0x0026
                com.bumptech.glide.a.a r1 = com.bumptech.glide.p129a.DiskLruCache.this     // Catch:{ all -> 0x0028 }
                r1.m4889d()     // Catch:{ all -> 0x0028 }
                com.bumptech.glide.a.a r1 = com.bumptech.glide.p129a.DiskLruCache.this     // Catch:{ all -> 0x0028 }
                r3 = 0
                r1.f4115l = r3     // Catch:{ all -> 0x0028 }
            L_0x0026:
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x0028:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.p129a.DiskLruCache.C15971.call():java.lang.Void");
            }
        };
        this.f4105b = file2;
        this.f4109f = i;
        this.f4106c = new File(file2, "journal");
        this.f4107d = new File(file2, "journal.tmp");
        this.f4108e = new File(file2, "journal.bkp");
        this.f4111h = i2;
        this.f4110g = j;
    }

    /* renamed from: a */
    public static DiskLruCache m4879a(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    m4884a(file2, file3, false);
                }
            }
            DiskLruCache aVar = new DiskLruCache(file, i, i2, j);
            if (aVar.f4106c.exists()) {
                try {
                    aVar.m4885b();
                    aVar.m4887c();
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
                    aVar.mo12363a();
                }
            }
            file.mkdirs();
            DiskLruCache aVar2 = new DiskLruCache(file, i, i2, j);
            aVar2.m4889d();
            return aVar2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|(1:19)(1:20)|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            r9.f4115l = r0 - r9.f4114k.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
            if (r1.mo12379b() != false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006e, code lost:
            m4889d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0072, code lost:
            r9.f4113j = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(r9.f4106c, true), com.bumptech.glide.p129a.Util.f4142a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008b, code lost:
            return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005f */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x008c=Splitter:B:23:0x008c, B:16:0x005f=Splitter:B:16:0x005f} */
    /* renamed from: b */
    private void m4885b() throws java.io.IOException {
        /*
        r9 = this;
        java.lang.String r0 = ", "
        com.bumptech.glide.a.b r1 = new com.bumptech.glide.a.b
        java.io.FileInputStream r2 = new java.io.FileInputStream
        java.io.File r3 = r9.f4106c
        r2.<init>(r3)
        java.nio.charset.Charset r3 = com.bumptech.glide.p129a.Util.f4142a
        r1.m42272init(r2, r3)
        java.lang.String r2 = r1.mo12378a()     // Catch:{ all -> 0x00ba }
        java.lang.String r3 = r1.mo12378a()     // Catch:{ all -> 0x00ba }
        java.lang.String r4 = r1.mo12378a()     // Catch:{ all -> 0x00ba }
        java.lang.String r5 = r1.mo12378a()     // Catch:{ all -> 0x00ba }
        java.lang.String r6 = r1.mo12378a()     // Catch:{ all -> 0x00ba }
        java.lang.String r7 = "libcore.io.DiskLruCache"
        boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x00ba }
        if (r7 == 0) goto L_0x008c
        java.lang.String r7 = "1"
        boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x00ba }
        if (r7 == 0) goto L_0x008c
        int r7 = r9.f4109f     // Catch:{ all -> 0x00ba }
        java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x00ba }
        boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x00ba }
        if (r4 == 0) goto L_0x008c
        int r4 = r9.f4111h     // Catch:{ all -> 0x00ba }
        java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x00ba }
        boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00ba }
        if (r4 == 0) goto L_0x008c
        java.lang.String r4 = ""
        boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x00ba }
        if (r4 == 0) goto L_0x008c
        r0 = 0
    L_0x0055:
        java.lang.String r2 = r1.mo12378a()     // Catch:{ EOFException -> 0x005f }
        r9.m4891d(r2)     // Catch:{ EOFException -> 0x005f }
        int r0 = r0 + 1
        goto L_0x0055
    L_0x005f:
        java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.a.a$c> r2 = r9.f4114k     // Catch:{ all -> 0x00ba }
        int r2 = r2.size()     // Catch:{ all -> 0x00ba }
        int r0 = r0 - r2
        r9.f4115l = r0     // Catch:{ all -> 0x00ba }
        boolean r0 = r1.mo12379b()     // Catch:{ all -> 0x00ba }
        if (r0 == 0) goto L_0x0072
        r9.m4889d()     // Catch:{ all -> 0x00ba }
        goto L_0x0088
    L_0x0072:
        java.io.BufferedWriter r0 = new java.io.BufferedWriter     // Catch:{ all -> 0x00ba }
        java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x00ba }
        java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x00ba }
        java.io.File r4 = r9.f4106c     // Catch:{ all -> 0x00ba }
        r5 = 1
        r3.<init>(r4, r5)     // Catch:{ all -> 0x00ba }
        java.nio.charset.Charset r4 = com.bumptech.glide.p129a.Util.f4142a     // Catch:{ all -> 0x00ba }
        r2.<init>(r3, r4)     // Catch:{ all -> 0x00ba }
        r0.<init>(r2)     // Catch:{ all -> 0x00ba }
        r9.f4113j = r0     // Catch:{ all -> 0x00ba }
    L_0x0088:
        com.bumptech.glide.p129a.Util.m4927a(r1)
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
        com.bumptech.glide.p129a.Util.m4927a(r1)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.p129a.DiskLruCache.m4885b():void");
    }

    /* renamed from: d */
    private void m4891d(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        String str3 = "unexpected journal line: ";
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                str2 = str.substring(i);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f4114k.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i, indexOf2);
            }
            C1600c cVar = (C1600c) this.f4114k.get(str2);
            if (cVar == null) {
                cVar = new C1600c(str2);
                this.f4114k.put(str2, cVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                cVar.f4128f = true;
                cVar.f4129g = null;
                cVar.m4912a(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                cVar.f4129g = new C1599b(cVar);
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

    /* renamed from: c */
    private void m4887c() throws IOException {
        m4883a(this.f4107d);
        Iterator it = this.f4114k.values().iterator();
        while (it.hasNext()) {
            C1600c cVar = (C1600c) it.next();
            int i = 0;
            if (cVar.f4129g == null) {
                while (i < this.f4111h) {
                    this.f4112i += cVar.f4127e[i];
                    i++;
                }
            } else {
                cVar.f4129g = null;
                while (i < this.f4111h) {
                    m4883a(cVar.mo12374a(i));
                    m4883a(cVar.mo12376b(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private|declared_synchronized */
    /* renamed from: d */
    public synchronized void m4889d() throws IOException {
        if (this.f4113j != null) {
            this.f4113j.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f4107d), Util.f4142a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f4109f));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f4111h));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (C1600c cVar : this.f4114k.values()) {
                if (cVar.f4129g != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("DIRTY ");
                    sb.append(cVar.f4126d);
                    sb.append(10);
                    bufferedWriter.write(sb.toString());
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("CLEAN ");
                    sb2.append(cVar.f4126d);
                    sb2.append(cVar.mo12375a());
                    sb2.append(10);
                    bufferedWriter.write(sb2.toString());
                }
            }
            bufferedWriter.close();
            if (this.f4106c.exists()) {
                m4884a(this.f4106c, this.f4108e, true);
            }
            m4884a(this.f4107d, this.f4106c, false);
            this.f4108e.delete();
            this.f4113j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f4106c, true), Util.f4142a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    /* renamed from: a */
    private static void m4883a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* renamed from: a */
    private static void m4884a(File file, File file2, boolean z) throws IOException {
        if (z) {
            m4883a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* renamed from: a */
    public synchronized C1601d mo12362a(String str) throws IOException {
        m4895f();
        C1600c cVar = (C1600c) this.f4114k.get(str);
        if (cVar == null) {
            return null;
        }
        if (!cVar.f4128f) {
            return null;
        }
        for (File exists : cVar.f4123a) {
            if (!exists.exists()) {
                return null;
            }
        }
        this.f4115l++;
        this.f4113j.append("READ");
        this.f4113j.append(' ');
        this.f4113j.append(str);
        this.f4113j.append(10);
        if (m4893e()) {
            this.f4104a.submit(this.f4117n);
        }
        C1601d dVar = new C1601d(str, cVar.f4130h, cVar.f4123a, cVar.f4127e);
        return dVar;
    }

    /* renamed from: b */
    public C1599b mo12364b(String str) throws IOException {
        return m4878a(str, -1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
            return null;
     */
    /* renamed from: a */
    private synchronized com.bumptech.glide.p129a.DiskLruCache.C1599b m4878a(java.lang.String r6, long r7) throws java.io.IOException {
        /*
        r5 = this;
        monitor-enter(r5)
        r5.m4895f()     // Catch:{ all -> 0x005d }
        java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.a.a$c> r0 = r5.f4114k     // Catch:{ all -> 0x005d }
        java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x005d }
        com.bumptech.glide.a.a$c r0 = (com.bumptech.glide.p129a.DiskLruCache.C1600c) r0     // Catch:{ all -> 0x005d }
        r1 = -1
        r3 = 0
        int r4 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
        if (r4 == 0) goto L_0x001f
        if (r0 == 0) goto L_0x001d
        long r1 = r0.f4130h     // Catch:{ all -> 0x005d }
        int r4 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
        if (r4 == 0) goto L_0x001f
    L_0x001d:
        monitor-exit(r5)
        return r3
    L_0x001f:
        if (r0 != 0) goto L_0x002c
        com.bumptech.glide.a.a$c r0 = new com.bumptech.glide.a.a$c     // Catch:{ all -> 0x005d }
        r0.m42268init(r6)     // Catch:{ all -> 0x005d }
        java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.a.a$c> r7 = r5.f4114k     // Catch:{ all -> 0x005d }
        r7.put(r6, r0)     // Catch:{ all -> 0x005d }
        goto L_0x0034
    L_0x002c:
        com.bumptech.glide.a.a$b r7 = r0.f4129g     // Catch:{ all -> 0x005d }
        if (r7 == 0) goto L_0x0034
        monitor-exit(r5)
        return r3
    L_0x0034:
        com.bumptech.glide.a.a$b r7 = new com.bumptech.glide.a.a$b     // Catch:{ all -> 0x005d }
        r7.m42266init(r0)     // Catch:{ all -> 0x005d }
        r0.f4129g = r7     // Catch:{ all -> 0x005d }
        java.io.Writer r8 = r5.f4113j     // Catch:{ all -> 0x005d }
        java.lang.String r0 = "DIRTY"
        r8.append(r0)     // Catch:{ all -> 0x005d }
        java.io.Writer r8 = r5.f4113j     // Catch:{ all -> 0x005d }
        r0 = 32
        r8.append(r0)     // Catch:{ all -> 0x005d }
        java.io.Writer r8 = r5.f4113j     // Catch:{ all -> 0x005d }
        r8.append(r6)     // Catch:{ all -> 0x005d }
        java.io.Writer r6 = r5.f4113j     // Catch:{ all -> 0x005d }
        r8 = 10
        r6.append(r8)     // Catch:{ all -> 0x005d }
        java.io.Writer r6 = r5.f4113j     // Catch:{ all -> 0x005d }
        r6.flush()     // Catch:{ all -> 0x005d }
        monitor-exit(r5)
        return r7
    L_0x005d:
        r6 = move-exception
        monitor-exit(r5)
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.p129a.DiskLruCache.m4878a(java.lang.String, long):com.bumptech.glide.a.a$b");
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0107, code lost:
            return;
     */
    /* renamed from: a */
    public synchronized void m4881a(com.bumptech.glide.p129a.DiskLruCache.C1599b r10, boolean r11) throws java.io.IOException {
        /*
        r9 = this;
        monitor-enter(r9)
        com.bumptech.glide.a.a$c r0 = r10.f4120b     // Catch:{ all -> 0x010e }
        com.bumptech.glide.a.a$b r1 = r0.f4129g     // Catch:{ all -> 0x010e }
        if (r1 != r10) goto L_0x0108
        r1 = 0
        if (r11 == 0) goto L_0x004d
        boolean r2 = r0.f4128f     // Catch:{ all -> 0x010e }
        if (r2 != 0) goto L_0x004d
        r2 = 0
    L_0x0015:
        int r3 = r9.f4111h     // Catch:{ all -> 0x010e }
        if (r2 >= r3) goto L_0x004d
        boolean[] r3 = r10.f4121c     // Catch:{ all -> 0x010e }
        boolean r3 = r3[r2]     // Catch:{ all -> 0x010e }
        if (r3 == 0) goto L_0x0033
        java.io.File r3 = r0.mo12376b(r2)     // Catch:{ all -> 0x010e }
        boolean r3 = r3.exists()     // Catch:{ all -> 0x010e }
        if (r3 != 0) goto L_0x0030
        r10.mo12372b()     // Catch:{ all -> 0x010e }
        monitor-exit(r9)
        return
    L_0x0030:
        int r2 = r2 + 1
        goto L_0x0015
    L_0x0033:
        r10.mo12372b()     // Catch:{ all -> 0x010e }
        java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x010e }
        java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x010e }
        r11.<init>()     // Catch:{ all -> 0x010e }
        java.lang.String r0 = "Newly created entry didn't create value for index "
        r11.append(r0)     // Catch:{ all -> 0x010e }
        r11.append(r2)     // Catch:{ all -> 0x010e }
        java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x010e }
        r10.<init>(r11)     // Catch:{ all -> 0x010e }
        throw r10     // Catch:{ all -> 0x010e }
    L_0x004d:
        int r10 = r9.f4111h     // Catch:{ all -> 0x010e }
        if (r1 >= r10) goto L_0x0081
        java.io.File r10 = r0.mo12376b(r1)     // Catch:{ all -> 0x010e }
        if (r11 == 0) goto L_0x007b
        boolean r2 = r10.exists()     // Catch:{ all -> 0x010e }
        if (r2 == 0) goto L_0x007e
        java.io.File r2 = r0.mo12374a(r1)     // Catch:{ all -> 0x010e }
        r10.renameTo(r2)     // Catch:{ all -> 0x010e }
        long[] r10 = r0.f4127e     // Catch:{ all -> 0x010e }
        r3 = r10[r1]     // Catch:{ all -> 0x010e }
        long r5 = r2.length()     // Catch:{ all -> 0x010e }
        long[] r10 = r0.f4127e     // Catch:{ all -> 0x010e }
        r10[r1] = r5     // Catch:{ all -> 0x010e }
        long r7 = r9.f4112i     // Catch:{ all -> 0x010e }
        long r7 = r7 - r3
        long r7 = r7 + r5
        r9.f4112i = r7     // Catch:{ all -> 0x010e }
        goto L_0x007e
    L_0x007b:
        m4883a(r10)     // Catch:{ all -> 0x010e }
    L_0x007e:
        int r1 = r1 + 1
        goto L_0x004d
    L_0x0081:
        int r10 = r9.f4115l     // Catch:{ all -> 0x010e }
        r1 = 1
        int r10 = r10 + r1
        r9.f4115l = r10     // Catch:{ all -> 0x010e }
        r10 = 0
        r0.f4129g = r10     // Catch:{ all -> 0x010e }
        boolean r10 = r0.f4128f     // Catch:{ all -> 0x010e }
        r10 = r10 | r11
        r2 = 10
        r3 = 32
        if (r10 == 0) goto L_0x00c9
        r0.f4128f = r1     // Catch:{ all -> 0x010e }
        java.io.Writer r10 = r9.f4113j     // Catch:{ all -> 0x010e }
        java.lang.String r1 = "CLEAN"
        r10.append(r1)     // Catch:{ all -> 0x010e }
        java.io.Writer r10 = r9.f4113j     // Catch:{ all -> 0x010e }
        r10.append(r3)     // Catch:{ all -> 0x010e }
        java.io.Writer r10 = r9.f4113j     // Catch:{ all -> 0x010e }
        java.lang.String r1 = r0.f4126d     // Catch:{ all -> 0x010e }
        r10.append(r1)     // Catch:{ all -> 0x010e }
        java.io.Writer r10 = r9.f4113j     // Catch:{ all -> 0x010e }
        java.lang.String r1 = r0.mo12375a()     // Catch:{ all -> 0x010e }
        r10.append(r1)     // Catch:{ all -> 0x010e }
        java.io.Writer r10 = r9.f4113j     // Catch:{ all -> 0x010e }
        r10.append(r2)     // Catch:{ all -> 0x010e }
        if (r11 == 0) goto L_0x00ec
        long r10 = r9.f4116m     // Catch:{ all -> 0x010e }
        r1 = 1
        long r1 = r1 + r10
        r9.f4116m = r1     // Catch:{ all -> 0x010e }
        r0.f4130h = r10     // Catch:{ all -> 0x010e }
        goto L_0x00ec
    L_0x00c9:
        java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.a.a$c> r10 = r9.f4114k     // Catch:{ all -> 0x010e }
        java.lang.String r11 = r0.f4126d     // Catch:{ all -> 0x010e }
        r10.remove(r11)     // Catch:{ all -> 0x010e }
        java.io.Writer r10 = r9.f4113j     // Catch:{ all -> 0x010e }
        java.lang.String r11 = "REMOVE"
        r10.append(r11)     // Catch:{ all -> 0x010e }
        java.io.Writer r10 = r9.f4113j     // Catch:{ all -> 0x010e }
        r10.append(r3)     // Catch:{ all -> 0x010e }
        java.io.Writer r10 = r9.f4113j     // Catch:{ all -> 0x010e }
        java.lang.String r11 = r0.f4126d     // Catch:{ all -> 0x010e }
        r10.append(r11)     // Catch:{ all -> 0x010e }
        java.io.Writer r10 = r9.f4113j     // Catch:{ all -> 0x010e }
        r10.append(r2)     // Catch:{ all -> 0x010e }
    L_0x00ec:
        java.io.Writer r10 = r9.f4113j     // Catch:{ all -> 0x010e }
        r10.flush()     // Catch:{ all -> 0x010e }
        long r10 = r9.f4112i     // Catch:{ all -> 0x010e }
        long r0 = r9.f4110g     // Catch:{ all -> 0x010e }
        int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
        if (r2 > 0) goto L_0x00ff
        boolean r10 = r9.m4893e()     // Catch:{ all -> 0x010e }
        if (r10 == 0) goto L_0x0106
    L_0x00ff:
        java.util.concurrent.ThreadPoolExecutor r10 = r9.f4104a     // Catch:{ all -> 0x010e }
        java.util.concurrent.Callable<java.lang.Void> r11 = r9.f4117n     // Catch:{ all -> 0x010e }
        r10.submit(r11)     // Catch:{ all -> 0x010e }
    L_0x0106:
        monitor-exit(r9)
        return
    L_0x0108:
        java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x010e }
        r10.<init>()     // Catch:{ all -> 0x010e }
        throw r10     // Catch:{ all -> 0x010e }
    L_0x010e:
        r10 = move-exception
        monitor-exit(r9)
        throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.p129a.DiskLruCache.m4881a(com.bumptech.glide.a.a$b, boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m4893e() {
        int i = this.f4115l;
        return i >= 2000 && i >= this.f4114k.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008c, code lost:
            return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008e, code lost:
            return false;
     */
    /* renamed from: c */
    public synchronized boolean mo12365c(java.lang.String r8) throws java.io.IOException {
        /*
        r7 = this;
        monitor-enter(r7)
        r7.m4895f()     // Catch:{ all -> 0x008f }
        java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.a.a$c> r0 = r7.f4114k     // Catch:{ all -> 0x008f }
        java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x008f }
        com.bumptech.glide.a.a$c r0 = (com.bumptech.glide.p129a.DiskLruCache.C1600c) r0     // Catch:{ all -> 0x008f }
        r1 = 0
        if (r0 == 0) goto L_0x008d
        com.bumptech.glide.a.a$b r2 = r0.f4129g     // Catch:{ all -> 0x008f }
        if (r2 == 0) goto L_0x0017
        goto L_0x008d
    L_0x0017:
        int r2 = r7.f4111h     // Catch:{ all -> 0x008f }
        if (r1 >= r2) goto L_0x0059
        java.io.File r2 = r0.mo12374a(r1)     // Catch:{ all -> 0x008f }
        boolean r3 = r2.exists()     // Catch:{ all -> 0x008f }
        if (r3 == 0) goto L_0x0043
        boolean r3 = r2.delete()     // Catch:{ all -> 0x008f }
        if (r3 == 0) goto L_0x002c
        goto L_0x0043
    L_0x002c:
        java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x008f }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
        r0.<init>()     // Catch:{ all -> 0x008f }
        java.lang.String r1 = "failed to delete "
        r0.append(r1)     // Catch:{ all -> 0x008f }
        r0.append(r2)     // Catch:{ all -> 0x008f }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x008f }
        r8.<init>(r0)     // Catch:{ all -> 0x008f }
        throw r8     // Catch:{ all -> 0x008f }
    L_0x0043:
        long r2 = r7.f4112i     // Catch:{ all -> 0x008f }
        long[] r4 = r0.f4127e     // Catch:{ all -> 0x008f }
        r5 = r4[r1]     // Catch:{ all -> 0x008f }
        long r2 = r2 - r5
        r7.f4112i = r2     // Catch:{ all -> 0x008f }
        long[] r2 = r0.f4127e     // Catch:{ all -> 0x008f }
        r3 = 0
        r2[r1] = r3     // Catch:{ all -> 0x008f }
        int r1 = r1 + 1
        goto L_0x0017
    L_0x0059:
        int r0 = r7.f4115l     // Catch:{ all -> 0x008f }
        r1 = 1
        int r0 = r0 + r1
        r7.f4115l = r0     // Catch:{ all -> 0x008f }
        java.io.Writer r0 = r7.f4113j     // Catch:{ all -> 0x008f }
        java.lang.String r2 = "REMOVE"
        r0.append(r2)     // Catch:{ all -> 0x008f }
        java.io.Writer r0 = r7.f4113j     // Catch:{ all -> 0x008f }
        r2 = 32
        r0.append(r2)     // Catch:{ all -> 0x008f }
        java.io.Writer r0 = r7.f4113j     // Catch:{ all -> 0x008f }
        r0.append(r8)     // Catch:{ all -> 0x008f }
        java.io.Writer r0 = r7.f4113j     // Catch:{ all -> 0x008f }
        r2 = 10
        r0.append(r2)     // Catch:{ all -> 0x008f }
        java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.a.a$c> r0 = r7.f4114k     // Catch:{ all -> 0x008f }
        r0.remove(r8)     // Catch:{ all -> 0x008f }
        boolean r8 = r7.m4893e()     // Catch:{ all -> 0x008f }
        if (r8 == 0) goto L_0x008b
        java.util.concurrent.ThreadPoolExecutor r8 = r7.f4104a     // Catch:{ all -> 0x008f }
        java.util.concurrent.Callable<java.lang.Void> r0 = r7.f4117n     // Catch:{ all -> 0x008f }
        r8.submit(r0)     // Catch:{ all -> 0x008f }
    L_0x008b:
        monitor-exit(r7)
        return r1
    L_0x008d:
        monitor-exit(r7)
        return r1
    L_0x008f:
        r8 = move-exception
        monitor-exit(r7)
        throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.p129a.DiskLruCache.mo12365c(java.lang.String):boolean");
    }

    /* renamed from: f */
    private void m4895f() {
        if (this.f4113j == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void close() throws IOException {
        if (this.f4113j != null) {
            Iterator it = new ArrayList(this.f4114k.values()).iterator();
            while (it.hasNext()) {
                C1600c cVar = (C1600c) it.next();
                if (cVar.f4129g != null) {
                    cVar.f4129g.mo12372b();
                }
            }
            m4896g();
            this.f4113j.close();
            this.f4113j = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m4896g() throws IOException {
        while (this.f4112i > this.f4110g) {
            mo12365c((String) ((Entry) this.f4114k.entrySet().iterator().next()).getKey());
        }
    }

    /* renamed from: a */
    public void mo12363a() throws IOException {
        close();
        Util.m4928a(this.f4105b);
    }
}
