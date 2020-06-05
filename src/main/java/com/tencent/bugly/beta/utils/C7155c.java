package com.tencent.bugly.beta.utils;

import android.util.Log;
import com.tencent.bugly.proguard.C7226an;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.utils.c */
public class C7155c {
    /* renamed from: u */
    private static HashMap<Long, String> f23864u = new HashMap<>();
    /* renamed from: a */
    private C7153a f23865a = null;
    /* renamed from: b */
    private String f23866b = null;
    /* renamed from: c */
    private long f23867c = 0;
    /* renamed from: d */
    private long f23868d = 0;
    /* renamed from: e */
    private HashMap<String, C7157b> f23869e = null;
    /* renamed from: f */
    private byte[] f23870f = new byte[16];
    /* renamed from: g */
    private long f23871g = 0;
    /* renamed from: h */
    private long f23872h = 0;
    /* renamed from: i */
    private String f23873i = null;
    /* renamed from: j */
    private long f23874j = 0;
    /* renamed from: k */
    private long f23875k = 0;
    /* renamed from: l */
    private long f23876l = 0;
    /* renamed from: m */
    private long f23877m = 0;
    /* renamed from: n */
    private long f23878n = 0;
    /* renamed from: o */
    private long f23879o = 0;
    /* renamed from: p */
    private long f23880p = 0;
    /* renamed from: q */
    private long f23881q = 0;
    /* renamed from: r */
    private long f23882r = 0;
    /* renamed from: s */
    private long f23883s = 0;
    /* renamed from: t */
    private long f23884t = 0;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.beta.utils.c$a */
    public static class C7156a {
        /* renamed from: a */
        private long f23885a = -1;
        /* renamed from: b */
        private long f23886b = 0;
        /* renamed from: c */
        private long f23887c = 0;
        /* renamed from: d */
        private long f23888d = -1;
        /* renamed from: e */
        private long f23889e = -1;
        /* renamed from: f */
        private long f23890f = 0;
        /* renamed from: g */
        private long f23891g = 0;
        /* renamed from: h */
        private long f23892h = 0;
        /* renamed from: i */
        private long f23893i = 0;
        /* renamed from: j */
        private long f23894j = 0;

        /* renamed from: a */
        public long mo34489a() {
            return this.f23885a;
        }

        /* renamed from: b */
        public long mo34491b() {
            return this.f23888d;
        }

        /* renamed from: c */
        public long mo34493c() {
            return this.f23889e;
        }

        /* renamed from: d */
        public long mo34495d() {
            return this.f23890f;
        }

        /* renamed from: e */
        public long mo34497e() {
            return this.f23894j;
        }

        /* renamed from: a */
        public synchronized void mo34490a(long j) {
            this.f23885a = j;
        }

        /* renamed from: b */
        public synchronized void mo34492b(long j) {
            this.f23886b = j;
        }

        /* renamed from: c */
        public synchronized void mo34494c(long j) {
            this.f23887c = j;
        }

        /* renamed from: d */
        public synchronized void mo34496d(long j) {
            this.f23889e = j;
        }

        /* renamed from: e */
        public synchronized void mo34498e(long j) {
            this.f23888d = j;
        }

        /* renamed from: f */
        public synchronized void mo34499f(long j) {
            this.f23890f = j;
        }

        /* renamed from: g */
        public synchronized void mo34500g(long j) {
            this.f23891g = j;
        }

        /* renamed from: h */
        public synchronized void mo34501h(long j) {
            this.f23892h = j;
        }

        /* renamed from: i */
        public synchronized void mo34502i(long j) {
            this.f23893i = j;
        }

        /* renamed from: j */
        public synchronized void mo34503j(long j) {
            this.f23894j = j;
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.beta.utils.c$b */
    public static class C7157b {
        /* renamed from: a */
        private String f23895a = null;
        /* renamed from: b */
        private long f23896b = -1;
        /* renamed from: c */
        private long f23897c = -1;
        /* renamed from: d */
        private long f23898d = 0;
        /* renamed from: e */
        private long f23899e = 0;

        /* renamed from: a */
        public long mo34504a() {
            return this.f23897c;
        }

        /* renamed from: a */
        public synchronized void mo34506a(String str) {
            this.f23895a = str;
        }

        /* renamed from: a */
        public synchronized void mo34505a(long j) {
            this.f23896b = j;
        }

        /* renamed from: b */
        public synchronized void mo34507b(long j) {
            this.f23897c = j;
        }

        /* renamed from: c */
        public synchronized void mo34508c(long j) {
            this.f23898d = j;
        }

        /* renamed from: d */
        public synchronized void mo34509d(long j) {
            this.f23899e = j;
        }
    }

    /* renamed from: a */
    private long m30635a(byte b) {
        if (1 == b) {
            return 32;
        }
        return 2 == b ? 64 : 0;
    }

    public C7155c(String str) {
        this.f23866b = str;
        String str2 = "x86";
        f23864u.put(Long.valueOf(3), str2);
        f23864u.put(Long.valueOf(7), str2);
        String str3 = "mips";
        f23864u.put(Long.valueOf(8), str3);
        f23864u.put(Long.valueOf(10), str3);
        f23864u.put(Long.valueOf(40), "armeabi");
        f23864u.put(Long.valueOf(62), "x86_64");
        f23864u.put(Long.valueOf(183), "arm64-v8a");
    }

    /* renamed from: b */
    private String m30640b() {
        return this.f23873i;
    }

    /* renamed from: c */
    private long m30642c() {
        return this.f23877m;
    }

    /* renamed from: d */
    private long m30643d() {
        return this.f23883s;
    }

    /* renamed from: e */
    private long m30644e() {
        return this.f23884t;
    }

    /* renamed from: a */
    public synchronized String mo34488a() {
        if (!m30645f()) {
            Log.e("ElfParser", "Failed to parseElfHeader elf header");
            return null;
        }
        String b = m30640b();
        if (!b.equals("armeabi")) {
            return b;
        }
        if (!m30648i()) {
            Log.e("ElfParser", "Failed to parseElfHeader section table");
            return b;
        }
        C7157b bVar = (C7157b) this.f23869e.get(".ARM.attributes");
        if (bVar == null) {
            Log.e("ElfParser", "No .ARM.attributes section in the elf file");
            return b;
        }
        return C7154b.m30626a(this.f23866b, this.f23868d, bVar.mo34504a());
    }

    /* renamed from: a */
    private static String m30636a(long j, long j2) {
        String str = (String) f23864u.get(Long.valueOf(j));
        return (64 != j2 || !str.equals("mips")) ? str : "mips64";
    }

    /* renamed from: f */
    private boolean m30645f() {
        if (!m30651l()) {
            return false;
        }
        if (!m30646g()) {
            m30649j();
            return false;
        }
        m30649j();
        return true;
    }

    /* renamed from: g */
    private synchronized boolean m30646g() {
        if (!m30647h()) {
            Log.e("ElfParser", "Faile to parseElfHeader header indent of elf");
            return false;
        }
        try {
            this.f23871g = this.f23865a.mo34485g();
            this.f23872h = this.f23865a.mo34485g();
            this.f23873i = m30636a(this.f23872h, this.f23867c);
            this.f23874j = this.f23865a.mo34486h();
            if (32 == this.f23867c) {
                long h = this.f23865a.mo34486h();
                this.f23874j = h;
                this.f23875k = h;
                this.f23876l = this.f23865a.mo34486h();
                this.f23877m = this.f23865a.mo34486h();
            } else if (64 == this.f23867c) {
                long i = this.f23865a.mo34487i();
                this.f23874j = i;
                this.f23875k = i;
                this.f23876l = this.f23865a.mo34487i();
                this.f23877m = this.f23865a.mo34487i();
            } else {
                Log.e("ElfParser", "File format error");
                return false;
            }
            this.f23878n = this.f23865a.mo34486h();
            this.f23879o = this.f23865a.mo34485g();
            this.f23880p = this.f23865a.mo34485g();
            this.f23881q = this.f23865a.mo34485g();
            this.f23882r = this.f23865a.mo34485g();
            this.f23883s = this.f23865a.mo34485g();
            this.f23884t = this.f23865a.mo34485g();
            return true;
        } catch (IOException e) {
            Log.e("ElfParser", e.getMessage());
            return false;
        }
    }

    /* renamed from: h */
    private synchronized boolean m30647h() {
        if (!this.f23865a.mo34478a(this.f23870f)) {
            Log.e("ElfParser", "Fail to parseElfHeader elf indentification");
            return false;
        } else if (!m30638a(this.f23870f)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Not a elf file: ");
            sb.append(this.f23866b);
            Log.e("ElfParser", sb.toString());
            return false;
        } else {
            this.f23867c = m30635a(this.f23870f[4]);
            if (0 == this.f23867c) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("File format error: ");
                sb2.append(this.f23870f[4]);
                Log.e("ElfParser", sb2.toString());
                return false;
            }
            this.f23868d = m30639b(this.f23870f[5]);
            if (C7153a.f23847a == this.f23868d) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Endian error: ");
                sb3.append(this.f23870f[5]);
                Log.e("ElfParser", sb3.toString());
                return false;
            }
            this.f23865a.mo34476a(this.f23868d);
            return true;
        }
    }

    /* renamed from: a */
    private static boolean m30638a(byte[] bArr) {
        if (bArr.length >= 3 && Byte.MAX_VALUE == bArr[0] && 69 == bArr[1] && 76 == bArr[2] && 70 == bArr[3]) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private long m30639b(byte b) {
        if (1 == b) {
            return C7153a.f23849c;
        }
        if (2 == b) {
            return C7153a.f23848b;
        }
        return C7153a.f23847a;
    }

    /* renamed from: i */
    private synchronized boolean m30648i() {
        this.f23869e = m30637a(m30642c(), m30643d(), m30644e());
        if (this.f23869e == null) {
            return false;
        }
        return true;
    }

    /* renamed from: j */
    private synchronized void m30649j() {
        if (this.f23865a != null) {
            if (this.f23865a.mo34477a()) {
                this.f23865a = null;
            }
        }
    }

    /* renamed from: k */
    private synchronized boolean m30650k() {
        if (this.f23865a != null) {
            m30649j();
        }
        try {
            this.f23865a = new C7153a(this.f23866b, this.f23868d);
        } catch (Exception e) {
            Log.e("ElfParser", e.getMessage());
            return false;
        }
        return true;
    }

    /* renamed from: l */
    private synchronized boolean m30651l() {
        if (this.f23865a != null) {
            m30649j();
        }
        try {
            this.f23865a = new C7153a(this.f23866b);
        } catch (Exception e) {
            Log.e("ElfParser", e.getMessage());
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private synchronized HashMap<String, C7157b> m30637a(long j, long j2, long j3) {
        if (!m30650k()) {
            m30649j();
            return null;
        } else if (!this.f23865a.mo34480b(j)) {
            m30649j();
            return null;
        } else {
            HashMap<String, C7157b> b = m30641b(j2, j3);
            m30649j();
            return b;
        }
    }

    /* renamed from: b */
    private synchronized HashMap<String, C7157b> m30641b(long j, long j2) {
        if (j <= 0 || j2 <= 0) {
            C7226an.m31148d("The SO file is invalid or has a shell.", new Object[0]);
            return null;
        }
        Vector vector = new Vector();
        for (int i = 0; ((long) i) < j; i++) {
            vector.add(m30652m());
        }
        C7156a aVar = (C7156a) vector.get((int) j2);
        long length = new File(this.f23866b).length();
        C7226an.m31147c("File length = %d", Long.valueOf(length));
        if (aVar.mo34493c() >= length) {
            C7226an.m31148d("The SO file is invalid or has a shell.", new Object[0]);
            return null;
        }
        C7158d dVar = new C7158d(this.f23866b, aVar.mo34493c(), aVar.mo34495d());
        HashMap<String, C7157b> hashMap = new HashMap<>();
        Iterator it = vector.iterator();
        while (it.hasNext()) {
            C7156a aVar2 = (C7156a) it.next();
            String a = dVar.mo34510a(aVar2.mo34489a());
            C7157b bVar = new C7157b();
            bVar.mo34506a(a);
            bVar.mo34505a(aVar2.mo34491b());
            bVar.mo34507b(aVar2.mo34493c());
            bVar.mo34508c(aVar2.mo34495d());
            bVar.mo34509d(aVar2.mo34497e());
            hashMap.put(a, bVar);
        }
        dVar.mo34511a();
        return hashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00b6, code lost:
            return r0;
     */
    /* renamed from: m */
    private synchronized com.tencent.bugly.beta.utils.C7155c.C7156a m30652m() {
        /*
        r9 = this;
        monitor-enter(r9)
        com.tencent.bugly.beta.utils.c$a r0 = new com.tencent.bugly.beta.utils.c$a     // Catch:{ all -> 0x00d5 }
        r0.m52452init()     // Catch:{ all -> 0x00d5 }
        r1 = 0
        com.tencent.bugly.beta.utils.a r2 = r9.f23865a     // Catch:{ IOException -> 0x00c9 }
        long r2 = r2.mo34486h()     // Catch:{ IOException -> 0x00c9 }
        r0.mo34490a(r2)     // Catch:{ IOException -> 0x00c9 }
        com.tencent.bugly.beta.utils.a r2 = r9.f23865a     // Catch:{ IOException -> 0x00c9 }
        long r2 = r2.mo34486h()     // Catch:{ IOException -> 0x00c9 }
        r0.mo34492b(r2)     // Catch:{ IOException -> 0x00c9 }
        long r2 = r9.f23867c     // Catch:{ IOException -> 0x00c9 }
        r4 = 64
        r6 = 32
        int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
        if (r8 != 0) goto L_0x0048
        com.tencent.bugly.beta.utils.a r2 = r9.f23865a     // Catch:{ IOException -> 0x00c9 }
        long r2 = r2.mo34486h()     // Catch:{ IOException -> 0x00c9 }
        r0.mo34494c(r2)     // Catch:{ IOException -> 0x00c9 }
        com.tencent.bugly.beta.utils.a r2 = r9.f23865a     // Catch:{ IOException -> 0x00c9 }
        long r2 = r2.mo34486h()     // Catch:{ IOException -> 0x00c9 }
        r0.mo34498e(r2)     // Catch:{ IOException -> 0x00c9 }
        com.tencent.bugly.beta.utils.a r2 = r9.f23865a     // Catch:{ IOException -> 0x00c9 }
        long r2 = r2.mo34486h()     // Catch:{ IOException -> 0x00c9 }
        r0.mo34496d(r2)     // Catch:{ IOException -> 0x00c9 }
        com.tencent.bugly.beta.utils.a r2 = r9.f23865a     // Catch:{ IOException -> 0x00c9 }
        long r2 = r2.mo34486h()     // Catch:{ IOException -> 0x00c9 }
        r0.mo34499f(r2)     // Catch:{ IOException -> 0x00c9 }
        goto L_0x0072
    L_0x0048:
        long r2 = r9.f23867c     // Catch:{ IOException -> 0x00c9 }
        int r8 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
        if (r8 != 0) goto L_0x00c0
        com.tencent.bugly.beta.utils.a r2 = r9.f23865a     // Catch:{ IOException -> 0x00c9 }
        long r2 = r2.mo34487i()     // Catch:{ IOException -> 0x00c9 }
        r0.mo34494c(r2)     // Catch:{ IOException -> 0x00c9 }
        com.tencent.bugly.beta.utils.a r2 = r9.f23865a     // Catch:{ IOException -> 0x00c9 }
        long r2 = r2.mo34487i()     // Catch:{ IOException -> 0x00c9 }
        r0.mo34498e(r2)     // Catch:{ IOException -> 0x00c9 }
        com.tencent.bugly.beta.utils.a r2 = r9.f23865a     // Catch:{ IOException -> 0x00c9 }
        long r2 = r2.mo34487i()     // Catch:{ IOException -> 0x00c9 }
        r0.mo34496d(r2)     // Catch:{ IOException -> 0x00c9 }
        com.tencent.bugly.beta.utils.a r2 = r9.f23865a     // Catch:{ IOException -> 0x00c9 }
        long r2 = r2.mo34487i()     // Catch:{ IOException -> 0x00c9 }
        r0.mo34499f(r2)     // Catch:{ IOException -> 0x00c9 }
    L_0x0072:
        com.tencent.bugly.beta.utils.a r2 = r9.f23865a     // Catch:{ IOException -> 0x00c9 }
        long r2 = r2.mo34486h()     // Catch:{ IOException -> 0x00c9 }
        r0.mo34500g(r2)     // Catch:{ IOException -> 0x00c9 }
        com.tencent.bugly.beta.utils.a r2 = r9.f23865a     // Catch:{ IOException -> 0x00c9 }
        long r2 = r2.mo34486h()     // Catch:{ IOException -> 0x00c9 }
        r0.mo34501h(r2)     // Catch:{ IOException -> 0x00c9 }
        long r2 = r9.f23867c     // Catch:{ IOException -> 0x00c9 }
        int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
        if (r8 != 0) goto L_0x009d
        com.tencent.bugly.beta.utils.a r2 = r9.f23865a     // Catch:{ IOException -> 0x00c9 }
        long r2 = r2.mo34486h()     // Catch:{ IOException -> 0x00c9 }
        r0.mo34502i(r2)     // Catch:{ IOException -> 0x00c9 }
        com.tencent.bugly.beta.utils.a r2 = r9.f23865a     // Catch:{ IOException -> 0x00c9 }
        long r2 = r2.mo34486h()     // Catch:{ IOException -> 0x00c9 }
        r0.mo34503j(r2)     // Catch:{ IOException -> 0x00c9 }
        goto L_0x00b5
    L_0x009d:
        long r2 = r9.f23867c     // Catch:{ IOException -> 0x00c9 }
        int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
        if (r6 != 0) goto L_0x00b7
        com.tencent.bugly.beta.utils.a r2 = r9.f23865a     // Catch:{ IOException -> 0x00c9 }
        long r2 = r2.mo34487i()     // Catch:{ IOException -> 0x00c9 }
        r0.mo34502i(r2)     // Catch:{ IOException -> 0x00c9 }
        com.tencent.bugly.beta.utils.a r2 = r9.f23865a     // Catch:{ IOException -> 0x00c9 }
        long r2 = r2.mo34487i()     // Catch:{ IOException -> 0x00c9 }
        r0.mo34503j(r2)     // Catch:{ IOException -> 0x00c9 }
    L_0x00b5:
        monitor-exit(r9)
        return r0
    L_0x00b7:
        java.lang.String r0 = "ElfParser"
        java.lang.String r2 = "File format error"
        android.util.Log.e(r0, r2)     // Catch:{ IOException -> 0x00c9 }
        monitor-exit(r9)
        return r1
    L_0x00c0:
        java.lang.String r0 = "ElfParser"
        java.lang.String r2 = "File format error"
        android.util.Log.e(r0, r2)     // Catch:{ IOException -> 0x00c9 }
        monitor-exit(r9)
        return r1
    L_0x00c9:
        r0 = move-exception
        java.lang.String r2 = "ElfParser"
        java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x00d5 }
        android.util.Log.e(r2, r0)     // Catch:{ all -> 0x00d5 }
        monitor-exit(r9)
        return r1
    L_0x00d5:
        r0 = move-exception
        monitor-exit(r9)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.utils.C7155c.m30652m():com.tencent.bugly.beta.utils.c$a");
    }
}
