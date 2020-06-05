package com.yanzhenjie.durban.p632c;

import android.graphics.Bitmap.CompressFormat;
import com.yanzhenjie.durban.error.StorageError;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/* compiled from: FileUtils */
/* renamed from: com.yanzhenjie.durban.c.f */
public class C7792f {
    /* renamed from: a */
    private static Random f26480a = new Random();

    /* renamed from: a */
    public static void m33829a(String str) throws StorageError {
        File file = new File(str);
        try {
            if (file.isFile()) {
                file.delete();
            }
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception unused) {
            throw new StorageError("Directory creation failed.");
        }
    }

    /* renamed from: a */
    public static String m33827a(CompressFormat compressFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmSSS", Locale.getDefault());
        Date date = new Date(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();
        sb.append(simpleDateFormat.format(date));
        sb.append(f26480a.nextInt(9000));
        sb.append(".");
        sb.append(compressFormat);
        return sb.toString();
    }

    /* renamed from: a */
    public static void m33830a(String str, String str2) throws StorageError {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            byte[] bArr = new byte[2048];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    return;
                }
            }
        } catch (IOException e) {
            throw new StorageError((Throwable) e);
        }
    }

    /* renamed from: a */
    public static void m33828a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
