package com.alibaba.baichuan.trade.biz.auth;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.alibaba.baichuan.trade.biz.auth.p050a.C1144a;
import com.alibaba.baichuan.trade.common.C1223b;
import com.alibaba.baichuan.trade.common.Environment;
import com.alibaba.baichuan.trade.common.adapter.mtop.C1221d.C1222a;
import com.alibaba.baichuan.trade.common.adapter.mtop.NetworkResponse;
import com.alibaba.baichuan.trade.common.adapter.p060b.C1207b;
import com.alibaba.baichuan.trade.common.adapter.p060b.C1211c;
import com.alibaba.baichuan.trade.common.utils.C1224a;
import com.alibaba.baichuan.trade.common.utils.C1231e;
import com.alibaba.baichuan.trade.common.utils.http.HttpHelper;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.alibaba.baichuan.trade.biz.auth.a */
public class C1140a {
    /* renamed from: a */
    static Map<Integer, C1142a> f2350a = new ConcurrentHashMap();

    /* renamed from: com.alibaba.baichuan.trade.biz.auth.a$a */
    public static class C1142a {
        /* renamed from: a */
        public String f2355a;
        /* renamed from: b */
        public Set<String> f2356b;
        /* renamed from: c */
        public C1148c f2357c;
    }

    /* renamed from: com.alibaba.baichuan.trade.biz.auth.a$b */
    static class C1143b implements C1222a {
        /* renamed from: a */
        private C1148c f2358a;
        /* renamed from: b */
        private String f2359b;
        /* renamed from: c */
        private boolean f2360c;

        public C1143b(C1148c cVar, String str, boolean z) {
            this.f2358a = cVar;
            this.f2359b = str;
            this.f2360c = z;
        }

        /* renamed from: a */
        public void mo10658a(int i, NetworkResponse networkResponse) {
            Map<String, Object> map = networkResponse.data;
            if (map == null || !networkResponse.isSuccess) {
                C1148c cVar = this.f2358a;
                if (cVar != null) {
                    cVar.mo10651a(networkResponse.errorCode, networkResponse.errorMsg);
                }
                C1140a.m2223b(networkResponse.errorCode);
                return;
            }
            C1207b.m2357a().mo10867a(AliAuthError.MODEL_NAME_COMPONENT, AliAuthError.MONITOR_POINT_MTOP_AUTH, C1211c.m2373a());
            if (!this.f2360c || TextUtils.equals(this.f2359b, C1145b.m2230a().mo10662b())) {
                C1145b.m2230a().mo10661a(map.get("token").toString(), C1231e.m2430b(map.get("expires")).longValue());
                C1148c cVar2 = this.f2358a;
                if (cVar2 != null) {
                    cVar2.mo10650a();
                }
                return;
            }
            C1148c cVar3 = this.f2358a;
            if (cVar3 != null) {
                cVar3.mo10650a();
            }
        }

        /* renamed from: b */
        public void mo10659b(int i, NetworkResponse networkResponse) {
            C1148c cVar = this.f2358a;
            if (cVar != null) {
                cVar.mo10651a(networkResponse.errorCode, networkResponse.errorMsg);
            }
            C1140a.m2223b(networkResponse.errorCode);
        }
    }

    /* renamed from: a */
    static void m2221a(final String str, final C1148c cVar, final boolean z, final boolean z2) {
        new AsyncTask<String, String, String>() {
            /* access modifiers changed from: protected|varargs */
            /* renamed from: a */
            public String doInBackground(String... strArr) {
                String str;
                String str2 = "getHint : url  ";
                String str3 = "alibc";
                String str4 = "_";
                String str5 = "$";
                if (C1223b.m2398b() == Environment.TEST) {
                    str = String.format("http://100.69.205.47/authHint.htm?apiList=[\"%s\"]", new Object[]{str.replace(str5, str4)});
                } else if (C1223b.m2398b() == Environment.PRE) {
                    str = String.format("http://pre.nbsdk-baichuan.taobao.com/authHint.htm?apiList=[\"%s\"]", new Object[]{str.replace(str5, str4)});
                } else {
                    str = String.format("https://nbsdk-baichuan.alicdn.com/authHint.htm?apiList=[\"%s\"]", new Object[]{str.replace(str5, str4)});
                }
                String str6 = "";
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(str);
                    C1224a.m2406d(str3, sb.toString());
                    str6 = HttpHelper.m2437a(str, null);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append(str);
                    sb2.append(" ");
                    sb2.append(str6);
                    C1224a.m2406d(str3, sb2.toString());
                    return str6;
                } catch (Exception e) {
                    e.printStackTrace();
                    return str6;
                }
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void onPostExecute(String str) {
                String str2 = "hintId";
                try {
                    if (TextUtils.isEmpty(str)) {
                        cVar.mo10651a(AliAuthError.HINTLIST_NULL.code, AliAuthError.HINTLIST_NULL.msg);
                        return;
                    }
                    JSONObject parseObject = JSON.parseObject(str);
                    HashSet hashSet = null;
                    if (C1231e.m2428a(parseObject.get("success"))) {
                        Map c = C1231e.m2431c(parseObject.get("authHintMap"));
                        if (c != null && c.size() > 0) {
                            hashSet = new HashSet(c.size());
                            for (String str3 : c.keySet()) {
                                Map d = C1231e.m2432d(c.get(str3));
                                if (d != null) {
                                    C1149d.m2240a((String) d.get(str2), (String) d.get("hintName"));
                                    hashSet.add(d.get(str2));
                                }
                            }
                            C1149d.m2241a(str, (Set<String>) hashSet);
                        }
                    }
                    if (hashSet != null) {
                        if (hashSet.size() > 0) {
                            if (z2) {
                                C1140a.m2222a(hashSet, cVar, z);
                            } else {
                                cVar.mo10650a();
                            }
                            return;
                        }
                    }
                    cVar.mo10651a(AliAuthError.HINTLIST_NULL.code, AliAuthError.HINTLIST_NULL.msg);
                } catch (Exception e) {
                    cVar.mo10651a(AliAuthError.HINTLIST_NULL.code, AliAuthError.HINTLIST_NULL.msg);
                    e.printStackTrace();
                }
            }
        }.execute(new String[0]);
    }

    /* renamed from: a */
    static void m2222a(Set<String> set, C1148c cVar, boolean z) {
        String b = C1145b.m2230a().mo10662b();
        if (set != null || !TextUtils.isEmpty(b)) {
            new C1144a().mo10660a(set, b, new C1143b(cVar, b, z));
            return;
        }
        if (cVar != null) {
            cVar.mo10651a(AliAuthError.HINTLIST_NULL.code, AliAuthError.HINTLIST_NULL.msg);
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static void m2223b(String str) {
        String str2 = (String) AliAuthError.mMtopErrorCode.get(str);
        if (str2 == null) {
            str2 = "00";
        }
        C1207b a = C1207b.m2357a();
        String a2 = C1211c.m2373a();
        StringBuilder sb = new StringBuilder();
        sb.append(AliAuthError.ERRNO_COMPONENT_AUTH_FAIL);
        sb.append(str2);
        a.mo10868a(AliAuthError.MODEL_NAME_COMPONENT, AliAuthError.MONITOR_POINT_MTOP_AUTH, a2, sb.toString(), "授权失败");
    }
}
