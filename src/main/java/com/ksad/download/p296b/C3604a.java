package com.ksad.download.p296b;

import java.io.IOException;
import okhttp3.C8362ab;
import okhttp3.C8508u;
import okhttp3.C8508u.C8509a;

/* renamed from: com.ksad.download.b.a */
public class C3604a implements C8508u {
    public C8362ab intercept(C8509a aVar) {
        try {
            return aVar.mo40244a(aVar.mo40246a());
        } catch (Exception e) {
            if (e instanceof IOException) {
                throw e;
            }
            throw new IOException(e);
        }
    }
}
