package com.kwad.sdk.core.request;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.kwad.sdk.core.p317a.C4057a;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p333g.C4145c;
import com.kwad.sdk.core.response.model.AdConfigData;
import com.kwad.sdk.core.response.model.AdConfigData.AdConfigs;
import com.kwad.sdk.core.response.p341a.C4320a;
import com.kwad.sdk.protocol.model.AdScene;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.request.f */
public class C4283f {
    /* access modifiers changed from: private|static */
    /* renamed from: a */
    public static boolean f14127a = false;
    /* renamed from: b */
    private static HandlerThread f14128b = null;
    /* renamed from: c */
    private static Handler f14129c = null;
    /* renamed from: d */
    private static volatile boolean f14130d = false;
    /* access modifiers changed from: private|static|volatile */
    /* renamed from: e */
    public static volatile long f14131e = 3600;
    /* access modifiers changed from: private|static */
    /* renamed from: f */
    public static Context f14132f;

    /* renamed from: com.kwad.sdk.core.request.f$a */
    private static class C4285a implements Runnable {
        C4285a() {
        }

        public void run() {
            C4057a.m16819a(C4283f.f14132f);
            if (!C4283f.f14127a) {
                C4145c.m17154a(C4283f.f14132f);
                C4283f.f14127a = true;
            }
            new C4283f().mo24410a(new AdScene(0), new C4287b() {
                /* renamed from: a */
                public void mo24414a(int i, String str) {
                }

                /* renamed from: a */
                public void mo24415a(AdConfigs adConfigs) {
                    C4057a.m16821a(C4283f.f14132f, adConfigs);
                }
            });
            C4283f.m17565c(C4283f.f14131e);
        }
    }

    /* renamed from: com.kwad.sdk.core.request.f$b */
    private interface C4287b {
        /* renamed from: a */
        void mo24414a(int i, String str);

        /* renamed from: a */
        void mo24415a(AdConfigs adConfigs);
    }

    /* renamed from: a */
    public static void m17560a(Context context) {
        if (!f14130d) {
            f14132f = context;
            f14128b = new HandlerThread("ksadsdk-config-request");
            f14128b.start();
            f14129c = new Handler(f14128b.getLooper());
            f14130d = true;
        }
        m17565c(0);
    }

    /* access modifiers changed from: private|static */
    /* renamed from: c */
    public static void m17565c(long j) {
        f14129c.removeMessages(16843026);
        Message obtain = Message.obtain(f14129c, new C4285a());
        obtain.what = 16843026;
        f14129c.sendMessageDelayed(obtain, j * 1000);
    }

    /* renamed from: a */
    public void mo24410a(final AdScene adScene, final C4287b bVar) {
        new C4311l() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo23796a(C4280c cVar, C4320a aVar) {
                if (aVar == null) {
                    C4065b.m16869d("ConfigRequestManager", "requestConfig responseBase is null");
                } else if (TextUtils.isEmpty(aVar.f14211b)) {
                    bVar.mo24414a(aVar.f14210a, "http error code");
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject(aVar.f14211b);
                        AdConfigData adConfigData = new AdConfigData();
                        adConfigData.parseJson(jSONObject);
                        if (adConfigData.result != 1) {
                            bVar.mo24414a(adConfigData.result, adConfigData.errorMsg);
                            return;
                        }
                        bVar.mo24415a(adConfigData.abConfig);
                        C4283f.f14131e = adConfigData.requestInterval;
                    } catch (JSONException e) {
                        C4065b.m16865a(e);
                        bVar.mo24414a(ErrorCode.ERROR_DATA_PARSE_FAIL.errorCode, ErrorCode.ERROR_DATA_PARSE_FAIL.msg);
                    }
                }
            }

            /* access modifiers changed from: protected */
            /* renamed from: d */
            public C4282e mo23795a() {
                return new C4282e(adScene);
            }
        }.mo23797b();
    }
}
