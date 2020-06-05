package epco;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: epco.w0 */
public class C8007w0 {
    /* renamed from: a */
    public static String m34695a(Iterable<?> iterable, String str) {
        if (iterable == null) {
            return null;
        }
        return m34697a(iterable.iterator(), str);
    }

    /* renamed from: a */
    public static String m34696a(String str, String str2) {
        if (!m34699a((CharSequence) str) && str2 != null) {
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            int indexOf = str.indexOf(str2);
            if (indexOf == -1) {
                return str;
            }
            str = str.substring(0, indexOf);
        }
        return str;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Regions count limit reached
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:694)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:694)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:694)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
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
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003d A[SYNTHETIC] */
    /* renamed from: a */
    public static java.lang.String m34697a(java.util.Iterator<?> r3, java.lang.String r4) {
        /*
        r0 = 0
        if (r3 != 0) goto L_0x0004
        return r0
    L_0x0004:
        boolean r1 = r3.hasNext()
        if (r1 != 0) goto L_0x000d
        java.lang.String r3 = ""
        return r3
    L_0x000d:
        java.lang.Object r1 = r3.next()
        boolean r2 = r3.hasNext()
        if (r2 != 0) goto L_0x001f
        if (r1 != 0) goto L_0x001a
        goto L_0x001e
    L_0x001a:
        java.lang.String r0 = r1.toString()
    L_0x001e:
        return r0
    L_0x001f:
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r2 = 256(0x100, float:3.59E-43)
        r0.<init>(r2)
        if (r1 == 0) goto L_0x002b
    L_0x0028:
        r0.append(r1)
    L_0x002b:
        boolean r1 = r3.hasNext()
        if (r1 == 0) goto L_0x003d
        if (r4 == 0) goto L_0x0036
        r0.append(r4)
    L_0x0036:
        java.lang.Object r1 = r3.next()
        if (r1 == 0) goto L_0x002b
        goto L_0x0028
    L_0x003d:
        java.lang.String r3 = r0.toString()
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: epco.C8007w0.m34697a(java.util.Iterator, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static ZipEntry m34698a(ZipFile zipFile, String str) {
        return zipFile.getEntry(str);
    }

    /* renamed from: a */
    public static boolean m34699a(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    /* renamed from: a */
    public static boolean m34700a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    /* renamed from: a */
    public static byte[] m34701a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byte[] bArr = new byte[1024];
            byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    inputStream.close();
                    return byteArray;
                }
            }
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }

    /* renamed from: b */
    public static boolean m34702b(CharSequence charSequence) {
        if (m34699a(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
