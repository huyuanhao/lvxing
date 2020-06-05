package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity;
import com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity;
import com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity;
import com.bytedance.sdk.openadsdk.core.p170d.DeepLink;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo;
import com.bytedance.sdk.openadsdk.multipro.p203b.VideoControllerDataModel;
import com.bytedance.sdk.openadsdk.multipro.p203b.VideoControllerDataModel.C2523a;
import com.bytedance.sdk.openadsdk.p165c.AdEventManager;
import com.bytedance.sdk.openadsdk.p165c.OpenAppSuccEvent;
import com.bytedance.sdk.openadsdk.utils.ActivityUtil;
import com.bytedance.sdk.openadsdk.utils.ActivityUtil.C2540a;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.C2566w;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;

/* renamed from: com.bytedance.sdk.openadsdk.core.z */
public class WebHelper {
    /* renamed from: a */
    private static boolean f8476a = false;

    /* renamed from: a */
    public static void m11010a(boolean z) {
        f8476a = z;
    }

    /* renamed from: a */
    public static boolean m11011a(Context context, MaterialMeta kVar, int i, TTNativeAd tTNativeAd, TTNativeExpressAd tTNativeExpressAd, String str, ITTDownloadAdapter aVar, boolean z) {
        String str2;
        Context context2 = context;
        MaterialMeta kVar2 = kVar;
        String str3 = str;
        if (context2 == null || kVar2 == null || i == -1) {
            return false;
        }
        DeepLink O = kVar.mo15427O();
        String str4 = "android.intent.action.VIEW";
        boolean z2 = true;
        if (O != null) {
            str2 = O.mo15376a();
            if (!TextUtils.isEmpty(str2)) {
                Uri parse = Uri.parse(O.mo15376a());
                Intent intent = new Intent(str4);
                intent.setData(parse);
                if (ToolUtils.m12004a(context, intent)) {
                    if (InternalContainer.m10069h().mo15783d()) {
                        ToolUtils.m12002a(kVar2, str3);
                    }
                    if (!(context2 instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    final Context context3 = context;
                    final MaterialMeta kVar3 = kVar;
                    final int i2 = i;
                    final String str5 = str;
                    final boolean z3 = z;
                    C23821 r0 = new C2540a() {
                        /* renamed from: a */
                        public void mo14890a() {
                        }

                        /* renamed from: a */
                        public void mo14891a(Throwable th) {
                            if (!InternalContainer.m10069h().mo15783d()) {
                                WebHelper.m11012a(context3, kVar3.mo15417E(), kVar3, i2, str5, z3);
                                C2564t.m12223c("WebHelper", "openDetailPage() -> context.startActivity(intent) fail :", th);
                            }
                        }
                    };
                    ActivityUtil.m12108a(context, intent, r0);
                    AdEventManager.m8417p(context, kVar2, str3, "open_url_app", null);
                    OpenAppSuccEvent.m8494a().mo15032a(kVar2, str3);
                    return true;
                }
            }
            String str6 = "open_fallback_url";
            if (O.mo15381c() != 2 || kVar.mo15429Q() == 5 || kVar.mo15429Q() == 15) {
                if (O.mo15381c() == 1) {
                    str2 = O.mo15379b();
                } else {
                    str2 = kVar.mo15417E();
                }
            } else if (aVar != null) {
                boolean k = aVar.mo16525k();
                if (!k && aVar.mo16523i() && aVar.mo16512a(z)) {
                    k = true;
                }
                if (!k && aVar.mo16515b(z)) {
                    k = true;
                }
                if (k || !aVar.mo16524j()) {
                    z2 = k;
                }
                AdEventManager.m8417p(context, kVar2, str3, str6, null);
                return z2;
            }
            AdEventManager.m8417p(context, kVar2, str3, str6, null);
        } else {
            str2 = kVar.mo15417E();
        }
        if (TextUtils.isEmpty(str2) && !kVar.mo15503q()) {
            return false;
        }
        if (kVar.mo15414B() != 2) {
            ActivityUtil.m12108a(context, m11009a(context, str2, kVar, i, tTNativeAd, tTNativeExpressAd, str, z), null);
            f8476a = false;
        } else if (!C2566w.m12242a(str2)) {
            return false;
        } else {
            Intent intent2 = new Intent(str4);
            try {
                intent2.setData(Uri.parse(str2));
                if (!(context2 instanceof Activity)) {
                    intent2.addFlags(268435456);
                }
                ActivityUtil.m12108a(context, intent2, null);
            } catch (Exception unused) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m11012a(Context context, String str, MaterialMeta kVar, int i, String str2, boolean z) {
        try {
            context.startActivity(m11009a(context, str, kVar, i, (TTNativeAd) null, (TTNativeExpressAd) null, str2, z));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: a */
    private static Intent m11009a(Context context, String str, MaterialMeta kVar, int i, TTNativeAd tTNativeAd, TTNativeExpressAd tTNativeExpressAd, String str2, boolean z) {
        Intent intent;
        if (!kVar.mo15503q() || (tTNativeAd == null && tTNativeExpressAd == null)) {
            intent = tTNativeAd instanceof TTDrawFeedAd ? new Intent(context, TTLandingPageActivity.class) : (kVar.mo15429Q() != 5 || f8476a) ? new Intent(context, TTLandingPageActivity.class) : new Intent(context, TTVideoLandingPageActivity.class);
        } else {
            intent = new Intent(context, TTPlayableLandingPageActivity.class);
            intent.putExtra("ad_pending_download", m11013a(kVar, z));
            if (kVar.mo15512z() != null && !TextUtils.isEmpty(kVar.mo15512z().mo15604h())) {
                String h = kVar.mo15512z().mo15604h();
                if (h.contains("?")) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(h);
                    sb.append("&orientation=portrait");
                    str = sb.toString();
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(h);
                    sb2.append("?orientation=portrait");
                    str = sb2.toString();
                }
            }
        }
        intent.putExtra("url", str);
        intent.putExtra("web_title", kVar.mo15422J());
        intent.putExtra("sdk_version", 2955);
        intent.putExtra("adid", kVar.mo15425M());
        intent.putExtra("log_extra", kVar.mo15428P());
        VideoControllerDataModel aVar = null;
        intent.putExtra("icon_url", kVar.mo15415C() == null ? null : kVar.mo15415C().mo15406a());
        intent.putExtra("event_tag", str2);
        intent.putExtra(ArgKey.KEY_SOURCE, i);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (MultiGlobalInfo.m11808b()) {
            intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, kVar.mo15459ae().toString());
        } else {
            SingleAppData.m10160a().mo15941g();
            SingleAppData.m10160a().mo15932a(kVar);
        }
        if (kVar.mo15429Q() == 5) {
            String str3 = TTAdConstant.MULTI_PROCESS_DATA;
            if (tTNativeAd != null) {
                if (tTNativeAd instanceof C2523a) {
                    aVar = ((C2523a) tTNativeAd).mo15044a();
                }
                if (aVar != null) {
                    intent.putExtra(str3, aVar.mo16888a().toString());
                }
            }
            if (tTNativeExpressAd != null) {
                aVar = tTNativeExpressAd.getVideoModel();
                if (aVar != null) {
                    intent.putExtra(str3, aVar.mo16888a().toString());
                }
            }
            if (aVar != null) {
                intent.putExtra("video_is_auto_play", aVar.f9083d);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("videoDataModel=");
                sb3.append(aVar.mo16888a().toString());
                C2564t.m12222c("videoDataModel", sb3.toString());
            }
        }
        return intent;
    }

    /* renamed from: a */
    private static boolean m11013a(MaterialMeta kVar, boolean z) {
        if (z && kVar != null && kVar.mo15414B() == 4 && kVar.mo15503q()) {
            return true;
        }
        return false;
    }
}
