package com.qiyukf.nimlib.p488k.p490b;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.text.TextUtils;
import com.qiyukf.basesdk.p412c.p413a.C5362a;
import com.qiyukf.basesdk.p412c.p413a.C5363b;
import com.qiyukf.basesdk.p412c.p416c.C5406d;
import com.qiyukf.nim.uikit.session.viewholder.C5637i;
import com.qiyukf.nimlib.C5718b;
import com.qiyukf.nimlib.p488k.p491c.C5944b;
import com.qiyukf.nimlib.p488k.p491c.C5946c;
import com.qiyukf.unicorn.C5961R;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.io.File;
import java.io.IOException;

/* renamed from: com.qiyukf.nimlib.k.b.b */
public final class C5940b {

    /* renamed from: com.qiyukf.nimlib.k.b.b$a */
    public static class C5941a {
        /* renamed from: a */
        public int f18757a = 0;
        /* renamed from: b */
        public int f18758b = 0;

        public C5941a(int i, int i2) {
            this.f18757a = i;
            this.f18758b = i2;
        }
    }

    /* renamed from: a */
    public static int m23808a(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                return TinkerReport.KEY_APPLIED_VERSION_CHECK;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (IOException unused) {
            return 0;
        }
    }

    /* renamed from: a */
    public static Bitmap m23809a() {
        try {
            return m23811a(C5718b.m23009a().getResources(), C5961R.C5962drawable.ysf_image_placeholder_fail);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static Bitmap m23810a(int i) {
        try {
            return m23811a(C5718b.m23009a().getResources(), i);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static Bitmap m23811a(Resources resources, int i) {
        Drawable drawable = resources.getDrawable(i);
        Bitmap bitmap = (drawable == null || !(drawable instanceof BitmapDrawable)) ? null : ((BitmapDrawable) drawable).getBitmap();
        return bitmap.copy(Config.RGB_565, false);
    }

    /* renamed from: a */
    public static Bitmap m23812a(String str, Bitmap bitmap) {
        if (TextUtils.isEmpty(str) || bitmap == null) {
            return null;
        }
        try {
            int a = m23808a(str);
            if (a == 0) {
                return bitmap;
            }
            Matrix matrix = new Matrix();
            matrix.postRotate((float) a);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
            if (createBitmap == null) {
                return bitmap;
            }
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
            return createBitmap;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return bitmap;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
            if (r3 < r6) goto L_0x0022;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0035  */
    /* renamed from: a */
    public static com.qiyukf.nimlib.p488k.p490b.C5940b.C5941a m23813a(float r3, float r4, float r5, float r6) {
        /*
        r0 = 0
        int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
        if (r1 <= 0) goto L_0x0040
        int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
        if (r0 > 0) goto L_0x000a
        goto L_0x0040
    L_0x000a:
        int r0 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
        if (r0 >= 0) goto L_0x0013
        r0 = 0
        r2 = r4
        r4 = r3
        r3 = r2
        goto L_0x0014
    L_0x0013:
        r0 = 1
    L_0x0014:
        int r1 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
        if (r1 >= 0) goto L_0x0024
        float r3 = r6 / r3
        float r3 = r3 * r4
        int r4 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
        if (r4 <= 0) goto L_0x0021
        goto L_0x0030
    L_0x0021:
        r5 = r3
    L_0x0022:
        r3 = r6
        goto L_0x0032
    L_0x0024:
        int r1 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
        if (r1 <= 0) goto L_0x0031
        float r4 = r5 / r4
        float r3 = r3 * r4
        int r4 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
        if (r4 >= 0) goto L_0x0032
    L_0x0030:
        goto L_0x0022
    L_0x0031:
        r5 = r4
    L_0x0032:
        if (r0 == 0) goto L_0x0035
        goto L_0x0038
    L_0x0035:
        r2 = r5
        r5 = r3
        r3 = r2
    L_0x0038:
        com.qiyukf.nimlib.k.b.b$a r4 = new com.qiyukf.nimlib.k.b.b$a
        int r3 = (int) r3
        int r5 = (int) r5
        r4.m50110init(r3, r5)
        return r4
    L_0x0040:
        com.qiyukf.nimlib.k.b.b$a r3 = new com.qiyukf.nimlib.k.b.b$a
        int r4 = (int) r6
        r3.m50110init(r4, r4)
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p488k.p490b.C5940b.m23813a(float, float, float, float):com.qiyukf.nimlib.k.b.b$a");
    }

    /* renamed from: a */
    public static File m23814a(File file, String str) {
        String path = file.getPath();
        String lowerCase = str.toLowerCase();
        boolean z = lowerCase.contains("jpg") || lowerCase.contains("jpeg") || lowerCase.toLowerCase().contains("png") || lowerCase.toLowerCase().contains("bmp") || lowerCase.toLowerCase().contains("gif");
        if (!z) {
            return null;
        }
        String a = C5363b.m22023a(path);
        StringBuilder sb = new StringBuilder("temp_image_");
        sb.append(C5406d.m22116a());
        sb.append(".");
        sb.append(a);
        File a2 = C5362a.m22019a(C5946c.m23834a(sb.toString(), C5944b.TYPE_TEMP));
        if (a2 != null && m23816a(file, a2, CompressFormat.JPEG).booleanValue()) {
            return a2;
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f4, code lost:
            if (r1.isRecycled() == false) goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f6, code lost:
            r1.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x013c, code lost:
            if (r1.isRecycled() == false) goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0161, code lost:
            if (r1.isRecycled() == false) goto L_0x00f6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0122 A[SYNTHETIC, Splitter:B:67:0x0122] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0147 A[SYNTHETIC, Splitter:B:83:0x0147] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x016a A[SYNTHETIC, Splitter:B:99:0x016a] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:80:0x0142=Splitter:B:80:0x0142, B:64:0x011d=Splitter:B:64:0x011d} */
    /* renamed from: a */
    private static java.lang.Boolean m23815a(java.io.File r16, java.io.File r17, int r18, int r19, android.graphics.Bitmap.CompressFormat r20) {
        /*
        r0 = r18
        r1 = r19
        r2 = 0
        java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
        r4 = 0
        java.lang.String r5 = r16.getPath()     // Catch:{ OutOfMemoryError -> 0x013f, IOException -> 0x011a, all -> 0x0115 }
        int[] r5 = com.qiyukf.nimlib.p488k.p490b.C5939a.m23806a(r5)     // Catch:{ OutOfMemoryError -> 0x013f, IOException -> 0x011a, all -> 0x0115 }
        r6 = r5[r2]     // Catch:{ OutOfMemoryError -> 0x013f, IOException -> 0x011a, all -> 0x0115 }
        float r6 = (float) r6     // Catch:{ OutOfMemoryError -> 0x013f, IOException -> 0x011a, all -> 0x0115 }
        r7 = 1
        r5 = r5[r7]     // Catch:{ OutOfMemoryError -> 0x013f, IOException -> 0x011a, all -> 0x0115 }
        float r5 = (float) r5     // Catch:{ OutOfMemoryError -> 0x013f, IOException -> 0x011a, all -> 0x0115 }
        float r8 = (float) r0     // Catch:{ OutOfMemoryError -> 0x013f, IOException -> 0x011a, all -> 0x0115 }
        float r9 = (float) r1     // Catch:{ OutOfMemoryError -> 0x013f, IOException -> 0x011a, all -> 0x0115 }
        com.qiyukf.nimlib.k.b.b$a r5 = m23813a(r6, r5, r8, r9)     // Catch:{ OutOfMemoryError -> 0x013f, IOException -> 0x011a, all -> 0x0115 }
        java.lang.String r6 = r16.getPath()     // Catch:{ OutOfMemoryError -> 0x013f, IOException -> 0x011a, all -> 0x0115 }
        int r8 = r5.f18757a     // Catch:{ OutOfMemoryError -> 0x013f, IOException -> 0x011a, all -> 0x0115 }
        int r9 = r5.f18758b     // Catch:{ OutOfMemoryError -> 0x013f, IOException -> 0x011a, all -> 0x0115 }
        int[] r10 = com.qiyukf.nimlib.p488k.p490b.C5939a.m23806a(r6)     // Catch:{ OutOfMemoryError -> 0x013f, IOException -> 0x011a, all -> 0x0115 }
        r11 = r10[r2]     // Catch:{ OutOfMemoryError -> 0x013f, IOException -> 0x011a, all -> 0x0115 }
        r10 = r10[r7]     // Catch:{ OutOfMemoryError -> 0x013f, IOException -> 0x011a, all -> 0x0115 }
        int r8 = com.qiyukf.nimlib.p488k.p490b.C5942c.m23820a(r11, r10, r8, r9)     // Catch:{ OutOfMemoryError -> 0x013f, IOException -> 0x011a, all -> 0x0115 }
        android.graphics.Bitmap r2 = com.qiyukf.nimlib.p488k.p490b.C5939a.m23804a(r6, r8, r2)     // Catch:{ OutOfMemoryError -> 0x013f, IOException -> 0x011a, all -> 0x0115 }
        java.lang.String r6 = r16.getAbsolutePath()     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        int r6 = m23808a(r6)     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        android.graphics.Matrix r14 = new android.graphics.Matrix     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        r14.<init>()     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        float r8 = (float) r6     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        r14.postRotate(r8)     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        int r8 = r2.getWidth()     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        r9 = 1065353216(0x3f800000, float:1.0)
        if (r8 < r1) goto L_0x0062
        int r8 = r2.getHeight()     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        if (r8 > r0) goto L_0x0062
        int r8 = r2.getWidth()     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        if (r8 < r1) goto L_0x0062
        int r1 = r2.getHeight()     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        if (r1 <= r0) goto L_0x0073
    L_0x0062:
        int r0 = r2.getWidth()     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        int r1 = r5.f18757a     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        if (r0 != r1) goto L_0x0076
        int r0 = r2.getHeight()     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        int r1 = r5.f18758b     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        if (r0 == r1) goto L_0x0073
        goto L_0x0076
    L_0x0073:
        r0 = 1065353216(0x3f800000, float:1.0)
        goto L_0x00a8
    L_0x0076:
        int r0 = r5.f18757a     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        float r0 = (float) r0     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        int r1 = r2.getWidth()     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        float r1 = (float) r1     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        float r0 = r0 / r1
        int r1 = r5.f18758b     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        float r1 = (float) r1     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        int r8 = r2.getHeight()     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        float r8 = (float) r8     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        float r1 = r1 / r8
        int r8 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
        if (r8 < 0) goto L_0x009a
        int r1 = r2.getWidth()     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        r5.f18757a = r1     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        int r1 = r5.f18758b     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        float r1 = (float) r1     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        float r1 = r1 / r0
        int r1 = (int) r1     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        r5.f18758b = r1     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        goto L_0x00a8
    L_0x009a:
        int r0 = r5.f18757a     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        float r0 = (float) r0     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        float r0 = r0 / r1
        int r0 = (int) r0     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        r5.f18757a = r0     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        int r0 = r2.getHeight()     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        r5.f18758b = r0     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        r0 = r1
    L_0x00a8:
        r14.postScale(r0, r0)     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        if (r6 != 0) goto L_0x00b3
        int r0 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
        if (r0 != 0) goto L_0x00b3
        r1 = r2
        goto L_0x00c0
    L_0x00b3:
        r10 = 0
        r11 = 0
        int r12 = r5.f18757a     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        int r13 = r5.f18758b     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        r15 = 1
        r9 = r2
        android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ OutOfMemoryError -> 0x0112, IOException -> 0x010f, all -> 0x010a }
        r1 = r0
    L_0x00c0:
        java.io.BufferedOutputStream r5 = new java.io.BufferedOutputStream     // Catch:{ OutOfMemoryError -> 0x0108, IOException -> 0x0106 }
        java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ OutOfMemoryError -> 0x0108, IOException -> 0x0106 }
        r6 = r17
        r0.<init>(r6)     // Catch:{ OutOfMemoryError -> 0x0108, IOException -> 0x0106 }
        r5.<init>(r0)     // Catch:{ OutOfMemoryError -> 0x0108, IOException -> 0x0106 }
        r0 = 60
        r4 = r20
        r1.compress(r4, r0, r5)     // Catch:{ OutOfMemoryError -> 0x0103, IOException -> 0x0100, all -> 0x00fb }
        r5.flush()     // Catch:{ OutOfMemoryError -> 0x0103, IOException -> 0x0100, all -> 0x00fb }
        java.lang.Boolean r3 = java.lang.Boolean.valueOf(r7)     // Catch:{ OutOfMemoryError -> 0x0103, IOException -> 0x0100, all -> 0x00fb }
        r5.close()     // Catch:{ IOException -> 0x00de }
        goto L_0x00e3
    L_0x00de:
        r0 = move-exception
        r4 = r0
        r4.printStackTrace()
    L_0x00e3:
        if (r2 == 0) goto L_0x00ee
        boolean r0 = r2.isRecycled()
        if (r0 != 0) goto L_0x00ee
        r2.recycle()
    L_0x00ee:
        if (r1 == 0) goto L_0x0164
        boolean r0 = r1.isRecycled()
        if (r0 != 0) goto L_0x0164
    L_0x00f6:
        r1.recycle()
        goto L_0x0164
    L_0x00fb:
        r0 = move-exception
        r3 = r1
        r4 = r5
        goto L_0x0167
    L_0x0100:
        r0 = move-exception
        r4 = r5
        goto L_0x011d
    L_0x0103:
        r0 = move-exception
        r4 = r5
        goto L_0x0142
    L_0x0106:
        r0 = move-exception
        goto L_0x011d
    L_0x0108:
        r0 = move-exception
        goto L_0x0142
    L_0x010a:
        r0 = move-exception
        r1 = r0
        r3 = r4
        goto L_0x0168
    L_0x010f:
        r0 = move-exception
        r1 = r4
        goto L_0x011d
    L_0x0112:
        r0 = move-exception
        r1 = r4
        goto L_0x0142
    L_0x0115:
        r0 = move-exception
        r1 = r0
        r2 = r4
        r3 = r2
        goto L_0x0168
    L_0x011a:
        r0 = move-exception
        r1 = r4
        r2 = r1
    L_0x011d:
        r0.printStackTrace()     // Catch:{ all -> 0x0165 }
        if (r4 == 0) goto L_0x012b
        r4.close()     // Catch:{ IOException -> 0x0126 }
        goto L_0x012b
    L_0x0126:
        r0 = move-exception
        r4 = r0
        r4.printStackTrace()
    L_0x012b:
        if (r2 == 0) goto L_0x0136
        boolean r0 = r2.isRecycled()
        if (r0 != 0) goto L_0x0136
        r2.recycle()
    L_0x0136:
        if (r1 == 0) goto L_0x0164
        boolean r0 = r1.isRecycled()
        if (r0 != 0) goto L_0x0164
        goto L_0x00f6
    L_0x013f:
        r0 = move-exception
        r1 = r4
        r2 = r1
    L_0x0142:
        r0.printStackTrace()     // Catch:{ all -> 0x0165 }
        if (r4 == 0) goto L_0x0150
        r4.close()     // Catch:{ IOException -> 0x014b }
        goto L_0x0150
    L_0x014b:
        r0 = move-exception
        r4 = r0
        r4.printStackTrace()
    L_0x0150:
        if (r2 == 0) goto L_0x015b
        boolean r0 = r2.isRecycled()
        if (r0 != 0) goto L_0x015b
        r2.recycle()
    L_0x015b:
        if (r1 == 0) goto L_0x0164
        boolean r0 = r1.isRecycled()
        if (r0 != 0) goto L_0x0164
        goto L_0x00f6
    L_0x0164:
        return r3
    L_0x0165:
        r0 = move-exception
        r3 = r1
    L_0x0167:
        r1 = r0
    L_0x0168:
        if (r4 == 0) goto L_0x0173
        r4.close()     // Catch:{ IOException -> 0x016e }
        goto L_0x0173
    L_0x016e:
        r0 = move-exception
        r4 = r0
        r4.printStackTrace()
    L_0x0173:
        if (r2 == 0) goto L_0x017e
        boolean r0 = r2.isRecycled()
        if (r0 != 0) goto L_0x017e
        r2.recycle()
    L_0x017e:
        if (r3 == 0) goto L_0x0189
        boolean r0 = r3.isRecycled()
        if (r0 != 0) goto L_0x0189
        r3.recycle()
    L_0x0189:
        throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p488k.p490b.C5940b.m23815a(java.io.File, java.io.File, int, int, android.graphics.Bitmap$CompressFormat):java.lang.Boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b5, code lost:
            r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b6, code lost:
            r12.printStackTrace();
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b5 A[ExcHandler: Exception (r12v1 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:11:0x0043] */
    /* renamed from: a */
    private static java.lang.Boolean m23816a(java.io.File r12, java.io.File r13, android.graphics.Bitmap.CompressFormat r14) {
        /*
        r0 = 0
        java.lang.Boolean r1 = java.lang.Boolean.valueOf(r0)
        java.lang.String r2 = r12.getAbsolutePath()     // Catch:{ Exception -> 0x00b5, OutOfMemoryError -> 0x00b0 }
        int r2 = com.qiyukf.nimlib.p488k.p490b.C5942c.m23821a(r2)     // Catch:{ Exception -> 0x00b5, OutOfMemoryError -> 0x00b0 }
        java.lang.String r3 = r12.getPath()     // Catch:{ Exception -> 0x00b5, OutOfMemoryError -> 0x00b0 }
        android.graphics.Bitmap r0 = com.qiyukf.nimlib.p488k.p490b.C5939a.m23804a(r3, r2, r0)     // Catch:{ Exception -> 0x00b5, OutOfMemoryError -> 0x00b0 }
        if (r0 != 0) goto L_0x0018
        return r1
    L_0x0018:
        java.lang.String r12 = r12.getAbsolutePath()     // Catch:{ Exception -> 0x00b5, OutOfMemoryError -> 0x00b0 }
        int r12 = m23808a(r12)     // Catch:{ Exception -> 0x00b5, OutOfMemoryError -> 0x00b0 }
        r2 = 1234067968(0x498e6200, float:1166400.0)
        int r3 = r0.getWidth()     // Catch:{ Exception -> 0x00b5, OutOfMemoryError -> 0x00b0 }
        float r3 = (float) r3     // Catch:{ Exception -> 0x00b5, OutOfMemoryError -> 0x00b0 }
        int r4 = r0.getHeight()     // Catch:{ Exception -> 0x00b5, OutOfMemoryError -> 0x00b0 }
        float r4 = (float) r4     // Catch:{ Exception -> 0x00b5, OutOfMemoryError -> 0x00b0 }
        float r3 = r3 * r4
        float r2 = r2 / r3
        double r2 = (double) r2     // Catch:{ Exception -> 0x00b5, OutOfMemoryError -> 0x00b0 }
        double r2 = java.lang.Math.sqrt(r2)     // Catch:{ Exception -> 0x00b5, OutOfMemoryError -> 0x00b0 }
        float r2 = (float) r2
        r3 = 1
        r11 = 70
        r4 = 1065353216(0x3f800000, float:1.0)
        if (r12 != 0) goto L_0x0043
        int r5 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
        if (r5 < 0) goto L_0x0043
        r12 = r0
        goto L_0x0065
    L_0x0043:
        android.graphics.Matrix r9 = new android.graphics.Matrix     // Catch:{ OutOfMemoryError -> 0x008f, Exception -> 0x00b5 }
        r9.<init>()     // Catch:{ OutOfMemoryError -> 0x008f, Exception -> 0x00b5 }
        if (r12 == 0) goto L_0x004e
        float r12 = (float) r12     // Catch:{ OutOfMemoryError -> 0x008f, Exception -> 0x00b5 }
        r9.postRotate(r12)     // Catch:{ OutOfMemoryError -> 0x008f, Exception -> 0x00b5 }
    L_0x004e:
        int r12 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
        if (r12 >= 0) goto L_0x0055
        r9.postScale(r2, r2)     // Catch:{ OutOfMemoryError -> 0x008f, Exception -> 0x00b5 }
    L_0x0055:
        r5 = 0
        r6 = 0
        int r7 = r0.getWidth()     // Catch:{ OutOfMemoryError -> 0x008f, Exception -> 0x00b5 }
        int r8 = r0.getHeight()     // Catch:{ OutOfMemoryError -> 0x008f, Exception -> 0x00b5 }
        r10 = 1
        r4 = r0
        android.graphics.Bitmap r12 = android.graphics.Bitmap.createBitmap(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ OutOfMemoryError -> 0x008f, Exception -> 0x00b5 }
    L_0x0065:
        java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x00b5, OutOfMemoryError -> 0x00b0 }
        java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00b5, OutOfMemoryError -> 0x00b0 }
        r4.<init>(r13)     // Catch:{ Exception -> 0x00b5, OutOfMemoryError -> 0x00b0 }
        r2.<init>(r4)     // Catch:{ Exception -> 0x00b5, OutOfMemoryError -> 0x00b0 }
        r12.compress(r14, r11, r2)     // Catch:{ Exception -> 0x00b5, OutOfMemoryError -> 0x00b0 }
        r2.flush()     // Catch:{ Exception -> 0x00b5, OutOfMemoryError -> 0x00b0 }
        r2.close()     // Catch:{ Exception -> 0x00b5, OutOfMemoryError -> 0x00b0 }
        java.lang.Boolean r1 = java.lang.Boolean.valueOf(r3)     // Catch:{ Exception -> 0x00b5, OutOfMemoryError -> 0x00b0 }
        boolean r13 = r0.isRecycled()     // Catch:{ Exception -> 0x00b5, OutOfMemoryError -> 0x00b0 }
        if (r13 != 0) goto L_0x0085
        r0.recycle()     // Catch:{ Exception -> 0x00b5, OutOfMemoryError -> 0x00b0 }
    L_0x0085:
        boolean r13 = r12.isRecycled()     // Catch:{ Exception -> 0x00b5, OutOfMemoryError -> 0x00b0 }
        if (r13 != 0) goto L_0x00b9
        r12.recycle()     // Catch:{ Exception -> 0x00b5, OutOfMemoryError -> 0x00b0 }
        goto L_0x00b9
    L_0x008f:
        java.io.BufferedOutputStream r12 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x00b5, OutOfMemoryError -> 0x00b0 }
        java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00b5, OutOfMemoryError -> 0x00b0 }
        r2.<init>(r13)     // Catch:{ Exception -> 0x00b5, OutOfMemoryError -> 0x00b0 }
        r12.<init>(r2)     // Catch:{ Exception -> 0x00b5, OutOfMemoryError -> 0x00b0 }
        r0.compress(r14, r11, r12)     // Catch:{ Exception -> 0x00b5, OutOfMemoryError -> 0x00b0 }
        r12.flush()     // Catch:{ Exception -> 0x00b5, OutOfMemoryError -> 0x00b0 }
        r12.close()     // Catch:{ Exception -> 0x00b5, OutOfMemoryError -> 0x00b0 }
        java.lang.Boolean r1 = java.lang.Boolean.valueOf(r3)     // Catch:{ Exception -> 0x00b5, OutOfMemoryError -> 0x00b0 }
        boolean r12 = r0.isRecycled()     // Catch:{ Exception -> 0x00b5, OutOfMemoryError -> 0x00b0 }
        if (r12 != 0) goto L_0x00af
        r0.recycle()     // Catch:{ Exception -> 0x00b5, OutOfMemoryError -> 0x00b0 }
    L_0x00af:
        return r1
    L_0x00b0:
        r12 = move-exception
        r12.printStackTrace()
        goto L_0x00b9
    L_0x00b5:
        r12 = move-exception
        r12.printStackTrace()
    L_0x00b9:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p488k.p490b.C5940b.m23816a(java.io.File, java.io.File, android.graphics.Bitmap$CompressFormat):java.lang.Boolean");
    }

    /* renamed from: a */
    public static String m23817a(File file) {
        String a = C5946c.m23834a(file.getName(), C5944b.TYPE_THUMB_IMAGE);
        File a2 = C5362a.m22019a(a);
        if (a2 == null) {
            return null;
        }
        if (m23815a(file, a2, C5637i.m22801b(), C5637i.m22803c(), CompressFormat.JPEG).booleanValue()) {
            return a;
        }
        C5362a.m22021b(a);
        return null;
    }
}
