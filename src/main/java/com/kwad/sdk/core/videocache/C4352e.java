package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.kwad.sdk.core.videocache.p343a.C4334b;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/* renamed from: com.kwad.sdk.core.videocache.e */
class C4352e extends C4363k {
    /* renamed from: a */
    private final C4360h f14263a;
    /* renamed from: b */
    private final C4334b f14264b;
    /* renamed from: c */
    private C4343b f14265c;

    public C4352e(C4360h hVar, C4334b bVar) {
        super(hVar, bVar);
        this.f14264b = bVar;
        this.f14263a = hVar;
    }

    /* renamed from: a */
    private String m17760a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    /* renamed from: a */
    private void m17761a(OutputStream outputStream, long j) {
        byte[] bArr = new byte[8192];
        while (true) {
            int a = mo24525a(bArr, j, bArr.length);
            if (a != -1) {
                outputStream.write(bArr, 0, a);
                j += (long) a;
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    /* renamed from: a */
    private boolean m17762a(C4348d dVar) {
        long a = this.f14263a.mo24517a();
        return !((a > 0 ? 1 : (a == 0 ? 0 : -1)) > 0) || !dVar.f14261c || ((float) dVar.f14260b) <= ((float) this.f14264b.mo24483a()) + (((float) a) * 0.2f);
    }

    /* renamed from: b */
    private String m17763b(C4348d dVar) {
        String c = this.f14263a.mo24520c();
        boolean z = !TextUtils.isEmpty(c);
        long a = this.f14264b.mo24487d() ? this.f14264b.mo24483a() : this.f14263a.mo24517a();
        boolean z2 = a >= 0;
        long j = dVar.f14261c ? a - dVar.f14260b : a;
        boolean z3 = z2 && dVar.f14261c;
        StringBuilder sb = new StringBuilder();
        sb.append(dVar.f14261c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        String str = "";
        sb.append(z2 ? m17760a("Content-Length: %d\n", Long.valueOf(j)) : str);
        sb.append(z3 ? m17760a("Content-Range: bytes %d-%d/%d\n", Long.valueOf(dVar.f14260b), Long.valueOf(a - 1), Long.valueOf(a)) : str);
        if (z) {
            str = m17760a("Content-Type: %s\n", c);
        }
        sb.append(str);
        sb.append("\n");
        return sb.toString();
    }

    /* renamed from: b */
    private void m17764b(OutputStream outputStream, long j) {
        C4360h hVar = new C4360h(this.f14263a);
        try {
            hVar.mo24518a((long) ((int) j));
            byte[] bArr = new byte[8192];
            while (true) {
                int a = hVar.mo24516a(bArr);
                if (a != -1) {
                    outputStream.write(bArr, 0, a);
                } else {
                    outputStream.flush();
                    return;
                }
            }
        } finally {
            hVar.mo24519b();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo24503a(int i) {
        C4343b bVar = this.f14265c;
        if (bVar != null) {
            bVar.mo24495a(this.f14264b.f14244a, this.f14263a.mo24521d(), i);
        }
    }

    /* renamed from: a */
    public void mo24504a(C4343b bVar) {
        this.f14265c = bVar;
    }

    /* renamed from: a */
    public void mo24505a(C4348d dVar, Socket socket) {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(m17763b(dVar).getBytes("UTF-8"));
        long j = dVar.f14260b;
        if (m17762a(dVar)) {
            m17761a((OutputStream) bufferedOutputStream, j);
        } else {
            m17764b(bufferedOutputStream, j);
        }
    }
}
