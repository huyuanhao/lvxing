package com.kwad.sdk.core.p333g;

import android.text.TextUtils;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.request.p340a.C4257a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdInfo.AdBaseInfo;
import com.kwad.sdk.core.response.model.AdInfo.AdTrackInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.p306a.C3803g;
import com.kwad.sdk.p306a.C3803g.C3804a;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.g.m */
public class C4162m extends C4257a {
    /* renamed from: a */
    int f13883a;
    /* renamed from: b */
    private AdTemplate f13884b;
    /* renamed from: c */
    private C4163a f13885c;
    /* renamed from: d */
    private JSONObject f13886d;

    /* renamed from: com.kwad.sdk.core.g.m$a */
    static class C4163a {
        /* renamed from: a */
        int f13887a;
        /* renamed from: b */
        int f13888b;
        /* renamed from: c */
        int f13889c;
        /* renamed from: d */
        int f13890d;
        /* renamed from: e */
        C3804a f13891e;
        /* renamed from: f */
        String f13892f;

        C4163a() {
        }
    }

    C4162m(AdTemplate adTemplate, int i, C4163a aVar, JSONObject jSONObject) {
        this.f13884b = adTemplate;
        this.f13883a = i;
        this.f13885c = aVar;
        this.f13886d = jSONObject;
    }

    /* renamed from: a */
    private String m17237a(String str, C4163a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return str;
        }
        if (aVar.f13888b != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("itemClickType=");
            sb.append(aVar.f13888b);
            str = m17239b(str, sb.toString());
        }
        if (TextUtils.isEmpty(aVar.f13892f)) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("payload=");
        sb2.append(aVar.f13892f);
        return m17239b(str, sb2.toString());
    }

    /* renamed from: b */
    private String m17238b(String str, C4163a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return str;
        }
        if (aVar.f13889c != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("itemCloseType=");
            sb.append(aVar.f13889c);
            str = m17239b(str, sb.toString());
        }
        if (aVar.f13887a > 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("photoPlaySecond=");
            sb2.append(aVar.f13887a);
            str = m17239b(str, sb2.toString());
        }
        if (aVar.f13890d != 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("elementType=");
            sb3.append(aVar.f13890d);
            str = m17239b(str, sb3.toString());
        }
        if (TextUtils.isEmpty(aVar.f13892f)) {
            return str;
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("payload=");
        sb4.append(aVar.f13892f);
        return m17239b(str, sb4.toString());
    }

    /* renamed from: b */
    private String m17239b(String str, String str2) {
        try {
            URI uri = new URI(str);
            String query = uri.getQuery();
            if (!TextUtils.isEmpty(query)) {
                StringBuilder sb = new StringBuilder();
                sb.append(query);
                sb.append("&");
                sb.append(str2);
                str2 = sb.toString();
            }
            URI uri2 = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), str2, uri.getFragment());
            return uri2.toString();
        } catch (URISyntaxException e) {
            C4065b.m16865a(e);
            return str;
        }
    }

    /* renamed from: b */
    private String m17240b(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("extData=");
                sb.append(URLEncoder.encode(jSONObject.toString(), "UTF-8"));
                str = m17239b(str, sb.toString());
                return str;
            } catch (UnsupportedEncodingException e) {
                C4065b.m16865a(e);
            }
        }
        return str;
    }

    /* renamed from: a */
    public String mo23849a() {
        String str;
        AdInfo e = C4324c.m17668e(this.f13884b);
        int i = this.f13883a;
        String str2 = "__PR__";
        if (i == 1) {
            str = e.adBaseInfo.showUrl.replaceFirst(str2, String.valueOf(this.f13884b.mBidEcpm));
        } else {
            AdBaseInfo adBaseInfo = e.adBaseInfo;
            if (i == 2) {
                String str3 = adBaseInfo.clickUrl;
                C4163a aVar = this.f13885c;
                if (aVar != null) {
                    str3 = C3803g.m15763b(str3, aVar.f13891e);
                }
                str = m17237a(str3.replaceFirst(str2, String.valueOf(this.f13884b.mBidEcpm)), this.f13885c);
            } else {
                str = m17238b(adBaseInfo.convUrl.replaceFirst("__ACTION__", String.valueOf(this.f13883a)).replaceFirst(str2, String.valueOf(this.f13884b.mBidEcpm)), this.f13885c);
            }
        }
        return m17240b(str, this.f13886d);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo23861b() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23862c() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public List<String> mo23863d() {
        C3804a aVar;
        AdTrackInfo adTrackInfo;
        ArrayList arrayList = new ArrayList();
        AdInfo e = C4324c.m17668e(this.f13884b);
        if (!e.adTrackInfoList.isEmpty()) {
            Iterator it = e.adTrackInfoList.iterator();
            while (true) {
                aVar = null;
                if (!it.hasNext()) {
                    adTrackInfo = null;
                    break;
                }
                adTrackInfo = (AdTrackInfo) it.next();
                if (adTrackInfo.type == this.f13883a && adTrackInfo.urls != null) {
                    break;
                }
            }
            if (adTrackInfo != null) {
                if (adTrackInfo.type == 2) {
                    C4163a aVar2 = this.f13885c;
                    if (aVar2 != null) {
                        aVar = aVar2.f13891e;
                    }
                }
                for (String a : adTrackInfo.urls) {
                    arrayList.add(C3803g.m15762a(a, aVar));
                }
            }
        }
        return arrayList;
    }
}
