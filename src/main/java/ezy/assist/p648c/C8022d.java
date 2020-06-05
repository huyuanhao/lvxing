package ezy.assist.p648c;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.text.Charsets;

/* compiled from: IoUtil */
/* renamed from: ezy.assist.c.d */
public class C8022d {
    /* renamed from: a */
    public static void m34809a(Closeable... closeableArr) {
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public static long m34806a(InputStream inputStream, OutputStream outputStream) throws IOException {
        try {
            long b = m34810b(inputStream, outputStream);
            m34809a(inputStream, outputStream);
            return b;
        } catch (Throwable th) {
            m34809a(inputStream, outputStream);
            throw th;
        }
    }

    /* renamed from: a */
    public static String m34807a(File file) throws IOException {
        return m34808a((InputStream) new FileInputStream(file));
    }

    /* renamed from: a */
    public static String m34808a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m34806a(inputStream, byteArrayOutputStream);
        return new String(byteArrayOutputStream.toByteArray(), Charsets.f27799a);
    }

    /* renamed from: b */
    public static long m34810b(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                outputStream.write(bArr, 0, read);
                j += (long) read;
            } else {
                outputStream.flush();
                return j;
            }
        }
    }
}
