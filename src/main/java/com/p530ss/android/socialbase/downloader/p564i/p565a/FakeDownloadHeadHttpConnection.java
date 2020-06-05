package com.p530ss.android.socialbase.downloader.p564i.p565a;

import com.p530ss.android.socialbase.downloader.p562g.HttpHeader;
import com.p530ss.android.socialbase.downloader.p564i.IDownloadHeadHttpConnection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.ss.android.socialbase.downloader.i.a.c */
public class FakeDownloadHeadHttpConnection implements IDownloadHeadHttpConnection {
    /* renamed from: c */
    private static final ArrayList<String> f22132c = new ArrayList<>(6);
    /* renamed from: a */
    protected List<HttpHeader> f22133a;
    /* renamed from: b */
    protected final Object f22134b;
    /* renamed from: d */
    private Map<String, String> f22135d;
    /* renamed from: e */
    private int f22136e;
    /* renamed from: f */
    private long f22137f;
    /* renamed from: g */
    private boolean f22138g;
    /* renamed from: h */
    private boolean f22139h;
    /* renamed from: i */
    private IDownloadHeadHttpConnection f22140i;

    static {
        f22132c.add("Content-Length");
        f22132c.add("Content-Range");
        f22132c.add("Transfer-Encoding");
        f22132c.add("Accept-Ranges");
        f22132c.add("Etag");
        f22132c.add("Content-Disposition");
    }

    /* renamed from: a */
    public void mo32457a() throws InterruptedException {
        synchronized (this.f22134b) {
            if (this.f22139h && this.f22135d == null) {
                this.f22134b.wait();
            }
        }
    }

    /* renamed from: a */
    public String mo16500a(String str) {
        Map<String, String> map = this.f22135d;
        if (map != null) {
            return (String) map.get(str);
        }
        IDownloadHeadHttpConnection cVar = this.f22140i;
        if (cVar != null) {
            return cVar.mo16500a(str);
        }
        return null;
    }

    /* renamed from: b */
    public int mo16501b() throws IOException {
        return this.f22136e;
    }

    /* renamed from: c */
    public void mo16502c() {
        IDownloadHeadHttpConnection cVar = this.f22140i;
        if (cVar != null) {
            cVar.mo16502c();
        }
    }

    /* renamed from: d */
    public boolean mo32458d() {
        return this.f22138g;
    }

    /* renamed from: e */
    public boolean mo32459e() {
        return System.currentTimeMillis() - this.f22137f < DownloadPreconnecter.f22129b;
    }

    /* renamed from: f */
    public List<HttpHeader> mo32460f() {
        return this.f22133a;
    }
}
