package com.tmsdk.module.coin;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebSettings;
import btmsdkobf.C0848ff;
import com.tencent.qqpim.discovery.internal.protocol.C7519s;
import com.tmsdk.module.coin.AdConfig.AD_KEY;
import com.tmsdk.module.coin.AdConfig.BUSINESS;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;

public class AdConfigManager {
    public static final String GZMD_ID = ReleaseSetting.CHANNEL_NO;
    /* renamed from: x */
    private static final Map<CmpAdConfig, AdRequestData> f25866x = new ConcurrentHashMap();

    /* renamed from: a */
    static boolean m32910a(CmpAdConfig cmpAdConfig) {
        return f25866x.containsKey(cmpAdConfig);
    }

    public static CmpAdConfig checkParam(AdConfig adConfig, long j) {
        m32913y();
        if (j >= 0) {
            CmpAdConfig cmpAdConfig = new CmpAdConfig(adConfig);
            if (CmpAdConfig.valid(cmpAdConfig)) {
                StringBuilder sb = new StringBuilder();
                sb.append("AdConfig请求参数：");
                sb.append(adConfig.toString());
                C0848ff.m908w("tmsdk_AdConfigManager", sb.toString());
                return cmpAdConfig;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[AdConfig ：");
            sb2.append(adConfig);
            sb2.append("] Ad Not Config ");
            throw new IllegalArgumentException(sb2.toString());
        }
        throw new IllegalArgumentException("TimeoutMillis less than zero");
    }

    public static void configCoinAd(List<AdCoinConfigItem> list) {
        CmpAdConfig cmpAdConfig;
        Map<CmpAdConfig, AdRequestData> map;
        for (AdCoinConfigItem adCoinConfigItem : list) {
            AdRequestData adRequestData = getAdRequestData(adCoinConfigItem.positionId, adCoinConfigItem.styleIds, adCoinConfigItem.business);
            if (adCoinConfigItem.sceneId == null) {
                map = f25866x;
                cmpAdConfig = new CmpAdConfig(GZMD_ID, adCoinConfigItem.business, (Bundle) null);
            } else {
                map = f25866x;
                cmpAdConfig = new CmpAdConfig(GZMD_ID, adCoinConfigItem.business, adCoinConfigItem.sceneId, null);
            }
            map.put(cmpAdConfig, adRequestData);
            f25866x.put(new CmpAdConfig(GZMD_ID, adCoinConfigItem.taskType, (Bundle) null), adRequestData);
        }
        C0848ff.m908w("tmsdk_AdConfigManager", f25866x.toString());
    }

    public static AdRequestData getAdRequestData(int i, ArrayList<Integer> arrayList, BUSINESS business) {
        AdRequestData adRequestData = new AdRequestData();
        adRequestData.positionId = i;
        adRequestData.advNum = 1;
        adRequestData.positionFormatTypes = arrayList;
        adRequestData.business = business;
        adRequestData.updateRequestId();
        return adRequestData;
    }

    public static AdRequestData getSimplePositionAdConfig(CmpAdConfig cmpAdConfig) {
        String str = "tmsdk_AdConfigManager";
        if (f25866x.containsKey(cmpAdConfig)) {
            AdRequestData adRequestData = (AdRequestData) f25866x.get(cmpAdConfig);
            try {
                String str2 = "";
                if (cmpAdConfig.getAdConfig().getOtherInput() != null) {
                    Bundle otherInput = cmpAdConfig.getAdConfig().getOtherInput();
                    if (otherInput.containsKey(AD_KEY.AD_NUM.name())) {
                        int i = otherInput.getInt(AD_KEY.AD_NUM.name(), 1);
                        adRequestData.advNum = i;
                        StringBuilder sb = new StringBuilder();
                        sb.append("adNum : ");
                        sb.append(i);
                        TmsLog.m32939d(str, sb.toString());
                    }
                    if (otherInput.containsKey(AD_KEY.AD_CHANNEL_NO.name())) {
                        String string = otherInput.getString(AD_KEY.AD_CHANNEL_NO.name(), str2);
                        adRequestData.additionalParam.put(Integer.valueOf(C7519s.f25243Sf), string);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("channel : ");
                        sb2.append(string);
                        TmsLog.m32939d(str, sb2.toString());
                    }
                }
                int i2 = TMSDKContext.getsExtraJO().getInt("coin_productId");
                Map<Integer, String> map = adRequestData.additionalParam;
                Integer valueOf = Integer.valueOf(C7519s.f25244Tf);
                StringBuilder sb3 = new StringBuilder();
                sb3.append(i2);
                sb3.append(str2);
                map.put(valueOf, sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append("coinProductId:");
                sb4.append(i2);
                TmsLog.m32939d(str, sb4.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Throwable th) {
                TmsLog.m32941e(str, "getSimplePositionAdConfig (Throwable)", th);
            }
            adRequestData.additionalParam.put(Integer.valueOf(C7519s.f25245Uf), getUserAgent());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("AdRequestData请求参数：");
            sb5.append(adRequestData.toString());
            C0848ff.m908w(str, sb5.toString());
            return adRequestData;
        }
        throw new RuntimeException("Ad Info Not Config");
    }

    public static String getUserAgent() {
        String w = m32911w();
        StringBuilder sb = new StringBuilder();
        sb.append("getWebViewUserAgent =");
        sb.append(m32911w());
        String str = "tmsdk_AdConfigManager";
        TmsLog.m32939d(str, sb.toString());
        if (!TextUtils.isEmpty(w)) {
            return w;
        }
        String x = m32912x();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getSystemUserAgent =");
        sb2.append(m32912x());
        TmsLog.m32939d(str, sb2.toString());
        return x;
    }

    /* renamed from: w */
    private static String m32911w() {
        if (VERSION.SDK_INT >= 17) {
            try {
                return WebSettings.getDefaultUserAgent(TMSDKContext.getApplicationContext());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: x */
    private static String m32912x() {
        return System.getProperty("http.agent");
    }

    /* renamed from: y */
    private static void m32913y() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("calling on main thread may lead to deadlock and/or ANRs");
        }
    }
}
