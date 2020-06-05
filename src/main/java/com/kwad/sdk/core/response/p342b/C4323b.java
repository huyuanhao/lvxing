package com.kwad.sdk.core.response.p342b;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* renamed from: com.kwad.sdk.core.response.b.b */
public class C4323b {
    /* renamed from: a */
    public static long m17659a(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0;
        }
        return m17663e(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonShowTime;
    }

    /* renamed from: b */
    public static String m17660b(AdTemplate adTemplate) {
        return adTemplate == null ? "" : m17663e(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonDescription;
    }

    /* renamed from: c */
    public static String m17661c(AdTemplate adTemplate) {
        return adTemplate == null ? "" : m17663e(adTemplate).playEndInfo.endTopToolBarInfo.callButtonDescription;
    }

    /* renamed from: d */
    public static boolean m17662d(AdTemplate adTemplate) {
        if (adTemplate == null || !C4324c.m17664a(adTemplate)) {
            return false;
        }
        AdStyleInfo e = m17663e(adTemplate);
        if (e.playEndInfo.type == 0) {
            return false;
        }
        return !TextUtils.isEmpty(e.playEndInfo.adWebCardInfo.cardUrl);
    }

    /* renamed from: e */
    public static AdStyleInfo m17663e(AdTemplate adTemplate) {
        return C4324c.m17668e(adTemplate).mAdStyleInfo;
    }
}
