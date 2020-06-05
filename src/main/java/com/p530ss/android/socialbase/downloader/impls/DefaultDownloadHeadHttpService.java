package com.p530ss.android.socialbase.downloader.impls;

import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.p562g.HttpHeader;
import com.p530ss.android.socialbase.downloader.p564i.IDownloadHeadHttpConnection;
import com.p530ss.android.socialbase.downloader.p564i.IDownloadHeadHttpService;
import com.p530ss.android.socialbase.downloader.p569m.DownloadExpSwitchCode;
import com.p530ss.android.socialbase.downloader.p569m.DownloadUtils;
import java.io.IOException;
import java.util.List;
import okhttp3.C8362ab;
import okhttp3.C8379e;
import okhttp3.C8513x;
import okhttp3.C8518z.C8519a;

/* renamed from: com.ss.android.socialbase.downloader.impls.f */
public class DefaultDownloadHeadHttpService implements IDownloadHeadHttpService {
    /* renamed from: a */
    public IDownloadHeadHttpConnection mo32468a(String str, List<HttpHeader> list) throws IOException {
        C8513x n = C6694b.m27382n();
        if (n != null) {
            C8519a a = new C8519a().mo40655a(str).mo40654a();
            if (list != null && list.size() > 0) {
                for (HttpHeader eVar : list) {
                    a.mo40662b(eVar.mo32429a(), DownloadUtils.m28814f(eVar.mo32430b()));
                }
            }
            final C8379e a2 = n.mo40177a(a.mo40663b());
            final C8362ab a3 = a2.mo40173a();
            if (a3 != null) {
                if (DownloadExpSwitchCode.m28744a(2097152)) {
                    a3.close();
                }
                return new IDownloadHeadHttpConnection() {
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
                };
            }
            throw new IOException("can't get response");
        }
        throw new IOException("can't get httpClient");
    }
}
