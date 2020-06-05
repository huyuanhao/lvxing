package com.tencent.p605ep.commonbase.apkparser;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import epco.C7944a;
import epco.C7949b;
import epco.C7956c;
import epco.C7964e;
import epco.C7967f;
import epco.C7969g;
import epco.C7972h;
import epco.C7974i;
import epco.C7982l;
import epco.C7984m;
import epco.C7986n;
import epco.C8007w0;
import epco.C8012z;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: com.tencent.ep.commonbase.apkparser.a */
public class C7293a implements Closeable {
    /* renamed from: i */
    private static final Locale f24728i = Locale.US;
    /* renamed from: a */
    private C8012z f24729a;
    /* renamed from: b */
    private String f24730b;
    /* renamed from: c */
    private C7944a f24731c;
    /* renamed from: d */
    private Set<Locale> f24732d;
    /* renamed from: e */
    private C7949b f24733e;
    /* renamed from: f */
    private final ZipFile f24734f;
    /* renamed from: g */
    private File f24735g;
    /* renamed from: h */
    private Locale f24736h = f24728i;

    /* renamed from: com.tencent.ep.commonbase.apkparser.a$a */
    public static final class C7294a {
        /* renamed from: a */
        public static final int f24737a = 0;
        /* renamed from: b */
        public static final int f24738b = 1;
        /* renamed from: c */
        public static final int f24739c = 2;
    }

    /* renamed from: com.tencent.ep.commonbase.apkparser.a$b */
    public static class C7295b extends RuntimeException {
        public C7295b(String str, Throwable th) {
            super(str, th);
        }
    }

    private C7293a(File file) {
        try {
            this.f24735g = file;
            this.f24734f = new ZipFile(file);
        } catch (IOException e) {
            throw new C7295b(String.format("Invalid APK: %s", new Object[]{file.getAbsolutePath()}), e);
        }
    }

    /* renamed from: a */
    public static C7293a m31496a(ApplicationInfo applicationInfo) {
        return new C7293a(new File(applicationInfo.sourceDir));
    }

    /* renamed from: a */
    public static C7293a m31497a(PackageInfo packageInfo) {
        return new C7293a(new File(packageInfo.applicationInfo.sourceDir));
    }

    /* renamed from: a */
    public static C7293a m31498a(PackageManager packageManager, String str) {
        return new C7293a(new File(packageManager.getApplicationInfo(str, 0).sourceDir));
    }

    /* renamed from: a */
    public static C7293a m31499a(File file) {
        return new C7293a(file);
    }

    /* renamed from: a */
    private void m31500a(String str, C7982l lVar) {
        ZipEntry a = C8007w0.m34698a(this.f24734f, str);
        if (a != null) {
            if (this.f24729a == null) {
                m31505k();
            }
            try {
                C7967f fVar = new C7967f(ByteBuffer.wrap(C8007w0.m34701a(this.f24734f.getInputStream(a))), this.f24729a);
                fVar.mo38327a(this.f24736h);
                fVar.mo38326a(lVar);
                fVar.mo38329c();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: c */
    public static C7293a m31501c(String str) {
        return new C7293a(new File(str));
    }

    /* renamed from: h */
    private void m31502h() {
        if (this.f24730b == null) {
            m31504j();
        }
    }

    /* renamed from: i */
    private void m31503i() {
        ZipEntry zipEntry;
        Enumeration entries = this.f24734f.entries();
        while (true) {
            if (!entries.hasMoreElements()) {
                zipEntry = null;
                break;
            }
            zipEntry = (ZipEntry) entries.nextElement();
            if (!zipEntry.getName().contains("../")) {
                if (!zipEntry.isDirectory()) {
                    if (zipEntry.getName().toUpperCase().endsWith(".RSA") || zipEntry.getName().toUpperCase().endsWith(".DSA")) {
                        break;
                    }
                }
            }
        }
        if (zipEntry != null) {
            InputStream inputStream = this.f24734f.getInputStream(zipEntry);
            this.f24733e = new C7969g(inputStream).mo38338a();
            inputStream.close();
            return;
        }
        throw new IOException("ApkParser certificate not found");
    }

    /* renamed from: j */
    private void m31504j() {
        C7984m mVar = new C7984m();
        C7964e eVar = new C7964e();
        m31500a(C7986n.f27118b, (C7982l) new C7972h(mVar, eVar));
        this.f24730b = mVar.mo38385a();
        if (this.f24730b != null) {
            this.f24731c = eVar.mo38311a();
            return;
        }
        throw new IOException("manifest xml not exists");
    }

    /* renamed from: k */
    private void m31505k() {
        Set<Locale> a;
        ZipEntry a2 = C8007w0.m34698a(this.f24734f, C7986n.f27117a);
        if (a2 == null) {
            this.f24729a = new C8012z();
            a = Collections.emptySet();
        } else {
            this.f24729a = new C8012z();
            this.f24732d = Collections.emptySet();
            C7974i iVar = new C7974i(ByteBuffer.wrap(C8007w0.m34701a(this.f24734f.getInputStream(a2))));
            iVar.mo38360c();
            this.f24729a = iVar.mo38359b();
            a = iVar.mo38358a();
        }
        this.f24732d = a;
    }

    /* renamed from: a */
    public C7944a mo35367a() {
        if (this.f24731c == null) {
            m31502h();
        }
        return this.f24731c;
    }

    /* renamed from: a */
    public void mo35368a(Locale locale) {
        if (!C8007w0.m34700a((Object) this.f24736h, (Object) locale)) {
            this.f24736h = locale;
            this.f24730b = null;
            this.f24731c = null;
        }
    }

    /* renamed from: a */
    public byte[] mo35369a(String str) {
        ZipEntry a = C8007w0.m34698a(this.f24734f, str);
        if (a == null) {
            return null;
        }
        return C8007w0.m34701a(this.f24734f.getInputStream(a));
    }

    /* renamed from: b */
    public C7949b mo35370b() {
        if (this.f24733e == null) {
            m31503i();
        }
        return this.f24733e;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.String, java.io.InputStream] */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:9|10|(2:11|(1:13)(1:28))|14|(2:16|17)|20) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
            r1 = r4.f24734f.getInputStream(r0);
            r5 = new java.io.ByteArrayOutputStream(8192);
            r0 = new byte[8192];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002d, code lost:
            r2 = r1.read(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
            if (r2 != -1) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
            r5.write(r0, 0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0039, code lost:
            r5 = r5.toString("UTF-8");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
            if (r1 != null) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0045, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0046, code lost:
            r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0049, code lost:
            return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004a, code lost:
            r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004b, code lost:
            if (r1 != 0) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0051, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0052, code lost:
            r0.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001e */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v0, types: [java.lang.String, java.io.InputStream]
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY]]
  uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], java.io.InputStream, java.lang.String]
	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:231)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:95)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:88)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:30)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
	at jadx.core.ProcessClass.process(ProcessClass.java:35)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: b */
    public java.lang.String mo35371b(java.lang.String r5) {
        /*
        r4 = this;
        java.util.zip.ZipFile r0 = r4.f24734f
        java.util.zip.ZipEntry r0 = epco.C8007w0.m34698a(r0, r5)
        r1 = 0
        if (r0 != 0) goto L_0x000a
        return r1
    L_0x000a:
        epco.z r2 = r4.f24729a
        if (r2 != 0) goto L_0x0011
        r4.m31505k()
    L_0x0011:
        epco.m r2 = new epco.m     // Catch:{ IOException -> 0x001e }
        r2.m54422init()     // Catch:{ IOException -> 0x001e }
        r4.m31500a(r5, r2)     // Catch:{ IOException -> 0x001e }
        java.lang.String r5 = r2.mo38385a()     // Catch:{ IOException -> 0x001e }
        return r5
    L_0x001e:
        java.util.zip.ZipFile r5 = r4.f24734f     // Catch:{ all -> 0x004a }
        java.io.InputStream r1 = r5.getInputStream(r0)     // Catch:{ all -> 0x004a }
        java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x004a }
        r0 = 8192(0x2000, float:1.14794E-41)
        r5.<init>(r0)     // Catch:{ all -> 0x004a }
        byte[] r0 = new byte[r0]     // Catch:{ all -> 0x004a }
    L_0x002d:
        int r2 = r1.read(r0)     // Catch:{ all -> 0x004a }
        r3 = -1
        if (r2 == r3) goto L_0x0039
        r3 = 0
        r5.write(r0, r3, r2)     // Catch:{ all -> 0x004a }
        goto L_0x002d
    L_0x0039:
        java.lang.String r0 = "UTF-8"
        java.lang.String r5 = r5.toString(r0)     // Catch:{ all -> 0x004a }
        if (r1 == 0) goto L_0x0049
        r1.close()     // Catch:{ all -> 0x0045 }
        goto L_0x0049
    L_0x0045:
        r0 = move-exception
        r0.printStackTrace()
    L_0x0049:
        return r5
    L_0x004a:
        r5 = move-exception
        if (r1 == 0) goto L_0x0055
        r1.close()     // Catch:{ all -> 0x0051 }
        goto L_0x0055
    L_0x0051:
        r0 = move-exception
        r0.printStackTrace()
    L_0x0055:
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.apkparser.C7293a.mo35371b(java.lang.String):java.lang.String");
    }

    /* renamed from: c */
    public C7956c mo35372c() {
        String str = mo35367a().f26982c;
        if (str == null) {
            return null;
        }
        return new C7956c(str, mo35369a(str));
    }

    public void close() {
        this.f24729a = null;
        this.f24733e = null;
        try {
            this.f24734f.close();
        } catch (Exception unused) {
        }
    }

    /* renamed from: d */
    public Set<Locale> mo35374d() {
        if (this.f24732d == null) {
            m31505k();
        }
        return this.f24732d;
    }

    /* renamed from: e */
    public String mo35375e() {
        if (this.f24730b == null) {
            m31504j();
        }
        return this.f24730b;
    }

    /* renamed from: f */
    public Locale mo35376f() {
        return this.f24736h;
    }

    /* renamed from: g */
    public int mo35377g() {
        if (C8007w0.m34698a(this.f24734f, "META-INF/MANIFEST.MF") == null) {
            return 0;
        }
        JarFile jarFile = new JarFile(this.f24735g);
        Enumeration entries = jarFile.entries();
        byte[] bArr = new byte[8192];
        while (entries.hasMoreElements()) {
            JarEntry jarEntry = (JarEntry) entries.nextElement();
            if (!jarEntry.isDirectory()) {
                InputStream inputStream = null;
                try {
                    InputStream inputStream2 = jarFile.getInputStream(jarEntry);
                    while (inputStream2.read(bArr, 0, bArr.length) != -1) {
                    }
                    inputStream2.close();
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                } catch (SecurityException unused) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
        return 2;
        return 1;
        throw th;
    }
}
