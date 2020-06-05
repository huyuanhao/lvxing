package com.kwad.sdk.core.request;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ksad.download.p297c.C3607b;
import com.kwad.sdk.KsAdSDK;
import com.kwad.sdk.contentalliance.C3833b;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.request.C4296i.C4302b;
import com.kwad.sdk.core.request.model.AdSceneStyle;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.C4327b;
import com.kwad.sdk.core.response.p341a.C4320a;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.draw.C4373a;
import com.kwad.sdk.entry.C4402a;
import com.kwad.sdk.export.p347i.IAdRequestManager;
import com.kwad.sdk.export.p347i.IAdRequestManager.DrawAdListener;
import com.kwad.sdk.export.p347i.IAdRequestManager.EntryElementListener;
import com.kwad.sdk.export.p347i.IAdRequestManager.FeedAdListener;
import com.kwad.sdk.export.p347i.IAdRequestManager.FullScreenVideoAdListener;
import com.kwad.sdk.export.p347i.IAdRequestManager.NativeAdListener;
import com.kwad.sdk.export.p347i.IAdRequestManager.RewardVideoAdListener;
import com.kwad.sdk.export.p347i.KsContentAllianceAd;
import com.kwad.sdk.export.p347i.KsEntryElement;
import com.kwad.sdk.feed.C4412a;
import com.kwad.sdk.feed.FeedType;
import com.kwad.sdk.fullscreen.C4456a;
import com.kwad.sdk.nativead.C4467a;
import com.kwad.sdk.p306a.C3807j;
import com.kwad.sdk.protocol.model.AdScene;
import com.kwad.sdk.reward.C4531b;
import com.kwad.sdk.reward.C4542e;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.request.b */
public class C4259b implements IAdRequestManager {
    /* access modifiers changed from: private|static|final */
    /* renamed from: a */
    public static final Handler f14079a = new Handler(Looper.getMainLooper());

    /* renamed from: com.kwad.sdk.core.request.b$a */
    public interface C4279a {
        /* renamed from: a */
        void mo24395a(int i, String str);

        /* renamed from: a */
        void mo24396a(C4327b bVar);
    }

    /* renamed from: a */
    private void m17534a(final AdScene adScene, final C4279a aVar) {
        if (!C3607b.m15045a(KsAdSDK.getContext())) {
            aVar.mo24395a(ErrorCode.ERROR_NO_NETWORK.errorCode, ErrorCode.ERROR_NO_NETWORK.msg);
        } else {
            new C4311l() {
                /* renamed from: a */
                public void mo23796a(C4280c cVar, C4320a aVar) {
                    if (aVar == null) {
                        C4065b.m16869d("AdRequestManager", "request responseBase is null");
                    } else if (TextUtils.isEmpty(aVar.f14211b)) {
                        aVar.mo24395a(aVar.f14210a, "http error code");
                    } else {
                        try {
                            JSONObject jSONObject = new JSONObject(aVar.f14211b);
                            C4327b bVar = new C4327b(cVar.mo24409d());
                            bVar.mo24465a(jSONObject);
                            if (bVar.f14217c != 1) {
                                aVar.mo24395a(bVar.f14217c, bVar.f14215a);
                                return;
                            }
                            if (bVar.mo24466a()) {
                                aVar.mo24395a(ErrorCode.ERROR_DATA_EMPTY.errorCode, ErrorCode.ERROR_DATA_EMPTY.msg);
                            } else {
                                aVar.mo24396a(bVar);
                            }
                        } catch (JSONException e) {
                            C4065b.m16865a(e);
                            aVar.mo24395a(ErrorCode.ERROR_DATA_PARSE_FAIL.errorCode, ErrorCode.ERROR_DATA_PARSE_FAIL.msg);
                        }
                    }
                }

                /* renamed from: d */
                public C4280c mo23795a() {
                    return new C4256a(adScene);
                }
            }.mo23797b();
        }
    }

    public KsContentAllianceAd loadContentAllianceAd(AdScene adScene) {
        C3807j.m15783a((Object) adScene, "AdScene must not be null");
        adScene.adStyle = AdSceneStyle.ContentAllianceAd.adStyle;
        return new C3833b(adScene);
    }

    public void loadDrawAd(AdScene adScene, final DrawAdListener drawAdListener) {
        adScene.adStyle = AdSceneStyle.DrawAd.adStyle;
        m17534a(adScene, new C4279a() {
            /* renamed from: a */
            public void mo24395a(final int i, final String str) {
                C4259b.f14079a.post(new Runnable() {
                    public void run() {
                        StringBuilder sb = new StringBuilder();
                        sb.append("loadDrawAd onError:");
                        sb.append(String.format("code:%s__msg:%s", new Object[]{Integer.valueOf(i), str}));
                        C4065b.m16869d("AdRequestManager", sb.toString());
                        drawAdListener.onError(i, str);
                    }
                });
            }

            /* renamed from: a */
            public void mo24396a(C4327b bVar) {
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : bVar.f14218d) {
                    if (adTemplate != null) {
                        if (!TextUtils.isEmpty(C4322a.m17632a(C4324c.m17668e(adTemplate)))) {
                            arrayList.add(new C4373a(adTemplate));
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    int i = ErrorCode.ERROR_DATA_EMPTY.errorCode;
                    StringBuilder sb = new StringBuilder();
                    sb.append(ErrorCode.ERROR_DATA_EMPTY.msg);
                    sb.append("(无视频资源)");
                    mo24395a(i, sb.toString());
                    return;
                }
                C4259b.f14079a.post(new Runnable() {
                    public void run() {
                        drawAdListener.onDrawAdLoad(arrayList);
                    }
                });
            }
        });
    }

    public KsEntryElement loadEntryElement(AdScene adScene, final EntryElementListener<KsEntryElement> entryElementListener) {
        C4296i.m17592a(adScene, new C4302b() {
            /* renamed from: a */
            public void mo24391a(final int i, final String str) {
                C4259b.f14079a.post(new Runnable() {
                    public void run() {
                        StringBuilder sb = new StringBuilder();
                        sb.append("loadFullScreenVideoAd onError:");
                        sb.append(String.format("code:%s__msg:%s", new Object[]{Integer.valueOf(i), str}));
                        C4065b.m16869d("AdRequestManager", sb.toString());
                        entryElementListener.onError(i, str);
                    }
                });
            }

            /* renamed from: a */
            public void mo24392a(final C4327b bVar) {
                if (bVar.f14219e != null) {
                    final C4402a aVar = new C4402a();
                    C4259b.f14079a.post(new Runnable() {
                        public void run() {
                            aVar.mo24600a(bVar.f14219e);
                            entryElementListener.onEntryLoad(aVar);
                        }
                    });
                }
            }
        }, 1);
        return null;
    }

    public void loadFeedAd(AdScene adScene, final FeedAdListener feedAdListener) {
        adScene.adStyle = AdSceneStyle.FeedAd.adStyle;
        m17534a(adScene, new C4279a() {
            /* renamed from: a */
            public void mo24395a(final int i, final String str) {
                C4259b.f14079a.post(new Runnable() {
                    public void run() {
                        StringBuilder sb = new StringBuilder();
                        sb.append("loadFeedAd onError:");
                        sb.append(String.format("code:%s__msg:%s", new Object[]{Integer.valueOf(i), str}));
                        C4065b.m16869d("AdRequestManager", sb.toString());
                        feedAdListener.onError(i, str);
                    }
                });
            }

            /* renamed from: a */
            public void mo24396a(C4327b bVar) {
                final ArrayList arrayList = new ArrayList();
                String str = null;
                for (AdTemplate adTemplate : bVar.f14218d) {
                    if (adTemplate != null) {
                        AdInfo e = C4324c.m17668e(adTemplate);
                        if (!FeedType.checkTypeValid(adTemplate)) {
                            str = String.format("(模板不匹配materialType:%s_feedType:%s)", new Object[]{Integer.valueOf(C4322a.m17658z(e)), FeedType.fromInt(adTemplate.type)});
                        } else {
                            arrayList.add(new C4412a(adTemplate));
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    int i = ErrorCode.ERROR_DATA_EMPTY.errorCode;
                    StringBuilder sb = new StringBuilder();
                    sb.append(ErrorCode.ERROR_DATA_EMPTY.msg);
                    sb.append(str);
                    mo24395a(i, sb.toString());
                    return;
                }
                C4259b.f14079a.post(new Runnable() {
                    public void run() {
                        feedAdListener.onFeedAdLoad(arrayList);
                    }
                });
            }
        });
    }

    public void loadFullScreenVideoAd(AdScene adScene, final FullScreenVideoAdListener fullScreenVideoAdListener) {
        adScene.adStyle = AdSceneStyle.FullscreenAd.adStyle;
        m17534a(adScene, new C4279a() {
            /* renamed from: a */
            public void mo24395a(final int i, final String str) {
                C4259b.f14079a.post(new Runnable() {
                    public void run() {
                        StringBuilder sb = new StringBuilder();
                        sb.append("loadFullScreenVideoAd onError:");
                        sb.append(String.format("code:%s__msg:%s", new Object[]{Integer.valueOf(i), str}));
                        C4065b.m16869d("AdRequestManager", sb.toString());
                        fullScreenVideoAdListener.onError(i, str);
                    }
                });
            }

            /* renamed from: a */
            public void mo24396a(C4327b bVar) {
                final ArrayList arrayList = new ArrayList();
                boolean z = false;
                boolean z2 = false;
                for (AdTemplate adTemplate : bVar.f14218d) {
                    if (adTemplate != null) {
                        AdInfo e = C4324c.m17668e(adTemplate);
                        if (C4322a.m17657y(e)) {
                            if (!TextUtils.isEmpty(C4322a.m17632a(e))) {
                                if (!C4542e.m18435a(adTemplate)) {
                                    z = true;
                                } else {
                                    arrayList.add(new C4456a(adTemplate));
                                    z = true;
                                    z2 = true;
                                }
                            }
                        }
                    }
                }
                if (!z) {
                    int i = ErrorCode.ERROR_DATA_EMPTY.errorCode;
                    StringBuilder sb = new StringBuilder();
                    sb.append(ErrorCode.ERROR_DATA_EMPTY.msg);
                    sb.append("(无视频资源)");
                    mo24395a(i, sb.toString());
                } else if (!z2) {
                    mo24395a(ErrorCode.ERROR_CACHE_VIDEO_FAIL.errorCode, ErrorCode.ERROR_CACHE_VIDEO_FAIL.msg);
                } else {
                    C4259b.f14079a.post(new Runnable() {
                        public void run() {
                            fullScreenVideoAdListener.onFullScreenVideoAdLoad(arrayList);
                        }
                    });
                }
            }
        });
    }

    public void loadNativeAd(AdScene adScene, final NativeAdListener nativeAdListener) {
        adScene.adStyle = AdSceneStyle.FeedAd.adStyle;
        m17534a(adScene, new C4279a() {
            /* renamed from: a */
            public void mo24395a(final int i, final String str) {
                C4259b.f14079a.post(new Runnable() {
                    public void run() {
                        StringBuilder sb = new StringBuilder();
                        sb.append("loadNativeAd onError:");
                        sb.append(String.format("code:%s__msg:%s", new Object[]{Integer.valueOf(i), str}));
                        C4065b.m16869d("AdRequestManager", sb.toString());
                        nativeAdListener.onError(i, str);
                    }
                });
            }

            /* renamed from: a */
            public void mo24396a(C4327b bVar) {
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : bVar.f14218d) {
                    if (adTemplate != null) {
                        arrayList.add(new C4467a(adTemplate));
                    }
                }
                C4259b.f14079a.post(new Runnable() {
                    public void run() {
                        nativeAdListener.onNativeAdLoad(arrayList);
                    }
                });
            }
        });
    }

    public void loadRewardVideoAd(AdScene adScene, final RewardVideoAdListener rewardVideoAdListener) {
        adScene.adStyle = AdSceneStyle.RewardAd.adStyle;
        m17534a(adScene, new C4279a() {
            /* renamed from: a */
            public void mo24395a(final int i, final String str) {
                C4259b.f14079a.post(new Runnable() {
                    public void run() {
                        StringBuilder sb = new StringBuilder();
                        sb.append("loadRewardVideoAd onError:");
                        sb.append(String.format("code:%s__msg:%s", new Object[]{Integer.valueOf(i), str}));
                        C4065b.m16869d("AdRequestManager", sb.toString());
                        rewardVideoAdListener.onError(i, str);
                    }
                });
            }

            /* renamed from: a */
            public void mo24396a(C4327b bVar) {
                final ArrayList arrayList = new ArrayList();
                boolean z = false;
                boolean z2 = false;
                for (AdTemplate adTemplate : bVar.f14218d) {
                    if (adTemplate != null) {
                        AdInfo e = C4324c.m17668e(adTemplate);
                        if (C4322a.m17657y(e)) {
                            if (!TextUtils.isEmpty(C4322a.m17632a(e))) {
                                if (!C4542e.m18435a(adTemplate)) {
                                    z = true;
                                } else {
                                    arrayList.add(new C4531b(adTemplate));
                                    z = true;
                                    z2 = true;
                                }
                            }
                        }
                    }
                }
                if (!z) {
                    int i = ErrorCode.ERROR_DATA_EMPTY.errorCode;
                    StringBuilder sb = new StringBuilder();
                    sb.append(ErrorCode.ERROR_DATA_EMPTY.msg);
                    sb.append("(无视频资源)");
                    mo24395a(i, sb.toString());
                } else if (!z2) {
                    mo24395a(ErrorCode.ERROR_CACHE_VIDEO_FAIL.errorCode, ErrorCode.ERROR_CACHE_VIDEO_FAIL.msg);
                } else {
                    C4259b.f14079a.post(new Runnable() {
                        public void run() {
                            rewardVideoAdListener.onRewardVideoAdLoad(arrayList);
                        }
                    });
                }
            }
        });
    }
}
