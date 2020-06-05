package com.kwad.sdk.core.request;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ksad.download.p297c.C3607b;
import com.kwad.sdk.KsAdSDK;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.request.model.AdSceneStyle;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.C4327b;
import com.kwad.sdk.core.response.p341a.C4320a;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.protocol.model.AdScene;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.request.i */
public class C4296i {
    /* access modifiers changed from: private|static|final */
    /* renamed from: a */
    public static final Handler f14149a = new Handler(Looper.getMainLooper());

    /* renamed from: com.kwad.sdk.core.request.i$a */
    public interface C4301a {
        /* renamed from: a */
        void mo23578a(int i, String str);

        /* renamed from: a */
        void mo23579a(List<AdTemplate> list);
    }

    /* renamed from: com.kwad.sdk.core.request.i$b */
    public interface C4302b {
        /* renamed from: a */
        void mo24391a(int i, String str);

        /* renamed from: a */
        void mo24392a(C4327b bVar);
    }

    /* renamed from: a */
    public static void m17590a(AdScene adScene, final C4301a aVar) {
        adScene.adStyle = AdSceneStyle.ContentAllianceAd.adStyle;
        m17591a(adScene, (C4302b) new C4302b() {
            /* renamed from: a */
            public void mo24391a(final int i, final String str) {
                C4296i.f14149a.post(new Runnable() {
                    public void run() {
                        StringBuilder sb = new StringBuilder();
                        sb.append("loadContentAlliance onError:");
                        sb.append(String.format("code:%s__msg:%s", new Object[]{Integer.valueOf(i), str}));
                        C4065b.m16869d("PhotoRequestManager", sb.toString());
                        aVar.mo23578a(i, str);
                    }
                });
            }

            /* renamed from: a */
            public void mo24392a(C4327b bVar) {
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : bVar.f14218d) {
                    if (adTemplate != null) {
                        if (!TextUtils.isEmpty(C4324c.m17670g(adTemplate))) {
                            String h = C4324c.m17671h(adTemplate);
                            if (!TextUtils.isEmpty(h)) {
                                KSImageLoader.preloadImage(h);
                            }
                            arrayList.add(adTemplate);
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    int i = ErrorCode.ERROR_DATA_EMPTY.errorCode;
                    StringBuilder sb = new StringBuilder();
                    sb.append(ErrorCode.ERROR_DATA_EMPTY.msg);
                    sb.append("(无视频资源)");
                    mo24391a(i, sb.toString());
                    return;
                }
                C4296i.f14149a.post(new Runnable() {
                    public void run() {
                        aVar.mo23579a(arrayList);
                    }
                });
            }
        });
    }

    /* renamed from: a */
    public static void m17591a(AdScene adScene, C4302b bVar) {
        m17592a(adScene, bVar, 0);
    }

    /* renamed from: a */
    public static void m17592a(final AdScene adScene, final C4302b bVar, final int i) {
        if (!C3607b.m15045a(KsAdSDK.getContext())) {
            bVar.mo24391a(ErrorCode.ERROR_NO_NETWORK.errorCode, ErrorCode.ERROR_NO_NETWORK.msg);
        } else {
            new C4311l() {
                /* renamed from: a */
                public void mo23796a(C4280c cVar, C4320a aVar) {
                    if (aVar == null) {
                        C4065b.m16869d("PhotoRequestManager", "request responseBase is null");
                    } else if (TextUtils.isEmpty(aVar.f14211b)) {
                        bVar.mo24391a(aVar.f14210a, "http error code");
                    } else {
                        try {
                            JSONObject jSONObject = new JSONObject(aVar.f14211b);
                            C4327b bVar = new C4327b(cVar.mo24409d());
                            bVar.mo24465a(jSONObject);
                            if (bVar.f14217c != 1) {
                                bVar.mo24391a(bVar.f14217c, bVar.f14215a);
                                return;
                            }
                            if (bVar.mo24467b()) {
                                bVar.mo24391a(ErrorCode.ERROR_DATA_EMPTY.errorCode, ErrorCode.ERROR_DATA_EMPTY.msg);
                            } else {
                                bVar.mo24392a(bVar);
                            }
                        } catch (JSONException e) {
                            C4065b.m16865a(e);
                            bVar.mo24391a(ErrorCode.ERROR_DATA_PARSE_FAIL.errorCode, ErrorCode.ERROR_DATA_PARSE_FAIL.msg);
                        }
                    }
                }

                /* renamed from: d */
                public C4280c mo23795a() {
                    return new C4295h(adScene, i);
                }
            }.mo23797b();
        }
    }
}
