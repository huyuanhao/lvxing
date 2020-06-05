package okhttp3.internal.p697a;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.internal.C8417c;
import okhttp3.internal.p700d.C8437a;
import okhttp3.internal.p701e.C8447f;
import okio.C8528d;
import okio.C8535k;
import okio.C8546q;
import okio.C8547r;

/* compiled from: DiskLruCache */
/* renamed from: okhttp3.internal.a.d */
public final class C8394d implements Closeable, Flushable {
    /* renamed from: a */
    static final Pattern f28453a = Pattern.compile("[a-z0-9_-]{1,120}");
    /* renamed from: m */
    static final /* synthetic */ boolean f28454m = (!C8394d.class.desiredAssertionStatus());
    /* renamed from: b */
    final C8437a f28455b;
    /* renamed from: c */
    final File f28456c;
    /* renamed from: d */
    final int f28457d;
    /* renamed from: e */
    C8528d f28458e;
    /* renamed from: f */
    final LinkedHashMap<String, C8399b> f28459f = new LinkedHashMap<>(0, 0.75f, true);
    /* renamed from: g */
    int f28460g;
    /* renamed from: h */
    boolean f28461h;
    /* renamed from: i */
    boolean f28462i;
    /* renamed from: j */
    boolean f28463j;
    /* renamed from: k */
    boolean f28464k;
    /* renamed from: l */
    boolean f28465l;
    /* renamed from: n */
    private final File f28466n;
    /* renamed from: o */
    private final File f28467o;
    /* renamed from: p */
    private final File f28468p;
    /* renamed from: q */
    private final int f28469q;
    /* renamed from: r */
    private long f28470r;
    /* renamed from: s */
    private long f28471s = 0;
    /* renamed from: t */
    private long f28472t = 0;
    /* renamed from: u */
    private final Executor f28473u;
    /* renamed from: v */
    private final Runnable f28474v = new Runnable() {
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            r5.f28475a.f28465l = true;
            r5.f28475a.f28458e = okio.C8535k.m36848a(okio.C8535k.m36850a());
     */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0033 */
        public void run() {
            /*
            r5 = this;
            okhttp3.internal.a.d r0 = okhttp3.internal.p697a.C8394d.this
            monitor-enter(r0)
            okhttp3.internal.a.d r1 = okhttp3.internal.p697a.C8394d.this     // Catch:{ all -> 0x0045 }
            boolean r1 = r1.f28462i     // Catch:{ all -> 0x0045 }
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L_0x000d
            r1 = 1
            goto L_0x000e
        L_0x000d:
            r1 = 0
        L_0x000e:
            okhttp3.internal.a.d r4 = okhttp3.internal.p697a.C8394d.this     // Catch:{ all -> 0x0045 }
            boolean r4 = r4.f28463j     // Catch:{ all -> 0x0045 }
            r1 = r1 | r4
            if (r1 == 0) goto L_0x0017
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            return
        L_0x0017:
            okhttp3.internal.a.d r1 = okhttp3.internal.p697a.C8394d.this     // Catch:{ IOException -> 0x001d }
            r1.mo40216e()     // Catch:{ IOException -> 0x001d }
            goto L_0x0021
        L_0x001d:
            okhttp3.internal.a.d r1 = okhttp3.internal.p697a.C8394d.this     // Catch:{ all -> 0x0045 }
            r1.f28464k = r3     // Catch:{ all -> 0x0045 }
        L_0x0021:
            okhttp3.internal.a.d r1 = okhttp3.internal.p697a.C8394d.this     // Catch:{ IOException -> 0x0033 }
            boolean r1 = r1.mo40212c()     // Catch:{ IOException -> 0x0033 }
            if (r1 == 0) goto L_0x0043
            okhttp3.internal.a.d r1 = okhttp3.internal.p697a.C8394d.this     // Catch:{ IOException -> 0x0033 }
            r1.mo40211b()     // Catch:{ IOException -> 0x0033 }
            okhttp3.internal.a.d r1 = okhttp3.internal.p697a.C8394d.this     // Catch:{ IOException -> 0x0033 }
            r1.f28460g = r2     // Catch:{ IOException -> 0x0033 }
            goto L_0x0043
        L_0x0033:
            okhttp3.internal.a.d r1 = okhttp3.internal.p697a.C8394d.this     // Catch:{ all -> 0x0045 }
            r1.f28465l = r3     // Catch:{ all -> 0x0045 }
            okhttp3.internal.a.d r1 = okhttp3.internal.p697a.C8394d.this     // Catch:{ all -> 0x0045 }
            okio.q r2 = okio.C8535k.m36850a()     // Catch:{ all -> 0x0045 }
            okio.d r2 = okio.C8535k.m36848a(r2)     // Catch:{ all -> 0x0045 }
            r1.f28458e = r2     // Catch:{ all -> 0x0045 }
        L_0x0043:
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            return
        L_0x0045:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.p697a.C8394d.C83951.run():void");
        }
    };

    /* compiled from: DiskLruCache */
    /* renamed from: okhttp3.internal.a.d$a */
    public final class C8397a {
        /* renamed from: a */
        final C8399b f28478a;
        /* renamed from: b */
        final boolean[] f28479b;
        /* renamed from: d */
        private boolean f28481d;

        C8397a(C8399b bVar) {
            this.f28478a = bVar;
            this.f28479b = bVar.f28487e ? null : new boolean[C8394d.this.f28457d];
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo40222a() {
            if (this.f28478a.f28488f == this) {
                for (int i = 0; i < C8394d.this.f28457d; i++) {
                    try {
                        C8394d.this.f28455b.mo40316d(this.f28478a.f28486d[i]);
                    } catch (IOException unused) {
                    }
                }
                this.f28478a.f28488f = null;
            }
        }

        /* renamed from: a */
        public C8546q mo40221a(int i) {
            synchronized (C8394d.this) {
                if (this.f28481d) {
                    throw new IllegalStateException();
                } else if (this.f28478a.f28488f != this) {
                    C8546q a = C8535k.m36850a();
                    return a;
                } else {
                    if (!this.f28478a.f28487e) {
                        this.f28479b[i] = true;
                    }
                    try {
                        C83981 r1 = new FaultHidingSink(C8394d.this.f28455b.mo40314b(this.f28478a.f28486d[i])) {
                            /* access modifiers changed from: protected */
                            /* renamed from: a */
                            public void mo40220a(IOException iOException) {
                                synchronized (C8394d.this) {
                                    C8397a.this.mo40222a();
                                }
                            }
                        };
                        return r1;
                    } catch (FileNotFoundException unused) {
                        return C8535k.m36850a();
                    }
                }
            }
        }

        /* renamed from: b */
        public void mo40223b() throws IOException {
            synchronized (C8394d.this) {
                if (!this.f28481d) {
                    if (this.f28478a.f28488f == this) {
                        C8394d.this.mo40208a(this, true);
                    }
                    this.f28481d = true;
                } else {
                    throw new IllegalStateException();
                }
            }
        }

        /* renamed from: c */
        public void mo40224c() throws IOException {
            synchronized (C8394d.this) {
                if (!this.f28481d) {
                    if (this.f28478a.f28488f == this) {
                        C8394d.this.mo40208a(this, false);
                    }
                    this.f28481d = true;
                } else {
                    throw new IllegalStateException();
                }
            }
        }
    }

    /* compiled from: DiskLruCache */
    /* renamed from: okhttp3.internal.a.d$b */
    private final class C8399b {
        /* renamed from: a */
        final String f28483a;
        /* renamed from: b */
        final long[] f28484b;
        /* renamed from: c */
        final File[] f28485c;
        /* renamed from: d */
        final File[] f28486d;
        /* renamed from: e */
        boolean f28487e;
        /* renamed from: f */
        C8397a f28488f;
        /* renamed from: g */
        long f28489g;

        C8399b(String str) {
            this.f28483a = str;
            this.f28484b = new long[C8394d.this.f28457d];
            this.f28485c = new File[C8394d.this.f28457d];
            this.f28486d = new File[C8394d.this.f28457d];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < C8394d.this.f28457d; i++) {
                sb.append(i);
                this.f28485c[i] = new File(C8394d.this.f28456c, sb.toString());
                sb.append(".tmp");
                this.f28486d[i] = new File(C8394d.this.f28456c, sb.toString());
                sb.setLength(length);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo40227a(String[] strArr) throws IOException {
            if (strArr.length == C8394d.this.f28457d) {
                int i = 0;
                while (i < strArr.length) {
                    try {
                        this.f28484b[i] = Long.parseLong(strArr[i]);
                        i++;
                    } catch (NumberFormatException unused) {
                        throw m35948b(strArr);
                    }
                }
                return;
            }
            throw m35948b(strArr);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo40226a(C8528d dVar) throws IOException {
            for (long l : this.f28484b) {
                dVar.mo40765i(32).mo40771l(l);
            }
        }

        /* renamed from: b */
        private IOException m35948b(String[] strArr) throws IOException {
            StringBuilder sb = new StringBuilder();
            sb.append("unexpected journal line: ");
            sb.append(Arrays.toString(strArr));
            throw new IOException(sb.toString());
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C8400c mo40225a() {
            if (Thread.holdsLock(C8394d.this)) {
                C8547r[] rVarArr = new C8547r[C8394d.this.f28457d];
                long[] jArr = (long[]) this.f28484b.clone();
                int i = 0;
                int i2 = 0;
                while (i2 < C8394d.this.f28457d) {
                    try {
                        rVarArr[i2] = C8394d.this.f28455b.mo40312a(this.f28485c[i2]);
                        i2++;
                    } catch (FileNotFoundException unused) {
                        while (i < C8394d.this.f28457d && rVarArr[i] != null) {
                            C8417c.m36040a((Closeable) rVarArr[i]);
                            i++;
                        }
                        try {
                            C8394d.this.mo40209a(this);
                        } catch (IOException unused2) {
                        }
                        return null;
                    }
                }
                C8400c cVar = new C8400c(this.f28483a, this.f28489g, rVarArr, jArr);
                return cVar;
            }
            throw new AssertionError();
        }
    }

    /* compiled from: DiskLruCache */
    /* renamed from: okhttp3.internal.a.d$c */
    public final class C8400c implements Closeable {
        /* renamed from: b */
        private final String f28492b;
        /* renamed from: c */
        private final long f28493c;
        /* renamed from: d */
        private final C8547r[] f28494d;
        /* renamed from: e */
        private final long[] f28495e;

        C8400c(String str, long j, C8547r[] rVarArr, long[] jArr) {
            this.f28492b = str;
            this.f28493c = j;
            this.f28494d = rVarArr;
            this.f28495e = jArr;
        }

        @Nullable
        /* renamed from: a */
        public C8397a mo40228a() throws IOException {
            return C8394d.this.mo40205a(this.f28492b, this.f28493c);
        }

        /* renamed from: a */
        public C8547r mo40229a(int i) {
            return this.f28494d[i];
        }

        public void close() {
            for (C8547r a : this.f28494d) {
                C8417c.m36040a((Closeable) a);
            }
        }
    }

    C8394d(C8437a aVar, File file, int i, int i2, long j, Executor executor) {
        this.f28455b = aVar;
        this.f28456c = file;
        this.f28469q = i;
        this.f28466n = new File(file, "journal");
        this.f28467o = new File(file, "journal.tmp");
        this.f28468p = new File(file, "journal.bkp");
        this.f28457d = i2;
        this.f28470r = j;
        this.f28473u = executor;
    }

    /* renamed from: a */
    public synchronized void mo40207a() throws IOException {
        if (!f28454m) {
            if (!Thread.holdsLock(this)) {
                throw new AssertionError();
            }
        }
        if (!this.f28462i) {
            if (this.f28455b.mo40317e(this.f28468p)) {
                if (this.f28455b.mo40317e(this.f28466n)) {
                    this.f28455b.mo40316d(this.f28468p);
                } else {
                    this.f28455b.mo40313a(this.f28468p, this.f28466n);
                }
            }
            if (this.f28455b.mo40317e(this.f28466n)) {
                try {
                    m35926g();
                    m35928i();
                    this.f28462i = true;
                    return;
                } catch (IOException e) {
                    C8447f c = C8447f.m36198c();
                    StringBuilder sb = new StringBuilder();
                    sb.append("DiskLruCache ");
                    sb.append(this.f28456c);
                    sb.append(" is corrupt: ");
                    sb.append(e.getMessage());
                    sb.append(", removing");
                    c.mo40323a(5, sb.toString(), (Throwable) e);
                    mo40217f();
                    this.f28463j = false;
                } catch (Throwable th) {
                    this.f28463j = false;
                    throw th;
                }
            }
            mo40211b();
            this.f28462i = true;
        }
    }

    /* renamed from: a */
    public static C8394d m35923a(C8437a aVar, File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 > 0) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), C8417c.m36037a("OkHttp DiskLruCache", true));
            C8394d dVar = new C8394d(aVar, file, i, i2, j, threadPoolExecutor);
            return dVar;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|(1:19)(1:20)|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            r9.f28460g = r0 - r9.f28459f.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006a, code lost:
            if (r1.mo40755f() == false) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006c, code lost:
            mo40211b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
            r9.f28458e = m35927h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0079, code lost:
            return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005d */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x007a=Splitter:B:23:0x007a, B:16:0x005d=Splitter:B:16:0x005d} */
    /* renamed from: g */
    private void m35926g() throws java.io.IOException {
        /*
        r9 = this;
        java.lang.String r0 = ", "
        okhttp3.internal.d.a r1 = r9.f28455b
        java.io.File r2 = r9.f28466n
        okio.r r1 = r1.mo40312a(r2)
        okio.e r1 = okio.C8535k.m36849a(r1)
        java.lang.String r2 = r1.mo40778r()     // Catch:{ all -> 0x00a8 }
        java.lang.String r3 = r1.mo40778r()     // Catch:{ all -> 0x00a8 }
        java.lang.String r4 = r1.mo40778r()     // Catch:{ all -> 0x00a8 }
        java.lang.String r5 = r1.mo40778r()     // Catch:{ all -> 0x00a8 }
        java.lang.String r6 = r1.mo40778r()     // Catch:{ all -> 0x00a8 }
        java.lang.String r7 = "libcore.io.DiskLruCache"
        boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x00a8 }
        if (r7 == 0) goto L_0x007a
        java.lang.String r7 = "1"
        boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x00a8 }
        if (r7 == 0) goto L_0x007a
        int r7 = r9.f28469q     // Catch:{ all -> 0x00a8 }
        java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x00a8 }
        boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x00a8 }
        if (r4 == 0) goto L_0x007a
        int r4 = r9.f28457d     // Catch:{ all -> 0x00a8 }
        java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x00a8 }
        boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00a8 }
        if (r4 == 0) goto L_0x007a
        java.lang.String r4 = ""
        boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x00a8 }
        if (r4 == 0) goto L_0x007a
        r0 = 0
    L_0x0053:
        java.lang.String r2 = r1.mo40778r()     // Catch:{ EOFException -> 0x005d }
        r9.m35924d(r2)     // Catch:{ EOFException -> 0x005d }
        int r0 = r0 + 1
        goto L_0x0053
    L_0x005d:
        java.util.LinkedHashMap<java.lang.String, okhttp3.internal.a.d$b> r2 = r9.f28459f     // Catch:{ all -> 0x00a8 }
        int r2 = r2.size()     // Catch:{ all -> 0x00a8 }
        int r0 = r0 - r2
        r9.f28460g = r0     // Catch:{ all -> 0x00a8 }
        boolean r0 = r1.mo40755f()     // Catch:{ all -> 0x00a8 }
        if (r0 != 0) goto L_0x0070
        r9.mo40211b()     // Catch:{ all -> 0x00a8 }
        goto L_0x0076
    L_0x0070:
        okio.d r0 = r9.m35927h()     // Catch:{ all -> 0x00a8 }
        r9.f28458e = r0     // Catch:{ all -> 0x00a8 }
    L_0x0076:
        okhttp3.internal.C8417c.m36040a(r1)
        return
    L_0x007a:
        java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x00a8 }
        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a8 }
        r7.<init>()     // Catch:{ all -> 0x00a8 }
        java.lang.String r8 = "unexpected journal header: ["
        r7.append(r8)     // Catch:{ all -> 0x00a8 }
        r7.append(r2)     // Catch:{ all -> 0x00a8 }
        r7.append(r0)     // Catch:{ all -> 0x00a8 }
        r7.append(r3)     // Catch:{ all -> 0x00a8 }
        r7.append(r0)     // Catch:{ all -> 0x00a8 }
        r7.append(r5)     // Catch:{ all -> 0x00a8 }
        r7.append(r0)     // Catch:{ all -> 0x00a8 }
        r7.append(r6)     // Catch:{ all -> 0x00a8 }
        java.lang.String r0 = "]"
        r7.append(r0)     // Catch:{ all -> 0x00a8 }
        java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x00a8 }
        r4.<init>(r0)     // Catch:{ all -> 0x00a8 }
        throw r4     // Catch:{ all -> 0x00a8 }
    L_0x00a8:
        r0 = move-exception
        okhttp3.internal.C8417c.m36040a(r1)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.p697a.C8394d.m35926g():void");
    }

    /* renamed from: h */
    private C8528d m35927h() throws FileNotFoundException {
        return C8535k.m36848a((C8546q) new FaultHidingSink(this.f28455b.mo40315c(this.f28466n)) {
            /* renamed from: a */
            static final /* synthetic */ boolean f28476a = (!C8394d.class.desiredAssertionStatus());

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo40220a(IOException iOException) {
                if (f28476a || Thread.holdsLock(C8394d.this)) {
                    C8394d.this.f28461h = true;
                    return;
                }
                throw new AssertionError();
            }
        });
    }

    /* renamed from: d */
    private void m35924d(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        String str3 = "unexpected journal line: ";
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                str2 = str.substring(i);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f28459f.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i, indexOf2);
            }
            C8399b bVar = (C8399b) this.f28459f.get(str2);
            if (bVar == null) {
                bVar = new C8399b(str2);
                this.f28459f.put(str2, bVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                bVar.f28487e = true;
                bVar.f28488f = null;
                bVar.mo40227a(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                bVar.f28488f = new C8397a(bVar);
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

    /* renamed from: i */
    private void m35928i() throws IOException {
        this.f28455b.mo40316d(this.f28467o);
        Iterator it = this.f28459f.values().iterator();
        while (it.hasNext()) {
            C8399b bVar = (C8399b) it.next();
            int i = 0;
            if (bVar.f28488f == null) {
                while (i < this.f28457d) {
                    this.f28471s += bVar.f28484b[i];
                    i++;
                }
            } else {
                bVar.f28488f = null;
                while (i < this.f28457d) {
                    this.f28455b.mo40316d(bVar.f28485c[i]);
                    this.f28455b.mo40316d(bVar.f28486d[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: declared_synchronized */
    /* renamed from: b */
    public synchronized void mo40211b() throws IOException {
        if (this.f28458e != null) {
            this.f28458e.close();
        }
        C8528d a = C8535k.m36848a(this.f28455b.mo40314b(this.f28467o));
        try {
            a.mo40738b("libcore.io.DiskLruCache").mo40765i(10);
            a.mo40738b("1").mo40765i(10);
            a.mo40771l((long) this.f28469q).mo40765i(10);
            a.mo40771l((long) this.f28457d).mo40765i(10);
            a.mo40765i(10);
            for (C8399b bVar : this.f28459f.values()) {
                if (bVar.f28488f != null) {
                    a.mo40738b("DIRTY").mo40765i(32);
                    a.mo40738b(bVar.f28483a);
                    a.mo40765i(10);
                } else {
                    a.mo40738b("CLEAN").mo40765i(32);
                    a.mo40738b(bVar.f28483a);
                    bVar.mo40226a(a);
                    a.mo40765i(10);
                }
            }
            a.close();
            if (this.f28455b.mo40317e(this.f28466n)) {
                this.f28455b.mo40313a(this.f28466n, this.f28468p);
            }
            this.f28455b.mo40313a(this.f28467o, this.f28466n);
            this.f28455b.mo40316d(this.f28468p);
            this.f28458e = m35927h();
            this.f28461h = false;
            this.f28465l = false;
        } catch (Throwable th) {
            a.close();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
            return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
            return null;
     */
    /* renamed from: a */
    public synchronized okhttp3.internal.p697a.C8394d.C8400c mo40206a(java.lang.String r4) throws java.io.IOException {
        /*
        r3 = this;
        monitor-enter(r3)
        r3.mo40207a()     // Catch:{ all -> 0x0050 }
        r3.m35929j()     // Catch:{ all -> 0x0050 }
        r3.m35925e(r4)     // Catch:{ all -> 0x0050 }
        java.util.LinkedHashMap<java.lang.String, okhttp3.internal.a.d$b> r0 = r3.f28459f     // Catch:{ all -> 0x0050 }
        java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0050 }
        okhttp3.internal.a.d$b r0 = (okhttp3.internal.p697a.C8394d.C8399b) r0     // Catch:{ all -> 0x0050 }
        r1 = 0
        if (r0 == 0) goto L_0x004e
        boolean r2 = r0.f28487e     // Catch:{ all -> 0x0050 }
        if (r2 != 0) goto L_0x001a
        goto L_0x004e
    L_0x001a:
        okhttp3.internal.a.d$c r0 = r0.mo40225a()     // Catch:{ all -> 0x0050 }
        if (r0 != 0) goto L_0x0022
        monitor-exit(r3)
        return r1
    L_0x0022:
        int r1 = r3.f28460g     // Catch:{ all -> 0x0050 }
        int r1 = r1 + 1
        r3.f28460g = r1     // Catch:{ all -> 0x0050 }
        okio.d r1 = r3.f28458e     // Catch:{ all -> 0x0050 }
        java.lang.String r2 = "READ"
        okio.d r1 = r1.mo40738b(r2)     // Catch:{ all -> 0x0050 }
        r2 = 32
        okio.d r1 = r1.mo40765i(r2)     // Catch:{ all -> 0x0050 }
        okio.d r4 = r1.mo40738b(r4)     // Catch:{ all -> 0x0050 }
        r1 = 10
        r4.mo40765i(r1)     // Catch:{ all -> 0x0050 }
        boolean r4 = r3.mo40212c()     // Catch:{ all -> 0x0050 }
        if (r4 == 0) goto L_0x004c
        java.util.concurrent.Executor r4 = r3.f28473u     // Catch:{ all -> 0x0050 }
        java.lang.Runnable r1 = r3.f28474v     // Catch:{ all -> 0x0050 }
        r4.execute(r1)     // Catch:{ all -> 0x0050 }
    L_0x004c:
        monitor-exit(r3)
        return r0
    L_0x004e:
        monitor-exit(r3)
        return r1
    L_0x0050:
        r4 = move-exception
        monitor-exit(r3)
        throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.p697a.C8394d.mo40206a(java.lang.String):okhttp3.internal.a.d$c");
    }

    @Nullable
    /* renamed from: b */
    public C8397a mo40210b(String str) throws IOException {
        return mo40205a(str, -1);
    }

    /* access modifiers changed from: declared_synchronized */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
            return null;
     */
    /* renamed from: a */
    public synchronized okhttp3.internal.p697a.C8394d.C8397a mo40205a(java.lang.String r6, long r7) throws java.io.IOException {
        /*
        r5 = this;
        monitor-enter(r5)
        r5.mo40207a()     // Catch:{ all -> 0x0074 }
        r5.m35929j()     // Catch:{ all -> 0x0074 }
        r5.m35925e(r6)     // Catch:{ all -> 0x0074 }
        java.util.LinkedHashMap<java.lang.String, okhttp3.internal.a.d$b> r0 = r5.f28459f     // Catch:{ all -> 0x0074 }
        java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0074 }
        okhttp3.internal.a.d$b r0 = (okhttp3.internal.p697a.C8394d.C8399b) r0     // Catch:{ all -> 0x0074 }
        r1 = -1
        r3 = 0
        int r4 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
        if (r4 == 0) goto L_0x0023
        if (r0 == 0) goto L_0x0021
        long r1 = r0.f28489g     // Catch:{ all -> 0x0074 }
        int r4 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
        if (r4 == 0) goto L_0x0023
    L_0x0021:
        monitor-exit(r5)
        return r3
    L_0x0023:
        if (r0 == 0) goto L_0x002b
        okhttp3.internal.a.d$a r7 = r0.f28488f     // Catch:{ all -> 0x0074 }
        if (r7 == 0) goto L_0x002b
        monitor-exit(r5)
        return r3
    L_0x002b:
        boolean r7 = r5.f28464k     // Catch:{ all -> 0x0074 }
        if (r7 != 0) goto L_0x006b
        boolean r7 = r5.f28465l     // Catch:{ all -> 0x0074 }
        if (r7 == 0) goto L_0x0034
        goto L_0x006b
    L_0x0034:
        okio.d r7 = r5.f28458e     // Catch:{ all -> 0x0074 }
        java.lang.String r8 = "DIRTY"
        okio.d r7 = r7.mo40738b(r8)     // Catch:{ all -> 0x0074 }
        r8 = 32
        okio.d r7 = r7.mo40765i(r8)     // Catch:{ all -> 0x0074 }
        okio.d r7 = r7.mo40738b(r6)     // Catch:{ all -> 0x0074 }
        r8 = 10
        r7.mo40765i(r8)     // Catch:{ all -> 0x0074 }
        okio.d r7 = r5.f28458e     // Catch:{ all -> 0x0074 }
        r7.flush()     // Catch:{ all -> 0x0074 }
        boolean r7 = r5.f28461h     // Catch:{ all -> 0x0074 }
        if (r7 == 0) goto L_0x0056
        monitor-exit(r5)
        return r3
    L_0x0056:
        if (r0 != 0) goto L_0x0062
        okhttp3.internal.a.d$b r0 = new okhttp3.internal.a.d$b     // Catch:{ all -> 0x0074 }
        r0.m55397init(r6)     // Catch:{ all -> 0x0074 }
        java.util.LinkedHashMap<java.lang.String, okhttp3.internal.a.d$b> r7 = r5.f28459f     // Catch:{ all -> 0x0074 }
        r7.put(r6, r0)     // Catch:{ all -> 0x0074 }
    L_0x0062:
        okhttp3.internal.a.d$a r6 = new okhttp3.internal.a.d$a     // Catch:{ all -> 0x0074 }
        r6.m55395init(r0)     // Catch:{ all -> 0x0074 }
        r0.f28488f = r6     // Catch:{ all -> 0x0074 }
        monitor-exit(r5)
        return r6
    L_0x006b:
        java.util.concurrent.Executor r6 = r5.f28473u     // Catch:{ all -> 0x0074 }
        java.lang.Runnable r7 = r5.f28474v     // Catch:{ all -> 0x0074 }
        r6.execute(r7)     // Catch:{ all -> 0x0074 }
        monitor-exit(r5)
        return r3
    L_0x0074:
        r6 = move-exception
        monitor-exit(r5)
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.p697a.C8394d.mo40205a(java.lang.String, long):okhttp3.internal.a.d$a");
    }

    /* access modifiers changed from: declared_synchronized */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f4, code lost:
            return;
     */
    /* renamed from: a */
    public synchronized void mo40208a(okhttp3.internal.p697a.C8394d.C8397a r10, boolean r11) throws java.io.IOException {
        /*
        r9 = this;
        monitor-enter(r9)
        okhttp3.internal.a.d$b r0 = r10.f28478a     // Catch:{ all -> 0x00fb }
        okhttp3.internal.a.d$a r1 = r0.f28488f     // Catch:{ all -> 0x00fb }
        if (r1 != r10) goto L_0x00f5
        r1 = 0
        if (r11 == 0) goto L_0x0047
        boolean r2 = r0.f28487e     // Catch:{ all -> 0x00fb }
        if (r2 != 0) goto L_0x0047
        r2 = 0
    L_0x000f:
        int r3 = r9.f28457d     // Catch:{ all -> 0x00fb }
        if (r2 >= r3) goto L_0x0047
        boolean[] r3 = r10.f28479b     // Catch:{ all -> 0x00fb }
        boolean r3 = r3[r2]     // Catch:{ all -> 0x00fb }
        if (r3 == 0) goto L_0x002d
        okhttp3.internal.d.a r3 = r9.f28455b     // Catch:{ all -> 0x00fb }
        java.io.File[] r4 = r0.f28486d     // Catch:{ all -> 0x00fb }
        r4 = r4[r2]     // Catch:{ all -> 0x00fb }
        boolean r3 = r3.mo40317e(r4)     // Catch:{ all -> 0x00fb }
        if (r3 != 0) goto L_0x002a
        r10.mo40224c()     // Catch:{ all -> 0x00fb }
        monitor-exit(r9)
        return
    L_0x002a:
        int r2 = r2 + 1
        goto L_0x000f
    L_0x002d:
        r10.mo40224c()     // Catch:{ all -> 0x00fb }
        java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00fb }
        java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fb }
        r11.<init>()     // Catch:{ all -> 0x00fb }
        java.lang.String r0 = "Newly created entry didn't create value for index "
        r11.append(r0)     // Catch:{ all -> 0x00fb }
        r11.append(r2)     // Catch:{ all -> 0x00fb }
        java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00fb }
        r10.<init>(r11)     // Catch:{ all -> 0x00fb }
        throw r10     // Catch:{ all -> 0x00fb }
    L_0x0047:
        int r10 = r9.f28457d     // Catch:{ all -> 0x00fb }
        if (r1 >= r10) goto L_0x007f
        java.io.File[] r10 = r0.f28486d     // Catch:{ all -> 0x00fb }
        r10 = r10[r1]     // Catch:{ all -> 0x00fb }
        if (r11 == 0) goto L_0x0077
        okhttp3.internal.d.a r2 = r9.f28455b     // Catch:{ all -> 0x00fb }
        boolean r2 = r2.mo40317e(r10)     // Catch:{ all -> 0x00fb }
        if (r2 == 0) goto L_0x007c
        java.io.File[] r2 = r0.f28485c     // Catch:{ all -> 0x00fb }
        r2 = r2[r1]     // Catch:{ all -> 0x00fb }
        okhttp3.internal.d.a r3 = r9.f28455b     // Catch:{ all -> 0x00fb }
        r3.mo40313a(r10, r2)     // Catch:{ all -> 0x00fb }
        long[] r10 = r0.f28484b     // Catch:{ all -> 0x00fb }
        r3 = r10[r1]     // Catch:{ all -> 0x00fb }
        okhttp3.internal.d.a r10 = r9.f28455b     // Catch:{ all -> 0x00fb }
        long r5 = r10.mo40318f(r2)     // Catch:{ all -> 0x00fb }
        long[] r10 = r0.f28484b     // Catch:{ all -> 0x00fb }
        r10[r1] = r5     // Catch:{ all -> 0x00fb }
        long r7 = r9.f28471s     // Catch:{ all -> 0x00fb }
        long r7 = r7 - r3
        long r7 = r7 + r5
        r9.f28471s = r7     // Catch:{ all -> 0x00fb }
        goto L_0x007c
    L_0x0077:
        okhttp3.internal.d.a r2 = r9.f28455b     // Catch:{ all -> 0x00fb }
        r2.mo40316d(r10)     // Catch:{ all -> 0x00fb }
    L_0x007c:
        int r1 = r1 + 1
        goto L_0x0047
    L_0x007f:
        int r10 = r9.f28460g     // Catch:{ all -> 0x00fb }
        r1 = 1
        int r10 = r10 + r1
        r9.f28460g = r10     // Catch:{ all -> 0x00fb }
        r10 = 0
        r0.f28488f = r10     // Catch:{ all -> 0x00fb }
        boolean r10 = r0.f28487e     // Catch:{ all -> 0x00fb }
        r10 = r10 | r11
        r2 = 10
        r3 = 32
        if (r10 == 0) goto L_0x00bb
        r0.f28487e = r1     // Catch:{ all -> 0x00fb }
        okio.d r10 = r9.f28458e     // Catch:{ all -> 0x00fb }
        java.lang.String r1 = "CLEAN"
        okio.d r10 = r10.mo40738b(r1)     // Catch:{ all -> 0x00fb }
        r10.mo40765i(r3)     // Catch:{ all -> 0x00fb }
        okio.d r10 = r9.f28458e     // Catch:{ all -> 0x00fb }
        java.lang.String r1 = r0.f28483a     // Catch:{ all -> 0x00fb }
        r10.mo40738b(r1)     // Catch:{ all -> 0x00fb }
        okio.d r10 = r9.f28458e     // Catch:{ all -> 0x00fb }
        r0.mo40226a(r10)     // Catch:{ all -> 0x00fb }
        okio.d r10 = r9.f28458e     // Catch:{ all -> 0x00fb }
        r10.mo40765i(r2)     // Catch:{ all -> 0x00fb }
        if (r11 == 0) goto L_0x00d9
        long r10 = r9.f28472t     // Catch:{ all -> 0x00fb }
        r1 = 1
        long r1 = r1 + r10
        r9.f28472t = r1     // Catch:{ all -> 0x00fb }
        r0.f28489g = r10     // Catch:{ all -> 0x00fb }
        goto L_0x00d9
    L_0x00bb:
        java.util.LinkedHashMap<java.lang.String, okhttp3.internal.a.d$b> r10 = r9.f28459f     // Catch:{ all -> 0x00fb }
        java.lang.String r11 = r0.f28483a     // Catch:{ all -> 0x00fb }
        r10.remove(r11)     // Catch:{ all -> 0x00fb }
        okio.d r10 = r9.f28458e     // Catch:{ all -> 0x00fb }
        java.lang.String r11 = "REMOVE"
        okio.d r10 = r10.mo40738b(r11)     // Catch:{ all -> 0x00fb }
        r10.mo40765i(r3)     // Catch:{ all -> 0x00fb }
        okio.d r10 = r9.f28458e     // Catch:{ all -> 0x00fb }
        java.lang.String r11 = r0.f28483a     // Catch:{ all -> 0x00fb }
        r10.mo40738b(r11)     // Catch:{ all -> 0x00fb }
        okio.d r10 = r9.f28458e     // Catch:{ all -> 0x00fb }
        r10.mo40765i(r2)     // Catch:{ all -> 0x00fb }
    L_0x00d9:
        okio.d r10 = r9.f28458e     // Catch:{ all -> 0x00fb }
        r10.flush()     // Catch:{ all -> 0x00fb }
        long r10 = r9.f28471s     // Catch:{ all -> 0x00fb }
        long r0 = r9.f28470r     // Catch:{ all -> 0x00fb }
        int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
        if (r2 > 0) goto L_0x00ec
        boolean r10 = r9.mo40212c()     // Catch:{ all -> 0x00fb }
        if (r10 == 0) goto L_0x00f3
    L_0x00ec:
        java.util.concurrent.Executor r10 = r9.f28473u     // Catch:{ all -> 0x00fb }
        java.lang.Runnable r11 = r9.f28474v     // Catch:{ all -> 0x00fb }
        r10.execute(r11)     // Catch:{ all -> 0x00fb }
    L_0x00f3:
        monitor-exit(r9)
        return
    L_0x00f5:
        java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00fb }
        r10.<init>()     // Catch:{ all -> 0x00fb }
        throw r10     // Catch:{ all -> 0x00fb }
    L_0x00fb:
        r10 = move-exception
        monitor-exit(r9)
        throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.p697a.C8394d.mo40208a(okhttp3.internal.a.d$a, boolean):void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo40212c() {
        int i = this.f28460g;
        return i >= 2000 && i >= this.f28459f.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
            return r7;
     */
    /* renamed from: c */
    public synchronized boolean mo40213c(java.lang.String r7) throws java.io.IOException {
        /*
        r6 = this;
        monitor-enter(r6)
        r6.mo40207a()     // Catch:{ all -> 0x0029 }
        r6.m35929j()     // Catch:{ all -> 0x0029 }
        r6.m35925e(r7)     // Catch:{ all -> 0x0029 }
        java.util.LinkedHashMap<java.lang.String, okhttp3.internal.a.d$b> r0 = r6.f28459f     // Catch:{ all -> 0x0029 }
        java.lang.Object r7 = r0.get(r7)     // Catch:{ all -> 0x0029 }
        okhttp3.internal.a.d$b r7 = (okhttp3.internal.p697a.C8394d.C8399b) r7     // Catch:{ all -> 0x0029 }
        r0 = 0
        if (r7 != 0) goto L_0x0017
        monitor-exit(r6)
        return r0
    L_0x0017:
        boolean r7 = r6.mo40209a(r7)     // Catch:{ all -> 0x0029 }
        if (r7 == 0) goto L_0x0027
        long r1 = r6.f28471s     // Catch:{ all -> 0x0029 }
        long r3 = r6.f28470r     // Catch:{ all -> 0x0029 }
        int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
        if (r5 > 0) goto L_0x0027
        r6.f28464k = r0     // Catch:{ all -> 0x0029 }
    L_0x0027:
        monitor-exit(r6)
        return r7
    L_0x0029:
        r7 = move-exception
        monitor-exit(r6)
        throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.p697a.C8394d.mo40213c(java.lang.String):boolean");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo40209a(C8399b bVar) throws IOException {
        if (bVar.f28488f != null) {
            bVar.f28488f.mo40222a();
        }
        for (int i = 0; i < this.f28457d; i++) {
            this.f28455b.mo40316d(bVar.f28485c[i]);
            this.f28471s -= bVar.f28484b[i];
            bVar.f28484b[i] = 0;
        }
        this.f28460g++;
        this.f28458e.mo40738b("REMOVE").mo40765i(32).mo40738b(bVar.f28483a).mo40765i(10);
        this.f28459f.remove(bVar.f28483a);
        if (mo40212c()) {
            this.f28473u.execute(this.f28474v);
        }
        return true;
    }

    /* renamed from: d */
    public synchronized boolean mo40215d() {
        return this.f28463j;
    }

    /* renamed from: j */
    private synchronized void m35929j() {
        if (mo40215d()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void flush() throws IOException {
        if (this.f28462i) {
            m35929j();
            mo40216e();
            this.f28458e.flush();
        }
    }

    public synchronized void close() throws IOException {
        C8399b[] bVarArr;
        if (this.f28462i) {
            if (!this.f28463j) {
                for (C8399b bVar : (C8399b[]) this.f28459f.values().toArray(new C8399b[this.f28459f.size()])) {
                    if (bVar.f28488f != null) {
                        bVar.f28488f.mo40224c();
                    }
                }
                mo40216e();
                this.f28458e.close();
                this.f28458e = null;
                this.f28463j = true;
                return;
            }
        }
        this.f28463j = true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo40216e() throws IOException {
        while (this.f28471s > this.f28470r) {
            mo40209a((C8399b) this.f28459f.values().iterator().next());
        }
        this.f28464k = false;
    }

    /* renamed from: f */
    public void mo40217f() throws IOException {
        close();
        this.f28455b.mo40319g(this.f28456c);
    }

    /* renamed from: e */
    private void m35925e(String str) {
        if (!f28453a.matcher(str).matches()) {
            StringBuilder sb = new StringBuilder();
            sb.append("keys must match regex [a-z0-9_-]{1,120}: \"");
            sb.append(str);
            sb.append("\"");
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
