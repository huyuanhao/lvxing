package com.yanzhenjie.durban.p632c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.io.FileInputStream;
import java.io.IOException;

/* renamed from: com.yanzhenjie.durban.c.a */
public class BitmapLoadUtils {
    /* renamed from: a */
    public static int m33813a(int i) {
        switch (i) {
            case 3:
            case 4:
                return TinkerReport.KEY_APPLIED_VERSION_CHECK;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    /* renamed from: b */
    public static int m33818b(int i) {
        return (i == 2 || i == 7 || i == 4 || i == 5) ? -1 : 1;
    }

    /* renamed from: a */
    public static Bitmap m33817a(Bitmap bitmap, Matrix matrix) {
        try {
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            return bitmap;
        } catch (OutOfMemoryError unused) {
            return bitmap;
        }
    }

    /* renamed from: a */
    public static int m33815a(Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            while (true) {
                if (i3 / i5 <= i2 && i4 / i5 <= i) {
                    break;
                }
                i5 *= 2;
            }
        }
        return i5;
    }

    /* renamed from: a */
    public static int m33816a(String str) {
        int i = 0;
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            i = new ImageHeaderParser(fileInputStream).mo37836a();
            fileInputStream.close();
            return i;
        } catch (IOException e) {
            e.printStackTrace();
            return i;
        }
    }

    /* renamed from: a */
    public static int m33814a(Context context) {
        int i;
        int i2;
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (VERSION.SDK_INT >= 13) {
            defaultDisplay.getSize(point);
            i = point.x;
            i2 = point.y;
        } else {
            int width = defaultDisplay.getWidth();
            i2 = defaultDisplay.getHeight();
            i = width;
        }
        int sqrt = (int) Math.sqrt(Math.pow((double) i, 2.0d) + Math.pow((double) i2, 2.0d));
        int a = EglUtils.m33822a();
        return a > 0 ? Math.min(sqrt, a) : sqrt;
    }
}
