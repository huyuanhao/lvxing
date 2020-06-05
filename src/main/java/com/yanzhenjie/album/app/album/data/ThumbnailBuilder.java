package com.yanzhenjie.album.app.album.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.yanzhenjie.album.p629b.AlbumUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;

public class ThumbnailBuilder {
    /* renamed from: a */
    private File f26255a;

    public ThumbnailBuilder(Context context) {
        this.f26255a = AlbumUtils.m33538a(context);
        if (this.f26255a.exists() && this.f26255a.isFile()) {
            this.f26255a.delete();
        }
        if (!this.f26255a.exists()) {
            this.f26255a.mkdirs();
        }
    }

    /* renamed from: a */
    public String mo37642a(String str) {
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return null;
        }
        File c = m33464c(str);
        if (c.exists()) {
            return c.getAbsolutePath();
        }
        Bitmap a = m33463a(str, 360, 360);
        if (a == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a.compress(CompressFormat.JPEG, 80, byteArrayOutputStream);
        try {
            byteArrayOutputStream.close();
            c.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(c);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            fileOutputStream.flush();
            fileOutputStream.close();
            return c.getAbsolutePath();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public String mo37643b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File c = m33464c(str);
        if (c.exists()) {
            return c.getAbsolutePath();
        }
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            if (URLUtil.isNetworkUrl(str)) {
                mediaMetadataRetriever.setDataSource(str, new HashMap());
            } else {
                mediaMetadataRetriever.setDataSource(str);
            }
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
            c.createNewFile();
            frameAtTime.compress(CompressFormat.JPEG, 80, new FileOutputStream(c));
            return c.getAbsolutePath();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: c */
    private File m33464c(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(AlbumUtils.m33554d(str));
        sb.append(".album");
        return new File(this.f26255a, sb.toString());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:9|10|26) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
            r3.inSampleSize *= 2;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0040 */
    /* renamed from: a */
    public static android.graphics.Bitmap m33463a(java.lang.String r12, int r13, int r14) {
        /*
        java.io.File r0 = new java.io.File
        r0.<init>(r12)
        boolean r1 = r0.exists()
        r2 = 0
        if (r1 == 0) goto L_0x0085
        java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0085 }
        java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0085 }
        r3.<init>(r0)     // Catch:{ Exception -> 0x0085 }
        r1.<init>(r3)     // Catch:{ Exception -> 0x0085 }
        android.graphics.BitmapFactory$Options r3 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x0085 }
        r3.<init>()     // Catch:{ Exception -> 0x0085 }
        r4 = 1
        r3.inJustDecodeBounds = r4     // Catch:{ Exception -> 0x0085 }
        android.graphics.BitmapFactory.decodeStream(r1, r2, r3)     // Catch:{ Exception -> 0x0085 }
        r1.close()     // Catch:{ Exception -> 0x0085 }
        r1 = 0
        r3.inJustDecodeBounds = r1     // Catch:{ Exception -> 0x0085 }
        int r13 = m33462a(r3, r13, r14)     // Catch:{ Exception -> 0x0085 }
        r3.inSampleSize = r13     // Catch:{ Exception -> 0x0085 }
        r13 = r2
    L_0x002e:
        if (r1 != 0) goto L_0x004a
        java.io.BufferedInputStream r14 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0085 }
        java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0085 }
        r5.<init>(r0)     // Catch:{ Exception -> 0x0085 }
        r14.<init>(r5)     // Catch:{ Exception -> 0x0085 }
        android.graphics.Bitmap r13 = android.graphics.BitmapFactory.decodeStream(r14, r2, r3)     // Catch:{ Exception -> 0x0040 }
        r1 = 1
        goto L_0x0046
    L_0x0040:
        int r5 = r3.inSampleSize     // Catch:{ Exception -> 0x0085 }
        int r5 = r5 * 2
        r3.inSampleSize = r5     // Catch:{ Exception -> 0x0085 }
    L_0x0046:
        r14.close()     // Catch:{ Exception -> 0x0085 }
        goto L_0x002e
    L_0x004a:
        java.lang.String r14 = r12.toLowerCase()     // Catch:{ Exception -> 0x0085 }
        java.lang.String r0 = ".jpg"
        boolean r0 = r14.endsWith(r0)     // Catch:{ Exception -> 0x0085 }
        if (r0 != 0) goto L_0x005e
        java.lang.String r0 = ".jpeg"
        boolean r14 = r14.endsWith(r0)     // Catch:{ Exception -> 0x0085 }
        if (r14 == 0) goto L_0x0083
    L_0x005e:
        int r12 = m33465d(r12)     // Catch:{ Exception -> 0x0085 }
        if (r12 <= 0) goto L_0x0083
        android.graphics.Matrix r10 = new android.graphics.Matrix     // Catch:{ Exception -> 0x0085 }
        r10.<init>()     // Catch:{ Exception -> 0x0085 }
        float r12 = (float) r12     // Catch:{ Exception -> 0x0085 }
        r10.setRotate(r12)     // Catch:{ Exception -> 0x0085 }
        r6 = 0
        r7 = 0
        int r8 = r13.getWidth()     // Catch:{ Exception -> 0x0085 }
        int r9 = r13.getHeight()     // Catch:{ Exception -> 0x0085 }
        r11 = 1
        r5 = r13
        android.graphics.Bitmap r12 = android.graphics.Bitmap.createBitmap(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0085 }
        if (r12 == r13) goto L_0x0083
        r13.recycle()     // Catch:{ Exception -> 0x0085 }
        goto L_0x0084
    L_0x0083:
        r12 = r13
    L_0x0084:
        return r12
    L_0x0085:
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yanzhenjie.album.app.album.data.ThumbnailBuilder.m33463a(java.lang.String, int, int):android.graphics.Bitmap");
    }

    /* renamed from: a */
    private static int m33462a(Options options, int i, int i2) {
        if (options.outWidth > i || options.outHeight > i2) {
            return Math.min(Math.round(((float) options.outWidth) / ((float) i)), Math.round(((float) options.outHeight) / ((float) i2)));
        }
        return 1;
    }

    /* renamed from: d */
    private static int m33465d(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                return TinkerReport.KEY_APPLIED_VERSION_CHECK;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt != 8) {
                return 0;
            }
            return 270;
        } catch (Exception unused) {
            return 0;
        }
    }
}
