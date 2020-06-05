package com.kwad.sdk.core.request;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ksad.download.p297c.C3607b;
import com.kwad.sdk.KsAdSDK;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.request.model.AdSceneStyle;
import com.kwad.sdk.core.response.model.PhotoShareInfo;
import com.kwad.sdk.core.response.p341a.C4320a;
import com.kwad.sdk.protocol.model.AdScene;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.request.k */
public class C4304k {
    /* access modifiers changed from: private|static|final */
    /* renamed from: a */
    public static final Handler f14159a = new Handler(Looper.getMainLooper());

    /* renamed from: com.kwad.sdk.core.request.k$a */
    public interface C4309a {
        /* renamed from: a */
        void mo23410a(int i, String str);

        /* renamed from: a */
        void mo23411a(PhotoShareInfo photoShareInfo);
    }

    /* renamed from: com.kwad.sdk.core.request.k$b */
    private interface C4310b {
        /* renamed from: a */
        void mo24428a(int i, String str);

        /* renamed from: a */
        void mo24429a(PhotoShareInfo photoShareInfo);
    }

    /* renamed from: a */
    private void m17605a(AdScene adScene, long j, C4310b bVar) {
        if (!C3607b.m15045a(KsAdSDK.getContext())) {
            bVar.mo24428a(ErrorCode.ERROR_NO_NETWORK.errorCode, ErrorCode.ERROR_NO_NETWORK.msg);
            return;
        }
        final AdScene adScene2 = adScene;
        final long j2 = j;
        final C4310b bVar2 = bVar;
        C43082 r0 = new C4311l() {
            /* renamed from: a */
            public void mo23796a(C4280c cVar, C4320a aVar) {
                if (aVar == null) {
                    C4065b.m16869d("PhotoShareUrlRequestManager", "requestShareInfo responseBase is null");
                } else if (TextUtils.isEmpty(aVar.f14211b)) {
                    bVar2.mo24428a(aVar.f14210a, "http error code");
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject(aVar.f14211b);
                        PhotoShareInfo photoShareInfo = new PhotoShareInfo();
                        photoShareInfo.parseJson(jSONObject);
                        if (photoShareInfo.result != 1) {
                            bVar2.mo24428a(photoShareInfo.result, photoShareInfo.errorMsg);
                            return;
                        }
                        if (photoShareInfo.isResultDataEmpty()) {
                            bVar2.mo24428a(ErrorCode.ERROR_DATA_EMPTY.errorCode, ErrorCode.ERROR_DATA_EMPTY.msg);
                        } else {
                            bVar2.mo24429a(photoShareInfo);
                        }
                    } catch (JSONException e) {
                        C4065b.m16865a(e);
                        bVar2.mo24428a(ErrorCode.ERROR_DATA_PARSE_FAIL.errorCode, ErrorCode.ERROR_DATA_PARSE_FAIL.msg);
                    }
                }
            }

            /* renamed from: d */
            public C4280c mo23795a() {
                return new C4303j(adScene2, j2);
            }
        };
        r0.mo23797b();
    }

    /* renamed from: a */
    public void mo24427a(AdScene adScene, long j, final C4309a aVar) {
        adScene.adStyle = AdSceneStyle.ContentAllianceAd.adStyle;
        m17605a(adScene, j, (C4310b) new C4310b() {
            /* renamed from: a */
            public void mo24428a(final int i, final String str) {
                C4304k.f14159a.post(new Runnable() {
                    public void run() {
                        StringBuilder sb = new StringBuilder();
                        sb.append("load onError:");
                        sb.append(String.format("code:%s__msg:%s", new Object[]{Integer.valueOf(i), str}));
                        C4065b.m16869d("PhotoShareUrlRequestManager", sb.toString());
                        aVar.mo23410a(i, str);
                    }
                });
            }

            /* renamed from: a */
            public void mo24429a(final PhotoShareInfo photoShareInfo) {
                C4304k.f14159a.post(new Runnable() {
                    public void run() {
                        aVar.mo23411a(photoShareInfo);
                    }
                });
            }
        });
    }
}
