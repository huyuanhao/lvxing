package com.jiayouya.travel.common.p246d;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import ezy.assist.p648c.C8022d;
import java.io.File;
import java.io.FileOutputStream;

/* renamed from: com.jiayouya.travel.common.d.h */
public class ImageUtil {
    /* renamed from: a */
    public static void m12961a(Bitmap bitmap, File file, int i) {
        m12962a(bitmap, file, i, CompressFormat.JPEG);
    }

    /* renamed from: a */
    public static void m12962a(Bitmap bitmap, File file, int i, CompressFormat compressFormat) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        int i2 = 1;
        while (true) {
            if (i2 > 10) {
                break;
            }
            try {
                FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                try {
                    bitmap.compress(compressFormat, (int) (Math.pow(0.8d, (double) i2) * 100.0d), fileOutputStream3);
                    if (file.length() <= ((long) i)) {
                        fileOutputStream = fileOutputStream3;
                        break;
                    }
                    C8022d.m34809a(fileOutputStream3);
                    i2++;
                    fileOutputStream2 = fileOutputStream3;
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream3;
                    try {
                        e.printStackTrace();
                        C8022d.m34809a(fileOutputStream);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream3 = fileOutputStream;
                        C8022d.m34809a(fileOutputStream3);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    C8022d.m34809a(fileOutputStream3);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                C8022d.m34809a(fileOutputStream);
                return;
            }
        }
        C8022d.m34809a(fileOutputStream);
    }

    /* renamed from: a */
    public static Bitmap m12960a(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        matrix.setRotate((float) i, ((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
        try {
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        }
    }
}
