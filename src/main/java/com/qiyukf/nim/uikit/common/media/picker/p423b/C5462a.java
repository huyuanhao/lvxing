package com.qiyukf.nim.uikit.common.media.picker.p423b;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.nimlib.p488k.p490b.C5940b;

/* renamed from: com.qiyukf.nim.uikit.common.media.picker.b.a */
public final class C5462a {
    /* renamed from: a */
    public static Bitmap m22273a(Bitmap bitmap, String str) {
        String str2;
        String str3;
        String str4 = "path:";
        int a = C5940b.m23808a(str);
        if (a == 0) {
            return bitmap;
        }
        try {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            matrix.setRotate((float) a, (float) (width / 2), (float) (height / 2));
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            return bitmap;
        } catch (Exception e) {
            e = e;
            StringBuilder sb = new StringBuilder(str4);
            sb.append(str);
            str2 = sb.toString();
            str3 = "reviewPicRotate is error";
        } catch (OutOfMemoryError e2) {
            e = e2;
            StringBuilder sb2 = new StringBuilder(str4);
            sb2.append(str);
            str2 = sb2.toString();
            str3 = "reviewPicRotate is outofmemory";
        }
        C5264a.m21621b(str3, str2, e);
        return bitmap;
    }
}
