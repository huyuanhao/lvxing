package com.ali.auth.third.core.rpc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.ali.auth.third.core.rpc.b */
public class C1033b {
    /* renamed from: a */
    protected static ByteArrayOutputStream m1973a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    /* renamed from: b */
    protected static String m1974b(String str) {
        return "utf-8";
    }
}
