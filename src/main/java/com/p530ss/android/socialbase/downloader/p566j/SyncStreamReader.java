package com.p530ss.android.socialbase.downloader.p566j;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.ss.android.socialbase.downloader.j.e */
public class SyncStreamReader implements IStreamReader {
    /* renamed from: a */
    private final InputStream f22289a;
    /* renamed from: b */
    private final C6744b f22290b;

    /* renamed from: a */
    public void mo32543a(C6744b bVar) {
    }

    public SyncStreamReader(InputStream inputStream, int i) {
        this.f22289a = inputStream;
        this.f22290b = new C6744b(i);
    }

    /* renamed from: a */
    public C6744b mo32542a() throws IOException {
        C6744b bVar = this.f22290b;
        bVar.f22287b = this.f22289a.read(bVar.f22286a);
        return this.f22290b;
    }

    /* renamed from: b */
    public void mo32544b() {
        try {
            this.f22289a.close();
        } catch (Throwable unused) {
        }
    }
}
