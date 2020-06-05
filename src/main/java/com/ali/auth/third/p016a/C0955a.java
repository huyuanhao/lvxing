package com.ali.auth.third.p016a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import com.ali.auth.third.core.config.AuthOption;
import com.ali.auth.third.core.config.C0990a;
import com.ali.auth.third.core.model.C1025f;
import com.ali.auth.third.core.model.C1027h;
import com.ali.auth.third.core.model.C1029j;
import com.ali.auth.third.core.p024c.C0989a;
import com.ali.auth.third.core.p025d.C0993b;
import com.ali.auth.third.core.p030h.C1013c;
import com.ali.auth.third.core.p030h.C1014d;
import com.ali.auth.third.core.p030h.C1015e;
import com.ali.auth.third.core.p033j.C1018a;
import com.ali.auth.third.core.rpc.protocol.RpcException;
import com.ali.auth.third.core.util.C1034a;
import com.ali.auth.third.core.util.C1039d;
import com.ali.auth.third.core.util.C1041f;
import com.ali.auth.third.core.util.C1042g;
import com.ali.auth.third.p016a.p017a.C0957a;
import com.ali.auth.third.p034ui.LoginWebViewActivity;
import com.ali.auth.third.p034ui.QrLoginActivity;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import com.tencent.p605ep.commonbase.software.AppEntity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ali.auth.third.a.a */
public class C0955a {
    /* renamed from: a */
    public static final C0955a f1830a = new C0955a();

    private C0955a() {
    }

    /* renamed from: a */
    private String m1807a(TreeMap<String, String> treeMap) {
        StringBuilder sb = new StringBuilder();
        for (Entry entry : treeMap.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                sb.append(str);
                sb.append(str2);
            }
        }
        return sb.toString();
    }

    /* renamed from: c */
    private String m1808c(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        StringBuilder sb = new StringBuilder(str2);
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str3 = ((String) keys.next()).toString();
                if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(jSONObject.getString(str3))) {
                    sb.append("&");
                    sb.append(str3);
                    sb.append("=");
                    sb.append(jSONObject.getString(str3));
                }
            }
        } catch (JSONException unused) {
        }
        return sb.toString();
    }

    /* renamed from: a */
    public C1029j<C1025f> mo10259a(String str, long j, boolean z) {
        String str2;
        String a;
        try {
            C1027h hVar = new C1027h();
            hVar.f2048a = "mtop.taobao.havana.mlogin.qrcodelogin";
            hVar.f2049b = "1.0";
            try {
                JSONObject jSONObject = new JSONObject();
                if (C0989a.f1886a) {
                    str2 = ArgKey.KEY_APP_ID;
                    StringBuilder sb = new StringBuilder();
                    sb.append(C0989a.m1887c().getPackageName());
                    sb.append("|");
                    sb.append(C1042g.m2009b());
                    a = sb.toString();
                } else {
                    str2 = "utdid";
                    a = ((C1013c) C0989a.m1882a(C1013c.class)).mo10353a();
                }
                jSONObject.put(str2, a);
                jSONObject.put(AppEntity.KEY_APP_NAME_STR, C0989a.m1884a());
                jSONObject.put("token", str);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(j);
                jSONObject.put("t", sb2.toString());
                jSONObject.put("sdkVersion", C0989a.f1890e);
                jSONObject.put("clientIp", C1034a.m1983c());
                hVar.mo10372a("tokenInfo", jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("umidToken", ((C1014d) C0989a.m1882a(C1014d.class)).mo10292a());
                hVar.mo10372a("riskControlInfo", jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("supportNativeIvOnly", z);
                jSONObject3.put("sdkPlatform", "baichuan_mp");
                hVar.mo10372a("ext", jSONObject3);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return ((C1013c) C0989a.m1882a(C1013c.class)).mo10352a(hVar, C1025f.class);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public C1029j<C1025f> mo10260a(String str, String str2, String str3) {
        String str4;
        String a;
        String str5 = "ext";
        String str6 = "miid";
        C1027h hVar = new C1027h();
        hVar.f2048a = "com.taobao.mtop.mloginService.mloginTokenLogin";
        hVar.f2049b = "1.0";
        try {
            JSONObject jSONObject = new JSONObject();
            if (C0989a.f1886a) {
                str4 = ArgKey.KEY_APP_ID;
                StringBuilder sb = new StringBuilder();
                sb.append(C0989a.m1887c().getPackageName());
                sb.append("|");
                sb.append(C1042g.m2009b());
                a = sb.toString();
            } else {
                str4 = "utdid";
                a = ((C1013c) C0989a.m1882a(C1013c.class)).mo10353a();
            }
            jSONObject.put(str4, a);
            jSONObject.put(AppEntity.KEY_APP_NAME_STR, C0989a.m1884a());
            jSONObject.put("token", str);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(System.currentTimeMillis());
            jSONObject.put("t", sb2.toString());
            jSONObject.put("scene", str2);
            jSONObject.put("sdkVersion", C0989a.f1890e);
            jSONObject.put("clientIp", C1034a.m1983c());
            try {
                JSONObject c = C0993b.m1901c("alimm_");
                c.put(str6, C0993b.m1900b(str6));
                c.put("aliusersdk_h5querystring", str3);
                c.put("sdkPlatform", "baichuan_mp");
                jSONObject.put(str5, c);
            } catch (Exception e) {
                e.printStackTrace();
            }
            hVar.mo10372a("tokenInfo", jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("umidToken", ((C1014d) C0989a.m1882a(C1014d.class)).mo10292a());
            hVar.mo10372a("riskControlInfo", jSONObject2);
            hVar.mo10372a(str5, C1039d.m1996a((Map<String, ? extends Object>) new HashMap<String,Object>()));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return C0957a.f1836c.mo10352a(hVar, C1025f.class);
    }

    /* renamed from: a */
    public String mo10261a(String str) {
        ((C1015e) C0989a.m1882a(C1015e.class)).mo10356a("GENERATE_TOPAPPLINK_TOKEN", null);
        TreeMap treeMap = new TreeMap();
        treeMap.put("appKey", C0989a.m1884a());
        treeMap.put("apkSign", str);
        treeMap.put("apiName", "taobao.oauth.code.create");
        String a = m1807a(treeMap);
        C1027h hVar = new C1027h();
        hVar.f2048a = "com.alibaba.havana.login.applink.generateTopAppLinkToken";
        hVar.f2049b = "1.0";
        String a2 = C0989a.m1884a();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(AppEntity.KEY_APP_NAME_STR, a2);
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(System.currentTimeMillis());
            jSONObject.put("t", sb.toString());
            jSONObject.put("clientIp", C1034a.m1983c());
            if (C0989a.f1886a) {
                String str2 = ArgKey.KEY_APP_ID;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(C0989a.m1887c().getPackageName());
                sb2.append("|");
                sb2.append(C1042g.m2009b());
                jSONObject.put(str2, sb2.toString());
            }
            jSONObject.put("sdkVersion", C0989a.f1890e);
            hVar.mo10372a("baseInfo", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        hVar.mo10372a(MessageKey.MSG_CONTENT, a);
        try {
            C1029j a3 = ((C1013c) C0989a.m1882a(C1013c.class)).mo10352a(hVar, String.class);
            if (a3 != null) {
                return (String) a3.f2056c;
            }
            return null;
        } catch (RpcException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public void mo10262a(final Activity activity) {
        C1018a.m1964b("login", "showLogin");
        if (C0989a.f1896k == AuthOption.H5ONLY) {
            mo10265b(activity);
        } else if (C0989a.f1895j == AuthOption.H5ONLY) {
            mo10265b(activity);
        } else {
            final String a = C1042g.m2007a();
            new AsyncTask<Object, Void, String>() {
                /* access modifiers changed from: protected|varargs */
                /* renamed from: a */
                public String doInBackground(Object... objArr) {
                    C1018a.m1964b("login", "showLogin doInBackground");
                    String str = "";
                    if (TextUtils.isEmpty(a)) {
                        return str;
                    }
                    try {
                        return C0955a.this.mo10261a(a);
                    } catch (Exception unused) {
                        return str;
                    }
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void onPostExecute(String str) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("showLogin onPostExecute signResult = ");
                    sb.append(str);
                    String str2 = "login";
                    C1018a.m1964b(str2, sb.toString());
                    if (!TextUtils.isEmpty(str)) {
                        Intent intent = new Intent();
                        intent.setAction("com.taobao.open.intent.action.GETWAY");
                        StringBuilder sb2 = new StringBuilder("tbopen://m.taobao.com/getway/oauth?");
                        sb2.append("&appkey=");
                        sb2.append(C0989a.m1884a());
                        sb2.append("&pluginName=");
                        sb2.append("taobao.oauth.code.create");
                        sb2.append("&apkSign=");
                        sb2.append(a);
                        sb2.append("&sign=");
                        sb2.append(str);
                        intent.setData(Uri.parse(sb2.toString()));
                        if (activity.getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
                            try {
                                activity.startActivityForResult(intent, C0961c.f1837a);
                                return;
                            } catch (Throwable th) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("startActivityForResult fail == ");
                                sb3.append(th.getMessage());
                                C1018a.m1964b(str2, sb3.toString());
                            }
                        }
                    }
                    C0955a.this.mo10265b(activity);
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
        }
    }

    /* renamed from: a */
    public void mo10263a(Activity activity, Map<String, Object> map) {
        C1018a.m1964b("login", "goQrCodeLogin start");
        Class<QrLoginActivity> cls = QrLoginActivity.class;
        String str = "";
        if (map != null) {
            String str2 = "userDefActivity";
            if (!TextUtils.isEmpty(map.get(str2) == null ? str : (String) map.get(str2))) {
                try {
                    cls = Class.forName((String) map.get(str2));
                } catch (ClassNotFoundException unused) {
                }
            }
        }
        Intent intent = new Intent(activity, cls);
        StringBuilder sb = new StringBuilder(String.format(C0990a.f1912k, new Object[]{C0989a.m1884a()}));
        if (map != null) {
            String str3 = "domain";
            if (!TextUtils.isEmpty(map.get(str3) == null ? str : (String) map.get(str3))) {
                sb.append("_");
                sb.append(map.get(str3));
            }
        }
        if (map != null) {
            String str4 = "config";
            if (!TextUtils.isEmpty(map.get(str4) == null ? str : (String) map.get(str4))) {
                String c = m1808c((String) map.get(str4));
                if (TextUtils.isEmpty(c)) {
                    c = str;
                }
                sb.append(c);
            }
        }
        intent.putExtra("qrCodeLoginUrl", sb.toString());
        intent.putExtra("passwordLoginUrl", C0990a.f1904c);
        activity.startActivityForResult(intent, C0961c.f1841e);
    }

    /* renamed from: b */
    public C1029j<C1025f> mo10264b(String str) {
        String str2;
        String a;
        String str3 = "ext";
        String str4 = "";
        try {
            ((C1015e) C0989a.m1882a(C1015e.class)).mo10356a("SSO_TOKEN_LOGIN", null);
            C1027h hVar = new C1027h();
            hVar.f2048a = "com.taobao.mtop.mloginService.ssoLogin";
            hVar.f2049b = "1.0";
            try {
                JSONObject jSONObject = new JSONObject();
                if (C0989a.f1886a) {
                    str2 = ArgKey.KEY_APP_ID;
                    StringBuilder sb = new StringBuilder();
                    sb.append(C0989a.m1887c().getPackageName());
                    sb.append("|");
                    sb.append(C1042g.m2009b());
                    a = sb.toString();
                } else {
                    str2 = "utdid";
                    a = ((C1013c) C0989a.m1882a(C1013c.class)).mo10353a();
                }
                jSONObject.put(str2, a);
                jSONObject.put(AppEntity.KEY_APP_NAME_STR, C0989a.m1884a());
                jSONObject.put("token", str);
                jSONObject.put("sdkVersion", C0989a.f1890e);
                jSONObject.put("tokenType", "ssoToken");
                jSONObject.put("scene", str4);
                jSONObject.put("ttid", str4);
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("deviceName", Build.MODEL);
                    jSONObject2.put("sdkPlatform", "baichuan_mp");
                    jSONObject.put(str3, jSONObject2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                hVar.mo10372a("tokenInfo", jSONObject);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("umidToken", ((C1014d) C0989a.m1882a(C1014d.class)).mo10292a());
                hVar.mo10372a("riskControlInfo", jSONObject3);
                hVar.mo10372a(str3, new JSONObject());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return ((C1013c) C0989a.m1882a(C1013c.class)).mo10352a(hVar, C1025f.class);
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public void mo10265b(Activity activity) {
        C1018a.m1964b("login", "open H5 login");
        Intent intent = new Intent(activity, LoginWebViewActivity.class);
        intent.putExtra("url", C0990a.f1904c);
        intent.putExtra("title", C1041f.m2004a(activity.getApplicationContext(), "com_taobao_tae_sdk_authorize_title"));
        activity.startActivityForResult(intent, C0961c.f1838b);
    }
}
