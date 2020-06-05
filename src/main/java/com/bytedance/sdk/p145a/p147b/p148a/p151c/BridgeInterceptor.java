package com.bytedance.sdk.p145a.p147b.p148a.p151c;

import com.bytedance.sdk.p145a.p146a.GzipSource;
import com.bytedance.sdk.p145a.p146a.Okio;
import com.bytedance.sdk.p145a.p146a.Source;
import com.bytedance.sdk.p145a.p147b.C1918ab;
import com.bytedance.sdk.p145a.p147b.C1918ab.C1919a;
import com.bytedance.sdk.p145a.p147b.Cookie;
import com.bytedance.sdk.p145a.p147b.CookieJar;
import com.bytedance.sdk.p145a.p147b.Interceptor;
import com.bytedance.sdk.p145a.p147b.Interceptor.C1939a;
import com.bytedance.sdk.p145a.p147b.MediaType;
import com.bytedance.sdk.p145a.p147b.RequestBody;
import com.bytedance.sdk.p145a.p147b.Response;
import com.bytedance.sdk.p145a.p147b.Response.C1921a;
import com.bytedance.sdk.p145a.p147b.ResponseBody;
import com.bytedance.sdk.p145a.p147b.p148a.C1876c;
import com.bytedance.sdk.p145a.p147b.p148a.Version;
import java.io.IOException;
import java.util.List;

/* renamed from: com.bytedance.sdk.a.b.a.c.a */
public final class BridgeInterceptor implements Interceptor {
    /* renamed from: a */
    private final CookieJar f5418a;

    public BridgeInterceptor(CookieJar pVar) {
        this.f5418a = pVar;
    }

    /* renamed from: a */
    public Response mo13664a(C1939a aVar) throws IOException {
        C1918ab i = aVar.mo13743i();
        C1919a e = i.mo13915e();
        RequestBody d = i.mo13914d();
        String str = "Content-Type";
        String str2 = "Content-Length";
        if (d != null) {
            MediaType a = d.mo13934a();
            if (a != null) {
                e.mo13925a(str, a.toString());
            }
            long b = d.mo13936b();
            String str3 = "Transfer-Encoding";
            if (b != -1) {
                e.mo13925a(str2, Long.toString(b));
                e.mo13923a(str3);
            } else {
                e.mo13925a(str3, "chunked");
                e.mo13923a(str2);
            }
        }
        String str4 = "Host";
        boolean z = false;
        if (i.mo13911a(str4) == null) {
            e.mo13925a(str4, C1876c.m6953a(i.mo13910a(), false));
        }
        String str5 = "Connection";
        if (i.mo13911a(str5) == null) {
            e.mo13925a(str5, "Keep-Alive");
        }
        String str6 = "Accept-Encoding";
        String str7 = "gzip";
        if (i.mo13911a(str6) == null && i.mo13911a("Range") == null) {
            z = true;
            e.mo13925a(str6, str7);
        }
        List a2 = this.f5418a.mo14036a(i.mo13910a());
        if (!a2.isEmpty()) {
            e.mo13925a("Cookie", m6978a(a2));
        }
        String str8 = "User-Agent";
        if (i.mo13911a(str8) == null) {
            e.mo13925a(str8, Version.m7030a());
        }
        Response a3 = aVar.mo13733a(e.mo13933d());
        HttpHeaders.m6996a(this.f5418a, i.mo13910a(), a3.mo13945f());
        C1921a a4 = a3.mo13947h().mo13955a(i);
        if (z) {
            String str9 = "Content-Encoding";
            if (str7.equalsIgnoreCase(a3.mo13938a(str9)) && HttpHeaders.m6998b(a3)) {
                GzipSource jVar = new GzipSource(a3.mo13946g().mo13745b());
                a4.mo13959a(a3.mo13945f().mo14072b().mo14081b(str9).mo14081b(str2).mo14080a());
                a4.mo13957a((ResponseBody) new RealResponseBody(a3.mo13938a(str), -1, Okio.m6747a((Source) jVar)));
            }
        }
        return a4.mo13963a();
    }

    /* renamed from: a */
    private String m6978a(List<Cookie> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            Cookie oVar = (Cookie) list.get(i);
            sb.append(oVar.mo14030a());
            sb.append('=');
            sb.append(oVar.mo14032b());
        }
        return sb.toString();
    }
}
