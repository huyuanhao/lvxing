package com.p530ss.android.socialbase.appdownloader.p554e.p555a;

import java.io.IOException;

/* renamed from: com.ss.android.socialbase.appdownloader.e.a.b */
public class ChunkUtil {
    /* renamed from: a */
    public static final void m26798a(IntReader dVar, int i) throws IOException {
        int b = dVar.mo31531b();
        if (b != i) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected chunk of type 0x");
            sb.append(Integer.toHexString(i));
            sb.append(", read 0x");
            sb.append(Integer.toHexString(b));
            sb.append(".");
            throw new IOException(sb.toString());
        }
    }
}
