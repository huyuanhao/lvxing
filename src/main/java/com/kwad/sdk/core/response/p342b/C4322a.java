package com.kwad.sdk.core.response.p342b;

import android.text.TextUtils;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature;
import com.kwad.sdk.core.response.model.C4326a;
import com.kwad.sdk.core.response.model.C4330e;
import com.kwad.sdk.p306a.C3811n;
import com.tencent.mid.sotrage.StorageInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.kwad.sdk.core.response.b.a */
public class C4322a {
    /* renamed from: A */
    public static List<String> m17625A(AdInfo adInfo) {
        String str = adInfo.adBaseInfo.videoPlayedNS;
        List<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            try {
                arrayList = Arrays.asList(str.split(StorageInterface.KEY_SPLITER));
            } catch (Exception unused) {
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add("3");
        }
        return arrayList;
    }

    /* renamed from: B */
    public static boolean m17626B(AdInfo adInfo) {
        return C4326a.m17691a(adInfo.adBaseInfo.expParam).f14212a != 0;
    }

    /* renamed from: C */
    public static boolean m17627C(AdInfo adInfo) {
        return C4326a.m17691a(adInfo.adBaseInfo.expParam).f14213b != 0;
    }

    /* renamed from: D */
    public static int[] m17628D(AdInfo adInfo) {
        int[] iArr = {3, 3, 3};
        String str = C4326a.m17691a(adInfo.adBaseInfo.expParam).f14214c;
        if (TextUtils.isEmpty(str)) {
            return iArr;
        }
        try {
            String[] split = str.split(StorageInterface.KEY_SPLITER);
            if (split.length < 3) {
                return iArr;
            }
            iArr[0] = Integer.parseInt(split[0]);
            iArr[1] = Integer.parseInt(split[1]);
            iArr[2] = Integer.parseInt(split[3]);
            return iArr;
        } catch (Exception unused) {
        }
    }

    /* renamed from: E */
    public static C4330e m17629E(AdInfo adInfo) {
        boolean z;
        int i;
        int i2;
        String str;
        String c = m17635c(adInfo);
        int d = m17636d(adInfo);
        int e = m17637e(adInfo);
        if (C3811n.m15812a(c) || C3811n.m15814b(c) || d == 0 || e == 0) {
            String f = m17638f(adInfo);
            str = f;
            i2 = m17639g(adInfo);
            i = m17640h(adInfo);
            z = true;
        } else {
            str = c;
            i2 = d;
            i = e;
            z = false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("frameUrl=");
        sb.append(str);
        sb.append(" useCover=");
        sb.append(z);
        sb.append(" isAd=");
        sb.append(true);
        C4065b.m16863a("AdInfoHelper", sb.toString());
        C4330e eVar = new C4330e(str, i2, i, true, z);
        return eVar;
    }

    /* renamed from: a */
    public static String m17630a() {
        return "立即安装";
    }

    /* renamed from: a */
    public static String m17631a(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("下载中  ");
        sb.append(i);
        sb.append("%");
        return sb.toString();
    }

    /* renamed from: a */
    public static String m17632a(AdInfo adInfo) {
        return m17655w(adInfo).materialUrl;
    }

    /* renamed from: b */
    public static int m17633b(AdInfo adInfo) {
        return m17655w(adInfo).videoDuration;
    }

    /* renamed from: b */
    public static String m17634b() {
        return "立即打开";
    }

    /* renamed from: c */
    public static String m17635c(AdInfo adInfo) {
        return m17655w(adInfo).firstFrame;
    }

    /* renamed from: d */
    public static int m17636d(AdInfo adInfo) {
        return m17655w(adInfo).videoWith;
    }

    /* renamed from: e */
    public static int m17637e(AdInfo adInfo) {
        return m17655w(adInfo).videoHeight;
    }

    /* renamed from: f */
    public static String m17638f(AdInfo adInfo) {
        return m17655w(adInfo).coverUrl;
    }

    /* renamed from: g */
    public static int m17639g(AdInfo adInfo) {
        return m17655w(adInfo).width;
    }

    /* renamed from: h */
    public static int m17640h(AdInfo adInfo) {
        return m17655w(adInfo).height;
    }

    /* renamed from: i */
    public static long m17641i(AdInfo adInfo) {
        return m17655w(adInfo).photoId;
    }

    /* renamed from: j */
    public static boolean m17642j(AdInfo adInfo) {
        return adInfo.adBaseInfo.enableSkipAd == 1;
    }

    /* renamed from: k */
    public static String m17643k(AdInfo adInfo) {
        return adInfo.adBaseInfo.adDescription;
    }

    /* renamed from: l */
    public static String m17644l(AdInfo adInfo) {
        return adInfo.adBaseInfo.appIconUrl;
    }

    /* renamed from: m */
    public static String m17645m(AdInfo adInfo) {
        return adInfo.adBaseInfo.appName;
    }

    /* renamed from: n */
    public static String m17646n(AdInfo adInfo) {
        return adInfo.adBaseInfo.appPackageName;
    }

    /* renamed from: o */
    public static String m17647o(AdInfo adInfo) {
        return adInfo.adBaseInfo.appDownloadCountDesc;
    }

    /* renamed from: p */
    public static float m17648p(AdInfo adInfo) {
        if (adInfo.adBaseInfo.appScore <= 0) {
            return 0.0f;
        }
        return ((float) adInfo.adBaseInfo.appScore) / 10.0f;
    }

    /* renamed from: q */
    public static String m17649q(AdInfo adInfo) {
        return adInfo.adBaseInfo.adSourceDescription;
    }

    /* renamed from: r */
    public static String m17650r(AdInfo adInfo) {
        String str = adInfo.adBaseInfo.adActionDescription;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return m17651s(adInfo) ? "立即下载" : "查看详情";
    }

    /* renamed from: s */
    public static boolean m17651s(AdInfo adInfo) {
        return m17652t(adInfo) == 1;
    }

    /* renamed from: t */
    public static int m17652t(AdInfo adInfo) {
        int i = adInfo.adBaseInfo.adOperationType;
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                return 0;
            }
        }
        return i2;
    }

    /* renamed from: u */
    public static int m17653u(AdInfo adInfo) {
        return adInfo.adBaseInfo.ecpm;
    }

    /* renamed from: v */
    public static String m17654v(AdInfo adInfo) {
        return adInfo.adConversionInfo.h5Url;
    }

    /* renamed from: w */
    public static MaterialFeature m17655w(AdInfo adInfo) {
        for (MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature != null) {
                if (materialFeature.featureType == 1 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    return materialFeature;
                }
            }
        }
        C4065b.m16869d("AdInfoHelper", "getVideoMaterialFeature in null");
        return new MaterialFeature();
    }

    /* renamed from: x */
    public static List<String> m17656x(AdInfo adInfo) {
        ArrayList arrayList = new ArrayList();
        int z = m17658z(adInfo);
        if (z != 2 && z != 3) {
            return arrayList;
        }
        for (MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                arrayList.add(materialFeature.materialUrl);
            }
        }
        return arrayList;
    }

    /* renamed from: y */
    public static boolean m17657y(AdInfo adInfo) {
        return m17658z(adInfo) == 1;
    }

    /* renamed from: z */
    public static int m17658z(AdInfo adInfo) {
        int i = adInfo.adMaterialInfo.materialType;
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    return 0;
                }
            }
        }
        return i2;
    }
}
