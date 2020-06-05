package com.tmsdk.module.coin;

import android.content.Context;
import android.text.TextUtils;
import btmsdkobf.C0562a;
import btmsdkobf.C0638c;
import btmsdkobf.C0649ci;
import btmsdkobf.C0650cj;
import btmsdkobf.C0747e;
import btmsdkobf.C0747e.C0748a;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TMSDKContext {
    public static final int ELANG_CHS = 1;
    public static final int ELANG_ENG = 2;
    public static final int ELANG_NONE = 0;
    public static final int S_ERR_FILE_OP = -201;
    public static final int S_ERR_FROM_SERVER = -101;
    public static final int S_ERR_TIMEOUT = -102;
    public static final int S_ERR_UNKNOWN = -999;
    public static final int S_EXIST_NEWER_DB = -208;
    public static final int S_NOTEXIST_NEWER_DB = -209;
    public static final int S_OK = 0;
    /* renamed from: bx */
    static AbsTMSConfig f25892bx;
    /* renamed from: by */
    private static JSONObject f25893by = new JSONObject();

    public static void c_c(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("c_c, arg:[");
        sb.append(i);
        sb.append("]");
        TmsLog.m32939d("TMSDKContext", sb.toString());
    }

    public static boolean checkLicence() {
        return C0638c.checkLicence();
    }

    public static Context getApplicationContext() {
        return C0638c.getApplicationContext();
    }

    public static int getCoinProductId() {
        try {
            return getsExtraJO().getInt("coin_productId");
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getGUID() {
        return C0638c.getGuid();
    }

    public static int getProductId() {
        return 13;
    }

    public static String getSDKVersionInfo() {
        return "2.0.0 20200225105645";
    }

    public static JSONObject getsExtraJO() {
        return f25893by;
    }

    /* access modifiers changed from: private|static */
    /* renamed from: i */
    public static boolean m32928i(Context context) {
        C0748a a = C0747e.m556a(40805, "40805.dat", 0, 0, null, 0);
        String str = "TMSDKContext";
        if (a != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("mFileName:");
            sb.append(a.f673e);
            TmsLog.m32939d(str, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("mUrl:");
            sb2.append(a.f672d);
            TmsLog.m32939d(str, sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("mStatusCode:");
            sb3.append(a.f671c);
            TmsLog.m32939d(str, sb3.toString());
            C0747e.m554a(a);
            m32929j(context);
        } else {
            TmsLog.m32939d(str, "没有更新");
        }
        return true;
    }

    public static synchronized boolean init(final Context context, AbsTMSConfig absTMSConfig) {
        synchronized (TMSDKContext.class) {
            String str = "TMSDKContext";
            StringBuilder sb = new StringBuilder();
            sb.append("init, aContext:[");
            sb.append(context);
            sb.append("]aConfig:[");
            sb.append(absTMSConfig);
            sb.append("]");
            TmsLog.m32939d(str, sb.toString());
            if (context == null) {
                TmsLog.m32945w("TMSDKContext", "aContext is null");
                return false;
            }
            if (absTMSConfig == null) {
                absTMSConfig = new AbsTMSConfig() {
                };
            }
            f25892bx = absTMSConfig;
            C0638c.m77a(context);
            if (!m32929j(context)) {
                return false;
            }
            String str2 = "TMSDKContext";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("传入的context包名：");
            sb2.append(context.getPackageName());
            TmsLog.m32945w(str2, sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("传入的ApplicationContext包名：");
            sb3.append(context.getApplicationContext().getPackageName());
            TmsLog.m32945w("TMSDKContext", sb3.toString());
            boolean a = C0638c.m78a(context, (C0562a) new C0562a() {
                /* renamed from: a */
                public String mo9077a() {
                    return "5253DC305AE12C0B";
                }

                /* renamed from: b */
                public int mo9078b() {
                    return 6020;
                }

                /* renamed from: c */
                public String mo9079c() {
                    return ReleaseSetting.CHANNEL_NO;
                }

                /* renamed from: d */
                public String mo9080d() {
                    String serverAddress = TMSDKContext.f25892bx.getServerAddress();
                    return TextUtils.isEmpty(serverAddress) ? "mazu.3g.qq.com" : serverAddress;
                }

                /* renamed from: e */
                public String mo9081e() {
                    return "Tcc-1.0.1";
                }

                /* renamed from: f */
                public String mo9082f() {
                    return "";
                }

                public String getDeviceId1() {
                    return TMSDKContext.f25892bx.getDeviceId1();
                }

                public String getDeviceId2() {
                    return TMSDKContext.f25892bx.getDeviceId2();
                }

                public String getDeviceId3() {
                    return TMSDKContext.f25892bx.getDeviceId3();
                }

                public int getProductId() {
                    return 13;
                }

                public String getVersion() {
                    return "2.0.0";
                }

                public boolean isAllowAndroidID() {
                    return ReleaseSetting.isAllowAndroidID();
                }

                public boolean isAllowImei() {
                    if (TextUtils.isEmpty(getDeviceId1())) {
                        return true;
                    }
                    return ReleaseSetting.isAllowImei();
                }

                public boolean isAllowImsi() {
                    return ReleaseSetting.isAllowImsi();
                }

                public boolean isAllowMac() {
                    return ReleaseSetting.isAllowMac();
                }

                public boolean isAllowOther() {
                    return ReleaseSetting.isAllowOther();
                }

                public boolean isCheckLicence() {
                    return ReleaseSetting.isCheckLicence();
                }

                public boolean isJavaTCC() {
                    return ReleaseSetting.isJavaTCC();
                }

                public boolean isUseIPList() {
                    return TMSDKContext.f25892bx.isUseIPList();
                }
            });
            ServiceManager.initService(getApplicationContext());
            C0638c.addUrgentTask(new Runnable() {
                public void run() {
                    TMSDKContext.m32928i(context);
                }
            }, "checkConfig");
            new AdManagerImpl();
            return a;
        }
    }

    public static boolean isInitialized() {
        return C0638c.isInitialized();
    }

    /* renamed from: j */
    private static boolean m32929j(Context context) {
        String str;
        String str2 = "adconfig";
        C0650cj a = C0747e.m555a(C0747e.m557a("40805.dat", true), "UTF-8");
        String str3 = "TMSDKContext";
        if (a == null || a.f406fP == null || a.f406fP.size() <= 0) {
            TmsLog.m32945w(str3, "读不出配置文件");
            return false;
        } else if (a.f406fP.size() < 1) {
            TmsLog.m32940e(str3, "配置文件不正确");
            return false;
        } else {
            Iterator it = a.f406fP.iterator();
            if (it.hasNext()) {
                C0649ci ciVar = (C0649ci) it.next();
                StringBuilder sb = new StringBuilder();
                sb.append("data1:");
                sb.append(ciVar.f396fH);
                TmsLog.m32939d(str3, sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("data2:");
                sb2.append(ciVar.f397fI);
                TmsLog.m32939d(str3, sb2.toString());
                str = ciVar.f396fH;
                ReleaseSetting.CHANNEL_NO = ciVar.f397fI;
                if (!TextUtils.isEmpty(ciVar.f398fJ)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("data3:");
                    sb3.append(ciVar.f398fJ);
                    TmsLog.m32939d(str3, sb3.toString());
                    try {
                        f25893by = new JSONObject(ciVar.f398fJ);
                        if (!TextUtils.isEmpty(ciVar.f399fK)) {
                            JSONArray jSONArray = new JSONObject(ciVar.f399fK).getJSONArray(str2);
                            if (jSONArray != null && jSONArray.length() > 0) {
                                for (int i = 0; i < jSONArray.length(); i++) {
                                    f25893by.getJSONArray(str2).put(jSONArray.get(i));
                                }
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str) || context.getApplicationContext().getPackageName().equals(str)) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("包名校验");
                sb4.append(str);
                sb4.append(":::");
                sb4.append(context.getApplicationContext().getPackageName());
                TmsLog.m32945w(str3, sb4.toString());
                return true;
            }
            TmsLog.m32945w(str3, "ApplicationContext包名校验失败");
            return false;
        }
    }

    public static void setAutoConnectionSwitch(Context context, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("setAutoConnectionSwitch, aContext[");
        sb.append(context);
        sb.append("]aAutoConnection:[");
        sb.append(z);
        sb.append("]");
        TmsLog.m32939d("TMSDKContext", sb.toString());
        C0638c.setAutoConnectionSwitch(context, z);
    }

    public static void setCurrentLang(int i) {
        C0638c.setCurrentLang(i);
    }

    public static void setTMSDKLogEnable(boolean z) {
        TmsLog.setLogEnable(z);
        C0638c.setLogEnable(z);
    }
}
