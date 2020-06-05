package com.pgl.p359a.p361b;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipFile;

/* renamed from: com.pgl.a.b.b */
public class C4783b {
    /* renamed from: a */
    public static void m19608a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m19609a(String str, int i) {
        Integer valueOf = Integer.valueOf(-1);
        C4784c.m19615a("android.os.FileUtils", str, Integer.valueOf(i), valueOf, valueOf);
    }

    /* renamed from: a */
    public static void m19610a(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: a */
    public static boolean m19611a(String str) {
        return new File(str).mkdirs();
    }
}
