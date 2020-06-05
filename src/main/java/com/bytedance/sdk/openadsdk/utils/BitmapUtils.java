package com.bytedance.sdk.openadsdk.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/* renamed from: com.bytedance.sdk.openadsdk.utils.f */
public class BitmapUtils {
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
            if (r1 != null) goto L_0x001f;
     */
    /* renamed from: a */
    public static java.lang.String m12137a(android.graphics.Bitmap r4) {
        /*
        r0 = 0
        if (r4 != 0) goto L_0x0004
        return r0
    L_0x0004:
        java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0026 }
        r1.<init>()     // Catch:{ all -> 0x0026 }
        android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ all -> 0x0027 }
        r3 = 100
        r4.compress(r2, r3, r1)     // Catch:{ all -> 0x0027 }
        r1.flush()     // Catch:{ all -> 0x0027 }
        r1.close()     // Catch:{ all -> 0x0027 }
        byte[] r4 = r1.toByteArray()     // Catch:{ all -> 0x0027 }
        r2 = 0
        java.lang.String r0 = android.util.Base64.encodeToString(r4, r2)     // Catch:{ all -> 0x0027 }
    L_0x001f:
        r1.flush()     // Catch:{ all -> 0x002a }
        r1.close()     // Catch:{ all -> 0x002a }
        goto L_0x002a
    L_0x0026:
        r1 = r0
    L_0x0027:
        if (r1 == 0) goto L_0x002a
        goto L_0x001f
    L_0x002a:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.BitmapUtils.m12137a(android.graphics.Bitmap):java.lang.String");
    }

    /* renamed from: a */
    public static Bitmap m12136a(String str) {
        Bitmap bitmap = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            bitmap = BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Throwable unused) {
        }
        return bitmap;
    }

    /* renamed from: b */
    public static byte[] m12138b(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bitmap.getByteCount());
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: a */
    public static Bitmap m12135a(Bitmap bitmap, int i, int i2) {
        int i3;
        if (bitmap == null) {
            return null;
        }
        if (bitmap.isRecycled()) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        StringBuilder sb = new StringBuilder();
        sb.append(width);
        sb.append(" originWidth");
        String str = "BitmapUtils";
        Log.i(str, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(height);
        sb2.append(" originHeight");
        Log.i(str, sb2.toString());
        if (width < i && height < i2) {
            return bitmap;
        }
        if (width > i) {
            i3 = (int) Math.floor(((double) height) / ((((double) width) * 1.0d) / ((double) i)));
            if (i > 0 && i3 > 0 && !bitmap.isRecycled()) {
                bitmap = Bitmap.createScaledBitmap(bitmap, i, i3, false);
            }
        } else {
            i = width;
            i3 = height;
        }
        if (i3 <= i2) {
            i2 = i3;
        } else if (i > 0 && i2 > 0 && !bitmap.isRecycled()) {
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, i, i2);
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(i);
        sb3.append(" width");
        Log.i(str, sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(i2);
        sb4.append(" height");
        Log.i(str, sb4.toString());
        return bitmap;
    }

    /* renamed from: a */
    public static Bitmap m12134a(Bitmap bitmap, int i) {
        if (bitmap == null || bitmap.getRowBytes() * bitmap.getHeight() < i) {
            return bitmap;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        int i2 = 90;
        while (byteArrayOutputStream.toByteArray().length > i) {
            byteArrayOutputStream.reset();
            bitmap.compress(CompressFormat.PNG, i2, byteArrayOutputStream);
            i2 -= 10;
        }
        return BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), null, null);
    }
}
