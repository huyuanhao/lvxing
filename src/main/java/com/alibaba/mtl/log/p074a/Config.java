package com.alibaba.mtl.log.p074a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.AppMonitorDelegate;
import com.alibaba.mtl.appmonitor.p071d.SampleRules;
import com.alibaba.mtl.log.UTDC;
import com.alibaba.mtl.log.p077d.Logger;
import com.tencent.android.tpush.common.MessageKey;
import discoveryAD.C7880W.C7881a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.alibaba.mtl.log.a.a */
public class Config {
    /* renamed from: a */
    public static String f3283a = "adashbc.ut.taobao.com";
    /* renamed from: b */
    public static String f3284b = "";
    /* renamed from: c */
    public static boolean f3285c = false;
    /* renamed from: d */
    public static String f3286d = null;
    /* renamed from: e */
    public static volatile boolean f3287e = false;
    /* renamed from: f */
    static List<String> f3288f = new ArrayList();
    /* renamed from: g */
    static List<String> f3289g = new ArrayList();
    /* renamed from: h */
    static List<String> f3290h = new ArrayList();
    /* renamed from: i */
    static List<String> f3291i = new ArrayList();
    /* renamed from: j */
    static List<String> f3292j = new ArrayList();
    /* renamed from: k */
    static List<String> f3293k = new ArrayList();
    /* renamed from: l */
    private static long f3294l = 300000;
    /* renamed from: m */
    private static long f3295m = 30000;
    /* renamed from: n */
    private static boolean f3296n = false;
    /* renamed from: o */
    private static boolean f3297o = false;
    /* renamed from: p */
    private static String f3298p = "net";
    /* renamed from: q */
    private static boolean f3299q;

    /* renamed from: a */
    public static String m3704a() {
        if (TextUtils.isEmpty(f3284b)) {
            StringBuilder sb = new StringBuilder();
            sb.append("https://");
            sb.append(f3283a);
            sb.append("/rest/sur");
            f3284b = sb.toString();
        }
        return f3284b;
    }

    static {
        f3289g.add("stm_bcx");
        f3290h.add("stm_x");
        f3291i.add("stm_p");
        f3292j.add("stm_c");
        f3288f.add("stm_d");
        f3293k.add("stm_nc");
    }

    /* renamed from: a */
    public static List<String> m3705a(String str) {
        int i;
        try {
            i = Integer.parseInt(str);
        } catch (Exception unused) {
            i = -1;
        }
        if (i == -1) {
            return f3288f;
        }
        if (i == 1 || i == 61005 || i == 61006 || i == 65501 || i == 65502 || i == 65503 || i == 65133) {
            return f3289g;
        }
        if ((i > 1 && i < 100) || ((i > 15300 && i < 15400) || ((i > 21000 && i < 30000) || ((i > 61000 && i < 61200) || (i > 65000 && i < 65300))))) {
            return f3290h;
        }
        if (i > 1000 && i < 2100) {
            return f3291i;
        }
        if (i > 2100 && i < 2200) {
            return f3292j;
        }
        if (i == 19999 || ((i > 4000 && i < 10000) || ((i > 64000 && i < 65000) || ((i > 65500 && i < 65600) || (i > 66000 && i < 67000))))) {
            return f3288f;
        }
        return f3293k;
    }

    /* renamed from: a */
    public static void m3707a(Map<String, String> map) {
        Logger.m3833a("Config", "[turnOnRealTimeDebug] params:", map);
        if (map != null) {
            String str = (String) map.get("debug_api_url");
            String str2 = (String) map.get("debug_key");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                f3284b = str;
                f3285c = true;
                f3286d = str2;
            }
            if (map.containsKey("debug_sampling_option")) {
                AppMonitorDelegate.f3187a = true;
                UTDC.m3703i();
            }
        }
    }

    /* renamed from: b */
    public static boolean m3709b() {
        return f3285c;
    }

    /* renamed from: c */
    public static boolean m3711c() {
        return !f3287e;
    }

    /* renamed from: d */
    public static long m3712d() {
        return f3295m;
    }

    /* renamed from: e */
    public static long m3714e() {
        return f3294l;
    }

    /* renamed from: f */
    private static int m3716f(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(str).intValue();
            } catch (Exception unused) {
            }
        }
        return -1;
    }

    /* renamed from: b */
    public static void m3708b(String str) {
        if (!f3297o) {
            int f = m3716f(str);
            if (f != -1) {
                f3294l = (long) (f * 1000);
            }
        }
    }

    /* renamed from: c */
    public static void m3710c(String str) {
        if (!f3296n) {
            int f = m3716f(str);
            if (f != -1) {
                f3295m = (long) (f * 1000);
            }
        }
    }

    /* renamed from: d */
    public static void m3713d(String str) {
        String str2 = "ut_";
        Editor edit = PreferenceManager.getDefaultSharedPreferences(UTDC.m3697c()).edit();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str).getJSONObject("config");
                if (jSONObject != null) {
                    Iterator keys = jSONObject.keys();
                    if (keys != null) {
                        while (keys.hasNext()) {
                            String str3 = (String) keys.next();
                            JSONObject jSONObject2 = jSONObject.getJSONObject(str3);
                            if (jSONObject2 != null) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(jSONObject2.remove(C7881a.TIMESTAMP));
                                sb.append("");
                                String sb2 = sb.toString();
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(str2);
                                sb3.append(str3);
                                sb3.append("_config");
                                edit.putString(sb3.toString(), jSONObject2.toString());
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append(str2);
                                sb4.append(str3);
                                sb4.append("_timestamp");
                                edit.putString(sb4.toString(), sb2);
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        edit.apply();
    }

    /* renamed from: f */
    public static String m3717f() {
        String str = "Config";
        if ("l0".equalsIgnoreCase(f3298p)) {
            Logger.m3833a(str, f3298p, "l0 config");
            return "{\"SYSTEM\":{\"discardap\":\"1\"}}";
        }
        if ("l1".equalsIgnoreCase(f3298p)) {
            Logger.m3833a(str, f3298p, "l1 config");
            return "{\"SYSTEM\":{\"useut\":\"0\",\"bg_interval\":600000,\"fg_interval\":60000},\"STAT\":{\"sampling\":0,\"metrics\":[{\"module\":\"networkPrefer\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"network\",\"sampling\":10},{\"monitorPoint\":\"NetworkError\",\"sampling\":10000}]},{\"module\":\"mtopsdk\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"mtopStats\",\"sampling\":10},{\"monitorPoint\":\"mtopExceptions\",\"sampling\":10},{\"monitorPoint\":\"uploadStats\",\"sampling\":10000}]},{\"module\":\"ImageLib\",\"sampling\":10000,\"monitorPoints\":[{\"monitorPoint\":\"ImageFlow\",\"sampling\":50},{\"monitorPoint\":\"ImageExceptions\",\"sampling\":50}]},{\"module\":\"accs\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"netperformance\",\"sampling\":10}]},{\"module\":\"ACDS\",\"sampling\":1000,\"monitorPoints\":[{\"monitorPoint\":\"initdata\",\"sampling\":20}]},{\"module\":\"WindVane\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"AllPackageApps\",\"sampling\":10000},{\"monitorPoint\":\"Config\",\"sampling\":5000},{\"monitorPoint\":\"PackageApp\",\"sampling\":2000},{\"monitorPoint\":\"H5\",\"sampling\":1},{\"monitorPoint\":\"WebViewVisit\",\"sampling\":5000}]},{\"module\":\"order\",\"sampling\":10000,\"monitorPoints\":[{\"monitorPoint\":\"Page_OrderList\",\"sampling\":500},{\"monitorPoint\":\"Page_OrderDetail\",\"sampling\":1000}]},{\"module\":\"wopc\",\"sampling\":10000},{\"module\":\"WeApp+\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"load\",\"sampling\":10000}]},{\"module\":\"NetworkSDK\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"TrafficStats\",\"sampling\":20}]}]},\"COUNTER\":{\"sampling\":0,\"cacheCount\":60,\"metrics\":[{\"module\":\"accs\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"to_buss\",\"sampling\":1},{\"monitorPoint\":\"resend\",\"sampling\":1}]},{\"module\":\"configCenter\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"SyncConfigsFromApi\",\"sampling\":2500},{\"monitorPoint\":\"SynconfigUpdateConfig\",\"sampling\":1},{\"monitorPoint\":\"NotifyConfigChanged\",\"sampling\":1},{\"monitorPoint\":\"RegisterToken\",\"sampling\":1},{\"monitorPoint\":\"SyncReferFromCdn\",\"sampling\":2500},{\"monitorPoint\":\"XcmdUpdateConfig\",\"sampling\":1},{\"monitorPoint\":\"SyncXcommandFromCdn\",\"sampling\":2500},{\"monitorPoint\":\"SaveConfigError\",\"sampling\":2500},{\"monitorPoint\":\"ParseTokenError\",\"sampling\":2500},{\"monitorPoint\":\"NotifyLoadConfig\",\"sampling\":2500}]},{\"module\":\"ACDS\",\"sampling\":250},{\"module\":\"Page_hotpatch\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hotpatch\",\"sampling\":250}]}]},\"ALARM\":{\"sampling\":0,\"successSampling\":0,\"failSampling\":0,\"metrics\":[{\"module\":\"Page_Home\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"HomeItemLoad\",\"sampling\":2500},{\"monitorPoint\":\"HomeNetwork\",\"sampling\":2500}]},{\"module\":\"Page_Detail\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"LoadDetail\",\"sampling\":2500},{\"monitorPoint\":\"LoadDesc\",\"sampling\":2500}]},{\"module\":\"Page_SearchItemList\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"SearchItem\",\"sampling\":2000}]},{\"module\":\"Page_Shop\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"loadShop\",\"sampling\":2500}]},{\"module\":\"Page_AutoLogin\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"autoLogin\",\"sampling\":2500}]},{\"module\":\"Page_Shop_Search_List\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"searchShopList\",\"sampling\":2500}]},{\"module\":\"Page_ShoppingCart\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"QueryData\",\"sampling\":2500},{\"monitorPoint\":\"ShowCart\",\"sampling\":2500},{\"monitorPoint\":\"UpdateCart\",\"sampling\":2500}]},{\"module\":\"Page_Pay\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"Alipay\",\"sampling\":2500}]},{\"module\":\"Page_ShowOrder\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"ShowOrder\",\"sampling\":2500},{\"monitorPoint\":\"CreateOrder\",\"sampling\":2500}]},{\"module\":\"Page_Attention\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"loadAttention\",\"sampling\":2500},{\"monitorPoint\":\"refreshAttention\",\"sampling\":2500}]},{\"module\":\"Page_SearchShopList\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"SearchShop\",\"sampling\":2500}]},{\"module\":\"WindVane\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"NativeError\",\"sampling\":1250},{\"monitorPoint\":\"AllPackageApps\",\"sampling\":1250},{\"monitorPoint\":\"Config\",\"sampling\":1250},{\"monitorPoint\":\"JavaScriptError\",\"sampling\":1250},{\"monitorPoint\":\"PackageApp\",\"sampling\":2000}]},{\"module\":\"WeApp+\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"domModule\",\"sampling\":2500},{\"monitorPoint\":\"enviroment\",\"sampling\":2500},{\"monitorPoint\":\"jsBridge\",\"sampling\":2500},{\"monitorPoint\":\"streamModule\",\"sampling\":2500}]},{\"module\":\"ACDS\",\"sampling\":250,\"monitorPoints\":[{\"monitorPoint\":\"huichang\",\"sampling\":0}]},{\"module\":\"Page_HuiChangTab\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hcconfig\",\"sampling\":250}]},{\"module\":\"Page_2015MainStage\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hcjs_cdn\",\"sampling\":250},{\"monitorPoint\":\"hcjs_mtop\",\"sampling\":250},{\"monitorPoint\":\"hcmaindegrade\",\"sampling\":2500}]},{\"module\":\"Page_2015SubStage\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hcjs_cdn\",\"sampling\":250},{\"monitorPoint\":\"hcjs_mtop\",\"sampling\":250},{\"monitorPoint\":\"hcsubdegrade\",\"sampling\":2500}]}]}}";
        }
        if ("l2".equalsIgnoreCase(f3298p)) {
            Logger.m3833a(str, f3298p, "l2 config");
            return "{\"SYSTEM\":{\"useut\":\"0\",\"bg_interval\":600000,\"fg_interval\":60000},\"STAT\":{\"sampling\":0,\"metrics\":[{\"module\":\"networkPrefer\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"network\",\"sampling\":10},{\"monitorPoint\":\"NetworkError\",\"sampling\":10000}]},{\"module\":\"mtopsdk\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"mtopStats\",\"sampling\":10},{\"monitorPoint\":\"mtopExceptions\",\"sampling\":10},{\"monitorPoint\":\"uploadStats\",\"sampling\":10000}]},{\"module\":\"ImageLib\",\"sampling\":10000,\"monitorPoints\":[{\"monitorPoint\":\"ImageFlow\",\"sampling\":50},{\"monitorPoint\":\"ImageExceptions\",\"sampling\":50}]},{\"module\":\"accs\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"netperformance\",\"sampling\":10}]},{\"module\":\"ACDS\",\"sampling\":1000,\"monitorPoints\":[{\"monitorPoint\":\"initdata\",\"sampling\":20}]},{\"module\":\"WindVane\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"AllPackageApps\",\"sampling\":10000},{\"monitorPoint\":\"Config\",\"sampling\":5000},{\"monitorPoint\":\"PackageApp\",\"sampling\":2000},{\"monitorPoint\":\"H5\",\"sampling\":1},{\"monitorPoint\":\"WebViewVisit\",\"sampling\":5000}]},{\"module\":\"order\",\"sampling\":10000,\"monitorPoints\":[{\"monitorPoint\":\"Page_OrderList\",\"sampling\":500},{\"monitorPoint\":\"Page_OrderDetail\",\"sampling\":1000}]},{\"module\":\"wopc\",\"sampling\":10000},{\"module\":\"WeApp+\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"load\",\"sampling\":10000}]},{\"module\":\"NetworkSDK\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"TrafficStats\",\"sampling\":20}]}]},\"COUNTER\":{\"sampling\":0,\"cacheCount\":60,\"metrics\":[{\"module\":\"accs\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"to_buss\",\"sampling\":1},{\"monitorPoint\":\"resend\",\"sampling\":1}]},{\"module\":\"configCenter\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"SyncConfigsFromApi\",\"sampling\":5000},{\"monitorPoint\":\"SynconfigUpdateConfig\",\"sampling\":1},{\"monitorPoint\":\"NotifyConfigChanged\",\"sampling\":1},{\"monitorPoint\":\"RegisterToken\",\"sampling\":1},{\"monitorPoint\":\"SyncReferFromCdn\",\"sampling\":5000},{\"monitorPoint\":\"XcmdUpdateConfig\",\"sampling\":1},{\"monitorPoint\":\"SyncXcommandFromCdn\",\"sampling\":5000},{\"monitorPoint\":\"SaveConfigError\",\"sampling\":5000},{\"monitorPoint\":\"ParseTokenError\",\"sampling\":5000},{\"monitorPoint\":\"NotifyLoadConfig\",\"sampling\":5000}]},{\"module\":\"ACDS\",\"sampling\":500},{\"module\":\"Page_hotpatch\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hotpatch\",\"sampling\":500}]}]},\"ALARM\":{\"sampling\":0,\"successSampling\":0,\"failSampling\":0,\"metrics\":[{\"module\":\"Page_Home\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"HomeItemLoad\",\"sampling\":5000},{\"monitorPoint\":\"HomeNetwork\",\"sampling\":5000}]},{\"module\":\"Page_Detail\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"LoadDetail\",\"sampling\":5000},{\"monitorPoint\":\"LoadDesc\",\"sampling\":5000}]},{\"module\":\"Page_SearchItemList\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"SearchItem\",\"sampling\":5000}]},{\"module\":\"Page_Shop\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"loadShop\",\"sampling\":5000}]},{\"module\":\"Page_AutoLogin\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"autoLogin\",\"sampling\":5000}]},{\"module\":\"Page_Shop_Search_List\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"searchShopList\",\"sampling\":5000}]},{\"module\":\"Page_ShoppingCart\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"QueryData\",\"sampling\":5000},{\"monitorPoint\":\"ShowCart\",\"sampling\":5000},{\"monitorPoint\":\"UpdateCart\",\"sampling\":5000}]},{\"module\":\"Page_Pay\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"Alipay\",\"sampling\":5000}]},{\"module\":\"Page_ShowOrder\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"ShowOrder\",\"sampling\":5000},{\"monitorPoint\":\"CreateOrder\",\"sampling\":5000}]},{\"module\":\"Page_Attention\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"loadAttention\",\"sampling\":5000},{\"monitorPoint\":\"refreshAttention\",\"sampling\":5000}]},{\"module\":\"Page_SearchShopList\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"SearchShop\",\"sampling\":5000}]},{\"module\":\"WindVane\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"NativeError\",\"sampling\":2500},{\"monitorPoint\":\"AllPackageApps\",\"sampling\":2500},{\"monitorPoint\":\"Config\",\"sampling\":2500},{\"monitorPoint\":\"JavaScriptError\",\"sampling\":2500},{\"monitorPoint\":\"PackageApp\",\"sampling\":2000}]},{\"module\":\"WeApp+\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"domModule\",\"sampling\":5000},{\"monitorPoint\":\"enviroment\",\"sampling\":5000},{\"monitorPoint\":\"jsBridge\",\"sampling\":5000},{\"monitorPoint\":\"streamModule\",\"sampling\":5000}]},{\"module\":\"ACDS\",\"sampling\":500,\"monitorPoints\":[{\"monitorPoint\":\"huichang\",\"sampling\":0}]},{\"module\":\"Page_HuiChangTab\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hcconfig\",\"sampling\":500}]},{\"module\":\"Page_2015MainStage\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hcjs_cdn\",\"sampling\":500},{\"monitorPoint\":\"hcjs_mtop\",\"sampling\":500},{\"monitorPoint\":\"hcmaindegrade\",\"sampling\":5000}]},{\"module\":\"Page_2015SubStage\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hcjs_cdn\",\"sampling\":500},{\"monitorPoint\":\"hcjs_mtop\",\"sampling\":500},{\"monitorPoint\":\"hcsubdegrade\",\"sampling\":5000}]}]}}";
        }
        if ("l3".equalsIgnoreCase(f3298p)) {
            Logger.m3833a(str, f3298p, "l3 config");
            return "{\"SYSTEM\":{\"useut\":\"0\",\"bg_interval\":600000,\"fg_interval\":60000},\"STAT\":{\"sampling\":0,\"metrics\":[{\"module\":\"networkPrefer\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"network\",\"sampling\":10},{\"monitorPoint\":\"NetworkError\",\"sampling\":10000}]},{\"module\":\"mtopsdk\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"mtopStats\",\"sampling\":10},{\"monitorPoint\":\"mtopExceptions\",\"sampling\":10},{\"monitorPoint\":\"uploadStats\",\"sampling\":10000}]},{\"module\":\"ImageLib\",\"sampling\":10000,\"monitorPoints\":[{\"monitorPoint\":\"ImageFlow\",\"sampling\":50},{\"monitorPoint\":\"ImageExceptions\",\"sampling\":50}]},{\"module\":\"accs\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"netperformance\",\"sampling\":10}]},{\"module\":\"ACDS\",\"sampling\":1000,\"monitorPoints\":[{\"monitorPoint\":\"initdata\",\"sampling\":20}]},{\"module\":\"WindVane\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"AllPackageApps\",\"sampling\":10000},{\"monitorPoint\":\"Config\",\"sampling\":5000},{\"monitorPoint\":\"PackageApp\",\"sampling\":2000},{\"monitorPoint\":\"H5\",\"sampling\":1},{\"monitorPoint\":\"WebViewVisit\",\"sampling\":5000}]},{\"module\":\"order\",\"sampling\":10000,\"monitorPoints\":[{\"monitorPoint\":\"Page_OrderList\",\"sampling\":500},{\"monitorPoint\":\"Page_OrderDetail\",\"sampling\":1000}]},{\"module\":\"wopc\",\"sampling\":10000},{\"module\":\"WeApp+\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"load\",\"sampling\":10000}]},{\"module\":\"NetworkSDK\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"TrafficStats\",\"sampling\":20}]}]},\"COUNTER\":{\"sampling\":0,\"cacheCount\":60,\"metrics\":[{\"module\":\"accs\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"to_buss\",\"sampling\":1},{\"monitorPoint\":\"resend\",\"sampling\":1}]},{\"module\":\"configCenter\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"SyncConfigsFromApi\",\"sampling\":10000},{\"monitorPoint\":\"SynconfigUpdateConfig\",\"sampling\":1},{\"monitorPoint\":\"NotifyConfigChanged\",\"sampling\":1},{\"monitorPoint\":\"RegisterToken\",\"sampling\":1},{\"monitorPoint\":\"SyncReferFromCdn\",\"sampling\":10000},{\"monitorPoint\":\"XcmdUpdateConfig\",\"sampling\":1},{\"monitorPoint\":\"SyncXcommandFromCdn\",\"sampling\":10000},{\"monitorPoint\":\"SaveConfigError\",\"sampling\":10000},{\"monitorPoint\":\"ParseTokenError\",\"sampling\":10000},{\"monitorPoint\":\"NotifyLoadConfig\",\"sampling\":10000}]},{\"module\":\"ACDS\",\"sampling\":1000},{\"module\":\"Page_hotpatch\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hotpatch\",\"sampling\":1000}]}]},\"ALARM\":{\"sampling\":0,\"successSampling\":0,\"failSampling\":0,\"metrics\":[{\"module\":\"Page_Home\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"HomeItemLoad\",\"sampling\":10000},{\"monitorPoint\":\"HomeNetwork\",\"sampling\":10000}]},{\"module\":\"Page_Detail\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"LoadDetail\",\"sampling\":10000},{\"monitorPoint\":\"LoadDesc\",\"sampling\":10000}]},{\"module\":\"Page_SearchItemList\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"SearchItem\",\"sampling\":10000}]},{\"module\":\"Page_Shop\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"loadShop\",\"sampling\":10000}]},{\"module\":\"Page_AutoLogin\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"autoLogin\",\"sampling\":10000}]},{\"module\":\"Page_Shop_Search_List\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"searchShopList\",\"sampling\":10000}]},{\"module\":\"Page_ShoppingCart\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"QueryData\",\"sampling\":10000},{\"monitorPoint\":\"ShowCart\",\"sampling\":10000},{\"monitorPoint\":\"UpdateCart\",\"sampling\":10000}]},{\"module\":\"Page_Pay\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"Alipay\",\"sampling\":10000}]},{\"module\":\"Page_ShowOrder\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"ShowOrder\",\"sampling\":10000},{\"monitorPoint\":\"CreateOrder\",\"sampling\":10000}]},{\"module\":\"Page_Attention\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"loadAttention\",\"sampling\":10000},{\"monitorPoint\":\"refreshAttention\",\"sampling\":10000}]},{\"module\":\"Page_SearchShopList\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"SearchShop\",\"sampling\":10000}]},{\"module\":\"WindVane\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"NativeError\",\"sampling\":5000},{\"monitorPoint\":\"AllPackageApps\",\"sampling\":5000},{\"monitorPoint\":\"Config\",\"sampling\":5000},{\"monitorPoint\":\"JavaScriptError\",\"sampling\":5000},{\"monitorPoint\":\"PackageApp\",\"sampling\":2000}]},{\"module\":\"WeApp+\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"domModule\",\"sampling\":10000},{\"monitorPoint\":\"enviroment\",\"sampling\":10000},{\"monitorPoint\":\"jsBridge\",\"sampling\":10000},{\"monitorPoint\":\"streamModule\",\"sampling\":10000}]},{\"module\":\"ACDS\",\"sampling\":1000,\"monitorPoints\":[{\"monitorPoint\":\"huichang\",\"sampling\":0}]},{\"module\":\"Page_HuiChangTab\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hcconfig\",\"sampling\":1000}]},{\"module\":\"Page_2015MainStage\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hcjs_cdn\",\"sampling\":1000},{\"monitorPoint\":\"hcjs_mtop\",\"sampling\":1000},{\"monitorPoint\":\"hcmaindegrade\",\"sampling\":10000}]},{\"module\":\"Page_2015SubStage\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hcjs_cdn\",\"sampling\":1000},{\"monitorPoint\":\"hcjs_mtop\",\"sampling\":1000},{\"monitorPoint\":\"hcsubdegrade\",\"sampling\":10000}]}]}}";
        }
        Logger.m3833a(str, f3298p, "net config");
        String g = m3718g("b01na");
        if (g != null) {
            try {
                JSONObject jSONObject = new JSONObject(g).getJSONObject(MessageKey.MSG_CONTENT);
                if (jSONObject != null) {
                    return jSONObject.getString("c_content");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: g */
    public static void m3719g() {
        try {
            String f = m3717f();
            SampleRules.m3572a().mo11651a(f);
            SystemConfig.m3728a(f);
            HostConfigMgr.m3724a().mo11765a(m3718g("b01n15"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: g */
    private static String m3718g(String str) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(UTDC.m3697c());
        StringBuilder sb = new StringBuilder();
        sb.append("ut_");
        sb.append(str);
        sb.append("_config");
        return defaultSharedPreferences.getString(sb.toString(), null);
    }

    /* renamed from: e */
    public static String m3715e(String str) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(UTDC.m3697c());
        StringBuilder sb = new StringBuilder();
        sb.append("ut_");
        sb.append(str);
        sb.append("_timestamp");
        return defaultSharedPreferences.getString(sb.toString(), "0");
    }

    /* renamed from: a */
    public static synchronized void m3706a(Context context) {
        synchronized (Config.class) {
            if (!f3299q) {
                f3299q = true;
                try {
                    m3719g();
                    SampleRules.m3572a().mo11649a(context);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                GcConfigChannelMgr.m3720a().mo11763b();
            }
        }
    }
}
