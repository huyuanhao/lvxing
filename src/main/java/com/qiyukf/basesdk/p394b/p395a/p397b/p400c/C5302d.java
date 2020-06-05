package com.qiyukf.basesdk.p394b.p395a.p397b.p400c;

import android.text.TextUtils;
import com.qiyukf.basesdk.p412c.C5366b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.qiyukf.basesdk.b.a.b.c.d */
public final class C5302d {
    /* renamed from: a */
    private String f17172a;
    /* renamed from: b */
    private String f17173b;
    /* renamed from: c */
    private String f17174c;
    /* renamed from: d */
    private int f17175d;

    /* renamed from: a */
    private static C5302d m21773a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        C5302d dVar = new C5302d();
        dVar.f17174c = C5366b.m22039e(jSONObject, "bucket");
        dVar.f17173b = C5366b.m22039e(jSONObject, "token");
        dVar.f17172a = C5366b.m22039e(jSONObject, "obj");
        dVar.f17175d = C5366b.m22034b(jSONObject, "expire");
        return dVar;
    }

    /* renamed from: a */
    public static String m21774a(C5302d dVar) {
        return m21776b(dVar).toString();
    }

    /* renamed from: a */
    public static String m21775a(List<C5302d> list) {
        JSONArray jSONArray = new JSONArray();
        for (C5302d b : list) {
            JSONObject b2 = m21776b(b);
            if (b2 != null) {
                jSONArray.put(b2);
            }
        }
        return jSONArray.toString();
    }

    /* renamed from: b */
    private static JSONObject m21776b(C5302d dVar) {
        if (dVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        C5366b.m22032a(jSONObject, "bucket", dVar.f17174c);
        C5366b.m22032a(jSONObject, "token", dVar.f17173b);
        C5366b.m22032a(jSONObject, "obj", dVar.f17172a);
        C5366b.m22029a(jSONObject, "expire", dVar.f17175d);
        return jSONObject;
    }

    /* renamed from: d */
    public static List<C5302d> m21777d(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray b = C5366b.m22035b(str);
                for (int i = 0; i < b.length(); i++) {
                    C5302d a = m21773a(b.getJSONObject(i));
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public static C5302d m21778e(String str) {
        return m21773a(C5366b.m22027a(str));
    }

    /* renamed from: a */
    public final String mo27177a() {
        return this.f17173b;
    }

    /* renamed from: a */
    public final void mo27178a(int i) {
        this.f17175d = i;
    }

    /* renamed from: a */
    public final void mo27179a(String str) {
        this.f17173b = str;
    }

    /* renamed from: b */
    public final String mo27180b() {
        return this.f17174c;
    }

    /* renamed from: b */
    public final void mo27181b(String str) {
        this.f17174c = str;
    }

    /* renamed from: c */
    public final String mo27182c() {
        return this.f17172a;
    }

    /* renamed from: c */
    public final void mo27183c(String str) {
        this.f17172a = str;
    }
}
