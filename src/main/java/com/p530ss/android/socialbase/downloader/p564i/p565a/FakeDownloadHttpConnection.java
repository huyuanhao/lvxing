package com.p530ss.android.socialbase.downloader.p564i.p565a;

import com.p530ss.android.socialbase.downloader.p562g.HttpHeader;
import com.p530ss.android.socialbase.downloader.p564i.IDownloadHttpConnection;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* renamed from: com.ss.android.socialbase.downloader.i.a.d */
public class FakeDownloadHttpConnection implements IDownloadHttpConnection {
    /* renamed from: a */
    protected final Object f22141a;
    /* renamed from: b */
    private final List<HttpHeader> f22142b;
    /* renamed from: c */
    private IDownloadHttpConnection f22143c;
    /* renamed from: d */
    private boolean f22144d;
    /* renamed from: e */
    private long f22145e;
    /* renamed from: f */
    private InputStream f22146f;

    /* renamed from: a */
    public boolean mo32461a(int i) {
        return i >= 200 && i < 300;
    }

    /* renamed from: e */
    public void mo32462e() throws InterruptedException {
        synchronized (this.f22141a) {
            if (this.f22144d && this.f22143c == null) {
                this.f22141a.wait();
            }
        }
    }

    /* renamed from: a */
    public InputStream mo16499a() throws IOException {
        InputStream inputStream = this.f22146f;
        if (inputStream != null) {
            return inputStream;
        }
        return null;
    }

    /* renamed from: d */
    public void mo16503d() {
        IDownloadHttpConnection eVar = this.f22143c;
        if (eVar != null) {
            eVar.mo16503d();
        }
    }

    /* renamed from: a */
    public String mo16500a(String str) {
        IDownloadHttpConnection eVar = this.f22143c;
        if (eVar != null) {
            return eVar.mo16500a(str);
        }
        return null;
    }

    /* renamed from: b */
    public int mo16501b() throws IOException {
        IDownloadHttpConnection eVar = this.f22143c;
        if (eVar != null) {
            return eVar.mo16501b();
        }
        return 0;
    }

    /* renamed from: f */
    public List<HttpHeader> mo32463f() {
        return this.f22142b;
    }

    /* renamed from: c */
    public void mo16502c() {
        IDownloadHttpConnection eVar = this.f22143c;
        if (eVar != null) {
            eVar.mo16502c();
        }
    }

    /* renamed from: g */
    public boolean mo32464g() {
        boolean z = false;
        try {
            if (this.f22143c != null && mo32461a(this.f22143c.mo16501b())) {
                z = true;
            }
            return z;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: h */
    public boolean mo32465h() {
        return System.currentTimeMillis() - this.f22145e < DownloadPreconnecter.f22128a;
    }
}
