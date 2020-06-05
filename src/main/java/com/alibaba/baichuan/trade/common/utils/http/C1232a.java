package com.alibaba.baichuan.trade.common.utils.http;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.alibaba.baichuan.trade.common.utils.http.a */
public class C1232a {
    /* renamed from: a */
    public static String m2443a(InputStream inputStream, String str) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr, 0, 1024);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    String str2 = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                    m2444a(inputStream);
                    return str2;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Throwable th) {
            m2444a(inputStream);
            throw th;
        }
    }

    /* renamed from: a */
    public static void m2444a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }
}
