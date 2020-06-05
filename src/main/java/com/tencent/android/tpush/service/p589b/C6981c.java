package com.tencent.android.tpush.service.p589b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.b.c */
public class C6981c {
    /* renamed from: a */
    private JSONObject f23192a = new JSONObject();
    /* renamed from: b */
    private List<String> f23193b = new ArrayList();

    /* renamed from: a */
    public static C6981c m29811a(String str) {
        String[] split;
        String str2 = ";";
        C6981c cVar = new C6981c();
        try {
            cVar.f23192a = new JSONObject(str);
            String optString = cVar.f23192a.optString("ips", null);
            if (optString != null && optString.trim().length() > 7) {
                if (optString.contains(str2)) {
                    for (String str3 : optString.split(str2)) {
                        if (C6979b.m29796b(str3)) {
                            cVar.f23193b.add(str3);
                        }
                    }
                } else if (C6979b.m29796b(optString)) {
                    cVar.f23193b.add(optString);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return cVar;
    }

    /* renamed from: a */
    public String mo33308a() {
        List<String> list = this.f23193b;
        if (list != null) {
            int size = list.size();
            if (size == 1) {
                return (String) this.f23193b.get(0);
            }
            if (size > 1) {
                Collections.shuffle(this.f23193b);
                return (String) this.f23193b.get(0);
            }
        }
        return null;
    }

    public String toString() {
        return this.f23192a.toString();
    }

    /* renamed from: b */
    public long mo33309b() {
        return this.f23192a.optLong("exp", System.currentTimeMillis());
    }
}
