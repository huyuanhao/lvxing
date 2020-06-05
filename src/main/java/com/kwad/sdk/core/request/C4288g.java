package com.kwad.sdk.core.request;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ksad.download.p297c.C3607b;
import com.kwad.sdk.KsAdSDK;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.request.model.AdSceneStyle;
import com.kwad.sdk.core.response.model.CommentResponse;
import com.kwad.sdk.core.response.p341a.C4320a;
import com.kwad.sdk.protocol.model.AdScene;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.request.g */
public class C4288g {
    /* access modifiers changed from: private|static|final */
    /* renamed from: a */
    public static final Handler f14137a = new Handler(Looper.getMainLooper());

    /* renamed from: com.kwad.sdk.core.request.g$a */
    public interface C4293a {
        /* renamed from: a */
        void mo23488a(int i, String str);

        /* renamed from: a */
        void mo23489a(CommentResponse commentResponse);
    }

    /* renamed from: com.kwad.sdk.core.request.g$b */
    private interface C4294b {
        /* renamed from: a */
        void mo24417a(int i, String str);

        /* renamed from: a */
        void mo24418a(CommentResponse commentResponse);
    }

    /* renamed from: a */
    private void m17576a(AdScene adScene, long j, C4294b bVar) {
        if (!C3607b.m15045a(KsAdSDK.getContext())) {
            bVar.mo24417a(ErrorCode.ERROR_NO_NETWORK.errorCode, ErrorCode.ERROR_NO_NETWORK.msg);
            return;
        }
        final AdScene adScene2 = adScene;
        final long j2 = j;
        final C4294b bVar2 = bVar;
        C42922 r0 = new C4311l() {
            /* renamed from: a */
            public void mo23796a(C4280c cVar, C4320a aVar) {
                if (aVar == null) {
                    C4065b.m16869d("PhotoCommentRequestManager", "request responseBase is null");
                } else if (TextUtils.isEmpty(aVar.f14211b)) {
                    bVar2.mo24417a(aVar.f14210a, "http error code");
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject(aVar.f14211b);
                        CommentResponse commentResponse = new CommentResponse();
                        commentResponse.parseJson(jSONObject);
                        if (commentResponse.result != 1) {
                            bVar2.mo24417a(commentResponse.result, commentResponse.errorMsg);
                            return;
                        }
                        if (commentResponse.isResultDataEmpty()) {
                            bVar2.mo24417a(ErrorCode.ERROR_DATA_EMPTY.errorCode, ErrorCode.ERROR_DATA_EMPTY.msg);
                        } else {
                            bVar2.mo24418a(commentResponse);
                        }
                    } catch (JSONException e) {
                        C4065b.m16865a(e);
                        bVar2.mo24417a(ErrorCode.ERROR_DATA_PARSE_FAIL.errorCode, ErrorCode.ERROR_DATA_PARSE_FAIL.msg);
                    }
                }
            }

            /* renamed from: d */
            public C4280c mo23795a() {
                return new C4281d(adScene2, j2);
            }
        };
        r0.mo23797b();
    }

    /* renamed from: a */
    public void mo24416a(AdScene adScene, long j, final C4293a aVar) {
        adScene.adStyle = AdSceneStyle.ContentAllianceAd.adStyle;
        m17576a(adScene, j, (C4294b) new C4294b() {
            /* renamed from: a */
            public void mo24417a(final int i, final String str) {
                C4288g.f14137a.post(new Runnable() {
                    public void run() {
                        StringBuilder sb = new StringBuilder();
                        sb.append("load onError:");
                        sb.append(String.format("code:%s__msg:%s", new Object[]{Integer.valueOf(i), str}));
                        C4065b.m16869d("PhotoCommentRequestManager", sb.toString());
                        aVar.mo23488a(i, str);
                    }
                });
            }

            /* renamed from: a */
            public void mo24418a(final CommentResponse commentResponse) {
                C4288g.f14137a.post(new Runnable() {
                    public void run() {
                        aVar.mo23489a(commentResponse);
                    }
                });
            }
        });
    }
}
