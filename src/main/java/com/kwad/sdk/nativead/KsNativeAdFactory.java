package com.kwad.sdk.nativead;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.request.ErrorCode;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.C4327b;
import com.kwad.sdk.export.p347i.IAdRequestManager.NativeAdListener;
import com.kwad.sdk.protocol.model.AdScene;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class KsNativeAdFactory {
    private static final String TAG = "KsNativeAdFactory";
    private static final Handler mHandler = new Handler(Looper.getMainLooper());

    public static void buildNativeAd(String str, final NativeAdListener nativeAdListener, AdScene adScene) {
        Runnable r2;
        if (TextUtils.isEmpty(str)) {
            doInMainThread(new Runnable() {
                public void run() {
                    C4065b.m16869d(KsNativeAdFactory.TAG, "method parseJson params jsonResult is empty");
                    nativeAdListener.onError(ErrorCode.ERROR_DATA_EMPTY.errorCode, ErrorCode.ERROR_DATA_EMPTY.msg);
                }
            });
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            final C4327b bVar = new C4327b(adScene);
            bVar.mo24465a(jSONObject);
            if (bVar.f14217c != 1) {
                doInMainThread(new Runnable() {
                    public void run() {
                        StringBuilder sb = new StringBuilder();
                        sb.append("loadNativeAd onError:");
                        sb.append(String.format("%s__%s", new Object[]{Integer.valueOf(bVar.f14217c), bVar.f14215a}));
                        C4065b.m16869d(KsNativeAdFactory.TAG, sb.toString());
                        nativeAdListener.onError(bVar.f14217c, bVar.f14215a);
                    }
                });
                return;
            }
            if (bVar.mo24466a()) {
                r2 = new Runnable() {
                    public void run() {
                        nativeAdListener.onError(ErrorCode.ERROR_DATA_EMPTY.errorCode, ErrorCode.ERROR_DATA_EMPTY.msg);
                    }
                };
            } else {
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : bVar.f14218d) {
                    if (adTemplate != null) {
                        arrayList.add(new C4467a(adTemplate));
                    }
                }
                r2 = new Runnable() {
                    public void run() {
                        nativeAdListener.onNativeAdLoad(arrayList);
                    }
                };
            }
            doInMainThread(r2);
        } catch (JSONException e) {
            C4065b.m16865a(e);
            nativeAdListener.onError(ErrorCode.ERROR_DATA_PARSE_FAIL.errorCode, ErrorCode.ERROR_DATA_PARSE_FAIL.msg);
        }
    }

    private static void doInMainThread(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            mHandler.post(runnable);
        }
    }
}
