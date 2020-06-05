package com.p530ss.android.socialbase.downloader.impls;

import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.p562g.HttpHeader;
import com.p530ss.android.socialbase.downloader.p564i.IDownloadHttpConnection;
import com.p530ss.android.socialbase.downloader.p564i.IDownloadHttpService;
import com.p530ss.android.socialbase.downloader.p569m.DownloadUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.GZIPInputStream;
import okhttp3.C8362ab;
import okhttp3.C8364ac;
import okhttp3.C8379e;
import okhttp3.C8513x;
import okhttp3.C8518z.C8519a;

/* renamed from: com.ss.android.socialbase.downloader.impls.g */
public class DefaultDownloadHttpService implements IDownloadHttpService {
    /* renamed from: a */
    public IDownloadHttpConnection mo16498a(int i, String str, List<HttpHeader> list) throws IOException {
        C8513x n = C6694b.m27382n();
        if (n != null) {
            C8519a a = new C8519a().mo40655a(str);
            if (list != null && list.size() > 0) {
                for (HttpHeader eVar : list) {
                    a.mo40662b(eVar.mo32429a(), DownloadUtils.m28814f(eVar.mo32430b()));
                }
            }
            final C8379e a2 = n.mo40177a(a.mo40663b());
            final C8362ab a3 = a2.mo40173a();
            if (a3 != null) {
                final C8364ac h = a3.mo40097h();
                if (h == null) {
                    return null;
                }
                InputStream d = h.mo40124d();
                String b = a3.mo40089b("Content-Encoding");
                final InputStream gZIPInputStream = (b == null || !"gzip".equalsIgnoreCase(b) || (d instanceof GZIPInputStream)) ? d : new GZIPInputStream(d);
                C67311 r0 = new IDownloadHttpConnection() {
                    /* renamed from: a */
                    public InputStream mo16499a() throws IOException {
                        return gZIPInputStream;
                    }

                    /* renamed from: a */
                    public String mo16500a(String str) {
                        return a3.mo40089b(str);
                    }

                    /* renamed from: b */
                    public int mo16501b() throws IOException {
                        return a3.mo40091c();
                    }

                    /* renamed from: c */
                    public void mo16502c() {
                        C8379e eVar = a2;
                        if (eVar != null && !eVar.mo40176c()) {
                            a2.mo40175b();
                        }
                    }

                    /* renamed from: d */
                    public void mo16503d() {
                        try {
                            if (h != null) {
                                h.close();
                            }
                            if (a2 != null && !a2.mo40176c()) {
                                a2.mo40175b();
                            }
                        } catch (Throwable unused) {
                        }
                    }
                };
                return r0;
            }
            throw new IOException("can't get response");
        }
        throw new IOException("can't get httpClient");
    }
}
