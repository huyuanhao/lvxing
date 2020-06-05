package ezy.sdk3rd.social.share.p650a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;

/* renamed from: ezy.sdk3rd.social.share.a.a */
public class ImageTool {
    /* renamed from: a */
    public static int f27312a = 768;
    /* renamed from: b */
    public static int f27313b = 1024;

    /* renamed from: a */
    public static byte[] m34849a(Bitmap bitmap, CompressFormat compressFormat) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: a */
    public static Bitmap m34848a(File file) {
        return BitmapFactory.decodeFile(file.toString());
    }
}
