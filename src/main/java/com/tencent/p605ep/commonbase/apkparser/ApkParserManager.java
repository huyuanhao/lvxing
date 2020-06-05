package com.tencent.p605ep.commonbase.apkparser;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.p605ep.commonbase.api.BaseManagerC;
import com.tencent.p605ep.commonbase.api.Log;
import com.tencent.p605ep.commonbase.software.AppEntity;
import com.tencent.p605ep.commonbase.utils.ReflecterHelper;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/* renamed from: com.tencent.ep.commonbase.apkparser.ApkParserManager */
public class ApkParserManager extends BaseManagerC {
    /* renamed from: f */
    private static final String f24723f = "ApkParserManager";
    /* renamed from: b */
    private C7296b f24724b;
    /* renamed from: c */
    private PackageManager f24725c = null;
    /* renamed from: d */
    private Context f24726d = null;
    /* renamed from: e */
    private CertificateFactory f24727e;

    /* renamed from: a */
    private Resources m31491a(String str) {
        Resources resources = this.f24726d.getResources();
        Object newInstance = ReflecterHelper.newInstance("android.content.res.AssetManager", null);
        ReflecterHelper.invokeMethod(newInstance, "addAssetPath", new Object[]{str});
        return (Resources) ReflecterHelper.newInstance("android.content.res.Resources", new Object[]{newInstance, resources.getDisplayMetrics(), resources.getConfiguration()});
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r1v0, types: [com.tencent.ep.commonbase.apkparser.a] */
    /* JADX WARNING: type inference failed for: r0v1, types: [com.tencent.ep.commonbase.apkparser.a] */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r1v2, types: [com.tencent.ep.commonbase.apkparser.a] */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:113|112|116|117|(0)|120) */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0146, code lost:
            r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0147, code lost:
            r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x014f, code lost:
            r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0153, code lost:
            if (r1 != 0) goto L_0x0155;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0155, code lost:
            r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0158, code lost:
            throw r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x007a, code lost:
            r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0012, code lost:
            r10 = th;
            r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
            r2 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:116:0x0149 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v2
  assigns: [?[OBJECT, ARRAY], ?[int, float, boolean, short, byte, char, OBJECT, ARRAY], java.lang.String]
  uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], com.tencent.ep.commonbase.apkparser.a, ?[OBJECT, ARRAY]]
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0012 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:3:0x0005] */
    /* JADX WARNING: Unknown variable types count: 6 */
    /* renamed from: a */
    private com.tencent.p605ep.commonbase.software.AppEntity m31492a(java.lang.String r10, com.tencent.p605ep.commonbase.software.AppEntity r11, int r12) {
        /*
        r9 = this;
        r0 = 0
        com.tencent.ep.commonbase.apkparser.a r1 = com.tencent.p605ep.commonbase.apkparser.C7293a.m31501c(r10)     // Catch:{ Exception -> 0x0149 }
        android.content.Context r2 = r9.f24726d     // Catch:{ Exception -> 0x0015, all -> 0x0012 }
        android.content.res.Resources r2 = r2.getResources()     // Catch:{ Exception -> 0x0015, all -> 0x0012 }
        android.content.res.Configuration r2 = r2.getConfiguration()     // Catch:{ Exception -> 0x0015, all -> 0x0012 }
        java.util.Locale r2 = r2.locale     // Catch:{ Exception -> 0x0015, all -> 0x0012 }
        goto L_0x0016
    L_0x0012:
        r10 = move-exception
        goto L_0x0153
    L_0x0015:
        r2 = r0
    L_0x0016:
        if (r2 == 0) goto L_0x001b
        r1.mo35368a(r2)     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
    L_0x001b:
        epco.a r2 = r1.mo35367a()     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        if (r2 != 0) goto L_0x0027
        if (r1 == 0) goto L_0x0026
        r1.close()
    L_0x0026:
        return r0
    L_0x0027:
        r3 = r12 & 128(0x80, float:1.794E-43)
        if (r3 == 0) goto L_0x0034
        java.lang.String r3 = r2.f26980a     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        if (r3 == 0) goto L_0x0034
        java.lang.String r4 = "pkgName"
        r11.put(r4, r3)     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
    L_0x0034:
        r3 = r12 & 256(0x100, float:3.59E-43)
        if (r3 == 0) goto L_0x0041
        java.lang.String r3 = r2.f26983d     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        if (r3 == 0) goto L_0x0041
        java.lang.String r4 = "version"
        r11.put(r4, r3)     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
    L_0x0041:
        r3 = r12 & 512(0x200, float:7.175E-43)
        if (r3 == 0) goto L_0x0054
        java.lang.Long r3 = r2.f26984e     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        int r3 = r3.intValue()     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        java.lang.String r4 = "versionCode"
        java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        r11.put(r4, r3)     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
    L_0x0054:
        r3 = r12 & 32
        if (r3 == 0) goto L_0x0070
        java.util.List<java.lang.String> r3 = r2.f26985f     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        if (r3 == 0) goto L_0x0064
        java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        java.util.List<java.lang.String> r4 = r2.f26985f     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        r3.<init>(r4)     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        goto L_0x0065
    L_0x0064:
        r3 = r0
    L_0x0065:
        if (r3 == 0) goto L_0x0070
        java.lang.String r4 = "permissions"
        java.lang.Object[] r3 = r3.toArray()     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        r11.put(r4, r3)     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
    L_0x0070:
        r3 = 0
        android.content.pm.PackageManager r4 = r9.f24725c     // Catch:{ Exception -> 0x007a, all -> 0x0012 }
        java.lang.String r5 = r2.f26980a     // Catch:{ Exception -> 0x007a, all -> 0x0012 }
        android.content.pm.ApplicationInfo r4 = r4.getApplicationInfo(r5, r3)     // Catch:{ Exception -> 0x007a, all -> 0x0012 }
        goto L_0x007b
    L_0x007a:
        r4 = r0
    L_0x007b:
        r5 = r12 & 1024(0x400, float:1.435E-42)
        if (r5 == 0) goto L_0x008c
        if (r4 == 0) goto L_0x008c
        java.lang.String r5 = "uid"
        int r6 = r4.uid     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        r11.put(r5, r6)     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
    L_0x008c:
        r5 = r12 & 8192(0x2000, float:1.14794E-41)
        if (r5 == 0) goto L_0x00bd
        int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        r6 = 7
        r7 = 1
        java.lang.String r8 = "installedOnSdcard"
        if (r5 <= r6) goto L_0x00ab
        if (r4 == 0) goto L_0x00bd
        int r5 = r4.flags     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        r6 = 262144(0x40000, float:3.67342E-40)
        r5 = r5 & r6
        if (r5 == 0) goto L_0x00a2
        goto L_0x00a3
    L_0x00a2:
        r7 = 0
    L_0x00a3:
        java.lang.Boolean r5 = java.lang.Boolean.valueOf(r7)     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
    L_0x00a7:
        r11.put(r8, r5)     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        goto L_0x00bd
    L_0x00ab:
        java.lang.String r5 = "/data"
        boolean r5 = r10.startsWith(r5)     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        if (r5 == 0) goto L_0x00b8
        java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        goto L_0x00a7
    L_0x00b8:
        java.lang.Boolean r5 = java.lang.Boolean.valueOf(r7)     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        goto L_0x00a7
    L_0x00bd:
        r5 = r12 & 2048(0x800, float:2.87E-42)
        if (r5 != 0) goto L_0x00c5
        r6 = r12 & 4
        if (r6 == 0) goto L_0x010b
    L_0x00c5:
        if (r5 == 0) goto L_0x00ce
        java.lang.String r5 = "appName"
        java.lang.String r2 = r2.f26981b     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        r11.put(r5, r2)     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
    L_0x00ce:
        r2 = r12 & 4
        if (r2 == 0) goto L_0x010b
        epco.c r2 = r1.mo35372c()     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        java.lang.String r5 = "icon"
        if (r2 == 0) goto L_0x0100
        byte[] r6 = r2.f27037b     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        if (r6 == 0) goto L_0x0100
        byte[] r6 = r2.f27037b     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        byte[] r2 = r2.f27037b     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        int r2 = r2.length     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeByteArray(r6, r3, r2)     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        android.graphics.drawable.BitmapDrawable r3 = new android.graphics.drawable.BitmapDrawable     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        r3.<init>(r2)     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        android.content.Context r2 = r9.f24726d     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        boolean r2 = m31494a(r2, r3)     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        if (r2 == 0) goto L_0x00fc
        if (r4 == 0) goto L_0x00fc
        android.content.pm.PackageManager r2 = r9.f24725c     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        android.graphics.drawable.Drawable r3 = r2.getApplicationIcon(r4)     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
    L_0x00fc:
        r11.put(r5, r3)     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        goto L_0x010b
    L_0x0100:
        if (r4 == 0) goto L_0x010b
        android.content.pm.PackageManager r2 = r9.f24725c     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        android.graphics.drawable.Drawable r2 = r2.getApplicationIcon(r4)     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        r11.put(r5, r2)     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
    L_0x010b:
        r2 = r12 & 16
        if (r2 == 0) goto L_0x013e
        epco.b r2 = r1.mo35370b()     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        if (r2 == 0) goto L_0x013e
        byte[] r3 = r2.f26999e     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        if (r3 == 0) goto L_0x013e
        java.security.cert.CertificateFactory r3 = r9.f24727e     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        android.content.pm.Signature r4 = new android.content.pm.Signature     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        byte[] r2 = r2.f26999e     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        r4.<init>(r2)     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        java.security.cert.Certificate r2 = m31493a(r3, r4)     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        java.security.cert.X509Certificate r2 = (java.security.cert.X509Certificate) r2     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
        if (r2 == 0) goto L_0x013e
        byte[] r2 = r2.getEncoded()     // Catch:{ CertificateEncodingException -> 0x0133 }
        java.lang.String r0 = com.tencent.p605ep.commonbase.utils.MD5Util.encrypt_bytes(r2)     // Catch:{ CertificateEncodingException -> 0x0133 }
        goto L_0x0137
    L_0x0133:
        r2 = move-exception
        r2.printStackTrace()     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
    L_0x0137:
        if (r0 == 0) goto L_0x013e
        java.lang.String r2 = "signatureCermMD5"
        r11.put(r2, r0)     // Catch:{ Exception -> 0x0144, all -> 0x0012 }
    L_0x013e:
        if (r1 == 0) goto L_0x0143
        r1.close()
    L_0x0143:
        return r11
    L_0x0144:
        r0 = r1
        goto L_0x0149
    L_0x0146:
        r10 = move-exception
        r1 = r0
        goto L_0x0153
    L_0x0149:
        com.tencent.ep.commonbase.software.AppEntity r10 = r9.m31495b(r10, r11, r12)     // Catch:{ all -> 0x0146 }
        if (r0 == 0) goto L_0x0152
        r0.close()
    L_0x0152:
        return r10
    L_0x0153:
        if (r1 == 0) goto L_0x0158
        r1.close()
    L_0x0158:
        throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.apkparser.ApkParserManager.m31492a(java.lang.String, com.tencent.ep.commonbase.software.AppEntity, int):com.tencent.ep.commonbase.software.AppEntity");
    }

    /* renamed from: a */
    private static Certificate m31493a(CertificateFactory certificateFactory, Signature signature) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(signature.toByteArray());
        Certificate certificate = null;
        try {
            X509Certificate x509Certificate = (X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream);
            try {
                byteArrayInputStream.close();
                return x509Certificate;
            } catch (IOException e) {
                IOException iOException = e;
                certificate = x509Certificate;
                e = iOException;
                e.printStackTrace();
                return certificate;
            }
        } catch (CertificateException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            throw th;
        }
        try {
            byteArrayInputStream.close();
            return null;
        } catch (IOException e5) {
            e = e5;
        }
    }

    /* renamed from: a */
    private static boolean m31494a(Context context, Drawable drawable) {
        try {
            float f = context.getResources().getDisplayMetrics().density;
            int intrinsicWidth = (int) (((float) drawable.getIntrinsicWidth()) / f);
            int intrinsicHeight = (int) (((float) drawable.getIntrinsicHeight()) / f);
            if (intrinsicWidth > 320 || intrinsicHeight > 320) {
                String str = f24723f;
                StringBuilder sb = new StringBuilder();
                sb.append("too large: (");
                sb.append(intrinsicWidth);
                sb.append(", ");
                sb.append(intrinsicHeight);
                sb.append(")");
                Log.m31483i(str, sb.toString());
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00f5, code lost:
            if (r6.toString().length() <= 0) goto L_0x00f7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00ed A[SYNTHETIC, Splitter:B:75:0x00ed] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x010e  */
    /* renamed from: b */
    private com.tencent.p605ep.commonbase.software.AppEntity m31495b(java.lang.String r11, com.tencent.p605ep.commonbase.software.AppEntity r12, int r13) {
        /*
        r10 = this;
        r0 = 0
        java.lang.Object r1 = com.tencent.p605ep.commonbase.utils.PackageUtil.getPackageParser(r11)     // Catch:{ Exception -> 0x0191 }
        java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0191 }
        r2.<init>(r11)     // Catch:{ Exception -> 0x0191 }
        android.util.DisplayMetrics r3 = new android.util.DisplayMetrics     // Catch:{ Exception -> 0x0191 }
        r3.<init>()     // Catch:{ Exception -> 0x0191 }
        r3.setToDefaults()     // Catch:{ Exception -> 0x0191 }
        r4 = 0
        java.lang.Object r2 = com.tencent.p605ep.commonbase.utils.PackageUtil.parsePackage(r1, r2, r11, r3, r4)     // Catch:{ Exception -> 0x0191 }
        if (r2 != 0) goto L_0x001a
        return r0
    L_0x001a:
        r3 = r13 & 128(0x80, float:1.794E-43)
        if (r3 == 0) goto L_0x002d
        java.lang.String r3 = "packageName"
        java.lang.Object r3 = com.tencent.p605ep.commonbase.utils.ReflecterHelper.getProperty(r2, r3)     // Catch:{ Exception -> 0x0191 }
        java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0191 }
        if (r3 == 0) goto L_0x002d
        java.lang.String r5 = "pkgName"
        r12.put(r5, r3)     // Catch:{ Exception -> 0x0191 }
    L_0x002d:
        r3 = r13 & 256(0x100, float:3.59E-43)
        if (r3 == 0) goto L_0x0040
        java.lang.String r3 = "mVersionName"
        java.lang.Object r3 = com.tencent.p605ep.commonbase.utils.ReflecterHelper.getProperty(r2, r3)     // Catch:{ Exception -> 0x0191 }
        java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0191 }
        if (r3 == 0) goto L_0x0040
        java.lang.String r5 = "version"
        r12.put(r5, r3)     // Catch:{ Exception -> 0x0191 }
    L_0x0040:
        r3 = r13 & 512(0x200, float:7.175E-43)
        if (r3 == 0) goto L_0x0059
        java.lang.String r3 = "mVersionCode"
        java.lang.Object r3 = com.tencent.p605ep.commonbase.utils.ReflecterHelper.getProperty(r2, r3)     // Catch:{ Exception -> 0x0191 }
        java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ Exception -> 0x0191 }
        int r3 = r3.intValue()     // Catch:{ Exception -> 0x0191 }
        java.lang.String r5 = "versionCode"
        java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0191 }
        r12.put(r5, r3)     // Catch:{ Exception -> 0x0191 }
    L_0x0059:
        r3 = r13 & 32
        if (r3 == 0) goto L_0x0070
        java.lang.String r3 = "requestedPermissions"
        java.lang.Object r3 = com.tencent.p605ep.commonbase.utils.ReflecterHelper.getProperty(r2, r3)     // Catch:{ Exception -> 0x0191 }
        java.util.ArrayList r3 = (java.util.ArrayList) r3     // Catch:{ Exception -> 0x0191 }
        if (r3 == 0) goto L_0x0070
        java.lang.String r5 = "permissions"
        java.lang.Object[] r3 = r3.toArray()     // Catch:{ Exception -> 0x0191 }
        r12.put(r5, r3)     // Catch:{ Exception -> 0x0191 }
    L_0x0070:
        r3 = r13 & 1024(0x400, float:1.435E-42)
        java.lang.String r5 = "applicationInfo"
        if (r3 == 0) goto L_0x008a
        java.lang.Object r3 = com.tencent.p605ep.commonbase.utils.ReflecterHelper.getProperty(r2, r5)     // Catch:{ Exception -> 0x0191 }
        android.content.pm.ApplicationInfo r3 = (android.content.pm.ApplicationInfo) r3     // Catch:{ Exception -> 0x0191 }
        if (r3 == 0) goto L_0x008b
        java.lang.String r6 = "uid"
        int r7 = r3.uid     // Catch:{ Exception -> 0x0191 }
        java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x0191 }
        r12.put(r6, r7)     // Catch:{ Exception -> 0x0191 }
        goto L_0x008b
    L_0x008a:
        r3 = r0
    L_0x008b:
        r6 = r13 & 8192(0x2000, float:1.14794E-41)
        r7 = 1
        if (r6 == 0) goto L_0x00c3
        int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0191 }
        r8 = 7
        java.lang.String r9 = "installedOnSdcard"
        if (r6 <= r8) goto L_0x00b1
        java.lang.Object r3 = com.tencent.p605ep.commonbase.utils.ReflecterHelper.getProperty(r2, r5)     // Catch:{ Exception -> 0x0191 }
        android.content.pm.ApplicationInfo r3 = (android.content.pm.ApplicationInfo) r3     // Catch:{ Exception -> 0x0191 }
        if (r3 == 0) goto L_0x00c3
        int r6 = r3.flags     // Catch:{ Exception -> 0x0191 }
        r8 = 262144(0x40000, float:3.67342E-40)
        r6 = r6 & r8
        if (r6 == 0) goto L_0x00a8
        r6 = 1
        goto L_0x00a9
    L_0x00a8:
        r6 = 0
    L_0x00a9:
        java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ Exception -> 0x0191 }
    L_0x00ad:
        r12.put(r9, r6)     // Catch:{ Exception -> 0x0191 }
        goto L_0x00c3
    L_0x00b1:
        java.lang.String r6 = "/data"
        boolean r6 = r11.startsWith(r6)     // Catch:{ Exception -> 0x0191 }
        if (r6 == 0) goto L_0x00be
        java.lang.Boolean r6 = java.lang.Boolean.valueOf(r4)     // Catch:{ Exception -> 0x0191 }
        goto L_0x00ad
    L_0x00be:
        java.lang.Boolean r6 = java.lang.Boolean.valueOf(r7)     // Catch:{ Exception -> 0x0191 }
        goto L_0x00ad
    L_0x00c3:
        r6 = r13 & 2048(0x800, float:2.87E-42)
        if (r6 != 0) goto L_0x00cb
        r8 = r13 & 4
        if (r8 == 0) goto L_0x0150
    L_0x00cb:
        if (r3 != 0) goto L_0x00d3
        java.lang.Object r3 = com.tencent.p605ep.commonbase.utils.ReflecterHelper.getProperty(r2, r5)     // Catch:{ Exception -> 0x0191 }
        android.content.pm.ApplicationInfo r3 = (android.content.pm.ApplicationInfo) r3     // Catch:{ Exception -> 0x0191 }
    L_0x00d3:
        if (r6 == 0) goto L_0x0103
        if (r3 == 0) goto L_0x0103
        int r5 = r3.labelRes     // Catch:{ Exception -> 0x0191 }
        if (r5 == 0) goto L_0x00e9
        android.content.res.Resources r5 = r10.m31491a(r11)     // Catch:{ Exception -> 0x00e6 }
        int r6 = r3.labelRes     // Catch:{ Exception -> 0x00e7 }
        java.lang.CharSequence r6 = r5.getText(r6)     // Catch:{ Exception -> 0x00e7 }
        goto L_0x00eb
    L_0x00e6:
        r5 = r0
    L_0x00e7:
        r6 = r0
        goto L_0x00eb
    L_0x00e9:
        r5 = r0
        r6 = r5
    L_0x00eb:
        if (r6 == 0) goto L_0x00f7
        java.lang.String r8 = r6.toString()     // Catch:{ Exception -> 0x0191 }
        int r8 = r8.length()     // Catch:{ Exception -> 0x0191 }
        if (r8 > 0) goto L_0x00fd
    L_0x00f7:
        android.content.pm.PackageManager r6 = r10.f24725c     // Catch:{ Exception -> 0x0191 }
        java.lang.CharSequence r6 = r6.getApplicationLabel(r3)     // Catch:{ Exception -> 0x0191 }
    L_0x00fd:
        java.lang.String r8 = "appName"
        r12.put(r8, r6)     // Catch:{ Exception -> 0x0191 }
        goto L_0x0104
    L_0x0103:
        r5 = r0
    L_0x0104:
        r6 = r13 & 4
        if (r6 == 0) goto L_0x0150
        if (r3 == 0) goto L_0x0150
        int r6 = r3.icon     // Catch:{ Exception -> 0x0191 }
        if (r6 == 0) goto L_0x013a
        if (r5 != 0) goto L_0x0114
        android.content.res.Resources r5 = r10.m31491a(r11)     // Catch:{ all -> 0x011b }
    L_0x0114:
        int r6 = r3.icon     // Catch:{ all -> 0x011b }
        android.graphics.drawable.Drawable r11 = r5.getDrawable(r6)     // Catch:{ all -> 0x011b }
        goto L_0x013b
    L_0x011b:
        r5 = move-exception
        java.lang.String r6 = "ApkParserManager"
        java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0191 }
        r8.<init>()     // Catch:{ Exception -> 0x0191 }
        java.lang.String r9 = ""
        r8.append(r9)     // Catch:{ Exception -> 0x0191 }
        r8.append(r11)     // Catch:{ Exception -> 0x0191 }
        java.lang.String r11 = " | res.getDrawable() error: "
        r8.append(r11)     // Catch:{ Exception -> 0x0191 }
        r8.append(r5)     // Catch:{ Exception -> 0x0191 }
        java.lang.String r11 = r8.toString()     // Catch:{ Exception -> 0x0191 }
        com.tencent.p605ep.commonbase.api.Log.m31479e(r6, r11)     // Catch:{ Exception -> 0x0191 }
    L_0x013a:
        r11 = r0
    L_0x013b:
        if (r11 == 0) goto L_0x0145
        android.content.Context r5 = r10.f24726d     // Catch:{ Exception -> 0x0191 }
        boolean r5 = m31494a(r5, r11)     // Catch:{ Exception -> 0x0191 }
        if (r5 == 0) goto L_0x014b
    L_0x0145:
        android.content.pm.PackageManager r11 = r10.f24725c     // Catch:{ Exception -> 0x0191 }
        android.graphics.drawable.Drawable r11 = r11.getApplicationIcon(r3)     // Catch:{ Exception -> 0x0191 }
    L_0x014b:
        java.lang.String r3 = "icon"
        r12.put(r3, r11)     // Catch:{ Exception -> 0x0191 }
    L_0x0150:
        r11 = r13 & 16
        if (r11 == 0) goto L_0x0190
        java.lang.String r11 = "collectCertificates"
        r13 = 2
        java.lang.Object[] r13 = new java.lang.Object[r13]     // Catch:{ Exception -> 0x0191 }
        r13[r4] = r2     // Catch:{ Exception -> 0x0191 }
        java.lang.Integer r3 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0191 }
        r13[r7] = r3     // Catch:{ Exception -> 0x0191 }
        com.tencent.p605ep.commonbase.utils.ReflecterHelper.invokeMethod(r1, r11, r13)     // Catch:{ Exception -> 0x0191 }
        java.lang.String r11 = "mSignatures"
        java.lang.Object r11 = com.tencent.p605ep.commonbase.utils.ReflecterHelper.getProperty(r2, r11)     // Catch:{ Exception -> 0x0191 }
        android.content.pm.Signature[] r11 = (android.content.pm.Signature[]) r11     // Catch:{ Exception -> 0x0191 }
        if (r11 == 0) goto L_0x0190
        int r13 = r11.length     // Catch:{ Exception -> 0x0191 }
        if (r13 <= 0) goto L_0x0190
        java.security.cert.CertificateFactory r13 = r10.f24727e     // Catch:{ Exception -> 0x0191 }
        r11 = r11[r4]     // Catch:{ Exception -> 0x0191 }
        java.security.cert.Certificate r11 = m31493a(r13, r11)     // Catch:{ Exception -> 0x0191 }
        java.security.cert.X509Certificate r11 = (java.security.cert.X509Certificate) r11     // Catch:{ Exception -> 0x0191 }
        if (r11 == 0) goto L_0x0190
        byte[] r11 = r11.getEncoded()     // Catch:{ CertificateEncodingException -> 0x0186 }
        java.lang.String r11 = com.tencent.p605ep.commonbase.utils.MD5Util.encrypt_bytes(r11)     // Catch:{ CertificateEncodingException -> 0x0186 }
        goto L_0x018b
    L_0x0186:
        r11 = move-exception
        r11.printStackTrace()     // Catch:{ Exception -> 0x0191 }
        r11 = r0
    L_0x018b:
        java.lang.String r13 = "signatureCermMD5"
        r12.put(r13, r11)     // Catch:{ Exception -> 0x0191 }
    L_0x0190:
        return r12
    L_0x0191:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.apkparser.ApkParserManager.m31495b(java.lang.String, com.tencent.ep.commonbase.software.AppEntity, int):com.tencent.ep.commonbase.software.AppEntity");
    }

    public synchronized AppEntity getApkInfo(AppEntity appEntity, int i) {
        String str = (String) appEntity.get(AppEntity.KEY_APK_PATH_STR);
        try {
            if (!this.f24724b.mo35378a(str)) {
                return null;
            }
            if ((i & 1) != 0) {
                appEntity.put(AppEntity.KEY_IS_SYSTEM_BOOL, Boolean.FALSE);
                i = i | 128 | 2048 | 1024;
            }
            if ((i & 2) != 0) {
                appEntity.put(AppEntity.KEY_IS_SYSTEM_BOOL, Boolean.FALSE);
                i = i | 128 | 1024;
            }
            if ((i & 8) != 0) {
                File file = new File(str);
                appEntity.put(AppEntity.KEY_SIZE_LONG, Long.valueOf(file.length()));
                appEntity.put(AppEntity.KEY_LAST_MODIFIED_LONG, Long.valueOf(file.lastModified()));
                i = i | 256 | 512;
            }
            if ((i & 64) != 0) {
                appEntity.put(AppEntity.KEY_APK_PATH_STR, str);
                appEntity.put(AppEntity.KEY_IS_APK_BOOL, Boolean.valueOf(true));
            }
            return m31492a(str, appEntity, i);
        } catch (Throwable unused) {
            return appEntity;
        }
    }

    public AppEntity getApkInfo(String str, int i) {
        AppEntity appEntity = new AppEntity();
        appEntity.put(AppEntity.KEY_APK_PATH_STR, str);
        return getApkInfo(appEntity, i);
    }

    public void onCreate(Context context) {
        this.f24726d = context;
        this.f24724b = new C7296b();
        this.f24725c = context.getPackageManager();
        try {
            this.f24727e = CertificateFactory.getInstance("X.509");
        } catch (CertificateException unused) {
        }
    }
}
