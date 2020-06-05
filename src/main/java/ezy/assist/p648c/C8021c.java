package ezy.assist.p648c;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: FileUtil */
/* renamed from: ezy.assist.c.c */
public class C8021c {
    /* renamed from: a */
    public static String m34803a(String str) {
        try {
            return C8022d.m34807a(new File(str));
        } catch (IOException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static void m34804a(String str, String str2) {
        try {
            C8022d.m34806a(new ByteArrayInputStream(str2.getBytes()), new FileOutputStream(str));
        } catch (IOException unused) {
        }
    }

    /* renamed from: b */
    public static void m34805b(String str) {
        new File(str).mkdirs();
    }
}
