package com.tencent.stat.common;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.util.Log;
import com.tencent.p605ep.commonbase.utils.ScreenUtil;
import java.io.File;

/* renamed from: com.tencent.stat.common.g */
public class C7600g {
    /* renamed from: a */
    private static int m32768a(int i, int i2) {
        return i < i2 ? i : i2;
    }

    /* renamed from: a */
    private static Bitmap m32770a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        float a = 240.0f / ((float) m32768a(bitmap.getWidth(), bitmap.getHeight()));
        matrix.postScale(a, a);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x003a A[SYNTHETIC, Splitter:B:22:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0043 A[Catch:{ IOException -> 0x005a }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x004d A[SYNTHETIC, Splitter:B:31:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0056 A[Catch:{ IOException -> 0x005a }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0061 A[SYNTHETIC, Splitter:B:40:0x0061] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x006a A[Catch:{ IOException -> 0x006e }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:19:0x0035=Splitter:B:19:0x0035, B:28:0x0048=Splitter:B:28:0x0048} */
    /* renamed from: a */
    private static void m32772a(android.graphics.Bitmap r2, java.io.File r3) {
        /*
        if (r2 != 0) goto L_0x0003
        return
    L_0x0003:
        java.lang.String r0 = r3.toString()
        java.lang.String r1 = "savePic"
        android.util.Log.e(r1, r0)
        r0 = 0
        java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x0034 }
        r1.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x0034 }
        android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ FileNotFoundException -> 0x002f, IOException -> 0x002c, all -> 0x0029 }
        r0 = 75
        r2.compress(r3, r0, r1)     // Catch:{ FileNotFoundException -> 0x002f, IOException -> 0x002c, all -> 0x0029 }
        r1.flush()     // Catch:{ FileNotFoundException -> 0x002f, IOException -> 0x002c, all -> 0x0029 }
        r1.close()     // Catch:{ IOException -> 0x005a }
        boolean r3 = r2.isRecycled()     // Catch:{ IOException -> 0x005a }
        if (r3 != 0) goto L_0x005e
        r2.recycle()     // Catch:{ IOException -> 0x005a }
        goto L_0x005e
    L_0x0029:
        r3 = move-exception
        r0 = r1
        goto L_0x005f
    L_0x002c:
        r3 = move-exception
        r0 = r1
        goto L_0x0035
    L_0x002f:
        r3 = move-exception
        r0 = r1
        goto L_0x0048
    L_0x0032:
        r3 = move-exception
        goto L_0x005f
    L_0x0034:
        r3 = move-exception
    L_0x0035:
        r3.printStackTrace()     // Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x003d
        r0.close()     // Catch:{ IOException -> 0x005a }
    L_0x003d:
        boolean r3 = r2.isRecycled()     // Catch:{ IOException -> 0x005a }
        if (r3 != 0) goto L_0x005e
        r2.recycle()     // Catch:{ IOException -> 0x005a }
        goto L_0x005e
    L_0x0047:
        r3 = move-exception
    L_0x0048:
        r3.printStackTrace()     // Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0050
        r0.close()     // Catch:{ IOException -> 0x005a }
    L_0x0050:
        boolean r3 = r2.isRecycled()     // Catch:{ IOException -> 0x005a }
        if (r3 != 0) goto L_0x005e
        r2.recycle()     // Catch:{ IOException -> 0x005a }
        goto L_0x005e
    L_0x005a:
        r2 = move-exception
        r2.printStackTrace()
    L_0x005e:
        return
    L_0x005f:
        if (r0 == 0) goto L_0x0064
        r0.close()     // Catch:{ IOException -> 0x006e }
    L_0x0064:
        boolean r0 = r2.isRecycled()     // Catch:{ IOException -> 0x006e }
        if (r0 != 0) goto L_0x0072
        r2.recycle()     // Catch:{ IOException -> 0x006e }
        goto L_0x0072
    L_0x006e:
        r2 = move-exception
        r2.printStackTrace()
    L_0x0072:
        throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.common.C7600g.m32772a(android.graphics.Bitmap, java.io.File):void");
    }

    /* renamed from: a */
    private static int m32769a(Options options, int i) {
        double d;
        int i2 = options.outHeight;
        int i3 = options.outWidth;
        if (i3 > i2) {
            d = Math.floor((double) (((float) i2) / ((float) i)));
        } else {
            d = Math.floor((double) (((float) i3) / ((float) i)));
        }
        int i4 = (((int) d) / 2) * 2;
        if (i4 < 1) {
            return 0;
        }
        return i4;
    }

    /* renamed from: a */
    private static Bitmap m32771a(String str, int i) {
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            if (!options.mCancel && options.outWidth != -1) {
                if (options.outHeight != -1) {
                    options.inSampleSize = m32769a(options, i);
                    options.inJustDecodeBounds = false;
                    options.inDither = false;
                    options.inPreferredConfig = Config.RGB_565;
                    Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                    Bitmap a = m32770a(decodeFile);
                    if (decodeFile != null && !decodeFile.isRecycled()) {
                        decodeFile.recycle();
                    }
                    return a;
                }
            }
            return null;
        } catch (OutOfMemoryError e) {
            Log.e("ScreenShot", "Got oom exception ", e);
            System.gc();
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static void m32773a(String str, File file) {
        m32772a(m32771a(str, (int) ScreenUtil.G8_WIDTH), file);
    }
}
