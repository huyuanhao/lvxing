package com.ali.auth.third.core.p026e;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.ali.auth.third.core.config.C0990a;
import com.ali.auth.third.core.model.C1022c;
import com.ali.auth.third.core.p024c.C0989a;
import com.ali.auth.third.core.p030h.C1014d;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ali.auth.third.core.e.a */
public class C0998a {
    /* renamed from: a */
    private static volatile C0998a f1941a;

    private C0998a() {
    }

    /* renamed from: a */
    public static C0998a m1908a() {
        if (f1941a == null) {
            synchronized (C0998a.class) {
                if (f1941a == null) {
                    f1941a = new C0998a();
                }
            }
        }
        return f1941a;
    }

    /* renamed from: a */
    private String m1909a(List<C1022c> list) {
        String str = "";
        if (list == null || list.size() <= 0) {
            return str;
        }
        JSONArray jSONArray = new JSONArray();
        for (C1022c cVar : list) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("userId", cVar.f1990a);
                jSONObject.put("tokenKey", cVar.f1994e);
                jSONObject.put("nick", cVar.f1991b);
                jSONObject.put(NotificationCompat.CATEGORY_EMAIL, cVar.f1993d);
                jSONObject.put(ArgKey.KEY_MOBILE, cVar.f1992c);
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
                return str;
            }
        }
        return jSONArray.toString();
    }

    /* renamed from: a */
    private List<C1022c> m1910a(String str) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONArray jSONArray = new JSONArray(str);
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject != null) {
                C1022c cVar = new C1022c();
                cVar.f1990a = jSONObject.optString("userId");
                cVar.f1994e = jSONObject.optString("tokenKey");
                cVar.f1992c = jSONObject.optString(ArgKey.KEY_MOBILE);
                cVar.f1991b = jSONObject.optString("nick");
                cVar.f1993d = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public void mo10318a(C1022c cVar, String str) {
        String str2;
        if (!C0990a.m1889b().mo10312e() || ((C1014d) C0989a.m1882a(C1014d.class)).mo10300b(cVar.f1994e, str)) {
            List<C1022c> b = mo10319b();
            String str3 = "taesdk_history_acounts";
            if (b != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(cVar);
                for (C1022c cVar2 : b) {
                    if (arrayList.size() >= C0990a.m1889b().mo10311c()) {
                        break;
                    } else if (TextUtils.isEmpty(cVar2.f1990a) || !cVar2.f1990a.equals(cVar.f1990a)) {
                        arrayList.add(cVar2);
                    }
                }
                str2 = m1909a((List<C1022c>) arrayList);
            } else {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(cVar);
                str2 = m1909a((List<C1022c>) arrayList2);
            }
            ((C1014d) C0989a.m1882a(C1014d.class)).mo10295a(str3, str2);
        }
    }

    /* renamed from: b */
    public List<C1022c> mo10319b() {
        String str = "taesdk_history_acounts";
        String a = ((C1014d) C0989a.m1882a(C1014d.class)).mo10293a(str);
        if (TextUtils.isEmpty(a)) {
            return new ArrayList();
        }
        try {
            return m1910a(a);
        } catch (JSONException unused) {
            ArrayList arrayList = new ArrayList();
            ((C1014d) C0989a.m1882a(C1014d.class)).mo10298b(str);
            return arrayList;
        }
    }
}
