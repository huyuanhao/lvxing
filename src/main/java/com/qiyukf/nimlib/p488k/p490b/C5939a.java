package com.qiyukf.nimlib.p488k.p490b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import android.text.TextUtils;
import com.qiyukf.basesdk.p412c.p413a.C5362a;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import java.io.File;

/* renamed from: com.qiyukf.nimlib.k.b.a */
public final class C5939a {
    /* renamed from: a */
    public static Bitmap m23804a(String str, int i, boolean z) {
        Options options = new Options();
        options.inPreferredConfig = z ? Config.ARGB_8888 : Config.RGB_565;
        options.inSampleSize = i;
        try {
            return BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m23805a(String str, String str2, int i, int i2) {
        boolean z = !TextUtils.isEmpty(str2) && new File(str2).exists();
        if (z) {
            return false;
        }
        C5362a.m22020a(ThumbnailUtils.extractThumbnail(ThumbnailUtils.createVideoThumbnail(str, 1), i, i2, 2), str2);
        return true;
    }

    /* renamed from: a */
    public static int[] m23806a(String str) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return new int[]{options.outWidth, options.outHeight};
    }

    /* renamed from: b */
    public static Bitmap m23807b(String str) {
        Bitmap a;
        int[][] iArr = {new int[]{C5412d.m22145a() << 1, C5412d.m22148b()}, new int[]{C5412d.m22145a(), C5412d.m22148b() << 1}, new int[]{(int) (((double) C5412d.m22145a()) * 1.414d), (int) (((double) C5412d.m22148b()) * 1.414d)}};
        int[] a2 = m23806a(str);
        float f = 0.0f;
        float f2 = a2[1] == 0 ? 0.0f : ((float) a2[0]) / ((float) a2[1]);
        if (a2[0] != 0) {
            f = ((float) a2[1]) / ((float) a2[0]);
        }
        int[] iArr2 = f2 >= 5.0f ? iArr[0] : f >= 5.0f ? iArr[1] : iArr[2];
        int i = a2[0];
        int i2 = a2[1];
        int a3 = C5942c.m23819a(C5942c.m23820a(i, i2, iArr2[0], iArr2[1]), i, i2);
        int i3 = 5;
        while (true) {
            a = m23804a(str, a3, true);
            if (a != null || i3 <= 0) {
                return a;
            }
            a3++;
            i3--;
        }
        return a;
    }
}
